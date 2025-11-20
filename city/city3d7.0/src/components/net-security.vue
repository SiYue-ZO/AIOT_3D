<template>
  <div id="net-security-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">名称</div>
        <el-input size="small" class="emer-input" v-model="securityQuery.securityName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">等级</div>
        <el-select size="small" class="emer-input" v-model="securityQuery.level" placeholder="请选择">
          <el-option label="街道" value="街道"></el-option>
          <el-option label="社区" value="社区"></el-option>
          <el-option label="网格" value="网格"></el-option>
          <el-option label="微网格" value="微网格"></el-option>
        </el-select>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'securityName', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column label="名称" prop="securityName" width="174px" sortable></el-table-column>
        <el-table-column label="级别" prop="level" width="80px" sortable></el-table-column>
        <el-table-column label="联系电话" prop="securityTel" width="100px" sortable></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20, 40]"
        :page-size="pagesize"
        :pager-count="5"
        layout="total, sizes, prev, pager, next"
        :total="queryResult.length">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import popUtil from "@/utils/pop/popUtil";
import "../js/CesiumPop.js";
import {stringToNumber} from "@/js/CesiumTools";
import {getSecuritySById, querySecurity, countNextSecurityS, getAllandSecurityById} from "../api/api";

let _this;
let ss_overlays3D = [];
export default {
  name: "net-security",
  data() {
    return {
      securityQuery: {
        securityName: "",
        level: "",
      },
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: true,
      isQueryShow: true,
      isResultShow: false,
    }
  },
  methods: {
    //根据条件查询派出所网格
    doQuery() {
      this.closeSecurity();
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        querySecurity(this.securityQuery).then(res => this.showSecurityAll(res.data));
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
        };
        getAllandSecurityById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleSecurity.map(item => {
            resultArr.push(item.security);
          });
          this.showSecurityAll(resultArr);
        });
      }
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //绘制网格图形
    showSecurityAll(data) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      for (let i = 0; i < data.length; i++) {
        let position = data[i].securityCenter.split(',');
        let netArr = stringToNumber(data[i].securityPoi);
        netArr.push(netArr[0], netArr[1], netArr[2]);
        ss_overlays3D.push(
          viewer.entities.add({
            id: 'ss' + data[i].securityId,
            position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
            label: {
              text: data[i].securityName,
              font: 'Bold 30px Helvetica',
              scale: 0.5,
              fillColor: Cesium.Color.fromCssColorString(data[i].securityCommunity),
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              outlineColor: Cesium.Color.WHITE,
              outlineWidth: 6,
              pixelOffset: new Cesium.Cartesian2(0, -20),
            },
            polygon: {
              hierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArrayHeights(netArr)),
              material: Cesium.Color.fromCssColorString(data[i].securityCommunity).withAlpha(0.4),
            },
            // polyline: {
            //   positions: Cesium.Cartesian3.fromDegreesArrayHeights(netArr),
            //   clampToGround: true,
            //   width: 5,
            //   show: true,
            //   material: Cesium.Color.fromCssColorString(data[i].securityCommunity).withAlpha(0.4),
            // }
          }),
        );
      }
      _this.queryResult = data;
      _this.pictLoading = false;
    },
    resetForm() {
      this.securityQuery.securityName = "";
      this.securityQuery.level = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.closeSecurity();
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //清除网格图形
    clearSecurity() {
      for (let i = 0; i < ss_overlays3D.length; i++) {
        viewer.entities.remove(ss_overlays3D[i]);
      }
      ss_overlays3D = [];
    },
    rowClick(row, column, event) {
      this.doGetSecurityById(row.securityId);
    },
    //根据id获取网格详情
    doGetSecurityById(id) {
      let params = {
        'securityId': id
      };
      getSecuritySById(params).then(res => {
        let params1 = {
          'pid': id
        };
        countNextSecurityS(params1).then(res1 => {
          let result = res.data;
          result.nextNum = res1.data;
          this.showSecurity(result);
        });
      });
    },
    //显示网格气泡
    showSecurity(data) {
      let netListenerArr = [];
      if (data.netListener === null || data.netListener === "") {
        netListenerArr = ["", "", ""];
      } else {
        netListenerArr = data.netListener.split(",");
        netListenerArr.splice(netListenerArr.length - 1, 1);
      }
      let popoptions = {
        popId: data.securityId,
        nsdata: data,
        netMasterId: data.netMaster,
        netListenerIds: netListenerArr,
        netBasePeople: data.netBasePeople,
        netHoldPeople: data.netHoldPeople,
        netFlowPeople: data.netFlowPeople,
        netGroup: data.netGroup,
        netNote: data.netNote,
        nextNum: data.nextNum,
      };
      popUtil.installMapPop().nsPop(popoptions);
      let addArr = data.securityCenter.split(',');
      let options = {
        "viewer": viewer,
        "id": data.securityId,
        "popupWidth": 477,
        "popupHeight": 323,
        "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
        "extentHeight": 0,
        "extentColor": Cesium.Color.WHITE,
      };
      CesiumPop.addDivPop(options, 'h');
    },
    //清除模块数据
    closeSecurity() {
      this.clearSecurity();
      CesiumPop.clearDivPop(viewer);
    }
  },
  mounted() {
    _this = this;
    this.securityQuery.level = "街道";
    this.doQuery();
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  color: #ffffff;
}

.pop-fai {
  position: absolute;
  z-index: 100;
  top: 3px;
  color: #efefef;
  font-size: 15px;
  cursor: pointer;
  padding: 5px 6px;
}

.pop-fai-start {
  right: 120px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}

.pop-fai-follow {
  right: 80px;
}

.pop-fai-follow:hover {
  background-color: #e0960d;
}

.emer-row {
  color: #ffffff;
  margin: 8px 0;
  height: 32px
}

.emer-row-label {
  width: 75px;
  font-size: 15px;
  margin-top: 5px;
  float: left;
  text-align: right;
  padding-right: 10px;
}

.emer-input {
  width: 280px;
}
</style>
