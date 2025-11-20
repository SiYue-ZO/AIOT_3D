<template>
  <div style="color:#ffffff">
    <el-tabs v-model="activeName">
      <el-tab-pane label="住房" name="house">
        <div class="leftimg">
          <img width="93px" v-bind:src="rhdata.panoramaUrl"/>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">房屋地址</td>
            <td>未登记</td>
          </tr>
          <tr>
            <td>房产所有人</td>
            <td>{{rhdata.peopleBase.name}}</td>
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
      </el-tab-pane>
      <el-tab-pane label="租户" name="trustee">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">租户姓名</td>
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
      </el-tab-pane>
      <el-tab-pane label="房主" name="base">
        <div class="leftimg">
          <img width="93px" v-bind:src="rhdata.peopleBase.imgurl"/>
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
            <td>未登记</td>
          </tr>
        </table>
      </el-tab-pane>
      <el-tab-pane label="详情" name="detail">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">曾用名</td>
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
      </el-tab-pane>
      <el-tab-pane label="关系" name="relation">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">与户主关系</td>
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
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default {
    name: "real-house-info",
    data() {
      return {
        rhdata: window.realHouseData,
        activeName: "house"
      }
    },
    mounted() {
      if(this.rhdata.peopleBase === null){
        this.rhdata.peopleBase = {};
        this.rhdata.peopleBase.name = "未登记";
        this.rhdata.peopleBase.imgurl = "";
        this.rhdata.peopleBase.peopleType = "";
        this.rhdata.peopleBase.identity = "";
        this.rhdata.peopleBase.gender = "";
        this.rhdata.peopleBase.tel = "";
        this.rhdata.peopleBase.onceName = "";
        this.rhdata.peopleBase.nation = "";
        this.rhdata.peopleBase.height = "";
        this.rhdata.peopleBase.bloodType = "";
        this.rhdata.peopleBase.communityCode = "";
        this.rhdata.peopleBase.calture = "";
        this.rhdata.peopleBase.phone = "";
        this.rhdata.peopleBase.region = "";
        this.rhdata.peopleBase.political = "";
        this.rhdata.peopleBase.marriage = "";
        this.rhdata.peopleBase.unitName = "";
        this.rhdata.peopleBase.job = "";
        this.rhdata.peopleBase.householdNo = "";
        this.rhdata.peopleBase.householdNature = "";
        this.rhdata.peopleBase.householdAddress = "";
        this.rhdata.peopleBase.householdPorvince = "";
        this.rhdata.peopleBase.nativePlaceCountry = "";
        this.rhdata.peopleBase.nativePlaceProvince = "";
        this.rhdata.peopleBase.fromCountry = "";
        this.rhdata.peopleBase.fromProvince = "";
        this.rhdata.peopleBase.inDate = "";
        this.rhdata.peopleBase.inReason = "";
        this.rhdata.peopleBase.serveArmy = "";
        this.rhdata.peopleBase.overseasRelation = "";
        this.rhdata.peopleBase.householdRelation = "";
        this.rhdata.peopleBase.fatherIdentity = "";
        this.rhdata.peopleBase.fatherName = "";
        this.rhdata.peopleBase.motherIdentity = "";
        this.rhdata.peopleBase.motherName = "";
        this.rhdata.peopleBase.mateIdentity = "";
        this.rhdata.peopleBase.mateName = "";

      }
    }
  }
</script>

<style scoped>
  .leftimg {
    float: left;
    margin-top: 6px;
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
    min-width: 80px;
  }
</style>
