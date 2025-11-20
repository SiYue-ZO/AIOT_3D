<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'nmPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{curInfoType}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-tie']" title="人口信息"
                           v-on:click.stop="showPeople"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'house-user']" title="住房信息"
                           v-on:click.stop="showHouse"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'calculator']" title="户型"
                           v-on:click.stop="showLayout"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'university']" title="单位信息"
                           v-on:click.stop="showCompany"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'marker']" title="地名地址信息"
                           v-on:click.stop="showAddress"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div v-show="isPeopleShow">
        <div class="leftimg">
          <el-image class="leftimg-img" :src="rpdata.imgurl" :preview-src-list="[rpdata.imgurl]"></el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">姓名</td>
            <td>{{rpdata.name}}</td>
          </tr>
          <tr>
            <td>人口类别</td>
            <td>{{rpdata.peopleType}}</td>
          </tr>
          <tr>
            <td>工作对象</td>
            <td></td><!--{{rpdata.name}}-->
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{rpdata.identity}}</td>
          </tr>
          <tr>
            <td>性别</td>
            <td>{{rpdata.gender}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{rpdata.tel}}</td>
          </tr>
          <tr>
            <td>曾用名</td>
            <td>{{rpdata.onceName}}</td>
          </tr>
          <tr>
            <td>民族</td>
            <td>{{rpdata.nation}}</td>
          </tr>
          <tr>
            <td>身高</td>
            <td>{{rpdata.height}}</td>
          </tr>
          <tr>
            <td>血型</td>
            <td>{{rpdata.bloodType}}</td>
          </tr>
          <tr>
            <td>社区/居（村）委会代码</td>
            <td>{{rpdata.communityCode}}</td>
          </tr>
          <tr>
            <td>文化程度</td>
            <td>{{rpdata.calture}}</td>
          </tr>
          <tr>
            <td>移动电话</td>
            <td>{{rpdata.phone}}</td>
          </tr>
          <tr>
            <td>宗教信仰</td>
            <td>{{rpdata.region}}</td>
          </tr>
          <tr>
            <td>政治面貌</td>
            <td>{{rpdata.political}}</td>
          </tr>
          <tr>
            <td>婚姻状况</td>
            <td>{{rpdata.marriage}}</td>
          </tr>
          <tr>
            <td>从业状况_单位名称</td>
            <td>{{rpdata.unitName}}</td>
          </tr>
          <tr>
            <td>从业状况_职业</td>
            <td>{{rpdata.job}}</td>
          </tr>
          <tr>
            <td>户号</td>
            <td>{{rpdata.householdNo}}</td>
          </tr>
          <tr>
            <td>户口性质代码</td>
            <td>{{rpdata.householdNature}}</td>
          </tr>
          <tr>
            <td>户籍地址_区划内详细地址</td>
            <td>{{rpdata.householdAddress}}</td>
          </tr>
          <tr>
            <td>户籍地址_省市县（区）</td>
            <td>{{rpdata.householdPorvince}}</td>
          </tr>
          <tr>
            <td>籍贯_国家（地区）</td>
            <td>{{rpdata.nativePlaceCountry}}</td>
          </tr>
          <tr>
            <td>籍贯_省市县（区）</td>
            <td>{{rpdata.nativePlaceProvince}}</td>
          </tr>
          <tr>
            <td>来本市情况_来自地_国家（地区）</td>
            <td>{{rpdata.fromCountry}}</td>
          </tr>
          <tr>
            <td>来本市情况_来自地_区划内详细地址</td>
            <td>{{rpdata.fromProvince}}</td>
          </tr>
          <tr>
            <td>来本市情况_迁（流）入日期</td>
            <td>{{rpdata.inDate}}</td>
          </tr>
          <tr>
            <td>来本市情况_迁（流）入原因</td>
            <td>{{rpdata.inReason}}</td>
          </tr>
          <tr>
            <td>是否服兵役</td>
            <td>{{rpdata.serveArmy}}</td>
          </tr>
          <tr>
            <td>是否有海外关系</td>
            <td>{{rpdata.overseasRelation}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isHouseShow">
        <div class="leftimg">
          <el-image fit="cover" class="leftimg-img" :src="rhdata.housePhotos" :preview-src-list="[rhdata.housePhotos]">
            <div slot="error">
              <el-image :src="noImg" class="noImg-knife"></el-image>
            </div>
          </el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td>社区民警</td>
            <td>{{rhdata.communityPolice}}</td>
          </tr>
          <tr>
            <td>房屋类型</td>
            <td>{{rhdata.houseType}}</td>
          </tr>
          <tr>
            <td>房屋用途</td>
            <td>{{rhdata.houseUse}}</td>
          </tr>
          <tr>
            <td>房屋结构</td>
            <td>{{rhdata.buldingStructure}}</td>
          </tr>
          <tr>
            <td>房屋面积</td>
            <td>{{rhdata.houseArea}}</td>
          </tr>
          <tr>
            <td>室内屋数</td>
            <td>{{rhdata.houseCount}}</td>
          </tr>
          <tr>
            <td>房屋来源</td>
            <td>{{rhdata.houseSource}}</td>
          </tr>
          <tr>
            <td>产权证号</td>
            <td>{{rhdata.propertyNo}}</td>
          </tr>
          <tr>
            <td>产权类型</td>
            <td>{{rhdata.propertyType}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isLayoutShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td>建筑地址</td>
            <td>{{ layoutName }}</td>
          </tr>
        </table>
      </div>
      <div v-show="isCompanyShow">
        <div class="leftimg">
          <el-image class="leftimg-img" :src="rcdata.imageInfo" :preview-src-list="[rcdata.imageInfo]"></el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">单位名称</td>
            <td>{{rcdata.name}}</td>
          </tr>
          <tr>
            <td>组织机构</td>
            <td>{{rcdata.organization}}</td>
          </tr>
          <tr>
            <td>行业类别</td>
            <td>{{rcdata.industryType}}</td>
          </tr>
          <tr>
            <td>九小类型</td>
            <td>{{rcdata.nineSmallType}}</td>
          </tr>
          <tr>
            <td>注册资本</td>
            <td>{{rcdata.registMoney}}</td>
          </tr>
          <tr>
            <td>办公地址</td>
            <td>{{rcdata.address}}</td>
          </tr>
          <tr>
            <td>固定电话</td>
            <td>{{rcdata.tel}}</td>
          </tr>
          <tr>
            <td>移动电话</td>
            <td>{{rcdata.contact}}</td>
          </tr>
          <tr>
            <td>资产性质</td>
            <td>{{rcdata.economicNature}}</td>
          </tr>
          <tr>
            <td>负责人</td>
            <td>{{rcdata.leader}}</td>
          </tr>
          <tr>
            <td>法人代表</td>
            <td>{{rcdata.legalMan}}</td>
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{rcdata.identity}}</td>
          </tr>
          <tr>
            <td>经营方式</td>
            <td>{{rcdata.operateMode}}</td>
          </tr>
          <tr>
            <td>主营范围</td>
            <td>{{rcdata.mainBusiness}}</td>
          </tr>
          <tr>
            <td>兼营范围</td>
            <td>{{rcdata.secondBusiness}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isAddressShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">地名地址</td>
            <td>{{radata.addName}}</td>
          </tr>
          <tr>
            <td>类型</td>
            <td>{{radata.addType}}</td>
          </tr>
          <tr>
            <td>采集时间</td>
            <td>{{radata.addDate}}</td>
          </tr>
          <tr>
            <td>市县区</td>
            <td>{{radata.province}}</td>
          </tr>
          <tr>
            <td>街道办/镇</td>
            <td>{{radata.subdistrict}}</td>
          </tr>
          <tr>
            <td>社区</td>
            <td>{{radata.communities}}</td>
          </tr>
          <tr>
            <td>街道/路</td>
            <td>{{radata.street}}</td>
          </tr>
          <tr>
            <td>小区</td>
            <td>{{radata.communityName}}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  import {getLayoutByName} from "../../../api/api";
  import "../../../js/CesiumLayout.js";
  import map3d from "../../../components/map-3d";

  let popzIndex = 0;
  export default {
    name: "pop-netManage",
    data() {
      return {
        popId: "",
        levelNum: "",
        rpdata: {
          imgurl: "",
          name: "",
          peopleType: "",
          identity: "",
          gender: "",
          tel: "",
          onceName: "",
          nation: "",
          height: "",
          bloodType: "",
          communityCode: "",
          calture: "",
          phone: "",
          region: "",
          political: "",
          marriage: "",
          unitName: "",
          job: "",
          householdNo: "",
          householdNature: "",
          householdAddress: "",
          householdPorvince: "",
          nativePlaceCountry: "",
          nativePlaceProvince: "",
          fromCountry: "",
          fromProvince: "",
          inDate: "",
          inReason: "",
          serveArmy: "",
          overseasRelation: "",
        },
        rhdata: {
          panoramaUrl: "",
          communityPolice: "",
          houseType: "",
          houseUse: "",
          buldingStructure: "",
          houseArea: "",
          houseCount: "",
          houseSource: "",
          propertyNo: "",
          propertyType: "",
        },
        rcdata: {
          imageInfo: "",
          name: "",
          organization: "",
          industryType: "",
          nineSmallType: "",
          registMoney: "",
          address: "",
          tel: "",
          contact: "",
          economicNature: "",
          leader: "",
          legalMan: "",
          identity: "",
          operateMode: "",
          mainBusiness: "",
          secondBusiness: "",
        },
        radata: {
          addName: "",
          addType: "",
          province: "",
          subdistrict: "",
          communities: "",
          street: "",
          communityName: "",
          floorHeight: ""
        },
        curInfoType: "人口信息",
        isPeopleShow: true,
        isHouseShow: false,
        isCompanyShow: false,
        isAddressShow: false,
        isLayoutShow: false,
        noImg: require("@/assets/pop/noneImg.png"),
        layoutName: "",
      }
    },
    methods: {
      showPeople() {
        this.isPeopleShow = true;
        this.isHouseShow = false;
        this.isCompanyShow = false;
        this.isAddressShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '人口信息';
      },
      showHouse() {
        this.isPeopleShow = false;
        this.isHouseShow = true;
        this.isCompanyShow = false;
        this.isAddressShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '住房信息';
      },
      showCompany() {
        this.isPeopleShow = false;
        this.isHouseShow = false;
        this.isCompanyShow = true;
        this.isAddressShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '单位信息';
      },
      showAddress() {
        this.isPeopleShow = false;
        this.isHouseShow = false;
        this.isCompanyShow = false;
        this.isAddressShow = true;
        this.isLayoutShow = false;
        this.curInfoType = '地名地址信息';
      },
      showLayout() {
        this.isPeopleShow = false;
        this.isHouseShow = false;
        this.isCompanyShow = false;
        this.isAddressShow = false;
        this.isLayoutShow = true;
        this.curInfoType = "户型";
        let addName = "";
        if (this.radata.addName.lastIndexOf("栋") > 0) {
          addName = this.radata.addName.substring(0, this.radata.addName.lastIndexOf("栋") + 1);
        } else if (this.radata.addName.lastIndexOf("楼") > 0) {
          addName = this.radata.addName.substring(0, this.radata.addName.lastIndexOf("楼") + 1);
        } else {
          addName = this.radata.addName;
        }
        let params = {
          'layoutName': addName
        };
        getLayoutByName(params).then(res => {
          this.layoutName = res.data[0].layoutName;
          let height = Number(this.radata.floorHeight.split(',')[0]);

          //回显地板和外墙
          let options = {
            'viewer': viewer,
            'layoutPos': res.data[0].layoutPos,
            'height': height,
            'color': Cesium.Color.WHITE,
            'outColor': Cesium.Color.LIME
          };
          CesiumLayout.showWall(options);

          //回显室内墙体
          let walloptions = {
            'viewer': viewer,
            'layoutFloor': res.data[0].layoutFloor,
            'height': height,
            'color': Cesium.Color.WHITE,
            'outColor': Cesium.Color.LIME
          };
          CesiumLayout.showLayout(walloptions);

          //切除上层模型
          map3d.methods.cutLayout(height);
        });
      },
      pop_close() {
        let pop = this.$refs['nmPop-' + this.levelNum];
        if (pop) {
          document.querySelector('body').removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
        CesiumLayout.clearLayout(viewer);
        map3d.methods.clearClippingPlanes();
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

  .leftimg {
    float: left;
    margin-top: 6px;
  }

  .leftimg-img {
    width: 93px !important
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

  .infoPop-tabel {
    width: 260px;
    border: none;
    margin-top: 5px;
    float: right
  }

  .infoPop-tabel-w {
    width: 100%;
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
    min-width: 70px;
  }

  .pop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }
</style>
