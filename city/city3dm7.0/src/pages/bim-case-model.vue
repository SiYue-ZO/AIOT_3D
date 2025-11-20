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
                  :default-sort="{prop: 'modelDep', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="缩略图" prop="modelImg" sortable>
            <template slot-scope="scope">
              <el-image class="table-logo" :src="logoSrc+scope.row.modelImg"
                        :preview-src-list="[logoSrc+scope.row.modelImg]"/>
            </template>
          </el-table-column>
          <el-table-column label="模型名称" prop="modelName" sortable></el-table-column>
          <el-table-column label="申报单位" prop="modelDep" sortable></el-table-column>
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
          <el-form-item label="缩略图" prop="modelImg">
            <div class="row_display avatar-img-row">
              <el-image class="avatar-img" :src="imagePreview" fit="fill"></el-image>
              <el-upload ref="uploadImage"
                         action=""
                         list-type="picture-card"
                         :auto-upload="false"
                         :accept="acceptFileType"
                         :file-list="fileList"
                         :limit="1"
                         :on-change="onChangeUpload"
                         :on-exceed="handleExceed"
                         class="avatar-img-upload">
                <i slot="default" class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                </div>
              </el-upload>
              <el-dialog :visible.sync="dialogVisible">
                <img width="100%" :src="dialogImageUrl" alt="">
              </el-dialog>
            </div>
          </el-form-item>
          <el-form-item label="模型名称" prop="modelName">
            <el-input v-model="formData.modelName" placeholder="请填写三维模型数据名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="模型路径" prop="modelUrl">
            <el-input v-model="formData.modelUrl" placeholder="请填写访问地址，以根节点索引json文件终止"
                      style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width title="点击预览实景三维模型"
                               @click="modelPreview"></font-awesome-icon>
            <div class="form-note">* 本地地址以文件夹开头、远程地址以http开头</div>
          </el-form-item>
          <el-form-item label="申报单位" prop="modelDep">
            <el-input v-model="formData.modelDep" placeholder="请填写三维模型数据名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="模型比例" prop="modelScale">
            <el-input v-model="formData.modelScale" placeholder="请填写三维模型数据名称" style="width: 90%"></el-input>
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
  deleteBimCaseModel,
  getBimCaseModel,
  insertBimCaseModel,
  updateBimCaseModel,
} from "../api/api";

export default {
  name: "bim-case-model",
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
      currentUrl: '',
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileList: [],
      imagePreview: '',
      rules: {
        modelName: [{required: true, message: '请输入', trigger: 'blur'}],
        modelUrl: [{required: true, message: '请输入', trigger: 'blur'}],
        modelScale: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        modelId: '',
        modelImg: '',
        modelUrl: '',
        modelName: '',
        modelDep: '',
        modelScale: '1',
      },
      logoSrc: common.serverIp + "city3dfile/"
    }
  },
  methods: {
    modelPreview() {
      CesiumMap.methods.removeBase3dtiles();
      if (this.formData.modelUrl.length !== 0) {
        let preTile = {
          tilesX: "",
          tilesY: "",
          tilesZ: "",
          tilesUrl: this.formData.modelUrl
        };
        CesiumMap.methods.add3dtilesmap(preTile, "pre");
      } else {
        this.$message({
          message: '链接地址不能为空！',
          type: 'error'
        });
      }
    },
    getBimCaseModelData() {
      this.pictLoading = true;
      getBimCaseModel().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      CesiumMap.methods.remove3dtilesmap(this.currentUrl);
      this.currentId = row.modelId;
      this.currentUrl = row.modelUrl;
      this.currentRow = row;
      let preTile = {
        tilesX: "",
        tilesY: "",
        tilesZ: "",
        tilesUrl: row.modelUrl
      };
      CesiumMap.methods.add3dtilesmap(preTile, "pre");
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    onChangeUpload(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'jpg' && fileName !== 'jpeg' && fileName !== 'png' && fileName !== 'gif' && fileName !== 'bmp'
        && fileName !== 'JPG' && fileName !== 'JPEG' && fileName !== 'PNG' && fileName !== 'GIF' && fileName !== 'BMP') {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是照片文件!'
        });
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        return false;
      }
      this.fileList = fileList;
      return false;
    },
    handleExceed(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleRemove(file) {
      this.$refs.uploadImage.handleRemove(file);
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
        this.imagePreview = this.logoSrc + this.formData.modelImg;
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
            modelId: this.currentId,
            modelImg: this.currentRow.modelImg
          };
          deleteBimCaseModel(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getBimCaseModelData();
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
          let params = this.formData;
          let formData = new FormData();
          this.fileList.map(item => {
            formData.append('files', item.raw);
          });
          formData.append('modelId', params.modelId);
          formData.append('modelImg', params.modelImg);
          formData.append('modelUrl', params.modelUrl);
          formData.append('modelName', params.modelName);
          formData.append('modelDep', params.modelDep);
          formData.append('modelScale', params.modelScale);
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateBimCaseModel(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getBimCaseModelData();
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
              insertBimCaseModel(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getBimCaseModelData();
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
      this.fileList = [];
      this.$refs.uploadImage.clearFiles();
      this.imagePreview = '';
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.modelName.indexOf(val)
          || ~item.modelDep.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getBimCaseModelData();
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

.avatar-img-row {
  width: 90%;
  margin: 0 0 10px 0;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img {
  margin: 5px 10px 5px 10px;
  width: 140px;
  height: 140px;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img-upload {
  margin: 2px 0 3px 10px;
}

.row_display {
  display: flex;
}

.table-logo {
  height: 100px;
  width: 100px;
}
</style>
