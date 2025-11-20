<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header" v-show="isTableShow">
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                   @click="addData()">
          批量导入
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="photoId"
                  :default-sort="{prop: 'photoTime', order: 'descending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="照片预览" prop="photoName">
            <template slot-scope="scope">
              <el-image class="table-photo"
                        :src="photoSrc+scope.row.photoName+scope.row.photoId+scope.row.photoName.substring(scope.row.photoName.indexOf('.'))"
                        :preview-src-list="[photoSrc+scope.row.photoName+scope.row.photoId+scope.row.photoName.substring(scope.row.photoName.indexOf('.'))]"/>
            </template>
          </el-table-column>
          <el-table-column label="拍照时间" prop="photoTime" sortable></el-table-column>
          <el-table-column label="照片名称" prop="photoName" sortable></el-table-column>
        </el-table>
        <el-pagination
          class="my-pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 40]"
          :page-size="pagesize"
          :pager-count="5"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableDate.length">
        </el-pagination>
      </div>
      <div v-show="!isTableShow" slot="header" class="card-header">
        <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm()">
          确 定
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
          重 置
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
      </div>
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table style="position: absolute; z-index: 10; width: 100%; background-color: #ffffff11; top:70px;"
                  :style="{height: viewerHeight}"
                  v-show="uploadPictLoading" v-loading="uploadPictLoading">
        </el-table>
        <div>
          <input id="file-input" class="file-input" type="file" value="" @change="getPhoto" multiple="multiple"
                 accept="image/*"></input>
          <el-image class="img-pre" v-show="isPreImgShow" :src="imgSrc" :preview-src-list="[imgSrc]"></el-image>
          <table class="list-tabel" cellspacing="0">
            <tr v-for="(item,index) in photoArr" :key="index">
              <td>{{ item.photoName }}</td>
              <td>
                <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                                   @click="flyToPhoto(item)"></font-awesome-icon>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
import CesiumMap from "../utils/components/cesium-map";
import {EXIF} from "exif-js";
import {deleteMapPhotos, getMapPhotos, insertMapPhotos, batchDeleteMapPhotos} from "../api/api";

