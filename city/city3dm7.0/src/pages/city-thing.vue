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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="thingId"
                  :default-sort="{prop: 'thingClass', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="部件名称" prop="thingName" sortable></el-table-column>
          <el-table-column label="大类" prop="thingClass" sortable></el-table-column>
          <el-table-column label="小类" prop="thingType" sortable></el-table-column>
          <el-table-column label="所属网格" prop="thingNet" sortable></el-table-column>
          <el-table-column label="权属单位" prop="thingDep" sortable></el-table-column>
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
          <el-form-item label="部件名称" prop="thingName">
            <el-input v-model="formData.thingName" placeholder="请填写部件名称" style="width: 90%"></el-input>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="所属网格" prop="thingNet">
              <el-input v-model="formData.thingNet" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="权属单位" prop="thingDep" style="margin-left:15px">
              <el-input v-model="formData.thingDep" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="设备位置" prop="thingPos">
            <el-input v-model="formData.thingPos" placeholder="请生成位置坐标" style="width: 90%" type="textarea"
                      :rows="3"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addModelToMapHandler"></font-awesome-icon>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="旋转角度" prop="thingHeading">
              <el-input v-model="formData.thingHeading" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="缩放比例" prop="thingScale" style="margin-left:15px">
              <el-input v-model="formData.thingScale" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="调整姿态">
            <font-awesome-icon class="form-fai-update" :icon="['fas', 'redo']" fixed-width
                               @click="updateModel(0)" title="刷新"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-left']" fixed-width
                               @click="updateModel(1)" title="左转"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-right']" fixed-width
                               @click="updateModel(2)" title="右转"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-up']" fixed-width
                               @click="updateModel(3)" title="上移"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-down']" fixed-width
                               @click="updateModel(4)" title="下移"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['fas', 'search-plus']" fixed-width
                               @click="updateModel(5)" title="放大"></font-awesome-icon>
            <font-awesome-icon class="form-fai-update" :icon="['fas', 'search-minus']" fixed-width
                               @click="updateModel(6)" title="缩小"></font-awesome-icon>
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
  deleteCityThing,
  getCityThing,
  insertCityThing,
  updateCityThing,
  batchDeleteCityThing,
  getCityThingModel
} from "../api/api";

