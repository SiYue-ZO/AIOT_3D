<template>
  <div id="city-building-remove-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">户主</div>
        <el-input size="small" class="emer-input" v-model="removeQuery.removeName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">坐落</div>
        <el-input size="small" class="emer-input" v-model="removeQuery.removeSite"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房产证号</div>
        <el-input size="small" class="emer-input" v-model="removeQuery.removeHouseNum"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">土地证号</div>
        <el-input size="small" class="emer-input" v-model="removeQuery.removeLandNum"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">是否签约</div>
        <el-select size="small" class="emer-input" v-model="removeQuery.removeSign" placeholder="请选择">
          <el-option label="已签约" value="已签约"></el-option>
          <el-option label="未签约" value="未签约"></el-option>
        </el-select>
      </div>
    </div>
    <div v-show="!isQueryShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'removeHouseNum', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="权利人" prop="removeName" width="100px" sortable>
        </el-table-column>
        <el-table-column label="坐落" prop="removeSite" width="265px" sortable>
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
import "../js/CesiumFloor.js";
import popUtil from "@/utils/pop/popUtil";
import {stringToNumber} from "@/js/CesiumTools";
import {eventBus} from "../main";
import {Viewer} from 'photo-sphere-viewer';
import 'photo-sphere-viewer/dist/photo-sphere-viewer.css';
import {
  getBuildingRemoveByAddId,
  getNetAndCountBuildingRemove,
  queryBuildingRemove,
  getHousePanoramaByHosueId,
  queryNetData,
  getBuildingRemoveNetById,
  getBuildingRemoveByPid,
  getNetAndCountBuildingRemoveById
} from "../api/api";

let that;
let br_overlays3D = [];
let bc_overlays3D = [];
let PSV;

