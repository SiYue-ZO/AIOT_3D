<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop" v-bind:ref="'buildingPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" style="border-color:#00d3e788">
      <div class="mapPop-name">{{ tdxz }}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" style="right:96px;" :icon="['fas', 'image']" title="照片和介绍"
                           v-on:click.stop="showImg"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" style="right:66px;" :icon="['fas', 'home']" title="信息"
                           v-on:click.stop="showInfo"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" style="right:36px;" :icon="['fas', 'calculator']" title="文件"
                           v-on:click.stop="changePdf"></font-awesome-icon>
        <font-awesome-icon class="mapPop-tools-fai" :icon="['fas', 'times']" title="清除"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788">
      <table class="pop-tabel" cellspacing="0" v-show="isImgShow">
        <tr>
          <td>
            <el-image fit="cover" :src="buildingImg" :preview-src-list="[buildingImg]"></el-image>
          </td>
        </tr>
        <tr>
          <td>{{ note }}</td>
        </tr>
      </table>
      <table class="pop-tabel" cellspacing="0" v-show="isInfoShow">
        <tr>
          <td>图标建库库号</td>
          <td>{{ dbnum }}</td>
        </tr>
        <tr>
          <td>土地性质</td>
          <td>{{ tdxz }}</td>
        </tr>
        <tr>
          <td>意向公司</td>
          <td>{{ yxgs }}</td>
        </tr>
        <tr>
          <td>建筑占地面积</td>
          <td>{{ jzzdmj }}</td>
        </tr>
        <tr>
          <td>实际建筑面积</td>
          <td>{{ sjjzmj }}</td>
        </tr>
        <tr>
          <td>房屋层数</td>
          <td>{{ fwcs }}</td>
        </tr>
        <tr>
          <td>房屋结构</td>
          <td>{{ fwjg }}</td>
        </tr>
        <tr>
          <td>宗地号</td>
          <td>{{ zdh }}</td>
        </tr>
        <tr>
          <td>房产证号</td>
          <td>{{ fczh }}</td>
        </tr>
      </table>
      <div class="row_display" v-show="isPdfShow">
        <el-steps class="form-steps" direction="vertical" :active="stepActive-1" :space="39"
                  finish-status="success">
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
        </el-steps>
        <table class="pop-tabel" cellspacing="0">
          <tr>
            <td width="110px">权属材料</td>
            <td @click="showpdf(1)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>身份户籍证明</td>
            <td @click="showpdf(2)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>现场测量资料</td>
            <td @click="showpdf(3)" class="pdf-pre">预览PDF文件</td>
          </tr>
        </table>
      </div>
    </div>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
  </div>
</template>

<script>
let popzIndex = 0;

export default {
  name: "pop-building",
  data() {
    return {
      popId: "",
      levelNum: 0,//层级
      dbnum: "",
      tdxz: "",
      yxgs: "",
      jzzdmj: "",
      sjjzmj: "",
      fwcs: "",
      fwjg: "",
      zdh: "",
      fczh: "",
      note: "",
      buildingImg: "",
      buildingPdf1: "",
      buildingPdf2: "",
      buildingPdf3: "",
      isImgShow: true,
      isInfoShow: false,
      isPdfShow: false,
      stepActive: 1,
    }
  },
  methods: {
    pop_close() {
      let pop = this.$refs['buildingPop-' + this.levelNum];
      if (pop) {
        document.querySelector('body').removeChild(pop);
      }
      CesiumPop.removeDivPopById(viewer, this.popId);
    },
    clickStick(id) {
      ++popzIndex;
      let stick = document.getElementById(id);
      if (stick !== null) {
        stick.style.zIndex = popzIndex;
        stick.style.position = "fixed";
      }
    },
    showImg() {
      this.isImgShow = true;
      this.isInfoShow = false;
      this.isPdfShow = false;
    },
    showInfo() {
      this.isImgShow = false;
      this.isInfoShow = true;
      this.isPdfShow = false;
    },
    changePdf() {
      this.isImgShow = false;
      this.isInfoShow = false;
      this.isPdfShow = true;
    },
    showpdf(type) {
      switch (type) {
        case 1:
          if (this.buildingPdf1 !== "" && this.buildingPdf1 !== null && this.buildingPdf1 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.buildingPdf1, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 2:
          if (this.buildingPdf2 !== "" && this.buildingPdf2 !== null && this.buildingPdf2 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.buildingPdf2, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 3:
          if (this.buildingPdf3 !== "" && this.buildingPdf3 !== null && this.buildingPdf3 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.buildingPdf3, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
      }
    }
  }
}
</script>

<style scoped>
.mapPop {
  width: 360px;
  height: 330px;
  color: #fff;
  font-family: Microsoft YaHei;
  position: absolute;
  left: -1000px;
  top: -1000px;
}

.mapPop-title {
  width: 100%;
  font-size: 13px;
  font-weight: bolder;
  border: solid;
  border-width: 1px 0 0 0;
  padding: 5px 8px;
  min-height: 30px;
  background-color: #11264DD1;
}

.mapPop-name {
  float: left;
}

.mapPop-tools {
  float: right
}

.mapPop-tools-fai {
  cursor: pointer;
  margin: 0 4px 0 6px;
}

.pop-tools-fai {
  cursor: pointer;
  top: 8px;
  right: 8px;
  position: absolute;
}

.mapPop-content {
  border: solid;
  border-width: 1px 0;
  font-size: 14px;
  background-color: #11264DD1;
  padding: 2px;
  box-sizing: border-box;
  height: 300px;
  overflow-y: auto;
  overflow-x: hidden;
}

.mapPop-content::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.mapPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.mapPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.pop-tabel {
  width: 100%;
  border: none;
  text-align: left;
  float: left;
}

.pop-tabel td {
  padding: 3px 10px;
}

.pop-tabel tr:nth-child(odd) {
  background: #004c5abb;
}

.pop-tabel tr:nth-child(even) {
  background: #091d46bb;
}

.row_display {
  display: flex;
}

.form-steps {
  font-size: 15px;
  margin: 8px 0 0 9px;
  width: 40px;
}

.pdf-pre {
  padding-top: 10px !important;
  padding-bottom: 10px !important;
  cursor: pointer;
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
  left: 170px;
}
</style>
