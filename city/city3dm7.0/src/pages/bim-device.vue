<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="deviceId"
                  :default-sort="{prop: 'type', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="名称" prop="name" sortable></el-table-column>
          <el-table-column label="类型" prop="type" sortable width="100"></el-table-column>
          <el-table-column label="状态" prop="status" sortable width="100"></el-table-column>
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
          <el-form-item label="名称" prop="name">
            <el-input v-model="formData.name" placeholder="请填写三维模型数据名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="类型" prop="type">
            <el-select v-model="formData.type" placeholder="请选择类型">
              <el-option label="供电" value="供电"></el-option>
              <el-option label="空调" value="空调"></el-option>
              <el-option label="给排水" value="给排水"></el-option>
              <el-option label="照明" value="照明"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="关联相机" prop="floor">
            <el-select v-model="formData.floor" placeholder="请选择关联相机">
              <el-option v-for="item in floorArr" :key="item.id" :label="item.camAdd"
                         :value="item.id"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="设备位置" prop="devicepos">
            <el-input v-model="formData.devicepos" placeholder="请生成设备位置坐标" style="width: 90%" type="textarea"
                      :rows="3"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addNetToMapHandler"></font-awesome-icon>
            <div class="form-note">* 左键选取坐标，右键结束</div>
          </el-form-item>
          <el-form-item label="设备高度" prop="height">
            <el-input v-model="formData.height" placeholder="请填写设备高度" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-select v-model="formData.status" placeholder="请选择状态">
              <el-option label="正常" value="正常"></el-option>
              <el-option label="异常" value="异常"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="温度" prop="temp">
            <el-input v-model="formData.temp" placeholder="请填写温度" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="电压" prop="voltage">
            <el-input v-model="formData.voltage" placeholder="请填写电压" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="累计开机" prop="runTime">
            <el-input v-model="formData.runTime" placeholder="请填写累计开机时间" style="width: 90%"></el-input>
            小时
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
import {
  deleteBimDevice,
  getBimDevice,
  insertBimDevice,
  updateBimDevice,
  batchDeleteBimDevice,
  getVideoNoNodes, getAllandDeviceById
} from "../api/api";
import {stringToNumber} from "@/js/CesiumTools";

let _this;
export default {
  name: "bim-device",
  components: {CesiumMap},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      multipleSelection: [],
      rules: {
        name: [{required: true, message: '请输入', trigger: 'blur'}],
        type: [{required: true, message: '请输入', trigger: 'blur'}],
        height: [{required: true, message: '请输入', trigger: 'blur'}],
        devicepos: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        deviceId: '',
        name: '',
        status: '正常',
        temp: '68',
        voltage: '220',
        runTime: '0',
        devicepos: '',
        height: '2.4',
        type: '供电',
        floor: ''
      },
      floorArr: [],
    }
  },
  methods: {
    addNetToMapHandler() {
      _this = this;
      viewer.entities.removeAll();
      let height;
      let activeShapePoints = [];
      let activeShapePointsgeo = [];
      let drawHandler = drawHandler && drawHandler.destroy();
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
          cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        }
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          activeShapePointsgeo.push(cartographic);
          if (activeShapePoints.length > 3) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.endPosition);
          newPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        activeShapePoints.pop();
        activeShapePoints.push(newPosition);
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      drawHandler.setInputAction(function (movement) {
        drawHandler = drawHandler && drawHandler.destroy();
        let tempPointsStr = '';
        if (activeShapePointsgeo.length > 2) {
          for (let pindex = 0; pindex < activeShapePointsgeo.length; pindex++) {
            let longitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].longitude);
            let latitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].latitude);
            let heightString = activeShapePointsgeo[pindex].height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          _this.formData.devicepos = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        viewer.entities.add({
          position: worldPosition,
          point: {
            color: Cesium.Color.RED,
            pixelSize: 10,
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE,
            disableDepthTestDistance: 10000
          }
        });
      }

      function drawPolygon() {
        if ((viewer.entities.getById('areaEntity') !== undefined)) {
          viewer.entities.removeById('areaEntity');
        }
        viewer.entities.add({
          id: 'areaEntity',
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
                  return activeShapePoints;
              }, false),*/
            material: new Cesium.ColorMaterialProperty(Cesium.Color.RED.withAlpha(0.3)),
            perPositionHeight: true,
            extrudedHeight: Number(_this.formData.height) + Number(height),
            outline: true,
            outlineColor: Cesium.Color.ORANGERED
          }
        });
      }
    },
    addNetToMap(row) {
      viewer.entities.removeAll();
      let pois = stringToNumber(row.devicepos);
      viewer.entities.add({
        polygon: {
          hierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(pois)),
          material: new Cesium.ColorMaterialProperty(Cesium.Color.RED.withAlpha(0.3)),
          perPositionHeight: true,
          extrudedHeight: Number(pois[2]) + Number(row.height),
          outline: true,
          outlineColor: Cesium.Color.ORANGERED
        }
      });

      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(Number(pois[0]), Number(pois[1]), Number(pois[2]) + 200),
      });
    },
    getBimDeviceData() {
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getBimDevice().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandDeviceById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleDevice.map(item => {
            resultArr.push(item.bimDevice);
          });
          this.queryResult = resultArr;
          this.tableDate = resultArr;
          this.pictLoading = false;
        });
      }
    },
    rowClick(row, column, event) {
      this.currentId = row.deviceId;
      this.currentRow = row;
      this.addNetToMap(row);
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
      this.getDeviceRelateVideo();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.getDeviceRelateVideo();
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
            deviceId: this.currentId
          };
          deleteBimDevice(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getBimDeviceData();
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
          let params = {
            "bimDevice": this.formData,
            "sysRoleBimDevice": {
              "roleId": localStorage.getItem("roleId"),
            }
          };
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateBimDevice(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getBimDeviceData();
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
              insertBimDevice(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getBimDeviceData();
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
    batchDeleteData() {
      if (this.multipleSelection !== []) {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          batchDeleteBimDevice(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getBimDeviceData();
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
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    backTable() {
      this.isTableShow = true;
    },
    //获取报警联动相机
    getDeviceRelateVideo() {
      getVideoNoNodes().then(res => {
        this.floorArr = res.data;
      });
    }
  },
  mounted() {
    this.getBimDeviceData();
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

.form-note {
  margin: 5px 0 0 10px
}
</style>
