<template>
  <div id="iot-video-is-show">
    <div class="pop-fai pop-fai-video" v-on:click="city3dvideo" title="0延迟播放器">
      <font-awesome-icon :icon="['fab', 'chromecast']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="vagueEdge" title="边缘模糊" v-show="isEdgeShow">
      <font-awesome-icon :icon="['fas', 'border-none']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetEdge" title="边缘锐化" v-show="!isEdgeShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-i" v-on:click="incompleteProject" title="不完全投影融合"
         v-show="isIncompleteProjectShow">
      <font-awesome-icon :icon="['fas', 'external-link-alt']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-i" v-on:click="incompleteProject" title="完全投影融合"
         v-show="!isIncompleteProjectShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <el-dialog style="overflow: hidden" v-bind:title="camAdd" :visible.sync="hisDialogVisible" width="60%" top="30px"
               center :modal-append-to-body="false" destroy-on-close @before-close="closeHisVideo">
      <el-date-picker v-model="valueTime" value-format="yyyyMMdd HHmmss" type="datetimerange" range-separator="至"
                      :default-time="['12:00:00', '08:00:00']" start-placeholder="开始日期" end-placeholder="结束日期"
                      style="width:90%!important;">
      </el-date-picker>
      <el-button style="float:right" type="primary" @click="initHisPlayer">确 定</el-button>
      <video :id="'hisVideo'+videoId" class="hisVideo" crossorigin="anonymous" muted="muted" loop="loop"
             autoplay="autoplay"></video>
    </el-dialog>
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
import ztree from "vue-giant-tree";
import map3d from "./map-3d";
import popUtil from "@/utils/pop/popUtil";
import flvjs from 'flv.js';
import hlsjs from 'hls.js';
import {getAllandVideoById, getVideo, getVideoById, startVideoConverter, stopVideoConvertor} from "../api/api";

let that;

let pmCollection = [];
let playersArr = [];

let camera_marks = [];
let cameraData = [];

let fixedHandler;

let camMovehandler;
let lockfunction;
let isCamLock = false;//超范围回弹标记，回弹坐标参数
let camLockId;
let pointLock;
let headingLock;
let pitchLock;

let preVideoScopeElement = null;
let preVideoScopePrimitiveArr = [];

let player;

