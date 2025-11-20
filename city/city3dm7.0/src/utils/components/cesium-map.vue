<template>
  <div>
    <div class="sys-tools">
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'building']" title="BIM数据"
                         v-on:click="openBIM()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'city']" title="实景三维模型"
                         v-on:click="openTiles()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'bars']" title="专题地图"
                         v-on:click="openLayer()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fab', 'buffer']" title="基础底图"
                         v-on:click="openBaseLayer()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'mountain']" title="地形开关"
                         v-on:click="terrainTurn()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'search-location']" title="地名地址搜索"
                         v-on:click="openPoiSearch()" fixed-width></font-awesome-icon>
      <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'home']" title="复位"
                         v-on:click="wholeView()" fixed-width></font-awesome-icon>
    </div>
    <div id="bim" class="tiles" v-show="isLayerShow">
      <div class="win-t">
        <label class="win-fai win-title">专题图层</label>
        <font-awesome-icon class="win-fai win-fai-r-1" :icon="['fas', 'times']" title="关闭" v-on:click="openLayer()"
                           fixed-width></font-awesome-icon>
      </div>
      <ztree :nodes="nodesLayer" :setting="settingLayer" style="padding:10px"/>
    </div>
    <div id="layer" class="tiles" v-show="isBIMShow">
      <div class="win-t">
        <label class="win-fai win-title">BIM数据</label>
        <font-awesome-icon class="win-fai win-fai-r-1" :icon="['fas', 'times']" title="关闭" v-on:click="openBIM()"
                           fixed-width></font-awesome-icon>
      </div>
      <ztree :nodes="nodesBim" :setting="settingBim" style="padding:10px"/>
    </div>
    <div id="tiles" class="tiles" v-show="isTilesShow">
      <div class="win-t">
        <label class="win-fai win-title">实景三维模型</label>
        <font-awesome-icon class="win-fai win-fai-r-1" :icon="['fas', 'times']" title="关闭" v-on:click="openTiles()"
                           fixed-width></font-awesome-icon>
      </div>
      <div class="emer-row">
        <span class="emer-row-label">三维透明度</span>
        <el-slider class="emer-slider" v-model="alpha" :format-tooltip="formatTooltip" @change="setAlpha"></el-slider>
        <el-checkbox class="fade-check" v-model="checked" @change="setFadeAlpha">渐变透明</el-checkbox>
      </div>
      <ztree :nodes="nodes" :setting="setting" style="padding:10px"/>
    </div>
    <div id="base" class="tiles" v-show="isBaseLayerShow">
      <div class="win-t">
        <label class="win-fai win-title">基础底图</label>
        <font-awesome-icon class="win-fai win-fai-r-1" :icon="['fas', 'times']" title="关闭"
                           v-on:click="openBaseLayer()"
                           fixed-width></font-awesome-icon>
      </div>
      <ztree :nodes="nodesBase" :setting="settingBase" style="padding:10px"/>
    </div>
    <div id="poiSearch" class="poiSearch" v-show="isPoiSearchShow">
      <div class="win-t">
        <label class="win-fai win-title">地名地址搜索</label>
        <font-awesome-icon class="win-fai win-fai-r-1" :icon="['fas', 'times']" title="关闭"
                           v-on:click="openPoiSearch()"
                           fixed-width></font-awesome-icon>
        <input class="win-input" v-model="poiname"></input>
        <font-awesome-icon class="win-fai win-fai-r-3" :icon="['fas', 'search']" title="搜索" v-on:click="searchPOI()"
                           fixed-width></font-awesome-icon>
      </div>
      <table class="list-tabel" cellspacing="0">
        <tr v-for="(item,index) in poiArr">
          <td>
            <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"></font-awesome-icon>
          </td>
          <td class="td-tag-name" v-on:click="moveToPOI(item.position)">{{ index + 1 + " " + item.name }}</td>
        </tr>
      </table>
    </div>
    <div id="cesiumContainer" :style="{height: cesiumContainer}"></div>
  </div>
