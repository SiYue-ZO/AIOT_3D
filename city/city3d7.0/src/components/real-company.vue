<template>
  <div id="real-company-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">单位名称</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.name"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">组织机构</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.organization"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">负责人</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.leader"></el-input>
        <div class="emer-row-label" style="margin-left:5px">法人</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.legalMan"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">办公地址</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.address"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">行业类别</div>
        <el-select size="small" class="emer-input" v-model="realPeopleQuery.industryType" placeholder="请选择">
          <el-option label="重点单位" value="重点单位"></el-option>
          <el-option label="特种行业" value="特种行业"></el-option>
          <el-option label="商业设施" value="商业设施"></el-option>
          <el-option label="娱乐场所" value="娱乐场所"></el-option>
          <el-option label="大型超市" value="大型超市"></el-option>
          <el-option label="企事业单位" value="企事业单位"></el-option>
          <el-option label="党政机关" value="党政机关"></el-option>
          <el-option label="宗教活动场所" value="宗教活动场所"></el-option>
          <el-option label="人员密集场所" value="人员密集场所"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">业务范围</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.mainBusiness"></el-input>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'name', order: 'ascending'}"
                :cell-style="cellStyle" @row-click="rowClick">
        <el-table-column label="单位名称" prop="name" width="150px" sortable>
        </el-table-column>
        <el-table-column label="负责人" prop="leader" width="84px" sortable>
        </el-table-column>
        <el-table-column label="类型" prop="industryType" width="120px" sortable>
        </el-table-column>
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
import realCompanyInfo from './real-company-info';
import {
  getCompanyByAddId,
  getCompanyByComName,
  queryCompanyData,
  queryNetCompany, queryNetCompanyById,
  selectCompanyById
} from "../api/api";

let that;
let ce_overlays3D = [];
let cp_overlays3D = [];
let cb_overlays3D = [];
let cc_overlays3D = [];

