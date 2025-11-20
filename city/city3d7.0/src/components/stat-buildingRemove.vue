<template>
  <div id="stat-buildingRemove" class="stat-window stat-buildingRemove">
    <img class="stat-top" src="../assets/window/window_top.png"/>
    <div class="stat-middle stat-body">
      <div class="stat-content textshadow-p">
        <font-awesome-icon :icon="['far', 'bell']" fixed-width></font-awesome-icon>
        数量统计
      </div>

      <font-awesome-layers class="stat-fai" style="top:78px;left:24px;color: #ff123e;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fas', 'user-plus']" transform="shrink-9"/>
      </font-awesome-layers>
      <div class="title-font" style="top:65px;left:70px">
        权利人总数
      </div>
      <div class="DS-font" style="top:97px;left:70px">{{nameNum}}</div>

      <font-awesome-layers class="stat-fai" style="top:78px;left:207px;color: #ff8600;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fas', 'home']" transform="shrink-7"/>
      </font-awesome-layers>
      <div class="title-font" style="top:65px;left:250px">
        房屋总数
      </div>
      <div class="DS-font" style="top:97px;left:250px">{{addNum}}</div>

      <font-awesome-layers class="stat-fai" style="top:178px;left:24px;color: #00ff0a;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fab', 'buffer']" transform="shrink-6"/>
      </font-awesome-layers>
      <div class="title-font" style="top:165px;left:70px">
        地块总数
      </div>
      <div class="DS-font" style="top:197px;left:70px">{{landNum}}</div>

      <font-awesome-layers class="stat-fai" style="top:178px;left:207px;color: #00d0ff;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fas', 'calculator']" transform="shrink-8"/>
      </font-awesome-layers>
      <div class="title-font" style="top:165px;left:250px">
        土地证总面积
      </div>
      <div class="DS-font" style="top:197px;left:250px">{{landArea}}</div>

      <font-awesome-layers class="stat-fai" style="top:278px;left:24px;color: #ff45ed;" fixed-width>
        <font-awesome-icon class="textshadow-i" :icon="['far', 'circle']"/>
        <font-awesome-icon class="textshadow-i" :icon="['fas', 'file']" transform="shrink-8"/>
      </font-awesome-layers>
      <div class="title-font" style="top:265px;left:70px">
        房产证总面积
      </div>
      <div class="DS-font" style="top:297px;left:70px">{{houseArea}}</div>
    </div>
    <img class="stat-bottom" src="../assets/window/window_bottom.png"/>
  </div>
</template>

<script>
  import {
    countAddress,
    countBuildingRemove,
    countBuildingRemoveLand,
    sumBuildingRemoveHouseArea,
    sumBuildingRemoveLandArea
  } from "../api/api";

  let _this;
  export default {
    name: "stat-buildingRemove",
    data() {
      return {
        nameNum: 0,
        addNum: 1,
        landNum: 2,
        landArea: 3,
        houseArea: 4,
      }
    },
    methods: {
      freshStat() {
        countBuildingRemove().then(res => {
          _this.nameNum = res.data;
        });
        countAddress().then(res => {
          _this.addNum = res.data;
        });
        countBuildingRemoveLand().then(res => {
          _this.landNum = res.data;
        });
        sumBuildingRemoveLandArea().then(res => {
          _this.landArea = res.data.toFixed(1);
        });
        sumBuildingRemoveHouseArea().then(res => {
          _this.houseArea = res.data.toFixed(1);
        });
      }
    },
    mounted() {
      _this = this;
      _this.freshStat();
      window.setInterval(() => {
        _this.freshStat();
      }, 300000);
    }
  }
</script>

<style scoped>
  .stat-buildingRemove {
    left: 0;
    top: 85px;
  }

  .stat-body {
    color: #fff;
    height: 350px;
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
