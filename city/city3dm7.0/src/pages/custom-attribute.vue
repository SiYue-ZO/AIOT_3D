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
                :default-sort="{prop: 'coverageName', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="字段名称" prop="attrName" sortable></el-table-column>
        <el-table-column label="字段类型" prop="type" sortable></el-table-column>
        <el-table-column label="初始值" prop="normalValue" sortable></el-table-column>
        <el-table-column label="可选项" prop="option" sortable></el-table-column>
        <el-table-column label="所属图层" prop="coverageName" sortable></el-table-column>
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
        <el-form-item label="字段名称" prop="attrName">
          <el-input v-model="formData.attrName" placeholder="请填写参数名称"></el-input>
        </el-form-item>
        <el-form-item label="类别" prop="type">
          <el-select v-model="formData.type" placeholder="请选择分类" @change="changeType">
            <el-option label="文本" value="文本"></el-option>
            <el-option label="下拉列表" value="下拉列表"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="初始值" prop="nomarlValue" v-show="!isSelectShow">
          <el-input v-model="formData.normalValue" placeholder="请填写"></el-input>
        </el-form-item>
        <el-form-item label="添加选项" prop="newOption" v-show="isSelectShow">
          <el-input v-model="formData.newOption" placeholder="请填写" @change="addOption"></el-input>
        </el-form-item>
        <el-form-item label="选项与初始值" prop="nomarlValue" v-show="isSelectShow">
          <el-select v-model="formData.normalValue" placeholder="请选择" default-first-option>
            <el-option v-for="item in optionArr" :key="item" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属图层" prop="coverageId">
          <el-select v-model="formData.coverageId" placeholder="请选择">
            <el-option v-for="item in coverageArr" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
  import {deleteAttribute, getAttribute, getCoverage, insertAttribute, updateAttribute} from "../api/api";

  export default {
    name: "custom-attribute",
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
        optionArr: [],
        coverageArr: [],
        isSelectShow: false,
        rules: {
          attrName: [{required: true, message: '请输入', trigger: 'blur'}],
          type: [{required: true, message: '请输入', trigger: 'blur'}],
          coverageId: [{required: true, message: '请输入', trigger: 'blur'}],
          orderNum: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          id: '',
          attrName: '',
          type: '文本',
          option: '',
          normalValue: '',
          coverageId: '',
          selectNum: '',
          orderNum: '',
          newOption: '',
          coverageName: ''
        },
      }
    },
    methods: {
      getAttributeData() {
        this.pictLoading = true;
        getCoverage().then(res => {
          this.coverageArr = res.data;
          getAttribute().then(res => {
            this.queryResult = res.data;
            this.tableDate = res.data;
            this.pictLoading = false;
          });
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.id;
        this.currentRow = row;
      },
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      addOption() {
        this.optionArr.push(this.formData.newOption);
        this.formData.normalValue = this.formData.newOption;
        this.formData.newOption = '';
        this.$message({
          message: '下拉列表添加成功！',
          type: 'success'
        });
      },
      changeType() {
        this.isSelectShow = this.formData.type === "下拉列表";
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
          this.isSelectShow = this.currentRow.type === "下拉列表";
          this.optionArr = this.currentRow.option.split("&");
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
              id: this.currentId
            };
            deleteAttribute(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getAttributeData();
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
            let _this = this;
            this.optionArr.map(item => {
              _this.formData.option += item + "&";
            });
            _this.formData.option.substring(0, _this.formData.option.length - 1);
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateAttribute(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getAttributeData();
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
                insertAttribute(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getAttributeData();
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
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.attrName.indexOf(val)
            || ~item.type.indexOf(val)
            || ~item.normalValue.indexOf(val)
            || ~item.coverageName.indexOf(val))
        );
      }
    },
    mounted() {
      this.getAttributeData();
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

  .my-form {
    width: 800px;
  }

  .my-card-body {
    overflow-y: auto;
  }
</style>
