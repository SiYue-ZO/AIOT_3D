<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                   @click="addData('formData')">
          添 加
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
      </div>
      <div class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="knifeId"
                  :default-sort="{prop: 'knifeType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="类型" prop="knifeType" sortable></el-table-column>
          <el-table-column label="编码" prop="qrCode" sortable></el-table-column>
          <el-table-column label="长度" prop="knifeLenth" sortable></el-table-column>
          <el-table-column label="固定情况" prop="fixedSituation" sortable></el-table-column>
          <el-table-column label="所有人" prop="peopleBase.name" sortable></el-table-column>
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
    </el-card>
    <div v-show="!isTableShow">
      <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
        <div slot="header" class="card-header">
          <div>
            <div slot="header" class="card-header">
              <el-button class="header-button" type="success" icon="el-icon-circle-check"
                         @click="submitForm('formData')">
                确 定
              </el-button>
              <el-button class="header-button" type="warning" icon="el-icon-refresh-right"
                         @click="resetForm('formData')">
                重 置
              </el-button>
              <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回
              </el-button>
            </div>
          </div>
        </div>
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <div class="row_display">
              <el-form-item label="所有人" prop="peopleBaseName" v-show="isEdit" style="width: 73%">
                <el-input v-model="peopleBaseName" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="长度" prop="knifeLenth">
                <el-input v-model="formData.knifeLenth" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="类型" prop="knifeType" style="margin-left:15px;">
                <el-select v-model="formData.knifeType" placeholder="请选择" style="width: 93%">
                  <el-option label="菜刀" value="菜刀"></el-option>
                  <el-option label="水果刀" value="水果刀"></el-option>
                  <el-option label="长水果刀" value="长水果刀"></el-option>
                  <el-option label="匕首" value="匕首"></el-option>
                  <el-option label="装饰刀" value="装饰刀"></el-option>
                  <el-option label="工具刀" value="工具刀"></el-option>
                  <el-option label="折叠刀" value="折叠刀"></el-option>
                  <el-option label="其它" value="其它"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="编码" prop="qrCode">
                <el-input v-model="formData.qrCode" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="固定情况" prop="fixedSituation" style="margin-left:15px;">
                <el-select v-model="formData.fixedSituation" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <el-form-item label="备注" prop="knifeRemark">
              <el-input type="textarea" v-model="formData.knifeRemark" placeholder="请填写"
                        :autosize="{minRows: 2, maxRows: 10}" style="width: 70%"></el-input>
            </el-form-item>
            <el-form-item label="车辆照片" prop="knifeImgUrl">
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
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
        <div class="row_display">
          <div class="right-card-title">刀具所有人</div>
          <el-input class="search-input-pp" placeholder="通过姓名、身份证号检索" v-model="devFilterPP"></el-input>
          <font-awesome-icon class="form-fai-pp" :icon="['fas', 'search']" fixed-width @click="searchPeopleBase"
                             title="开始搜索"></font-awesome-icon>
        </div>
        <div class="my-card-body" :style="{height: treeHeight}">
          <el-table class="result-table"
                    :data="tableDatePP.slice((currentPagePP-1)*pagesizePP,currentPagePP*pagesizePP)"
                    v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                    element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                    :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                    :default-sort="{prop: 'name', order: 'ascending'}" @row-click="rowClickPP">
            <el-table-column label="姓名" prop="name" sortable width="140px"></el-table-column>
            <el-table-column label="住址" prop="address.addName" sortable></el-table-column>
            <el-table-column label="性别" prop="gender" sortable width="80px"></el-table-column>
            <el-table-column label="身份证号" prop="identity" sortable></el-table-column>
            <el-table-column label="类别" prop="peopleType" sortable width="100px"></el-table-column>
          </el-table>
          <el-pagination
            class="my-pagination"
            @size-change="handleSizeChangePP"
            @current-change="handleCurrentChangePP"
            :current-page="currentPagePP"
            :page-sizes="[5, 10, 20, 40]"
            :page-size="pagesizePP"
            :pager-count="5"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableDatePP.length">
          </el-pagination>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import {
    deletePeopleKnife,
    getPeopleKnife,
    insertPeopleKnife,
    queryPeoplebasePart,
    updatePeopleKnife,
    batchDeleteKnife
  } from "../api/api";

  export default {
    name: "real-knife",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        queryResult: [],
        tableDate: [],
        currentPagePP: 1, //初始页
        pagesizePP: 10,   //每页的数据
        tableDatePP: [],
        pictLoading: false,
        devFilter: '',
        devFilterPP: '',
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
        peopleBaseName: "",
        rules: {
          knifeLenth: [{required: true, message: '请输入', trigger: 'blur'}],
          qrCode: [{required: true, message: '请输入', trigger: 'blur'}],
          knifeType: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          knifeId: '',
          ppId: '',
          knifeLenth: '',
          qrCode: '',
          fixedSituation: '',
          knifeImgUrl: '',
          knifeRemark: '',
          knifeType: '',
        },
      }
    },
    methods: {
      getKnifeData() {
        this.pictLoading = true;
        getPeopleKnife().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.knifeId;
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
      rowClickPP(row, column, event) {
        this.formData.ppId = row.ppId;
      },
      handleSizeChangePP: function (size) {
        this.pagesizePP = size;
      },
      handleCurrentChangePP: function (currentPagePP) {
        this.currentPagePP = currentPagePP;
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
        this.peopleBaseName = '';
        this.formData.ppId = '';
      },
      editData() {
        if (this.currentId !== '') {
          this.isTableShow = false;
          this.isEdit = true;
          this.formData = Object.assign(this.formData, this.currentRow);
          this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.knifeImgUrl;
          this.peopleBaseName = this.currentRow.peopleBase.name;
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
              knifeId: this.currentId,
              knifeImgUrl: this.currentRow.knifeImgUrl
            };
            deletePeopleKnife(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getKnifeData();
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
            batchDeleteKnife(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getKnifeData();
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
            formData.append('knifeId', params.knifeId);
            formData.append('ppId', params.ppId);
            formData.append('knifeLenth', params.knifeLenth);
            formData.append('qrCode', params.qrCode);
            formData.append('fixedSituation', params.fixedSituation);
            formData.append('knifeType', params.knifeType);
            formData.append('knifeImgUrl', params.knifeImgUrl);
            formData.append('knifeRemark', params.knifeRemark);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePeopleKnife(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getKnifeData();
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
                  message: '修改失败，请重试！'
                });
              });
            } else {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                insertPeopleKnife(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getKnifeData();
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
                  message: '新增失败，请重试！'
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
        this.tableDatePP = [];
        this.devFilterPP = '';
        this.formData.ppId = '';
        this.peopleBaseName = '';
        this.imagePreview = '';
      },
      searchPeopleBase() {
        this.pictLoading = true;
        let params = {
          'identity': this.devFilterPP,
          'name': this.devFilterPP
        };
        queryPeoplebasePart(params).then(res => {
          this.tableDatePP = res.data;
          this.pictLoading = false;
        });
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.knifeLenth.indexOf(val)
            || ~item.qrCode.indexOf(val)
            || ~item.fixedSituation.indexOf(val)
            || ~item.knifeType.indexOf(val)
            || ~item.peopleBase.name.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getKnifeData();
    },
    computed: {
      viewerHeight: function () {
        return (window.innerHeight - 130) + 'px';
      },
      cardBodyHeight: function () {
        return (window.innerHeight - 130 - 100) + 'px';
      },
      treeHeight: function () {
        return (window.innerHeight - 130 - 20) + 'px';
      },
      leftWidth: function () {
        return ((window.innerWidth - 230) * 0.5) + 'px';
      },
      rightWidth: function () {
        return ((window.innerWidth - 230) * 0.5) + 'px';
      }
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
    overflow-x: hidden;
    font-size: 15px !important;
    margin: 10px 0 0 5px;
  }

  .row_display {
    display: flex;
  }

  .left-card {
    float: left;
  }

  .right-card {
    float: right;
  }

  .avatar-img-row {
    width: 70%;
    margin: 0 0 10px 0;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img {
    margin: 5px 5px 5px 5px;
    width: 400px;
    height: 320px;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img-upload {
    margin: 5px 5px 0 0;
  }

  .search-input-pp {
    width: 300px;
    margin: -5px 0 0 30px;
  }

  .form-fai-pp {
    font-size: 18px !important;
    cursor: pointer;
    color: #007acc;
    margin: 7px 0 0 10px
  }
</style>
