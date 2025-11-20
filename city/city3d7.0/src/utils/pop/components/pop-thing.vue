<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'thingPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{thingName}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="清除"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <table class="infoPop-tabel" cellspacing="0">
        <tr>
          <td>部件名称</td>
          <td>{{thingName}}</td>
        </tr>
        <tr>
          <td>大类</td>
          <td>{{thingType}}</td>
        </tr>
        <tr>
          <td>小类</td>
          <td>{{thingClass}}</td>
        </tr>
        <tr>
          <td>所属网格</td>
          <td>{{thingNet}}</td>
        </tr>
        <tr>
          <td>所属单位</td>
          <td>{{thingDep}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
  let popzIndex = 0;
  export default {
    name: "pop-thing",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        thingId: "",
        thingType: "",
        thingClass: "",
        thingName: "",
        thingNet: "",
        thingDep: "",
      }
    },
    methods: {
      pop_close() {
        let pop = this.$refs['thingPop-' + this.levelNum];
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

  .infoPop-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
  }

  .infoPop-tabel td {
    padding: 2px 5px;
  }

  .infoPop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }
</style>
