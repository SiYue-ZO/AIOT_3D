<template>
  <div class="stat-video">
    <img class="stat-title" src="../assets/ui5/ui5-stat-title-video.png" alt=""/>
    <img class="stat-back-1" src="../assets/ui5/ui5-stat-btn-back.png" alt=""/>
    <div class="stat-left-1">
      <div class="stat-text stat-text-1">32</div>
      <div class="stat-text stat-text-2">32</div>
      <img class="stat-left-1-img" src="../assets/ui5/ui5-stat-right-1.png" alt=""/>
      <img class="stat-right-1-img-1" src="../assets/ui5/ui5-stat-right-img-1.png" alt=""/>
      <img class="stat-right-1-img-2" src="../assets/ui5/ui5-stat-right-img-1.png" alt=""/>
    </div>
    <div class="stat-left-2">
      <div class="stat-text-small stat-text-2-1">98</div>
      <div class="stat-text-small stat-text-2-2">98</div>
      <div class="stat-text-small stat-text-2-3">6.7</div>
      <div class="stat-text-color-1 stat-text-2-4">良好</div>
      <img class="stat-right-2-img" src="../assets/ui5/ui5-stat-right-2.png" alt=""/>
    </div>
    <div class="stat-left-3">
      <img class="stat-left-3-img" src="../assets/ui5/ui5-stat-right-3.png" alt=""/>
      <div class="stat-text-color-1 stat-text-3-1">情 况 正 常</div>
      <img class="stat-left-3-con" src="../assets/ui5/ui5-stat-right-3-con.png" alt=""/>
    </div>
    <div class="stat-left-4">
      <div class="stat-text-small stat-text-2-1">64</div>
      <div class="stat-text-small stat-text-4-2">167</div>
      <img class="stat-right-4-img" src="../assets/ui5/ui5-stat-right-4.png" alt=""/>
    </div>
    <div class="stat-left-5">
      <div class="stat-text-small stat-text-5-1">22</div>
      <div class="stat-text-small stat-text-5-2">29</div>
      <div class="stat-text-small stat-text-5-3">49</div>
      <img class="stat-right-5-img" src="../assets/ui5/ui5-stat-right-5.png" alt=""/>
      <img class="stat-right-5-con" src="../assets/ui5/ui5-stat-right-5-con.png" alt=""/>
    </div>
    <div class="stat-left-6">
      <div class="stat-text-color-2 stat-text-6-1">第 2 名</div>
      <div class="stat-text-medium stat-text-6-2">93.28</div>
      <img class="stat-right-6-img" src="../assets/ui5/ui5-stat-right-6.png" alt=""/>
      <img class="stat-right-6-con" src="../assets/ui5/ui5-stat-right-6-con.png" alt=""/>
    </div>
  </div>
</template>

<script>
  export default {
    name: "stat-video"
  }
</script>

<style scoped>
  .stat-video {
    position: absolute;
    z-index: 1002;
    width: 491px;
    height: 960px;
    left: 75px;
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

  .stat-right-1-img-1 {
    position: absolute;
    z-index: 1002;
    top: 68px;
    left: 150px;
    width: 204px;
  }

  .stat-right-1-img-2 {
    position: absolute;
    z-index: 1002;
    top: 197px;
    left: 150px;
    width: 204px;
  }

  .stat-text {
    color: #ffffff;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 50px;
  }

  .stat-text-1 {
    position: absolute;
    top: 83px;
    left: 43px;
  }

  .stat-text-2 {
    position: absolute;
    top: 212px;
    left: 43px;
  }

  .stat-back-1 {
    width: 25px;
    position: absolute;
    top: 10px;
    left: 340px;
    cursor: pointer;
  }

  .stat-left-2 {
    width: 345px;
    height: 105px;
    position: absolute;
    top: 325px;
    left: 15px;
  }

  .stat-right-2-img {
    width: 345px;
  }

  .stat-text-small {
    color: #ffffff;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 26px;
  }

  .stat-text-2-1 {
    position: absolute;
    top: 16px;
    left: 110px;
  }

  .stat-text-2-2 {
    position: absolute;
    top: 16px;
    left: 275px;
  }

  .stat-text-2-3 {
    position: absolute;
    top: 59px;
    left: 123px;
  }

  .stat-text-2-4 {
    position: absolute;
    top: 58px;
    left: 280px;
  }

  .stat-text-color-1 {
    color: #00ffc6;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 22px;
  }

  .stat-left-3 {
    width: 345px;
    height: 230px;
    position: absolute;
    top: 445px;
    left: 15px;
  }

  .stat-left-3-img {
    width: 345px;
  }

  .stat-text-3-1 {
    position: absolute;
    top: 20px;
    left: 35px;
    width: 60px;
  }

  .stat-left-3-con {
    width: 204px;
    position: absolute;
    top: 7px;
    left: 134px;
  }

  .stat-left-4 {
    width: 345px;
    height: 61px;
    position: absolute;
    top: 585px;
    left: 15px;
  }

  .stat-right-4-img {
    width: 345px;
  }

  .stat-text-4-2 {
    position: absolute;
    top: 16px;
    left: 265px;
  }

  .stat-left-5 {
    width: 345px;
    height: 134px;
    position: absolute;
    top: 665px;
    left: 15px;
  }

  .stat-right-5-img {
    width: 345px;
  }

  .stat-right-5-con {
    width: 345px;
    position: absolute;
    top: 0;
    left: 0;
  }

  .stat-text-5-1 {
    position: absolute;
    top: 16px;
    left: 265px;
  }

  .stat-text-5-2 {
    position: absolute;
    top: 50px;
    left: 265px;
  }

  .stat-text-5-3 {
    position: absolute;
    top: 83px;
    left: 265px;
  }

  .stat-left-6 {
    width: 345px;
    height: 134px;
    position: absolute;
    top: 815px;
    left: 15px;
  }

  .stat-right-6-img {
    width: 345px;
  }

  .stat-right-6-con {
    width: 345px;
    position: absolute;
    top: 0;
    left: 0;
  }

  .stat-text-6-1 {
    position: absolute;
    top: 16px;
    left: 200px;
  }

  .stat-text-6-2 {
    position: absolute;
    top: 80px;
    left: 188px;
  }

  .stat-text-color-2 {
    color: #fff286;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 22px;
  }

  .stat-text-medium {
    color: #ffffff;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 38px;
  }
</style>
