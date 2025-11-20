<template>
  <div id="iot-uav-is-show">
    <div class="pop-fai pop-fai-follow" v-on:click="startFollow" title="开始跟随" v-show="isFollow">
      <font-awesome-icon :icon="['fab', 'chromecast']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="stopFollow" title="停止跟随" v-show="!isFollow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="openVideo" title="开启投影" v-show="isVideo">
      <font-awesome-icon :icon="['fas', 'video']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="closeVideo" title="关闭投影" v-show="!isVideo">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="openInfo" title="开启信息" v-show="isInfo">
      <font-awesome-icon :icon="['fas', 'info']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="closeInfo" title="关闭信息" v-show="!isInfo">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">同步时差（秒）</div>
      <el-input class="emer-input" v-model="syncTime" placeholder="同步时差" size="small"></el-input>
    </div>
    <ztree :nodes="nodes" :setting="setting"/>
    <div class="uav-list">
      <table class="uav-table" v-for="item in uavResultArr" :id="item.uavId" :key="item.uavId"
             v-on:click="flytoUav(item.uavId)">
        <tr>
          <td colspan="4">{{ item.name }}</td>
          <td colspan="2">{{ item.time }}</td>
        </tr>
        <tr>
          <td :id="'icon1-'+item.uavId" style="font-size:18px;text-align:center;color:#00cb11;display: block">
            <font-awesome-icon :icon="['fas', 'battery-full']" fixed-width></font-awesome-icon>
          </td>
          <td :id="'icon2-'+item.uavId" style="font-size:18px;text-align:center;color:yellow;display: none">
            <font-awesome-icon :icon="['fas', 'battery-half']" fixed-width></font-awesome-icon>
          </td>
          <td :id="'icon3-'+item.uavId" style="font-size:18px;text-align:center;color:red;display: none">
            <font-awesome-icon :icon="['fas', 'battery-quarter']" fixed-width></font-awesome-icon>
          </td>
          <td :id="'elec-'+item.uavId">{{ item.batterValue }} %</td>
          <td class="td-label">飞行状态</td>
          <td>{{ item.flyState }}</td>
          <td class="td-label">相机状态</td>
          <td>{{ item.isVideoOn }}</td>
        </tr>
        <tr>
          <td class="td-label">卫星数量</td>
          <td>{{ item.satelliteCount }}</td>
          <td class="td-label">起飞时间</td>
          <td colspan="3">{{ item.flightTimeInSeconds }}秒</td>
        </tr>
        <tr>
          <td class="td-label">经度</td>
          <td>{{ item.lng }}°</td>
          <td class="td-label">纬度</td>
          <td>{{ item.lat }}°</td>
          <td class="td-label">高程</td>
          <td>{{ item.alt }}米</td>
        </tr>
        <tr>
          <td class="td-label">偏航角</td>
          <td>{{ item.yawValue }}°</td>
          <td class="td-label">俯仰角</td>
          <td>{{ item.pitchValue }}°</td>
          <td class="td-label">滚转角</td>
          <td>{{ item.rollValue }}°</td>
        </tr>
        <tr>
          <td class="td-label">经向速度</td>
          <td>{{ item.velocityX }}</td>
          <td class="td-label">纬向速度</td>
          <td>{{ item.velocityY }}</td>
          <td class="td-label">垂直速度</td>
          <td>{{ item.velocityZ }}</td>
        </tr>
        <tr>
          <td class="td-label">相机水平角</td>
          <td>{{ item.cYam }}°</td>
          <td class="td-label">相机俯仰角</td>
          <td>{{ item.cPitch }}°</td>
          <td class="td-label">相机滚转角</td>
          <td>{{ item.cRoll }}°</td>
        </tr>
        <tr>
          <td class="td-label">相机视场角</td>
          <td>{{ item.camFov }}°</td>
          <td class="td-label">相机焦距</td>
          <td>{{ item.camNear }}米</td>
          <td class="td-label">相机视距</td>
          <td>{{ item.camFar }}米</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import ztree from "vue-giant-tree";
