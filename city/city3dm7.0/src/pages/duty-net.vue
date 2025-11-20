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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="netId"
                  :default-sort="{prop: 'netDep', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="严控区名称" prop="netName" sortable></el-table-column>
          <el-table-column label="类别" prop="netDep" sortable></el-table-column>
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
        <el-form ref="formData" :model="formData" :rules="rules" label-width="110px">
          <el-form-item label="名称" prop="netName">
            <el-input v-model="formData.netName" placeholder="请填写区域名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="类别" prop="netDep">
            <el-input v-model="formData.netDep" placeholder="请填写区域类别" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="图形坐标" prop="netPolygen">
            <el-input v-model="formData.netPolygen" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%" type="textarea" :rows="5"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addNetToMapHandler"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="外观颜色" prop="netColor">
            <el-input v-model="formData.netColor" placeholder="请选择或填入CSS颜色值" style="width: 90%"></el-input>
            <el-color-picker class="color-picker" v-model="formData.netColor" size="small"
                             :predefine="predefineColors"></el-color-picker>
          </el-form-item>
          <el-form-item label="中心坐标" prop="netCenter">
            <el-input v-model="formData.netCenter" placeholder="请左键地图点选、右键结束或填写点位坐标值" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="addNetCenterToMapHandler"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="登记时间" prop="netTime">
            <el-date-picker v-model="formData.netTime" align="left" type="date"
                            placeholder="选择日期" :picker-options="pickerOptions" style="width: 90%">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="封控等级" prop="netLevel">
            <el-input v-model="formData.netLevel" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="区域面积" prop="netArea">
            <el-input v-model="formData.netArea" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="人口数量" prop="netPeople">
            <el-input v-model="formData.netPeople" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="重点人员数量" prop="netKeyPeople">
            <el-input v-model="formData.netKeyPeople" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="netNote">
            <el-input v-model="formData.netNote" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
          </el-form-item>
          医疗保障：
          <el-form-item label="负责人员" prop="netDutyCare">
            <el-input v-model="formData.netDutyCare" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="netCareNote">
            <el-input v-model="formData.netCareNote" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
          </el-form-item>
          物质保障：
          <el-form-item label="负责人员" prop="netDutyGoods">
            <el-input v-model="formData.netDutyGoods" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="netGoodsNote">
            <el-input v-model="formData.netGoodsNote" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
          </el-form-item>
          其它：
          <el-form-item label="备注" prop="otherNote">
            <el-input v-model="formData.otherNote" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
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
  import {
    deletePoliceNet,
    getPoliceNet,
    insertPoliceNet,
    updatePoliceNet,
    batchDeletePoliceNet
  } from "../api/api";
  import {stringToNumber} from "@/js/CesiumTools";
  import CesiumMap from "../utils/components/cesium-map";

  let _this;
  let tmpClassificationPrimitive;
  export default {
    name: "duty-net",
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
          netName: [{required: true, message: '请输入', trigger: 'blur'}],
          netDep: [{required: true, message: '请输入', trigger: 'blur'}],
          netPolygen: [{required: true, message: '请输入', trigger: 'blur'}],
          netColor: [{required: true, message: '请输入', trigger: 'blur'}],
          netCenter: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          netId: '',
          netName: '',
          netDep: '',
          netPolygen: '',
          netColor: '',
          netCenter: '',
          netTime: '',
          netLevel: '',
          netArea: '',
          netPeople: '',
          netKeyPeople: '',
          netNote: '',
          netDutyCare: '',
          netCareNote: '',
          netDutyGoods: '',
          netGoodsNote: '',
          otherNote: ''
        },
        predefineColors: [
          '#ff4500',
          '#ff8c00',
          '#ffd700',
          '#90ee90',
          '#00ced1',
          '#1e90ff',
          '#c71585',
        ],
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
      }
    },
    methods: {
      addNetToMapHandler() {
        _this = this;
        viewer.entities.removeAll();
        viewer.scene.primitives.remove(tmpClassificationPrimitive);
        let activeShapePoints = [];
        let activeShapePointsgeo = [];
        let drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          let earthPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
          let height = cartographic.height; //模型高度
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
            _this.formData.netPolygen = tempPointsStr.substring(0, tempPointsStr.length - 1);
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
              classificationType: Cesium.ClassificationType.BOTH,
              outline: true,
              outlineColor: Cesium.Color.WHITE
            }
          });
        }
      },
      addNetToMap(row) {
        viewer.entities.removeAll();
        viewer.scene.primitives.remove(tmpClassificationPrimitive);
        let pois = stringToNumber(row.netPolygen);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(pois)),
            extrudedHeight: 5000,
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.fromCssColorString(row.netColor).withAlpha(0.6)),
          }
        });
        tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);

        let netCenterArr = row.netCenter.split(',');
        viewer.entities.add({
          position: Cesium.Cartesian3.fromDegrees(Number(netCenterArr[0]), Number(netCenterArr[1]), Number(netCenterArr[2])),
          label: {
            text: row.netName,
            font: '20px STHupo',
            style: Cesium.LabelStyle.FILL_AND_OUTLINE,
            fillColor: Cesium.Color.fromCssColorString(row.netColor),
            outlineColor: Cesium.Color.WHITE,
            outlineWidth: 5.0,
            disableDepthTestDistance: 5000000,
          }
        });

        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(Number(netCenterArr[0]), Number(netCenterArr[1]), Number(netCenterArr[2]) + 1000),
        });
      },
      addNetCenterToMapHandler() {
        let drawHandler = drawHandler && drawHandler.destroy();
        viewer.entities.removeById("drawPointEntity");
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
                image: pinBuilder.fromText('中', Cesium.Color.RED, 42).toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM
              },
              ellipsoid: {
                radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
                material: Cesium.Color.RED.withAlpha(0.7)
              }
            });
          } else {
            drawPointEntity.position = cartesian.clone();
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          _this.formData.netCenter = poiResult;
          drawHandler = drawHandler && drawHandler.destroy();
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      getDutyNetData() {
        this.pictLoading = true;
        getPoliceNet().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.netId;
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
              netId: this.currentId
            };
            deletePoliceNet(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getDutyNetData();
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
            batchDeletePoliceNet(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getDutyNetData();
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
            this.formData.netTime = new Date(this.formData.netTime).toLocaleDateString().replace(/\//g, '-');
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePoliceNet(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getDutyNetData();
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
                insertPoliceNet(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getDutyNetData();
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
        viewer.scene.primitives.remove(tmpClassificationPrimitive);
      },
      backTable() {
        this.isTableShow = true;
        viewer.entities.removeAll();
        viewer.scene.primitives.remove(tmpClassificationPrimitive);
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.netName.indexOf(val)
            || ~item.netDep.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getDutyNetData();
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

  .color-picker {
    position: absolute;
    top: 4px;
    margin: 0 0 0 8px;
  }

  .search-input {
    width: 180px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
