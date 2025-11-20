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
                  :default-sort="{prop: 'addDate', order: 'descending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="地名地址" prop="addName" sortable></el-table-column>
          <el-table-column label="类型" prop="addType" sortable width="80px"></el-table-column>
          <el-table-column label="社区" prop="net.netName" sortable width="150px"></el-table-column>
          <el-table-column label="录入时间" prop="addDate" sortable width="150px"></el-table-column>
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
          <div class="row_display">
            <el-form-item label="采集时间" prop="addDate">
              <el-date-picker v-model="formData.addDate" align="left" type="date"
                              placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="分类" prop="addType" style="margin-left: -15px">
              <el-select v-model="formData.addType" placeholder="请选择分类" style="width: 93%">
                <el-option label="住宅" value="住宅"></el-option>
                <el-option label="行政" value="行政"></el-option>
                <el-option label="地点" value="地点"></el-option>
                <el-option label="单位" value="单位"></el-option>
                <el-option label="场所" value="场所"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <el-form-item label="绘制分户" prop="floorPoi" style="position: relative; margin-bottom: 5px">
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="drawFloorPoi" title="左键点击地图分户图形坐标，右键结束">
            </font-awesome-icon>
            绘制分户图形
            <font-awesome-icon class="form-fai" :icon="['fas', 'cut']" fixed-width v-show="cutBtnShow"
                               @click="cutFloorPoiHandler"
                               title="仅支持两个交点的裁切，左键拾取点位,右键结束"></font-awesome-icon>
            <span v-show="cutBtnShow">裁切图形</span>
          </el-form-item>
          <div style="position: relative; margin-bottom: 22px">
            <div style="margin-bottom: 5px">
              <el-input readonly style="width: 25%;" size="small" value="分户坐标"></el-input>
              <el-input readonly style="width: 30%;" size="small" value="地址前缀"></el-input>
              <el-input readonly style="width: 10%;" size="small" value="门号"></el-input>
              <el-input readonly style="width: 25%;" size="small" value="重心坐标"></el-input>
            </div>
            <div v-for="(item,index) in floorPoiInputArr" :key="index" style="margin-bottom: 5px">
              <el-input type="textarea" v-model="item.floorPoi" :autosize="{minRows: 2, maxRows: 2}"
                        style="width: 25%;" placeholder="">
              </el-input>
              <el-input type="textarea" v-model="item.addName" :autosize="{minRows: 2, maxRows: 2}"
                        style="width: 30%;" placeholder="">
              </el-input>
              <el-input :id="'roomNum'+index" type="textarea" v-model="item.roomNum"
                        :autosize="{minRows: 2, maxRows: 2}"
                        style="width: 10%;" placeholder="">
              </el-input>
              <el-input type="textarea" v-model="item.poi" :autosize="{minRows: 2, maxRows: 2}"
                        style="width: 25%" placeholder=""></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'map-pin']" fixed-width
                                 @click="drawFloorCenter(index)"
                                 title="请左键地图点选、右键结束或填写点位坐标值"></font-awesome-icon>
            </div>
          </div>
          <el-form-item label="拾取分层" prop="floorHeight" style="position: relative;">
            <el-input type="textarea" v-model="formData.floorHeight" :autosize="{minRows: 2, maxRows: 10}"
                      style="width: 90%"
                      placeholder="左键选中高度，右键结束。从下向上依次划分楼层。每次选定的高度为该层的底面高度，最后一次要选定最高层顶面高度，尽量选择建筑物凸起最高点">
            </el-input>
            <font-awesome-icon class="form-fai icon_position_up" :icon="['fab', 'buffer']" fixed-width
                               @click="drawFloorHeight" title="左键拾取点位,右键结束"></font-awesome-icon>
            <font-awesome-icon class="form-fai icon_position_down" :icon="['fas', 'globe-asia']" fixed-width
                               @click="createFloorPreview" title="预览分层分户"></font-awesome-icon>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="楼层数" prop="addFloor">
              <el-input v-model="formData.addFloor" style="width: 100%"></el-input>
            </el-form-item>
            <el-form-item label="楼层高" prop="addFloorHeight" style="margin-left:15px;">
              <el-input v-model="formData.addFloorHeight" style="width: 100%"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="初始层" prop="startFloor">
              <el-input v-model="formData.startFloor" style="width: 100%"></el-input>
            </el-form-item>
            <el-form-item label="相机坐标" prop="camPoi" style="margin-left:15px;">
              <el-input v-model="formData.camPoi" style="width: 100%"></el-input>
            </el-form-item>
          </div>
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
  batchDeleteAddress,
  deleteAddress,
  getAddress,
  insertAddress,
  queryNetData,
  updateAddress,
  getNetInfoById, getAllandNetById
} from "../api/api";
import "../js/CesiumFloor.js";
import {geoUtil} from "../js/GeojsonClip";

