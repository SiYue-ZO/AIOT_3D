<template>
  <div id="duty-ai-list-is-show">
    <div class="pop-fai pop-fai-stop" v-on:click="stopFaceAlarm" title="停止清除">
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
  import {getVideoByMacUrl, queryKeypeople} from "../api/api";

  let that;
  let followpath = [];
  let suspectArr = [];
  let followlineground;
  let policeManLine;
  let policeMan_points = [];

  export default {
    name: "duty-ai-list",
    data() {
      return {
        faceAlarmArr: [],
      };
    },
    methods: {
      manHisPlay(data) {
        if (data.length > 0) {
          let traceList = [];
          data.map(item => {
            let arrPos = item.realPos.split(',');
            traceList.push(Number(arrPos[0]));
            traceList.push(Number(arrPos[1]));
            traceList.push(Number(arrPos[2]));
          });
          let result = createManLines(traceList, data[0].deviceNum, data);

          function createManLines(nodes, lineId, data) {
            //添加轨迹线
            policeManLine = viewer.entities.add({
              polyline: {
                positions: Cesium.Cartesian3.fromDegreesArrayHeights(nodes),
                width: 4.0,
                material: new Cesium.PolylineDashMaterialProperty({
                  color: Cesium.Color.RED.withAlpha(0.8),
                  //glowPower: 0.6
                }),
                clampToGround: true,
                classificationType: Cesium.ClassificationType.BOTH
              }
            });
            for (let i = 0; i < nodes.length / 3; i++) {
              let point = Cesium.Cartesian3.fromDegrees(nodes[i * 3], nodes[i * 3 + 1], nodes[i * 3 + 2]);
              policeMan_points.push(
                viewer.entities.add({
                  position: point,
                  point: {
                    pixelSize: 5,
                    color: Cesium.Color.RED,
                    outlineColor: Cesium.Color.WHITE,
                    outlineWidth: 2,
                    disableDepthTestDistance: 100000000,
                  },
                  label: {
                    verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                    horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                    text: data[i].realTime,
                    font: 'bold 26px Helvetica',
                    scale: 0.5,
                    style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                    fillColor: Cesium.Color.RED,
                    outlineColor: Cesium.Color.WHITE,
                    outlineWidth: 8,
                    disableDepthTestDistance: 100000000,
                    pixelOffset: new Cesium.Cartesian2(0, -30.0),
                  }
                })
              );
            }
          }
        } else {
          that.$message({
            message: '该时段未查询到指定人员轨迹数据，请重试！',
            type: 'error'
          });
        }
      },
      manHisStop() {
        viewer.entities.remove(policeManLine);
        for (let i = 0; i < policeMan_points.length; i++) {
          viewer.entities.remove(policeMan_points[i]);
        }
        policeMan_points = [];
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
      //黑名单人脸报警
      startFaceAlarm(res) {
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
            let poiline = new Cesium.Cartesian3.fromDegrees(
              Number(posi[0]),
              Number(posi[1]),
              Number(posi[2])
            );
            followpath.push(poiline);
            if (followlineground.polyline !== undefined) {
              followlineground.polyline.positions = followpath;
            }
            //绘制点位
            that.addSuspectPin(poiline, res.alarm.captureTime, common.aiIp + "api/captureImage/" + res.alarm.image);
            if (res.alarm.cardId) {
              let queryData = {
                identity: res.alarm.cardId,
              };
              queryKeypeople(queryData).then((res2) => {
                that.faceAlarmArr[0].name = res2.data[0].name;
                that.faceAlarmArr[0].targetImage = res2.data[0].imgurl;
              });
            }
          });
        }, 500)
      },
      createLineAlarm() {
        followlineground = viewer.entities.add({
          id: "followlineground1",
          polyline: {
            width: 13.0,
            material: new Cesium.PolylineArrowMaterialProperty(Cesium.Color.GREENYELLOW),
            clampToGround: true,
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      },
      stopFaceAlarm() {
        if (viewer.entities.getById("followlineground1")) {
          viewer.entities.removeById("followlineground1");
        }
        for (let i = 0; i < suspectArr.length; i++) {
          viewer.entities.remove(suspectArr[i]);
        }
        followpath = [];
        suspectArr = [];
      },
    },
    mounted() {
      // this.manHisPlay(manRoute);
      this.createLineAlarm();
    },
    created() {
      that = this;
      //通过Websocket和事件公交触发显示人脸识别报警结果
      eventBus.$on("face_alarm", (message) => {
        if (Number(message.alarm.repoType) === 2) {
          this.startFaceAlarm(message);
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
