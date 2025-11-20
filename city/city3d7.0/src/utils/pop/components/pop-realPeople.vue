<template>
  <div v-bind:id="'popupDiv' + popId" class="infoPop" v-bind:ref="'rpPop-' + levelNum"
       v-on:click="clickStick('popupDiv' + popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{ curInfoType }}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'user-tie']" title="基本信息"
                           v-on:click.stop="showBase"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'address-book']" title="详细信息"
                           v-on:click.stop="showDetail"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fab', 'hubspot']" title="人际关系"
                           v-on:click.stop="showRelation"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'house-user']" title="住房"
                           v-on:click.stop="showHouse"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'calculator']" title="户型"
                           v-on:click.stop="showLayout"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'truck-pickup']" title="车辆"
                           v-on:click.stop="showCar"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'tools']" title="四机一具"
                           v-on:click.stop="showMachine"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'utensils']" title="刀具"
                           v-on:click.stop="showKnife"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div v-show="isBaseShow">
        <div v-for="(rp, index) in rpdata" :key="'rp1-' + index" class="split-div">
          <div class="leftimg">
            <el-image fit="cover" class="noImg" :src="rp.imgurl" :preview-src-list="[rp.imgurl]">
              <div slot="error">
                <el-image :src="noImg" class="noImg"></el-image>
              </div>
            </el-image>
          </div>
          <table class="infoPop-tabel" cellspacing="0">
            <tr>
              <td class="td-label">姓名</td>
              <td>{{ rp.name }}</td>
            </tr>
            <tr>
              <td>人口类别</td>
              <td>{{ rp.peopleType }}</td>
            </tr>
            <tr>
              <td>工作对象</td>
              <td></td>
              <!--{{rp.name}}-->
            </tr>
            <tr>
              <td>身份证号</td>
              <td>{{ rp.identity }}</td>
            </tr>
            <tr>
              <td>性别</td>
              <td>{{ rp.gender }}</td>
            </tr>
            <tr>
              <td>联系电话</td>
              <td>{{ rp.tel }}</td>
            </tr>
            <tr>
              <td>入户住址</td>
              <td>{{ rp.address.addName }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div v-show="isDetailShow">
        <div v-for="(rp, index) in rpdata" :key="'rp2-' + index" class="split-div">
          <table class="infoPop-tabel-w" cellspacing="0">
            <tr>
              <td>曾用名</td>
              <td>{{ rp.onceName }}</td>
            </tr>
            <tr>
              <td>民族</td>
              <td>{{ rp.nation }}</td>
            </tr>
            <tr>
              <td>身高</td>
              <td>{{ rp.height }}</td>
            </tr>
            <tr>
              <td>血型</td>
              <td>{{ rp.bloodType }}</td>
            </tr>
            <tr>
              <td>社区/居（村）委会代码</td>
              <td>{{ rp.communityCode }}</td>
            </tr>
            <tr>
              <td>文化程度</td>
              <td>{{ rp.calture }}</td>
            </tr>
            <tr>
              <td>移动电话</td>
              <td>{{ rp.phone }}</td>
            </tr>
            <tr>
              <td>宗教信仰</td>
              <td>{{ rp.region }}</td>
            </tr>
            <tr>
              <td>政治面貌</td>
              <td>{{ rp.political }}</td>
            </tr>
            <tr>
              <td>婚姻状况</td>
              <td>{{ rp.marriage }}</td>
            </tr>
            <tr>
              <td>从业状况_单位名称</td>
              <td>{{ rp.unitName }}</td>
            </tr>
            <tr>
              <td>从业状况_职业</td>
              <td>{{ rp.job }}</td>
            </tr>
            <tr>
              <td>户号</td>
              <td>{{ rp.householdNo }}</td>
            </tr>
            <tr>
              <td>户口性质代码</td>
              <td>{{ rp.householdNature }}</td>
            </tr>
            <tr>
              <td>户籍地址_区划内详细地址</td>
              <td>{{ rp.householdAddress }}</td>
            </tr>
            <tr>
              <td>户籍地址_省市县（区）</td>
              <td>{{ rp.householdPorvince }}</td>
            </tr>
            <tr>
              <td>籍贯_国家（地区）</td>
              <td>{{ rp.nativePlaceCountry }}</td>
            </tr>
            <tr>
              <td>籍贯_省市县（区）</td>
              <td>{{ rp.nativePlaceProvince }}</td>
            </tr>
            <tr>
              <td>来本市情况_来自地_国家（地区）</td>
              <td>{{ rp.fromCountry }}</td>
            </tr>
            <tr>
              <td>来本市情况_来自地_区划内详细地址</td>
              <td>{{ rp.fromProvince }}</td>
            </tr>
            <tr>
              <td>来本市情况_迁（流）入日期</td>
              <td>{{ rp.inDate }}</td>
            </tr>
            <tr>
              <td>来本市情况_迁（流）入原因</td>
              <td>{{ rp.inReason }}</td>
            </tr>
            <tr>
              <td>是否服兵役</td>
              <td>{{ rp.serveArmy }}</td>
            </tr>
            <tr>
              <td>是否有海外关系</td>
              <td>{{ rp.overseasRelation }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div v-show="isRelationShow">
        <div v-for="(rp, index) in rpdata" :key="'rp3-' + index" class="split-div">
          <div v-bind:id="popId+'relation-chart'+index" class="infoPop-tabel-echarts"></div>
          <table class="infoPop-tabel-w" cellspacing="0">
            <tr>
              <td>与户主关系</td>
              <td>{{ rp.householdRelation }}</td>
            </tr>
            <tr>
              <td>父亲_公民身份证号码</td>
              <td><a class="idhref" href="#" @click="queryRelation(rprdata.fatherIdentity)">{{
                  rp.fatherIdentity
                }}</a></td>
            </tr>
            <tr>
              <td>父亲_姓名</td>
              <td>{{ rp.fatherName }}</td>
            </tr>
            <tr>
              <td>母亲_公民身份证号码</td>
              <td><a class="idhref" href="#" @click="queryRelation(rprdata.motherIdentity)">{{
                  rp.motherIdentity
                }}</a></td>
            </tr>
            <tr>
              <td>母亲_姓名</td>
              <td>{{ rp.motherName }}</td>
            </tr>
            <tr>
              <td>配偶_公民身份证号码</td>
              <td><a class="idhref" href="#" @click="queryRelation(rprdata.mateIdentity)">{{
                  rp.mateIdentity
                }}</a></td>
            </tr>
            <tr>
              <td>配偶_姓名</td>
              <td>{{ rp.mateName }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div v-show="isHouseShow">
        <div class="leftimg">
          <el-image fit="cover" class="noImg-knife" :src="rpdata[0].address.house.housePhotos"
                    :preview-src-list="[rpdata[0].address.house.housePhotos]">
            <div slot="error">
              <el-image :src="noImg" class="noImg-knife"></el-image>
            </div>
          </el-image>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">房屋地址</td>
            <td class="td-text-w">{{ rpdata[0].address.addName }}</td>
          </tr>
          <tr>
            <td>房产证编号</td>
            <td class="td-text-w">{{ rpdata[0].address.house.propertyNo }}</td>
          </tr>
          <tr>
            <td>房产所有人</td>
            <td class="td-text-w">{{ rpdata[0].address.house.owner }}</td>
          </tr>
          <tr>
            <td>房屋面积</td>
            <td class="td-text-w">{{ rpdata[0].address.house.houseArea }}</td>
          </tr>
          <tr>
            <td>房屋结构</td>
            <td class="td-text-w">
              {{ rpdata[0].address.house.buldingStructure }}
            </td>
          </tr>
          <tr>
            <td>全景图</td>
            <td>
              <a href="#" style="color: white"
                 v-on:click=" openPhotoSphereViewer(rpdata[0].address.house.housePanoramas)">打开全景图</a>
            </td>
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
      <div v-show="isCarShow">
        <div v-for="(rp, index1) in rpdata" :key="'rp4-' + index1" class="split-div">
          <div v-for="(item, index) in rp.peopleVehicles" :key="'ve-' + index" class="vehicle-line">
            <div class="leftimg demo-image__preview">
              <el-image style="width: 93px; height: 115px" :src="item.carImgUrl"
                        :preview-src-list="[item.carImgUrl]"></el-image>
            </div>
            <table class="infoPop-tabel" cellspacing="0">
              <tr>
                <td class="td-label">车辆品牌</td>
                <td class="td-text">{{ item.carBrand }}</td>
              </tr>
              <tr>
                <td>车牌号</td>
                <td class="td-text">{{ item.carNo }}</td>
              </tr>
              <tr>
                <td>车辆类型</td>
                <td class="td-text">{{ item.carType }}</td>
              </tr>
              <tr>
                <td>车辆识别代码</td>
                <td class="td-text">{{ item.carCode }}</td>
              </tr>
              <tr>
                <td>发动机号</td>
                <td class="td-text">{{ item.engineNo }}</td>
              </tr>
              <tr>
                <td>颜色</td>
                <td class="td-text">{{ item.color }}</td>
              </tr>
              <tr>
                <td>注册日期</td>
                <td class="td-text">{{ item.registerData }}</td>
              </tr>
              <tr>
                <td>备注</td>
                <td class="td-text">{{ item.carRemark }}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div v-show="isMachineShow">
        <div v-for="(rp, index1) in rpdata" :key="'rp5-' + index1" class="split-div">
          <div v-for="(item, index) in rp.peopleMachines" :key="'ma-' + index" class="machine-line">
            <div class="leftimg">
              <el-image fit="cover" class="noImg-machine" :src="item.machineImgUrl" :preview-src-list="[item.machineImgUrl]">
                <div slot="error">
                  <el-image :src="noImg" class="noImg-machine"></el-image>
                </div>
              </el-image>
            </div>
            <table class="infoPop-tabel" cellspacing="0">
              <tr>
                <td class="td-label">类型</td>
                <td class="td-text">{{ item.machineType }}</td>
              </tr>
              <tr>
                <td>二维码</td>
                <td class="td-text">{{ item.qrCode }}</td>
              </tr>
              <tr>
                <td>备注</td>
                <td class="td-text">{{ item.machineRemark }}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div v-show="isKnifeShow">
        <div v-for="(rp, index1) in rpdata" :key="'rp6-' + index1" class="split-div">
          <div v-for="(item, index) in rp.peopleKnifes" :key="'kn-' + index" class="knife-line">
            <div class="leftimg">
              <el-image fit="cover" class="noImg-knife" :src="item.knifeImgUrl" :preview-src-list="[item.knifeImgUrl]">
                <div slot="error">
                  <el-image :src="noImg" class="noImg-knife"></el-image>
                </div>
              </el-image>
            </div>
            <table class="infoPop-tabel" cellspacing="0">
              <tr>
                <td class="td-label">类型</td>
                <td class="td-text">{{ item.knifeType }}</td>
              </tr>
              <tr>
                <td>长度</td>
                <td class="td-text">{{ item.knifeLenth }}</td>
              </tr>
              <tr>
                <td>二维码</td>
                <td class="td-text">{{ item.qrCode }}</td>
              </tr>
              <tr>
                <td>固定情况</td>
                <td class="td-text">{{ item.fixedSituation }}</td>
              </tr>
              <tr>
                <td>备注</td>
                <td class="td-text">{{ item.knifeRemark }}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {eventBus} from "../../../main";
import {queryPeoplebase, getLayoutByName} from "../../../api/api";
import realPeople from "../../../components/real-people";
import "../../../js/CesiumLayout.js";
import map3d from "../../../components/map-3d";

let popzIndex = 0;

export default {
  name: "pop-realPeople",
  data() {
    return {
      popId: "",
      rpdata: [],
      levelNum: "",
      curInfoType: "基本信息",
      isBaseShow: true,
      isDetailShow: false,
      isRelationShow: false,
      isMachineShow: false,
      isKnifeShow: false,
      isHouseShow: false,
      isLayoutShow: false,
      isCarShow: false,
      tomcatUrl: "",
      noImg: require("@/assets/pop/noneImg.png"),
      layoutName: "",
    };
  },
  methods: {
    showBase() {
      this.isBaseShow = true;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "基本信息";
    },
    showDetail() {
      this.isBaseShow = false;
      this.isDetailShow = true;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "详细信息";
    },
    showRelation() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = true;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "人际关系";
    },
    showMachine() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = true;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "四机一具";
    },
    showKnife() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = true;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "刀具";
    },
    showHouse() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = true;
      this.isLayoutShow = false;
      this.isCarShow = false;
      this.curInfoType = "住房";
    },
    showLayout() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = true;
      this.isCarShow = false;
      this.curInfoType = "户型";
      let addName = "";
      if (this.rpdata[0].address.addName.lastIndexOf("栋") > 0) {
        addName = this.rpdata[0].address.addName.substring(0, this.rpdata[0].address.addName.lastIndexOf("栋") + 1);
      } else if (this.rpdata[0].address.addName.lastIndexOf("楼") > 0) {
        addName = this.rpdata[0].address.addName.substring(0, this.rpdata[0].address.addName.lastIndexOf("楼") + 1);
      } else {
        addName = this.rpdata[0].address.addName;
      }
      let params = {
        'layoutName': addName
      };
      getLayoutByName(params).then(res => {
        this.layoutName = res.data[0].layoutName;
        let height = Number(this.rpdata[0].address.floorHeight.split(',')[0]);

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
    showCar() {
      this.isBaseShow = false;
      this.isDetailShow = false;
      this.isRelationShow = false;
      this.isMachineShow = false;
      this.isKnifeShow = false;
      this.isHouseShow = false;
      this.isLayoutShow = false;
      this.isCarShow = true;
      this.curInfoType = "车辆";
    },
    pop_close() {
      let pop = this.$refs["rpPop-" + this.levelNum];
      if (pop) {
        document.querySelector("body").removeChild(pop);
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
    },
    showChart() {
      this.rpdata.map((item, index) => {
        let relationChart = this.$echarts.init(document.getElementById(this.popId + "relation-chart" + index), 'light');
        let dutyInfoData = {dutyData: [], dutyInfocategories: [], dutyInfolinks: []};
        dutyInfoData.dutyData.push({
          name: item.name,
          symbolSize: 12,
          category: "本人",
          draggable: true,
          value: item.identity
        }, {
          name: "父亲" + item.fatherName,
          symbolSize: 12,
          category: "父亲",
          draggable: true,
          value: item.fatherIdentity
        }, {
          name: "母亲" + item.motherName,
          symbolSize: 12,
          category: "母亲",
          draggable: true,
          value: item.motherIdentity
        }, {
          name: "配偶" + item.mateName,
          symbolSize: 12,
          category: "配偶",
          draggable: true,
          value: item.mateIdentity
        });
        dutyInfoData.dutyInfocategories.push({
          name: "本人",
          itemStyle: {
            normal: {
              color: "#6aff2e",
              shadowColor: '#eeeeee',
              shadowBlur: 30
            }
          }
        }, {
          name: "父亲",
          itemStyle: {
            normal: {
              color: "#1a77ff",
              shadowColor: '#eeeeee',
              shadowBlur: 30
            }
          }
        }, {
          name: "母亲",
          itemStyle: {
            normal: {
              color: "#ff6ce6",
              shadowColor: '#eeeeee',
              shadowBlur: 30
            }
          }
        }, {
          name: "配偶",
          itemStyle: {
            normal: {
              color: "#ff9b0c",
              shadowColor: '#eeeeee',
              shadowBlur: 30
            }
          }
        });
        dutyInfoData.dutyInfolinks.push({
          source: item.name,
          target: "父亲" + item.fatherName,
        }, {
          source: item.name,
          target: "母亲" + item.motherName,
        }, {
          source: item.name,
          target: "配偶" + item.mateName,
        });
        let option = {
          tooltip: {},
          backgroundColor: 'rgba(255, 255, 255, 0)',
          legend: [{
            padding: 3,
            itemWidth: 10,
            itemHeight: 10,
            itemGap: 5,
            textStyle: {
              fontSize: 14,
              color: '#ffffff'
            },
            orient: 'vertical',
            left: '10px',
            top: '20px'
          }],
          animationEasingUpdate: 'quinticInOut',
          series: [{
            name: '人际关系',
            type: 'graph',
            layout: 'force',
            force: {
              repulsion: [160, 80],
              gravity: 0.1,
              edgeLength: [35, 25],
              layoutAnimation: true,
              initLayout: 'circular'
            },
            roam: false,
            symbolSize: 20,
            top: 0,
            left: 40,
            label: {
              normal: {
                show: true,
                position: 'bottom',
                formatter: '{b}',
                fontSize: 14,
                fontStyle: '600',
              }
            },
            lineStyle: {
              normal: {
                width: 3,
                color: 'target',
                curveness: 0.4,
                type: "solid"
              }
            },
            emphasis: {
              lineStyle: {
                width: 5
              }
            },
            data: dutyInfoData.dutyData,
            links: dutyInfoData.dutyInfolinks,
            categories: dutyInfoData.dutyInfocategories,
          }]
        };
        relationChart.setOption(option);
      });
    },
    queryRelation(id) {
      let params = {
        name: "",
        onceName: "",
        gender: "",
        height: "",
        isFlow: "",
        isLost: "",
        bloodType: "",
        identity: id,
        nation: "",
        isDrug: "",
        peopleType: "",
        calture: "",
        tel: "",
        region: "",
        political: "",
        marriage: "",
        unitName: "",
        job: "",
        householdNature: "",
        householdAddress: "",
        fatherName: "",
        fatherIdentity: "",
        motherName: "",
        motherIdentity: "",
        mateName: "",
        mateIdentity: "",
        serveArmy: "",
      };
      queryPeoplebase(params).then((res) => {
        if (res.data.length !== 0) {
          realPeople.methods.showqueryPeoplebase(res.data);
          this.pop_close();
        } else {
          this.$message.error('未获取符合条件人口信息!');
        }
      });
    },
  },
  mounted() {
    this.tomcatUrl = common.serverIp.substring(0, common.serverIp.length);
    this.$nextTick(function () {
      this.showChart();
    });
  },
};
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
  float: right;
}

.infoPop-tools-fai {
  cursor: pointer;
  margin: 0 4px 0 6px;
}

.leftimg {
  float: left;
  margin-right: 5px;
  padding: 3px 2px;
  border: solid 1px #0f65e8;
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

.infoPop-content::-webkit-scrollbar-thumb {
  /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.infoPop-content::-webkit-scrollbar-track {
  /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.infoPop-tabel {
  border: none;
  margin-top: 5px;
  width: 250px;
}

.infoPop-tabel-w {
  width: 100%;
  border: none;
  margin-top: 5px;
}

.infoPop-tabel td,
.infoPop-tabel-w td {
  padding: 2px 5px;
}

.infoPop-tabel tr:nth-child(odd),
.infoPop-tabel-w tr:nth-child(odd) {
  background: #004c5abb;
}

.infoPop-tabel tr:nth-child(even),
.infoPop-tabel-w tr:nth-child(even) {
  background: #091d46bb;
}

.td-label {
  min-width: 70px;
}

.pop-tools-fai {
  cursor: pointer;
  margin: 0 4px 0 6px;
}

.td-text {
  width: 165px;
  word-wrap: break-word;
  word-break: break-all;
}

.td-text-w {
  width: 265px;
  word-wrap: break-word;
  word-break: break-all;
}

.machine-line {
  height: 77px;
}

.knife-line {
  height: 125px;
}

.vehicle-line {
  min-height: 203px;
}

.noImg {
  width: 93px;
}

.noImg-machine {
  width: 93px;
  max-height: 70px;
}

.noImg-knife {
  width: 93px;
  max-height: 110px;
}

.infoPop-tabel-echarts {
  width: 370px;
  height: 125px;
}

.idhref {
  color: #ffffff !important;
}

.split-div {
  padding-bottom: 10px;
  margin-bottom: 10px;
  border-bottom: dashed 1px #0f65e8;
}
</style>