let _this;
let photoPinArr = [];
export default {
  name: "map-photos",
  components: {CesiumMap},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      multipleSelection: [],
      fileList: [],
      rules: {},
      formData: {},
      photoArr: [],
      isPreImgShow: false,
      imgSrc: '',
      photoSrc: common.serverIp + "city3dfile/mapphotos/",
      uploadPictLoading: false,
    }
  },
  methods: {
    getMapPhotosData() {
      this.uploadPictLoading = false;
      this.pictLoading = true;
      getMapPhotos().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      viewer.entities.removeAll();
      this.currentId = row.photoId;
      this.currentRow = row;
      let posArr = row.photoPos.split(',');
      let pinBuilder = new Cesium.PinBuilder();
      Promise.resolve(
        pinBuilder.fromMakiIconId("camera", Cesium.Color.RED, 36)
      ).then(function (canvas) {
        return viewer.entities.add({
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
            text: row.photoName,
            pixelOffset: new Cesium.Cartesian2(0.0, -60.0),
            disableDepthTestDistance: 100000000,
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
          }
        })
      });
      CesiumMap.methods.flyToLocation([posArr[0], posArr[1], Number(posArr[2]) + 2000]);
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    addData() {
      viewer.entities.removeAll();
      this.isTableShow = false;
      this.isEdit = false;
    },
    deleteData() {
      if (this.currentId !== '') {
        this.$confirm('删除后无法恢复，请确认是否删除？', '删除数据', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '取消'
        }).then(() => {
          deleteMapPhotos(this.currentRow).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getMapPhotosData();
            } else {
              this.$message({
                type: 'error',
                message: '删除失败，请重试！'
              });
            }
          });
        }).catch(action => {
          this.$message({
            type: 'warning',
            message: '放弃删除！'
          });
        });
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    batchDeleteData() {
      if (this.multipleSelection !== []) {
        this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
          distinguishCancelAndClose: true,
          confirmButtonText: "确认",
          cancelButtonText: "取消",
        }).then(() => {
          batchDeleteMapPhotos(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getMapPhotosData();
            } else {
              this.$message({
                message: '删除失败，请重试！',
                type: 'error'
              });
            }
          });
        }).catch((action) => {
          this.$message({
            message: '放弃删除！',
            type: 'warning'
          });
        });
      } else {
        this.$message({
          message: '至少选择一条需要删除的数据！',
          type: 'warning'
        });
      }
    },
    submitForm() {
      this.uploadPictLoading = true;
      let formData = new FormData();
      this.photoArr.map(item => {
        for (let i = 0; i < this.fileList.length; i++) {
          if (item.photoName === this.fileList[i].name) {
            formData.append('files', this.fileList[i]);
            break;
          }
        }
        formData.append('photoName', item.photoName);
        formData.append('photoPos', item.photoPos);
        formData.append('photoTime', item.photoTime);
      });
      insertMapPhotos(formData).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '新增成功，返回列表！'
          });
          this.backTable();
          this.getMapPhotosData();
        } else {
          this.$message({
            type: 'error',
            message: '新增失败，请重试！'
          });
        }
      });
    },
    resetForm() {
      viewer.entities.removeAll();
      this.photoArr = [];
    },
    backTable() {
      this.isTableShow = true;
      this.resetForm();
    },
    getPhoto(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList = files;
      for (let i = 0; i < files.length; i++) {
        let file = files[i];
        EXIF.getData(file, function () {
          let tagLon = EXIF.getTag(this, 'GPSLongitude');
          if (tagLon !== undefined) {
            let tagLat = EXIF.getTag(this, 'GPSLatitude');
            let tagAlt = EXIF.getTag(this, 'GPSAltitude');
            let photoTime = EXIF.getTag(this, 'DateTimeOriginal');
            let lon = tagLon[0].numerator / tagLon[0].denominator +
              tagLon[1].numerator / tagLon[1].denominator / 60 +
              tagLon[2].numerator / tagLon[2].denominator / 3600;
            let lat = tagLat[0].numerator / tagLat[0].denominator +
              tagLat[1].numerator / tagLat[1].denominator / 60 +
              tagLat[2].numerator / tagLat[2].denominator / 3600;
            let alt = tagAlt.numerator / tagAlt.denominator;
            let pos = lon + ',' + lat + ',' + alt;
            let pinBuilder = new Cesium.PinBuilder();
            photoPinArr.push(
              Promise.resolve(
                pinBuilder.fromMakiIconId("camera", Cesium.Color.RED, 36)
              ).then(function (canvas) {
                return viewer.entities.add({
                  position: new Cesium.Cartesian3.fromDegrees(lon, lat, alt),
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
                    text: file.name,
                    pixelOffset: new Cesium.Cartesian2(0.0, -60.0),
                    disableDepthTestDistance: 100000000,
                    scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                  }
                })
              })
            );
            let reads = new FileReader();
            reads.readAsDataURL(file);
            reads.onload = function (e) {
              _this.photoArr.push({
                photoName: file.name, photoPos: pos, photoUrl: this.result, photoTime: photoTime
              });
            };
          } else {
            _this.$message({
              type: 'error',
              message: '未获取到' + file.name + '的GPS信息！'
            });
          }
        });
      }
    },
    flyToPhoto(photo) {
      this.imgSrc = photo.photoUrl;
      this.isPreImgShow = true;
      let posArr = photo.photoPos.split(',');
      posArr[2] = Number(posArr[2]) + 500;
      CesiumMap.methods.flyToLocation(posArr);
    },
  },
  mounted() {
    this.getMapPhotosData();
    _this = this;
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.4) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 230) * 0.6) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
    },
  }
}
</script>

<style scoped>
.left-card {
  float: left;
}

.right-card {
  float: right;
}

.form-fai {
  font-size: 19px !important;
  cursor: pointer;
  margin: 0 0 0 8px;
  color: #007acc;
}

.result-table {
  width: 100%;
  font-size: 15px !important;
}

.my-card-body {
  overflow-y: auto;
}

.list-tabel {
  width: 99%;
  min-height: 50px;
  margin-top: 10px;
  color: #007acc;
  border: solid 1px #007acc;
  border-radius: 5px;
  padding: 8px 10px;
  font-size: 14px;
}

.list-tabel td {
  padding: 2px 10px;
  cursor: pointer;
  height: 32px;
}

.list-tabel tr:nth-child(odd) {
  background: rgba(244, 247, 253, 0.94);
}

.list-tabel tr:nth-child(even) {
  background: rgb(237, 239, 241);
}

.img-pre {
  width: 100%;
}

.file-input {
  width: 97%;
  border: solid 1px #007acc;
  border-radius: 5px;
  padding: 8px 1%;
  color: #007acc;
  cursor: pointer;
  background: #D0EEFF;
  text-decoration: none;
  text-indent: 0;
  overflow: hidden;
}

.file-input:hover {
  background: #AADFFD;
  border-color: #78C3F3;
  color: #004974;
  text-decoration: none;
}

.table-photo {
  width: 150px
}
</style>
