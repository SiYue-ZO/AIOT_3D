<template>
  <div style="color:#ffffff">
    <el-tabs v-model="activeName">
      <el-tab-pane label="单位信息" name="company">
        <div class="leftimg">
          <img width="93px" v-bind:src="rcdata.imageInfo"/>
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
      </el-tab-pane>
      <el-tab-pane label="防火措施" name="fire">
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
      </el-tab-pane>
      <el-tab-pane label="安保监管" name="save">
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
      </el-tab-pane>
      <el-tab-pane label="建筑" name="construction">
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
      </el-tab-pane>
      <el-tab-pane label="执业监管" name="license">
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
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  export default {
    name: "real-company-info",
    data() {
      return {
        rcdata: window.realCompanyData,
        activeName: "company"
      }
    },
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
