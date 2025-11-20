<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop" v-bind:ref="'buildingRemovePop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" style="border-color:#00d3e788">
      <div class="mapPop-name">{{ removeName }}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" style="right:66px;" :icon="['fas', 'user-clock']" title="四角图片"
                           v-on:click.stop="showCorner"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" style="right:36px;" :icon="['fas', 'calculator']" title="文件"
                           v-on:click.stop="changePdf"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="清除"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788;">
      <table class="pop-tabel" cellspacing="0" v-show="!isPdfShow">
        <tr>
          <td width="110px">户主</td>
          <td>{{ removeName }}</td>
        </tr>
        <tr>
          <td>电话</td>
          <td>{{ removeTel }}</td>
        </tr>
        <tr>
          <td>坐落</td>
          <td>{{ removeSite }}</td>
        </tr>
        <tr>
          <td>四至</td>
          <td>{{ removeCorner }}</td>
        </tr>
        <tr>
          <td>全景图</td>
          <td>
            <a
              href="#"
              style="color: white"
              v-on:click=" openPhotoSphereViewer(housePanoramas)"
            >打开全景图</a>
          </td>
        </tr>
        <tr>
          <td>身份证</td>
          <td>{{ removeCard }}</td>
        </tr>
        <tr>
          <td>产权性质</td>
          <td>{{ removeProType }}</td>
        </tr>
        <tr>
          <td>用途</td>
          <td>{{ removeUse }}</td>
        </tr>
        <tr>
          <td>使用情况</td>
          <td>{{ removeState }}</td>
        </tr>
        <tr>
          <td>是否签约</td>
          <td>{{ removeSign }}</td>
        </tr>
        <tr>
          <td>房产证号</td>
          <td>{{ removeHouseNum }}</td>
        </tr>
        <tr>
          <td>房产证载面积</td>
          <td>{{ removeHouseArea }}</td>
        </tr>
        <tr>
          <td>房产核定面积</td>
          <td>{{ removeHouseAreaCheck }}</td>
        </tr>
        <tr>
          <td>确权建筑面积</td>
          <td>{{ removeBuildingAreaCheck }}</td>
        </tr>
        <tr>
          <td>阁楼确权面积</td>
          <td>{{ removeTop }}</td>
        </tr>
        <tr>
          <td>无证建筑面积</td>
          <td>{{ removeAreaNoCer }}</td>
        </tr>
        <tr>
          <td>土地证号</td>
          <td>{{ removeLandNum }}</td>
        </tr>
        <tr>
          <td>土地证载面积</td>
          <td>{{ removeLandArea }}</td>
        </tr>
        <tr>
          <td>土地核定面积</td>
          <td>{{ removeLandAreaCheck }}</td>
        </tr>
        <tr>
          <td>确权土地面积</td>
          <td>{{ removeLandAreaOk }}</td>
        </tr>
        <tr>
          <td>无证土地面积</td>
          <td>{{ removeLandAreaNoCer }}</td>
        </tr>
        <tr>
          <td>备注</td>
          <td>{{ removeNote }}</td>
        </tr>
        <tr>
          <td>创建时间</td>
          <td>{{ removeDate }}</td>
        </tr>
      </table>
      <div class="row_display" v-show="isPdfShow">
        <el-steps class="form-steps" direction="vertical" :active="stepActive-1" :space="39"
                  finish-status="success">
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
          <el-step></el-step>
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
          <tr>
            <td>面积确权资材</td>
            <td @click="showpdf(4)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>分户评估报告</td>
            <td @click="showpdf(5)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>征迁补偿协议</td>
            <td @click="showpdf(6)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>补偿款领款单</td>
            <td @click="showpdf(7)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>补偿核算单</td>
            <td @click="showpdf(8)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>补偿款领取单</td>
            <td @click="showpdf(9)" class="pdf-pre">预览PDF文件</td>
          </tr>
          <tr>
            <td>房屋腾空材料</td>
            <td @click="showpdf(10)" class="pdf-pre">预览PDF文件</td>
          </tr>
        </table>
      </div>
    </div>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
    <el-dialog
      title="四角照片"
      :visible.sync="dialogPanorama"
      width="80%" top="80px"
      :modal-append-to-body="false"
      destroy-on-close
    >
      <div style="width: 100%;text-align: center;">
        <el-image style="height: 100%;" :src="photoSrc+curImgSrc" :preview-src-list="[photoSrc+curImgSrc]"/>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {eventBus} from "../../../main";

