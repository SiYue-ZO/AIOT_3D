<template>
  <div id="net-building-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="selectbypolygon" title="框选:左键选取，右键结束" v-show="isQueryShow">
      <font-awesome-icon :icon="['far', 'object-ungroup']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="opensearchmenu" title="筛选" v-show="isQueryShow">
      <font-awesome-icon :icon="['fas', 'search']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="返回" v-show="isResultShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="exportResult" title="导出">
      <font-awesome-icon :icon="['fas', 'download']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-clear" v-on:click="clearSelectBuildingAll" title="清除">
      <font-awesome-icon :icon="['fas', 'eraser']" fixed-width></font-awesome-icon>
    </div>
    <div id="buildingStat" class="stat-chart"></div>
    <div id="buildinglandStat" class="stat-chart"></div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">建库库号</div>
        <el-input size="small" class="emer-input" v-model="buildingQuery.dbnum"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">土地性质</div>
        <el-select size="small" class="emer-input" v-model="buildingQuery.tdxz" placeholder="请选择">
          <el-option label="集体建设用地" value="集体建设用地"></el-option>
          <el-option label="宅基地" value="宅基地"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">意向公司</div>
        <el-input size="small" class="emer-input" v-model="buildingQuery.yxgs"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房屋层数</div>
        <el-input size="small" class="emer-input" v-model="buildingQuery.fwcs"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房屋结构</div>
        <el-select size="small" class="emer-input" v-model="buildingQuery.fwjg" placeholder="请选择">
          <el-option label="砼" value="砼"></el-option>
          <el-option label="混" value="混"></el-option>
          <el-option label="砖" value="砖"></el-option>
          <el-option label="简" value="简"></el-option>
          <el-option label="棚" value="棚"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">宗地号</div>
        <el-input size="small" class="emer-input" v-model="buildingQuery.zdh"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">房产证号</div>
        <el-input size="small" class="emer-input" v-model="buildingQuery.fczh"></el-input>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="list-tabel" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'dbnum', order: 'ascending'}"
                @row-click="rowClick">
        <el-table-column label="宗地号" prop="zdh" width="110px" sortable></el-table-column>
        <el-table-column label="性质" prop="tdxz" width="110px" sortable></el-table-column>
        <el-table-column label="结构" prop="fwjg" width="70px" sortable></el-table-column>
        <el-table-column label="层数" prop="fwcs" width="65px" sortable></el-table-column>
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
import {stringToNumber, isPointInPolygonBidirectional} from "../js/CesiumTools.js";
import popUtil from "@/utils/pop/popUtil";
import XLSX from "xlsx";
import {getBuildingAll, getBuildingById, queryBuilding} from "../api/api";

let bu_overlays3D = [];
let prebuildingprimitive = undefined;
let buildingpointArr = [];
let inbuildings = [];
let buildingData;
let query_building3D = [];

