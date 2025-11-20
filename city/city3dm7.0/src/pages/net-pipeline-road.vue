<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                    class="search-input"></el-input>
          <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                     @click="addData('formData')">
            添 加
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        </div>
        <div v-show="!isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  row-key="thingModelId"
                  :default-sort="{prop: 'roadName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="名称" prop="roadName" sortable></el-table-column>
        </el-table>
        <el-pagination
          class="my-pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 40]"
          :page-size="pagesize"
          :pager-count="5"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableDate.length">
        </el-pagination>
      </div>
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
          <el-form-item label="权属" prop="roadPid">
            <ztree :nodes="nodes" :setting="setting" @onCreated="handleCreated"/>
          </el-form-item>
          <el-form-item label="名称" prop="roadName">
            <el-input v-model="formData.roadName" placeholder="请填写名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="相机坐标" prop="camPoi">
            <el-input v-model="formData.camPoi" placeholder="请生成相机坐标" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width title="获取视角"
                               @click="getCam"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="朝向" prop="camHeading">
            <el-input v-model="formData.camHeading" placeholder="请生成相机朝向" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="俯角" prop="camPitch">
            <el-input v-model="formData.camPitch" placeholder="请生成相机俯角" style="width: 90%"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
import CesiumMap from "../utils/components/cesium-map";
import ztree from "vue-giant-tree";
import {
  deletePipelineRoad,
  getPipelineRoad,
  insertPipelineRoad,
  updatePipelineRoad,
} from "../api/api";

export default {
  name: "net-pipeline-road",
  components: {CesiumMap, ztree},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      devFilter: '',
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      rules: {
        roadName: [{required: true, message: '请输入', trigger: 'blur'}],
        roadPid: [{required: true, message: '请输入', trigger: 'blur'}],
        camPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        camHeading: [{required: true, message: '请输入', trigger: 'blur'}],
        camPitch: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        roadId: '',
        roadName: '',
        roadPid: '',
        camPoi: '',
        camHeading: '',
        camPitch: '',
      },
      setting: {},
      ztreeObj: null,
      nodes: [],
    }
  },
  methods: {
    createZTree(data, curId) {
      let _this = this;
      this.setting = {
        check: {
          enable: true,
          chkStyle: "radio",
          radioType: "all",
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0",
          },
        },
        callback: {
          onCheck: TreeChecked,
        },
        view: {
          showIcon: false,
          selectedMulti: false, //可以多选
        },
      };

      let treeNodes = [
        {
          id: "0",
          pid: "",
          name: "管线路名目录树",
          isNode: false,
          showIcon: false,
          nocheck: false,
          checked: "0" === curId,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].roadId;
        treeObj.pid = data[i].roadPid;
        treeObj.name = data[i].roadName;
        treeObj.checked = data[i].roadId === curId;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function TreeChecked(event, treeId, treeNode) {
        _this.formData.roadPid = treeNode.id;
      }

      _this.formData.roadPid = "0";
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    getPipelineRoadData() {
      this.pictLoading = true;
      getPipelineRoad().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.roadId;
      this.currentRow = row;
      this.setview(row.camPoi, row.camHeading, row.camPitch);
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    addData(formName) {
      this.isTableShow = false;
      this.isEdit = false;
      this.$refs[formName].resetFields();
      getPipelineRoad().then(res => {
        this.createZTree(res.data, "0");
      });
    },
    editData() {
      if (this.currentId !== '') {
        getPipelineRoad().then(res => {
          this.createZTree(res.data, this.currentRow.roadPid);
        });
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    deleteData() {
      if (this.currentId !== '') {
        this.$confirm('删除后无法恢复，请确认是否删除？', '删除数据', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '取消'
        }).then(() => {
          let params = {
            roadId: this.currentId
          };
          deletePipelineRoad(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getPipelineRoadData();
            } else {
              this.$message({
                type: 'error',
                message: '删除失败，请重试！'
              });
            }
          });
        }).catch(action => {
          this.$message({
            type: 'warning',
            message: '放弃删除！'
          });
        });
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let params = this.formData;
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updatePipelineRoad(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getPipelineRoadData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '修改失败，请重试！'
                  });
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '请完善信息！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              insertPipelineRoad(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getPipelineRoadData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '新增失败，请重试！'
                  });
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '新增失败，请重试！'
              });
            });
          }
        } else {
          this.$message({
            message: '请完善信息！',
            type: 'error'
          });
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    backTable() {
      this.isTableShow = true;
    },
    getCam() {
      let camPoiR = viewer.camera.position;
      let camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
      let camHeading = viewer.camera.heading;
      let camPitch = viewer.camera.pitch;
      this.formData.camPoi = camPoi;
      this.formData.camHeading = camHeading;
      this.formData.camPitch = camPitch;
    },
    setview(camPoi, camHeading, camPitch) {
      let camPoiArr = camPoi.split(',');
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromElements(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2])),
        orientation: {
          heading: Number(camHeading),
          pitch: Number(camPitch),
          roll: 0.0
        }
      });
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.roadName.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getPipelineRoadData();
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.4) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 230) * 0.6) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
    },
  }
}
</script>

<style scoped>
.left-card {
  float: left;
}

.right-card {
  float: right;
}

.form-fai {
  font-size: 19px !important;
  cursor: pointer;
  margin: 0 0 0 8px;
  color: #007acc;
}

.result-table {
  width: 100%;
  font-size: 15px !important;
}

.my-card-body {
  overflow-y: auto;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
