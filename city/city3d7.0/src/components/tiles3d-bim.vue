<template>
  <div id="tiles3dBim-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="cut_tiles" title="剖切融合">
      <font-awesome-icon :icon="['fas', 'cut']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="change3dtilesClick" title="拾取属性">
      <font-awesome-icon :icon="['fas', 'info-circle']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <span class="emer-row-label">三维透明度</span>
      <el-slider class="emer-slider" v-model="alpha" :format-tooltip="formatTooltip" @change="setAlpha"></el-slider>
      <el-checkbox class="fade-check" v-model="checked" @change="setFadeAlpha">渐变透明</el-checkbox>
    </div>
    <ztree class="ztree_bim" :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
  import ztree from "vue-giant-tree";
  import map3d from "./map-3d";
  import "../js/CesiumPop.js";
  import popUtil from "@/utils/pop/popUtil";
  import {getAllandBimById, getBim} from "../api/api";

  let tilesClickhandler;
  let preFeature;
  let bimData;
  export default {
    name: "tiles3d-bim",
    components: {
      ztree
    },
    data() {
      return {
        setting: {},
        nodes: [],
        alpha: 100,
        checked: true,
      }
    },
    methods: {
      //创建bim目录树
      createTiles3DTree(data) {
        bimData = data;
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
            onCheck: tiles3dzTreeOnCheck,
            onClick: tiles3dzTreeOnClick,
          }
        };
        let treeNodes = [{id: 0, pid: "", name: "园区BIM数据集", isNode: false, open: true, showIcon: false, nocheck: true}];
        for (let i = 0; i < data.length; i++) {
          let j = {};
          j.id = data[i].bim.tilesId;
          j.name = data[i].bim.tilesName;
          j.pid = "0";
          j.tilesX = data[i].bim.tilesX;
          j.tilesY = data[i].bim.tilesY;
          j.tilesZ = data[i].bim.tilesZ;
          j.tilesUrl = data[i].bim.tilesUrl;
          j.camPoi = data[i].bim.camPoi;
          j.camHeading = data[i].bim.camHeading;
          j.camPitch = data[i].bim.camPitch;
          j.checked = data[i].bim.tilesType === "cc";
          treeNodes.push(j);
        }
        this.nodes = treeNodes;

        //check触发回调函数
        function tiles3dzTreeOnClick(event, treeId, treeNode) {
          let camPoiArr = treeNode.camPoi.split(',');
          map3d.methods.moveToWin(
            camPoiArr[0],
            camPoiArr[1],
            camPoiArr[2],
            treeNode.camHeading,
            treeNode.camPitch);
        }

        function tiles3dzTreeOnCheck(event, treeId, treeNode) {
          if (treeNode.checked) {
            map3d.methods.add3dtilesmap(treeNode);
          } else {
            map3d.methods.remove3dtilesmap(treeNode.tilesUrl);
          }
        }

        for (let i = 0; i < data.length; i++) {
          if (data[i].bim.tilesType === 'cc') {
            map3d.methods.add3dtilesmap(data[i].bim);
          }
        }
      },
      //监听点击bim模型，显示详情气泡
      add3dtilesClick() {
        tilesClickhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        tilesClickhandler.setInputAction(function (result) {
          let feature = viewer.scene.pick(result.position);
          if (feature) {
            if (preFeature) {
              preFeature.color = Cesium.Color.WHITE;
            }
            feature.color = Cesium.Color.RED;
            preFeature = feature;
            CesiumPop.removeDivPopById(viewer, 'tiles911');
            let popoptions = {
              popId: 'tiles911',
              pldata: bimInfo[0],
              ckdata: bimInfo[1]
            };
            popUtil.installMapPop().plPop(popoptions);
            let cartesian = viewer.scene.pickPosition(result.position);
            let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            let height = cartographic.height;//模型高度
            let lng = Cesium.Math.toDegrees(cartographic.longitude);
            let lat = Cesium.Math.toDegrees(cartographic.latitude);
            let options = {
              "viewer": viewer,
              "id": 'tiles911',
              "popupWidth": 477,
              "popupHeight": 323,
              "pos": {
                "lon": lng,
                "lat": lat,
                "alt": height
              },
              "extentHeight": 0,
              "extentColor": Cesium.Color.WHITE,
            };
            CesiumPop.addDivPop(options, 'h');
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      },
      stop3dtilesClick() {
        tilesClickhandler = tilesClickhandler && tilesClickhandler.destroy();
        tilesClickhandler = undefined;
      },
      change3dtilesClick() {
        if (tilesClickhandler) {
          this.stop3dtilesClick();
        } else {
          this.add3dtilesClick();
        }
      },
      //清除bim
      closeBIM() {
        bimData.map((item) => {
          map3d.methods.remove3dtilesmap(item.bim.tilesUrl);
        });
        this.stop3dtilesClick();
        map3d.methods.resetTilesetAlpha(1.0);
        map3d.methods.clearClippingPlanes();
        CesiumPop.clearDivPop(viewer);
      },
      formatTooltip(val) {
        return val / 100;
      },
      //改变bim透明度
      setAlpha() {
        map3d.methods.resetTilesetAlpha(this.alpha / 100);
        let alpha = Number(this.alpha / 100);
        alpha = !isNaN(alpha) ? alpha : 1.0;
        alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);
        viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 0.0, 2000.0, 1.0);
        viewer.scene.globe.translucency.enabled = true;
      },
      //改变地形的渐进透明度
      setFadeAlpha() {
        map3d.methods.resetTilesetAlpha(this.alpha / 100);
        let alpha = Number(this.alpha / 100);
        alpha = !isNaN(alpha) ? alpha : 1.0;
        alpha = Cesium.Math.clamp(alpha, 0.0, 1.0);
        viewer.scene.globe.translucency.frontFaceAlphaByDistance = new Cesium.NearFarScalar(400.0, 0.0, 2000.0, 1.0);
        viewer.scene.globe.translucency.enabled = true;
      },
      cut_tiles() {
        let points = [];
        clipPosData.map(item => {
          points.push(new Cesium.Cartesian3.fromDegrees(item[0], item[1], item[2]));
        });
        map3d.methods.cutBIM(points);
      },
    },
    mounted() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getBim().then(res => {
          let tilesetArr = [];
          res.data.map(item => {
            item.bim = item;
            tilesetArr.push(item);
          });
          this.createTiles3DTree(tilesetArr);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
        };
        getAllandBimById(params).then(res => this.createTiles3DTree(res.data.sysRoleBim));
      }
      CesiumPop.bindPopGlobeEventHandler(viewer);
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

  .pop-fai-start {
    right: 80px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-stop {
    right: 120px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }

  .emer-row {
    color: #ffffff;
    margin: 8px 0;
  }

  .emer-row-label {
    width: 90px;
    font-size: 15px;
    margin: 8px 0 0 7px;
    float: left;
  }

  .emer-slider {
    width: 150px;
    float: left;
  }

  .fade-check {
    float: left;
    margin: 9px 0 0 27px;
    color: #ffffff;
  }

  .ztree_bim {
    position: absolute;
    margin-top: 40px;
  }
</style>
