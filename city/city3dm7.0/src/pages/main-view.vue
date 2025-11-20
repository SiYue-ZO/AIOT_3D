<template>
  <el-container class="main-view">
    <el-header class="header">
      <div class="sys-title textshadow-p">
        <img class="sys-logo" :src="logoSrc+ui.appLogo"/>
        <div class="sys-name">{{ ui.appName }}</div>
        <div class="sys-bar textshadow-p">|</div>
        <div class="sys-version textshadow-p">{{ ui.appVersion }}</div>
      </div>
      <div class="sys-tools">
        <font-awesome-icon class="sys-tools-fai-right" :icon="['fas', 'power-off']" title="退出" fixed-width
                           @click="logout()"></font-awesome-icon>
        <font-awesome-icon class="sys-tools-fai-right" :icon="['fas', 'home']" title="首页" fixed-width
                           @click="reset_home()"></font-awesome-icon>
        <el-popover
          placement="top"
          width="260"
          v-model="visible">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item label="新密码" prop="pwd">
              <el-input v-model="formData.pwd" placeholder="请填写新密码" style="width: 90%"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="userTel">
              <el-input v-model="formData.userTel" placeholder="请确认新密码" style="width: 90%"></el-input>
            </el-form-item>
          </el-form>
          <div style="text-align: right; margin: 0">
            <el-button size="mini" type="text" @click="visible = false">取消</el-button>
            <el-button size="mini" type="primary" @click="editPwd('formData')">确定</el-button>
          </div>
          <font-awesome-icon class="sys-tools-fai-right" :icon="['fas', 'cogs']" title="修改密码" fixed-width
                             slot="reference"></font-awesome-icon>
        </el-popover>
        <div class="sys-user">
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'user']" title="当前用户"
                             fixed-width></font-awesome-icon>
          {{ userName }}
        </div>
      </div>
    </el-header>
    <el-container>
      <el-aside class="sys-navi">
        <el-menu :default-active="defaultActive"
                 :unique-opened=true
                 background-color="#545c64"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 :router=true>
          <el-submenu v-for="(item,index) in funcList" :key="index+1" :index="(index+1).toString()">
            <template slot="title">
              <font-awesome-icon class="sys-navi-fai" :icon="[item.sysFunc.funcIconType, item.sysFunc.funcIcon]"
                                 fixed-width></font-awesome-icon>
              {{ item.funcName }}
            </template>
            <el-menu-item v-for="(item1,index1) in item.children" :key="index1+1" :index="item1.sysFunc.funcUrl">
              {{ item1.funcName }}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main class="main-router-view">
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </el-main>
        <el-footer class="main-foot">&copy; 2025.09- 孙恒一</el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
import {
  getAllandFuncByIdandSrc,
  querySysParabyType,
  getAppById,
  getFuncBySrc,
  updatePwd
} from "../api/api";
import {iconArr} from "../js/icon";

