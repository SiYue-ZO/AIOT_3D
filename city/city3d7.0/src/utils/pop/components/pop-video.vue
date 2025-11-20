<template>
  <div v-bind:id="'popupDiv'+videoId" style="box-shadow:0 0 15px #00d3e7" class="mapPop"
       v-bind:ref="'videoPop-'+levelNum" v-on:click="clickStick('popupDiv'+videoId)">
    <div class="mapPop-title" style="border-color:#00d3e788;box-shadow:inset 0 0 6px #00d3e7">
      <div class="mapPop-name">{{camAdd}}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['far', 'clone']" title="视频贴地" v-on:click.stop="putVideo">
        </font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'expand-arrows-alt']" title="放大视频"
                           v-on:click.stop="maxVideo"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'street-view']" title="定点环视"
                           v-on:click.stop="fixedView"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'camera-retro']" title="AI智能识别"
                           v-on:click.stop="show_face_win"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'clock']" title="回放"
                           v-on:click.stop="show_video_his"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['far', 'address-card']" title="视频信息"
                           v-on:click.stop="show_video_info"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="关闭气泡" @click.stop="pop_close">
        </font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788;box-shadow:inset 0 0 6px #00d3e7;overflow: hidden;">
      <div style="height:100%;width:100%;" id="videoBox" v-show="isVideoShow">
        <video v-bind:id="videoId" class="pop-video" crossorigin="anonymous" muted="muted" loop="loop"
               autoplay="autoplay"></video>
      </div>
      <div id="videoInfo" v-show="isInfoShow">
        <table class="pop-tabel" cellspacing="0">
          <tr>
            <td class="td-name">视频地址</td>
            <td>{{camAdd}}</td>
          </tr>
          <tr>
            <td class="td-name">视频网址</td>
            <td>{{camUrl}}</td>
          </tr>
          <tr>
            <td class="td-name">设备类型</td>
            <td>{{camType}}</td>
          </tr>
          <tr>
            <td class="td-name">RTSP流地址</td>
            <td>{{camRtsp}}</td>
          </tr>
          <tr>
            <td class="td-name">转码地址</td>
            <td>{{camPort}}</td>
          </tr>
        </table>
      </div>
    </div>
    <el-dialog style="overflow: hidden" v-bind:title="camAdd" :visible.sync="centerDialogVisible" width="60%" top="60px"
               center :modal-append-to-body="false" destroy-on-close @before-close="closeMaxVideo" @opened="initPlayer">
      <video :id="'maxVideo'+videoId" class="maxVideo" crossorigin="anonymous" muted="muted" loop="loop"
             autoplay="autoplay"></video>
    </el-dialog>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
  </div>
</template>

