<template>
  <div id="map-layer-is-show">
    <div class="pop-add-fai" v-on:click="ctrlSlider" title="卷帘">
      <font-awesome-icon :icon="['fas', 'arrows-alt-h']"></font-awesome-icon>
    </div>
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
import ztree from "vue-giant-tree";
import {getDatalayer} from "../api/api";
import VectorTileImageryProvider from "cesiumvectortile";

let imageryArr = [];
let kmllayerArr = [];
let sliderLayer;
let sliderhandler;
let isSlidershow = false;

export default {
  name: "map-layer",
  components: {
    ztree
  },
  data() {
    return {
      setting: {},
      nodes: []
    }
  },
  methods: {
    //创建专题数据目录树
    createDataLayerTree(data) {
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
      this.nodes = treeNodes;
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
          url: Cesium.buildModuleUrl(window.mapServerIp + node.layerPath)
        });
        let datalayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
        sliderLayer = datalayer;
      } else if (node.layerType === "cesiumlab") {
        //加载cesiumlab切图的方法，但是与下载的数据不兼容
        let layerProvider = new Cesium.UrlTemplateImageryProvider({
          url: Cesium.buildModuleUrl(window.mapServerIp + node.layerPath) + '/{z}/{x}/{y}.png',
          minimumLevel: 1,
        });
        let datalayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
        sliderLayer = datalayer;
      } else if (node.layerType === "arcgis") {
        let arcgislayerProvider = new Cesium.ArcGisMapServerImageryProvider({
          url: Cesium.buildModuleUrl(node.layerPath)
        });
        let datalayer = new Cesium.ImageryLayer(arcgislayerProvider, {alpha: Number(node.layerAlpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
        sliderLayer = datalayer;
      } else if (node.layerType === "shp") {
        //加载shp
        let vectorLayer = new VectorTileImageryProvider({
          source: window.mapServerIp + node.layerPath,
          defaultStyle: {
            outlineColor: "rgb(255,255,255)",
            lineWidth: 2,
            fill: false,
            tileCacheSize: 200
          },
          maximumLevel: 20,
          minimumLevel: 1
        });
        let datalayer = new Cesium.ImageryLayer(vectorLayer, {alpha: Number(node.layeralpha)});
        viewer.imageryLayers.add(datalayer);
        let datalayerObj = {"id": node.id, "img": datalayer};
        imageryArr.push(datalayerObj);
        sliderLayer = datalayer;
      } else {
        let kmllayer = Cesium.KmlDataSource.load(
          window.mapServerIp + node.layerPath,
          {
            sourceUri: window.mapServerIp + node.layerPath,
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
      sliderLayer = undefined;
    },
    //移除全部专题图层
    cleardatalayer() {
      for (let i = 0; i < imageryArr.length; i++) {
        viewer.imageryLayers.remove(imageryArr[i].img);
      }
      for (let i = 0; i < kmllayerArr.length; i++) {
        viewer.dataSources.remove(kmllayerArr[i].kml, true);
      }
      imageryArr = [];
      kmllayerArr = [];
      this.stopSlider();
    },
    //卷帘滚动条
    startSlider() {
      if (sliderLayer) {
        sliderLayer.splitDirection = Cesium.ImagerySplitDirection.LEFT;
        let slider = document.getElementById('slider');
        slider.style.display = "block";
        viewer.scene.imagerySplitPosition = (slider.offsetLeft) / slider.parentElement.offsetWidth;

        sliderhandler = sliderhandler && sliderhandler.destroy();
        sliderhandler = new Cesium.ScreenSpaceEventHandler(slider);
        let moveActive = false;

        function move(movement) {
          if (!moveActive) {
            return;
          }
          let relativeOffset = movement.endPosition.x;
          let splitPosition = (slider.offsetLeft + relativeOffset) / slider.parentElement.offsetWidth;
          slider.style.left = 100.0 * splitPosition + '%';
          viewer.scene.imagerySplitPosition = splitPosition;
        }

        sliderhandler.setInputAction(function () {
          moveActive = true;
        }, Cesium.ScreenSpaceEventType.LEFT_DOWN);
        sliderhandler.setInputAction(function () {
          moveActive = true;
        }, Cesium.ScreenSpaceEventType.PINCH_START);

        sliderhandler.setInputAction(move, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        sliderhandler.setInputAction(move, Cesium.ScreenSpaceEventType.PINCH_MOVE);

        sliderhandler.setInputAction(function () {
          moveActive = false;
        }, Cesium.ScreenSpaceEventType.LEFT_UP);
        sliderhandler.setInputAction(function () {
          moveActive = false;
        }, Cesium.ScreenSpaceEventType.PINCH_END);
      } else {
        this.$message.warning("请先选择图层，目前只有瓦片图层才有卷帘分析效果!");
        this.ctrlSlider();
      }
    },
    //停止卷帘
    stopSlider() {
      document.getElementById('slider').style.display = "none";
      sliderhandler = sliderhandler && sliderhandler.destroy();
      viewer.scene.imagerySplitPosition = 1;
    },
    //控制卷帘操作
    ctrlSlider() {
      if (isSlidershow) {
        isSlidershow = false;
        this.stopSlider();
      } else {
        isSlidershow = true;
        this.startSlider();
      }
    }
  },
  mounted() {
    getDatalayer().then(res => this.createDataLayerTree(res.data));
  }
}
</script>

<style scoped>
.pop-add-fai {
  position: absolute;
  z-index: 100;
  top: 3px;
  right: 80px;
  color: #efefef;
  font-size: 15px;
  cursor: pointer;
  padding: 5px 6px;
}

.pop-add-fai:hover {
  background-color: #20920a;
}
</style>
