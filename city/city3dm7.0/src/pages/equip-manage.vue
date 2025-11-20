<template>
  <el-card>
    <div slot="header" class="card-header">
      <div v-show="isTableShow">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline" @click="addData('formData')">
          添 加
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
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
                :default-sort="{prop: 'equipmentType', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="装备类型" prop="equipmentType" sortable></el-table-column>
        <el-table-column label="装备名称" prop="equipmentName" sortable></el-table-column>
        <el-table-column label="装备评分" prop="equipmentGrade" sortable></el-table-column>
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
        <el-form-item label="装备名称" prop="equipmentName">
          <el-input v-model="formData.equipmentName" placeholder="请填写" style="width:69%"></el-input>
        </el-form-item>
        <div class="row_display">
          <el-form-item label="装备类型" prop="equipmentType">
            <el-select v-model="formData.equipmentType" placeholder="请选择">
              <el-option label="手枪" value="手枪"></el-option>
              <el-option label="散弹枪" value="散弹枪"></el-option>
              <el-option label="突击步枪" value="突击步枪"></el-option>
              <el-option label="狙击步枪" value="狙击步枪"></el-option>
              <el-option label="防弹衣/防刺服" value="防弹衣/防刺服"></el-option>
              <el-option label="防弹/防刺头盔" value="防弹/防刺头盔"></el-option>
              <el-option label="防爆盾牌" value="防爆盾牌"></el-option>
              <el-option label="刀具" value="刀具"></el-option>
              <el-option label="棍/叉" value="棍/叉"></el-option>
              <el-option label="手榴弹/闪光弹/烟雾弹/催泪弹" value="手榴弹/闪光弹/烟雾弹/催泪弹"></el-option>
              <el-option label="执法仪" value="执法仪"></el-option>
              <el-option label="喷雾" value="喷雾"></el-option>
              <el-option label="路障/围栏" value="路障/围栏"></el-option>
              <el-option label="无人机" value="无人机"></el-option>
              <el-option label="急救装备" value="急救装备"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="装备评分" prop="equipmentGrade" style="margin-left: 15px">
            <el-input-number v-model="formData.equipmentGrade" :precision="1" :step="0.1" :max="10"></el-input-number>
          </el-form-item>
        </div>
        <el-form-item label="装备照片" prop="image">
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
</template>

<script>
  import {deleteEquipment, insertEquipment, selectEquipmentByType, updateEquipment} from "../api/api";

  export default {
    name: "equip-manage",
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
        acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
        fileList: [],
        imagePreview: '',
        rules: {
          equipmentType: [{required: true, message: '请输入', trigger: 'blur'}],
          equipmentName: [{required: true, message: '请输入', trigger: 'blur'}],
          equipmentGrade: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          equipmentId: '',
          equipmentType: '',
          equipmentName: '',
          equipmentGrade: '',
          equipmentPicture: ''
        }
      }
    },
    methods: {
      getEquipmentData() {
        this.pictLoading = true;
        selectEquipmentByType().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.equipmentId;
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
          this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.equipmentPicture;
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
              equipmentId: this.currentId,
              equipmentPicture: this.currentRow.equipmentPicture
            };
            deleteEquipment(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getEquipmentData();
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
            let params = this.formData;
            let formData = new FormData();
            this.fileList.map(item => {
              formData.append('files', item.raw);
            });
            formData.append('equipmentId', params.equipmentId);
            formData.append('equipmentType', params.equipmentType);
            formData.append('equipmentName', params.equipmentName);
            formData.append('equipmentGrade', params.equipmentGrade);
            formData.append('equipmentPicture', params.equipmentPicture);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateEquipment(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getEquipmentData();
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
                insertEquipment(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getEquipmentData();
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
          item => (~item.equipmentType.indexOf(val)
            || ~item.equipmentName.indexOf(val)
            || ~item.equipmentGrade.indexOf(val))
        );
      }
    },
    mounted() {
      this.getEquipmentData();
    },
    computed: {
      cardBodyHeight: function () {
        return (window.innerHeight - 130 - 100) + 'px';
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
    overflow-x: hidden;
    font-size: 15px !important;
    margin: 10px 0 0 5px;
  }

  .row_display {
    display: flex;
  }

  .avatar-img-row {
    width: 69%;
    margin: 0 0 10px 0;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img {
    margin: 5px 10px 5px 10px;
    width: 400px;
    height: 300px;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img-upload {
    margin: 80px 0 0 10px;
  }
</style>
