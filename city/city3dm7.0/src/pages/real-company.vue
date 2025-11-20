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
                  :default-sort="{prop: 'name', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="单位名称" prop="name" sortable></el-table-column>
          <el-table-column label="行业类型" prop="industryType" sortable></el-table-column>
          <el-table-column label="经营方式" prop="operateMode" sortable></el-table-column>
          <el-table-column label="主营范围" prop="mainBusiness" sortable></el-table-column>
          <el-table-column label="法人代表" prop="legalMan" sortable></el-table-column>
          <el-table-column label="资产性质" prop="economicNature" sortable></el-table-column>
          <el-table-column label="注册资本" prop="registMoney" sortable></el-table-column>
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
        <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item v-show="isEdit" label="单位地址" prop="addName" style="width: 73.5%">
              <el-input v-model="addName" placeholder="请选择目录树地址"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="单位名称" prop="name">
                <el-input v-model="formData.name" placeholder="请填写人员姓名"></el-input>
              </el-form-item>
              <el-form-item label="联系电话" prop="tel" style="margin-left:15px;">
                <el-input v-model="formData.tel" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="单位类型" prop="industryType">
                <el-select v-model="formData.industryType" placeholder="请选择" style="width: 93%">
                  <el-option label="重点单位" value="重点单位"></el-option>
                  <el-option label="特种行业" value="特种行业"></el-option>
                  <el-option label="商业设施" value="商业设施"></el-option>
                  <el-option label="娱乐场所" value="娱乐场所"></el-option>
                  <el-option label="大型超市" value="大型超市"></el-option>
                  <el-option label="企事业单位" value="企事业单位"></el-option>
                  <el-option label="党政机关" value="党政机关"></el-option>
                  <el-option label="宗教活动场所" value="宗教活动场所"></el-option>
                  <el-option label="人员密集场所" value="人员密集场所"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="九小类型" prop="nineSmallType">
                <el-select v-model="formData.nineSmallType" placeholder="请选择" style="width: 93%">
                  <el-option label="无" value="无"></el-option>
                  <el-option label="餐馆" value="餐馆"></el-option>
                  <el-option label="刻印" value="刻印"></el-option>
                  <el-option label="网吧" value="网吧"></el-option>
                  <el-option label="宾馆" value="宾馆"></el-option>
                  <el-option label="KTV" value="KTV"></el-option>
                  <el-option label="物流" value="物流"></el-option>
                  <el-option label="汽修" value="汽修"></el-option>
                  <el-option label="洗浴" value="洗浴"></el-option>
                  <el-option label="美容美发" value="美容美发"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="资产性质" prop="economicNature">
                <el-select v-model="formData.economicNature" placeholder="请选择" style="width: 93%">
                  <el-option label="私企" value="私企"></el-option>
                  <el-option label="国企" value="国企"></el-option>
                  <el-option label="个体" value="个体"></el-option>
                  <el-option label="事业单位" value="事业单位"></el-option>
                  <el-option label="政府机关" value="政府机关"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="经营方式" prop="operateMode">
                <el-input v-model="formData.operateMode" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="法人代表" prop="legalMan">
                <el-input v-model="formData.legalMan" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="主要领导" prop="leader" style="margin-left:15px;">
                <el-input v-model="formData.leader" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="身份证号" prop="identity">
                <el-input v-model="formData.identity" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="营业面积" prop="businessScope" style="margin-left:15px;">
                <el-input v-model="formData.businessScope" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="主营范围" prop="mainBusiness">
                <el-input v-model="formData.mainBusiness" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="兼营范围" prop="secondBusiness" style="margin-left:15px;">
                <el-input v-model="formData.secondBusiness" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="营业执照" prop="licenseNo">
                <el-input v-model="formData.licenseNo" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="组织代码" prop="organization" style="margin-left:15px;">
                <el-input v-model="formData.organization" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="注册地址" prop="registAddress">
                <el-input v-model="formData.registAddress" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="注册资金" prop="registMoney" style="margin-left:15px;">
                <el-input v-model="formData.registMoney" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="注册时间" prop="registDate">
                <el-date-picker v-model="formData.registDate" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="开业时间" prop="openDate" style="margin-left:-15px;">
                <el-date-picker v-model="formData.openDate" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="建筑高度" prop="buildingHeight">
                <el-input v-model="formData.buildingHeight" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="建筑楼层" prop="buildingStorey" style="margin-left:15px;">
                <el-input v-model="formData.buildingStorey" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="建筑面积" prop="constructionArea">
                <el-input v-model="formData.constructionArea" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="占地面积" prop="coverArea" style="margin-left:15px;">
                <el-input v-model="formData.coverArea" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="建筑物业" prop="constructionManagerCompany">
                <el-input v-model="formData.constructionManagerCompany" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="周边环境" prop="geometryInfo" style="margin-left:15px;">
                <el-input v-model="formData.geometryInfo" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="报警器" prop="autoFire">
                <el-input v-model="formData.autoFire" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="防火级别" prop="fireLevel" style="margin-left:15px;">
                <el-input v-model="formData.fireLevel" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="防火负责" prop="fireManager">
                <el-input v-model="formData.fireManager" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="防火管理" prop="fireMange" style="margin-left:15px;">
                <el-input v-model="formData.fireMange" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="主管部门" prop="mainManageDepartment">
                <el-input v-model="formData.mainManageDepartment" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="分管部门" prop="manageDepartment" style="margin-left:15px;">
                <el-input v-model="formData.manageDepartment" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="上级单位" prop="upperCompany">
                <el-input v-model="formData.upperCompany" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="管理类型" prop="manageType" style="margin-left:15px;">
                <el-select v-model="formData.manageType" placeholder="请选择" style="width: 93%">
                  <el-option label="局管单位" value="局管单位"></el-option>
                  <el-option label="所管单位" value="所管单位"></el-option>
                  <el-option label="社区管理" value="社区管理"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="安保级别" prop="saveLevel">
                <el-select v-model="formData.saveLevel" placeholder="请选择" style="width: 93%">
                  <el-option label="一级" value="一级"></el-option>
                  <el-option label="二级" value="二级"></el-option>
                  <el-option label="三级" value="三级"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="安保类型" prop="saveType">
                <el-select v-model="formData.saveType" placeholder="请选择" style="width: 93%">
                  <el-option label="重点单位" value="重点单位"></el-option>
                  <el-option label="学校" value="学校"></el-option>
                  <el-option label="宗教场所" value="宗教场所"></el-option>
                  <el-option label="特种行业" value="特种行业"></el-option>
                  <el-option label="一般企业" value="一般企业"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="安保负责" prop="saveManName">
                <el-input v-model="formData.saveManName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="安保电话" prop="saveManTel" style="margin-left:15px;">
                <el-input v-model="formData.saveManTel" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="照片" prop="imageInfo">
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
        <div class="my-card-body" :style="{height: treeHeight}">
          <AddressComTree></AddressComTree>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import AddressComTree from "../utils/components/address-com-tree";
