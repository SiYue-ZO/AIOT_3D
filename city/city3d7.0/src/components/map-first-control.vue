<template>
  <div id="map-first-control-is-show">
    <div class="note">键盘按钮对应动作：</div>
    <div class="emer-row center">
      <el-button class="keyBoard-btn loc-up-left">上:Q</el-button>
      <el-button class="keyBoard-btn" type="primary">前:W</el-button>
      <el-button class="keyBoard-btn loc-up-right">下:E</el-button>
    </div>
    <div class="emer-row center">
      <el-button class="keyBoard-btn" type="success" @click="startFirstControl" v-show="isStarted">开</el-button>
      <el-button class="keyBoard-btn" type="danger" @click="stopFirtControl" v-show="!isStarted">关</el-button>
    </div>
    <div class="emer-row center">
      <el-button class="keyBoard-btn loc-down-left" type="warning">左:A</el-button>
      <el-button class="keyBoard-btn" type="primary">后:S</el-button>
      <el-button class="keyBoard-btn loc-down-right" type="warning">右:D</el-button>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">飞行速度</div>
      <el-input-number size="small" v-model="speed" :step="0.1" :max="10" :min="0"></el-input-number>
    </div>
    <div class="note">操作提示：飞行发生偏斜时，关闭第一人称视角，点击鼠标中间可恢复平视</div>
  </div>
</template>

<script>
  import CesiumKeyBoardControl from "../js/CesiumKeyBoardControl";

  let cesiumKeyBoardControl;

  export default {
    name: "map-first-control",
    data() {
      return {
        isStarted: true,
        speed: 1
      };
    },
    methods: {
      startFirstControl() {
        cesiumKeyBoardControl.start();
        this.isStarted = false;
      },
      stopFirtControl() {
        cesiumKeyBoardControl.stop();
        this.isStarted = true;
      }
    },
    watch: {
      speed: function (val, oldVal) {
        cesiumKeyBoardControl.moveSpeed = val;
      }
    },
    mounted() {
      cesiumKeyBoardControl = new CesiumKeyBoardControl(viewer);
    }
  }
</script>

<style scoped>
  .emer-row {
    color: #ffffff;
    margin: 8px 0;
    height: 50px;
  }

  .emer-row-label {
    width: 75px;
    font-size: 15px;
    margin-top: 5px;
    float: left;
    text-align: right;
    padding-right: 10px;
  }

  .note {
    color: #ffffff;
  }

  .keyBoard-btn {
    background: none;
    border-radius: 6px;
    color: #ffffff;
  }

  .center {
    text-align: center;
  }

  .loc-up-left {
    position: absolute;
    top: 110px;
    left: 75px;
  }

  .loc-up-right {
    position: absolute;
    top: 110px;
    left: 260px;
  }

  .loc-down-left {
    position: absolute;
    top: 170px;
    left: 75px;
  }

  .loc-down-right {
    position: absolute;
    top: 170px;
    left: 260px;
  }
</style>
