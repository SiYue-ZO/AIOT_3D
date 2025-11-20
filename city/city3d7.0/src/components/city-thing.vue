<template>
  <div id="city-thing-is-show">
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
import "../js/CesiumPop.js";
import popUtil from "@/utils/pop/popUtil";
import ztree from "vue-giant-tree";
import {getCityThingByPid, getCityThingModel} from "../api/api";

let demoModelArr = [];
let instanceCollection = [];
let label_overlays3D = [];
let lineArr = [];
export default {
  name: "city-thing",
  components: {
    ztree
  },
  data() {
    return {
      setting: {},
      nodes: [],
      loading: null,
    }
  },
  methods: {
    createModelZTree(data) {
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
          onCheck: zTreeChecked,
        },
        view: {
          showIcon: true,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [
        {
          id: "0",
          pid: "",
          name: "部件分类目录树",
          isNode: false,
          nocheck: false,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].thingModelId;
        treeObj.pid = data[i].thingModelPid;
        treeObj.name = data[i].thingModelName;
        treeObj.url = data[i].thingModelUrl;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;
      let _this = this;

      //check触发回调函数
      function zTreeChecked(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.loadModelPoint(treeNode.id, treeNode.icon);
        } else {
          _this.closeCityThingByPid(treeNode.id);
        }
      }
    },
    loadModelPoint(type, icon) {
      let params = {
        "thingPid": type
      };
      getCityThingByPid(params).then(res => {
        let data = [];
        if (res.data.length === 0) {
          for (let i = 1; i < 40; i++) {
            for (let j = 1; j < 30; j++) {
              let lon = 126.51562406872812 + 0.0002 * i;
              let lat = 45.64114677813597 - 0.0002 * j;
              let obj = {
                thingId: "" + i * j,
                thingName: "部件" + i * j,
                thingType: '路灯',
                thingClass: '公共设施',
                thingNet: '城东123523',
                thingDep: '城管局',
                thingPid: type,
                thingPos: lon + ',' + lat + ',' + 170,
                thingScale: '0.01',
                thingUrl: common.serverIp + "city3dfile/" + "data/model/oilModel/001.glb",
                thingHeading: Math.random() * 360,
                thingIcon: icon
              };
              data.push(obj);
            }
          }
        } else {
          data = res.data;
          data.map(item => {
            item.thingIcon = icon;
          });
        }
        this.createModels(data);
      });
    },
    createModels(data) {
      demoModelArr.push({"thingPid": data[0].thingPid, "model": data});
      this.loading = this.$loading({
        lock: true,
        text: "正在加载中，请稍后！",
        spinner: "el-icon-loading",
        background: "rgba(0, 0, 0, 0.7)"
      });
      let instances = [];
      let geojson = {
        type: "FeatureCollection",
        features: []
      };
      for (let i = 0; i < data.length; i++) {
        let posArr = data[i].thingPos.split(',');
        let point = Cesium.Cartesian3.fromDegrees(Number(posArr[0]), Number(posArr[1]), Number(posArr[2]));
        let modelMatrix = Cesium.Transforms.headingPitchRollToFixedFrame(
          point,
          new Cesium.HeadingPitchRoll(Cesium.Math.toRadians(Number(data[i].thingHeading)), 0, 0)
        );
        Cesium.Matrix4.multiplyByUniformScale(modelMatrix, Number(data[i].thingScale), modelMatrix);
        instances.push({
          id: "cy" + data[i].thingId,
          modelMatrix: modelMatrix,
          scale: Number(data[i].thingScale),
        });

        //需要直接显示部件名称的情况，可以解除如下注释
        let feature = {
          type: "Feature",
          geometry: {
            type: "Point",
            coordinates: [
              Number(posArr[0]), Number(posArr[1]), Number(posArr[2]) + 15
            ]
          },
          id: "cy" + data[i].thingId,
          name: "模型",
          properties: {
            title: data[i].thingName,
            icon: data[i].thingIcon
          }
        };
        geojson.features.push(feature);

        //连接线
        let positionextent = new Cesium.Cartesian3.fromDegrees(Number(posArr[0]), Number(posArr[1]), Number(posArr[2]) + 15);
        let line = viewer.entities.add({
          polyline: {
            positions: [point, positionextent],
            width: 2,
            show: true,
            material: new Cesium.PolylineDashMaterialProperty({
              color: Cesium.Color.WHITE
            })
          }
        });
        lineArr.push({"thingPid": data[i].thingPid, "line": line});
      }
      let promise = Cesium.GeoJsonDataSource.load(geojson, {markerSize: 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        label_overlays3D.push({"thingPid": data[0].thingPid, "ds": dataSource});
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
            image: dataSourceEntities[i].properties.icon._value,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            width: 24,
            height: 24,
          });
        }

        let removeListener;

        function customStyle() {
          if (Cesium.defined(removeListener)) {
            removeListener();
            removeListener = undefined;
          } else {
            removeListener = dataSource.clustering.clusterEvent.addEventListener(
              function (clusteredEntities, cluster) {
                cluster.label.scale = 0;
                cluster.billboard = new Cesium.BillboardGraphics({
                  image: clusteredEntities[0].properties.icon._value,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  width: 24,
                  height: 24,
                  scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                });
              }
            );
          }
          // force a re-cluster with the new styling
          let pixelRange = dataSource.clustering.pixelRange;
          dataSource.clustering.pixelRange = 0;
          dataSource.clustering.pixelRange = pixelRange;
        }

        // start with custom style
        customStyle();
      });
      let modelInstanceCollection = new Cesium.ModelInstanceCollection({
        url: common.serverIp + "city3dfile/" + data[0].thingUrl,
        instances: instances,
        imageBasedLightingFactor: new Cesium.Cartesian2(1, 1),
      });
      let instancePrimative = viewer.scene.primitives.add(modelInstanceCollection);
      Promise.resolve(instancePrimative.readyPromise).then(function (model) {
        model.activeAnimations.addAll({
          loop: Cesium.ModelAnimationLoop.REPEAT
        });
        model.pid = data[0].thingPid;
      });
      instanceCollection.push({"thingPid": data[0].thingPid, "ins": instancePrimative});
      this.loading.close();
    },
    showDemoModelInfo(int, pid) {
      for (let i = 0; i < demoModelArr.length; i++) {
        if (demoModelArr[i].thingPid === pid) {
          let posArr = demoModelArr[i].model[int].thingPos.split(',');
          if (!document.getElementById("popupDiv" + pid + int)) {
            let popoptions = {
              popId: pid + int,
              thingType: demoModelArr[i].model[int].thingType,
              thingClass: demoModelArr[i].model[int].thingClass,
              thingName: demoModelArr[i].model[int].thingName,
              thingNet: demoModelArr[i].model[int].thingNet,
              thingDep: demoModelArr[i].model[int].thingDep,
            };
            popUtil.installMapPop().thingPop(popoptions);
            let options = {
              viewer: viewer,
              id: pid + int,
              popupWidth: 477,
              popupHeight: 323,
              pos: {
                lon: Number(posArr[0]),
                lat: Number(posArr[1]),
                alt: Number(posArr[2]) + 3
              },
              extentHeight: 0,
              extentColor: Cesium.Color.WHITE
            };
            CesiumPop.addDivPop(options, "h");
          }
          break;
        }
      }
    },
    closeCityThingByPid(pid) {
      for (let i = 0; i < instanceCollection.length; i++) {
        if (instanceCollection[i].thingPid === pid) {
          viewer.scene.primitives.remove(instanceCollection[i].ins);
          instanceCollection.splice(i, 1);
          break;
        }
      }
      for (let i = 0; i < label_overlays3D.length; i++) {
        if (label_overlays3D[i].thingPid === pid) {
          viewer.dataSources.remove(label_overlays3D[i].ds);
          label_overlays3D.splice(i, 1);
          break;
        }
      }
      for (let i = 0; i < lineArr.length; i++) {
        if (lineArr[i].thingPid === pid) {
          viewer.entities.remove(lineArr[i].line);
          lineArr.splice(i, 1);
          break;
        }
      }
    },
    closeCityThing() {
      CesiumPop.clearDivPop(viewer);
      instanceCollection.map(item => {
        viewer.scene.primitives.remove(item.ins);
      });
      instanceCollection = [];
      label_overlays3D.map(item => {
        viewer.dataSources.remove(item.ds);
      });
      label_overlays3D = [];
      lineArr.map(item => {
        viewer.entities.remove(item.line);
      });
      lineArr = [];
    },
  },
  mounted() {
    getCityThingModel().then(res => {
      this.createModelZTree(res.data);
    });
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>
</style>
