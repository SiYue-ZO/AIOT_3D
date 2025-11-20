<template>
  <div style="color:#ffffff">
    <el-tabs v-model="activeName">
      <el-tab-pane label="基本信息" name="base">
        <div class="leftimg">
          <img width="93px" v-bind:src="rpdata.imgurl"/>
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
            <td>入户住址</td>
            <td>未登记</td>
          </tr>
        </table>
      </el-tab-pane>
      <el-tab-pane label="详细信息" name="detail">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">曾用名</td>
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
      </el-tab-pane>
      <el-tab-pane label="人际关系" name="relation">
        <table class="infoPop-tabel-w" cellspacing="0">
          <tr>
            <td class="td-label">与户主关系</td>
            <td>{{rpdata.householdRelation}}</td>
          </tr>
          <tr>
            <td>父亲_公民身份证号码</td>
            <td>{{rpdata.fatherIdentity}}</td>
          </tr>
          <tr>
            <td>父亲_姓名</td>
            <td>{{rpdata.fatherName}}</td>
          </tr>
          <tr>
            <td>母亲_公民身份证号码</td>
            <td>{{rpdata.motherIdentity}}</td>
          </tr>
          <tr>
            <td>母亲_姓名</td>
            <td>{{rpdata.motherName}}</td>
          </tr>
          <tr>
            <td>配偶_公民身份证号码</td>
            <td>{{rpdata.mateIdentity}}</td>
          </tr>
          <tr>
            <td>配偶_姓名</td>
            <td>{{rpdata.mateName}}</td>
          </tr>
        </table>
      </el-tab-pane>
      <el-tab-pane label="四机一具" name="machine">
        <div v-for="(item, index) in rpdata.peopleMachines" :key="index">
          <div class="leftimg">
            <img width="93px" v-bind:src="item.imgUrl"/>
          </div>
          <table class="infoPop-tabel" cellspacing="0" >
            <tr>
              <td class="td-label">类型</td>
              <td>{{item.machineType}}</td>
            </tr>
            <tr>
              <td>二维码</td>
              <td></td>
            </tr>
            <tr>
              <td>备注</td>
              <td></td>
            </tr>
          </table>
        </div>
      </el-tab-pane>
      <el-tab-pane label="刀具" name="knife">
        <div class="leftimg">
          <img width="93px" v-bind:src="rpdata.peopleKnife.imgUrl"/>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">类型</td>
            <td>{{rpdata.peopleKnife.knifeType}}</td>
          </tr>
          <tr>
            <td>长度</td>
            <td>{{rpdata.peopleKnife.knifeLenth}}</td>
          </tr>
          <tr>
            <td>二维码</td>
            <td>{{rpdata.peopleKnife.qrCode}}</td>
          </tr>
          <tr>
            <td>固定情况</td>
            <td>{{rpdata.peopleKnife.fixedSituation}}</td>
          </tr>
          <tr>
            <td>备注</td>
            <td>{{rpdata.peopleKnife.remark}}</td>
          </tr>
        </table>
      </el-tab-pane>
      <el-tab-pane label="住房" name="house">
        <div class="leftimg">
          <img width="93px" v-bind:src="rpdata.peopleKnife.imgUrl"/>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">房屋地址</td>
            <td></td>
          </tr>
          <tr>
            <td>房产证编号</td>
            <td></td>
          </tr>
          <tr>
            <td>房产所有人</td>
            <td></td>
          </tr>
          <tr>
            <td>房屋面积</td>
            <td></td>
          </tr>
          <tr>
            <td>房屋结构</td>
            <td></td>
          </tr>
          <tr>
            <td>全景图</td>
            <td></td>
          </tr>
        </table>
      </el-tab-pane>
      <el-tab-pane label="车辆" name="car">
        <div class="leftimg">
          <img width="93px" v-bind:src="rpdata.peopleKnife.imgUrl"/>
        </div>
        <table class="infoPop-tabel" cellspacing="0">
          <tr>
            <td class="td-label">车辆品牌</td>
            <td></td>
          </tr>
          <tr>
            <td>车牌号</td>
            <td></td>
          </tr>
          <tr>
            <td>车辆类型</td>
            <td></td>
          </tr>
          <tr>
            <td>车辆识别代码</td>
            <td></td>
          </tr>
          <tr>
            <td>发动机号</td>
            <td></td>
          </tr>
          <tr>
            <td>颜色</td>
            <td></td>
          </tr>
          <tr>
            <td>注册日期</td>
            <td></td>
          </tr>
          <tr>
            <td>备注</td>
            <td></td>
          </tr>
        </table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default {
    name: "real-people-info",
    data() {
      return {
        rpdata: window.realPeopleData,
        activeName: "base"
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
