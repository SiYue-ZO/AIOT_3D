<template>
  <div id="stat-case" class="stat-window stat-case">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['fas', 'info-circle']" fixed-width></font-awesome-icon>
        实时警情处置率
      </div>
      <div class="row">
        <div id="chart_it" class="chartRowHeight"></div>
        <div id="chart_110" class="chartRowHeight"></div>
      </div>
      <div class="row">
        <div id="chart_119" class="chartRowHeight"></div>
        <div id="chart_122" class="chartRowHeight"></div>
      </div>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  import echarts from 'echarts';

  let caseStat;
  let caseStat110;
  let caseStat119;
  let caseStat122;
  export default {
    name: "stat-case",
    data() {
      return {
        'alarm_it': 44,
        'alarm_110': 65,
        'alarm_119': 17,
        'alarm_122': 78,
      }
    },
    methods: {
      showStatCase() {
        caseStat = this.$echarts.init(document.getElementById("chart_it"), 'dark');
        caseStat110 = this.$echarts.init(document.getElementById("chart_110"), 'dark');
        caseStat119 = this.$echarts.init(document.getElementById("chart_119"), 'dark');
        caseStat122 = this.$echarts.init(document.getElementById("chart_122"), 'dark');
        let caseStatOption = {
          backgroundColor: 'rgba(255, 255, 255, 0)',
          series: [{
            radius: '100%',
            type: 'gauge',
            startAngle: 210,
            endAngle: -30,
            min: 0,
            max: 100,
            splitNumber: 5,
            axisLine: {
              lineStyle: {
                width: 4,
                // color: [
                //   [0.25, '#FF6E76'],
                //   [0.5, '#FDDD60'],
                //   [0.75, '#7CFFB2'],
                //   [1, '#58D9F9']
                // ]
                color: [
                  [
                    0.3, new echarts.graphic.LinearGradient(
                    0, 1, 1, 0, [{
                      offset: 0,
                      color: 'rgba(0, 237, 3,0.1)',
                    }, {
                      offset: 0.5,
                      color: 'rgba(0, 237, 3,0.6)',
                    },
                      {
                        offset: 1,
                        color: 'rgba(0, 237, 3,1)',
                      }
                    ]
                  )],
                  [
                    0.7, new echarts.graphic.LinearGradient(
                    0, 1, 1, 0, [{
                      offset: 0,
                      color: 'rgba(255, 184, 0,0.1)',
                    }, {
                      offset: 0.5,
                      color: 'rgba(255, 184, 0,0.6)',
                    },
                      {
                        offset: 1,
                        color: 'rgba(255, 184, 0,1)',
                      }
                    ]
                  )],
                  [
                    1, new echarts.graphic.LinearGradient(
                    0, 1, 1, 0, [{
                      offset: 0,
                      color: 'rgba(175, 36, 74,0.1)',
                    }, {
                      offset: 0.5,
                      color: 'rgba(255, 36, 74,0.6)',
                    },
                      {
                        offset: 1,
                        color: 'rgba(255, 36, 74,1)',
                      }
                    ]
                  )]
                ]
              }
            },
            pointer: {
              // icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
              // length: '50%',
              // width: 7,
              // offsetCenter: [0, '-60%'],
              itemStyle: {
                color: 'auto'
              }
            },
            axisTick: {
              length: 12,
              lineStyle: {
                color: 'auto',
                width: 2
              }
            },
            splitLine: {
              length: 20,
              lineStyle: {
                color: 'auto',
                width: 4
              }
            },
            axisLabel: {
              show: false,
              color: 'auto',
              fontSize: 10,
              distance: 2,
            },
            title: {
              offsetCenter: [0, '40%'],
              fontSize: 13,
              color: '#fefefe'
            },
            detail: {
              fontSize: 15,
              offsetCenter: [0, '70%'],
              valueAnimation: true,
              formatter: function (value) {
                return Math.round(value) + ' %';
              },
              color: '#fefefe'
            },
            data: [{
              value: this.alarm_it,
              name: '智 能'
            }]
          }]
        };
        caseStat.setOption(caseStatOption);
        caseStatOption.series[0].data[0].value = this.alarm_110;
        caseStatOption.series[0].data[0].name = '110';
        caseStat110.setOption(caseStatOption);
        caseStatOption.series[0].data[0].value = this.alarm_119;
        caseStatOption.series[0].data[0].name = '119';
        caseStat119.setOption(caseStatOption);
        caseStatOption.series[0].data[0].value = this.alarm_122;
        caseStatOption.series[0].data[0].name = '122';
        caseStat122.setOption(caseStatOption);
      }
    },
    mounted() {
      this.showStatCase();
      //动态展示数据-实际轮询数据库，然后传入数值
      window.setInterval(() => {
        caseStat.setOption({
          series: [{
            data: [{
              value: parseInt(Math.random() * 100),
              name: '智 能'
            }]
          }]
        });
        caseStat110.setOption({
          series: [{
            data: [{
              value: parseInt(Math.random() * 100),
              name: '110'
            }]
          }]
        });
        caseStat119.setOption({
          series: [{
            data: [{
              value: parseInt(Math.random() * 100),
              name: '119'
            }]
          }]
        });
        caseStat122.setOption({
          series: [{
            data: [{
              value: parseInt(Math.random() * 100),
              name: '122'
            }]
          }]
        });
      }, 3000);
    }
  }
</script>

<style scoped>
  .stat-case {
    left: 0;
    top: 715px;
  }

  .stat-body {
    color: #fff;
    height: 300px;
    width: 415px;
  }

  .row {
    width: 100%;
    margin-left: 26px;
  }

  .chartRowHeight {
    margin-top: 15px;
    height: 120px;
    width: 180px;
    float: left;
  }
</style>
