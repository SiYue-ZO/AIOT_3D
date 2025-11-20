<template>
  <div id="demo-pipeline-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="clipTiles" title="开挖分析">
      <font-awesome-icon :icon="['fas', 'cut']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <span class="emer-row-label">三维透明度</span>
      <el-slider class="emer-slider" v-model="alpha" :format-tooltip="formatTooltip" @change="setAlpha"></el-slider>
      <el-checkbox class="fade-check" v-model="checked" @change="setFadeAlpha">渐变透明</el-checkbox>
    </div>
    <div class="emer-row">
      <div class="ztree_pipe">
        <ztree :nodes="nodes" :setting="setting"/>
      </div>
    </div>
  </div>
</template>

<script>
import map3d from "./map-3d";
import "../js/CesiumPop.js";
import popUtil from "@/utils/pop/popUtil";
import {
  getPipeline,
  getPipelineById,
  getPipelineByPlName,
  getPipelineCheck,
  getPipelineCheckByAdd,
  getPipelineRoad
} from "../api/api";
import ztree from "vue-giant-tree";
import {getHeadingPitchRoll, getModelMatrix} from "../js/CesiumTools";

let pl_overlays3D = [];
let wp_overlays3D = [];
let preColor;
let prePlId;
let pointArr = [];
let handler = handler && handler.destroy();
let clipPos = [];

