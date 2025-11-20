<template>
  <div class="realHouse" id="real-house-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">房屋地址</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.address.addName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房主姓名</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.peopleBase.name"></el-input>
        <div class="emer-row-label" style="margin-left:5px">社区民警</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.communityPolice"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房屋类型</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.houseType" placeholder="请选择">
          <el-option label="楼房" value="楼房"></el-option>
          <el-option label="平房" value="平房"></el-option>
          <el-option label="拆迁" value="拆迁"></el-option>
          <el-option label="其他" value="其他"></el-option>
        </el-select>
        <div class="emer-row-label" style="margin-left:5px">房屋用途</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.houseUse" placeholder="请选择">
          <el-option label="住宅" value="住宅"></el-option>
          <el-option label="出租" value="出租"></el-option>
          <el-option label="商用" value="商用"></el-option>
          <el-option label="其他" value="其他"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">产权证号</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.propertyNo"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">租客姓名</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.trusteeName"></el-input>
        <div class="emer-row-label" style="margin-left:5px">联系电话</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.trusteeTel"></el-input>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'address.addName', order: 'ascending'}"
                :cell-style="cellStyle" @row-click="rowClick">
        <el-table-column label="地址" prop="address.addName" width="204px" sortable>
        </el-table-column>
        <el-table-column label="姓名" prop="peopleBase.name" width="80px" sortable>
        </el-table-column>
        <el-table-column label="类型" prop="houseUse" width="70px" sortable>
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
    <div>
      <el-dialog
        :visible.sync="dialogPanorama"
        :modal-append-to-body="false"
        :destroy-on-close="true"
        :before-close="closePhotoSphereViewer"
        custom-class="role-mask">
        <div v-for="(item, index) in panoramas" :key="'pa-' + index">
          <div
            v-on:click="selectPhoto(item.housePanorama, item.panoramaId)"
            :class="{ active: currentIndex === item.panoramaId }"
            class="panoramaBtn"
          >
            {{ item.housePattern }}
          </div>
        </div>
        <div id="container" style="margin: auto"></div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import map3d from "./map-3d";
import popUtil from "@/utils/pop/popUtil";
import "../js/CesiumPop.js";
import "../js/CesiumFloor.js";
import realHouseInfo from "./real-house-info";
import {stringToNumber} from "@/js/CesiumTools";
import {eventBus} from "../main";
import {Viewer} from 'photo-sphere-viewer';
import 'photo-sphere-viewer/dist/photo-sphere-viewer.css';
import {
  getAddressByComName,
  getHouseByAddId,
  getHouseById,
  getNetAndCountHouse,
  getNetAndCountHouseById,
  queryHouse,
  queryNetHouse
} from "../api/api";

let that;
let he_overlays3D = [];
let hp_overlays3D = [];
let rh_overlays3D = [];
let hd_overlays3D = [];
let PSV;

