<template>
  <div v-bind:id="'popupDiv'+popId" class="mapPop"
       v-bind:ref="'nmaPop-'+levelNum" v-on:click="clickStick('popupDiv'+popId)">
    <div class="mapPop-title" style="border-color:#00d3e788">
      <div class="mapPop-name">{{name}}-{{curInfoType}}
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'university']" title="网格概况"
                           v-on:click.stop="showCompany"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-tie']" title="网格长"
                           v-on:click.stop="showPeople"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-friends']" title="联络员"
                           v-on:click.stop="showHouse"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'marker']" title="网格统计"
                           v-on:click.stop="showAddress"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'level-down-alt']" title="进入"
                           v-on:click.stop="pop_in" v-show="!isfaiShow"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'level-down-alt']" title="进入"
                           v-on:click.stop="pop_in_c" v-show="isfaiShow"></font-awesome-icon>
      </div>
    </div>
    <div class="mapPop-content" style="border-color:#00d3e788;">
      <div v-show="isCompanyShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">网格名称</td>
            <td>{{name}}</td>
          </tr>
          <tr>
            <td>网格类型</td>
            <td>{{netLevel}}</td>
          </tr>
          <tr>
            <td>所属社区</td>
            <td class="td-con">{{netCom}}</td>
          </tr>
          <tr>
            <td>常住人员数</td>
            <td class="DS-font">{{netBasePeople}}</td>
          </tr>
          <tr>
            <td>户籍人员数</td>
            <td class="DS-font">{{netHoldPeople}}</td>
          </tr>
          <tr>
            <td>外来人员数</td>
            <td class="DS-font">{{netFlowPeople}}</td>
          </tr>
          <tr>
            <td>组团力量数</td>
            <td class="DS-font">{{netGroup}}</td>
          </tr>
          <tr>
            <td class="td-label">备注</td>
            <td class="td-con">{{netNote}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isPeopleShow">
        <div class="leftimg">
          <el-image class="leftimg-img" :src="imgSrc+netMaster.imgurl"
                    :preview-src-list="[imgSrc+netMaster.imgurl]"></el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">姓名</td>
            <td>{{netMaster.name}}</td>
          </tr>
          <tr>
            <td>职务</td>
            <td>{{netMaster.post}}</td>
          </tr>
          <tr>
            <td>工作职责</td>
            <td class="td-con">{{netMaster.duty}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{netMaster.tel}}</td>
          </tr>
          <tr>
            <td>党员信息</td>
            <td>{{netMaster.party}}</td>
          </tr>
          <tr>
            <td>入职时间</td>
            <td>{{netMaster.jobTime}}</td>
          </tr>
          <tr>
            <td>备注</td>
            <td class="td-con">{{netMaster.note}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isHouseShow">
        <div v-for="(item, index) in netListener" :key="index" class="table-for">
          <table class="infoPop-tabel-w" cellspacing="0">
            <tr>
              <td rowspan="7" class="" style="vertical-align: top;">
                <el-image class="leftimg-img" :src="imgSrc+item.imgurl"
                          :preview-src-list="[imgSrc+item.imgurl]"></el-image>
              </td>
              <td class="td-label">民情联络员{{index+1}}</td>
              <td>{{item.name}}</td>
            </tr>
            <tr>
              <td>职务</td>
              <td>{{item.post}}</td>
            </tr>
            <tr>
              <td>工作职责</td>
              <td>{{item.duty}}</td>
            </tr>
            <tr>
              <td>联系电话</td>
              <td>{{item.tel}}</td>
            </tr>
            <tr>
              <td>党员信息</td>
              <td>{{item.party}}</td>
            </tr>
            <tr>
              <td>入职时间</td>
              <td>{{item.jobTime}}</td>
            </tr>
            <tr>
              <td>备注</td>
              <td class="td-con">{{item.note}}</td>
            </tr>
          </table>
        </div>
      </div>
      <div v-show="isAddressShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td>标准分户</td>
            <td class="DS-font">{{raNum}}</td>
          </tr>
          <tr>
            <td>实有人口</td>
            <td class="DS-font">{{rpNum}}</td>
          </tr>
          <tr>
            <td>实有房屋</td>
            <td class="DS-font">{{rhNum}}</td>
          </tr>
          <tr>
            <td>实有单位</td>
            <td class="DS-font">{{rcNum}}</td>
          </tr>
          <tr>
            <td>下级网格</td>
            <td class="DS-font">{{nnNum}}</td>
          </tr>
        </table>
      </div>
    </div>
    <div style="border-top-color:#00d3e7;filter: drop-shadow(0 0 6px #00d3e7)" class="box_leg"></div>
    <div style="border-color:#00d3e7" class="box_lt"></div>
    <div style="border-color:#00d3e7" class="box_lb"></div>
    <div style="border-color:#00d3e7" class="box_rt"></div>
    <div style="border-color:#00d3e7" class="box_rb"></div>
  </div>
</template>

<script>
  import netManage from "@/components/net-manage";
  import {getNetManById} from "../../../api/api";

  let popzIndex = 0;
  export default {
    name: "pop-netManageArea",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        name: "",
        netMaster: {
          imgurl: "",
          name: "",
          post: "",
          duty: "",
          tel: "",
          party: "",
          jobTime: "",
          note: ""
        },
        netMasterId: "",
        netListenerIds: [],
        netListener: [],
        netBasePeople: "",
        netHoldPeople: "",
        netFlowPeople: "",
        netGroup: "",
        netNote: "",
        netCom: "",
        netLevel: "",
        curInfoType: "概况",
        isPeopleShow: false,
        isHouseShow: false,
        isCompanyShow: true,
        isAddressShow: false,
        isfaiShow: false,
        imgSrc: common.serverIp + "city3dfile/"
      }
    },
    methods: {
      showPeople() {
        this.isPeopleShow = true;
        this.isHouseShow = false;
        this.isCompanyShow = false;
        this.isAddressShow = false;
        this.curInfoType = '网格长';
        let params = {
          netManId: this.netMasterId
        };
        getNetManById(params).then(res => {
          this.netMaster = res.data;
        });
      },
      showHouse() {
        this.isPeopleShow = false;
        this.isHouseShow = true;
        this.isCompanyShow = false;
        this.isAddressShow = false;
        this.curInfoType = '联络员';
        this.netListenerIds.map(item => {
          let params = {
            netManId: item
          };
          getNetManById(params).then(res => {
            this.netListener.push(res.data);
          });
        });
      },
      showCompany() {
        this.isPeopleShow = false;
        this.isHouseShow = false;
        this.isCompanyShow = true;
        this.isAddressShow = false;
        this.curInfoType = '概况';
      },
      showAddress() {
        this.isPeopleShow = false;
        this.isHouseShow = false;
        this.isCompanyShow = false;
        this.isAddressShow = true;
        this.curInfoType = '统计';
      },
      pop_in() {
        netManage.methods.stepInNextLevel(this.popId);
      },
      pop_in_c() {
        netManage.methods.stepInCommunity(this.popId);
      },
      pop_close() {
        let pop = this.$refs['nmaPop-' + this.levelNum];
        if (pop) {
          document.querySelector('body').removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      }
    },
    mounted() {
      switch (this.netLevel) {
        case "0":
          this.netLevel = "街道";
          break;
        case "1":
          this.netLevel = "社区";
          break;
        case "2":
          this.netLevel = "小区";
          break;
        case "3":
          this.netLevel = "一级网格";
          break;
        case "4":
          this.netLevel = "二级网格";
          break;
        default:
          break;
      }
    }
  }
</script>

<style scoped>
  .mapPop {
    width: 240px;
    height: 235px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
  }

  .mapPop-title {
    width: 100%;
    font-size: 13px;
    font-weight: bolder;
    letter-spacing: 2px;
    border: solid;
    border-width: 1px 0 0 0;
    padding: 5px 8px;
    min-height: 50px;
    background-color: #11264DD1;
  }

  .mapPop-name {
    font-size: 14px;
  }

  .infoPop-tools {
    margin-top: 5px;
    float: right
  }

  .infoPop-tools-fai {
    cursor: pointer;
    float: right;
    margin: 2px 1px 0 0;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 0 0 15px;
  }

  .mapPop-content {
    border: solid;
    border-width: 1px 0;
    font-size: 13px;
    background-color: #11264DD1;
    padding: 2px;
    box-sizing: border-box;
    height: 185px;
    overflow-y: auto;
    overflow-x: hidden;
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

  .td-label {
    min-width: 80px;
  }

  .td-con{
    word-break:break-all;
  }

  .infoPop-tabel {
    width: 160px;
    border: none;
    margin-top: 1px;
    float: right
  }

  .infoPop-tabel-w {
    width: 100%;
    border: none;
    margin-top: 1px;
    text-align: center;
  }

  .infoPop-tabel td, .infoPop-tabel-w td {
    padding: 2px 5px;
  }

  .infoPop-tabel tr:nth-child(odd), .infoPop-tabel-w tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even), .infoPop-tabel-w tr:nth-child(even) {
    background: #091d46bb;
  }

  .leftimg {
    float: left;
    margin-top: 1px;
  }

  .leftimg-img {
    width: 50px !important
  }

  .table-for {
    margin-bottom: 10px;
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
    left: 110px;
  }

  .DS-font {
    font-family: DS-Digital;
    color: #ffe700;
    font-size: 20px;
  }
</style>
