<template>
  <div id="map-photos-is-show">
    <div class="pop-fai pop-fai-follow" @click="getMapPhotosByTime" title="搜索">
      <font-awesome-icon :icon="['fas', 'search']" fixed-width></font-awesome-icon>
    </div>
    <el-date-picker v-model="valueTime" value-format="yyyy:MM:dd HH:mm:ss" type="datetimerange" range-separator="至"
                    size="small" :default-time="['12:00:00', '08:00:00']" style="margin-bottom: 10px"
                    start-placeholder="开始日期" end-placeholder="结束日期">
    </el-date-picker>
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'photoTime', order: 'descending'}" @row-click="rowClick">
      <el-table-column label="拍照时间" prop="photoTime" width="200px" sortable></el-table-column>
      <el-table-column label="照片名称" prop="photoName" width="155px" sortable></el-table-column>
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
      width="100%" top="10px"
      :modal-append-to-body="false"
      destroy-on-close
      :before-close="closePhotoSphereViewer"
    >
      <font-awesome-icon v-show="left_icon_show" class="photo-fai photo-fai-left" :icon="['fas', 'chevron-up']"
                         fixed-width @click="stepPhotoSphereViewer('next')"></font-awesome-icon>
      <font-awesome-icon v-show="right_icon_show" class="photo-fai photo-fai-right" :icon="['fas', 'chevron-down']"
                         fixed-width @click="stepPhotoSphereViewer('pre')"></font-awesome-icon>
      <div id="mapphotoscontainer" style="margin: auto"></div>
    </el-dialog>
  </div>
</template>

<script>
  import {getMapPhotos, getMapPhotosByTime} from "../api/api";
  import map3d from "./map-3d";
  import {Viewer} from 'photo-sphere-viewer';
  import 'photo-sphere-viewer/dist/photo-sphere-viewer.css';

  let mapPhotosArr = [];
  let _this;
  let PSV;
  export default {
    name: "map-photos",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        dialogPanorama: false,
        mapPhotosTitle: "",
        valueTime: "",
        left_icon_show: true,
        right_icon_show: true,
        current_step: 0
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
        let posArr = row.photoPos.split(',');
        map3d.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 2000]);
      },
      getMapPhotosData() {
        this.pictLoading = true;
        getMapPhotos().then(res => {
          this.queryResult = res.data;
          this.pictLoading = false;
          this.showMapPhotosPin(res.data);
        });
      },
      getMapPhotosByTime() {
        this.pictLoading = true;
        if (this.valueTime === null || this.valueTime === "") {
          getMapPhotos().then(res => {
            this.queryResult = res.data;
            this.pictLoading = false;
            this.showMapPhotosPin(res.data);
          });
        } else {
          let params = {
            "photoName": this.valueTime[0],
            "photoTime": this.valueTime[1]
          };
          getMapPhotosByTime(params).then(res => {
            this.queryResult = res.data;
            this.pictLoading = false;
            this.showMapPhotosPin(res.data);
          });
        }
      },
      showMapPhotosPin(data) {
        this.closeMapPhotos();
        let pinBuilder = new Cesium.PinBuilder();
        let url = Cesium.buildModuleUrl("../../../static/images/uav.png");
        let lineposArr = [];
        data.map(item => {
          let posArr = item.photoPos.split(',');
          lineposArr.push(posArr[0], posArr[1], posArr[2]);
          let pinURI = pinBuilder.fromUrl(url, Cesium.Color.RED, 36);
          mapPhotosArr.push(viewer.entities.add({
              id: "mp" + item.photoId,
              position: new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]),
              billboard: {
                image: pinURI,
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
                text: item.photoTime,
                pixelOffset: new Cesium.Cartesian2(0.0, -60.0),
                disableDepthTestDistance: 100000000,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              }
            })
          )
        });
        mapPhotosArr.push(viewer.entities.add({
          polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(lineposArr),
            width: 2,
            material: new Cesium.PolylineOutlineMaterialProperty({
              color: Cesium.Color.RED,
              outlineWidth: 1,
              outlineColor: Cesium.Color.WHITE,
            }),
            classificationType: Cesium.ClassificationType.NONE
          }
        }));
      },
      showMapPhotos(id) {
        let mapPhotos = _this.queryResult;
        _this.dialogPanorama = true;
        setTimeout(() => {
          for (let i = 0; i < mapPhotos.length; i++) {
            if (mapPhotos[i].photoId === id) {
              _this.right_icon_show = i !== 0;
              _this.left_icon_show = i !== mapPhotos.length - 1;
              let posArr = mapPhotos[i].photoPos.split(',');
              _this.mapPhotosTitle = mapPhotos[i].photoName;
              let div = document.getElementById("mapphotoscontainer");
              PSV = new Viewer({
                panorama: common.serverIp + "city3dfile/mapphotos/" + mapPhotos[i].photoName + mapPhotos[i].photoId
                  + mapPhotos[i].photoName.substring(mapPhotos[i].photoName.indexOf('.')),
                container: div,
                navbar: true,
                defaultLong: viewer.camera.heading,
                defaultLat: viewer.camera.pitch,
                size: {
                  height: "900px",
                },
              });
              viewer.camera.setView({
                destination: Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]),
              });
              PSV.on('position-updated', (e, position) => {
                map3d.methods.moveToDegrees(posArr[0], posArr[1], posArr[2], position.longitude, position.latitude);
              });
              _this.current_step = i;
              break;
            }
          }
        }, 500);
      },
      //关闭全景图播放器
      closePhotoSphereViewer() {
        this.dialogPanorama = false;
      },
      closeMapPhotos() {
        this.dialogPanorama = false;
        mapPhotosArr.map(item => {
          viewer.entities.remove(item);
        });
        mapPhotosArr = [];
      },
      //按照拍摄时间顺序，前后切换全景照片
      stepPhotoSphereViewer(step) {
        let mapPhotos = _this.queryResult;
        let next_step = step === "next" ? _this.current_step + 1 : _this.current_step - 1;
        _this.right_icon_show = next_step !== 0;
        _this.left_icon_show = next_step !== mapPhotos.length - 1;
        let posArr = mapPhotos[next_step].photoPos.split(',');
        _this.mapPhotosTitle = mapPhotos[next_step].photoName;
        let panoUrl = common.serverIp + "city3dfile/mapphotos/" + mapPhotos[next_step].photoName + mapPhotos[next_step].photoId
          + mapPhotos[next_step].photoName.substring(mapPhotos[next_step].photoName.indexOf('.'));
        PSV.setPanorama(panoUrl);
        viewer.camera.setView({
          destination: Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]),
        });
        PSV.on('position-updated', (e, position) => {
          map3d.methods.moveToDegrees(posArr[0], posArr[1], posArr[2], position.longitude, position.latitude);
        });
        _this.current_step = next_step;
      }
    },
    mounted() {
      this.getMapPhotosData();
      _this = this;
    }
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

  .pop-fai-follow {
    right: 80px;
  }

  .pop-fai-follow:hover {
    background-color: #21e000;
  }

  .photo-fai {
    color: #efefef;
    font-size: 50px;
    cursor: pointer;
    position: absolute;
    z-index: 100;
  }

  .photo-fai-left {
    top: 90px;
    left: 50%;
    filter: drop-shadow(0 0 5px #000000);
  }

  .photo-fai-right {
    bottom: 70px;
    left: 50%;
    filter: drop-shadow(0 0 5px #000000);
  }
</style>
