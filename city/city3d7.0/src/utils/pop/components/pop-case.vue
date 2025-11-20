<template>
  <div v-bind:id="'popupDiv' + caseId" style="box-shadow: 0 0 15px #00d3e7" class="mapPop" v-bind:ref="'casePop-' + levelNum" v-on:click="clickStick('popupDiv' + caseId)">
    <div class="mapPop-title" style="border-color: #00d3e788; box-shadow: inset 0 0 6px #00d3e7">
      <div class="mapPop-name">{{ caseName }}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'award']" title="处理记录" v-on:click.stop="getcaseHistory"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'file-image']" title="图片信息" v-on:click.stop="openMaterialImg"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'file-video']" title="视频信息" v-on:click.stop="openMaterialVideo"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="清除" v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color: #00d3e788; box-shadow: inset 0 0 6px #00d3e7">
      <table class="pop-tabel" cellspacing="0">
        <tr>
          <td class="td-name">案件编号</td>
          <td class="td-text">{{ caseId.substring(0, 8) }}</td>
        </tr>
        <tr>
          <td class="td-name">网格编号</td>
          <td class="td-text">{{ netName }}</td>
        </tr>
        <tr>
          <td class="td-name">案件名称</td>
          <td class="td-text">{{ caseName }}</td>
        </tr>
        <tr>
          <td class="td-name">案件性质</td>
          <td class="td-text">{{ caseType }}</td>
        </tr>
        <tr>
          <td class="td-name">案发地址</td>
          <td class="td-text">{{ caseAddr }}</td>
        </tr>
        <tr>
          <td class="td-name">案发时间</td>
          <td class="td-text">{{ caseDate }}</td>
        </tr>
        <tr>
          <td class="td-name">案发来源</td>
          <td class="td-text">{{ caseSource }}</td>
        </tr>
        <tr>
          <td class="td-name">受害人</td>
          <td>{{ victim }}</td>
        </tr>
        <tr>
          <td class="td-name">嫌疑犯</td>
          <td>{{ suspect }}</td>
        </tr>
        <tr>
          <td class="td-name">案件简介</td>
          <td>{{ caseDescribe }}</td>
        </tr>
      </table>
    </div>
    <div style="border-top-color: #00d3e7; filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color: #00d3e7" class="box_lt"></div>
    <div style="border-color: #00d3e7" class="box_lb"></div>
    <div style="border-color: #00d3e7" class="box_rt"></div>
    <div style="border-color: #00d3e7" class="box_rb"></div>
    <!-- 案件图片 -->
    <el-dialog title="案件图片" :visible.sync="dialogVisibleImg" width="58%" custom-class="role-mask" :modal-append-to-body="false" @close="showCaseImg">
      <div class="imgBorder" v-show="isImgShow">
        <div class="bigImgBorder">
          <el-image class="case-material-img" :src="items"> </el-image>
        </div>
        <div class="caseImgList">
          <el-image v-for="(item, index) in itemImg" :key="index" class="caseImgOnce" title="查看照片" :src="item" v-on:click="showBigImg(item)">
          </el-image>
        </div>
      </div>
      <div style="border-color: #00d3e7" class="box_lt"></div>
      <div style="border-color: #00d3e7" class="box_lb"></div>
      <div style="border-color: #00d3e7" class="box_rt"></div>
      <div style="border-color: #00d3e7" class="box_rb"></div>
    </el-dialog>
    <!-- 案件视频 -->
    <el-dialog title="案件视频" :visible.sync="dialogVisibleVid" width="58%" custom-class="role-mask" :modal-append-to-body="false" @close="showCaseVid">
      <div class="imgBorder" v-show="isVidShow">
        <div class="caseImgList">
          <video v-for="(item, index) in itemVid" :key="index" class="caseImgOnce" title="查看视频" :src="item" v-on:click="showBigVid(item)"></video>
        </div>
        <div class="bigImgBorder">
          <video class="case-material-img" :src="itemv" autoplay loop controls></video>
        </div>
      </div>
      <div style="border-color: #00d3e7" class="box_lt"></div>
      <div style="border-color: #00d3e7" class="box_lb"></div>
      <div style="border-color: #00d3e7" class="box_rt"></div>
      <div style="border-color: #00d3e7" class="box_rb"></div>
    </el-dialog>
  </div>
</template>

<script>
import caseHistoryResult from "@/components/case-historyResult";
import { getCaseMaterialById } from "../../../api/api";

