<template>
  <div class="toolResult">
    <div id="moveResult" class="moveResult">
      <div id="moveResultCon" class="moveResultCon"></div>
      <div class="box_lt"></div>
      <div class="box_lb"></div>
      <div class="box_rt"></div>
      <div class="box_rb"></div>
    </div>
    <div id="cammoveResult" class="cammoveResult">
      <div id="cammoveResultCon" class="cammoveResultCon"></div>
      <div class="box_lt"></div>
      <div class="box_lb"></div>
      <div class="box_rt"></div>
      <div class="box_rb"></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "tool-result",
    data() {
      return {};
    },
  }
</script>

<style scoped>
  /* measure */
  .toolResult {
    right: 435px;
    bottom: 3px;
    position: absolute;
    z-index: 2000;
    color: #fff;
  }

  .moveResult {
    display: none;
    background-color: #11264DD1;
    padding: 0 5px;
    border: 1px solid rgba(255, 255, 255, .1);
    box-sizing: content-box;
    width: 220px;
    height: 30px;
    font-size: 14px;
    text-align: center;
    float: right
  }

  .cammoveResult {
    display: none;
    background-color: #11264DD1;
    padding: 0 5px;
    border: 1px solid rgba(255, 255, 255, .1);
    box-sizing: content-box;
    width: 370px;
    height: 30px;
    font-size: 14px;
    text-align: center;
    float: left;
  }

  .moveResultCon {
    margin-top: 4px
  }

  .cammoveResultCon {
    margin-top: 4px
  }

  .box_lt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    top: 0;
    border-color: #00d3e7;
  }

  .box_rt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    top: 0;
    border-color: #00d3e7;
  }

  .box_rb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    bottom: 0;
    border-color: #00d3e7;
  }

  .box_lb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    bottom: 0;
    border-color: #00d3e7;
  }
</style>
