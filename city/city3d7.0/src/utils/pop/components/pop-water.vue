<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop"
       v-bind:ref="'waterPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div v-show="isliquidshow" :id="popId+'echart-liquidfill'" class="echart-liquidfill"
         @click="turnChart(popId)"></div>
    <div v-show="islineshow" :id="popId+'echart-line'" class="echart-line" @click="turnChart(popId)"></div>
  </div>
</template>

<script>
  import 'echarts-liquidfill'
  import echarts from 'echarts';

  let popzIndex = 0;

  export default {
    name: "pop-water",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        isliquidshow: true,
        islineshow: false
      }
    },
    methods: {
      showChart() {
        let waterChart = this.$echarts.init(document.getElementById(this.popId + "echart-liquidfill"), 'light');

        let val = (Math.random() * 3).toFixed(1);
        let data = [val / 3, val / 3 - 0.2];
        let color = [];
        if (val > 1.5) {
          color = ['#fc8158', '#f74638', 'rgba(247,70,56,0.90)', 'rgba(0,0,0,0)', 'RGBA(128,0,0,0.9)', 'rgba(247,70,56,0.90)'];
        } else {
          color = ['#4feafc', '#1f4ff7', 'rgba(88,142,197,0.95)', 'rgba(0,0,0,0)', 'RGBA(51, 66, 127, 0.9)', 'rgba(88,142,197,0.5)'];
        }

        function _pie2() {
          let dataArr = [];
          for (let i = 0; i < 8; i++) {
            if (i % 2 === 0) {
              dataArr.push({
                name: (i + 1).toString(),
                value: 25,
                itemStyle: {
                  normal: {
                    color: color[2],
                  },
                },
              });
            } else {
              dataArr.push({
                name: (i + 1).toString(),
                value: 20,
                itemStyle: {
                  normal: {
                    color: color[3],
                  },
                },
              });
            }
          }
          return dataArr;
        }

        let option = {
          series: [
            {
              type: 'liquidFill',
              radius: '50%',
              center: ['50%', '50%'],
              color: [
                {
                  type: 'linear',
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 1,
                      color: color[0],
                    },
                    {
                      offset: 0,
                      color: color[1],
                    },
                  ],
                  globalCoord: false,
                },
              ],
              data: data,
              backgroundStyle: {
                borderWidth: 1,
                color: color[4],
              },
              label: {
                normal: {
                  formatter: val + '米',
                  textStyle: {
                    fontSize: 16,
                    color: '#fff',
                  },
                },
              },
              outline: {
                show: true,
                itemStyle: {
                  borderWidth: 0,
                },
                borderDistance: 0,
              },
            },
            {
              type: 'pie',
              zlevel: 1,
              silent: true,
              center: ['50%', '50%'],
              radius: ['55%', '52%'],
              hoverAnimation: false,
              color: color[5],
              label: {
                normal: {
                  show: false,
                },
              },
              labelLine: {
                normal: {
                  show: false,
                },
              },
              data: [1],
            },
            {
              type: 'pie',
              zlevel: 2,
              silent: true,
              center: ['50%', '50%'],
              radius: ['65%', '61%'],
              startAngle: 50,
              hoverAnimation: false,
              label: {
                normal: {
                  show: false,
                },
              },
              labelLine: {
                normal: {
                  show: false,
                },
              },
              data: _pie2(),
            },
            {
              type: 'pie',
              zlevel: 3,
              silent: true,
              center: ['50%', '50%'],
              radius: ['57%', '60%'],
              label: {
                normal: {
                  show: false,
                },
              },
              labelLine: {
                normal: {
                  show: false,
                },
              },
              data: _pie2(),
            }
          ],
        };
        waterChart.setOption(option);
      },
      showChartsHistory() {
        let hisChart = this.$echarts.init(document.getElementById(this.popId + "echart-line"), 'dark');
        let statOption = {
          legend: {top: '5px'},
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow',
            },
            backgroundColor: 'rgba(9, 24, 48, 0.5)',
            textStyle: {
              color: '#CFE3FC',
            },
            formatter: (p) => {
              let str = '<div>时间：' + p[0].name + '</div><div>水位高：' + p[0].data + '毫米</div><div>降雨量：' + p[1].data + '毫米</div>';
              return str;
            }
          },
          grid: {
            left: '5px',
            right: '20px',
            top: '45px',
            bottom: '10px',
            containLabel: true,
          },
          toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: false, readOnly: false},
              saveAsImage: {show: false}
            }
          },
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          xAxis: [{
            type: 'category',
            data: waterHisData[0],
            boundaryGap: true,
            axisTick: {
              show: true,
              alignWithLabel: true
            },
            axisLabel: {
              // interval: interVal,
              fontSize: 10,
            },
          }],
          yAxis: {},
          series: [
            {
              name: '水位高',
              type: 'bar',
              data: waterHisData[1],
              itemStyle: {
                color: new echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [
                    {offset: 0, color: '#00f06e'},
                    {offset: 0.3, color: '#00f6da'},
                    {offset: 1, color: '#00f6da00'}
                  ]
                )
              },
            },
            {
              name: '降雨量',
              data: waterHisData[2],
              type: 'line',
              smooth: true,
              symbol: 'circle',
              symbolSize: 7,
              itemStyle: {
                type: 'normal',
                // color: 'rgba(0, 255, 240, 1)',
                color: '#3af3ff',
              },
              areaStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: 'rgba(98, 227, 255, 1)',
                  },
                  {
                    offset: 1,
                    color: 'rgba(98, 227, 255, 0)',
                  },
                ]),
              },
            },
          ]
        };
        hisChart.setOption(statOption);
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      },
      turnChart(id) {
        this.isliquidshow = !this.isliquidshow;
        this.islineshow = !this.islineshow;
      }
    },
    mounted() {
      this.$nextTick(function () {
        this.showChart();
        this.showChartsHistory();
      });
    }
  }
</script>

<style scoped>
  .mapPop {
    width: 220px;
    height: 150px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .echart-liquidfill {
    width: 120px;
    height: 120px;
    margin: 30px auto 0;
  }

  .echart-line {
    width: 220px;
    height: 150px;
  }
</style>
