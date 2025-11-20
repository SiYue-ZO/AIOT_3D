<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width:leftWidth,height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                     @click="addData('formData')">
            添 加
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData('formData')">编 辑
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        </div>
        <div v-show="!isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <ztree :nodes="nodes" :setting="setting"/>
      </div>
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
          <el-form-item label="是否节点" prop="camPosition">
            <el-switch v-model="formIsNotNode" active-color="#13ce66" active-text="否" inactive-text="是"></el-switch>
          </el-form-item>
          <el-form-item label="父节点" prop="camPid">
            <el-select v-model="formData.camPid" placeholder="请选择父节点">
              <el-option v-for="item in nodeSelect" :key="item.id" :value="item.id" :label="item.camAdd"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="监控位置" prop="camAdd">
            <el-input v-model="formData.camAdd" placeholder="请填写视频监控设备位置" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="设备坐标" prop="camPosition" v-show="formIsNotNode">
            <el-input v-model="formData.camPosition" placeholder="请填写或在地图中选取设备坐标，左键点选、右键确定"
                      style="width: 80%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width title="选取坐标"
                               @click="configurePoi"></font-awesome-icon>
            <font-awesome-icon class="form-fai" :icon="['fas', 'paper-plane']" fixed-width title="飞到坐标"
                               @click="flyToPoi"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="设备高度" prop="camHeight" v-show="formIsNotNode">
            <el-slider v-model="formData.camHeight" style="width: 90%" show-input :min="-5" :max="5"
                       :step="0.01" @change="changePosByHeight"></el-slider>
          </el-form-item>
          <el-form-item label="设备类型" prop="camType" v-show="formIsNotNode">
            <el-select v-model="formData.camType" placeholder="请选择监控设备类型">
              <el-option label="枪机" value="1"></el-option>
              <el-option label="球机" value="2"></el-option>
              <el-option label="识别" value="3"></el-option>
              <el-option label="高空" value="4"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="视频来源" prop="camAdd" v-show="formIsNotNode">
            <el-switch v-model="isLocalOrRoam" active-color="#13ce66" inactive-color="#ff4949"
                       active-text="转码链接" inactive-text="直播链接">
            </el-switch>
          </el-form-item>
          <el-form-item label="视频地址" prop="camUrl" v-show="!isLocalOrRoam&&formIsNotNode">
            <el-input v-model="formData.camUrl" placeholder="请填写HLS、FLV、MP4完整网络直播地址或本地文件地址"
                      style="width: 80%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'camera']" fixed-width title="预览视频"
                               @click="configureVideo"></font-awesome-icon>
            <font-awesome-icon class="form-fai" :icon="['far', 'times-circle']" fixed-width title="清除视频"
                               @click="clearVideoOnEarth"></font-awesome-icon>
            <div class="form-note">* HLS、FLV、MP4链接以http/https开头，本地文件地址为city3dfile以下完整地址</div>
            <div class="form-note">* HLS、FLV、MP4网络链接需要允许跨域访问</div>
          </el-form-item>
          <el-form-item label="视频IP" prop="camUrl" v-show="isLocalOrRoam&&formIsNotNode">
            <el-input v-model="formData.camUrlHttp" placeholder="请填写协议类型" style="width: 21%">
              <template slot="append">://</template>
            </el-input>
            <el-input v-model="formData.camUrlIp" placeholder="请填写IP地址" style="width: 69%">
              <template slot="append">:9998</template>
            </el-input>
          </el-form-item>
          <el-form-item label="视频端口" prop="camUrl" v-show="isLocalOrRoam&&formIsNotNode">
            <el-input v-model="formData.camPortNum" placeholder="请填写端口" style="width: 83%" readonly>
              <template slot="prepend">/live?port=</template>
              <template slot="append">&app=live&stream=mystream</template>
            </el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'camera']" fixed-width title="预览视频"
                               @click="configureVideo"></font-awesome-icon>
            <font-awesome-icon class="form-fai" :icon="['far', 'times-circle']" fixed-width title="清除视频"
                               @click="clearVideoOnEarth"></font-awesome-icon>
            <div class="form-note">* 端口不能重复</div>
          </el-form-item>
          <el-form-item label="RTSP流" prop="camRtsp" v-show="isLocalOrRoam&&formIsNotNode">
            <el-input v-model="formData.camRtsp" placeholder="请根据监控设备厂商提供的RTSP取流链接"
                      style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="转码端口" prop="camPort" v-show="isLocalOrRoam&&formIsNotNode">
            <el-input v-model="formData.camPortIp" placeholder="请填写转码服务器IP" style="width: 40%">
              <template slot="prepend">rtmp://</template>
            </el-input>
            <el-input v-model="formData.camPortNum" placeholder="请填写转码端口，*端口不能重复" style="width: 50%"
                      @change="doTestVideoRepetitionByCamPort">
              <template slot="prepend">:</template>
              <template slot="append">/live/mystream</template>
            </el-input>
            <div class="form-note">* 转码端口与视频端口保持一致</div>
          </el-form-item>
          <el-form-item label="AI识别码" prop="macUrl" v-show="formIsNotNode">
            <el-input v-model="formData.macUrl" placeholder="人脸识别对应唯一识别码，可为IP地址或MAC地址"
                      style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="视场角" prop="camFov" v-show="formIsNotNode">
            <el-slider v-model="formData.camFov" style="width: 90%" show-input :min="10" :max="179.9"
                       :step="0.1" @input="updateCamFov"></el-slider>
          </el-form-item>
          <el-form-item label="宽高比" prop="camAspectratio" v-show="formIsNotNode">
            <el-slider v-model="formData.camAspectratio" style="width: 90%" show-input :min="0.5" :max="2"
                       :step="0.01" @input="updateCamAspectRatio"></el-slider>
          </el-form-item>
          <el-form-item label="设备焦距" prop="camNear" v-show="formIsNotNode">
            <el-slider v-model="formData.camNear" style="width: 90%" show-input :min="0.0001" :max="0.1"
                       :step="0.0001" @input="updateCamNear"></el-slider>
          </el-form-item>
          <el-form-item label="拍摄距离" prop="camFar" v-show="formIsNotNode">
            <el-slider v-model="formData.camFar" style="width: 90%" show-input :min="10" :max="400"
                       :step="10" @input="updateCamFar"></el-slider>
          </el-form-item>
          <el-form-item label="方位角" prop="camHeading" v-show="formIsNotNode">
            <el-slider v-model="formData.camHeading" style="width: 90%" show-input :min="0" :max="360"
                       :step="0.1" @input="updateRotation"></el-slider>
          </el-form-item>
          <el-form-item label="俯仰角" prop="camPitch" v-show="formIsNotNode">
            <el-slider v-model="formData.camPitch" style="width: 90%" show-input :min="-90" :max="90"
                       :step="0.1" @input="updateRotation"></el-slider>
          </el-form-item>
          <el-form-item label="旋转角" prop="camRoll" v-show="formIsNotNode">
            <el-slider v-model="formData.camRoll" style="width: 90%" show-input :min="0" :max="360"
                       :step="0.1" @input="updateRotation"></el-slider>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width:rightWidth,height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
    <div id="videoSource"></div>
  </div>
