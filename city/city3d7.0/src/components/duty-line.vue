<template>
  <div id="duty-line-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'lTime', order: 'descending'}" @row-click="rowClick">
      <el-table-column label="路径名称" prop="lName" width="130px" sortable></el-table-column>
      <el-table-column label="姓名" prop="lPName" width="120px" sortable></el-table-column>
      <el-table-column label="时间" prop="lTime" width="105px" sortable></el-table-column>
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
  import {getPoliceLine} from "../api/api";
  import popUtil from "@/utils/pop/popUtil";
  import map3d from "./map-3d";

  let lineArr = [];
  let lineData = [];
  export default {
    name: "duty-line",
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
        let posArr = row.lPoyline.split(',');
        let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
        this.showPoliceLineInfoPop(row, pos);
      },
      getPoliceLineById(id, pos) {
        for (let i = 0; i < lineData.length; i++) {
          if (lineData[i].lId === id) {
            this.showPoliceLineInfoPop(lineData[i], pos);
            break;
          }
        }
      },
      showPoliceLineInfoPop(data, pos) {
        if (!document.getElementById('popupDiv' + data.lId)) {
          let popoptions = {
            popId: data.lId,
            lName: data.lName,
            lType: data.lType,
            lTime: data.lTime,
            lPName: data.lPName,
            lStop: data.lStop,
            lLiving: data.lLiving,
            lNote: data.lNote,
          };
          popUtil.installMapPop().dlPop(popoptions);
          let cartographic = Cesium.Cartographic.fromCartesian(pos);
          let lon = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          let options = {
            viewer: viewer,
            id: data.lId,
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
          map3d.methods.flyToLocation([lon, lat, Number(cartographic.height) + 500]);
        }
      },
      showLine(data) {
        this.queryResult = data;
        lineData = data;
        for (let i = 0; i < data.length; i++) {
          let position = data[i].lPoyline.split(',');
          let color = data[i].lColor === null || data[i].lColor === "" ? "#ff0000" : data[i].lColor;
          lineArr.push(viewer.entities.add({
            id: 'dl' + data[i].lId,
            polyline: {
              positions: Cesium.Cartesian3.fromDegreesArrayHeights(position),
              width: 6.0,
              material: Cesium.Color.fromCssColorString(color),
              clampToGround: true
            }
          }));
          //创建标注
          for (let j = 0; j < position.length; j = j + 3) {
            lineArr.push(viewer.entities.add({
              position: Cesium.Cartesian3.fromDegrees(position[j], position[j + 1], position[j + 2]),
              point: {
                pixelSize: 8.0,
                color: Cesium.Color.fromCssColorString(color),
                outlineColor: Cesium.Color.WHITE,
                outlineWidth: 2.0,
                disableDepthTestDistance: 5000000,
              }
            }));
          }
        }
      },
      closePoliceLine() {
        lineArr.map(item => {
          viewer.entities.remove(item);
        });
        lineArr = [];
        CesiumPop.clearDivPop(viewer);
      },
    },
    mounted() {
      getPoliceLine().then(res => this.showLine(res.data));
      CesiumPop.bindPopGlobeEventHandler(viewer);
    },
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
  }
</style>
