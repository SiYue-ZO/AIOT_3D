<template>
  <div id="map-eye-is-show">
    <div class="my-note">左键选取，右键结束</div>
    <div style="margin:20px 0 0 10px">
      <el-button class="my-button" type="primary" v-on:click="showVisibleRegion">可视域</el-button>
      <el-button class="my-button" type="success" v-on:click="showVisibleCircle">通视网</el-button>
      <el-button class="my-button" type="warning" v-on:click="showVisibleLine">通视线</el-button>
      <el-button class="my-button" type="danger" v-on:click="clearVisible">清 除</el-button>
    </div>
  </div>
</template>

<script>
  import "../js/CesiumVisibleLine.js";
  import "../js/CesiumViewShed.js";

  export default {
    name: "map-eye",
    methods: {
      showVisibleLine() {
        let options = {
          "viewer": viewer,
          "drawColor": Cesium.Color.YELLOW,
          "originColor": Cesium.Color.BLUE,
          "targetColor": Cesium.Color.BLUE,
          "breakColor": Cesium.Color.YELLOW,
          "visibleColor": Cesium.Color.GREEN,
          "hiddenColor": Cesium.Color.RED,
          "bodyHeight": 1.78, //用于做视域分析的人员身高
          "bodyColor": Cesium.Color.YELLOW,
        };
        CesiumVisibleLine.drawLines(options);
      },
      showVisibleCircle() {
        let options = {
          "viewer": viewer,
          "drawColor": Cesium.Color.YELLOW,
          "originColor": Cesium.Color.BLUE,
          "targetColor": Cesium.Color.YELLOW,
          "breakColor": Cesium.Color.YELLOW,
          "visibleColor": Cesium.Color.GREEN,
          "visiblePolygonColor": Cesium.Color.GREEN.withAlpha(0.6),
          "hiddenColor": Cesium.Color.RED,
          "bodyHeight": 1.78, //用于做视域分析的人员身高
          "bodyColor": Cesium.Color.YELLOW,
        };
        CesiumVisibleLine.drawCircles(options);
      },
      showVisibleRegion() {
        let options = {
          "viewer": viewer,
          "horizontalViewAngle": 80,
          "verticalViewAngle": 60,
        };
        CesiumViewShed.init(options);
      },
      clearVisible() {
        CesiumVisibleLine.removeLines(viewer);
        CesiumViewShed.clear();
      }
    }
  }
</script>

<style scoped>
  .my-button {
    padding: 12px 16px;
    font-size: 15px;
  }

  .my-note {
    color: #ffffff;
    margin: 15px 0 0 10px;
  }
</style>