</template>

<script>
import {
  clearVideoConverter,
  deleteVideo,
  freshNginx, getAllandVideoById,
  getVideo,
  getVideosIsNode,
  insertVideo,
  startVideoConverter,
  stopVideoConvertor,
  testVideoRepetitionByCamPort,
  updateVideo
} from "../api/api";
import ztree from "vue-giant-tree";
import flvjs from 'flv.js';
import hlsjs from 'hls.js';
import CesiumMap from "../utils/components/cesium-map";
import CesiumVideoShadow from "../js/CesiumVideoShadow.js";

let _this;

let camera_marks = [];
let cameraData = [];
let playersArr = [];

let pmCollection = [];

let camPosTemp;

export default {
  name: "iot-video-indoor",
  components: {
    CesiumMap, ztree
  },
  data() {
    return {
      queryResult: [],
      setting: {},
      nodes: [],
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      nodeSelect: [],
      isLocalOrRoam: true,
      formIsNotNode: true,
      rules: {
        camAdd: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        id: '',
        camAdd: '',
        camUrl: 'data/v4.mp4',
        camUrlHttp: 'http',
        camUrlIp: '127.0.0.1',
        camType: '1',
        camPosition: '',
        camPid: '0',
        camIsnode: false,
        camHoles: '',
        camFov: 42.0,
        camHeading: 0,
        camPitch: -15,
        camRoll: 0,
        camNear: 0.005,
        camFar: 200,
        camAspectratio: 1.7778,
        camRtsp: '',
        camPortIp: '127.0.0.1',
        camPort: '',
        camPortNum: '',
        macUrl: '',
        isIndoor: 'true',
        camHeight: 0
      }
    }
  },
  methods: {
    setviewtotiles(camPoi, camHeading, camPitch) {
      let camPoiArr = camPoi.split(',');
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromDegrees(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2])),
        orientation: {
          heading: Cesium.Math.toRadians(Number(camHeading)),
          pitch: Cesium.Math.toRadians(Number(camPitch)),
          roll: 0.0
        }
      });
    },
    flyToPoi() {
      if (this.formData.camPosition !== '') {
        let camPoiArr = this.formData.camPosition.split(',');
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]) + 500)
        });
      }
    },
    configurePoi() {
      let drawHandler = drawHandler && drawHandler.destroy();
      let poiResult;
      let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        let cartesian = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          cartesian = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        let lng = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        poiResult = lng + "," + lat + "," + height;

        let drawPointEntity = viewer.entities.getById("drawPointEntity");
        if (drawPointEntity === undefined) {
          let url = Cesium.buildModuleUrl("../../../static/images/camera1.png");
          Promise.resolve(
            pinBuilder.fromUrl(url, Cesium.Color.GREEN, 36)
          ).then(function (canvas) {
            return viewer.entities.add({
              id: 'drawPointEntity',
              position: cartesian.clone(),
              billboard: {
                image: canvas.toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              },
            });
          });
        } else {
          drawPointEntity.position = cartesian.clone();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        _this.formData.camPosition = poiResult;
        camPosTemp = poiResult;
        drawHandler = drawHandler && drawHandler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    changePosByHeight() {
      let prePoiArr = camPosTemp.split(',');
      this.formData.camPosition = prePoiArr[0] + "," + prePoiArr[1] + "," + (Number(prePoiArr[2]) + Number(this.formData.camHeight));
    },
    createVideoElement(videoSrc, id, as, videoType) {
      let videoElement = document.createElement('video');
      videoElement.id = 'video' + id;
      videoElement.style.position = 'absolute';
      videoElement.style.zIndex = '100';
      videoElement.style.visibility = 'hidden';
      let veHeight = viewer.canvas.clientHeight;
      videoElement.style.height = veHeight + 'px';
      let veWidth = Number(veHeight) * Number(as);
      videoElement.style.width = veWidth + 'px';
      videoElement.style.left = (Number(viewer.canvas.clientWidth) - veWidth) / 2 + 'px';
      videoElement.crossOrigin = 'anonymous';
      videoElement.autoplay = true;
      videoElement.loop = true;
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
      } else if (videoType === "hls") {
        let hls = new hlsjs();
        hls.loadSource(videoSrc);
        hls.attachMedia(videoElement);
        hls.on(hlsjs.Events.MANIFEST_PARSED, () => {
          console.log('加载成功');
        });
        hls.on(hlsjs.Events.ERROR, (event, data) => {
          // console.log(event, data);
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
      }
      let playerObj = {};
      playerObj.id = 'video' + id;
      playerObj.player = player;
      playersArr.push(playerObj);
    },
    destroyVideoElement(videoElement) {
      document.getElementById("videoSource").removeChild(videoElement);
    },
    createCameraVideo(node, videoElement) {
      let poiArr = node.camPosition.split(',');
      //视频投影-阴影方法
      let cameraVideo = new CesiumVideoShadow(Cesium, viewer, {
          type: 3,//1:color,2:img,3:video
          show: true,
          aspectRatio: node.camAspectratio,//视频长宽比
          element: videoElement,//视频标签
          alpha: 1,//透明度
          debugFrustum: true,//是否显示锥视线
          rotation: {
            x: Number(node.camPitch),//pitch
            y: Number(node.camHeading),//heading
            r: Number(node.camRoll)//roll
          },
          position: {
            x: Number(poiArr[0]),
            y: Number(poiArr[1]),
            z: Number(poiArr[2])
          },
          near: Number(node.camNear),//焦距
          far: Number(node.camFar),//视距
          fov: Number(node.camFov),//视场角
          depth: .0
        }
      );

      let pmObj = {};
      pmObj.id = 'video' + node.id;
      pmObj.primitive = cameraVideo;
      pmCollection.push(pmObj);
    },
    //清除视频投影渲染基元
    destroyCameraVideo(vid) {
      for (let i = 0; i < pmCollection.length; i++) {
        if (vid === pmCollection[i].id) {
          pmCollection[i].primitive.destroy();//shadow
          pmCollection.splice(i, 1);
        }
      }
    },
    clearVideoOnEarth() {
      let id = this.isEdit ? this.currentId : "9999";
      let vid = "video" + id;
      let videoElement = document.getElementById(vid);
      if (videoElement) {
        this.destroyVideoElement(videoElement);
        for (let i = 0; i < playersArr.length; i++) {
          if (vid === playersArr[i].id) {
            playersArr[i].player.pause();
            playersArr[i].player.destroy();
            playersArr.splice(i, 1);
          }
        }
      }
      this.destroyCameraVideo(vid);
      this.dostopVideoConvertor(id);
    },
    configureVideo() {
      if (this.formData.camPosition !== '' && this.formData.camUrl !== '') {
        let camPoiArr = this.formData.camPosition.split(',');
        if (camPoiArr.length === 3) {
          this.clearVideoOnEarth();
          let videoForm = {};
          videoForm = Object.assign(videoForm, this.formData);
          let camPortTemp = this.isEdit ? this.formData.camPortNum : "19999";
          if (this.isLocalOrRoam) {
            videoForm.camUrl = this.formData.camUrlHttp + '://' + this.formData.camUrlIp + ':9998/live?port=' + camPortTemp + '&app=live&stream=mystream';
            videoForm.camPort = 'rtmp://' + this.formData.camPortIp + ':' + camPortTemp + '/live/mystream';
          }
          videoForm.id = this.isEdit ? this.currentId : "9999";
          videoForm.vlcUrl = nginxUrl;
          this.dostartVideoConverter(videoForm);
        } else {
          this.$message({
            message: '摄像头坐标格式有误，请重新指定坐标！',
            type: 'error'
          });
        }
      } else {
        this.$message({
          message: '摄像头坐标和服务链接不能为空！',
          type: 'error'
        });
      }
    },
    dostartVideoConverter(node) {
      let commandobj = {
        "id": node.id,
        "camRtsp": node.camRtsp,
        "camPort": node.camPort,
        "camAdd": node.vlcUrl
      };
      startVideoConverter(commandobj).then(res => {
        this.startVideoShow(res.data, node)
      });
    },
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
    startVideoShow(data, node) {
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
      this.createVideoElement(camUrl, node.id, node.camAspectratio, videoType);
      setTimeout(() => {
        this.createCameraVideo(node, document.getElementById('video' + node.id));
      }, 100);
    },
    updateRotation() {
      let cameraVideo = this.getcfgVideo();
      if (cameraVideo) {
        cameraVideo.rotation = {
          x: this.formData.camPitch,
          y: this.formData.camHeading,
          r: this.formData.camRoll
        };
      }
    },
    updateCamFov() {
      let cameraVideo = this.getcfgVideo();
      if (cameraVideo) {
        cameraVideo.fov = this.formData.camFov;
      }
    },
    updateCamAspectRatio() {
      let cameraVideo = this.getcfgVideo();
      if (cameraVideo) {
        cameraVideo.aspectRatio = this.formData.camAspectratio;
      }
    },
    updateCamNear() {
      let cameraVideo = this.getcfgVideo();
      if (cameraVideo) {
        cameraVideo.near = this.formData.camNear;
      }
    },
    updateCamFar() {
      let cameraVideo = this.getcfgVideo();
      if (cameraVideo) {
        cameraVideo.far = this.formData.camFar;
      }
    },
    getcfgVideo() {
      let cameraVideo;
      if (this.isEdit) {
        let checkedIDstr = "video" + this.currentId;
        for (let i = 0; i < pmCollection.length; i++) {
          if (checkedIDstr === pmCollection[i].id) {
            cameraVideo = pmCollection[i].primitive;
          }
        }
      } else {
        for (let i = 0; i < pmCollection.length; i++) {
          if ("video9999" === pmCollection[i].id) {
            cameraVideo = pmCollection[i].primitive;
          }
        }
      }
      return cameraVideo;
    },
    getVideoData() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          isIndoor: "true"
        };
        getVideo(params).then(res => {
          this.queryResult = res.data;
          this.clearVideoAll();
          this.createZTree(res.data);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
          'roleName': "true"
        };
        getAllandVideoById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleVideo.map(item => {
            resultArr.push(item.video);
          });
          this.queryResult = resultArr;
          this.clearVideoAll();
          this.createZTree(resultArr);
        });
      }
    },
    //创建视频目录树
    createZTree(data) {
      //目录树配置
      this.setting = {
        check: {
          enable: true,
          chkStyle: "radio",
          radioType: "all"
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
        },
        view: {
          showIcon: false,
          selectedMulti: false,     //可以多选
        }
      };
      let treeNodes = [
        {id: "0", name: "视频监控列表(请勾选需要操作的节点)", open: true, nocheck: true}
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
        node.camType = data[i].camType;
        node.macUrl = data[i].macUrl;
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
          let camera_mark = viewer.entities.add({
            name: '摄像头',
            id: 'ca' + data[i].id,
            position: point,
            billboard: {
              image: imgurl,
              scale: 0.15,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
          });
          camera_marks.push(camera_mark);
        }
        treeNodes.push(node);
      }
      this.nodes = treeNodes;

      function zTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.currentId = treeNode.id;
          _this.currentRow = treeNode;
          if (!treeNode.camIsnode) {
            _this.setviewtotiles(treeNode.camPosition, treeNode.camHeading, treeNode.camPitch);
          }
        }
      }
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
    },
    addData(formName) {
      getVideosIsNode().then(res => {
        this.nodeSelect = res.data;
        this.isTableShow = false;
        this.isEdit = false;
        this.$refs[formName].resetFields();
      });
    },
    editData() {
      if (this.currentId !== '') {
        getVideosIsNode().then(res => {
          this.nodeSelect = res.data;
          this.isTableShow = false;
          this.isEdit = true;
          this.formIsNotNode = !this.currentRow.camIsnode;
          let currentRowOptimize = {};
          currentRowOptimize = Object.assign(currentRowOptimize, this.currentRow);
          if (currentRowOptimize.camRtsp !== null
            && currentRowOptimize.camRtsp !== ''
            && currentRowOptimize.camPort !== null
            && currentRowOptimize.camPort !== '') {
            this.isLocalOrRoam = true;
            let roamUrlArr = currentRowOptimize.camUrl.split(':');
            currentRowOptimize.camUrlHttp = roamUrlArr[0];
            currentRowOptimize.camUrlIp = roamUrlArr[1].substring(2);
            let camPortArr = currentRowOptimize.camPort.split(':');
            currentRowOptimize.camPortIp = camPortArr[1].substring(2);
            currentRowOptimize.camPortNum = camPortArr[2].split('\/')[0];
          } else {
            this.isLocalOrRoam = false;
          }
          currentRowOptimize.camFov = Number(currentRowOptimize.camFov);
          currentRowOptimize.camHeading = Number(currentRowOptimize.camHeading);
          currentRowOptimize.camPitch = Number(currentRowOptimize.camPitch);
          currentRowOptimize.camRoll = Number(currentRowOptimize.camRoll);
          currentRowOptimize.camNear = Number(currentRowOptimize.camNear);
          currentRowOptimize.camFar = Number(currentRowOptimize.camFar);
          currentRowOptimize.camAspectratio = Number(currentRowOptimize.camAspectratio);
          currentRowOptimize.camPid = currentRowOptimize.pid;
          this.formData = Object.assign(this.formData, currentRowOptimize);
          camPosTemp = currentRowOptimize.camPosition;
        });
      } else {
        this.$message({
          message: '请选择需要操作的节点！',
          type: 'warning'
        });
      }
    },
    deleteData() {
      if (this.currentId !== '') {
        this.$confirm('删除后无法恢复，请确认是否删除？', '删除数据', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '取消'
        }).then(() => {
          let params = {
            id: this.currentId
          };
          deleteVideo(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.isTableShow = true;
              this.getVideoData();
            } else {
              this.$message({
                type: 'error',
                message: '删除失败，请重试！'
              });
            }
          });
        }).catch(action => {
          this.$message({
            type: 'warning',
            message: '放弃删除！'
          });
        });
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    submitForm(formName) {
      let videoForm = this.formData;
      if (this.formIsNotNode && this.isLocalOrRoam) {
        if (videoForm.camPosition === ""
          || videoForm.camUrlHttp === "" || videoForm.camUrlIp === ""
          || videoForm.camPortNum === "" || videoForm.camRtsp === ""
          || videoForm.camPortIp === "" || videoForm.macUrl === "") {
          this.$message({
            type: 'error',
            message: '请完善坐标、视频IP、端口、RTSP流、AI识别码信息！'
          });
          return false;
        }
      }
      if (this.formIsNotNode) {
        if (videoForm.camPosition.split(",").length !== 3) {
          this.$message({
            type: 'error',
            message: '请填写坐标或坐标格式不正确！'
          });
          return false;
        }
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.isLocalOrRoam) {
            videoForm.camUrl = this.formData.camUrlHttp + '://' + this.formData.camUrlIp + ':9998/live?port=' + this.formData.camPortNum + '&app=live&stream=mystream';
            videoForm.camPort = 'rtmp://' + this.formData.camPortIp + ':' + this.formData.camPortNum + '/live/mystream';
          }
          videoForm.camIsnode = !this.formIsNotNode;
          let params = {
            "video": videoForm,
            "sysRoleVideo": {
              "roleId": localStorage.getItem("roleId"),
            }
          };
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateVideo(videoForm).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  doRefresh();
                } else {
                  this.$message({
                    type: 'error',
                    message: '修改失败，请重试！'
                  });
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '请完善信息！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              insertVideo(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  doRefresh();
                } else {
                  this.$message({
                    type: 'error',
                    message: '新增失败，请重试！'
                  });
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '请完善信息！'
              });
            });
          }
        } else {
          this.$message({
            message: '请完善信息！',
            type: 'error'
          });
          return false;
        }
      });

      function doRefresh() {
        _this.isTableShow = true;
        _this.getVideoData();
        clearVideoConverter();
        let args = {
          "camAdd": nginxUrl
        };
        freshNginx(args).then(res => {
            if (res) {
              _this.$message({
                type: 'success',
                message: '代理配置刷新成功！'
              });
            } else {
              _this.$message({
                type: 'error',
                message: '代理配置刷新失败！'
              });
            }
          }
        );
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.clearVideoOnEarth();
    },
    backTable() {
      this.isTableShow = true;
      this.clearVideoOnEarth();
    },
    doTestVideoRepetitionByCamPort() {
      let params = {
        'camPort': ':' + this.formData.camPortNum + '/live/mystream'
      };
      testVideoRepetitionByCamPort(params).then(res => {
        if (res.data === 'repetition') {
          this.$message({
            message: '端口重复，请更换端口！',
            type: 'error'
          });
          this.formData.camPortNum = "";
        } else {
          this.$message({
            message: '端口可用！',
            type: 'success'
          });
        }
      });
    }
  },
  mounted() {
    this.getVideoData();
    _this = this;
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.4) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 230) * 0.6) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 95) + 'px';
    },
  }
}
</script>

<style scoped>
.left-card {
  float: left;
}

.right-card {
  float: right;
}

.form-fai {
  font-size: 19px !important;
  cursor: pointer;
  margin: 0 0 0 8px;
  color: #007acc;
}

.my-card-body {
  overflow-y: auto;
}

.my-card-body::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.my-card-body::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.my-card-body::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.form-note {
  margin: 5px 0 0 10px
}
</style>
