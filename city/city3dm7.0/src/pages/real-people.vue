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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="ppId"
                  :default-sort="{prop: 'name', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="姓名" prop="name" sortable></el-table-column>
          <el-table-column label="人口类别" prop="peopleType" sortable></el-table-column>
          <el-table-column label="身份证号" prop="identity" sortable></el-table-column>
          <el-table-column label="民族" prop="nation" sortable></el-table-column>
          <el-table-column label="性别" prop="gender" sortable></el-table-column>
          <el-table-column label="联系电话" prop="tel" sortable></el-table-column>
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
            </el-form-item>
            <el-form-item v-show="isEdit" label="住址" prop="addName" style="width: 73.5%">
              <el-input v-model="addName" placeholder="请选择目录树地址"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="姓名" prop="name">
                <el-input v-model="formData.name" placeholder="请填写人员姓名"></el-input>
              </el-form-item>
              <el-form-item label="曾用名" prop="onceName" style="margin-left:15px;">
                <el-input v-model="formData.onceName" placeholder="请填写人员曾用名"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="身份证号" prop="identity">
                <el-input v-model="formData.identity" placeholder="请填写身份证号" maxlength=18
                          show-word-limit></el-input>
              </el-form-item>
              <el-form-item label="人口类别" prop="peopleType" style="margin-left:15px;">
                <el-select v-model="formData.peopleType" placeholder="请选择" style="width: 93%">
                  <el-option label="常住人口" value="常住人口"></el-option>
                  <el-option label="从业人员" value="从业人员"></el-option>
                  <el-option label="重点人员" value="重点人员"></el-option>
                  <el-option label="监管对象" value="监管对象"></el-option>
                  <el-option label="吸毒人员" value="吸毒人员"></el-option>
                  <el-option label="上访人员" value="上访人员"></el-option>
                  <el-option label="精神病人员" value="精神病人员"></el-option>
                  <el-option label="流入人口" value="流入人口"></el-option>
                  <el-option label="流出人口" value="流出人口"></el-option>
                  <el-option label="维稳双联户长" value="维稳双联户长"></el-option>
                  <el-option label="楼栋长" value="楼栋长"></el-option>
                  <el-option label="单元长" value="单元长"></el-option>
                  <el-option label="小区长" value="小区长"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="是否吸毒" prop="isDrug">
                <el-select v-model="formData.isDrug" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="犯罪前科" prop="isKey">
                <el-select v-model="formData.isKey" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="监管对象" prop="isSupervise">
                <el-select v-model="formData.isSupervise" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="精神疾病" prop="isMental">
                <el-select v-model="formData.isMental" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="失踪人口" prop="isLost">
                <el-select v-model="formData.isLost" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="出境未归" prop="isOut">
                <el-select v-model="formData.isOut" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="上访人员" prop="isVisit">
                <el-select v-model="formData.isVisit" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="涉疆人员" prop="isXinjiang">
                <el-select v-model="formData.isXinjiang" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="重点人口" prop="isImportant">
                <el-select v-model="formData.isImportant" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="流动人口" prop="isFlow">
                <el-select v-model="formData.isFlow" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="民族" prop="nation">
                <el-input v-model="formData.nation" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="宗教信仰" prop="region" style="margin-left:15px;">
                <el-select v-model="formData.region" placeholder="请选择" style="width: 93%">
                  <el-option label="无宗教信仰" value="无宗教信仰"></el-option>
                  <el-option label="伊斯兰教" value="伊斯兰教"></el-option>
                  <el-option label="佛教" value="佛教"></el-option>
                  <el-option label="基督教" value="基督教"></el-option>
                  <el-option label="天主教" value="天主教"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="性别" prop="gender">
                <el-select v-model="formData.gender" placeholder="请选择" style="width: 93%">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="身高" prop="height">
                <el-input v-model="formData.height" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="血型" prop="bloodType">
                <el-select v-model="formData.bloodType" placeholder="请选择" style="width: 93%">
                  <el-option label="A" value="A"></el-option>
                  <el-option label="B" value="B"></el-option>
                  <el-option label="AB" value="AB"></el-option>
                  <el-option label="O" value="O"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="婚姻状态" prop="marriage">
                <el-select v-model="formData.marriage" placeholder="请选择" style="width: 93%">
                  <el-option label="未婚" value="未婚"></el-option>
                  <el-option label="已婚" value="已婚"></el-option>
                  <el-option label="离婚" value="离婚"></el-option>
                  <el-option label="初婚" value="初婚"></el-option>
                  <el-option label="复婚" value="复婚"></el-option>
                  <el-option label="再婚" value="再婚"></el-option>
                  <el-option label="丧偶" value="丧偶"></el-option>
                  <el-option label="未说明的婚姻状况" value="未说明的婚姻状况"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="出生日期" prop="identity1">
                <el-date-picker v-model="formData.identity1" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="文化程度" prop="calture" style="margin-left: -15px">
                <el-select v-model="formData.calture" placeholder="请选择" style="width: 93%">
                  <el-option label="未入学/文盲" value="未入学/文盲"></el-option>
                  <el-option label="小学" value="小学"></el-option>
                  <el-option label="初中" value="初中"></el-option>
                  <el-option label="中专" value="中专"></el-option>
                  <el-option label="高中" value="高中"></el-option>
                  <el-option label="大专" value="大专"></el-option>
                  <el-option label="本科" value="本科"></el-option>
                  <el-option label="硕士" value="硕士"></el-option>
                  <el-option label="博士" value="博士"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="政治面貌" prop="political">
                <el-select v-model="formData.political" placeholder="请选择" style="width: 93%">
                  <el-option label="中共党员" value="中共党员"></el-option>
                  <el-option label="群众" value="群众"></el-option>
                  <el-option label="其他党派" value="其他党派"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="联系电话" prop="tel">
                <el-input v-model="formData.tel" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="服兵役" prop="serveArmy" style="margin-left:15px;">
                <el-select v-model="formData.serveArmy" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="从业单位" prop="unitName">
                <el-input v-model="formData.unitName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="从业职业" prop="job" style="margin-left:15px;">
                <el-input v-model="formData.job" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="户口性质" prop="householdNature">
                <el-select v-model="formData.householdNature" placeholder="请选择" style="width: 93%">
                  <el-option label="非农业户口" value="非农业户口"></el-option>
                  <el-option label="农业户口" value="农业户口"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="户籍地址" prop="householdAddress">
                <el-input v-model="formData.householdAddress" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="迁入日期" prop="inDate">
                <el-date-picker v-model="formData.inDate" align="left" type="date"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="迁入原因" prop="inReason" style="margin-left: -15px">
                <el-input v-model="formData.inReason" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="迁入国家" prop="fromCountry">
                <el-input v-model="formData.fromCountry" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="迁入省市" prop="fromProvince" style="margin-left:15px;">
                <el-input v-model="formData.fromProvince" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="是否入户" prop="entryType">
                <el-select v-model="formData.entryType" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="海外关系" prop="overseasRelation">
                <el-select v-model="formData.overseasRelation" placeholder="请选择" style="width: 93%">
                  <el-option label="是" value="是"></el-option>
                  <el-option label="否" value="否"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="父亲姓名" prop="fatherName">
                <el-input v-model="formData.fatherName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="身份证号" prop="fatherIdentity" style="margin-left:15px;">
                <el-input v-model="formData.fatherIdentity" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="母亲姓名" prop="motherName">
                <el-input v-model="formData.motherName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="身份证号" prop="motherIdentity" style="margin-left:15px;">
                <el-input v-model="formData.motherIdentity" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="配偶姓名" prop="mateName">
                <el-input v-model="formData.mateName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="身份证号" prop="mateIdentity" style="margin-left:15px;">
                <el-input v-model="formData.mateIdentity" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
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
import {
  deletePeopleBase,
  getAddressById,
  getPeopleBaseAll,
  insertPeopleBase,
  updatePeopleBase,
  batchDeletePeopleBase
} from "../api/api";
import AddressTree from "../utils/components/address-tree";

