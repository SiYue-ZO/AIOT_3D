<template>
  <div id="iot-uav-his-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startHis" title="开始回放" v-show="isVideo">
      <font-awesome-icon :icon="['fas', 'video']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="pauseHis" title="暂停回放" v-show="!isVideo">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="followUav" title="开始跟随" v-show="isFollow">
      <font-awesome-icon :icon="['fab', 'chromecast']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="followUav" title="停止跟随" v-show="!isFollow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div style="color: white">飞行参数仪表盘</div>
  </div>
</template>

<script>
import axios from 'axios'

let _this;
let czml = [];
let hisData = [];
let hprArr = [];
let czmldatads;
let pointCollection;

let uavlistener;
let cameraVideo;
export default {
  name: "iot-uav-his",
  data() {
    return {
      isFollow: true,
      isVideo: true,
      isPause: true
    }
  },
  methods: {
    //跟踪
    followUav() {
      this.isFollow = !this.isFollow;
    },
    //开始回放
    startHis() {
      this.isVideo = !this.isVideo;
      viewer.clock.shouldAnimate = true;
      if (this.isPause) {
        let videoElement;
        videoElement = document.createElement('video');
        videoElement.id = 'video-uav';
        videoElement.style.height = 300 + 'px';
        videoElement.crossOrigin = 'anonymous';
        videoElement.autoplay = true;
        videoElement.loop = 'loop';
        videoElement.muted = 'muted';
        videoElement.src = common.serverIp + "city3dfile/uav/MyVideo_2.mp4";
        setTimeout(() => {
          let UAVTrack;
          let czmldata = Cesium.CzmlDataSource.load(czml);
          viewer.dataSources.add(czmldata).then(function (ds) {
            czmldatads = ds;
            UAVTrack = ds.entities.getById("UAVTrack");
          });

          let positionCt3 = Cesium.Cartesian3.fromDegrees(
            Number(hisData[0].RTK_gps_lon),
            Number(hisData[0].RTK_gps_lat),
            Number(hisData[0].abs_alt));
          // 2.2.2.2 准备inverseViewMatrix
          // 准备inverseViewMatrix是为了定义视频拍摄的相机的姿态(位置和方向)
          // 此处设定为当前相机的欧拉角(heading\pitch\roll)和位置信息
          let inverseViewMatrix = _this.hpr2m({
            position: positionCt3,
            heading: Cesium.Math.toRadians(Number(hisData[0].RTK_drone_yaw)),
            pitch: Cesium.Math.toRadians(Number(hisData[0].gb_pitch)),
            roll: Cesium.Math.toRadians(Number(hisData[0].gb_roll) - Number(hisData[0].drone_roll)),
          });

          // 2.2.2.3 准备frustum，
          // frustum是为了定义投影体的形状
          // frustum选填，可以直接置为undefined
          let frustum = new Cesium.PerspectiveFrustum({
            fov: Cesium.Math.toRadians(14.7),
            aspectRatio: 1.7777778,
            near: 0.005,
            far: 300,
          });

          // 2.2.2.4 根据以上信息创建cameraVideo
          cameraVideo = new Cesium.XbsjCameraVideo({
            inverseViewMatrix: inverseViewMatrix,
            frustum: frustum,
            videoElement: videoElement,
            showHelperPrimitive: true,
          });
          cameraVideo._primitive.classificationType = 1; // 同时投影地形和3dtiles数据
          // 2.2.2.5 加入到场景中去
          viewer.scene.primitives.add(cameraVideo);

          let obj = {
            heading: Cesium.Math.toRadians(Number(hisData[0].RTK_drone_yaw)),
            pitch: Cesium.Math.toRadians(Number(hisData[0].gb_pitch)),
            roll: Cesium.Math.toRadians(Number(hisData[0].gb_roll) - Number(hisData[0].drone_roll)),
          };
          //每一帧渲染时的监听，取到无人机的位置，更新视频投影位置
          uavlistener = function (scene, time) {
            let timerPos = UAVTrack;
            if (timerPos && timerPos.position._property && timerPos.position._property._interpolationResult[0]) {
              let interPosArr = timerPos.position._property._interpolationResult;
              obj.position = Cesium.Cartesian3.fromElements(interPosArr[0], interPosArr[1], interPosArr[2]);

              for (let i = 0; i < timerPos.orientation._times.length; i++) {
                if (time.secondsOfDay.toFixed(1) === timerPos.orientation._times[i].secondsOfDay.toFixed(1)) {
                  obj.heading = hprArr[i].heading;
                  obj.pitch = hprArr[i].pitch;
                  obj.roll = hprArr[i].roll;
                  break;
                }
              }
              cameraVideo.inverseViewMatrix = _this.hpr2m(obj);
              if (!_this.isFollow) {
                viewer.camera.setView({
                  destination: obj.position,
                  orientation: {
                    heading: obj.heading,
                    pitch: obj.pitch,
                    roll: obj.roll
                  }
                });
              }
            }
          };
          viewer.scene.preUpdate.addEventListener(uavlistener);
        }, 10);
      }
    },
    //h,p,r转matrix4，根据参数计算姿态矩阵
    hpr2m(obj, result) {
      let scratchSetViewQuaternion = new Cesium.Quaternion();
      let scratchSetViewMatrix3 = new Cesium.Matrix3();
      const inverseViewMatrix = Cesium.Transforms.eastNorthUpToFixedFrame(obj.position, undefined, result);
      let rotMat = Cesium.Matrix3.fromRotationX(Cesium.Math.PI_OVER_TWO, scratchSetViewMatrix3);
      Cesium.Matrix4.multiplyByMatrix3(inverseViewMatrix, rotMat, inverseViewMatrix);

      rotMat = Cesium.Matrix3.fromRotationY(-obj.heading, scratchSetViewMatrix3);
      Cesium.Matrix4.multiplyByMatrix3(inverseViewMatrix, rotMat, inverseViewMatrix);

      rotMat = Cesium.Matrix3.fromRotationX(obj.pitch, scratchSetViewMatrix3);
      Cesium.Matrix4.multiplyByMatrix3(inverseViewMatrix, rotMat, inverseViewMatrix);

      rotMat = Cesium.Matrix3.fromRotationZ(-obj.roll, scratchSetViewMatrix3);
      Cesium.Matrix4.multiplyByMatrix3(inverseViewMatrix, rotMat, inverseViewMatrix);

      return inverseViewMatrix;
    },
    //暂停回放
    pauseHis() {
      viewer.clock.shouldAnimate = false;
      this.isVideo = !this.isVideo;
      this.isPause = false;
    },
    //获取json
    GetJsonInfo() {
      pointCollection = viewer.scene.primitives.add(new Cesium.PointPrimitiveCollection());
      let url = common.serverIp + "city3dfile/uav/DJI_20220929170428_0001_Z_Final.json";
      axios.get(url).then(function (response) {
        hisData = response.data;
        czml = [
          {
            "id": "document",
            "name": "CZML UAV track",
            "version": "1.0",
            "clock": {
              "interval": "2012-03-15T10:00:00Z/2012-03-16T10:00:00Z",
              "currentTime": "2012-03-15T10:00:00Z",
              "multiplier": 1,
              "range": "LOOP",
              "step": "SYSTEM_CLOCK_MULTIPLIER"
            }
          },
          {
            "id": "UAVTrack",
            "point": {
              "pixelSize": 4,
              "outlineWidth": 1,
              "outlineColor": {"rgba": [255, 255, 255, 255]},
              "color": {"rgba": [255, 0, 0, 255]},
              "disableDepthTestDistance": 100000000,
            },
            "position": {
              "interpolationAlgorithm": "LAGRANGE",
              "interpolationDegree": 1,
              "referenceFrame": "FIXED",
              "epoch": "2012-03-15T10:00:00Z",
              "cartographicDegrees": []
            },
            "orientation": {
              "interpolationAlgorithm": "LAGRANGE",
              "interpolationDegree": 1,
              "epoch": "2012-03-15T10:00:00Z",
              "unitQuaternion": []
            }
          }
        ];

        let startTime = new Date(hisData[0].time).toISOString();
        let stopTime = new Date(hisData[hisData.length - 1].time).toISOString();
        let startTimeT = new Date(hisData[0].time).getTime();
        czml[0].clock.interval = startTime + "/" + stopTime;
        czml[0].clock.currentTime = startTime;
        czml[1].position.epoch = startTime;
        czml[1].orientation.epoch = startTime;
        let cartesianArr = [];
        let orientationArr = [];
        hisData.map(item => {
          let hpr = new Cesium.HeadingPitchRoll(
            Cesium.Math.toRadians(Number(item.RTK_drone_yaw)),
            Cesium.Math.toRadians(Number(item.gb_pitch)),
            Cesium.Math.toRadians(Number(item.gb_roll) - Number(item.drone_roll)));
          hprArr.push(hpr);
          let rotQuat = Cesium.Quaternion.fromHeadingPitchRoll(hpr, new Cesium.Quaternion());
          let currentTimeT = new Date(item.time).getTime();
          let time = (currentTimeT - startTimeT) / 1000;
          cartesianArr.push(time, Number(item.RTK_gps_lon), Number(item.RTK_gps_lat), Number(item.abs_alt));
          orientationArr.push(time, rotQuat.x, rotQuat.y, rotQuat.z, rotQuat.w);
          pointCollection.add({
            position : new Cesium.Cartesian3.fromDegrees(Number(item.RTK_gps_lon), Number(item.RTK_gps_lat), Number(item.abs_alt)),
            pixelSize: 4,
            color : Cesium.Color.GREEN.withAlpha(0.5),
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE.withAlpha(0.4),
          });
        });
        czml[1].position.cartographicDegrees = cartesianArr;
        czml[1].orientation.unitQuaternion = orientationArr;
      }).catch(function (error) {
        console.log(error);
      });
    },
    closeUavHis() {
      viewer.clock.shouldAnimate = true;
      viewer.dataSources.remove(czmldatads, true);
      viewer.scene.preUpdate.removeEventListener(uavlistener);
      viewer.scene.primitives.remove(cameraVideo);
      pointCollection.removeAll();
    }
  },
  mounted() {
    _this = this;
    this.GetJsonInfo();
  }
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

.pop-fai-follow {
  right: 80px;
}

.pop-fai-follow:hover {
  background-color: #e0960d;
}

.pop-fai-start {
  right: 120px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}
</style>
