<template>
  <div v-bind:id="'popupDiv'+popId" v-bind:style="'box-shadow:0 0 15px '+color" class="mapPop"
       v-bind:ref="'carPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" v-bind:style="'border-color:'+color+'88;box-shadow:inset 0 0 6px '+color">
      <div class="mapPop-name">{{carLicense}}-实时定位</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'award']" title="综合能力"
                           v-on:click.stop="show_power"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'camera']" title="视频图传"
                           @click.stop="show_car_video"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'route']" title="轨迹"
                           v-on:click.stop="car_route"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['far', 'address-card']" title="车辆信息"
                           v-on:click.stop="show_car_info"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="关闭气泡"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" v-bind:style="'border-color:'+color+'88;box-shadow:inset 0 0 6px '+color">
      <div id="carPower" v-show="isPowerShow">
        <div style="margin:5px 0 4px 0;">战斗能力综合评分：（{{num}}）</div>
        <div class="mapPop-equip">
          <div class="equipLeftbox-car">
            <el-image fit="cover" class="equipLeftbox-car-img" :src="imageUrl"
                      :preview-src-list="[imageUrl]"></el-image>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_lt"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_lb"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_rt"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_rb"></div>
          </div>
          <div class="equipPopRightbox" v-if="equipArr!==[]&&equipArr!==undefined">
            <table class="pop-tabel" cellspacing="0">
              <tr v-for="(item,index) in equipArr">
                <td>{{item.equipment.equipmentName}}:</td>
                <td>
                  <el-image :src="item.equipment.equipmentPicture"
                            :preview-src-list="[item.equipment.equipmentPicture]" class="noImg1"></el-image>
                </td>
              </tr>
            </table>
          </div>
          <div class="equipPopRightbox" v-else>
            <div>未佩戴装备:</div>
            <div class="equipPoliceType">
              <img class="noImg1" :src="noImg" alt="未佩戴装备">
            </div>
          </div>
        </div>
      </div>
      <div id="carRoute" v-show="isRouteShow">
        <el-form inline size="small" ref="form" class="pop-form">
          <div class="man_his_lab">选择起始时间---终止时间</div>
          <el-form-item>
            <el-date-picker v-model="dateTime" type="datetimerange" format="yyyy-MM-dd HH:mm:ss"
                            value-format="yyyy-MM-dd HH:mm:ss" range-separator="-" start-placeholder="开始日期"
                            end-placeholder="结束日期">
            </el-date-picker>
          </el-form-item>
          <div class="man_his_lab">最低速度：默认值为“1”</div>
          <el-form-item>
            <el-input v-model="limitVelocity" placeholder="最小速度" type='number'></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="pop-btn" type="danger" size="small" v-on:click="pop_carHisStop">清 除</el-button>
            <el-button class="pop-btn" type="primary" size="small" v-on:click="pop_carHisPlay">确 定</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div id="carInfo" v-show="isInfoShow">
        <table class="pop-tabel" cellspacing="0">
          <tr>
            <td>牌照</td>
            <td>{{carLicense}}</td>
          </tr>
          <tr>
            <td>警用类型</td>
            <td>{{policeType}}</td>
          </tr>
          <tr>
            <td>购置时间</td>
            <td>{{carDate}}</td>
          </tr>
          <tr>
            <td>驾驶员</td>
            <td>{{driver}}</td>
          </tr>
          <tr>
            <td>车辆型号</td>
            <td>{{carStyle}}</td>
          </tr>
          <tr>
            <td>设备卡号</td>
            <td>{{cardNum}}</td>
          </tr>
          <tr>
            <td>定位时间</td>
            <td>{{updateDate}}</td>
          </tr>
          <tr>
            <td>当前速度</td>
            <td>{{velocity}}</td>
          </tr>
          <tr>
            <td>当前方向</td>
            <td>{{direction}}</td>
          </tr>
          <tr>
            <td>当前油量</td>
            <td>{{gas}}</td>
          </tr>
          <tr>
            <td>里程数</td>
            <td>{{mileage}}</td>
          </tr>
        </table>
      </div>
    </div>
    <div v-bind:style="'border-top-color:'+color+';filter: drop-shadow(0 0 6px '+color+')'" class="box_leg"></div>
    <div v-bind:style="'border-color:'+color" class="box_lt"></div>
    <div v-bind:style="'border-color:'+color" class="box_lb"></div>
    <div v-bind:style="'border-color:'+color" class="box_rt"></div>
    <div v-bind:style="'border-color:'+color" class="box_rb"></div>
  </div>
</template>

