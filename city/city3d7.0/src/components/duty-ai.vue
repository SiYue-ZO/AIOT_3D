<template>
  <div id="duty-ai-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" size="small"
              :default-sort="{prop: 'origin', order: 'ascending'}">
      <el-table-column label="姓名" prop="name" width="130px" sortable></el-table-column>
      <el-table-column label="类型" prop="origin" width="90px" sortable></el-table-column>
      <el-table-column label="职务" prop="post" width="90px" sortable></el-table-column>
      <el-table-column label="记录" prop="status" width="45px">
        <template slot-scope="scope">
          <el-popover
            placement="right"
            width="400"
            trigger="click">
            <el-table :data="patrolResult.slice((currentPagePop-1)*pagesizePop,currentPagePop*pagesizePop)" size="small"
                      class="result-table" :default-sort="{prop: 'captureTime', order: 'descending'}" :stripe="true"
                      :highlight-current-row="true" @row-click="rowClick">
              <el-table-column label="打卡照片" property="image" width="70px">
                <template slot-scope="scope1">
                  <el-image class="table-img" :src="aiIp+scope1.row.image"
                            :preview-src-list="[aiIp+scope1.row.image]"></el-image>
                </template>
              </el-table-column>
              <el-table-column label="打卡时间" property="captureTime" sortable></el-table-column>
              <el-table-column label="打卡相机" property="video.camAdd"></el-table-column>
            </el-table>
            <el-pagination
              @size-change="handleSizeChangePop"
              @current-change="handleCurrentChangePop"
              :current-page="currentPagePop"
              :page-sizes="[5, 10, 20, 40]"
              :page-size="pagesizePop"
              :pager-count="5"
              layout="total, sizes, prev, pager, next"
              :total="patrolResult.length">
            </el-pagination>
            <el-button slot="reference" icon="el-icon-search" circle type="primary" size="mini"
                       @click="dogetDutyAi(scope.row.birth)"></el-button>
          </el-popover>
        </template>
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
</template>

<script>
  import {getFaceIdentityByRepoTypeandUserId, getPolice} from "../api/api";

  let camera_mark;
  export default {
    name: "duty-ai",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        patrolResult: [],
        currentPagePop: 1, //初始页
        pagesizePop: 5,   //每页的数据
        aiIp: common.aiIp
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
      //elementUI表格方法
      handleSizeChangePop: function (size) {
        this.pagesizePop = size;
      },
      //elementUI表格方法
      handleCurrentChangePop: function (currentPage) {
        this.currentPagePop = currentPage;
      },
      rowClick(row, column, event) {
        let position = row.video.camPosition.split(',');
        let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        let imgurl;
        if (row.video.camType === "3") {
          imgurl = 'static/images/pinimg/03.png';
        } else if (row.video.camType === "1") {
          imgurl = 'static/images/pinimg/04.png';
        } else if (row.video.camType === "2") {
          imgurl = 'static/images/pinimg/05.png';
        } else {
          imgurl = 'static/images/pinimg/05.png';
        }
        if (camera_mark) {
          camera_mark.position = point;
        } else {
          camera_mark = viewer.entities.add({
            name: '摄像头',
            id: 'ca' + row.video.id,
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
      },
      dogetDutyAi(birth) {
        let params = {
          'repoType': '2',
          'userId': birth
        };
        getFaceIdentityByRepoTypeandUserId(params).then(res => {
          this.currentPagePop = 1;
          this.patrolResult = res.data;
        });
      },
      closeDutyAi() {
        viewer.entities.remove(camera_mark);
        camera_mark = undefined;
      }
    },
    mounted() {
      getPolice().then(res => {
        this.queryResult = res.data;
      });
    }
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
  }

  .table-img {
    height: 60px;
    width: 40px;
    margin-left: 10px;
  }
</style>
