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
          <el-button class="header-button" type="primary" icon="el-icon-circle-close" @click="clearData">清 除
          </el-button>
          <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
          </el-button>
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                    class="search-input"></el-input>
          <el-upload
            ref="upload"
            action=""
            :limit="1"
            :file-list="fileList"
            accept=".xlsx, .xls"
            :on-exceed="handleExceed"
            :on-change="onChangeUpload"
            :on-remove="handleRemove"
            :auto-upload="false"
            :show-file-list="true"
            :disabled="isUploading"
            class="header-upload-1"
          >
            <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary" class="header-button-upload">
              选取管线文件
            </el-button>
            <div slot="tip" class="el-upload__tip">
              仅允许导入xls、xlsx格式文件
              <el-link type="primary" :underline="false" style="font-size: 12px; vertical-align: baseline; float: right"
                       :href="downloadUrl1" download="pipeline.xlsx" target="_blank">
                下载模板
              </el-link>
            </div>
          </el-upload>
          <el-upload
            ref="uploadPoint"
            action=""
            :limit="1"
            :file-list="fileListPoint"
            accept=".xlsx, .xls"
            :on-exceed="handleExceedPoint"
            :on-change="onChangeUploadPoint"
            :on-remove="handleRemovePoint"
            :auto-upload="false"
            :show-file-list="true"
            :disabled="isUploadingPoint"
            class="header-upload-2"
          >
            <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary" class="header-button-upload">
              选取管点文件
            </el-button>
            <div slot="tip" class="el-upload__tip">
              仅允许导入xls、xlsx格式文件
              <el-link type="primary" :underline="false" style="font-size: 12px; vertical-align: baseline; float: right"
                       :href="downloadUrl2" download="pipeline_point.xls" target="_blank">
                下载模板
              </el-link>
            </div>
          </el-upload>
          <el-button class="header-button" style="margin:10px 0 50px 420px" type="success" icon="el-icon-upload2"
                     @click="uploadData">
            批量导入
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
          <el-button class="header-button" type="primary" icon="el-icon-circle-close" @click="clearData">清 除
          </el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="pipeId"
                  :default-sort="{prop: 'plName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="管段" prop="plName" sortable></el-table-column>
          <el-table-column label="类型" prop="plType" sortable></el-table-column>
          <el-table-column label="材质" prop="plMaterial" sortable></el-table-column>
          <el-table-column label="载体" prop="plCarry" sortable></el-table-column>
          <el-table-column label="所在区县" prop="plArea" sortable></el-table-column>
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
          <el-form-item label="权属" prop="plPid">
            <ztree :nodes="nodes" :setting="setting" @onCreated="handleCreated"/>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="管段" prop="plName">
              <el-input v-model="formData.plName" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="类型" prop="plType">
              <el-select v-model="formData.plType" placeholder="请选择类别" style="width: 93%">
                <el-option label="给水" value="给水"></el-option>
                <el-option label="排水" value="排水"></el-option>
                <el-option label="燃气" value="燃气"></el-option>
                <el-option label="热力" value="热力"></el-option>
                <el-option label="电力" value="电力"></el-option>
                <el-option label="通信" value="通信"></el-option>
                <el-option label="工业" value="工业"></el-option>
                <el-option label="能源" value="能源"></el-option>
                <el-option label="其他" value="其他"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="类别" prop="plSort">
              <el-input v-model="formData.plSort" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="埋设方式" prop="plBuildingType">
              <el-input v-model="formData.plBuildingType" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="载体" prop="plCarry">
              <el-input v-model="formData.plCarry" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="材质" prop="plMaterial">
              <el-input v-model="formData.plMaterial" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="长度" prop="plLine">
              <el-input v-model="formData.plLine" placeholder="请填写，单位(m)"></el-input>
            </el-form-item>
            <el-form-item label="坡度" prop="plSlope">
              <el-input v-model="formData.plSlope" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="外径" prop="plOutDiameter">
              <el-input v-model="formData.plOutDiameter" placeholder="请填写，单位(mm)"></el-input>
            </el-form-item>
            <el-form-item label="内径" prop="plInDiameter">
              <el-input v-model="formData.plInDiameter" placeholder="请填写，单位(mm)"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="方向" prop="plDirection">
              <el-input v-model="formData.plDirection" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="状态" prop="plState">
              <el-input v-model="formData.plState" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="起点埋深" prop="plDeep">
              <el-input v-model="formData.plDeep" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="终点埋深" prop="plDeepStop">
              <el-input v-model="formData.plDeepStop" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="所在区县" prop="plArea">
              <el-input v-model="formData.plArea" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="管沟权属" prop="plDitchDep">
              <el-input v-model="formData.plDitchDep" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="管线权属" prop="plLineDep">
              <el-input v-model="formData.plLineDep" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="探测单位" prop="plSurveyDep">
              <el-input v-model="formData.plSurveyDep" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="探测时间" prop="plSurveyTime">
              <el-input v-model="formData.plSurveyTime" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="探测人员" prop="plPeople1">
              <el-input v-model="formData.plPeople1" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="过检人员" prop="plPeople2">
              <el-input v-model="formData.plPeople2" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="终检人员" prop="plPeople3">
              <el-input v-model="formData.plPeople3" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="管井类型" prop="plWellType">
              <el-select v-model="formData.plWellType" placeholder="请选择类别" style="width: 93%">
                <el-option label="圆井" value="圆井"></el-option>
                <el-option label="方井" value="方井"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="井盖类型" prop="plCoverType" style="margin-left: -14px">
              <el-select v-model="formData.plCoverType" placeholder="请选择类别" style="width: 93%;">
                <el-option label="污水井盖" value="污水井盖"></el-option>
                <el-option label="污水阀井" value="污水阀井"></el-option>
                <el-option label="篦子" value="篦子"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <el-form-item label="管线坐标" prop="plPos">
            <el-input v-model="formData.plPos" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%" type="textarea" :rows="5"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="addLineToMapHandler"></font-awesome-icon>
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
  deletePipeline,
  getPipeline,
  insertPipeline,
  updatePipeline,
  batchDeletePipeline,
  insertBatchPipeline, getPipelineRoad
} from "../api/api";
import XLSX from "xlsx";
import {stringToNumber, getHeadingPitchRoll, getModelMatrix} from "../js/CesiumTools";