</template>

<script>
import {
  clearVideoConverter,
  freshNginx,
  getSys,
  getAllandTiles3dById,
  getAllandBimById, getTiles3D, getBim, getDatalayer
} from "../../api/api";
import {bd09towgs84} from "../../js/CesiumTools.js";
import ztree from "vue-giant-tree";

const jsonp = require('jsonp');

let viewer = null;
let googleimagery;
let arcgisimagery;
let tdtimagery;
let tdtannoimagery;
let tdtvectorimagery;
let tdtvectoranoimagery;
let tilesetArr = [];
let preImageryArr = [];
let suggestionArr = [];
let imageryArr = [];
let kmllayerArr = [];
let pomhandler;
export default {
  name: "cesium-map",
  components: {
    ztree
  },
  data() {
    return {
      poiname: "",
      poiArr: [],
      isLayerShow: false,
      isTilesShow: false,
      isBaseLayerShow: false,
      isPoiSearchShow: false,
      isTerrainShow: false,
      setting: {},
      nodes: [],
      settingBase: {},
      nodesBase: [],
      isBIMShow: false,
      settingBim: {},
      nodesBim: [],
      settingLayer: {},
      nodesLayer: [],
      alpha: 100,
      checked: true,
    };
  },
  methods: {
    //初始化地图
    initMap() {
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
        url:
          "https://services.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer",
      });
      arcgisimagery = new Cesium.ImageryLayer(arcgisimageryProvider, {});

      //天地图影像服务，质量太差，如无特殊要求就不用
      let tdtimgurl =
        "http://t0.tianditu.gov.cn/img_w/wmts?SERVICE=WMTS&REQUEST=GetTile" +
        "&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles" +
        "&TILEMATRIX={TileMatrix}&TILEROW={TileRow}&TILECOL={TileCol}&" +
        "tk=6e5873565cb599dbb7a14b2dd4ea8421";
      let tdtimageryProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtimgurl,
        layer: "tdtimgLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true,
      });
      tdtimagery = new Cesium.ImageryLayer(tdtimageryProvider, {});

      //天地图影像注记
      let tdtimganourl =
        "http://t0.tianditu.gov.cn/cia_w/wmts?service=wmts&request=GetTile" +
        "&version=1.0.0&LAYER=cia&tileMatrixSet=w&TileMatrix={TileMatrix}" +
        "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg" +
        "&tk=6e5873565cb599dbb7a14b2dd4ea8421";
      let tdtannoimageryProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtimganourl,
        layer: "tdtimganoLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true,
      });
      tdtannoimagery = new Cesium.ImageryLayer(tdtannoimageryProvider, {});

      //天地图二维矢量底图
      let tdtvecurl =
        "http://t0.tianditu.gov.cn/vec_w/wmts?service=wmts&request=GetTile" +
        "&version=1.0.0&LAYER=vec&tileMatrixSet=w&TileMatrix={TileMatrix}" +
        "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg" +
        "&tk=6e5873565cb599dbb7a14b2dd4ea8421";
      let tdtvectorProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtvecurl,
        layer: "tdtvecLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true,
      });
      tdtvectorimagery = new Cesium.ImageryLayer(tdtvectorProvider, {});

      //天地图二维矢量底图注记
      let tdtvecanourl =
        "http://t0.tianditu.gov.cn/cva_w/wmts?service=wmts&request=GetTile" +
        "&version=1.0.0&LAYER=cva&tileMatrixSet=w&TileMatrix={TileMatrix}" +
        "&TileRow={TileRow}&TileCol={TileCol}&style=default.jpg" +
        "&tk=6e5873565cb599dbb7a14b2dd4ea8421";
      let tdtvectoranoProvider = new Cesium.WebMapTileServiceImageryProvider({
        url: tdtvecanourl,
        layer: "tdtvecLayer",
        style: "default",
        format: "image/jpeg",
        tileMatrixSetID: "GoogleMapsCompatible",
        show: true,
      });
      tdtvectoranoimagery = new Cesium.ImageryLayer(tdtvectoranoProvider, {});

      preImageryArr = [arcgisimagery, tdtannoimagery];

      //cesium全球30米分辨率地形资源token
      Cesium.Ion.defaultAccessToken =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiI0NjBlYzRiYS0wMDRhL" +
        "TRjZWYtODJhOS1jZTk5ZmI4ZDg5ZTIiLCJpZCI6ODI1MCwic2NvcGVzIjpbImFzciIsImdjIl0sImlhdCI6MTU1MTU3M" +
        "DU1Mn0.yfJ_i4EPiunFj_qUftuv1ksx4pUNgnPC16vQCBGrM08";
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
      });
      viewer.imageryLayers.add(arcgisimagery);
      //viewer.imageryLayers.add(tdtannoimagery);
      //其他设置
      viewer.scene._hdr = false;
      viewer.scene.skyBox.show = true; //星空
      viewer.scene.moon.show = false; //月亮
      viewer.scene.globe.enableLighting = false; //太阳光
      viewer.scene.globe.depthTestAgainstTerrain = true;
      viewer.scene.globe.showGroundAtmosphere = true;
      viewer.scene.skyAtmosphere.brightnessShift = 0.125; //天空亮度
      viewer.scene.skyAtmosphere.atmosphereRayleighScaleHeight = 7000; //大气高度
      viewer.shadowMap.darkness = 0.7;
      viewer.shadows = false;
      // 去掉entity的点击事件
      viewer.cesiumWidget.screenSpaceEventHandler.removeInputAction(
        Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK
      );
      viewer.cesiumWidget.screenSpaceEventHandler.removeInputAction(
        Cesium.ScreenSpaceEventType.LEFT_CLICK
      );
      //抗锯齿设定
      if (Cesium.FeatureDetection.supportsImageRenderingPixelated()) {//判断是否支持图像渲染像素化处理
        viewer.resolutionScale = window.devicePixelRatio;
      }
      viewer.scene.fxaa = true;
      viewer.scene.postProcessStages.fxaa.enabled = true;

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

      window.viewer = viewer;
    },
    //初始化地图参数
    initSys(data) {
      let nginxUrl = "";
      for (let i = 0; i < data.length; i++) {
        switch (data[i].sysType) {
          case "gis":
            let serverIp = data[i].sysContent;
            window.serverIp = serverIp;
            break;
          case "nginx":
            nginxUrl = data[i].sysContent;
            window.nginxUrl = nginxUrl;
            break;
          default:
            break;
        }
      }
      let args = {
        camAdd: nginxUrl,
      };
      freshNginx(args).then((res) => {
        if (res) {
          console.log("代理配置刷新成功！");
          setTimeout(() => {
            if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
              getTiles3D().then(res => this.init3dtilesmaps(res.data));
            } else {
              let params = {
                'roleId': localStorage.getItem("roleId"),
              };
              getAllandTiles3dById(params).then((res) => this.init3dtilesmaps(res.data.sysRoleTiles3d));
            }
            this.wholeView();
          }, 2000);
        } else {
          console.log("代理配置添加成功！");
        }
      });
      clearVideoConverter();
    },
    //改变地图尺寸
    resizeMap() {
      let winHeight = Number(document.documentElement.clientWidth);
      document.getElementById('cesiumContainer').style.height = winHeight + 'px';
    },
    //初始化实景三维模型
    init3dtilesmaps(data) {
      //模型平移的转移矩阵
      if (data) {
        for (let i = 0; i < data.length; i++) {
          if (data[i].tiles3d ? data[i].tiles3d.tilesType === "cc" : data[i].tilesType === "cc") {
            this.add3dtilesmap(data[i].tiles3d ? data[i].tiles3d : data[i]);
          }
        }
      }
    },
    add3dtilesmap(data, type) {
      let urlType = data.tilesUrl.substring(0, 4);
      let tilesUrl = "";
      if (urlType !== "http") {
        tilesUrl = serverIp + data.tilesUrl;
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
        //skipLevelOfDetail: true,
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
        let translation = Cesium.Cartesian3.subtract(offset, surface, new Cesium.Cartesian3());
        tileset.modelMatrix = Cesium.Matrix4.fromTranslation(translation);
        tileset.tilesTransparent = data.tilesTransparent;
        tilesetArr.push(tileset);
        viewer.scene.primitives.add(tileset); //加载3dtiles数据

        if (type === "pre") {
          viewer.zoomTo(tileset, new Cesium.HeadingPitchRange(0.5, -0.2, tileset.boundingSphere.radius));
        }
      });
    },
    //移除实景三维模型
    remove3dtilesmap(url) {
      let urlType = url.substring(0, 4);
      let fullserverIp = "";
      if (urlType !== "http") {
        fullserverIp = serverIp + url;
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
    removeBase3dtiles() {
      for (let i = 0; i < tilesetArr.length; i++) {
        viewer.scene.primitives.remove(tilesetArr[i]);
      }
      tilesetArr = [];
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
    //视角复位
    wholeView() {
      let origin = localStorage.getItem("appPos").split(',');
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromDegrees(origin[0], origin[1], origin[2]),
        orientation: {
          heading: Cesium.Math.toRadians(origin[3]),
          pitch: Cesium.Math.toRadians(origin[4]),
          roll: 0,
        },
      });
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
    //创建BIM列表
    createBIM() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getBim().then(res => this.createBimTree(res.data));
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
        };
        getAllandBimById(params).then(res => this.createBimTree(res.data.sysRoleBim));
      }
    },
    //打开BIM数据列表
    openBIM() {
      this.isBIMShow = !this.isBIMShow;
    },
    //创建三维模型目录树
    createBimTree(data) {
      //目录树配置
      this.settingBim = {
        view: {
          fontCss: {color: "white"},
          showIcon: false
        },
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
          onCheck: tiles3dzTreeOnCheck,
          onClick: tiles3dzTreeOnClick,
        }
      };
      let treeNodes = [{id: 0, pid: "", name: "BIM数据集", isNode: false, open: true, showIcon: false, nocheck: true}];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].bim ? data[i].bim.tilesId : data[i].tilesId;
        j.name = data[i].bim ? data[i].bim.tilesName : data[i].tilesName;
        j.pid = "0";
        j.tilesX = data[i].bim ? data[i].bim.tilesX : data[i].tilesX;
        j.tilesY = data[i].bim ? data[i].bim.tilesY : data[i].tilesY;
        j.tilesZ = data[i].bim ? data[i].bim.tilesZ : data[i].tilesZ;
        j.tilesUrl = data[i].bim ? data[i].bim.tilesUrl : data[i].tilesUrl;
        j.camPoi = data[i].bim ? data[i].bim.camPoi : data[i].camPoi;
        j.camHeading = data[i].bim ? data[i].bim.camHeading : data[i].camHeading;
        j.camPitch = data[i].bim ? data[i].bim.camPitch : data[i].camPitch;
        treeNodes.push(j);
      }
      this.nodesBim = treeNodes;

      let _this = this;

      function tiles3dzTreeOnClick(event, treeId, treeNode) {
        let camPoiArr = treeNode.camPoi.split(',');
        _this.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), Number(treeNode.camHeading), Number(treeNode.camPitch));
      }

      //check触发回调函数
      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.add3dtilesmap(treeNode);
        } else {
          _this.remove3dtilesmap(treeNode.tilesUrl);
        }
      }
    },
    //创建三维模型列表
    createTiles() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getTiles3D().then(res => this.createTiles3DTree(res.data));
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
        };
        getAllandTiles3dById(params).then(res => this.createTiles3DTree(res.data.sysRoleTiles3d));
      }
    },
    //打开三维模型列表
    openTiles() {
      this.isTilesShow = !this.isTilesShow;
    },
    //创建三维模型目录树
    createTiles3DTree(data) {
      let _this = this;
      //目录树配置
      this.setting = {
        view: {
          fontCss: {color: "white"},
          showIcon: false
        },
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
          onCheck: tiles3dzTreeOnCheck,
          onClick: tiles3dzTreeOnClick,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "实景三维数据集",
        isNode: false,
        open: true,
        showIcon: false,
        nocheck: true
      }];
      if (data) {
        for (let i = 0; i < data.length; i++) {
          let j = {};
          j.id = data[i].tiles3d ? data[i].tiles3d.tilesId : data[i].tilesId;
          j.name = data[i].tiles3d ? data[i].tiles3d.tilesName : data[i].tilesName;
          j.pid = "0";
          j.tilesX = data[i].tiles3d ? data[i].tiles3d.tilesX : data[i].tilesX;
          j.tilesY = data[i].tiles3d ? data[i].tiles3d.tilesY : data[i].tilesY;
          j.tilesZ = data[i].tiles3d ? data[i].tiles3d.tilesZ : data[i].tilesZ;
          j.tilesTransparent = data[i].tiles3d ? data[i].tiles3d.tilesTransparent : data[i].tilesTransparent;
          j.maxNumLoadedTiles = data[i].tiles3d ? data[i].tiles3d.maxNumLoadedTiles : data[i].maxNumLoadedTiles;
          j.maxMemoryUsage = data[i].tiles3d ? data[i].tiles3d.maxMemoryUsage : data[i].maxMemoryUsage;
          j.tilesUrl = data[i].tiles3d ? data[i].tiles3d.tilesUrl : data[i].tilesUrl;
          j.camPoi = data[i].tiles3d ? data[i].tiles3d.camPoi : data[i].camPoi;
          j.camHeading = data[i].tiles3d ? data[i].tiles3d.camHeading : data[i].camHeading;
          j.camPitch = data[i].tiles3d ? data[i].tiles3d.camPitch : data[i].camPitch;
          j.checked = data[i].tiles3d ? data[i].tiles3d.tilesType === "cc" : data[i].tilesType === "cc";
          treeNodes.push(j);
        }
      }
      this.nodes = treeNodes;

      function tiles3dzTreeOnClick(event, treeId, treeNode) {
        let camPoiArr = treeNode.camPoi.split(',');
        _this.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), Number(treeNode.camHeading), Number(treeNode.camPitch));
      }

      //check触发回调函数
      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.add3dtilesmap(treeNode);
        } else {
          _this.remove3dtilesmap(treeNode.tilesUrl);
        }
      }
    },
    //打开基础底图窗口
    openBaseLayer() {
      if (!this.isBaseLayerShow) {
        this.createBaseLayerTree();
      }
      this.isBaseLayerShow = !this.isBaseLayerShow;
    },
    //创建基础底图目录树
    createBaseLayerTree() {
      //目录树配置
      this.settingBase = {
        view: {
          fontCss: {color: "white"},
          showIcon: false
        },
        check: {
          enable: true,
          chkStyle: "radio",
          radioType: "all"
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
          onCheck: baseLayerTreeOnCheck
        }
      };
      let treeNodes = [
        {id: 0, pid: "", name: "基础底图数据集", isNode: false, open: true, nocheck: true},
        {id: 1, pid: "0", name: "arcgis影像地图", isNode: true},
        {id: 2, pid: "0", name: "天地图影像地图", isNode: true},
        {id: 3, pid: "0", name: "天地图矢量地图", isNode: true},
        {id: 4, pid: "0", name: "谷歌影像地图", isNode: true},
      ];
      this.nodesBase = treeNodes;

      //check触发回调函数
      function baseLayerTreeOnCheck(event, treeId, treeNode) {
        switch (treeNode.id) {
          case 1:
            for (let i = 0; i < preImageryArr.length; i++) {
              viewer.imageryLayers.remove(preImageryArr[i], false);
            }
            preImageryArr = [];
            viewer.imageryLayers.add(arcgisimagery);
            viewer.imageryLayers.add(tdtannoimagery);
            preImageryArr.push(arcgisimagery, tdtannoimagery);
            break;
          case 2:
            for (let i = 0; i < preImageryArr.length; i++) {
              viewer.imageryLayers.remove(preImageryArr[i], false);
            }
            preImageryArr = [];
            viewer.imageryLayers.add(tdtimagery);
            viewer.imageryLayers.add(tdtannoimagery);
            preImageryArr.push(tdtimagery, tdtannoimagery);
            break;
          case 3:
            for (let i = 0; i < preImageryArr.length; i++) {
              viewer.imageryLayers.remove(preImageryArr[i], false);
            }
            preImageryArr = [];
            viewer.imageryLayers.add(tdtvectorimagery);
            viewer.imageryLayers.add(tdtvectoranoimagery);
            preImageryArr.push(tdtvectorimagery, tdtvectoranoimagery);
            break;
          case 4:
            for (let i = 0; i < preImageryArr.length; i++) {
              viewer.imageryLayers.remove(preImageryArr[i], false);
            }
            preImageryArr = [];
            viewer.imageryLayers.add(googleimagery);
            viewer.imageryLayers.add(tdtannoimagery);
            preImageryArr.push(googleimagery, tdtannoimagery);
            break;
          default:
            break;
        }
      }
    },
    //切换地形加载
    terrainTurn() {
      if (this.isTerrainShow) {
        viewer.scene.terrainProvider = new Cesium.EllipsoidTerrainProvider({});
      } else {
        viewer.scene.terrainProvider = Cesium.createWorldTerrain({requestWaterMask: true});
      }
      this.isTerrainShow = !this.isTerrainShow;
    },
    //打开地名地址检索窗口
    openPoiSearch() {
      this.isPoiSearchShow = !this.isPoiSearchShow;
      this.clearsuggestionArr();
    },
    //地名地址检索
    searchPOI() {
      let poiname = this.poiname;
      if (poiname !== '') {
        this.clearsuggestionArr();
        let camPoiR = viewer.camera.position;
        let camCartographic = Cesium.Cartographic.fromCartesian(camPoiR);
        let camlng = Cesium.Math.toDegrees(camCartographic.longitude);
        let camlat = Cesium.Math.toDegrees(camCartographic.latitude);
        let posstr = camlat + ',' + camlng;
        let url = "http://api.map.baidu.com/place/v2/suggestion?query="
          + poiname + "&location=" + posstr + "&coord_type=1&"
          + "output=json&ak=ZpRjzwQe7dQCVzTR9zytcdLO";
        jsonp(url, null, this.createPOI);
      } else {
        this.$message({
          message: '请输入地名地址关键词！',
          type: 'error'
        });
      }
    },
    //创建地名地址标签
    createPOI(err, data) {
      if (err) {
        console.error(err.message);
        this.$message({
          message: '访问失败，请重试！',
          type: 'error'
        });
      } else {
        if (data.status === 0 && data.result !== []) {
          let temppoiArr = [];
          let result = data.result;
          let campos = viewer.scene.camera.position;
          let camposgeo = Cesium.Cartographic.fromCartesian(campos);
          let camheight = camposgeo.height;
          for (let i = 0; i < result.length; i++) {
            if (result[i].location !== undefined) {
              let bdpos = bd09towgs84(result[i].location.lng, result[i].location.lat);
              let pos = Cesium.Cartesian3.fromDegrees(bdpos[0], bdpos[1], 1600);
              if (camheight < 100000) {
                pos = viewer.scene.clampToHeight(pos);
              }
              let str = (i + 1).toString();
              let poiId = 'pi' + result[i].uid;
              suggestionArr.push(poiId);
              viewer.entities.add({
                id: poiId,
                position: pos,
                label: {
                  show: true,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                  font: 'bold 56px Helvetica',
                  scale: 0.5,
                  fillColor: Cesium.Color.fromCssColorString("#e54163"),
                  text: str,
                  pixelOffset: new Cesium.Cartesian2(0.0, -285.0),
                  scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  disableDepthTestDistance: 100000000,
                },
                billboard: {
                  image: 'static/images/pinimg/34.png',
                  scale: 0.15,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  disableDepthTestDistance: 100,
                }
              });
              let position = [bdpos[0], bdpos[1], 500];
              temppoiArr.push({
                'poiId': poiId,
                'addressstr': result[i].province + result[i].city + result[i].district,
                'name': result[i].name,
                'position': position
              });
            }
          }
          this.poiArr = temppoiArr;
        } else {
          this.$message({
            message: '未查询到结果，请重试！',
            type: 'error'
          });
        }
      }
    },
    //跳转到地名标签
    moveToPOI(position) {
      this.flyToLocation(position);
    },
    //清除地名地址搜索
    clearsuggestionArr() {
      for (let i = 0; i < suggestionArr.length; i++) {
        viewer.entities.removeById(suggestionArr[i]);
      }
      suggestionArr = [];
    },
    //滚动条的数值显示
    formatTooltip(val) {
      return val / 100;
    },
    //通过滚动条设置透明度
    setAlpha() {
      this.resetTilesetAlpha(this.alpha / 100);
      let alpha = Number(this.alpha / 100);
      alpha = !isNaN(alpha) ? alpha : 1.0;
      alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);

      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, alpha, 2000.0, this.checked ? 1.0 : alpha);
      viewer.scene.globe.translucency.enabled = true;
    },
    //设置地形的渐变透明度
    setFadeAlpha() {
      this.resetTilesetAlpha(this.alpha / 100);
      let alpha = Number(this.alpha / 100);
      alpha = !isNaN(alpha) ? alpha : 1.0;
      alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);

      viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, alpha, 2000.0, this.checked ? 1.0 : alpha);
      viewer.scene.globe.translucency.enabled = true;
    },
    //打开二维专题图列表
    openLayer() {
      this.isLayerShow = !this.isLayerShow;
    },
    createLayer() {
      getDatalayer().then(res => this.createDataLayerTree(res.data));
    },
    //创建专题数据目录树
    createDataLayerTree(data) {
      //目录树配置
      this.settingLayer = {
        view: {
          fontCss: {color: "white"},
          showIcon: false
        },
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
          onCheck: dataLayerzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "专题数据集",
        isNode: false,
        open: true,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].layerId;
        j.name = data[i].layerName;
        j.pid = "0";
        j.layerType = data[i].layerType;
        j.layerPath = data[i].layerPath;
        j.layerAlpha = data[i].layerPid;
        treeNodes.push(j);
      }
      this.nodesLayer = treeNodes;
      let that = this;

      function dataLayerzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          that.adddatalayer(treeNode);
        } else {
          that.removedatalayer(treeNode);
        }
      }
    },
    //添加不同类型专题图层
    adddatalayer(node) {
      if (node.layerType === "瓦片") {
        let layerProvider = new Cesium.TileMapServiceImageryProvider({
          url: Cesium.buildModuleUrl(serverIp + node.layerPath)
        });
        let datalayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
      } else if (node.layerType === "cesiumlab") {
        //加载cesiumlab切图的方法，但是与下载的数据不兼容
        let layerProvider = new Cesium.UrlTemplateImageryProvider({
          url: Cesium.buildModuleUrl(serverIp + node.layerPath) + '/{z}/{x}/{y}.png',
          minimumLevel: 1,
        });
        let datalayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
      } else if (node.layerType === "arcgis") {
        let arcgislayerProvider = new Cesium.ArcGisMapServerImageryProvider({
          url: Cesium.buildModuleUrl(node.layerPath)
        });
        let datalayer = new Cesium.ImageryLayer(arcgislayerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
      } else {
        let kmllayer = Cesium.KmlDataSource.load(
          serverIp + node.layerPath,
          {
            sourceUri: serverIp + node.layerPath,
            clampToGround: true
          });
        kmllayer.then(function (dataSource) {
          viewer.dataSources.add(dataSource);
          let kmlobj = {"id": node.id, "kml": dataSource};
          kmllayerArr.push(kmlobj);
        });
      }
    },
    //移除不同类型专题图层
    removedatalayer(node) {
      if (node.layerType !== "kml") {
        for (let i = 0; i < imageryArr.length; i++) {
          if (imageryArr[i].id === node.id) {
            viewer.imageryLayers.remove(imageryArr[i].img);
          }
        }
      } else {
        for (let i = 0; i < kmllayerArr.length; i++) {
          if (kmllayerArr[i].id === node.id) {
            viewer.dataSources.remove(kmllayerArr[i].kml, true);
          }
        }
      }
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
    },
  },
  mounted() {
    this.initMap();
    getSys().then((res) => this.initSys(res.data));
    this.addPOMListener();
    this.createBIM();
    this.createTiles();
    this.createLayer();
    //根据窗口尺寸，调整地图尺寸
    window.onresize = () => {
      return (() => {
        this.resizeMap();
      })();
    };
  },
  computed: {
    cesiumContainer: function () {
      return (window.innerHeight - 150) + 'px';
    },
  }
};
</script>

