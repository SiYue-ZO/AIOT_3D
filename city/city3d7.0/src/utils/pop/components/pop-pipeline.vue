<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'plPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{curInfoType}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'bacon']" title="管线信息"
                           v-on:click.stop="showPipeline"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'tools']" title="检修信息"
                           v-on:click.stop="showCheck"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div v-show="isPipelineShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">管段</td>
            <td>{{pldata.plName}}</td>
          </tr>
          <tr>
            <td>管线类型</td>
            <td>{{pldata.plType}}</td>
          </tr>
          <tr>
            <td>管线类别</td>
            <td>{{pldata.plSort}}</td>
          </tr>
          <tr>
            <td>埋设方式</td>
            <td>{{pldata.plBuildingType}}</td>
          </tr>
          <tr>
            <td>载体</td>
            <td>{{pldata.plCarry}}</td>
          </tr>
          <tr>
            <td>管线材质</td>
            <td>{{pldata.plMaterial}}</td>
          </tr>
          <tr>
            <td>管线长(mm)</td>
            <td>{{pldata.plLine}}</td>
          </tr>
          <tr>
            <td>管线坡度</td>
            <td>{{pldata.plSlope}}</td>
          </tr>
          <tr>
            <td>管线外径(mm)</td>
            <td>{{pldata.plOutDiameter}}</td>
          </tr>
          <tr>
            <td>管线内径(mm)</td>
            <td>{{pldata.plInDiameter}}</td>
          </tr>
          <tr>
            <td>管线方向</td>
            <td>{{pldata.plDirection}}</td>
          </tr>
          <tr>
            <td>管线状态</td>
            <td>{{pldata.plState}}</td>
          </tr>
          <tr>
            <td>起点埋深(mm)</td>
            <td>{{pldata.plDeep}}</td>
          </tr>
          <tr>
            <td>终点埋深(mm)</td>
            <td>{{pldata.plDeepStop}}</td>
          </tr>
          <tr>
            <td>所在区县</td>
            <td>{{pldata.plArea}}</td>
          </tr>
          <tr>
            <td>管沟权属</td>
            <td>{{pldata.plDitchDep}}</td>
          </tr>
          <tr>
            <td>管线权属</td>
            <td>{{pldata.plLineDep}}</td>
          </tr>
          <tr>
            <td>探测单位</td>
            <td>{{pldata.plSurveyDep}}</td>
          </tr>
          <tr>
            <td>探测时间</td>
            <td>{{pldata.plSurveyTime}}</td>
          </tr>
          <tr>
            <td>探测人员</td>
            <td>{{pldata.plPeople1}}</td>
          </tr>
          <tr>
            <td>过检人员</td>
            <td>{{pldata.plPeople2}}</td>
          </tr>
          <tr>
            <td>终检人员</td>
            <td>{{pldata.plPeople3}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isCheckShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">检测段</td>
            <td>{{ckdata.checkAdd}}</td>
          </tr>
          <tr>
            <td>检测员</td>
            <td>{{ckdata.checkMan}}</td>
          </tr>
          <tr>
            <td>检测时间</td>
            <td>{{ckdata.checkTime}}</td>
          </tr>
          <tr>
            <td>检测结果</td>
            <td>{{ckdata.checkResult}}</td>
          </tr>
          <tr>
            <td>维修员</td>
            <td>{{ckdata.repairMan}}</td>
          </tr>
          <tr>
            <td>维修时间</td>
            <td>{{ckdata.repairTime}}</td>
          </tr>
          <tr>
            <td>维修结果</td>
            <td>{{ckdata.repairResult}}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  let popzIndex = 0;
  export default {
    name: "pop-pipeline",
    data() {
      return {
        popId: "",
        pldata: {},
        ckdata: {},
        levelNum: "",
        curInfoType: "管线信息",
        isPipelineShow: true,
        isCheckShow: false,
      }
    },
    methods: {
      showPipeline() {
        this.isPipelineShow = true;
        this.isCheckShow = false;
        this.curInfoType = '管线信息';
      },
      showCheck() {
        this.isPipelineShow = false;
        this.isCheckShow = true;
        this.curInfoType = '检修信息';
      },
      pop_close() {
        let pop = this.$refs['plPop-' + this.levelNum];
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
