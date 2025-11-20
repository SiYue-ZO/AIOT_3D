<template>
  <div id="iot-environment-is-show">
    <div v-show="clipStart" class="emer-row">
      <span class="emer-row-label">经度裁切：</span>
      <el-slider class="emer-slider" v-model="longitudeClip" :format-tooltip="formatTooltip"
                 @change="changeClipParam"></el-slider>
    </div>
    <div v-show="clipStart" class="emer-row">
      <span class="emer-row-label">纬度裁切：</span>
      <el-slider class="emer-slider" v-model="latitudeClip" :format-tooltip="formatTooltip"
                 @change="changeClipParam"></el-slider>
    </div>
    <div v-show="clipStart" class="emer-row">
      <span class="emer-row-label">高程裁切：</span>
      <el-slider class="emer-slider" v-model="heightClip" :format-tooltip="formatTooltip"
                 @change="changeClipParam"></el-slider>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="clipPoint" title="剖切点阵">
      <font-awesome-icon :icon="['fas', 'cut']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="clearClip" title="清除剖切">
      <font-awesome-icon :icon="['fas', 'times-circle']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <span class="emer-row-label">数据更新时间：</span>
      <span class="emer-row-label">{{time}}</span>
    </div>
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'type', order: 'ascending'}"
              :cell-style="cellStyle" @row-click="rowClick">
      <el-table-column label="名称" prop="name" width="190px" sortable></el-table-column>
      <el-table-column label="数值" prop="val" width="100px" sortable></el-table-column>
      <el-table-column label="状态" prop="status" width="70px" sortable></el-table-column>
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
  import "../js/CesiumHeatmap3d";
  import map3d from "./map-3d";

  let environDeviceArr = [];
  let range;
  export default {
    name: "iot-environment",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        time: "",
        clipStart: false,
        longitudeClip: 100,
        latitudeClip: 100,
        heightClip: 100
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
      cellStyle(row, column, rowIndex, columnIndex) {
        if (row.column.label === "状态" && row.row.status !== "正常") {
          return "color:#FF747B";
        }
      },
      //elementUI表格方法：点击行
      rowClick(row, column, event) {
        map3d.methods.flyToLocation([Number(row.devicePos[0]), Number(row.devicePos[1]), Number(row.devicePos[2]) + 200]);
      },
      getEnvironData() {
        let options = {
          viewer: viewer,
          cityPos: [126.60360175093398, 45.72171581421446, 300],//热力地图位置
          devicePosArr: [
            [126.63188820809117, 45.67080197646418, 500],
            [126.60360175093398, 45.72171581421446, 300],
            [126.58007411974839, 45.7037403069547, 160],
            [126.58917106261146, 45.75851952594732, 150],
            [126.53241004315593, 45.7986089892231, 120],
            [126.64343244169747, 45.698317975931495, 180],
            [126.65443560708191, 45.7713276917298, 170],
            [126.66627966156334, 45.731212629302426, 180],
          ],//监测设备位置
          valArr: [3100, 3000, 3300, 3000, 4000, 3300, 3300, 3500],//监测值
          nameArr: ["哈南", "学府路", "哈西", "道里", "松北", "植物园", "道外", "香坊"],//监测点位置
          size: 10,//散点的大小
          offset: 40,//散点之间的距离
          defaultGradient: [
            [0.25, 0, 0, 255, 0.2],
            [0.45, 0, 255, 255, 0.4],
            [0.6, 0, 255, 0, 0.5],
            [0.8, 255, 255, 0, 0.6],
            [1, 255, 0, 0, 0.8],
          ]//热力图图谱
        };
        range = CesiumHeatmap3d.load(options);
        options.valArr.map((item, i) => {
          let temp = {
            name: options.nameArr[i],
            val: item,
            devicePos: options.devicePosArr[i],
            status: item > 3300 ? "报警" : "正常",
          };
          this.queryResult.push(temp);
          environDeviceArr.push(viewer.entities.add({
            position: Cesium.Cartesian3.fromDegrees(options.devicePosArr[i][0], options.devicePosArr[i][1], options.devicePosArr[i][2]),
            billboard: {
              image: 'static/images/pinimg/32.png',
              scale: 0.6,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
            label: {
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: 'bold 42px Helvetica',
              scale: 0.5,
              fillColor: Cesium.Color.WHITE,
              text: options.nameArr[i],
              showBackground: true,
              backgroundColor: new Cesium.Color.fromCssColorString("#e54163").withAlpha(0.8),
              backgroundPadding: new Cesium.Cartesian2(25, 5),
              pixelOffset: new Cesium.Cartesian2(0.0, -50.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            }
          }));
        });
        this.time = (new Date()).pattern("yyyy-MM-dd hh:mm:ss");
      },
      closeIotEnvironment() {
        CesiumHeatmap3d.clear(viewer);
        environDeviceArr.map(item => {
          viewer.entities.remove(item);
        });
        environDeviceArr = [];
      },
      clipPoint() {
        this.clipStart = true;
      },
      clearClip() {
        CesiumHeatmap3d.clearClip();
        this.longitudeClip = 100;
        this.latitudeClip = 100;
        this.heightClip = 100;
        this.clipStart = false;
      },
      changeClipParam() {
        let lonResult = range[2] + (range[0] - range[2]) * this.longitudeClip / 100;
        let latResult = range[1] + (range[3] - range[1]) * this.latitudeClip / 100;
        let heightResult = range[4] + (range[5] - range[4]) * this.heightClip / 100;
        CesiumHeatmap3d.clip(lonResult, latResult, heightResult);
      },
      formatTooltip(val) {
        return val / 100;
      },
    },
    mounted() {
      this.getEnvironData();
    }
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
  }

  .emer-row {
    color: #ffffff;
    margin: 10px 0;
    height: 26px
  }

  .emer-row-label {
    font-size: 15px;
    margin: 2px 0 3px 0;
    color: #ffffff;
    float: left;
  }

  .emer-slider {
    width: 270px;
    float: left;
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
    right: 80px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-stop {
    right: 120px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
