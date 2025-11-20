<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width:leftWidth,height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                    class="search-input"></el-input>
          <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                     @click="addData('formData')">
            添 加
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        </div>
        <div v-show="!isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
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
                  :default-sort="{prop: 'layerType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="图层名称" prop="layerName" sortable width="260px"></el-table-column>
          <el-table-column label="图层类型" prop="layerType" sortable></el-table-column>
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
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
          <el-form-item label="图层名称" prop="layerName">
            <el-input v-model="formData.layerName" placeholder="请填写专题数据图层名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="图层格式" prop="layerType">
            <el-select v-model="formData.layerType" placeholder="请选择图层格式">
              <el-option label="TMS瓦片" value="瓦片"></el-option>
              <el-option label="Cesiumlab" value="cesiumlab"></el-option>
              <el-option label="ArcGIS" value="arcgis"></el-option>
              <el-option label="shp" value="shp"></el-option>
              <el-option label="kml" value="kml"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="透明度" prop="layerPid">
            <el-input v-model="formData.layerPid" placeholder="图层透明度为0-1之间小数，0为完全透明"
                      style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="路径" prop="layerPath">
            <el-input v-model="formData.layerPath" placeholder="请填写访问地址，瓦片服务以文件夹终止"
                      style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width
                               @click="layerPreview"></font-awesome-icon>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width:rightWidth,height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
import {
  deleteDatalayer,
  getDatalayer,
  insertDatalayer,
  updateDatalayer
} from "../api/api";
import CesiumMap from "../utils/components/cesium-map";
import VectorTileImageryProvider from "CesiumVectorTile";

let imageryArr = [];
let kmllayerArr = [];
export default {
  name: "map-layer",
  components: {CesiumMap},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      devFilter: '',
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      rules: {
        layerName: [{required: true, message: '请输入', trigger: 'blur'}],
        layerType: [{required: true, message: '请输入', trigger: 'blur'}],
        layerPid: [{required: true, message: '请输入', trigger: 'blur'}],
        layerPath: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        layerId: '',
        layerName: '',
        layerType: '',
        layerPid: '1',
        layerPath: '',
      }
    }
  },
  methods: {
    layerPreview() {
      this.clearDataLayer();
      this.addDataLayer(this.formData.layerType, this.formData.layerPath, this.formData.layerPid);
    },
    addDataLayer(layerType, layerPath, layeralpha) {
      this.clearDataLayer();
      if (layerType === '瓦片') {
        let layerProvider = new Cesium.TileMapServiceImageryProvider({
          url: Cesium.buildModuleUrl(serverIp + layerPath)
        });
        let imageryLayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(layeralpha)});
        viewer.imageryLayers.add(imageryLayer);
        imageryArr.push(imageryLayer);
      } else if (layerType === "arcgis") {
        let arcgislayerProvider = new Cesium.ArcGisMapServerImageryProvider({
          url: Cesium.buildModuleUrl(layerPath)
        });
        let datalayer = new Cesium.ImageryLayer(arcgislayerProvider, {alpha: Number(layeralpha)});
        viewer.imageryLayers.add(datalayer);
        imageryArr.push(datalayer);
      } else if (layerType === "cesiumlab") {
        //加载cesiumlab切图的方法，但是与下载的数据不兼容
        let layerProvider = new Cesium.UrlTemplateImageryProvider({
          url: Cesium.buildModuleUrl(serverIp + layerPath) + '/{z}/{x}/{y}.png',
          minimumLevel: 1,
        });
        let datalayer = new Cesium.ImageryLayer(layerProvider, {alpha: Number(layeralpha)});
        viewer.imageryLayers.add(datalayer);
        imageryArr.push(datalayer);
      } else if (layerType === "shp") {
        //加载shp
        let vectorLayer = new VectorTileImageryProvider({
          source: Cesium.buildModuleUrl(serverIp + layerPath),
          defaultStyle: {
            outlineColor: "rgb(255,255,255)",
            lineWidth: 2,
            fill: false,
            tileCacheSize: 200
          },
          maximumLevel: 20,
          minimumLevel: 1
        });
        let datalayer = new Cesium.ImageryLayer(vectorLayer, {alpha: Number(layeralpha)});
        viewer.imageryLayers.add(datalayer);
        imageryArr.push(datalayer);
      } else {
        let kmllayer = Cesium.KmlDataSource.load(serverIp + layerPath, {clampToGround: true});
        kmllayer.then(function (dataSource) {
          viewer.dataSources.add(dataSource);
          kmllayerArr.push(dataSource);
        });
      }
    },
    clearDataLayer() {
      for (let i = 0; i < imageryArr.length; i++) {
        viewer.imageryLayers.remove(imageryArr[i]);
      }
      for (let i = 0; i < kmllayerArr.length; i++) {
        viewer.dataSources.remove(kmllayerArr[i], true);
      }
      imageryArr = [];
      kmllayerArr = [];
    },
    getDatalayerData() {
      this.pictLoading = true;
      getDatalayer().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.layerId;
      this.currentRow = row;
      this.addDataLayer(row.layerType, row.layerPath, row.layerPid);
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    addData(formName) {
      this.isTableShow = false;
      this.isEdit = false;
      this.$refs[formName].resetFields();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
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
          let params = {
            layerId: this.currentId
          };
          deleteDatalayer(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getDatalayerData();
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
    multideleteData() {
      this.$message({
        message: '待完善，批量删除！',
        type: 'error'
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateDatalayer(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getDatalayerData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '修改失败，请重试！'
                  })
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '请完善信息！'
              });
            });
          } else {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              insertDatalayer(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getDatalayerData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '新增失败，请重试！'
                  })
                }
              });
            }).catch(action => {
              this.$message({
                type: 'warning',
                message: '请完善信息！'
              });
            });
          }
        } else {
          this.$message({
            message: '请完善信息！',
            type: 'error'
          });
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.clearDataLayer();
    },
    backTable() {
      this.isTableShow = true;
      this.clearDataLayer();
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.layerName.indexOf(val)
          || ~item.layerType.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getDatalayerData();
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

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
