<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                     @click="addData()">
            批量导入
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
          <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
          </el-button>
        </div>
        <div v-show="!isTableShow">
          <el-button v-show="!isEdit" class="header-button" type="success" icon="el-icon-circle-check"
                     @click="submitForm()">
            确 定
          </el-button>
          <el-button v-show="isEdit" class="header-button" type="success" icon="el-icon-circle-check"
                     @click="submitDeal()">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="imageId"
                  :default-sort="{prop: 'imageTime', order: 'descending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="照片预览" prop="imageName">
            <template slot-scope="scope">
              <el-image class="table-photo"
                        :src="photoSrc+scope.row.imageName+scope.row.imageId+scope.row.imageName.substring(scope.row.imageName.indexOf('.'))"
                        :preview-src-list="[photoSrc+scope.row.imageName+scope.row.imageId+scope.row.imageName.substring(scope.row.imageName.indexOf('.'))]"/>
            </template>
          </el-table-column>
          <el-table-column label="拍照时间" prop="imageTime" sortable></el-table-column>
          <el-table-column label="照片名称" prop="imageName" sortable></el-table-column>
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
      <div v-show="!isTableShow&&!isEdit" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formDataBatch" label-width="90px">
          <el-form-item label="上传图片" prop="layerName">
            <input id="file-input" class="file-input" type="file" value="" @change="getPhoto" multiple="multiple"
                   accept="image/*"></input>
          </el-form-item>
          <el-form-item label="上传csv" prop="layerType">
            <input id="csv-input" class="file-input" type="file" value="" @change="httpRequest" accept=".csv"></input>
          </el-form-item>
          <el-image class="img-pre" v-show="isPreImgShow" :src="imgSrc" :preview-src-list="[imgSrc]"></el-image>
          <table class="list-tabel" cellspacing="0">
            <tr v-for="(item,index) in photoArr" :key="index">
              <td>{{ item.imageName }}</td>
              <td>
                <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                                   @click="flyToPhoto(item)"></font-awesome-icon>
              </td>
            </tr>
          </table>
        </el-form>
      </div>
      <div v-show="!isTableShow&&isEdit" class="my-card-body" :style="{height: cardBodyHeight}"
           style="text-align: center">
        <el-image class="img-pre" :src="curImgSrc" :preview-src-list="[curImgSrc]"></el-image>
        <el-form ref="formData" :model="formData" label-width="90px">
          <div class="row_display">
            <el-form-item label="图片名称" prop="imageName">
              <el-input v-model="formData.imageName" placeholder="请填写" readonly></el-input>
            </el-form-item>
            <el-form-item label="拍照时间" prop="imageTime">
              <el-input v-model="formData.imageTime" placeholder="请填写" readonly></el-input>
            </el-form-item>
          </div>
          <el-form-item label="清理前" prop="deal1">
            <input class="file-input file-input-deal" type="file" value="" @change="getDeal1" accept="image/*"></input>
            <el-image class="img-pre-deal" :src="curImgSrc1" :preview-src-list="[curImgSrc1]"></el-image>
          </el-form-item>
          <el-form-item label="清理中" prop="deal2">
            <input class="file-input file-input-deal" type="file" value="" @change="getDeal2" accept="image/*"></input>
            <el-image class="img-pre-deal" :src="curImgSrc2" :preview-src-list="[curImgSrc2]"></el-image>
          </el-form-item>
          <el-form-item label="清理后" prop="deal3">
            <input class="file-input file-input-deal" type="file" value="" @change="getDeal3" accept="image/*"></input>
            <el-image class="img-pre-deal" :src="curImgSrc3" :preview-src-list="[curImgSrc3]"></el-image>
          </el-form-item>
          <el-form-item label="误判" prop="deal4">
            <input class="file-input file-input-deal" type="file" value="" @change="getDeal4" accept="image/*"></input>
            <el-image class="img-pre-deal" :src="curImgSrc4" :preview-src-list="[curImgSrc4]"></el-image>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
import CesiumMap from "../utils/components/cesium-map";
import {
  batchDeleteMapImage,
  deleteMapImage,
  getMapImage,
  insertMapImage,
  getMapImageByPid,
  deleteImage
} from "../api/api";
import * as jschardet from "jschardet";
import * as Papa from "papaparse";

