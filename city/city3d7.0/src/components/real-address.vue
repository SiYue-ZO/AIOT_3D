<template>
  <div id="real-address-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">地名地址</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.addName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">街道</div>
        <el-select size="small" class="emer-input" placeholder="请选择" @change="changeStreetTable"
                   v-model="realPeopleQuery.street">
          <el-option v-for="item in streetArr" :key="item.netId" :label="item.netName" :value="item.netId"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">社区</div>
        <el-select size="small" class="emer-input" placeholder="请选择" @change="changeCommunityTable"
                   v-model="realPeopleQuery.communities">
          <el-option v-for="item in communitiesArr" :key="item.netId" :label="item.netName"
                     :value="item.netId"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">小区</div>
        <el-select size="small" class="emer-input" placeholder="请选择" v-model="realPeopleQuery.communityName">
          <el-option v-for="item in communityNameArr" :key="item.netId" :label="item.netName"
                     :value="item.netId"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">类型</div>
        <el-select size="small" class="emer-input" placeholder="请选择" v-model="realPeopleQuery.addType">
          <el-option label="行政" value="行政"></el-option>
          <el-option label="地点" value="地点"></el-option>
          <el-option label="住宅" value="住宅"></el-option>
        </el-select>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'addName', order: 'ascending'}"
                :cell-style="cellStyle" @row-click="rowClick">
        <el-table-column label="地址" prop="addName" width="204px" sortable></el-table-column>
        <el-table-column label="街道" prop="street" width="80px" sortable></el-table-column>
        <el-table-column label="类型" prop="addType" width="70px" sortable></el-table-column>
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
import map3d from "./map-3d";
import "../js/CesiumPop.js";
import popUtil from "@/utils/pop/popUtil";
import "../js/CesiumFloor.js";
import {stringToNumber} from "@/js/CesiumTools";
import {
  getAddressByComName,
  getAddressById,
  getNetAndCountAddress,
  getNetAndCountAddressById,
  queryAddress,
  queryNetAddress,
  queryNetData
} from "../api/api";

let that;
let ap_overlays3D = [];
let ae_overlays3D = [];
let aa_overlays3D = [];
let ac_overlays3D = [];

