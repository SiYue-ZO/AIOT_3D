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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="vehicleId"
                  :default-sort="{prop: 'carType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="牌照" prop="carNo" sortable></el-table-column>
          <el-table-column label="类型" prop="carType" sortable></el-table-column>
          <el-table-column label="品牌型号" prop="carBrand" sortable></el-table-column>
          <el-table-column label="颜色" prop="color" sortable></el-table-column>
          <el-table-column label="唯一识别码" prop="carCode" sortable></el-table-column>
          <el-table-column label="车主" prop="peopleBase.name" sortable></el-table-column>
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
              <el-form-item label="牌照" prop="carNo">
                <el-input v-model="formData.carNo" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="类型" prop="carType" style="margin-left:15px;">
                <el-select v-model="formData.carType" placeholder="请选择" style="width: 93%">
                  <el-option label="轿车" value="轿车"></el-option>
                  <el-option label="客车" value="客车"></el-option>
                  <el-option label="载货汽车" value="载货汽车"></el-option>
                  <el-option label="自卸汽车" value="自卸汽车"></el-option>
                  <el-option label="越野汽车" value="越野汽车"></el-option>
                  <el-option label="牵引汽车及半挂牵引汽车" value="牵引汽车及半挂牵引汽车"></el-option>
                  <el-option label="专用汽车" value="专用汽车"></el-option>
                  <el-option label="其它" value="其它"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="车辆品牌" prop="carBrand">
                <el-input v-model="formData.carBrand" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="颜色" prop="color" style="margin-left:15px;">
                <el-select v-model="formData.color" placeholder="请选择" style="width: 93%">
                  <el-option label="白色" value="白色"></el-option>
                  <el-option label="黑色" value="黑色"></el-option>
                  <el-option label="银色" value="银色"></el-option>
                  <el-option label="银灰色" value="银灰色"></el-option>
                  <el-option label="红色" value="红色"></el-option>
                  <el-option label="金色" value="金色"></el-option>
                  <el-option label="蓝色" value="蓝色"></el-option>
                  <el-option label="其它" value="其它"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="识别码" prop="carCode">
                <el-input v-model="formData.carCode" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="发动机号" prop="engineNo" style="margin-left:15px;">
                <el-input v-model="formData.engineNo" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="注册日期" prop="registerData">
                <el-date-picker v-model="formData.registerData" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="车主" prop="peopleBaseName" v-show="isEdit" style="margin-left: -15px">
                <el-input v-model="peopleBaseName" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="备注" prop="carRemark">
              <el-input type="textarea" v-model="formData.carRemark" placeholder="请填写"
                        :autosize="{minRows: 2, maxRows: 10}" style="width: 70%"></el-input>
            </el-form-item>
            <el-form-item label="车辆照片" prop="carImgUrl">
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
          <div class="right-card-title">车辆所有人</div>
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
    deletePeopleVehicle,
    getPeopleVehicle,
    insertPeopleVehicle,
    queryPeoplebasePart,
    updatePeopleVehicle,
    batchDeleteVehicle
  } from "../api/api";

  export default {
    name: "real-vehicle",
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
          carNo: [{required: true, message: '请输入', trigger: 'blur'}],
          carCode: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          vehicleId: '',
          ppId: '',
          carBrand: '',
          carCode: '',
          carNo: '',
          carType: '',
          color: '',
          engineNo: '',
          carImgUrl: '',
          registerData: '',
          carRemark: '',
        },
        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
      }
    },
    methods: {
      getVehicleData() {
        this.pictLoading = true;
        getPeopleVehicle().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.vehicleId;
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
          this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.carImgUrl;
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
              vehicleId: this.currentId,
              carImgUrl: this.currentRow.carImgUrl
            };
            deletePeopleVehicle(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getVehicleData();
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
            batchDeleteVehicle(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getVehicleData();
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
            params.registerData = new Date(params.registerData).toLocaleDateString().replace(/\//g, '-');
            let formData = new FormData();
            this.fileList.map(item => {
              formData.append('files', item.raw);
            });
            formData.append('vehicleId', params.vehicleId);
            formData.append('ppId', params.ppId);
            formData.append('carBrand', params.carBrand);
            formData.append('carCode', params.carCode);
            formData.append('carNo', params.carNo);
            formData.append('carType', params.carType);
            formData.append('color', params.color);
            formData.append('engineNo', params.engineNo);
            formData.append('carImgUrl', params.carImgUrl);
            formData.append('registerData', params.registerData);
            formData.append('carRemark', params.carRemark);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePeopleVehicle(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getVehicleData();
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
                insertPeopleVehicle(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getVehicleData();
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
          item => (~item.carNo.indexOf(val)
            || ~item.carType.indexOf(val)
            || ~item.carBrand.indexOf(val)
            || ~item.color.indexOf(val)
            || ~item.carCode.indexOf(val)
            || ~item.peopleBase.name.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getVehicleData();
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

  .my-card-body::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .my-card-body::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .my-card-body::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
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
