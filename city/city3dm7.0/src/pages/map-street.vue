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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="streetId"
                  :default-sort="{prop: 'streetCheck', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="路名点名称" prop="streetName" sortable></el-table-column>
          <el-table-column label="路名全称" prop="streetCheck" sortable></el-table-column>
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
          <el-form-item label="点名称" prop="streetName">
            <el-input v-model="formData.streetName" placeholder="请填写路名点名称" style="width: 90%" maxlength="1"
                      show-word-limit></el-input>
          </el-form-item>
          <el-form-item label="路名全称" prop="streetCheck">
            <el-input v-model="formData.streetCheck" placeholder="请填写路名全称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="点位坐标" prop="poi">
            <el-input v-model="formData.poi" placeholder="请左键地图点选、右键结束或填写点位坐标值" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="addStreetPoiToMapHandler"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="旋转角度" prop="rotationAngle">
            <el-input v-model="formData.rotationAngle" placeholder="旋转角度" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width title="点击预览路名点"
                               @click="streetPreview"></font-awesome-icon>
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
  import {getStreet} from "../api/api";
  import {deleteStreet, insertStreet, updateStreet, batchDeleteStreet} from "../api/api";

  let roadLabelArr = [];

  export default {
    name: "map-street",
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
        multipleSelection: [],
        rules: {
          streetName: [{required: true, message: '请输入', trigger: 'blur'}],
          streetCheck: [{required: true, message: '请输入', trigger: 'blur'}],
          poi: [{required: true, message: '请输入', trigger: 'blur'}],
          rotationAngle: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          streetId: '',
          streetName: '',
          streetCheck: '',
          poi: '',
          rotationAngle: '0',
        }
      }
    },
    methods: {
      addStreetPoiToMapHandler() {
        let _this = this;
        viewer.entities.removeAll();
        let drawHandler = drawHandler && drawHandler.destroy();
        let poiResult;
        let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
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

          let drawPointEntity = viewer.entities.getById("drawPointEntity");
          if (drawPointEntity === undefined) {
            viewer.entities.add({
              id: 'drawPointEntity',
              position: cartesian.clone(),
              billboard: {
                image: pinBuilder.fromText('新', Cesium.Color.GREEN, 42).toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM
              },
              ellipsoid: {
                radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
                material: Cesium.Color.GREEN.withAlpha(0.7)
              }
            });
          } else {
            drawPointEntity.position = cartesian.clone();
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          _this.formData.poi = poiResult;
          drawHandler = drawHandler && drawHandler.destroy();
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      getStreetData() {
        this.pictLoading = true;
        getStreet().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
          this.showRoadName(res.data);
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.streetId;
        this.currentRow = row;
        let poiArr = row.poi.split(',');
        poiArr[2] = Number(poiArr[2]) + 300;
        CesiumMap.methods.flyToLocation(poiArr);
        this.addStreetPoiToMap(row);
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
              streetId: this.currentId
            };
            deleteStreet(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getStreetData();
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
            batchDeleteStreet(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getStreetData();
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
                updateStreet(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getStreetData();
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
                insertStreet(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getStreetData();
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
      },
      backTable() {
        this.isTableShow = true;
        viewer.entities.removeAll();
      },
      streetPreview() {
        if (this.formData.poi !== '' && this.formData.rotationAngle !== '' && this.formData.streetName !== '') {
          this.clearRoadLabel();
          let streetArr = [this.formData];
          this.showRoadName(streetArr);
        } else {
          this.$message({
            message: '点名称、点位坐标、旋转角度不能为空！',
            type: 'error'
          });
        }
      },
      addStreetPoiToMap(row) {
        this.clearRoadLabel();
        this.showRoadName([row]);
      },
      showRoadName(tmRoadLable) {
        //计算当前城市的经纬度与米的换算比
        if (tmRoadLable.length !== 0) {
          let yPerimeter = 40075016.68557849;
          let curlat = Number(tmRoadLable[0].poi.split(',')[1].split('.')[0]) * Math.PI / 180;
          let xPerimeter = yPerimeter * Math.cos(curlat);
          let yperi = 360 / yPerimeter;
          let xperi = 360 / xPerimeter;

          //显示重要道路标记
          for (let i = 0; i < tmRoadLable.length; i++) {
            let textCanvas = document.createElement('canvas');
            textCanvas.width = 40;
            textCanvas.height = 40;
            let context = textCanvas.getContext("2d");
            context.font = "36px Microsoft YaHei";
            context.fontWeight = "900";
            context.fillStyle = "#fff";
            context.textAlign = "center";
            context.textBaseline = "middle";
            context.strokeStyle = "#a25100";
            context.lineWidth = "1";
            context.fillText(tmRoadLable[i].streetName, 20, 20);
            context.strokeText(tmRoadLable[i].streetName, 20, 20);
            let poiArr = tmRoadLable[i].poi.split(',');
            roadLabelArr.push(viewer.entities.add({
                show: true,
                rectangle: {
                  coordinates: Cesium.Rectangle.fromDegrees(
                    Number(poiArr[0]) - 5 * xperi,
                    Number(poiArr[1]) - 5 * yperi,
                    Number(poiArr[0]) + 5 * xperi,
                    Number(poiArr[1]) + 5 * yperi
                  ),
                  material: textCanvas,
                  rotation: Cesium.Math.toRadians(tmRoadLable[i].rotationAngle),
                  stRotation: Cesium.Math.toRadians(tmRoadLable[i].rotationAngle),
                  classificationType: Cesium.ClassificationType.BOTH
                }
              })
            );
          }
        }
      },
      clearRoadLabel() {
        roadLabelArr.map(item => {
          viewer.entities.remove(item);
        });
        roadLabelArr = [];
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.streetName.indexOf(val)
            || ~item.streetCheck.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getStreetData();
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
