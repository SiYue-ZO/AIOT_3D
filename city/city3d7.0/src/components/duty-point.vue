<template>
  <div id="duty-point-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'pTime', order: 'descending'}" @row-click="rowClick">
      <el-table-column label="点位名称" prop="pName" width="130px" sortable></el-table-column>
      <el-table-column label="确症" prop="nameChecked" width="120px" sortable></el-table-column>
      <el-table-column label="时间" prop="pTime" width="105px" sortable></el-table-column>
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
</template>

<script>
import {getPolicePoint} from "../api/api";
import popUtil from "@/utils/pop/popUtil";
import map3d from "./map-3d";

let pointArr = [];
let pointData = [];
export default {
  name: "duty-point",
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      pictLoading: false,
      queryResult: [],
    };
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
      let posArr = row.pPoi.split(',');
      let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
      this.showPolicePointInfoPop(row, pos);
    },
    getPolicePointById(id) {
      for (let i = 0; i < pointData.length; i++) {
        if (pointData[i].pId === id) {
          let posArr = pointData[i].pPoi.split(',');
          let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
          this.showPolicePointInfoPop(pointData[i], pos);
          break;
        }
      }
    },
    showPolicePointInfoPop(data, pos) {
      if (!document.getElementById('popupDiv' + data.pId)) {
        let popoptions = {
          popId: data.pId,
          pName: data.pName,
          pType: data.pType,
          nameChecked: data.nameChecked,
          nameClose: data.nameClose,
          nameSubClose: data.nameSubClose,
          idChecked: data.idChecked,
          idClose: data.idClose,
          idSubClose: data.idSubClose,
          pTime: data.pTime,
          pLiving: data.pLiving,
          pFlow: data.pFlow,
          pNote: data.pNote,
        };
        popUtil.installMapPop().dpPop(popoptions);
        let cartographic = Cesium.Cartographic.fromCartesian(pos);
        let lon = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        let options = {
          viewer: viewer,
          id: data.pId,
          popupWidth: 477,
          popupHeight: 323,
          pos: {
            lon: lon,
            lat: lat,
            alt: cartographic.height,
          },
          extentHeight: 0,
          extentColor: Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options, "h");
      }
      if (data.camPoi === "" || data.camPoi === null) {
        let posArr = data.pPoi.split(",");
        posArr[2] = Number(posArr[2]) + 500;
        map3d.methods.flyToLocation(posArr);
      } else {
        let camPosArr = data.camPoi.split(",");
        map3d.methods.moveToWin(camPosArr[0], camPosArr[1], camPosArr[2], data.camHeading, data.camPitch);
      }
    },
    showPoint(data) {
      this.queryResult = data;
      pointData = data;
      for (let i = 0; i < data.length; i++) {
        let position = data[i].pPoi.split(',');
        let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
        let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
        let color = data[i].pColor === null || data[i].pColor === "" ? "#ff0000" : data[i].pColor;
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.fromCssColorString(color), 30)
        ).then(function (canvas) {
          return pointArr.push(viewer.entities.add({
            id: 'dp' + data[i].pId,
            position: point,
            label: {
              show: true,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: 'bold 36px Helvetica',
              scale: 0.5,
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              fillColor: Cesium.Color.fromCssColorString(color),
              text: data[i].pName,
              outlineColor: Cesium.Color.WHITE,
              outlineWidth: 12,
              pixelOffset: new Cesium.Cartesian2(0.0, -50.0),
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 100000000,
            },
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
          }));
        });
      }
    },
    closePolicePoint() {
      pointArr.map(item => {
        viewer.entities.remove(item);
      });
      pointArr = [];
      CesiumPop.clearDivPop(viewer);
    },
  },
  mounted() {
    getPolicePoint().then(res => this.showPoint(res.data));
    CesiumPop.bindPopGlobeEventHandler(viewer);
  },
}
</script>

<style scoped>
.result-table {
  width: 100%;
  color: #ffffff;
  overflow-x: hidden;
}
</style>
