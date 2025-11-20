<template>
  <div class="realPeople" id="real-people-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="doQuery" title="确定">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-follow" v-on:click="resetForm" title="重置">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="addPointsHandler" title="框选">
      <font-awesome-icon :icon="['far', 'object-ungroup']" fixed-width></font-awesome-icon>
    </div>
    <div v-show="isQueryShow">
      <div class="emer-row">
        <div class="emer-row-label">姓名</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.name"></el-input>
        <div class="emer-row-label" style="margin-left: 5px">曾用名</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.onceName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">身份证号</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.identity"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">工作对象</div>
        <el-select size="small" class="emer-input" v-model="realPeopleQuery.isDrug" placeholder="请选择">
          <el-option label="重点人口" value="重点人口"></el-option>
          <el-option label="监管对象" value="监管对象"></el-option>
          <el-option label="吸毒人员" value="吸毒人员"></el-option>
          <el-option label="上访人员" value="上访人员"></el-option>
          <el-option label="精神病人员" value="精神病人员"></el-option>
          <el-option label="人口流动" value="人口流动"></el-option>
          <el-option label="内地涉疆人员" value="内地涉疆人员"></el-option>
          <el-option label="出境未归人员" value="出境未归人员"></el-option>
          <el-option label="去向不明与无轨迹人员" value="去向不明与无轨迹人员"></el-option>
          <el-option label="重点人员" value="重点人员"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">人口类别</div>
        <el-select size="small" class="emer-input" v-model="realPeopleQuery.peopleType" placeholder="请选择">
          <el-option label="常住人口" value="常住人口"></el-option>
          <el-option label="从业人员" value="从业人员"></el-option>
          <el-option label="重点人员" value="重点人员"></el-option>
          <el-option label="监管对象" value="监管对象"></el-option>
          <el-option label="吸毒人员" value="吸毒人员"></el-option>
          <el-option label="上访人员" value="上访人员"></el-option>
          <el-option label="精神病人员" value="精神病人员"></el-option>
          <el-option label="流入人口" value="流入人口"></el-option>
          <el-option label="流出人口" value="流出人口"></el-option>
          <el-option label="维稳双联户长" value="维稳双联户长"></el-option>
          <el-option label="楼栋长" value="楼栋长"></el-option>
          <el-option label="单元长" value="单元长"></el-option>
          <el-option label="小区长" value="小区长"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">性别</div>
        <el-radio-group v-model="realPeopleQuery.gender" size="small">
          <el-radio style="color: #ffffff" border label="男"></el-radio>
          <el-radio style="color: #ffffff" border label="女"></el-radio>
        </el-radio-group>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">身高</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.height"></el-input>
        <div class="emer-row-label" style="margin-left: 5px">血型</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.bloodType" placeholder="请选择">
          <el-option label="A" value="A"></el-option>
          <el-option label="B" value="B"></el-option>
          <el-option label="AB" value="AB"></el-option>
          <el-option label="O" value="O"></el-option>
        </el-select>
      </div>
      <!--<div class="emer-row">
        <div class="emer-row-label">生日</div>
        <el-date-picker v-model="realPeopleQuery.birthday" type="datetimerange" format="yyyy-MM-dd HH:mm:ss"
                        value-format="yyyy-MM-dd HH:mm:ss" range-separator="-" start-placeholder="开始日期"
                        end-placeholder="结束日期" size="small" style="width:280px!important;">
        </el-date-picker>
      </div>-->
      <div class="emer-row">
        <div class="emer-row-label">民族</div>
        <el-input size="small" class="emer-input-half" v-model="realPeopleQuery.nation"></el-input>
        <div class="emer-row-label" style="margin-left: 5px">文化程度</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.calture" placeholder="请选择">
          <el-option label="未入学/文盲" value="未入学/文盲"></el-option>
          <el-option label="小学" value="小学"></el-option>
          <el-option label="初中" value="初中"></el-option>
          <el-option label="中专" value="中专"></el-option>
          <el-option label="高中" value="高中"></el-option>
          <el-option label="大专" value="大专"></el-option>
          <el-option label="本科" value="本科"></el-option>
          <el-option label="硕士" value="硕士"></el-option>
          <el-option label="博士" value="博士"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">联系电话</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.tel"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">政治面貌</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.political" placeholder="请选择">
          <el-option label="党员" value="党员"></el-option>
          <el-option label="团员" value="团员"></el-option>
          <el-option label="群众" value="群众"></el-option>
          <el-option label="民主党派" value="民主党派"></el-option>
        </el-select>
        <div class="emer-row-label" style="margin-left: 5px">宗教信仰</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.region" placeholder="请选择">
          <el-option label="无宗教信仰" value="无宗教信仰"></el-option>
          <el-option label="伊斯兰教" value="伊斯兰教"></el-option>
          <el-option label="佛教" value="佛教"></el-option>
          <el-option label="基督教" value="基督教"></el-option>
          <el-option label="天主教" value="天主教"></el-option>
          <el-option label="其他" value="其他"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">婚姻状态</div>
        <el-select size="small" class="emer-input-half" v-model="realPeopleQuery.marriage" placeholder="请选择">
          <el-option label="未婚" value="未婚"></el-option>
          <el-option label="已婚" value="已婚"></el-option>
          <el-option label="离婚" value="离婚"></el-option>
          <el-option label="初婚" value="初婚"></el-option>
          <el-option label="复婚" value="复婚"></el-option>
          <el-option label="再婚" value="再婚"></el-option>
          <el-option label="丧偶" value="丧偶"></el-option>
          <el-option label="未说明的婚姻状况" value="未说明的婚姻状况"></el-option>
        </el-select>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">从业单位</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.unitName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">从业职业</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.job"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">户口性质</div>
        <el-radio-group v-model="realPeopleQuery.householdNature" size="small">
          <el-radio style="color: #ffffff" border label="非农业户口"></el-radio>
          <el-radio style="color: #ffffff" border label="农业户口"></el-radio>
        </el-radio-group>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">户籍地址</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.householdAddress"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">父亲姓名</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.fatherName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">身份证号</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.fatherIdentity"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">母亲姓名</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.motherName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">身份证号</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.motherIdentity"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">配偶姓名</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.mateName"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">身份证号</div>
        <el-input size="small" class="emer-input" v-model="realPeopleQuery.mateIdentity"></el-input>
      </div>
      <div class="emer-row">
        <div class="emer-row-label">服兵役</div>
        <el-radio-group v-model="realPeopleQuery.serveArmy" size="small">
          <el-radio style="color: #ffffff" border label="是"></el-radio>
          <el-radio style="color: #ffffff" border label="否"></el-radio>
        </el-radio-group>
      </div>
    </div>
    <div v-show="isResultShow">
      <el-table class="result-table" :data="queryResult.slice((currentPage - 1) * pagesize,currentPage * pagesize)"
                v-loading="isLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中"
                element-loading-spinner="el-icon-loading" :stripe="true" :fit="false" :highlight-current-row="true"
                size="small" :default-sort="{ prop: 'address.addName', order: 'ascending' }" :cell-style="cellStyle"
                @row-click="rowClick"
      >
        <el-table-column label="姓名" prop="name" width="80px" sortable>
        </el-table-column>
        <el-table-column label="类型" prop="peopleType" width="70px" sortable>
        </el-table-column>
        <el-table-column label="地址" prop="address.addName" width="204px" sortable>
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
        :total="queryResult.length"
      >
      </el-pagination>
    </div>
    <div>
      <el-dialog :visible.sync="dialogPanorama"
                 :modal-append-to-body="false"
                 :destroy-on-close="true"
                 :before-close="closePhotoSphereViewer"
                 custom-class="role-mask">
        <div v-for="(item, index) in panoramas" :key="'pa-' + index">
          <div v-on:click="selectPhoto(item.housePanorama, item.panoramaId)"
               :class="{ active: currentIndex === item.panoramaId }" class="panoramaBtn">
            {{ item.housePattern }}
          </div>
        </div>
        <div id="container" style="margin: auto"></div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {insidePolygon, stringToNumber} from "@/js/CesiumTools";
