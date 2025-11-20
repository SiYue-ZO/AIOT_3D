<template>
  <div v-bind:id="'popupDiv'+popId" v-bind:style="'box-shadow:0 0 15px '+color" class="mapPop"
       v-bind:ref="'manPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" v-bind:style="'border-color:'+color+'88;box-shadow:inset 0 0 6px '+color">
      <div class="mapPop-name">{{name}}-5G视频图传</div>
      <div class="mapPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'award']" title="综合能力" v-on:click.stop="show_power">
        </font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'camera']" title="视频图传"
                           @click.stop="show_man_video"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'route']" title="轨迹" v-on:click.stop="man_route">
        </font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['far', 'address-card']" title="人员信息"
                           @click.stop="show_man_info"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'times']" title="关闭气泡" v-on:click.stop="pop_close">
        </font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" :style="'border-color:'+color+'88;box-shadow:inset 0 0 6px '+color">
      <div id="manPower" v-show="isPowerShow">
        <div style="margin:5px 0 4px 0;">战斗能力综合评分：（{{num}}）</div>
        <div class="mapPop-equip">
          <div class="equipLeftbox-man">
            <el-image fit="cover" class="equipLeftbox-man-img" :src="imageUrl"
                      :preview-src-list="[imageUrl]"></el-image>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_lt"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_lb"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_rt"></div>
            <div v-bind:style="'border-color:'+color+'cc'" class="manImg_rb"></div>
          </div>
          <div class="equipPopRightbox" v-if="equipArr">
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
      <div id="manRoute" v-show="isRouteShow">
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
            <el-input v-model="velocity" placeholder="最小速度" type='number'></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="pop-btn" type="danger" size="small" @click="pop_manHisStop">清 除</el-button>
            <el-button class="pop-btn" type="primary" size="small" @click="pop_manHisPlay">确 定</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div id="manInfo" v-show="isInfoShow">
        <table class="pop-tabel" cellspacing="0">
          <tr>
            <td>定位时间</td>
            <td>{{realTime}}</td>
          </tr>
          <tr>
            <td>姓名</td>
            <td>{{name}}</td>
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{identity}}</td>
          </tr>
          <tr>
            <td>性别</td>
            <td>{{gender}}</td>
          </tr>
          <tr>
            <td>民族</td>
            <td>{{nation}}</td>
          </tr>
          <tr>
            <td>警种分类</td>
            <td>{{origin}}</td>
          </tr>
          <tr>
            <td>职务</td>
            <td>{{post}}</td>
          </tr>
          <tr>
            <td>警衔</td>
            <td>{{policeRank}}</td>
          </tr>
          <tr>
            <td>入职时间</td>
            <td>{{jobDate}}</td>
          </tr>
          <tr>
            <td>最高学历</td>
            <td>{{education}}</td>
          </tr>
          <tr>
            <td>设备卡号</td>
            <td>{{deviceNum}}</td>
          </tr>
          <tr>
            <td>设备类别</td>
            <td>{{deviceType}}</td>
          </tr>
          <tr>
            <td>采购日期</td>
            <td>{{deviceDate}}</td>
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
  import comMan from "@/components/iot-man";
  import {getManHisDataByTime} from "../../../api/api";

  let popzIndex = 0;
  export default {
    name: "pop-man",
    data() {
      return {
        popId: "",
        name: "",
        identity: "",
        gender: "",
        birth: "",
        nation: "",
        origin: "",
        post: "",
        jobDate: "",
        policeRank: "",
        education: "",
        deviceNum: "",
        deviceType: "",
        deviceDate: "",
        realTime: "",
        num: 0,
        imageUrl: "",
        levelNum: 0, //层级
        color: "#00d3e7",
        equipArr: [],
        dateTime: "",
        velocity: 1,
        isPowerShow: true,
        isRouteShow: false,
        isInfoShow: false,
        noImg: require("@/assets/pop/noneImg.png"),
      };
    },
    methods: {
      show_power() {
        this.isPowerShow = true;
        this.isRouteShow = false;
        this.isInfoShow = false;
      },
      man_route() {
        this.isPowerShow = false;
        this.isRouteShow = true;
        this.isInfoShow = false;
      },
      show_man_info() {
        this.isPowerShow = false;
        this.isRouteShow = false;
        this.isInfoShow = true;
      },
      show_man_video() {
        comMan.methods.initSewisePlayer(this.popId, this.name);
      },
      pop_close() {
        viewer.entities.getById("po" + this.popId).show = true;
        let pop = this.$refs["manPop-" + this.levelNum];
        if (pop) {
          document.querySelector("body").removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
        comMan.methods.closeVideoPlayer(this.popId);
        comMan.methods.manHisStop();
      },
      pop_manHisPlay() {
        this.pop_manHisStop();
        let args = {
          deviceNum: this.deviceNum,
          startTime: this.dateTime[0],
          endTime: this.dateTime[1],
          // "velocity": Number(this.velocity)
        };
        // getManHisDataByTime(args).then((res) => {
        //   comMan.methods.manHisPlay(res.data, this.velocity);
        // });
        comMan.methods.manHisPlay(manRoute, this.velocity);
      },
      pop_manHisStop() {
        comMan.methods.manHisStop();
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      },
    },
  };
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
    background-color: #11264dd1;
  }

  .mapPop-name {
    float: left;
  }

  .mapPop-tools {
    float: right;
  }

  #manPower {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
  }

  .mapPop-content {
    border: solid;
    border-width: 1px 0;
    font-size: 14px;
    background-color: #11264dd1;
    box-sizing: border-box;
    height: 185px;
    overflow-y: auto;
    padding: 0 10px;
    box-sizing: border-box;
  }

  .mapPop-content::-webkit-scrollbar {
    width: 3px !important;
    height: 2px !important;
  }

  .mapPop-content::-webkit-scrollbar-thumb {
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .mapPop-content::-webkit-scrollbar-track {
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .mapPop-equip {
    height: 145px;
    width: 100%;
    display: flex;
    justify-content: space-between;
  }

  .equipLeftbox-man {
    width: 120px;
    height: 146px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 3px;
  }

  .equipLeftbox-man-img {
    width: 114px;
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
    left: 121px;
    top: 59px;
  }

  .manImg_rb {
    width: 10px;
    height: 15px;
    position: absolute;
    border-bottom: 1px solid #00d3e7;
    border-right: 1px solid #00d3e7;
    left: 121px;
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

  .pop-form {
    width: 100%;
    margin-top: 2px;
  }

  .pop-btn {
    float: right;
    margin: 0 0 0 15px;
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

  .man_his_lab {
    margin-bottom: 5px;
  }

  .pop-form /deep/ .el-form-item {
    margin-bottom: 10px !important;
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
