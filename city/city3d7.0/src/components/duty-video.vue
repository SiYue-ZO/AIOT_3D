<template>
  <div id="duty-video-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startDuty" title="开始巡查">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="startDuty" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="stopDuty" title="停止巡查">
      <font-awesome-icon :icon="['fas', 'stop']"></font-awesome-icon>
    </div>
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'dutyType', order: 'ascending'}"
              @row-click="rowClick">
      <el-table-column label="任务名称" prop="dutyName" width="240px" sortable></el-table-column>
      <el-table-column label="任务类型" prop="dutyType" width="120px" sortable></el-table-column>
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
  import map3d from './map-3d';
  import iotVideo from './iot-video';
  import popVideo from '../utils/pop/components/pop-video';
  import {getDutyVideo} from '../api/api';

  let _this;
  let camera_marks = [];
  let dutyVideoLines = [];
  let dutyVideoVideo = [];
  let dutyInterval;
  let dutyInt = 0;
  let preVideoId = "";
  let dutyTime = "";
  export default {
    name: "duty-video",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        isPause: true,
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
        this.removeDutyVideoArr();
        this.removeVideo();
        dutyVideoVideo = row.dutyVideoVideo;
        this.dutyTime = row.dutyTime;
        if (row.dutyVideoVideo.length > 1) {
          let posArr = row.dutyVideoVideo[0].video.camPosition.split(',');
          map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 1000]);
          for (let i = 0; i < row.dutyVideoVideo.length - 1; i++) {
            let posArr = row.dutyVideoVideo[i].video.camPosition.split(',');
            let posArr1 = row.dutyVideoVideo[i + 1].video.camPosition.split(',');
            let videoPos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
            let videoPos1 = new Cesium.Cartesian3.fromDegrees(posArr1[0], posArr1[1], posArr1[2]);
            this.addDutyLineToMap([videoPos, videoPos1]);
          }
          for (let i = 0; i < row.dutyVideoVideo.length; i++) {
            this.showVideo(row.dutyVideoVideo[i].video);
          }
        }
      },
      getDutyVideoData() {
        this.pictLoading = true;
        getDutyVideo().then(res => {
          this.queryResult = res.data;
          this.pictLoading = false;
        });
      },
      showVideo(data) {
        let position = data.camPosition.split(',');
        let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        let imgurl;
        if (data.camType === "3") {
          imgurl = 'static/images/pinimg/03.png';
        } else if (data.camType === "1") {
          imgurl = 'static/images/pinimg/04.png';
        } else if (data.camType === "2") {
          imgurl = 'static/images/pinimg/05.png';
        } else {
          imgurl = 'static/images/pinimg/05.png';
        }
        camera_marks.push(viewer.entities.add({
          name: '摄像头',
          id: 'ca' + data.id,
          position: point,
          billboard: {
            image: imgurl,
            scale: 0.8,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            disableDepthTestDistance: 200,
          },
        }));
      },
      removeVideo() {
        camera_marks.map(item => {
          viewer.entities.remove(item);
        });
        camera_marks = [];
        dutyVideoVideo = [];
      },
      addDutyLineToMap(videoPosArr) {
        dutyVideoLines.push(viewer.entities.add({
          polyline: {
            positions: videoPosArr,
            width: 15.0,
            material: new Cesium.PolylineArrowMaterialProperty(Cesium.Color.RED),
            clampToGround: true
          }
        }));
      },
      removeDutyVideoArr() {
        dutyVideoLines.map(item => {
          viewer.entities.remove(item);
        });
        dutyVideoLines = [];
      },
      closeDutyVideo() {
        this.stopDuty();
        this.removeDutyVideoArr();
        this.removeVideo();
        iotVideo.methods.clearVideoAll();
        CesiumPop.clearDivPop(viewer);
        iotVideo.methods.stopCamMoveListener();
      },
      startDuty() {
        if (dutyVideoVideo.length > 0) {
          CesiumPop.bindPopGlobeEventHandler(viewer);
          this.isPause = true;
          startVideo();
          _this.$message({
            message: '开始巡查！',
            type: 'success'
          });
          dutyInterval = setInterval(() => {
            if (preVideoId !== "") {
              popVideo.methods.popCloseById(preVideoId);
            }
            if (dutyInt < dutyVideoVideo.length) {
              startVideo();
            } else {
              _this.$message({
                message: '本次巡查完成，开始循环巡查！',
                type: 'warning'
              });
              dutyInt = 0;
              startVideo();
            }
          }, Number(_this.dutyTime) * 1000);
        } else {
          _this.$message({
            message: '请先选择任务！',
            type: 'error'
          });
        }

        function startVideo() {
          iotVideo.methods.getVideoById(dutyVideoVideo[dutyInt].video.id);
          let posArr = dutyVideoVideo[dutyInt].video.camPosition.split(',');
          map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 500]);
          preVideoId = dutyVideoVideo[dutyInt].video.id;
          dutyInt++;
        }
      },
      stopDuty() {
        if (dutyVideoVideo.length > 0) {
          clearInterval(dutyInterval);
          dutyInt = 0;
          preVideoId = "";
          iotVideo.methods.clearVideoAll();
          CesiumPop.clearDivPop(viewer);
          iotVideo.methods.stopCamMoveListener();
          _this.$message({
            message: '停止巡查！',
            type: 'success'
          });
        } else {
          _this.$message({
            message: '请先选择任务！',
            type: 'error'
          });
        }
      },
      //暂停
      pauseOrContinue() {
        if (dutyVideoVideo.length > 0) {
          this.isPause = !this.isPause;
          clearInterval(dutyInterval);
          _this.$message({
            message: '暂停巡查！',
            type: 'success'
          });
        } else {
          _this.$message({
            message: '请先选择任务！',
            type: 'error'
          });
        }
      },
    },
    mounted() {
      this.getDutyVideoData();
      _this = this;
    },
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
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
    right: 160px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-pause {
    right: 120px;
  }

  .pop-fai-pause:hover {
    background-color: #e0960d;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
