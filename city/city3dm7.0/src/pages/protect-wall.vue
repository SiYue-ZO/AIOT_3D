<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
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
                  :default-sort="{prop: 'wallName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="围栏名称" prop="wallName" sortable></el-table-column>
          <el-table-column label="进入报警" prop="wallIn" sortable></el-table-column>
          <el-table-column label="离开报警" prop="wallOut" sortable></el-table-column>
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
          <el-form-item label="围栏名称" prop="wallName">
            <el-input v-model="formData.wallName" placeholder="请填写名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="进入报警" prop="wallIn">
            <el-select v-model="formData.wallIn" placeholder="请选择">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="离开报警" prop="wallOut">
            <el-select v-model="formData.wallOut" placeholder="请选择">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="围栏坐标" prop="wallPoi">
            <el-input v-model="formData.wallPoi" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%" type="textarea" :rows="5"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addWallToMapHandler"></font-awesome-icon>
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
  import {stringToNumber} from "@/js/CesiumTools";
  import CesiumMap from "../utils/components/cesium-map";
  import {deleteWall, getWall, insertWall, updateWall} from "../api/api";

  let wallDrawMarkArr = [];
  let drawHandler;
  export default {
    name: "protect-wall",
    components: {CesiumMap},
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
          wallName: [{required: true, message: '请输入', trigger: 'blur'}],
          wallIn: [{required: true, message: '请输入', trigger: 'blur'}],
          wallOut: [{required: true, message: '请输入', trigger: 'blur'}],
          wallPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          wallId: '',
          wallName: '',
          wallIn: '是',
          wallOut: '是',
          wallPoi: '',
        },
      }
    },
    methods: {
      addWallToMapHandler() {
        let _this = this;
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicLineGroundEntity = viewer.entities.add({
          id: 'dynamicLineGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureLineGroundEntity = viewer.entities.add({
          id: 'measureLineGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.YELLOW,
          }
        });

        //节点添加标签
        function addPin(carPoi) {
          wallDrawMarkArr.push(viewer.entities.add({
            position: carPoi,
            point: {
              pixelSize: 10,
              color: Cesium.Color.RED,
              disableDepthTestDistance: 5000000,
              outlineWidth: 2,
              outlineColor: Cesium.Color.WHITE.withAlpha(1)
            },
          }));
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
          let tempPosArr = [];
          let minimumHeights = [];
          let measureResult = 0;
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
            tempPosArr.push(Number(longitudeString), Number(latitudeString), Number(heightString) + 40);
            minimumHeights.push(Number(heightString));
          }

          let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[0]);
          let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
          let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
          let heightString = cartographic.height;
          tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          tempPosArr.push(Number(longitudeString), Number(latitudeString), Number(heightString) + 40);
          minimumHeights.push(Number(heightString));

          for (let i = 0; i < measureLinePositonsArray.length - 1; i++) {
            measureResult += Cesium.Cartesian3.distance(measureLinePositonsArray[i], measureLinePositonsArray[i + 1]);
          }

          tempPointsStr = tempPointsStr.substring(0, tempPointsStr.length - 1);
          _this.formData.wallPoi = tempPointsStr;

          viewer.entities.remove(dynamicLineGroundEntity);
          viewer.entities.remove(measureLineGroundEntity);
          for (let i = 0; i < wallDrawMarkArr.length; i++) {
            viewer.entities.remove(wallDrawMarkArr[i]);
          }
          wallDrawMarkArr = [];

          let alp = 1;
          let num = 0;
          viewer.entities.add({
            polygon: {
              hierarchy: Cesium.Cartesian3.fromDegreesArrayHeights(tempPosArr),
              material: Cesium.Color.RED.withAlpha(0.05)
            },
            wall: {
              positions: Cesium.Cartesian3.fromDegreesArrayHeights(tempPosArr),
              minimumHeights: minimumHeights,
              material: new Cesium.ImageMaterialProperty({
                image: "static/images/wallbg.png",
                transparent: true,
                repeat: new Cesium.Cartesian2(measureResult / 60, 1.0),
                color: new Cesium.CallbackProperty(function () {
                  if ((num % 2) === 0) {
                    alp -= 0.01;
                  } else {
                    alp += 0.01;
                  }

                  if (alp <= 0.1) {
                    num++;
                  } else if (alp >= 1) {
                    num++;
                  }
                  return Cesium.Color.WHITE.withAlpha(alp)
                  //entity的颜色透明 并不影响材质，并且 entity也会透明
                }, false)
              }),
            },
          });
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      addWall(row) {
        this.clearWall();
        let posCarArr = [];
        let posArr = stringToNumber(row.wallPoi);
        let minimumHeights = [];
        let measureResult = 0;
        for (let j = 0; j < posArr.length; j = j + 3) {
          let point = new Cesium.Cartesian3.fromDegrees(posArr[j], posArr[j + 1], Number(posArr[j + 2]) + 40);
          posCarArr.push(point);
          minimumHeights.push(Number(posArr[j + 2]));
        }
        let point = new Cesium.Cartesian3.fromDegrees(posArr[3], posArr[4], Number(posArr[5]) + 40);
        posCarArr.push(point);
        minimumHeights.push(Number(posArr[5]));
        for (let n = 0; n < posCarArr.length - 1; n++) {
          measureResult += Cesium.Cartesian3.distance(posCarArr[n], posCarArr[n + 1]);
        }

        let alp = 1;
        let num = 0;
        viewer.entities.add({
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(posCarArr),
            material: Cesium.Color.RED.withAlpha(0.05)
          },
          wall: {
            positions: posCarArr,
            minimumHeights: minimumHeights,
            material: new Cesium.ImageMaterialProperty({
              image: "static/images/wallbg.png",
              transparent: true,
              repeat: new Cesium.Cartesian2(measureResult / 60, 1.0),
              color: new Cesium.CallbackProperty(function () {
                if ((num % 2) === 0) {
                  alp -= 0.01;
                } else {
                  alp += 0.01;
                }

                if (alp <= 0.1) {
                  num++;
                } else if (alp >= 1) {
                  num++;
                }
                return Cesium.Color.WHITE.withAlpha(alp)
                //entity的颜色透明 并不影响材质，并且 entity也会透明
              }, false)
            }),
          },
        });
        CesiumMap.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 500]);
      },
      clearWall() {
        for (let i = 0; i < wallDrawMarkArr.length; i++) {
          viewer.entities.remove(wallDrawMarkArr[i]);
        }
        wallDrawMarkArr.length = 0;
        drawHandler = drawHandler && drawHandler.destroy();
        viewer.entities.removeAll();
      },
      getWallData() {
        this.pictLoading = true;
        getWall().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.wallId;
        this.currentRow = row;
        this.addWall(row);
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
              wallId: this.currentId
            };
            deleteWall(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getWallData();
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
      multideleteData() {
        this.$message({
          message: '待完善，批量删除！',
          type: 'error'
        });
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
                updateWall(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getWallData();
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
                insertWall(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getWallData();
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
        this.clearWall();
      },
      backTable() {
        this.isTableShow = true;
        this.clearWall();
      }
    },
    mounted() {
      this.getWallData();
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

  .search-input {
    width: 180px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
