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
                  :default-sort="{prop: 'flowName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="名称" prop="flowName" sortable></el-table-column>
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
          <el-form-item label="名称" prop="flowName">
            <el-input v-model="formData.flowName" placeholder="请填写水流线代表名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="设备位置" prop="flowPos">
            <el-input v-model="formData.flowPos" placeholder="请生成水流线坐标" style="width: 90%" type="textarea"
                      :rows="3"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addLineToMapHandler"></font-awesome-icon>
            <div class="form-note">* 左键选取坐标，右键结束</div>
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
  import "../js/CesiumTrail.js";
  import CesiumMap from "../utils/components/cesium-map";
  import {deleteBimWaterFlow, getBimWaterFlow, insertBimWaterFlow, updateBimWaterFlow} from "../api/api";

  let _this;
  export default {
    name: "bim-water-flow",
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
        rules: {
          flowName: [{required: true, message: '请输入', trigger: 'blur'}],
          flowPos: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          bimFlowId: '',
          flowName: '',
          flowPos: '',
        }
      }
    },
    methods: {
      addLineToMapHandler() {
        let _this = this;
        viewer.entities.removeAll();
        let drawHandler = drawHandler && drawHandler.destroy();
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicLineGroundEntity = viewer.entities.add({
          id: 'dynamicLineGroundEntity',
          polyline: {
            width: 20,
            material: new Cesium.PolylineTrailLinkMaterialProperty(Cesium.Color.BLUE, 100000),
          }
        });
        //已输入的线段的entity
        let measureLineGroundEntity = viewer.entities.add({
          id: 'measureLineGroundEntity',
          polyline: {
            width: 3,
            material: Cesium.Color.YELLOW,
          }
        });

        //节点添加标签
        function addPin(carPoi) {
          viewer.entities.add({
            position: carPoi,
            point: {
              pixelSize: 10,
              color: Cesium.Color.RED,
              disableDepthTestDistance: 5000000,
              outlineWidth: 2,
              outlineColor: Cesium.Color.WHITE
            },
          });
        }

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          if (isFirst) {
            previousPosition = viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              previousPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            let tmp1 = previousPosition.clone();
            measureLinePositonsArray.push(tmp1);
            isFirst = false;
            addPin(tmp1);
          } else {
            currentPosition = viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            let tmp2 = currentPosition.clone();
            measureLinePositonsArray.push(tmp2);
            measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
            previousPosition = currentPosition.clone();
            addPin(tmp2);
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          if (!isFirst) {
            //获取当前点的坐标
            currentPosition = viewer.scene.pickPosition(movement.endPosition);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.endPosition);
              currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            if (currentPosition) {
              dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        drawHandler.setInputAction(function () {
          drawHandler = drawHandler && drawHandler.destroy();
          let tempPointsStr = '';
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          _this.formData.flowPos = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      addLineToMap(pois) {
        viewer.entities.removeAll();
        viewer.entities.add({
          polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(pois),
            width: 20,
            material: new Cesium.PolylineTrailLinkMaterialProperty(Cesium.Color.BLUE, 100000),
          }
        });
        //创建标注
        for (let i = 0; i < pois.length; i = i + 3) {
          viewer.entities.add({
            position: Cesium.Cartesian3.fromDegrees(pois[i], pois[i + 1], pois[i + 2]),
            point: {
              pixelSize: 8.0,
              color: Cesium.Color.BLUE,
              outlineColor: Cesium.Color.WHITE,
              outlineWidth: 2.0,
              disableDepthTestDistance: 5000000,
            }
          });
        }
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(Number(pois[0]), Number(pois[1]), Number(pois[2]) + 100)
        });
      },
      getBimWaterFlowData() {
        this.pictLoading = true;
        getBimWaterFlow().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.bimFlowId;
        this.currentRow = row;
        this.addLineToMap(row.flowPos.split(','));
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
        if (this.currentId !== '') {
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
              bimFlowId: this.currentId
            };
            deleteBimWaterFlow(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getBimWaterFlowData();
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
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateBimWaterFlow(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getBimWaterFlowData();
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
                insertBimWaterFlow(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getBimWaterFlowData();
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
      }
    },
    mounted() {
      this.getBimWaterFlowData();
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
