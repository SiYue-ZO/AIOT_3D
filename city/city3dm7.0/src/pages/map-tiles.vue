<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
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
                  :default-sort="{prop: 'tilesName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="名称" prop="tilesName" sortable width="260px"></el-table-column>
          <el-table-column label="连接地址" prop="tilesUrl" sortable></el-table-column>
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
        <el-form ref="formData" :model="formData" :rules="rules" label-width="120px">
          <el-form-item label="名称" prop="tilesName">
            <el-input v-model="formData.tilesName" placeholder="请填写三维模型数据名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="路径" prop="tilesUrl">
            <el-input v-model="formData.tilesUrl" placeholder="请填写访问地址，以根节点索引json文件终止"
                      style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width title="点击预览实景三维模型"
                               @click="tiles3dPreview"></font-awesome-icon>
            <div class="form-note">* 本地地址以文件夹开头、远程地址以http开头</div>
          </el-form-item>
          <el-form-item label="初始显示" prop="tilesType">
            <el-select v-model="formData.tilesType" placeholder="请选择是否初始化显示">
              <el-option label="是" value="cc"></el-option>
              <el-option label="否" value="ff"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="透明影响" prop="tilesTransparent">
            <el-select v-model="formData.tilesTransparent" placeholder="请选择是否受透明和开挖操作影响">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="最大加载瓦片" prop="maxNumLoadedTiles">
            <el-input v-model="formData.maxNumLoadedTiles" placeholder="请填写" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="最大内存使用" prop="maxMemoryUsage">
            <el-input v-model="formData.maxMemoryUsage" placeholder="请填写" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="偏移经度" prop="tilesX">
            <el-input v-model="formData.tilesX" placeholder="请填写偏移量" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="偏移纬度" prop="tilesY">
            <el-input v-model="formData.tilesY" placeholder="请填写偏移量" style="width: 200px"></el-input>
          </el-form-item>
          <el-form-item label="偏移高度" prop="tilesZ">
            <el-input v-model="formData.tilesZ" placeholder="请填写偏移量" style="width: 200px"></el-input>
            <span class="form-note">* 正上负下</span>
          </el-form-item>
          <el-form-item label="相机坐标" prop="camPoi">
            <el-input v-model="formData.camPoi" placeholder="请生成相机坐标" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width title="调整地图视角，点击生成"
                               @click="gettiles3dCam"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="朝向" prop="camHeading">
            <el-input v-model="formData.camHeading" placeholder="请生成相机朝向" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="俯角" prop="camPitch">
            <el-input v-model="formData.camPitch" placeholder="请生成相机俯角" style="width: 90%"></el-input>
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
import {
  deleteTiles3D, getAllandTiles3dById,
  getTiles3D,
  insertTiles3D,
  updateTiles3D
} from "../api/api";
import CesiumMap from "../utils/components/cesium-map";

export default {
  name: "map-tiles",
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
        tilesName: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesUrl: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesType: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesTransparent: [{required: true, message: '请输入', trigger: 'blur'}],
        maxNumLoadedTiles: [{required: true, message: '请输入', trigger: 'blur'}],
        maxMemoryUsage: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesX: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesY: [{required: true, message: '请输入', trigger: 'blur'}],
        tilesZ: [{required: true, message: '请输入', trigger: 'blur'}],
        camPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        camHeading: [{required: true, message: '请输入', trigger: 'blur'}],
        camPitch: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        tilesId: '',
        tilesName: '',
        tilesUrl: '',
        tilesType: '',
        tilesTransparent: '',
        maxNumLoadedTiles: '500',
        maxMemoryUsage: '128',
        tilesX: '0',
        tilesY: '0',
        tilesZ: '0',
        camPoi: '',
        camHeading: '',
        camPitch: '',
      }
    }
  },
  methods: {
    tiles3dPreview() {
      CesiumMap.methods.removeBase3dtiles();
      if (this.formData.tilesUrl.length !== 0 && this.formData.tilesX.length !== 0 &&
        this.formData.tilesY.length !== 0 && this.formData.tilesZ.length !== 0) {
        CesiumMap.methods.add3dtilesmap(this.formData, "pre");
      } else {
        this.$message({
          message: '地址和偏移量不能为空！',
          type: 'error'
        });
      }
    },
    gettiles3dCam() {
      let camPoiR = viewer.camera.position;
      let camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
      let camHeading = viewer.camera.heading;
      let camPitch = viewer.camera.pitch;
      this.formData.camPoi = camPoi;
      this.formData.camHeading = camHeading;
      this.formData.camPitch = camPitch;
    },
    setviewtotiles(camPoi, camHeading, camPitch) {
      let camPoiArr = camPoi.split(',');
      viewer.camera.setView({
        destination: Cesium.Cartesian3.fromElements(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2])),
        orientation: {
          heading: Number(camHeading),
          pitch: Number(camPitch),
          roll: 0.0
        }
      });
    },
    getTiles3DData() {
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getTiles3D().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandTiles3dById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleTiles3d.map(item => {
            resultArr.push(item.tiles3d);
          });
          this.queryResult = resultArr;
          this.tableDate = resultArr;
          this.pictLoading = false;
        });
      }
    },
    rowClick(row, column, event) {
      this.currentId = row.tilesId;
      this.currentRow = row;
      this.setviewtotiles(row.camPoi, row.camHeading, row.camPitch);
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
            tilesId: this.currentId
          };
          deleteTiles3D(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getTiles3DData();
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
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let params = {
            "tiles3d": this.formData,
            "sysRoleTiles3d": {
              "roleId": localStorage.getItem("roleId"),
            }
          };
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateTiles3D(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getTiles3DData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '修改失败，请重试！'
                  });
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
              insertTiles3D(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getTiles3DData();
                } else {
                  this.$message({
                    type: 'error',
                    message: '新增失败，请重试！'
                  });
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
    },
    backTable() {
      this.isTableShow = true;
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.tilesName.indexOf(val)
          || ~item.tilesUrl.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getTiles3DData();
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

.form-note {
  margin: 5px 0 0 10px
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}
</style>
