<template>
  <div>
    <div v-show="uiMode[0]">
      <div id="header" class="header">
        <div class="sys-title textshadow-p">
          <img class="sys-logo" :src="logoSrc+ui.appLogo"/>
          <div class="sys-name">{{ ui.appName }}</div>
          <div class="sys-bar textshadow-p">|</div>
          <div class="sys-version textshadow-p">{{ ui.appVersion }}</div>
        </div>
        <div class="navigation-icons textshadow-p">
          <el-menu
            class="el-menu"
            mode="horizontal"
            background-color="#11264D99"
            text-color="#fff"
            active-text-color="#00ffff">
            <el-submenu v-for="(item,index) in funcList" :key="index+1" :index="(index+1).toString()">
              <template slot="title">{{ item.funcName }}</template>
              <el-menu-item v-for="(item1,index1) in item.children" :key="index1+1"
                            :index="(index+1).toString()+'-'+(index1+1).toString()"
                            v-on:click="initWin(item1)">
                <font-awesome-icon class="navigation-fai" :icon="[item1.sysFunc.funcIconType, item1.sysFunc.funcIcon]"
                                   fixed-width></font-awesome-icon>
                {{ item1.funcName }}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </div>
        <div class="sys-state">
          <font-awesome-icon class="navigation-fai sys-state-icon" :icon="['far', 'user']"
                             title="当前用户"></font-awesome-icon>
          <div class="sys-state-user">{{ userName }}</div>
        </div>
        <div class="sys-tools">
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'home']" title="复位"
                             v-on:click="map_wholeView()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'expand']" title="全屏"
                             v-on:click="ui_fullscreen()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'adjust']" title="FXAA抗锯齿"
                             v-on:click="ui_fxaa()"></font-awesome-icon>
<!--          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'certificate']" title="8倍MSAA抗锯齿"-->
<!--                             v-on:click="ui_msaa()"></font-awesome-icon>-->
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'dove']" title="Bloom效果"
                             v-on:click="ui_bloom()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'car']" title="模拟车流"
                             v-on:click="ui_Traffic()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'water']" title="水面效果"
                             v-on:click="ui_water()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'cloud']" title="动态云效果"
                             v-on:click="ui_cloud()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'sun']" title="天空昼夜变换"
                             v-on:click="ui_light()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'cube']" title="环境阴影"
                             v-on:click="ui_shadow()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['far', 'compass']" title="指南针"
                             v-on:click="ui_compass()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fab', 'buffer']" title="渐进墙"
                             v-on:click="ui_buffer()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['far', 'bookmark']" title="UI阴影"
                             v-on:click="ui_mask()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'times-circle']" title="清除"
                             v-on:click="map_clear()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'font']" title="字体"
                             v-on:click="font_download()"></font-awesome-icon>
          <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'power-off']" title="退出"
                             v-on:click="logout()"></font-awesome-icon>
        </div>
      </div>
      <stat-protect></stat-protect>
      <stat-people></stat-people>
      <stat-case></stat-case>
      <stat-device></stat-device>
      <stat-station></stat-station>
      <stat-transport></stat-transport>
      <!--<stat-building-remove></stat-building-remove>-->
      <!--<stat-building-remove-type-area></stat-building-remove-type-area>-->
      <!--<stat-building-remove-type-num></stat-building-remove-type-num>-->
      <!--<stat-building-remove-use></stat-building-remove-use>-->
      <div id="map-bar-left" class="map-bar map-bar-left" style="display: block;"></div>
      <div id="map-bar-right" class="map-bar map-bar-right" style="display: block;"></div>
      <div id="mask" class="mask"></div>
    </div>
    <div class="navigation-icons-left textshadow-p" v-show="uiMode[1]">
      <div class="navigation-icons-left-body">
        <table v-for="(item,index) in funcList" :key="index+1" :index="(index+1).toString()">
          <tr>
            <td colspan="3">{{ item.funcName }}</td>
          </tr>
          <tr v-for="(item1,index1) in item.children" :key="index1+1"
              :index="(index+1).toString()+'-'+(index1+1).toString()">
            <td width="25px">
              <el-checkbox :checked="winCheckedArr[index1]" @change="initWinCheck(index1, item1)"></el-checkbox>
            </td>
            <td width="30px">
              <font-awesome-icon class="navigation-fai" :icon="[item1.sysFunc.funcIconType, item1.sysFunc.funcIcon]"
                                 fixed-width></font-awesome-icon>
            </td>
            <td>{{ item1.funcName }}</td>
          </tr>
        </table>
      </div>
      <div style="border-color:#00d3e7" class="box_lt"></div>
      <div style="border-color:#00d3e7" class="box_lb"></div>
      <div style="border-color:#00d3e7" class="box_rt"></div>
      <div style="border-color:#00d3e7" class="box_rb"></div>
    </div>
    <div class="pad-header" v-show="uiMode[2]||uiMode[3]">
      <div class="pad-sys-title textshadow-p">
        <img class="pad-sys-logo" :src="logoSrc+ui.appLogo"/>
        <div class="pad-sys-name">{{ ui.appName }}</div>
        <div class="pad-sys-bar textshadow-p">|</div>
        <div class="pad-sys-version textshadow-p">{{ ui.appVersion }}</div>
      </div>
    </div>
    <div class="pad-sys-tools-left" v-show="uiMode[2]">
      <div class="pad-sys-tools-btn" v-on:click="map_wholeView()" style="margin-left:0">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'home']" title="复位"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn" v-on:click="ui_bloom()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'dove']" title="Bloom效果"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn" v-on:click="ui_compass()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'compass']" title="指南针"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn" v-on:click="ui_cloud()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'cloud']" title="动态云效果"></font-awesome-icon>
      </div>
    </div>
    <div class="pad-sys-tools-right" v-show="uiMode[2]">
      <div class="pad-sys-tools-btn" v-on:click="ui_buffer()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fab', 'buffer']" title="渐进墙"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn" v-on:click="map_clear()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'times-circle']" title="清除"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn" v-on:click="logout()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'power-off']" title="退出"></font-awesome-icon>
      </div>
    </div>
    <div class="navigation-icons-v-left textshadow-p" v-show="uiMode[2]">
      <el-menu
        class="el-menu-left"
        background-color="#11264DAA"
        text-color="#fff"
        active-text-color="#F2DF0C"
        :collapse="true"
      >
        <el-submenu v-for="(item,index) in funcList" :key="index+1" :index="(index+1).toString()">
          <template slot="title">
            <i :class="iArr[index]"></i>
            <span slot="title">{{ item.funcName }}</span>
          </template>
          <el-menu-item v-for="(item1,index1) in item.children" :key="index1+1"
                        :index="(index+1).toString()+'-'+(index1+1).toString()"
                        v-on:click="initWin(item1)">
            {{ item1.funcName }}
          </el-menu-item>
        </el-submenu>
      </el-menu>
      <div class="pad-box_lt"></div>
      <div class="pad-box_lb"></div>
      <div class="pad-box_rt"></div>
      <div class="pad-box_rb"></div>
    </div>
    <div class="pad-mask" v-show="uiMode[2]||uiMode[3]"></div>
    <div class="pad-sys-tools-bottom" v-show="uiMode[3]">
      <div class="pad-sys-tools-btn-bottom" v-on:click="map_wholeView()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'home']" title="复位"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn-bottom" v-on:click="ui_bloom()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'dove']" title="Bloom效果"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn-bottom" v-on:click="ui_compass()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'compass']" title="指南针"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn-bottom" v-on:click="ui_buffer()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fab', 'buffer']" title="渐进墙"></font-awesome-icon>
      </div>
      <div class="pad-sys-tools-btn-bottom" v-on:click="logout()">
        <font-awesome-icon class="pad-sys-tools-fai" :icon="['fas', 'power-off']" title="退出"></font-awesome-icon>
      </div>
    </div>
    <div class="ui-5" v-show="uiMode[4]">
      <img class="ui5-header-bg" src="../assets/ui5/ui5-header-bg.png" alt=""/>
      <img class="ui5-logo" src="../assets/ui5/ui5-logo.png" alt=""/>
      <div class="ui5-btn-group">
        <div class="ui5-btn ui5-btn-1">
          <div class="ui5-btn-text">首 页</div>
          <img class="ui5-btn-bg" src="../assets/ui5/ui5-btn-hl.png" alt=""/>
        </div>
        <div class="ui5-btn ui5-btn-2">
          <div class="ui5-btn-text">人口管理</div>
          <img class="ui5-btn-bg" src="../assets/ui5/ui5-btn.png" alt=""/>
        </div>
        <div class="ui5-btn ui5-btn-3">
          <div class="ui5-btn-text">疫情防控</div>
          <img class="ui5-btn-bg" src="../assets/ui5/ui5-btn.png" alt=""/>
        </div>
        <div class="ui5-btn ui5-btn-4">
          <div class="ui5-btn-text">视频监控</div>
          <img class="ui5-btn-bg-r" src="../assets/ui5/ui5-btn-r.png" alt=""/>
        </div>
      </div>
      <div class="ui5-date">2020.09.14 / 14:49:55 /
        <font-awesome-icon :icon="['fas', 'sun']"></font-awesome-icon>
        晴 / 15~21℃
      </div>
      <div class="ui5-enviro">空气质量: <span class="ui5-btn-text-hl">优</span> / 风速: <span
        class="ui5-btn-text-hl">5级</span>
        /
        湿度: <span class="ui5-btn-text-hl">30%</span></div>
      <div class="ui5-tools">
        <font-awesome-icon class="sys-tools-fai" :icon="['fas', 'power-off']" title="退出"
                           v-on:click="logout()"></font-awesome-icon>
      </div>
      <div class="ui5-stat-left">
        <img class="ui5-stat-left-bg" src="../assets/ui5/ui5-stat-left.png" alt=""/>
        <stat-construction></stat-construction>
      </div>
      <div class="ui5-stat-right">
        <img class="ui5-stat-right-bg" src="../assets/ui5/ui5-stat-right.png" alt=""/>
        <stat-video></stat-video>
      </div>
    </div>
    <img class="ui5-foot" v-show="uiMode[4]" src="../assets/ui5/ui5-foot.png" alt=""/>
  </div>
