<template>
  <el-card>
    <div slot="header" class="card-header">
      <div v-show="isTableShow">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline" @click="addData('formData')">
          添 加
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
      </div>
      <div v-show="!isTableShow">
        <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">确
          定
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">重
          置
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
      </div>
    </div>
    <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
      <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                @selection-change="handleSelectionChange" ref="multipleTable" row-key="netManId"
                :default-sort="{prop: 'name', order: 'ascending'}" @row-click="rowClick">
        <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
        <el-table-column label="照片" prop="imgurl" sortable>
          <template slot-scope="scope">
            <el-image class="table-logo" :src="imgSrc+scope.row.imgurl" :preview-src-list="[imgSrc+scope.row.imgurl]"/>
          </template>
        </el-table-column>
        <el-table-column label="姓名" prop="name" sortable></el-table-column>
        <el-table-column label="类型" prop="type" sortable></el-table-column>
        <el-table-column label="职务" prop="post" sortable></el-table-column>
        <el-table-column label="职责" prop="duty" sortable></el-table-column>
        <el-table-column label="电话" prop="tel" sortable></el-table-column>
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
      <el-form ref="formData" :model="formData" :rules="rules" label-width="90px" class="my-form">
        <el-form-item label="照片" prop="imgurl">
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
        <el-form-item label="姓名" prop="name">
          <el-input v-model="formData.name" placeholder="请填写真实姓名" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="formData.type" placeholder="请选择类型">
            <el-option label="网格长" value="网格长"></el-option>
            <el-option label="民情联络员" value="民情联络员"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职务" prop="post">
          <el-input v-model="formData.post" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="职责" prop="duty">
          <el-input v-model="formData.duty" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="tel">
          <el-input v-model="formData.tel" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="党员信息" prop="party">
          <el-input v-model="formData.party" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="入职时间" prop="jobTime">
          <el-input v-model="formData.jobTime" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="formData.note" placeholder="请填写" style="width:90%"></el-input>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
import {deleteNetMan, getNetMan, insertNetMan, updateNetMan, batchDeleteNetMan} from "../api/api";

export default {
  name: "net-man",
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
      multipleSelection: [],
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileList: [],
      imagePreview: '',
      rules: {
        name: [{required: true, message: '请输入', trigger: 'blur'}],
        type: [{required: true, message: '请输入', trigger: 'blur'}],
        post: [{required: true, message: '请输入', trigger: 'blur'}],
        duty: [{required: true, message: '请输入', trigger: 'blur'}],
        tel: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        netManId: '',
        imgurl: '',
        name: '',
        post: '',
        duty: '',
        tel: '',
        party: '',
        jobTime: '',
        note: '',
        type: '',
      },
      imgSrc: common.serverIp + "city3dfile/"
    }
  },
  methods: {
    getNetManData() {
      this.pictLoading = true;
      getNetMan().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.netManId;
      this.currentRow = row;
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
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.imgurl;
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
            netManId: this.currentId,
            imgurl: this.currentRow.imgurl
          };
          deleteNetMan(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getNetManData();
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
          batchDeleteNetMan(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getNetManData();
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
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let params = this.formData;
          let formData = new FormData();
          this.fileList.map(item => {
            formData.append('files', item.raw);
          });
          formData.append('netManId', params.netManId);
          formData.append('imgurl', params.imgurl);
          formData.append('name', params.name);
          formData.append('post', params.post);
          formData.append('duty', params.duty);
          formData.append('tel', params.tel);
          formData.append('party', params.party);
          formData.append('jobTime', params.jobTime);
          formData.append('note', params.note);
          formData.append('type', params.type);
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateNetMan(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getNetManData();
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
              insertNetMan(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getNetManData();
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
        item => (~item.name.indexOf(val)
          || ~item.type.indexOf(val)
          || ~item.post.indexOf(val)
          || ~item.duty.indexOf(val)
          || ~item.tel.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getNetManData();
  },
  computed: {
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
    },
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  font-size: 15px !important;
}

.card-header {
  height: 30px;
}

.header-button {
  margin: -3px 10px 0 0;
  float: left;
  font-size: 15px;
}

.search-input {
  width: 400px;
  float: right;
  margin: -5px 0 0 20px;
}

.my-pagination {
  margin-top: 15px;
}

.my-card-body {
  overflow-y: auto;
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
  width: 60px;
}

.my-form {
  width: 800px;
}
</style>