let popzIndex = 0;
let cornerhandler;
export default {
  name: "pop-building-remove",
  data() {
    return {
      popId: "",
      levelNum: 0,//层级
      removeName: "",
      removeSite: "",
      removeTel: "",
      removeCard: "",
      removeLandNum: "",
      removeProType: "",
      removeLandArea: "",
      removeHouseNum: "",
      removeHouseArea: "",
      removeState: "",
      removeUse: "",
      removeHouseAreaCheck: "",
      removeBuildingAreaCheck: "",
      removeAreaNoCer: "",
      removeLandAreaCheck: "",
      removeLandAreaOk: "",
      removeLandAreaNoCer: "",
      removeNote: "",
      removeDate: "",
      removeCorner: "",
      removePic1: "",
      removePicPos1: "",
      removePic2: "",
      removePicPos2: "",
      removePic3: "",
      removePicPos3: "",
      removePic4: "",
      removePicPos4: "",
      removePdf: "",
      removePdf1: "",
      removePdf2: "",
      removePdf3: "",
      removePdf4: "",
      removePdf5: "",
      removePdf6: "",
      removePdf7: "",
      removePdf8: "",
      removePdf9: "",
      removeSign: "",
      removeTop: "",
      dialogPanorama: false,
      photoSrc: "",
      curImgSrc: "",
      housePanoramas: [],
      isPdfShow: false,
      stepActive: 1,
    }
  },
  methods: {
    pop_close() {
      let pop = this.$refs['buildingRemovePop-' + this.levelNum];
      if (pop) {
        document.querySelector('body').removeChild(pop);
      }
      CesiumPop.removeDivPopById(viewer, this.popId);
      this.clearCorner();
      cornerhandler = cornerhandler && cornerhandler.destroy();
    },
    clickStick(id) {
      ++popzIndex;
      let stick = document.getElementById(id);
      if (stick !== null) {
        stick.style.zIndex = popzIndex;
        stick.style.position = "fixed";
      }
    },
    openPhotoSphereViewer(data) {
      if (data.length === 0) {
        this.$message.error("该户没有全景图！");
        return;
      }
      eventBus.$emit("br_panorama", data);
    },
    clearCorner() {
      viewer.entities.removeById('corner1');
      viewer.entities.removeById('corner2');
      viewer.entities.removeById('corner3');
      viewer.entities.removeById('corner4');
    },
    showCorner() {
      let _this = this;
      this.photoSrc = common.serverIp + "city3dfile/";
      this.clearCorner();
      //角点
      let pinBuilder = new Cesium.PinBuilder();
      let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
      if (this.removePicPos1 !== "" && this.removePicPos1 !== null) {
        let removePicPos1Arr = this.removePicPos1.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.RED, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner1",
            name: _this.removePic1,
            position: Cesium.Cartesian3.fromDegrees(removePicPos1Arr[0], removePicPos1Arr[1], removePicPos1Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.RED.withAlpha(0.7)
            }
          });
        });
      }
      if (this.removePicPos2 !== "" && this.removePicPos2 !== null) {
        let removePicPos2Arr = this.removePicPos2.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.GREEN, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner2",
            name: _this.removePic2,
            position: Cesium.Cartesian3.fromDegrees(removePicPos2Arr[0], removePicPos2Arr[1], removePicPos2Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.GREEN.withAlpha(0.7)
            }
          });
        });
      }
      if (this.removePicPos3 !== "" && this.removePicPos3 !== null) {
        let removePicPos3Arr = this.removePicPos3.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.ORANGE, 30)
        ).then(function (canvas) {
            viewer.entities.add({
              id: "corner3",
              name: _this.removePic3,
              position: Cesium.Cartesian3.fromDegrees(removePicPos3Arr[0], removePicPos3Arr[1], removePicPos3Arr[2]),
              billboard: {
                image: canvas.toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              },
              ellipsoid: {
                radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
                material: Cesium.Color.ORANGE.withAlpha(0.7)
              }
            });
          }
        );
      }
      if (this.removePicPos4 !== "" && this.removePicPos4 !== null) {
        let removePicPos4Arr = this.removePicPos4.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.BLUE, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner4",
            name: _this.removePic4,
            position: Cesium.Cartesian3.fromDegrees(removePicPos4Arr[0], removePicPos4Arr[1], removePicPos4Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.BLUE.withAlpha(0.7)
            }
          });
        });
      }
      cornerhandler = cornerhandler && cornerhandler.destroy();
      cornerhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      cornerhandler.setInputAction(function (movement) {
        let pickedObject = viewer.scene.pick(movement.position);
        if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)) {
          _this.curImgSrc = pickedObject.id.name;
          _this.dialogPanorama = true;
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
    },
    changePdf() {
      this.isPdfShow = !this.isPdfShow;
    },
    showpdf(type) {
      switch (type) {
        case 1:
          if (this.removePdf !== "" && this.removePdf !== null && this.removePdf !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 2:
          if (this.removePdf1 !== "" && this.removePdf1 !== null && this.removePdf1 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf1, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 3:
          if (this.removePdf2 !== "" && this.removePdf2 !== null && this.removePdf2 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf2, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 4:
          if (this.removePdf3 !== "" && this.removePdf3 !== null && this.removePdf3 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf3, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 5:
          if (this.removePdf4 !== "" && this.removePdf4 !== null && this.removePdf4 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf4, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 6:
          if (this.removePdf5 !== "" && this.removePdf5 !== null && this.removePdf5 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf5, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 7:
          if (this.removePdf6 !== "" && this.removePdf6 !== null && this.removePdf6 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf6, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 8:
          if (this.removePdf7 !== "" && this.removePdf7 !== null && this.removePdf7 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf7, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 9:
          if (this.removePdf8 !== "" && this.removePdf8 !== null && this.removePdf8 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf8, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
        case 10:
          if (this.removePdf9 !== "" && this.removePdf9 !== null && this.removePdf9 !== "null") {
            window.open(common.serverIp + "city3dfile/" + this.removePdf9, "", "_blank");
          } else {
            this.$message.error('该项材料未上传，请提前完善材料!');
          }
          break;
      }
    }
  },
  mounted() {
    console.log(this.stepActive);
  }
}
</script>

<style scoped>
.mapPop {
  width: 360px;
  height: 630px;
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

.mapPop-content {
  border: solid;
  border-width: 1px 0;
  font-size: 14px;
  background-color: #11264DD1;
  padding: 2px;
  box-sizing: border-box;
  height: 600px;
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

.pop-tools-fai {
  cursor: pointer;
  top: 8px;
  right: 8px;
  position: absolute;
}

.DS-font {
  font-family: DS-Digital;
  color: #ffe700;
  font-size: 24px;
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
</style>
