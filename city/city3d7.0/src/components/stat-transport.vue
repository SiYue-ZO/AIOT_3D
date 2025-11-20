<template>
  <div id="stat-transport" class="stat-window stat-transport">
    <div class="stat-title textshadow-p">
      <font-awesome-icon class="sys-tools-fai stat-fai" style="margin-right: 5px"
                         :icon="['fas', 'route']"></font-awesome-icon>
      城市实时交通
    </div>
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div id="map" class="baiduMap"></div>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  export default {
    name: "stat-transport",
    methods: {
      showBaiduMap() {
        //调用百度地图的路况数据
        let map = new BMap.Map("map");
        map.setMapStyle({style: 'midnight'});
        map.enableScrollWheelZoom(true);
        map.centerAndZoom(new BMap.Point(126.61974568816505, 45.75483350005753), 12);
        let ctrl = new BMapLib.TrafficControl({
          showPanel: false //是否显示路况提示面板
        });
        map.addControl(ctrl);
        ctrl.setAnchor(BMAP_ANCHOR_TOP_RIGHT);
        ctrl.showTraffic();//显示路况
      }
    },
    mounted() {
      this.showBaiduMap();
    }
  }
</script>

<style scoped>
  .stat-transport {
    right: 0;
    top: 600px;
  }

  .stat-body {
    color: #fff;
    height: 398px;
    width: 415px;
  }

  .baiduMap {
    width: 370px;
    height: 400px;
    margin: -7px 0 0 21px;
  }
</style>
