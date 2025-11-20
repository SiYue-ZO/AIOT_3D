<template>
  <div>
    <div class="pop-fai pop-fai-start" v-on:click="openCoverageSearchData" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="emer-row">
      <div>自定义图层：{{ radioName }}</div>
    </div>
    <div v-show="isQueryShow">
      <div v-for="(item,index) in attributeData" :key="index" class="emer-row">
        <div v-if="item.type==='文本'">
          <div class="emer-row-label">{{ item.attrName }}</div>
          <el-input v-model="queryData[index]" size="small" class="emer-input"></el-input>
        </div>
        <div v-else-if="item.type==='下拉列表'">
          <div class="emer-row-label">{{ item.attrName }}</div>
          <el-select v-bind:id="'coverage' + item.id" size="small" class="emer-input" placeholder="请选择"
                     v-model="queryData[index]">
            <el-option v-for="(optionItem,oindex) in item.option.split('&')" :key="oindex" :label="optionItem"
                       :value="optionItem"></el-option>
          </el-select>
        </div>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">地址</div>
        <el-input v-model="coverageAddress" size="small" class="emer-input"></el-input>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'addName', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column :label="name1" prop="value1" width="110px" sortable>
        </el-table-column>
        <el-table-column :label="name2" prop="value2" width="114px" sortable>
        </el-table-column>
        <el-table-column :label="name3" prop="value3" width="130px" sortable>
        </el-table-column>
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
import map3d from './map-3d';
import popUtil from "../utils/pop/popUtil";
import {getAttributeDataAndAddressById, getAttributeDataByValue, getAttributeOnlyByCoverId} from "../api/api";

let idShowAttrData;
let custom_Overlays = [];
export default {
  name: "net-custom-search",
  data() {
    return {
      radioId: 0, // 选中的值
      radioName: '',
      attributeData: [],
      queryData: [],
      coverageAddress: '',
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: false,
      name1: '',
      name2: '',
      name3: '',
    }
  },
  methods: {
    //打开指定图层的属性项
    openCoverageSearch(data) {
      this.attributeData = data;
    },
    //根据条件获取指定图层的全部数据
    openCoverageSearchData() {
      let params = {};
      params.coverageId = this.radioId;
      for (let i = 0; i < this.attributeData.length; i++) {
        let value1 = this.queryData[i];
        let key1 = this.attributeData[i].attrName;
        params[key1] = value1;
      }
      params.addName = this.coverageAddress;
      let result = delObjValurNull(params);
      this.getSearchAttrResult(result, this.radioId);

      function delObjValurNull(obj) {
        Object.keys(obj).forEach(item => {
          if (obj[item] === "" || obj[item] === undefined) delete obj[item];
        });
        return obj;
      }
    },
    //获取检索结果
    getSearchAttrResult(params, id) {
      this.pictLoading = true;
      getAttributeDataByValue(params).then(res => this.showAttrData_3D(res.data, id));
    },
    //显示结果
    showAttrData_3D(data, id) {
      this.closeNetCustomSearch();
      idShowAttrData = id;
      this.isQueryShow = false;
      this.isResultShow = true;
      for (let i = 0; i < data.length; i++) {
        let valueArr = data[i].value.split('&');
        if (valueArr[0]) {
          let prop1Arr = valueArr[0].split('#');
          this.name1 = prop1Arr[0];
          data[i].value1 = prop1Arr[1];
        }
        if (valueArr[1]) {
          let prop2Arr = valueArr[1].split('#');
          this.name2 = prop2Arr[0];
          data[i].value2 = prop2Arr[1];
        }
        if (valueArr[2]) {
          let prop3Arr = valueArr[2].split('#');
          this.name3 = prop3Arr[0];
          data[i].value3 = prop3Arr[1];
        }
        let position = data[i].poi.split(',');
        let color = data[i].color === null ? '#ffffff' : data[i].color;
        let colorCesium = Cesium.Color.fromCssColorString(color);
        let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        let pinBuilder = new Cesium.PinBuilder();
        let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
        Promise.resolve(
          pinBuilder.fromUrl(url, colorCesium, 30)
        ).then(function (canvas) {
          return custom_Overlays.push(viewer.entities.add({
            id: 'co' + data[i].id,
            position: point,
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.3, 0.3, 0.3),
              material: Cesium.Color.fromCssColorString(color).withAlpha(0.5)
            },
            // label: {
            //   show: true,
            //   verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            //   horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
            //   font: 'bold 56px Helvetica',
            //   scale: 0.5,
            //   fillColor: Cesium.Color.fromCssColorString("#ffffff"),
            //   text: i + 1 + '',
            //   pixelOffset: new Cesium.Cartesian2(0.0, -85.0),
            //   scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            //   pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            //   disableDepthTestDistance: 100000000,
            // },
            // billboard: {
            //   image: 'static/images/pinimg/34.png',
            //   scale: 0.8,
            //   verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            //   scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            //   pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            //   disableDepthTestDistance: 100,
            // }
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
          }));
        });
      }
      this.queryResult = data;
      this.pictLoading = false;
    },
    //表单复位
    resetForm() {
      this.isQueryShow = true;
      this.isResultShow = false;
    },
    rowClick(row, column, event) {
      this.dogetAttrDataById(row.id);
      if (row.camHeading !== null && row.camHeading !== '') {
        let camPoiArr = row.camPoi.split(',');
        map3d.methods.moveToWin(camPoiArr[0], camPoiArr[1], camPoiArr[2], row.camHeading, row.camPitch);
      } else {
        let poiArr = row.poi.split(',');
        poiArr[2] = Number(poiArr[2]) + 500;
        map3d.methods.flyToLocation(poiArr);
      }
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //根据数据id获取该条数据
    dogetAttrDataById(id) {
      let params = {
        'id': id
      };
      getAttributeDataAndAddressById(params).then(res => this.showAttrData(res.data));
    },
    //详情气泡
    showAttrData(data) {
      if (!document.getElementById('popupDiv' + data.id)) {
        CesiumPop.bindPopGlobeEventHandler(viewer);
        let attrDatas = data.value.replace(/#/g, '&').split('&');
        let pcValueArr = [];
        for (let i = 0; i < attrDatas.length; i = i + 2) {
          pcValueArr.push([attrDatas[i], attrDatas[i + 1]]);
        }
        let popoptions = {
          popId: data.id,
          addName: data.addName,
          pcValueArr: pcValueArr
        };
        popUtil.installMapPop().pcPop(popoptions);
        let addArr = data.poi.split(',');
        let options = {
          "viewer": viewer,
          "id": data.id,
          "popupWidth": 477,
          "popupHeight": 323,
          "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
          "extentHeight": 0,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options, 'h');
      }
    },
    //清除数据
    closeNetCustomSearch() {
      for (let i = 0; i < custom_Overlays.length; i++) {
        viewer.entities.remove(custom_Overlays[i]);
      }
      custom_Overlays = [];
      CesiumPop.clearDivPop(viewer);
    },
  },
  mounted() {
    let params = {
      'coverageId': window.curNetCustomId
    };
    getAttributeOnlyByCoverId(params).then(res => this.openCoverageSearch(res.data));
    this.radioId = window.curNetCustomId;
    this.radioName = window.curNetCustomName;
  }
}
</script>

<style scoped>
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
  width: 100px;
  font-size: 15px;
  margin-top: 5px;
  float: left;
  text-align: right;
  padding-right: 10px;
}

.emer-input {
  width: 250px;
}

.result-table {
  width: 100%;
  color: #ffffff;
}
</style>