</template>

<script>
import StatPeople from "../components/stat-people";
import StatCase from "../components/stat-case";
import StatDevice from "../components/stat-device";
import StatTransport from "../components/stat-transport";
import StatProtect from "../components/stat-protect";
import StatStation from "../components/stat-station";
import StatConstruction from "../components/stat-construction";
import StatVideo from "../components/stat-video";
import caseCall from "./case-call";
import caseMap from "./case-map";
import iotCar from "./iot-car";
import iotMan from "./iot-man";
import iotVideo from "./iot-video";
import iotVideoIndoor from "./iot-video-indoor";
import iotEnvironment from "./iot-environment";
import iotUav from "./iot-uav";
import iotUavHis from "./iot-uav-his";
import map3d from "./map-3d";
import tiles3d from "./tiles3d";
import tiles3dBim from "./tiles3d-bim";
import toolTags from "./tool-tags";
import toolSearchPOI from "./tool-searchPOI";
import toolRoam from "./tool-roam";
import planPeace from "./plan-peace";
import planWar from "./plan-war";
import planFlood from "./plan-flood";
import mapLayer from "./map-layer";
import statBigDataMap from "./stat-bigDataMap";
import mapRoute from "./map-route";
import mapEye from "./map-eye";
import terrainEx from "./map-terrainEx";
import netBuilding from "./net-building";
import protectAlarm from "./protect-alarm";
import protectAlarmBlacklist from "./protect-alarm-blacklist";
import protectWall from "./protect-wall";
import protectAlert from "./protect-alert";
import protectFace from "./protect-face";
import realPeople from "./real-people";
import realHouse from "./real-house";
import realCompany from "./real-company";
import realAddress from "./real-address";
import netManage from "./net-manage";
import netSecurity from "./net-security";
import netCustom from "./net-custom";
import demoPipeline from "./demo-pipeline";
import demoMissile from './demo-missile';
import demoWeather from './demo-weather';
import iotWater from './iot-water';
import mapFirstControl from './map-first-control';
import bimDevice from './bim-device';
import bimWaterFlow from './bim-water-flow';
import bimRegion from './bim-region';
import dutyVideo from './duty-video';
import dutyAi from './duty-ai';
import dutyAiList from './duty-ai-list';
import cityThing from './city-thing';
import cityBuilding from './city-building';
import cityBuildingRemove from './city-building-remove';
import accessMan from './access-man';
import accessManList from './access-man-list';
import accessCar from './access-car';
import accessCarList from './access-car-list';
import dutyPoint from './duty-point';
import dutyLine from './duty-line';
import dutyNet from './duty-net';
import bimCase from './bim-case';
import mapPhotos from './map-photos';
import mapImage from './map-image';
import dutyHeatmap from './duty-heatmap';
import dutyStream from './duty-stream';
import "../js/CesiumSurvey.js";
import "../js/CesiumPop.js";
import "../js/CesiumTrail.js";
import {eventBus} from '../main'
import {getAllandFuncByIdandSrc, getAppById, getFuncBySrc} from "../api/api";
import {iconArr} from "../js/icon";
import StatBuildingRemove from "./stat-buildingRemove";
import StatBuildingRemoveTypeArea from "./stat-buildingRemoveTypeArea";
import StatBuildingRemoveTypeNum from "./stat-buildingRemoveTypeNum";
import StatBuildingRemoveUse from "./stat-buildingRemoveUse";

let isLabelShow = false;
let isMoveResultShow = false;
let isCammoveResultShow = false;
let isCaseHeatmapShow = false;
let isKeyPeopleHeatmapShow = false;
let isVideoScopeShow = false;
let isPoliceLinesShow = false;
let isSimple3DShow = false;
let isShadowShow = true;
let isBloomShow = false;
let isTrafficShow = false;
let isHugeShow = false;
let isCloudShow = true;
let isCrossShow = false;
let isWaterShow = false;