export default {
  name: "main-view",
  data() {
    return {
      userName: "",
      funcList: [],
      iconArr: [],
      ui: {
        appId: '',
        appName: '',
        appLogo: '',
        appUiMode: '',
        appPos: '',
        appVersion: ''
      },
      logoSrc: common.serverIp + "city3dfile/",
      visible: false,
      rules: {
        userId: [{required: true, message: '不能为空', trigger: 'blur'}],
        pwd: [{required: true, message: '不能为空', trigger: 'blur'}],
        userTel: [{required: true, message: '不能为空', trigger: 'blur'}],
      },
      formData: {
        userId: '',
        pwd: '',
        userTel: '',
      }
    }
  },
  methods: {
    logout() {
      localStorage.clear();
      this.$router.push({path: '/'});
    },
    reset_home() {
      this.$router.push({path: 'main'});
    },
    getSysData() {
      let params = {
        'sysType': 'aiIp'
      };
      querySysParabyType(params).then(res => {
        window.aiIp = res.data[0].sysContent;
      });
    },
    getFuncList() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "funcSrc": "数据中台"
        };
        getFuncBySrc(params).then(res => {
          let level1 = [];
          let level2 = [];
          res.data.map(item => {
            if (item.funcLevel === "一级") {
              let lev1 = {
                'funcName': item.funcDefaultName,
                'sysFunc': item
              };
              lev1.children = [];
              level1.push(lev1);
            } else {
              let lev2 = {
                'funcName': item.funcDefaultName,
                'sysFunc': item
              };
              level2.push(lev2);
            }
            let icon = this.iconArr.find(icon => {
              return icon.iconId === item.funcIcon;
            });
            item.funcIconType = icon.iconType;
          });
          level1.map(lev1 => {
            level2.map(lev2 => {
              if (lev1.sysFunc.funcId === lev2.sysFunc.funcPid) {
                lev1.children.push(lev2);
              }
            });
          });
          this.funcList = level1;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
          'roleName': "数据中台"
        };
        getAllandFuncByIdandSrc(params).then(res => {
          let level1 = [];
          let level2 = [];
          res.data.sysRoleFunc.map(item => {
            if (item.sysFunc.funcLevel === "一级") {
              item.children = [];
              level1.push(item);
            } else {
              level2.push(item);
            }
            let icon = this.iconArr.find(icon => {
              return icon.iconId === item.sysFunc.funcIcon;
            });
            item.funcIconType = icon.iconType;
          });
          level1.map(lev1 => {
            level2.map(lev2 => {
              if (lev1.funcId === lev2.roleFuncPid) {
                lev1.children.push(lev2);
              }
            });
          });
          this.funcList = level1;
        });
      }
    },
    initUI() {
      if (localStorage.getItem("app") === 'sunhengyi18826126699') {
        this.ui.appName = '实景三维智慧城市平台';
        this.ui.appLogo = 'image/logo/superadmin.png';
        this.ui.appVersion = 'CITY3D';
        localStorage.setItem('appPos', '126.60801015108913,45.68098813093156,5122.238481546125,0.18118455208178974,-50.07516275099384,0');
      } else {
        let params = {
          appId: localStorage.getItem("app")
        };
        getAppById(params).then(res => {
          this.ui = res.data;
          localStorage.setItem('appPos', res.data.appPos);
        })
      }
    },
    editPwd(formName) {
      this.formData.userId = localStorage.getItem("userId");
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
            distinguishCancelAndClose: true,
            confirmButtonText: '确认',
            cancelButtonText: '取消'
          }).then(() => {
            updatePwd(this.formData).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '修改成功，返回列表！'
                });
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
        }
      });
      this.visible = false;
    }
  },
  computed: {
    defaultActive: function () {
      return this.$route.path.replace('/', '');
    }
  },
  mounted() {
    if (localStorage.getItem("isLogin") !== "isLogin") {
      this.$router.push("/");
    }
    let srsptmTimeLong = new Date(localStorage.getItem("createTime").replace("-", "/").replace("-", "/"));
    let deadTime = new Date(new Date(srsptmTimeLong).getTime() + Number(localStorage.getItem("deadLine")) * 24 * 60 * 60 * 1000).getTime();
    let rsptmTimeLong = new Date().getTime();//当前时间
    if (rsptmTimeLong > deadTime) {
      this.$router.push("/");
      localStorage.setItem("isLogin", "");
    }
    this.iconArr = iconArr;
    this.userName = localStorage.getItem("userName");
    this.initUI();
    this.getSysData();
    this.getFuncList();
  }
}
</script>

<style scoped>
.main-view {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  padding: 0;
}

.header {
  height: 34px;
  background-color: #11264DD1;
  color: #f2f2f2
}

.sys-title {
  position: absolute;
  height: 77px;
  width: 980px;
  background: url("../assets/header/title.png");
  z-index: 5
}

.sys-logo {
  float: left;
  margin: 8px 0 0 20px;
  width: 46px;
  height: 46px;
  filter: drop-shadow(0px 0px 14px #ffffff);
}

.sys-name {
  float: left;
  font-family: IconFont;
  font-style: italic;
  font-size: 25px;
  font-weight: bold;
  margin: 15px 5px 0 20px
}

.sys-bar {
  font-size: 15px;
  float: left;
  margin: 25px 0 0 6px;
  font-style: italic;
}

.sys-version {
  font-size: 12px;
  float: left;
  margin: 31px 0 0 10px;
  font-style: italic;
}

.main-foot {
  border-top: solid 1px #dddddd;
  line-height: 45px !important;
  height: 45px !important;
  text-align: right;
  vertical-align: middle;
  color: #555555;
}

.sys-tools {
  position: absolute;
  right: 26px;
  top: 19px;
  color: #00ffff
}

.sys-user {
  float: right;
  line-height: 20px;
  vertical-align: middle;
}

.sys-tools-fai {
  margin: 0 5px 0 20px;
  font-size: 18px;
  cursor: pointer;
}

.sys-tools-fai-right {
  margin: 0 5px 0 20px;
  font-size: 18px;
  cursor: pointer;
  float: right;
}

.sys-navi {
  width: 200px !important;
  /*background-color: #11264DD1;*/
  background-color: #545c64;
  overflow-y: auto;
}

.sys-navi::-webkit-scrollbar {
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.sys-navi::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.sys-navi::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.sys-navi-fai {
  margin: -2px 5px 0 0;
  font-size: 14px;
}

.main-router-view {
  background-color: #eeeeee;
}
</style>
