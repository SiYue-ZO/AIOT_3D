<template>
  <div id="map-route-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="showRoadNav" title="导航">
      <font-awesome-icon :icon="['fas', 'check']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="clearRouteLine" title="清除">
      <font-awesome-icon :icon="['fas', 'trash-alt']"></font-awesome-icon>
    </div>
    <div style="margin-top:25px">
      <el-input class="pos-input" v-model="startPos" placeholder="起点坐标"></el-input>
      <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"
                         v-on:click="addStartPoi"></font-awesome-icon>
    </div>
    <div style="margin-top:25px">
      <el-input class="pos-input" v-model="stopPos" placeholder="终点坐标"></el-input>
      <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"
                         v-on:click="addStopPoi"></font-awesome-icon>
    </div>
  </div>
</template>

<script>
  import {bd09towgs84} from "@/js/CesiumTools";
  import {searchPOIJsonp} from "../api/api";

  let routeStart;
  let routeEnd;
  let steplineArr = [];
  let steplabelArr = [];

  export default {
    name: "map-route",
    data() {
      return {
        startPos: '',
        stopPos: ''
      }
    },
    methods: {
      //获取百度路径导航
      showRoadNav() {
        if (this.startPos !== "" && this.stopPos !== "") {
          let url = "http://api.map.baidu.com/direction/v2/driving?origin="
            + this.startPos + "&destination=" + this.stopPos + "&coord_type=wgs84&tactics=5"
            + "&alternatives=0&ak=ZpRjzwQe7dQCVzTR9zytcdLO";
          searchPOIJsonp(url, this.showRouteLine);
        } else {
          this.$message.error('起终点不能为空，请重试!');
        }
      },
      //创建路径线(进一步可增加动画或流动线效果)
      showRouteLine(err, data) {
        this.clearRouteLine();
        if (data.status === 0) {
          for (let i = 0; i < data.result.routes[0].steps.length; i++) {
            let step = data.result.routes[0].steps[i];
            let pathArr = step.path.split(/[,;]/);
            let wgs84pathArr = [];
            for (let m = 0; m < pathArr.length; m = m + 2) {
              let wgs84poi = bd09towgs84(pathArr[m], pathArr[m + 1]);
              wgs84pathArr.push(wgs84poi);
            }
            let traConCount = 0;
            for (let j = 0; j < step.traffic_condition.length; j++) {
              let traCon = step.traffic_condition[j];
              let trafficStr = "";
              let roadColor = Cesium.Color.YELLOW;
              switch (traCon.status) {
                case 0:
                  trafficStr = "无路况";
                  roadColor = Cesium.Color.YELLOW;
                  break;
                case 1:
                  trafficStr = "畅通";
                  roadColor = Cesium.Color.CHARTREUSE;
                  break;
                case 2:
                  trafficStr = "缓行";
                  roadColor = Cesium.Color.ORANGE;
                  break;
                case 3:
                  trafficStr = "拥堵";
                  roadColor = Cesium.Color.RED;
                  break;
                case 4:
                  trafficStr = "非常拥堵";
                  roadColor = Cesium.Color.DARKRED;
                  break;
                default:
                  break;
              }
              let subwgs84pathArr = wgs84pathArr.slice(traConCount, traConCount + traCon.geo_cnt + 1);
              let linesubwgs84pathArr = [];
              for (let n = 0; n < subwgs84pathArr.length; n++) {
                linesubwgs84pathArr.push(subwgs84pathArr[n][0], subwgs84pathArr[n][1]);
              }
              let stepline = viewer.entities.add({
                polyline: {
                  positions: Cesium.Cartesian3.fromDegreesArray(linesubwgs84pathArr),
                  width: 8,
                  material: new Cesium.PolylineOutlineMaterialProperty({
                    color: roadColor,
                    outlineWidth: 2,
                    outlineColor: Cesium.Color.BLACK
                  }),
                  clampToGround: true,
                  classificationType: Cesium.ClassificationType.BOTH
                },
              });
              steplineArr.push(stepline);
              let point = Cesium.Cartesian3.fromDegrees(
                Number(subwgs84pathArr[parseInt(subwgs84pathArr.length / 2)][0]), Number(subwgs84pathArr[parseInt(subwgs84pathArr.length / 2)][1]), 137);
              let clampedpoint = viewer.scene.clampToHeight(point);
              let steptext = '';
              if (traConCount === 0) {
                steptext = step.road_name + ' \n ' + traCon.distance + '米 | ' + trafficStr;
              } else {
                steptext = traCon.distance + '米 | ' + trafficStr;
              }
              let steplabel = viewer.entities.add({
                //position :point,
                position: clampedpoint,
                label: {
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                  font: 'bold 30px Helvetica',
                  scale: 0.5,
                  fillColor: Cesium.Color.WHITE,
                  style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                  outlineColor: Cesium.Color.BLACK,
                  outlineWidth: 1,
                  text: steptext,
                  showBackground: true,
                  backgroundColor: new Cesium.Color.fromCssColorString("#01adcd").withAlpha(0.8),
                  backgroundPadding: new Cesium.Cartesian2(30, 15),
                  disableDepthTestDistance: 100000000,
                  pixelOffset: new Cesium.Cartesian2(0, -35.0),
                  scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                }
              });
              steplabelArr.push(steplabel);
              traConCount = traConCount + traCon.geo_cnt;
            }
          }
        } else {
          this.$message.success('路径导航服务请求失败,请重试！');
        }
      },
      //清除导航路径
      clearRouteLine() {
        for (let i = 0; i < steplineArr.length; i++) {
          viewer.entities.remove(steplineArr[i]);
        }
        for (let j = 0; j < steplabelArr.length; j++) {
          viewer.entities.remove(steplabelArr[j]);
        }
        steplineArr = [];
        steplabelArr = [];
      },
      //清除导航点
      clearRoutePoi() {
        viewer.entities.remove(routeStart);
        viewer.entities.remove(routeEnd);
      },
      //添加起始点
      addStartPoi() {
        let that = this;
        let handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        handler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = viewer.scene.pickPosition(movement.position);
          if (Cesium.defined(cartesian)) {
            let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              cartesian = viewer.scene.globe.pick(ray, viewer.scene);
            }
            cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            let lng = Cesium.Math.toDegrees(cartographic.longitude);
            let lat = Cesium.Math.toDegrees(cartographic.latitude);
            that.startPos = lat + ',' + lng;
          }
          let startpoiPin = viewer.entities.getById("startpoiId");
          if (startpoiPin === undefined) {
            routeStart = viewer.entities.add({
              id: "startpoiId",
              position: cartesian.clone(),
              billboard: {
                image: 'static/images/pinimg/30.png',
                scale: 0.8,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
              }
            });
          } else {
            startpoiPin.position = cartesian.clone();
          }
          handler.destroy();
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      },
      //添加终点
      addStopPoi() {
        let that = this;
        let handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        handler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = viewer.scene.pickPosition(movement.position);
          if (Cesium.defined(cartesian)) {
            let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              cartesian = viewer.scene.globe.pick(ray, viewer.scene);
            }
            cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            let lng = Cesium.Math.toDegrees(cartographic.longitude);
            let lat = Cesium.Math.toDegrees(cartographic.latitude);
            that.stopPos = lat + ',' + lng;
          }
          //创建标注
          let endpoiPin = viewer.entities.getById("endpoiId");
          if (endpoiPin === undefined) {
            routeEnd = viewer.entities.add({
              id: "endpoiId",
              position: cartesian.clone(),
              billboard: {
                image: 'static/images/pinimg/31.png',
                scale: 0.8,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
              }
            });
          } else {
            endpoiPin.position = cartesian.clone();
          }
          handler.destroy();
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      }
    }
  }
</script>

<style scoped>
  .pos-input {
    width: 94%;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 11px 0 0 0;
    color: #ffffff;
    float: right;
    font-size: 18px;
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
    right: 120px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
