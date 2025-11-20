<template>
  <div>
    <div class="left-card">
      <el-card id="left-card" :style="{width: leftWidth, height: viewerHeight}">
        <div slot="header" class="card-header">
          <div v-show="isTableShow">
            <el-input placeholder="搜索名称" prefix-icon="el-icon-search" v-model="devFilter"
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
                    @selection-change="handleSelectionChange" ref="multipleTable" row-key="netId"
                    :default-sort="{prop: 'netLevel', order: 'ascending'}" @row-click="rowClick">
            <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
            <el-table-column label="网格名称" prop="netName" sortable></el-table-column>
            <el-table-column label="网格等级" prop="netLevel" sortable></el-table-column>
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
              <el-form-item label="名称" prop="netName">
                <el-input v-model="formData.netName" placeholder="请填写区域名称"></el-input>
              </el-form-item>
              <el-form-item label="类别" prop="netLevel" style="margin-left:14px">
                <el-select v-model="formData.netLevel" placeholder="请选择分类" style="width: 93%">
                  <el-option label="街道" value="0"></el-option>
                  <el-option label="社区" value="1"></el-option>
                  <el-option label="小区" value="2"></el-option>
                  <el-option label="一级网格" value="3"></el-option>
                  <el-option label="二级网格" value="4"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <el-form-item label="网格坐标" prop="netPoi">
              <el-input v-model="formData.netPoi" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                        style="width: 90%" type="textarea" :rows="3"></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                                 @click="addNetToMapHandler"></font-awesome-icon>
            </el-form-item>
            <el-form-item label="外观颜色" prop="netColor">
              <el-input v-model="formData.netColor" placeholder="请选择或填入CSS颜色值" style="width: 90%"></el-input>
              <el-color-picker class="color-picker" v-model="formData.netColor" size="small"
                               :predefine="predefineColors"></el-color-picker>
            </el-form-item>
            <el-form-item label="中心坐标" prop="netCenter">
              <el-input v-model="formData.netCenter" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                        style="width: 90%"></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                                 @click="addNetCenterToMapHandler"></font-awesome-icon>
            </el-form-item>
            <el-form-item label="所属网格" prop="netCom">
              <el-input v-model="formData.netCom" placeholder="请填写" style="width: 90%"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="网格长" prop="netMaster">
                <el-select v-model="formData.netMaster" placeholder="请选择" filterable style="width: 93%">
                  <el-option v-for="item in netMasterArr" :key="item.netManId"
                             :label="item.name+'-'+item.post+'-'+item.tel"
                             :value="item.netManId"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="联络员1" prop="netListener1">
                <el-select v-model="netListenerResultArr[0]" placeholder="请选择" filterable style="width: 93%;">
                  <el-option v-for="item in netListenerArr" :key="item.netManId"
                             :label="item.name+'-'+item.post+'-'+item.tel"
                             :value="item.netManId"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="联络员2" prop="netListener2">
                <el-select v-model="netListenerResultArr[1]" placeholder="请选择" filterable style="width: 93%">
                  <el-option v-for="item in netListenerArr" :key="item.netManId"
                             :label="item.name+'-'+item.post+'-'+item.tel"
                             :value="item.netManId"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="联络员3" prop="netListener3">
                <el-select v-model="netListenerResultArr[2]" placeholder="请选择" filterable style="width: 93%">
                  <el-option v-for="item in netListenerArr" :key="item.netManId"
                             :label="item.name+'-'+item.post+'-'+item.tel"
                             :value="item.netManId"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="常住人员数" prop="netBasePeople">
                <el-input v-model="formData.netBasePeople" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="户籍人员数" prop="netHoldPeople" style="margin-left:14px">
                <el-input v-model="formData.netHoldPeople" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="外来人员数" prop="netFlowPeople">
                <el-input v-model="formData.netFlowPeople" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="组团力量数" prop="netGroup" style="margin-left:14px">
                <el-input v-model="formData.netGroup" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="备注" prop="netNote">
              <el-input v-model="formData.netNote" placeholder="请填写" type="textarea"
                        :autosize="{minRows: 2, maxRows: 3}" style="width: 90%"></el-input>
            </el-form-item>
          </el-form>
          <NetTree v-if="fresh"></NetTree>
        </div>
      </el-card>
    </div>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
import {stringToNumber} from "@/js/CesiumTools";
import CesiumMap from "../utils/components/cesium-map";
import NetTree from "../utils/components/net-tree";
import {
  deleteNet,
  insertNet,
  queryNetData,
  updateNet,
  getNetManByType,
  batchDeleteNet,
  getAllandNetById
} from "../api/api";

