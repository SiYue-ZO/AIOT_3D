<template>
  <div id="tool-roam-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startRoam" title="播放">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="stopRoaming" title="停止清除">
      <font-awesome-icon :icon="['fas', 'stop']"></font-awesome-icon>
    </div>
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in roamsArr">
        <td>
          <input class="list-tabel-radio" type="radio" name="roam" v-model="curRoamId" v-bind:value="item.roamId"/>
        </td>
        <td class="td-tag-name">{{item.roamName}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  import '../js/CesiumRoam.js';
  import {getRoamAll} from "../api/api";

  export default {
    name: "tool-roam",
    data() {
      return {
        roamsArr: [],
        curRoamId: "",
        isPause: true,
      }
    },
    methods: {
      //创建路径漫游列表
      createRoamList(data) {
        this.roamsArr = data;
      },
      //开始漫游动画
      startRoam() {
        let roamsData = this.roamsArr;
        for (let i = 0; i < roamsData.length; i++) {
          if (roamsData[i].roamId === this.curRoamId) {
            let modeluri = '';
            let modelscale = 0;
            switch (roamsData[i].roamModel) {
              case '无人机':
                modeluri = common.serverIp + 'city3dfile/' + "data/model/air/UAV.glb";
                modelscale = 0.01;
                break;
              case '旋翼无人机':
                modeluri = common.serverIp + 'city3dfile/' + "data/model/air/rUAVa.gltf";
                modelscale = 0.5;
                break;
              case '大型客机':
                modeluri = common.serverIp + 'city3dfile/' + "data/model/air/plane.glb";
                modelscale = 1;
                break;
              case '战斗机':
                modeluri = common.serverIp + 'city3dfile/' + "data/model/air/jet.glb";
                modelscale = 1;
                break;
              default:
                break;
            }
            let linesStr = roamsData[i].roamLine.substring(0, roamsData[i].roamLine.length - 1);
            let isPathShow = roamsData[i].roamIsshow === '是';
            let isRe = roamsData[i].roamIsre === '是';
            let roamIsmodelshow = roamsData[i].roamIsmodelshow === '是';
            if(!roamIsmodelshow){
              modelscale = 0;
            }
            let options = {
              'viewer': viewer,
              'modeluri': modeluri,
              'scale': modelscale,
              'lines': linesStr,
              'isPathShow': isPathShow,
              'isRe': isRe,
              'roamIsmodelshow': roamIsmodelshow,
              'speed': Number(roamsData[i].roamSpeed),
              'type': roamsData[i].roamType,
            };
            this.stopRoaming();
            CesiumRoam.initRoaming(options);
            this.isPause = true;
            break;
          }
        }
      },
      //暂停
      pauseOrContinue() {
        this.isPause = !this.isPause;
        CesiumRoam.PauseOrContinue(viewer, this.isPause);
      },
      //停止漫游
      stopRoaming() {
        CesiumRoam.EndRoaming(viewer);
      }
    },
    mounted() {
      getRoamAll().then(res => this.createRoamList(res.data));
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
