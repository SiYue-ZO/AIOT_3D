<template>
  <div id="stat-device" class="stat-window stat-device">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['fas', 'house-user']" fixed-width></font-awesome-icon>
        城市管理资源
      </div>
      <div class="row">
        <div id="chart_people" class="chartRowHeight"></div>
        <div id="chart_add" class="chartRowHeight"></div>
        <div id="chart_dep" class="chartRowHeight"></div>
      </div>
      <div class="row">
        <div id="chart_patrol" class="chartRowHeight"></div>
        <div id="chart_cam" class="chartRowHeight"></div>
        <div id="chart_man" class="chartRowHeight"></div>
      </div>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  let peopleChart;
  let addChart;
  let depChart;
  let patrolChart;
  let camChart;
  let manChart;
  let peopleOption;
  let addOption;
  let depOption;
  let patrolOption;
  let camOption;
  let manOption;

  export default {
    name: "stat-device",
    data() {
      return {
        'Data1': [
          {name: "重点人口", value: "12510", type: "人口"},
          {name: "流动人口", value: "26571", type: "人口"},
          {name: "普通人口", value: "556786", type: "人口"},
        ],
        'Data2': [
          {name: "一区", value: "180", type: "地址"},
          {name: "二区", value: "69", type: "地址"},
          {name: "三区", value: "161", type: "地址"},
          {name: "四区", value: "104", type: "地址"},
        ],
        'Data3': [
          {name: "重点单位", value: "22", type: "单位"},
          {name: "消防列管单位", value: "10", type: "单位"},
          {name: "行业场所", value: "12", type: "单位"},
        ],
        'Data4': [
          {name: "巡逻点位", value: "54", type: "巡逻"},
          {name: "治安卡口", value: "36", type: "巡逻"},
          {name: "巡区", value: "8", type: "巡逻"},
          {name: "巡线", value: "11", type: "巡逻"},
        ],
        'Data5': [
          {name: "枪机", value: "214", type: "摄像头"},
          {name: "球机", value: "93", type: "摄像头"},
          {name: "高空贴地", value: "18", type: "摄像头"},
          {name: "车辆识别", value: "48", type: "摄像头"},
          {name: "人脸识别", value: "32", type: "摄像头"},
        ],
        'Data6': [
          {name: "警员", value: "116", type: "力量"},
          {name: "车辆", value: "34", type: "力量"},
          {name: "摩托", value: "23", type: "力量"},
          {name: "无人机", value: "15", type: "力量"},
          {name: "治安员", value: "46", type: "力量"}
        ],
      }
    },
    methods: {
      showChartData(data) {
        let img = 'data:image/png;base64,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';
        let graphic = {
          elements: [{
            type: "image",
            z: 3,
            style: {
              image: img,
              width: 75,
              height: 75
            },
            left: 'center',
            top: 'center',
            position: [100, 100]
          }]
        };
        let color = ['#00ffff', '#00cfff', '#006ced', '#ffe000', '#ffa800', '#ff5b00', '#ff3000'];

        peopleChart = this.$echarts.init(document.getElementById("chart_people"), 'light');
        addChart = this.$echarts.init(document.getElementById("chart_add"), 'light');
        depChart = this.$echarts.init(document.getElementById("chart_dep"), 'light');
        patrolChart = this.$echarts.init(document.getElementById("chart_patrol"), 'light');
        camChart = this.$echarts.init(document.getElementById("chart_cam"), 'light');
        manChart = this.$echarts.init(document.getElementById("chart_man"), 'light');
        let peopleData = [];
        let addData = [];
        let depData = [];
        let patrolData = [];
        let camData = [];
        let manData = [];
        let splitV1 = 0;
        this.Data1.map((item, i) => {
          splitV1 += Number(item.value);
        });
        this.Data1.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          peopleData.push(item, {
            value: splitV1 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });
        let splitV2 = 0;
        this.Data2.map((item, i) => {
          splitV2 += Number(item.value);
        });
        this.Data2.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          addData.push(item, {
            value: splitV2 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });
        let splitV3 = 0;
        this.Data3.map((item, i) => {
          splitV3 += Number(item.value);
        });
        this.Data3.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          depData.push(item, {
            value: splitV3 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });
        let splitV4 = 0;
        this.Data4.map((item, i) => {
          splitV4 += Number(item.value);
        });
        this.Data4.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          patrolData.push(item, {
            value: splitV4 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });
        let splitV5 = 0;
        this.Data5.map((item, i) => {
          splitV5 += Number(item.value);
        });
        this.Data5.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          camData.push(item, {
            value: splitV5 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });
        let splitV6 = 0;
        this.Data6.map((item, i) => {
          splitV6 += Number(item.value);
        });
        this.Data6.map((item, i) => {
          item.itemStyle = {
            normal: {
              borderWidth: 4,
              shadowBlur: 12,
              borderColor: color[i],
              shadowColor: color[i],
              borderRadius: 1,
            }
          };
          manData.push(item, {
            value: splitV6 / 30,
            name: '',
            itemStyle: {
              normal: {
                label: {
                  show: false
                },
                labelLine: {
                  show: false
                },
                color: 'rgba(0, 0, 0, 0)',
                borderColor: 'rgba(0, 0, 0, 0)',
                borderWidth: 0
              }
            }
          });
        });

        peopleOption = {
          title: {
            text: '城市人口',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['重点人口', '流动人口', '普通人口']
          },
          series: [
            {
              name: '接入人口资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: peopleData
            }
          ]
        };
        addOption = {
          title: {
            text: '城市网格',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['地名地址', '房屋']
          },
          series: [
            {
              name: '接入地址资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: addData
            }
          ]
        };
        depOption = {
          title: {
            text: '单位管理',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['重点单位', '消防列管单位', '行业场所']
          },
          series: [
            {
              name: '接入单位资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: depData
            }
          ]
        };
        patrolOption = {
          title: {
            text: '城市巡逻',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['巡逻点位', '治安卡口', '巡区', '巡线']
          },
          series: [
            {
              name: '接入巡逻资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: patrolData
            }
          ]
        };
        camOption = {
          title: {
            text: 'AI监控',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['枪机', '球机', '高空贴地', '车辆识别', '人脸识别']
          },
          series: [
            {
              name: '接入视频资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0]
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: camData
            }
          ]
        };
        manOption = {
          title: {
            text: '执勤能力',
            left: 'center',
            top: 40,
            textStyle: {
              color: '#f1f1f1',
              fontSize: '15',
              fontWeight: 'bold'
            }
          },
          color: color,
          graphic: graphic,
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
          },
          legend: {
            show: false,
            orient: 'vertical',
            x: 'left',
            data: ['警员', '车辆', '摩托', '无人机', '治安员']
          },
          series: [
            {
              name: '接入力量资源',
              type: 'pie',
              radius: ['73%', '80%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center',
                  padding: [22, 0, 0, 0],
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '13',
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
              data: manData
            }
          ]
        };
        peopleChart.setOption(peopleOption);
        addChart.setOption(addOption);
        depChart.setOption(depOption);
        patrolChart.setOption(patrolOption);
        camChart.setOption(camOption);
        manChart.setOption(manOption);
      }
    },
    mounted() {
      this.showChartData(this.statDiviceData);

      let index1 = 0;
      let index2 = 0;
      let index3 = 0;
      let index4 = 0;
      let index5 = 0;
      let index6 = 0;
      let index = 1;
      //动态外部激活饼状图的各个块儿，显示详细信息
      window.setInterval(() => {
        peopleChart.dispatchAction({
          type: 'hideTip'
        });
        addChart.dispatchAction({
          type: 'hideTip'
        });
        depChart.dispatchAction({
          type: 'hideTip'
        });
        patrolChart.dispatchAction({
          type: 'hideTip'
        });
        camChart.dispatchAction({
          type: 'hideTip'
        });
        manChart.dispatchAction({
          type: 'hideTip'
        });
        switch (index) {
          case 1:
            let _index1 = index1;
            if (index1 === 0) {
              _index1 = peopleOption.series[0].data.length - 2;
            } else {
              _index1 = index1 - 2;
            }

            peopleChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index1
            });
            peopleChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index1
            });
            peopleChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index1
            });
            index1 += 2;
            if (index1 >= peopleOption.series[0].data.length) {
              index1 = 0;
            }
            break;
          case 2:
            let _index2 = index2;
            if (index2 === 0) {
              _index2 = addOption.series[0].data.length - 2;
            } else {
              _index2 = index2 - 2;
            }

            addChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index2
            });
            addChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index2
            });
            addChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index2
            });
            index2 += 2;
            if (index2 >= addOption.series[0].data.length) {
              index2 = 0;
            }
            break;
          case 3:
            let _index3 = index3;
            if (index3 === 0) {
              _index3 = depOption.series[0].data.length - 2;
            } else {
              _index3 = index3 - 2;
            }

            depChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index3
            });
            depChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index3
            });
            depChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index3
            });
            index3 += 2;
            if (index3 >= depOption.series[0].data.length) {
              index3 = 0;
            }
            break;
          case 4:
            let _index4 = index4;
            if (index4 === 0) {
              _index4 = patrolOption.series[0].data.length - 2;
            } else {
              _index4 = index4 - 2;
            }

            patrolChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index4
            });
            patrolChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index4
            });
            patrolChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index4
            });
            index4 += 2;
            if (index4 >= patrolOption.series[0].data.length) {
              index4 = 0;
            }
            break;
          case 5:
            let _index5 = index5;
            if (index5 === 0) {
              _index5 = camOption.series[0].data.length - 2;
            } else {
              _index5 = index5 - 2;
            }

            camChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index5
            });
            camChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index5
            });
            camChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index5
            });
            index5 += 2;
            if (index5 >= camOption.series[0].data.length) {
              index5 = 0;
            }
            break;
          case 6:
            let _index6 = index6;
            if (index6 === 0) {
              _index6 = manOption.series[0].data.length - 2;
            } else {
              _index6 = index6 - 2;
            }

            manChart.dispatchAction({
              type: 'downplay',
              seriesIndex: 0,
              dataIndex: _index6
            });
            manChart.dispatchAction({
              type: 'highlight',
              seriesIndex: 0,
              dataIndex: index6
            });
            manChart.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: index6
            });
            index6 += 2;
            if (index6 >= manOption.series[0].data.length) {
              index6 = 0;
            }
            break;
        }
        index++;
        if (index > 6) {
          index = 1;
        }
      }, 2000);
    }
  }
</script>

<style scoped>
  .stat-device {
    right: 0;
    top: 85px;
  }

  .stat-body {
    color: #fff;
    height: 280px;
    width: 415px;
  }

  .row {
    width: 100%;
    margin-left: 26px;
  }

  .chartRowHeight {
    margin-top: 5px;
    height: 120px;
    width: 125px;
    float: left;
  }
</style>
