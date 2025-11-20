<template>
  <div id="iot-car-is-show">
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
import ztree from "vue-giant-tree";
import map3d from "./map-3d";
import "../js/CesiumPop.js";
import popUtil from "../utils/pop/popUtil";
import videoContainer from "./video-container";
import {
  getAllandCarById,
  getAllCars,
  getCarAndEquipmentsByPuid,
  getCarRealgpsByPhone,
  getPoliceCarRealDataPart
} from "../api/api";

let that;
let deviceListCar = [];
let policeCarInterval;
let policecar3D_marks = [];
let policeCar_points = [];

//添加轨迹线和实体等
let policecarLine;
let policecar_mark;
let policecar_mark_start;
let policecar_mark_end;
let listener;

let carVideoPlayerArr = [];

export default {
  name: "iot-car",
  components: {
    ztree
  },
  data() {
    return {
      setting: {},
      nodes: []
    }
  },
  methods: {
    //初始化创建车辆目录树
    createZTree(data) {
      //目录树配置
      this.setting = {
        check: {
          enable: true,
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0"
          }
        },
        callback: {
          onCheck: carLayerzTreeOnCheck,
          onClick: carLayerzTreeOnClick,
        },
        view: {
          showIcon: true,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [{
        id: 0,
        pid: "",
        name: "车辆目录",
        isNode: false,
        open: true,
        icon: "static/images/treeicon/subject.png",
        nocheck: true
      }];
      for (let i = 0; i < data.length; i++) {
        let node = {};
        node.id = data[i].carId;
        node.pid = 0;
        node.name = data[i].policeType + '(' + data[i].carLicense + ')';
        node.highlight = false;
        node.isNode = true;
        node.phone = data[i].cardNum;
        node.icon = "static/images/treeicon/car1.png";
        treeNodes.push(node);
      }
      this.nodes = treeNodes;

      //点击车辆check执行
      function carLayerzTreeOnCheck(event, treeId, treeNode) {
        if (treeNode.level !== 0) {
          let result = [];
          if (treeNode.name !== undefined) {
            result = treeNode.name.match(/\(([^)]*)\)/);
          }
          if (treeNode.checked) {
            if (deviceListCar.length === 0 || deviceListCar.indexOf(result[1]) === -1) {
              deviceListCar.push(result[1]);
              freshPoliceCarPos(deviceListCar);
            }
          } else {
            deviceListCar.splice(deviceListCar.indexOf(result[1]), 1);
            viewer.entities.removeById('pc' + treeNode.id);
            CesiumPop.removeDivPopById(viewer, treeNode.id);
          }
        }
      }

      //目录树点击定位方法
      function carLayerzTreeOnClick(event, treeId, treeNode) {
        let phone = treeNode.phone;
        let params = {
          "cardNum": phone
        };
        getCarRealgpsByPhone(params).then(res => {
          let data = res.data;
          if (data !== null) {
            let position = [Number(data[0].longitude), Number(data[0].latitude), Number(500)];
            map3d.methods.flyToLocation(position);
          }
        });
      }

      policeCarInterval = window.setInterval(function () {
        freshPoliceCarPos(deviceListCar);
      }, 10000);
      freshPoliceCarPos(deviceListCar);

      function freshPoliceCarPos(carLicenses) {
        if (policeCarInterval !== undefined) {
          if (carLicenses.length === 0) {
            that.clearPoliceCar3DMarks();
            return;
          }
          let args = {
            "carLicenses": carLicenses
          };
          getPoliceCarRealDataPart(args).then(res => {
            if (policeCarInterval) {
              that.showPoliceCar(res.data)
            }
          });
        } else {
          that.clearPoliceCar3DMarks();
        }
      }
    },
    //创建全部车辆地图标签
    showPoliceCar(data) {
      let url = '';
      let urlHalo = '';
      for (let i = 0; i < data.length; i++) {
        let carId = data[i].car.carId;
        let carLicense = data[i].car.carLicense;
        let cartype = data[i].car.policeType;
        if (data[i].realdata !== undefined) {
          let point = Cesium.Cartesian3.fromDegrees(Number(data[i].realdata.longitude), Number(data[i].realdata.latitude), Number(data[i].realdata.altitude));
          let clampedpoint = viewer.scene.clampToHeight(point);//将悬空的点落到三维或地形数据上
          // let height = Cesium.Cartographic.fromCartesian(clampedpoint).height;
          switch (cartype) {
            case '巡逻车':
              url = 'static/images/pinimg/13.png';
              urlHalo = 'static/images/halo/circle_bg.png';
              break;
            case '警卫车':
              url = 'static/images/pinimg/15.png';
              urlHalo = 'static/images/halo/circle_bg.png';
              break;
            case '防爆装甲车':
              url = 'static/images/pinimg/14.png';
              urlHalo = 'static/images/halo/circle_bg.png';
              break;
            default:
              url = 'static/images/pinimg/16.png';
              urlHalo = 'static/images/halo/circle_bg.png';
              break;
          }
          createPoliceCarPin(url, carId, clampedpoint, carLicense, urlHalo, data[i].realdata);
          //如有气泡，更新气泡位置
          if (document.getElementById("popupDiv" + carId)) {
            let pos = {
              "lon": Number(data[i].realdata.longitude),
              "lat": Number(data[i].realdata.latitude),
              "alt": Number(data[i].realdata.altitude)
            };
            CesiumPop.updatePopPos(viewer, carId, pos, 30, 300, 215, Cesium.Color.WHITE);
          }
        }
      }

      function createPoliceCarPin(url, id, point, carLicense, urlHalo, haloRect) {
        let rotation = Cesium.Math.toRadians(0);

        function getRotationValue() {
          rotation += 0.015;
          return rotation;
        }

        let carPin = viewer.entities.getById('pc' + id);
        if (carPin === undefined) {
          let x = 15;
          let flog = true;
          policecar3D_marks.push(viewer.entities.add({
            name: '车辆',
            id: 'pc' + id,
            position: point,
            billboard: {
              image: url,
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffset: new Cesium.CallbackProperty(function (time, result) {
                //图标闪烁效果
                if (flog) {
                  x -= 0.3;
                  if (x <= 0) {
                    flog = false;
                  }
                } else {
                  x += 0.3;
                  if (x >= 15) {
                    flog = true;
                  }
                }
                return new Cesium.Cartesian2(0.0, x);
              }, false),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(50, 100000000)
            },
            label: {
              show: true,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: 'bold 48px Helvetica',
              scale: 0.5,
              style: Cesium.LabelStyle.FILL_AND_OUTLINE,
              outlineColor: Cesium.Color.fromCssColorString("#03a975"),
              outlineWidth: 3,
              fillColor: Cesium.Color.WHITE,
              text: carLicense,
              pixelOffset: new Cesium.Cartesian2(0.0, -125.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            },
            model: {
              uri: common.serverIp + "city3dfile/" + "data/model/car/jingche_a.gltf",
              scale: 1,
              imageBasedLightingFactor: new Cesium.Cartesian2(2.0, 1.0),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 300)
            },
            rectangle: {
              coordinates: Cesium.Rectangle.fromDegrees(
                Number(haloRect.longitude) - 0.00003,
                Number(haloRect.latitude) - 0.00003,
                Number(haloRect.longitude) + 0.00003,
                Number(haloRect.latitude) + 0.00003),
              material: new Cesium.ImageMaterialProperty({
                image: urlHalo,
                transparent: true,
              }),
              rotation: new Cesium.CallbackProperty(getRotationValue, false),
              stRotation: new Cesium.CallbackProperty(getRotationValue, false),
              classificationType: Cesium.ClassificationType.BOTH,
            },
          }));
        } else {
          carPin.position = point;
          carPin.rectangle.coordinates = Cesium.Rectangle.fromDegrees(
            Number(haloRect.longitude) - 0.00003,
            Number(haloRect.latitude) - 0.00003,
            Number(haloRect.longitude) + 0.00003,
            Number(haloRect.latitude) + 0.00003);
        }
      }
    },
    //停止车辆位置更新
    stopFreshPoliceCarPos() {
      window.clearInterval(policeCarInterval);
      policeCarInterval = undefined;
    },
    //清除车辆标签
    clearPoliceCar3DMarks() {
      for (let i = 0; i < policecar3D_marks.length; i++) {
        viewer.entities.remove(policecar3D_marks[i]); // 将标注从场景移除
        CesiumPop.removeDivPopById(viewer, policecar3D_marks[i].id.substring(2));
      }
      policecar3D_marks.length = 0;
      deviceListCar.length = 0;//清除车辆数组
    },
    //获取单个车辆信息并弹出气泡
    getPoliceCarById(id, pos) {
      viewer.entities.getById('pc' + id).show = false;
      let args = {
        "carId": id
      };
      getCarAndEquipmentsByPuid(args).then(res => {
        let data = res.data;
        let num = 0;
        let dataCE = data.CarEquipments;
        if (dataCE !== undefined && dataCE !== null) {
          for (let i = 0; i < dataCE.length; i++) {
            num += Number(dataCE[i].equipment.equipmentGrade);
            dataCE[i].equipment.equipmentPicture = common.serverIp + "city3dfile/" + dataCE[i].equipment.equipmentPicture;
          }
        }
        let popcolor = '';
        switch (data.policeType) {
          case '防爆装甲车':
            popcolor = '#00d3e7';
            break;
          case '巡逻车':
            popcolor = '#FF6A6A';
            break;
          case '武装巡逻车':
            popcolor = '#836FFF';
            break;
          case '警卫车':
            popcolor = '#FFD700';
            break;
          default:
            break;
        }
        let directionStr = '';
        if (Number(data.direction) >= 0 && Number(data.direction) < 22.5) {
          directionStr = '北';
        } else if (Number(data.direction) >= 22.5 && Number(data.direction) < 67.5) {
          directionStr = '东北';
        } else if (Number(data.direction) >= 67.5 && Number(data.direction) < 112.5) {
          directionStr = '东';
        } else if (Number(data.direction) >= 112.5 && Number(data.direction) < 157.5) {
          directionStr = '东南';
        } else if (Number(data.direction) >= 157.5 && Number(data.direction) < 202.5) {
          directionStr = '南';
        } else if (Number(data.direction) >= 202.5 && Number(data.direction) < 247.5) {
          directionStr = '西南';
        } else if (Number(data.direction) >= 247.5 && Number(data.direction) < 292.5) {
          directionStr = '西';
        } else if (Number(data.direction) >= 292.5 && Number(data.direction) < 337.5) {
          directionStr = '西北';
        } else if (Number(data.direction) >= 337.5 && Number(data.direction) < 360) {
          directionStr = '北';
        } else {
          directionStr = '数据错误';
        }
        let cartographic = Cesium.Cartographic.fromCartesian(pos);
        let lon = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        let popoptions = {
          popId: data.carId,
          carLicense: data.carLicense,
          policeType: data.policeType,
          carDate: data.carDate,
          driver: data.driver,
          carStyle: data.carStyle,
          cardNum: data.cardNum,
          num: num.toFixed(1),
          imageUrl: common.serverIp + "city3dfile/" + data.image,
          color: popcolor,
          equipArr: dataCE,
          updateDate: data.updateDate,
          velocity: data.velocity,
          direction: directionStr,
          gas: data.gas,
          mileage: data.mileage
        };
        popUtil.installMapPop().carPop(popoptions);
        let options = {
          "viewer": viewer,
          "id": data.carId,
          "popupWidth": 300,
          "popupHeight": 215,
          "pos": {"lon": Number(lon), "lat": Number(lat), "alt": Number(cartographic.height)},
          "extentHeight": 30,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);
      });
    },
    //历史轨迹回放
    carHisPlay(data, velocity) {
      document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "block";
      document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "block";
      let traceList = [];
      data.map(item => {
        traceList.push(Number(item.longitude));
        traceList.push(Number(item.latitude));
        traceList.push(Number(item.altitude) + 5);
      });
      let position = [Number(data[0].longitude), Number(data[0].latitude), 500];
      map3d.methods.flyToLocation(position);

      let startTime = Cesium.JulianDate.fromDate(new Date(data[0].sendTime));
      let stopTime = Cesium.JulianDate.fromDate(new Date(data[data.length - 1].sendTime));
      viewer.clock.startTime = startTime;
      viewer.clock.stopTime = stopTime;
      viewer.clock.currentTime = startTime;
      viewer.clock.clockRange = Cesium.ClockRange.CLAMPED;
      viewer.clock.multiplier = 10;
      viewer.timeline.zoomTo(startTime, stopTime);

      createCarLines(traceList, data[0].simNo, data);

      function createCarLines(nodes, lineId, data) {
        //添加轨迹线
        policecarLine = viewer.entities.add({
          polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(nodes),
            width: 4.0,
            material: new Cesium.PolylineDashMaterialProperty({
              color: Cesium.Color.VIOLET.withAlpha(0.8),
            }),
            clampToGround: true,
            classificationType: Cesium.ClassificationType.BOTH
          }
        });
        //添加移动实体
        let nodesPosition = [];
        let times = [];
        for (let i = 0; i < nodes.length / 3; i++) {
          let time = Cesium.JulianDate.fromDate(new Date(data[i].sendTime));
          times.push(time);
          let point = Cesium.Cartesian3.fromDegrees(nodes[i * 3], nodes[i * 3 + 1], nodes[i * 3 + 2]);
          nodesPosition.push(point);
          let clampedpoint = viewer.scene.clampToHeight(point);
          let timeTextArr = data[i].sendTime.split(" ");
          policeCar_points.push(
            viewer.entities.add({
              position: clampedpoint,
              point: {
                show: i % 5 === 0,
                pixelSize: 5,
                color: Cesium.Color.ORANGERED,
                outlineColor: Cesium.Color.WHITE,
                outlineWidth: 2,
                disableDepthTestDistance: 100000000,
              },
              label: {
                show: i % 10 === 0,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                text: timeTextArr[0] + '\n' + timeTextArr[1] + '\n速度：' + data[i].velocity + '\n里程：' + data[i].mileage + '\n油量：' + data[i].gas,
                font: 'bold 26px Helvetica',
                scale: 0.5,
                style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                fillColor: Cesium.Color.ORANGERED,
                outlineColor: Cesium.Color.WHITE,
                outlineWidth: 8,
                disableDepthTestDistance: 100000000,
                pixelOffset: new Cesium.Cartesian2(0, -50.0),
              }
            })
          );
        }
        //插值
        let property = new Cesium.SampledPositionProperty();
        property.addSamples(times, nodesPosition);
        let orientationproperty = new Cesium.VelocityOrientationProperty(property);// 计算朝向
        let pinBuilder = new Cesium.PinBuilder();
        Promise.resolve(
          pinBuilder.fromUrl('static/images/car.png', Cesium.Color.ORANGERED, 48)
        ).then(function (canvas) {
          policecar_mark = viewer.entities.add({
            id: lineId,
            position: property,
            orientation: orientationproperty,
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scale: 1,
              //大于20000显示pin，隐藏模型
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 100000),//2000
            },
            // model: {
            //   uri: 'static/model/car/jingche_a.gltf',
            //   minimumPixelSize: 128,
            //   maximumScale: 20,
            //   scale: 0.02,
            //   //小于20000显示模型，隐藏pin
            //   distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 4000),
            //   imageBasedLightingFactor : new Cesium.Cartesian2(3, 1),
            // }
          });
        });
        //起点
        let startpoint = Cesium.Cartesian3.fromDegrees(Number(nodes[0]), Number(nodes[1]), Number(nodes[2]));
        policecar_mark_start = viewer.entities.add({
          position: startpoint,
          billboard: {
            image: pinBuilder.fromText('起', Cesium.Color.GREEN, 40).toDataURL(),
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          }
        });
        //终点
        let endpoint = Cesium.Cartesian3.fromDegrees(Number(nodes[nodes.length - 3]), Number(nodes[nodes.length - 2]), Number(nodes[nodes.length - 1]));
        policecar_mark_end = viewer.entities.add({
          position: endpoint,
          billboard: {
            image: pinBuilder.fromText('终', Cesium.Color.RED, 40).toDataURL(),
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          }
        });
        //轨迹
        let pathPosition1 = new Cesium.SampledPositionProperty();
        viewer.entities.add({
          id: 'carPath',
          position: pathPosition1,
          path: {
            show: true,
            leadTime: 0,
            trailTime: 6000000000,
            width: 7,
            resolution: 1,
            material: new Cesium.PolylineGlowMaterialProperty({
              color: Cesium.Color.ORANGE,
              glowPower: 0.4
            }),
            // new Cesium.PolylineDashMaterialProperty({
            //   color: Cesium.Color.YELLOW
            // })
          },
        });

        //轨迹投影
        let newWallPoint = startpoint;
        let wallPosArr = [newWallPoint];
        let wallMinArr = [0];
        //投影轨迹增长
        viewer.entities.add({
          id: 'carPathWall',
          wall: {
            positions: new Cesium.CallbackProperty(function () {
              wallPosArr.push(newWallPoint);
              return wallPosArr;
            }, false),
            minimumHeights: new Cesium.CallbackProperty(function () {
              wallMinArr.push(0);
              return wallMinArr;
            }, false),
            material: Cesium.Color.LIMEGREEN.withAlpha(0.4)
          },
        });

        listener = function (scene, time) {
          if (policecar_mark && policecar_mark.position._property && policecar_mark.position._property._interpolationResult[0]) {
            let interPosArr1 = policecar_mark.position._property._interpolationResult;
            let interPos1 = Cesium.Cartesian3.fromElements(interPosArr1[0], interPosArr1[1], interPosArr1[2]);
            pathPosition1.addSample(viewer.clock.currentTime, interPos1);
            newWallPoint = interPos1;
          }
        };
        viewer.scene.preUpdate.addEventListener(listener);
      }
    },
    //历史轨迹停止
    carHisStop() {
      document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "none";
      document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "none";
      viewer.scene.preUpdate.removeEventListener(listener);
      viewer.entities.remove(policecarLine);
      viewer.entities.remove(policecar_mark);
      viewer.entities.remove(policecar_mark_start);
      viewer.entities.remove(policecar_mark_end);
      viewer.entities.removeById('carPath');
      viewer.entities.removeById('carPathWall');
      for (let i = 0; i < policeCar_points.length; i++) {
        viewer.entities.remove(policeCar_points[i]);
      }
      policeCar_points = [];
      policecar_mark = undefined;
    },
    //车载视频
    showVideoPlayer(id, name) {
      let isVideoOn = false;
      for (let i = 0; i < carVideoPlayerArr.length; i++) {
        if (carVideoPlayerArr[i] === id) {
          isVideoOn = true;
          break;
        }
      }
      if (!isVideoOn) {
        let options = {
          title: name + "-车载视频图传",
          message: videoContainer,
          initWidth: "405px",
          initHeight: "355px",
          top: 75,
          left: 0,
          titleImg: ['fas', 'camera'],
          options: {
            minWidth: "405px",
            minHeight: "355px",
            fullScreen: true,
            closeCallback: that.clearVideoPlayer,
          }
        };
        that.$installdialog.subPop(options);
        carVideoPlayerArr.push(id);
      }
    },
    //关闭车载视频
    closeVideoPlayer(id) {
      for (let j = 0; j < carVideoPlayerArr.length; j++) {
        if (carVideoPlayerArr[j] === id) {
          carVideoPlayerArr.splice(j, 1);
          break;
        }
      }
    },
    clearVideoPlayer() {
      //carVideoPlayerArr = [];
    },
  },
  mounted() {
    that = this;
    if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
      getAllCars().then(res => this.createZTree(res.data));
    } else {
      let params = {
        'roleId': localStorage.getItem("roleId"),
      };
      getAllandCarById(params).then(res => {
        let resultArr = [];
        res.data.sysRoleCar.map(item => {
          resultArr.push(item.car);
        });
        this.createZTree(resultArr);
      });
    }
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>

</style>
