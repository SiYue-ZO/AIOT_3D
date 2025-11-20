<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop"
       v-bind:ref="'rhaPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" style="border-color:#00d3e788">
      <div class="mapPop-name">{{name}}</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'level-down-alt']" title="进入"
                           v-on:click.stop="pop_in"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788;">
      <table class="pop-tabel" cellspacing="0">
        <tr>
          <td>实有房屋</td>
        </tr>
        <tr>
          <td class="DS-font">{{rhNum}}</td>
        </tr>
        <tr>
          <td>住址数量</td>
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
      <div class="pop-chart" v-bind:id="popId+'chart_rpa1'"></div>
    </div>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
  </div>
</template>

<script>
  import realHouse from '@/components/real-house';

  let popzIndex = 0;
  export default {
    name: "pop-realHouseArea",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        name: "",
        addNum: 0,
        rhNum: 0,
        nextLabel: "",
        nextNum: 0,
        rhaData: [],
      }
    },
    methods: {
      showChart() {
        let rpaChart1 = this.$echarts.init(document.getElementById(this.popId + "chart_rpa1"), 'light');
        let rpaOption1 = {
          title: {
            text: '房屋用途',
            left: 'center',
            top: 45,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold',
            }
          },
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['住宅', '出租']
          },
          series: [
            {
              name: '房屋用途',
              type: 'pie',
              radius: ['62%', '84%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [14, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '16',
                    fontWeight: 'bold',
                    color: '#fff065'
                  }
                }
              },
              labelLine: {
                normal: {
                  show: false
                }
              },
              startAngle: 315,
              minAngle: 2,
              hoverOffset: 3,
              data: this.rhaData
            }
          ]
        };
        rpaChart1.setOption(rpaOption1);
      },
      pop_in() {
        realHouse.methods.stepInNextLevel(this.popId);
      },
      pop_close() {
        let pop = this.$refs['rhaPop-' + this.levelNum];
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
    },
    mounted() {
      this.$nextTick(function () {
        this.showChart();
      });
    }
  }
</script>

<style scoped>
  .mapPop {
    width: 240px;
    height: 184px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .mapPop-title {
    width: 100%;
    font-size: 15px;
    font-weight: bolder;
    letter-spacing: 2px;
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
    height: 154px;
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
    width: 90px;
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
    left: 110px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 22px;
  }

  .pop-chart {
    width: 136px;
    height: 136px;
    float: right;
    border: none;
    text-align: center;
  }
</style>