import {getAllandUavById, getUav, getUavPosByUavId} from "../api/api";
import flvjs from 'flv.js';
import hlsjs from 'hls.js';
import {eventBus} from "../main";

let that;
let uavArr = [];
let uavInterval;
let uavi;
let uavlistener;
let curUavList = [];
let curUavNameList = [];
let lastPoint = [];

let pmCollection = [];
let playersArr = [];

let property = new Cesium.SampledPositionProperty();

export default {
  name: "iot-uav",
  components: {
    ztree
  },
  data() {
    return {
      setting: {},
      nodes: [],
      isFollow: true,
      isVideo: true,
      isInfo: true,
      curUavId: "",
      uavResultArr: [],
      syncTime: 3
    }
  },
  methods: {
    //创建无人机目录树
    createUavZTree(data) {
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
          onCheck: zTreeChecked,
          onClick: zTreeOnClick,
        },
        view: {
          showIcon: true,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [{
        id: 0,
        pId: "",
        name: "无人机目录（视频回传）",
        isNode: false,
        open: true,
        nocheck: true,
        icon: "static/images/treeicon/subject.png"
      }];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].uavId;
        treeObj.pid = 0;
        treeObj.name = data[i].uavName + "(" + data[i].uavType + ")：" + data[i].uavModel;
        treeObj.highlight = false;
        treeObj.isNode = true;
        treeObj.uavName = data[i].uavName;
        treeObj.uavType = data[i].uavType;
        treeObj.uavModel = data[i].uavModel;
        treeObj.uavProperty = data[i].uavProperty;
        treeObj.uavDate = data[i].uavDate;
        treeObj.uavElec = data[i].uavElec;
        treeObj.uavCamType = data[i].uavCamType;
        treeObj.uavUrl = data[i].uavUrl;
        treeObj.realDate = data[i].realDate;
        treeObj.icon = "static/images/treeicon/uav.png";
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function zTreeChecked(event, treeId, treeNode) {
        if (treeNode.level === 0) {
          return;
        }
        if (treeNode.checked) {
          if (curUavList.length === 0 || curUavList.indexOf(treeNode.id) === -1) {
            curUavList.push(treeNode.id);
            curUavNameList.push(treeNode.name);
            that.curUavId = treeNode.id;
            freshUav(curUavList);//定位
            //从数据库中获取当前位置的第一个点
            let params = {
              "uavId": treeNode.id
            };
            getUavPosByUavId(params).then(res => {
              let data = res.data[0];
              that.startVideoShow(treeNode, data);
              res.data[0].realDate = new Date().toISOString();
              that.freshUavPos(res.data);

              let pointObj = {};
              pointObj.id = data.uavId;
              let point = Cesium.Cartesian3.fromDegrees(
                Number(data.droneLocationLng),
                Number(data.droneLocationLat),
                Number(data.droneLocationArt));
              pointObj.point = point;
              pointObj.realData = data;
              lastPoint.push(pointObj);
            });
          }
        } else {
          curUavList.splice(curUavList.indexOf(treeNode.id), 1);
          curUavNameList.splice(curUavNameList.indexOf(treeNode.name), 1);
          for (let i = 0; i < lastPoint.length; i++) {
            if (treeNode.id === lastPoint[i].id) {
              lastPoint.splice(i, 1);
              break;
            }
          }
          viewer.entities.removeById(treeNode.id);
          that.clearVideoOnEarth(treeNode.id);
          let uavResultIds = [];
          that.uavResultArr.map(item1 => {
            uavResultIds.push(item1.uavId);
          });
          let num = uavResultIds.indexOf(treeNode.id);
          if (num > -1) {
            that.uavResultArr.splice(num, 1);
          }
        }
      }

      //目录树点击定位方法
      function zTreeOnClick(event, treeId, treeNode) {
        that.flytoUav(treeNode.id);
      }

      //通过轮巡数据库方式获取实时定位
      uavi = -1;
      uavInterval = window.setInterval(function () {
        if (uavi > 3) {
          uavi = -1;
        }
        freshUav(curUavList);
      }, 10000);

      function freshUav(curUavList) {
        if (uavInterval !== undefined) {
          if (curUavList.length === 0) {
            that.deleteUavMarks();
            return;
          }
          if (uavi > -1) {
            let syncDate = new Date(new Date().getTime() + 10 * 1000).toISOString();// 根据轮巡的间隔添加增量时间
            uavPosData[uavi][0].realDate = syncDate;
            that.freshUavPos(uavPosData[uavi]);
          }
          uavi++;
        } else {
          that.deleteUavMarks();
        }
      }

      //每一帧渲染时的监听，取到无人机的位置，更新视频投影位置
      uavlistener = function (scene, time) {
        if (uavi > -1) {
          for (let i = 0; i < pmCollection.length; i++) {
            let timerPos = viewer.entities.getById(pmCollection[i].id.substring(5, pmCollection[i].id.length));
            if (timerPos && timerPos.position._property && timerPos.position._property._interpolationResult[0]) {
              let interPosArr = timerPos.position._property._interpolationResult;
              for (let j = 0; j < lastPoint.length; j++) {
                if (lastPoint[j].id === pmCollection[i].id.substring(5, pmCollection[i].id.length)) {
                  let obj = {};
                  obj.position = Cesium.Cartesian3.fromElements(interPosArr[0], interPosArr[1], interPosArr[2]);
                  obj.heading = Cesium.Math.toRadians(lastPoint[j].realData.cYam);
                  obj.pitch = Cesium.Math.toRadians(lastPoint[j].realData.cPitch);
                  obj.roll = Cesium.Math.toRadians(lastPoint[j].realData.cRoll);
                  pmCollection[i].primitive.inverseViewMatrix = that.hpr2m(obj);
                  break;
                }
              }
            }
          }
        }
      };
      viewer.scene.preUpdate.addEventListener(uavlistener);
    },
    initClock() {
      let startTime = Cesium.JulianDate.now();
      let stopTime = Cesium.JulianDate.addSeconds(startTime, 3600, new Cesium.JulianDate());
      viewer.clock.startTime = startTime.clone();
      viewer.clock.stopTime = stopTime.clone();
      viewer.clock.currentTime = startTime.clone();
      viewer.clock.clockRange = Cesium.ClockRange.UNBOUNDED;
      viewer.clock.multiplier = 1;
      viewer.timeline.zoomTo(startTime, stopTime);
    },
    initWs() {
      //通过Websocket和事件公交触发更新无人机定位
      eventBus.$on("uav_real_data", (message) => {
        let uavResultIds = [];
        that.uavResultArr.map(item1 => {
          uavResultIds.push(item1.uavId);
        });
        let num = uavResultIds.indexOf("1c0d7a2cb1674f17820d9d8ce7883abb");
        if (num > -1) {
          message.uavId = "1c0d7a2cb1674f17820d9d8ce7883abb";
          let syncDate = new Date(new Date().getTime() + Number(that.syncTime) * 1000).toISOString();
          message.realDate = syncDate;
          message.camFov = 95;
          message.camNear = 0.05;
          message.camFar = 1000;
          message.camAspectratio = 1.777778;
          message.isVideoOn = true;
          if (message.droneLocationLng === null) {
            message.droneLocationLng = 126.61555851126096 + Math.random() * 0.001;
            message.droneLocationLat = 45.71527930020664 + Math.random() * 0.001;
            message.droneLocationArt = 286.74603777096195 + Math.random() * 0.001;
          }
          that.freshUavPos([message]);
        }
      });
    },
    //刷新无人机位置
    freshUavPos(realdata) {
      realdata.map(item => {
        //更新无人机位置
        let curUavNum = curUavList.indexOf(item.uavId);
        if (curUavNum > -1) {
          let point = Cesium.Cartesian3.fromDegrees(
            Number(item.droneLocationLng),
            Number(item.droneLocationLat),
            Number(item.droneLocationArt));
          let heading = Cesium.Math.toRadians(item.yawValue);
          let pitch = Cesium.Math.toRadians(item.pitchValue);
          let roll = Cesium.Math.toRadians(item.rollValue);
          let hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);
          let orientation = Cesium.Transforms.headingPitchRollQuaternion(point, hpr);
          let isVideoOn = item.isVideoOn ? "开" : "关";
          let flyState = item.flyState === 1 ? "着陆" : "飞行";
          let realDate = (new Date(item.realDate)).pattern("yyyy-MM-dd hh:mm:ss");
          let uavPin = viewer.entities.getById(item.uavId);
          if (uavPin === undefined) {
            property.addSamples([Cesium.JulianDate.fromIso8601(item.realDate)], [point]);
            uavArr.push(viewer.entities.add({
                id: item.uavId,
                position: property,// 位置
                orientation: orientation,
                model: {
                  uri: common.serverIp + 'city3dfile/data/model/air/rUAVa.gltf',// 模型路径
                  minimumPixelSize: 48,// 模型最小刻度
                  maximumSize: 128,
                  maximumScale: 200,// 设置模型最大放大大小
                  silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
                  silhouetteSize: 0.7,
                  color: Cesium.Color.fromCssColorString("#9e9e9e"),// 模型颜色  ，这里可以设置颜色的变化
                  debugWireframe: false,// 仅用于调试，显示魔仙绘制时的线框
                  debugShowBoundingVolume: false,// 仅用于调试。显示模型绘制时的边界球。
                  scale: 0.5,
                  runAnimations: true, // 是否运行模型中的动画效果
                  shadows: Cesium.ShadowMode.DISABLED,
                  imageBasedLightingFactor: new Cesium.Cartesian2(3.0, 1.0),
                },
                label: {
                  show: false,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
                  font: 'bold 48px Helvetica',
                  scale: 0.3,
                  style: Cesium.LabelStyle.FILL,
                  fillColor: Cesium.Color.WHITE,
                  text: realDate + "\n" +
                    "当前电量: " + item.batterValue + " %\n" +
                    "飞行状态: " + flyState + "\n" +
                    "相机状态: " + isVideoOn,
                  pixelOffset: new Cesium.Cartesian2(65.0, 52.0),
                  disableDepthTestDistance: 100000000,
                  scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                },
                billboard: {
                  show: false,
                  image: "static/images/pinimg/36.png",
                  scale: 0.8,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
                  pixelOffset: new Cesium.Cartesian2(0.0, 88.0),
                  scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  disableDepthTestDistance: 1,
                },
              })
            );
          } else {
            for (let i = 0; i < lastPoint.length; i++) {
              if (lastPoint[i].id === item.uavId) {
                let nodes = [lastPoint[i].point, point];
                let times = [Cesium.JulianDate.fromIso8601(lastPoint[i].realData.realDate),
                  Cesium.JulianDate.fromIso8601(item.realDate)];
                property.addSamples(times, nodes);
                uavPin.orientation = orientation;

                uavPin.label.text = realDate + "\n" +
                  "当前电量: " + item.batterValue + " %\n" +
                  "飞行状态: " + flyState + "\n" +
                  "相机状态: " + isVideoOn;
                lastPoint[i].point = point;
                lastPoint[i].realData = item;
                break;
              }
            }
          }
          //更新仪表盘参数
          let uavResult = item;
          uavResult.isVideoOn = isVideoOn;
          uavResult.flyState = flyState;
          uavResult.lng = Number(item.droneLocationLng).toFixed(4);
          uavResult.lat = Number(item.droneLocationLat).toFixed(4);
          uavResult.alt = Number(item.droneLocationArt).toFixed(1);
          uavResult.time = realDate;

          let uavResultIds = [];
          this.uavResultArr.map(item1 => {
            uavResultIds.push(item1.uavId);
          });
          let num = uavResultIds.indexOf(item.uavId);
          uavResult.name = curUavNameList[curUavNum];
          if (num > -1) {
            this.$set(this.uavResultArr, num, uavResult);
          } else {
            this.uavResultArr.push(uavResult);
          }
          setTimeout(() => {
            document.getElementById('icon1-' + item.uavId).style.display = "none";
            document.getElementById('icon2-' + item.uavId).style.display = "none";
            document.getElementById('icon3-' + item.uavId).style.display = "none";
            if (Number(item.batterValue) >= 70) {
              document.getElementById('elec-' + item.uavId).style.color = "#00cb11";
              document.getElementById('icon1-' + item.uavId).style.display = "block";
            } else if (Number(item.batterValue) < 70 && Number(item.batterValue) >= 30) {
              document.getElementById('elec-' + item.uavId).style.color = "yellow";
              document.getElementById('icon2-' + item.uavId).style.display = "block";
            } else {
              document.getElementById('elec-' + item.uavId).style.color = "red";
              document.getElementById('icon3-' + item.uavId).style.display = "block";
            }
          }, 100);
        }
      });
    },
    //清除图标
    deleteUavMarks() {
      for (let i = 0; i < uavArr.length; i++) {
        viewer.entities.remove(uavArr[i]); // 将标注从场景移除
      }
      uavArr.length = 0;
      curUavList.length = 0;
      curUavNameList.length = 0;
      lastPoint.length = 0;
    },
    flytoUav(id) {
      let target = viewer.entities.getById(id);
      if (target) {
        viewer.flyTo(target, {
          offset: new Cesium.HeadingPitchRange(0, -1, 500)
        });
      }
    },
    //初始化视频
    startVideoShow(treeNode, data) {
      let uavUrl;
      let videoType = '';
      if (treeNode.uavUrl.substring(0, 4) === "http" || treeNode.uavUrl.substring(0, 5) === "https") {
        if (treeNode.uavUrl.substring(treeNode.uavUrl.length - 4, treeNode.uavUrl.length) === "m3u8") {
          uavUrl = treeNode.uavUrl;
          videoType = "hls";
          console.log("视频链接为hls地址！");
        } else if (treeNode.uavUrl.substring(treeNode.uavUrl.length - 3, treeNode.uavUrl.length) === "mp4") {
          uavUrl = treeNode.uavUrl;
          videoType = "local";
          console.log("视频链接为mp4地址！");
        } else {
          uavUrl = treeNode.uavUrl;
          videoType = "http";
          console.log("转换进程已存在或参数不全！");
        }
      } else {
        uavUrl = common.serverIp + 'city3dfile/' + treeNode.uavUrl;
        videoType = "local";
        console.log("视频链接为本地地址！");
      }

      that.createVideoElement(uavUrl, data.uavId, data.camAspectratio, videoType);
      setTimeout(() => {
        that.createCameraVideo(data, document.getElementById('video' + data.uavId));
      }, 100);
    },
    //创建视频html标签
    createVideoElement(videoSrc, id, as, videoType) {
      let videoElement = document.createElement('video');
      videoElement.id = 'video' + id;
      videoElement.style.position = 'absolute';
      videoElement.style.zIndex = '100';
      //videoElement.style.visibility = 'hidden';
      let veHeight = viewer.canvas.clientHeight;
      videoElement.style.height = veHeight + 'px';
      let veWidth = Number(veHeight) * Number(as);
      videoElement.style.width = veWidth + 'px';
      videoElement.style.left = (Number(viewer.canvas.clientWidth) - veWidth) / 2 + 'px';
      videoElement.crossOrigin = 'anonymous';
      videoElement.autoplay = true;
      videoElement.loop = 'loop';
      videoElement.muted = 'muted';
      document.getElementById("videoSource").appendChild(videoElement);

      let player;
      if (videoType === "local") {
        player = flvjs.createPlayer({
          type: 'mp4',
          url: videoSrc,
          isLive: true,
          enableStashBuffer: false,
        });
        player.attachMediaElement(videoElement);
        player.load();
        player.play();
        player.muted = true;
      } else if (videoType === "hls") {
        let hls = new hlsjs();
        hls.loadSource(videoSrc);
        hls.attachMedia(videoElement);
        hls.on(hlsjs.Events.MANIFEST_PARSED, () => {
          console.log('加载成功');
        });
        hls.on(hlsjs.Events.ERROR, (event, data) => {
          // 监听出错事件
          console.log('加载失败');
        });
      } else {
        player = flvjs.createPlayer({
          type: 'flv',
          url: videoSrc,
          isLive: true,
          enableStashBuffer: false,
        });
        player.attachMediaElement(videoElement);
        player.load();
        player.play();
        player.muted = true;
      }
      let playerObj = {};
      playerObj.id = 'video' + id;
      playerObj.player = player;
      playersArr.push(playerObj);
    },
    //h,p,r转matrix4，根据参数计算姿态矩阵
    hpr2m(obj, result) {
      let scratchSetViewQuaternion = new Cesium.Quaternion();
      let scratchSetViewMatrix3 = new Cesium.Matrix3();
      // const inverseViewMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(position, headingPitchRoll, undefined, undefined, result);
      const inverseViewMatrix = Cesium.Transforms.eastNorthUpToFixedFrame(obj.position, undefined, result);
      // const hpr = new Cesium.HeadingPitchRoll(heading - Cesium.Math.PI_OVER_TWO, pitch, roll);
      // var rotQuat = Cesium.Quaternion.fromHeadingPitchRoll(hpr, scratchSetViewQuaternion);
      // var rotMat = Cesium.Matrix3.fromQuaternion(rotQuat, scratchSetViewMatrix3);
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
    //创建视频融合贴地渲染基元
    createCameraVideo(node, videoElement) {
      let positionCt3 = Cesium.Cartesian3.fromDegrees(
        Number(node.droneLocationLng),
        Number(node.droneLocationLat),
        Number(node.droneLocationArt));
      // 2.2.2.2 准备inverseViewMatrix
      // 准备inverseViewMatrix是为了定义视频拍摄的相机的姿态(位置和方向)
      // 此处设定为当前相机的欧拉角(heading\pitch\roll)和位置信息
      let inverseViewMatrix = this.hpr2m({
        position: positionCt3,
        heading: Cesium.Math.toRadians(Number(node.cYam)),
        pitch: Cesium.Math.toRadians(Number(node.cPitch)),
        roll: Cesium.Math.toRadians(Number(node.cRoll)),
      });

      // 2.2.2.3 准备frustum，
      // frustum是为了定义投影体的形状
      // frustum选填，可以直接置为undefined
      let frustum = new Cesium.PerspectiveFrustum({
        fov: Cesium.Math.toRadians(Number(node.camFov)),
        aspectRatio: Number(node.camAspectratio),
        near: Number(node.camNear),
        far: Number(node.camFar),
      });

      // 2.2.2.4 根据以上信息创建cameraVideo
      let cameraVideo = new Cesium.XbsjCameraVideo({
        inverseViewMatrix: inverseViewMatrix,
        frustum: frustum,
        videoElement: videoElement,
        showHelperPrimitive: true,
      });
      cameraVideo._primitive.classificationType = 2; // 同时投影地形和3dtiles数据
      // 2.2.2.5 加入到场景中去
      viewer.scene.primitives.add(cameraVideo);
      cameraVideo.show = false;

      let pmObj = {};
      pmObj.id = 'video' + node.uavId;
      pmObj.primitive = cameraVideo;
      pmCollection.push(pmObj);
    },
    //清除视频投影
    clearVideoOnEarth(id) {
      let vid = "video" + id;
      //清除element
      let videoElement = document.getElementById(vid);
      if (videoElement) {
        document.getElementById("videoSource").removeChild(videoElement);
        for (let i = 0; i < playersArr.length; i++) {
          if (vid === playersArr[i].id) {
            playersArr[i].player.destroy();
            playersArr.splice(i, 1);
            break;
          }
        }
      }
      //清除投影
      for (let i = 0; i < pmCollection.length; i++) {
        if (vid === pmCollection[i].id) {
          viewer.scene.primitives.remove(pmCollection[i].primitive);
          pmCollection.splice(i, 1);
          break;
        }
      }
    },
    //停止获取定位的计时器
    stopFreshUavPos() {
      window.clearInterval(uavInterval);
      uavInterval = undefined;
      uavi = -1;
    },
    //清除所有图形和视频
    closeIotUav() {
      this.deleteUavMarks();
      this.stopFreshUavPos();
      //清除视频
      for (let i = 0; i < pmCollection.length; i++) {
        viewer.scene.primitives.remove(pmCollection[i].primitive);
        let videoElement = document.getElementById(pmCollection[i].id);
        if (videoElement) {
          document.getElementById("videoSource").removeChild(videoElement);
        }
      }
      pmCollection.length = 0;
      this.stopFollow();
      viewer.scene.preUpdate.removeEventListener(uavlistener);
    },
    //开始跟踪
    startFollow() {
      this.isFollow = !this.isFollow;
      let curUav = viewer.entities.getById(this.curUavId);
      if (curUav) {
        curUav.viewFrom = new Cesium.Cartesian3(0, -350, 500);
        viewer.trackedEntity = curUav;
      }
    },
    //停止跟踪
    stopFollow() {
      this.isFollow = !this.isFollow;
      viewer.trackedEntity = undefined;
    },
    //开启视频投影
    openVideo() {
      this.isVideo = !this.isVideo;
      pmCollection.map(item => {
        item.primitive.show = true;
      });
    },
    //关闭视频投影
    closeVideo() {
      this.isVideo = !this.isVideo;
      pmCollection.map(item => {
        item.primitive.show = false;
      });
    },
    //开启信息气泡
    openInfo() {
      this.isInfo = !this.isInfo;
      uavArr.map(item => {
        item.label.show = true;
        item.billboard.show = true;
      });
    },
    //关闭信息气泡
    closeInfo() {
      this.isInfo = !this.isInfo;
      uavArr.map(item => {
        item.label.show = false;
        item.billboard.show = false;
      });
    }
  },
  mounted() {
    that = this;
    if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
      getUav().then(res => {
        this.createUavZTree(res.data);
        this.initClock();
        this.initWs();
      });
    } else {
      let params = {
        'roleId': localStorage.getItem("roleId"),
      };
      getAllandUavById(params).then(res => {
        let resultArr = [];
        res.data.sysRoleUav.map(item => {
          resultArr.push(item.uav);
        });
        this.createUavZTree(resultArr);
        this.initClock();
        this.initWs();
      });
    }
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

