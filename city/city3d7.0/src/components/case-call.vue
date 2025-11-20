<template>
  <div id="case-call-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="RHPCPoi" title="指定案件地点">
      <font-awesome-icon :icon="['fas', 'burn']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-clear" v-on:click="closeRHPC" title="清除">
      <font-awesome-icon :icon="['far', 'trash-alt']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">案件名称</div>
      <el-input class="emer-input" v-model="emergencyStr" placeholder="突发案件名称"></el-input>
    </div>
    <div class="my-note">接警类型：110电话/微信/短信/一键报警器</div>
    <div class="emer-row">
      <div class="emer-row-label">监控圈</div>
      <el-input id="eCamRadius" class="emer-input-half" v-model="eCamRadius" placeholder="100"></el-input>
      <div class="emer-row-label" style="margin-left:5px">封控圈</div>
      <el-input id="ePoliceRadius" class="emer-input-half" v-model="ePoliceRadius" placeholder="200"></el-input>
    </div>
    <div class="my-note">红色：应急力量响应区 | 绿色：摄像头应急响应区</div>
    <div class="my-note" v-show="isTellingShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width spin></font-awesome-icon>
      正在通话...
    </div>
    <div style="margin-top: 10px">
      <el-button class="my-button" type="primary" v-on:click="showRHPC">应急</el-button>
      <el-button class="my-button" type="success" v-on:click="commandRHPC">调度</el-button>
      <el-button class="my-button" type="warning" v-on:click="turnOnEarth">投影</el-button>
      <el-button class="my-button" type="primary" v-on:click="doinsertEmergencyCase">保存</el-button>
      <el-button class="my-button" type="danger" v-on:click="stopintercom">停止</el-button>
    </div>
    <div class="my-note">通话人：</div>
    <el-input id="intercom" class="intercom" type="textarea" :rows="5" v-model="intercomStr"></el-input>
    <div class="my-note">
      应急案件范围：国防、安防、警用、暴恐、城管、社区安保、火灾、水灾、突发污染、盗油、盗采、盗伐、交通事故、工程事故、生产事故...
    </div>
  </div>
</template>

<script>
import "../js/CesiumRadarScan.js";
import "../js/CesiumSurvey.js";
import iotVideo from "./iot-video";
import iotCar from "./iot-car";
import iotMan from "./iot-man";
import protectAlarm from "./protect-alarm";
import {bd09towgs84, getFlatternDistance, insidePolygon, s_to_hs} from "@/js/CesiumTools";
import {
  getRHPCCar,
  getRHPCPolice,
  insertEmergencyCase,
  searchPOIJsonp,
  getVideo
} from "../api/api";

//接处警应急：RHPC=receiveHandlePoliceCase
let that;
let movehandler;
let ScanPostStages = [];
let subLable = [];
let caseNameHis;
let rhpcListArray = [];//用于存储摄像头数据
let rhpcCameraPins = [];
let thecam = false;
let commandselectpointArr = [];
let emergencypowerArr = [];
let emergencypowerArrCar = [];
let steplinesArr = [];
let steplabelsArr = [];