export default {
  name: "real-people",
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
      multipleSelection: [],
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileList: [],
      imagePreview: '',
      addName: "",
      rules: {
        identity: [{required: true, message: '请输入', trigger: 'blur'}, {
          message: '身份证长度不足',
          trigger: 'blur',
          min: 16
        }],
        identity1: [{required: true, message: '请输入', trigger: 'blur'}],
        tel: [{required: true, message: '请输入', trigger: 'blur'}],
        motherIdentity: [{required: true, message: '请输入', trigger: 'blur'}],
        motherName: [{required: true, message: '请输入', trigger: 'blur'}],
        nation: [{required: true, message: '请输入', trigger: 'blur'}],
        mateIdentity: [{required: true, message: '请输入', trigger: 'blur'}],
        mateName: [{required: true, message: '请输入', trigger: 'blur'}],
        height: [{required: true, message: '请输入', trigger: 'blur'}],
        gender: [{required: true, message: '请输入', trigger: 'blur'}],
        calture: [{required: true, message: '请输入', trigger: 'blur'}],
        name: [{required: true, message: '请输入', trigger: 'blur'}],
        bloodType: [{required: true, message: '请输入', trigger: 'blur'}],
        region: [{required: true, message: '请输入', trigger: 'blur'}],
        political: [{required: true, message: '请输入', trigger: 'blur'}],
        onceName: [{required: true, message: '请输入', trigger: 'blur'}],
        unitName: [{required: true, message: '请输入', trigger: 'blur'}],
        job: [{required: true, message: '请输入', trigger: 'blur'}],
        fatherIdentity: [{required: true, message: '请输入', trigger: 'blur'}],
        fatherName: [{required: true, message: '请输入', trigger: 'blur'}],
        householdAddress: [{required: true, message: '请输入', trigger: 'blur'}],
        householdNature: [{required: true, message: '请输入', trigger: 'blur'}],
        marriage: [{required: true, message: '请输入', trigger: 'blur'}],
        fromCountry: [{required: true, message: '请输入', trigger: 'blur'}],
        fromProvince: [{required: true, message: '请输入', trigger: 'blur'}],
        inDate: [{required: true, message: '请输入', trigger: 'blur'}],
        inReason: [{required: true, message: '请输入', trigger: 'blur'}],
        serveArmy: [{required: true, message: '请输入', trigger: 'blur'}],
        overseasRelation: [{required: true, message: '请输入', trigger: 'blur'}],
        peopleType: [{required: true, message: '请输入', trigger: 'blur'}],
        entryType: [{required: true, message: '请输入', trigger: 'blur'}],
        isDrug: [{required: true, message: '请输入', trigger: 'blur'}],
        isFlow: [{required: true, message: '请输入', trigger: 'blur'}],
        isImportant: [{required: true, message: '请输入', trigger: 'blur'}],
        isLost: [{required: true, message: '请输入', trigger: 'blur'}],
        isOut: [{required: true, message: '请输入', trigger: 'blur'}],
        isMental: [{required: true, message: '请输入', trigger: 'blur'}],
        isSupervise: [{required: true, message: '请输入', trigger: 'blur'}],
        isVisit: [{required: true, message: '请输入', trigger: 'blur'}],
        isXinjiang: [{required: true, message: '请输入', trigger: 'blur'}],
        isKey: [{required: true, message: '请输入', trigger: 'blur'}],
        communityCode: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        ppId: "",
        addId: "",
        identity: "",
        identity1: "1990-01-01",
        tel: "",
        motherIdentity: "无",
        motherName: "无",
        nation: "汉",
        mateIdentity: "无",
        mateName: "无",
        height: "170",
        communityCode: "",
        gender: "男",
        calture: "高中",
        name: "",
        bloodType: "A",
        region: "无宗教信仰",
        political: "群众",
        onceName: "无",
        unitName: "无",
        job: "无",
        fatherIdentity: "无",
        fatherName: "无",
        householdAddress: "无",
        householdNature: "非农业户口",
        marriage: "未婚",
        fromCountry: "无",
        fromProvince: "无",
        inDate: "1990-01-01",
        inReason: "无",
        serveArmy: "否",
        overseasRelation: "否",
        peopleType: "常住人口",
        imgurl: "",
        entryType: "是",
        isDrug: "否",
        isFlow: "否",
        isImportant: "否",
        isLost: "否",
        isMental: "否",
        isOut: "否",
        isSupervise: "否",
        isVisit: "否",
        isXinjiang: "否",
        isKey: "否",
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
    getRealPeopleData() {
      this.pictLoading = true;
      getPeopleBaseAll().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.ppId;
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
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.imgurl;
        window.addressId = this.currentRow.addId;
        let params = {
          addId: this.currentRow.addId
        };
        getAddressById(params).then(res => {
          this.addName = res.data.addName;
          this.formData.communityCode = res.data.pid;
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
            ppId: this.currentId,
            imgurl: this.currentRow.imgurl
          };
          deletePeopleBase(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getRealPeopleData();
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
          batchDeletePeopleBase(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getRealPeopleData();
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
            this.formData.addId = window.addressId;
            this.formData.identity1 = new Date(this.formData.identity1).toLocaleDateString().replace(/\//g, '-');
            this.formData.inDate = new Date(this.formData.inDate).toLocaleDateString().replace(/\//g, '-');
            let params = this.formData;
            let formData = new FormData();
            this.fileList.map(item => {
              formData.append('files', item.raw);
            });
            formData.append('ppId', params.ppId);
            formData.append('addId', params.addId);
            formData.append('identity', params.identity);
            formData.append('identity1', params.identity1);
            formData.append('tel', params.tel);
            formData.append('motherIdentity', params.motherIdentity);
            formData.append('motherName', params.motherName);
            formData.append('nation', params.nation);
            formData.append('mateIdentity', params.mateIdentity);
            formData.append('mateName', params.mateName);
            formData.append('height', params.height);
            formData.append('communityCode', params.communityCode);
            formData.append('gender', params.gender);
            formData.append('calture', params.calture);
            formData.append('name', params.name);
            formData.append('bloodType', params.bloodType);
            formData.append('region', params.region);
            formData.append('political', params.political);
            formData.append('onceName', params.onceName);
            formData.append('unitName', params.unitName);
            formData.append('job', params.job);
            formData.append('fatherIdentity', params.fatherIdentity);
            formData.append('fatherName', params.fatherName);
            formData.append('householdAddress', params.householdAddress);
            formData.append('householdNature', params.householdNature);
            formData.append('marriage', params.marriage);
            formData.append('fromCountry', params.fromCountry);
            formData.append('fromProvince', params.fromProvince);
            formData.append('inDate', params.inDate);
            formData.append('inReason', params.inReason);
            formData.append('serveArmy', params.serveArmy);
            formData.append('overseasRelation', params.overseasRelation);
            formData.append('peopleType', params.peopleType);
            formData.append('entryType', params.entryType);
            formData.append('isDrug', params.isDrug);
            formData.append('isFlow', params.isFlow);
            formData.append('isImportant', params.isImportant);
            formData.append('isLost', params.isLost);
            formData.append('isMental', params.isMental);
            formData.append('isOut', params.isOut);
            formData.append('isSupervise', params.isSupervise);
            formData.append('isVisit', params.isVisit);
            formData.append('isXinjiang', params.isXinjiang);
            formData.append('isKey', params.isKey);
            formData.append('imgurl', params.imgurl);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePeopleBase(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getRealPeopleData();
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
                let params = {
                  addId: window.addressId
                };
                getAddressById(params).then(res => {
                  formData.append('communityCode', res.data.pid);
                  insertPeopleBase(formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                      this.backTable();
                      this.getRealPeopleData();
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
          || ~item.peopleType.indexOf(val)
          || ~item.identity.indexOf(val)
          || ~item.nation.indexOf(val)
          || ~item.gender.indexOf(val)
          || ~item.tel.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getRealPeopleData();
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
</style>