import {
  deleteCompany,
  getAddressById,
  insertCompany,
  queryCompanyData,
  updateCompany,
  batchDeleteCompany
} from "../api/api";

export default {
  name: "real-company",
  components: {AddressComTree},
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
      addName: "",
      rules: {
        name: [{required: true, message: '请输入', trigger: 'blur'}],
        industryType: [{required: true, message: '请输入', trigger: 'blur'}],
        nineSmallType: [{required: true, message: '请输入', trigger: 'blur'}],
        tel: [{required: true, message: '请输入', trigger: 'blur'}],
        operateMode: [{required: true, message: '请输入', trigger: 'blur'}],
        mainBusiness: [{required: true, message: '请输入', trigger: 'blur'}],
        legalMan: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        companyId: "",
        addId: "",
        name: "",
        organization: "20171027",
        industryType: "重点单位",
        nineSmallType: "无",
        tel: "18900001234",
        economicNature: "私企",
        leader: "李某",
        legalMan: "李某",
        identity: "123456199001011234",
        operateMode: "私有",
        mainBusiness: "商贸",
        secondBusiness: "商贸",
        openDate: "2017-10-27",
        licenseNo: "20171027",
        registMoney: "1000万",
        registAddress: "学府路99号",
        registDate: "2017-10-27",
        buildingHeight: "30米",
        buildingStorey: "5层",
        businessScope: "6000平方米",
        coverArea: "1000平方米",
        constructionArea: "6000平方米",
        constructionManagerCompany: "无",
        geometryInfo: "无",
        autoFire: "有",
        fireLevel: "一级",
        fireManager: "惠元",
        fireMange: "应急管理局",
        mainManageDepartment: "工商管理局",
        manageDepartment: "工商管理局",
        upperCompany: "工商管理局",
        manageType: "局管单位",
        saveLevel: "一级",
        saveManName: "王国龙",
        saveManTel: "13900001234",
        saveType: "重点单位",
        community: "",
        imageInfo: ""
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
    getCompanyData() {
      this.pictLoading = true;
      let params = {
        name: "",
        organization: "",
        leader: "",
        legalMan: "",
        address: "",
        industryType: "",
        mainBusiness: "",
      };
      queryCompanyData(params).then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.companyId;
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
      window.addressId = '';
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.imageInfo;
        window.addressId = this.currentRow.addId;
        let params = {
          addId: this.currentRow.addId
        };
        getAddressById(params).then(res => {
          this.addName = res.data.addName;
          this.formData.community = res.data.pid;
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
            companyId: this.currentId,
            imageInfo: this.currentRow.imageInfo
          };
          deleteCompany(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getCompanyData();
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
          batchDeleteCompany(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getCompanyData();
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
          if (window.addressId !== undefined && window.addressId !== null && window.addressId !== '') {
            let params = this.formData;
            params.addId = window.addressId;
            params.registDate = new Date(params.registDate).toLocaleDateString().replace(/\//g, '-');
            params.openDate = new Date(params.openDate).toLocaleDateString().replace(/\//g, '-');
            let formData = new FormData();
            this.fileList.map(item => {
              formData.append('files', item.raw);
            });
            formData.append('companyId', params.companyId);
            formData.append('addId', params.addId);
            formData.append('name', params.name);
            formData.append('organization', params.organization);
            formData.append('industryType', params.industryType);
            formData.append('nineSmallType', params.nineSmallType);
            formData.append('tel', params.tel);
            formData.append('economicNature', params.economicNature);
            formData.append('leader', params.leader);
            formData.append('legalMan', params.legalMan);
            formData.append('identity', params.identity);
            formData.append('operateMode', params.operateMode);
            formData.append('mainBusiness', params.mainBusiness);
            formData.append('secondBusiness', params.secondBusiness);
            formData.append('openDate', params.openDate);
            formData.append('licenseNo', params.licenseNo);
            formData.append('registMoney', params.registMoney);
            formData.append('registAddress', params.registAddress);
            formData.append('registDate', params.registDate);
            formData.append('buildingHeight', params.buildingHeight);
            formData.append('buildingStorey', params.buildingStorey);
            formData.append('businessScope', params.businessScope);
            formData.append('coverArea', params.coverArea);
            formData.append('constructionArea', params.constructionArea);
            formData.append('constructionManagerCompany', params.constructionManagerCompany);
            formData.append('geometryInfo', params.geometryInfo);
            formData.append('autoFire', params.autoFire);
            formData.append('fireLevel', params.fireLevel);
            formData.append('fireManager', params.fireManager);
            formData.append('fireMange', params.fireMange);
            formData.append('mainManageDepartment', params.mainManageDepartment);
            formData.append('manageDepartment', params.manageDepartment);
            formData.append('upperCompany', params.upperCompany);
            formData.append('manageType', params.manageType);
            formData.append('saveLevel', params.saveLevel);
            formData.append('saveManName', params.saveManName);
            formData.append('saveManTel', params.saveManTel);
            formData.append('saveType', params.saveType);
            formData.append('community', params.community);
            formData.append('imageInfo', params.imageInfo);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateCompany(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getCompanyData();
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
                  formData.append('community', res.data.pid);
                  insertCompany(formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                      this.backTable();
                      this.getCompanyData();
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
      this.$refs.uploadImage.clearFiles();
      this.imagePreview = '';
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.name.indexOf(val)
          || ~item.industryType.indexOf(val)
          || ~item.operateMode.indexOf(val)
          || ~item.mainBusiness.indexOf(val)
          || ~item.legalMan.indexOf(val)
          || ~item.economicNature.indexOf(val)
          || ~item.registMoney.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getCompanyData();
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
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
</style>
