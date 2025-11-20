<template>
  <div class="main-view">
    <map-header></map-header>
    <map3d></map3d>
    <tool-result></tool-result>
<!--    <websocket></websocket>-->
    <div id="videoSource"></div>
    <canvas id="canvas-a" width="400px" height="400px" style="display: none"></canvas>
    <canvas id="canvas-b" width="400px" height="400px" style="display: none"></canvas>
    <canvas id="canvas-c" width="400px" height="400px" style="display: none"></canvas>
  </div>
</template>

<script>
  import Map3d from "@/components/map-3d";
  import MapHeader from "@/components/map-header";
  import ToolResult from "@/components/tool-result";
  import Websocket from "@/components/websocket";

  export default {
    name: "main-view",
    components: {
      ToolResult,
      MapHeader,
      Map3d,
      Websocket
    },
    mounted() {
      if (localStorage.getItem("isLogin") !== "isLogin") {
        this.$router.push("/");
      }
      if (localStorage.getItem("createTime") === null || localStorage.getItem("createTime") === undefined || localStorage.getItem("createTime") === "") {
        localStorage.setItem("isLogin", "");
        this.$router.push("/");
      }
      let srsptmTimeLong = new Date(localStorage.getItem("createTime").replace("-", "/").replace("-", "/"));
      let deadTime = new Date(new Date(srsptmTimeLong).getTime() + Number(localStorage.getItem("deadLine")) * 24 * 60 * 60 * 1000).getTime();
      let rsptmTimeLong = new Date().getTime();//当前时间
      if (rsptmTimeLong > deadTime) {
        localStorage.setItem("isLogin", "");
        this.$router.push("/");
      }
    }
  }
</script>

<style scoped>
  .main-view {
    height: 100%;
    width: 100%;
  }

  #videoSource {
    position: absolute;
    top: 0;
    left: 0;
    display: none;
  }
</style>
