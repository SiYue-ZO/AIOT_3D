<template>
  <el-card>
    <div slot="header" class="card-header">
      <div v-show="isTableShow">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">详 情
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
      </div>
      <div v-show="!isTableShow">
        <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
      </div>
    </div>
    <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
      <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                @selection-change="handleSelectionChange" ref="multipleTable" row-key="accessCarId"
                :default-sort="{prop: 'accessTime', order: 'descending'}" @row-click="rowClick">
        <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
        <el-table-column label="抓拍相机" prop="cameraId" sortable></el-table-column>
        <el-table-column label="车辆牌照" prop="userId" sortable></el-table-column>
        <el-table-column label="抓拍类型" prop="accessType" sortable></el-table-column>
        <el-table-column label="抓拍时间" prop="accessTime" sortable></el-table-column>
        <el-table-column label="序列号" prop="serialNumber" sortable></el-table-column>
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
        <el-form-item label="抓拍相机" prop="cameraId">
          <el-input v-model="formData.cameraId" placeholder="" readonly></el-input>
        </el-form-item>
        <el-form-item label="序列号" prop="serialNumber">
          <el-input v-model="formData.serialNumber" placeholder="" readonly></el-input>
        </el-form-item>
        <el-form-item label="抓拍时间" prop="accessTime">
          <el-input v-model="formData.accessTime" placeholder="" readonly></el-input>
        </el-form-item>
        <el-form-item label="车辆类型" prop="accessType">
          <el-select v-model="formData.accessType" placeholder="" readonly>
            <el-option label="禁止车辆" value="0"></el-option>
            <el-option label="内部车辆" value="1"></el-option>
            <el-option label="外来车辆" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车辆牌照" prop="userId">
          <el-input v-model="formData.userId" placeholder="" readonly></el-input>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
  import {deleteAccessCar, getAccessCar, batchDeleteAccessCar} from "../api/api";

  export default {
    name: "access-car",
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
          serialNumber: [{required: true, message: '请输入', trigger: 'blur'}],
          cameraId: [{required: true, message: '请输入', trigger: 'blur'}],
          accessType: [{required: true, message: '请输入', trigger: 'blur'}],
          accessTime: [{required: true, message: '请输入', trigger: 'blur'}],
          userId: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          accessCarId: '',
          serialNumber: '',
          cameraId: '',
          accessType: '',
          accessTime: '',
          image: '',
          userId: '',
        }
      }
    },
    methods: {
      getAccessCarData() {
        this.pictLoading = true;
        getAccessCar().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.accessCarId;
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
              accessCarId: this.currentId
            };
            deleteAccessCar(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getAccessCarData();
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
            batchDeleteAccessCar(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getAccessCarData();
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
      backTable() {
        this.isTableShow = true;
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.cameraId.indexOf(val)
            || ~item.userId.indexOf(val)
            || ~item.accessType.indexOf(val)
            || ~item.accessTime.indexOf(val)
            || ~item.serialNumber.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getAccessCarData();
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
