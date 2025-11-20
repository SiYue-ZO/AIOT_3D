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
                  :default-sort="{prop: 'thingModelName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="名称" prop="thingModelName" sortable></el-table-column>
          <el-table-column label="模型链接" prop="thingModelUrl" sortable></el-table-column>
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
          <el-form-item label="部件类型" prop="thingType">
            <ztree :nodes="nodes" :setting="setting" @onCreated="handleCreated"/>
          </el-form-item>
          <el-form-item label="部件名称" prop="thingModelName">
            <el-input v-model="formData.thingModelName" placeholder="请填写部件类别名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="模型上传" prop="modelUpload" style="width: 400px">
            <el-upload
              ref="uploadModel"
              action=""
              :limit="1"
              :file-list="fileList"
              accept=".gltf, .glb"
              :on-exceed="handleExceed"
              :on-change="onChangeUpload"
              :on-remove="handleRemove"
              :auto-upload="false"
              :show-file-list="true"
              :disabled="isUploading"
            >
              <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary" class="button-upload">
                选取模型文件
              </el-button>
            </el-upload>
          </el-form-item>
          <el-form-item label="模型链接" prop="thingModelUrl">
            <el-input v-model="formData.thingModelUrl" placeholder="请填写" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map']" fixed-width title="预览"
                               @click="addModelToMap"></font-awesome-icon>
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
  deleteCityThingModel,
  getCityThingModel,
  insertCityThingModel,
  updateCityThingModel,
} from "../api/api";

export default {
  name: "city-thing-model",
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
        thingModelName: [{required: true, message: '请输入', trigger: 'blur'}],
        thingModelPid: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        thingModelId: '',
        thingModelPid: '',
        thingModelName: '',
        thingModelUrl: '',
      },
      setting: {},
      ztreeObj: null,
      nodes: [],
      fileList: [],
      isUploading: false,
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
          name: "部件分类目录树",
          isNode: false,
          showIcon: false,
          nocheck: false,
          checked: "0" === curId,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].thingModelId;
        treeObj.pid = data[i].thingModelPid;
        treeObj.name = data[i].thingModelName;
        treeObj.checked = data[i].thingModelId === curId;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function TreeChecked(event, treeId, treeNode) {
        _this.formData.thingModelPid = treeNode.id;
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    getCityThingModelData() {
      this.pictLoading = true;
      getCityThingModel().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.thingModelId;
      this.currentRow = row;
      this.addModelToMap(row);
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
      viewer.entities.removeAll();
      getCityThingModel().then(res => {
        this.createZTree(res.data, "0");
      });
    },
    editData() {
      if (this.currentId !== '') {
        getCityThingModel().then(res => {
          this.createZTree(res.data, this.currentRow.thingModelPid);
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
            thingModelId: this.currentId
          };
          deleteCityThingModel(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getCityThingModelData();
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
          let formData = new FormData();
          this.fileList.map(item => {
            formData.append('files', item.raw);
          });
          formData.append('thingModelId', this.formData.thingModelId);
          formData.append('thingModelPid', this.formData.thingModelPid);
          formData.append('thingModelName', this.formData.thingModelName);
          formData.append('thingModelUrl', this.formData.thingModelUrl);
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateCityThingModel(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getCityThingModelData();
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
              insertCityThingModel(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getCityThingModelData();
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
                message: '请完善信息！'
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
      viewer.entities.removeAll();
      this.fileList = [];
      this.$refs.uploadModel.clearFiles();
    },
    backTable() {
      this.isTableShow = true;
      viewer.entities.removeAll();
      this.fileList = [];
      this.$refs.uploadModel.clearFiles();
    },
    addModelToMap(data) {
      viewer.entities.removeAll();
      if (data.thingModelUrl) {
        let position = [126.60365532985155, 45.7214413006515, 186];
        let pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        let hpr = new Cesium.HeadingPitchRoll(0, 0, 0);
        let orientation = Cesium.Transforms.headingPitchRollQuaternion(pos, hpr);
        let pinBuilder = new Cesium.PinBuilder();
        viewer.entities.add({
          id: 'drawPointEntity',
          position: pos,
          orientation: orientation,
          billboard: {
            image: pinBuilder.fromText('新', Cesium.Color.GREEN, 42).toDataURL(),
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            pixelOffset: new Cesium.Cartesian2(0, -50),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(50, 1, 2000, 0.2),
            distanceDisplayCondition: new Cesium.DistanceDisplayCondition(200, 100000000)
          },
          model: {
            uri: common.serverIp + "city3dfile/" + data.thingModelUrl,// 模型路径
            scale: 1,
            // minimumPixelSize: 32,// 模型最小刻度
            // maximumSize: 128,
            // maximumScale: 200,// 设置模型最大放大大小
            silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
            silhouetteSize: 1.0,
            imageBasedLightingFactor: new Cesium.Cartesian2(1.5, 1),
          }
        });
        position[2] = Number(position[2]) + 200;
        CesiumMap.methods.flyToLocation(position);
      } else {
        this.$message({
          type: 'warning',
          message: '您选择的类型没有对应模型!'
        });
      }
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    onChangeUpload(file, fileList) {
      this.isUploading = true;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'gltf' && fileName !== 'glb' && fileName !== 'GLTF' && fileName !== 'GLB') {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是gltf或glb文件!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      this.fileList = fileList;
      this.isUploading = false;
    },
    handleRemove(files, fileList) {
      this.fileList = [];
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.thingModelName.indexOf(val)
          || ~item.thingModelUrl.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getCityThingModelData();
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

.button-upload {
  font-size: 14px;
}
</style>
