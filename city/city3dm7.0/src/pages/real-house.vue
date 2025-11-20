<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="lId"
                  :default-sort="{prop: 'address.addName', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="房屋地址" prop="address.addName" sortable></el-table-column>
          <el-table-column label="产权人" prop="peopleBase.name" sortable></el-table-column>
          <el-table-column label="产权类型" prop="propertyType" sortable></el-table-column>
          <el-table-column label="房屋类型" prop="houseType" sortable></el-table-column>
          <el-table-column label="房屋用途" prop="houseUse" sortable></el-table-column>
          <el-table-column label="房屋面积" prop="houseArea" sortable></el-table-column>
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
      <div class="left-card">
        <el-card id="left-card" :style="{width: leftWidth, height: viewerHeightTop}">
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
          <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeightInfo}">
            <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
              <el-form-item v-show="isEdit" label="房屋地址" prop="addName" style="width: 73.5%">
                <el-input v-model="addName" placeholder="请选择目录树地址"></el-input>
              </el-form-item>
              <div class="row_display">
                <el-form-item label="房屋类型" prop="houseType">
                  <el-select v-model="formData.houseType" placeholder="请选择" style="width: 93%">
                    <el-option label="楼房" value="楼房"></el-option>
                    <el-option label="平房" value="平房"></el-option>
                    <el-option label="拆迁" value="拆迁"></el-option>
                    <el-option label="其他" value="其他"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="产权人" prop="peopleBaseName" v-show="isEdit">
                  <el-input v-model="peopleBaseName" placeholder="请填写"></el-input>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item label="房屋用途" prop="houseUse">
                  <el-select v-model="formData.houseUse" placeholder="请选择" style="width: 93%">
                    <el-option label="住宅" value="住宅"></el-option>
                    <el-option label="出租" value="出租"></el-option>
                    <el-option label="商用" value="商用"></el-option>
                    <el-option label="其他" value="其他"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="房屋结构" prop="buldingStructure">
                  <el-select v-model="formData.buldingStructure" placeholder="请选择" style="width: 93%">
                    <el-option label="砖混" value="砖混"></el-option>
                    <el-option label="框架" value="框架"></el-option>
                    <el-option label="砖木" value="砖木"></el-option>
                    <el-option label="钢混" value="钢混"></el-option>
                    <el-option label="板房" value="板房"></el-option>
                    <el-option label="棚房" value="棚房"></el-option>
                    <el-option label="其他" value="其他"></el-option>
                  </el-select>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item label="房屋面积" prop="houseArea">
                  <el-input v-model="formData.houseArea" placeholder="请填写"></el-input>
                </el-form-item>
                <el-form-item label="房间数" prop="houseCount" style="margin-left:15px;">
                  <el-input v-model="formData.houseCount" placeholder="请填写"></el-input>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item label="产权证号" prop="propertyNo">
                  <el-input v-model="formData.propertyNo" placeholder="请填写"></el-input>
                </el-form-item>
                <el-form-item label="产权类型" prop="propertyType" style="margin-left:15px;">
                  <el-select v-model="formData.propertyType" placeholder="请选择" style="width: 93%">
                    <el-option label="私有" value="私有"></el-option>
                    <el-option label="集体" value="集体"></el-option>
                    <el-option label="国有" value="国有"></el-option>
                    <el-option label="其他" value="其他"></el-option>
                  </el-select>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item label="产权起始" prop="beginDate">
                  <el-date-picker v-model="formData.beginDate" align="left" type="date"
                                  placeholder="选择日期" style="width: 87%">
                  </el-date-picker>
                </el-form-item>
                <el-form-item label="产权结束" prop="endDate" style="margin-left:-15px;">
                  <el-date-picker v-model="formData.endDate" align="left" type="date"
                                  placeholder="选择日期" style="width: 87%">
                  </el-date-picker>
                </el-form-item>
              </div>
              <el-form-item label="户型图" prop="housePhotos">
                <div class="row_display avatar-img-row">
                  <el-image class="avatar-img" :src="imagePreview" fit="fill"></el-image>
                  <el-upload ref="uploadImage"
                             action=""
                             list-type="picture-card"
                             :auto-upload="false"
                             :accept="acceptFileType"
                             :file-list="fileList1"
                             :limit="1"
                             :on-change="onChangeUpload1"
                             :on-exceed="handleExceed1"
                             class="avatar-img-upload">
                    <i slot="default" class="el-icon-plus"></i>
                    <div slot="file" slot-scope="{file}">
                      <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                      <span class="el-upload-list__item-actions">
                        <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                          <i class="el-icon-zoom-in"></i>
                        </span>
                        <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove1(file)">
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
        <el-card class="left-card-middle" :style="{width: leftWidth, height: viewerHeightMiddle}">
          <div class="my-card-body" style="height: 150px">
            <el-form ref="formDataPP" label-width="120px">
              <el-form-item label="上传全景照片" prop="image">
                <el-upload ref="uploadFiles"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList"
                           :multiple="true"
                           :limit="8"
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
              </el-form-item>
            </el-form>
          </div>
        </el-card>
        <el-card class="left-card-bottom" :style="{width: leftWidth, height: viewerHeightBottom}">
          <div class="my-card-body">
            <div slot="header" class="card-header right-card-title">现有全景照片</div>
            <el-carousel class="right-card-bottom-carousel" :interval="4000" type="card" height="200px">
              <el-carousel-item v-for="item in panoramas" :key="item.panoramaId">
                <el-image class="carousel-item" :src="item.housePanorama"
                          :preview-src-list="[item.housePanorama]"></el-image>
                <font-awesome-icon class="form-fai" :icon="['fas', 'times-circle']" fixed-width title="删除资料"
                                   @click="dodeletePanoramas(item.panoramaId,item.housePanorama)"></font-awesome-icon>
              </el-carousel-item>
            </el-carousel>
          </div>
        </el-card>
      </div>
      <div class="right-card">
        <el-card class="right-card-top" :style="{width: rightWidth, height: viewerHeightTopR}">
          <div class="my-card-body" :style="{height: treeHeight}">
            <AddressTree></AddressTree>
          </div>
        </el-card>
        <el-card class="right-card-bottom" :style="{width: rightWidth, height: viewerHeightBottomR}">
          <div class="row_display">
            <div class="right-card-title">房产所有人</div>
            <el-input class="search-input-pp" placeholder="通过姓名、身份证号检索" v-model="devFilterPP"></el-input>
            <font-awesome-icon class="form-fai-pp" :icon="['fas', 'search']" fixed-width @click="searchPeopleBase"
                               title="开始搜索"></font-awesome-icon>
          </div>
          <div class="my-card-body" style="height: 360px">
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
  </div>
