<template>
  <el-card>
    <div slot="header" class="card-header">
      <div v-show="isTableShow">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
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
                :default-sort="{prop: 'userName', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="用户名" prop="userName" sortable></el-table-column>
        <el-table-column label="登录名" prop="loginName" sortable></el-table-column>
        <el-table-column label="用户组织" prop="userDep" sortable></el-table-column>
        <el-table-column label="联系电话" prop="userTel" sortable></el-table-column>
        <el-table-column label="所属应用" prop="sysApp.appName" sortable></el-table-column>
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
        <el-form-item label="真实姓名" prop="userName">
          <el-input v-model="formData.userName" placeholder="请填写用户真实姓名"></el-input>
        </el-form-item>
        <el-form-item label="登录名" prop="loginName">
          <el-input v-model="formData.loginName" placeholder="请填写登录名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input v-model="formData.pwd" placeholder="请填写密码" show-password></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="pwdcheck">
          <el-input v-model="formData.pwdcheck" placeholder="请确认密码" show-password></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="roleId">
          <el-select v-model="formData.roleId" placeholder="请选择用户角色">
            <el-option v-for="item in roleArr" :key="item.roleId" :label="item.roleName"
                       :value="item.roleId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户组织" prop="userDep">
          <el-input v-model="formData.userDep" placeholder="请填写用户所属组织"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="userTel">
          <el-input v-model="formData.userTel" placeholder="请填写您的联系电话"></el-input>
        </el-form-item>
        <el-form-item label="应用名称" prop="appId">
          <el-select v-model="formData.appId" placeholder="请选择所属应用">
            <el-option v-for="item in appArr" :key="item.appId" :label="item.appName"
                       :value="item.appId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="有效时间" prop="deadLine">
          <el-input v-model="formData.deadLine" placeholder="天数"></el-input>
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker v-model="formData.createTime" align="left" type="datetime"
                          placeholder="选择日期时间" :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
import {deleteUser, getUser, insertUser, updateUser, getRole, getApp} from "../api/api";

export default {
  name: "sys-user",
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
      rules: {
        loginName: [{required: true, message: '请输入', trigger: 'blur'}],
        userName: [{required: true, message: '请输入', trigger: 'blur'}],
        pwd: [{required: true, message: '请输入', trigger: 'blur'}],
        pwdcheck: [{required: true, message: '请输入', trigger: 'blur'}],
        roleId: [{required: true, message: '请输入', trigger: 'blur'}],
        appId: [{required: true, message: '请输入', trigger: 'blur'}],
        deadLine: [{required: true, message: '请输入', trigger: 'blur'}],
        createTime: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        userId: '',
        loginName: '',
        userName: '',
        pwd: '',
        pwdcheck: '',
        userDep: '',
        userTel: '',
        role: '',
        roleId: '',
        app: '',
        appId: '',
        deadLine: '',
        createTime: new Date()
      },
      roleArr: [],
      appArr: [],
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
    getUserData() {
      this.pictLoading = true;
      getUser().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    setRoleApp() {
      getRole().then(res => {
        this.roleArr = res.data;
      });
      getApp().then(res => {
        this.appArr = res.data;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.userId;
      this.currentRow = row;
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    addData(formName) {
      this.isTableShow = false;
      this.isEdit = false;
      this.$refs[formName].resetFields();
      this.setRoleApp();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.currentRow.pwdcheck = this.currentRow.pwd;
        this.currentRow.roleId = this.currentRow.sysRole.roleId;
        this.currentRow.appId = this.currentRow.sysApp.appId;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.setRoleApp();
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
            userId: this.currentId
          };
          deleteUser(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getUserData();
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
      if (this.formData.pwd === this.formData.pwdcheck) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.formData.role = this.formData.roleId;
            this.formData.app = this.formData.appId;
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateUser(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getUserData();
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
                insertUser(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getUserData();
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
      } else {
        this.$message({
          message: '密码不同，请再次确认密码！',
          type: 'error'
        });
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    backTable() {
      this.isTableShow = true;
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.userName.indexOf(val)
          || ~item.userDep.indexOf(val)
          || ~item.userTel.indexOf(val))
      );
    }
  },
  mounted() {
    this.getUserData();
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
