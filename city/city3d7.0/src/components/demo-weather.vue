<template>
  <div id="demo-weather-is-show">
    <div class="pop-fai pop-fai-stop" @click="closeWeather" title="清除效果">
      <font-awesome-icon :icon="['far', 'trash-alt']" fixed-width></font-awesome-icon>
    </div>
    <div style="margin:20px 0 0 10px">
      <el-button class="my-button" type="primary" v-on:click="openRainHigh">大雨</el-button>
      <el-button class="my-button" type="primary" v-on:click="openRainMid">中雨</el-button>
      <el-button class="my-button" type="primary" v-on:click="openRainLow">小雨</el-button>
    </div>
    <div style="margin:20px 0 0 10px">
      <el-button class="my-button" type="success" v-on:click="openSnowHigh">大雪</el-button>
      <el-button class="my-button" type="success" v-on:click="openSnowMid">中雪</el-button>
      <el-button class="my-button" type="success" v-on:click="openSnowLow">小雪</el-button>
    </div>
    <div style="margin:20px 0 0 10px">
      <el-button class="my-button" type="warning" v-on:click="openFogHigh">浓雾</el-button>
      <el-button class="my-button" type="warning" v-on:click="openFogMid">大雾</el-button>
      <el-button class="my-button" type="warning" v-on:click="openFogLow">薄雾</el-button>
    </div>
  </div>
</template>

<script>
  import CesiumWeather from "../js/CesiumWeather";
  import map3d from "./map-3d";

  let weatherEffect;
  export default {
    name: "demo-weather",
    methods: {
      //开启雨天效果
      openRainHigh() {
        viewer.scene.skyAtmosphere.saturationShift = -0.75;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.2;//天空亮度
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openRainEffect("1.");
      },
      openRainMid() {
        viewer.scene.skyAtmosphere.saturationShift = -0.5;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.1;//天空亮度
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openRainEffect("4.");
      },
      openRainLow() {
        viewer.scene.skyAtmosphere.saturationShift = -0.2;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.05;//天空亮度
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openRainEffect("10.");
      },
      //开启雪天效果
      openSnowHigh() {
        viewer.scene.skyAtmosphere.saturationShift = -0.75;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.2;//天空亮度
        map3d.methods.coverTilesetSnow(0.7);
        weatherEffect.openSnowEffect(1);
      },
      openSnowMid() {
        viewer.scene.skyAtmosphere.saturationShift = -0.5;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.1;//天空亮度
        map3d.methods.coverTilesetSnow(0.5);
        weatherEffect.openSnowEffect(1.5);
      },
      openSnowLow() {
        viewer.scene.skyAtmosphere.saturationShift = -0.2;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = -0.05;//天空亮度
        map3d.methods.coverTilesetSnow(0.3);
        weatherEffect.openSnowEffect(2);
      },
      //开启雾天效果
      openFogHigh() {
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openFogEffect(0.7);
      },
      openFogMid() {
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openFogEffect(0.76);
      },
      openFogLow() {
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.openFogEffect(0.81);
      },
      //关闭天气效果
      closeWeather() {
        viewer.scene.skyAtmosphere.saturationShift = 0;//饱和度
        viewer.scene.skyAtmosphere.brightnessShift = 0.35;//天空亮度
        map3d.methods.clearCoverTilesetSnow();
        weatherEffect.closeWeatherEffects();
      },
      initWeather() {
        weatherEffect = new CesiumWeather(viewer);
      }
    },
    mounted() {
      this.initWeather();
    }
  }
</script>

<style scoped>
  .my-button {
    padding: 12px 16px;
    font-size: 15px;
  }

  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e600c3;
  }
</style>