let drawpointArr = [];
let floorHeightDrawArr = [];
let addMarkArr = [];
let clipPolygondrawHandler;
let lineDrawMarkArr = [];
let clipPolygonArr = [];
export default {
  name: "real-address",
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
      floorPoiInputArr: [
        {
          floorPoi: "",
          addName: "xx市xx区xx小区xx栋xx单元",
          roomNum: "01",
          poi: "",
          addMultiFloorPosArr: [],
          addFloorArr: []
        },
      ],
      cutBtnShow: true,
      multipleSelection: [],
      rules: {
        floorHeight: [{required: true, message: '请输入', trigger: 'blur'}],
        addFloor: [{required: true, message: '请输入', trigger: 'blur'}],
        addFloorHeight: [{required: true, message: '请输入', trigger: 'blur'}],
        camPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        camHeading: [{required: true, message: '请输入', trigger: 'blur'}],
        camPitch: [{required: true, message: '请输入', trigger: 'blur'}],
        startFloor: [{required: true, message: '请输入', trigger: 'blur'}],
        addType: [{required: true, message: '请输入', trigger: 'blur'}],
        pid: [{required: true, message: '请输入', trigger: 'blur'}],
        addDate: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        addId: "",
        addName: "xx市xx区xx小区xx栋xx单元",
        floorPoi: "",
        floorHeight: "",
        addFloor: "1",
        addFloorHeight: "2.6",
        poi: "",
        camPoi: "",
        camHeading: "",
        camPitch: "",
        roomNum: "01",
        startFloor: "1",
        addType: "住宅",
        pid: "",
        addDate: (new Date()).pattern("yyyy-MM-dd"),
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
      getAddress().then((res) => {
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
      let camPoiArr = row.camPoi.split(',');
      CesiumMap.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), row.camHeading, row.camPitch);
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
      this.cutBtnShow = true;
    },
    editData() {
      if (this.currentId !== "") {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.floorPoiInputArr[0].floorPoi = this.currentRow.floorPoi;
        this.floorPoiInputArr[0].addName = this.currentRow.addName;
        this.floorPoiInputArr[0].poi = this.currentRow.poi;
        this.ztreeObj.checkNode(this.ztreeObj.getNodeByParam("id", this.currentRow.pid), true);
        this.cutBtnShow = false;
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
      let _this = this;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              let params = this.formData;
              params.addName = this.floorPoiInputArr[0].addName;
              params.poi = this.floorPoiInputArr[0].addMultiFloorPosArr[0];
              params.addDate = new Date(params.addDate).toLocaleDateString().replace(/\//g, '-');
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
                message: '请完善信息！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              let floorheightArr = this.formData.floorHeight.split(",");
              this.floorPoiInputArr.map((item, index) => {
                for (let i = 0; i < floorheightArr.length - 2; i++) {
                  let floorHeight = floorheightArr[i] + "," + floorheightArr[i + 1] + ",";
                  let params = this.formData;
                  params.addName = item.addName + item.addFloorArr[i];
                  params.floorPoi = item.floorPoi;
                  params.floorHeight = floorHeight;
                  params.poi = item.addMultiFloorPosArr[i];
                  params.addDate = new Date(params.addDate).toLocaleDateString().replace(/\//g, '-');
                  insertAddress(params).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                    } else if (res.data === 2) {
                      this.$message({
                        type: 'error',
                        message: '地址重复，新增失败，请重试！'
                      });
                    } else {
                      this.$message({
                        type: 'error',
                        message: '新增失败，请重试！'
                      });
                    }
                  });
                }
                if (index === this.floorPoiInputArr.length - 1) {
                  setTimeout(() => {
                    _this.backTable();
                    _this.init();
                  }, 3000);
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
      this.formData.addFloor = "1";
      this.formData.addFloorHeight = "2.6";
      this.formData.startFloor = "1";
      this.formData.addType = "住宅";
      this.formData.addDate = (new Date()).pattern("yyyy-MM-dd");
      this.floorPoiInputArr = [{
        floorPoi: "",
        addName: "xx市xx区xx小区xx栋xx单元",
        roomNum: "01",
        poi: "",
        addMultiFloorPosArr: [],
        addFloorArr: []
      }];
    },
    backTable() {
      this.isTableShow = true;
      this.removeFloor();
      this.clearDrawFloorPoi();
      this.clearFloorCenter();
      this.clearClipLine();
      this.floorPoiInputArr = [{
        floorPoi: "",
        addName: "xx市xx区xx小区xx栋xx单元",
        roomNum: "01",
        poi: "",
        addMultiFloorPosArr: [],
        addFloorArr: []
      }];
    },
    //回显分层分户单体化结构和重心点
    addAddressToMap(data) {
      viewer.entities.removeById("addAddressToMap");
      if (data.poi !== null && data.poi !== '') {
        let position = data.poi.split(',');
        viewer.entities.add({
          id: "addAddressToMap",
          position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
          ellipsoid: {
            radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
            material: Cesium.Color.YELLOW.withAlpha(0.7)
          }
        });
      }
      CesiumFloor.removeFloor(viewer);
      if (data.floorPoi !== null && data.floorPoi !== '') {
        let options = {
          'viewer': viewer,
          'floorPoi': data.floorPoi,
          'floorHeight': data.floorHeight,
        };
        CesiumFloor.showFloor(options);
      }
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
          _this.floorPoiInputArr[0].floorPoi = tempPointsStr.substring(0, tempPointsStr.length - 1);
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
        _this.formData.floorHeight = tempHeight;
        _this.formData.addFloor = floorHeightDrawArr.length - 1;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    //预览分层分户
    createFloorPreview() {
      let _this = this;
      _this.removeFloor();
      _this.clearClipLine();
      _this.clearDrawFloorPoi();

      let camPoiR = viewer.camera.position;
      let camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
      let camHeading = viewer.camera.heading;
      let camPitch = viewer.camera.pitch;
      _this.formData.camPoi = camPoi;
      _this.formData.camHeading = camHeading;
      _this.formData.camPitch = camPitch;

      let heightArr = _this.formData.floorHeight.split(',');
      if (heightArr.length > 2) {
        _this.floorPoiInputArr.map(item => {
          let options = {
            'viewer': viewer,
            'floorPoi': item.floorPoi,
            'floorHeight': _this.formData.floorHeight,
          };
          CesiumFloor.showFloor(options);
        });
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
    //绘制分层分户中心点
    drawFloorCenter(index) {
      if (this.formData.floorHeight === "") {
        this.$message({
          message: '请先拾取分层点！',
          type: 'error'
        });
        return;
      }
      this.$confirm('请先修改门号，重心绘制后无法修改', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '开始绘制重心!'
        });
        document.getElementById("roomNum" + index).readOnly = true;
        document.getElementById("roomNum" + index).style.backgroundColor = "#aaaaaa";
        let _this = this;
        _this.clearFloorCenter();
        let addMarkHandler = addMarkHandler && addMarkHandler.destroy();
        addMarkHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        addMarkHandler.setInputAction(function (movement) {
          let lng, lat, height, poiStr;
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
            poiStr = lng + ',' + lat + ',' + height;
            _this.floorPoiInputArr[index].poi = poiStr;
          }
          //创建标注
          let pinBuilder = new Cesium.PinBuilder();

          let floor = _this.formData.addFloor;
          if (floor !== null || floor !== '') {
            let floorHeihgt = _this.formData.addFloorHeight !== '' ? Number(_this.formData.addFloorHeight) : 2.6;
            let addUnit = _this.floorPoiInputArr[index].roomNum;
            let addStartFloor = Number(_this.formData.startFloor);
            _this.floorPoiInputArr[index].addMultiFloorPosArr = [];
            _this.floorPoiInputArr[index].addFloorArr = [];
            for (let i = 0; i < Number(floor); i++) {
              let pos = Cesium.Cartesian3.fromDegrees(lng, lat, height + i * floorHeihgt);
              let posStr = lng.toString() + "," + lat.toString() + "," + (height + i * floorHeihgt).toString();
              _this.floorPoiInputArr[index].addMultiFloorPosArr.push(posStr);
              addMarkArr.push(viewer.entities.add({
                position: pos,
                billboard: {
                  image: pinBuilder.fromText(index, Cesium.Color.BLUE, 36).toDataURL(),
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM
                },
                ellipsoid: {
                  radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
                  material: Cesium.Color.BLUE.withAlpha(0.7)
                }
              }));
              if (Number(addUnit) < 10) {
                addUnit = "0" + Number(addUnit);
              }
              _this.floorPoiInputArr[index].poi = poiStr;
              let addfloor = (addStartFloor + i).toString() + addUnit;
              _this.floorPoiInputArr[index].addFloorArr.push(addfloor);
            }
          } else {
            _this.$message({
              message: '请先输入该单元的楼层数！',
              type: 'error'
            });
          }
          addMarkHandler = addMarkHandler && addMarkHandler.destroy();
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '停止绘制！'
        });
      });
    },
    clearFloorCenter() {
      for (let j = 0; j < addMarkArr.length; j++) {
        viewer.entities.remove(addMarkArr[j]);
      }
      addMarkArr = [];
    },
    cutFloorPoiHandler() {
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
        lineDrawMarkArr.push(viewer.entities.add({
          position: carPoi,
          point: {
            pixelSize: 10,
            color: Cesium.Color.ORANGE,
            disableDepthTestDistance: 50000,
            outlineWidth: 2,
            outlineColor: Cesium.Color.WHITE.withAlpha(1)
          },
        }));
      }

      let measureLinePositonsArray = [];//存储已量测的线段的折点
      clipPolygondrawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      clipPolygondrawHandler.setInputAction(function (movement) {
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
      clipPolygondrawHandler.setInputAction(function (movement) {
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
      clipPolygondrawHandler.setInputAction(function () {
        _this.clearClipLine();
        for (let i = 0; i < drawpointArr.length; i++) {
          viewer.entities.remove(drawpointArr[i]);
        }
        drawpointArr = [];

        let curFloorPoiInputArr = [];
        for (let n = 0; n < _this.floorPoiInputArr.length; n++) {
          let polygonjson = {
            geometry: {type: "Polygon", coordinates: [[]]},
            type: "Feature"
          };
          let polygonArr = _this.floorPoiInputArr[n].floorPoi.split(',');
          for (let i = 0; i < polygonArr.length; i += 3) {
            polygonjson.geometry.coordinates[0].push([Number(polygonArr[i]), Number(polygonArr[i + 1])]);
          }
          polygonjson.geometry.coordinates[0].push([Number(polygonArr[0]), Number(polygonArr[1])]);
          let clipLinejson = {
            geometry: {type: "LineString", coordinates: []},
            properties: {},
            type: "Feature"
          };
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitude = Number(Cesium.Math.toDegrees(cartographic.longitude));
            let latitude = Number(Cesium.Math.toDegrees(cartographic.latitude));
            clipLinejson.geometry.coordinates.push([longitude, latitude]);
          }
          let clippedPolygon = geoUtil.polygonClipByLine(polygonjson, clipLinejson);
          let colorArr = [Cesium.Color.YELLOW.withAlpha(0.5), Cesium.Color.GREEN.withAlpha(0.5)];
          let pinBuilder = new Cesium.PinBuilder();
          if (clippedPolygon.features) {
            for (let i = 0; i < clippedPolygon.features.length; i++) {
              let degreesStr = '';
              let degreesArr = [];
              let coordArr = clippedPolygon.features[i].geometry.coordinates[0];
              for (let j = 0; j < coordArr.length; j++) {
                let x = coordArr[j][0];
                let y = coordArr[j][1];
                degreesArr.push(x, y);
                degreesStr += x + ',' + y + ',' + polygonArr[2] + ',';
                drawpointArr.push(viewer.entities.add({
                  position: Cesium.Cartesian3.fromDegrees(x, y, polygonArr[2]),
                  point: {
                    color: Cesium.Color.RED,
                    pixelSize: 10,
                    outlineWidth: 1,
                    outlineColor: Cesium.Color.WHITE,
                    disableDepthTestDistance: 100
                  },
                }));
              }
              degreesStr = degreesStr.substring(0, degreesStr.length - 1);
              clipPolygonArr.push(viewer.entities.add({
                position: Cesium.Cartesian3.fromDegrees(degreesArr[0], degreesArr[1], polygonArr[2]),
                polygon: {
                  hierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArray(degreesArr)),
                  material: new Cesium.ColorMaterialProperty(colorArr[i]),
                  classificationType: Cesium.ClassificationType.BOTH,
                },
                billboard: {
                  image: pinBuilder.fromText(i + 1, Cesium.Color.BLUE, 36).toDataURL(),
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM
                },
              }));
              curFloorPoiInputArr.push({
                floorPoi: degreesStr,
                addName: "xx市xx区xx小区xx栋xx单元",
                roomNum: "01",
                poi: ""
              },);
            }
          } else {
            curFloorPoiInputArr.push(_this.floorPoiInputArr[n]);
            let degreesArr = _this.floorPoiInputArr[n].floorPoi.split(",");
            clipPolygonArr.push(viewer.entities.add({
              position: Cesium.Cartesian3.fromDegrees(degreesArr[0], degreesArr[1], polygonArr[2]),
              polygon: {
                hierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(degreesArr)),
                material: new Cesium.ColorMaterialProperty(Cesium.Color.BLUE.withAlpha(0.5)),
                classificationType: Cesium.ClassificationType.BOTH,
              },
              billboard: {
                image: pinBuilder.fromText(curFloorPoiInputArr.length, Cesium.Color.BLUE, 36).toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM
              },
            }));
          }
        }
        _this.floorPoiInputArr = curFloorPoiInputArr;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    clearClipLine() {
      clipPolygondrawHandler = clipPolygondrawHandler && clipPolygondrawHandler.destroy();
      if (viewer.entities.getById('dynamicLineGroundEntity')) {
        viewer.entities.removeById('dynamicLineGroundEntity');
      }
      if (viewer.entities.getById('measureLineGroundEntity')) {
        viewer.entities.removeById('measureLineGroundEntity');
      }
      for (let i = 0; i < lineDrawMarkArr.length; i++) {
        viewer.entities.remove(lineDrawMarkArr[i]);
      }
      lineDrawMarkArr = [];
      clipPolygonArr.map(item => {
        viewer.entities.remove(item);
      });
      clipPolygonArr = [];
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.addName.indexOf(val)
          || ~item.addType.indexOf(val)
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
};
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
  right: 10px;
}

.icon_position_down {
  position: absolute;
  top: 34px;
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
