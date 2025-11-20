<template>
  <div id="net-manage-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">名称</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.netName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">等级</div>
        <el-select size="small" class="emer-input" v-model="realPeopleQuery.netLevel" placeholder="请选择">
          <el-option label="街道" value="0"></el-option>
          <el-option label="社区" value="1"></el-option>
          <el-option label="小区" value="2"></el-option>
          <el-option label="一级网格" value="3"></el-option>
          <el-option label="二级网格" value="4"></el-option>
        </el-select>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'netLevel', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column label="名称" prop="netName" width="244px" sortable></el-table-column>
        <el-table-column label="等级" prop="netLevel" width="110px" sortable></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20, 40]"
        :page-size="pagesize"
        :pager-count="5"
        layout="total, sizes, prev, pager, next"
        :total="queryResult.length">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import popUtil from "@/utils/pop/popUtil";
import map3d from "./map-3d";
import "../js/CesiumPop.js";
import "../js/CesiumFloor.js";
import {stringToNumber} from "@/js/CesiumTools";
import {
  getAddressByComName,
  getNetAllByAddId,
  getNetAndCountAll,
  getNetAndCountAllById,
  getNetAndCountAllN,
  getNetById,
  queryNetData
} from "../api/api";

let that;
let ne_overlays3D = [];
let nt_overlays3D = [];

