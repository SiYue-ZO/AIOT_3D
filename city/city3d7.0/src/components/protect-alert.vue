<template>
  <div id="protect-alert-is-show">
    <div class="pop-fai pop-fai-back" v-on:click="backAlert" title="回放">
      <font-awesome-icon :icon="['fas', 'file-video']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-real" v-on:click="realAlert" title="实时">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-save" v-on:click="saveAlert" title="保存">
      <font-awesome-icon :icon="['far', 'save']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-lose" v-on:click="loseAlert" title="忽略">
      <font-awesome-icon :icon="['far', 'trash-alt']"></font-awesome-icon>
    </div>
    <table id="pop-alert" class="list-tabel" cellspacing="0">
      <tr v-for="(item, index) in perimAlertArr" :key="index" :class="{active:currentIndex === item.id}"
          @click="rowClick(item)">
        <td>
          <div class="alert-add-hid" :title="item.alertAdd">地址：{{ item.alertAdd }}</div>
          <div>&emsp;IP：{{ item.ip }}</div>
          <div>时间：{{ item.date }}</div>
          <div> 类别：
            <select class="alert-select" :id="`type${item.id}`" :value="item.alertSelect"
                    @change="changeSelect(item.id)">
              <option v-for="(option, i) in options" :key="i" :value="option.value">{{ option.label }}</option>
            </select>
          </div>
        </td>
        <td>
          <div class="demo-image__preview">
            <el-image style="max-width: 150px; max-height: 84px" :src="item.alertImg"
                      :preview-src-list="[item.alertImg]"></el-image>
          </div>
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
  import popUtil from "@/utils/pop/popUtil";
  import flvjs from 'flv.js';
  import {
    getVideoByMacUrl,
    getVideoById,
    startVideoConverter,
    stopVideoConvertor,
    insertAlert
  } from "../api/api";
  import {eventBus} from "../main";

  let that;
  let camera_marks = [];
  let preVideoScopePrimitiveArr = [];
  let scratchSetViewMatrix3 = new Cesium.Matrix3();
  let alertJson = {};
  let pmCollection = [];
  let playersArr = [];

  export default {
    name: "protect-alert",
    data() {
      return {
        perimAlertArr: [],
        options: [
          {
            value: "",
            label: "--请选择分类--",
          },
          {
            value: "人员闯入",
            label: "人员闯入",
          },
          {
            value: "车辆闯入",
            label: "车辆闯入",
          },
          {
            value: "超高建筑物",
            label: "超高建筑物（塔吊、高压电缆、天线等）",
          },
          {
            value: "升空物体",
            label: "升空物体（无人机、风筝、气球等）",
          },
          {
            value: "飞鸟",
            label: "飞鸟（野鸟、信鸽等）",
          },
          {
            value: "其它",
            label: "其它（超高树木、烟花爆竹等）",
          },
        ],
        value: "",
        maxTitle: "",
        maxVideoUrl: "",
        currentIndex: 0,
        activeRow: null,
        dialogMaxVideo: false,
        controlsShow: false
      };
    },
    methods: {
      //websocket推送过来的报警数据
      socketAlert(alertData) {
        let params = {
          macUrl: alertData.ip,
        };
        //根据摄像头ip获取摄像头信息
        getVideoByMacUrl(params).then((res) => showAlertInfoByIP(res.data));

        function showAlertInfoByIP(data) {
          that.alarmPoi(data);
          alertData["videoId"] = data.id;
          alertData["alertAdd"] = data.camAdd;
          alertData["alertImg"] = `${common.aiIp}api/ivatCatch/${alertData.image}`;
          alertData["alertPosition"] = data.camPosition;
          alertData["alertSelect"] = "";
          that.perimAlertArr.unshift(alertData);
          that.alarmSound();
          if (alertJson[alertData.ip] === undefined) {
            alertJson[alertData.ip] = 1;
          } else {
            alertJson[alertData.ip] += 1;
          }
        }
      },
      //触发报警后，绘制报警图形、飞到报警视角、绘制报警相机的监控范围
      alarmPoi(data) {
        that = this;
        let elem = viewer.entities.getById("vi" + data.id);
        if (!elem) {
          let position = data.camPosition.split(",");
          let point = Cesium.Cartesian3.fromDegrees(
            Number(position[0]),
            Number(position[1]),
            Number(position[2])
          );
          let imgurl;
          if (data.camType === "3") {
            imgurl = "static/images/pinimg/03.png";
          } else if (data.camType === "1") {
            imgurl = "static/images/pinimg/04.png";
          } else if (data.camType === "2") {
            imgurl = "static/images/pinimg/05.png";
          } else {
            imgurl = "static/images/pinimg/05.png";
          }
          that.createCameraPin(imgurl, data.id, point);
          that.flytoCamView(data.camPosition);
          that.createVideoScope(data);
        }
      },
      //创建报警摄像头点位的闪烁标签
      createCameraPin(url, id, point) {
        let x = 1;
        let flog = true;
        let camera_mark = viewer.entities.add({
          name: "摄像头",
          id: "vi" + id,
          position: point,
          billboard: {
            image: url,
            scale: 0.8,
            color: new Cesium.CallbackProperty(function (time, result) {
              if (flog) {
                x -= 0.05;
                if (x <= 0) {
                  flog = false;
                }
              } else {
                x += 0.05;
                if (x >= 1) {
                  flog = true;
                }
              }
              return Cesium.Color.WHITE.withAlpha(x);
            }, false),
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            disableDepthTestDistance: 200,
          },
        });
        camera_marks.push(camera_mark);
      },
      //创建摄像头可视区域
      createVideoScope(data) {
        let poiArr = data.camPosition.split(",");
        let positionCt3 = Cesium.Cartesian3.fromDegrees(
          poiArr[0],
          poiArr[1],
          poiArr[2]
        );
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
          showHelperPrimitive: true,
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
        let pmObj = {};
        pmObj.id = 'video' + data.id;
        pmObj.primitive = cameraVideo;
        pmCollection.push(pmObj);
        preVideoScopePrimitiveArr.push(cameraVideo);
      },
      //h,p,r转matrix4
      hpr2m(obj, result) {
        // const inverseViewMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(position, headingPitchRoll, undefined, undefined, result);
        const inverseViewMatrix = Cesium.Transforms.eastNorthUpToFixedFrame(
          obj.position,
          undefined,
          result
        );
        // const hpr = new Cesium.HeadingPitchRoll(heading - Cesium.Math.PI_OVER_TWO, pitch, roll);
        // var rotQuat = Cesium.Quaternion.fromHeadingPitchRoll(hpr, scratchSetViewQuaternion);
        // var rotMat = Cesium.Matrix3.fromQuaternion(rotQuat, scratchSetViewMatrix3);
        let rotMat = Cesium.Matrix3.fromRotationX(
          Cesium.Math.PI_OVER_TWO,
          scratchSetViewMatrix3
        );
        Cesium.Matrix4.multiplyByMatrix3(
          inverseViewMatrix,
          rotMat,
          inverseViewMatrix
        );

        rotMat = Cesium.Matrix3.fromRotationY(
          -obj.heading,
          scratchSetViewMatrix3
        );
        Cesium.Matrix4.multiplyByMatrix3(
          inverseViewMatrix,
          rotMat,
          inverseViewMatrix
        );

        rotMat = Cesium.Matrix3.fromRotationX(obj.pitch, scratchSetViewMatrix3);
        Cesium.Matrix4.multiplyByMatrix3(
          inverseViewMatrix,
          rotMat,
          inverseViewMatrix
        );

        rotMat = Cesium.Matrix3.fromRotationZ(-obj.roll, scratchSetViewMatrix3);
        Cesium.Matrix4.multiplyByMatrix3(
          inverseViewMatrix,
          rotMat,
          inverseViewMatrix
        );

        return inverseViewMatrix;
      },
      //创建视频标签
      createVideoElement(videoSrc, id) {
        let videoElement = document.createElement("video");
        videoElement.id = "video" + id;
        videoElement.src = videoSrc + "?t=" + new Date().getTime();
        // videoElement.type = 'video/mp4';
        videoElement.style.position = "absolute";
        videoElement.style.zIndex = "-100";
        videoElement.style.visibility = "hidden";
        videoElement.crossOrigin = "anonymous";
        videoElement.autoplay = true;
        videoElement.loop = true;
        videoElement.muted = true;
        document.getElementById("videoSource").appendChild(videoElement);
        return videoElement;
      },
      //报警声音
      alarmSound() {
        let alarmAudio = document.createElement("audio");
        alarmAudio.autoplay = false;
        alarmAudio.loop = false;
        alarmAudio.src = common.serverIp + 'city3dfile/' + "data/audio/soundAlarm.mp3";
        alarmAudio.play();
      },
      //移动到摄像机视角
      flytoCamView(camPosition) {
        let positionStr = camPosition.split(",");
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(
            Number(positionStr[0]),
            Number(positionStr[1]),
            Number(positionStr[2]) + 600
          ),
        });
      },
      //根据标签id切换成气泡窗，隐藏标签
      getVideoById(id) {
        let popShow = document.getElementById("popupDiv" + id);
        if (!popShow) {
          viewer.entities.getById("vi" + id).show = false;
          let params = {
            id: id,
          };
          getVideoById(params).then((res) =>
            this.dostartVideoConverter(res.data, true)
          );
        }
      },
      //启动视频转码服务
      dostartVideoConverter(node, isinfo) {
        let commandobj = {
          id: node.id,
          camRtsp: node.camRtsp,
          camPort: node.camPort,
          camAdd: window.nginxUrl,
        };
        startVideoConverter(commandobj).then((res) => {
          this.startVideoShow(res.data, node, isinfo);
        });
      },
      //启动转换进程
      startVideoShow(data, node, isinfo) {
        let camUrl;
        let videoType = '';
        if (data) {
          console.log("启动转换命令发送成功！");
          camUrl = node.camUrl;
          videoType = "http";
        } else {
          console.log("转换进程已存在或参数不全！");
          let subUrl = node.camUrl.substring(0, 4);
          if (subUrl === "http") {
            camUrl = node.camUrl;
            videoType = "http";
          } else {
            camUrl = node.camUrl;
            videoType = "local";
          }
        }
        if (isinfo) {
          this.showInfoVideo(node, camUrl, videoType);
        }
      },
      //报警气泡窗
      showInfoVideo(node, camUrl, videoType) {
        let typeStr = "";
        switch (node) {
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
        let pos = node.camPosition.split(",");
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
          viewer: viewer,
          id: node.id,
          popupWidth: 330,
          popupHeight: 225,
          pos: {lon: Number(pos[0]), lat: Number(pos[1]), alt: Number(pos[2])},
          extentHeight: 20,
          extentColor: Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);

        let player;
        if (videoType === "local") {
          player = flvjs.createPlayer({
            type: 'mp4',
            url: camUrl,
            isLive: true,
            enableStashBuffer: false,
          });
        } else {
          player = flvjs.createPlayer({
            type: 'flv',
            url: camUrl,
            isLive: true,
            enableStashBuffer: false,
          });
        }
        player.attachMediaElement(document.getElementById(node.id));
        player.load();
        player.play();
        let playerObj = {};
        playerObj.id = 'video' + node.id;
        playerObj.player = player;
        playersArr.push(playerObj);
      },
      //停止转换进程
      dostopVideoConvertor(id) {
        let params = {
          id: id,
        };
        stopVideoConvertor(params).then((res) => showResult(res.data));

        function showResult(data) {
          if (data) {
            console.log("停止转换命令发送成功！");
          } else {
            console.log("停止转换进程不存在！");
          }
        }
      },
      //选中报警行数据
      rowClick(obj) {
        this.activeRow = obj;
        this.currentIndex = obj.id;
        let positionStr = obj.alertPosition.split(",");
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(
            Number(positionStr[0]),
            Number(positionStr[1]),
            Number(positionStr[2]) + 600
          ),
        });
      },
      //回放视频
      backAlert() {
        if (this.activeRow) {
          this.maxVideoUrl = common.serverIp + 'city3dfile/' + "data/ch011.mp4";
          this.maxTitle = this.activeRow.alertAdd + "报警回放";
          this.controlsShow = true;
          this.dialogMaxVideo = true;
        } else {
          that.$message.warning('请选择报警信息！');
        }
      },
      //实时视频
      realAlert() {
        if (that.activeRow) {
          that.getVideoById(that.activeRow.videoId);
        } else {
          that.$message.warning('请选择报警信息！');
        }
      },
      //保存报警
      saveAlert() {
        if (that.activeRow) {
          let alarmType = document.getElementById("type" + that.activeRow.id).value;
          if (alarmType !== '') {
            let alertObj = {
              'id': that.activeRow.id,
              'ip': that.activeRow.ip,
              'userName': that.activeRow.userName,
              'password': that.activeRow.password,
              'channel': that.activeRow.channel,
              'type': alarmType,
              'date': that.activeRow.date,
            };
            insertAlert(alertObj).then((res) => {
              if (alertJson[that.activeRow.ip] > 1) {
                alertJson[that.activeRow.ip] -= 1;
              } else {
                that.closeAlertVideo(that.activeRow);
              }
              that.perimAlertArr = that.perimAlertArr.filter((item) => {
                return item.id !== that.activeRow.id
              });
              that.activeRow = null;
              that.$message.success('保存成功！');
            });
          } else {
            that.$message.warning('请选择报警类别后再保存！');
          }
        } else {
          that.$message.warning('请选择报警信息！');
        }
      },
      //忽略报警
      loseAlert() {
        if (that.activeRow) {
          that.$confirm('此操作将永久忽略该条报警信息, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            if (alertJson[that.activeRow.ip] > 1) {
              alertJson[that.activeRow.ip] -= 1;
            } else {
              that.closeAlertVideo(that.activeRow);
            }
            that.perimAlertArr = that.perimAlertArr.filter((item) => {
              return item.id !== that.activeRow.id
            });
            that.activeRow = null;
            that.$message.success('忽略成功！');
          }).catch(() => {
            that.$message.info('已取消忽略！');
          });
        } else {
          that.$message.warning('请选择报警信息！');
        }
      },
      //根据摄像头id清除相应的标签、范围、气泡窗
      closeAlertVideo(data) {
        delete alertJson[data.ip];
        this.clearCameraPin(data.videoId);
        this.destroyVideoScope(data.videoId)
      },
      //清除报警信息
      clearAlert() {
        this.clearVideoAll();
        this.clearAllVideoScope();
        this.activeRow = null;
        //this.perimAlertArr = [];
        alertJson = {};
        CesiumPop.clearDivPop(viewer);
      },
      //根据摄像头id删除对应的地图标签
      clearCameraPin(id) {
        viewer.entities.removeById("vi" + id); // 将标注从场景移除
      },
      destroyVideoElement(videoElement) {
        document.getElementById("videoSource").removeChild(videoElement);
      },
      //销毁显示范围
      destroyVideoScope(id) {
        for (let i = 0; i < pmCollection.length; i++) {
          if (pmCollection[i].id === 'video' + id) {
            viewer.scene.primitives.remove(pmCollection[i].primitive);
          }
        }
      },
      //清除摄像头地图标签
      clearVideoAll() {
        for (let i1 = 0; i1 < camera_marks.length; i1++) {
          viewer.entities.remove(camera_marks[i1]); // 将标注从场景移除
        }
        camera_marks.length = 0;
        for (let i = 0; i < that.perimAlertArr.length; i++) {
          let videoElement = document.getElementById("video" + that.perimAlertArr[i].id);
          if (videoElement) {
            this.destroyVideoElement(videoElement);
            for (let i = 0; i < playersArr.length; i++) {
              playersArr[i].player.pause();
              playersArr[i].player.destroy();
              playersArr.splice(i, 1);
            }
          }
        }
      },
      //清除报警区域
      clearAllVideoScope() {
        for (let i = 0; i < preVideoScopePrimitiveArr.length; i++) {
          viewer.scene.primitives.remove(preVideoScopePrimitiveArr[i]);
        }
      },
      //最大化视频窗口
      maxVideo(videoUrl) {
        this.maxVideoUrl = videoUrl;
        this.controlsShow = false;
        this.dialogMaxVideo = true;
      },
      //关闭视频窗口
      closeDialog() {
        this.maxVideoUrl = "";
        this.dialogMaxVideo = false;
      },
      //选择报警类别后赋给对应行的对象
      changeSelect(id) {
        let alarmType = document.getElementById("type" + id).value;
        that.perimAlertArr.map(item => {
          if (item.id === id) {
            item.alertSelect = alarmType;
          }
        })
      }
    },
    created() {
      //通过事件公交获取websocket推送的数据
      eventBus.$on("busAlert", (msg) => {
        this.socketAlert(msg);
      });
      //通过事件公交调取清除报警信息的方法
      eventBus.$on("clearAlert", (msg) => {
        this.clearAlert();
        eventBus.$off("clearAlert");
      });
    },
    mounted() {
      that = this;
      CesiumPop.bindPopGlobeEventHandler(viewer);
      //打开周界报警功能后创建websocket
      eventBus.$emit("creatWebsocket", "");
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

  .pop-fai-back {
    right: 160px;
  }

  .pop-fai-back:hover {
    background-color: #e0960d;
  }

  .pop-fai-real {
    right: 130px;
  }

  .pop-fai-real:hover {
    background-color: #e600c3;
  }

  .pop-fai-save {
    right: 100px;
  }

  .pop-fai-save:hover {
    background-color: #20920a;
  }

  .pop-fai-lose {
    right: 70px;
  }

  .pop-fai-lose:hover {
    background-color: #e6002f;
  }

  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
    font-size: 14px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .list-tabel td {
    padding: 2px 10px;
    cursor: pointer;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #002064;
  }

  .list-tabel tr:hover {
    background-color: #07b6f1;
  }

  .alert-select {
    background: #074457;
    color: white;
    border-radius: 3px;
    height: 24px;
    padding: 0px 4px;
    border: solid 1px rgba(12, 152, 254, 0.3);
    width: 130px;
  }

  .alert-add-hid {
    width: 180px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
</style>
