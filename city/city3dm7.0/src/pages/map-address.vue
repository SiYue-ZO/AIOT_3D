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
          <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
          </el-button>
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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="addId"
                  :default-sort="{prop: 'addType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="地名地址" prop="addName" sortable></el-table-column>
          <el-table-column label="类型" prop="addType" sortable></el-table-column>
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
          <el-form-item label="所属网格" prop="pid">
            <ztree :nodes="nodes" :setting="setting" @onCreated="handleCreated"/>
          </el-form-item>
          <el-form-item label="地名地址" prop="addName">
            <el-input v-model="formData.addName" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="单位名称" prop="subsidiaryAdd">
            <el-input v-model="formData.subsidiaryAdd" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="remark">
            <el-input type="textarea" v-model="formData.remark" style="width: 90%"></el-input>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="采集时间" prop="addDate">
              <el-date-picker v-model="formData.addDate" align="left" type="date"
                              placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="分类" prop="addType" style="margin-left: -15px">
              <el-select v-model="formData.addType" placeholder="请选择分类" style="width: 93%">
                <el-option label="行政" value="行政"></el-option>
                <el-option label="地点" value="地点"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <el-form-item label="重心坐标" prop="poi">
            <el-input v-model="formData.poi" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai icon_position" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="drawFloorCenter"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="相机坐标" prop="camPoi">
            <el-input v-model="formData.camPoi" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai icon_position" :icon="['fas', 'edit']" fixed-width
                               @click="getCamView"></font-awesome-icon>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="相机朝向" prop="camHeading">
              <el-input v-model="formData.camHeading" style="width: 100%"></el-input>
            </el-form-item>
            <el-form-item label="相机俯角" prop="camPitch" style="margin-left:15px;">
              <el-input v-model="formData.camPitch" style="width: 100%"></el-input>
            </el-form-item>
          </div>
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
  deleteAddress,
  getAddressByType,
  insertAddress,
  updateAddress,
  queryNetData,
  batchDeleteAddress,
  getNetInfoById, getAllandNetById
} from "../api/api";
import "../js/CesiumFloor.js";