export default {
  name: "iot-video",
  components: {
    ztree
  },
  data() {
    return {
      setting: {},
      nodes: [],
      isEdgeShow: false,
      isIncompleteProjectShow: true,
      valueTime: "",
      camAdd: "",
      hisDialogVisible: false,
      videoId: "",
      hisObj: {}
    }
  },
  methods: {
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
    //销毁视频html标签
    destroyVideoElement(videoElement) {
      document.getElementById("videoSource").removeChild(videoElement);
    },
    //创建视频融合贴地渲染基元
    createCameraVideo(node, videoElement) {
      let poiArr = node.camPosition.split(',');
      let positionCt3 = Cesium.Cartesian3.fromDegrees(poiArr[0], poiArr[1], poiArr[2]);
      // 2.2.2.2 准备inverseViewMatrix
      // 准备inverseViewMatrix是为了定义视频拍摄的相机的姿态(位置和方向)
      // 此处设定为当前相机的欧拉角(heading\pitch\roll)和位置信息
      let inverseViewMatrix = this.hpr2m({
        position: positionCt3,
        heading: Cesium.Math.toRadians(Number(node.camHeading)),
        pitch: Cesium.Math.toRadians(Number(node.camPitch)),
        roll: Cesium.Math.toRadians(Number(node.camRoll)),
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
        showHelperPrimitive: false,
      });
      cameraVideo._primitive.classificationType = 2; // 同时投影地形和3dtiles数据
      let isHole = false;
      if (node.camHoles !== null && node.camHoles.length !== 0) {
        let alphamaterial = new Cesium.Material({
          fabric: {
            type: 'XbsjCameraVideo',
            uniforms: {
              image: '', // Cesium有bug，此处不能直接赋值video
              alphaImage: node.camHoles,
            },
            components: {
              diffuse: 'texture2D(image, fract(materialInput.st)).rgb',
              alpha: 'texture2D(alphaImage, fract(materialInput.st)).r',
            }
          }
        });
        alphamaterial.uniforms.image = videoElement;
        cameraVideo._primitive.appearance.material = alphamaterial;
        isHole = true;
      } else {
        let alphamaterial = new Cesium.Material({
          fabric: {
            type: 'XbsjCameraVideo',
            uniforms: {
              image: '', // Cesium有bug，此处不能直接赋值video
              alphaImage: 'static/images/videoMark.jpg',
            },
            components: {
              diffuse: 'texture2D(image, fract(materialInput.st)).rgb',
              // alpha : 'texture2D(alphaImage, fract(repeat * materialInput.st)).a * color.a'
              alpha: 'texture2D(alphaImage, fract(materialInput.st)).r',
            }
          }
        });
        alphamaterial.uniforms.image = videoElement;
        cameraVideo._primitive.appearance.material = alphamaterial;
      }
      // 2.2.2.5 加入到场景中去
      viewer.scene.primitives.add(cameraVideo);

      let pmObj = {};
      pmObj.id = 'video' + node.id;
      pmObj.isHole = isHole;
      pmObj.primitive = cameraVideo;
      pmCollection.push(pmObj);
    },
    //清除视频投影渲染基元
    destroyCameraVideo(vid) {
      for (let i = 0; i < pmCollection.length; i++) {
        if (vid === pmCollection[i].id) {
          viewer.scene.primitives.remove(pmCollection[i].primitive);
          pmCollection.splice(i, 1);
          break;
        }
      }
    },
    //创建视频目录树
    createZTree(data) {
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
          onCheck: zTreeOnCheck,
          onClick: zTreeOnClick,
          onRightClick: zTreeOnRightClick,
        },
        view: {
          showIcon: false,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [
        {id: "0", name: "视频监控列表(勾选融合、左键气泡、右键定位)", open: true, nocheck: true}
      ];
      for (let i = 0; i < data.length; i++) {
        let node = {};
        node.id = data[i].id;
        node.pid = data[i].camPid;
        node.name = data[i].camAdd;
        node.camAdd = data[i].camAdd;
        node.highlight = false;
        node.camUrl = data[i].camUrl;
        node.camPosition = data[i].camPosition;
        node.camIsnode = data[i].camIsnode;
        node.camFov = data[i].camFov;
        node.camHeading = data[i].camHeading;
        node.camPitch = data[i].camPitch;
        node.camRoll = data[i].camRoll;
        node.camNear = data[i].camNear;
        node.camFar = data[i].camFar;
        node.camAspectratio = data[i].camAspectratio;
        node.camHoles = data[i].camHoles;
        node.camRtsp = data[i].camRtsp;
        node.camPort = data[i].camPort;
        if (!data[i].camIsnode) {
          let position = data[i].camPosition.split(',');
          cameraData.push({
            name: data[i].id,
            value: [Number(position[0]), Number(position[1]), Number(position[2])],
            type: data[i].camType,
            node: node
          });

          let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          let imgurl;
          if (data[i].camType === "3") {
            imgurl = 'static/images/pinimg/03.png';
          } else if (data[i].camType === "1") {
            imgurl = 'static/images/pinimg/04.png';
          } else if (data[i].camType === "2") {
            imgurl = 'static/images/pinimg/05.png';
          } else {
            imgurl = 'static/images/pinimg/05.png';
          }
          let x = 15;
          let flog = true;
          let camera_mark = viewer.entities.add({
            name: '摄像头',
            id: 'ca' + data[i].id,
            position: point,
            billboard: {
              image: imgurl,
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffset: new Cesium.CallbackProperty(function (time, result) {
                //图标闪烁效果
                if (flog) {
                  x -= 0.3;
                  if (x <= 0) {
                    flog = false;
                  }
                } else {
                  x += 0.3;
                  if (x >= 15) {
                    flog = true;
                  }
                }
                return new Cesium.Cartesian2(0.0, x);
              }, false),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
          });
          camera_marks.push(camera_mark);
        } else {
          node.nocheck = true;
        }
        treeNodes.push(node);
      }
      this.nodes = treeNodes;

      function zTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.level !== 0) {
          if (treeNode.checked) {
            that.dostartVideoConverter(treeNode, false);
            that.flytoCamView(treeNode);
            isCamLock = true;
            camLockId = treeNode.id;
            let positionStr = treeNode.camPosition.split(",");
            pointLock = Cesium.Cartesian3.fromDegrees(Number(positionStr[0]), Number(positionStr[1]), Number(positionStr[2]))
            headingLock = Cesium.Math.toRadians(Number(treeNode.camHeading));
            pitchLock = Cesium.Math.toRadians(Number(treeNode.camPitch));
            that.startCamMoveListener();
          } else {
            that.clearVideoOnEarth(treeNode.id);
            that.dostopVideoConvertor(treeNode.id);
            isCamLock = false;
            that.stopCamMoveListener();
          }
        }
      }

      function zTreeOnClick(event, treeId, treeNode) {
        if (!treeNode.camIsnode) {
          if (!document.getElementById('popupDiv' + treeNode.id)) {
            that.dostartVideoConverter(treeNode, true);
            viewer.entities.getById('ca' + treeNode.id).show = false;
          } else {
            that.$message({
              message: '提示，气泡已打开！请勿重复操作！',
              type: 'warning'
            });
          }
        }
      }

      function zTreeOnRightClick(event, treeId, treeNode) {
        if (!treeNode.camIsnode) {
          that.flytoCamView(treeNode);
        }
      }
    },
    //执行视频监控服务接入
    dostartVideoConverter(node, isinfo) {
      let commandobj = {
        "id": node.id,
        "camRtsp": node.camRtsp,
        "camPort": node.camPort,
        "camAdd": window.nginxUrl
      };
      startVideoConverter(commandobj).then(res => {
        this.startVideoShow(res.data, node, isinfo)
      });
    },
    //停止视频监控接入
    dostopVideoConvertor(id) {
      let params = {
        "id": id
      };
      stopVideoConvertor(params).then(res => {
        if (res.data) {
          console.log("停止转换命令发送成功！");
        } else {
          console.log("停止转换进程不存在！");
        }
      });
    },
    //显示视频监控气泡或投影
    startVideoShow(data, node, isinfo) {
      let camUrl;
      let videoType = '';
      if (data) {
        console.log("启动转换命令发送成功！");
        camUrl = node.camUrl;
        videoType = "http";
      } else {
        if (node.camUrl.substring(0, 4) === "http" || node.camUrl.substring(0, 5) === "https") {
          if (node.camUrl.substring(node.camUrl.length - 4, node.camUrl.length) === "m3u8") {
            camUrl = node.camUrl;
            videoType = "hls";
            console.log("视频链接为hls地址！");
          } else if (node.camUrl.substring(node.camUrl.length - 3, node.camUrl.length) === "flv") {
            camUrl = node.camUrl;
            videoType = "http";
            console.log("视频链接为flv地址！");
          } else if (node.camUrl.substring(node.camUrl.length - 3, node.camUrl.length) === "mp4") {
            camUrl = node.camUrl;
            videoType = "local";
            console.log("视频链接为mp4地址！");
          } else {
            camUrl = node.camUrl;
            videoType = "http";
            console.log("转换进程已存在或参数不全！");
          }
        } else {
          camUrl = common.serverIp + 'city3dfile/' + node.camUrl;
          videoType = "local";
          console.log("视频链接为本地地址！");
        }
      }
      if (isinfo) {
        this.showInfoVideo(node, camUrl, videoType);
      } else {
        this.createVideoElement(camUrl, node.id, node.camAspectratio, videoType);
        setTimeout(() => {
          this.createCameraVideo(node, document.getElementById('video' + node.id));
        }, 100);
      }
    },
    //显示视频气泡
    showInfoVideo(node, camUrl, videoType) {
      let typeStr = "";
      switch (node.camType) {
        case "1":
          typeStr = "枪机";
          break;
        case "2":
          typeStr = "球机";
          break;
        case "3":
          typeStr = "识别";
          break;
        case "4":
          typeStr = "高空";
          break;
      }
      let pos = node.camPosition.split(',');
      let popoptions = {
        videoId: node.id,
        camAdd: node.camAdd,
        camUrl: camUrl,
        camType: typeStr,
        camRtsp: node.camRtsp,
        camPort: node.camPort,
        camPosition: node.camPosition,
        camHeading: node.camHeading,
        camPitch: node.camPitch,
        camRoll: node.camRoll,
        type: videoType
      };
      popUtil.installMapPop().videoPop(popoptions);
      let options = {
        "viewer": viewer,
        "id": node.id,
        "popupWidth": 330,
        "popupHeight": 225,
        "pos": {"lon": Number(pos[0]), "lat": Number(pos[1]), "alt": Number(pos[2])},
        "extentHeight": 20,
        "extentColor": Cesium.Color.WHITE,
      };
      CesiumPop.addDivPop(options);

      let player;
      let videoElement = document.getElementById(node.id);
      if (videoType === "local") {
        player = flvjs.createPlayer({
          type: 'mp4',
          url: camUrl,
          isLive: true,
          enableStashBuffer: false,
        });
        player.attachMediaElement(videoElement);
        player.load();
        player.play();
      } else if (videoType === "hls") {
        let hls = new hlsjs();
        hls.loadSource(camUrl);
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
          url: camUrl,
          isLive: true,
          enableStashBuffer: false,
        });
        player.attachMediaElement(videoElement);
        player.load();
        player.play();
      }
      let playerObj = {};
      playerObj.id = 'video' + node.id;
      playerObj.player = player;
      playersArr.push(playerObj);
    },
    //清除视频投影
    clearVideoOnEarth(id) {
      let vid = "video" + id;
      let videoElement = document.getElementById(vid);
      if (videoElement) {
        this.destroyVideoElement(videoElement);
        for (let i = 0; i < playersArr.length; i++) {
          if (vid === playersArr[i].id) {
            // playersArr[i].player.pause();
            playersArr[i].player.destroy();
            playersArr.splice(i, 1);
            break;
          }
        }
      }
      this.destroyCameraVideo(vid);
    },
    //清除摄像头地图标签
    clearVideoAll() {
      for (let i1 = 0; i1 < camera_marks.length; i1++) {
        viewer.entities.remove(camera_marks[i1]); // 将标注从场景移除
      }
      camera_marks.length = 0;
      for (let i = 0; i < pmCollection.length; i++) {
        viewer.scene.primitives.remove(pmCollection[i].primitive);
        let videoElement = document.getElementById(pmCollection[i].id);
        if (videoElement) {
          this.destroyVideoElement(videoElement);
        }
      }
      pmCollection.length = 0;
      fixedHandler = fixedHandler && fixedHandler.destroy();
      isCamLock = false;
    },
    //根据id获取单个视频监控信息
    getVideoById(id) {
      viewer.entities.getById('ca' + id).show = false;
      let params = {
        'id': id
      };
      getVideoById(params).then(res => this.dostartVideoConverter(res.data, true));
    },
    //定点环视
    fixedView(id, lon, lat, height, camHeading, camPitch, camRoll) {
      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(Number(lon), Number(lat), Number(height)),
        orientation: {
          heading: Cesium.Math.toRadians(Number(camHeading)), // 方向
          pitch: Cesium.Math.toRadians(Number(camPitch)),// 倾斜角度
          roll: Cesium.Math.toRadians(Number(camRoll))
        }
      });
      this.lockCamera(false);
      this.stopCamMoveListener();
      this.startRotateOnCam(id, lon, lat, height, camHeading, camPitch, camRoll);
    },
    //锁定摄像机方法
    lockCamera(value) {
      viewer.scene._screenSpaceCameraController.enableLook = value;
      viewer.scene._screenSpaceCameraController.enableTranslate = value;
      viewer.scene._screenSpaceCameraController.enableRotate = value;
      viewer.scene._screenSpaceCameraController.enableZoom = value;
      viewer.scene._screenSpaceCameraController.enableTilt = value;
    },
    //鼠标拖动视角
    startRotateOnCam(id, lon, lat, height, camHeading, camPitch, camRoll) {
      document.getElementById('popupDiv' + id).style.display = 'none';
      viewer.entities.getById("popentity" + id).show = false;
      let heading = Number(camHeading);
      let pitch = Number(camPitch);
      let startMousePosition;
      let mousePosition;
      let flags = false;
      fixedHandler = fixedHandler && fixedHandler.destroy();
      fixedHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      fixedHandler.setInputAction(function (movement) {
        flags = true;
        mousePosition = startMousePosition = Cesium.Cartesian3.clone(movement.position);
      }, Cesium.ScreenSpaceEventType.LEFT_DOWN);

      fixedHandler.setInputAction(function (movement) {
        mousePosition = movement.endPosition;
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);

      fixedHandler.setInputAction(function (position) {
        flags = false;
      }, Cesium.ScreenSpaceEventType.LEFT_UP);

      fixedHandler.setInputAction(function (position) {
        flags = false;
        fixedHandler = fixedHandler && fixedHandler.destroy();
        that.lockCamera(true);
        that.startCamMoveListener();
        document.getElementById('popupDiv' + id).style.display = 'block';
        viewer.entities.getById("popentity" + id).show = true;
      }, Cesium.ScreenSpaceEventType.RIGHT_UP);

      viewer.clock.onTick.addEventListener(function (clock) {
        if (flags) {
          let cwidth = viewer.canvas.clientWidth;
          let cheight = viewer.canvas.clientHeight;
          // Coordinate (0.0, 0.0) will be where the mouse was clicked.
          let x = (mousePosition.x - startMousePosition.x) / cwidth;
          let y = -(mousePosition.y - startMousePosition.y) / cheight;
          if (x > 0.1) {
            heading += 3;
          } else if (x < -0.1) {
            heading -= 3;
          }
          if (y > 0.1) {
            pitch += 1;
          } else if (y < -0.1) {
            pitch -= 1;
          }
          viewer.camera.setView({
            destination: Cesium.Cartesian3.fromDegrees(Number(lon), Number(lat), Number(height)),
            orientation: {
              heading: Cesium.Math.toRadians(heading), // 方向
              pitch: Cesium.Math.toRadians(pitch),// 倾斜角度
              roll: Cesium.Math.toRadians(Number(camRoll))
            }
          });
        }
      });
    },
    //移动到摄像机视角
    flytoCamView(treeNode) {
      let positionStr = treeNode.camPosition.split(",");
      let x = Number(positionStr[0]);
      let y = Number(positionStr[1]);
      let z = Number(positionStr[2]);
      let h = Cesium.Math.toRadians(Number(treeNode.camHeading)); // 方向
      let p = Cesium.Math.toRadians(Number(treeNode.camPitch));// 倾斜角度
      map3d.methods.moveToDegrees(x, y, z, h, p);
    },
    //启动相机移动监听
    startCamMoveListener() {
      camMovehandler = camMovehandler && camMovehandler.destroy();
      camMovehandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      //根据相机画面的变化来判断相机的最佳视角
      lockfunction = function () {
        that.returntoLockPoi();
      };
      viewer.camera.moveEnd.addEventListener(lockfunction);
      //鼠标右键解除超范围回弹控制
      camMovehandler.setInputAction(function (movement) {
        isCamLock = false;
        camLockId = "";
        pointLock = "";
        headingLock = "";
        pitchLock = "";
        camMovehandler = camMovehandler && camMovehandler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      //鼠标经过标签显示视频投影范围
      //改为点击气泡窗按钮显示
      /*camMovehandler.setInputAction(function onMouseMove(movement) {
        if (!isCamLock) {
          let pickedFeature = viewer.scene.pick(movement.endPosition);
          //判断鼠标是否在三维场景内
          if (Cesium.defined(pic1kedFeature)) {
            //判断鼠标是否触碰到标签
            if (pickedFeature.id !== undefined) {
              let currentEntity = viewer.entities.getById(pickedFeature.id._id);
              //排除鼠标触碰到红线
              if (currentEntity !== undefined) {
                if (currentEntity._name !== undefined) {
                  for (let i = 0; i < preVideoScopePrimitiveArr.length; i++) {
                    viewer.scene.primitives.remove(preVideoScopePrimitiveArr[i]);
                  }
                  let params = {
                    "id": currentEntity.id.substring(2)
                  };
                  getVideoById(params).then(res => that.createVideoScope(res.data));
                }
              }
            } else {
              that.closeAllVideoScope();
            }
          }
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);*/
    },
    //停止相机移动监听
    stopCamMoveListener() {
      camMovehandler = camMovehandler && camMovehandler.destroy();
      viewer.camera.moveEnd.removeEventListener(lockfunction);
    },
    //锁定视角：限制查看视频的移动范围
    returntoLockPoi() {
      if (isCamLock) {
        let camPoiR = viewer.camera.position;
        let camHeading = viewer.camera.heading;
        let camPitch = viewer.camera.pitch;
        if (cameraData.length > 0) {
          for (let i = 0; i < cameraData.length; i++) {
            let cameraPoints = Cesium.Cartesian3.fromDegrees(cameraData[i].value[0], cameraData[i].value[1], cameraData[i].value[2]);
            let cameraDistance = Cesium.Cartesian3.distance(camPoiR, cameraPoints);
            //距离不超过10米 方向角度不超过1  倾斜角度不超过1
            if (cameraDistance < 15 && Math.abs(camHeading - Cesium.Math.toRadians(Number(cameraData[i].value[3]))) < 0.3
              && Math.abs(camPitch - Cesium.Math.toRadians(Number(cameraData[i].value[4]))) < 0.3) {
            } else {
              //超出设定范围回弹
              if (cameraData[i].name === camLockId) {
                viewer.camera.setView({
                  destination: pointLock,
                  orientation: {
                    heading: headingLock, // 方向
                    pitch: pitchLock,// 倾斜角度
                    roll: 0
                  }
                });
              } else {
                //注释掉的目的是同时手动打开多个视频
                //videotheVideoTreeObjList.checkNode(videotheVideoTreeObjList.getNodeByParam("id",this.name,null), false, false);
                //videotheVideoTreeObjList.setting.callback.onCheck(null, videotheVideoTreeObjList.setting.treeId, videotheVideoTreeObjList.getNodeByParam("id",this.name,null));
              }
            }
          }
        }
      }
    },
    //只显示监测范围，不显示视频
    createVideoScope(data) {
      // if (preVideoScopeElement != null) {
      //   this.destroyVideoElement(preVideoScopeElement);
      // }
      // preVideoScopeElement = this.createVideoElement("", "videoScope");

      let poiArr = data.camPosition.split(',');
      let positionCt3 = Cesium.Cartesian3.fromDegrees(poiArr[0], poiArr[1], poiArr[2]);
      // 2.2.2.2 准备inverseViewMatrix
      // 准备inverseViewMatrix是为了定义视频拍摄的相机的姿态(位置和方向)
      // 此处设定为当前相机的欧拉角(heading\pitch\roll)和位置信息
      let inverseViewMatrix = this.hpr2m({
        position: positionCt3,
        heading: Cesium.Math.toRadians(Number(data.camHeading)),
        pitch: Cesium.Math.toRadians(Number(data.camPitch)),
        roll: Cesium.Math.toRadians(Number(data.camRoll)),
      });
      // 2.2.2.3 准备frustum，
      // frustum是为了定义投影体的形状
      // frustum选填，可以直接置为undefined
      let frustum = new Cesium.PerspectiveFrustum({
        fov: Cesium.Math.toRadians(Number(data.camFov)),
        aspectRatio: Number(data.camAspectratio),
        near: Number(data.camNear),
        far: Number(data.camFar),
      });
      // 2.2.2.4 根据以上信息创建cameraVideo
      let cameraVideo = new Cesium.XbsjCameraVideo({
        inverseViewMatrix: inverseViewMatrix,
        frustum: frustum,
        videoElement: Cesium.Color.RED.withAlpha(0.2),
        showHelperPrimitive: true
      });
      cameraVideo._primitive.appearance.material = new Cesium.Material({
        fabric: {
          type: 'Color',
          uniforms: {
            color: Cesium.Color.RED.withAlpha(0.2)
          }
        }
      });
      viewer.scene.primitives.add(cameraVideo);
      preVideoScopePrimitiveArr.push(cameraVideo);
    },
    //清除监测范围
    closeAllVideoScope() {
      for (let i = 0; i < preVideoScopePrimitiveArr.length; i++) {
        viewer.scene.primitives.remove(preVideoScopePrimitiveArr[i]);
      }
      preVideoScopePrimitiveArr = [];
    },
    //单独打开视频投影
    putVideo(id) {
      for (let i = 0; i < cameraData.length; i++) {
        if (id === cameraData[i].name) {
          that.dostartVideoConverter(cameraData[i].node, false);
          break;
        }
      }
    },
    //边缘模糊
    vagueEdge() {
      for (let i = 0; i < pmCollection.length; i++) {
        if (!pmCollection[i].isHole) {
          let alphamaterial = new Cesium.Material({
            fabric: {
              type: 'XbsjCameraVideo',
              uniforms: {
                image: '', // Cesium有bug，此处不能直接赋值video
                alphaImage: 'static/images/videoMark.jpg',
              },
              components: {
                diffuse: 'texture2D(image, fract(materialInput.st)).rgb',
                // alpha : 'texture2D(alphaImage, fract(repeat * materialInput.st)).a * color.a'
                alpha: 'texture2D(alphaImage, fract(materialInput.st)).r',
              }
            }
          });
          alphamaterial.uniforms.image = document.getElementById(pmCollection[i].id);
          pmCollection[i].primitive._primitive.appearance.material = alphamaterial;
        }
      }
      this.isEdgeShow = false;
    },
    //边缘锐化
    resetEdge() {
      for (let i = 0; i < pmCollection.length; i++) {
        if (!pmCollection[i].isHole) {
          let alphamaterial = new Cesium.Material({
            fabric: {
              type: 'XbsjCameraVideo',
              uniforms: {
                image: '', // Cesium有bug，此处不能直接赋值video
                alphaImage: 'static/images/videoMarkFull.jpg',
              },
              components: {
                diffuse: 'texture2D(image, fract(materialInput.st)).rgb',
                // alpha : 'texture2D(alphaImage, fract(repeat * materialInput.st)).a * color.a'
                alpha: 'texture2D(alphaImage, fract(materialInput.st)).r',
              }
            }
          });
          alphamaterial.uniforms.image = document.getElementById(pmCollection[i].id);
          pmCollection[i].primitive._primitive.appearance.material = alphamaterial;
        }
      }
      this.isEdgeShow = true;
    },
    //不完全投影，遮挡三维模型
    incompleteProject() {
      if (this.isIncompleteProjectShow) {
        document.getElementById('videoSource').style.display = 'block';
        this.lockCamera(false);
      } else {
        document.getElementById('videoSource').style.display = 'none';
        this.lockCamera(true);
      }
      this.isIncompleteProjectShow = !this.isIncompleteProjectShow;
    },
    //打开0延迟播放器
    city3dvideo() {
      window.location.href = 'city3dvideo://';
    },
    //打开视频回放对话框
    openVideoHisDialog(hisObj) {
      that.hisDialogVisible = true;
      that.camAdd = hisObj.camAdd;
      that.videoId = hisObj.videoId;
      that.hisObj = hisObj;
    },
    initHisPlayer() {
      let startTime = that.valueTime[0].split(" ")[0] + "t" + that.valueTime[0].split(" ")[1] + "z";
      let endTime = that.valueTime[1].split(" ")[0] + "t" + that.valueTime[1].split(" ")[1] + "z";
      let camRtsp = that.hisObj.camRtsp !== "" && that.hisObj.camRtsp !== null ? that.hisObj.camRtsp + "?starttime=" + startTime + "?endtime=" + endTime : "";
      let commandobj = {
        "id": that.videoId,
        "camRtsp": camRtsp,
        "camPort": that.hisObj.camPort,
        "camAdd": window.nginxUrl
      };
      startVideoConverter(commandobj).then(res => {
        let videoElement = document.getElementById("hisVideo" + that.videoId);
        if (res.data) {
          console.log("启动转换命令发送成功！");
          player = flvjs.createPlayer({
            type: 'flv',
            url: that.hisObj.camUrl,
            isLive: true,
            enableStashBuffer: false,
          });
          player.attachMediaElement(videoElement);
          player.load();
          player.play();
        } else {
          if (that.hisObj.type === "local") {
            player = flvjs.createPlayer({
              type: 'mp4',
              url: that.hisObj.camUrl,
              isLive: true,
              enableStashBuffer: false,
            });
            player.attachMediaElement(videoElement);
            player.load();
            player.play();
          } else if (that.hisObj.type === "hls") {
            let hls = new hlsjs();
            hls.loadSource(that.hisObj.camUrl);
            hls.attachMedia(videoElement);
            hls.on(hlsjs.Events.MANIFEST_PARSED, () => {
              console.log('加载成功');
            });
            hls.on(hlsjs.Events.ERROR, (event, data) => {
              // 监听出错事件
              console.log('加载失败');
            });
          }
        }
      });
    },
    closeHisVideo() {
      // player.pause();
      player.destroy();
      that.hisDialogVisible = false;
    }
  },
  mounted() {
    if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
      let params = {
        isIndoor: "false"
      };
      getVideo(params).then(res => this.createZTree(res.data));
    } else {
      let params = {
        'roleId': localStorage.getItem("roleId"),
        'roleName': "false"
      };
      getAllandVideoById(params).then(res => {
        let resultArr = [];
        res.data.sysRoleVideo.map(item => {
          resultArr.push(item.video);
        });
        this.createZTree(resultArr)
      });
    }
    CesiumPop.bindPopGlobeEventHandler(viewer);
    that = this;
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

.pop-fai-video {
  right: 160px;
}

.pop-fai-video:hover {
  background-color: #38b61f;
}

.pop-fai-i {
  right: 120px;
}

.pop-fai-i:hover {
  background-color: #e6002f;
}

.hisVideo {
  height: 100%;
  width: 100%;
  object-fit: fill;
  overflow: hidden;
  margin-top: 10px;
}
</style>
