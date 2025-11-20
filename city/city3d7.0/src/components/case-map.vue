<template>
  <div id="case-map-is-show">
    <div v-show="isSearchMenuShow" class="pop-fai pop-fai-search" v-on:click="searchCase" title="搜索">
      <font-awesome-icon :icon="['fas', 'search']"></font-awesome-icon>
    </div>
    <div v-show="isMenuShow">
      <el-table class="list-tabel" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'caseName', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column label="名称" prop="caseName" width="204px" sortable></el-table-column>
        <el-table-column label="来源" prop="caseSource" width="80px" sortable></el-table-column>
        <el-table-column label="类型" prop="caseType" width="70px" sortable></el-table-column>
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
    <div v-show="isSearchShow">
      <div class="pop-fai pop-fai-start-back" v-on:click="showCaseTabBack" title="返回">
        <font-awesome-icon :icon="['far', 'arrow-alt-circle-left']" fixed-width></font-awesome-icon>
      </div>
      <div class="pop-fai pop-fai-start" v-on:click="showSearchCaseInfo" title="确定">
        <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">名称</div>
        <el-input size="small" class="emer-input" v-model="searchCondition.caseName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">来源</div>
        <el-select size="small" class="emer-input" v-model="searchCondition.caseSource" clearable placeholder="请选择">
          <el-option label="110" value="110"></el-option>
          <el-option label="119" value="119"></el-option>
          <el-option label="122" value="122"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">类型</div>
        <el-input size="small" class="emer-input" v-model="searchCondition.caseType"></el-input>
      </div>
    </div>
    <div v-show="isResultShow">
      <div class="pop-fai pop-fai-start-redo" v-on:click="showAllCaseBack" title="重置">
        <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
      </div>
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'caseName', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column label="名称" prop="caseName" width="204px" sortable>
        </el-table-column>
        <el-table-column label="来源" prop="caseSource" width="80px" sortable>
        </el-table-column>
        <el-table-column label="类型" prop="caseType" width="70px" sortable>
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
  import map3d from "./map-3d";
  import popUtil from "@/utils/pop/popUtil";
  import "../js/CesiumPop.js";
  import {getCase, getCaseById, queryPoliceCase} from "../api/api";

  let case_overlays3D;// 用于存储条件查询结果标签

  export default {
    name: "case-map",
    data() {
      return {
        searchCondition: {
          caseName: "",
          caseSource: "",
          caseType: "",
        },
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        queryResult: [],
        pictLoading: true,
        isSearchShow: false,
        isResultShow: false,
        isMenuShow: true,
        isSearchMenuShow: true,
      }
    },
    methods: {
      //展示案件图标和表格
      showCase(data) {
        this.queryResult = data;
        this.pictLoading = false;
        let casegeojson = {
          "type": "FeatureCollection",
          "features": []
        };
        for (let i = 0; i < data.length; i++) {
          let poiArr = data[i].casePosition.split(",");
          let feature = {
            "type": "Feature",
            "geometry": {
              "type": "Point",
              "coordinates": [Number(poiArr[0]), Number(poiArr[1]), Number(poiArr[2])]
            },
            "id": "cs" + data[i].caseId,
            "case_source": data[i].caseSource
          };
          switch (data[i].caseSource) {
            case '110':
              feature.properties = {
                "case_source": "110",
                "title": "marker",
                "marker-symbol": "marker",
                "marker-color": "#180EF1"
              };
              break;
            case '119':
              feature.properties = {
                "case_source": "119",
                "title": "marker",
                "marker-symbol": "marker",
                "marker-color": "#FD1134"
              };
              break;
            case '122':
              feature.properties = {
                "case_source": "122",
                "title": "marker",
                "marker-symbol": "marker",
                "marker-color": "#FFFE35"
              };
              break;
            default:
              feature.properties = {
                "case_source": "110",
                "title": "marker",
                "marker-symbol": "marker",
                "marker-color": "#180EF1"
              };
              break;
          }
          casegeojson.features.push(feature);
        }
        createClusterPin(casegeojson);

        //创建聚合展点方法
        function createClusterPin(geojson) {
          let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
          let dataSourcePromise = viewer.dataSources.add(promise);
          dataSourcePromise.then(function (dataSource) {
            case_overlays3D = dataSource;
            dataSource.clustering.enabled = true;
            dataSource.clustering.pixelRange = 25;
            dataSource.clustering.minimumClusterSize = 3;
            let dataSourceEntities = dataSource.entities.values;
            for (let i = 0; i < dataSourceEntities.length; i++) {
              let case_source = dataSourceEntities[i].properties.case_source._value;
              let caseImg = '';
              switch (case_source) {
                case '110':
                  caseImg = 'static/images/pinimg/19.png';
                  break;
                case '119':
                  caseImg = 'static/images/pinimg/18.png';
                  break;
                case '122':
                  caseImg = 'static/images/pinimg/17.png';
                  break;
                default:
                  caseImg = 'static/images/pinimg/19.png';
                  break;
              }
              dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
                image: caseImg,
                scale: 0.8,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
              });
            }
            let removeListener;
            let pinBuilder = new Cesium.PinBuilder();
            let pin50 = pinBuilder.fromText('50+', Cesium.Color.RED, 36).toDataURL();
            let pin40 = pinBuilder.fromText('40+', Cesium.Color.ORANGE, 36).toDataURL();
            let pin30 = pinBuilder.fromText('30+', Cesium.Color.YELLOW, 36).toDataURL();
            let pin20 = pinBuilder.fromText('20+', Cesium.Color.GREEN, 36).toDataURL();
            let pin10 = pinBuilder.fromText('10+', Cesium.Color.BLUE, 36).toDataURL();
            let singleDigitPins = new Array(8);
            for (let i = 0; i < singleDigitPins.length; ++i) {
              singleDigitPins[i] = pinBuilder.fromText('' + (i + 2), Cesium.Color.VIOLET, 36).toDataURL();
            }

            function customStyle() {
              if (Cesium.defined(removeListener)) {
                removeListener();
                removeListener = undefined;
              } else {
                removeListener = dataSource.clustering.clusterEvent.addEventListener(function (clusteredEntities, cluster) {
                  cluster.label.show = false;
                  cluster.billboard.show = true;
                  cluster.billboard.id = cluster.label.id;
                  cluster.billboard.verticalOrigin = Cesium.VerticalOrigin.BOTTOM;
                  if (clusteredEntities.length >= 50) {
                    cluster.billboard.image = pin50;
                  } else if (clusteredEntities.length >= 40) {
                    cluster.billboard.image = pin40;
                  } else if (clusteredEntities.length >= 30) {
                    cluster.billboard.image = pin30;
                  } else if (clusteredEntities.length >= 20) {
                    cluster.billboard.image = pin20;
                  } else if (clusteredEntities.length >= 10) {
                    cluster.billboard.image = pin10;
                  } else {
                    cluster.billboard.image = singleDigitPins[clusteredEntities.length - 2];
                  }
                });
              }
              // force a re-cluster with the new styling
              let pixelRange = dataSource.clustering.pixelRange;
              dataSource.clustering.pixelRange = 0;
              dataSource.clustering.pixelRange = pixelRange;
            }

            // start with custom style
            customStyle();
          });
        }
      },
      closeCase() {
        viewer.dataSources.remove(case_overlays3D);
        CesiumPop.clearDivPop(viewer);
      },
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      moveToCase(pos) {
        let posArr = pos.split(",");
        posArr[2] = Number(posArr[2]) + 1000;
        map3d.methods.flyToLocation(posArr);
      },
      rowClick(row, column, event) {
        if (!document.getElementById("popupDiv" + row.caseId)) {
          this.getCaseById(row.caseId);
          let pos = row.casePosition;
          this.moveToCase(pos);
        } else {
          this.$message({
            message: '提示，气泡已打开！请勿重复操作！',
            type: 'warning'
          });
        }
      },
      //根据id获取案件信息
      getCaseById(id) {
        let params = {
          "caseId": id
        };
        getCaseById(params).then(res => this.showCaseInfoPop(res.data));
      },
      searchCase() {
        this.isMenuShow = false;
        this.isResultShow = false;
        this.isSearchShow = true;
        this.isSearchMenuShow = false;
      },
      //案件气泡
      showCaseInfoPop(data) {
        let popoptions = {
          caseId: data.caseId,
          netName: data.netName,
          caseName: data.caseName,
          caseType: data.caseType,
          caseAddr: data.caseAddr,
          caseDate: data.caseDate,
          caseSource: data.caseSource,
          victim: data.victim,
          suspect: data.suspect,
          caseDescribe: data.caseDescribe,
        };
        popUtil.installMapPop().casePop(popoptions);
        let poiArr = data.casePosition.split(",");
        let options = {
          "viewer": viewer,
          "id": data.caseId,
          "popupWidth": 300,
          "popupHeight": 215,
          "pos": {"lon": Number(poiArr[0]), "lat": Number(poiArr[1]), "alt": Number(poiArr[2])},
          "extentHeight": 30,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);
      },
      //条件检索
      showSearchCaseInfo() {
        this.pictLoading = true;
        this.isSearchShow = false;
        this.isResultShow = true;
        let params = this.searchCondition;
        queryPoliceCase(params).then(res => this.showCaseResultTab(res.data));
      },
      showCaseResultTab(data) {
        this.pictLoading = false;
        this.queryResult = data;
      },
      showCaseTabBack() {
        this.isMenuShow = true;
        this.isSearchShow = false;
        this.isSearchMenuShow = true;
      },
      showAllCaseBack() {
        this.searchCondition.caseName = "";
        this.searchCondition.caseSource = "";
        this.searchCondition.caseType = "";
        this.isMenuShow = true;
        this.isResultShow = false;
        this.isSearchShow = false;
        this.isSearchMenuShow = true;
        getCase().then(res => this.showCase(res.data));
      },
    },
    mounted() {
      getCase().then(res => this.showCase(res.data));
      CesiumPop.bindPopGlobeEventHandler(viewer);
    }
  }
</script>

<style scoped>
  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel td {
    padding: 2px 10px;
    cursor: pointer;
    height: 32px;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #091d46bb;
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

  .pop-fai-search {
    right: 80px;
  }

  .pop-fai-search:hover {
    background-color: #e600c3;
  }

  .pop-fai-start {
    right: 80px;
  }

  .pop-fai-start-back {
    right: 120px;
  }

  .pop-fai-start-redo {
    right: 80px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-start-back:hover {
    background-color: #e0960d;
  }

  .pop-fai-start-redo:hover {
    background-color: #e0960d;
  }

  .result-table {
    width: 100%;
    color: #ffffff;
  }
</style>
