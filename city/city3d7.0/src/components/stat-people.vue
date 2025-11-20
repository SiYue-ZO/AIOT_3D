<template>
  <div id="stat-people" class="stat-window stat-people">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['fas', 'user-shield']" fixed-width></font-awesome-icon>
        综合治理
      </div>
      <div class="title-font" style="top:55px;left:25px;height:40px;line-height:40px;width:100px;font-size:18px;">
        总人口
      </div>
      <countTo class="DS-font" style="top:95px;left:25px;height:60px;line-height:60px;width:100px;font-size:30px;"
               :startVal='totalPeople_startVal' :endVal='totalPeople_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:55px;left:125px;width:100px;">
        重点人口
      </div>
      <countTo class="DS-font" style="top:80px;left:125px;width:100px;"
               :startVal='keyPeople_startVal' :endVal='keyPeople_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:105px;left:125px;width:100px;">
        流动人口
      </div>
      <countTo class="DS-font" style="top:130px;left:125px;width:100px;"
               :startVal='flowPeople_startVal' :endVal='flowPeople_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:55px;left:225px">
        地名地址
      </div>
      <countTo class="DS-font" style="top:55px;left:305px;"
               :startVal='address_startVal' :endVal='address_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:80px;left:225px">
        实有房屋
      </div>
      <countTo class="DS-font" style="top:80px;left:305px;"
               :startVal='house_startVal' :endVal='house_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:105px;left:225px">
        实有单位
      </div>
      <countTo class="DS-font" style="top:105px;left:305px;"
               :startVal='department_startVal' :endVal='department_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:130px;left:225px">
        行业场所
      </div>
      <countTo class="DS-font" style="top:130px;left:305px;"
               :startVal='business_startVal' :endVal='business_endVal' :duration='3600'></countTo>
      <div id="peopleStat" class="people-stat"></div>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  import echarts from 'echarts';
  import countTo from 'vue-count-to';//文字增长的动态效果

  let peopleStat;
  let peopleStatOption;
  export default {
    name: "stat-people",
    components: {countTo},
    data() {
      return {
        totalPeople_startVal: 368975,
        keyPeople_startVal: 1063,
        flowPeople_startVal: 4589,
        house_startVal: 9269,
        department_startVal: 1452,
        business_startVal: 8569,
        address_startVal: 26223,
        totalPeople_endVal: 368975,
        keyPeople_endVal: 1063,
        flowPeople_endVal: 4589,
        house_endVal: 9269,
        department_endVal: 1452,
        business_endVal: 8569,
        address_endVal: 26223,
      }
    },
    methods: {
      showPeopleStat() {
        peopleStat = this.$echarts.init(document.getElementById("peopleStat"), 'dark');
        peopleStatOption = {
          legend: {top: '30px'},
          tooltip: {},
          toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: false, readOnly: false},
              saveAsImage: {show: false}
            }
          },
          backgroundColor: 'rgba(255, 255, 255, 0)',
          xAxis: [{
            type: 'category',
            data: ['毒', '案', '精', '访', '失', '监', '疆', '藏', '其'],
          }],
          yAxis: {},
          series: [
            {
              name: '女',
              type: 'bar',
              data: [166, 124, 383, 38, 357, 88, 56, 86, 145],
              itemStyle: {
                color: new echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [
                    {offset: 0, color: '#83bff6'},
                    {offset: 0.3, color: '#188df0'},
                    {offset: 1, color: '#188df000'}
                  ]
                )
              },
            },
            {
              name: '男',
              type: 'bar',
              data: [466, 694, 367, 74, 83, 247, 274, 111, 178],
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
            // {
            //   name: '合计',
            //   data: [632, 1008, 690, 192, 240, 335, 330, 197, 123],
            //   type: 'line',
            //   smooth: true,
            //   itemStyle: {
            //     type: 'normal',
            //     color: '#00ffd8'
            //   },
            // },
          ]
        };
        peopleStat.setOption(peopleStatOption);
      }
    },
    mounted() {
      this.showPeopleStat();
      let index = 0;
      window.setInterval(() => {
        this.totalPeople_endVal += parseInt(Math.random() * 10);
        this.keyPeople_endVal += parseInt(Math.random() * 10);
        this.flowPeople_endVal += parseInt(Math.random() * 10);
        this.house_endVal += parseInt(Math.random() * 10);
        this.department_endVal += parseInt(Math.random() * 10);
        this.business_endVal += parseInt(Math.random() * 10);
        this.address_endVal += parseInt(Math.random() * 10);
      }, 10000);
      window.setInterval(() => {
        if (index % 2 === 0) {
          peopleStat.dispatchAction({
            type: 'showTip',
            seriesIndex: 0,
            dataIndex: index / 2
          });
        } else {
          peopleStat.dispatchAction({
            type: 'showTip',
            seriesIndex: 1,
            dataIndex: (index - 1) / 2
          });
        }
        index++;
        if (index > peopleStatOption.series[0].data.length * 2) {
          index = 0;
        }
      }, 2000);
    }
  }
</script>

<style scoped>
  .stat-people {
    left: 0;
    top: 250px;
  }

  .stat-body {
    color: #fff;
    height: 410px;
    width: 415px;
  }

  .people-stat {
    color: #fff;
    width: 380px;
    height: 320px;
    margin-left: 15px;
    top: 100px;
  }

  .title-font {
    font-size: 15px;
    position: absolute;
    z-index: 10;
    background-color: #ffffff1E;
    height: 25px;
    line-height: 25px;
    text-align: center;
    vertical-align: middle;
    width: 80px;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 24px;
    position: absolute;
    z-index: 10;
    background-color: #ffffff1E;;
    text-align: center;
    vertical-align: middle;
    line-height: 25px;
    height: 25px;
    width: 80px;
  }

</style>
