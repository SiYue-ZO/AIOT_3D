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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="layoutId"
                  :default-sort="{prop: 'layoutName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="户型地址" prop="layoutName" sortable></el-table-column>
          <el-table-column label="社区" prop="net.netName" sortable width="150px"></el-table-column>
        </el-table>
        <el-pagination class="my-pagination" @size-change="handleSizeChange" @current-change="handleCurrentChange"
                       :current-page="currentPage" :page-sizes="[5, 10, 20, 40]" :page-size="pagesize" :pager-count="5"
                       layout="total, sizes, prev, pager, next, jumper" :total="tableDate.length">
        </el-pagination>
      </div>
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
          <el-form-item label="所属网格" prop="pid">
            <ztree :nodes="nodes" :setting="setting" @onCreated="handleCreated"/>
          </el-form-item>
          <el-form-item label="建筑轮廓" prop="layoutPos">
            <el-input type="textarea" v-model="formData.layoutPos" :autosize="{minRows: 2, maxRows: 10}"
                      style="width: 90%"
                      placeholder="左键选取坐标，右键结束。">
            </el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="drawFloorPoi" title="左键点击地图分户图形坐标，右键结束">
            </font-awesome-icon>
          </el-form-item>
          <el-form-item label="拾取分层" prop="layoutHeight" style="position: relative;">
            <el-input type="textarea" v-model="formData.layoutHeight" :autosize="{minRows: 2, maxRows: 10}"
                      style="width: 90%"
                      placeholder="左键选中高度，右键结束。从下向上依次划分楼层。每次选定的高度为该层的底面高度，最后一次要选定最高层顶面高度，尽量选择建筑物凸起最高点">
            </el-input>
            <font-awesome-icon class="form-fai icon_position_up" :icon="['fab', 'buffer']" fixed-width
                               @click="drawFloorHeight" title="左键拾取点位,右键结束"></font-awesome-icon>
            <font-awesome-icon class="form-fai icon_position_down" :icon="['fas', 'globe-asia']" fixed-width
                               @click="createFloorPreview" title="预览分层分户"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="户型图形" prop="layoutFloor">
            <el-input type="textarea" v-model="formData.layoutFloor" :autosize="{minRows: 2, maxRows: 10}"
                      style="width: 90%"
                      placeholder="左键选取坐标，右键结束。">
            </el-input>
            <font-awesome-icon class="form-fai icon_position_up" :icon="['fas', 'map-pin']" fixed-width
                               @click="drawLayoutFloorPoi" title="左键点击地图分户图形坐标，右键结束">
            </font-awesome-icon>
            <font-awesome-icon class="form-fai icon_position_down" :icon="['fas', 'stop']" fixed-width
                               @click="stopDrawLayoutFloorPoi" title="停止绘制">
            </font-awesome-icon>
          </el-form-item>
          <el-form-item label="建筑地址" prop="layoutName">
            <el-input v-model="formData.layoutName" style="width: 90%"
                      placeholder="请先选取地址，自动截取建筑地址，特殊地址请手动订正截取"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'search']" fixed-width @click="searchAddress"
                               title="检索各楼层地址">
            </font-awesome-icon>
          </el-form-item>
          <AddressTree></AddressTree>
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
import AddressTree from "../utils/components/address-tree";
import ztree from "vue-giant-tree";
import {
  getAddressById,
  queryNetData,
  getLayout,
  batchDeleteLayout,
  deleteLayout,
  insertLayout,
  updateLayout, getAllandNetById
} from "../api/api";
import "../js/CesiumFloor.js";
import "../js/CesiumLayout.js";

