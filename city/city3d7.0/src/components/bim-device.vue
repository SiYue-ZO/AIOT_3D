<template>
  <div id="bim-device-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'type', order: 'ascending'}"
              :cell-style="cellStyle" @row-click="rowClick">
      <el-table-column label="名称" prop="name" width="190px" sortable></el-table-column>
      <el-table-column label="类型" prop="type" width="100px" sortable></el-table-column>
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
import popUtil from "@/utils/pop/popUtil";
import {getAllandDeviceById, getBimDevice, getBimDeviceById, getVideoById} from "../api/api";
import {getFlatternDistance} from "@/js/CesiumTools";
import iotVideo from "./iot-video";

let bimDeviceArr = [];
export default {
  name: "bim-device",
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      pictLoading: false,
      queryResult: [],
      alarmResult: [],
      preId: ""
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
      let posArr = row.devicepos.split(',');
      let pos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
      this.showBimDeviceInfoPop(row, pos);
    },
    getBimDeviceById(id, pos) {
      let params = {
        "deviceId": id
      };
      getBimDeviceById(params).then(res => this.showBimDeviceInfoPop(res.data, pos));
    },
    showBimDeviceInfoPop(data, pos) {
      if (!document.getElementById('popupDiv' + data.deviceId)) {
        let popoptions = {
          popId: data.deviceId,
          name: data.name,
          status: data.status,
          temp: data.temp,
          voltage: data.voltage,
          runTime: data.runTime,
        };
        popUtil.installMapPop().dePop(popoptions);
        let cartographic = Cesium.Cartographic.fromCartesian(pos);
        let lon = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        let options = {
          viewer: viewer,
          id: data.deviceId,
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
    },
    initBimDevice(data) {
      this.queryResult = data;
      data.map(item => {
        let posArr = item.devicepos.split(',');
        let mat;
        switch (item.type) {
          case "供电":
            mat = Cesium.Color.RED.withAlpha(0.3);
            break;
          case "空调":
            mat = Cesium.Color.GREENYELLOW.withAlpha(0.3);
            break;
          case "给排水":
            mat = Cesium.Color.SKYBLUE.withAlpha(0.4);
            break;
          case "照明":
            mat = Cesium.Color.YELLOW.withAlpha(0.3);
            break;
          default:
            break;
        }
        bimDeviceArr.push(viewer.entities.add({
          id: "de" + item.deviceId,
          polygon: {
            hierarchy: {
              positions: new Cesium.Cartesian3.fromDegreesArrayHeights(posArr),
            },
            perPositionHeight: true,
            extrudedHeight: Number(item.height) + Number(posArr[2]),
            material: mat
          }
        }));
        if (item.status !== "正常") {
          this.alarmResult.push(item);
        }
      });
    },
    startDeviceAlarm() {
      let _this = this;
      let alarmStep = 0;
      let alarmInt = setInterval(() => {
        if (alarmStep > _this.alarmResult.length - 1) {
          clearInterval(alarmInt);
          return;
        }
        let x = 1;
        let flog = true;
        let mat = new Cesium.ColorMaterialProperty(new Cesium.CallbackProperty(function (time, result) {
          //图标闪烁效果
          if (flog) {
            x = x - 0.02;
            if (x <= 0) {
              flog = false;
            }
          } else {
            x = x + 0.02;
            if (x >= 1) {
              flog = true;
            }
          }
          return Cesium.Color.PURPLE.withAlpha(x);
        }, false));
        let alarmDevice = viewer.entities.getById("de" + _this.alarmResult[alarmStep].deviceId);
        alarmDevice.polygon.material = mat;
        this.$message({
          type: "error",
          message: "设备：" + _this.alarmResult[alarmStep].name + "，状态异常！请注意！",
          duration: 0,
          showClose: true,
        });
        _this.dogetRelateVideo(_this.alarmResult[alarmStep].floor);
        alarmStep++;
      }, 10000);
    },
    closeBimDevice() {
      bimDeviceArr.map(item => {
        viewer.entities.remove(item);
      });
      bimDeviceArr = [];
      CesiumPop.clearDivPop(viewer);
    },
    //获取关联视频
    dogetRelateVideo(id) {
      if (this.preId !== "") {
        let vid = "video" + this.preId;
        let videoElement = document.getElementById(vid);
        if (videoElement != null) {
          iotVideo.methods.destroyVideoElement(videoElement);
        }
        iotVideo.methods.destroyCameraVideo(vid);
        iotVideo.methods.dostopVideoConvertor(this.preId);
        CesiumPop.removeDivPopById(viewer, this.preId);
      }

      let params = {
        id: id
      };
      getVideoById(params).then(res => {
        let data = res.data;
        //开启对应相机转码
        iotVideo.methods.dostartVideoConverter(data, true);
        this.preId = id;
      });
    },
  },
  mounted() {
    if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
      getBimDevice().then(res => {
        this.initBimDevice(res.data);
        this.startDeviceAlarm();
      });
    } else {
      let params = {
        'roleId': localStorage.getItem("roleId"),
      };
      getAllandDeviceById(params).then(res => {
        let resultArr = [];
        res.data.sysRoleDevice.map(item => {
          resultArr.push(item.bimDevice);
        });
        this.initBimDevice(resultArr);
        this.startDeviceAlarm();
      });
    }
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  color: #ffffff;
}
</style>