let _this;
let tmpClassificationPrimitive;
export default {
  name: "net-manage",
  components: {CesiumMap, NetTree},
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
      multipleSelection: [],
      rules: {
        netName: [{required: true, message: '请输入', trigger: 'blur'}],
        netPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        netLevel: [{required: true, message: '请输入', trigger: 'blur'}],
        netColor: [{required: true, message: '请输入', trigger: 'blur'}],
        netCenter: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        netId: '',
        netPid: '',
        netPoi: '',
        netLevel: '4',
        netName: '',
        netCenter: '',
        netColor: '#ff4500',
        netCom: "",
        netMaster: "",
        netListener: "",
        netBasePeople: "",
        netHoldPeople: "",
        netFlowPeople: "",
        netGroup: "",
        netNote: ""
      },
      netMasterArr: [],
      netListenerArr: [],
      netListenerResultArr: ["", "", ""],
      predefineColors: [
        '#ff4500',
        '#ff8c00',
        '#ffd700',
        '#90ee90',
        '#00ced1',
        '#1e90ff',
        '#c71585',
      ],
      fresh: true
    }
  },
  methods: {
    addNetToMapHandler() {
      _this = this;
      viewer.entities.removeAll();
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
          _this.formData.netPoi = tempPointsStr.substring(0, tempPointsStr.length - 1);
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
      let pois = stringToNumber(row.netPoi);
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
    getNetManageData() {
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        queryNetData().then(res => {
          res.data.map(item => {
            switch (item.netLevel) {
              case '0':
                item.netLevel = "街道";
                break;
              case '1':
                item.netLevel = "社区";
                break;
              case '2':
                item.netLevel = "小区";
                break;
              case '3':
                item.netLevel = "一级网格";
                break;
              case '4':
                item.netLevel = "二级网格";
                break;
              default:
                break;
            }
          });
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandNetById(params).then(res => {
          res.data.sysRoleNet.map(item => {
            switch (item.net.netLevel) {
              case '0':
                item.net.netLevel = "街道";
                break;
              case '1':
                item.net.netLevel = "社区";
                break;
              case '2':
                item.net.netLevel = "小区";
                break;
              case '3':
                item.net.netLevel = "一级网格";
                break;
              case '4':
                item.net.netLevel = "二级网格";
                break;
              default:
                break;
            }
          });
          let resultArr = [];
          res.data.sysRoleNet.map(item => {
            resultArr.push(item.net);
          });
          this.queryResult = resultArr;
          this.tableDate = resultArr;
          this.pictLoading = false;
        });
      }
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
      this.netListenerResultArr = [];
      this.getNetManData();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        window.netPid = this.currentRow.netPid;
        if (this.currentRow.netListener === null || this.currentRow.netListener === "") {
          this.netListenerResultArr = ["", "", ""];
        } else {
          this.netListenerResultArr = this.currentRow.netListener.split(",");
          this.netListenerResultArr.splice(this.netListenerResultArr.length - 1, 1);
        }
        this.getNetManData();
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
          deleteNet(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getNetManageData();
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
          batchDeleteNet(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getNetManageData();
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
          switch (this.formData.netLevel) {
            case '街道':
              this.formData.netLevel = "0";
              break;
            case '社区':
              this.formData.netLevel = "1";
              break;
            case '小区':
              this.formData.netLevel = "2";
              break;
            case '一级网格':
              this.formData.netLevel = "3";
              break;
            case '二级网格':
              this.formData.netLevel = "4";
              break;
            default:
              break;
          }
          let netListenerStr = "";
          this.netListenerResultArr.map(item => {
            netListenerStr += item + ",";
          });
          this.formData.netListener = netListenerStr;
          if (window.netPid !== undefined && window.netPid !== null && window.netPid !== '') {
            this.formData.netPid = window.netPid;
            let params = {
              "net": this.formData,
              "sysRoleNet": {
                "roleId": localStorage.getItem("roleId"),
              }
            };
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateNet(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getNetManageData();
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
                insertNet(params).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getNetManageData();
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
              type: 'error',
              message: '请选择目录树中的父级网格！'
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
      window.netPid = null;
      viewer.entities.removeAll();
      viewer.scene.primitives.remove(tmpClassificationPrimitive);
      this.fresh = false;
      this.$nextTick(() => {
        this.fresh = true;
      });
    },
    getNetManData() {
      let params = {
        type: "网格长"
      };
      getNetManByType(params).then(res => {
        this.netMasterArr = res.data;
      });
      let params1 = {
        type: "民情联络员"
      };
      getNetManByType(params1).then(res => {
        this.netListenerArr = res.data;
      });
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.netName.indexOf(val)
          || ~item.netLevel.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getNetManageData();
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

.row_display {
  display: flex;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