import map3d from "./map-3d";
import "../js/CesiumPop.js";
import popUtil from "@/utils/pop/popUtil";
import realPeopleInfo from "./real-people-info";
import "../js/CesiumFloor.js";
import {eventBus} from "../main";
import {Viewer} from 'photo-sphere-viewer';
import 'photo-sphere-viewer/dist/photo-sphere-viewer.css';
import {
  getAddressByComName,
  getNetAndCount,
  getNetAndCountById,
  getPeopleBaseById,
  queryNet,
  queryPeoplebase,
  queryPeopleByAddId,
} from "../api/api";

let that;
let comPoints = [];
let handler = handler && handler.destroy();
let kp_overlays3D; //重点人口信息点存储
let kp2_overlays3D = []; //椭球
let pointArr = [];
let rp_overlays3D = [];
let ad_overlays3D = [];
let PSV;

export default {
  name: "real-people",
  data() {
    return {
      realPeopleQuery: {
        name: "",
        onceName: "",
        gender: "",
        height: "",
        isFlow: "",
        isLost: "",
        bloodType: "",
        identity: "",
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
      },
      isQueryShow: true,
      isResultShow: false,
      currentPage: 1, //初始页
      pagesize: 10, //每页的数据
      queryResult: [],
      isLoading: false,
      dialogPanorama: false,
      currentIndex: 0,
      panoramas: [],
    };
  },
  methods: {
    cellStyle(row, column, rowIndex, columnIndex) {
      if (row.column.label === "地址" && row.row.address.addName === "未登记") {
        return "color:#FF747B";
      }
    },
    //根据条件查询网格
    doQuery() {
      this.clearRealPeopleArea();
      this.clearAddress();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      this.isLoading = true;
      let params = this.realPeopleQuery;
      queryPeoplebase(params).then((res) => this.showqueryPeoplebase(res.data));
      this.isQueryShow = false;
      this.isResultShow = true;
    },
    //组织条件查询结果数据
    showqueryPeoplebase(data) {
      console.log(data);
      that.isLoading = false;
      if (data.length !== 0) {
        //没有圈选范围
        if (comPoints.length === 0) {
          let isPoiArr = [];
          for (let i = 0; i < data.length; i++) {
            if (data[i].address.poi !== "") {
              data[i].address.ppId = data[i].ppId;
              isPoiArr.push(data[i].address);
            } else {
              data[i].address.addName = "未登记";
            }
            if (data[i].peopleType === "" || data[i].peopleType === null) {
              data[i].peopleType = "常驻人口";
            }
          }
          that.showQueryKeypeople_3D(isPoiArr);
          that.queryResult = data;
        } else {
          let insidedata = [];
          let insideResult = [];
          for (let i = 0; i < data.length; i++) {
            if (data[i].address.addName !== "" && data[i].address.poi !== "") {
              let poiArr = data[i].address.poi.split(",");
              let testPoi = [Number(poiArr[0]), Number(poiArr[1])];
              if (insidePolygon(comPoints, testPoi)) {
                data[i].address.ppId = data[i].ppId;
                insidedata.push(data[i].address);
                insideResult.push(data[i]);
              }
            }
          }
          if (insidedata.length !== 0) {
            that.showQueryKeypeople_3D(insidedata);
            that.queryResult = insideResult;
          } else {
            that.clearPointsSelect();
            comPoints.length = 0;
            that.$message.error('未获取符合条件人口信息!');
          }
        }
      } else {
        that.$message.error('未获取符合条件人口信息!');
      }
    },
    //显示条件查询结果图形
    showQueryKeypeople_3D(data) {
      this.closeKeypeople_3D();
      this.clearPointsSelect();

      let geojson = {
        type: "FeatureCollection",
        features: [],
      };
      for (let i = 0; i < data.length; i++) {
        let position = data[i].poi.split(",");
        let feature = {
          type: "Feature",
          geometry: {
            type: "Point",
            coordinates: [
              Number(position[0]),
              Number(position[1]),
              Number(position[2]),
            ],
          },
          id: "pp" + data[i].ppId,
          name: "实有人口",
          properties: {
            title: "marker",
            "marker-symbol": "pitch",
            "marker-color": "#8A2BE2",
          },
        };
        geojson.features.push(feature);

        kp2_overlays3D.push(
          viewer.entities.add({
            id: "pe" + data[i].ppId,
            position: Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2])),
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.BLUEVIOLET.withAlpha(0.7),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(10.0, 300.0)
            },
          })
        );
        if (data[i].floorPoi !== null && data[i].floorPoi !== "") {
          let options = {
            viewer: viewer,
            floorType: "fl",
            floorAddId: data[i].addId,
            floorPoi: data[i].floorPoi,
            floorHeight: data[i].floorHeight,
            floorName: data[i].addName,
          };
          CesiumFloor.showFloor(options);
        }
      }

      let promise = Cesium.GeoJsonDataSource.load(geojson, {markerSize: 30});
      let dataSourcePromise = viewer.dataSources.add(promise);
      dataSourcePromise.then(function (dataSource) {
        kp_overlays3D = dataSource;
        dataSource.clustering.enabled = true;
        dataSource.clustering.pixelRange = 25;
        dataSource.clustering.minimumClusterSize = 3;
        let dataSourceEntities = dataSource.entities.values;
        for (let i = 0; i < dataSourceEntities.length; i++) {
          dataSourceEntities[i].billboard = new Cesium.BillboardGraphics({
            image: "static/images/pinimg/20.png",
            scale: 0.8,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            disableDepthTestDistance: 200,
          });
        }
        let removeListener;
        let pinBuilder = new Cesium.PinBuilder();
        let pin50 = pinBuilder.fromText("50+", Cesium.Color.RED, 36).toDataURL();
        let pin40 = pinBuilder.fromText("40+", Cesium.Color.ORANGE, 36).toDataURL();
        let pin30 = pinBuilder.fromText("30+", Cesium.Color.YELLOW, 36).toDataURL();
        let pin20 = pinBuilder.fromText("20+", Cesium.Color.GREEN, 36).toDataURL();
        let pin10 = pinBuilder.fromText("10+", Cesium.Color.BLUE, 36).toDataURL();
        let singleDigitPins = new Array(8);
        for (let i = 0; i < singleDigitPins.length; ++i) {
          singleDigitPins[i] = pinBuilder.fromText("" + (i + 2), Cesium.Color.VIOLET, 36).toDataURL();
        }

        function customStyle() {
          if (Cesium.defined(removeListener)) {
            removeListener();
            removeListener = undefined;
          } else {
            removeListener = dataSource.clustering.clusterEvent.addEventListener(
              function (clusteredEntities, cluster) {
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
                  cluster.billboard.image =
                    singleDigitPins[clusteredEntities.length - 2];
                }
              }
            );
          }
          // force a re-cluster with the new styling
          let pixelRange = dataSource.clustering.pixelRange;
          dataSource.clustering.pixelRange = 0;
          dataSource.clustering.pixelRange = pixelRange;
        }

        // start with custom style
        customStyle();
      });
    },
    //清除条件查询结果图形
    closeKeypeople_3D() {
      for (let i = 0; i < kp2_overlays3D.length; i++) {
        viewer.entities.remove(kp2_overlays3D[i]); // 将标注从场景移除
      }
      kp2_overlays3D.length = 0;
      viewer.dataSources.remove(kp_overlays3D);
      //stopPeopleRoute3D();
      CesiumLayout.clearLayout(viewer);
      map3d.methods.clearClippingPlanes();
    },
    rowClick(row, column, event) {
      if (!document.getElementById("popupDiv" + row.ppId)) {
        this.getRealPeopleById(row.ppId);
      } else {
        this.$message({
          message: '提示，气泡已打开！请勿重复操作！',
          type: 'warning'
        });
      }
    },
    //根据id获取网格的统计信息
    getRealPeopleById(id) {
      let params = {
        ppId: id,
      };
      getPeopleBaseById(params).then((res) =>
        this.showPeopleBaseInfo(res.data)
      );
    },
    //显示网格统计信息的气泡
    showPeopleBaseInfo(data) {
      if (data !== null && data !== [] && data.length !== 0) {
        if (data.address !== null) {
          data.imgurl = common.serverIp + "city3dfile/" + data.imgurl;
          data.address.house.housePhotos = common.serverIp + "city3dfile/" + data.address.house.housePhotos;
          let mid = "", kid = "", vid = "";
          for (let i = 0; i < data.peopleMachines.length; i++) {
            if (data.peopleMachines[i].machineId !== "" && data.peopleMachines[i].machineId !== null) {
              mid = data.peopleMachines[i].machineId
            }
            data.peopleMachines[i].machineImgUrl = common.serverIp + "city3dfile/" + data.peopleMachines[i].machineImgUrl;
          }
          for (let i = 0; i < data.peopleKnifes.length; i++) {
            if (data.peopleKnifes[i].knifeId !== "" && data.peopleKnifes[i].knifeId !== null) {
              kid = data.peopleKnifes[i].knifeId
            }
            data.peopleKnifes[i].knifeImgUrl = common.serverIp + "city3dfile/" + data.peopleKnifes[i].knifeImgUrl;
          }
          for (let i = 0; i < data.peopleVehicles.length; i++) {
            if (data.peopleVehicles[i].vehicleId !== "" && data.peopleVehicles[i].vehicleId !== null) {
              vid = data.peopleVehicles[i].vehicleId
            }
            data.peopleVehicles[i].carImgUrl = common.serverIp + "city3dfile/" + data.peopleVehicles[i].carImgUrl;
          }
          if (mid === "") data.peopleMachines = [];
          if (kid === "") data.peopleKnifes = [];
          if (vid === "") data.peopleVehicles = [];
          for (let i = 0; i < data.address.house.housePanoramas.length; i++) {
            data.address.house.housePanoramas[i].housePanorama = common.serverIp + "city3dfile/" + data.address.house.housePanoramas[i].housePanorama;
          }
          let popoptions = {
            popId: data.ppId,
            rpdata: [data],
          };
          popUtil.installMapPop().rpPop(popoptions);
          let addArr = data.address.poi.split(",");
          let options = {
            viewer: viewer,
            id: data.ppId,
            popupWidth: 477,
            popupHeight: 323,
            pos: {
              lon: Number(addArr[0]),
              lat: Number(addArr[1]),
              alt: Number(addArr[2]),
            },
            extentHeight: 0,
            extentColor: Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, "h");
          let camPoiArr = data.address.camPoi.split(",");
          map3d.methods.moveToWin(
            camPoiArr[0],
            camPoiArr[1],
            camPoiArr[2],
            data.address.camHeading,
            data.address.camPitch
          );
        } else {
          window.realPeopleData = data;
          let options = {
            title: "人口信息",
            message: realPeopleInfo,
            initWidth: "405px",
            initHeight: "355px",
            top: 75,
            left: 1500,
            titleImg: ["fas", "city"],
            options: {
              minWidth: "405px",
              minHeight: "355px",
              fullScreen: true,
              //closeCallback: this.closeCallback,
            },
          };
          that.$installdialog.subPop(options);
        }
      } else {
        this.$message.error('该地址未登记住户!');
      }
    },
    //绘制框选图形
    addPointsHandler() {
      this.clearPointsSelect();

      let activeShapePoints = [];
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
          cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        }
        let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
        let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
        let comPoint = [Number(longitudeString), Number(latitudeString)];
        comPoints.push(comPoint);

        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 3) {
            drawShape();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.endPosition);
          newPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        activeShapePoints.pop();
        activeShapePoints.push(newPosition);
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        pointArr.push(
          viewer.entities.add({
            position: worldPosition,
            point: {
              color: Cesium.Color.RED,
              pixelSize: 10,
              outlineWidth: 1,
              outlineColor: Cesium.Color.WHITE,
              disableDepthTestDistance: 10000,
            },
          })
        );
      }

      function drawShape() {
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        viewer.entities.add({
          id: "comEntity",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            material: new Cesium.ColorMaterialProperty(
              Cesium.Color.RED.withAlpha(0.2)
            ),
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      }
    },
    //清除框选绘制点
    clearPointsSelect() {
      if (viewer.entities.getById("comEntity") !== undefined) {
        viewer.entities.removeById("comEntity");
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      comPoints.length = 0;
      pointArr = [];
      handler = handler && handler.destroy();
    },
    resetForm() {
      this.realPeopleQuery.name = "";
      this.realPeopleQuery.onceName = "";
      this.realPeopleQuery.gender = "";
      this.realPeopleQuery.height = "";
      this.realPeopleQuery.birthday = "";
      this.realPeopleQuery.bloodType = "";
      this.realPeopleQuery.identity = "";
      this.realPeopleQuery.nation = "";
      this.realPeopleQuery.isDrug = "";
      this.realPeopleQuery.peopleType = "";
      this.realPeopleQuery.calture = "";
      this.realPeopleQuery.tel = "";
      this.realPeopleQuery.region = "";
      this.realPeopleQuery.political = "";
      this.realPeopleQuery.marriage = "";
      this.realPeopleQuery.unitName = "";
      this.realPeopleQuery.job = "";
      this.realPeopleQuery.householdNature = "";
      this.realPeopleQuery.householdAddress = "";
      this.realPeopleQuery.fatherName = "";
      this.realPeopleQuery.fatherIdentity = "";
      this.realPeopleQuery.motherName = "";
      this.realPeopleQuery.motherIdentity = "";
      this.realPeopleQuery.mateName = "";
      this.realPeopleQuery.mateIdentity = "";
      this.realPeopleQuery.serveArmy = "";
      this.isQueryShow = true;
      this.isResultShow = false;
      this.queryResult = [];
      this.clearPointsSelect();
      this.closeKeypeople_3D();
      this.dogetNetAndCount();
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    //获取3级-社区级网格，并统计每个网格的相关数据
    dogetNetAndCount() {
      this.clearRealPeopleArea();
      this.clearAddress();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        let params = {
          netLevel: "3",
        };
        getNetAndCount(params).then((res) => {
          this.showRealPeopleArea(res.data);
        });
      } else {
        let params = {
          netLevel: "3",
          netPid: localStorage.getItem("roleId"),
        };
        getNetAndCountById(params).then(res => {
          this.showRealPeopleArea(res.data);
        });
      }
    },
    //绘制网格图形
    showRealPeopleArea(data) {
      let netData = data[0];
      for (let i = 0; i < netData.length; i++) {
        let netArr = stringToNumber(netData[i].netPoi);
        let netColor = new Cesium.Color.fromCssColorString(netData[i].netColor);
        let giid = "3";
        if (netData[i].netLevel === "3") {
          giid = "ra";
        } else {
          giid = "rd";
        }
        let tmpGeometryInstance = new Cesium.GeometryInstance({
          id: giid + netData[i].netId,
          geometry: new Cesium.PolygonGeometry({
            polygonHierarchy: new Cesium.PolygonHierarchy(
              Cesium.Cartesian3.fromDegreesArrayHeights(netArr)
            ),
            extrudedHeight: 5000,
          }),
          attributes: {
            color: Cesium.ColorGeometryInstanceAttribute.fromColor(netColor.withAlpha(0.4)),
          },
        });
        let tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
          geometryInstances: tmpGeometryInstance,
        });
        viewer.scene.primitives.add(tmpClassificationPrimitive);
        rp_overlays3D.push(tmpClassificationPrimitive);

        if (netData[0].netLevel === "3") {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 3 + 2],
            rpNum: data[i * 3 + 1],
            nextLabel: "下辖小区",
            nextNum: data[i * 3 + 3],
            rpaData1: [
              {name: "常住人口", value: "450"},
              {name: "从业人员", value: "382"},
            ],
            rpaData2: [
              {name: "重点人员", value: "37"},
              {name: "监管对象", value: "18"},
              {name: "吸毒人员", value: "11"},
              {name: "上访人员", value: "7"},
              {name: "精神病人员", value: "9"},
            ],
            rpaData3: [
              {name: "楼栋长", value: "66"},
              {name: "单元长", value: "164"},
              {name: "小区长", value: "12"},
              {name: "维稳双联户长", value: "45"},
            ],
            rpaData4: [
              {name: "流入人口", value: "23"},
              {name: "流出人口", value: "16"},
            ],
          };
          popUtil.installMapPop().rpaPop(popoptions);
          let centerArr = netData[i].netCenter.split(",");
          let options = {
            viewer: viewer,
            id: netData[i].netId,
            popupWidth: 240,
            popupHeight: 184,
            pos: {
              lon: Number(centerArr[0]),
              lat: Number(centerArr[1]),
              alt: Number(centerArr[2]),
            },
            extentHeight: 40,
            extentColor: Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        } else {
          let popoptions = {
            popId: netData[i].netId,
            name: netData[i].netName,
            addNum: data[i * 2 + 2],
            rpNum: data[i * 2 + 1],
          };
          popUtil.installMapPop().rpcPop(popoptions);
          let centerArr = netData[i].netCenter.split(",");
          let options = {
            viewer: viewer,
            id: netData[i].netId,
            popupWidth: 110,
            popupHeight: 144,
            pos: {
              lon: Number(centerArr[0]),
              lat: Number(centerArr[1]),
              alt: Number(centerArr[2]),
            },
            extentHeight: 40,
            extentColor: Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options);
        }
      }
    },
    //清除网格图形
    clearRealPeopleArea() {
      for (let i = 0; i < rp_overlays3D.length; i++) {
        viewer.scene.primitives.remove(rp_overlays3D[i]);
      }
      rp_overlays3D.length = 0;
      CesiumPop.clearDivPop(viewer);
    },
    //点击3级图形或点击气泡上的深入箭头获取其下级的几个4级图形和统计数据
    stepInNextLevel(id) {
      this.clearRealPeopleArea();
      CesiumPop.bindPopGlobeEventHandler(viewer);
      let params = {
        netPid: id,
      };
      queryNet(params).then((res) => this.showRealPeopleArea(res.data));
    },
    //点击4级图形或气泡上的深入箭头，获取其下级所有分层分户图形
    stepInCommunity(ComName) {
      this.clearRealPeopleArea();
      let params = {
        communityName: ComName,
      };
      getAddressByComName(params).then((res) => this.showAddress(res.data));
    },
    //绘制分层分户图形
    showAddress(data) {
      for (let i = 0; i < data.length; i++) {
        // 是否需要标识点？需要的话可以打开注释
        // let position = data[i].poi.split(",");
        // ad_overlays3D.push(
        //   viewer.entities.add({
        //     id: "ad" + data[i].addId,
        //     position: Cesium.Cartesian3.fromDegrees(
        //       Number(position[0]),
        //       Number(position[1]),
        //       Number(position[2])
        //     ),
        //     ellipsoid: {
        //       radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
        //       material: Cesium.Color.YELLOW.withAlpha(0.7),
        //     },
        //   })
        // );
        if (data[i].floorPoi !== null && data[i].floorPoi !== "") {
          let options = {
            viewer: viewer,
            floorType: "fl",
            floorAddId: data[i].addId,
            floorPoi: data[i].floorPoi,
            floorHeight: data[i].floorHeight,
            floorName: data[i].addName,
          };
          CesiumFloor.showFloor(options);
        }
      }
    },
    //清除分层分户图形
    clearAddress() {
      for (let i = 0; i < ad_overlays3D.length; i++) {
        viewer.entities.remove(ad_overlays3D[i]);
      }
      ad_overlays3D = [];
      CesiumFloor.removeFloor(viewer);
    },
    //根据地名地址的id获取
    doQueryPeopleByAddId(addId) {
      CesiumPop.bindPopGlobeEventHandler(viewer);
      that.isLoading = true;
      let params = {
        addId: addId,
      };
      queryPeopleByAddId(params).then((res) => {
        this.showQueryPeopleByAddId(res.data);
      });
      that.isQueryShow = false;
      that.isResultShow = true;
    },
    //显示网格统计信息气泡
    showQueryPeopleByAddId(data) {
      that.isLoading = false;
      for (let j = 0; j < data.length; j++) {
        data[j].imgurl = common.serverIp + "city3dfile/" + data[j].imgurl;
        data[j].address.house.housePhotos = common.serverIp + "city3dfile/" + data[j].address.house.housePhotos;
        let mid = "", kid = "", vid = "";
        for (let i = 0; i < data[j].peopleMachines.length; i++) {
          if (data[j].peopleMachines[i].machineId !== "" && data[j].peopleMachines[i].machineId !== null) {
            mid = data[j].peopleMachines[i].machineId
          }
          data[j].peopleMachines[i].machineImgUrl = common.serverIp + "city3dfile/" + data[j].peopleMachines[i].machineImgUrl;
        }
        for (let i = 0; i < data[j].peopleKnifes.length; i++) {
          if (data[j].peopleKnifes[i].knifeId !== "" && data[j].peopleKnifes[i].knifeId !== null) {
            kid = data[j].peopleKnifes[i].knifeId
          }
          data[j].peopleKnifes[i].knifeImgUrl = common.serverIp + "city3dfile/" + data[j].peopleKnifes[i].knifeImgUrl;
        }
        for (let i = 0; i < data[j].peopleVehicles.length; i++) {
          if (data[j].peopleVehicles[i].vehicleId !== "" && data[j].peopleVehicles[i].vehicleId !== null) {
            vid = data[j].peopleVehicles[i].vehicleId
          }
          data[j].peopleVehicles[i].carImgUrl = common.serverIp + "city3dfile/" + data[j].peopleVehicles[i].carImgUrl;
        }
        if (mid === "") data[j].peopleMachines = [];
        if (kid === "") data[j].peopleKnifes = [];
        if (vid === "") data[j].peopleVehicles = [];
        for (let i = 0; i < data[j].address.house.housePanoramas.length; i++) {
          data[j].address.house.housePanoramas[i].housePanorama = common.serverIp + "city3dfile/" + data[j].address.house.housePanoramas[i].housePanorama;
        }
        if (data[j].peopleType === "" || data[j].peopleType === null) {
          data[j].peopleType = "常驻人口";
        }
        if (data[j].address.floorPoi !== null && data[j].address.floorPoi !== "") {
          CesiumFloor.removeFloorById(viewer);
          let options = {
            viewer: viewer,
            floorType: "fl",
            floorAddId: data[j].address.addId,
            floorPoi: data[j].address.floorPoi,
            floorHeight: data[j].address.floorHeight,
          };
          CesiumFloor.showFloorHighLight(options);
        }
      }
      //全家气泡
      let popoptions = {
        "popId": data[0].ppId,
        "rpdata": data,
      };
      popUtil.installMapPop().rpPop(popoptions);
      let addArr = data[0].address.poi.split(",");
      let options = {
        viewer: viewer,
        id: data[0].ppId,
        popupWidth: 477,
        popupHeight: 323,
        pos: {
          lon: Number(addArr[0]),
          lat: Number(addArr[1]),
          alt: Number(addArr[2]),
        },
        extentHeight: 0,
        extentColor: Cesium.Color.WHITE,
      };
      CesiumPop.addDivPop(options, "h");

      that.queryResult = data;
    },
    //清除模块数据
    closeRealPeople() {
      this.clearPointsSelect();
      this.closeKeypeople_3D();
      this.clearRealPeopleArea();
      this.clearAddress();
    },
    //打开全景图播放器
    openPhotoSphereViewer(data) {
      this.panoramas = data;
      this.dialogPanorama = true;
      setTimeout(() => {
        this.selectPhoto(
          this.panoramas[0].housePanorama,
          this.panoramas[0].panoramaId
        );
      }, 500);
    },
    //选择照片
    selectPhoto(panorama, id) {
      if (PSV) {
        let viewerpa = document.querySelector('#container');
        viewerpa.removeChild(viewerpa.childNodes[0]);
      }
      PSV = undefined;
      this.currentIndex = id;
      let div = document.getElementById("container");
      PSV = new Viewer({
        panorama: panorama,
        container: div,
        navbar: true,
        size: {
          width: "910px",
          height: "490px",
        },
      });
      let finalViewer = document.querySelector('#container');
      if (finalViewer.childNodes.length > 1) {
        finalViewer.removeChild(finalViewer.childNodes[0]);
      }
    },
    //关闭全景图播放器
    closePhotoSphereViewer() {
      if (PSV) {
        let viewerpa = document.querySelector('#container');
        viewerpa.removeChild(viewerpa.childNodes[0]);
      }
      PSV = undefined;
      this.panoramas = "";
      this.currentIndex = 0;
      this.dialogPanorama = false;
    },
  },
  mounted() {
    that = this;
    this.dogetNetAndCount();
  },
  created() {
    //通过事件公交浏览全景图
    eventBus.$on("sel_panorama", (msg) => {
      this.openPhotoSphereViewer(msg);
    });
  },
};
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
  right: 120px;
}

.pop-fai-follow:hover {
  background-color: #e0960d;
}

.pop-fai-stop {
  right: 80px;
}

.pop-fai-stop:hover {
  background-color: #e600c3;
}

.emer-row {
  color: #ffffff;
  margin: 8px 0;
  height: 32px;
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

.emer-input-half {
  width: 100px;
  float: left;
}

.result-table {
  width: 100%;
  color: #ffffff;
}

.panoramaBtn {
  color: white;
  width: 60px;
  text-align: center;
  cursor: pointer;
  float: left;
  margin-left: 10px;
  height: 20px;
}
</style>
