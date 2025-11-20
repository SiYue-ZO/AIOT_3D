<template>
  <div id="protect-alarm-is-show">
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
        <td @click="dogetKeypeopleById(item)">
          <div>{{item.camAdd}}</div>
          <div>{{item.name}}</div>
          <div>{{item.alarmTime}}</div>
        </td>
        <td class="play_video">
          <font-awesome-icon title="警保联动" @click="showFaceVideo(item)" class="show_close" :icon="['fas', 'play']">
          </font-awesome-icon>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  import map3d from "./map-3d";
  import iotVideo from "./iot-video";
  import popUtil from "@/utils/pop/popUtil";
  import {eventBus} from "@/main";
  import {getFlatternDistance} from "@/js/CesiumTools";
  import caseCall from "./case-call";
  import iotMan from "./iot-man";
  import iotCar from "./iot-car";
  import {queryKeypeople, getRHPCCar, getRHPCPolice, getVideoListByMacUrl, queryKeypeopleByIdentity} from "../api/api";

  let that;
  let videoDivPopId = '';
  let followpath = [];
  let suspectArr = [];
  let followPeopleArr = [];
  let followlineground;
  let policemanList = []; //调用的警员
  let rePolicemanList = []; //重复的警员
  let policeCarList = []; //调用的警车
  let rePoliceCarList = []; //重复的警车
  export default {
    name: "protect-alarm",
    data() {
      return {
        faceAlarmArr: [],
      };
    },
    methods: {
      //创建告警人员的行动轨迹
      createLineAlarm() {
        followlineground = viewer.entities.add({
          id: "followlineground1",
          polyline: {
            width: 7.0,
            material: new Cesium.PolylineGlowMaterialProperty({
              color: Cesium.Color.RED,
              glowPower: 0.25,
            }),
            clampToGround: true,
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      },
      //创建报警点图标
      addSuspectPin(poi, alarmtime) {
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
              outlineColor: Cesium.Color.fromCssColorString("#e54163"),
              outlineWidth: 3,
              fillColor: Cesium.Color.WHITE,
              text: alarmtimen,
              pixelOffset: new Cesium.Cartesian2(0.0, -335.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            },
            billboard: {
              image: "static/images/pinimg/02.png",
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
          })
        );
      },
      //黑名单人脸报警
      startFaceAlarm(res) {
        window.videoNum += 1;
        if (window.videoNum > 3) {
          window.videoNum = 1;
        }
        let params = {macUrl: res.alarm.cameraId};
        setTimeout(function () {
          getVideoListByMacUrl(params).then((res1) => {
            let resResult = res1.data[window.videoNum - 1];
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
            that.addSuspectPin(poiline, res.alarm.captureTime);
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
        let poi = data.camPosition.split(",");
        let tmppoi = new Cesium.Cartesian3.fromDegrees(
          Number(poi[0]),
          Number(poi[1]),
          Number(poi[2])
        );
        window.emergencyPosArr = [Number(poi[0]), Number(poi[1]), Number(poi[2])];
        followPeopleArr = [Number(poi[0]), Number(poi[1]), Number(poi[2]) + 400];
        caseCall.methods.clearRouteLines();
        getRHPCPolice().then((res) => {
          dogetPolicemanList(res.data, followPeopleArr);
        });
        getRHPCCar().then((res) => dogetPoliceCarList(res.data, followPeopleArr));

        function dogetPolicemanList(data, position) {
          policemanList = [];
          rePolicemanList = [];
          let lng = Number(position[0]);
          let lat = Number(position[1]);
          for (let i = 0; i < data.length; i++) {
            let dis = getFlatternDistance(
              lng,
              lat,
              Number(data[i].longitude),
              Number(data[i].latitude)
            );
            if (dis <= 500) {
              if (rePolicemanList.indexOf(data[i].deviceNum) === -1) {
                rePolicemanList.push(data[i].deviceNum);
              } else {
                policemanList = policemanList.filter(
                  (item) => item.deviceNum !== data[i].deviceNum
                );
              }
              policemanList.push(data[i]);
            }
          }
          iotMan.methods.deletePoliceManMarks();
          iotMan.methods.showPoliceMan(policemanList);
          caseCall.methods.showRoadNavs(policemanList);
          if (document.getElementById("intercom")) {
            caseCall.methods.startintercom(policemanList, "police");
          }
        }

        function dogetPoliceCarList(data, position) {
          rePoliceCarList = [];
          policeCarList = [];
          let lng = Number(position[0]);
          let lat = Number(position[1]);
          for (let i = 0; i < data.length; i++) {
            if (data[i].realdata !== undefined) {
              let dis = getFlatternDistance(
                lng,
                lat,
                Number(data[i].realdata.longitude),
                Number(data[i].realdata.latitude)
              );
              if (dis <= 500) {
                if (rePoliceCarList.indexOf(data[i].car.carId) === -1) {
                  rePoliceCarList.push(data[i].car.carId);
                } else {
                  policeCarList = policeCarList.filter(
                    (item) => item.car.carId !== data[i].car.carId
                  );
                }
                policeCarList.push(data[i]);
                rePoliceCarList.push(data[i]);
              }
            }
          }
          iotCar.methods.clearPoliceCar3DMarks();
          iotCar.methods.showPoliceCar(policeCarList);
          caseCall.methods.showRoadNavs(policeCarList);
          if (document.getElementById("intercom")) {
            caseCall.methods.startintercom(policeCarList);
          }
        }
      },
      //清除识别报警结果
      stopFaceAlarm() {
        CesiumPop.removeDivPopById(viewer, videoDivPopId);
        iotVideo.methods.dostopVideoConvertor(videoDivPopId);
        videoDivPopId = "";
        if (viewer.entities.getById("followlineground1")) {
          viewer.entities.removeById("followlineground1");
        }
        for (let i = 0; i < suspectArr.length; i++) {
          viewer.entities.remove(suspectArr[i]);
        }
        followpath = [];
        suspectArr = [];

        caseCall.methods.clearRouteLines();
        iotMan.methods.deletePoliceManMarks();
        iotCar.methods.clearPoliceCar3DMarks();
        policemanList = [];
        rePolicemanList = [];
        policeCarList = [];
        rePoliceCarList = [];

        CesiumPop.clearDivPop(viewer);
      },
      //关联显示该重点监控人员的住址和基本信息
      dogetKeypeopleById(item) {
        if (!item.cardId) {
          this.$message.error("该人员未关联到本地数据库!");
          return;
        }
        if (document.getElementById("popupDiv" + item.cardId)) {
          document.getElementById("popupDiv" + item.cardId).remove();
        }
        if (document.getElementById("popupDiv" + item.id)) {
          document.getElementById("popupDiv" + item.id).style.top = "2000px"
        }
        CesiumPop.bindPopGlobeEventHandler(viewer);
        let params = {
          identity: item.cardId,
        };
        queryKeypeopleByIdentity(params).then((res) => {
          showKeypeopleById(res.data, item.cardId)
        });

        function showKeypeopleById(data, keyId) {
          let popoptions = {
            popId: keyId,
            imgurl: data.imgurl,
            name: data.name,
            identity: data.identity,
            gender: data.gender,
            birthday: data.birthday,
            blood: data.blood,
            nation: data.nation,
            origin: data.origin,
            height: data.height,
            type: data.type,
            describe: data.describe,
            job: data.job,
            tel: data.tel,
            addName: data.address.addName,
          };
          popUtil.installMapPop().kpPop(popoptions);
          let addArr = data.address.poi.split(",");
          let options = {
            viewer: viewer,
            id: keyId,
            popupWidth: 477,
            popupHeight: 323,
            pos: {
              lon: Number(addArr[0]),
              lat: Number(addArr[1]),
              alt: Number(addArr[2]),
            },
            extentHeight: 0,
            extentColor: Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, "h");
          let camPoiArr = data.address.camPoi.split(",");
          map3d.methods.moveToDegrees(
            camPoiArr[0],
            camPoiArr[1],
            camPoiArr[2],
            Cesium.Math.toRadians(Number(data.address.camHeading)),
            Cesium.Math.toRadians(Number(data.address.camPitch))
          );
        }
      },
    },
    mounted() {
      this.createLineAlarm();
    },
    created() {
      that = this;
      //通过Websocket和事件公交触发显示人脸识别报警结果
      eventBus.$on("face_alarm", (message) => {
        this.startFaceAlarm(message);
      });
    },
  };
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