<script>
  import iotVideo from "@/components/iot-video";
  import protectFace from "@/components/protect-face";
  import {eventBus} from "@/main";
  import flvjs from 'flv.js';
  import hlsjs from 'hls.js';

  let popzIndex = 0;
  let player;
  let isVideoOnEarthShow = false;

  export default {
    name: "pop-video",
    data() {
      return {
        levelNum: 0, //层级
        videoId: "",
        camAdd: "",
        camUrl: "",
        camType: "",
        camRtsp: "",
        camPort: "",
        camPosition: "",
        camHeading: "",
        camPitch: "",
        camRoll: "",
        isVideoShow: true,
        isInfoShow: false,
        type: "local",
        centerDialogVisible: false
      };
    },
    methods: {
      pop_close() {
        let caEnt = viewer.entities.getById("ca" + this.videoId);
        if (caEnt) {
          caEnt.show = true;
        }
        let pop = this.$refs["videoPop-" + this.levelNum];
        if (pop) {
          document.querySelector("body").removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.videoId);
        iotVideo.methods.clearVideoOnEarth(this.videoId);
        iotVideo.methods.dostopVideoConvertor(this.videoId);
        isVideoOnEarthShow = false;
      },
      popCloseById(id) {
        let caEnt = viewer.entities.getById("ca" + id);
        if (caEnt) {
          caEnt.show = true;
        }
        let pop = document.getElementById("popupDiv" + id);
        if (pop) {
          document.querySelector("body").removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, id);
        iotVideo.methods.clearVideoOnEarth(id);
        iotVideo.methods.dostopVideoConvertor(id);
        isVideoOnEarthShow = false;
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      },
      putVideo() {
        if (!isVideoOnEarthShow) {
          iotVideo.methods.putVideo(this.videoId);
          isVideoOnEarthShow = true;
        }
      },
      maxVideo() {
        this.centerDialogVisible = true;
      },
      initPlayer() {
        let videoElement = document.getElementById("maxVideo" + this.videoId);
        if (this.type === "local") {
          player = flvjs.createPlayer({
            type: 'mp4',
            url: this.camUrl,
            isLive: true,
            enableStashBuffer: false,
          });
          player.attachMediaElement(videoElement);
          player.load();
          player.play();
        } else if (this.type === "hls") {
          let hls = new hlsjs();
          hls.loadSource(this.camUrl);
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
            url: this.camUrl,
            isLive: true,
            enableStashBuffer: false,
          });
          player.attachMediaElement(videoElement);
          player.load();
          player.play();
        }
      },
      closeMaxVideo() {
        // player.pause();
        player.destroy();
        this.centerDialogVisible = false;
      },
      fixedView() {
        let camPArr = this.camPosition.split(",");
        iotVideo.methods.fixedView(
          this.videoId,
          camPArr[0],
          camPArr[1],
          camPArr[2],
          this.camHeading,
          this.camPitch,
          this.camRoll
        );
      },
      show_video_info() {
        if (this.isVideoShow) {
          this.isVideoShow = false;
          this.isInfoShow = true;
        } else {
          this.isVideoShow = true;
          this.isInfoShow = false;
        }
      },
      show_face_win() {
        let options = {
          title: "AI智能识别",
          message: protectFace,
          initWidth: "405px",
          initHeight: "355px",
          top: 175,
          left: 1510,
          titleImg: ["fas", "camera-retro"],
          options: {
            minWidth: "405px",
            minHeight: "355px",
            fullScreen: true,
            closeCallback: this.close_face_win,
          },
        };
        this.$installdialog.subPop(options);
        eventBus.$emit("creat_face_key_people", this.videoId);
      },
      close_face_win() {
        eventBus.$emit("close_face_key_people", "1");
      },
      show_video_his() {
        this.pop_close();
        let hisObj = {
          videoId: this.videoId,
          camAdd: this.camAdd,
          camUrl: this.camUrl,
          camRtsp: this.camRtsp,
          camPort: this.camPort,
          type: this.type
        };
        iotVideo.methods.openVideoHisDialog(hisObj);
      }
    }
  };
</script>

<style scoped>
  .mapPop {
    width: 330px;
    height: 225px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .mapPop-title {
    width: 100%;
    font-size: 14px;
    border: solid;
    border-width: 1px 0;
    padding: 5px 8px;
    min-height: 30px;
    background-color: #11264dd1;
  }

  .mapPop-name {
    float: left;
  }

  .mapPop-tools {
    float: right;
  }

  .mapPop-content {
    border: solid;
    border-width: 1px 0;
    font-size: 14px;
    background-color: #11264dd1;
    padding: 3px;
    box-sizing: border-box;
    height: 195px;
    overflow-y: auto;
    overflow-x: hidden;
  }

  .mapPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .mapPop-content::-webkit-scrollbar-thumb {
    /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .mapPop-content::-webkit-scrollbar-track {
    /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .pop-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
  }

  .pop-tabel td {
    padding: 2px 5px;
  }

  .pop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .pop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .box_lt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    top: 0;
  }

  .box_rt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    top: 0;
  }

  .box_rb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    bottom: 0;
  }

  .box_lb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    bottom: 0;
  }

  .box_leg {
    width: 0;
    height: 0;
    border: 10px solid;
    border-color: #000 transparent transparent;
    position: absolute;
    bottom: -20px;
    left: 155px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 2px;
  }

  .td-name {
    width: 70px;
  }

  .maxVideo {
    height: 100%;
    width: 100%;
    object-fit: fill;
    overflow: hidden;
  }

  .pop-video {
    height: 100%;
    width: 100%;
    object-fit: fill;
    overflow: hidden;
  }
</style>
