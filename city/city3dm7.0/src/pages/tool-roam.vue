<template>
  <div>
    <div class="left-card">
      <el-card id="left-card" :style="{width: leftWidth, height: viewerHeight}">
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
            <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
          </div>
          <div v-show="!isTableShow">
            <el-button class="header-button" type="success" icon="el-icon-circle-check"
                       @click="submitForm('formData')">
              确 定
            </el-button>
            <el-button class="header-button" type="warning" icon="el-icon-refresh-right"
                       @click="resetForm('formData')">
              重 置
            </el-button>
            <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回
            </el-button>
          </div>
        </div>
        <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
          <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                    v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                    element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                    :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                    @selection-change="handleSelectionChange" ref="multipleTable" row-key="roamId"
                    :default-sort="{prop: 'roamModel', order: 'ascending'}" @row-click="rowClick">
            <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
            <el-table-column label="名称" prop="roamName" sortable></el-table-column>
            <el-table-column label="类型" prop="roamModel" sortable></el-table-column>
            <el-table-column label="显示路线" prop="roamIsshow" sortable></el-table-column>
            <el-table-column label="循环漫游" prop="roamIsre" sortable></el-table-column>
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
            <div class="row_display">
              <el-form-item label="路径名称" prop="roamName">
                <el-input v-model="formData.roamName" placeholder="请填写路径名称"></el-input>
              </el-form-item>
              <el-form-item label="漫游模型" prop="roamModel" style="margin-left:14px">
                <el-select v-model="formData.roamModel" placeholder="请选择分类" style="width: 93%">
                  <el-option label="旋翼无人机" value="旋翼无人机"></el-option>
                  <el-option label="无人机" value="无人机"></el-option>
                  <el-option label="大型客机" value="大型客机"></el-option>
                  <el-option label="战斗机" value="战斗机"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="路径类型" prop="roamType">
                <el-select v-model="formData.roamType" placeholder="请选择分类" style="width: 93%">
                  <el-option label="平滑线" value="平滑线"></el-option>
                  <el-option label="折线" value="折线"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="循环漫游" prop="roamIsre">
                <el-select v-model="formData.roamIsre" placeholder="请选择分类" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="显示路线" prop="roamIsshow">
                <el-select v-model="formData.roamIsshow" placeholder="请选择分类" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="显示模型" prop="roamIsmodelshow">
                <el-select v-model="formData.roamIsmodelshow" placeholder="请选择分类" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="漫游时间" prop="roamSpeed">
                <el-input v-model="formData.roamSpeed" placeholder="请填写时长"></el-input>
              </el-form-item>
              <el-form-item label="路径高度" prop="roamHeight" style="margin-left:14px">
                <el-input v-model="formData.roamHeight" placeholder="请填写高度"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="路径坐标" prop="roamLine">
              <el-input id="roamLine" v-model="formData.roamLine" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                        style="width: 90%" type="textarea" :rows="3"></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                                 @click="roamDraw"></font-awesome-icon>
            </el-form-item>
            <el-form-item label="路径备注" prop="roamNote">
              <el-input v-model="formData.roamNote" placeholder="请填写备注"
                        style="width: 90%" type="textarea" :rows="3"></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width
                                 @click="roamPreview"></font-awesome-icon>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
  import CesiumMap from "../utils/components/cesium-map";
  import '../js/CesiumRoam.js';
  import {deleteRoam, getRoamAll, insertRoam, updateRoam, batchDeleteRoam} from "../api/api";

  let roamDrawMarkArr = [];
  export default {
    name: "tool-roam",
    components: {CesiumMap},
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        devFilter: "", //搜索字段
        queryResult: [],
        tableDate: [],
        pictLoading: false,
        isTableShow: true,
        isEdit: false,
        currentId: '',
        currentRow: {},
        rules: {
          roamName: [{required: true, message: '请输入', trigger: 'blur'}],
          roamModel: [{required: true, message: '请输入', trigger: 'blur'}],
          roamLine: [{required: true, message: '请输入', trigger: 'blur'}],
          roamIsshow: [{required: true, message: '请输入', trigger: 'blur'}],
          roamIsre: [{required: true, message: '请输入', trigger: 'blur'}],
          roamSpeed: [{required: true, message: '请输入', trigger: 'blur'}],
          roamType: [{required: true, message: '请输入', trigger: 'blur'}],
          roamIsmodelshow: [{required: true, message: '请输入', trigger: 'blur'}],
          roamHeight: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          roamId: '',
          roamName: "",
          roamModel: "旋翼无人机",
          roamLine: '',
          roamIsshow: '是',
          roamIsre: '是',
          roamSpeed: '3000',
          roamType: '平滑线',
          roamIsmodelshow: '是',
          roamHeight: "150",
          roamNote: ""
        },
      }
    },
    methods: {
      roamDraw() {
        let _this = this;
        this.clearRoamDraw();
        let roamHandler = roamHandler && roamHandler.destroy();
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicRoamGroundEntity = viewer.entities.add({
          id: 'dynamicRoamGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureRoamGroundEntity = viewer.entities.add({
          id: 'measureRoamGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.YELLOW,
          }
        });

        //节点添加标签
        function addPin(carPoi) {
          roamDrawMarkArr.push(viewer.entities.add({
            position: carPoi,
            point: {
              pixelSize: 10,
              color: Cesium.Color.RED.withAlpha(0.8),
              disableDepthTestDistance: 5000000,
              outlineWidth: 2,
              outlineColor: Cesium.Color.WHITE.withAlpha(1)
            },
          }));
        }

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        roamHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        roamHandler.setInputAction(function (movement) {
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
            measureRoamGroundEntity.polyline.positions = measureLinePositonsArray;
            previousPosition = currentPosition.clone();
            addPin(tmp2);
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        roamHandler.setInputAction(function (movement) {
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
              dynamicRoamGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        roamHandler.setInputAction(function () {
          roamHandler = roamHandler && roamHandler.destroy();
          let tempPointsStr = '';
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height + Number(_this.formData.roamHeight);
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          _this.formData.roamLine = tempPointsStr;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      startRoam(data) {
        this.stopRoaming();
        let modeluri = '';
        let modelscale = 0;
        switch (data.roamModel) {
          case '无人机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/UAV.glb";
            modelscale = 0.01;
            break;
          case '旋翼无人机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/rUAVa.gltf";
            modelscale = 0.5;
            break;
          case '大型客机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/plane.glb";
            modelscale = 0.06;
            break;
          case '战斗机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/jet.glb";
            modelscale = 1;
            break;
          default:
            break;
        }
        let linesStr = data.roamLine.substring(0, data.roamLine.length - 1);
        let isPathShow = data.roamIsshow === '是';
        let isRe = data.roamIsre === '是';
        let roamIsmodelshow = data.roamIsmodelshow === '是';
        let options = {
          'viewer': viewer,
          'modeluri': modeluri,
          'scale': modelscale,
          'lines': linesStr,
          'isPathShow': isPathShow,
          'isRe': isRe,
          'roamIsmodelshow': roamIsmodelshow,
          'speed': Number(data.roamSpeed),
          'type': data.roamType,
        };
        CesiumRoam.initRoaming(options);
      },
      roamPreview() {
        this.stopRoaming();
        let modeluri = '';
        let modelscale = 0;
        switch (this.formData.roamModel) {
          case '无人机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/UAV.glb";
            modelscale = 0.01;
            break;
          case '旋翼无人机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/rUAVa.gltf";
            modelscale = 0.5;
            break;
          case '大型客机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/plane.glb";
            modelscale = 0.06;
            break;
          case '战斗机':
            modeluri = common.serverIp + 'city3dfile/' + "data/model/air/jet.glb";
            modelscale = 1;
            break;
          default:
            break;
        }
        let linesStr = this.formData.roamLine.substring(0, this.formData.roamLine.length - 1);
        let isPathShow = this.formData.roamIsshow === '是';
        let isRe = this.formData.roamIsre === '是';
        let roamIsmodelshow = this.formData.roamIsmodelshow === '是';
        let options = {
          'viewer': viewer,
          'modeluri': modeluri,
          'scale': modelscale,
          'lines': linesStr,
          'isPathShow': isPathShow,
          'isRe': isRe,
          'roamIsmodelshow': roamIsmodelshow,
          'speed': Number(this.formData.roamSpeed),
          'type': this.formData.roamType,
        };
        CesiumRoam.initRoaming(options);
      },
      stopRoaming() {
        CesiumRoam.EndRoaming(viewer);
      },
      clearRoamDraw() {
        if ((viewer.entities.getById('dynamicRoamGroundEntity') !== undefined)) {
          viewer.entities.removeById('dynamicRoamGroundEntity');
        }
        if ((viewer.entities.getById('measureRoamGroundEntity') !== undefined)) {
          viewer.entities.removeById('measureRoamGroundEntity');
        }
        for (let i = 0; i < roamDrawMarkArr.length; i++) {
          viewer.entities.remove(roamDrawMarkArr[i]);
        }
        roamDrawMarkArr = [];
      },
      getRoamData() {
        this.pictLoading = true;
        getRoamAll().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.roamId;
        this.currentRow = row;
        this.startRoam(row);
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
              roamId: this.currentId
            };
            deleteRoam(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getRoamData();
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
            batchDeleteRoam(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getRoamData();
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
                updateRoam(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getRoamData();
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
                insertRoam(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getRoamData();
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
        this.clearRoamDraw();
        this.stopRoaming();
      },
      backTable() {
        this.isTableShow = true;
        this.clearRoamDraw();
        this.stopRoaming();
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.roamName.indexOf(val)
            || ~item.roamModel.indexOf(val)
            || ~item.roamIsshow.indexOf(val)
            || ~item.roamIsre.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getRoamData();
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
    font-size: 15px !important;
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
