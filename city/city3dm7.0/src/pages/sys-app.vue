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
                  :default-sort="{prop: 'appName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="应用名称" prop="appName" sortable></el-table-column>
          <el-table-column label="logo图片" prop="appLogo" sortable>
            <template slot-scope="scope">
              <el-image class="table-logo" :src="logoSrc+scope.row.appLogo"
                        :preview-src-list="[logoSrc+scope.row.appLogo]"/>
            </template>
          </el-table-column>
          <el-table-column label="UI类型" prop="appUiMode" sortable></el-table-column>
          <el-table-column label="版本" prop="appVersion" sortable></el-table-column>
          <el-table-column label="默认二维地图" prop="appImage" sortable></el-table-column>
          <el-table-column label="默认地形" prop="appTerrain" sortable></el-table-column>
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
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">确
            定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">重
            置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item label="应用名称" prop="appName">
              <el-input v-model="formData.appName" placeholder="请填写" style="width: 90%"></el-input>
            </el-form-item>
            <el-form-item label="应用版本" prop="appVersion">
              <el-input v-model="formData.appVersion" placeholder="请填写" style="width: 90%"></el-input>
            </el-form-item>
            <el-form-item label="应用logo" prop="appLogo">
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
            <div class="row_display">
              <el-form-item label="默认地图" prop="appImage">
                <el-select v-model="formData.appImage" placeholder="请选择" style="width: 93%">
                  <el-option label="本地暗色地图" value="本地暗色地图"></el-option>
                  <el-option label="本地遥感影像" value="本地遥感影像"></el-option>
                  <el-option label="ArcGIS Online" value="ArcGIS Online"></el-option>
                  <el-option label="天地图遥感影像" value="天地图遥感影像"></el-option>
                  <el-option label="天地图矢量地图" value="天地图矢量地图"></el-option>
                  <el-option label="无地图" value="无地图"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="默认地形" prop="appTerrain">
                <el-select v-model="formData.appTerrain" placeholder="请选择" style="width: 93%">
                  <el-option label="本地地形" value="本地地形"></el-option>
                  <el-option label="Cesium地形" value="Cesium地形"></el-option>
                  <el-option label="无地形" value="无地形"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <el-form-item label="初始视角" prop="appPos">
              <el-input v-model="formData.appPos" placeholder="请填写" style="width: 90%"></el-input>
              <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width title="调整地图视角，点击生成"
                                 @click="getAppView"></font-awesome-icon>
            </el-form-item>
            <el-form-item label="UI类型" prop="appUiMode">
              <el-radio-group v-model="formData.appUiMode">
                <el-radio-button label="0" border>
                  <div class="ui-name">—— · 推荐：功能性用户 · ——</div>
                  <el-image class="ui-mode-img" src="static/images/uimode1.png"
                            :preview-src-list="['static/images/uimode1.png']"/>
                </el-radio-button>
                <el-radio-button label="1" border>
                  <div class="ui-name">—— · 推荐：大屏用户 · ——</div>
                  <el-image class="ui-mode-img" src="static/images/uimode2.jpg"
                            :preview-src-list="['static/images/uimode2.jpg']"/>
                </el-radio-button>
                <el-radio-button label="2" border>
                  <div class="ui-name">—— · 推荐：平板用户 · ——</div>
                  <el-image class="ui-mode-img" src="static/images/uimode3.png"
                            :preview-src-list="['static/images/uimode3.png']"/>
                </el-radio-button>
                <el-radio-button label="3" border>
                  <div class="ui-name">—— · 推荐：手机用户 · ——</div>
                  <el-image class="ui-mode-img" src="static/images/uimode4.png"
                            :preview-src-list="['static/images/uimode4.png']"/>
                </el-radio-button>
                <el-radio-button label="4" border>
                  <div class="ui-name">—— · 推荐：智慧城市 · ——</div>
                  <el-image class="ui-mode-img" src="static/images/uimode5.png"
                            :preview-src-list="['static/images/uimode5.png']"/>
                </el-radio-button>
              </el-radio-group>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
        <CesiumMap></CesiumMap>
      </el-card>
    </div>
  </div>
</template>

<script>
  import CesiumMap from "../utils/components/cesium-map";
  import {deleteApp, getApp, insertApp, updateApp} from "../api/api";

  export default {
    name: "sys-app",
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
        dialogImageUrl: '',
        dialogVisible: false,
        disabled: false,
        acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
        fileList: [],
        imagePreview: '',
        rules: {
          appName: [{required: true, message: '请输入', trigger: 'blur'}],
          appPos: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          appId: '',
          appName: '',
          appLogo: '',
          appUiMode: '',
          appPos: '',
          appImage: '本地暗色地图',
          appTerrain: '本地地形',
          appVersion:''
        },
        logoSrc: common.serverIp + "city3dfile/"
      }
    },
    methods: {
      getAppView() {
        let camPoiR = Cesium.Cartographic.fromCartesian(viewer.camera.position);
        let camHeading = Cesium.Math.toDegrees(viewer.camera.heading);
        let camPitch = Cesium.Math.toDegrees(viewer.camera.pitch);
        let camRoll = 0;
        this.formData.appPos = Cesium.Math.toDegrees(camPoiR.longitude) + ','
          + Cesium.Math.toDegrees(camPoiR.latitude) + ','
          + camPoiR.height + ','
          + camHeading + ',' + camPitch + ',' + camRoll;
      },
      setviewtoapp(camPoi) {
        let camPoiArr = camPoi.split(',');
        viewer.camera.setView({
          destination: Cesium.Cartesian3.fromDegrees(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2])),
          orientation: {
            heading: Cesium.Math.toRadians(Number(camPoiArr[3])),
            pitch: Cesium.Math.toRadians(Number(camPoiArr[4])),
            roll: 0,
          }
        });
      },
      getAppData() {
        this.pictLoading = true;
        getApp().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.appId;
        this.currentRow = row;
        this.setviewtoapp(row.appPos);
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
          this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.appLogo;
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
              appId: this.currentId,
              appLogo: this.currentRow.appLogo
            };
            deleteApp(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getAppData();
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
            formData.append('appId', params.appId);
            formData.append('appName', params.appName);
            formData.append('appUiMode', params.appUiMode);
            formData.append('appPos', params.appPos);
            formData.append('appLogo', params.appLogo);
            formData.append('appVersion', params.appVersion);
            formData.append('appImage', params.appImage);
            formData.append('appTerrain', params.appTerrain);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateApp(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getAppData();
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
                insertApp(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getAppData();
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
          item => (~item.appName.indexOf(val)
            || ~item.appUiMode.indexOf(val)
            || ~item.appVersion.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getAppData();
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

  .ui-name {
    font-size: 18px;
    font-weight: bolder;
    margin-bottom: 10px;
  }

  .ui-mode-img {
    width: 460px;
  }

  .table-logo {
    height: 40px;
    width: 40px
  }
</style>