export default {
  name: "real-company",
  data() {
    return {
      realPeopleQuery: {
        name: "",
        organization: "",
        leader: "",
        legalMan: "",
        address: "",
        industryType: "",
        mainBusiness: "",
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
    cellStyle(row, column, rowIndex, columnIndex) {
      if (row.column.label === "单位名称" && (row.row.addressAddress.poi === "" || row.row.addressAddress.poi === null)) {
        return "color:#FF747B";
      }
    },
    //根据条件查询网格
    doQuery() {
      this.clearRealCompanyArea();
      this.clearCompany();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.pictLoading = true;
      let params = this.realPeopleQuery;
      queryCompanyData(params).then(res => this.showQueryCompany(res.data));
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //组织网格数据
    showQueryCompany(data) {
      this.pictLoading = false;
      if (data.length !== 0) {
        let isPoiArr = [];
        for (let i = 0; i < data.length; i++) {
          if (data[i].addressAddress !== null) {
            isPoiArr.push(data[i]);
          }
        }
        that.showQueryCompany_3D(isPoiArr);
        this.queryResult = data;
      } else {
        this.$message.error('未获取符合条件的单位信息!');
      }
    },
    //显示网格图形
    showQueryCompany_3D(data) {
      this.closeCompany_3D();
      let geojson = {
        "type": "FeatureCollection",
        "features": []
      };
      for (let i = 0; i < data.length; i++) {
        if (data[i].addressAddress.poi !== null && data[i].addressAddress.poi !== '') {
          let position = data[i].addressAddress.poi.split(',');
          let feature = {
            "type": "Feature",
            "geometry": {
              "type": "Point",
              "coordinates": [Number(position[0]), Number(position[1]), Number(position[2])]
            },
            "id": "cp" + data[i].companyId,
            "name": '实有单位',
            "properties": {
              "title": "marker",
              "marker-symbol": "pitch",
              "marker-color": "#8A2BE2"
            }
          };
          geojson.features.push(feature);

          ce_overlays3D.push(viewer.entities.add({
            id: 'ce' + data[i].companyId,
            position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.BLUEVIOLET.withAlpha(0.7),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(10.0, 300.0)
            }
          }));
        }
      }

      let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        cp_overlays3D = dataSource;
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
            image: "static/images/pinimg/23.png",
            scale: 0.8,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            disableDepthTestDistance: 200,
          });
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
    //清除网格图形
    closeCompany_3D() {
      for (let i = 0; i < ce_overlays3D.length; i++) {
        viewer.entities.remove(ce_overlays3D[i]); // 将标注从场景移除
      }
      ce_overlays3D.length = 0;
      viewer.dataSources.remove(cp_overlays3D);
    },
    rowClick(row, column, event) {
      if (!document.getElementById("popupDiv" + row.companyId)) {
        this.getCompanyById(row.companyId);
      } else {
        this.$message({
          message: '提示，气泡已打开！请勿重复操作！',
          type: 'warning'
        });
      }
    },
    //根据id获取网格的统计信息
    getCompanyById(id) {
      let params = {
        "companyId": id
      };
      selectCompanyById(params).then(res => this.showCompanyInfo(res.data));
    },
    //显示网格统计信息的气泡
    showCompanyInfo(data) {
      if (data !== null && data !== [] && data.length !== 0) {
        if (data.addressAddress !== null && data.addressAddress.poi !== null && data.addressAddress.poi !== '') {
          data.imageInfo = common.serverIp + "city3dfile/" + data.imageInfo;
          let popoptions = {
            popId: data.companyId,
            rcdata: data
          };
          popUtil.installMapPop().rcPop(popoptions);
          let addArr = data.addressAddress.poi.split(',');
          let options = {
            "viewer": viewer,
            "id": data.companyId,
            "popupWidth": 477,
            "popupHeight": 323,
            "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, 'h');
          let camPoiArr = data.addressAddress.camPoi.split(',');
          map3d.methods.moveToWin(camPoiArr[0], camPoiArr[1], camPoiArr[2], data.addressAddress.camHeading, data.addressAddress.camPitch);
        } else {
          window.realCompanyData = data;
          let options = {
            title: "单位信息",
            message: realCompanyInfo,
            initWidth: "405px",
            initHeight: "355px",
            top: 75,
            left: 1500,
            titleImg: ['fas', 'city'],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              //closeCallback: this.closeCallback,
            }
          };
          that.$installdialog.subPop(options);
        }
      } else {
        this.$message.error('未获得符合条件数据!');
      }
    },
    resetForm() {
      this.realPeopleQuery.name = "";
      this.realPeopleQuery.organization = "";
      this.realPeopleQuery.leader = "";
      this.realPeopleQuery.legalMan = "";
      this.realPeopleQuery.address = "";
      this.realPeopleQuery.industryType = "";
      this.realPeopleQuery.mainBusiness = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.closeCompany_3D();
      this.dogetNetAndCount();
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //获取3级-社区级网格，并统计每个网格的相关数据
    dogetNetAndCount() {
      this.clearRealCompanyArea();
      this.clearCompany();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "netLevel": "3"
        };
        queryNetCompany(params).then(res => {
          this.showRealCompanyArea(res.data);
        });
      } else {
        let params = {
          "netLevel": "3",
          'netPid': localStorage.getItem("roleId"),
        };
        queryNetCompanyById(params).then(res => {
          this.showRealCompanyArea(res.data);
        });
      }
    },
    //绘制网格图形
    showRealCompanyArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "cb" + netData[i].netId,
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
        cb_overlays3D.push(tmpClassificationPrimitive);

        let popoptions = {
          popId: netData[i].netId,
          name: netData[i].netName,
          netPid: netData[i].netPid,
          addNum: data[i * 2 + 2],
          rcNum: data[i * 2 + 1],
          rcaData: [
            {name: "人员密集场所", value: "13"},
            {name: "企事业单位", value: "142"},
            {name: "重点单位", value: "18"},
            {name: "特种行业", value: "43"},
            {name: "娱乐场所", value: "28"},
            {name: "党政机关", value: "7"},
            {name: "清真寺", value: "3"}
          ]
        };
        popUtil.installMapPop().rcaPop(popoptions);
        let centerArr = netData[i].netCenter.split(',');
        let options = {
          "viewer": viewer,
          "id": netData[i].netId,
          "popupWidth": 190,
          "popupHeight": 138,
          "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
          "extentHeight": 40,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);
      }
    },
    //清除网格图形
    clearRealCompanyArea() {
      for (let i = 0; i < cb_overlays3D.length; i++) {
        viewer.scene.primitives.remove(cb_overlays3D[i]);
      }
      cb_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(netPid) {
      this.clearRealCompanyArea();
      let params = {
        'community': netPid
      };
      getCompanyByComName(params).then(res => this.showComCompany(res.data));
    },
    //绘制分层分户图形
    showComCompany(data) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      for (let i = 0; i < data.length; i++) {
        if (data[i].addressAddress.poi !== null && data[i].addressAddress.poi !== '') {
          let position = data[i].addressAddress.poi.split(',');
          cc_overlays3D.push(viewer.entities.add({
            id: 'cp' + data[i].companyId,
            position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
            billboard: {
              image: 'static/images/pinimg/23.png',
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.YELLOW.withAlpha(0.7)
            }
          }));
        }
        if (data[i].addressAddress.floorPoi !== null && data[i].addressAddress.floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': 'cl',
            'floorAddId': data[i].addId,
            'floorPoi': data[i].addressAddress.floorPoi,
            'floorHeading': data[i].addressAddress.floorHeading,
            'floorHeight': data[i].addressAddress.floorHeight,
            'miniheading': data[i].addressAddress.miniheading,
            'floorName': data[i].addressAddress.addName,
          };
          CesiumFloor.addFloor(options);
        }
      }
    },
    //清除分层分户图形
    clearCompany() {
      for (let i = 0; i < cc_overlays3D.length; i++) {
        viewer.entities.remove(cc_overlays3D[i]);
      }
      cc_overlays3D = [];
      CesiumFloor.removeFloor(viewer);
    },
    //根据地名地址的id获取
    doQueryCompanyByAddId(addId) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      that.pictLoading = true;
      let params = {
        'addId': addId
      };
      getCompanyByAddId(params).then(res => this.showQueryCompanyByAddId(res.data));
      that.isQueryShow = false;
      that.isResultShow = true;
    },
    //显示网格统计信息气泡
    showQueryCompanyByAddId(data) {
      that.pictLoading = false;
      that.queryResult = data;
    },
    //清除模块数据
    closeRealCompany() {
      this.closeCompany_3D();
      this.clearRealCompanyArea();
      this.clearCompany();
    }
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

.emer-input-half {
  width: 100px;
  float: left;
}

.result-table {
  width: 100%;
  color: #ffffff;
}
</style>
