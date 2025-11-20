<template>
  <div class="stat-construction">
    <img class="stat-title" src="../assets/ui5/ui5-stat-title-con.png" alt=""/>
    <img class="stat-back-1" src="../assets/ui5/ui5-stat-btn-back.png" alt=""/>
    <div class="stat-left-1">
      <div class="stat-text stat-text-1">72</div>
      <div class="stat-text stat-text-2">238</div>
      <div class="stat-text stat-text-3">80</div>
      <div class="stat-text stat-text-4">170</div>
      <img class="stat-left-1-img" src="../assets/ui5/ui5-stat-left-1.png" alt=""/>
    </div>
    <div class="stat-left-2">
      <img class="stat-left-2-img" src="../assets/ui5/ui5-stat-left-2.png" alt=""/>
      <img class="stat-left-2-con" src="../assets/ui5/ui5-stat-left-2-con.png" alt=""/>
    </div>
    <div class="stat-left-3">
      <img class="stat-left-3-img" src="../assets/ui5/ui5-stat-left-3.png" alt=""/>
      <img class="stat-left-3-con" src="../assets/ui5/ui5-stat-left-3-con.png" alt=""/>
    </div>
    <div class="split-line"></div>
    <img class="stat-title-1" src="../assets/ui5/ui5-stat-title-ill.png" alt=""/>
    <div class="stat-left-4">
      <div class="stat-text stat-text-4-1">72</div>
      <div class="stat-text stat-text-4-2">238</div>
      <div class="stat-text stat-text-4-3">80</div>
      <div class="stat-text stat-text-4-4">170</div>
      <img class="stat-left-4-img" src="../assets/ui5/ui5-stat-left-4.png" alt=""/>
    </div>
    <img class="stat-back-2" src="../assets/ui5/ui5-stat-btn-back.png" alt=""/>
    <div class="stat-left-5">
      <img class="stat-left-5-img" src="../assets/ui5/ui5-stat-left-5.png" alt=""/>
      <img class="stat-left-5-con" src="../assets/ui5/ui5-stat-left-5-con.png" alt=""/>
    </div>
  </div>
</template>

<script>
  export default {
    name: "stat-construction"
  }
</script>

<style scoped>
  .stat-construction {
    position: absolute;
    z-index: 1002;
    width: 491px;
    height: 960px;
    left: 20px;
  }

  .stat-title {
    width: 127px;
    margin: 13px 0 0 17px
  }

  .stat-left-1 {
    width: 345px;
    height: 105px;
    margin: 10px 0 0 17px
  }

  .stat-left-1-img {
    width: 345px;
  }

  .stat-text {
    color: #ffffff;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 26px;
  }

  .stat-text-1 {
    position: absolute;
    top: 75px;
    left: 130px;
  }

  .stat-text-2 {
    position: absolute;
    top: 75px;
    left: 280px;
  }

  .stat-text-3 {
    position: absolute;
    top: 119px;
    left: 130px;
  }

  .stat-text-4 {
    position: absolute;
    top: 119px;
    left: 280px;
  }

  .stat-left-2 {
    width: 345px;
    height: 192px;
    margin: 15px 0 0 17px
  }

  .stat-left-2-img {
    width: 345px;
  }

  .stat-left-2-con {
    width: 345px;
    position: absolute;
    top: 180px;
    left: 10px;
  }

  .stat-left-3 {
    width: 345px;
    height: 230px;
    margin: 15px 0 0 17px
  }

  .stat-left-3-img {
    width: 345px;
  }

  .stat-left-3-con {
    width: 345px;
    position: absolute;
    top: 400px;
    left: 16px;
  }

  .stat-back-1 {
    width: 25px;
    position: absolute;
    top: 10px;
    left: 340px;
    cursor: pointer;
  }

  .split-line {
    width: 350px;
    position: absolute;
    left: 10px;
    border-top: #9fdaff2D solid 1px;
    margin-top: 6px;
  }

  .stat-title-1 {
    width: 94px;
    margin: 20px 0 0 17px
  }

  .stat-left-4 {
    width: 345px;
    height: 105px;
    margin: 10px 0 0 17px
  }

  .stat-left-4-img {
    width: 345px;
  }

  .stat-text-4-1 {
    position: absolute;
    top: 698px;
    left: 130px;
  }

  .stat-text-4-2 {
    position: absolute;
    top: 698px;
    left: 280px;
  }

  .stat-text-4-3 {
    position: absolute;
    top: 742px;
    left: 130px;
  }

  .stat-text-4-4 {
    position: absolute;
    top: 742px;
    left: 280px;
  }

  .stat-back-2 {
    width: 25px;
    position: absolute;
    top: 630px;
    left: 340px;
    cursor: pointer;
  }

  .stat-left-5 {
    width: 345px;
    height: 140px;
    margin: 23px 0 0 17px
  }

  .stat-left-5-img {
    width: 345px;
  }

  .stat-left-5-con {
    width: 345px;
    position: absolute;
    top: 808px;
    left: 16px;
  }
</style>
