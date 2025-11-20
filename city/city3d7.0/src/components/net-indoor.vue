<template>
  <div id="net-indoor-is-show">
    <div class="emer-row">
      <span class="emer-row-label">三维透明度</span>
      <el-slider class="emer-slider" v-model="alpha" :format-tooltip="formatTooltip" @change="setAlpha"></el-slider>
    </div>
    <div class="emer-row">
      <el-slider style="top:60px" v-model="floor" vertical height="200px" :step="25" show-stops
                 :marks="marks" :show-tooltip="false" @change="changeFloor"></el-slider>
    </div>
  </div>
</template>

<script>
  import map3d from "./map-3d";

  let marksStyle = {
    color: '#ffffff',
    width: '300px',
    padding: '5px'
  };
  export default {
    name: "net-indoor",
    data() {
      return {
        alpha: 100,
        floor: 100,
        marks: {
          0: {
            style: marksStyle,
            label: this.$createElement('strong', '1层 - 铁炉堡科技开发有限公司')
          },
          25: {
            style: marksStyle,
            label: this.$createElement('strong', '2层 - 赛博坦信息技术有限公司')
          },
          50: {
            style: marksStyle,
            label: this.$createElement('strong', '3层 - 银月城科技开发有限公司')
          },
          75: {
            style: marksStyle,
            label: this.$createElement('strong', '4层 - Cesium地理信息技术有限公司')
          },
          100: {
            style: marksStyle,
            label: this.$createElement('strong', '5层 - city3d科技有限公司')
          },
        }
      }
    },
    methods: {
      formatTooltip(val) {
        return val / 100;
      },
      setAlpha() {
        map3d.methods.resetTilesetAlpha(this.alpha / 100);
      },
      changeFloor() {

      }
    },
    mounted() {
    }
  }
</script>

<style scoped>
  .emer-row {
    color: #ffffff;
    margin: 8px 0;
  }

  .emer-row-label {
    width: 90px;
    font-size: 15px;
    margin: 8px 0 0 7px;
    float: left;
  }

  .emer-slider {
    width: 250px;
    float: left;
  }
</style>
