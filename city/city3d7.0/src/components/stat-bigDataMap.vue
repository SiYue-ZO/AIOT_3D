<template>

</template>

<script>
  import iotVideo from "./iot-video";
  import {
    queryPoliceLine,
    getAllVideoScope,
    getKeyPeople,
    getCase,
  } from "../api/api";

  let caseHeatmap;//案件分布热力图
  let keyPeopleHeatmap;
  let policeodline;
  let heatmapBounds = {
    west: 126.51782496032324,
    south: 45.65665624102519,
    east: 126.69515433048157,
    north: 45.783947433640976
  };

  export default {
    name: "stat-bigDataMap",
    methods: {
      //获取案件热力图数据
      showStatCase() {
        getCase().then(res => this.caseHeatmapLoad(res.data));
      },
      closeStatCase() {
        caseHeatmap.show(false);
      },
      //案件热力图
      caseHeatmapLoad(data) {
        caseHeatmap = CesiumHeatmap.create(
          viewer, // your cesium viewer
          heatmapBounds, // bounds for heatmap layer
          {
            // heatmap.js options go here
            // maxOpacity: 0.3
          }
        );
        let caseHeatmapData = [];
        for (let i = 0; i < data.length; i++) {
          let poiArr = data[i].casePosition.split(",");
          caseHeatmapData.push({
            "x": Number(poiArr[0]),
            "y": Number(poiArr[1]),
            "value": 10.0
          });
        }
        caseHeatmap.setWGS84Data(0, 10, caseHeatmapData);
      },
      //获取重点监控人员居住分布热力图数据
      showStatPeople() {
        getKeyPeople().then(res => this.keyPeopleHeatmapLoad(res.data));
      },
      closeStatPeople() {
        keyPeopleHeatmap.show(false);
      },
      //重点监控人员居住分布热力图
      keyPeopleHeatmapLoad(data) {
        keyPeopleHeatmap = CesiumHeatmap.create(
          viewer, // your cesium viewer
          heatmapBounds, // bounds for heatmap layer
          {
            // heatmap.js options go here
            // maxOpacity: 0.3
          }
        );
        let keyPeopleHeatmapData = [];
        for (let i = 0; i < data.length; i++) {
          let poiArr = data[i].poi.split(",");
          keyPeopleHeatmapData.push({
            "x": Number(poiArr[0]),
            "y": Number(poiArr[1]),
            "value": 10.0
          });
        }
        keyPeopleHeatmap.setWGS84Data(0, 15, keyPeopleHeatmapData);
      },
      //获取人员巡逻路线数据
      showStatPoliceLines() {
        queryPoliceLine().then(res => this.showpoliceLines(res.data));
      },
      //人员巡逻路线-路线的飞行效果BUG
      showpoliceLines(data) {
        /*var odOption = {
                  viewer: viewer,
                  geoJsonUrl: 'data/map/busLines.json',
                  linecolor: Cesium.Color.GOLD,//ORANGE;//ORANGE;//GOLD;//底线颜色
                  linewidth: 8.0,//底线宽度
                  lineglow: 0.15,//底线光晕宽度
                  tracecolor: Cesium.Color.WHITE,//ORANGE;//GOLD;//尾迹线颜色
                  tracewidth: 28.0,//尾迹线宽度
                  positions: points,//坐标点数组
                  timeDuration: 3.0,//各个尾迹线发出的时间间隔
                  moveBaseDuration: 3.0,//各个尾迹线的速度，数值越大越慢
          };
          policeodline = CesiumODline.loadGeoJson(odOption);*/

        let points = [];
        for (let i = 0; i < data.length; i++) {
          let lPoylineArr = data[i].realPos.split(',');
          let tmppoints = [];
          for (let j = 0; j < lPoylineArr.length; j = j + 3) {
            let cart = Cesium.Cartesian3.fromDegrees(Number(lPoylineArr[j]),
              Number(lPoylineArr[j + 1]), Number(lPoylineArr[j + 2] + 30));
            tmppoints.push(cart);
          }
          points.push(tmppoints);
        }

        let odOption = {
          viewer: viewer,
          linecolor: Cesium.Color.ORANGE,//ORANGE;//ORANGE;//GOLD;//底线颜色
          linewidth: 8.0,//底线宽度
          lineglow: 0.15,//底线光晕宽度
          tracecolor: Cesium.Color.WHITE,//ORANGE;//GOLD;//尾迹线颜色
          tracewidth: 28.0,//尾迹线宽度
          positions: points,//坐标点数组
          timeDuration: 3.0,//各个尾迹线发出的时间间隔
          moveBaseDuration: 3.0,//各个尾迹线的速度，数值越大越慢
        };
        policeodline = CesiumODline.add(odOption);
      },
      closepoliceLines() {
        CesiumODline.remove(viewer, policeodline);
      },
      //获取视频监控范围
      showStatVideoScope() {
        getAllVideoScope().then(res => this.doCreateVideoScope(res.data));
      },
      //绘制视频监控范围图形
      doCreateVideoScope(data) {
        for (let i = 0; i < data.length; i++) {
          iotVideo.methods.createVideoScope(data[i]);
        }
      },
      closeStatVideoScope() {
        iotVideo.methods.closeAllVideoScope();
      },
    },
  }
</script>

<style scoped>

</style>