export default {
  name: "net-building",
  data() {
    return {
      buildingQuery: {
        dbnum: "",
        tdxz: "",
        yxgs: "",
        fwcs: "",
        fwjg: "",
        zdh: "",
        fczh: "",
      },
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      pictLoading: false
    }
  },
  methods: {
    //绘制全部建筑物多边形
    showBuildingAll(data) {
      buildingData = data;
      for (let i = 0; i < data.length; i++) {
        let polygonArrtmp = stringToNumber(data[i].coordinates);
        let polygonArr = [];
        for (let j = 0; j < polygonArrtmp.length; j += 2) {
          polygonArr.push(polygonArrtmp[j], polygonArrtmp[j + 1]);
        }
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "bu" + data[i].buildingId,
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArray(polygonArr)),
            extrudedHeight: 5000
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.DARKORCHID.withAlpha(0.7))
          }
        });
        let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);
        bu_overlays3D.push(tmpClassificationPrimitive);
      }
    },
    //关闭建筑物
    closeBuilding() {
      for (let i = 0; i < bu_overlays3D.length; i++) {
        viewer.scene.primitives.remove(bu_overlays3D[i]);
      }
      bu_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
      this.clearSelectBuildingAll();
    },
    //关闭上一个建筑物多边形
    closePreBuilding() {
      if (prebuildingprimitive !== undefined) {
        viewer.scene.primitives.remove(prebuildingprimitive);
      }
    },
    //查询指定id
    getBuildingById(id, pos) {
      let params = {
        "buildingId": id
      };
      getBuildingById(params).then(res => this.showBuildingById(res.data, pos));
    },
    showBuildingById(data, pos) {
      this.closePreBuilding();
      for (let i = 0; i < buildingData.length; i++) {
        if (buildingData[i].buildingId === data.buildingId) {
          let polygonArrtmp = stringToNumber(data.coordinates);
          let polygonArr = [];
          for (let j = 0; j < polygonArrtmp.length; j += 2) {
            polygonArr.push(polygonArrtmp[j], polygonArrtmp[j + 1]);
          }
          let tmpGeometryInstance = new Cesium.GeometryInstance({
            id: "bubyid" + data.buildingId,
            geometry: new Cesium.PolygonGeometry({
              polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArray(polygonArr)),
              extrudedHeight: 5000
            }),
            attributes: {
              color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.ORANGE.withAlpha(0.6))
            }
          });
          let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
            geometryInstances: tmpGeometryInstance
          });
          viewer.scene.primitives.add(tmpClassificationPrimitive);
          prebuildingprimitive = tmpClassificationPrimitive;
          if (!document.getElementById('popupDiv' + data.buildingId)) {
            let stepActive = 1;
            if (data.buildingPdf3 !== "" && data.buildingPdf3 !== null && data.buildingPdf3 !== "null") {
              stepActive = 4;
            } else if (data.buildingPdf2 !== "" && data.buildingPdf2 !== null && data.buildingPdf2 !== "null") {
              stepActive = 3;
            } else if (data.buildingPdf1 !== "" && data.buildingPdf1 !== null && data.buildingPdf1 !== "null") {
              stepActive = 2;
            }
            let popoptions = {
              popId: data.buildingId,
              dbnum: data.dbnum,
              tdxz: data.tdxz,
              yxgs: data.yxgs,
              jzzdmj: data.jzzdmj,
              sjjzmj: data.sjjzmj,
              fwcs: data.fwcs,
              fwjg: data.fwjg,
              zdh: data.zdh,
              fczh: data.fczh,
              note: data.note,
              buildingImg: common.serverIp + "city3dfile/" +data.buildingImg,
              buildingPdf1: data.buildingPdf1,
              buildingPdf2: data.buildingPdf2,
              buildingPdf3: data.buildingPdf3,
              stepActive: stepActive
            };
            popUtil.installMapPop().buildingPop(popoptions);
            let cartographic = Cesium.Cartographic.fromCartesian(pos);
            let lon = Cesium.Math.toDegrees(cartographic.longitude);
            let lat = Cesium.Math.toDegrees(cartographic.latitude);
            let options = {
              "viewer": viewer,
              "id": data.buildingId,
              "popupWidth": 360,
              "popupHeight": 330,
              "pos": {"lon": Number(lon), "lat": Number(lat), "alt": cartographic.height},
              "extentHeight": 10,
              "extentColor": Cesium.Color.WHITE,
            };
            CesiumPop.addDivPop(options);
          }
          break;
        }
      }
    },
    //框选
    selectbypolygon() {
      this.clearSelectBuildingAll();
      let activeShapePoints = [];
      let comPoints = [];
      let that = this;

      function createPoint(worldPosition) {
        buildingpointArr.push(viewer.entities.add({
          position: worldPosition,
          point: {
            color: Cesium.Color.RED,
            pixelSize: 10,
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE,
            disableDepthTestDistance: 10000
          }
        }));
      }

      function drawPolygon() {
        if (viewer.entities.getById('comEntity') !== undefined) {
          viewer.entities.removeById('comEntity');
        }
        viewer.entities.add({
          id: 'comEntity',
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
              return activeShapePoints;
          }, false),*/
            material: new Cesium.ColorMaterialProperty(Cesium.Color.RED.withAlpha(0.3)),
            classificationType: Cesium.ClassificationType.BOTH,
            outline: true,
            outlineColor: Cesium.Color.WHITE
          }
        });
      }

      let handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        //获取地理坐标（经度、纬度、高程）
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let heightString = cartographic.height;
        if (Number(heightString) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
        let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
        let comPoint = {'x': Number(longitudeString), 'y': Number(latitudeString)};
        comPoints.push(comPoint);
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 3) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        if (newPosition !== undefined) {
          let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
          let height = cartographic.height; //模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            newPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          activeShapePoints.pop();
          activeShapePoints.push(newPosition);
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
        if (activeShapePoints.length > 3) {
          drawPolygon();
          that.showbuildingComresult(comPoints); //计算符合条件的数据并显示
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    //显示框选结果
    showbuildingComresult(comPoints) {
      this.clearSelectResult();
      this.clearQueryResult();
      for (let i = 0; i < buildingData.length; i++) {
        let coordArr = buildingData[i].coordinates.split(',');
        let targetPoi = [];
        for (let j = 0; j < coordArr.length; j += 2) {
          targetPoi.push({'x': Number(coordArr[j]), 'y': Number(coordArr[j + 1])});
        }
        if (isPointInPolygonBidirectional(comPoints, targetPoi)) {
          let attributes = bu_overlays3D[i].getGeometryInstanceAttributes("bu" + buildingData[i].buildingId);
          attributes.color = Cesium.ColorGeometryInstanceAttribute.toValue(Cesium.Color.YELLOW.withAlpha(0.6));
          inbuildings.push(i);
        }
      }
      this.showbuildingstat();
    },
    //框选后显示统计图表
    showbuildingstat() {
      this.isQueryShow = true;
      this.isResultShow = false;
      document.getElementById("buildingStat").style.display = 'block';
      document.getElementById("buildinglandStat").style.display = 'block';
      let statz1 = 0, statz2 = 0, statz3 = 0, statz4 = 0, statz5 = 0, statz6 = 0;
      let statj1 = 0, statj2 = 0, statj3 = 0, statj4 = 0, statj5 = 0;
      let statzb1 = 0, statzb2 = 0, statzb3 = 0, statzb4 = 0, statzb5 = 0, statzb6 = 0;
      let statjb1 = 0, statjb2 = 0, statjb3 = 0, statjb4 = 0, statjb5 = 0;
      for (let i = 0; i < inbuildings.length; i++) {
        switch (Number(buildingData[inbuildings[i]].fwcs)) {
          case 1:
            statz1 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb1 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case 2:
            statz2 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb2 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case 3:
            statz3 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb3 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case 4:
            statz4 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb4 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case 5:
            statz5 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb5 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case 6:
            statz6 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb6 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          default:
            statz6 += Number(buildingData[inbuildings[i]].jzzdmj);
            statzb6 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
        }
        switch (buildingData[inbuildings[i]].fwjg) {
          case '砼':
            statj1 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb1 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case '砖':
            statj2 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb2 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case '混':
            statj3 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb3 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case '简':
            statj4 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb4 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          case '棚':
            statj5 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb5 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
          default:
            statj5 += Number(buildingData[inbuildings[i]].jzzdmj);
            statjb5 += Number(buildingData[inbuildings[i]].sjjzmj);
            break;
        }
      }
      let buildinglandtotal = statz1 + statz2 + statz3 + statz4 + statz5 + statz6;
      let buildingtotal = statzb1 + statzb2 + statzb3 + statzb4 + statzb5 + statzb6;

      let buildingStat = this.$echarts.init(document.getElementById("buildingStat"), 'dark');
      let buildingOption = {
        title: {
          text: '面积统计',
          subtext: '实际建筑面积共： ' + buildingtotal.toFixed(1) + '平方米',
          textStyle: {fontSize: 15},
          subtextStyle: {fontSize: 13, color: '#eee'}
        },
        legend: {bottom: '5px'},
        tooltip: {},
        toolbox: {
          show: true,
          feature: {
            mark: {show: true},
            dataView: {show: false, readOnly: false},
            saveAsImage: {show: false}
          }
        },
        backgroundColor: 'rgba(255, 255, 255, 0)',
        dataset: {
          dimensions: ['product', '1层', '2层', '3层', '4层', '5层', '6层以上'],
          source: [{
            product: '建筑占地面积', '1层': statz1.toFixed(1), '2层': statz2.toFixed(1), '3层': statz3.toFixed(1),
            '4层': statz4.toFixed(1), '5层': statz5.toFixed(1), '6层以上': statz6.toFixed(1)
          },
            {
              product: '实际建筑面积', '1层': statzb1.toFixed(1), '2层': statzb2.toFixed(1), '3层': statzb3.toFixed(1),
              '4层': statzb4.toFixed(1), '5层': statzb5.toFixed(1), '6层以上': statzb6.toFixed(1)
            }]
        },
        xAxis: {type: 'category'},
        yAxis: {},
        series: [
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'}
        ]
      };
      buildingStat.setOption(buildingOption);

      let buildinglandStat = this.$echarts.init(document.getElementById("buildinglandStat"), 'dark');
      let buildinglandOption = {
        title: {
          text: '面积统计',
          subtext: '实际建筑面积共： ' + buildingtotal.toFixed(1) + '平方米',
          textStyle: {fontSize: 15},
          subtextStyle: {fontSize: 13, color: '#eee'}
        },
        legend: {bottom: '5px'},
        tooltip: {},
        toolbox: {
          show: true,
          feature: {
            mark: {show: true},
            dataView: {show: false, readOnly: false},
            saveAsImage: {show: false}
          }
        },
        backgroundColor: 'rgba(255, 255, 255, 0)',
        dataset: {
          dimensions: ['product', '砼', '砖', '混', '简', '棚'],
          source: [{
            product: '建筑占地面积',
            '砼': statj1.toFixed(1),
            '砖': statj2.toFixed(1),
            '混': statj3.toFixed(1),
            '简': statj4.toFixed(1),
            '棚': statj5.toFixed(1)
          },
            {
              product: '实际建筑面积',
              '砼': statjb1.toFixed(1),
              '砖': statjb2.toFixed(1),
              '混': statjb3.toFixed(1),
              '简': statjb4.toFixed(1),
              '棚': statjb5.toFixed(1)
            }]
        },
        xAxis: {type: 'category'},
        yAxis: {},
        series: [
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'},
          {type: 'bar'}
        ]
      };
      buildinglandStat.setOption(buildinglandOption);
    },
    //清除所有查询结果
    clearSelectBuildingAll() {
      if (viewer.entities.getById('comEntity') !== undefined) {
        viewer.entities.removeById('comEntity');
      }
      for (let i = 0; i < buildingpointArr.length; i++) {
        viewer.entities.remove(buildingpointArr[i]);
      }
      this.clearSelectResult();
      this.clearQueryResult();
      this.closePreBuilding();
      document.getElementById("buildingStat").style.display = 'none';
      document.getElementById("buildinglandStat").style.display = 'none';
    },
    //清除结果
    clearSelectResult() {
      for (let i = 0; i < inbuildings.length; i++) {
        if (bu_overlays3D[inbuildings[i]]) {
          let attributes = bu_overlays3D[inbuildings[i]].getGeometryInstanceAttributes("bu" + buildingData[inbuildings[i]].buildingId);
          attributes.color = Cesium.ColorGeometryInstanceAttribute.toValue(Cesium.Color.DARKORCHID.withAlpha(0.7));
        }
      }
      inbuildings = [];
      this.closePreBuilding();
    },
    //打开搜索结果
    opensearchmenu() {
      this.pictLoading = true;
      this.isQueryShow = false;
      this.isResultShow = true;
      let params = this.buildingQuery;
      queryBuilding(params).then(res => this.showQueryBuilding(res.data));
    },
    //绘制条件查询结果
    showQueryBuilding(data) {
      this.clearSelectBuildingAll();
      for (let i = 0; i < data.length; i++) {
        let polygonArrtmp = stringToNumber(data[i].coordinates);
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: "bu" + data[i].buildingId,
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArray(polygonArrtmp)),
            extrudedHeight: 5000
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.DEEPPINK.withAlpha(0.6))
          }
        });
        let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);
        query_building3D.push(tmpClassificationPrimitive);
      }
      this.pictLoading = false;
      this.queryResult = data;
    },
    clearQueryResult() {
      for (let i = 0; i < query_building3D.length; i++) {
        viewer.scene.primitives.remove(query_building3D[i]);
      }
      query_building3D.length = 0;// 清空用于存放查询结果的数据
    },
    //利用xlsx导出查询结果
    exportResult() {
      let aoa = [
        ['图标建库库号', '土地性质', '意向公司', '建筑占地面积', '实际建筑面积', '房屋层数', '房屋结构', '宗地号', '房产证号']
      ];
      for (let i = 0; i < inbuildings.length; i++) {
        let aoap = buildingData[inbuildings[i]];
        aoa.push([aoap.dbnum, aoap.tdxz, aoap.yxgs, aoap.jzzdmj, aoap.sjjzmj, aoap.fwcs, aoap.fwjg, aoap.zdh, aoap.fczh]);
      }
      let workbook = XLSX.utils.aoa_to_sheet(aoa);
      this.openDownloadDialog(sheet2blob(workbook), '导出结果.xlsx');

      //将一个sheet转成最终的excel文件的blob对象，然后利用URL.createObjectURL下载
      function sheet2blob(sheet, sheetName) {
        sheetName = sheetName || 'sheet1';
        let workbook = {
          SheetNames: [sheetName],
          Sheets: {}
        };
        workbook.Sheets[sheetName] = sheet;
        // 生成excel的配置项
        let wopts = {
          bookType: 'xlsx', // 要生成的文件类型
          bookSST: false, // 是否生成Shared String Table，官方解释是，如果开启生成速度会下降，但在低版本IOS设备上有更好的兼容性
          type: 'binary'
        };
        let wbout = XLSX.write(workbook, wopts);
        let outBlob = new Blob([s2ab(wbout)], {type: "application/octet-stream"});

        // 字符串转ArrayBuffer
        function s2ab(s) {
          let buf = new ArrayBuffer(s.length);
          let view = new Uint8Array(buf);
          for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
          return buf;
        }

        return outBlob;
      }
    },
    //开始下载
    openDownloadDialog(url, saveName) {
      if (typeof url == 'object' && url instanceof Blob) {
        url = URL.createObjectURL(url); // 创建blob地址
      }
      let aLink = document.createElement('a');
      aLink.href = url;
      aLink.download = saveName || ''; // HTML5新增的属性，指定保存文件名，可以不要后缀，注意，file:///模式下不会生效
      let event;
      if (window.MouseEvent) event = new MouseEvent('click');
      else {
        event = document.createEvent('MouseEvents');
        event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
      }
      aLink.dispatchEvent(event);
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    rowClick(row, column, event) {
      this.getBuildingById(row.buildingId);
    },
    resetForm() {
      this.buildingQuery.dbnum = "";
      this.buildingQuery.tdxz = "";
      this.buildingQuery.yxgs = "";
      this.buildingQuery.fwcs = "";
      this.buildingQuery.fwjg = "";
      this.buildingQuery.zdh = "";
      this.buildingQuery.fczh = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.clearSelectBuildingAll();
    },
  },
  mounted() {
    getBuildingAll().then(res => this.showBuildingAll(res.data));
    CesiumPop.bindPopGlobeEventHandler(viewer);
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
  right: 160px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}

.pop-fai-follow {
  right: 130px;
}

.pop-fai-follow:hover {
  background-color: #e0960d;
}

.pop-fai-stop {
  right: 100px;
}

.pop-fai-stop:hover {
  background-color: #e600c3;
}

.pop-fai-clear {
  right: 70px;
}

.pop-fai-clear:hover {
  background-color: #e60020;
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

.stat-chart {
  min-height: 280px;
  width: 390px;
  margin: 5px 0 0 5px;
  display: none;
}

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
</style>