export default {
  name: "city-building-remove",
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      pictLoading: false,
      queryResult: [],
      removeQuery: {
        removeName: "",
        removeSite: "",
        removeHouseNum: "",
        removeLandNum: "",
        removeSign: "",
      },
      isQueryShow: true,
      isResultShow: false,
      dialogPanorama: false,
      currentIndex: 0,
      panoramas: [],
    }
  },
  methods: {
    //elementUI表格方法
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    //elementUI表格方法
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //elementUI表格方法：点击行
    rowClick(row, column, event) {
      let camPoiArr = row.address.camPoi.split(',');
      map3d.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), row.address.camHeading, row.address.camPitch);
      this.addRemoveToMap(row);
    },
    //回显分成分户实体
    addRemoveToMap(data) {
      //回显分层分户
      if (data.address.floorPoi !== null && data.address.floorPoi !== "") {
        CesiumFloor.removeFloorById(viewer);
        let options = {
          viewer: viewer,
          floorType: "br",
          floorAddId: data.address.addId,
          floorPoi: data.address.floorPoi,
          floorHeight: data.address.floorHeight,
        };
        CesiumFloor.showFloorHighLight(options);

        if (!document.getElementById('popupDiv' + data.removeId)) {
          let params = {
            houseId: data.removeId
          };
          getHousePanoramaByHosueId(params).then(res => {
            let housePanoramas = [];
            res.data.map(item => {
              item.housePanorama = common.serverIp + "city3dfile/" + item.housePanorama;
              housePanoramas.push(item)
            });
            let stepActive = 1;
            if (data.removePdf9 !== "" && data.removePdf9 !== null) {
              stepActive = 11;
            } else if (data.removePdf8 !== "" && data.removePdf8 !== null && data.removePdf !== "null") {
              stepActive = 10;
            } else if (data.removePdf7 !== "" && data.removePdf7 !== null && data.removePdf !== "null") {
              stepActive = 9;
            } else if (data.removePdf6 !== "" && data.removePdf6 !== null && data.removePdf !== "null") {
              stepActive = 8;
            } else if (data.removePdf5 !== "" && data.removePdf5 !== null && data.removePdf !== "null") {
              stepActive = 7;
            } else if (data.removePdf4 !== "" && data.removePdf4 !== null && data.removePdf !== "null") {
              stepActive = 6;
            } else if (data.removePdf3 !== "" && data.removePdf3 !== null && data.removePdf !== "null") {
              stepActive = 5;
            } else if (data.removePdf2 !== "" && data.removePdf2 !== null && data.removePdf !== "null") {
              stepActive = 4;
            } else if (data.removePdf1 !== "" && data.removePdf1 !== null && data.removePdf !== "null") {
              stepActive = 3;
            } else if (data.removePdf !== "" && data.removePdf !== null && data.removePdf !== "null") {
              stepActive = 2;
            }
            let popoptions = {
              popId: data.removeId,
              removeName: data.removeName,
              removeSite: data.removeSite,
              removeTel: data.removeTel,
              removeCard: data.removeCard,
              removeLandNum: data.removeLandNum,
              removeProType: data.removeProType,
              removeLandArea: data.removeLandArea,
              removeHouseNum: data.removeHouseNum,
              removeHouseArea: data.removeHouseArea,
              removeState: data.removeState,
              removeUse: data.removeUse,
              removeHouseAreaCheck: data.removeHouseAreaCheck,
              removeBuildingAreaCheck: data.removeBuildingAreaCheck,
              removeAreaNoCer: data.removeAreaNoCer,
              removeLandAreaCheck: data.removeLandAreaCheck,
              removeLandAreaOk: data.removeLandAreaOk,
              removeLandAreaNoCer: data.removeLandAreaNoCer,
              removeNote: data.removeNote,
              removeDate: data.removeDate,
              removeCorner: data.removeCorner,
              removePic1: data.removePic1,
              removePicPos1: data.removePicPos1,
              removePic2: data.removePic2,
              removePicPos2: data.removePicPos2,
              removePic3: data.removePic3,
              removePicPos3: data.removePicPos3,
              removePic4: data.removePic4,
              removePicPos4: data.removePicPos4,
              removePdf: data.removePdf,
              removePdf1: data.removePdf1,
              removePdf2: data.removePdf2,
              removePdf3: data.removePdf3,
              removePdf4: data.removePdf4,
              removePdf5: data.removePdf5,
              removePdf6: data.removePdf6,
              removePdf7: data.removePdf7,
              removePdf8: data.removePdf8,
              removePdf9: data.removePdf9,
              removeSign: data.removeSign,
              removeTop: data.removeTop,
              stepActive: stepActive,
              housePanoramas: housePanoramas
            };
            popUtil.installMapPop().brPop(popoptions);

            let posArr = data.address.poi.split(',');
            let pos = Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
            let cartographic = Cesium.Cartographic.fromCartesian(pos);
            let lon = Cesium.Math.toDegrees(cartographic.longitude);
            let lat = Cesium.Math.toDegrees(cartographic.latitude);
            let options = {
              "viewer": viewer,
              "id": data.removeId,
              "popupWidth": 360,
              "popupHeight": 630,
              "pos": {"lon": Number(lon), "lat": Number(lat), "alt": cartographic.height},
              "extentHeight": 10,
              "extentColor": Cesium.Color.WHITE,
            };
            CesiumPop.addDivPop(options);
          });
        }
      }
    },
    //回显分成分户实体
    doQueryRemoveByAddId(id) {
      let params = {
        removeId: id,
      };
      getBuildingRemoveByAddId(params).then((res) => {
        //回显分层分户
        let data = res.data[0];
        this.addRemoveToMap(data);
      });
    },
    //清除分层分户实体
    removeFloor() {
      CesiumFloor.removeFloor(viewer);
    },
    //关闭征地拆迁
    closeCityBuildingRemove() {
      this.removeFloor();
      CesiumPop.clearDivPop(viewer);
      viewer.entities.removeById('corner1');
      viewer.entities.removeById('corner2');
      viewer.entities.removeById('corner3');
      viewer.entities.removeById('corner4');
      this.clearBuildingRemoveArea();
    },
    //显示分层分户图斑
    showBuildingRemove(data) {
      data.map(item => {
        if (item.address !== null && item.address.floorPoi !== null && item.address.floorPoi !== "") {
          let options = {
            viewer: viewer,
            floorType: "br",
            floorAddId: item.address.addId,
            floorPoi: item.address.floorPoi,
            floorHeight: item.address.floorHeight,
            floorName: item.address.addName,
            removeSign: item.removeSign
          };
          CesiumFloor.showFloorRemove(options);
        }
      });
    },
    //根据条件查询网格
    doQuery() {
      this.clearBuildingRemoveArea();
      this.removeFloor();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.pictLoading = true;
      let params = this.removeQuery;
      queryBuildingRemove(params).then(res => {
        if (res.data.length !== 0) {
          this.queryResult = res.data;
          this.showBuildingRemove(res.data);
        } else {
          this.$message.error('未获取符合条件房屋信息!');
        }
        this.pictLoading = false;
      });
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //返回条件查询
    resetForm() {
      this.removeQuery = {
        removeName: "",
        removeSite: "",
        removeHouseNum: "",
        removeLandNum: "",
        removeSign: "",
      };
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.removeFloor();
      this.dogetNetAndCount();
    },
    //获取3级-社区级网格，并统计每个网格的相关数据
    dogetNetAndCount() {
      this.clearBuildingRemoveArea();
      this.removeFloor();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "netLevel": "3"
        };
        getNetAndCountBuildingRemove(params).then(res => {
          this.showBuildingRemoveArea(res.data);
        });
      } else {
        let params = {
          "netLevel": "3",
          'netPid': localStorage.getItem("roleId"),
        };
        getNetAndCountBuildingRemoveById(params).then(res => {
          this.showBuildingRemoveArea(res.data);
        });
      }
    },
    //绘制网格图形
    showBuildingRemoveArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "ba" + netData[i].netId,
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
        br_overlays3D.push(tmpClassificationPrimitive);
        let popoptions = {
          popId: netData[i].netId,
          name: netData[i].netName,
          rhNum: data[i * 4 + 1],
          addNum: data[i * 4 + 2],
          signNum: data[i * 4 + 3],
          rhaData: [
            {name: "已签约", value: data[i * 4 + 3]},
            {name: "未签约", value: data[i * 4 + 4]},
          ]
        };
        popUtil.installMapPop().braPop(popoptions);
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
      }
    },
    //清除网格图形
    clearBuildingRemoveArea() {
      for (let i = 0; i < br_overlays3D.length; i++) {
        viewer.scene.primitives.remove(br_overlays3D[i]);
      }
      br_overlays3D.length = 0;
      bc_overlays3D.map(item => {
        viewer.entities.remove(item);
      });
      bc_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(id) {
      this.clearBuildingRemoveArea();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        'netPid': id
      };
      queryNetData(params).then(res => this.showBuildingRemoveCom(res.data));
    },
    //显示最低级网格及其名称图标
    showBuildingRemoveCom(netData) {
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "bp" + netData[i].netId,
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
        br_overlays3D.push(tmpClassificationPrimitive);
        let netCenterArr = netData[i].netCenter.split(',');
        let pos = Cesium.Cartesian3.fromDegrees(netCenterArr[0], netCenterArr[1], netCenterArr[2]);
        bc_overlays3D.push(viewer.entities.add({
          id: "bc" + netData[i].netId,
          position: pos,
          label: {
            show: true,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
            font: 'bold 56px Helvetica',
            scale: 0.5,
            fillColor: netColor,
            style: Cesium.LabelStyle.FILL_AND_OUTLINE,
            outlineColor: Cesium.Color.WHITE,
            outlineWidth: 4,
            text: netData[i].netName,
            pixelOffset: new Cesium.Cartesian2(0.0, -20.0),
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            disableDepthTestDistance: 100000000,
          },
        }));
      }
    },
    //点击图标显示气泡
    getBuildingRemoveNetById(id) {
      let params = {
        netId: id
      };
      getBuildingRemoveNetById(params).then(res => {
        let data = res.data;
        let popoptions = {
          popId: data[0].netId,
          name: data[0].netName,
          rhNum: data[1],
          addNum: data[2],
          signNum: data[3],
          rhaData: [
            {name: "已签约", value: data[3]},
            {name: "未签约", value: data[4]},
          ]
        };
        popUtil.installMapPop().brcPop(popoptions);
        let centerArr = data[0].netCenter.split(',');
        let options = {
          "viewer": viewer,
          "id": data[0].netId,
          "popupWidth": 240,
          "popupHeight": 184,
          "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
          "extentHeight": 40,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);
      })
    },
    //点击4级图形或气泡上的深入箭头，获取其下级所有分层分户图形
    stepInCommunity(netId) {
      this.clearBuildingRemoveArea();
      that.pictLoading = true;
      that.isQueryShow = false;
      that.isResultShow = true;
      let params = {
        'removePid': netId
      };
      getBuildingRemoveByPid(params).then(res => {
        that.queryResult = res.data;
        that.pictLoading = false;
        this.showBuildingRemove(res.data);
      });
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
    eventBus.$on("br_panorama", (msg) => {
      this.openPhotoSphereViewer(msg);
    });
  },
}
</script>

<style scoped>
.result-table {
  width: 100%;
  color: #ffffff;
  overflow-x: hidden;
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