export default {
  name: "case-call",
  data() {
    return {
      emergencyStr: "",
      eCamRadius: "100",
      ePoliceRadius: "200",
      isTellingShow: false,
      intercomStr: "",
    }
  },
  methods: {
    //指定三维接处警点
    RHPCPoi() {
      that = this;
      this.stopMovePin();
      this.closeRHPC();
      let emergencyStr = this.emergencyStr;
      if (emergencyStr !== "") {
        //获取鼠标点击处的坐标，创建图标方法
        let RHPChandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        RHPChandler.setInputAction(function (movement) {
          let cartesian = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          //如果没有三维数据，获取地形数据对应的坐标
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            cartesian = viewer.scene.globe.pick(ray, viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          height = cartographic.height;//模型高度
          window.emergencyPosArr = [lng, lat, height];//全局记录报警坐标

          let rhpcPin = viewer.entities.getById("rhpcPinId");
          if (rhpcPin === undefined) {
            let x = 1;
            let flog = true;
            viewer.entities.add({
              id: "rhpcPinId",
              position: cartesian.clone(),
              billboard: {
                image: 'static/images/pinimg/01.png',
                scale: 0.9,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
                color: new Cesium.CallbackProperty(function (time, result) {
                  //图标闪烁效果
                  if (flog) {
                    x = x - 0.02;
                    if (x <= 0) {
                      flog = false;
                    }
                  } else {
                    x = x + 0.02;
                    if (x >= 1) {
                      flog = true;
                    }
                  }
                  return Cesium.Color.WHITE.withAlpha(x);
                }, false),
              }
            });
          } else {
            rhpcPin.position = cartesian.clone();
            //rhpcPin.label.text = emergencyStr;
          }
          that.startMovePin();
          RHPChandler.destroy();
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      } else {
        that.$message.error('错误，请先输入案件名称！');
      }
    },
    //移动图标
    startMovePin() {
      movehandler = movehandler && movehandler.destroy();
      movehandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      let leftDownFlag = false;
      let pointDraged;
      movehandler.setInputAction(function (event) {
        pointDraged = viewer.entities.getById("rhpcPinId");//只选取案件定位图标的entity
        //pointDraged = viewer.scene.pick(event.position);//选取场景中任意鼠标选中的图标的entity
        leftDownFlag = true;
        if (pointDraged) {
          viewer.scene.screenSpaceCameraController.enableRotate = false;//锁定相机
        }
      }, Cesium.ScreenSpaceEventType.LEFT_DOWN);
      movehandler.setInputAction(function (event) {
        leftDownFlag = false;
        pointDraged = null;
        viewer.scene.screenSpaceCameraController.enableRotate = true;//解锁相机
      }, Cesium.ScreenSpaceEventType.LEFT_UP);
      movehandler.setInputAction(function (movement) {
        if (leftDownFlag && pointDraged != null) {
          //获取鼠标点击处的坐标
          let cartesian = viewer.scene.pickPosition(movement.endPosition);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            cartesian = viewer.scene.globe.pick(ray, viewer.scene);
          }
          pointDraged.position = cartesian.clone();//选中案件定位图标时直接用.position
          //pointDraged.id.position = cartesian.clone();//选中任意图标时，需+id
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          height = cartographic.height;//模型高度
          window.emergencyPosArr = [lng, lat, height];
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
    },
    //停止移动报警图标
    stopMovePin() {
      movehandler = movehandler && movehandler.destroy();
      CesiumSurvey.clearHandler();
    },
    //智能应急方法
    showRHPC() {
      if (window.emergencyPosArr.length === 0) {
        this.$message.error('错误，请先定位案件！');
        return;
      } else if (caseNameHis === this.emergencyStr) {
        this.$message.error('错误，案件名称重复，请修改再生成案件！');
        return;
      }
      caseNameHis = this.emergencyStr;
      this.stopMovePin();
      this.clearRHPC();
      let options = [{
        viewer: viewer,
        lon: window.emergencyPosArr[0],
        lat: window.emergencyPosArr[1],
        maxRadius: Number(this.ePoliceRadius),
        duration: 12000,
        scanColor: Cesium.Color.RED
      }, {
        viewer: viewer,
        lon: window.emergencyPosArr[0],
        lat: window.emergencyPosArr[1],
        maxRadius: Number(this.eCamRadius),
        duration: 9000,
        scanColor: Cesium.Color.GREEN
      }];
      ScanPostStages.push(CesiumRadarScan.add(options[0]));//雷达扫描圈
      ScanPostStages.push(CesiumRadarScan.add(options[1]));

      let point1 = Cesium.Cartesian3.fromDegrees(window.emergencyPosArr[0], window.emergencyPosArr[1] + 0.0007, window.emergencyPosArr[2] + 40);
      let point2 = Cesium.Cartesian3.fromDegrees(window.emergencyPosArr[0], window.emergencyPosArr[1] + 0.0016, window.emergencyPosArr[2] + 40);
      let line1 = viewer.entities.add({
        position: point1,
        label: {
          scale: 0.5,
          showBackground: true,
          backgroundColor: Cesium.Color.BLACK.withAlpha(0.8),
          text: "监控圈",
          font: 'bold 40px Helvetica',
          fillColor: Cesium.Color.GREEN,
        }
      });
      let line2 = viewer.entities.add({
        position: point2,
        label: {
          scale: 0.5,
          showBackground: true,
          backgroundColor: Cesium.Color.BLACK.withAlpha(0.8),
          text: "封控圈",
          font: 'bold 40px Helvetica',
          fillColor: Cesium.Color.RED,
        }
      });
      subLable.push(line1);
      subLable.push(line2);

      this.dogetRHPCVideo(window.emergencyPosArr);
      this.dogetRHPCPolice(window.emergencyPosArr);
      this.dogetRHPCCar(window.emergencyPosArr);
      this.isTellingShow = true;
      //执行15秒后，关闭雷达圈
      setTimeout(() => {
        this.clearRHPC();
      }, 15000);
    },
    //接处警应急定位报警写入案件中
    doinsertEmergencyCase() {
      if (window.emergencyPosArr.length === 0) {
        this.$message.error('错误，请先定位案件！');
        return;
      } else if ("" === this.emergencyStr) {
        this.$message.error('错误，请先输入案件名称！');
        return;
      }
      let params = {
        "caseName": this.emergencyStr,
        "casePosition": window.emergencyPosArr.join(',')
      };
      insertEmergencyCase(params).then(res => {
        if (res.data === 1) {
          this.$message.success('定位报警已记录，请在管理后台完善案件后续信息！');
        }
      });
    },
    //获取范围内视频
    dogetRHPCVideo(position) {
      let pts = position.toString().split(',');
      let params = {
        isIndoor: "false"
      };
      getVideo(params).then(res => {
        this.clearrhpcVideo();
        CesiumPop.bindPopGlobeEventHandler(viewer);

        let data = res.data;
        for (let i = 0; i < data.length; i++) {
          if (!data[i].camIsnode) {
            let positions = data[i].camPosition.split(',');
            let dis = getFlatternDistance(Number(positions[0]), Number(positions[1]), Number(pts[0]), Number(pts[1]));
            if (dis <= Number(this.eCamRadius)) {
              rhpcListArray.push(data[i]);
              //绘制相机图标
              let point = Cesium.Cartesian3.fromDegrees(Number(positions[0]), Number(positions[1]), Number(positions[2]));
              Promise.resolve(
                new Cesium.PinBuilder().fromUrl(Cesium.buildModuleUrl('../assets/camera1.png'), Cesium.Color.BLUEVIOLET, 36)
              ).then(function (canvas) {
                rhpcCameraPins.push(viewer.entities.add({
                  name: '摄像头',
                  id: 'rc' + data[i].id,
                  position: point,
                  billboard: {
                    image: canvas.toDataURL(),
                    verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                    scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.3),
                    pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.3),
                  },
                }));
              });
              //开启对应相机转码
              iotVideo.methods.dostartVideoConverter(data[i], true);
            }
          }
        }
      });
    },
    //获取范围内人员
    dogetRHPCPolice(position) {
      getRHPCPolice().then(res => {
        let data = res.data;
        let deviceList = [];
        for (let i = 0; i < data.length; i++) {
          let dis = getFlatternDistance(Number(position[0]), Number(position[1]), Number(data[i].longitude), Number(data[i].latitude));
          if (dis <= Number(this.ePoliceRadius)) {
            deviceList.push(data[i]);
          }
        }
        that.startintercom(deviceList, 'police');
        iotMan.methods.showPoliceMan(deviceList);
      });
    },
    //获取范围内车辆
    dogetRHPCCar(position) {
      getRHPCCar().then(res => {
        let data = res.data;
        let carEmresult = [];
        for (let i = 0; i < data.length; i++) {
          if (data[i].realdata !== undefined) {
            let dis = getFlatternDistance(Number(position[0]), Number(position[1]), Number(data[i].realdata.longitude), Number(data[i].realdata.latitude));
            if (dis <= Number(this.ePoliceRadius)) {
              carEmresult.push(data[i]);
            }
          }
        }
        that.startintercom(carEmresult, '');
        iotCar.methods.showPoliceCar(carEmresult);
      });
    },
    //清除报警区效果
    clearRHPC() {
      CesiumRadarScan.removes(viewer, ScanPostStages);
      for (let i = 0; i < subLable.length; i++) {
        viewer.entities.remove(subLable[i]); // 将标注从场景移除
      }
    },
    //切换贴地或气泡两种视频播放模式
    turnOnEarth() {
      if (thecam) {
        for (let i = 0; i < rhpcListArray.length; i++) {
          iotVideo.methods.dostartVideoConverter(rhpcListArray[i], true);
          iotVideo.methods.clearVideoOnEarth(rhpcListArray[i].id);
        }
        thecam = false;
      } else {
        for (let i = 0; i < rhpcListArray.length; i++) {
          iotVideo.methods.dostartVideoConverter(rhpcListArray[i], false);
          CesiumPop.removeDivPopById(viewer, rhpcListArray[i].id);
        }
        thecam = true;
      }
    },
    //关闭全部应急内容
    clearEmergency() {
      iotCar.methods.clearPoliceCar3DMarks();
      iotCar.methods.carHisStop();
      iotMan.methods.deletePoliceManMarks();
      CesiumPop.clearDivPop(viewer);
      this.clearrhpcVideo();
      this.clearCommandSelect();
      this.stopintercom();
      this.clearRouteLines();
      viewer.entities.removeById("rhpcPinId");//清除pin标记
      this.clearRHPC();
      window.emergencyPosArr = [];
    },
    //清除视频标签和气泡
    clearrhpcVideo() {
      if (rhpcCameraPins.length !== 0) {
        for (let i = 0; i < rhpcCameraPins.length; i++) {
          viewer.entities.remove(rhpcCameraPins[i]);
        }
        rhpcCameraPins = [];
      }
      if (rhpcListArray.length !== 0) {
        for (let int = 0; int < rhpcListArray.length; int++) {
          let vid = "video" + rhpcListArray[int].id;
          let videoElement = document.getElementById(vid);
          if (videoElement != null) {
            iotVideo.methods.destroyVideoElement(videoElement);
          }
          iotVideo.methods.destroyCameraVideo(vid);
          iotVideo.methods.dostopVideoConvertor(rhpcListArray[int].id);
        }
        rhpcListArray = [];
        CesiumPop.clearDivPop(viewer);
      }
    },
    // 清除调度
    clearCommandSelect() {
      if ((viewer.entities.getById('comEntity') !== undefined)) {
        viewer.entities.removeById('comEntity');
      }
      for (let i = 0; i < commandselectpointArr.length; i++) {
        viewer.entities.remove(commandselectpointArr[i]);
      }
      commandselectpointArr = [];
    },
    //停止调度绘制监听
    stopHanlderD() {
      handlerDispatch = handlerDispatch && handlerDispatch.destroy();
    },
    //调度方法
    commandRHPC() {
      this.clearCommandSelect();
      let activeShapePoints = [];
      let comPoints = [];

      function createPoint(worldPosition) {
        if (worldPosition.x) {
          commandselectpointArr.push(viewer.entities.add({
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
      }

      function drawPolygon() {
        if ((viewer.entities.getById('comEntity') !== undefined)) {
          viewer.entities.removeById('comEntity');
        }
        viewer.entities.add({
          id: 'comEntity',
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
              return activeShapePoints;
          }, false),*/
            material: new Cesium.ColorMaterialProperty(Cesium.Color.GREEN.withAlpha(0.3)),
            classificationType: Cesium.ClassificationType.BOTH,
            outline: true,
            outlineColor: Cesium.Color.WHITE
          }
        });
      }

      handlerDispatch = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handlerDispatch.setInputAction(function (movement) {
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
        let comPoint = [Number(longitudeString), Number(latitudeString)];
        comPoints.push(comPoint);
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 3) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handlerDispatch.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        if (newPosition) {
          let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            newPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          activeShapePoints.pop();
          activeShapePoints.push(newPosition);
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handlerDispatch.setInputAction(function (movement) {
        handlerDispatch = handlerDispatch && handlerDispatch.destroy();
        if (activeShapePoints.length > 2) {
          drawPolygon();
          that.doselectCommandCar(comPoints);//向后台请求数据，并计算符合条件的数据police
          that.doselectCommandPolice(comPoints);//向后台请求数据，并计算符合条件的数据car
          that.clearCommandSelect();
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    //调度车辆
    doselectCommandCar(comPoints) {
      getRHPCCar().then(res => {
        let data = res.data;
        if (data !== undefined) {
          let insidedata = [];
          let insidedataCar = [];
          for (let i = 0; i < data.length; i++) {
            if (data[i].realdata !== undefined) {
              let testPoi = [Number(data[i].realdata.longitude), Number(data[i].realdata.latitude)];
              //判断是否在选框内
              if (insidePolygon(comPoints, testPoi)) {
                insidedataCar.push(data[i]);
                insidedata.push(data[i]);
              }
            }
          }
          if (insidedata.length !== 0) {
            iotCar.methods.showPoliceCar(insidedata);//车辆定位图标
            that.startintercom(insidedataCar);//选中并填入正在对讲人的车牌
            that.showRoadNavs(insidedataCar);//显示多个路径导航
          } else {
            that.clearrhpcVideo();
            that.$message({
              message: '提示，没有选中车辆警力！',
              type: 'warning'
            });
          }
        }
      });
    },
    //调度人员
    doselectCommandPolice(comPoints) {
      getRHPCPolice().then(res => {
        let data = res.data;
        if (data !== undefined) {
          let insidedata = [];
          for (let i = 0; i < data.length; i++) {
            let testPoi = [Number(data[i].longitude), Number(data[i].latitude)];
            //判断是否在选框内
            if (insidePolygon(comPoints, testPoi)) {
              insidedata.push(data[i]);
            }
          }
          if (insidedata.length !== 0) {
            iotMan.methods.showPoliceMan(insidedata);//人员定位图标
            that.startintercom(insidedata, 'police');//选中并填入正在对讲人的姓名
            that.showRoadNavs(insidedata);//显示多个路径导航
          } else {
            that.clearrhpcVideo();
            that.$message({
              message: '提示，没有选中人员警力！',
              type: 'warning'
            });
          }
        }
      });
    },
    //开启对讲
    startintercom(data, type) {
      let curintercom = '';
      if (type === 'police') {
        for (let i = 0; i < data.length; i++) {
          if (!emergencypowerArr.some(item => item.deviceNum === data[i].deviceNum)) {
            curintercom += data[i].name + '(' + data[i].origin + ')' + ' | ';
            emergencypowerArr.push(data[i]);
          }
        }
      } else {
        for (let i = 0; i < data.length; i++) {
          if (!emergencypowerArrCar.some(item => item.car.carLicense === data[i].car.carLicense)) {
            curintercom += data[i].car.carLicense + ' | ';
            emergencypowerArrCar.push(data[i]);
          }
        }
      }
      this.intercomStr += curintercom;
    },
    //停止对讲
    stopintercom() {
      emergencypowerArr = [];
      emergencypowerArrCar = [];
      this.isTellingShow = false;
      this.clearCommandSelect();
      this.clearRouteLines();
      this.intercomStr = "";
    },
    //路径分析
    showRoadNavs(data) {
      if (window.emergencyPosArr.length !== 0) {
        this.clearRouteLines();
        for (let i = 0; i < data.length; i++) {
          let longitude = data[i].realdata === undefined ? data[i].longitude : data[i].realdata.longitude;
          let latitude = data[i].realdata === undefined ? data[i].latitude : data[i].realdata.latitude;
          let startpoi = latitude + ',' + longitude;
          let endpoi = window.emergencyPosArr[1] + ',' + window.emergencyPosArr[0];
          let url = "http://api.map.baidu.com/direction/v2/driving?origin="
            + startpoi + "&destination=" + endpoi + "&coord_type=wgs84&tactics=5"
            + "&alternatives=0&ak=ZpRjzwQe7dQCVzTR9zytcdLO";
          searchPOIJsonp(url, this.showRouteLines);
        }
      } else {
        this.$message.error('错误！请定位案发或嫌犯位置！');
      }
    },
    //绘制导航路线
    showRouteLines(err, data) {
      if (data.status === 0) {
        for (let i = 0; i < data.result.routes[0].steps.length; i++) {
          let step = data.result.routes[0].steps[i];
          let pathArr = step.path.split(/[,;]/);
          let wgs84pathArr = [];
          for (let m = 0; m < pathArr.length; m = m + 2) {
            let wgs84poi = bd09towgs84(pathArr[m], pathArr[m + 1]);
            wgs84pathArr.push(wgs84poi);
          }
          let traConCount = 0;
          for (let j = 0; j < step.traffic_condition.length; j++) {
            let traCon = step.traffic_condition[j];
            let trafficStr = "";
            let roadColor = Cesium.Color.YELLOW;
            switch (traCon.status) {
              case 0:
                trafficStr = "无路况";
                roadColor = Cesium.Color.YELLOW;
                break;
              case 1:
                trafficStr = "畅通";
                roadColor = Cesium.Color.CHARTREUSE;
                break;
              case 2:
                trafficStr = "缓行";
                roadColor = Cesium.Color.ORANGE;
                break;
              case 3:
                trafficStr = "拥堵";
                roadColor = Cesium.Color.RED;
                break;
              case 4:
                trafficStr = "非常拥堵";
                roadColor = Cesium.Color.DARKRED;
                break;
              default:
                break;
            }
            let subwgs84pathArr = wgs84pathArr.slice(traConCount, traConCount + traCon.geo_cnt + 1);
            let linesubwgs84pathArr = [];
            for (let n = 0; n < subwgs84pathArr.length; n++) {
              linesubwgs84pathArr.push(subwgs84pathArr[n][0], subwgs84pathArr[n][1]);
            }
            let stepline = viewer.entities.add({
              polyline: {
                positions: Cesium.Cartesian3.fromDegreesArray(linesubwgs84pathArr),
                width: 8,
                material: new Cesium.PolylineOutlineMaterialProperty({
                  color: roadColor,
                  outlineWidth: 2,
                  outlineColor: Cesium.Color.BLACK
                }),
                clampToGround: true,
                classificationType: Cesium.ClassificationType.BOTH
              },
            });
            steplinesArr.push(stepline);
            let point = Cesium.Cartesian3.fromDegrees(
              Number(subwgs84pathArr[0][0]), Number(subwgs84pathArr[0][1]), 138);
            let clampedpoint = viewer.scene.clampToHeight(point);
            let steptext = '';
            if (traConCount === 0) {
              steptext = step.road_name + ' | ' + traCon.distance + '米 | ' + trafficStr;
            } else {
              steptext = traCon.distance + '米 | ' + trafficStr;
            }
            if (i === 0) {
              let hs = s_to_hs(Number(data.result.routes[0].duration));
              steptext += "\n到警时间预测：" + hs;
              let steplabel = viewer.entities.add({
                position: clampedpoint,
                label: {
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                  font: 'bold 30px Helvetica',
                  scale: 0.5,
                  fillColor: Cesium.Color.WHITE,
                  style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                  outlineColor: Cesium.Color.BLACK,
                  outlineWidth: 1,
                  text: steptext,
                  showBackground: true,
                  backgroundColor: new Cesium.Color.fromCssColorString("#01adcd").withAlpha(0.8),
                  backgroundPadding: new Cesium.Cartesian2(30, 15),
                  disableDepthTestDistance: 100000000,
                  pixelOffset: new Cesium.Cartesian2(0, -35.0),
                  scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                  pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                }
              });
              steplabelsArr.push(steplabel);
              traConCount = traConCount + traCon.geo_cnt;
              break;
            }
          }
        }
      } else {
        this.$message.error('路径导航服务请求失败，请重试!');
      }
    },
    //清除路径
    clearRouteLines() {
      for (let i = 0; i < steplinesArr.length; i++) {
        viewer.entities.remove(steplinesArr[i]);
      }
      steplinesArr.length = 0;
      for (let j = 0; j < steplabelsArr.length; j++) {
        viewer.entities.remove(steplabelsArr[j]);
      }
      steplabelsArr.length = 0;
    },
    //关闭应急窗口
    closeRHPC() {
      this.clearEmergency();
      protectAlarm.methods.stopFaceAlarm();
    },
  }, mounted() {
    window.handlerDispatch = null;
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>
.emer-row {
  color: #ffffff;
  margin: 8px 0;
}

.emer-row-label {
  width: 75px;
  font-size: 16px;
  margin-top: 8px;
  float: left;
}

.emer-input {
  width: 280px;
}

.emer-input-half {
  width: 100px;
  float: left;
}

.intercom {
  margin-top: 5px;
  height: 120px;
}

.my-note {
  color: #ffffff;
  margin: 5px 0 0 0;
}

.my-button {
  padding: 8px 13px;
  font-size: 15px;
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

.pop-fai-clear {
  right: 80px;
}

.pop-fai-clear:hover {
  background-color: #e6002f;
}

</style>
