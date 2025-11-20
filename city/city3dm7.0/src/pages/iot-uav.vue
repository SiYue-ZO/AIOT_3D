<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline" @click="addData('formData')">
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
                  :default-sort="{prop: 'uavType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="名称" prop="uavName" sortable></el-table-column>
          <el-table-column label="类型" prop="uavType" sortable></el-table-column>
          <el-table-column label="品牌型号" prop="uavModel" sortable></el-table-column>
          <el-table-column label="权属" prop="uavProperty" sortable></el-table-column>
          <el-table-column label="购买时间" prop="uavDate" sortable></el-table-column>
          <el-table-column label="电池容量" prop="uavElec" sortable></el-table-column>
          <el-table-column label="相机类型" prop="uavCamType" sortable></el-table-column>
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
    <el-card v-show="!isTableShow">
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
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px" class="my-form">
          <el-form-item label="名称" prop="uavName">
            <el-input v-model="formData.uavName" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="类型" prop="uavType">
            <el-select v-model="formData.uavType" placeholder="请选择">
              <el-option label="摄影" value="摄影"></el-option>
              <el-option label="测量" value="测量"></el-option>
              <el-option label="侦查" value="侦查"></el-option>
              <el-option label="查打一体" value="查打一体"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="品牌型号" prop="uavModel">
            <el-input v-model="formData.uavModel" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="权属" prop="uavProperty">
            <el-input v-model="formData.uavProperty" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="购置时间" prop="uavDate">
            <el-date-picker v-model="formData.uavDate" type="date" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="相机类型" prop="uavCamType">
            <el-select v-model="formData.uavCamType" placeholder="请选择">
              <el-option label="摄影测量" value="摄影测量"></el-option>
              <el-option label="激光雷达" value="激光雷达"></el-option>
              <el-option label="热红外" value="热红外"></el-option>
              <el-option label="光电吊舱" value="光电吊舱"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="电池容量" prop="uavElec">
            <el-input v-model="formData.uavElec" placeholder="请填写"></el-input>
          </el-form-item>
          <el-form-item label="视频地址" prop="uavUrl">
            <el-input v-model="formData.uavUrl" placeholder="请填写"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
import {deleteUav, getAllandUavById, getUav, insertUav, updateUav} from "../api/api";

export default {
  name: "iot-uav",
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
        uavName: [{required: true, message: '请输入', trigger: 'blur'}],
        uavModel: [{required: true, message: '请输入', trigger: 'blur'}],
        uavUrl: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        uavId: '',
        uavName: '',
        uavType: '',
        uavModel: '',
        uavProperty: '',
        uavDate: '2022-01-01',
        uavElec: '',
        uavCamType: '',
        uavUrl: '',
      }
    }
  },
  methods: {
    getUavData() {
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getUav().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandUavById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleUav.map(item => {
            resultArr.push(item.uav);
          });
          this.queryResult = resultArr;
          this.tableDate = resultArr;
          this.pictLoading = false;
        });
      }
    },
    rowClick(row, column, event) {
      this.currentId = row.uavId;
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
            uavId: this.currentId,
          };
          deleteUav(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getUavData();
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
          let params = {
            "uav": this.formData,
            "sysRoleUav": {
              "roleId": localStorage.getItem("roleId")
            }
          };
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateUav(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getUavData();
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
              insertUav(params).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getUavData();
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
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.uavName.indexOf(val)
          || ~item.uavType.indexOf(val)
          || ~item.uavModel.indexOf(val)
          || ~item.uavProperty.indexOf(val)
          || ~item.uavDate.indexOf(val)
          || ~item.uavElec.indexOf(val)
          || ~item.uavCamType.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getUavData();
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

.my-form {
  width: 800px;
}
</style>
