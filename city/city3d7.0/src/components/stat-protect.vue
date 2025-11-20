<template>
  <div id="stat-protect" class="stat-window stat-protect">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['far', 'bell']" fixed-width></font-awesome-icon>
        智能安防
      </div>
      <font-awesome-layers class="stat-fai" style="top:68px;left:24px;color: #ff45ed;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'bell']" transform="shrink-6"/>
      </font-awesome-layers>
      <div class="title-font" style="top:55px;left:70px">
        AI识别报警
      </div>
      <countTo class="DS-font" style="top:87px;left:70px" :startVal='alarmRecord_startVal' :endVal='alarmRecord_endVal'
               :duration='3600'></countTo>
      <font-awesome-layers class="stat-fai" style="top:68px;left:207px;color: #ff8600;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fas', 'bolt']" transform="shrink-6"/>
      </font-awesome-layers>
      <div class="title-font" style="top:55px;left:250px">
        智能物联报警
      </div>
      <countTo class="DS-font" style="top:87px;left:250px" :startVal='alarmWall_startVal' :endVal='alarmWall_endVal'
               :duration='3600'></countTo>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  import countTo from 'vue-count-to';

  export default {
    name: "stat-protect",
    components: {countTo},//数字增长动态效果
    data() {
      return {
        alarmRecord_startVal: 1634,
        alarmRecord_endVal: 1638,
        alarmWall_startVal: 607,
        alarmWall_endVal: 613,
      }
    },
    mounted() {
      window.setInterval(() => {
        this.alarmRecord_endVal += parseInt(Math.random() * 10);
        this.alarmWall_endVal += parseInt(Math.random() * 10);
      }, 5000);
    }
  }
</script>

<style scoped>
  .stat-protect {
    left: 0;
    top: 85px;
  }

  .stat-body {
    color: #fff;
    height: 110px;
    width: 415px;
  }

  .title-font {
    font-size: 15px;
    position: absolute;
    background-color: #ffffff1E;
    width: 130px;
    height: 27px;
    padding-top: 3px;
    text-align: center;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 24px;
    height: 28px;
    width: 130px;
    position: absolute;
    background-color: #ffffff3E;
    padding-top: 2px;
    text-align: center;
  }

  .stat-fai {
    font-size: 34px;
    position: absolute;
    color: #00ffff;
  }
</style>