let drawHandler;
export default {
  name: "city-thing",
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
      multipleSelection: [],
      rules: {
        thingName: [{required: true, message: '请输入', trigger: 'blur'}],
        thingPos: [{required: true, message: '请输入', trigger: 'blur'}],
        thingNet: [{required: true, message: '请输入', trigger: 'blur'}],
        thingDep: [{required: true, message: '请输入', trigger: 'blur'}],
        thingPid: [{required: true, message: '请输入', trigger: 'blur'}],
        thingHeading: [{required: true, message: '请输入', trigger: 'blur'}],
        thingScale: [{required: true, message: '请输入', trigger: 'blur'}],
        thingUrl: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        thingId: '',
        thingName: '',
        thingType: '',
        thingPos: '',
        thingNet: '',
        thingDep: '',
        thingClass: '',
        thingPid: '',
        thingHeading: '0',
        thingScale: '0.01',
        thingUrl: '',
      },
      setting: {},
      ztreeObj: null,
      nodes: [],
    }
  },
  methods: {
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
          id: "0",
          pid: "",
          name: "部件分类目录树",
          isNode: false,
          showIcon: false,
          nocheck: false,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].thingModelId;
        treeObj.pid = data[i].thingModelPid;
        treeObj.name = data[i].thingModelName;
        treeObj.url = data[i].thingModelUrl;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function TreeChecked(event, treeId, treeNode) {
        _this.formData.thingPid = treeNode.id;
        _this.formData.thingUrl = treeNode.url;
        _this.formData.thingType = treeNode.name;
        let nodes = _this.nodes;
        for (let i = 0; i < nodes.length; i++) {
          if (nodes[i].id === treeNode.pid) {
            _this.formData.thingClass = nodes[i].name;
            break;
          }
        }
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    getCityThingData() {
      this.pictLoading = true;
      getCityThing().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.thingId;
      this.currentRow = row;
      this.addModelToMap(row);
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
      viewer.entities.removeAll();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.ztreeObj.checkNode(this.ztreeObj.getNodeByParam("id", this.currentRow.thingPid), true);
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
            thingId: this.currentId
          };
          deleteCityThing(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getCityThingData();
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
    batchDeleteData() {
      if (this.multipleSelection !== []) {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          batchDeleteCityThing(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getCityThingData();
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
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateCityThing(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getCityThingData();
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
              insertCityThing(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getCityThingData();
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
    },
    backTable() {
      this.isTableShow = true;
      this.clearModel();
    },
    addModelToMapHandler() {
      if (this.formData.thingPid === '') {
        this.$message({
          message: '请选择部件类型！',
          type: 'error'
        });
        return;
      }
      let _this = this;
      viewer.entities.removeAll();
      drawHandler = drawHandler && drawHandler.destroy();
      let poiResult;
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        let cartesian = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          cartesian = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        let lng = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        poiResult = lng + "," + lat + "," + height;

        let heading = Cesium.Math.toRadians(Number(_this.formData.thingHeading));
        let hpr = new Cesium.HeadingPitchRoll(heading, 0, 0);
        let orientation = Cesium.Transforms.headingPitchRollQuaternion(cartesian, hpr);
        let pinBuilder = new Cesium.PinBuilder();
        let drawPointEntity = viewer.entities.getById("drawPointEntity");
        if (drawPointEntity === undefined) {
          viewer.entities.add({
            id: 'drawPointEntity',
            position: cartesian.clone(),
            orientation: orientation,
            billboard: {
              image: pinBuilder.fromText('新', Cesium.Color.GREEN, 42).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              pixelOffset: new Cesium.Cartesian2(0, -50),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(50, 1, 2000, 0.2),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(200, 100000000)
            },
            model: {
              uri: common.serverIp + "city3dfile/" + _this.formData.thingUrl,// 模型路径
              scale: Number(_this.formData.thingScale),
              // minimumPixelSize: 32,// 模型最小刻度
              // maximumSize: 128,
              // maximumScale: 200,// 设置模型最大放大大小
              silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
              silhouetteSize: 1.0,
              imageBasedLightingFactor: new Cesium.Cartesian2(1.5, 1),
            }
          });
        } else {
          drawPointEntity.position = cartesian.clone();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        _this.formData.thingPos = poiResult;
        drawHandler = drawHandler && drawHandler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    clearModel() {
      drawHandler = drawHandler && drawHandler.destroy();
      viewer.entities.removeAll();
    },
    updateModel(key) {
      let heading, hpr, position, pos, orientation;
      switch (key) {
        case 0:
          heading = Cesium.Math.toRadians(Number(this.formData.thingHeading));
          hpr = new Cesium.HeadingPitchRoll(heading, 0, 0);
          position = this.formData.thingPos.split(",");
          pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          orientation = Cesium.Transforms.headingPitchRollQuaternion(pos, hpr);
          viewer.entities.getById("drawPointEntity").orientation = orientation;
          viewer.entities.getById("drawPointEntity").position = pos;
          this.formData.thingScale = Number(this.formData.thingScale);
          viewer.entities.getById("drawPointEntity").model.scale = this.formData.thingScale;
          break;
        case 1:
          this.formData.thingHeading = Number(this.formData.thingHeading) - 1;
          heading = Cesium.Math.toRadians(Number(this.formData.thingHeading));
          hpr = new Cesium.HeadingPitchRoll(heading, 0, 0);
          position = this.formData.thingPos.split(",");
          pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          orientation = Cesium.Transforms.headingPitchRollQuaternion(pos, hpr);
          viewer.entities.getById("drawPointEntity").orientation = orientation;
          break;
        case 2:
          this.formData.thingHeading = Number(this.formData.thingHeading) + 1;
          heading = Cesium.Math.toRadians(Number(this.formData.thingHeading));
          hpr = new Cesium.HeadingPitchRoll(heading, 0, 0);
          position = this.formData.thingPos.split(",");
          pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          orientation = Cesium.Transforms.headingPitchRollQuaternion(pos, hpr);
          viewer.entities.getById("drawPointEntity").orientation = orientation;
          break;
        case 3:
          position = this.formData.thingPos.split(",");
          pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]) + 1);
          viewer.entities.getById("drawPointEntity").position = pos;
          this.formData.thingPos = position[0] + ',' + position[1] + ',' + (Number(position[2]) + 1);
          break;
        case 4:
          position = this.formData.thingPos.split(",");
          pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]) - 1);
          viewer.entities.getById("drawPointEntity").position = pos;
          this.formData.thingPos = position[0] + ',' + position[1] + ',' + (Number(position[2]) - 1);
          break;
        case 5:
          this.formData.thingScale = Number(this.formData.thingScale) + 0.01;
          viewer.entities.getById("drawPointEntity").model.scale = this.formData.thingScale;
          break;
        case 6:
          this.formData.thingScale = Number(this.formData.thingScale) - 0.01;
          viewer.entities.getById("drawPointEntity").model.scale = this.formData.thingScale;
          break;
        default:
          break;
      }
    },
    addModelToMap(data) {
      viewer.entities.removeAll();
      let position = data.thingPos.split(",");
      let pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
      let hpr = new Cesium.HeadingPitchRoll(Cesium.Math.toRadians(Number(data.thingHeading)), 0, 0);
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
          uri: common.serverIp + "city3dfile/" + data.thingUrl,// 模型路径
          scale: Number(data.thingScale),
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
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.thingName.indexOf(val)
          || ~item.thingClass.indexOf(val)
          || ~item.thingType.indexOf(val)
          || ~item.thingNet.indexOf(val)
          || ~item.thingDep.indexOf(val)
        ));
    }
  },
  mounted() {
    getCityThingModel().then(res => {
      this.createZTree(res.data);
    });
    this.getCityThingData();
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

.form-fai-update {
  font-size: 24px !important;
  cursor: pointer;
  margin: 0 15px 0 0;
  color: #007acc;
}

.result-table {
  width: 100%;
  font-size: 15px !important;
}

.my-card-body {
  overflow-y: auto;
}

.row_display {
  display: flex;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
