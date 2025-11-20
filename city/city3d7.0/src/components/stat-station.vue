<template>
  <div id="stat-station" class="stat-window stat-station">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['fas', 'project-diagram']" fixed-width></font-awesome-icon>
        外勤统计（今日）
      </div>
      <div class="title-font" style="top:55px;left:20px">
        <font-awesome-icon class="stat-fai" :icon="['fas', 'project-diagram']" fixed-width></font-awesome-icon>
        巡逻公里数：
      </div>
      <countTo class="DS-font" style="top:55px;left:158px;"
               :startVal='station_startVal' :endVal='station_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:55px;left:220px">
        <font-awesome-icon class="stat-fai" :icon="['fas', 'map-pin']" fixed-width></font-awesome-icon>
        巡逻点位数：
      </div>
      <countTo class="DS-font" style="top:55px;left:337px;"
               :startVal='security_startVal' :endVal='security_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:95px;left:20px">
        <font-awesome-icon class="stat-fai" :icon="['fas', 'chess-rook']" fixed-width></font-awesome-icon>
        巡视消防单位：
      </div>
      <countTo class="DS-font" style="top:95px;left:158px;"
               :startVal='patrolPoint_startVal' :endVal='patrolPoint_endVal' :duration='3600'></countTo>
      <div class="title-font" style="top:95px;left:220px">
        <font-awesome-icon class="stat-fai" :icon="['fas', 'code-branch']" fixed-width></font-awesome-icon>
        巡视早夜市：
      </div>
      <countTo class="DS-font" style="top:95px;left:337px;"
               :startVal='patrolLine_startVal' :endVal='patrolLine_endVal' :duration='3600'></countTo>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  import countTo from 'vue-count-to';

  export default {
    name: "stat-station",
    components: {countTo},//数字动态效果
    data() {
      return {
        station_startVal: 348,
        station_endVal: 348,
        patrolPoint_startVal: 52,
        patrolPoint_endVal: 52,
        security_startVal: 16,
        security_endVal: 16,
        patrolLine_startVal: 14,
        patrolLine_endVal: 14,
      }
    },
    mounted() {
      window.setInterval(() => {
        this.station_endVal += parseInt(Math.random() * 10);
        this.patrolPoint_endVal += parseInt(Math.random() * 10);
        this.security_endVal += parseInt(Math.random() * 10);
        this.patrolLine_endVal += parseInt(Math.random() * 10);
      }, 5000);
    }
  }
</script>

<style scoped>
  .stat-station {
    right: 0;
    top: 420px;
  }

  .stat-body {
    color: #fff;
    height: 120px;
    width: 415px;
  }

  .title-font {
    font-size: 15px;
    position: absolute;
    height: 27px;
    padding: 4px 0 0 8px;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 24px;
    height: 28px;
    width: 60px;
    position: absolute;
    padding-top: 2px;
    text-align: center;
  }

  .stat-fai {
    margin: 0 4px 0 0;
    font-size: 14px;
    color: #ff8e54;
  }
</style>