<style scoped>
#cesiumContainer {
  width: 100%;
  margin: 0;
  padding: 0;
  border: none;
  overflow: hidden;
}

.sys-tools {
  position: absolute;
  right: 40px;
  top: 100px;
  color: #00ffff;
  z-index: 2;
}

.sys-tools-fai {
  border: solid 1px #00ffff;
  padding: 5px;
  width: 20px;
  height: 20px;
  border-radius: 5px;
  margin: 0 0 0 10px;
  font-size: 20px;
  cursor: pointer;
  background: #0088ffb1;
}

.tiles {
  width: 320px;
  height: 400px;
  background: #22222288;
  position: absolute;
  z-index: 2;
  top: 140px;
  right: 40px;
  border-radius: 5px;
  overflow: auto;
}

.tiles::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.tiles::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.tiles::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.poiSearch {
  width: 320px;
  height: 400px;
  background: #22222288;
  position: absolute;
  z-index: 2;
  top: 140px;
  right: 40px;
  border-radius: 5px;
}

.win-fai {
  color: #00ffff;
  font-size: 16px;
  cursor: pointer;
  position: absolute;
  z-index: 3;
}

.win-fai-r-1 {
  top: 5px;
  right: 5px;
}

.win-fai-r-3 {
  top: 45px;
  right: 8px;
}

