<template>
  <div id="bim-water-flow-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'flowName', order: 'ascending'}"
              @row-click="rowClick">
      <el-table-column label="名称" prop="flowName" width="360px" sortable></el-table-column>
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
  import "../js/CesiumTrail.js";
  import map3d from './map-3d';
  import {getBimWaterFlow} from '../api/api';

  let flowArr = [];
  export default {
    name: "bim-water-flow",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: []
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
        let posArr = row.flowPos.split(',');
        map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 100]);
      },
      showBimWaterFlow(data) {
        this.queryResult = data;
        data.map(item => {
          let posArr = item.flowPos.split(',');
          flowArr.push(viewer.entities.add({
            polyline: {
              positions: Cesium.Cartesian3.fromDegreesArrayHeights(posArr),
              width: 20,
              material: new Cesium.PolylineTrailLinkMaterialProperty(Cesium.Color.BLUE, 100000),
            }
          }));
          for (let i = 0; i < posArr.length; i = i + 3) {
            flowArr.push(viewer.entities.add({
              position: Cesium.Cartesian3.fromDegrees(posArr[i], posArr[i + 1], posArr[i + 2]),
              point: {
                pixelSize: 8.0,
                color: Cesium.Color.BLUE,
                outlineColor: Cesium.Color.WHITE,
                outlineWidth: 2.0,
                disableDepthTestDistance: 5000000,
              }
            }));
          }
        });
      },
      closeBimWaterFlow() {
        flowArr.map(item => {
          viewer.entities.remove(item);
        });
        flowArr = [];
      },
    },
    mounted() {
      getBimWaterFlow().then(res => this.showBimWaterFlow(res.data));
    },
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
  }
</style>
