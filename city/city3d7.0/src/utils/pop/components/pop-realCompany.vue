<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'rcPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">{{curInfoType}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'university']" title="单位信息"
                           v-on:click.stop="showCompany"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'fire-extinguisher']" title="防火措施"
                           v-on:click.stop="showFire"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fas', 'shield-alt']" title="安保监管"
                           v-on:click.stop="showSave"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['far', 'building']" title="建筑信息"
                           v-on:click.stop="showConstruction"></font-awesome-icon>
        <font-awesome-icon class="pop-tools-fai" :icon="['fab', 'leanpub']" title="执业监管"
                           v-on:click.stop="showLicense"></font-awesome-icon>
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="关闭"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
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
      <div v-show="isFireShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">防火级别</td>
            <td>{{rcdata.fireLevel}}</td>
          </tr>
          <tr>
            <td>防火负责人</td>
            <td>{{rcdata.fireManager}}</td>
          </tr>
          <tr>
            <td>防火管理部门</td>
            <td>{{rcdata.fireMange}}</td>
          </tr>
          <tr>
            <td>防火报警器</td>
            <td>{{rcdata.autoFire}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isSaveShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">安保级别</td>
            <td>{{rcdata.saveLevel}}</td>
          </tr>
          <tr>
            <td>安保人员</td>
            <td>{{rcdata.saveManName}}</td>
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{rcdata.saveManIdentity}}</td>
          </tr>
          <tr>
            <td>联系电话</td>
            <td>{{rcdata.saveManTel}}</td>
          </tr>
          <tr>
            <td>安保类型</td>
            <td>{{rcdata.saveType}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isConstructionShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">经营面积</td>
            <td>{{rcdata.businessScope}}</td>
          </tr>
          <tr>
            <td>建筑楼层</td>
            <td>{{rcdata.buildingHeight}}</td>
          </tr>
          <tr>
            <td>建筑高度</td>
            <td>{{rcdata.buildingStorey}}</td>
          </tr>
          <tr>
            <td>建筑面积</td>
            <td>{{rcdata.constructionArea}}</td>
          </tr>
          <tr>
            <td>占地面积</td>
            <td>{{rcdata.coverArea}}</td>
          </tr>
          <tr>
            <td>周边环境</td>
            <td>{{rcdata.geometryInfo}}</td>
          </tr>
          <tr>
            <td>建筑管理部门</td>
            <td>{{rcdata.constructionManagerCompany}}</td>
          </tr>
        </table>
      </div>
      <div v-show="isLicenseShow">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">执照编号</td>
            <td>{{rcdata.licenseNo}}</td>
          </tr>
          <tr>
            <td>注册地址</td>
            <td>{{rcdata.registAddress}}</td>
          </tr>
          <tr>
            <td>注册资金</td>
            <td>{{rcdata.registMoney}}</td>
          </tr>
          <tr>
            <td>注册时间</td>
            <td>{{rcdata.registDate}}</td>
          </tr>
          <tr>
            <td>主管部门</td>
            <td>{{rcdata.mainManageDepartment}}</td>
          </tr>
          <tr>
            <td>分管部门</td>
            <td>{{rcdata.manageDepartment}}</td>
          </tr>
          <tr>
            <td>上级单位</td>
            <td>{{rcdata.upperCompany}}</td>
          </tr>
          <tr>
            <td>管理类型</td>
            <td>{{rcdata.manageType}}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  let popzIndex = 0;
  export default {
    name: "pop-realCompany",
    data() {
      return {
        popId: "",
        rcdata: {},
        levelNum: "",
        curInfoType: "单位信息",
        isCompanyShow: true,
        isFireShow: false,
        isSaveShow: false,
        isConstructionShow: false,
        isLicenseShow: false,
      }
    },
    methods: {
      showCompany() {
        this.isCompanyShow = true;
        this.isFireShow = false;
        this.isSaveShow = false;
        this.isConstructionShow = false;
        this.isLicenseShow = false;
        this.curInfoType = '单位信息';
      },
      showFire() {
        this.isCompanyShow = false;
        this.isFireShow = true;
        this.isSaveShow = false;
        this.isConstructionShow = false;
        this.isLicenseShow = false;
        this.curInfoType = '防火措施';
      },
      showSave() {
        this.isCompanyShow = false;
        this.isFireShow = false;
        this.isSaveShow = true;
        this.isConstructionShow = false;
        this.isLicenseShow = false;
        this.curInfoType = '安保措施';
      },
      showConstruction() {
        this.isCompanyShow = false;
        this.isFireShow = false;
        this.isSaveShow = false;
        this.isConstructionShow = true;
        this.isLicenseShow = false;
        this.curInfoType = '建筑信息';
      },
      showLicense() {
        this.isCompanyShow = false;
        this.isFireShow = false;
        this.isSaveShow = false;
        this.isConstructionShow = false;
        this.isLicenseShow = true;
        this.curInfoType = '执业监管';
      },
      pop_close() {
        let pop = this.$refs['rcPop-' + this.levelNum];
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
