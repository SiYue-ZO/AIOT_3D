<template>
  <div id="map-image-is-show">
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'imageTime', order: 'descending'}" @row-click="rowClick">
      <el-table-column label="缩略图" prop="imageUrl" width="115px" sortable>
        <template slot-scope="scope">
          <el-image style="width: 100px"
                    :src="photoSrc+scope.row.imageName+scope.row.imageId+scope.row.imageName.substring(scope.row.imageName.indexOf('.'))"
                    :preview-src-list="[photoSrc+scope.row.imageName+scope.row.imageId+scope.row.imageName.substring(scope.row.imageName.indexOf('.'))]"/>
        </template>
      </el-table-column>
      <el-table-column label="拍照时间" prop="imageTime" width="120px" sortable></el-table-column>
      <el-table-column label="照片名称" prop="imageName" width="120px" sortable></el-table-column>
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
    <el-dialog
      v-bind:title="mapPhotosTitle"
      :visible.sync="dialogPanorama"
      width="80%" top="80px"
      :modal-append-to-body="false"
      destroy-on-close
      :before-close="closeImageViewer"
    >
      <div class="deal-time">拍摄时间：{{ curTime }}</div>
      <el-image style="width: 58%" :src="photoSrc+curImgSrc" :preview-src-list="[photoSrc+curImgSrc]"/>
      <div class="deal-box">
        <div class="deal-box-con">
          <div class="deal-title color1">清 理 前：</div>
          <el-image class="deal-img" :src="photoSrc+curImgSrc1" :preview-src-list="[photoSrc+curImgSrc1]"/>
        </div>
        <div class="deal-box-con">
          <div class="deal-title color2">清 理 中：</div>
          <el-image class="deal-img" :src="photoSrc+curImgSrc2" :preview-src-list="[photoSrc+curImgSrc2]"/>
        </div>
        <div class="deal-box-con" style="margin-top: 20px">
          <div class="deal-title color3">清 理 后：</div>
          <el-image class="deal-img" :src="photoSrc+curImgSrc3" :preview-src-list="[photoSrc+curImgSrc3]"/>
        </div>
        <div class="deal-box-con" style="margin-top: 20px">
          <div class="deal-title color4">误 判：</div>
          <el-image class="deal-img" :src="photoSrc+curImgSrc4" :preview-src-list="[photoSrc+curImgSrc4]"/>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import map3d from "./map-3d";
import {getMapImage, getMapImageByPid} from "../api/api";

let _this;
let mapImageArr = [];
export default {
  name: "map-image",
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      pictLoading: false,
      queryResult: [],
      photoSrc: common.serverIp + "city3dfile/mapimage/",
      dialogPanorama: false,
      mapPhotosTitle: "",
      curTime: "",
      curImgSrc: "",
      curImgSrc1: "",
      curImgSrc2: "",
      curImgSrc3: "",
      curImgSrc4: "",
    }
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
      let posArr = row.imagePos.split(',');
      map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 2000]);
    },
    getMapImageData() {
      this.pictLoading = true;
      getMapImage().then(res => {
        this.queryResult = res.data;
        this.pictLoading = false;
        this.showMapImagePin(res.data);
      });
    },
    showMapImagePin(data) {
      let pinBuilder = new Cesium.PinBuilder();
      let url = Cesium.buildModuleUrl("../../../static/images/uav.png");
      data.map(item => {
        let posArr = item.imagePos.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.RED, 36)
        ).then(function (canvas) {
          return mapImageArr.push(viewer.entities.add({
            id: "im" + item.imageId,
            position: new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM
            },
            label: {
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: 'bold 36px Helvetica',
              scale: 0.5,
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              outlineColor: Cesium.Color.RED,
              outlineWidth: 8,
              fillColor: Cesium.Color.WHITE,
              text: item.imageTime,
              pixelOffset: new Cesium.Cartesian2(0.0, -60.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            }
          }))
        });
      });
    },
    closeMapImage() {
      this.dialogPanorama = false;
      mapImageArr.map(item => {
        viewer.entities.remove(item);
      });
      mapImageArr = [];
    },
    showImage(id) {
      _this.dialogPanorama = true;
      let mapImageArr = _this.queryResult;
      let params = {
        imagePid: id
      };
      getMapImageByPid(params).then(res => {
        for (let i = 0; i < mapImageArr.length; i++) {
          if (mapImageArr[i].imageId === id) {
            _this.mapPhotosTitle = mapImageArr[i].imageName;
            _this.curTime = mapImageArr[i].imageTime;
            _this.curImgSrc = mapImageArr[i].imageName + mapImageArr[i].imageId + mapImageArr[i].imageName.substring(mapImageArr[i].imageName.indexOf('.'));
            res.data.map(item => {
              switch (item.imageType) {
                case '清理前':
                  _this.curImgSrc1 = item.imageName + item.imageId + item.imageName.substring(item.imageName.indexOf('.'));
                  break;
                case '清理中':
                  _this.curImgSrc2 = item.imageName + item.imageId + item.imageName.substring(item.imageName.indexOf('.'));
                  break;
                case '清理后':
                  _this.curImgSrc3 = item.imageName + item.imageId + item.imageName.substring(item.imageName.indexOf('.'));
                  break;
                case '误判':
                  _this.curImgSrc4 = item.imageName + item.imageId + item.imageName.substring(item.imageName.indexOf('.'));
                  break;
                default:
                  break;
              }
            });
            break;
          }
        }
      });
    },
    closeImageViewer() {
      this.dialogPanorama = false;
      this.curTime = "";
      this.curImgSrc = "";
      this.curImgSrc1 = "";
      this.curImgSrc2 = "";
      this.curImgSrc3 = "";
      this.curImgSrc4 = "";
    }
  },
  mounted() {
    this.getMapImageData();
    _this = this;
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  color: #ffffff;
}

.deal-time {
  font-size: 16px;
  font-weight: bold;
  font-family: Helvetica;
  color: #ffffff;
  text-align: center;
  width: 58%;
  margin-bottom: 10px;
}

.deal-box {
  width: 40%;
  float: right;
}

.deal-box-con {
  float: left;
  width: 50%
}

.deal-title {
  width: 95%;
  font-size: 16px;
  font-weight: bold;
  font-family: Helvetica;
  color: #ffffff;
  text-align: center;
  padding: 5px 0;
  border: solid 2px #0088ff;
  border-radius: 5px;
  background-color: #ffffff22;
}

.deal-img {
  margin-top: 10px;
  width: 95%
}

.color1 {
  border-color: #ff3e00
}

.color2 {
  border-color: #ffe820
}

.color3 {
  border-color: #4bff65
}

.color4 {
  border-color: #ec63ff
}
</style>
