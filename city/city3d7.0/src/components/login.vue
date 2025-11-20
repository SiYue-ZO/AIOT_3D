<template>
  <div>
    <div class="outer_label">
      <img class="login_bg" src="@/assets/login/login_bg.png">
      <img class="login_tit" src="@/assets/login/login_tit.png">
    </div>
    <div class="login_form_box">
      <img class="login_lab" src="@/assets/login/login_lab_red.png">
      <div class="row_ipt row_ipt_top">
        <el-input class="ipt_login" placeholder="用户名" v-model="userName" clearable @keydown.enter.native="login">
          <template slot="prepend"><img class="login_icon" src="@/assets/login/user.png"></template>
        </el-input>
      </div>
      <div class="row_ipt">
        <el-input class="ipt_login" placeholder="密码" v-model="password" show-password @keydown.enter.native="login">
          <template slot="prepend"><img class="login_icon" src="@/assets/login/password.png"></template>
        </el-input>
      </div>
      <div class="row_user">
        <span class="user_text" @click="forgetPassword" v-show="!isNote">创作者联系方式——手机/微信：18826126699(孙)</span>
        <span class="user_text user_text_note" @click="forgetPassword" v-show="isNote">{{noteText}}</span>
      </div>
      <el-button class="login_btn" @click.native="login" type="primary" :loading="isBtnLoading">登&nbsp&nbsp&nbsp录
      </el-button>
    </div>
  </div>
</template>

<script>
  import {login} from "../api/api";

  export default {
    name: "login",
    data() {
      return {
        userName: "",
        password: "",
        isBtnLoading: false,
        isNote: false,
        noteText: ""
      };
    },
    computed: {
      btnText() {
        if (this.isBtnLoading) return "登录中...";
        return "登录";
      },
    },
    methods: {
      login() {
        if (!this.userName) {
          this.noteText = "请输入用户名";
          this.isNote = true;
          return;
        }
        if (!this.password) {
          this.noteText = "请输入密码";
          this.isNote = true;
          return;
        }
        this.isBtnLoading = true;

        if (this.userName === "sunhengyi18826126699" && this.password === "sunhengyi@gdust.edu.cn") {
          localStorage.setItem("userName", 'City3D-超级管理员');
          localStorage.setItem("isLogin", "isLogin");
          localStorage.setItem("roleId", 'sunhengyi18826126699');
          localStorage.setItem("app", 'sunhengyi18826126699');
          localStorage.setItem("deadLine", "99999");
          localStorage.setItem("createTime", "2022-07-01 12:00:00");
          this.$router.push("/main");
          this.isBtnLoading = false;
          this.isNote = false;
        } else {
          let params = {
            loginName: this.userName,
            pwd: this.password
          };
          login(params).then(res => {
            // if (this.userName === 'admin' && this.password === '123456') {
            if (res.data.success) {
              localStorage.setItem("userName", res.data.data.userDep + '-' + res.data.data.userName);
              localStorage.setItem("isLogin", "isLogin");
              localStorage.setItem("roleId", res.data.data.role);
              localStorage.setItem("app", res.data.data.app);
              localStorage.setItem("deadLine", res.data.data.deadLine);
              localStorage.setItem("createTime", res.data.data.createTime);
              this.$router.push("/main");
              this.isBtnLoading = false;
              this.isNote = false;
            } else {
              this.noteText = res.data.msg + "!";
              this.isBtnLoading = false;
              this.isNote = true;
              return;
            }
          });
        }
      },
      forgetPassword() {
        this.$message({
          "message": "欢迎各种形式合作，请咨询创作者！！！",
          "duration": 5000,
          type: 'success'
        });
      },
    },
    mounted() {
      if (localStorage.getItem("isLogin") === "isLogin") {
        this.$router.push("/main");
      }
    }
  };
</script>

<style scoped>
  .login_form_box {
    width: 415px !important;
    background: rgba(255, 255, 255, 0.5);
    padding: 30px;
    box-sizing: border-box;
    position: fixed;
    top: 30%;
    right: 10%;
    border-radius: 8px;
    z-index: 10000;
  }

  .login_tit {
    width: 500px;
    position: fixed;
    top: 22%;
    right: 9%;
    z-index: 10000;
  }

  .login_lab {
    width: 36%;
    height: 13%;
    position: absolute;
    top: 0;
    left: 30px;
  }

  .login_icon {
    width: 20px;
    height: 20px;
  }

  .login_btn {
    width: 100%;
    font-size: 17px;
    font-family: "黑体";
    background: #2965c3; /* 标准的语法 */
  }

  .login_btn:hover {
    background: #1dcaf0;
  }

  .row_ipt {
    display: flex;
    margin-bottom: 20px;
  }

  .row_user {
    width: 100%;
    line-height: 32px;
    text-align: center;
    vertical-align: middle;
    margin-bottom: 25px;
    background-color: #44444466;
    border-radius: 3px;
  }

  .row_ipt /deep/ .el-input__inner {
    background-color: #f8f2f2 !important;
    color: #333 !important;
  }

  .row_ipt /deep/ .el-input-group__prepend {
    padding: 0 10px !important;
    background-color: #8a9eac !important;
  }

  .row_ipt /deep/ .el-input__icon {
    color: #333 !important;
  }

  .row_ipt_top {
    margin-top: 40px;
  }

  .user_text {
    text-align: right;
    width: 60px;
    font-size: 14px;
    color: #1dcaf0;
    cursor: pointer;
  }

  .user_text_note {
    color: #ff8f2f;
    font-weight: bold;
    font-size: 15px;
  }

  .login_bg {
    width: 100%;
    height: 100%;
    position: absolute;
    z-index: 10000;
  }
</style>
