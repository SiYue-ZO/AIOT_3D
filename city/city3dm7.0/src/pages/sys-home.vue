<template>
  <div>
    <el-card id="left-card-1" class="left-card" :style="{width: leftWidth, height: viewerHeightTop}">
      <div id="myChart-1" :style="{width: leftWidthChart, height: viewerHeightTopChart}"></div>
    </el-card>
    <el-card id="left-card-2" class="left-card1" :style="{width: leftWidth1, height: viewerHeightTop}">
      <div id="myChart-2" :style="{width: leftWidthChart1, height: viewerHeightTopChart}"></div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeightTop}">
      <CesiumMapMain :style="{width: mapWidth, height: viewerHeightTopChart}"></CesiumMapMain>
    </el-card>
    <el-card id="bottom-card" class="bottom-card" :style="{width: bottomWidth, height: viewerHeightBottom}">
      <div id="myChart-3" :style="{width: bottomWidthChart, height: viewerHeightBottomChart}"></div>
    </el-card>
  </div>
</template>

<script>
  import CesiumMapMain from "../utils/components/cesium-map-main";
  import echarts from 'echarts';
  import {countGeneralByExample} from "../api/api";

  export default {
    name: "sys-home",
    components: {
      CesiumMapMain
    },
    methods: {
      initChart1() {
        let myChart = this.$echarts.init(document.getElementById("myChart-1"), 'light');

        const symbol1 = 'image://' + "static/images/echarts/data-1616487032064-6FOUWYNk3.png";
        const symbol2 = 'image://' + "static/images/echarts/data-1616487535227-ELoLLlCbe.png";
        const symbol3 = 'image://' + "static/images/echarts/data-1616487247546-VOogMaQ_I.png";
        const symbol4 = 'image://' + "static/images/echarts/data-1616487251844-2-ThXQ4Rw.png";

        const tooltip = {
          trigger: 'item',
          textStyle: {fontSize: '100%'},
          formatter: params => {
            return `${params.name}`
          }
        };

        const series = {
          type: 'graph',
          symbol: symbol1,
          symbolSize: 90,
          label: {
            show: true,
            align: 'center',
            textStyle: {fontSize: 12, color: '#fff'},
            formatter: params => {
              return `\n\n\n\n\n\n\n${params.name}`
            },
            rich: {
              a0: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(255, 86, 76, .45)'
              },
              a1: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(255, 86, 76, .35)'
              },
              a2: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(239, 255, 55, .35)'
              },
              a3: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(50, 233, 255, .35)'
              },
            }
          },
          edgeSymbol: ['circle', 'arrow'],
          edgeSymbolSize: [4, 8],
          edgeLabel: {show: true, textStyle: {fontSize: 10}, formatter: "{c}"},
          data: [
            {name: '实景三维', value: {num: 55, type: 0}, draggable: true, x: 0, y: 0, symbol: symbol3},//0
            {name: '智慧综治', value: {num: 55, type: 1}, draggable: true, x: -12, y: -18, symbol: symbol4},//1
            {name: '智慧安防', value: {num: 55, type: 1}, draggable: true, x: 1, y: -21, symbol: symbol4},//2
            {name: '智慧物联', value: {num: 55, type: 2}, draggable: true, x: 18, y: 0, symbol: symbol2},//3
            {name: '智慧资源', value: {num: 55, type: 2}, draggable: true, x: -15, y: 18, symbol: symbol2},//4
            {name: '智慧消防', value: {num: 55, type: 3}, draggable: true, x: 19, y: 20},//5
            {name: '智慧园区', value: {num: 55, type: 2}, draggable: true, x: -20, y: 0, symbol: symbol2},//6
            {name: '智慧巡查', value: {num: 55, type: 3}, draggable: true, x: 1, y: 21},//7
            {name: '智慧城建', value: {num: 55, type: 3}, draggable: true, x: 19, y: -20, symbol: symbol4},//8
            {name: '智慧社区', value: {num: 55, type: 3}, draggable: true, x: -32, y: -21},//9
            {name: '智慧城管', value: {num: 55, type: 1}, draggable: true, x: 33, y: -20, symbol: symbol4},//10
            {name: '超级地图', value: {num: 55, type: 3}, draggable: true, x: -32, y: 20},//11
            {name: '智慧小区', value: {num: 55, type: 3}, draggable: true, x: -36, y: -7},//12
            {name: '智慧校园', value: {num: 55, type: 3}, draggable: true, x: -36, y: 7},//13
            {name: '智慧水利', value: {num: 55, type: 3}, draggable: true, x: 37, y: -7},//14
            {name: '智慧交通', value: {num: 55, type: 3}, draggable: true, x: 37, y: 7},//15
            {name: '智慧民生', value: {num: 55, type: 3}, draggable: true, x: 33, y: 20},//16
          ],
          links: [
            {source: 0, target: 1, value: '分层分户',},
            {source: 0, target: 2, value: '地理场景',},
            {source: 0, target: 3, value: '地理实体',},
            {source: 0, target: 4, value: '地理场景',},
            {source: 0, target: 5, value: '室内外',},
            {source: 0, target: 6, value: '地理场景',},
            {source: 0, target: 7, value: '地理场景',},
            {source: 0, target: 8, value: '地理场景',},
            {source: 6, target: 9, value: '小场景',},
            {source: 6, target: 12, value: '小场景',},
            {source: 6, target: 13, value: '小场景',},
            {source: 1, target: 9, value: '人口信息',},
            {source: 3, target: 2, value: '',},
            {source: 3, target: 7, value: '',},
            {source: 3, target: 5, value: '',},
            {source: 3, target: 8, value: '',},
            {source: 3, target: 10, value: '',},
            {source: 4, target: 11, value: '',},
            {source: 3, target: 14, value: '',},
            {source: 3, target: 15, value: '',},
            {source: 3, target: 16, value: '',},
          ],
          lineStyle: {
            opacity: 0.9,
            width: 1,
            curveness: 0,
            color: '#fff'
          }
        };

        let option = {tooltip, series, backgroundColor: '#000E1AEE'};
        myChart.setOption(option);
      },
      initChart2() {
        let myChart2 = this.$echarts.init(document.getElementById("myChart-2"), 'light');

        const legend1 = 'image://' + "static/images/echarts/data-1616488906907-TTcSsT2dL.png";
        const legend2 = 'image://' + "static/images/echarts/data-1616488914803-Pen9H3XeG.png";
        const legend3 = 'image://' + "static/images/echarts/data-1616488899626-PSUAyWzyA.png";

        const symbol1 = 'image://' + "static/images/echarts/data-1616487032064-6FOUWYNk3.png";
        const symbol3 = 'image://' + "static/images/echarts/pserver.png";
        const symbol4 = 'image://' + "static/images/echarts/server.png";
        const symbol5 = 'image://' + "static/images/echarts/eq3.png";
        const symbol6 = 'image://' + "static/images/echarts/cam.png";
        const symbol7 = 'image://' + "static/images/echarts/ai.png";
        const symbol8 = 'image://' + "static/images/echarts/alarm.png";
        const symbol9 = 'image://' + "static/images/echarts/envi.png";

        const tooltip = {
          trigger: 'item',
          textStyle: {fontSize: '100%'},
          formatter: params => {
            return `${params.name}`
          }
        };

        const legend = {
          show: true,
          bottom: '2%',
          right: '2%',
          textStyle: {color: '#fff'},
          itemWidth: 20,
          itemHeight: 20,
          orient: 'vertical',
          data: [
            {name: '用户', icon: legend1},
            {name: '智能终端', icon: legend2},
            {name: '服务器', icon: legend3},
          ]
        };

        const series = {
          type: 'graph',
          symbol: symbol1,
          symbolSize: 60,
          categories: [{name: "用户"}, {name: "智能终端"}, {name: "服务器"}],
          label: {
            show: true,
            align: 'center',
            textStyle: {fontSize: 12, color: '#fff'},
            formatter: params => {
              return `\n\n\n\n\n\n\n${params.name}`
            },
            rich: {
              a0: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(255, 86, 76, .45)'
              },
              a1: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(255, 86, 76, .35)'
              },
              a2: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(239, 255, 55, .35)'
              },
              a3: {
                color: '#fff',
                padding: [4, 5],
                backgroundColor: 'rgba(50, 233, 255, .35)'
              },
            }
          },
          edgeSymbol: ['circle', 'arrow'],
          edgeSymbolSize: [4, 8],
          edgeLabel: {show: true, textStyle: {fontSize: 10}, formatter: "{c}"},
          data: [
            {name: '平台服务器', value: {num: 55, type: 0}, draggable: true, x: 0, y: 0, symbol: symbol3},//0
            {name: 'GIS服务器', value: {num: 55, type: 1}, category: 2, draggable: true, x: -10, y: -40, symbol: symbol4},//1
            {name: '物联网服务器', value: {num: 55, type: 2}, category: 2, draggable: true, x: -40, y: 0, symbol: symbol4},//2
            {name: '视频服务器', value: {num: 55, type: 1}, category: 2, draggable: true, x: -35, y: -24, symbol: symbol4},//3
            {name: 'AI服务器', value: {num: 55, type: 2}, category: 2, draggable: true, x: -35, y: 24, symbol: symbol4},//4

            {name: '视频监控', value: {num: 55, type: 3}, category: 1, draggable: true, x: -65, y: -43, symbol: symbol6},//5
            {name: 'GPS/执法仪', value: {num: 55, type: 3}, category: 1, draggable: true, x: -68, y: -20, symbol: symbol5},//6
            {name: '环境监控', value: {num: 55, type: 3}, category: 1, draggable: true, x: -70, y: 0, symbol: symbol8},//7
            {name: '多种报警器', value: {num: 55, type: 3}, category: 1, draggable: true, x: -68, y: 22, symbol: symbol9},//8
            {name: 'AI识别', value: {num: 55, type: 3}, category: 1, draggable: true, x: -65, y: 45, symbol: symbol7},//9

            {name: '指挥领导', value: {num: 55, type: 3}, category: 0, draggable: true, x: 30, y: -40},//10
            {name: '操作用户', value: {num: 55, type: 3}, category: 0, draggable: true, x: 30, y: -20},//11
            {name: '外勤用户', value: {num: 55, type: 3}, category: 0, draggable: true, x: 30, y: 0},//12
            {name: '管理员', value: {num: 55, type: 3}, category: 0, draggable: true, x: 30, y: 20},//13
          ],
          links: [
            {source: 1, target: 0, value: 'GIS服务',},
            {source: 2, target: 0, value: 'websocket',},
            {source: 3, target: 0, value: '推流',},
            {source: 4, target: 0, value: 'websocket',},
            {source: 6, target: 2, value: '推送',},
            {source: 7, target: 2, value: '推送',},
            {source: 8, target: 2, value: '推送',},
            {source: 5, target: 3, value: 'RTSP',},
            {source: 9, target: 4, value: 'http推送',},
            {source: 0, target: 10, value: '决策',},
            {source: 0, target: 11, value: '操作',},
            {source: 0, target: 12, value: '指挥',},
            {source: 0, target: 13, value: '运维',},
          ],
          lineStyle: {
            opacity: 0.9,
            width: 1,
            curveness: 0,
            color: '#fff'
          }
        };

        let option = {tooltip, series, legend, backgroundColor: '#000E1AEE'};
        myChart2.setOption(option);
      },
      initChart3() {
        countGeneralByExample().then(res => {
          let myChart3 = this.$echarts.init(document.getElementById("myChart-3"), 'light');

          let xData = ['案件', '围栏', 'AI', '周界', '围栏报警', '视频', '人员', '车辆', '装备', '地名地址', '人口', '房屋',
            '单位', '网格', '派出所', '预案', '标绘', 'BIM', '监控人员', '定制图层', '巡网', '拆改', '实景三维', '专题', '漫游'];
          let data0 = [];
          xData.map(item => {
            data0.push(1);
          });
          let data1 = res.data;
          let maxnum1 = Math.max.apply(null, data1);
          let maxlen1 = Math.pow(10, String(Math.ceil(maxnum1)).length - 2);
          let max1;
          if (maxnum1 >= 5) {
            max1 = Math.ceil(maxnum1 / (10 * maxlen1)) * maxlen1 * 10;
          } else {
            max1 = 5;
          }
          let option = {
            backgroundColor: '#000E1AEE', //背景色
            tooltip: {
              trigger: 'axis',
              borderColor: 'rgba(255,255,255,.3)',
              backgroundColor: 'rgba(13,5,30,.6)',
              textStyle: {
                color: 'white', //设置文字颜色
              },
              borderWidth: 1,
              formatter: function (parms) {
                let str =
                  '模块：' +
                  parms[0].axisValue +
                  '</br>' +
                  parms[0].marker +
                  '数据量：' +
                  parms[0].value;
                return str;
              },
            },
            textStyle: {
              color: '#C9C9C9',
            },
            grid: {
              containLabel: true,
              left: '0.5%',
              top: '9%',
              bottom: '3%',
              right: '1%',
            },
            xAxis: {
              type: 'category',
              data: xData,
              axisLine: {
                show: false,
                lineStyle: {
                  color: '#B5B5B5',
                },
              },
              axisTick: {
                show: false,
              },
              axisLabel: {
                margin: 20, //刻度标签与轴线之间的距离。
                textStyle: {
                  fontFamily: 'Microsoft YaHei',
                  color: '#FFF',
                },
                fontSize: 12,
                fontStyle: 'bold',
              },
            },
            yAxis: [
              {
                type: 'value',
                axisLine: {
                  show: true,
                  lineStyle: {
                    color: '#B5B5B5',
                  },
                },
                splitLine: {
                  show: false,
                },
                axisLabel: {
                  show: true,
                  textStyle: {
                    fontFamily: 'Microsoft YaHei',
                    color: '#FFF',
                  },
                  fontSize: 10,
                },
              },
              {
                show: true,
                type: 'value',
                min: 0,
                max: max1, // 计算最大值
                interval: max1 / 5, // 平均分为5份
                splitNumber: 5,
                name: '数量（项）',
                nameTextStyle: {
                  color: '#82AFC6',
                  fontSize: 12,
                  padding: [0, 0, -8, -100],
                },
                axisLabel: {
                  formatter: function (value) {
                    let num = value;
                    if (num && num !== 'undefined' && num !== 'null') {
                      let numS = num;
                      numS = numS.toString();
                      numS = numS.replace(/,/gi, '');
                      return numS;
                    } else {
                      return num;
                    }
                  },
                  color: '#82AFC6',
                  textStyle: {
                    fontSize: 12,
                  },
                },
                axisLine: {
                  show: false,
                  lineStyle: {
                    color: '#3E5B7D',
                  },
                },
                axisTick: {
                  show: false,
                },
                splitLine: {
                  lineStyle: {
                    color: '#102E74',
                  },
                },
              },
            ],
            series: [
              {
                name: '',
                type: 'bar',
                data: data1,
                stack: 'zs',
                barMaxWidth: 'auto',
                barWidth: 30,
                label: {
                  normal: {
                    show: true,
                    position: 'top',
                    fontSize: 16,
                    color: '#fff',
                  }
                },
                itemStyle: {
                  color: {
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    type: 'linear',
                    global: false,
                    colorStops: [
                      {
                        offset: 0,
                        color: '#017ebb',
                      },
                      {
                        offset: 1,
                        color: '#06fbfe',
                      },
                    ],
                  },
                },
              },
              {
                name: '',
                type: 'line',
                data: data1,
                smooth: true,
                symbol: 'none',
                itemStyle: {
                  normal: {
                    lineStyle: {
                      color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                          offset: 0,
                          color: 'rgba(255, 227, 168, 0)',
                        },
                        {
                          offset: 0.5,
                          color: 'rgba(255, 227, 168, 1)',
                        },
                        {
                          offset: 1,
                          color: 'rgba(255, 227, 168, 0)',
                        },
                      ]),
                      shadowColor: 'rgba(255, 120, 0,1)',
                      shadowBlur: 8,
                    },
                    areaStyle: {
                      color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                          offset: 0,
                          color: 'rgba(197, 106, 255, 0.6)',
                        },
                        {
                          offset: 0.6,
                          color: 'rgba(255, 120, 0, 0)',
                        },
                      ]),
                    },
                  },
                },
              },
              {
                data: data0,
                type: 'pictorialBar',
                barMaxWidth: '10',
                symbol: 'diamond',
                symbolOffset: [0, '50%'],
                symbolSize: [30, 10],
                zlevel: 2,
                itemStyle: {
                  normal: {
                    color: '#06fbfe',
                  },
                },
              },
              {
                data: data1,
                type: 'pictorialBar',
                barMaxWidth: '10',
                symbolPosition: 'end',
                symbol: 'diamond',
                symbolOffset: [0, '-50%'],
                symbolSize: [30, 10],
                zlevel: 2,
                itemStyle: {
                  normal: {
                    color: '#06fbfe',
                  },
                },
              },
            ],
          };

          myChart3.setOption(option);
        });
      }
    },
    mounted() {
      this.initChart1();
      this.initChart2();
      this.initChart3();
    },
    computed: {
      viewerHeightTop: function () {
        return (window.innerHeight - 500) + 'px';
      },
      viewerHeightTopChart: function () {
        return (window.innerHeight - 520) + 'px';
      },
      viewerHeightBottom: function () {
        return 360 + 'px';
      },
      viewerHeightBottomChart: function () {
        return 340 + 'px';
      },
      bottomWidth: function () {
        return (window.innerWidth - 222) + 'px';
      },
      bottomWidthChart: function () {
        return (window.innerWidth - 222) - 20 + 'px';
      },
      leftWidth: function () {
        return ((window.innerWidth - 230) * 0.4) - 10 + 'px';
      },
      leftWidthChart: function () {
        return ((window.innerWidth - 230) * 0.4) - 30 + 'px';
      },
      leftWidth1: function () {
        return ((window.innerWidth - 230) * 0.3) - 5 + 'px';
      },
      leftWidthChart1: function () {
        return ((window.innerWidth - 230) * 0.3) - 25 + 'px';
      },
      rightWidth: function () {
        return ((window.innerWidth - 230) * 0.3) + 'px';
      },
      mapWidth: function () {
        return ((window.innerWidth - 230) * 0.3) - 20 + 'px';
      },
    }
  }
</script>

<style scoped>
  .left-card {
    float: left;
    background-color: #aaaaaa;
  }

  .left-card1 {
    float: left;
    margin-left: 10px;
    background-color: #aaaaaa;
  }

  .bottom-card {
    position: absolute;
    bottom: 55px;
    background-color: #aaaaaa;
  }

  .right-card {
    float: right;
    background-color: #aaaaaa;
  }
</style>