</template>

<script>
import AddressTree from "../utils/components/address-tree";
import {
  deleteHouse,
  deleteHousePanorama,
  getAddressById,
  getHousePanoramaByHosueId,
  insertHouse,
  queryHouse,
  updateHouse,
  queryPeoplebasePart,
  batchDeleteHouse
} from "../api/api";

export default {
  name: "real-house",
  components: {AddressTree},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      currentPagePP: 1, //初始页
      pagesizePP: 5,   //每页的数据
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
      fileList1: [],
      imagePreview: '',
      addName: "",
      peopleBaseName: "",
      panoramas: [],
      rules: {
        buldingStructure: [{required: true, message: '请输入', trigger: 'blur'}],
        houseArea: [{required: true, message: '请输入', trigger: 'blur'}],
        houseCount: [{required: true, message: '请输入', trigger: 'blur'}],
        houseType: [{required: true, message: '请输入', trigger: 'blur'}],
        houseUse: [{required: true, message: '请输入', trigger: 'blur'}],
        propertyNo: [{required: true, message: '请输入', trigger: 'blur'}],
        propertyType: [{required: true, message: '请输入', trigger: 'blur'}],
        beginDate: [{required: true, message: '请输入', trigger: 'blur'}],
        endDate: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        houseId: "",
        addId: "",
        ppId: "",
        buldingStructure: "砖混",
        houseArea: "100",
        houseCount: "4",
        houseType: "楼房",
        houseUse: "住宅",
        propertyNo: "1990-79",
        propertyType: "私有",
        beginDate: "1990-01-01",
        endDate: "2020-01-01",
        houseUrl: "",
        housePhotos: ""
      },
    }
  },
  methods: {
    getHouseData() {
      this.pictLoading = true;
      let params = {
        address: {addName: ""},
        peopleBase: {name: ""},
        communityPolice: "",
        houseType: "",
        houseUse: "",
        propertyNo: "",
        trusteeName: "",
        trusteeTel: "",
      };
      queryHouse(params).then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.houseId;
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
    onChangeUpload1(file, fileList) {
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
      this.fileList1 = fileList;
      return false;
    },
    handleExceed(files, fileList) {
      this.$message.warning(
        `当前限制选择 8 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleExceed1(files, fileList) {
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
      this.$refs.uploadFiles.handleRemove(file);
    },
    handleRemove1(file) {
      this.$refs.uploadImage.handleRemove(file);
    },
    addData(formName) {
      this.isTableShow = false;
      this.isEdit = false;
      this.$refs[formName].resetFields();
      this.peopleBaseName = '';
      window.addressId = '';
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        window.addressId = this.currentRow.addId;
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.housePhotos;
        this.peopleBaseName = this.currentRow.peopleBase.name;
        let params = {
          addId: this.currentRow.addId
        };
        getAddressById(params).then(res => {
          this.addName = res.data.addName;
          this.formData.houseUrl = res.data.pid;
        });
        let paramsPanorama = {
          "houseId": this.currentId
        };
        getHousePanoramaByHosueId(paramsPanorama).then(res => {
          for (let i = 0; i < res.data.length; i++) {
            res.data[i].housePanorama = common.serverIp + 'city3dfile/' + res.data[i].housePanorama;
          }
          this.panoramas = res.data;
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
            houseId: this.currentId,
            housePhotos: this.currentRow.housePhotos
          };
          deleteHouse(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getHouseData();
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
          batchDeleteHouse(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getHouseData();
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
    multiuploadData() {
      this.$message({
        message: '待完善，批量导入！',
        type: 'error'
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (window.addressId !== undefined && window.addressId !== null && window.addressId !== '') {
            let params = this.formData;
            params.addId = window.addressId;
            params.beginDate = new Date(params.beginDate).toLocaleDateString().replace(/\//g, '-');
            params.endDate = new Date(params.endDate).toLocaleDateString().replace(/\//g, '-');
            let formData = new FormData();
            this.fileList.map(item => {
              formData.append('files', item.raw);
            });
            this.fileList1.map(item => {
              formData.append('photos', item.raw);
            });
            formData.append('houseId', params.houseId);
            formData.append('addId', params.addId);
            formData.append('ppId', params.ppId);
            formData.append('buldingStructure', params.buldingStructure);
            formData.append('houseArea', params.houseArea);
            formData.append('houseCount', params.houseCount);
            formData.append('houseType', params.houseType);
            formData.append('houseUse', params.houseUse);
            formData.append('propertyNo', params.propertyNo);
            formData.append('propertyType', params.propertyType);
            formData.append('beginDate', params.beginDate);
            formData.append('endDate', params.endDate);
            formData.append('houseUrl', params.houseUrl);
            formData.append('housePhotos', params.housePhotos);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateHouse(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getHouseData();
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
                let paramsAdd = {
                  addId: window.addressId
                };
                getAddressById(paramsAdd).then(res => {
                  formData.append('houseUrl', res.data.pid);
                  insertHouse(formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                      this.backTable();
                      this.getHouseData();
                    } else {
                      this.$message({
                        type: 'error',
                        message: '新增失败，请重试！'
                      });
                    }
                  });
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
      this.fileList1 = [];
      this.$refs.uploadFiles.clearFiles();
      this.panoramas = [];
      this.tableDatePP = [];
      this.devFilterPP = '';
      this.formData.ppId = '';
      this.imagePreview = '';
    },
    dodeletePanoramas(id, url) {
      let params = {
        'panoramaId': id,
        'housePanorama': url,
      };
      deleteHousePanorama(params).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '删除成功！'
          });
          for (let i = 0; i < this.panoramas.length; i++) {
            if (this.panoramas[i].panoramaId === id) {
              this.panoramas.splice(i, 1);
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
        item => (~item.address.addName.indexOf(val)
          || ~item.peopleBase.name.indexOf(val)
          || ~item.propertyType.indexOf(val)
          || ~item.houseType.indexOf(val)
          || ~item.houseUse.indexOf(val)
          || ~item.houseArea.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getHouseData();
  },
  computed: {
    viewerHeightTopR: function () {
      return (window.innerHeight - 130 - 10) / 2 + 4 + 'px';
    },
    viewerHeightBottomR: function () {
      return (window.innerHeight - 130 - 10) / 2 + 'px';
    },
    viewerHeightTop: function () {
      return (window.innerHeight - 130 - 10) / 3 + 115 + 'px';
    },
    viewerHeightMiddle: function () {
      return (window.innerHeight - 130 - 10) / 3 - 110 + 'px';
    },
    viewerHeightBottom: function () {
      return (window.innerHeight - 130 - 10) / 3 - 5 + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
    },
    cardBodyHeightInfo: function () {
      return (window.innerHeight - 130 - 10) / 3 + 32 + 'px';
    },
    treeHeight: function () {
      return (window.innerHeight - 130 - 20) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.5) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 240) * 0.5) + 'px';
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

.left-card-middle {
  margin-top: 5px;
}

.left-card-bottom {
  margin-top: 5px;
}

.right-card-bottom {
  float: right;
  margin-top: 8px;
}

.right-card-title {
  font-size: 16px;
  margin: 5px 0 0 10px
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
  margin-top: 0;
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