export default {
  name: "map-header",
  components: {
    StatBuildingRemoveUse,
    StatBuildingRemoveTypeNum,
    StatBuildingRemoveTypeArea,
    StatBuildingRemove,
    StatStation,
    StatProtect,
    StatTransport,
    StatDevice,
    StatCase,
    StatPeople,
    StatConstruction,
    StatVideo,
  },
  data() {
    return {
      msg: "map-header",
      userName: "",
      funcList: [],
      iconArr: [],
      ui: {
        appId: '',
        appName: '',
        appLogo: '',
        appUiMode: '',
        appPos: '',
        appVersion: ''
      },
      logoSrc: common.serverIp + "city3dfile/",
      uiMode: [],
      winCheckedArr: [],
      iArr: [
        "el-icon-bell",
        "el-icon-video-camera",
        "el-icon-location",
        "el-icon-star-off",
        "el-icon-picture-outline-round",
        "el-icon-warning-outline",
        "el-icon-camera",
        "el-icon-s-promotion",
        "el-icon-coordinate",
        "el-icon-monitor",
        "el-icon-s-tools",
        "el-icon-user-solid",
        "el-icon-s-help",
        "el-icon-picture-outline",
      ]
    };
  },
  methods: {
    initChecked() {
      for (let i = 0; i < 200; i++) {
        this.winCheckedArr[i] = false;
      }
    },
    initWinCheck(index, func) {
      if (!this.winCheckedArr[index]) {
        this.initWin(func);
      }
      this.winCheckedArr[index] = !this.winCheckedArr[index];
    },
    initWin(func) {
      let isShowUrl = "";
      let url = null;
      let eventClose = null;
      let top = this.uiMode[2] ? window.innerHeight - 420 : 75;
      let left = this.uiMode[2] ? window.innerWidth - 400 : 0;
      switch (func.sysFunc.funcUrl) {
        case "caseCall":
          isShowUrl = "case-call";
          url = caseCall;
          eventClose = this.close_win_emer;
          break;
        case "caseMap":
          isShowUrl = "case-map";
          url = caseMap;
          eventClose = this.close_win_case;
          break;
        case "protectWall":
          isShowUrl = "protect-wall";
          url = protectWall;
          eventClose = this.close_win_wall;
          break;
        case "protectAlert":
          isShowUrl = "protect-alert";
          url = protectAlert;
          eventClose = this.close_win_alert;
          top = this.uiMode[2] ? window.innerHeight - 420 : 75;
          left = this.uiMode[2] ? window.innerWidth - 400 : 1510;
          break;
        case "protectAlarm":
          isShowUrl = "protect-alarm";
          url = protectAlarm;
          eventClose = this.close_win_alarm;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          left = this.uiMode[2] ? window.innerWidth - 400 : 1510;
          let options1 = {
            title: "识别黑名单",
            message: protectAlarmBlacklist,
            initWidth: "405px",
            initHeight: "355px",
            top: this.uiMode[2] ? window.innerHeight - 420 : 75,
            left: this.uiMode[2] ? 0 : 1510,
            titleImg: ['far', 'bell'],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              closeCallback: this.close_win_alarm,
            }
          };
          this.$installdialog.subPop(options1);
          break;
        case "protectFace":
          isShowUrl = "protect-face";
          url = protectFace;
          eventClose = this.close_win_face;
          top = this.uiMode[2] ? window.innerHeight - 420 : 75;
          left = this.uiMode[2] ? window.innerWidth - 400 : 1510;
          break;
        case "videoArea":
          isShowUrl = "";
          url = null;
          this.map_stat_video_area();
          break;
        case "statCase":
          isShowUrl = "";
          url = null;
          this.map_stat_case();
          break;
        case "iotVideo":
          isShowUrl = "iot-video";
          url = iotVideo;
          eventClose = this.close_win_iot_video;
          break;
        case "iotVideoIndoor":
          isShowUrl = "iot-video-indoor";
          url = iotVideoIndoor;
          eventClose = this.close_win_iot_video_indoor;
          break;
        case "iotMan":
          isShowUrl = "iot-man";
          url = iotMan;
          eventClose = this.close_win_iot_man;
          break;
        case "iotCar":
          isShowUrl = "iot-car";
          url = iotCar;
          eventClose = this.close_win_iot_car;
          break;
        case "iotWater":
          isShowUrl = "iot-water";
          url = iotWater;
          eventClose = this.close_win_iot_water;
          break;
        case "iotEnvironment":
          isShowUrl = "iot-environment";
          url = iotEnvironment;
          eventClose = this.close_win_iot_environment;
          break;
        case "iotUav":
          isShowUrl = "iot-uav";
          url = iotUav;
          eventClose = this.close_win_iot_uav;
          break;
        case "iotUavHis":
          isShowUrl = "iot-uav-his";
          url = iotUavHis;
          eventClose = this.close_win_iot_uav_his;
          break;
        case "realPeople":
          isShowUrl = "real-people";
          url = realPeople;
          eventClose = this.close_win_real_people;
          break;
        case "realHouse":
          isShowUrl = "real-house";
          url = realHouse;
          eventClose = this.close_win_real_house;
          break;
        case "realCompany":
          isShowUrl = "real-company";
          url = realCompany;
          eventClose = this.close_win_real_company;
          break;
        case "realAddress":
          isShowUrl = "real-address";
          url = realAddress;
          eventClose = this.close_win_real_address;
          break;
        case "netManage":
          isShowUrl = "net-manage";
          url = netManage;
          eventClose = this.close_win_net;
          break;
        case "netSecurity":
          isShowUrl = "net-security";
          url = netSecurity;
          eventClose = this.close_win_station;
          break;
        case "statPeople":
          isShowUrl = "";
          url = null;
          this.map_stat_people();
          break;
        case "planWar":
          isShowUrl = "plan-war";
          url = planWar;
          eventClose = this.close_win_plan_war;
          break;
        case "planPeace":
          isShowUrl = "plan-peace";
          url = planPeace;
          eventClose = this.close_win_plan_peace;
          break;
        case "planFlood":
          isShowUrl = "plan-flood";
          url = planFlood;
          eventClose = this.close_win_flood;
          break;
        case "demoWeather":
          isShowUrl = "demo-weather";
          url = demoWeather;
          eventClose = this.close_win_weather;
          break;
        case "tiles3dBim":
          isShowUrl = "tiles3dBim";
          url = tiles3dBim;
          eventClose = this.close_win_bim;
          break;
        case "netCustom":
          isShowUrl = "net-custom";
          url = netCustom;
          eventClose = this.close_net_custom;
          break;
        case "netSecurityPro":
          isShowUrl = "net-security";
          url = netSecurity;
          eventClose = this.close_win_station;
          break;
        case "dutyHeatmap":
          isShowUrl = "duty-heatmap";
          url = dutyHeatmap;
          eventClose = this.close_win_duty_heatmap;
          break;
        case "dutyStream":
          isShowUrl = "duty-stream";
          url = dutyStream;
          eventClose = this.close_win_duty_stream;
          break;
        case "netBuilding":
          isShowUrl = "net-building";
          url = netBuilding;
          eventClose = this.close_win_building;
          break;
        case "realHousefile":
          isShowUrl = "real-house";
          url = realHouse;
          eventClose = this.close_win_real_house;
          break;
        case "demoPipeline":
          isShowUrl = "demo-pipeline";
          url = demoPipeline;
          eventClose = this.close_win_pipeline;
          break;
        case "demoMissile":
          isShowUrl = "demo-missile";
          url = demoMissile;
          eventClose = this.close_win_missile;
          break;
        case "mapRoute":
          isShowUrl = "map-route";
          url = mapRoute;
          eventClose = this.close_win_route;
          break;
        case "mapEye":
          isShowUrl = "map-eye";
          url = mapEye;
          eventClose = this.close_win_eye;
          break;
        case "measureHeight":
          isShowUrl = "";
          url = null;
          this.measure_height();
          break;
        case "measureDistances":
          isShowUrl = "";
          url = null;
          this.measure_distances();
          break;
        case "heightAngle":
          isShowUrl = "";
          url = null;
          this.measure_height_angle();
          break;
        case "measureArea":
          isShowUrl = "";
          url = null;
          this.measure_area();
          break;
        case "measurePoint":
          isShowUrl = "";
          url = null;
          this.measure_point();
          break;
        case "moveMeasurePoint":
          isShowUrl = "";
          url = null;
          this.move_measure_point();
          break;
        case "cammoveMeasurePoint":
          isShowUrl = "";
          url = null;
          this.cammove_measure_point();
          break;
        case "tiles3d":
          isShowUrl = "tiles3d";
          url = tiles3d;
          break;
        case "mapLayer":
          isShowUrl = "map-layer";
          url = mapLayer;
          eventClose = this.close_win_layer;
          break;
        case "simple3D":
          isShowUrl = "";
          url = null;
          this.win_Simple3D();
          break;
        case "elTerrain":
          isShowUrl = "";
          url = null;
          this.map_addelTerrain();
          break;
        case "worldTerrain":
          isShowUrl = "";
          url = null;
          this.map_addWorldTerrain();
          break;
        case "localTerrain":
          isShowUrl = "";
          url = null;
          this.map_addLocalTerrain();
          break;
        case "localImageLayer":
          isShowUrl = "";
          url = null;
          this.map_addLocalImageLayer();
          break;
        case "darkMapLayer":
          isShowUrl = "";
          url = null;
          this.map_addDarkMapLayer();
          break;
        case "googleImageLayer":
          isShowUrl = "";
          url = null;
          this.map_addgoogleImageLayer();
          break;
        case "arcgisImageLayer":
          isShowUrl = "";
          url = null;
          this.map_addarcgisImageLayer();
          break;
        case "tdtImageLayer":
          isShowUrl = "";
          url = null;
          this.map_addtdtImageLayer();
          break;
        case "tdtVectorLayer":
          isShowUrl = "";
          url = null;
          this.map_addtdtVectorLayer();
          break;
        case "terrainEx":
          isShowUrl = "terrainEx";
          url = terrainEx;
          break;
        case "toolTags":
          isShowUrl = "tool-tags";
          url = toolTags;
          eventClose = this.close_win_tag;
          break;
        case "toolRoam":
          isShowUrl = "tool-roam";
          url = toolRoam;
          eventClose = this.close_win_roam;
          break;
        case "toolSearchPOI":
          isShowUrl = "tool-searchPOI";
          url = toolSearchPOI;
          eventClose = this.close_win_search;
          break;
        case "importantLable":
          isShowUrl = "";
          url = null;
          this.map_showImportantLable();
          break;
        case "mapFirstControl":
          isShowUrl = "map-first-control";
          url = mapFirstControl;
          eventClose = this.close_win_first;
          break;
        case "bimDevice":
          isShowUrl = "bim-device";
          url = bimDevice;
          eventClose = this.close_win_bim_device;
          break;
        case "bimWaterFlow":
          isShowUrl = "bim-water-flow";
          url = bimWaterFlow;
          eventClose = this.close_win_bim_water_flow;
          break;
        case "bimRegion":
          isShowUrl = "bim-region";
          url = bimRegion;
          eventClose = this.close_win_bim_region;
          break;
        case "dutyVideo":
          isShowUrl = "duty-video";
          url = dutyVideo;
          eventClose = this.close_win_duty_video;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "dutyAi":
          isShowUrl = "duty-ai";
          url = dutyAi;
          eventClose = this.close_win_duty_ai;
          let options2 = {
            title: "AI巡更-实时打卡",
            message: dutyAiList,
            initWidth: "405px",
            initHeight: "355px",
            top: this.uiMode[2] ? window.innerHeight - 420 : 535,
            left: 0,
            titleImg: ['fas', 'street-view'],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              closeCallback: this.close_win_duty_ai_list,
            }
          };
          this.$installdialog.subPop(options2);
          break;
        case "cityThing":
          isShowUrl = "city-thing";
          url = cityThing;
          eventClose = this.close_win_city_thing;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "cityBuilding":
          isShowUrl = "city-building";
          url = cityBuilding;
          eventClose = this.close_win_city_building;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "cityBuildingRemove":
          isShowUrl = "city-building-remove";
          url = cityBuildingRemove;
          eventClose = this.close_win_city_building_remove;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "accessMan":
          isShowUrl = "access-man";
          url = accessMan;
          eventClose = this.close_win_access_man;
          let options3 = {
            title: "人员门禁-实时抓拍",
            message: accessManList,
            initWidth: "405px",
            initHeight: "355px",
            top: this.uiMode[2] ? window.innerHeight - 420 : 535,
            left: 0,
            titleImg: ['fas', 'user-tag'],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              closeCallback: this.close_win_access_man_list,
            }
          };
          this.$installdialog.subPop(options3);
          break;
        case "accessCar":
          isShowUrl = "access-car";
          url = accessCar;
          eventClose = this.close_win_access_car;
          let options4 = {
            title: "车辆道闸-实时抓拍",
            message: accessCarList,
            initWidth: "405px",
            initHeight: "355px",
            top: this.uiMode[2] ? window.innerHeight - 420 : 535,
            left: 0,
            titleImg: ['fas', 'shuttle-van'],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              closeCallback: this.close_win_access_car_list,
            }
          };
          this.$installdialog.subPop(options4);
          break;
        case "dutyPoint":
          isShowUrl = "duty-point";
          url = dutyPoint;
          eventClose = this.close_win_duty_point;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "dutyLine":
          isShowUrl = "duty-line";
          url = dutyLine;
          eventClose = this.close_win_duty_line;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "dutyNet":
          isShowUrl = "duty-net";
          url = dutyNet;
          eventClose = this.close_win_duty_net;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "bimCase":
          isShowUrl = "bim-case";
          url = bimCase;
          eventClose = this.close_win_bim_case;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          break;
        case "mapPhotos":
          isShowUrl = "map-photos";
          url = mapPhotos;
          eventClose = this.close_win_map_photos;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          left = this.uiMode[2] ? window.innerWidth - 400 : 1510;
          break;
        case "mapImage":
          isShowUrl = "map-image";
          url = mapImage;
          eventClose = this.close_win_map_image;
          top = this.uiMode[2] ? window.innerHeight - 420 : 535;
          left = this.uiMode[2] ? window.innerWidth - 400 : 1510;
          break;
        case "mapHuge":
          isShowUrl = "";
          url = null;
          this.map_huge();
          break;
        case "trafficCross":
          isShowUrl = "";
          url = null;
          this.ui_cross();
          break;
        default:
          window.href = func.sysFunc.funcUrl;
          window.open(func.sysFunc.funcUrl, "", "_blank");
          break;
      }
      if (url !== null) {
        if (!this.stopAlertPop(isShowUrl + '-is-show')) return;
        let options = {
          title: func.funcName,
          message: url,
          initWidth: "405px",
          initHeight: "355px",
          top: top,
          left: left,
          titleImg: [func.sysFunc.funcIconType, func.sysFunc.funcIcon],
          options: {
            minWidth: "405px",
            minHeight: "355px",
            fullScreen: true,
            closeCallback: eventClose,
          }
        };
        this.$installdialog.subPop(options);
        if (func.sysFunc.funcUrl === "protectFace") {
          eventBus.$emit("creat_face_key_people", 'local');
        }
      }
    },
    close_win_emer() {
      caseCall.methods.closeRHPC();
    },
    close_win_case() {
      caseMap.methods.closeCase();
    },
    close_win_wall() {
      protectWall.methods.stopWallAlarm();
    },
    close_win_alert() {
      protectAlert.methods.clearAlert();
    },
    close_win_alarm() {
      protectAlarm.methods.stopFaceAlarm();
    },
    close_win_face() {
      eventBus.$emit("close_face_key_people", "1");
    },
    close_win_iot_video() {
      iotVideo.methods.clearVideoAll();
      CesiumPop.clearDivPop(viewer);
      iotVideo.methods.stopCamMoveListener();
    },
    close_win_iot_video_indoor() {
      iotVideoIndoor.methods.clearVideoAll();
      CesiumPop.clearDivPop(viewer);
      iotVideoIndoor.methods.stopCamMoveListener();
    },
    close_win_iot_man() {
      iotMan.methods.deletePoliceManMarks();
      iotMan.methods.stopFreshPolicePos();
      CesiumPop.clearDivPop(viewer);
    },
    close_win_iot_car() {
      iotCar.methods.clearPoliceCar3DMarks();
      iotCar.methods.stopFreshPoliceCarPos();
      iotCar.methods.carHisStop();
      CesiumPop.clearDivPop(viewer);
    },
    close_win_iot_water() {
      iotWater.methods.closeWaterLevel();
    },
    close_win_iot_environment() {
      iotEnvironment.methods.closeIotEnvironment();
    },
    close_win_iot_uav() {
      iotUav.methods.closeIotUav();
    },
    close_win_iot_uav_his() {
      iotUavHis.methods.closeUavHis();
    },
    close_win_real_people() {
      realPeople.methods.closeRealPeople();
    },
    close_win_real_house() {
      realHouse.methods.closeRealHouse();
    },
    close_win_real_company() {
      realCompany.methods.closeRealCompany();
    },
    close_win_real_address() {
      realAddress.methods.closeRealAddress();
    },
    close_win_net() {
      netManage.methods.closeNet();
    },
    close_win_duty_heatmap() {
      dutyHeatmap.methods.closeDutyHeatmap();
    },
    close_win_duty_stream() {
      dutyStream.methods.closeDutyStream();
    },
    close_win_station() {
      netSecurity.methods.closeSecurity();
    },
    close_win_plan_war() {
      planWar.methods.stopArrow();
    },
    close_win_plan_peace() {
      planPeace.methods.clearEplan();
    },
    close_win_flood() {
      planFlood.methods.closeFlood();
    },
    close_win_weather() {
      demoWeather.methods.closeWeather();
    },
    close_win_bim() {
      tiles3dBim.methods.closeBIM();
    },
    close_net_custom() {
      netCustom.methods.closeCustom();
    },
    close_win_building() {
      netBuilding.methods.closeBuilding();
    },
    close_win_pipeline() {
      demoPipeline.methods.closePipeline();
    },
    close_win_missile() {
      demoMissile.methods.closeMissile();
    },
    close_win_route() {
      mapRoute.methods.clearRouteLine();
      mapRoute.methods.clearRoutePoi();
    },
    close_win_eye() {
      mapEye.methods.clearVisible();
    },
    close_win_layer() {
      mapLayer.methods.cleardatalayer();
    },
    close_win_tag() {
      toolTags.methods.clearTags();
      toolTags.methods.stopAddTagHandle();
    },
    close_win_roam() {
      toolRoam.methods.stopRoaming();
    },
    close_win_search() {
      toolSearchPOI.methods.clearsuggestionArr();
      CesiumPop.clearDivPop(viewer);
    },
    close_win_first() {
      mapFirstControl.methods.stopFirtControl();
    },
    close_win_bim_device() {
      bimDevice.methods.closeBimDevice();
    },
    close_win_bim_water_flow() {
      bimWaterFlow.methods.closeBimWaterFlow();
    },
    close_win_bim_region() {
      bimRegion.methods.closeBimRegion();
    },
    close_win_duty_video() {
      dutyVideo.methods.closeDutyVideo();
    },
    close_win_duty_ai() {
      dutyAi.methods.closeDutyAi();
    },
    close_win_duty_ai_list() {
      dutyAiList.methods.stopFaceAlarm();
      dutyAiList.methods.manHisStop();
    },
    close_win_city_thing() {
      cityThing.methods.closeCityThing();
    },
    close_win_city_building() {
      cityBuilding.methods.closeCityBuilding();
    },
    close_win_city_building_remove() {
      cityBuildingRemove.methods.closeCityBuildingRemove();
    },
    close_win_access_man() {
      accessMan.methods.closeAccessMan();
    },
    close_win_access_man_list() {
      accessManList.methods.stopAccessMan();
    },
    close_win_access_car_list() {
      accessCarList.methods.stopAccessCar()
    },
    close_win_access_car() {
      accessCar.methods.closeAccessCar();
    },
    close_win_duty_point() {
      dutyPoint.methods.closePolicePoint();
    },
    close_win_duty_line() {
      dutyLine.methods.closePoliceLine();
    },
    close_win_duty_net() {
      dutyNet.methods.closePoliceNet();
    },
    close_win_bim_case() {
      bimCase.methods.closeBimCase();
    },
    close_win_map_photos() {
      mapPhotos.methods.closeMapPhotos();
    },
    close_win_map_image() {
      mapImage.methods.closeMapImage();
    },

    /**统计、测量、打开图层等直接触发执行方法*/
    map_stat_case() {
      if (isCaseHeatmapShow) {
        statBigDataMap.methods.closeStatCase();
      } else {
        statBigDataMap.methods.showStatCase();
      }
      isCaseHeatmapShow = !isCaseHeatmapShow;
    },
    map_stat_people() {
      if (isKeyPeopleHeatmapShow) {
        statBigDataMap.methods.closeStatPeople();
      } else {
        statBigDataMap.methods.showStatPeople();
      }
      isKeyPeopleHeatmapShow = !isKeyPeopleHeatmapShow;
    },
    map_stat_video_area() {
      if (isVideoScopeShow) {
        statBigDataMap.methods.closeStatVideoScope();
      } else {
        statBigDataMap.methods.showStatVideoScope();
      }
      isVideoScopeShow = !isVideoScopeShow;
    },
    map_stat_patrol_man() {
      if (isPoliceLinesShow) {
        statBigDataMap.methods.closepoliceLines();
      } else {
        statBigDataMap.methods.showStatPoliceLines();
      }
      isPoliceLinesShow = !isPoliceLinesShow;
    },
    measure_height_angle() {
      CesiumSurvey.clearHandler();
      CesiumSurvey.measureHeightAngle(viewer);
    },
    measure_distances() {
      CesiumSurvey.clearHandler();
      CesiumSurvey.measureDist(viewer);
    },
    measure_height() {
      CesiumSurvey.clearHandler();
      CesiumSurvey.measureHeight(viewer);
    },
    measure_area() {
      CesiumSurvey.clearHandler();
      CesiumSurvey.measureArea(viewer);
    },
    measure_point() {
      CesiumSurvey.clearHandler();
      let img = 'static/images/pinimg/32.png';
      CesiumSurvey.measurePoint(viewer, img);
    },
    move_measure_point() {
      if (isMoveResultShow) {
        CesiumSurvey.clearMMHandler();
        document.getElementById('moveResult').style.display = 'none';
      } else {
        CesiumSurvey.measureMovePoint(viewer, 'moveResultCon');
        document.getElementById('moveResult').style.display = 'block';
      }
      isMoveResultShow = !isMoveResultShow;
    },
    cammove_measure_point() {
      if (isCammoveResultShow) {
        CesiumSurvey.clearCamMMHandler();
        document.getElementById('cammoveResult').style.display = 'none';
      } else {
        CesiumSurvey.cammeasureMovePoint(viewer, 'cammoveResultCon');
        document.getElementById('cammoveResult').style.display = 'block';
      }
      isCammoveResultShow = !isCammoveResultShow;
    },
    win_Simple3D() {
      if (isSimple3DShow) {
        map3d.methods.removeSimple3D();
        this.map_addLocalTerrain();
        this.ui_compass();
      } else {
        map3d.methods.addSimple3D();
        this.map_addelTerrain();
        map3d.methods.removeTilesetWall();
        this.ui_compass();
      }
      isSimple3DShow = !isSimple3DShow;
    },
    /**添加cesium提供的全球30米分辨率地形数据*/
    map_addWorldTerrain() {
      map3d.methods.addWorldTerrain();
      map3d.methods.initTilesetWall(5.0);
    },
    /**添加ArcGIS提供的全球高分辨率地形数据*/
    map_adArcGISTerrain() {
      map3d.methods.addArcgisTerrain();
    },
    map_addLocalTerrain() {
      map3d.methods.addLocalTerrain();
      map3d.methods.initTilesetWall(5.0);
    },
    map_addLocalImageLayer() {
      map3d.methods.addLocalImageLayer();
    },
    map_addelTerrain() {
      map3d.methods.addelTerrain();
      map3d.methods.initTilesetWall(2.0);
    },
    map_addDarkMapLayer() {
      map3d.methods.addDarkMapLayer();
    },
    map_addgoogleImageLayer() {
      map3d.methods.addgoogleImageLayer();
    },
    map_addarcgisImageLayer() {
      map3d.methods.addarcgisImageLayer();
    },
    map_addtdtImageLayer() {
      map3d.methods.addtdtImageLayer();
    },
    map_addtdtVectorLayer() {
      map3d.methods.addtdtVectorLayer();
    },
    map_showImportantLable() {
      if (isLabelShow) {
        map3d.methods.closeImportantLable();
      } else {
        map3d.methods.showImportantLable();
      }
      isLabelShow = !isLabelShow;
    },
    map_huge() {
      if (isHugeShow) {
        map3d.methods.clearMapHuge();
      } else {
        map3d.methods.loadMapHuge();
      }
      isHugeShow = !isHugeShow;
    },
    map_wholeView() {
      map3d.methods.wholeView();
    },
    ui_fullscreen() {
      let protectelm = document.getElementById("stat-protect");
      let peopleelm = document.getElementById("stat-people");
      let caseelm = document.getElementById("stat-case");
      let deviceelm = document.getElementById("stat-device");
      let stationelm = document.getElementById("stat-station");
      let transportelm = document.getElementById("stat-transport");
      if (document.getElementById('map-bar-left').style.display === "block") {
        document.getElementById('map-bar-left').style.display = "none";
        document.getElementById('map-bar-right').style.display = "none";
        let pos = 0;
        let intervalId = setInterval(function () {
          if (pos === -540) {
            clearInterval(intervalId);
            pos = 0;
          } else {
            pos -= 10;
            protectelm.style.left = pos + 'px';
            peopleelm.style.left = pos + 'px';
            caseelm.style.left = pos + 'px';
            deviceelm.style.right = pos + 'px';
            stationelm.style.right = pos + 'px';
            transportelm.style.right = pos + 'px';
          }
        }, 1);
      } else {
        document.getElementById('map-bar-left').style.display = "block";
        document.getElementById('map-bar-right').style.display = "block";
        let pos1 = -420;
        let intervalId1 = setInterval(function () {
          if (pos1 === 0) {
            clearInterval(intervalId1);
            pos1 = -420;
          } else {
            pos1 += 10;
            protectelm.style.left = pos1 + 'px';
            peopleelm.style.left = pos1 + 'px';
            caseelm.style.left = pos1 + 'px';
            deviceelm.style.right = pos1 + 'px';
            stationelm.style.right = pos1 + 'px';
            transportelm.style.right = pos1 + 'px';
          }
        }, 1);
      }
    },
    ui_compass() {
      if (viewer.entities.getById("rotatingDial")) {
        map3d.methods.removeRotatingDial();
      } else {
        map3d.methods.initRotatingDial();
      }
    },
    ui_buffer() {
      if (viewer.entities.getById("tilesetWall")) {
        map3d.methods.removeTilesetWall();
      } else {
        map3d.methods.initTilesetWall(5.0);
      }
    },
    ui_shadow() {
      let shadows = viewer.shadows;
      viewer.shadows = !shadows;
    },
    ui_light() {
      let enableLighting = viewer.scene.globe.enableLighting;
      viewer.scene.globe.enableLighting = !enableLighting;
    },
    ui_bloom() {
      if (isBloomShow) {
        isBloomShow = false;
        map3d.methods.enableBloom(isBloomShow);
      } else {
        isBloomShow = true;
        map3d.methods.enableBloom(isBloomShow);
      }
    },
    ui_mask() {
      if (isShadowShow) {
        document.getElementById("mask").style.display = "none";
      } else {
        document.getElementById("mask").style.display = "block";
      }
      isShadowShow = !isShadowShow;
    },
    ui_Traffic() {
      if (isTrafficShow) {
        map3d.methods.clearTraffic();
      } else {
        map3d.methods.showTraffic();
      }
      isTrafficShow = !isTrafficShow;
    },
    ui_cloud() {
      if (isCloudShow) {
        map3d.methods.clearVolumetricClouds();
      } else {
        map3d.methods.showVolumetricClouds();
      }
      isCloudShow = !isCloudShow;
    },
    ui_cross() {
      if (isCrossShow) {
        map3d.methods.clearCross();
      } else {
        map3d.methods.showCross();
      }
      isCrossShow = !isCrossShow;
    },
    ui_water() {
      if (isWaterShow) {
        map3d.methods.clearKmlWater();
      } else {
        map3d.methods.showKmlWater();
      }
      isWaterShow = !isWaterShow;
    },
    ui_fxaa() {
      if (Cesium.FeatureDetection.supportsImageRenderingPixelated()) {//判断是否支持图像渲染像素化处理
        viewer.resolutionScale = window.devicePixelRatio;
      }
      if (viewer.scene.fxaa) {
        viewer.scene.fxaa = false;
        viewer.scene.postProcessStages.fxaa.enabled = false;
      } else {
        viewer.scene.fxaa = true;
        viewer.scene.postProcessStages.fxaa.enabled = true;
      }
    },
    ui_msaa() {
      if (!viewer.scene.msaaSupported) {
        window.alert("This browser does not support MSAA.");
      }
      if (viewer.scene.msaaSamples === 0 || viewer.scene.msaaSamples === 1) {
        viewer.scene.msaaSamples = 8;
      } else {
        viewer.scene.msaaSamples = 0;
      }
    },
    map_clear() {
      CesiumSurvey.measureClear(viewer);//清除测量
      iotCar.methods.carHisStop();//清除车辆轨迹
      toolTags.methods.clearTags();
      toolTags.methods.stopAddTagHandle();
      caseCall.methods.stopMovePin();
    },
    font_download() {
      window.open('static/DS-DIGIB.TTF');
    },
    resizeState() {
      let winWidth = Number(document.documentElement.clientWidth);
      let stateWidth = winWidth - this.funcList.length * 100;
      document.documentElement.getElementsByClassName('sys-state')[0].style.width = stateWidth + 'px';
    },
    logout() {
      localStorage.clear();
      this.$router.push("/");
      location.reload();
    },
    //阻止弹窗多次出现
    stopAlertPop(id) {
      if (document.getElementById(id)) {
        this.$message.error("窗口已存在！请勿重复开启！");
        return false;
      } else {
        return true
      }
    },
    getFuncList() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          "funcSrc": "应用前台"
        };
        getFuncBySrc(params).then(res => {
          let level1 = [];
          let level2 = [];
          res.data.map(item => {
            if (item.funcLevel === "一级") {
              let lev1 = {
                'funcName': item.funcDefaultName,
                'sysFunc': item
              };
              lev1.children = [];
              level1.push(lev1);
            } else {
              let lev2 = {
                'funcName': item.funcDefaultName,
                'sysFunc': item
              };
              level2.push(lev2);
            }
            let icon = this.iconArr.find(icon => {
              return icon.iconId === item.funcIcon;
            });
            item.funcIconType = icon.iconType;
          });
          level1.map(lev1 => {
            level2.map(lev2 => {
              if (lev1.sysFunc.funcId === lev2.sysFunc.funcPid) {
                lev1.children.push(lev2);
              }
            });
          });
          this.funcList = level1;
          this.resizeState();
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
          'roleName': "应用前台"
        };
        getAllandFuncByIdandSrc(params).then(res => {
          let level1 = [];
          let level2 = [];
          res.data.sysRoleFunc.map(item => {
            if (item.sysFunc.funcLevel === "一级") {
              item.children = [];
              level1.push(item);
            } else {
              level2.push(item);
            }
            let icon = this.iconArr.find(icon => {
              return icon.iconId === item.sysFunc.funcIcon;
            });
            item.sysFunc.funcIconType = icon.iconType;
          });
          level1.map(lev1 => {
            level2.map(lev2 => {
              if (lev1.funcId === lev2.roleFuncPid) {
                lev1.children.push(lev2);
              }
            });
          });
          this.funcList = level1;
          this.resizeState();
        });
      }
    },
    initUI() {
      if (localStorage.getItem("app") === 'sunhengyi18826126699') {
        this.ui.appName = '实景三维智慧城市平台';
        this.ui.appVersion = 'CITY3D';
        this.ui.appLogo = 'image/logo/superadmin.png';
        for (let i = 0; i < 100; i++) {
          this.uiMode.push(false);
        }
        this.uiMode[0] = true;
        window.appPos = '126.60801015108913,45.68098813093156,5122.238481546125,0.18118455208178974,-50.07516275099384,0';
        window.appImage = "本地暗色地图";
        window.appTerrain = "本地地形";
        setTimeout(() => {
          map3d.methods.wholeView();
        }, 100);
      } else {
        let params = {
          appId: localStorage.getItem("app")
        };
        getAppById(params).then(res => {
          this.ui = res.data;
          for (let i = 0; i < 100; i++) {
            this.uiMode.push(false);
          }
          let curMode = Number(this.ui.appUiMode);
          this.uiMode[curMode] = true;
          window.appPos = res.data.appPos;
          window.appImage = res.data.appImage;
          window.appTerrain = res.data.appTerrain;
          map3d.methods.wholeView();
        })
      }
    }
  },
  mounted() {
    window.onresize = () => {
      return (() => {
        this.resizeState();
      })();
    };
    this.iconArr = iconArr;
    this.userName = localStorage.getItem("userName");
    this.getFuncList();
    this.initUI();
    this.initChecked();
  },
}
</script>

