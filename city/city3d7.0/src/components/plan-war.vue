<template>
  <div id="plan-war-is-show">
    <div class="pop-fai pop-fai-save" v-on:click="saveArrow" title="保存方案">
      <font-awesome-icon :icon="['fas', 'save']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-clear" v-on:click="clearAllArrow" title="清除">
      <font-awesome-icon :icon="['far', 'trash-alt']"></font-awesome-icon>
    </div>
    <div>
      <el-input v-model="planName" placeholder="我的作战方案"></el-input>
    </div>
    <div class="my-note">绘制箭头：左键选取，右键结束</div>
    <div style="margin:5px 10px 0 0;">
      <el-color-picker class="color-picker" v-model="color" size="small" :predefine="predefineColors"></el-color-picker>
      <div style="margin-left: 50px">
        <el-button class="my-button" type="primary" v-on:click="drawpincerArrow">钳形</el-button>
        <el-button class="my-button" type="success" v-on:click="drawattackArrow">攻击</el-button>
        <el-button class="my-button" type="warning" v-on:click="drawstraightArrow">直线</el-button>
        <el-button class="my-button" type="danger" v-on:click="clearOneArrow">单删</el-button>
      </div>
    </div>
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in warsArr">
        <td>
          <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'map-marker-alt']"></font-awesome-icon>
        </td>
        <td class="td-tag-name" v-on:click="getPlanById(item.planId)">{{item.planName}}</td>
        <td>
          <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']"
                             v-on:click="dodeletePlanById(item.planId)"></font-awesome-icon>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  import {deletePlanById, getPlan, savePlan} from "../api/api";

  let planData;

  export default {
    name: "plan-war",
    data() {
      return {
        warsArr: [],
        planName: "",
        color: "#ff0000",
        predefineColors: [
          '#ff4500',
          '#ff8c00',
          '#ffd700',
          '#90ee90',
          '#00ced1',
          '#1e90ff',
          '#c71585',
        ]
      }
    },
    methods: {
      //绘制钳形箭头
      drawpincerArrow() {
        CesiumArrow.draw("pincerArrow", this.color);
      },
      //绘制攻击箭头
      drawattackArrow() {
        CesiumArrow.draw("attackArrow", this.color);
      },
      //绘制直箭头
      drawstraightArrow() {
        CesiumArrow.draw("straightArrow", this.color);
      },
      //保存箭头方案
      saveArrow() {
        if (this.planName !== "") {
          let result = CesiumArrow.saveData();
          let params = {
            'planName': this.planName,
            'planPos': result
          };
          savePlan(params).then(res => {
            if (res.data === 1) {
              this.dogetPlanAll();
              this.$message({
                message: "保存成功!",
                type: "success",
              });
            } else {
              this.$message({
                message: "保存失败，请重试!",
                type: "error",
              });
            }
          });
        } else {
          this.$message({
            message: "请输入作战方案名称!",
            type: "warning",
          });
        }
      },
      //开始删除单个箭头的方法监听
      clearOneArrow() {
        CesiumArrow.clearOne();
      },
      //清除箭头
      clearAllArrow() {
        CesiumArrow.clearAll();
      },
      //清除模块数据
      stopArrow() {
        CesiumArrow.clearAll();
        CesiumArrow.disable();
      },
      //获取全部已保存的标绘
      dogetPlanAll() {
        getPlan().then(res => this.showPlans(res.data));
      },
      //显示方案列表
      showPlans(data) {
        planData = data;
        let warsArrTemp = [];
        for (let i = 0; i < data.length; i++) {
          warsArrTemp.push({
            "planId": data[i].planId,
            "planName": data[i].planName,
          });
        }
        this.warsArr = warsArrTemp;
      },
      //显示指定方案图形
      getPlanById(planId) {
        for (let i = 0; i < planData.length; i++) {
          if (planId === planData[i].planId) {
            let args = JSON.parse(planData[i].planPos);
            CesiumArrow.showData(args);
            break;
          }
        }
      },
      //清除指定方案
      dodeletePlanById(id) {
        let params = {
          "planId": id
        };
        deletePlanById(params).then(res => {
          if (res.data === 1) {
            this.clearAllArrow();
            this.dogetPlanAll();
            this.$message({
              message: "删除作战方案成功!",
              type: "success",
            });
          } else {
            this.$message({
              message: "删除作战方案失败!",
              type: "error",
            });
          }
        });
      },
    },
    mounted() {
      this.dogetPlanAll();
      CesiumArrow.init(viewer);
    }
  }
</script>

<style scoped>
  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel td {
    padding: 2px 10px;
    cursor: pointer;
    height: 32px;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .td-tag-name {
    width: 280px;
  }

  .my-note {
    color: #ffffff;
    margin: 5px 0 0 0;
  }

  .my-button {
    padding: 10px 16px;
    font-size: 15px;
  }

  .color-picker {
    position: absolute;
    margin-top: 5px;
  }

  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-fai-save {
    right: 120px;
  }

  .pop-fai-save:hover {
    background-color: #20920a;
  }

  .pop-fai-clear {
    right: 80px;
  }

  .pop-fai-clear:hover {
    background-color: #e6002f;
  }
</style>
