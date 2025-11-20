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
                  :default-sort="{prop: 'funcSrc', order: 'ascending'}" @row-click="rowClick" row-key="funcId"
                  :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
          <el-table-column label="子平台" prop="funcSrc" sortable></el-table-column>
          <el-table-column label="链接路径" prop="funcUrl" sortable></el-table-column>
          <el-table-column label="UI图标" prop="funcIcon" sortable>
            <template slot-scope="scope">
              <font-awesome-icon :icon="[scope.row.funcIconType, scope.row.funcIcon]" fixed-width></font-awesome-icon>
            </template>
          </el-table-column>
          <el-table-column label="默认名称" prop="funcDefaultName" sortable></el-table-column>
          <el-table-column label="类型" prop="funcType" sortable></el-table-column>
          <el-table-column label="物联设备" prop="funcIotName" sortable></el-table-column>
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
            <el-form-item label="子平台" prop="funcSrc">
              <el-select v-model="formData.funcSrc" placeholder="请选择" @change="getFuncType">
                <el-option label="应用前台" value="应用前台"></el-option>
                <el-option label="数据中台" value="数据中台"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="链接路径" prop="funcUrl">
              <el-input v-model="formData.funcUrl" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="默认名称" prop="funcDefaultName">
              <el-input v-model="formData.funcDefaultName" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="类型" prop="funcType">
              <el-select v-model="formData.funcType" placeholder="请选择">
                <el-option label="必选" value="必选"></el-option>
                <el-option label="可选" value="可选"></el-option>
                <el-option label="不可选" value="不可选"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="菜单级别" prop="funcLevel">
              <el-select v-model="formData.funcLevel" placeholder="请选择" @change="setPidOption()">
                <el-option label="一级" value="一级"></el-option>
                <el-option label="二级" value="二级"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="父级" prop="funcPid">
              <el-select v-model="formData.funcPid" placeholder="请先选择菜单级别">
                <el-option v-for="item in pidArr" :key="item.funcId" :label="item.funcDefaultName"
                           :value="item.funcId"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="物联设备" prop="funcIotName">
              <el-input v-model="formData.funcIotName" placeholder="请填写"></el-input>
            </el-form-item>
            <!--<el-form-item label="设备照片" prop="funcIotImg">-->
            <!--<el-input v-model="formData.funcIotImg" placeholder="请填写您的联系电话"></el-input>-->
            <!--</el-form-item>-->
            <el-form-item label="UI标签" prop="funcIcon">
              <el-input v-model="formData.funcIcon" placeholder="请填写"></el-input>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
        <div class="my-card-body" :style="{height: cardBodyEquipHeight}">
          <el-card :id="item.iconId" class="equip-card" v-for="item in iconArr" :key="item.iconId"
                   :body-style="{ padding: '0px' }">
            <div class="func-icon" @click="selectIcon(item.iconId)">
              <font-awesome-icon :icon="[item.iconType, item.iconId]" fixed-width></font-awesome-icon>
            </div>
            <div class="icon-text" @click="selectIcon(item.iconId)">{{item.iconText}}</div>
          </el-card>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import {deleteFunc, getFunc, insertFunc, updateFunc, getFuncByLevel} from "../api/api";
  import {iconArr} from "../js/icon";

  export default {
    name: "sys-func",
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
          funcSrc: [{required: true, message: '请输入', trigger: 'blur'}],
          funcUrl: [{required: true, message: '请输入', trigger: 'blur'}],
          funcDefaultName: [{required: true, message: '请输入', trigger: 'blur'}],
          funcType: [{required: true, message: '请输入', trigger: 'blur'}],
          funcIotName: [{required: true, message: '请输入', trigger: 'blur'}],
          funcLevel: [{required: true, message: '请输入', trigger: 'blur'}],
          funcPid: [{required: true, message: '请输入', trigger: 'blur'}],
          funcIcon: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          funcId: '',
          funcSrc: '应用前台',
          funcUrl: '无',
          funcDefaultName: '',
          funcType: '',
          funcIotName: '无',
          funcIotImg: '',
          funcLevel: '',
          funcPid: '',
          funcIcon: '',
        },
        pidArr: [],
        iconArr: [],
        preId: ""
      }
    },
    methods: {
      getFuncData() {
        this.pictLoading = true;
        getFunc().then(res => {
          this.queryResult = res.data;
          let tempTabelData = [];
          res.data.map(item => {
            if (item.funcLevel === "一级") {
              let icon = this.iconArr.find(icon => {
                return icon.iconId === item.funcIcon;
              });
              item.funcIconType = icon.iconType;
              item.children = [];
              tempTabelData.push(item);
            }
          });
          res.data.map(item => {
            for (let i = 0; i < tempTabelData.length; i++) {
              if (item.funcPid === tempTabelData[i].funcId) {
                let icon = this.iconArr.find(icon => {
                  return icon.iconId === item.funcIcon;
                });
                item.funcIconType = icon.iconType;
                tempTabelData[i].children.push(item);
                // this.tableDate.push(item);
                break;
              }
            }
          });
          this.tableDate = tempTabelData;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.funcId;
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
          this.getFuncType();
          document.getElementById(this.formData.funcIcon).style.backgroundColor = '#139cec85';
          this.preId = this.formData.funcIcon;
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
              funcId: this.currentId
            };
            deleteFunc(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getFuncData();
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
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateFunc(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getFuncData();
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
                insertFunc(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getFuncData();
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
        if (this.preId !== "") {
          document.getElementById(this.preId).style.backgroundColor = '#FFF';
        }
        this.preId = "";
      },
      setPidOption() {
        if (this.formData.funcLevel === "二级") {
          let params = {
            "funcLevel": "一级",
            "funcSrc": this.formData.funcSrc
          };
          getFuncByLevel(params).then(res => {
            this.formData.funcPid = "";
            this.pidArr = res.data;
          });
        } else {
          this.formData.funcPid = "0";
          this.pidArr = [];
        }
      },
      getFuncType() {
        if (this.formData.funcLevel === "二级") {
          let params = {
            "funcLevel": "一级",
            "funcSrc": this.formData.funcSrc
          };
          getFuncByLevel(params).then(res => {
            this.pidArr = res.data;
          });
        }
      },
      selectIcon(iconId) {
        if (this.preId !== "") {
          document.getElementById(this.preId).style.backgroundColor = '#FFF';
        }
        document.getElementById(iconId).style.backgroundColor = '#139cec85';
        this.formData.funcIcon = iconId;
        this.preId = iconId;
      },
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.funcSrc.indexOf(val)
            || ~item.funcDefaultName.indexOf(val)
            || ~item.funcType.indexOf(val)
            || ~item.funcUrl.indexOf(val))
        );
      }
    },
    mounted() {
      this.iconArr = iconArr;
      this.getFuncData();
    },
    computed: {
      viewerHeight: function () {
        return (window.innerHeight - 130) + 'px';
      },
      cardBodyHeight: function () {
        return (window.innerHeight - 130 - 90) + 'px';
      },
      cardBodyEquipHeight: function () {
        return (window.innerHeight - 130 - 25) + 'px';
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
  }

  .left-card {
    float: left;
  }

  .right-card {
    float: right;
  }

  .equip-card {
    width: 90px;
    height: 100px;
    margin: 5px;
    cursor: pointer;
    border-radius: 6px;
    float: left;
    text-align: center;
  }

  .func-icon {
    padding: 10px 0 3px 0;
    font-size: 25px
  }

  .icon-text {
    padding: 2px 0 8px 0;
    font-size: 16px
  }
</style>
