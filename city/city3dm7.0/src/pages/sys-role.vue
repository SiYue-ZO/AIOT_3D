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
                :default-sort="{prop: 'roleName', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="权限名" prop="roleName" width="200" sortable></el-table-column>
        <el-table-column label="功能" prop="roleFuncStr" sortable></el-table-column>
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
        <el-form-item label="权限名称" prop="roleName">
          <el-input v-model="formData.roleName" placeholder="请填写"></el-input>
        </el-form-item>
        <el-form-item label="" prop="roleFunc">
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilterFunc"
                    class="search-input"
                    style="margin-bottom: 20px"></el-input>
          <el-table class="result-table" ref="multipleTable"
                    :data="tableDateFunc.slice((currentPageFunc-1)*pagesizeFunc,currentPageFunc*pagesizeFunc)"
                    v-loading="pictLoadingFunc" element-loading-background="rgba(230, 230, 230, 0.5)"
                    element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                    :stripe="true" :fit="true" size="medium"
                    :default-sort="{prop: 'roleFuncOrder', order: 'ascending'}" border
                    @selection-change="handleSelectionChange" row-key="funcId"
                    :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
          >
            <el-table-column type="selection" :reserve-selection="true" width="39"></el-table-column>
            <el-table-column label="子平台" prop="funcSrc" width="120" sortable></el-table-column>
            <el-table-column label="链接路径" prop="funcUrl" width="150"></el-table-column>
            <el-table-column label="默认名称" prop="funcDefaultName" width="150"></el-table-column>
            <el-table-column label="类型" prop="funcType" width="70"></el-table-column>
            <el-table-column label="物联设备" prop="funcIotName"></el-table-column>
            <el-table-column label="自定义名称" prop="funcName" width="150"></el-table-column>
            <el-table-column label="层级结构" prop="roleFuncName" width="120"></el-table-column>
            <el-table-column label="排序" prop="roleFuncOrder" width="75" sortable></el-table-column>
            <el-table-column label="配置" width="75">
              <template slot-scope="scope">
                <el-button class="table-button" :type="tableBtnType(scope.row.funcLevel)" icon="el-icon-s-tools"
                           @click="handleEdit(scope.$index, scope.row)"></el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination
            class="my-pagination"
            @size-change="handleSizeChangeFunc"
            @current-change="handleCurrentChangeFunc"
            :current-page="currentPageFunc"
            :page-sizes="[5, 10, 20, 40]"
            :page-size="pagesizeFunc"
            :pager-count="5"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableDateFunc.length">
          </el-pagination>
        </el-form-item>
        <el-form-item label="配置数据" prop="roleData">
          <div class="row_display">
            <ztree ref="tilesTree" :nodes="nodes" :setting="setting" class="tree-group"/>
            <ztree ref="tilesTreeBim" :nodes="nodesBim" :setting="settingBim" class="tree-group"/>
            <ztree ref="tilesTreeCar" :nodes="nodesCar" :setting="settingCar" class="tree-group"/>
            <ztree ref="tilesTreePolice" :nodes="nodesPolice" :setting="settingPolice" class="tree-group"/>
          </div>
          <div class="row_display">
            <ztree ref="tilesTreeNet" :nodes="nodesNet" :setting="settingNet" class="tree-group"/>
            <ztree ref="tilesTreeDevice" :nodes="nodesDevice" :setting="settingDevice" class="tree-group"/>
            <ztree ref="tilesTreeSecurity" :nodes="nodesSecurity" :setting="settingSecurity" class="tree-group"/>
            <ztree ref="tilesTreeUav" :nodes="nodesUav" :setting="settingUav" class="tree-group"/>
          </div>
          <div class="row_display">
            <ztree ref="tilesTreeVideo" :nodes="nodesVideo" :setting="settingVideo" class="tree-group"/>
            <ztree ref="tilesTreeVideoIndoor" :nodes="nodesVideoIndoor" :setting="settingVideoIndoor"
                   class="tree-group"/>
          </div>
        </el-form-item>
      </el-form>
    </div>
    <el-dialog title="配置该权限下的功能名和层级结构" :visible.sync="dialogTableVisible" width="30%">
      <el-form ref="dialogForm" :model="dialogForm">
        <el-form-item label="自定义名称">
          <el-input v-model="dialogForm.name"></el-input>
        </el-form-item>
        <el-form-item label="自定义父级" v-show="!isTopLevel">
          <el-select v-model="dialogForm.pid" placeholder="请选择父级菜单">
            <el-option v-for="item in dialogPidArr" :key="item.funcId" :label="item.funcName"
                       :value="item.funcName"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="自定义排序">
          <el-input-number v-model="dialogForm.order"></el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogTableVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirmDialog">确 定</el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
