<template>
  <el-card>
    <div slot="header" class="card-header">
      <div v-show="isTableShow">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
      </div>
      <div v-show="!isTableShow">
        <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
          确 定
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
          重 置
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
      </div>
    </div>
    <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
      <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                @selection-change="handleSelectionChange" ref="multipleTable" row-key="checkId"
                :default-sort="{prop: 'checkTime', order: 'descending'}" @row-click="rowClick">
        <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
        <el-table-column label="管段" prop="checkAdd" sortable></el-table-column>
        <el-table-column label="巡查人" prop="checkMan" sortable></el-table-column>
        <el-table-column label="巡查时间" prop="checkTime" sortable></el-table-column>
        <el-table-column label="巡查结果" prop="checkResult" sortable></el-table-column>
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
        <div class="row_display">
          <el-form-item label="巡查管段" prop="checkAdd">
            <el-input v-model="formData.checkAdd" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="巡查人" prop="checkMan" style="margin-left: 15px">
            <el-input v-model="formData.checkMan" placeholder="请填写"></el-input>
          </el-form-item>
        </div>
        <div class="row_display">
          <el-form-item label="巡查时间" prop="checkTime">
            <el-date-picker v-model="formData.checkTime" type="date" placeholder="请选择日期"
                            style="width: 87%"></el-date-picker>
          </el-form-item>
        </div>
        <el-form-item label="巡查结果" prop="checkResult">
          <el-input v-model="formData.checkResult" placeholder="请填写" style="width: 90%"></el-input>
        </el-form-item>
        <div class="row_display">
          <el-form-item label="维修人" prop="repairMan">
            <el-input v-model="formData.repairMan" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="维修时间" prop="repairTime" style="margin-left: 15px">
            <el-date-picker v-model="formData.repairTime" type="date" placeholder="请选择日期"
                            style="width: 87%"></el-date-picker>
          </el-form-item>
        </div>
        <el-form-item label="维修结果" prop="repairResult">
          <el-input v-model="formData.repairResult" placeholder="请填写" style="width: 90%"></el-input>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
  import {
    deletePipelineCheck,
    getPipelineCheck,
    insertPipelineCheck,
    updatePipelineCheck,
    batchDeletePipelineCheck
  } from "../api/api";

  export default {
    name: "net-pipeline-check",
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
        rules: {
          checkAdd: [{required: true, message: '请输入', trigger: 'blur'}],
          checkMan: [{required: true, message: '请输入', trigger: 'blur'}],
          checkTime: [{required: true, message: '请输入', trigger: 'blur'}],
          checkResult: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          checkId: '',
          checkAdd: '',
          checkMan: '',
          checkTime: '2020-10-25',
          checkResult: '',
          repairMan: '',
          repairTime: '2020-10-25',
          repairResult: '',
        },
      }
    },
    methods: {
      getPipelineCheckData() {
        this.pictLoading = true;
        getPipelineCheck().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.checkId;
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
      editData() {
        if (this.currentId !== '') {
          this.isTableShow = false;
          this.isEdit = true;
          this.formData = Object.assign(this.formData, this.currentRow);
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
              checkId: this.currentId
            };
            deletePipelineCheck(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getPipelineCheckData();
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
            batchDeletePipelineCheck(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getPipelineCheckData();
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
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePipelineCheck(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getPipelineCheckData();
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
                insertPipelineCheck(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getPipelineCheckData();
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
          item => (~item.checkAdd.indexOf(val)
            || ~item.checkMan.indexOf(val)
            || ~item.checkTime.indexOf(val)
            || ~item.checkResult.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getPipelineCheckData();
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

  .my-form {
    width: 655px;
  }

  .my-card-body {
    overflow-y: auto;
    font-size: 15px !important;
  }

  .row_display {
    display: flex;
  }

  .search-input {
    width: 400px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
