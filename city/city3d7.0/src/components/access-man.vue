<template>
  <div id="access-man-is-show">
    <el-input placeholder="请输入搜索内容" icon="search" v-model="devFilter" class="search-input"></el-input>
    <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" size="small" @row-click="rowClick"
              :default-sort="{prop: 'accessTime', order: 'descending'}">
      <el-table-column label="编号" prop="userId" width="80px" sortable></el-table-column>
      <el-table-column label="类型" prop="accessType" width="70px" sortable></el-table-column>
      <el-table-column label="时间" prop="accessTime" width="140px" sortable></el-table-column>
      <el-table-column label="位置" prop="camName" width="75px" sortable></el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 20, 40]"
      :page-size="pagesize"
      :pager-count="5"
      layout="total, sizes, prev, pager, next"
      :total="tableDate.length">
    </el-pagination>
  </div>
</template>

<script>
  import {getAccessMan, getVideoByMacUrl} from "../api/api";
  import map3d from "./map-3d";

  let camera_mark;
  export default {
    name: "access-man",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        tableDate: [],
        devFilter: '',
        aiIp: common.aiIp
      };
    },
    methods: {
      dogetAccessMan() {
        getAccessMan().then(res => {
          let resArr = [];
          res.data.map(item => {
            switch (item.accessType) {
              case "0":
                item.accessType = "黑名单";
                break;
              case "1":
                item.accessType = "内部人员";
                break;
              case "2":
                item.accessType = "陌生人";
                break;
              default:
                break;
            }
            switch (item.cameraId) {
              case "192.168.3.187":
                item.camName = "西门车道";
                break;
              case "192.168.3.188":
                item.camName = "人行通道";
                break;
              default:
                break;
            }
            resArr.push(item);
          });
          this.queryResult = resArr;
          this.tableDate = resArr;
        });
      },
      //elementUI表格方法
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      //elementUI表格方法
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      rowClick(row, column, event) {
        let params = {macUrl: row.cameraId};
        getVideoByMacUrl(params).then(res => {
          let position = res.data.camPosition.split(',');
          let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          map3d.methods.flyToLocation([
            Number(position[0]),
            Number(position[1]),
            Number(position[2]) + 300,
          ]);
          let imgurl;
          if (res.data.camType === "3") {
            imgurl = 'static/images/pinimg/03.png';
          } else if (res.data.camType === "1") {
            imgurl = 'static/images/pinimg/04.png';
          } else if (res.data.camType === "2") {
            imgurl = 'static/images/pinimg/05.png';
          } else {
            imgurl = 'static/images/pinimg/05.png';
          }
          if (camera_mark) {
            camera_mark.position = point;
          } else {
            camera_mark = viewer.entities.add({
              name: '摄像头',
              id: 'ca' + res.data.id,
              position: point,
              billboard: {
                image: imgurl,
                scale: 0.8,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
              },
            });
          }
        });
      },
      closeAccessMan() {
        viewer.entities.remove(camera_mark);
        camera_mark = undefined;
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.camName.indexOf(val)
            || ~item.userId.indexOf(val)
            || ~item.accessType.indexOf(val)
            || ~item.accessTime.indexOf(val)
          ));
      }
    },
    mounted() {
      this.dogetAccessMan();
    }
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
  }

</style>