<style scoped>
.header {
  position: absolute;
  z-index: 999;
  width: 100%;
  height: 34px;
  background-color: #11264DD1;
  color: #f2f2f2
}

.sys-title {
  position: absolute;
  height: 77px;
  width: 980px;
  background: url("../assets/header/title.png");
  z-index: 5
}

.sys-logo {
  float: left;
  margin: 8px 0 0 20px;
  width: 46px;
  height: 46px;
  filter: drop-shadow(0px 0px 14px #ffffff);
}

.sys-name {
  float: left;
  font-family: IconFont;
  font-style: italic;
  font-size: 25px;
  font-weight: bold;
  margin: 15px 5px 0 20px
}

.sys-bar {
  font-size: 15px;
  float: left;
  margin: 25px 0 0 6px;
  font-style: italic;
}

.sys-version {
  font-size: 12px;
  float: left;
  margin: 31px 0 0 10px;
  font-style: italic;
}

.navigation-icons {
  position: absolute;
  right: 0;
  top: 34px;
  z-index: 6
}

.navigation-fai {
  margin: 0 14px 0 2px;
  font-size: 16px;
  cursor: pointer;
}

.sys-tools {
  position: absolute;
  right: 20px;
  top: 7px;
  color: #00ffff
}

.sys-tools-fai {
  margin: 0 0 0 20px;
  font-size: 18px;
  cursor: pointer;
}

.sys-state {
  position: absolute;
  left: 0;
  top: 34px;
  height: 40px;
  color: #00ffff;
  background-color: #11264DD1;
}

.sys-state-user {
  float: left;
  font-size: 15px;
  max-width: 170px;
}

.sys-state-icon {
  float: left;
  margin: 1px 5px 0 520px;
  font-size: 18px;
}

.map-bar-left {
  left: 0;
}

.map-bar-right {
  right: 0;
}

.map-bar {
  height: 100%;
  width: 0;
  box-shadow: 0 5px 450px 250px #11264D;
  position: absolute;
  z-index: 1;
}

.mask {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  box-shadow: inset 1px 0 150px 70px #11264DCC;
  pointer-events: none;
  z-index: 1;
}

.navigation-icons-left {
  position: absolute;
  left: 5px;
  bottom: 5px;
  z-index: 6;
  width: 210px;
  height: 800px;
  background-color: #0f65e855;
  border: solid 1px #175be8;
  padding: 20px 10px;
  color: #ffffff;
  font-size: 15px;
}

.navigation-icons-left-body {
  height: 800px;
  overflow-y: auto;
}

.navigation-icons-left-body::-webkit-scrollbar {
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.navigation-icons-left-body::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.navigation-icons-left-body::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.box_lt {
  width: 10px;
  height: 10px;
  position: absolute;
  border-top: 2px solid #00d3e7;
  border-left: 2px solid #00d3e7;
  left: 5px;
  top: 5px;
}

.box_rt {
  width: 10px;
  height: 10px;
  position: absolute;
  border-top: 2px solid #00d3e7;
  border-right: 2px solid #00d3e7;
  right: 5px;
  top: 5px;
}

.box_rb {
  width: 10px;
  height: 10px;
  position: absolute;
  border-bottom: 2px solid #00d3e7;
  border-right: 2px solid #00d3e7;
  right: 5px;
  bottom: 5px;
}

.box_lb {
  width: 10px;
  height: 10px;
  position: absolute;
  border-bottom: 2px solid #00d3e7;
  border-left: 2px solid #00d3e7;
  left: 5px;
  bottom: 5px;
}

.pad-header {
  position: absolute;
  z-index: 999;
  width: 100%;
  height: 54px;
  color: #f2f2f2;
  background: url("../assets/header/title-2.png") center center no-repeat;
  text-align: center;
}

.pad-sys-title {
  line-height: 54px;
  width: 320px;
  margin: auto;
  vertical-align: middle;
  text-align: center;
}

.pad-sys-logo {
  float: left;
  margin: 6px 0 0 0;
  width: 28px;
  height: 28px;
  filter: drop-shadow(0px 0px 14px #ffffff);
}

.pad-sys-name {
  float: left;
  font-family: IconFont;
  font-style: italic;
  font-size: 16px;
  font-weight: bold;
  letter-spacing: 1px;
  margin: -7px 5px 0 6px;
}

.pad-sys-bar {
  float: left;
  font-size: 13px;
  margin: -6px 0 0 0;
  font-style: italic;
}

.pad-sys-version {
  float: left;
  font-size: 10px;
  margin: -4px 0 0 5px;
  font-style: italic;
}

.pad-mask {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  box-shadow: inset 1px 0 20px 5px #11264DCC;
  pointer-events: none;
  z-index: 1;
}

.pad-sys-tools-left {
  position: absolute;
  z-index: 999;
  top: 10px;
  left: 20px;
  color: #eeeeee;
}

.pad-sys-tools-right {
  position: absolute;
  z-index: 999;
  top: 10px;
  right: 20px;
  color: #eeeeee;
}

.pad-sys-tools-btn {
  margin: 0 0 0 20px;
  font-size: 18px;
  cursor: pointer;
  background-color: #11264DBB;
  border: solid 1px #175be8;
  border-radius: 22px;
  box-shadow: #175be8 0 0 5px 3px inset;
  width: 44px;
  height: 44px;
  text-align: center;
  float: left;
}

.pad-sys-tools-fai {
  margin-top: 13px;
}

.pad-box_lt {
  width: 10px;
  height: 10px;
  position: absolute;
  border-top: 2px solid #00d3e7;
  border-left: 2px solid #00d3e7;
  left: 0;
  top: 0;
}

.pad-box_rb {
  width: 10px;
  height: 10px;
  position: absolute;
  border-bottom: 2px solid #00d3e7;
  border-right: 2px solid #00d3e7;
  right: 0;
  bottom: 0;
}

.pad-box_rt {
  width: 10px;
  height: 10px;
  position: absolute;
  border-top: 2px solid #00d3e7;
  border-right: 2px solid #00d3e7;
  right: 0;
  top: 0;
}

.pad-box_lb {
  width: 10px;
  height: 10px;
  position: absolute;
  border-bottom: 2px solid #00d3e7;
  border-left: 2px solid #00d3e7;
  left: 0;
  bottom: 0;
}

.navigation-icons-v-left {
  position: absolute;
  left: 0;
  bottom: 0;
  z-index: 6;
  border: none;
  box-shadow: #1768e8 0 0 9px 6px inset;
}

.pad-sys-tools-bottom {
  position: absolute;
  z-index: 999;
  bottom: 0;
  left: 10px;
  color: #eeeeee;
}

.pad-sys-tools-btn-bottom {
  margin: 0 0 15px 0;
  font-size: 18px;
  cursor: pointer;
  background-color: #11264DBB;
  border: solid 1px #175be8;
  border-radius: 22px;
  box-shadow: #175be8 0 0 5px 3px inset;
  width: 44px;
  height: 44px;
  text-align: center;
}

.ui-5 {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1000;
}

.ui5-header-bg {
  width: 100%;
}

.ui5-logo {
  width: 511px;
  position: absolute;
  top: 0;
  left: 0;
}

.ui5-btn-group {
  width: 475px;
  height: 28px;
  position: absolute;
  z-index: 1001;
  top: 20px;
  left: 435px;
}

.ui5-btn {
  width: 126px;
  height: 28px;
  color: #9fdaff;
  font-size: 16px;
  font-family: 黑体;
}

.ui5-btn-bg {
  width: 126px;
  height: 28px;
  position: absolute;
  top: 0;
  left: 0;
}

.ui5-btn-bg-r {
  width: 126px;
  height: 28px;
  position: absolute;
  top: 0;
  left: 0;
}

.ui5-btn-text {
  position: absolute;
  z-index: 10;
  top: 5px;
  left: 31px;
}

.ui5-btn-text-hl {
  color: #00ffea;
  font-size: 15px;
  font-family: Arial, Helvetica, sans-serif;
}

.ui5-btn-2 {
  position: absolute;
  top: 0;
  left: 115px;
}

.ui5-btn-3 {
  position: absolute;
  top: 0;
  left: 230px;
}

.ui5-btn-4 {
  position: absolute;
  top: 0;
  left: 345px;
}

.ui5-date {
  width: 287px;
  height: 28px;
  position: absolute;
  z-index: 1001;
  top: 27px;
  right: 21%;
  color: #9fdaff;
  font-size: 15px;
  font-family: Arial, Helvetica, sans-serif;
}

.ui5-tools {
  width: 100px;
  height: 28px;
  position: absolute;
  z-index: 1001;
  top: 27px;
  right: 15px;
  color: #9fdaff;
  font-size: 15px;
  font-family: Arial, Helvetica, sans-serif;
  text-align: right;
}

.ui5-enviro {
  width: 258px;
  height: 28px;
  position: absolute;
  z-index: 1001;
  top: 27px;
  right: 4%;
  color: #9fdaff;
  font-size: 15px;
  font-family: Arial, Helvetica, sans-serif;
}

.ui5-stat-left {
  width: 474px;
  position: absolute;
  z-index: 1001;
  top: 72px;
  bottom: 0;
}

.ui5-stat-left-bg {
  width: 474px;
  position: absolute;
  z-index: 1001;
  top: 0;
  bottom: 0;
}

.ui5-stat-right {
  width: 474px;
  position: absolute;
  z-index: 1001;
  right: 0;
  top: 72px;
  bottom: 0;
}

.ui5-stat-right-bg {
  width: 474px;
  position: absolute;
  z-index: 1001;
  top: 0;
  bottom: 0;
}

.ui5-foot {
  width: 100%;
  position: absolute;
  z-index: 1001;
  bottom: 0;
}
</style>
