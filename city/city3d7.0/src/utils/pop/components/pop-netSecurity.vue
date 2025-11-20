<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'nsPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">派出所/警务站详细信息</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'university']" title="网格概况"
                           v-on:click.stop="showCompany"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'user-tie']" title="网格长"
                           v-on:click.stop="showPeople"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'user-friends']" title="联络员"
                           v-on:click.stop="showHouse"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'level-down-alt']" title="下级网格"
                           v-on:click.stop="nextLevel"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div v-show="isCompanyShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">名称</td>
            <td>{{nsdata.securityName}}</td>
          </tr>
          <tr>
            <td>类型</td>
            <td>{{nsdata.securityType}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{nsdata.securityTel}}</td>
          </tr>
          <tr>
            <td>级别</td>
            <td>{{nsdata.level}}</td>
          </tr>
          <tr>
            <td>下级网格</td>
            <td class="DS-font">{{nextNum}}</td>
          </tr>
          <tr>
            <td>简介</td>
            <td>{{nsdata.securityDescribe}}</td>
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
    </div>
  </div>
</template>

<script>
  import {getNetManById, querySecurity} from "../../../api/api";
  import netSecurity from "../../../components/net-security";

  let popzIndex = 0;
  export default {
    name: "pop-netSecurity",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        nsdata: {},
        curInfoType: "概况",
        isPeopleShow: false,
        isHouseShow: false,
        isCompanyShow: true,
        imgSrc: common.serverIp + "city3dfile/",
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
        nextNum: 0
      }
    },
    methods: {
      showPeople() {
        this.isPeopleShow = true;
        this.isHouseShow = false;
        this.isCompanyShow = false;
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
        this.curInfoType = '概况';
      },
      nextLevel() {
        this.pop_close();
        let params = {
          "pid": this.nsdata.securityId
        };
        querySecurity(params).then(res => {
          netSecurity.methods.closeSecurity();
          netSecurity.methods.showSecurityAll(res.data);
        });
      },
      pop_close() {
        let pop = this.$refs['nsPop-' + this.levelNum];
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
    }
  }
</script>

<style scoped>
  .infoPop {
    width: 477px;
    height: 323px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
    background: url("../../../assets/pop/info_pop_h.png");
  }

  .infoPop-title {
    width: 370px;
    font-size: 14px;
    padding: 5px 8px;
    min-height: 30px;
    margin: 23px 0 0 90px;
    border-bottom: solid;
    border-width: 1px 0;
  }

  .infoPop-name {
    float: left;
  }

  .infoPop-tools {
    float: right
  }

  .infoPop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .infoPop-content {
    font-size: 14px;
    padding: 3px;
    width: 370px;
    height: 160px;
    overflow-y: auto;
    overflow-x: hidden;
    color: #fff;
    margin: 0 0 0 90px;
  }

  .infoPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .infoPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .infoPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .infoPop-tabel-w {
    width: 100%;
    border: none;
    margin-top: 5px;
  }

  .infoPop-tabel {
    width: 300px;
    border: none;
    margin-top: 5px;
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

  .td-label {
    min-width: 80px;
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
</style>