let _this;
let photoPinArr = [];
export default {
  name: "map-image",
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
      photoSrc: common.serverIp + "city3dfile/mapimage/",
      curImgSrc: '',
      curImgSrc1: '',
      curImgSrc2: '',
      curImgSrc3: '',
      curImgSrc4: '',
      imageDealArr: [],
      editDealIds: []
    }
  },
  methods: {
    getMapImageData() {
      this.pictLoading = true;
      getMapImage().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      viewer.entities.removeAll();
      this.currentId = row.imageId;
      this.currentRow = row;
      let posArr = row.imagePos.split(',');
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
            text: row.imageName,
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
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.curImgSrc = this.photoSrc + this.currentRow.imageName + this.currentRow.imageId + this.currentRow.imageName.substring(this.currentRow.imageName.indexOf('.'));
        let params = {
          imagePid: this.currentId
        };
        getMapImageByPid(params).then(res => {
          this.imageDealArr = res.data;
          res.data.map(item => {
            let fileUrl = item.imageName + item.imageId + item.imageName.substring(item.imageName.indexOf('.'));
            switch (item.imageType) {
              case '清理前':
                this.curImgSrc1 = this.photoSrc + fileUrl;
                break;
              case '清理中':
                this.curImgSrc2 = this.photoSrc + fileUrl;
                break;
              case '清理后':
                this.curImgSrc3 = this.photoSrc + fileUrl;
                break;
              case '误判':
                this.curImgSrc4 = this.photoSrc + fileUrl;
                break;
              default:
                break;
            }
          });
        });
      } else {
        this.$message({
          message: '请选择需要操作的行！',
          type: 'warning'
        });
      }
    },
    deleteData() {
      if (this.currentId !== '') {
        this.$confirm('删除后无法恢复，请确认是否删除？', '删除数据', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '取消'
        }).then(() => {
          deleteMapImage(this.currentRow).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getMapImageData();
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
          batchDeleteMapImage(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getMapImageData();
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
      this.photoArr.map((item, index) => {
        let formData = new FormData();
        formData.append('files', this.fileList[index]);
        formData.append('imageName', item.imageName);
        formData.append('imagePos', item.imagePos);
        formData.append('imageTime', item.imageTime);
        formData.append('imagePid', "0");
        formData.append('imageType', "");
        insertMapImage(formData).then(res => {
          if (res.data === 1) {
            this.$message({
              type: 'success',
              message: '新增成功，返回列表！'
            });
            this.backTable();
            this.getMapImageData();
          } else {
            this.$message({
              type: 'error',
              message: '新增失败，请重试！'
            });
          }
        });
      });
    },
    resetForm() {
      viewer.entities.removeAll();
      this.photoArr = [];
      this.fileList = [];
      this.imgSrc = "";
      this.curImgSrc1 = "";
      this.curImgSrc2 = "";
      this.curImgSrc3 = "";
      this.curImgSrc4 = "";
      this.editDealIds = [];
    },
    backTable() {
      this.isTableShow = true;
      this.resetForm();
    },
    getPhoto(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList = files;
    },
    httpRequest(e) {
      if (this.fileList.length === 0) {
        this.$message.error("请先导入图片");
        return;
      }
      let files = e.target.files || e.dataTransfer.files;
      let fReader = new FileReader();
      fReader.readAsDataURL(files[0]);
      fReader.onload = evt => {
        // 检查编码
        let encoding = this.checkEncoding(evt.target.result);
        // 将csv转换成二维数组
        Papa.parse(files[0], {
          encoding,
          complete: res => {
            // UTF8 \r\n与\n混用时有可能会出问题
            let data = res.data;
            if (data[data.length - 1][0] === "") {
              //去除最后的空行
              data.pop();
            }
            if (this.fileList.length !== data.length - 1) {
              this.$message.error("照片数量与点位数据不符！");
              return;
            }
            for (let i = 1; i < data.length; i++) {
              let pinBuilder = new Cesium.PinBuilder();
              photoPinArr.push(
                Promise.resolve(
                  pinBuilder.fromMakiIconId("camera", Cesium.Color.RED, 36)
                ).then(function (canvas) {
                  return viewer.entities.add({
                    position: new Cesium.Cartesian3.fromDegrees(data[i][3], data[i][2], data[i][4]),
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
                      text: data[i][1],
                      pixelOffset: new Cesium.Cartesian2(0.0, -60.0),
                      disableDepthTestDistance: 100000000,
                      scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                      pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                    }
                  })
                })
              );
              let pos = data[i][3] + ',' + data[i][2] + ',' + data[i][4];
              let reads = new FileReader();
              reads.readAsDataURL(this.fileList[i - 1]);
              reads.onload = function (e) {
                _this.photoArr.push({
                  imageName: _this.fileList[i - 1].name, imagePos: pos, photoUrl: this.result, imageTime: data[i][5]
                });
              };
            }
            this.$message.success("照片与点位数量匹配成功，可以提交！");
            CesiumMap.methods.flyToLocation([data[1][3], data[1][2], Number(data[1][4]) + 1000]);
          }
        });
      };
    },
    // 检查编码，引用了 jschardet
    checkEncoding(base64Str) {
      // 这种方式得到的是一种二进制串
      let str = atob(base64Str.split(";base64,")[1]);
      // 要用二进制格式
      let encoding = jschardet.detect(str);
      encoding = encoding.encoding;
      if (encoding === "windows-1252") {
        // 有时会识别错误（如UTF8的中文二字）
        encoding = "ANSI";
      }
      return encoding;
    },
    flyToPhoto(photo) {
      this.imgSrc = photo.photoUrl;
      this.isPreImgShow = true;
      let posArr = photo.imagePos.split(',');
      posArr[2] = Number(posArr[2]) + 500;
      CesiumMap.methods.flyToLocation(posArr);
    },
    getDeal1(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList.push([files[0], "清理前"]);
      let reads = new FileReader();
      reads.readAsDataURL(files[0]);
      reads.onload = function (e) {
        _this.editDealIds.push("清理前");
        _this.curImgSrc1 = this.result;
      };
    },
    getDeal2(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList.push([files[0], "清理中"]);
      let reads = new FileReader();
      reads.readAsDataURL(files[0]);
      reads.onload = function (e) {
        _this.editDealIds.push("清理中");
        _this.curImgSrc2 = this.result;
      };
    },
    getDeal3(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList.push([files[0], "清理后"]);
      let reads = new FileReader();
      reads.readAsDataURL(files[0]);
      reads.onload = function (e) {
        _this.editDealIds.push("清理后");
        _this.curImgSrc3 = this.result;
      };
    },
    getDeal4(e) {
      let files = e.target.files || e.dataTransfer.files;
      this.fileList.push([files[0], "误判"]);
      let reads = new FileReader();
      reads.readAsDataURL(files[0]);
      reads.onload = function (e) {
        _this.editDealIds.push("误判");
        _this.curImgSrc4 = this.result;
      };
    },
    doDeleteImage(type) {
      for (let i = 0; i < this.imageDealArr.length; i++) {
        if (this.imageDealArr[i].imageType === type) {
          deleteImage(this.imageDealArr[i]).then(res => {
            this.$message.success("替换成功！");
          });
          break;
        }
      }
    },
    submitDeal() {
      this.editDealIds.map(item => {
        this.doDeleteImage(item);
      });
      this.fileList.map(item => {
        let formData = new FormData();
        formData.append('files', item[0]);
        formData.append('imageName', item[0].name);
        formData.append('imageType', item[1]);
        formData.append('imagePos', "");
        formData.append('imageTime', "");
        formData.append('imagePid', this.currentId);
        insertMapImage(formData).then(res => {
          if (res.data === 1) {
            this.$message({
              type: 'success',
              message: '上传成功，返回列表！'
            });
            this.backTable();
            this.getMapImageData();
          } else {
            this.$message({
              type: 'error',
              message: '上传失败，请重试！'
            });
          }
        });
      });
    }
  },
  mounted() {
    this.getMapImageData();
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
  width: 70%;
  margin: 0 auto 15px;
}

.img-pre-deal {
  width: 40%;
}

.file-input {
  width: 92%;
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

.file-input-deal {
  width: 30%;

}
</style>