let drawpointArr = [];
let floorHeightDrawArr = [];
let pinArr = [];
let handler;
export default {
  name: "city-building",
  components: {CesiumMap, ztree, AddressTree},
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
        layoutPos: [{required: true, message: '请输入', trigger: 'blur'}],
        layoutFloor: [{required: true, message: '请输入', trigger: 'blur'}],
        layoutHeight: [{required: true, message: '请输入', trigger: 'blur'}],
        layoutName: [{required: true, message: '请输入', trigger: 'blur'}],
        pid: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        layoutId: "",
        layoutPos: "",
        layoutFloor: "",
        layoutName: "",
        layoutHeight: "",
        pid: "",
        addId: "",
      },
    };
  },
  methods: {
    getLayoutData(res) {
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
      }
    },
    init() {
      this.pictLoading = true;
      getLayout().then((res) => {
        this.getLayoutData(res);
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
      this.currentId = row.layoutId;
      this.currentRow = row;
      let camPoiArr = row.layoutPos.split(',');
      CesiumMap.methods.flyToLocation([Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]) + 200]);
      this.addLayoutToMap(row);
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
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    deleteData() {
      if (this.currentId !== "") {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          let params = {
            layoutId: this.currentId,
          };
          deleteLayout(params).then((res) => {
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
          batchDeleteLayout(this.multipleSelection).then((res) => {
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
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              let params = this.formData;
              updateLayout(params).then(res => {
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
                message: '请完善信息！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              let params = this.formData;
              insertLayout(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.init();
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
                message: '新增失败，请重试！'
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
      this.removeFloor();
      this.clearDrawFloorPoi();
      this.clearLayoutFloorPoi();
      window.addressId = "";
    },
    backTable() {
      this.isTableShow = true;
      this.removeFloor();
      this.clearDrawFloorPoi();
      this.clearLayoutFloorPoi();
      window.addressId = "";
    },
    //回显室内户型结构
    addLayoutToMap(data) {
      this.removeFloor();
      this.clearDrawFloorPoi();
      this.clearLayoutFloorPoi();

      //回显分层分户
      if (data.layoutPos !== null && data.layoutPos !== '') {
        let options = {
          'viewer': viewer,
          'floorPoi': data.layoutPos,
          'floorHeight': data.layoutHeight,
        };
        CesiumFloor.showFloor(options);
      }

      let layoutHeightArr = data.layoutHeight.split(',');
      let height = Number(layoutHeightArr[layoutHeightArr.length - 2]) + 5;
      //回显地板和外墙
      let options = {
        'viewer': viewer,
        'layoutPos': data.layoutPos,
        'height': height,
        'color': Cesium.Color.WHITE,
        'outColor': Cesium.Color.WHITE
      };
      CesiumLayout.showWall(options);

      //回显室内墙体
      let walloptions = {
        'viewer': viewer,
        'layoutFloor': data.layoutFloor,
        'height': height,
        'color': Cesium.Color.WHITE,
        'outColor': Cesium.Color.WHITE
      };
      CesiumLayout.showLayout(walloptions);
    },
    //绘制分户坐标
    drawFloorPoi() {
      let _this = this;
      _this.clearDrawFloorPoi();
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
        let tempPointsStr = "";
        if (activeShapePointsgeo.length > 2) {
          for (let pindex = 0; pindex < activeShapePointsgeo.length; pindex++) {
            let longitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].longitude);
            let latitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].latitude);
            let heightString = activeShapePointsgeo[pindex].height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          _this.formData.layoutPos = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        let ipoint = viewer.entities.add({
          position: worldPosition,
          point: {
            color: Cesium.Color.RED,
            pixelSize: 10,
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE,
          },
        });
        drawpointArr.push(ipoint);
      }

      function drawPolygon() {
        if (viewer.entities.getById("areaEntity") !== undefined) {
          viewer.entities.removeById("areaEntity");
        }
        viewer.entities.add({
          id: "areaEntity",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            material: new Cesium.ColorMaterialProperty(Cesium.Color.RED.withAlpha(0.2)),
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      }
    },
    // 删除分户图形
    clearDrawFloorPoi() {
      for (let i = 0; i < drawpointArr.length; i++) {
        viewer.entities.remove(drawpointArr[i]);
      }
      drawpointArr = [];
      if (viewer.entities.getById("areaEntity")) {
        viewer.entities.removeById("areaEntity");
      }
    },
    //拾取分层点
    drawFloorHeight() {
      let _this = this;
      let tempHeight = "";
      let handler = handler && handler.destroy();
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let cartesian = viewer.scene.pickPosition(movement.position);//获取鼠标点击处的坐标
        if (Cesium.defined(cartesian)) {
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let testheight = cartographic.height;
          if (Number(testheight) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            cartesian = viewer.scene.globe.pick(ray, viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          tempHeight += height + ',';

          floorHeightDrawArr.push(viewer.entities.add({
            position: cartesian,
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.4, 0.4, 0.4),
              material: Cesium.Color.RED.withAlpha(0.8)
            }
          }));
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
        _this.formData.layoutHeight = tempHeight;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    //预览分层分户
    createFloorPreview() {
      this.removeFloor();
      this.clearDrawFloorPoi();

      let heightArr = this.formData.layoutHeight.split(',');
      if (heightArr.length > 2) {
        let options = {
          'viewer': viewer,
          'floorPoi': this.formData.layoutPos,
          'floorHeight': this.formData.layoutHeight,
        };
        CesiumFloor.showFloor(options);
      } else {
        this.$message({
          message: '请至少确定两个楼层分隔点！',
          type: 'warning'
        });
      }
    },
    // 清除地图中所有实体
    removeFloor() {
      CesiumFloor.removeFloor(viewer);
      for (let j = 0; j < floorHeightDrawArr.length; j++) {
        viewer.entities.remove(floorHeightDrawArr[j]);
      }
      floorHeightDrawArr = [];
    },
    //绘制室内户型的线框结构
    drawLayoutFloorPoi() {
      if (handler) {
        return;
      }
      //生成地板和外墙
      let layoutHeightArr = this.formData.layoutHeight.split(',');
      let height = Number(layoutHeightArr[layoutHeightArr.length - 2]) + 5;
      let options = {
        'viewer': viewer,
        'layoutPos': this.formData.layoutPos,
        'height': height,
        'color': Cesium.Color.WHITE,
        'outColor': Cesium.Color.WHITE
      };
      CesiumLayout.showWall(options);

      let isFirst = true;//是否为第一个点
      let previousPosition;//前一个点的坐标
      let currentPosition;//当前点坐标
      let dynamicLineGroundEntity = viewer.entities.add({
        id: 'dynamicLineGroundEntity',
        polyline: {
          width: 3,
          material: Cesium.Color.RED,
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
        pinArr.push(viewer.entities.add({
          position: carPoi,
          point: {
            pixelSize: 10,
            color: Cesium.Color.RED,
            disableDepthTestDistance: 5000000,
            outlineWidth: 2,
            outlineColor: Cesium.Color.WHITE
          },
        }));
      }

      let measureLinePositonsArray = [];//存储已量测的线段的折点
      let _this = this;
      let tempPos = "";
      handler = handler && handler.destroy();
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let cartesian = viewer.scene.pickPosition(movement.position);//获取鼠标点击处的坐标
        if (Cesium.defined(cartesian)) {
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
          let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
          let heightString = cartographic.height;
          tempPos += longitudeString + "," + latitudeString + "," + heightString + ",";

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
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
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
      handler.setInputAction(function (movement) {
        if (tempPos !== "") {
          _this.formData.layoutFloor += tempPos + '+';

          //显示单个户型图形
          let options = {
            'viewer': viewer,
            'layoutFloor': tempPos,
            'height': height,
            'color': Cesium.Color.WHITE,
            'outColor': Cesium.Color.WHITE
          };
          CesiumLayout.showSingleLayout(options);

          tempPos = "";
          viewer.entities.remove(dynamicLineGroundEntity);
          viewer.entities.remove(measureLineGroundEntity);
          dynamicLineGroundEntity = viewer.entities.add({
            id: 'dynamicLineGroundEntity',
            polyline: {
              width: 3,
              material: Cesium.Color.RED,
            }
          });
          //已输入的线段的entity
          measureLineGroundEntity = viewer.entities.add({
            id: 'measureLineGroundEntity',
            polyline: {
              width: 3,
              material: Cesium.Color.YELLOW,
            }
          });
          isFirst = true;
          measureLinePositonsArray = [];
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    stopDrawLayoutFloorPoi() {
      handler = handler && handler.destroy();
      viewer.entities.removeById("dynamicLineGroundEntity");
      viewer.entities.removeById("measureLineGroundEntity");
    },
    clearLayoutFloorPoi() {
      this.stopDrawLayoutFloorPoi();
      pinArr.map(item => {
        viewer.entities.remove(item);
      });
      pinArr = [];
      CesiumLayout.clearLayout(viewer);
    },
    searchAddress() {
      if (window.addressId === "") {
        this.$message.error("请选择地名地址！");
        return;
      }
      let params = {
        addId: window.addressId
      };
      getAddressById(params).then(res => {
        if (res.data.addName !== "") {
          let addName = "";
          if (res.data.addName.lastIndexOf("栋") > 0) {
            addName = res.data.addName.substring(0, res.data.addName.lastIndexOf("栋") + 1);
          } else if (res.data.addName.lastIndexOf("楼") > 0) {
            addName = res.data.addName.substring(0, res.data.addName.lastIndexOf("楼") + 1);
          } else {
            addName = res.data.addName;
          }
          this.formData.layoutName = addName;
        } else {
          this.$message.error("地名地址为空！");
        }
      });
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.layoutName.indexOf(val)
          || ~item.net.netName.indexOf(val)
        )
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
  overflow-x: hidden;
  font-size: 15px !important;
}

.row_display {
  display: flex;
}

.icon_position_up {
  position: absolute;
  top: 2px;
  right: 20px;
}

.icon_position_down {
  position: absolute;
  top: 34px;
  right: 20px;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