export default {
  name: "real-address",
  data() {
    return {
      realPeopleQuery: {
        addName: "",
        communities: "",
        street: "",
        communityName: "",
        addType: "",
      },
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: false,
      streetArr: [],
      communitiesArr: [],
      communityNameArr: [],
    }
  },
  methods: {
    cellStyle(row, column, rowIndex, columnIndex) {
      if (row.column.label === "类型" && (row.row.addType === "" || row.row.addType === null)) {
        return "color:#FF747B";
      }
    },
    //根据条件查询地名地址信息
    doQuery() {
      this.clearRealAddressArea();
      this.clearAddress();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.pictLoading = true;
      let street = "", communities = "", communityName = "";
      for (let i = 0; i < this.streetArr.length; i++) {
        if (this.streetArr[i].netId === this.realPeopleQuery.street) {
          street = this.streetArr[i].netName;
          break;
        }
      }
      for (let i = 0; i < this.communitiesArr.length; i++) {
        if (this.communitiesArr[i].netId === this.realPeopleQuery.communities) {
          communities = this.communitiesArr[i].netName;
          break;
        }
      }
      for (let i = 0; i < this.communityNameArr.length; i++) {
        if (this.communityNameArr[i].netId === this.realPeopleQuery.communityName) {
          communityName = this.communityNameArr[i].netName;
          break;
        }
      }
      let params = this.realPeopleQuery;
      params.street = street;
      params.communities = communities;
      params.communityName = communityName;
      queryAddress(params).then(res => this.showQueryAddress(res.data));
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //整理地名地址查询结果
    showQueryAddress(data) {
      this.pictLoading = false;
      if (data.length !== 0) {
        let isPoiArr = [];
        for (let i = 0; i < data.length; i++) {
          if (data[i].poi !== null) {
            isPoiArr.push(data[i]);
          }
          if (data[i].addType === "" || data[i].addType === null) {
            data[i].addType = "住宅";
          }
        }
        if (data.length > 500) {
          this.$message({
            message: '提示，数据量500条，不显示点位！',
            type: 'warning'
          });
        } else {
          that.showQueryAddress_3D(isPoiArr);
        }
        this.queryResult = data;
      } else {
        this.$message.error('错误，未获取符合条件的地名地址信息！');
      }
    },
    //绘制条件查询结果图形，分层分户和聚合
    showQueryAddress_3D(data) {
      this.closeAddress_3D();

      let geojson = {
        "type": "FeatureCollection",
        "features": []
      };
      for (let i = 0; i < data.length; i++) {
        let position = data[i].poi.split(',');
        let feature = {
          "type": "Feature",
          "geometry": {
            "type": "Point",
            "coordinates": [Number(position[0]), Number(position[1]), Number(position[2])]
          },
          "id": "ap" + data[i].addId,
          "name": '地名地址',
          "properties": {
            "title": "marker",
            "marker-symbol": "pitch",
            "marker-color": "#8A2BE2"
          }
        };
        geojson.features.push(feature);

        ae_overlays3D.push(viewer.entities.add({
          id: 'ae' + data[i].addId,
          position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
          ellipsoid: {
            radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
            material: Cesium.Color.RED.withAlpha(0.7),
            distanceDisplayCondition: new Cesium.DistanceDisplayCondition(10.0, 300.0)
          }
        }));

        if (data[i].floorPoi !== null && data[i].floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': "al",
            'floorAddId': data[i].addId,
            'floorPoi': data[i].floorPoi,
            'floorHeight': data[i].floorHeight,
            'floorName': data[i].addName,
          };
          CesiumFloor.showFloor(options);
        }
      }

      let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        ap_overlays3D = dataSource;
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i].billboard.image = 'static/images/pinimg/25.png';
          dataSourceEntities[i].billboard.scaleByDistance = new Cesium.NearFarScalar(1000, 1, 20000, 0.2);
          dataSourceEntities[i].billboard.pixelOffsetScaleByDistance = new Cesium.NearFarScalar(1000, 1, 20000, 0.2);
        }
        let removeListener;
        let pinBuilder = new Cesium.PinBuilder();
        let pin50 = pinBuilder.fromText('50+', Cesium.Color.RED, 36).toDataURL();
        let pin40 = pinBuilder.fromText('40+', Cesium.Color.ORANGE, 36).toDataURL();
        let pin30 = pinBuilder.fromText('30+', Cesium.Color.YELLOW, 36).toDataURL();
        let pin20 = pinBuilder.fromText('20+', Cesium.Color.GREEN, 36).toDataURL();
        let pin10 = pinBuilder.fromText('10+', Cesium.Color.BLUE, 36).toDataURL();
        let singleDigitPins = new Array(8);
        for (let i = 0; i < singleDigitPins.length; ++i) {
          singleDigitPins[i] = pinBuilder.fromText('' + (i + 2), Cesium.Color.VIOLET, 36).toDataURL();
        }

        function customStyle() {
          if (Cesium.defined(removeListener)) {
            removeListener();
            removeListener = undefined;
          } else {
            removeListener = dataSource.clustering.clusterEvent.addEventListener(function (clusteredEntities, cluster) {
              cluster.label.show = false;
              cluster.billboard.show = true;
              cluster.billboard.id = cluster.label.id;
              cluster.billboard.verticalOrigin = Cesium.VerticalOrigin.BOTTOM;
              if (clusteredEntities.length >= 50) {
                cluster.billboard.image = pin50;
              } else if (clusteredEntities.length >= 40) {
                cluster.billboard.image = pin40;
              } else if (clusteredEntities.length >= 30) {
                cluster.billboard.image = pin30;
              } else if (clusteredEntities.length >= 20) {
                cluster.billboard.image = pin20;
              } else if (clusteredEntities.length >= 10) {
                cluster.billboard.image = pin10;
              } else {
                cluster.billboard.image = singleDigitPins[clusteredEntities.length - 2];
              }
            });
          }
          // force a re-cluster with the new styling
          let pixelRange = dataSource.clustering.pixelRange;
          dataSource.clustering.pixelRange = 0;
          dataSource.clustering.pixelRange = pixelRange;
        }

        // start with custom style
        customStyle();
      });
    },
    //清除地名地址图形
    closeAddress_3D() {
      for (let i = 0; i < ae_overlays3D.length; i++) {
        viewer.entities.remove(ae_overlays3D[i]); // 将标注从场景移除
      }
      ae_overlays3D.length = 0;
      viewer.dataSources.remove(ap_overlays3D);
    },
    rowClick(row, column, event) {
      if (!document.getElementById("popupDiv" + row.addId)) {
        this.getRealAddressById(row.addId);
      } else {
        this.$message({
          message: '提示，气泡已打开！请勿重复操作！',
          type: 'warning'
        });
      }
    },
    //根据id获取地名地址
    getRealAddressById(id) {
      let params = {
        "addId": id
      };
      getAddressById(params).then(res => this.showAddressInfo(res.data));
    },
    //绘制分层分户图形和标注气泡
    showAddressInfo(data) {
      if (data !== null && data !== [] && data.length !== 0) {
        if (data.floorPoi !== null && data.floorPoi !== "") {
          CesiumFloor.removeFloorById(viewer);
          let options = {
            viewer: viewer,
            floorType: "al",
            floorAddId: data.addId,
            floorPoi: data.floorPoi,
            floorHeight: data.floorHeight,
          };
          CesiumFloor.showFloorHighLight(options);
        }

        let popoptions = {
          popId: data.addId,
          radata: data
        };
        popUtil.installMapPop().raPop(popoptions);
        let addArr = data.poi.split(',');
        let options = {
          "viewer": viewer,
          "id": data.addId,
          "popupWidth": 477,
          "popupHeight": 323,
          "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
          "extentHeight": 0,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options, 'h');
        if (data.camHeading !== null && data.camHeading !== "") {
          let camPoiArr = data.camPoi.split(',');
          map3d.methods.moveToWin(camPoiArr[0], camPoiArr[1], camPoiArr[2], data.camHeading, data.camPitch);
        } else {
          let poiArr = data.poi.split(',');
          map3d.methods.flyToLocation([Number(poiArr[0]), Number(poiArr[1]), Number(poiArr[2]) + 500]);
        }
      } else {
        this.$message.error('错误，未获得该地名地址信息！');
      }
    },
    resetForm() {
      this.realPeopleQuery.addName = "";
      this.realPeopleQuery.communities = "";
      this.realPeopleQuery.street = "";
      this.realPeopleQuery.communityName = "";
      this.realPeopleQuery.addType = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.closeAddress_3D();
      this.dogetNetAndCount();
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //绘制网格图形
    dogetNetAndCount() {
      this.clearRealAddressArea();
      this.clearAddress();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "netLevel": "3"
        };
        getNetAndCountAddress(params).then(res => {
          this.showRealAddressArea(res.data);
        });
      } else {
        let params = {
          'netPid': localStorage.getItem("roleId"),
          "netLevel": "3"
        };
        getNetAndCountAddressById(params).then(res => {
          this.showRealAddressArea(res.data);
        });
      }
    },
    showRealAddressArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let giid = "3";
        if (netData[i].netLevel === "3") {
          giid = "aa";
        } else {
          giid = "as";
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
        aa_overlays3D.push(tmpClassificationPrimitive);

        if (netData[0].netLevel === "3") {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 2 + 1],
            nextLabel: "下辖小区",
            nextNum: data[i * 2 + 2],
            netLevel: netData[0].netLevel
          };
          popUtil.installMapPop().raaPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 110,
            "popupHeight": 140,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 40,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 2 + 1],
            netLevel: netData[0].netLevel,
            nextLabel: "登记房屋",
            nextNum: data[i * 2 + 2],
          };
          popUtil.installMapPop().raaPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 110,
            "popupHeight": 140,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 60,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        }
      }
    },
    //清除地名地址网格
    clearRealAddressArea() {
      for (let i = 0; i < aa_overlays3D.length; i++) {
        viewer.scene.primitives.remove(aa_overlays3D[i]);
      }
      aa_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(id) {
      this.clearRealAddressArea();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'netPid': id
      };
      queryNetAddress(params).then(res => this.showRealAddressArea(res.data));
    },
    //点击4级图形或气泡上的深入箭头，获取其下级所有分层分户图形
    stepInCommunity(ComName) {
      this.clearRealAddressArea();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'communityName': ComName
      };
      getAddressByComName(params).then(res => this.showComAddress(res.data));
    },
    //绘制分层分户图形
    showComAddress(data) {
      for (let i = 0; i < data.length; i++) {
        if (data[i].floorPoi !== null && data[i].floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': "al",
            'floorAddId': data[i].addId,
            'floorPoi': data[i].floorPoi,
            'floorHeight': data[i].floorHeight,
            'floorName': data[i].addName,
          };
          CesiumFloor.showFloor(options);
        }
      }
    },
    //清除分层分户结果
    clearAddress() {
      for (let i = 0; i < ac_overlays3D.length; i++) {
        viewer.entities.remove(ac_overlays3D[i]);
      }
      ac_overlays3D = [];
      CesiumFloor.removeFloor(viewer);
    },
    //清除地名地址模块数据
    closeRealAddress() {
      this.closeAddress_3D();
      this.clearRealAddressArea();
      this.clearAddress();
    },
    setNetData() {
      let params = {
        netLevel: "0"
      };
      queryNetData(params).then(res => {
        this.streetArr = res.data;
      });
    },
    changeStreetTable() {
      let params = {
        netPid: this.realPeopleQuery.street
      };
      queryNetData(params).then(res => {
        this.communitiesArr = res.data;
      });
    },
    changeCommunityTable() {
      let params = {
        netPid: this.realPeopleQuery.communities
      };
      queryNetData(params).then(res => {
        this.communityNameArr = res.data;
      });
    },
  },
  mounted() {
    that = this;
    this.dogetNetAndCount();
    this.setNetData();
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