export default {
  name: "net-manage",
  data() {
    return {
      realPeopleQuery: {
        netName: "",
        netLevel: "",
      },
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: false
    }
  },
  methods: {
    //根据条件查询网格
    doQuery() {
      this.clearNet();
      this.clearComNet();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.pictLoading = true;
      let params = this.realPeopleQuery;
      queryNetData(params).then(res => this.showQueryNet(res.data));
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //组织网格数据
    showQueryNet(data) {
      this.pictLoading = false;
      if (data.length !== 0) {
        for (let i = 0; i < data.length; i++) {
          switch (data[i].netLevel) {
            case "0":
              data[i].netLevel = "街道";
              break;
            case "1":
              data[i].netLevel = "社区";
              break;
            case "2":
              data[i].netLevel = "小区";
              break;
            case "3":
              data[i].netLevel = "一级网格";
              break;
            case "4":
              data[i].netLevel = "二级网格";
              break;
            default:
              break;
          }
        }
        that.showQueryNet_3D(data);
        this.queryResult = data;
      } else {
        this.$message.success('未获取符合条件的网格信息！');
      }
    },
    //显示网格图形
    showQueryNet_3D(netData) {
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "nt" + netData[i].netId,
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(netArr)),
            extrudedHeight: 5000
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(netColor.withAlpha(0.4))
          }
        });
        let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);
        nt_overlays3D.push(tmpClassificationPrimitive);
      }
    },
    //清除网格图形
    clearNet() {
      for (let i = 0; i < nt_overlays3D.length; i++) {
        viewer.scene.primitives.remove(nt_overlays3D[i]); // 将标注从场景移除
      }
      nt_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    rowClick(row, column, event) {
      this.getNetById(row.netId);
    },
    //根据id获取网格的统计信息
    getNetById(id) {
      CesiumPop.clearDivPop(viewer);
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        "netId": id
      };
      getNetById(params).then(res => this.showNetInfo(res.data));
    },
    //显示网格统计信息的气泡
    showNetInfo(data) {
      if (data !== null && data !== [] && data.length !== 0) {
        let netData = data[0];
        let flypoiArr = netData.netCenter.split(',');
        flypoiArr[2] = Number(flypoiArr[2]) + 300;
        map3d.methods.flyToLocation(flypoiArr);
        let netListenerArr = [];
        if (netData.netListener === null || netData.netListener === "") {
          netListenerArr = ["", "", ""];
        } else {
          netListenerArr = netData.netListener.split(",");
          netListenerArr.splice(netListenerArr.length - 1, 1);
        }
        if (netData.netLevel === "3") {
          let popoptions = {
            popId: netData.netId,
            name: netData.netName,
            netLevel: netData.netLevel,
            raNum: data[1],
            rpNum: data[2],
            rhNum: data[3],
            rcNum: data[4],
            nnNum: data[5],
            isfaiShow: false,
            netMasterId: netData.netMaster,
            netListenerIds: netListenerArr,
            netBasePeople: netData.netBasePeople,
            netHoldPeople: netData.netHoldPeople,
            netFlowPeople: netData.netFlowPeople,
            netGroup: netData.netGroup,
            netNote: netData.netNote,
            netCom: netData.netCom,
          };
          popUtil.installMapPop().nmaPop(popoptions);
          let centerArr = netData.netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData.netId,
            "popupWidth": 240,
            "popupHeight": 215,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          let popoptions = {
            popId: netData.netId,
            name: netData.netName,
            netLevel: netData.netLevel,
            raNum: data[1],
            rpNum: data[2],
            rhNum: data[3],
            rcNum: data[4],
            nnNum: data[5],
            isfaiShow: true,
            netMasterId: netData.netMaster,
            netListenerIds: netListenerArr,
            netBasePeople: netData.netBasePeople,
            netHoldPeople: netData.netHoldPeople,
            netFlowPeople: netData.netFlowPeople,
            netGroup: netData.netGroup,
            netNote: netData.netNote,
            netCom: netData.netCom,
          };
          popUtil.installMapPop().nmaPop(popoptions);
          let centerArr = netData.netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData.netId,
            "popupWidth": 240,
            "popupHeight": 215,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        }
      } else {
        this.$message.success('未获得符合条件数据！');
      }
    },
    resetForm() {
      this.realPeopleQuery.netLevel = "";
      this.realPeopleQuery.netName = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.dogetNetAndCount();
      this.clearComNet();
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //获取3级-社区级网格，并统计每个网格的相关数据
    dogetNetAndCount() {
      this.clearNet();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "netLevel": "3"
        };
        getNetAndCountAll(params).then(res => {
          this.showNetArea(res.data);
        });
      } else {
        let params = {
          "netLevel": "3",
          'netPid': localStorage.getItem("roleId"),
        };
        getNetAndCountAllById(params).then(res => {
          this.showNetArea(res.data);
        });
      }
    },
    //绘制网格图形
    showNetArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let giid = "3";
        if (netData[i].netLevel === "3") {
          giid = "nt";
        } else {
          giid = "nd";
        }
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: giid + netData[i].netId,
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(netArr)),
            extrudedHeight: 5000
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(netColor.withAlpha(0.4))
          }
        });
        let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);
        nt_overlays3D.push(tmpClassificationPrimitive);

        let netListenerArr = [];
        if (netData[i].netListener === null || netData[i].netListener === "") {
          netListenerArr = ["", "", ""];
        } else {
          netListenerArr = netData[i].netListener.split(",");
          netListenerArr.splice(netListenerArr.length - 1, 1);
        }
        if (netData[i].netLevel === "3") {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            netLevel: netData[i].netLevel,
            raNum: data[i * 5 + 1],
            rpNum: data[i * 5 + 2],
            rhNum: data[i * 5 + 3],
            rcNum: data[i * 5 + 4],
            nnNum: data[i * 5 + 5],
            isfaiShow: false,
            netMasterId: netData[i].netMaster,
            netListenerIds: netListenerArr,
            netBasePeople: netData[i].netBasePeople,
            netHoldPeople: netData[i].netHoldPeople,
            netFlowPeople: netData[i].netFlowPeople,
            netGroup: netData[i].netGroup,
            netNote: netData[i].netNote,
            netCom: netData[i].netCom,
          };
          popUtil.installMapPop().nmaPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 240,
            "popupHeight": 215,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            netLevel: netData[i].netLevel,
            raNum: data[i * 5 + 1],
            rpNum: data[i * 5 + 2],
            rhNum: data[i * 5 + 3],
            rcNum: data[i * 5 + 4],
            nnNum: data[i * 5 + 5],
            isfaiShow: true,
            netMasterId: netData[i].netMaster,
            netListenerIds: netListenerArr,
            netBasePeople: netData[i].netBasePeople,
            netHoldPeople: netData[i].netHoldPeople,
            netFlowPeople: netData[i].netFlowPeople,
            netGroup: netData[i].netGroup,
            netNote: netData[i].netNote,
            netCom: netData[i].netCom,
          };
          popUtil.installMapPop().nmaPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 240,
            "popupHeight": 215,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        }
      }
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(id) {
      this.clearNet();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'netPid': id
      };
      getNetAndCountAllN(params).then(res => this.showNetArea(res.data));
    },
    //点击4级图形或气泡上的深入箭头，获取其下级所有分层分户图形
    stepInCommunity(netName) {
      this.clearNet();
      let params = {
        'communityName': netName
      };
      getAddressByComName(params).then(res => this.showComNet(res.data));
    },
    //绘制分层分户图形
    showComNet(data) {
      for (let i = 0; i < data.length; i++) {
        if (data[i].poi !== null && data[i].poi !== '') {
          let position = data[i].poi.split(',');
          ne_overlays3D.push(viewer.entities.add({
            id: 'ne' + data[i].addId,
            position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.YELLOW.withAlpha(0.7),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(10.0, 300.0)
            }
          }));
        }
        if (data[i].floorPoi !== null && data[i].floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': 'nl',
            'floorAddId': data[i].addId,
            'floorPoi': data[i].floorPoi,
            'floorHeight': data[i].floorHeight,
            'floorName': data[i].addName,
          };
          CesiumFloor.showFloor(options);
        }
      }
    },
    //清除分层分户图形
    clearComNet() {
      for (let i = 0; i < ne_overlays3D.length; i++) {
        viewer.entities.remove(ne_overlays3D[i]);
      }
      ne_overlays3D = [];
      CesiumFloor.removeFloor(viewer);
    },
    //根据地名地址的id获取
    doQueryAllByAddId(addId) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'addId': addId
      };
      getNetAllByAddId(params).then(res => this.showQueryAllByAddId(res.data));
    },
    //显示单体化图形的信息气泡
    showQueryAllByAddId(data) {
      data[1][0] = data[1][0] !== undefined ? data[1][0] : {};
      data[2][0] = data[2][0] !== undefined ? data[2][0] : {};
      data[2][0].housePhotos = common.serverIp + "city3dfile/" + data[2][0].housePhotos;
      data[3][0] = data[3][0] !== undefined ? data[3][0] : {};
      data[1][0].imgurl = common.serverIp + "city3dfile/" + data[1][0].imgurl;
      let popoptions = {
        popId: data[0][0].addId,
        rpdata: data[1][0],
        rhdata: data[2][0],
        rcdata: data[3][0],
        radata: data[0][0],
      };
      popUtil.installMapPop().nmPop(popoptions);
      let addArr = data[0][0].poi.split(',');
      let options = {
        "viewer": viewer,
        "id": data[0][0].addId,
        "popupWidth": 477,
        "popupHeight": 323,
        "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
        "extentHeight": 0,
        "extentColor": Cesium.Color.WHITE,
      };
      CesiumPop.addDivPop(options, 'h');
    },
    //清除网格图形
    closeNet() {
      this.clearNet();
      this.clearComNet();
      CesiumLayout.clearLayout(viewer);
      map3d.methods.clearClippingPlanes();
    },
  },
  mounted() {
    that = this;
    this.dogetNetAndCount();
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
  right: 120px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}

.pop-fai-follow {
  right: 80px;
}

.pop-fai-follow:hover {
  background-color: #e0960d;
}

.emer-row {
  color: #ffffff;
  margin: 8px 0;
  height: 32px
}

.emer-row-label {
  width: 75px;
  font-size: 15px;
  margin-top: 5px;
  float: left;
  text-align: right;
  padding-right: 10px;
}

.emer-input {
  width: 280px;
}

.result-table {
  width: 100%;
  color: #ffffff;
}
</style>
