<template>
  <div id="duty-stream-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startStream" title="播放">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="stopStream" title="停止清除">
      <font-awesome-icon :icon="['fas', 'stop']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <el-slider style="top:25px;left:15px" v-model="step" vertical height="400px" :step="10" show-stops
                 :format-tooltip="formatTooltip"
                 :marks="marks" :show-tooltip="false" @change="changeStep"></el-slider>
    </div>
  </div>
</template>

<script>
  import {queryPoliceLine} from "../api/api";
  import {stringToNumber} from "../js/CesiumTools";

  let _this;
  let peopleRouteArr = [];
  let dutyStreamInterval;
  let marksStyle = {
    color: '#ffffff',
    width: '300px',
    padding: '5px'
  };

  export default {
    name: "duty-stream",
    data() {
      return {
        step: 100,
        marks: {
          0: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月22日__人流车流密度')
          },
          10: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月23日__人流车流密度')
          },
          20: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月24日__人流车流密度')
          },
          30: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月25日__人流车流密度')
          },
          40: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月26日__人流车流密度')
          },
          50: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月27日__人流车流密度')
          },
          60: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月28日__人流车流密度')
          },
          70: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月29日__人流车流密度')
          },
          80: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月30日__人流车流密度')
          },
          90: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月31日__人流车流密度')
          },
          100: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年4月1日__人流车流密度')
          },
        },
        isPause: true,
      }
    },
    methods: {
      //获取人流车流模拟数据，绘制流线图形
      showDutyStream() {
        let params = {
          'lType': '人流车流'
        };
        queryPoliceLine(params).then(res => {
          res.data.map((item) => {
            this.loadDutyStream(item);
          });
        });
      },
      loadDutyStream(item) {
        let color, width;
        switch (item.lName) {
          case "1":
            color = Cesium.Color.fromCssColorString("#f000d7");
            width = 30;
            break;
          case "2":
            color = Cesium.Color.fromCssColorString("#f0d534");
            width = 22;
            break;
          case "3":
            color = Cesium.Color.fromCssColorString("#23c728");
            width = 15;
            break;
        }
        let posArr = stringToNumber(item.lPoyline);
        peopleRouteArr.push(viewer.entities.add({
          polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(posArr),
            width: width,
            material: new Cesium.PolylineTrailLinkMaterialProperty(color, 36000),
            clampToGround: true,
          },
        }));
      },
      closeDutyStream() {
        this.clearDutyStream();
        this.stopStream();
      },
      clearDutyStream() {
        peopleRouteArr.map((item) => {
          viewer.entities.remove(item);
        });
        peopleRouteArr = [];
      },
      formatTooltip(val) {
        return val / 100;
      },
      changeStep() {
        peopleRouteArr.map(item => {
          let lName = parseInt(Math.random() * 3) + 1;
          let color, width;
          switch (lName.toString()) {
            case "1":
              color = Cesium.Color.fromCssColorString("#f000d7");
              width = 30;
              break;
            case "2":
              color = Cesium.Color.fromCssColorString("#f0d534");
              width = 22;
              break;
            case "3":
              color = Cesium.Color.fromCssColorString("#23c728");
              width = 15;
              break;
          }
          item.polyline.width = width;
          item.polyline.material = new Cesium.PolylineTrailLinkMaterialProperty(color, 36000);
        });
      },
      startStream() {
        this.$message({
          message: '开始自动播放人流车流密度模拟！',
          type: 'success'
        });
        dutyStreamInterval = setInterval(() => {
          _this.step -= 10;
          if (_this.step < 0) {
            _this.step = 100;
          }
          _this.changeStep();
        }, 5000);
      },
      pauseOrContinue() {
        if (this.isPause) {
          clearInterval(dutyStreamInterval);
          this.$message({
            message: '暂停自动播放人流车流密度模拟！',
            type: 'warning'
          });
        } else {
          this.startStream();
          this.$message({
            message: '继续自动播放人流车流密度模拟！',
            type: 'warning'
          });
        }
        this.isPause = !this.isPause;
      },
      stopStream() {
        _this.$message({
          message: '停止自动播放人流车流密度模拟！',
          type: 'error'
        });
        clearInterval(dutyStreamInterval);
      }
    },
    mounted() {
      _this = this;
      this.showDutyStream();
    }
  }
</script>

<style scoped>
  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-fai-start {
    right: 160px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-pause {
    right: 120px;
  }

  .pop-fai-pause:hover {
    background-color: #e0960d;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
