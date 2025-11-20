<template>
  <div id="iot-water-is-show">
    <div class="emer-row">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'checkAdd', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="监测段" prop="checkAdd" width="80px" sortable></el-table-column>
        <el-table-column label="负责人" prop="checkMan" width="80px" sortable></el-table-column>
        <el-table-column label="水位高" prop="waterLevel" width="80px" sortable></el-table-column>
        <el-table-column label="位置" prop="checkAddStr" width="125px" sortable></el-table-column>
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
      <div>
        * 阈值：1.5米
      </div>
    </div>
  </div>
</template>

<script>
  import popUtil from "@/utils/pop/popUtil";
  import map3d from "./map-3d";
  import "../js/CesiumPop.js";

  export default {
    name: "iot-water",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        queryResult: [
          // {'checkAdd': '5-16-31-1', 'checkMan': '李浩然', 'time': '2020-10-25', 'poi': '正常'},
          // {'checkAdd': '5-16-31-2', 'checkMan': '李浩然', 'time': '2020-10-25', 'poi': '腐蚀'},
          // {'checkAdd': '5-16-31-3', 'checkMan': '白王路', 'time': '2020-10-25', 'poi': '腐蚀'},
          // {'checkAdd': '3-11-8-1', 'checkMan': '朱开播', 'time': '2020-10-26', 'poi': '正常'},
          {'checkAdd': '3-11-8-2', 'checkMan': '朱开播', 'waterLevel':0.4, 'checkAddStr': '学府路涵洞', 'time': '2020-10-26', 'poi': '126.61715206188845,45.71722302186345,179.63986943053897'},
          // {'checkAdd': '3-11-8-3', 'checkMan': '白王路', 'time': '2020-10-26', 'poi': '正常'},
          // {'checkAdd': '3-11-8-4', 'checkMan': '白王路', 'time': '2020-10-26', 'poi': '正常'},
          {'checkAdd': '3-11-8-5', 'checkMan': '白王路','waterLevel':1.6, 'checkAddStr': '测绘路涵洞', 'time': '2020-10-26', 'poi': '126.61063049345108,45.71682151371739,185.35083039800034'},
          // {'checkAdd': '3-11-8-6', 'checkMan': '李浩然', 'time': '2020-10-26', 'poi': '泄漏'},
          // {'checkAdd': '3-11-8-7', 'checkMan': '李浩然', 'time': '2020-10-26', 'poi': '正常'},
          // {'checkAdd': '3-11-8-8', 'checkMan': '李浩然', 'time': '2020-10-26', 'poi': '正常'},
          // {'checkAdd': '4-6-22-1', 'checkMan': '徐浩', 'time': '2020-10-27', 'poi': '正常'},
          // {'checkAdd': '4-6-22-2', 'checkMan': '徐浩', 'time': '2020-10-27', 'poi': '腐蚀'},
          // {'checkAdd': '4-6-22-3', 'checkMan': '徐浩', 'time': '2020-10-27', 'poi': '正常'},
          {'checkAdd': '4-6-22-4', 'checkMan': '徐浩','waterLevel':1.8, 'checkAddStr': '大直街立交桥', 'time': '2020-10-27', 'poi': '126.60719398801082,45.723447708165,182.3884944790228'},
          // {'checkAdd': '4-6-22-5', 'checkMan': '徐浩', 'time': '2020-10-27', 'poi': '正常'},
          // {'checkAdd': '4-6-22-6', 'checkMan': '李浩然', 'time': '2020-10-27', 'poi': '正常'},
          // {'checkAdd': '4-6-22-7', 'checkMan': '李浩然', 'time': '2020-10-27', 'poi': '腐蚀'},
          // {'checkAdd': '4-6-22-8', 'checkMan': '李浩然', 'time': '2020-10-27', 'poi': '正常'},
          {'checkAdd': '4-6-22-9', 'checkMan': '徐浩','waterLevel':2.1, 'checkAddStr': '大成街隧道', 'time': '2021-08-01', 'poi': '126.6045040417034,45.71981460631859,184.45317482418272'},
          {'checkAdd': '4-6-22-10', 'checkMan': '李浩然','waterLevel':2.3, 'checkAddStr': '征仪路隧道', 'time': '2020-10-27', 'poi': '126.60327317686124,45.721724930905836,183.9728572397668'}
        ],
        pictLoading: false
      }
    },
    methods: {
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      rowClick(row, column, event) {
        let flypoiArr = row.poi.split(',');
        flypoiArr[2] = Number(flypoiArr[2]) + 300;
        map3d.methods.flyToLocation(flypoiArr);
      },
      showWaterLevel() {
        this.queryResult.map(item => {
          let popoptions = {
            popId: item.checkAdd,
          };
          popUtil.installMapPop().waterPop(popoptions);
          let centerArr = item.poi.split(',');
          let options = {
            "viewer": viewer,
            "id": item.checkAdd,
            "popupWidth": 220,
            "popupHeight": 130,
            "pos": {"lon": Number(centerArr[0]), "lat": Number(centerArr[1]), "alt": Number(centerArr[2])},
            "extentHeight": 50,
            "extentColor": Cesium.Color.WHITE.withAlpha(0.8),
          };
          CesiumPop.addDivPop(options);
        });
      },
      closeWaterLevel() {
        CesiumPop.clearDivPop(viewer);
      }
    },
    mounted() {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.showWaterLevel();
    }
  }
</script>

<style scoped>
  .emer-row {
    color: #ffffff;
    margin: 8px 0;
    height: 32px
  }

  .result-table {
    width: 100%;
    color: #ffffff;
  }
</style>
