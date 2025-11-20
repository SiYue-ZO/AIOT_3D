<template>
  <div id="cesiumContainer">
    <div id="slider" class="slider shadow"></div>
  </div>
</template>

<script>
import iotMan from "./iot-man";
import iotCar from "./iot-car";
import iotVideo from "./iot-video";
import toolSearchPOI from "./tool-searchPOI";
import caseMap from "./case-map";
import netBuilding from "./net-building";
import protectWall from "./protect-wall";
import realPeople from "./real-people";
import realHouse from "./real-house";
import realCompany from "./real-company";
import realAddress from "./real-address";
import netManage from "./net-manage";
import netSecurity from "./net-security";
import demoPipeline from "./demo-pipeline";
import netCustomSearch from "./net-custom-search";
import protectAlert from "./protect-alert";
import bimDevice from "./bim-device";
import cityThing from "./city-thing";
import dutyPoint from "./duty-point";
import dutyLine from "./duty-line";
import dutyNet from "./duty-net";
import mapPhotos from "./map-photos";
import mapImage from "./map-image";
import cityBuildingRemove from "./city-building-remove";
import CesiumRotatingDial from '../js/CesiumRotatingDial.js';
import '../js/CesiumTraffic.js';
import "../js/CesiumHugePin.js";
import "../js/CesiumCloud.js";
import {
  clearVideoConverter,
  freshNginx,
  getAddressByType,
  getSys,
  getAllandTiles3dById,
  getStreet,
  getTiles3D,
  queryPoliceLine
} from "../api/api";
import * as turf from '@turf/turf';
import {stringToNumber, getInverseTransform, createPlane} from "@/js/CesiumTools";

let viewer = null;
let localimageryUrl = "";
let localimgannoUrl = "";
let localdarkUrl = "";
let localdem = "";
let googleimagery;
let arcgisimagery;
let arcgisTerrainProvider;
let tdtimagery;
let tdtannoimagery;
let tdtvectorimagery;
let tdtvectoranoimagery;
let localimagery;
let localimganno;
let darkimagery;
let preImageryArr = [];
let localTerrainProvider;
let tilesetArr = [];
let tilesZ = [];
let simple3D;
let simpleUrl = "";
let importantLableArr = [];//重点地名地址标记数组
let address_overlays3D;
let pomhandler;//操作监听句柄对象
let rotatingDial;
let rotatingDialPos;
let tilesetWallArr = [];
window.emergencyPosArr = [];//接处警点坐标数组
let bloom;
let isBloomShow = false;
let waterPmtArr = [];