let addMark;
export default {
  name: "map-address",
  components: {CesiumMap, ztree},
  data() {
    return {
      setting: {},
      nodes: [],
      currentPage: 1, //初始页
      pagesize: 10, //每页的数据
      devFilter: "", //搜索字段
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      isTableShow: true,
      isEdit: false,
      currentId: "",
      currentRow: {},
      ztreeObj: null,
      rules: {
        addName: [{required: true, message: '请输入', trigger: 'blur'}],
        poi: [{required: true, message: '请输入', trigger: 'blur'}],
        addType: [{required: true, message: '请输入', trigger: 'blur'}],
        addDate: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        addId: "",
        addName: "",
        poi: "",
        camPoi: "",
        camHeading: "",
        camPitch: "",
        addType: "地点",
        addDate: (new Date()).pattern("yyyy-MM-dd"),
        pid: "0",
        subsidiaryAdd: '',
        remark: '',
        street: "",
        communities: "",
        communityName: "",
        buildingNum: "",
        unitNum: ""
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
    };
  },
  methods: {
    getAddressData(res) {
      this.queryResult = res.data;
      this.tableDate = res.data;
      this.pictLoading = false;
    },
    createZTree(data) {
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
          id: 0,
          pid: "",
          name: "网格目录树",
          isNode: false,
          showIcon: false,
          nocheck: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].netId;
        treeObj.pid = data[i].netPid;
        treeObj.name = data[i].netName;
        treeObj.highlight = false;
        treeObj.isNode = true;
        treeObj.nocheck = data[i].netLevel !== "4";
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function TreeChecked(event, treeId, treeNode) {
        _this.formData.pid = treeNode.id;
        let params = {
          netId: treeNode.id
        };
        getNetInfoById(params).then((res) => {
          _this.formData.unitNum = res.data.netName;
          if (res.data.length !== 0) {
            let params = {
              netId: res.data.netPid
            };
            getNetInfoById(params).then((res) => {
              _this.formData.buildingNum = res.data.netName;
              if (res.data.length !== 0) {
                let params = {
                  netId: res.data.netPid
                };
                getNetInfoById(params).then((res) => {
                  _this.formData.communityName = res.data.netName;
                  if (res.data.length !== 0) {
                    let params = {
                      netId: res.data.netPid
                    };
                    getNetInfoById(params).then((res) => {
                      _this.formData.communities = res.data.netName;
                      if (res.data.length !== 0) {
                        let params = {
                          netId: res.data.netPid
                        };
                        getNetInfoById(params).then((res) => {
                          _this.formData.street = res.data.netName;
                        });
                      }
                    });
                  }
                });
              }
            });
          }
        });
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    init() {
      this.pictLoading = true;
      getAddressByType().then((res) => {
        this.getAddressData(res);
      });
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        queryNetData().then((res) => {
          this.createZTree(res.data);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandNetById(params).then(res => {
          let netArr = [];
          res.data.sysRoleNet.map(item => {
            netArr.push(item.net);
          });
          this.createZTree(netArr);
        });
      }
    },
    rowClick(row, column, event) {
      this.currentId = row.addId;
      this.currentRow = row;
      if (row.camHeading !== null && row.camHeading !== "") {
        let camPoiArr = row.camPoi.split(',');
        CesiumMap.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), row.camHeading, row.camPitch);
      } else {
        let poiArr = row.poi.split(',');
        CesiumMap.methods.flyToLocation([Number(poiArr[0]), Number(poiArr[1]), Number(poiArr[2]) + 500]);
      }
      this.addAddressToMap(row);
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
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
    },
    editData() {
      if (this.currentId !== "") {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.ztreeObj.checkNode(this.ztreeObj.getNodeByParam("id", this.currentRow.pid), true);
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    deleteData() {
      if (this.currentId !== "") {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          let params = {
            addId: this.currentId,
          };
          deleteAddress(params).then((res) => {
            if (res.data === 1) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.init();
            } else {
              this.$message({
                message: '删除失败，请重试！',
                type: 'error'
              });
            }
          });
        }).catch((action) => {
          this.$message({
            message: '放弃删除！',
            type: 'warning'
          });
        });
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    batchDeleteData() {
      if (this.multipleSelection !== []) {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          batchDeleteAddress(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.init();
            } else {
              this.$message({
                message: '删除失败，请重试！',
                type: 'error'
              });
            }
          });
        }).catch((action) => {
          this.$message({
            message: '放弃删除！',
            type: 'warning'
          });
        });
      } else {
        this.$message({
          message: '至少选择一条需要删除的数据！',
          type: 'warning'
        });
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let params = this.formData;
          params.addDate = new Date(params.addDate).toLocaleDateString().replace(/\//g, '-');
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateAddress(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.init();
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
                message: '取消操作！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              insertAddress(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.init();
                } else if (res.data === 2) {
                  this.$message({
                    type: 'error',
                    message: '地名地址重复！'
                  });
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
                message: '取消操作！'
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
      this.formData.addType = "行政";
      this.formData.addDate = (new Date()).pattern("yyyy-MM-dd");
    },
    backTable() {
      this.isTableShow = true;
      this.clearFloorCenter();
      this.removeFloor();
    },
    //回显分层分户单体化结构和重心点
    addAddressToMap(data) {
      viewer.entities.removeById("addAddressToMap");
      if (data.poi !== null && data.poi !== '') {
        let position = data.poi.split(',');
        let labelColor = data.addType === "行政" ? Cesium.Color.ORANGERED : Cesium.Color.MAROON;
        let addicon = data.addType === "行政" ? "static/images/redstar.png" : "static/images/building.png";
        viewer.entities.add({
          id: "addAddressToMap",
          position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
          label: {
            text: data.addName,
            font: 'Bold 64px Helvetica',
            scale: 0.25,
            fillColor: labelColor,
            style: Cesium.LabelStyle.FILL_AND_OUTLINE,
            outlineColor: Cesium.Color.WHITE,
            outlineWidth: 4,
            pixelOffset: new Cesium.Cartesian2(0, -20)
          },
          billboard: {
            image: addicon,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            width: 24,
            height: 24,
            pixelOffset: new Cesium.Cartesian2(-48.0, -6.0),
          }
        });
      }
    },
    // 清除地图中所有实体
    removeFloor() {
      viewer.entities.removeAll();
    },
    //绘制分层分户中心点
    drawFloorCenter() {
      let _this = this;
      _this.clearFloorCenter();
      let addMarkHandler = addMarkHandler && addMarkHandler.destroy();
      addMarkHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      addMarkHandler.setInputAction(function (movement) {
        let lng, lat, height;
        let cartesian = viewer.scene.pickPosition(movement.position);//获取鼠标点击处的坐标
        if (Cesium.defined(cartesian)) {
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let testheight = cartographic.height;
          if (Number(testheight) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            cartesian = viewer.scene.globe.pick(ray, viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          lng = Cesium.Math.toDegrees(cartographic.longitude);
          lat = Cesium.Math.toDegrees(cartographic.latitude);
          height = cartographic.height;//模型高度
          let poiStr = lng + ',' + lat + ',' + height;
          _this.formData.poi = poiStr;

          //创建标注
          let pinBuilder = new Cesium.PinBuilder();
          addMark = viewer.entities.add({
            position: cartesian,
            billboard: {
              image: pinBuilder.fromText('新', Cesium.Color.BLUE, 36).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.BLUE.withAlpha(0.7)
            }
          });
        }
        addMarkHandler = addMarkHandler && addMarkHandler.destroy();
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
    },
    clearFloorCenter() {
      viewer.entities.remove(addMark);
    },
    getCamView() {
      let _this = this;
      let camPoiR = viewer.camera.position;
      let camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
      let camHeading = viewer.camera.heading;
      let camPitch = viewer.camera.pitch;
      _this.formData.camPoi = camPoi;
      _this.formData.camHeading = camHeading;
      _this.formData.camPitch = camPitch;
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.addName.indexOf(val)
          || ~item.addType.indexOf(val))
      );
    }
  },
  mounted() {
    this.init();
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
  },
};
</script>

<style scoped>
.card-header {
  display: flex;
}

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
  overflow-x: hidden;
  font-size: 15px !important;
}

.row_display {
  display: flex;
}

.icon_position {
  position: absolute;
  top: 10px;
  right: 10px;
}

.row_display /deep/ .el-radio {
  line-height: 39px !important;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