export default {
  name: "demo-pipeline",
  components: {
    ztree
  },
  data() {
    return {
      alpha: 100,
      checked: true,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      pictLoading: false,
      queryResult: [],
      setting: {},
      nodes: [],
    }
  },
  methods: {
    //滚动条的数值显示
    formatTooltip(val) {
      return val / 100;
    },
    //通过滚动条设置透明度
    setAlpha() {
      map3d.methods.resetTilesetAlpha(this.alpha / 100);
      let alpha = Number(this.alpha / 100);
      alpha = !isNaN(alpha) ? alpha : 1.0;
      alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);

      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, alpha, 2000.0, this.checked ? 1.0 : alpha);
      viewer.scene.globe.translucency.enabled = true;
    },
    //设置地形的渐变透明度
    setFadeAlpha() {
      map3d.methods.resetTilesetAlpha(this.alpha / 100);
      let alpha = Number(this.alpha / 100);
      alpha = !isNaN(alpha) ? alpha : 1.0;
      alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);

      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, alpha, 2000.0, this.checked ? 1.0 : alpha);
      viewer.scene.globe.translucency.enabled = true;
    },
    //显示该行信息气泡
    showCheckInfo(row) {
      if (prePlId) {
        CesiumPop.removeDivPopById(viewer, prePlId.substring(2));
      }
      prePlId = 'pl' + row.pipeId;
      // let params = {
      //   'plName': row.checkAdd
      // };
      // getPipelineByPlName(params).then(res => {
      //   let data = res.data[0];
      //   let popoptions = {
      //     popId: data.pipeId,
      //     pldata: res.data[0],
      //     ckdata: row
      //   };
      //   popUtil.installMapPop().plPop(popoptions);
      //   let addArr = res.data[0].plPos.split(',');
      //   let options = {
      //     "viewer": viewer,
      //     "id": data.pipeId,
      //     "popupWidth": 477,
      //     "popupHeight": 323,
      //     "pos": {
      //       "lon": Number(addArr[9]),
      //       "lat": Number(addArr[10]),
      //       "alt": Number(addArr[11])
      //     },
      //     "extentHeight": 0,
      //     "extentColor": Cesium.Color.WHITE,
      //   };
      //   CesiumPop.addDivPop(options, 'h');
      //   map3d.methods.flyToLocation([Number(addArr[9]), Number(addArr[10]), Number(addArr[11]) + 500]);
      //
      //   if (viewer.entities.getById(prePlId)) {
      //     viewer.entities.getById(prePlId).polylineVolume.material = preColor;
      //     CesiumPop.removeDivPopById(viewer, prePlId.substring(2));
      //   }
      //   preColor = viewer.entities.getById('pl' + data.pipeId).polylineVolume.material;
      //   viewer.entities.getById('pl' + data.pipeId).polylineVolume.material = Cesium.Color.GREEN;
      //   prePlId = 'pl' + data.pipeId;
      // });

      let popoptions = {
        popId: row.pipeId,
        pldata: row,
        // ckdata: row
      };
      popUtil.installMapPop().plPop(popoptions);
      let options = {
        "viewer": viewer,
        "id": row.pipeId,
        "popupWidth": 477,
        "popupHeight": 323,
        "pos": {
          "lon": Number(row.plPos[0]),
          "lat": Number(row.plPos[1]),
          "alt": Number(row.plPos[2])
        },
        "extentHeight": 0,
        "extentColor": Cesium.Color.WHITE,
      };
      CesiumPop.addDivPop(options, 'h');
      map3d.methods.flyToLocation([row.plPos[0], Number(row.plPos[1]), Number(row.plPos[2]) + 500]);
    },
    //初始化目录树
    getPipelineData() {
      getPipelineRoad().then(resRoad => {
        getPipeline().then(res => {
          this.createZTree(resRoad.data, res.data);
        });
      });
      // getPipelineCheck().then(res => {
      //   this.queryResult = res.data;
      // });
    },
    //获取管线信息
    doGetPipelineById(id, pos) {
      if (prePlId) {
        CesiumPop.removeDivPopById(viewer, prePlId.substring(2));
      }
      prePlId = 'pl' + id;
      if (!document.getElementById('popupDiv' + id)) {
        let params = {
          'pipeId': id.substring(0, 32)
        };
        getPipelineById(params).then(res => {
          let paramsCheck = {
            'checkAdd': res.data.plName
          };
          getPipelineCheckByAdd(paramsCheck).then(resCheck => {
            let ckdata = resCheck.data[0];
            if (resCheck.data.length === 0) {
              ckdata = {
                checkId: '',
                checkAdd: '',
                checkMan: '',
                checkTime: '',
                checkResult: '',
                repairMan: '',
                repairTime: '',
                repairResult: '',
              };
            }
            let popoptions = {
              popId: id,
              pldata: res.data,
              ckdata: ckdata
            };
            popUtil.installMapPop().plPop(popoptions);
            let addArr = Cesium.Cartographic.fromCartesian(pos);
            let options = {
              "viewer": viewer,
              "id": id,
              "popupWidth": 477,
              "popupHeight": 323,
              "pos": {
                "lon": Number(Cesium.Math.toDegrees(addArr.longitude)),
                "lat": Number(Cesium.Math.toDegrees(addArr.latitude)),
                "alt": Number(addArr.height)
              },
              "extentHeight": 0,
              "extentColor": Cesium.Color.WHITE,
            };
            CesiumPop.addDivPop(options, 'h');
          });
        });
      }
    },
    //获取井盖信息
    doGetPipelineWellById(id, pos) {
      if (prePlId) {
        CesiumPop.removeDivPopById(viewer, prePlId.substring(2));
      }
      prePlId = 'pl' + id;
      if (!document.getElementById('popupDiv' + id)) {
        let params = {
          'pipeId': id.substring(0, 32)
        };
        getPipelineById(params).then(res => {
          let paramsCheck = {
            'checkAdd': res.data.plName
          };
          getPipelineCheckByAdd(paramsCheck).then(resCheck => {
            let ckdata = resCheck.data[0];
            if (resCheck.data.length === 0) {
              ckdata = {
                checkId: '',
                checkAdd: '',
                checkMan: '',
                checkTime: '',
                checkResult: '',
                repairMan: '',
                repairTime: '',
                repairResult: '',
              };
            }
            let popoptions = {
              popId: id,
              pldata: res.data,
              ckdata: ckdata
            };
            popUtil.installMapPop().plPop(popoptions);
            let wellpos = Cesium.Cartographic.fromCartesian(pos);
            let options = {
              "viewer": viewer,
              "id": id,
              "popupWidth": 477,
              "popupHeight": 323,
              "pos": {
                "lon": Number(Cesium.Math.toDegrees(wellpos.longitude)),
                "lat": Number(Cesium.Math.toDegrees(wellpos.latitude)),
                "alt": Number(wellpos.height)
              },
              "extentHeight": 0,
              "extentColor": Cesium.Color.WHITE,
            };
            CesiumPop.addDivPop(options, 'h');
          });
        });
      }
    },
    //关闭管线
    closePipeline() {
      for (let i = 0; i < pl_overlays3D.length; i++) {
        viewer.scene.primitives.remove(pl_overlays3D[i].primitive);
      }
      pl_overlays3D = [];
      for (let i = 0; i < wp_overlays3D.length; i++) {
        viewer.scene.primitives.remove(wp_overlays3D[i].primitive);
      }
      wp_overlays3D = [];
      CesiumPop.clearDivPop(viewer);

      map3d.methods.resetTilesetAlpha(1.0);
      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 1.0, 2000.0, 1.0);

      this.clearPointsSelect();
    },
    //开挖模型
    clipTiles() {
      this.clearPointsSelect();

      let activeShapePoints = [];
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        clipPos.push(earthPosition);

        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 3) {
            drawShape();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
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
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
        //注释功能为边缘插值方法，感觉在开挖分析中效果不明显，暂时不用
        // let lerpPosArr = [];
        // let lerpPosHeightArr = [];
        // let count = 100;
        // clipPos.push(clipPos[0]);
        // for (let i = 0; i < clipPos.length - 1; i++) {
        //   lerpPosArr.push(clipPos[i]);
        //   for (let j = 0; j < count; j++) {
        //     let offset = j / (count - 1);
        //     let lerpPos = Cesium.Cartesian3.lerp(
        //       clipPos[i],
        //       clipPos[i + 1],
        //       offset,
        //       new Cesium.Cartesian3()
        //     );
        //     lerpPosArr.push(lerpPos);
        //     lerpPosHeightArr.push(Cesium.Cartographic.fromCartesian(lerpPos).height);
        //   }
        // }
        // let minHeight = Math.min(...lerpPosHeightArr);
        // let exHeight = minHeight - 10;
        // viewer.scene.clampToHeightMostDetailed(lerpPosArr).then(function (clampedCartesians) {
        //   // for (let i = 0; i < clampedCartesians.length; ++i) {
        //   //   viewer.entities.add({
        //   //     position: clampedCartesians[i],
        //   //     ellipsoid: {
        //   //       radii: new Cesium.Cartesian3(0.2, 0.2, 0.2),
        //   //       material: Cesium.Color.RED,
        //   //     },
        //   //   });
        //   // }
        //   let originClipPos = clipPos.splice(0,clipPos.length - 1);
        //   map3d.methods.cut3dtilesmap(originClipPos);
        let exHeight = Cesium.Cartographic.fromCartesian(clipPos[0]).height - 10;
        map3d.methods.cut3dtilesmap(clipPos);
        viewer.entities.add({
          id: "comEntityFlat",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(clipPos),
            // hierarchy: new Cesium.PolygonHierarchy(clampedCartesians),//注释功能为边缘插值方法，感觉在开挖分析中效果不明显，暂时不用
            material: new Cesium.ImageMaterialProperty({
              image: 'static/images/clipHole.png',
              repeat: new Cesium.Cartesian2(5, 5),
              color: Cesium.Color.WHITE
            }),
            perPositionHeight: true,
            classificationType: Cesium.ClassificationType.NONE,
            closeTop: false, // 这个要设置为false
            extrudedHeight: exHeight,
          },
        });
        for (let i = 0; i < pointArr.length; i++) {
          viewer.entities.remove(pointArr[i]);
        }
        pointArr = [];
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        // });
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        pointArr.push(
          viewer.entities.add({
            position: worldPosition,
            point: {
              color: Cesium.Color.RED,
              pixelSize: 10,
              outlineWidth: 1,
              outlineColor: Cesium.Color.WHITE,
              disableDepthTestDistance: 10000,
            },
          })
        );
      }

      function drawShape() {
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        viewer.entities.add({
          id: "comEntity",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            material: new Cesium.ColorMaterialProperty(
              Cesium.Color.GREENYELLOW.withAlpha(0.3)
            ),
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      }
    },
    //清除框选绘制点
    clearPointsSelect() {
      if (viewer.entities.getById("comEntity") !== undefined) {
        viewer.entities.removeById("comEntity");
      }
      if (viewer.entities.getById("comEntityFlat") !== undefined) {
        viewer.entities.removeById("comEntityFlat");
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      pointArr = [];
      clipPos = [];
      handler = handler && handler.destroy();
      map3d.methods.clearClippingPlanes();
    },
    //创建管线权属目录树
    createZTree(data, datap) {
      //目录树配置
      this.setting = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: zTreeChecked,
          onClick: zTreeClick,
        },
        view: {
          showIcon: true,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [
        {
          id: "0",
          pid: "",
          name: "管线权属目录树",
          isNode: false,
          nocheck: true,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].roadId;
        treeObj.pid = data[i].roadPid;
        treeObj.name = data[i].roadName;
        treeNodes.push(treeObj);
      }
      datap.map(item => {
        let addArr = item.plPos.split(',');
        for (let j = 3; j < addArr.length; j = j + 3) {
          let treeObj = {
            id: item.pipeId + (j / 3),
            pid: item.plPid,
            name: item.plType + "_" + item.plName + '-' + (j / 3) + item.plMaterial,
            pipeId: item.pipeId + (j / 3),
            plName: item.plName + '-' + (j / 3),
            plLine: item.plLine,
            plOutDiameter: item.plOutDiameter,
            plInDiameter: item.plInDiameter,
            plDeep: item.plDeep,
            plDeepStop: item.plDeepStop,
            plMaterial: item.plMaterial,
            plType: item.plType,
            plSlope: item.plSlope,
            plDirection: item.plDirection,
            plSort: item.plSort,
            plBuildingType: item.plBuildingType,
            plCarry: item.plCarry,
            plState: item.plState,
            plArea: item.plArea,
            plDitchDep: item.plDitchDep,
            plLineDep: item.plLineDep,
            plSurveyDep: item.plSurveyDep,
            plSurveyTime: item.plSurveyTime,
            plPeople1: item.plPeople1,
            plPeople2: item.plPeople2,
            plPeople3: item.plPeople3,
            plWellType: item.plWellType,
            plCoverType: item.plCoverType,
            startPointAlt: item.startPointAlt,
            endPointAlt: item.endPointAlt,
            plPos: [
              Number(addArr[j - 3]),
              Number(addArr[j - 2]),
              Number(addArr[j - 1]),
              Number(addArr[j]),
              Number(addArr[j + 1]),
              Number(addArr[j + 2])
            ]
          };
          treeNodes.push(treeObj);
        }
      });
      this.nodes = treeNodes;
      let _this = this;

      //check触发回调函数
      function zTreeChecked(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.addPipeline(treeNode);
        } else {
          _this.clearPipelineById(treeNode);
        }
      }

      function zTreeClick(event, treeId, treeNode) {
        _this.showCheckInfo(treeNode);
      }
    },
    //判断目录树层级，同时调度创建管线方法
    addPipeline(data) {
      if (data.plPos) {
        this.createPipeline(data);
      } else {
        if (data.children[0].plPos) {
          for (let i = 0; i < data.children.length; i++) {
            this.createPipeline(data.children[i]);
          }
        } else {
          data.children.map(item1 => {
            for (let i = 0; i < item1.children.length; i++) {
              this.createPipeline(item1.children[i]);
            }
          })
        }
      }
    },
    //绘制管线实体
    createPipeline(data) {
      viewer.scene.screenSpaceCameraController.enableCollisionDetection = false;
      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 0.0, 2000.0, 1.0);
      viewer.scene.globe.translucency.enabled = true;
      let color;
      switch (data.plType) {
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
          break;
      }
      let wellCoverUrl = "";
      switch (data.plCoverType) {
        case "污水井盖":
          wellCoverUrl = 'static/images/well/wellCover1.png';
          break;
        case "污水阀井":
          wellCoverUrl = 'static/images/well/wellCover3.jpg';
          break;
        case "篦子":
          wellCoverUrl = 'static/images/well/wellCover2.jpg';
          break;
      }
      let volume = new Cesium.PolylineVolumeGeometry({
        polylinePositions: Cesium.Cartesian3.fromDegreesArrayHeights([
          data.plPos[0],
          data.plPos[1],
          data.plPos[2] - Number(data.plDeep) / 1000,
          data.plPos[3],
          data.plPos[4],
          data.plPos[5] - Number(data.plDeepStop) / 1000 - Number(data.plOutDiameter) / 1000
        ]),
        shapePositions: computeCircle(Number(data.plOutDiameter) / 1000),
      });
      // 定义 Geometry
      let geometry = Cesium.PolylineVolumeGeometry.createGeometry(volume);
      // 定义 GeometryInstance
      let instance = new Cesium.GeometryInstance({
        geometry: geometry,
        id: 'pl' + data.id,
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
      pl_overlays3D.push({"id": data.id, "primitive": primitive});
      viewer.scene.primitives.add(primitive);

      let reHeight = 0.1;
      if (data.plWellType === "圆井") {
        //管井井体
        let cylinder = new Cesium.CylinderGeometry({
          length: (Number(data.plDeepStop) / 1000) + Number(data.plOutDiameter) / 1000 + reHeight * 1.9,
          topRadius: 0.83,
          bottomRadius: 1.3,
          slices: 64
        });
        const geometry = Cesium.CylinderGeometry.createGeometry(cylinder);
        let instance = new Cesium.GeometryInstance({
          geometry: geometry,
          id: 'wp' + data.id,
          modelMatrix: Cesium.Matrix4.multiplyByTranslation(
            Cesium.Transforms.eastNorthUpToFixedFrame(Cesium.Cartesian3.fromDegrees(data.plPos[3], data.plPos[4])),
            new Cesium.Cartesian3(0.0, 0.0, data.plPos[5] - (Number(data.plDeepStop) / 1000 + Number(data.plOutDiameter) / 1000) / 2),
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
        wp_overlays3D.push({"id": data.id, "primitive": primitive});
        viewer.scene.primitives.add(primitive);
        //管井井盖
        let ellipse = new Cesium.EllipseGeometry({
          center: Cesium.Cartesian3.fromDegrees(
            data.plPos[3], data.plPos[4],
            data.plPos[5] - (Number(data.plDeepStop) / 1000 + Number(data.plOutDiameter) / 1000) / 2
          ),
          semiMinorAxis: 0.8,
          semiMajorAxis: 0.8,
          height: data.plPos[5] + reHeight,
        });
        let geometryE = Cesium.EllipseGeometry.createGeometry(ellipse);
        let instanceE = new Cesium.GeometryInstance({
          geometry: geometryE,
          id: 'we' + data.id,
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
        wp_overlays3D.push({"id": data.id, "primitive": primitiveE});
        viewer.scene.primitives.add(primitiveE);
      } else {
        //管井井体
        let point2Matrix = getModelMatrix(Cesium.Cartesian3.fromDegrees(data.plPos[0], data.plPos[1], 0),
          Cesium.Cartesian3.fromDegrees(data.plPos[3], data.plPos[4], 0));
        let hpRoll = getHeadingPitchRoll(point2Matrix);
        let hprMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(
          Cesium.Cartesian3.fromDegrees(data.plPos[3], data.plPos[4], data.plPos[5] - (Number(data.plDeepStop) / 1000 + Number(data.plOutDiameter) / 1000) / 2),
          hpRoll,
          Cesium.Ellipsoid.WGS84,
          Cesium.Transforms.eastNorthUpToFixedFrame,
          new Cesium.Matrix4()
        );
        let box = new Cesium.BoxGeometry.fromDimensions({
          vertexFormat: Cesium.VertexFormat.POSITION_AND_NORMAL,
          dimensions: new Cesium.Cartesian3(1.7, 1.7, (Number(data.plDeepStop) / 1000) + Number(data.plOutDiameter) / 1000 + reHeight * 1.9),
        });
        let geometry = Cesium.BoxGeometry.createGeometry(box);
        let instance = new Cesium.GeometryInstance({
          geometry: geometry,
          id: 'wp' + data.id,
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
        wp_overlays3D.push({"id": data.id, "primitive": primitive});
        viewer.scene.primitives.add(primitive);
        //管井井盖
        let hprMatrixPlane = Cesium.Transforms.headingPitchRollToFixedFrame(
          Cesium.Cartesian3.fromDegrees(data.plPos[3], data.plPos[4], data.plPos[5] + reHeight),
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
          id: 'we' + data.id,
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
        wp_overlays3D.push({"id": data.id, "primitive": primitiveE});
        viewer.scene.primitives.add(primitiveE);
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
    },
    //清除管线实体
    clearPipelineById(data) {
      if (data.plPos) {
        for (let i = 0; i < pl_overlays3D.length; i++) {
          if (pl_overlays3D[i].id === data.id) {
            viewer.scene.primitives.remove(pl_overlays3D[i].primitive);
            pl_overlays3D.splice(i, 1);
            break;
          }
        }
        wp_overlays3D.map(item => {
          if (item.id === data.id) {
            viewer.scene.primitives.remove(item.primitive);
          }
        });
      } else {
        if (data.children[0].plPos) {
          data.children.map(item => {
            for (let i = 0; i < pl_overlays3D.length; i++) {
              if (pl_overlays3D[i].id === item.id) {
                viewer.scene.primitives.remove(pl_overlays3D[i].primitive);
                break;
              }
            }
            wp_overlays3D.map(item1 => {
              if (item1.id === item.id) {
                viewer.scene.primitives.remove(item1.primitive);
              }
            });
          });
        } else {
          data.children.map(item1 => {
            item1.children.map(item2 => {
              for (let i = 0; i < pl_overlays3D.length; i++) {
                if (pl_overlays3D[i].id === item2.id) {
                  viewer.scene.primitives.remove(pl_overlays3D[i].primitive);
                  break;
                }
              }
              wp_overlays3D.map(item3 => {
                if (item3.id === item2.id) {
                  viewer.scene.primitives.remove(item3.primitive);
                }
              });
            });
          })
        }
      }
    }
  },
  mounted() {
    this.getPipelineData();
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>
.emer-row {
  color: #ffffff;
  margin: 8px 0;
}

.emer-row-label {
  width: 90px;
  font-size: 15px;
  margin: 8px 0 0 7px;
  float: left;
}

.emer-slider {
  width: 150px;
  float: left;
}

.fade-check {
  float: left;
  margin: 9px 0 0 27px;
  color: #ffffff;
}

.pop-fai {
  position: absolute;
  z-index: 100;
  top: 3px;
  color: #efefef;
  font-size: 15px;
  cursor: pointer;
  padding: 5px 6px;
}

.pop-fai-start {
  right: 80px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}

.ztree_pipe {
  position: absolute;
  margin-top: 40px;
  width: 380px;
  height: 295px;
  overflow-y: auto;
}

.ztree_pipe::-webkit-scrollbar {
  width: 8px !important; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px !important;
}

.ztree_pipe::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px !important;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
  background: #00ffff33 !important;
}

.ztree_pipe::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
  border-radius: 0 !important;
  background: rgba(0, 0, 0, 0.2) !important;
}
</style>
