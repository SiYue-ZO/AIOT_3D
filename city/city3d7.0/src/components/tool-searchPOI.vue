<template>
  <div id="tool-searchPOI-is-show">
    <div class="pop-fai pop-add-fai" v-on:click="searchPOI" title="搜索">
      <font-awesome-icon :icon="['fas', 'search']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="clearsuggestionArr" title="清除">
      <font-awesome-icon :icon="['fas', 'trash-alt']"></font-awesome-icon>
    </div>
    <div>
      <el-input v-model="poiname" placeholder="地名地址"></el-input>
    </div>
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in poiArr">
        <td>
          <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"></font-awesome-icon>
        </td>
        <td class="td-tag-name" v-on:click="moveToPOI(item.position)">{{index+1+" "+item.name}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  import {bd09towgs84} from "../js/CesiumTools.js";
  import map3d from "./map-3d";
  import "../js/CesiumPop.js";
  import popUtil from "@/utils/pop/popUtil";
  import {searchPOIJsonp} from "../api/api";

  let suggestionArr = [];

  export default {
    name: "tool-searchPOI",
    data() {
      return {
        poiname: "",
        poiArr: [],
      }
    },
    methods: {
      //引用百度的地名地址服务
      searchPOI() {
        let poiname = this.poiname;
        if (poiname !== '') {
          this.clearsuggestionArr();
          let camPoiR = viewer.camera.position;
          let camCartographic = Cesium.Cartographic.fromCartesian(camPoiR);
          let camlng = Cesium.Math.toDegrees(camCartographic.longitude);
          let camlat = Cesium.Math.toDegrees(camCartographic.latitude);
          let posstr = camlat + ',' + camlng;
          let url = "http://api.map.baidu.com/place/v2/suggestion?query="
            + poiname + "&location=" + posstr + "&coord_type=1&"
            + "output=json&ak=ZpRjzwQe7dQCVzTR9zytcdLO";
          searchPOIJsonp(url, this.createPOI);
          CesiumPop.bindPopGlobeEventHandler(viewer);
        } else {
          this.$message.error('请输入地名地址关键词!');
        }
      },
      //绘制地名地址图标
      createPOI(err, data) {
        if (err) {
          this.$message.error('访问失败，请重试！');
        } else {
          if (data.status === 0 && data.result !== []) {
            let temppoiArr = [];
            let result = data.result;
            let campos = viewer.scene.camera.position;
            let camposgeo = Cesium.Cartographic.fromCartesian(campos);
            let camheight = camposgeo.height;
            for (let i = 0; i < result.length; i++) {
              if (result[i].location !== undefined) {
                let bdpos = bd09towgs84(result[i].location.lng, result[i].location.lat);
                let pos = Cesium.Cartesian3.fromDegrees(bdpos[0], bdpos[1], 1600);
                if (camheight < 100000) {
                  pos = viewer.scene.clampToHeight(pos);
                }
                let str = (i + 1).toString();
                let poiId = 'pi' + result[i].uid;
                suggestionArr.push(poiId);
                viewer.entities.add({
                  id: poiId,
                  position: pos,
                  label: {
                    show: true,
                    verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                    horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                    font: 'bold 56px Helvetica',
                    scale: 0.5,
                    fillColor: Cesium.Color.fromCssColorString("#ffffff"),
                    text: str,
                    pixelOffset: new Cesium.Cartesian2(0.0, -85.0),
                    scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    disableDepthTestDistance: 100000000,
                  },
                  billboard: {
                    image: 'static/images/pinimg/34.png',
                    scale: 0.8,
                    verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                    scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    disableDepthTestDistance: 100,
                  }
                });
                let position = [bdpos[0], bdpos[1], 500];
                temppoiArr.push({
                  'poiId': poiId,
                  'addressstr': result[i].province + result[i].city + result[i].district,
                  'name': result[i].name,
                  'position': position
                });
              }
            }
            this.poiArr = temppoiArr;
          } else {
            this.$message.error('未查询到结果，请重试!');
          }
        }
      },
      moveToPOI(position) {
        map3d.methods.flyToLocation(position);
      },
      //引用百度服务获取该点位详细信息
      getPOIDetailById(id) {
        viewer.entities.getById('pi' + id).show = false;
        let url = "http://api.map.baidu.com/place/v2/detail?uid="
          + id + "&output=json&scope=2&ak=ZpRjzwQe7dQCVzTR9zytcdLO";
        searchPOIJsonp(url, this.showpoipop);
      },
      //显示详情气泡
      showpoipop(err, data) {
        if (data.status === 0 && data.result !== []) {
          let result = data.result;
          let bdpos = bd09towgs84(result.location.lng, result.location.lat);
          let address = result.address === undefined ? "" : result.address;
          let telephone = result.telephone === undefined ? "" : result.telephone;
          let tag = result.detail_info.tag === undefined ? "" : result.detail_info.tag;
          let popoptions = {
            popId: result.uid,
            address: address,
            telephone: telephone,
            tag: tag,
            name: result.name
          };
          popUtil.installMapPop().poiPop(popoptions);
          let options = {
            "viewer": viewer,
            "id": result.uid,
            "popupWidth": 300,
            "popupHeight": 215,
            "pos": {"lon": Number(bdpos[0]), "lat": Number(bdpos[1]), "alt": 180},
            "extentHeight": 120,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          this.$message.error('未查询到结果，请重试!');
        }
      },
      //清除模块数据
      clearsuggestionArr() {
        for (let i = 0; i < suggestionArr.length; i++) {
          viewer.entities.removeById(suggestionArr[i]);
        }
        suggestionArr = [];
      }
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
    width: 300px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-add-fai {
    right: 120px;
  }

  .pop-add-fai:hover {
    background-color: #20920a;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
