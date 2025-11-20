<template>
  <div id="duty-heatmap-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startHeatmap" title="播放">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="stopHeatmap" title="停止清除">
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
  import {getHisDataAllDemo, getManRealPosAll} from "../api/api";

  let _this;
  let policeHeatmap;//警力（目前只有警车）分布热力图
  let heatmapBounds = {
    west: 126.51782496032324,
    south: 45.65665624102519,
    east: 126.69515433048157,
    north: 45.783947433640976
  };
  let marksStyle = {
    color: '#ffffff',
    width: '300px',
    padding: '5px'
  };
  let dataManConst;
  let dataCarConst;
  let dutyHeatmapInterval;

  export default {
    name: "duty-heatmap",
    data() {
      return {
        step: 100,
        marks: {
          0: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月22日__警车+警员定位密度分布')
          },
          10: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月23日__警车+警员定位密度分布')
          },
          20: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月24日__警车+警员定位密度分布')
          },
          30: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月25日__警车+警员定位密度分布')
          },
          40: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月26日__警车+警员定位密度分布')
          },
          50: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月27日__警车+警员定位密度分布')
          },
          60: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月28日__警车+警员定位密度分布')
          },
          70: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月29日__警车+警员定位密度分布')
          },
          80: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月30日__警车+警员定位密度分布')
          },
          90: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年3月31日__警车+警员定位密度分布')
          },
          100: {
            style: marksStyle,
            label: this.$createElement('strong', '2022年4月1日__警车+警员定位密度分布')
          },
        },
        isPause: true,
      }
    },
    methods: {
      //获取见警率数据，暂时为人员实时位置和固定有数据的三天的全部车辆历史定位数据，实际应为近两天内的所有人员和车辆的历史数据
      showDutyHeatmap() {
        getManRealPosAll().then(res => {
          getHisDataAllDemo().then(resCar => {
            dataManConst = res.data;
            dataCarConst = resCar.data;
            this.loadHeatmap(res.data, resCar.data);
          });
        });
      },
      loadHeatmap(dataMan, dataCar) {
        //见警率热力图
        policeHeatmap = CesiumHeatmap.create(
          viewer, // your cesium viewer
          heatmapBounds, // bounds for heatmap layer
          {
            // heatmap.js options go here
            // maxOpacity: 0.3
          }
        );
        let policeHeatmapData = [];
        for (let i = 0; i < dataMan.length; i++) {
          let posArr = dataMan[i].realPos.split(",");
          policeHeatmapData.push({
            "x": Number(posArr[0]),
            "y": Number(posArr[1]),
            "value": 1.0
          });
        }
        for (let i = 0; i < dataCar.length; i++) {
          policeHeatmapData.push({
            "x": Number(dataCar[i].longitude),
            "y": Number(dataCar[i].latitude),
            "value": 1.0
          });
        }
        policeHeatmap.setWGS84Data(0, 10, policeHeatmapData);
      },
      closeDutyHeatmap() {
        this.clearDutyHeatmap();
        this.stopHeatmap();
      },
      clearDutyHeatmap() {
        policeHeatmap.show(false);
      },
      formatTooltip(val) {
        return val / 100;
      },
      changeStep() {
        this.clearDutyHeatmap();
        let mandata = [], cardata = [];
        dataManConst.map(item => {
          let posArr = item.realPos.split(",");
          posArr[0] = parseInt(Math.random() * 10) % 2 === 0 ? Number(posArr[0]) + Math.random() * 0.001 : Number(posArr[0]) - Math.random() * 0.001;
          posArr[1] = parseInt(Math.random() * 10) % 2 === 0 ? Number(posArr[1]) + Math.random() * 0.001 : Number(posArr[1]) - Math.random() * 0.001;
          item.realPos = posArr[0] + "," + posArr[1];
          mandata.push(item);
        });
        dataCarConst.map(item => {
          item.longitude = parseInt(Math.random() * 10) % 2 === 0 ? Number(item.longitude) + Math.random() * 0.001 : Number(item.longitude) - Math.random() * 0.001;
          item.latitude = parseInt(Math.random() * 10) % 2 === 0 ? Number(item.latitude) + Math.random() * 0.001 : Number(item.latitude) - Math.random() * 0.001;
          cardata.push(item);
        });
        this.loadHeatmap(mandata, cardata);
      },
      startHeatmap() {
        this.$message({
          message: '开始自动播放动态热力图！',
          type: 'success'
        });
        dutyHeatmapInterval = setInterval(() => {
          _this.step -= 10;
          if (_this.step < 0) {
            _this.step = 100;
          }
          _this.changeStep();
        }, 5000);
      },
      pauseOrContinue() {
        if (this.isPause) {
          clearInterval(dutyHeatmapInterval);
          this.$message({
            message: '暂停自动播放动态热力图！',
            type: 'warning'
          });
        } else {
          this.startHeatmap();
          this.$message({
            message: '继续自动播放动态热力图！',
            type: 'warning'
          });
        }
        this.isPause = !this.isPause;
      },
      stopHeatmap() {
        _this.$message({
          message: '停止自动播放动态热力图！',
          type: 'error'
        });
        clearInterval(dutyHeatmapInterval);
      }
    },
    mounted() {
      _this = this;
      this.showDutyHeatmap();
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