<script>
  import comCar from "../../../components/iot-car";
  import {getHisDataByTime} from "../../../api/api";

  let popzIndex = 0;

  export default {
    name: "pop-base",
    data() {
      return {
        popId: "",
        carLicense: "",
        carDate: "",
        carStyle: "",
        cardNum: "",
        driver: "",
        policeType: "",
        num: 0,
        imageUrl: "",
        updateDate: "",
        velocity: "",
        direction: "",
        gas: "",
        mileage: "",
        levelNum: 0,//层级
        color: "#00d3e7",
        equipArr: [],
        dateTime: "",
        limitVelocity: 1,
        isPowerShow: true,
        isRouteShow: false,
        isInfoShow: false,
        noImg: require("@/assets/pop/noneImg.png"),
      }
    },
    methods: {
      show_power() {
        this.isPowerShow = true;
        this.isRouteShow = false;
        this.isInfoShow = false;
      },
      car_route() {
        this.isPowerShow = false;
        this.isRouteShow = true;
        this.isInfoShow = false;
      },
      show_car_info() {
        this.isPowerShow = false;
        this.isRouteShow = false;
        this.isInfoShow = true;
      },
      show_car_video() {
        comCar.methods.showVideoPlayer(this.popId, this.carLicense);
      },
      pop_close() {
        viewer.entities.getById('pc' + this.popId).show = true;
        let pop = this.$refs['carPop-' + this.levelNum];
        if (pop) {
          document.querySelector('body').removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
        comCar.methods.closeVideoPlayer(this.popId);
        comCar.methods.carHisStop();
      },
      pop_carHisPlay() {
        this.pop_carHisStop();
        let args = {
          "simNo": this.cardNum,
          "startTime": this.dateTime[0],
          "endTime": this.dateTime[1],
          "velocity": Number(this.limitVelocity)
        };
        getHisDataByTime(args).then(res => {
          let data = res.data;
          if (data === undefined || data.length === 0 || data === null) {
            this.$message.error('该时段未查询到指定车辆轨迹数据，请重试！');
          }else {
            comCar.methods.carHisPlay(data, this.limitVelocity);
          }
        });
      },
      pop_carHisStop() {
        comCar.methods.carHisStop();
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      }
    }
  }
</script>

<style scoped>
  .mapPop {
    width: 300px;
    height: 215px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .mapPop-title {
    width: 100%;
    font-size: 14px;
    border: solid;
    border-width: 1px 0;
    padding: 5px 8px;
    min-height: 30px;
    background-color: #11264DD1;
  }

  .mapPop-name {
    float: left;
  }

  .mapPop-tools {
    float: right
  }

  .mapPop-content {
    border: solid;
    border-width: 1px 0;
    font-size: 14px;
    background-color: #11264DD1;
    box-sizing: border-box;
    height: 185px;
    overflow-y: auto;
    padding: 0 10px;
    box-sizing: border-box;
  }

  .mapPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .mapPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .mapPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .mapPop-equip {
    height: 150px;
    width: 100%;
    display: flex;
    justify-content: space-between;
  }

  .equipLeftbox-car {
    width: 130px;
    height: 146px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 3px;
  }

  .equipLeftbox-car-img {
    width: 122px;
    height: 140px;
  }

  .manImg_lt {
    width: 10px;
    height: 15px;
    position: absolute;
    border-top: 1px solid #00d3e7;
    border-left: 1px solid #00d3e7;
    left: 10px;
    top: 59px;
  }

  .manImg_rt {
    width: 10px;
    height: 15px;
    position: absolute;
    border-top: 1px solid #00d3e7;
    border-right: 1px solid #00d3e7;
    left: 129px;
    top: 59px;
  }

  .manImg_rb {
    width: 10px;
    height: 15px;
    position: absolute;
    border-bottom: 1px solid #00d3e7;
    border-right: 1px solid #00d3e7;
    left: 129px;
    bottom: 8px;
  }

  .manImg_lb {
    width: 10px;
    height: 15px;
    position: absolute;
    border-bottom: 1px solid #00d3e7;
    border-left: 1px solid #00d3e7;
    left: 10px;
    bottom: 8px;
  }

  .equipPopRightbox {
    margin-top: -5px;
    margin-left: 5px;
    min-width: 145px;
    height: 152px;
    overflow-y: auto;
  }

  .equipPoliceType {
    min-width: 120px;
    height: 30px;
    margin-bottom: 8px;
  }

  .noImg1 {
    width: 65px;
    height: 60px;
  }

  .pop-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
  }

  .pop-tabel td {
    padding: 2px 5px;
  }

  .pop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .pop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .man_his_lab {
    margin-bottom: 5px;
  }

  .pop-form {
    width: 100%;
    margin-top: 2px;
  }

  .pop-form /deep/ .el-form-item {
    margin-bottom: 10px !important;
  }

  .pop-btn {
    float: right;
    margin: 0 0 0 15px
  }

  .box_lt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    top: 0;
  }

  .box_rt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    top: 0;
  }

  .box_rb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    bottom: 0;
  }

  .box_lb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    bottom: 0;
  }

  .box_leg {
    width: 0;
    height: 0;
    border: 10px solid;
    border-color: #000 transparent transparent;
    position: absolute;
    bottom: -20px;
    left: 140px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .equipPopRightbox::-webkit-scrollbar {
    width: 8px !important; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px !important;
  }

  .equipPopRightbox::-webkit-scrollbar-thumb {
    /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
    background: #00ffff33 !important;
  }

  .equipPopRightbox::-webkit-scrollbar-track {
    /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2) !important;
  }
</style>
