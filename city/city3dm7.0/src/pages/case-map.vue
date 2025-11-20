<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
      </div>
      <div class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'caseDate', order: 'descending'}" @row-click="rowClick">
          <el-table-column label="案件名称" prop="caseName" sortable></el-table-column>
          <el-table-column label="案件性质" prop="caseType" sortable></el-table-column>
          <el-table-column label="案发地址" prop="caseAddr" sortable></el-table-column>
          <el-table-column label="案发时间" prop="caseDate" sortable></el-table-column>
          <el-table-column label="案发来源" prop="caseSource" sortable></el-table-column>
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
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item label="案件名称" prop="caseName" style="width: 73%">
              <el-input v-model="formData.caseName" placeholder="请填写人员姓名"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="案件来源" prop="caseSource">
                <el-select v-model="formData.caseSource" placeholder="请选择" style="width: 93%">
                  <el-option label="110" value="110"></el-option>
                  <el-option label="119" value="119"></el-option>
                  <el-option label="122" value="122"></el-option>
                  <el-option label="智能报警" value="智能报警"></el-option>
                  <el-option label="一键报警器" value="一键报警器"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="案件性质" prop="caseType">
                <el-select v-model="formData.caseType" placeholder="请选择" style="width: 93%">
                  <el-option label="治安" value="治安"></el-option>
                  <el-option label="刑事" value="刑事"></el-option>
                  <el-option label="交通" value="交通"></el-option>
                  <el-option label="火警" value="火警"></el-option>
                  <el-option label="求助" value="求助"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="案发地址" prop="caseAddr">
                <el-input v-model="formData.caseAddr" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="案发时间" prop="caseDate" style="margin-left:15px;">
                <el-date-picker v-model="formData.caseDate" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="受害人" prop="victim">
                <el-input v-model="formData.victim" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="嫌疑犯" prop="suspect" style="margin-left:15px;">
                <el-input v-model="formData.suspect" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="案件简介" prop="caseDescribe" style="width: 73%">
              <el-input v-model="formData.caseDescribe" placeholder="请填写" type="textarea"
                        :autosize="{minRows: 3, maxRows: 10}"></el-input>
            </el-form-item>
            <el-form-item label="处理结果" prop="caseResult" style="width: 73%">
              <el-input v-model="formData.caseResult" placeholder="请填写" type="textarea"
                        :autosize="{minRows: 3, maxRows: 10}"></el-input>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeighthalf}">
        <div class="my-card-body">
          <div slot="header" class="card-header right-card-title">上传资料</div>
          <el-upload ref="uploadFiles"
                     action=""
                     list-type="picture-card"
                     :auto-upload="false"
                     :accept="acceptFileType"
                     :file-list="fileList"
                     :multiple="true"
                     :limit="10"
                     :on-change="onChangeUpload"
                     :on-exceed="handleExceed">
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
      </el-card>
      <el-card id="right-card-bottom" class="right-card-bottom" :style="{width: rightWidth, height: viewerHeighthalf}">
        <div class="my-card-body">
          <div slot="header" class="card-header right-card-title">现有资料</div>
          <el-carousel class="right-card-bottom-carousel" :interval="4000" type="card" height="260px">
            <el-carousel-item v-for="item in materialList" :key="item.caseMaterialId">
              <el-image class="carousel-item" v-show="item.materialType==='img'" :src="item.materialUrl"
                        :preview-src-list="[item.materialUrl]"></el-image>
              <video class="carousel-item" v-show="item.materialType==='vid'" :src="item.materialUrl"
                     crossOrigin='anonymous' autoplay loop muted controls></video>
              <font-awesome-icon class="form-fai" :icon="['fas', 'times-circle']" fixed-width title="删除资料"
                                 @click="dodeleteCaseMaterial(item.caseMaterialId,item.materialUrl)"></font-awesome-icon>
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import {deleteCase, getCase, updateCase, getCaseMaterialById, deleteCaseMaterial} from "../api/api";

  export default {
    name: "case-map",
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
        dialogImageUrl: '',
        dialogVisible: false,
        disabled: false,
        acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP,.avi,.mp4,.wmv,.mov,.AVI,.MP4,.WMV,.MOV",
        fileList: [],
        materialList: [],
        rules: {
          caseName: [{required: true, message: '请输入', trigger: 'blur'}],
          caseSource: [{required: true, message: '请输入', trigger: 'blur'}],
          caseType: [{required: true, message: '请输入', trigger: 'blur'}],
          caseDate: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          caseId: "",
          netId: "",
          caseName: "",
          caseSource: "",
          caseType: "",
          caseAddr: "",
          caseDate: "",
          victim: "",
          suspect: "",
          caseDescribe: "",
          caseResult: "",
          casePosition: "",
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
      getCaseData() {
        this.pictLoading = true;
        getCase().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.caseId;
        this.currentRow = row;
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
          && fileName !== 'JPG' && fileName !== 'JPEG' && fileName !== 'PNG' && fileName !== 'GIF' && fileName !== 'BMP'
          && fileName !== 'avi' && fileName !== 'mp4' && fileName !== 'wmv' && fileName !== 'mov'
          && fileName !== 'AVI' && fileName !== 'MP4' && fileName !== 'WMV' && fileName !== 'MOV') {
          that.$message({
            type: 'error',
            showClose: true,
            duration: 3000,
            message: '文件类型不是照片或视频文件!'
          });
          return false;
        }
        //读取文件大小
        let fileSize = file.size;
        if (fileSize > 1048576 * 500) {
          that.$message({
            type: 'error',
            showClose: true,
            duration: 3000,
            message: '文件不能大于500M!'
          });
          return false;
        }
        this.fileList = fileList;

        return false;
      },
      handleExceed(files, fileList) {
        this.$message.warning(
          `当前限制选择 10 个文件，本次选择了 ${
            files.length
            } 个文件，共选择了 ${files.length + fileList.length} 个文件`
        );
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handleRemove(file) {
        this.$refs.uploadFiles.handleRemove(file);
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
          let params = {
            "caseId": this.currentId
          };
          getCaseMaterialById(params).then(res => {
            for (let i = 0; i < res.data.length; i++) {
              res.data[i].materialUrl = common.serverIp + 'city3dfile/' + res.data[i].materialUrl;
            }
            this.materialList = res.data;
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
            let params = {
              caseId: this.currentId
            };
            deleteCase(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.getCaseData();
                this.backTable();
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
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              let params = this.formData;
              params.caseDate = new Date(params.caseDate).toLocaleDateString().replace(/\//g, '-');
              let formData = new FormData();
              this.fileList.map(item => {
                formData.append('files', item.raw);
              });
              formData.append('caseId', params.caseId);
              formData.append('caseName', params.caseName);
              formData.append('caseSource', params.caseSource);
              formData.append('caseType', params.caseType);
              formData.append('caseAddr', params.caseAddr);
              formData.append('caseDate', params.caseDate);
              formData.append('victim', params.victim);
              formData.append('suspect', params.suspect);
              formData.append('caseDescribe', params.caseDescribe);
              formData.append('caseResult', params.caseResult);
              formData.append('casePosition', params.casePosition);
              updateCase(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.getCaseData();
                  this.backTable();
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
        this.$refs.uploadFiles.clearFiles();
        this.materialList = [];
      },
      dodeleteCaseMaterial(id, url) {
        let params = {
          'caseMaterialId': id,
          'materialUrl': url,
        };
        deleteCaseMaterial(params).then(res => {
          if (res.data === 1) {
            this.$message({
              type: 'success',
              message: '删除成功！'
            });
            for (let i = 0; i < this.materialList.length; i++) {
              if (this.materialList[i].caseMaterialId === id) {
                this.materialList.splice(i, 1);
                break;
              }
            }
          } else {
            this.$message({
              type: 'error',
              message: '删除失败，请重试！'
            });
          }
        });
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.caseName.indexOf(val)
            || ~item.caseType.indexOf(val)
            || ~item.caseAddr.indexOf(val)
            || ~item.caseDate.indexOf(val)
            || ~item.caseSource.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getCaseData();
    },
    computed: {
      viewerHeight: function () {
        return (window.innerHeight - 130) + 'px';
      },
      viewerHeighthalf: function () {
        return (window.innerHeight - 130 - 10) / 2 + 'px';
      },
      cardBodyHeight: function () {
        return (window.innerHeight - 130 - 100) + 'px';
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

  .right-card-bottom {
    float: right;
    margin-top: 8px;
  }

  .right-card-title {
    font-size: 16px;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .right-card-bottom-carousel {
    margin-top: 30px
  }

  .carousel-item {
    height: 100%
  }

  .form-fai {
    font-size: 18px !important;
    cursor: pointer;
    color: #007acc;
    position: absolute;
    top: 4px;
    right: 1px;
  }
</style>