let excelJsonResult = [];
let excelJsonResultPos = [];
let pipelinePrimitiveCollection = new Cesium.PrimitiveCollection();

export default {
  name: "net-pipeline",
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
        plName: [{required: true, message: '请输入', trigger: 'blur'}],
        plType: [{required: true, message: '请输入', trigger: 'blur'}],
        plDeep: [{required: true, message: '请输入', trigger: 'blur'}],
        plDeepStop: [{required: true, message: '请输入', trigger: 'blur'}],
        plPos: [{required: true, message: '请输入', trigger: 'blur'}],
        plPid: [{required: true, message: '请输入', trigger: 'blur'}],
        plWellType: [{required: true, message: '请输入', trigger: 'blur'}],
        plCoverType: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        pipeId: '',
        plName: '',
        plLine: '',
        plOutDiameter: '800',
        plInDiameter: '780',
        plDeep: '2500',
        plMaterial: 'PH-21钢材',
        plType: '给水',
        plSlope: '0.3',
        plDirection: '正',
        plPos: '',
        plSort: '',
        plDeepStop: '2500',
        plBuildingType: '',
        plCarry: '',
        plState: '',
        plArea: '',
        plDitchDep: '',
        plLineDep: '',
        plSurveyDep: '',
        plSurveyTime: '',
        plPeople1: '',
        plPeople2: '',
        plPeople3: '',
        plPid: '',
        plWellType: '圆井',
        plCoverType: '污水井盖'
      },
      fileList: [],
      fileListPoint: [],
      isUploading: false,
      isUploadingPoint: false,
      downloadUrl1: "",
      downloadUrl2: "",
      setting: {},
      ztreeObj: null,
      nodes: [],
    }
  },
  methods: {
    createZTree(data, curId) {
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
          name: "管线权属目录树",
          isNode: false,
          showIcon: false,
          nocheck: false,
          checked: "0" === curId,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].roadId;
        treeObj.pid = data[i].roadPid;
        treeObj.name = data[i].roadName;
        treeObj.checked = data[i].roadId === curId;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function TreeChecked(event, treeId, treeNode) {
        _this.formData.plPid = treeNode.id;
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
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
        _this.formData.plPos = tempPointsStr.substring(0, tempPointsStr.length - 1);
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    addLineToMap(pois, type, deep, deepStop, plWellType, plCoverType, plOutDiameter) {
      if (plWellType === null) plWellType = "圆井";
      if (plCoverType === null) plCoverType = "污水井盖";
      console.log(pois, type, deep, deepStop, plWellType, plCoverType, plOutDiameter);
      this.clearData();
      viewer.scene.screenSpaceCameraController.enableCollisionDetection = false;
      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 0.0, 2000.0, 1.0);
      viewer.scene.globe.translucency.enabled = true;
      CesiumMap.methods.resetTilesetAlpha(0.2);
      let color;
      switch (type) {
        case '给水':
          color = Cesium.Color.fromBytes(0, 255, 255, 255);
          break;
        case '排水':
          color = Cesium.Color.fromBytes(76, 57, 38, 255);
          break;
        case '燃气':
          color = Cesium.Color.fromBytes(255, 0, 255, 255);
          break;
        case '热力':
          color = Cesium.Color.fromBytes(255, 128, 0, 255);
          break;
        case '电力':
          color = Cesium.Color.fromBytes(255, 0, 0, 255);
          break;
        case '通信':
          color = Cesium.Color.fromBytes(0, 255, 0, 255);
          break;
        case '工业':
          color = Cesium.Color.fromBytes(0, 0, 0, 255);
          break;
        case '能源':
          color = Cesium.Color.fromBytes(0, 0, 255, 255);
          break;
        case '其他':
          color = Cesium.Color.fromBytes(102, 0, 204, 255);
          break;
        default:
          color = Cesium.Color.fromBytes(102, 0, 204, 255);
          break;
      }
      let wellCoverUrl = "";
      switch (plCoverType) {
        case "污水井盖":
          wellCoverUrl = 'static/images/well/wellCover1.png';
          break;
        case "污水阀井":
          wellCoverUrl = 'static/images/well/wellCover3.jpg';
          break;
        case "篦子":
          wellCoverUrl = 'static/images/well/wellCover2.jpg';
          break;
        default:
          wellCoverUrl = 'static/images/well/wellCover1.png';
          break;
      }
      //绘制管线
      for (let j = 3; j < pois.length; j = j + 3) {
        let volume = new Cesium.PolylineVolumeGeometry({
          polylinePositions: Cesium.Cartesian3.fromDegreesArrayHeights([
            Number(pois[j - 3]),
            Number(pois[j - 2]),
            Number(pois[j - 1]) - Number(deep) / 1000,
            Number(pois[j]),
            Number(pois[j + 1]),
            Number(pois[j + 2]) - Number(deepStop) / 1000 - Number(plOutDiameter) / 1000
          ]),
          shapePositions: computeCircle(Number(plOutDiameter) / 1000),
        });
        // 定义 Geometry
        let geometry = Cesium.PolylineVolumeGeometry.createGeometry(volume);
        // 定义 GeometryInstance
        let instance = new Cesium.GeometryInstance({
          geometry: geometry,
          id: 'pl' + j,
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(color)
          }
        });
        // Primitive加载
        let primitive = new Cesium.Primitive({
          geometryInstances: instance, // 多个instance组成的集合
          appearance: new Cesium.PerInstanceColorAppearance({
            flat: true,
            translucent: false
          })
        });
        pipelinePrimitiveCollection.add(primitive);

        //绘制管井
        let reHeight = 0.1;
        if (plWellType === "圆井") {
          //管井井体
          let cylinder = new Cesium.CylinderGeometry({
            length: (Number(deepStop) / 1000) + Number(plOutDiameter) / 1000 + reHeight * 1.9,
            topRadius: 0.83,
            bottomRadius: 1.3,
            slices: 64
          });
          const geometry = Cesium.CylinderGeometry.createGeometry(cylinder);
          let instance = new Cesium.GeometryInstance({
            geometry: geometry,
            id: 'wp' + j,
            modelMatrix: Cesium.Matrix4.multiplyByTranslation(
              Cesium.Transforms.eastNorthUpToFixedFrame(Cesium.Cartesian3.fromDegrees(Number(pois[j]), Number(pois[j + 1]))),
              new Cesium.Cartesian3(0.0, 0.0, Number(pois[j + 2]) - (Number(deepStop) / 1000 + Number(plOutDiameter) / 1000) / 2),
              new Cesium.Matrix4()),
          });
          let primitive = new Cesium.Primitive({
            geometryInstances: instance, // 多个instance组成的集合
            appearance: new Cesium.MaterialAppearance({
              material: new Cesium.Material({
                translucent: false,
                fabric: {
                  type: 'Image',
                  uniforms: {
                    image: 'static/images/well/well1.png',
                  },
                }
              }),
              flat: true,
              translucent: false,
              faceForward: true
            })
          });
          pipelinePrimitiveCollection.add(primitive);
          //管井井盖
          let ellipse = new Cesium.EllipseGeometry({
            center: Cesium.Cartesian3.fromDegrees(
              Number(pois[j]), Number(pois[j + 1]),
              Number(pois[j + 2]) - (Number(deepStop) / 1000 + Number(plOutDiameter) / 1000) / 2
            ),
            semiMinorAxis: 0.8,
            semiMajorAxis: 0.8,
            height: Number(pois[j + 2]) + reHeight,
          });
          let geometryE = Cesium.EllipseGeometry.createGeometry(ellipse);
          let instanceE = new Cesium.GeometryInstance({
            geometry: geometryE,
            id: 'we' + j,
          });
          let primitiveE = new Cesium.Primitive({
            geometryInstances: instanceE, // 多个instance组成的集合
            appearance: new Cesium.MaterialAppearance({
              material: new Cesium.Material({
                translucent: false,
                fabric: {
                  type: 'Image',
                  uniforms: {
                    image: wellCoverUrl,
                  },
                }
              }),
              flat: true,
              translucent: false,
              faceForward: true
            })
          });
          pipelinePrimitiveCollection.add(primitiveE);
        } else {
          //管井井体
          let point2Matrix = getModelMatrix(Cesium.Cartesian3.fromDegrees(Number(pois[j - 3]), Number(pois[j - 2]), 0),
            Cesium.Cartesian3.fromDegrees(Number(pois[j]), Number(pois[j + 1]), 0));
          let hpRoll = getHeadingPitchRoll(point2Matrix);
          let hprMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(
            Cesium.Cartesian3.fromDegrees(Number(pois[j]), Number(pois[j + 1]), Number(pois[j + 2]) - (Number(deepStop) / 1000 + Number(plOutDiameter) / 1000) / 2),
            hpRoll,
            Cesium.Ellipsoid.WGS84,
            Cesium.Transforms.eastNorthUpToFixedFrame,
            new Cesium.Matrix4()
          );
          let box = new Cesium.BoxGeometry.fromDimensions({
            vertexFormat: Cesium.VertexFormat.POSITION_AND_NORMAL,
            dimensions: new Cesium.Cartesian3(1.7, 1.7, (Number(deepStop) / 1000) + Number(plOutDiameter) / 1000 + reHeight * 1.9),
          });
          let geometry = Cesium.BoxGeometry.createGeometry(box);
          let instance = new Cesium.GeometryInstance({
            geometry: geometry,
            id: 'wp' + j,
            modelMatrix: hprMatrix,
          });
          let primitive = new Cesium.Primitive({
            geometryInstances: instance, // 多个instance组成的集合
            appearance: new Cesium.MaterialAppearance({
              material: new Cesium.Material({
                translucent: false,
                fabric: {
                  type: 'Image',
                  uniforms: {
                    image: 'static/images/well/well1.png',
                  },
                }
              }),
              flat: true,
              translucent: false,
              faceForward: true
            })
          });
          pipelinePrimitiveCollection.add(primitive);
          //管井井盖
          let hprMatrixPlane = Cesium.Transforms.headingPitchRollToFixedFrame(
            Cesium.Cartesian3.fromDegrees(Number(pois[j]), Number(pois[j + 1]), Number(pois[j + 2]) + reHeight),
            hpRoll,
            Cesium.Ellipsoid.WGS84,
            Cesium.Transforms.eastNorthUpToFixedFrame,
            new Cesium.Matrix4()
          );
          let dimensions = new Cesium.Cartesian3(1.6, 1.6, 1);
          let scaleMatrix = Cesium.Matrix4.fromScale(dimensions);
          let planeModelMatrix = new Cesium.Matrix4();
          Cesium.Matrix4.multiply(hprMatrixPlane, scaleMatrix, planeModelMatrix);

          let plane = new Cesium.PlaneGeometry();
          let geometryE = Cesium.PlaneGeometry.createGeometry(plane);
          let instanceE = new Cesium.GeometryInstance({
            geometry: geometryE,
            id: 'we' + j,
            modelMatrix: planeModelMatrix
          });
          let primitiveE = new Cesium.Primitive({
            geometryInstances: instanceE, // 多个instance组成的集合
            appearance: new Cesium.MaterialAppearance({
              material: new Cesium.Material({
                translucent: false,
                fabric: {
                  type: 'Image',
                  uniforms: {
                    image: wellCoverUrl,
                  },
                }
              }),
              flat: true,
              translucent: false,
              faceForward: true
            })
          });
          pipelinePrimitiveCollection.add(primitiveE);
        }
      }

      function computeCircle(radius) {
        let positions = [];
        for (let i = 0; i < 360; i += 10) {
          let radians = Cesium.Math.toRadians(i);
          positions.push(
            new Cesium.Cartesian2(
              radius * Math.cos(radians),
              radius * Math.sin(radians)
            )
          );
        }
        return positions;
      }

      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(Number(pois[0]), Number(pois[1]), Number(pois[2]) + 1000)
      });
    },
    getPipelineData() {
      this.pictLoading = true;
      getPipeline().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        viewer.scene.primitives.add(pipelinePrimitiveCollection);
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.pipeId;
      this.currentRow = row;
      let pois = stringToNumber(row.plPos);
      this.addLineToMap(pois, row.plType, row.plDeep, row.plDeepStop, row.plWellType, row.plCoverType, row.plOutDiameter);
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
      this.clearData();
      getPipelineRoad().then(res => {
        this.createZTree(res.data, "0");
      });
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        getPipelineRoad().then(res => {
          this.createZTree(res.data, this.currentRow.plPid);
        });
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
            pipeId: this.currentId
          };
          deletePipeline(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getPipelineData();
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
          batchDeletePipeline(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getPipelineData();
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
    clearData() {
      pipelinePrimitiveCollection.removeAll();
      CesiumMap.methods.resetTilesetAlpha(1.0);
      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 1.0, 2000.0, 1.0);
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
              updatePipeline(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getPipelineData();
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
              insertPipeline(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getPipelineData();
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
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    onChangeUpload(file, fileList) {
      this.isUploading = true;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'xlsx' && fileName !== 'xls' && fileName !== 'XLSX' && fileName !== 'XLS') {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是Excel文件!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      //解析excel
      let reader = new FileReader();
      reader.onload = (e) => {
        let data = e.target.result;
        let workbook = XLSX.read(data, {
          type: 'binary',
          cellDates: true,
        });
        let excelJson = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]], {
          defval: null,
          raw: false
        });
        excelJsonResult = dealExcel(excelJson);
        for (let i = 0; i < excelJsonResult.length; i++) {
          let timeArr = excelJsonResult[i].plSurveyTime.split('/');
          let timeStr = "20" + timeArr[2] + "年" + timeArr[0] + "月" + timeArr[1] + "日";
          excelJsonResult[i].plSurveyTime = timeStr;
        }
        this.isUploading = false;
      };
      reader.readAsBinaryString(file.raw);
      this.fileList = fileList;

      function dealExcel(ws) {
        let keymap = {
          "管线编码": "plName",
          "断面尺寸(管径/宽X高(mm))": "plOutDiameter",
          "管线起点埋深(m)": "plDeep",
          "材质": "plMaterial",
          "管线类型": "plType",
          "流向(0/1)": "plDirection",
          "管线类别": "plSort",
          "管线终点埋深(m)": "plDeepStop",
          "埋设方式": "plBuildingType",
          "载体": "plCarry",
          "状态": "plState",
          "所在区县": "plArea",
          "管沟权属": "plDitchDep",
          "管线权属": "plLineDep",
          "探测单位": "plSurveyDep",
          "探测时间": "plSurveyTime",
          "探测人员": "plPeople1",
          "过程检查人员": "plPeople2",
          "最终检查人员": "plPeople3",
          "管线起点编号": "startPointNum",
          "管线终点编号": "endPointNum",
          "管线起点高程(m)": "startPointAlt",
          "管线终点高程(m)": "endPointAlt",
        };
        ws.forEach((sourceObj) => {
          Object.keys(sourceObj).map((keys) => {
            if (keymap[keys]) {
              sourceObj[keymap[keys]] = sourceObj[keys];
              delete sourceObj[keys]
            }
          });
        });
        return ws
      }
    },
    handleRemove(files, fileList) {
      excelJsonResult = [];
      this.fileList = [];
    },
    handleExceedPoint(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    onChangeUploadPoint(file, fileList) {
      this.isUploadingPoint = true;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'xlsx' && fileName !== 'xls' && fileName !== 'XLSX' && fileName !== 'XLS') {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是Excel文件!'
        });
        this.isUploadingPoint = false;
        this.$refs.uploadPoint.clearFiles();
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        this.isUploadingPoint = false;
        this.$refs.uploadPoint.clearFiles();
        return false;
      }
      //解析excel
      let reader = new FileReader();
      reader.onload = (e) => {
        let data = e.target.result;
        let workbook = XLSX.read(data, {
          type: 'binary',
          cellDates: true,
        });
        let excelJson = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]], {
          defval: null,
          raw: false
        });
        excelJsonResultPos = dealExcel(excelJson);
        this.isUploadingPoint = false;
      };
      reader.readAsBinaryString(file.raw);
      this.fileListPoint = fileList;

      function dealExcel(ws) {
        let keymap = {
          "管线点编号": "pointNum",
          "管线点X坐标(m)": "posX",
          "管线点Y坐标(m)": "posY",
        };
        ws.forEach((sourceObj) => {
          Object.keys(sourceObj).map((keys) => {
            if (keymap[keys]) {
              sourceObj[keymap[keys]] = sourceObj[keys];
              delete sourceObj[keys]
            }
          });
        });
        return ws
      }
    },
    handleRemovePoint(files, fileList) {
      excelJsonResultPos = [];
      this.fileListPoint = [];
    },
    //批量上传
    uploadData() {
      if (excelJsonResult.length === 0 || excelJsonResultPos.length === 0
        || this.fileList.length === 0 || this.fileListPoint.length === 0) {
        this.$message({
          type: 'error',
          message: '请选择管线点属性表和管线线属性表！'
        });
        return;
      }
      let pipelineList = [];
      excelJsonResult.map(item => {
        for (let i = 0; i < excelJsonResultPos.length; i++) {
          if (item.startPointNum === excelJsonResultPos[i].pointNum) {
            for (let j = 0; j < excelJsonResultPos.length; j++) {
              if (item.endPointNum === excelJsonResultPos[j].pointNum) {
                // item.plPos = excelJsonResultPos[i].posX + ',' + excelJsonResultPos[i].posY + ',' + (Number(item.startPointAlt) - Number(item.plDeep)) + ',' +
                //   excelJsonResultPos[j].posX + ',' + excelJsonResultPos[j].posY + ',' + (Number(item.endPointAlt) - Number(item.plDeepStop));
                item.plPos = excelJsonResultPos[i].posX + ',' + excelJsonResultPos[i].posY + ',' + item.startPointAlt + ',' +
                  excelJsonResultPos[j].posX + ',' + excelJsonResultPos[j].posY + ',' + item.endPointAlt;
                item.plDeep = 1000 * Number(item.plDeep);
                item.plDeepStop = 1000 * Number(item.plDeepStop);
                pipelineList.push(item);
                break;
              }
            }
          }
        }
      });
      let confirmStr = "您上传的管线总数为" + excelJsonResult.length + ",与管线点匹配成功" + pipelineList.length + ",是否确认上传？";
      this.$confirm(confirmStr, '批量上传', {
        distinguishCancelAndClose: true,
        confirmButtonText: '确认',
        cancelButtonText: '取消'
      }).then(() => {
        insertBatchPipeline(pipelineList).then(res => {
          if (res.data > 0) {
            this.$message({
              type: 'success',
              message: '批量导入成功，返回列表！'
            });
            this.backTable();
            this.getPipelineData();
            excelJsonResult = [];
            excelJsonResultPos = [];
            this.fileList = [];
            this.fileListPoint = [];
            this.$refs.upload.clearFiles();
            this.$refs.uploadPoint.clearFiles();
          } else {
            this.$message({
              type: 'error',
              message: '批量导入失败，请重试！'
            });
          }
        });
      }).catch(action => {
        this.$message({
          type: 'warning',
          message: '放弃上传！'
        });
      });
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.plName.indexOf(val)
          || ~item.plType.indexOf(val)
          || ~item.plMaterial.indexOf(val)
          || ~item.plCarry.indexOf(val)
          || ~item.plArea.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getPipelineData();
    this.downloadUrl1 = common.serverIp + "city3dfile/download/pipeline.xlsx";
    this.downloadUrl2 = common.serverIp + "city3dfile/download/pipeline-point.xls";
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
  width: 90px;
  float: right;
  margin: 0 0 0 10px;
}

.header-upload-1 {
  width: 210px;
  position: absolute;
  top: 128px;
  left: 231px;
}

.header-upload-2 {
  width: 210px;
  position: absolute;
  top: 128px;
  left: 450px;
}

.header-button-upload {
  margin-top: 12px;
  font-size: 14px;
}
</style>