let popzIndex = 0;
export default {
  name: "pop-case",
  data() {
    return {
      levelNum: 0, //层级
      caseId: "",
      netName: "",
      caseName: "",
      caseType: "",
      caseAddr: "",
      caseDate: "",
      caseSource: "",
      victim: "",
      suspect: "",
      caseDescribe: "",
      isImgShow: false,
      isVidShow: false,
      itemImg: [],
      items: "",
      itemVid: [],
      itemv: "",
      dialogVisibleImg: false,
      dialogVisibleVid: false,
    };
  },
  methods: {
    pop_close() {
      let pop = this.$refs["casePop-" + this.levelNum];
      if (pop) {
        document.querySelector("body").removeChild(pop);
      }
      CesiumPop.removeDivPopById(viewer, this.caseId);
    },
    clickStick(id) {
      ++popzIndex;
      let stick = document.getElementById(id);
      if (stick !== null) {
        stick.style.zIndex = popzIndex;
        stick.style.position = "fixed";
      }
    },
    getcaseHistory() {
      let options = {
        title: "处理记录",
        message: caseHistoryResult,
        initWidth: "405px",
        initHeight: "355px",
        top: 175,
        left: 1510,
        titleImg: ["fas", "camera-retro"],
        options: {
          minWidth: "405px",
          minHeight: "355px",
          fullScreen: true,
        },
      };
      this.$installdialog.subPop(options);
    },
    // 获取案件图片
    openMaterialImg() {
      let params = {
        caseId: this.caseId,
        materialType: "img",
      };
      getCaseMaterialById(params).then((res) => this.caseImgArr(res.data));
    },
    caseImgArr(data) {
      if (data !== undefined && data !== "") {
        this.dialogVisibleImg = true;
        this.isImgShow = true;
        for (let i = 0; i < data.length; i++) {
          this.itemImg.push(common.serverIp + 'city3dfile/' + data[i].materialUrl);
        }
        this.items = this.itemImg[0];
      } else {
        this.$message("暂无图片信息！");
      }
    },
    // 获取案件视频
    openMaterialVideo() {
      let params = {
        caseId: this.caseId,
        materialType: "vid",
      };
      getCaseMaterialById(params).then((res) => this.caseVidArr(res.data));
    },
    caseVidArr(data) {
      if (data !== undefined && data !== "") {
        this.dialogVisibleVid = true;
        this.isVidShow = true;
        for (let i = 0; i < data.length; i++) {
          this.itemVid.push(common.serverIp + 'city3dfile/' + data[i].materialUrl);
        }
        this.itemv = this.itemVid[0];
      } else {
        this.$message("暂无视频信息！");
      }
    },
    showCaseImg() {
      this.itemImg = [];
      this.isImgShow = false;
    },
    showCaseVid() {
      this.itemVid = [];
      this.isVidShow = false;
    },
    showBigImg(data) {
      this.items = data;
    },
    showBigVid(data) {
      this.itemv = data;
    },
  },
};
</script>

<style scoped>
.mapPop {
  width: 300px;
  height: 215px;
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
  height: 185px;
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
  left: 140px;
}

.pop-tools-fai {
  cursor: pointer;
  margin: 0 4px 0 6px;
}

.td-name {
  width: 70px;
}
.td-text {
  width: 120px;
  word-wrap: break-word;
  word-break: break-all;
}
/* 案件视频和图片弹窗的相关样式 */
.imgBorder {
  width: 1090px;
  height: 670px;
  z-index: 1001;
}

.pop-fai-close {
  cursor: pointer;
  float: right;
  color: #fff;
}

.case-material-img {
  max-height: 700px;
  max-width: 890px;
  min-height: 635px;
}

.caseImgList {
  cursor: pointer;
  width: 190px;
  height: 650px;
  float: left;
  margin: 3px;
  overflow-x: hidden;
  overflow-y: auto;
}

.caseImgList::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.caseImgList::-webkit-scrollbar-thumb {
  /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.caseImgList::-webkit-scrollbar-track {
  /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.caseImgOnce {
  max-width: 180px;
  max-height: 160px;
}

.caseImgOnce:hover {
  border: 4px solid rgba(22, 98, 181, 1);
}

.caseImgOnce:active {
  border: 4px solid red;
  z-index: 1;
}

.bigImgBorder {
  width: 890px;
  height: 650px;
  float: right;
  text-align: center;
}

.bigImgBorder .case-material-img /deep/ .el-image__inner {
  max-height: 700px;
  max-width: 890px;
  min-height: 635px;
  top: 50%;
  left: 50%;
  width: auto !important;
}

.bigImgBorder /deep/ .el-image {
  width: 890px;
}

.el-dialog__wrapper {
  overflow: hidden;
}

.mapPop /deep/ .el-dialog {
  background: #11264dd1 !important;
}

.mapPop /deep/ .el-dialog__headerbtn .el-dialog__close {
  color: #fff;
}

.mapPop /deep/ .el-dialog__header .el-dialog__title {
  line-height: 24px;
  font-size: 18px;
  color: #fff !important;
}

.mapPop /deep/ .el-dialog__body {
  padding: 0px 15px;
  color: #606266;
  font-size: 14px;
  word-break: break-all;
}
</style>
