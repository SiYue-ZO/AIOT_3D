<template>
  <div id="access-car-list-is-show">
    <div class="pop-fai pop-fai-stop" v-on:click="stopAccessCar" title="停止清除">
      <font-awesome-icon :icon="['far', 'trash-alt']"></font-awesome-icon>
    </div>
    <table id="pop_face_alarm" class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in faceAlarmArr" :key="index">
        <td>
          <el-image style="width: 70px" :src="item.alarmPic" :preview-src-list="[item.alarmPic]"/>
        </td>
        <td>
          <el-image style="width: 50px" :src="item.targetImage" :preview-src-list="[item.targetImage]"/>
        </td>
        <td><!--@click="dogetKeypeopleById(item)"-->
          <div>{{item.camAdd}}</div>
          <div>{{item.name}}</div>
          <div>{{item.alarmTime}}</div>
        </td>
        <td class="play_video">
          <font-awesome-icon title="打开监控视频" @click="showFaceVideo(item)" class="show_close" :icon="['fas', 'play']">
          </font-awesome-icon>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  import "../js/CesiumPop.js";
  import {eventBus} from "@/main";
  import iotVideo from "./iot-video";
  import map3d from "./map-3d";
  import {getVideoByMacUrl} from "../api/api";

  let that;
  let videoDivPopId = '';
  let suspectArr = [];
  export default {
    name: "access-car-list",
    data() {
      return {
        faceAlarmArr: [],
      };
    },
    methods: {
      startAccessCar(res) {
        let params = {macUrl: res.alarm.cameraId};
        setTimeout(function () {
          getVideoByMacUrl(params).then((res1) => {
            let resResult = res1.data;
            let posi = resResult.camPosition.split(",");
            that.faceAlarmArr.unshift({
              keyId: res.alarm.faceId,
              alarmPic: common.aiIp + "api/captureImage/" + res.alarm.image,
              camAdd: resResult.camAdd,
              camPosition: resResult.camPosition,
              name: "-",
              camUrl: resResult.camUrl,
              cardId: res.alarm.cardId,
              alarmTime: res.alarm.captureTime,
              id: resResult.id,
              camRtsp: resResult.camRtsp,
              camPort: resResult.camPort,
            });
            //绘制轨迹线
            let pos = new Cesium.Cartesian3.fromDegrees(
              Number(posi[0]),
              Number(posi[1]),
              Number(posi[2])
            );

            //绘制点位
            that.addSuspectPin(pos, res.alarm.captureTime, common.aiIp + "api/captureImage/" + res.alarm.image);
          });
        }, 500)
      },
      addSuspectPin(poi, alarmtime, alarmPic) {
        let alarmtimearr = alarmtime.split(" ");
        let alarmtimen = alarmtimearr[0] + "\n" + alarmtimearr[1];
        suspectArr.push(
          viewer.entities.add({
            position: poi,
            label: {
              show: true,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: "Bold 34px Helvetica",
              scale: 0.5,
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              outlineColor: Cesium.Color.GREEN,
              outlineWidth: 3,
              fillColor: Cesium.Color.WHITE,
              text: alarmtimen,
              pixelOffset: new Cesium.Cartesian2(0.0, -170.0),
              disableDepthTestDistance: 100000000,
            },
            billboard: {
              image: alarmPic,
              scale: 0.3,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              pixelOffset: new Cesium.Cartesian2(0.0, -20.0),
              disableDepthTestDistance: 200,
            },
          })
        );
      },
      //打开报警的相机画面
      showFaceVideo(data) {
        if (videoDivPopId) {
          CesiumPop.removeDivPopById(viewer, videoDivPopId);
          iotVideo.methods.dostopVideoConvertor(videoDivPopId);
        }
        CesiumPop.bindPopGlobeEventHandler(viewer);
        let posi = data.camPosition.split(",");
        map3d.methods.flyToLocation([
          Number(posi[0]),
          Number(posi[1]),
          Number(posi[2]) + 400,
        ]);
        this.dostartVideoConverterface(data);
        videoDivPopId = data.id
      },
      //开启相应报警相机的视频服务，同时获取周边人员和车辆的位置
      dostartVideoConverterface(data) {
        iotVideo.methods.dostartVideoConverter(data, true);
      },
      stopAccessCar() {
        for (let i = 0; i < suspectArr.length; i++) {
          viewer.entities.remove(suspectArr[i]);
        }
        suspectArr = [];
      },
    },
    created() {
      that = this;
      //通过Websocket和事件公交触发显示人脸识别报警结果
      eventBus.$on("face_alarm", (message) => {
        if (Number(message.alarm.repoType) === 3) {
          this.startAccessCar(message);
        }
      });
    },
  }
</script>

<style scoped>
  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }

  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel td {
    padding: 1px 3px;
    cursor: pointer;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .show_close {
    margin-right: 15px;
  }

  .show_close:hover {
    color: dodgerblue;
  }

  .play_video {
    width: 50px;
  }
</style>
