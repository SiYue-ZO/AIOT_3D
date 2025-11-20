<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'rhPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{curInfoType}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'house-user']" title="住房信息"
                           v-on:click.stop="showHouse"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'calculator']" title="户型"
                           v-on:click.stop="showLayout"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-clock']" title="租户信息"
                           v-on:click.stop="showTrustee"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-tie']" title="房主信息"
                           v-on:click.stop="showBase"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'address-book']" title="房主详细信息"
                           v-on:click.stop="showDetail"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fab', 'hubspot']" title="房主人际关系"
                           v-on:click.stop="showRelation"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
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
            <td class="td-label">房屋地址</td>
            <td>{{rhdata.address.addName}}</td>
          </tr>
          <tr>
            <td>房产所有人</td>
            <td>{{rhdata.peopleBase.name}}</td>
          </tr>
          <tr>
            <td>全景图</td>
            <td>
              <a
                href="#"
                style="color: white"
                v-on:click=" openPhotoSphereViewer(rhdata.housePanoramas)"
              >打开全景图</a>
            </td>
          </tr>
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
      <div v-show="isTrusteeShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td>租户姓名</td>
            <td>{{rhdata.trusteeName}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{rhdata.trusteeTel}}</td>
          </tr>
          <tr>
            <td>民族</td>
            <td>{{rhdata.trusteeNation}}</td>
          </tr>
          <tr>
            <td>户籍地</td>
            <td>{{rhdata.trusteeHouseholdAddress}}</td>
          </tr>
          <tr>
            <td>与房主关系</td>
            <td>{{rhdata.trusteeRelation}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isBaseShow">
        <div class="leftimg">
          <el-image class="leftimg-img" :src="rhdata.peopleBase.imgurl"
                    :preview-src-list="[rhdata.peopleBase.imgurl]"></el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">姓名</td>
            <td>{{rhdata.peopleBase.name}}</td>
          </tr>
          <tr>
            <td>人口类别</td>
            <td>{{rhdata.peopleBase.peopleType}}</td>
          </tr>
          <tr>
            <td>工作对象</td>
            <td></td><!--{{rhdata.name}}-->
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{rhdata.peopleBase.identity}}</td>
          </tr>
          <tr>
            <td>性别</td>
            <td>{{rhdata.peopleBase.gender}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{rhdata.peopleBase.tel}}</td>
          </tr>
          <tr>
            <td>入户住址</td>
            <td>{{rhdata.address.addName}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isDetailShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td>曾用名</td>
            <td>{{rhdata.peopleBase.onceName}}</td>
          </tr>
          <tr>
            <td>民族</td>
            <td>{{rhdata.peopleBase.nation}}</td>
          </tr>
          <tr>
            <td>身高</td>
            <td>{{rhdata.peopleBase.height}}</td>
          </tr>
          <tr>
            <td>血型</td>
            <td>{{rhdata.peopleBase.bloodType}}</td>
          </tr>
          <tr>
            <td>社区/居（村）委会代码</td>
            <td>{{rhdata.peopleBase.communityCode}}</td>
          </tr>
          <tr>
            <td>文化程度</td>
            <td>{{rhdata.peopleBase.calture}}</td>
          </tr>
          <tr>
            <td>移动电话</td>
            <td>{{rhdata.peopleBase.phone}}</td>
          </tr>
          <tr>
            <td>宗教信仰</td>
            <td>{{rhdata.peopleBase.region}}</td>
          </tr>
          <tr>
            <td>政治面貌</td>
            <td>{{rhdata.peopleBase.political}}</td>
          </tr>
          <tr>
            <td>婚姻状况</td>
            <td>{{rhdata.peopleBase.marriage}}</td>
          </tr>
          <tr>
            <td>从业状况_单位名称</td>
            <td>{{rhdata.peopleBase.unitName}}</td>
          </tr>
          <tr>
            <td>从业状况_职业</td>
            <td>{{rhdata.peopleBase.job}}</td>
          </tr>
          <tr>
            <td>户号</td>
            <td>{{rhdata.peopleBase.householdNo}}</td>
          </tr>
          <tr>
            <td>户口性质代码</td>
            <td>{{rhdata.peopleBase.householdNature}}</td>
          </tr>
          <tr>
            <td>户籍地址_区划内详细地址</td>
            <td>{{rhdata.peopleBase.householdAddress}}</td>
          </tr>
          <tr>
            <td>户籍地址_省市县（区）</td>
            <td>{{rhdata.peopleBase.householdPorvince}}</td>
          </tr>
          <tr>
            <td>籍贯_国家（地区）</td>
            <td>{{rhdata.peopleBase.nativePlaceCountry}}</td>
          </tr>
          <tr>
            <td>籍贯_省市县（区）</td>
            <td>{{rhdata.peopleBase.nativePlaceProvince}}</td>
          </tr>
          <tr>
            <td>来本市情况_来自地_国家（地区）</td>
            <td>{{rhdata.peopleBase.fromCountry}}</td>
          </tr>
          <tr>
            <td>来本市情况_来自地_区划内详细地址</td>
            <td>{{rhdata.peopleBase.fromProvince}}</td>
          </tr>
          <tr>
            <td>来本市情况_迁（流）入日期</td>
            <td>{{rhdata.peopleBase.inDate}}</td>
          </tr>
          <tr>
            <td>来本市情况_迁（流）入原因</td>
            <td>{{rhdata.peopleBase.inReason}}</td>
          </tr>
          <tr>
            <td>是否服兵役</td>
            <td>{{rhdata.peopleBase.serveArmy}}</td>
          </tr>
          <tr>
            <td>是否有海外关系</td>
            <td>{{rhdata.peopleBase.overseasRelation}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isRelationShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td>与户主关系</td>
            <td>{{rhdata.peopleBase.householdRelation}}</td>
          </tr>
          <tr>
            <td>父亲_公民身份证号码</td>
            <td>{{rhdata.peopleBase.fatherIdentity}}</td>
          </tr>
          <tr>
            <td>父亲_姓名</td>
            <td>{{rhdata.peopleBase.fatherName}}</td>
          </tr>
          <tr>
            <td>母亲_公民身份证号码</td>
            <td>{{rhdata.peopleBase.motherIdentity}}</td>
          </tr>
          <tr>
            <td>母亲_姓名</td>
            <td>{{rhdata.peopleBase.motherName}}</td>
          </tr>
          <tr>
            <td>配偶_公民身份证号码</td>
            <td>{{rhdata.peopleBase.mateIdentity}}</td>
          </tr>
          <tr>
            <td>配偶_姓名</td>
            <td>{{rhdata.peopleBase.mateName}}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  import {eventBus} from "../../../main";
  import {getLayoutByName} from "../../../api/api";
  import "../../../js/CesiumLayout.js";
  import map3d from "../../../components/map-3d";

  let popzIndex = 0;
  export default {
    name: "pop-realHouse",
    data() {
      return {
        popId: "",
        rhdata: {},
        levelNum: "",
        curInfoType: "住房信息",
        isHouseShow: true,
        isTrusteeShow: false,
        isBaseShow: false,
        isDetailShow: false,
        isRelationShow: false,
        isLayoutShow: false,
        noImg: require("@/assets/pop/noneImg.png"),
        layoutName: "",
      }
    },
    methods: {
      showHouse() {
        this.isHouseShow = true;
        this.isTrusteeShow = false;
        this.isBaseShow = false;
        this.isDetailShow = false;
        this.isRelationShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '住房信息';
      },
      showTrustee() {
        this.isHouseShow = false;
        this.isTrusteeShow = true;
        this.isBaseShow = false;
        this.isDetailShow = false;
        this.isRelationShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '租户信息';
      },
      showBase() {
        this.isHouseShow = false;
        this.isTrusteeShow = false;
        this.isBaseShow = true;
        this.isDetailShow = false;
        this.isRelationShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '房主信息';
      },
      showDetail() {
        this.isHouseShow = false;
        this.isTrusteeShow = false;
        this.isBaseShow = false;
        this.isDetailShow = true;
        this.isRelationShow = false;
        this.isLayoutShow = false;
        this.curInfoType = '房主详细信息';
      },
      showRelation() {
        this.isHouseShow = false;
        this.isTrusteeShow = false;
        this.isBaseShow = false;
        this.isDetailShow = false;
        this.isRelationShow = true;
        this.isLayoutShow = false;
        this.curInfoType = '房主人际关系';
      },
      showLayout() {
        this.isHouseShow = false;
        this.isTrusteeShow = false;
        this.isBaseShow = false;
        this.isDetailShow = false;
        this.isRelationShow = false;
        this.isLayoutShow = true;
        this.curInfoType = "户型";
        let addName = "";
        if (this.rhdata.address.addName.lastIndexOf("栋") > 0) {
          addName = this.rhdata.address.addName.substring(0, this.rhdata.address.addName.lastIndexOf("栋") + 1);
        } else if (this.rhdata.address.addName.lastIndexOf("楼") > 0) {
          addName = this.rhdata.address.addName.substring(0, this.rhdata.address.addName.lastIndexOf("楼") + 1);
        } else {
          addName = this.rhdata.address.addName;
        }
        let params = {
          'layoutName': addName
        };
        getLayoutByName(params).then(res => {
          this.layoutName = res.data[0].layoutName;
          let height = Number(this.rhdata.address.floorHeight.split(',')[0]);

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
        let pop = this.$refs['rhPop-' + this.levelNum];
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
      },
      openPhotoSphereViewer(data) {
        eventBus.$emit("sel_panorama", data);
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
