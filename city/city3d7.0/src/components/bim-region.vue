<template>
  <div id="bim-region-is-show">
    <div class="emer-row">
      <span class="legendRow">
        <div class="legendColor1"></div>
        <span class="legend-label">重点</span>
      </span>
      <span class="legendRow">
        <div class="legendColor2"></div>
        <span class="legend-label">危险</span>
      </span>
      <span class="legendRow">
        <div class="legendColor3"></div>
        <span class="legend-label">警示</span>
      </span>
      <span class="legendRow">
        <div class="legendColor4"></div>
        <span class="legend-label">权限</span>
      </span>
      <span class="legendRow">
        <div class="legendColor5"></div>
        <span class="legend-label">限制</span>
      </span>
    </div>
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'netName', order: 'ascending'}"
              @row-click="rowClick">
      <el-table-column label="名称" prop="netName" width="260px" sortable></el-table-column>
      <el-table-column label="类别" prop="netDep" width="100px" sortable></el-table-column>
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
  import {queryPoliceNet} from "../api/api";
  import map3d from './map-3d';

  let areaEntArr = [];
  export default {
    name: "bim-region",
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
        let posArr = row.netPolygen.split(',');
        map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 100]);
      },
      showBimRegion(data) {
        this.queryResult = data;
        data.map(item => {
          let posArr = item.netPolygen.split(',');
          let posHighArr = [];
          for (let i = 0; i < posArr.length; i = i + 3) {
            posHighArr.push(posArr[i], posArr[i + 1], Number(posArr[i + 2]) + 0.5);
          }
          areaEntArr.push(viewer.entities.add({
            polygon: {
              hierarchy: {
                positions: Cesium.Cartesian3.fromDegreesArrayHeights(posHighArr),
              },
              material: Cesium.Color.fromCssColorString(item.netColor).withAlpha(0.6),
              // classificationType: Cesium.ClassificationType.NONE,
              perPositionHeight: true
            }
          }));
        });
      },
      closeBimRegion() {
        areaEntArr.map(item => {
          viewer.entities.remove(item);
        });
        areaEntArr = [];
      },
    },
    mounted() {
      let params = {
        'netDep': '室内分区'
      };
      queryPoliceNet(params).then(res => this.showBimRegion(res.data));
    },
  }
</script>

<style scoped>
  .emer-row {
    color: #ffffff;
    margin: 8px 0;
  }

  .legend-label {
    width: 38px;
    font-size: 14px;
    margin: 2px 0 0 5px;
    float: left;
  }

  .legendRow {
    float: left;
  }

  .legendColor1 {
    width: 24px;
    height: 24px;
    border: solid 1px #ffffff;
    border-radius: 4px;
    background-color: #e4cd04;
    float: left;
  }

  .legendColor2 {
    width: 24px;
    height: 24px;
    border: solid 1px #ffffff;
    border-radius: 4px;
    background-color: #f07100;
    float: left;
  }

  .legendColor3 {
    width: 24px;
    height: 24px;
    border: solid 1px #ffffff;
    border-radius: 4px;
    background-color: #ff2039;
    float: left;
  }

  .legendColor4 {
    width: 24px;
    height: 24px;
    border: solid 1px #ffffff;
    border-radius: 4px;
    background-color: #4eff52;
    float: left;
  }

  .legendColor5 {
    width: 24px;
    height: 24px;
    border: solid 1px #ffffff;
    border-radius: 4px;
    background-color: #75dfff;
    float: left;
  }

  .result-table {
    width: 100%;
    color: #ffffff;
    padding-top: 15px;
  }
</style>