export default {
  name: "real-house",
  data() {
    return {
      realPeopleQuery: {
        address: {addName: ""},
        peopleBase: {name: ""},
        communityPolice: "",
        houseType: "",
        houseUse: "",
        propertyNo: "",
        trusteeName: "",
        trusteeTel: "",
      },
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: false,
      dialogPanorama: false,
      currentIndex: 0,
      panoramas: [],
    }
  },
  methods: {
    cellStyle(row, column, rowIndex, columnIndex) {
      if (row.column.label === "地址" && row.row.address.addName === "未登记") {
        return "color:#FF747B";
      }
    },
    //根据条件查询网格
    doQuery() {
      this.clearRealHouseArea();
      this.clearHouse();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.pictLoading = true;
      let params = this.realPeopleQuery;
      queryHouse(params).then(res => {
        this.showQueryHouse(res.data)
      });
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //组织条件查询结果数据
    showQueryHouse(data) {
      this.pictLoading = false;
      if (data.length !== 0) {
        let isPoiArr = [];
        for (let i = 0; i < data.length; i++) {
          if (data[i].address !== null) {
            isPoiArr.push(data[i]);
          } else {
            data[i].address = {};
            data[i].address.addName = "未登记";
          }
          if (data[i].houseUse === "" || data[i].houseUse === null) {
            data[i].houseUse = "住宅";
          }
        }
        that.showQueryHouse_3D(isPoiArr);
        this.queryResult = data;
      } else {
        this.$message.error('未获取符合条件房屋信息!');
      }
    },
    //显示条件查询结果图形
    showQueryHouse_3D(data) {
      this.closeHouse_3D();

      let geojson = {
        "type": "FeatureCollection",
        "features": []
      };
      for (let i = 0; i < data.length; i++) {
        let position = data[i].address.poi.split(',');
        let feature = {
          "type": "Feature",
          "geometry": {
            "type": "Point",
            "coordinates": [Number(position[0]), Number(position[1]), Number(position[2])]
          },
          "id": "hp" + data[i].houseId,
          "name": '实有房屋',
          "properties": {
            "title": "marker",
            "marker-symbol": "pitch",
            "marker-color": "#8A2BE2"
          }
        };
        geojson.features.push(feature);

        he_overlays3D.push(viewer.entities.add({
          id: 'he' + data[i].houseId,
          position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
          ellipsoid: {
            radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
            material: Cesium.Color.BLUEVIOLET.withAlpha(0.7),
            distanceDisplayCondition: new Cesium.DistanceDisplayCondition(10.0, 300.0)
          }
        }));

        if (data[i].address.floorPoi !== null && data[i].address.floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': 'hl',
            'floorAddId': data[i].address.addId,
            'floorPoi': data[i].address.floorPoi,
            'floorHeight': data[i].address.floorHeight,
            'floorName': data[i].address.addName,
          };
          CesiumFloor.showFloor(options);
        }
      }

      let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        hp_overlays3D = dataSource;
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
            image: "static/images/pinimg/22.png",
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
    closeHouse_3D() {
      for (let i = 0; i < he_overlays3D.length; i++) {
        viewer.entities.remove(he_overlays3D[i]); // 将标注从场景移除
      }
      he_overlays3D.length = 0;
      viewer.dataSources.remove(hp_overlays3D);
    },
    rowClick(row, column, event) {
      if (!document.getElementById("popupDiv" + row.houseId)) {
        this.getRealHouseById(row.houseId);
      } else {
        this.$message({
          message: '提示，气泡已打开！请勿重复操作！',
          type: 'warning'
        });
      }
    },
    //根据id获取网格的统计信息
    getRealHouseById(id) {
      let params = {
        "houseId": id
      };
      getHouseById(params).then(res => this.showHouseInfo(res.data));
    },
    //显示网格统计信息的气泡
    showHouseInfo(data) {
      if (data !== null && data !== [] && data.length !== 0) {
        if (data.address !== null) {
          data.peopleBase.imgurl = common.serverIp + "city3dfile/" + data.peopleBase.imgurl;
          data.housePhotos = common.serverIp + "city3dfile/" + data.housePhotos;
          for (let i = 0; i < data.housePanoramas.length; i++) {
            data.housePanoramas[i].housePanorama = common.serverIp + "city3dfile/" + data.housePanoramas[i].housePanorama;
          }
          let popoptions = {
            popId: data.houseId,
            rhdata: data
          };
          popUtil.installMapPop().rhPop(popoptions);
          let addArr = data.address.poi.split(',');
          let options = {
            "viewer": viewer,
            "id": data.houseId,
            "popupWidth": 477,
            "popupHeight": 323,
            "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, 'h');
          let camPoiArr = data.address.camPoi.split(',');
          map3d.methods.moveToWin(camPoiArr[0], camPoiArr[1], camPoiArr[2], data.address.camHeading, data.address.camPitch);
        } else {
          window.realHouseData = data;
          let options = {
            title: "房屋信息",
            message: realHouseInfo,
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
        this.$message.error('该房屋未登记房主!');
      }
    },
    resetForm() {
      this.realPeopleQuery.addName = "";
      this.realPeopleQuery.communityPolice = "";
      this.realPeopleQuery.name = "";
      this.realPeopleQuery.houseType = "";
      this.realPeopleQuery.houseUse = "";
      this.realPeopleQuery.propertyNo = "";
      this.realPeopleQuery.trusteeName = "";
      this.realPeopleQuery.trusteeTel = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.closeHouse_3D();
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
      this.clearRealHouseArea();
      this.clearHouse();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "netLevel": "3"
        };
        getNetAndCountHouse(params).then(res => {
          this.showRealHouseArea(res.data);
        });
      } else {
        let params = {
          "netLevel": "3",
          'netPid': localStorage.getItem("roleId"),
        };
        getNetAndCountHouseById(params).then(res => {
          this.showRealHouseArea(res.data);
        });
      }
    },
    //绘制网格图形
    showRealHouseArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let giid = "3";
        if (netData[i].netLevel === "3") {
          giid = "ha";
        } else {
          giid = "hd";
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
        rh_overlays3D.push(tmpClassificationPrimitive);

        if (netData[0].netLevel === "3") {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 3 + 2],
            rhNum: data[i * 3 + 1],
            nextLabel: "下辖小区",
            nextNum: data[i * 3 + 3],
            rhaData: [
              {name: "住宅", value: "1319"},
              {name: "出租", value: "142"},
            ]
          };
          popUtil.installMapPop().rhaPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 240,
            "popupHeight": 184,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 40,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 2 + 2],
            rhNum: data[i * 2 + 1],
          };
          popUtil.installMapPop().rhcPop(popoptions);
          let centerArr = netData[i].netCenter.split(',');
          let options = {
            "viewer": viewer,
            "id": netData[i].netId,
            "popupWidth": 110,
            "popupHeight": 144,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 40,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        }
      }
    },
    //清除网格图形
    clearRealHouseArea() {
      for (let i = 0; i < rh_overlays3D.length; i++) {
        viewer.scene.primitives.remove(rh_overlays3D[i]);
      }
      rh_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(id) {
      this.clearRealHouseArea();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'netPid': id
      };
      queryNetHouse(params).then(res => this.showRealHouseArea(res.data));
    },
    //点击4级图形或气泡上的深入箭头，获取其下级所有分层分户图形
    stepInCommunity(ComName) {
      this.clearRealHouseArea();
      let params = {
        'communityName': ComName
      };
      getAddressByComName(params).then(res => this.showComHouse(res.data));
    },
    //绘制分层分户图形
    showComHouse(data) {
      for (let i = 0; i < data.length; i++) {
        // 是否需要标识点？需要的话可以打开注释
        // if(data[i].poi !== null && data[i].poi !== ''){
        //   let position = data[i].poi.split(',');
        //   hd_overlays3D.push(viewer.entities.add({
        //     id: 'hd' + data[i].addId,
        //     position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
        //     ellipsoid: {
        //       radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
        //       material: Cesium.Color.YELLOW.withAlpha(0.7)
        //     }
        //   }));
        // }
        if (data[i].floorPoi !== null && data[i].floorPoi !== '') {
          let options = {
            'viewer': viewer,
            'floorType': 'hl',
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
    clearHouse() {
      for (let i = 0; i < hd_overlays3D.length; i++) {
        viewer.entities.remove(hd_overlays3D[i]);
      }
      hd_overlays3D = [];
      CesiumFloor.removeFloor(viewer);
    },
    //根据地名地址的id获取
    doQueryHouseByAddId(addId) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      that.pictLoading = true;
      let params = {
        'addId': addId
      };
      getHouseByAddId(params).then(res => this.showQueryHouseByAddId(res.data));
      that.isQueryShow = false;
      that.isResultShow = true;
    },
    //显示网格统计信息气泡
    showQueryHouseByAddId(data) {
      that.pictLoading = false;
      for (let i = 0; i < data.length; i++) {
        if (data[i].houseUse === "" || data[i].houseUse === null) {
          data[i].houseUse = "住宅";
        }
        if (data[i].address.floorPoi !== null && data[i].address.floorPoi !== "") {
          CesiumFloor.removeFloorById(viewer);
          let options = {
            viewer: viewer,
            floorType: "hl",
            floorAddId: data[i].address.addId,
            floorPoi: data[i].address.floorPoi,
            floorHeight: data[i].address.floorHeight,
          };
          CesiumFloor.showFloorHighLight(options);
        }
      }
      that.queryResult = data;
    },
    //清除网格图形
    closeRealHouse() {
      this.closeHouse_3D();
      this.clearRealHouseArea();
      this.clearHouse();
      CesiumLayout.clearLayout(viewer);
      map3d.methods.clearClippingPlanes();
    },
    //打开全景图播放器
    openPhotoSphereViewer(data) {
      this.panoramas = data;
      this.dialogPanorama = true;
      setTimeout(() => {
        this.selectPhoto(
          this.panoramas[0].housePanorama,
          this.panoramas[0].panoramaId
        );
      }, 500);
    },
    //选择照片
    selectPhoto(panorama, id) {
      if (PSV) {
        let viewerpa = document.querySelector('#container');
        viewerpa.removeChild(viewerpa.childNodes[0]);
      }
      PSV = undefined;
      this.currentIndex = id;
      let div = document.getElementById("container");
      PSV = new Viewer({
        panorama: panorama,
        container: div,
        navbar: true,
        size: {
          width: "910px",
          height: "490px",
        },
      });
      let finalViewer = document.querySelector('#container');
      if (finalViewer.childNodes.length > 1) {
        finalViewer.removeChild(finalViewer.childNodes[0]);
      }
    },
    //关闭全景图播放器
    closePhotoSphereViewer() {
      if (PSV) {
        let viewerpa = document.querySelector('#container');
        viewerpa.removeChild(viewerpa.childNodes[0]);
      }
      PSV = undefined;
      this.panoramas = "";
      this.currentIndex = 0;
      this.dialogPanorama = false;
    },
  },
  mounted() {
    that = this;
    this.dogetNetAndCount();
  },
  created() {
    //通过事件公交浏览全景图
    eventBus.$on("sel_panorama", (msg) => {
      this.openPhotoSphereViewer(msg);
    });
  },
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

.panoramaBtn {
  color: white;
  width: 60px;
  text-align: center;
  cursor: pointer;
  float: left;
  margin-left: 10px;
  height: 20px;
}

.active {
  color: #07b6f1 !important;
}
</style>