import {
  deleteRole,
  getRole,
  insertRole,
  updateRole,
  getFunc,
  getAllandFuncById,
  getFuncAndRel,
  getTiles3D,
  getAllandTiles3dById,
  getBim,
  getAllandBimById,
  getAllCars,
  queryNetData,
  getPolice,
  getBimDevice,
  getSecurityAll,
  getUav,
  getVideo,
  getAllandCarById,
  getAllandPoliceById,
  getAllandDeviceById,
  getAllandNetById,
  getAllandSecurityById,
  getAllandUavById,
  getAllandVideoById
} from "../api/api";
import ztree from "vue-giant-tree";

export default {
  name: "sys-role",
  components: {
    ztree
  },
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
        roleName: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        roleId: '',
        roleName: '',
        sysRoleFunc: [],
        sysRoleTiles3d: [],
        sysRoleBim: [],
        sysRoleCar: [],
        sysRolePolice: [],
        sysRoleNet: [],
        sysRoleDevice: [],
        sysRoleSecurity: [],
        sysRoleUav: [],
        sysRoleVideo: [],
        sysRoleVideoIndoor: [],
        roleFuncStr: ''
      },
      multipleSelection: [],
      currentPageFunc: 1, //初始页
      pagesizeFunc: 40,   //每页的数据
      queryResultFunc: [],
      tableDateFunc: [],
      pictLoadingFunc: false,
      devFilterFunc: '',
      dialogTableVisible: false,
      dialogForm: {
        'name': '',
        'pid': '',
        'order': 1
      },
      dialogRow: {},
      isTopLevel: false,
      dialogPidArr: [],
      setting: {},
      settingBim: {},
      settingCar: {},
      settingPolice: {},
      settingNet: {},
      settingDevice: {},
      settingSecurity: {},
      settingUav: {},
      settingVideo: {},
      settingVideoIndoor: {},
      nodes: [],
      nodesBim: [],
      nodesCar: [],
      nodesPolice: [],
      nodesNet: [],
      nodesDevice: [],
      nodesSecurity: [],
      nodesUav: [],
      nodesVideo: [],
      nodesVideoIndoor: [],
      tiles3dSelection: [],
      bimSelection: [],
      carSelection: [],
      policeSelection: [],
      netSelection: [],
      deviceSelection: [],
      securitySelection: [],
      uavSelection: [],
      videoSelection: [],
      videoSelectionIndoor: [],
      isTestFuncSelected: false
    }
  },
  methods: {
    getRoleData() {
      this.pictLoading = true;
      getRole().then(res => {
        this.queryResult = res.data;
        let tempData = [];
        res.data.map(item => {
          let roleFuncStr = '';
          item.sysRoleFunc.map(func => {
            roleFuncStr += func.funcName + ';';
          });
          item.roleFuncStr = roleFuncStr;
          tempData.push(item);
        });
        this.tableDate = tempData;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.roleId;
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
      getTiles3D().then(res => this.createTiles3DTree(res.data));
      getBim().then(res => this.createBimTree(res.data));
      getAllCars().then(res => this.createCarTree(res.data));
      getPolice().then(res => this.createPoliceTree(res.data));
      getBimDevice().then(res => this.createDeviceTree(res.data));
      queryNetData().then(res => this.createNetTree(res.data));
      getSecurityAll().then(res => this.createSecurityTree(res.data));
      getUav().then(res => this.createUavTree(res.data));
      let params = {
        isIndoor: "false"
      };
      getVideo(params).then(res => this.createVideoTree(res.data));
      let params1 = {
        isIndoor: "true"
      };
      getVideo(params1).then(res => this.createVideoTreeIndoor(res.data));
      this.dogetFuncData();
      this.isTestFuncSelected = true;
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        this.redogetFuncData();
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
            roleId: this.currentId
          };
          deleteRole(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getRoleData();
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
      let funcSelectedArr = [];
      for (let i = 0; i < this.multipleSelection.length; i++) {
        if (this.multipleSelection[i].funcId !== undefined) {
          funcSelectedArr.push(this.multipleSelection[i]);
        }
      }
      if (this.multipleSelection.length !== 0) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.formData.sysRoleFunc = funcSelectedArr;
            this.formData.sysRoleTiles3d = this.tiles3dSelection;
            this.formData.sysRoleBim = this.bimSelection;
            this.formData.sysRoleCar = this.carSelection;
            this.formData.sysRolePolice = this.policeSelection;
            this.formData.sysRoleNet = this.netSelection;
            this.formData.sysRoleDevice = this.deviceSelection;
            this.formData.sysRoleSecurity = this.securitySelection;
            this.formData.sysRoleUav = this.uavSelection;
            this.formData.sysRoleVideo = this.videoSelection;
            this.formData.sysRoleVideoIndoor = this.videoSelectionIndoor;
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateRole(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getRoleData();
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
                insertRole(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getRoleData();
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
                  message: '用户已取消保存！'
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
          message: '该权限的功能不能为空！',
          type: 'error'
        });
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    backTable() {
      this.isTableShow = true;
      this.tiles3dSelection = [];
      this.bimSelection = [];
      this.carSelection = [];
      this.policeSelection = [];
      this.netSelection = [];
      this.deviceSelection = [];
      this.securitySelection = [];
      this.uavSelection = [];
      this.videoSelection = [];
      this.isTestFuncSelected = false;
    },
    handleSizeChangeFunc: function (size) {
      this.pagesizeFunc = size;
    },
    handleCurrentChangeFunc: function (currentPage) {
      this.currentPageFunc = currentPage;
    },
    //多选功能项，为该权限配置功能
    handleSelectionChange(val) {
      if (this.isTestFuncSelected) {
        let funcIdArr = [];
        val.map(item => {
          funcIdArr.push(item.funcId);
        });
        val.map(item => {
          if (funcIdArr.indexOf(item.funcPid) === -1 && item.funcLevel === "二级") {
            this.$message({
              type: 'error',
              message: '您选择的功能<' + item.funcName + '>需要勾选父级功能节点，否则影响使用！'
            });
          }
        });
        this.multipleSelection = val;
      }
    },
    //获取功能列表
    dogetFuncData() {
      this.pictLoadingFunc = true;
      getFunc().then(res => {
        this.$refs.multipleTable.clearSelection();
        this.queryResultFunc = res.data;
        let tempTabelData = [];
        res.data.map((item, index) => {
          if (item.funcLevel === "一级") {
            item.children = [];
            item.funcName = item.funcDefaultName;
            item.roleFuncPid = item.funcPid;
            item.roleFuncName = "--";
            item.roleFuncOrder = index;
            tempTabelData.push(item);
          }
        });
        res.data.map((item, index) => {
          for (let i = 0; i < tempTabelData.length; i++) {
            if (item.funcPid === tempTabelData[i].funcId) {
              tempTabelData[i].children.push(item);
              item.funcName = item.funcDefaultName;
              item.roleFuncPid = item.funcPid;
              item.roleFuncName = tempTabelData[i].funcName;
              item.roleFuncOrder = index;
              break;
            }
          }
        });
        this.tableDateFunc = tempTabelData;
        this.pictLoadingFunc = false;
      });
    },
    //回显功能列表和业务数据的目录树
    redogetFuncData() {
      this.pictLoadingFunc = true;
      let params = {
        'roleId': this.currentRow.roleId
      };
      //创建功能列表
      getFuncAndRel(params).then(res => {
        this.$refs.multipleTable.clearSelection();
        this.queryResultFunc = res.data;
        let tempTabelData = [];
        res.data.map(item => {
          if (item.funcLevel === "一级") {
            item.children = [];
            item.funcName = item.sysRoleFunc.funcName !== null && item.sysRoleFunc.funcName !== '' ? item.sysRoleFunc.funcName : item.funcDefaultName;
            item.roleFuncPid = item.funcPid;
            item.roleFuncName = "--";
            item.roleFuncOrder = item.sysRoleFunc.roleFuncOrder;
            tempTabelData.push(item);
          }
        });
        res.data.map(item => {
          for (let i = 0; i < tempTabelData.length; i++) {
            if (item.funcPid === tempTabelData[i].funcId) {
              tempTabelData[i].children.push(item);
              item.funcName = item.sysRoleFunc.funcName !== null && item.sysRoleFunc.funcName !== '' ? item.sysRoleFunc.funcName : item.funcDefaultName;
              item.roleFuncPid = item.sysRoleFunc.roleFuncPid;
              let _item = tempTabelData.find(table => {
                return table.funcId === item.sysRoleFunc.roleFuncPid;
              });
              if (_item) {
                item.roleFuncName = _item.sysRoleFunc.funcName;
              }
              item.roleFuncOrder = item.sysRoleFunc.roleFuncOrder;
              break;
            }
          }
        });
        //回显对应权限已选功能
        getAllandFuncById(params).then(res => {
          res.data.sysRoleFunc.forEach(item => {
            let row = this.tableDateFunc.find((table) => {
              return item.sysFunc.funcId === table.funcId;
            });
            if (!row) {
              let _tableDateFunc = this.tableDateFunc;
              for (let i = 0; i < _tableDateFunc.length; i++) {
                let childRow = _tableDateFunc[i].children.find((table) => {
                  return item.sysFunc.funcId === table.funcId;
                });
                if (childRow) {
                  this.$refs.multipleTable.toggleRowSelection(childRow, true);
                  break;
                }
              }
            } else {
              this.$refs.multipleTable.toggleRowSelection(row, true);
            }
          });
          this.isTestFuncSelected = true;
          this.$refs.multipleTable.toggleRowSelection({}, true);//空刷一下，触发handleSelectionChange，回显multipleSelection
          //创建3dtiles数据目录树
          getTiles3D().then(res => {
            this.createTiles3DTree(res.data);
            //回显对应权限已选的3dtiles
            getAllandTiles3dById(params).then(res => {
              let treeNodes = [];
              let tilesArr = res.data.sysRoleTiles3d;
              for (let i = 0; i < this.nodes.length; i++) {
                if (tilesArr) {
                  for (let j = 0; j < tilesArr.length; j++) {
                    if (this.nodes[i].id === tilesArr[j].tilesId) {
                      this.nodes[i].checked = true;
                      this.tiles3dSelection.push(this.nodes[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodes[i]);
              }
              this.nodes = treeNodes;
            });
          });
          //创建bim数据目录树
          getBim().then(res => {
            this.createBimTree(res.data);
            //回显对应权限已选的bim
            getAllandBimById(params).then(res => {
              let treeNodes = [];
              let tilesArr = res.data.sysRoleBim;
              for (let i = 0; i < this.nodesBim.length; i++) {
                if (tilesArr) {
                  for (let j = 0; j < tilesArr.length; j++) {
                    if (this.nodesBim[i].id === tilesArr[j].tilesId) {
                      this.nodesBim[i].checked = true;
                      this.bimSelection.push(this.nodesBim[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesBim[i]);
              }
              this.nodesBim = treeNodes;
            });
          });
          //创建车辆数据目录树
          getAllCars().then(res => {
            this.createCarTree(res.data);
            //回显对应权限已选的车辆
            getAllandCarById(params).then(res => {
              let treeNodes = [];
              let carArr = res.data.sysRoleCar;
              for (let i = 0; i < this.nodesCar.length; i++) {
                if (carArr) {
                  for (let j = 0; j < carArr.length; j++) {
                    if (this.nodesCar[i].id === carArr[j].carId) {
                      this.nodesCar[i].checked = true;
                      this.carSelection.push(this.nodesCar[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesCar[i]);
              }
              this.nodesCar = treeNodes;
            });
          });
          //创建人员数据目录树
          getPolice().then(res => {
            this.createPoliceTree(res.data);
            //回显对应权限已选的人员
            getAllandPoliceById(params).then(res => {
              let treeNodes = [];
              let manArr = res.data.sysRolePolice;
              for (let i = 0; i < this.nodesPolice.length; i++) {
                if (manArr) {
                  for (let j = 0; j < manArr.length; j++) {
                    if (this.nodesPolice[i].id === manArr[j].policeId) {
                      this.nodesPolice[i].checked = true;
                      this.policeSelection.push(this.nodesPolice[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesPolice[i]);
              }
              this.nodesPolice = treeNodes;
            });
          });
          //创建设备数据目录树
          getBimDevice().then(res => {
            this.createDeviceTree(res.data);
            //回显对应权限已选的设备
            getAllandDeviceById(params).then(res => {
              let treeNodes = [];
              let deviceArr = res.data.sysRoleDevice;
              for (let i = 0; i < this.nodesDevice.length; i++) {
                if (deviceArr) {
                  for (let j = 0; j < deviceArr.length; j++) {
                    if (this.nodesDevice[i].id === deviceArr[j].deviceId) {
                      this.nodesDevice[i].checked = true;
                      this.deviceSelection.push(this.nodesDevice[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesDevice[i]);
              }
              this.nodesDevice = treeNodes;
            });
          });
          //创建网格数据目录树
          queryNetData().then(res => {
            this.createNetTree(res.data);
            //回显对应权限已选的网格
            getAllandNetById(params).then(res => {
              let treeNodes = [];
              let netArr = res.data.sysRoleNet;
              for (let i = 0; i < this.nodesNet.length; i++) {
                if (netArr) {
                  for (let j = 0; j < netArr.length; j++) {
                    if (this.nodesNet[i].id === netArr[j].netId) {
                      this.nodesNet[i].checked = true;
                      this.netSelection.push(this.nodesNet[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesNet[i]);
              }
              this.nodesNet = treeNodes;
            });
          });
          //创建警务站数据目录树
          getSecurityAll().then(res => {
            this.createSecurityTree(res.data);
            //回显对应权限已选的警务站
            getAllandSecurityById(params).then(res => {
              let treeNodes = [];
              let securityArr = res.data.sysRoleSecurity;
              for (let i = 0; i < this.nodesSecurity.length; i++) {
                if (securityArr) {
                  for (let j = 0; j < securityArr.length; j++) {
                    if (this.nodesSecurity[i].id === securityArr[j].securityId) {
                      this.nodesSecurity[i].checked = true;
                      this.securitySelection.push(this.nodesSecurity[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesSecurity[i]);
              }
              this.nodesSecurity = treeNodes;
            });
          });
          //创建无人机数据目录树
          getUav().then(res => {
            this.createUavTree(res.data);
            //回显对应权限已选的无人机0
            getAllandUavById(params).then(res => {
              let treeNodes = [];
              let uavArr = res.data.sysRoleUav;
              for (let i = 0; i < this.nodesUav.length; i++) {
                if (uavArr) {
                  for (let j = 0; j < uavArr.length; j++) {
                    if (this.nodesUav[i].id === uavArr[j].uavId) {
                      this.nodesUav[i].checked = true;
                      this.uavSelection.push(this.nodesUav[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesUav[i]);
              }
              this.nodesUav = treeNodes;
            });
          });
          //创建视频监控数据目录树
          let params1 = {
            isIndoor: "false"
          };
          getVideo(params1).then(res => {
            this.createVideoTree(res.data);
            //回显对应权限已选的视频监控
            let params = {
              'roleId': this.currentRow.roleId,
              'roleName': "false"
            };
            getAllandVideoById(params).then(res => {
              let treeNodes = [];
              let videoArr = res.data.sysRoleVideo;
              console.log(res.data,videoArr,this.nodesVideo);
              for (let i = 0; i < this.nodesVideo.length; i++) {
                if (videoArr) {
                  for (let j = 0; j < videoArr.length; j++) {
                    if (this.nodesVideo[i].id === videoArr[j].videoId) {
                      this.nodesVideo[i].checked = true;
                      this.videoSelection.push(this.nodesVideo[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesVideo[i]);
              }
              this.nodesVideo = treeNodes;
            });
          });
          //创建室内视频监控数据目录树
          let params2 = {
            isIndoor: "true"
          };
          getVideo(params2).then(res => {
            this.createVideoTreeIndoor(res.data);
            //回显对应权限已选的室内视频监控
            let params = {
              'roleId': this.currentRow.roleId,
              'roleName': "true"
            };
            getAllandVideoById(params).then(res => {
              let treeNodes = [];
              let videoArr = res.data.sysRoleVideo;
              for (let i = 0; i < this.nodesVideoIndoor.length; i++) {
                if (videoArr) {
                  for (let j = 0; j < videoArr.length; j++) {
                    if (this.nodesVideoIndoor[i].id === videoArr[j].videoId) {
                      this.nodesVideoIndoor[i].checked = true;
                      this.videoSelectionIndoor.push(this.nodesVideoIndoor[i]);
                      break;
                    }
                  }
                }
                treeNodes.push(this.nodesVideoIndoor[i]);
              }
              this.nodesVideoIndoor = treeNodes;
            });
          });
        });
        this.tableDateFunc = tempTabelData;
        this.pictLoadingFunc = false;
      });
    },
    tableBtnType(funcLevel) {
      let type = "success";
      if (funcLevel === "一级") {
        // type = "danger";
        type = "primary";
      }
      return type;
    },
    handleEdit(index, row) {
      this.dialogPidArr = [];
      this.dialogRow = row;
      this.dialogForm.name = row.funcName;
      this.dialogForm.pid = row.roleFuncName;
      this.dialogForm.order = row.roleFuncOrder;
      this.dialogTableVisible = true;
      this.isTopLevel = row.funcLevel === "一级";
      this.tableDateFunc.map(item => {
        if (item.funcLevel === "一级") {
          if (item.funcSrc === row.funcSrc) {
            this.dialogPidArr.push(item);
          }
        }
      });
    },
    confirmDialog() {
      this.dialogRow.funcName = this.dialogForm.name;
      if (this.dialogForm.pid && this.dialogForm.pid !== '') {
        this.dialogRow.roleFuncName = this.dialogForm.pid;
        for (let i = 0; i < this.dialogPidArr.length; i++) {
          if (this.dialogRow.roleFuncName === this.dialogPidArr[i].funcName) {
            this.dialogRow.roleFuncPid = this.dialogPidArr[i].funcId;
            break;
          }
        }
      }
      this.dialogRow.roleFuncOrder = this.dialogForm.order;
      this.dialogTableVisible = false;
    },
    createTiles3DTree(data) {
      //目录树配置
      this.setting = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "实景三维数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].tilesId;
        j.tilesId = data[i].tilesId;
        j.name = data[i].tilesName;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodes = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.tiles3dSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.tiles3dSelection.length; i++) {
            if (_this.tiles3dSelection[i].id === treeNode.id) {
              _this.tiles3dSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createBimTree(data) {
      //目录树配置
      this.settingBim = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{id: 0, pid: "", name: "BIM数据集", isNode: false, open: false, showIcon: false, nocheck: true}];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].tilesId;
        j.tilesId = data[i].tilesId;
        j.name = data[i].tilesName;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodesBim = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.bimSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.bimSelection.length; i++) {
            if (_this.bimSelection[i].id === treeNode.id) {
              _this.bimSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createCarTree(data) {
      //目录树配置
      this.settingCar = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "车辆监控数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].carId;
        j.carId = data[i].carId;
        j.name = data[i].carLicense;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodesCar = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.carSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.carSelection.length; i++) {
            if (_this.carSelection[i].id === treeNode.id) {
              _this.carSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createPoliceTree(data) {
      //目录树配置
      this.settingPolice = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "人员监控数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].policeId;
        j.policeId = data[i].policeId;
        j.name = data[i].name;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodesPolice = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.policeSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.policeSelection.length; i++) {
            if (_this.policeSelection[i].id === treeNode.id) {
              _this.policeSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createNetTree(data) {
      //目录树配置
      this.settingNet = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "网格数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].netId;
        j.netId = data[i].netId;
        j.name = data[i].netName;
        j.pid = data[i].netPid;
        treeNodes.push(j);
      }
      this.nodesNet = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.netSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.netSelection.length; i++) {
            if (_this.netSelection[i].id === treeNode.id) {
              _this.netSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createDeviceTree(data) {
      //目录树配置
      this.settingDevice = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "设备监控数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].deviceId;
        j.deviceId = data[i].deviceId;
        j.name = data[i].name;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodesDevice = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.deviceSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.deviceSelection.length; i++) {
            if (_this.deviceSelection[i].id === treeNode.id) {
              _this.deviceSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createSecurityTree(data) {
      //目录树配置
      this.settingSecurity = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "派出所警务站数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].securityId;
        j.securityId = data[i].securityId;
        j.name = data[i].securityName;
        j.pid = data[i].pid;
        treeNodes.push(j);
      }
      this.nodesSecurity = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.securitySelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.securitySelection.length; i++) {
            if (_this.securitySelection[i].id === treeNode.id) {
              _this.securitySelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createUavTree(data) {
      //目录树配置
      this.settingUav = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "无人机数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].uavId;
        j.uavId = data[i].uavId;
        j.name = data[i].uavName;
        j.pid = "0";
        treeNodes.push(j);
      }
      this.nodesUav = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.uavSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.uavSelection.length; i++) {
            if (_this.uavSelection[i].id === treeNode.id) {
              _this.uavSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createVideoTree(data) {
      //目录树配置
      this.settingVideo = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "视频监控数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].id;
        j.videoId = data[i].id;
        j.name = data[i].camAdd;
        j.pid = data[i].camPid;
        treeNodes.push(j);
      }
      this.nodesVideo = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.videoSelection.push(treeNode);
        } else {
          for (let i = 0; i < _this.videoSelection.length; i++) {
            if (_this.videoSelection[i].id === treeNode.id) {
              _this.videoSelection.splice(i, 1);
              break;
            }
          }
        }
      }
    },
    createVideoTreeIndoor(data) {
      //目录树配置
      this.settingVideoIndoor = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: tiles3dzTreeOnCheck,
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "室内视频监控数据集",
        isNode: false,
        open: false,
        showIcon: false,
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let j = {};
        j.id = data[i].id;
        j.videoId = data[i].id;
        j.name = data[i].camAdd;
        j.pid = data[i].camPid;
        treeNodes.push(j);
      }
      this.nodesVideoIndoor = treeNodes;

      let _this = this;

      function tiles3dzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.checked) {
          _this.videoSelectionIndoor.push(treeNode);
        } else {
          for (let i = 0; i < _this.videoSelectionIndoor.length; i++) {
            if (_this.videoSelectionIndoor[i].id === treeNode.id) {
              _this.videoSelectionIndoor.splice(i, 1);
              break;
            }
          }
        }
      }
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.roleName.indexOf(val)
          || ~item.roleFuncStr.indexOf(val))
      );
    },
    devFilterFunc: function (val, oldVal) {
      this.tableDateFunc = this.queryResultFunc.filter(
        item => (~item.funcSrc.indexOf(val)
          || ~item.funcDefaultName.indexOf(val)
          || ~item.funcType.indexOf(val)
          || ~item.funcUrl.indexOf(val)
          || ~item.funcIotName.indexOf(val)
        )
      );
    }
  },
  mounted() {
    this.getRoleData();
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
  width: 1200px;
}

.my-card-body {
  overflow-y: auto;
}

.table-button {
  font-size: 16px;
  font-weight: bolder;
  padding: 5px 18px !important;
}

.tree-group {
  width: 25%;
}

.row_display {
  display: flex;
}
</style>
