<template>
  <div id="tool-tags-is-show">
    <div class="pop-add-fai" v-on:click="addTag" title="收藏视角">
      <font-awesome-icon :icon="['fas', 'plus']"></font-awesome-icon>
    </div>
    <div>
      <el-input v-model="tagStr" placeholder="我的位置"></el-input>
    </div>
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in tagsArr">
        <td>
          <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"></font-awesome-icon>
        </td>
        <td class="td-tag-name" v-on:click="moveToTag(item.pos)">{{item.tagName}}</td>
        <td>
          <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']"
                             v-on:click="deleteTagById(item.tagId)"></font-awesome-icon>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  import map3d from "./map-3d";
  import {deleteTagById, getTag, insertTag} from "../api/api";

  let tagsEntArr = [];
  let isAddingTag = false;
  let addTagHandler;

  export default {
    name: "tool-tags",
    data() {
      return {
        tagsArr: [],
        tagStr: ""
      }
    },
    methods: {
      //创建视角标签列表
      createTagList(data) {
        let temptagsArr = [];
        for (let i = 0; i < data.length; i++) {
          let poiArr = data[i].tagLabelPoi.split(',');
          let point = Cesium.Cartesian3.fromDegrees(Number(poiArr[0]), Number(poiArr[1]), Number(poiArr[2]) + 10);
          let tagentId = 'tag' + data[i].tagId;
          tagsEntArr.push(tagentId);
          viewer.entities.add({
            id: tagentId,
            position: point,
            billboard: {
              image: 'static/images/pinimg/33.png',
              scale: 0.6,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 100000, 0.5),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 100000, 0.5),
              disableDepthTestDistance: 200,
            },
            label: {
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              text: data[i].tagName,
              font: 'bold 54px Helvetica',
              scale: 0.5,
              fillColor: Cesium.Color.WHITE,
              showBackground: true,
              backgroundColor: new Cesium.Color.fromCssColorString("#01adcd").withAlpha(0.8),
              backgroundPadding: new Cesium.Cartesian2(30, 15),
              pixelOffset: new Cesium.Cartesian2(0.0, -50.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 100000, 0.5),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 100000, 0.5),
            }
          });
          let campoiArr = data[i].tagPoi.split(',');
          temptagsArr.push({
            'tagId': data[i].tagId,
            'tagName': data[i].tagName,
            'pos': [Number(campoiArr[0]), Number(campoiArr[1]), Number(campoiArr[2]), Number(data[i].tagHeading), Number(data[i].tagPitch)]
          });
        }
        this.tagsArr = temptagsArr;
      },
      //移动视角
      moveToTag(pos) {
        map3d.methods.moveToDegrees(pos[0], pos[1], pos[2], pos[3], pos[4]);
      },
      //清除视角
      clearTags() {
        for (let i = 0; i < tagsEntArr.length; i++) {
          viewer.entities.removeById(tagsEntArr[i]);
        }
        tagsEntArr.length = 0;
      },
      //根据id删除视角
      deleteTagById(id) {
        let params = {
          "tagId": id
        };
        deleteTagById(params).then(res => this.refreshTags());
      },
      //在每次删除或新增后更新列表
      refreshTags() {
        this.clearTags();
        getTag().then(res => this.createTagList(res.data));
      },
      //新增视角标签监听
      addTag() {
        if (!isAddingTag) {
          let that = this;
          let camPoi, camHeading, camPitch, poiStr;
          addTagHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
          addTagHandler.setInputAction(function (movement) {
            let cartesian = viewer.scene.pickPosition(movement.position);
            if (Cesium.defined(cartesian)) {
              let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
              let testheight = cartographic.height;
              if (Number(testheight) < 0) {
                let ray = viewer.camera.getPickRay(movement.position);
                cartesian = viewer.scene.globe.pick(ray, viewer.scene);
              }
              cartographic = Cesium.Cartographic.fromCartesian(cartesian);
              let lng = Cesium.Math.toDegrees(cartographic.longitude);
              let lat = Cesium.Math.toDegrees(cartographic.latitude);
              let height = cartographic.height;//模型高度
              poiStr = lng + ',' + lat + ',' + height;

              let camPoiR = viewer.camera.position;
              let camCartographic = Cesium.Cartographic.fromCartesian(camPoiR);
              let camlng = Cesium.Math.toDegrees(camCartographic.longitude);
              let camlat = Cesium.Math.toDegrees(camCartographic.latitude);
              let camheight = camCartographic.height;//模型高度
              camPoi = camlng + "," + camlat + "," + camheight;
              camHeading = viewer.camera.heading;
              camPitch = viewer.camera.pitch;
            }
            //创建标注
            let pinBuilder = new Cesium.PinBuilder();
            let addPin = viewer.entities.getById("addTagPinId");
            if (addPin === undefined) {
              viewer.entities.add({
                id: "addTagPinId",
                position: cartesian.clone(),
                billboard: {
                  image: pinBuilder.fromText('新', Cesium.Color.BLUE, 36).toDataURL(),
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM
                },
              });
            } else {
              addPin.position = cartesian.clone();
            }
            isAddingTag = true;
          }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
          addTagHandler.setInputAction(function (movement) {
            if (that.tagStr.length !== 0) {
              if (camPoi !== undefined) {
                addTagHandler = addTagHandler && addTagHandler.destroy();
                let obj = {
                  'tagId': '0',
                  'tagPoi': camPoi,
                  'tagHeading': camHeading.toString(),
                  'tagPitch': camPitch.toString(),
                  'tagName': that.tagStr,
                  'tagLabelPoi': poiStr,
                };
                insertTag(obj).then(res => that.refreshTags());
                viewer.entities.removeById("addTagPinId");
                isAddingTag = false;
              } else {
                this.$message.error('请定位标签!');
              }
            } else {
              this.$message.error('请填写标签名称!');
            }
          }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
        }
      },
      //停止添加视角标签监听
      stopAddTagHandle(){
        addTagHandler = addTagHandler && addTagHandler.destroy();
      }
    },
    mounted() {
      getTag().then(res => this.createTagList(res.data));
    }
  }
</script>

<style scoped>
  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel td {
    padding: 2px 10px;
    cursor: pointer;
    height: 32px;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .td-tag-name {
    width: 280px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .pop-add-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    right: 80px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-add-fai:hover {
    background-color: #20920a;
  }
</style>
