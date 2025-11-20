<template>
  <div id="plan-peace-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="showEplan" title="播放">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="clearEplan" title="停止清除">
      <font-awesome-icon :icon="['fas', 'stop']"></font-awesome-icon>
    </div>
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in plansArr">
        <td>
          <input class="list-tabel-radio" type="radio" name="plan" v-model="curPlanId" v-bind:value="item.eplanId"
                 @change="moveToPlan"/>
        </td>
        <td class="td-tag-name">{{item.eplanName}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  import '../js/CesiumPlan.js';
  import map3d from "./map-3d";
  import {getEplanAll} from "../api/api";

  export default {
    name: "tool-plan",
    data() {
      return {
        plansArr: [],
        curPlanId: "",
        isPause: true,
      }
    },
    methods: {
      //获取应急预案列表
      createEplans(data) {
        this.plansArr = data;
      },
      //显示并且播放应急预案
      showEplan() {
        CesiumPlan.clearDraw(viewer);
        map3d.methods.initTilesetWall(5.0);
        let eplansData = this.plansArr;
        for (let i = 0; i < eplansData.length; i++) {
          if (eplansData[i].eplanId === this.curPlanId) {
            CesiumPlan.addAllPlan(eplansData[i].eplanCon, viewer);
            break;
          }
        }
      },
      //清除应急预案
      clearEplan() {
        CesiumPlan.clearDraw(viewer);
        map3d.methods.initTilesetWall(5.0);
        this.closeTimeline();
      },
      //暂停应急预案
      pauseOrContinue() {
        this.isPause = !this.isPause;
        CesiumRoam.PauseOrContinue(viewer, this.isPause);
      },
      //飞行到预案位置
      moveToPlan() {
        let eplansData = this.plansArr;
        for (let i = 0; i < eplansData.length; i++) {
          if (eplansData[i].eplanId === this.curPlanId) {
            let camPoiArr = eplansData[i].camPoi.split(',');
            map3d.methods.moveToWin(
              camPoiArr[0],
              camPoiArr[1],
              camPoiArr[2],
              eplansData[i].camHeading,
              eplansData[i].camPitch);
            break;
          }
        }
      },
      showTimeline() {
        document.getElementsByClassName("cesium-viewer-bottom")[0].style.display = "block";
        document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "block";
        document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "block";
      },
      closeTimeline() {
        document.getElementsByClassName("cesium-viewer-bottom")[0].style.display = "none";
        document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "none";
        document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "none";
      },
    },
    mounted() {
      getEplanAll().then(res => this.createEplans(res.data));
      this.showTimeline();
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

  .list-tabel-radio {
    cursor: pointer;
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

  .pop-fai-start {
    right: 160px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-pause {
    right: 120px;
  }

  .pop-fai-pause:hover {
    background-color: #e0960d;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
