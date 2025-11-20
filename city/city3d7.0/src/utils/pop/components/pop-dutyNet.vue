<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'dnPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{curInfoType}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'address-book']" title="区域名称"
                           v-on:click.stop="show0"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-tie']" title="医疗保障"
                           v-on:click.stop="show1"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'box']" title="物质保障"
                           v-on:click.stop="show2"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'tools']" title="其它"
                           v-on:click.stop="show3"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div v-show="showArr[0]">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">名称</td>
            <td>{{netName}}</td>
          </tr>
          <tr>
            <td>类型</td>
            <td>{{netDep}}</td>
          </tr>
          <tr>
            <td>时间</td>
            <td>{{netTime}}</td>
          </tr>
          <tr>
            <td>封控等级</td>
            <td>{{netLevel}}</td>
          </tr>
          <tr>
            <td>区域面积</td>
            <td>{{netArea}}</td>
          </tr>
          <tr>
            <td>人口数量</td>
            <td>{{netPeople}}</td>
          </tr>
          <tr>
            <td>重点人员数量</td>
            <td>{{netKeyPeople}}</td>
          </tr>
          <tr>
            <td>备注</td>
            <td>{{netNote}}</td>
          </tr>
        </table>
      </div>
      <div v-show="showArr[1]">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">负责人员</td>
            <td>{{netDutyCare}}</td>
          </tr>
          <tr>
            <td>备注</td>
            <td>{{netCareNote}}</td>
          </tr>
        </table>
      </div>
      <div v-show="showArr[2]">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">负责人员</td>
            <td>{{netDutyGoods}}</td>
          </tr>
          <tr>
            <td>备注</td>
            <td>{{netGoodsNote}}</td>
          </tr>
        </table>
      </div>
      <div v-show="showArr[3]">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">备注</td>
            <td>{{otherNote}}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  let popzIndex = 0;

  export default {
    name: "pop-dutyPoint",
    data() {
      return {
        popId: "",
        levelNum: 0,
        showArr: [true, false, false, false],
        netName: "",
        netDep: "",
        curInfoType: "区域名称",
      }
    },
    methods: {
      show0() {
        this.showArr.map((item, index) => {
          this.showArr[index] = false;
        });
        this.showArr[0] = true;
        this.curInfoType = "区域名称";
      },
      show1() {
        this.showArr.map((item, index) => {
          this.showArr[index] = false;
        });
        this.showArr[1] = true;
        this.curInfoType = "医疗保障";
      },
      show2() {
        this.showArr.map((item, index) => {
          this.showArr[index] = false;
        });
        this.showArr[2] = true;
        this.curInfoType = "物质保障";
      },
      show3() {
        this.showArr.map((item, index) => {
          this.showArr[index] = false;
        });
        this.showArr[3] = true;
        this.curInfoType = "其它";
      },
      pop_close() {
        let pop = this.$refs['dnPop-' + this.levelNum];
        if (pop) {
          document.querySelector('body').removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      }
    }
  }
</script>

<style scoped>
  .infoPop {
    width: 477px;
    height: 323px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
    background: url("../../../assets/pop/info_pop_h.png");
  }

  .infoPop-title {
    width: 370px;
    font-size: 14px;
    padding: 5px 8px;
    min-height: 30px;
    margin: 23px 0 0 90px;
    border-bottom: solid;
    border-width: 1px 0;
  }

  .infoPop-name {
    float: left;
  }

  .infoPop-tools {
    float: right
  }

  .infoPop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .infoPop-content {
    font-size: 14px;
    padding: 3px;
    width: 370px;
    height: 160px;
    overflow-y: auto;
    overflow-x: hidden;
    color: #fff;
    margin: 0 0 0 90px;
  }

  .infoPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .infoPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .infoPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .infoPop-tabel-w {
    width: 100%;
    border: none;
    margin-top: 5px;
  }

  .infoPop-tabel td, .infoPop-tabel-w td {
    padding: 2px 5px;
  }

  .infoPop-tabel tr:nth-child(odd), .infoPop-tabel-w tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even), .infoPop-tabel-w tr:nth-child(even) {
    background: #091d46bb;
  }

  .td-label {
    min-width: 70px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }
</style>
