<template>
  <div id="duty-net-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'netDep', order: 'ascending'}" @row-click="rowClick">
      <el-table-column label="点位名称" prop="netName" width="220px" sortable></el-table-column>
      <el-table-column label="类别" prop="netDep" width="130px" sortable></el-table-column>
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
  import {getPoliceNet} from "../api/api";
  import popUtil from "@/utils/pop/popUtil";
  import map3d from "./map-3d";

  let netArr = [];
  let netData = [];
  export default {
    name: "duty-net",
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
        let posArr = row.netCenter.split(',');
        let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
        this.showPoliceNetInfoPop(row, pos);
      },
      getPoliceNetById(id) {
        for (let i = 0; i < netData.length; i++) {
          if (netData[i].netId === id) {
            let posArr = netData[i].netCenter.split(',');
            let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
            this.showPoliceNetInfoPop(netData[i], pos);
            break;
          }
        }
      },
      showPoliceNetInfoPop(data, pos) {
        if (!document.getElementById('popupDiv' + data.netId)) {
          let popoptions = {
            popId: data.netId,
            netName: data.netName,
            netDep: data.netDep,
            netTime: data.netTime,
            netLevel: data.netLevel,
            netArea: data.netArea,
            netPeople: data.netPeople,
            netKeyPeople: data.netKeyPeople,
            netNote: data.netNote,
            netDutyCare: data.netDutyCare,
            netCareNote: data.netCareNote,
            netDutyGoods: data.netDutyGoods,
            netGoodsNote: data.netGoodsNote,
            otherNote: data.otherNote,
          };
          popUtil.installMapPop().dnPop(popoptions);
          let cartographic = Cesium.Cartographic.fromCartesian(pos);
          let lon = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          let options = {
            viewer: viewer,
            id: data.netId,
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
        let posArr = data.netCenter.split(",");
        posArr[2] = Number(posArr[2]) + 500;
        map3d.methods.flyToLocation(posArr);
      },
      showNet(data) {
        this.queryResult = data;
        netData = data;
        for (let i = 0; i < data.length; i++) {
          let pois = data[i].netPolygen.split(',');
          let position = data[i].netCenter.split(',');
          let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          netArr.push(viewer.entities.add({
            id: 'dn' + data[i].netId,
            position: point,
            label: {
              text: data[i].netName,
              font: '20px STHupo',
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              fillColor: Cesium.Color.fromCssColorString(data[i].netColor),
              outlineColor: Cesium.Color.WHITE,
              outlineWidth: 5.0,
              disableDepthTestDistance: 5000000,
            },
            polygon: {
              hierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(pois)),
              material: Cesium.Color.fromCssColorString(data[i].netColor).withAlpha(0.6)
            },
          }));
        }
      },
      closePoliceNet() {
        netArr.map(item => {
          viewer.entities.remove(item);
        });
        netArr = [];
        CesiumPop.clearDivPop(viewer);
      },
    },
    mounted() {
      getPoliceNet().then(res => this.showNet(res.data));
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