.pop-fai-stop {
  right: 160px;
}

.pop-fai-stop:hover {
  background-color: #e6002f;
}

.uav-list {
  position: absolute;
  top: 425px;
  left: 8px;
  background-color: #11264dd1;
  width: 390px;
  height: 480px;
  border-radius: 10px;
  border: 4px solid #025c95;
  color: white;
  font-size: 12px;
  overflow-y: auto;
}

.uav-list table {
  width: 100%;
}

.uav-list td {
  padding: 1px 2px;
  cursor: pointer;
  height: 22px;
}

.uav-list tr:nth-child(odd) {
  background: #004c5abb;
}

.uav-list tr:nth-child(even) {
  background: #091d46bb;
}

.uav-table {
  margin-bottom: 10px;
  border-top: 1px solid #025c95;
  border-bottom: 1px solid #025c95;
}

.uav-list::-webkit-scrollbar {
  width: 8px !important; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px !important;
}

.uav-list::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px !important;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
  background: #00ffff33 !important;
}

.uav-list::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
  border-radius: 0 !important;
  background: rgba(0, 0, 0, 0.2) !important;
}

.td-label {
  color: #eeeeee
}

.emer-row {
  color: #ffffff;
  margin: 8px 0;
}

.emer-row-label {
  width: 120px;
  font-size: 16px;
  margin-top: 8px;
  float: left;
}

.emer-input {
  width: 50px;
}
</style>
