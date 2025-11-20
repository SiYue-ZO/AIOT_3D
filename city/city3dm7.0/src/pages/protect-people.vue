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
      </div>
      <div class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'name', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="姓名" prop="name" sortable></el-table-column>
          <el-table-column label="人口类别" prop="type" sortable></el-table-column>
          <el-table-column label="身份证号" prop="identity" sortable></el-table-column>
          <el-table-column label="监控单位" prop="origin" sortable></el-table-column>
          <el-table-column label="监控原因" prop="describe" sortable></el-table-column>
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
          <el-button class="header-button" type="primary" icon="el-icon-s-promotion" @click="doregistAIFace">注册AI人脸图像
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="dodeleteAIFace">删除AI人脸图像
          </el-button>

        </div>
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item label="2寸照片" prop="image">
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
              <div class="form-note">* AI人脸识别图像注册仅支持jpg格式图片</div>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="名单类型" prop="blood">
                <el-select v-model="formData.blood" placeholder="请选择" style="width: 93%">
                  <el-option label="黑名单" value="1"></el-option>
                  <el-option label="白名单" value="2"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="AI服务器" prop="faceIp">
                <el-select v-model="faceIp" placeholder="请选择" style="width: 93%">
                  <el-option v-for="(item,index) in faceIps" :label="item" :value="item" :key="index"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="姓名" prop="name">
                <el-input v-model="formData.name" placeholder="请填写人员姓名"></el-input>
              </el-form-item>
              <el-form-item label="身份证号" prop="identity" style="margin-left:15px;">
                <el-input v-model="formData.identity" placeholder="请填写身份证号" maxlength=18 show-word-limit></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="AI编号" prop="birthday">
                <el-input v-model="formData.birthday" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item v-show="isEdit" label="住址" prop="addName" style="width: 73.5%">
              <el-input v-model="addName" placeholder="请选择目录树地址"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="性别" prop="gender">
                <el-select v-model="formData.gender" placeholder="请选择" style="width: 93%">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="民族" prop="nation">
                <el-input v-model="formData.nation" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="从业职业" prop="job">
                <el-input v-model="formData.job" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="联系电话" prop="tel" style="margin-left:15px;">
                <el-input v-model="formData.tel" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="身高" prop="height">
                <el-input v-model="formData.height" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="人口类别" prop="type">
                <el-select v-model="formData.type" placeholder="请选择" style="width: 93%">
                  <el-option label="重点人员" value="重点人员"></el-option>
                  <el-option label="监管对象" value="监管对象"></el-option>
                  <el-option label="司法矫正" value="司法矫正"></el-option>
                  <el-option label="取保候审" value="取保候审"></el-option>
                  <el-option label="重点嫌疑" value="重点嫌疑"></el-option>
                  <el-option label="刑满释放" value="刑满释放"></el-option>
                  <el-option label="吸毒人员" value="吸毒人员"></el-option>
                  <el-option label="上访人员" value="上访人员"></el-option>
                  <el-option label="精神病史" value="精神病史"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="监控单位" prop="origin">
                <el-input v-model="formData.origin" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="监控原因" prop="describe">
              <el-input type="textarea" v-model="formData.describe" placeholder="请填写" style="width: 70%"></el-input>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
        <div class="my-card-body" :style="{height: treeHeight}">
          <AddressTree></AddressTree>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import AddressTree from "../utils/components/address-tree";
  import {
    getKeypeopleAll,
    getAddressById,
    deleteKeypeople,
    updateKeypeople,
    insertKeypeople,
    registAIFace, deleteAIFace
  } from "../api/api";
  import {randomNumber} from "../js/CesiumTools";

  export default {
    name: "protect-people",
    components: {AddressTree},
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
        addName: "",
        faceIp: "",
        faceIps: [],
        rules: {
          name: [{required: true, message: '请输入', trigger: 'blur'}],
          gender: [{required: true, message: '请输入', trigger: 'blur'}],
          identity: [{required: true, message: '请输入', trigger: 'blur'}],
          nation: [{required: true, message: '请输入', trigger: 'blur'}],
          birthday: [{required: true, message: '请输入', trigger: 'blur'}],
          height: [{required: true, message: '请输入', trigger: 'blur'}],
          job: [{required: true, message: '请输入', trigger: 'blur'}],
          tel: [{required: true, message: '请输入', trigger: 'blur'}],
          type: [{required: true, message: '请输入', trigger: 'blur'}],
          origin: [{required: true, message: '请输入', trigger: 'blur'}],
          describe: [{required: true, message: '请输入', trigger: 'blur'}],
          blood: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          keyId: "",
          addId: "",
          name: "",
          gender: "",
          identity: "",
          nation: "",
          birthday: "",
          height: "",
          job: "",
          tel: "",
          type: "重点人员",
          origin: "无",
          describe: "无",
          blood: "1",
          imgurl: ""
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
      getKeypeopleData() {
        this.pictLoading = true;
        getKeypeopleAll().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.keyId;
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
        this.initFaceIp();
        this.formData.birthday = randomNumber();
      },
      editData() {
        if (this.currentId !== '') {
          this.isTableShow = false;
          this.isEdit = true;
          this.formData = Object.assign(this.formData, this.currentRow);
          this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.imgurl;
          window.addressId = this.currentRow.addId;
          let params = {
            addId: this.currentRow.addId
          };
          getAddressById(params).then(res => {
            this.addName = res.data.addName;
          });
          this.initFaceIp();
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
              keyId: this.currentId,
              imgurl: this.currentRow.imgurl
            };
            deleteKeypeople(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getKeypeopleData();
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
            if (window.addressId !== undefined && window.addressId !== null && window.addressId !== '') {
              this.formData.addId = window.addressId;
              let params = this.formData;
              let formData = new FormData();
              this.fileList.map(item => {
                formData.append('files', item.raw);
              });
              formData.append('keyId', params.keyId);
              formData.append('addId', params.addId);
              formData.append('name', params.name);
              formData.append('identity', params.identity);
              formData.append('gender', params.gender);
              formData.append('nation', params.nation);
              formData.append('birthday', params.birthday);
              formData.append('height', params.height);
              formData.append('job', params.job);
              formData.append('tel', params.tel);
              formData.append('type', params.type);
              formData.append('origin', params.origin);
              formData.append('describe', params.describe);
              formData.append('blood', params.blood);
              formData.append('imgurl', params.imgurl);
              if (this.isEdit) {
                this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                  distinguishCancelAndClose: true,
                  confirmButtonText: '确认',
                  cancelButtonText: '取消'
                }).then(() => {
                  updateKeypeople(formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '修改成功，返回列表！'
                      });
                      this.backTable();
                      this.getKeypeopleData();
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
                  insertKeypeople(formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                      this.backTable();
                      this.getKeypeopleData();
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
                type: 'error',
                message: '请选择目录树中的地名地址！'
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
        window.addressId = null;
        this.fileList = [];
        this.$refs.uploadImage.clearFiles();
        this.imagePreview = '';
      },
      doregistAIFace() {
        let base64Url = "";
        let img = document.getElementsByClassName("el-upload-list__item-thumbnail")[0];
        if (img) {
          base64Url = this.getBase64Image(img);
        } else {
          this.$message({
            type: 'error',
            message: "自选照片不能为空，请点击“+”添加图片！"
          });
          return;
        }

        if (this.faceIp !== "" && this.formData.blood !== "" && this.formData.name !== "" && this.formData.identity !== "") {
          let params = {
            "repoType": parseInt(this.formData.blood),
            "image": base64Url,
            "userId": "123456789",
            "name": this.formData.name,
            "cardId": this.formData.identity,
          };
          if (this.faceIp === "全部") {
            this.faceIps.map(item => {
              if (item !== "全部") {
                this.doregistAiFace(item, params);
              }
            });
          } else {
            this.doregistAiFace(this.faceIp, params);
          }
        } else {
          this.$message({
            type: 'error',
            message: "名单类型、AI服务器地址、姓名、身份证号不能为空！"
          });
        }
      },
      doregistAiFace(faceIp, params) {
        registAIFace(faceIp, params).then(res => {
          if (res.data.result.code === "200") {
            this.$message({
              type: 'success',
              message: 'AI人脸识别图像注册成功！'
            });
          } else {
            let mess = "";
            switch (res.data.data) {
              case -1:
                mess = "注册失败,访问出错！";
                break;
              case -2:
                mess = "注册失败,服务器繁忙！";
                break;
              case -3:
                mess = "注册失败,数据库类型错误！";
                break;
              case -4:
                mess = "注册失败,索引错误！";
                break;
              case -5:
                mess = "注册失败,不支持的图片格式！";
                break;
              case -6:
                mess = "注册失败,加载图片失败！";
                break;
              case -7:
                mess = "注册失败,检测人脸失败！";
                break;
              case -8:
                mess = "注册失败,提取特征值失败！";
                break;
              case -9:
                mess = "注册失败,提取人脸照片失败！";
                break;
              case -10:
                mess = "注册失败,缩放人脸照片失败！";
                break;
              case -11:
                mess = "注册失败,保存人脸照片失败！";
                break;
              case -12:
                mess = "注册失败,修改名单时找不到UID！";
                break;
              case -13:
                mess = "注册失败,创建UID失败，请求超时！";
                break;
              default:
                break;
            }
            this.$message({
              type: 'error',
              message: mess
            });
          }
        });
      },
      dodeleteAIFace() {
        if (this.faceIp !== "") {
          deleteAIFace(this.faceIp, this.formData.birthday).then(res => {
            if (res.data.result.code === "200") {
              if (res.data.data === 0) {
                this.$message({
                  type: 'success',
                  message: '请求成功，但AI人脸识别图像不存在，不需删除！'
                });
              } else if (res.data.data === 1) {
                this.$message({
                  type: 'success',
                  message: 'AI人脸识别图像删除成功！'
                });
              }
            } else {
              this.$message({
                type: 'error',
                message: "AI人脸识别图像删除失败，请重试！"
              });
            }
          })
        } else {
          this.$message({
            type: 'error',
            message: "AI服务器地址不能为空！"
          });
        }
      },
      initFaceIp() {
        this.faceIps = window.aiIp.split(',');
        this.faceIps.unshift('全部');
      },
      getBase64Image(img) {
        let canvas = document.createElement("canvas");
        canvas.width = img.width;
        canvas.height = img.height;
        let ctx = canvas.getContext("2d");
        ctx.drawImage(img, 0, 0, img.width, img.height);
        let dataUrl = canvas.toDataURL("image/jpeg");
        return dataUrl;
      },
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.name.indexOf(val)
            || ~item.type.indexOf(val)
            || ~item.identity.indexOf(val)
            || ~item.origin.indexOf(val)
            || ~item.describe.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getKeypeopleData();
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
    width: 69%;
    margin: 0 0 10px 0;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img {
    margin: 5px 10px 5px 10px;
    width: 140px;
    height: 196px;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img-upload {
    margin: 30px 0 0 10px;
  }

  .form-note {
    margin: 5px 0 0 10px
  }
</style>