export default {
  name: "map-3d",
  data() {
    return {
      msg: "map-3d",
    };
  },
  methods: {
    //初始地图参数
    initSys(data) {
      for (let i = 0; i < data.length; i++) {
        switch (data[i].sysType) {
          case "gis":
            window.mapServerIp = data[i].sysContent;
            break;
          case "nginx":
            window.nginxUrl = data[i].sysContent;
            break;
          case "smarteye":
            window.serverUrl = data[i].sysContent;
            jSW.swInit({
              url: serverUrl, // bv_nginx.exe服务器地址
              calltype: jSW.CallProtoType.AUTO, // AUTO: IE优先使用OCX, 如果希望IE仍然使用HTTP通信, 请使用jSW.CallProtoType.HTTP
            });
            break;
          case "simpleUrl":
            simpleUrl = data[i].sysContent;
            break;
          case "tdtToken":
            window.tdtToken = data[i].sysContent;
            break;
          case "localimageryUrl":
            localimageryUrl = data[i].sysContent;
            break;
          case "localimgannoUrl":
            localimgannoUrl = data[i].sysContent;
            break;
          case "localdarkUrl":
            localdarkUrl = data[i].sysContent;
            break;
          case "localdem":
            localdem = data[i].sysContent;
            break;
          case "rotatingDial":
            rotatingDialPos = data[i].sysContent;
            break;
          case "tilesetWall":
            tilesetWallArr = data[i].sysContent.split(',');
            break;
          default:
            break;
        }
      }

      //谷歌地图
      let googleimageryProvider = new Cesium.UrlTemplateImageryProvider({
        //url: "http://www.google.cn/maps/vt?lyrs=y@189&gl=cn&x={x}&y={y}&z={z}&s=Gali",
        url: "http://mt1.google.cn/vt/lyrs=s@113&hl=zh-CN&x={x}&y={y}&z={z}&s=Gali",
        maximumLevel: 19,
        tilingScheme: new Cesium.WebMercatorTilingScheme()
      });
      googleimagery = new Cesium.ImageryLayer(googleimageryProvider, {});

      //arcgis影像地图
      let arcgisimageryProvider = new Cesium.ArcGisMapServerImageryProvider({
        url: 'https://services.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer',
      });
      arcgisimagery = new Cesium.ImageryLayer(arcgisimageryProvider, {});

      //arcgis地形数据
      arcgisTerrainProvider = new Cesium.ArcGISTiledElevationTerrainProvider({
        url: "https://elevation3d.arcgis.com/arcgis/rest/services/WorldElevation3D/Terrain3D/ImageServer",
      });

      //天地图影像服务，质量太差，如无特殊要求就不用
      let tdtimgurl = "http://t0.tianditu.gov.cn/img_w/wmts?SERVICE=WMTS&REQUEST=GetTile"
        + "&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles"
        + "&TILEMATRIX={TileMatrix}&TILEROW={TileRow}&TILECOL={TileCol}&"
        + "&tk=" + tdtToken;
      let tdtimageryProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtimgurl,
        layer: "tdtimgLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true
      });
      tdtimagery = new Cesium.ImageryLayer(tdtimageryProvider, {});

      //天地图影像注记
      let tdtimganourl = "http://t0.tianditu.gov.cn/cia_w/wmts?service=wmts&request=GetTile"
        + "&version=1.0.0&LAYER=cia&tileMatrixSet=w&TileMatrix={TileMatrix}"
        + "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg"
        + "&tk=" + tdtToken;
      let tdtannoimageryProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtimganourl,
        layer: "tdtimganoLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true
      });
      tdtannoimagery = new Cesium.ImageryLayer(tdtannoimageryProvider, {});

      //天地图二维矢量底图
      let tdtvecurl = "http://t0.tianditu.gov.cn/vec_w/wmts?service=wmts&request=GetTile"
        + "&version=1.0.0&LAYER=vec&tileMatrixSet=w&TileMatrix={TileMatrix}"
        + "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg"
        + "&tk=" + tdtToken;
      let tdtvectorProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtvecurl,
        layer: "tdtvecLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true
      });
      tdtvectorimagery = new Cesium.ImageryLayer(tdtvectorProvider, {});

      //天地图二维矢量底图注记
      let tdtvecanourl = "http://t0.tianditu.gov.cn/cva_w/wmts?service=wmts&request=GetTile"
        + "&version=1.0.0&LAYER=cva&tileMatrixSet=w&TileMatrix={TileMatrix}"
        + "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg"
        + "&tk=" + tdtToken;
      let tdtvectoranoProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtvecanourl,
        layer: "tdtvecLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true
      });
      tdtvectoranoimagery = new Cesium.ImageryLayer(tdtvectoranoProvider, {});

      let args = {
        "camAdd": window.nginxUrl
      };
      freshNginx(args).then(res => {
          if (res) {
            console.log("代理配置刷新成功！");
            setTimeout(() => {
              if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
                getTiles3D().then(res => {
                  let tilesetArr = [];
                  res.data.map(item => {
                    item.tiles3d = item;
                    tilesetArr.push(item);
                  });
                  this.init3dtilesmaps(tilesetArr);
                });
              } else {
                let params = {
                  'roleId': localStorage.getItem("roleId"),
                };
                getAllandTiles3dById(params).then(res => this.init3dtilesmaps(res.data.sysRoleTiles3d));
              }

              localimagery = new Cesium.ImageryLayer(new Cesium.TileMapServiceImageryProvider({
                url: Cesium.buildModuleUrl(window.mapServerIp + localimageryUrl),
                maximumLevel: 16
              }));

              localimganno = new Cesium.ImageryLayer(new Cesium.TileMapServiceImageryProvider({
                url: Cesium.buildModuleUrl(window.mapServerIp + localimgannoUrl),
                maximumLevel: 16
              }));

              darkimagery = new Cesium.ImageryLayer(new Cesium.TileMapServiceImageryProvider({
                url: Cesium.buildModuleUrl(window.mapServerIp + localdarkUrl)
              }), {});

              localTerrainProvider = new Cesium.CesiumTerrainProvider({
                url: window.mapServerIp + localdem,
                // requestVertexNormals: true
              });

              switch (window.appImage) {
                case "本地暗色地图":
                  this.addDarkMapLayer();
                  break;
                case "本地遥感影像":
                  this.addLocalImageLayer();
                  break;
                case "ArcGIS Online":
                  this.addarcgisImageLayer();
                  break;
                case "天地图遥感影像":
                  this.addtdtImageLayer();
                  break;
                case "天地图矢量地图":
                  this.addtdtVectorLayer();
                  break;
                default:
                  break;
              }

              switch (window.appTerrain) {
                case "本地地形":
                  this.addLocalTerrain();
                  break;
                case "Cesium地形":
                  this.addWorldTerrain();
                  break;
                case "无地形":
                  this.addelTerrain();
                  break;
                default:
                  break;
              }
            }, 2000);
          } else {
            console.log("代理配置添加成功！");
          }
        }
      );

      // this.initRotatingDial();
      this.initTilesetWall(4.0);
      this.showVolumetricClouds();
      // this.showTraffic();

      clearVideoConverter();
      window.onbeforeunload = function () {
        iotMan.methods.smartEyelogout();
        jSW.swDeInit();
      }
    },
    //初始化地图
    initMap() {
      //cesium全球30米分辨率地形资源token
      Cesium.Ion.defaultAccessToken = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI0NjBlYzRiYS0wMDRhL'
        + 'TRjZWYtODJhOS1jZTk5ZmI4ZDg5ZTIiLCJpZCI6ODI1MCwic2NvcGVzIjpbImFzciIsImdjIl0sImlhdCI6MTU1MTU3M'
        + 'DU1Mn0.yfJ_i4EPiunFj_qUftuv1ksx4pUNgnPC16vQCBGrM08';
      //初始化三维场景
      viewer = new Cesium.Viewer("cesiumContainer", {
        fullscreenButton: false,
        homeButton: false,
        timeline: true,
        geocoder: false,
        scene3DOnly: true,
        sceneModePicker: false,
        baseLayerPicker: false,
        shouldAnimate: true,
        navigationHelpButton: false,
        navigationInstructionsInitiallyVisible: false,
        requestRenderMode: false,
        maximumRenderTimeChange: "Infinity",
        imageryProvider: new Cesium.TileMapServiceImageryProvider({
          url: Cesium.buildModuleUrl("Assets/Textures/NaturalEarthII"),
        }),
        // contextOptions: {
        //   requestWebgl2: true,//容易导致崩溃
        // },
      });
      //效果调优设置
      // viewer.scene.highDynamicRange = true;//高度动态范围，影像清晰度等图片效果
      viewer.scene._hdr = false;
      viewer.scene.skyBox.show = true; //星空
      viewer.scene.moon.show = false;//月亮
      viewer.scene.globe.enableLighting = false; //太阳光
      viewer.scene.globe.depthTestAgainstTerrain = true;
      viewer.scene.globe.showGroundAtmosphere = true;
      viewer.scene.skyAtmosphere.brightnessShift = 0.3;//天空亮度-1.100
      // viewer.scene.skyAtmosphere.brightnessShift = 0.125;//天空亮度-1.100
      // viewer.scene.skyAtmosphere.atmosphereRayleighScaleHeight = 7000;//大气高度-1.100
      viewer.shadows = false;
      viewer.shadowMap.darkness = 0.7;
      // 去掉entity的点击事件
      viewer.cesiumWidget.screenSpaceEventHandler.removeInputAction(Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK);
      viewer.cesiumWidget.screenSpaceEventHandler.removeInputAction(Cesium.ScreenSpaceEventType.LEFT_CLICK);
      //抗锯齿
      if (Cesium.FeatureDetection.supportsImageRenderingPixelated()) {//判断是否支持图像渲染像素化处理
        viewer.resolutionScale = window.devicePixelRatio;
      }
      viewer.scene.fxaa = true;
      viewer.scene.postProcessStages.fxaa.enabled = true;
      //外发光、炫光效果
      bloom = viewer.scene.postProcessStages.bloom;
      bloom.enabled = false;
      bloom.uniforms.glowOnly = false;
      bloom.uniforms.contrast = 115;
      bloom.uniforms.brightness = -0.5;
      bloom.uniforms.delta = 1.0;
      bloom.uniforms.sigma = 3.0;
      bloom.uniforms.stepSize = 4.0;

      //修改cesium默认的clock时间从utc时间到系统时间
      const DateTimeFormatter = (datetime, viewModel, ignoredate) => {
        let julianDT = new Cesium.JulianDate();
        Cesium.JulianDate.addHours(datetime, 8, julianDT);
        let gregorianDT = Cesium.JulianDate.toGregorianDate(julianDT);
        let objDT;
        if (ignoredate)
          objDT = '';
        else {
          objDT = new Date(gregorianDT.year, gregorianDT.month - 1, gregorianDT.day);
          objDT = gregorianDT.year + '年' + objDT.toLocaleString('zh-cn', {month: 'short'}) + gregorianDT.day + '日';
          if (viewModel || gregorianDT.hour + gregorianDT.minute === 0)
            return objDT;
          objDT += ' '
        }
        return objDT + gregorianDT.hour + ":" + gregorianDT.minute + ":" + gregorianDT.second;
      };

      const TimeFormatter = (time, viewModel) => {
        return DateTimeFormatter(time, viewModel, true)
      };

      viewer.animation.viewModel.dateFormatter = DateTimeFormatter;
      viewer.animation.viewModel.timeFormatter = TimeFormatter;
      viewer.timeline.makeLabel = DateTimeFormatter;

      //报错时刷新页面
      viewer.scene.renderError.addEventListener(function () {
        //If a model fails to load, restart render loop.
        //viewer.useDefaultRenderLoop = true;
        window.location.reload();
      });

      window.viewer = viewer;
      //点击三维模型，返回模型信息的方法，有需要时可打开
      // var handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      // handler.setInputAction(function(result) {
      //     var feature = viewer.scene.pick(result.position);
      //         var srcurl = feature.content._resource._url;
      //         console.log(srcurl);
      // }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
    },
    //初始化视角
    wholeView() {
      let origin = window.appPos.split(',');
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromDegrees(origin[0], origin[1], origin[2]),
        orientation: {
          heading: Cesium.Math.toRadians(origin[3]),
          pitch: Cesium.Math.toRadians(origin[4]),
          roll: 0
        }
      });
    },
    //改变地图尺寸
    resizeMap() {
      let winHeight = Number(document.documentElement.clientWidth);
      document.getElementById('cesiumContainer').style.height = winHeight + 'px';
    },
    //初始化
    init3dtilesmaps(data) {
      //模型平移的转移矩阵
      if (data) {
        for (let i = 0; i < data.length; i++) {
          if (data[i].tiles3d.tilesType === "cc") {
            this.add3dtilesmap(data[i].tiles3d);
          }
        }
      }
    },
    //添加实景三维模型
    add3dtilesmap(data) {
      let urlType = data.tilesUrl.substring(0, 4);
      let tilesUrl = "";
      if (urlType !== "http") {
        tilesUrl = mapServerIp + data.tilesUrl;
      } else {
        tilesUrl = data.tilesUrl;
      }
      let tilesetOption = {
        url: tilesUrl,
        imageBasedLightingFactor: new Cesium.Cartesian2(1.5, 1),
        maximumScreenSpaceError: 2,
        maximumNumberOfLoadedTiles: Number(data.maxNumLoadedTiles),
        maximumMemoryUsage: Number(data.maxMemoryUsage),
        dynamicScreenSpaceError: true,
        dynamicScreenSpaceErrorDensity: 0.00278,
        dynamicScreenSpaceErrorFactor: 4.0,
        dynamicScreenSpaceErrorHeightFalloff: 0.25,
        // skipLevelOfDetail: true,
        baseScreenSpaceError: 1024,
        skipScreenSpaceErrorFactor: 16,
        skipLevels: 2,
        immediatelyLoadDesiredLevelOfDetail: false,
        loadSiblings: false,
        cullWithChildrenBounds: true,
        cullRequestsWhileMoving: true,
        cullRequestsWhileMovingMultiplier: 0.001, // 值越小能够更快的剔除
        preloadWhenHidden: true,
        preferLeaves: true,
        progressiveResolutionHeightFraction: 0.2, // 数值偏于0能够让初始加载变得模糊
      };
      let tileset = new Cesium.Cesium3DTileset(tilesetOption);
      //数据加载成功后，根据偏移量计算实景三维模型新的位置矩阵
      tileset.readyPromise.then(function () {
        let cartographic = Cesium.Cartographic.fromCartesian(
          tileset.boundingSphere.center
        );
        let surface = Cesium.Cartesian3.fromRadians(
          cartographic.longitude,
          cartographic.latitude,
          cartographic.height
        );
        let offset = Cesium.Cartesian3.fromRadians(
          cartographic.longitude + Number(data.tilesX),
          cartographic.latitude + Number(data.tilesY),
          cartographic.height + Number(data.tilesZ)
        );
        let translation = Cesium.Cartesian3.subtract(
          offset,
          surface,
          new Cesium.Cartesian3()
        );
        tileset.modelMatrix = Cesium.Matrix4.fromTranslation(translation);
        tileset.tilesTransparent = data.tilesTransparent;
        tilesetArr.push(tileset);
        tilesZ.push(Number(data.tilesZ));
        viewer.scene.primitives.add(tileset); //加载3dtiles数据
      });
    },
    //移除实景三维模型
    remove3dtilesmap(url) {
      let urlType = url.substring(0, 4);
      let fullserverIp = "";
      if (urlType !== "http") {
        fullserverIp = mapServerIp + url;
      } else {
        fullserverIp = url;
      }
      for (let i = 0; i < tilesetArr.length; i++) {
        if (fullserverIp === tilesetArr[i]._url) {
          viewer.scene.primitives.remove(tilesetArr[i], true);
          tilesetArr.splice(i, 1);
          break;
        }
      }
    },
    //调整实景三维数据透明度
    resetTilesetAlpha(tilesetAlpha) {
      for (let i = 0; i < tilesetArr.length; i++) {
        if (tilesetArr[i].tilesTransparent === "是") {
          if (tilesetAlpha === 1.0) {
            tilesetArr[i].style = new Cesium.Cesium3DTileStyle({
              color: 'color("white",' + tilesetAlpha + ')'
            });
          } else {
            tilesetArr[i].style = new Cesium.Cesium3DTileStyle({
              color: 'color("skyblue",' + tilesetAlpha + ')'
            });
          }
        }
      }
    },
    //实景三维数据覆盖雪的效果
    coverTilesetSnow(alpa) {
      if (viewer.entities.getById("coverSnow")) {
        viewer.entities.removeById("coverSnow");
      }
      viewer.entities.add({
        id: "coverSnow",
        rectangle: {
          coordinates: Cesium.Rectangle.fromDegrees(50, -60, 160, 60),
          material: Cesium.Color.WHITE.withAlpha(alpa),
        }
      });
    },
    clearCoverTilesetSnow() {
      viewer.entities.removeById("coverSnow");
    },
    //改变实景三维模型切割面
    cut3dtilesmap(points) {
      //统一到逆时针
      let ring = [];
      points.map(item => {
        ring.push([item.x, item.y]);
      });
      ring.push([points[0].x, points[0].y]);
      if (!turf.booleanClockwise(ring)) {//开挖需要非，孤立的时候去掉！，也就是要统一到顺时针
        points.reverse();
      }

      tilesetArr.map(item => {
        if (item.tilesTransparent === "是") {
          let clippingPlanesArr = []; // 存储ClippingPlane集合
          let inverseTransform = getInverseTransform(item);//需要根据点击的模型在Arr中找到该模型
          for (let i = 0; i < points.length; i++) {
            let plane;
            if (i < points.length - 1) {
              plane = createPlane(points[i], points[i + 1], inverseTransform);
            } else {
              plane = createPlane(points[i], points[0], inverseTransform);
            }
            clippingPlanesArr.push(plane);
          }
          let clippingPlanes = new Cesium.ClippingPlaneCollection({
            planes: clippingPlanesArr,
            edgeWidth: 1,
            edgeColor: Cesium.Color.WHITE,
            unionClippingRegions: false//开挖的时候是false，孤立的时候是true
          });
          item.clippingPlanes = clippingPlanes;
        }
      });
    },
    //使用切割补面的方式压平3dtiles
    flatten3dtilesmap(points) {
      //统一到逆时针
      let ring = [];
      points.map(item => {
        ring.push([item.x, item.y]);
      });
      ring.push([points[0].x, points[0].y]);
      if (!turf.booleanClockwise(ring)) {
        points.reverse();
      }

      tilesetArr.map(item => {
        let clippingPlanesArr = []; // 存储ClippingPlane集合
        let inverseTransform = getInverseTransform(item);//需要根据点击的模型在Arr中找到该模型
        for (let i = 0; i < points.length; i++) {
          let plane;
          if (i < points.length - 1) {
            plane = createPlane(points[i], points[i + 1], inverseTransform);
          } else {
            plane = createPlane(points[i], points[0], inverseTransform);
          }
          clippingPlanesArr.push(plane);
        }
        let clippingPlanes = new Cesium.ClippingPlaneCollection({
          planes: clippingPlanesArr,
          edgeWidth: 1,
          edgeColor: Cesium.Color.WHITE,
          // unionClippingRegions: true
        });
        item.clippingPlanes = clippingPlanes;
      });
    },
    //切割园区实景三维模型，融合BIM室内模型
    cutBIM(points) {
      let clippingPlanesArr = []; // 存储ClippingPlane集合
      tilesetArr.map(item => {
        let inverseTransform = getInverseTransform(item);
        for (let i = 0; i < points.length; i++) {
          let plane;
          if (i < points.length - 1) {
            plane = createPlane(points[i], points[i + 1], inverseTransform);
          } else {
            plane = createPlane(points[i], points[0], inverseTransform);
          }
          clippingPlanesArr.push(plane);
        }

        let clippingPlanes = new Cesium.ClippingPlaneCollection({
          modelMatrix: Cesium.Matrix4.fromTranslation(
            new Cesium.Cartesian3(0, 0, 50 + 316)
          ),
          planes: clippingPlanesArr,
          edgeWidth: 1,
          edgeColor: Cesium.Color.WHITE,
        });
        item.clippingPlanes = clippingPlanes;
      });
    },
    cutLayout(height) {
      tilesetArr.map((item, index) => {
        //cesium-1.100适用
        // let clippingPlanes = new Cesium.ClippingPlaneCollection({
        //   planes: [new Cesium.ClippingPlane(
        //     new Cesium.Cartesian3(0.0, 0.0, -1.0),
        //     -2.8
        //   )],
        //   edgeWidth: 1,
        //   edgeColor: Cesium.Color.WHITE,
        // });
        // item.clippingPlanes = clippingPlanes;
        //cesium-1.82
        let clippingPlanes = new Cesium.ClippingPlaneCollection({
          modelMatrix: Cesium.Matrix4.fromTranslation(
            new Cesium.Cartesian3(0, 0, height - tilesZ[index] - 2)
          ),
          planes: [new Cesium.ClippingPlane(
            new Cesium.Cartesian3(0.0, 0.0, -1.0),
            0.0
          ),],
          edgeWidth: 1,
          edgeColor: Cesium.Color.WHITE,
        });
        item.clippingPlanes = clippingPlanes;
      });
    },
    clearClippingPlanes() {
      tilesetArr.map(item => {
        if (item.clippingPlanes) {
          item.clippingPlanes.enabled = false;
        }
      });
    },
    //添加简模
    addSimple3D() {
      let tilesetOption = {
        url: window.mapServerIp + simpleUrl,
        imageBasedLightingFactor: new Cesium.Cartesian2(2.5, 1),
        maximumScreenSpaceError: 1,
        maximumNumberOfLoadedTiles: 1000,
        maximumMemoryUsage: 128,
        dynamicScreenSpaceError: true,
        dynamicScreenSpaceErrorDensity: 0.00278,
        dynamicScreenSpaceErrorFactor: 4.0,
        dynamicScreenSpaceErrorHeightFalloff: 0.25,
        skipLevelOfDetail: false,
        baseScreenSpaceError: 1024,
        skipScreenSpaceErrorFactor: 16,
        skipLevels: 1,
        immediatelyLoadDesiredLevelOfDetail: true,
        loadSiblings: false,
        cullWithChildrenBounds: true,
        cullRequestsWhileMoving: true,
        cullRequestsWhileMovingMultiplier: 0.001, // 值越小能够更快的剔除
        preloadWhenHidden: true,
        preferLeaves: true,
        progressiveResolutionHeightFraction: 0.1, // 数值偏于0能够让初始加载变得模糊
      };
      simple3D = new Cesium.Cesium3DTileset(tilesetOption);
      simple3D.readyPromise.then(function () {
        viewer.scene.primitives.add(simple3D);//加载3dtiles数据
        // this.addDarkMapLayer();
      });
    },
    //移除简模
    removeSimple3D() {
      if (simple3D) {
        viewer.scene.primitives.remove(simple3D);
        //this.addarcgisImageLayer();
      }
    },
    //切换地形加载
    addWorldTerrain() {
      viewer.scene.terrainProvider = Cesium.createWorldTerrain({requestWaterMask: true});
    },
    //加载arcgis地形，但是加载速度过慢，不宜使用
    addArcgisTerrain() {
      viewer.scene.terrainProvider = arcgisTerrainProvider;
    },
    //椭球
    addelTerrain() {
      viewer.scene.terrainProvider = new Cesium.EllipsoidTerrainProvider({});
    },
    //本地地形
    addLocalTerrain() {
      viewer.scene.terrainProvider = localTerrainProvider;
    },
    //本地影像
    addLocalImageLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(localimagery);
      viewer.imageryLayers.add(localimganno);
      preImageryArr.push(localimagery, localimganno);
    },
    //加载谷歌遥感影像瓦片数据
    addgoogleImageLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(googleimagery);
      viewer.imageryLayers.add(tdtannoimagery);
      preImageryArr.push(googleimagery, tdtannoimagery);
    },
    //加载arcgis影像底图
    addarcgisImageLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(arcgisimagery);
      viewer.imageryLayers.add(tdtannoimagery);
      preImageryArr.push(arcgisimagery, tdtannoimagery);
    },
    //加载天地图遥感影像瓦片数据
    addtdtImageLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(tdtimagery);
      viewer.imageryLayers.add(tdtannoimagery);
      preImageryArr.push(tdtimagery, tdtannoimagery);
    },
    //加载街道矢量瓦片数据
    addtdtVectorLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(tdtvectorimagery);
      viewer.imageryLayers.add(tdtvectoranoimagery);
      preImageryArr.push(tdtvectorimagery, tdtvectoranoimagery);
    },
    //加载本地的暗色地图
    addDarkMapLayer() {
      for (let i = 0; i < preImageryArr.length; i++) {
        viewer.imageryLayers.remove(preImageryArr[i], false);
      }
      preImageryArr = [];
      viewer.imageryLayers.add(darkimagery);
      preImageryArr.push(darkimagery);
    },
    //显示地名地址标签
    showImportantLable() {
      getAddressByType().then(res => this.showImportantAddress(res.data));
      getStreet().then(res => this.showRoadName(res.data));
    },
    showImportantAddress(data) {
      let geojson = {
        "type": "FeatureCollection",
        "features": []
      };
      for (let i = 0; i < data.length; i++) {
        let position = data[i].poi.split(',');
        let addicon = "";
        switch (data[i].addType) {
          case "行政":
            addicon = "static/images/redstar.png";
            break;
          case "地点":
            addicon = "static/images/building.png";
            break;
          default:
            break;
        }
        let feature = {
          "type": "Feature",
          "geometry": {
            "type": "Point",
            "coordinates": [Number(position[0]), Number(position[1]), Number(position[2])]
          },
          "name": '地名地址',
          "properties": {
            "title": data[i].addName,
            "addType": data[i].addType,
            "addicon": addicon,
          }
        };
        geojson.features.push(feature);
      }
      let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        address_overlays3D = dataSource;
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          let labelColor = dataSourceEntities[i].properties.addType._value === "行政" ? Cesium.Color.ORANGERED : Cesium.Color.MAROON;
          dataSourceEntities[i].label = new Cesium.LabelGraphics({
            text: dataSourceEntities[i].name,
            font: 'Bold 64px Helvetica',
            scale: 0.25,
            fillColor: labelColor,
            style: Cesium.LabelStyle.FILL_AND_OUTLINE,
            outlineColor: Cesium.Color.WHITE,
            outlineWidth: 4,
            pixelOffset: new Cesium.Cartesian2(0, -20)
          });
          dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
            image: dataSourceEntities[i].properties.addicon._value,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            width: 24,
            height: 24,
            pixelOffset: new Cesium.Cartesian2(-48.0, -6.0),
          });
        }

        let removeListener;

        function customStyle() {
          if (Cesium.defined(removeListener)) {
            removeListener();
            removeListener = undefined;
          } else {
            removeListener = dataSource.clustering.clusterEvent.addEventListener(function (clusteredEntities, cluster) {
              let curClusteredEntity;
              let tempClusteredEntity = clusteredEntities[0];
              for (let i = 0; i < clusteredEntities.length; i++) {
                let addType = clusteredEntities[i].properties.addType._value;
                if (addType === '行政') {
                  curClusteredEntity = clusteredEntities[i];
                  cluster.label.fillColor = Cesium.Color.ORANGERED;
                } else if (addType === '地名') {
                  tempClusteredEntity = clusteredEntities[i];
                  cluster.label.fillColor = Cesium.Color.MAROON;
                } else {
                  tempClusteredEntity = clusteredEntities[i];
                  cluster.label.fillColor = Cesium.Color.MAROON;
                }
              }
              if (curClusteredEntity === undefined) {
                curClusteredEntity = tempClusteredEntity;
              }
              cluster.label.text = curClusteredEntity.name;
              cluster.label.font = 'Bold 34px Helvetica';
              cluster.label.scale = 0.5;
              cluster.label.style = Cesium.LabelStyle.FILL_AND_OUTLINE;
              cluster.label.outlineColor = Cesium.Color.WHITE;
              cluster.label.outlineWidth = 4;
              cluster.label.pixelOffset = new Cesium.Cartesian2(0, -20);
              cluster.billboard = new Cesium.BillboardGraphics({
                image: curClusteredEntity.properties.addicon._value,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                width: 24,
                height: 24,
                pixelOffset: new Cesium.Cartesian2(-20.0, 0.0),
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              });
            });
          }
          // force a re-cluster with the new styling
          let pixelRange = dataSource.clustering.pixelRange;
          dataSource.clustering.pixelRange = 0;
          dataSource.clustering.pixelRange = pixelRange;
        }

        // start with custom style
        customStyle();
      });
    },
    //贴地显示道路图标
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
          let roadLable = viewer.entities.add({
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
          });
          importantLableArr.push(roadLable);
        }
      }
    },
    //删除重点单位标记
    closeImportantLable() {
      for (let i = 0; i < importantLableArr.length; i++) {
        viewer.entities.remove(importantLableArr[i]);
      }
      importantLableArr.length = 0;
      viewer.dataSources.remove(address_overlays3D);
    },
    //加载海量地名地址数据
    loadMapHuge() {
      // CesiumHugePin.load(xm, viewer);
      let options = {
        viewer: viewer,
        tilesetUrl: mapServerIp + "hljPOI02/tileset.json",
      };
      CesiumHugePin.init(options);
    },
    //清除海量地名地址数据
    clearMapHuge() {
      // CesiumHugePin.clear(viewer);
      CesiumHugePin.close(viewer);
    },
    //定位到坐标
    flyToLocation(position) {
      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]))
      });
    },
    //跳转到cart视角
    moveToWin(x, y, z, h, p) {
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromElements(Number(x), Number(y), Number(z)),
        orientation: {
          heading: Number(h),
          pitch: Number(p),
          roll: 0
        }
      });
    },
    //跳转到经纬度视角
    moveToDegrees(x, y, z, h, p) {
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromDegrees(Number(x), Number(y), Number(z)),
        orientation: {
          heading: Number(h),
          pitch: Number(p),
          roll: 0
        }
      });
    },
    //场景中所有图标点击选取获得数据的操作监听句柄
    addPOMListener() {
      pomhandler = pomhandler && pomhandler.destroy();
      pomhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      let id;
      pomhandler.setInputAction(function (movement) {
        let pickedObject = viewer.scene.pick(movement.position);
        if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)) {
          //判断拾取的是pin还是ClassificationPrimitive
          //若是pin ,pickedObject.id为一个对象，需要读取pickedObject.id._id获取id
          //若是ClassificationPrimitive，pickedObject.id则是字符串，直接获取id
          if (typeof pickedObject.id == "string") {
            id = pickedObject.id;
          } else {
            id = pickedObject.id._id;
          }
          let type = id.substring(0, 2);
          let pomid = id.substring(2);
          switch (type) {
            case 'kp'://司法矫正等重点监控人口
            case 'ke':
              protectWall.methods.getKeypeopleById(pomid);
              break;
            case 'pp':
            case 'pe'://实有人口详情
              realPeople.methods.getRealPeopleById(pomid);
              break;
            case 'ra'://实有人口社区
              realPeople.methods.stepInNextLevel(pomid);
              break;
            case 'rd'://实有人口小区
              realPeople.methods.stepInCommunity(pomid);
              break;
            case 'ad':
            case 'fl'://实有人口分层分户
              realPeople.methods.doQueryPeopleByAddId(pomid);
              break;
            case 'hp'://实有房屋
            case 'he':
              realHouse.methods.getRealHouseById(pomid);
              break;
            case 'ha'://实有房屋社区
              realHouse.methods.stepInNextLevel(pomid);
              break;
            case 'hd'://实有房屋小区
              realHouse.methods.stepInCommunity(pomid);
              break;
            case 'hl'://房屋分层分户
              realHouse.methods.doQueryHouseByAddId(pomid);
              break;
            case 'cp':
            case 'ce'://实有单位
              realCompany.methods.getCompanyById(pomid);
              break;
            case 'cb'://实有单位社区
              realCompany.methods.stepInNextLevel(pomid);
              break;
            case 'cl'://单位分层分户
              realCompany.methods.doQueryCompanyByAddId(pomid);
              break;
            case 'ap':
            case 'ae':
            case 'al'://地名地址分层分户
              realAddress.methods.getRealAddressById(pomid);
              break;
            case 'as'://地名地址小区
              realAddress.methods.stepInCommunity(pomid);
              break;
            case 'aa'://地名地址社区
              realAddress.methods.stepInNextLevel(pomid);
              break;
            case 'nt':
              //netManage.methods.getNetById(pomid);
              netManage.methods.stepInNextLevel(pomid);
              break;
            case 'nd':
              netManage.methods.stepInCommunity(pomid);
              break;
            case 'ne':
            case 'nl':
              netManage.methods.doQueryAllByAddId(pomid);
              break;
            case 'ss'://治安卡口
              netSecurity.methods.doGetSecurityById(pomid);
              break;
            case 'ca'://摄像头
            case 'rc'://接处警应急摄像头
              iotVideo.methods.getVideoById(pomid);
              break;
            case 'po'://人员
              let pos = pickedObject.id._position._value;
              iotMan.methods.getPoliceById(pomid, pos);
              break;
            case 'pc'://车辆
              let position = pickedObject.id._position._value;
              iotCar.methods.getPoliceCarById(pomid, position);
              break;
            case 'cs'://案件
              caseMap.methods.getCaseById(pomid);
              break;
            case 'bu'://建筑物
              let cartesian = viewer.scene.pickPosition(movement.position);
              netBuilding.methods.getBuildingById(pomid, cartesian);
              break;
            case 'pl'://管线
              let plPosition = viewer.scene.pickPosition(movement.position);
              demoPipeline.methods.doGetPipelineById(pomid, plPosition);
              break;
            case 'wp'://管井
              let wpPosition = viewer.scene.pickPosition(movement.position);
              demoPipeline.methods.doGetPipelineWellById(pomid, wpPosition);
              break;
            case 'pi'://名址搜索
              toolSearchPOI.methods.getPOIDetailById(pomid);
              break;
            case 'wa'://电子围栏报警
              protectWall.methods.getAlarmById(pomid);
              break;
            case 'co'://自定义图层
              netCustomSearch.methods.dogetAttrDataById(pomid);
              break;
            case 'vi':
              protectAlert.methods.getVideoById(pomid);
              break;
            case 'de':
              let dePosition = viewer.scene.pickPosition(movement.position);
              bimDevice.methods.getBimDeviceById(pomid, dePosition);
              break;
            case 'dp':
              dutyPoint.methods.getPolicePointById(pomid);
              break;
            case 'dl':
              let dlPosition = viewer.scene.pickPosition(movement.position);
              dutyLine.methods.getPoliceLineById(pomid, dlPosition);
              break;
            case 'dn':
              dutyNet.methods.getPoliceNetById(pomid);
              break;
            case 'mp':
              mapPhotos.methods.showMapPhotos(pomid);
              break;
            case 'im':
              mapImage.methods.showImage(pomid);
              break;
            case 'br':
              cityBuildingRemove.methods.doQueryRemoveByAddId(pomid);
              break;
            case 'ba'://征地拆迁社区
              cityBuildingRemove.methods.stepInNextLevel(pomid);
              break;
            case 'bc'://征地拆迁小区
            case 'bp'://征地拆迁小区
              cityBuildingRemove.methods.getBuildingRemoveNetById(pomid);
              break;
            default:
              break;
          }
        }
        if (pickedObject && pickedObject.instanceId !== undefined) {
          cityThing.methods.showDemoModelInfo(pickedObject.instanceId, pickedObject.primitive.pid);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      let currentObjectId;
      let currentPrimitive;
      let currentColor;
      let currentShow;
      let attributes;
      pomhandler.setInputAction(function (movement) {
        let pickedObject = viewer.scene.pick(movement.endPosition);
        if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)) {
          if (pickedObject.id === currentObjectId) {
            return;
          }
          if (Cesium.defined(currentObjectId)) {
            attributes = currentPrimitive.getGeometryInstanceAttributes(currentObjectId);
            if (attributes !== undefined) {
              if (currentColor !== undefined) {
                attributes.color = currentColor;
              } else {
                attributes.color = Cesium.Color.YELLOW;
              }
              attributes.show = currentShow;
            }
            currentObjectId = undefined;
            currentPrimitive = undefined;
            currentColor = undefined;
            currentShow = undefined;
          }
        }
        if (Cesium.defined(pickedObject)
          && Cesium.defined(pickedObject.primitive)
          && Cesium.defined(pickedObject.id)
          && Cesium.defined(pickedObject.primitive.getGeometryInstanceAttributes)
          && pickedObject.id._id !== 'cameraAreaId'
          && pickedObject.id._id !== 'ppcAreaId'
          && pickedObject.id._id !== 'comEntityFlat'
          && pickedObject.id._id !== 'floodEnt'
          && pickedObject.id._id !== 'coverSnow'
          && pickedObject.id._id !== 'tilesetWall'
          && pickedObject.id._id !== 'floorEntity'
          && pickedObject.id._id !== 'planeEntity'
          && pickedObject.id._id !== 'comEntity') {
          currentObjectId = pickedObject.id;
          currentPrimitive = pickedObject.primitive;
          attributes = currentPrimitive.getGeometryInstanceAttributes(currentObjectId);
          currentColor = attributes.color;
          currentShow = attributes.show;
          if (!viewer.scene.invertClassification) {
            attributes.color = [245, 245, 0, 128];
          }
          attributes.show = [1];
        } else if (Cesium.defined(currentObjectId)) {
          attributes = currentPrimitive.getGeometryInstanceAttributes(currentObjectId);
          if (attributes !== undefined) {
            if (currentColor !== undefined) {
              attributes.color = currentColor;
            } else {
              attributes.color = Cesium.Color.YELLOW;
            }
            attributes.show = currentShow;
          }
          currentObjectId = undefined;
          currentPrimitive = undefined;
          currentColor = undefined;
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);

      viewer.camera.moveEnd.addEventListener(function () {
        if (isBloomShow) {
          bloom.enabled = Cesium.Math.toDegrees(viewer.camera.pitch) <= -13;
        }
      });
    },
    //初始化指南针罗盘
    initRotatingDial() {
      let rotatingDialPosArr = rotatingDialPos.split(',');
      let position = Cesium.Cartesian3.fromDegrees(rotatingDialPosArr[0], rotatingDialPosArr[1], rotatingDialPosArr[2]);
      rotatingDial = new CesiumRotatingDial(viewer, position, rotatingDialPosArr[3], rotatingDialPosArr[4]);
    },
    //移除罗盘
    removeRotatingDial() {
      rotatingDial.remove();
    },
    //显示实景三维周边与地面衔接的墙
    initTilesetWall(repeatY) {
      viewer.entities.removeById("tilesetWall");
      viewer.entities.add({
        id: "tilesetWall",
        wall: {
          positions: Cesium.Cartesian3.fromDegreesArrayHeights(tilesetWallArr),
          material: new Cesium.ImageMaterialProperty({
            image: 'static/images/wall.png',
            // repeat: new Cesium.Cartesian2(0, repeatY),
            transparent: true,
          }),
        },
        polyline: {
          positions: Cesium.Cartesian3.fromDegreesArrayHeights(tilesetWallArr),
          width: 3,
          material: Cesium.Color.CYAN.withAlpha(0.4),
          // clampToGround: true
        }
        //周围暗色方法
        // polygon: {
        //   hierarchy: {
        //     positions: Cesium.Cartesian3.fromDegreesArray([80, 70, 140, 70, 140, 10, 80, 10]),
        //     holes: [{positions: Cesium.Cartesian3.fromDegreesArrayHeights(tilesetWallArr)}]
        //   },
        //   material: Cesium.Color.BLACK.withAlpha(0.6)
        // },
      });
    },
    //关闭实景三维衔接墙
    removeTilesetWall() {
      viewer.entities.removeById("tilesetWall");
    },
    //bloom渲染
    enableBloom(enabled) {
      isBloomShow = enabled;
      bloom.enabled = enabled;
    },
    //交通模拟效果
    showTraffic() {
      let params = {
        'lType': '车流模拟'
      };
      queryPoliceLine(params).then(res => {
        let roads = [];
        res.data.map((item) => {
          let singleRoad = stringToNumber(item.lPoyline);
          roads.push(singleRoad);
        });
        let options = {
          'viewer': viewer,
          'time': 20,
          'speed': 1,
          'data': roads,
          'modeUri': common.serverIp + 'city3dfile/data/model/car/'
        };
        CesiumTraffic.show(options);
      });
    },
    //关闭交通模拟效果
    clearTraffic() {
      CesiumTraffic.clear(viewer);
    },
    //十字路口模拟效果
    showCross() {
      let params = {
        'lType': '十字路口模拟'
      };
      queryPoliceLine(params).then(res => {
        let roads = [];
        res.data.map((item) => {
          let singleRoad = stringToNumber(item.lPoyline);
          roads.push(singleRoad);
        });
        let options = {
          'viewer': viewer,//地图容器
          'time': 15,//运行时间
          'stopTime': 5,//红灯停留时间
          'stopStep': 2,//第几个点等红灯
          'speed': 1,//速度
          'data': roads,//定位坐标
          'modeUri': common.serverIp + 'city3dfile/data/model/car/'//模型路径
        };
        CesiumTraffic.showCross(options);
      });
      let params1 = {
        'lType': '十字路口模拟转弯'
      };
      queryPoliceLine(params1).then(res => {
        let roads = [];
        res.data.map((item) => {
          let singleRoad = stringToNumber(item.lPoyline);
          roads.push(singleRoad);
        });
        let options = {
          'viewer': viewer,//地图容器
          'time': 10,//运行时间
          'data': roads,//定位坐标
          'modeUri': common.serverIp + 'city3dfile/data/model/car/'
        };
        CesiumTraffic.turnRight(options);
      });
    },
    clearCross() {
      CesiumTraffic.clearCross(viewer);
    },
    //开启体积云模拟效果
    showVolumetricClouds() {
      let options = {
        "viewer": viewer,
        "pos": [126.60360648605406, 45.721949051401275, 3000],//中心坐标
        "density": 0.4,//采样密度：0-1
        "radii": 100000,//半径
        "step": 5000,//采样距离
        "speedx": 2,//经度：移动速度，可为负
        "speedy": 0.5,//纬度：移动速度，可为负
      };
      CesiumCloud.show(options);
    },
    //关闭体积云模拟效果
    clearVolumetricClouds() {
      CesiumCloud.clear(viewer);
    },
    //开启水面特效
    showKmlWater() {
      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(121.53461257233478, 29.870404641008506, 6885.7176036996825),
        orientation: {
          heading: Cesium.Math.toRadians(4.556645233653076),
          pitch: Cesium.Math.toRadians(-64.15069563370407),
          roll: 0
        }
      });
      let kmlSource = Cesium.KmlDataSource.load(common.serverIp + 'city3dfile/' + 'kml/yaojiang.kml', {});
      kmlSource.then(function (dataSource) {
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i]._children.map(item => {
            let waterPmt = new Cesium.GroundPrimitive({
              geometryInstances: new Cesium.GeometryInstance({
                geometry: new Cesium.PolygonGeometry({
                  polygonHierarchy: item._children[0].polygon.hierarchy._value,
                  perPositionHeight: true,
                  vertexFormat: Cesium.EllipsoidSurfaceAppearance.VERTEX_FORMAT
                }),
              }),
              appearance: new Cesium.EllipsoidSurfaceAppearance({
                material: new Cesium.Material({
                  fabric: {
                    type: 'Water',
                    uniforms: {
                      baseWaterColor: new Cesium.Color(64 / 255.0, 157 / 255.0, 253 / 255.0, 0.6),
                      normalMap: 'static/images/water/waterNormals.jpg',
                      frequency: 2000.0,
                      animationSpeed: 0.05,
                      amplitude: 4,
                      specularIntensity: 0.4,
                    }
                  }
                }),
              }),
            });
            viewer.scene.primitives.add(waterPmt);
            waterPmtArr.push(waterPmt);
          });
        }
      });
    },
    //关闭水面特效
    clearKmlWater() {
      waterPmtArr.map(item => {
        viewer.scene.primitives.remove(item);
      });
    }
  },
  mounted() {
    this.initMap();
    getSys().then(res => this.initSys(res.data));
    this.addPOMListener();
    //根据窗口尺寸，调整地图尺寸
    window.onresize = () => {
      return (() => {
        this.resizeMap();
      })();
    };
  }
}
</script>

<style scoped>
#cesiumContainer {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  border: none;
  overflow: hidden;
}

.slider {
  display: none;
  position: absolute;
  left: 50%;
  top: 41px;
  bottom: 0;
  background-color: #d3d3d3;
  width: 3px;
  z-index: 9999;
  cursor: e-resize;
  background-color: rgba(0, 152, 254, 0.54)
}

.shadow {
  -webkit-box-shadow: 0 0 15px #446cf2;
  -moz-box-shadow: 0 0 15px #446cf2;
  box-shadow: 0 0 25px #446cf2;
}
</style>
