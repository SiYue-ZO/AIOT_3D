<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'dpPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{pName}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <table class="infoPop-tabel-w" cellspacing="0">
        <tr>
          <td class="td-label">地点名称</td>
          <td>{{pName}}</td>
        </tr>
        <tr>
          <td>时间</td>
          <td>{{pTime}}</td>
        </tr>
        <tr>
          <td>确症人员姓名</td>
          <td>{{nameChecked}}</td>
        </tr>
        <tr>
          <td>身份证号</td>
          <td>{{idChecked}}</td>
        </tr>
        <tr>
          <td>密接人员</td>
          <td>{{nameClose}}</td>
        </tr>
        <tr>
          <td>身份证号</td>
          <td>{{idClose}}</td>
        </tr>
        <tr>
          <td>次密接人员</td>
          <td>{{nameSubClose}}</td>
        </tr>
        <tr>
          <td>身份证号</td>
          <td>{{idSubClose}}</td>
        </tr>
        <tr>
          <td>活动范围</td>
          <td>{{pLiving}}</td>
        </tr>
        <tr>
          <td>流调情况</td>
          <td>{{pFlow}}</td>
        </tr>
        <tr>
          <td>备注</td>
          <td>{{pNote}}</td>
        </tr>
      </table>
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
        pName: "",
        pType: "",
        nameChecked: '',
        nameClose: '',
        nameSubClose: '',
        idChecked: '',
        idClose: '',
        idSubClose: '',
        pTime: '',
        pLiving: '',
        pFlow: '',
        pNote: ''
      }
    },
    methods: {
      pop_close() {
        let pop = this.$refs['dpPop-' + this.levelNum];
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
    word-break: break-all; /*支持IE，chrome，FF不支持*/
    word-wrap: break-word; /*支持IE，chrome，FF*/
  }

  .infoPop-tabel tr:nth-child(odd), .infoPop-tabel-w tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even), .infoPop-tabel-w tr:nth-child(even) {
    background: #091d46bb;
  }

  .td-label {
    min-width: 100px;
  }
</style>
