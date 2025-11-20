<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop"
       v-bind:ref="'raaPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" style="border-color:#00d3e788">
      <div class="mapPop-name">{{name}}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'level-down-alt']" title="进入"
                           v-on:click.stop="pop_in"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788;">
      <table class="pop-tabel" cellspacing="0">
        <tr>
          <td>全部地名地址</td>
        </tr>
        <tr>
          <td class="DS-font">{{addNum}}</td>
        </tr>
        <tr>
          <td>{{nextLabel}}</td>
        </tr>
        <tr>
          <td class="DS-font">{{nextNum}}</td>
        </tr>
      </table>
    </div>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
  </div>
</template>

<script>
  import realAddress from '@/components/real-address';
  let popzIndex = 0;
  export default {
    name: "pop-realAddressArea",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        name: "",
        addNum: 0,
        nextLabel: "",
        nextNum: 0,
        netLevel:"3"
      }
    },
    methods:{
      pop_in(){
        if(this.netLevel==="3"){
          realAddress.methods.stepInNextLevel(this.popId);
        }else{
          realAddress.methods.stepInCommunity(this.popId);
        }
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
  .mapPop {
    width: 110px;
    height: 140px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .mapPop-title {
    width: 100%;
    font-size: 13px;
    font-weight: bolder;
    border: solid;
    border-width: 1px 0 0 0;
    padding: 5px 8px;
    min-height: 30px;
    background-color: #11264DD1;
  }

  .mapPop-name {
    float: left;
  }

  .mapPop-tools {
    float: right
  }

  .mapPop-content {
    border: solid;
    border-width: 1px 0;
    font-size: 14px;
    background-color: #11264DD1;
    padding: 2px;
    box-sizing: border-box;
    height: 110px;
    overflow-y: auto;
    overflow-x: hidden;
  }

  .mapPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .mapPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .mapPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .pop-tabel {
    width: 100%;
    border: none;
    text-align: center;
    float: left;
  }

  .pop-tabel td {
    padding: 2px 5px;
  }

  .pop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .pop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .box_lt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    top: 0;
  }

  .box_rt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    top: 0;
  }

  .box_rb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    bottom: 0;
  }

  .box_lb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    bottom: 0;
  }

  .box_leg {
    width: 0;
    height: 0;
    border: 10px solid;
    border-color: #000 transparent transparent;
    position: absolute;
    bottom: -20px;
    left: 45px;
  }

  .pop-tools-fai {
    cursor: pointer;
    top: 8px;
    right: 8px;
    position: absolute;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 24px;
  }
</style>