.win-title {
  top: 5px;
  left: 10px;
  font-size: 15px;
}

.win-t {
  border-bottom: solid 1px #00ffff;
  height: 30px;
  margin: 0 5px;
}

.win-input {
  border: solid 1px #00ffff;
  border-radius: 4px;
  background: #22222233;
  height: 22px;
  width: 260px;
  font-size: 14px;
  color: #eeeeee;
  position: absolute;
  z-index: 3;
  top: 40px;
  left: 10px;
  padding-left: 10px
}

.list-tabel {
  width: 300px;
  border: none;
  margin: 40px auto 0 auto;
  color: #eeeeee;
  font-size: 14px;
}

.list-tabel td {
  padding: 2px 5px;
  cursor: pointer;
  height: 28px;
}

.list-tabel tr:nth-child(odd) {
  background: #004c5ab3;
}

.list-tabel tr:nth-child(even) {
  background: #091d46b3;
}

.pop-tools-fai {
  cursor: pointer;
  margin: 0 0 0 6px;
}

.emer-row {
  color: #ffffff;
  margin: 8px 0;
  display: flex;
}

.emer-row-label {
  width: 90px;
  font-size: 15px;
  margin: 8px 0 0 7px;
}

.emer-slider {
  width: 120px;
}

.fade-check {
  margin: 9px 0 0 15px;
  color: #ffffff;
}
</style>
