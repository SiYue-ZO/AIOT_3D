<template>
  <div id="iot-man-is-show">
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
  getAllandPoliceById,
  getGpsRealdata,
  getManPosByDn,
  getPolice,
  getPoliceById
} from "../api/api";

let that;

let deviceListMan = [];
let policeManInterval;
let policeMan_marks = [];
let policeMan_points = [];

//添加轨迹线和实体等
let policeManLine;
let policeMan_mark;
let policeMan_mark_start;
let policeMan_mark_end;
let listener;

let smartEyesession;
let dlghandleArr = [];
let manVideoPlayerArr = [];

export default {
  name: "iot-man",
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
    //创建人员目录树
    createManZTree(data) {
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
          onCheck: policezTreeChecked,
          onClick: policezTreeOnClick,
        },
        view: {
          showIcon: true,
          selectedMulti: true,     //可以多选
        }
      };
      let treeNodes = [{
        id: 0,
        pId: "",
        name: "4G执法仪目录（视频回传）",
        isNode: false,
        open: true,
        nocheck: true,
        icon: "static/images/treeicon/subject.png"
      }];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].policeId;
        treeObj.pid = 0;
        treeObj.name = data[i].name + "(" + data[i].origin + ")：" + data[i].deviceNum;
        treeObj.highlight = false;
        treeObj.isNode = true;
        treeObj.phone = data[i].deviceNum;
        treeObj.deviceType = data[i].deviceType;
        treeObj.icon = "static/images/treeicon/police1.png";
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function policezTreeChecked(event, treeId, treeNode) {
        if (treeNode.level !== 0) {
          if (treeNode.checked) {
            if (deviceListMan.length === 0 || deviceListMan.indexOf(treeNode.phone) === -1) {
              deviceListMan.push(treeNode.phone);
              freshPoliceManPos(deviceListMan);
            }
          } else {
            deviceListMan.splice(deviceListMan.indexOf(treeNode.phone), 1);
            viewer.entities.removeById('po' + treeNode.phone);
            CesiumPop.removeDivPopById(viewer, treeNode.phone);
          }
        }
      }

      //目录树点击定位方法
      function policezTreeOnClick(event, treeId, treeNode) {
        let params = {
          "deviceNum": treeNode.phone
        };
        getManPosByDn(params).then(res => {
          let data = res.data[0];
          if (data !== undefined) {
            let posArr = data.realPos.split(',');
            let position = [Number(posArr[0]), Number(posArr[1]), Number(posArr[2]) + 195];
            map3d.methods.flyToLocation(position);
          }
        });
      }

      policeManInterval = window.setInterval(function () {
        freshPoliceManPos(deviceListMan);
      }, 5000);
      freshPoliceManPos(deviceListMan);

      function freshPoliceManPos(deviceListMan) {
        if (policeManInterval !== undefined) {
          if (deviceListMan.length === 0) {
            that.deletePoliceManMarks();
            return;
          }
          let params = {
            'deviceNums': deviceListMan
          };
          getGpsRealdata(params).then(res => {
            if (policeManInterval) {
              that.showPoliceMan(res.data)
            }
          });
        } else {
          that.deletePoliceManMarks();
        }
      }

      this.smartEyelogin();
    },
    //显示人员实时监督
    showPoliceMan(realdata) {
      let url = '';
      let urlHalo = '';
      for (let i = 0; i < realdata.length; i++) {
        switch (realdata[i].origin) {
          case '特警':
            url = 'static/images/pinimg/10.png';
            urlHalo = 'static/images/halo/bg_circle.png';
            break;
          case '巡警':
            url = 'static/images/pinimg/12.png';
            urlHalo = 'static/images/halo/bg_circle.png';
            break;
          case '治安警察':
            url = 'static/images/pinimg/11.png';
            urlHalo = 'static/images/halo/bg_circle.png';
            break;
          // case '刑警':
          //   break;
          // case '城管':
          //   break;
          default:
            break;
        }
        let posArr = realdata[i].realPos.split(',');
        let point = Cesium.Cartesian3.fromDegrees(Number(posArr[0]), Number(posArr[1]), Number(posArr[2]));
        let pointHalo = {};
        pointHalo.longitude = Number(posArr[0]);
        pointHalo.latitude = Number(posArr[1]);
        let puid = realdata[i].deviceNum;
        let policeName = realdata[i].name;
        let clampedpoint = viewer.scene.clampToHeight(point);
        let height = Cesium.Cartographic.fromCartesian(clampedpoint).height;
        createPoliceManPin(url, puid, clampedpoint, policeName, urlHalo, pointHalo);
        //如有气泡，更新气泡位置
        if (document.getElementById("popupDiv" + puid)) {
          let pos = {
            "lon": Number(posArr[0]),
            "lat": Number(posArr[1]),
            "alt": height
          };
          CesiumPop.updatePopPos(viewer, puid, pos, 30, 300, 215, Cesium.Color.WHITE);
        }
      }

      function createPoliceManPin(url, id, point, policeName, urlHalo, pointHalo) {
        let rotation = Cesium.Math.toRadians(0);

        function getRotationValue() {
          rotation += 0.015;
          return rotation;
        }

        let policePin = viewer.entities.getById('po' + id);
        if (policePin === undefined) {
          let x = 15;
          let flog = true;
          policeMan_marks.push(viewer.entities.add({
            name: '人员',
            id: 'po' + id,
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
              outlineColor: Cesium.Color.fromCssColorString("#e7b13c"),
              outlineWidth: 2,
              fillColor: Cesium.Color.WHITE,
              text: policeName,
              pixelOffset: new Cesium.Cartesian2(0.0, -125.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            },
            model: {
              uri: common.serverIp + "city3dfile/" + "data/model/man/tejing.gltf",
              scale: 0.05,
              imageBasedLightingFactor: new Cesium.Cartesian2(2.0, 1.0),
              distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 300)
            },
            rectangle: {
              coordinates: Cesium.Rectangle.fromDegrees(
                pointHalo.longitude - 0.00004,
                pointHalo.latitude - 0.00004,
                pointHalo.longitude + 0.00004,
                pointHalo.latitude + 0.00004),
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
          policePin.position = point;
          policePin.rectangle.coordinates = Cesium.Rectangle.fromDegrees(
            pointHalo.longitude - 0.00004,
            pointHalo.latitude - 0.00004,
            pointHalo.longitude + 0.00004,
            pointHalo.latitude + 0.00004);
        }
      }
    },
    //停止获取定位的计时器
    stopFreshPolicePos() {
      window.clearInterval(policeManInterval);
      policeManInterval = undefined;
    },
    //清除图标
    deletePoliceManMarks() {
      for (let i = 0; i < policeMan_marks.length; i++) {
        viewer.entities.remove(policeMan_marks[i]); // 将标注从场景移除
        CesiumPop.removeDivPopById(viewer, policeMan_marks[i].id.substring(2));
      }
      policeMan_marks.length = 0;
      deviceListMan.length = 0;//清除警员数组
      this.manHisStop();
    },
    //获取人员详细信息并显示详情气泡
    getPoliceById(id, posCart) {
      viewer.entities.getById('po' + id).show = false;
      let params = {
        "deviceNum": id
      };
      getPoliceById(params).then(res => {
        let data = res.data;
        CesiumPop.removeDivPopById(viewer, data.deviceNum);
        let num = 0;
        let dataPE = data.policeEquipments;
        if (dataPE !== null) {
          for (let i = 0; i < dataPE.length; i++) {
            num += Number(dataPE[i].equipment.equipmentGrade);
            dataPE[i].equipment.equipmentPicture = common.serverIp + "city3dfile/" + dataPE[i].equipment.equipmentPicture;
          }
        }
        let popcolor = '';
        switch (data.origin) {
          case '特警':
            popcolor = '#00d3e7';
            break;
          case '巡警':
            popcolor = '#FF6A6A';
            break;
          case '治安警察':
            popcolor = '#836FFF';
            break;
          default:
            break;
        }

        let cartographic = Cesium.Cartographic.fromCartesian(posCart);
        let lon = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        let popoptions = {
          popId: data.deviceNum,
          name: data.name,
          identity: data.identity,
          gender: data.gender,
          birth: data.birth,
          nation: data.nation,
          origin: data.origin,
          post: data.post,
          jobDate: data.jobDate,
          policeRank: data.policeRank,
          education: data.education,
          deviceNum: data.deviceNum,
          deviceType: data.deviceType,
          deviceDate: data.deviceDate,
          realTime: data.realTime,
          num: num.toFixed(1),
          imageUrl: common.serverIp + "city3dfile/" + data.image,
          color: popcolor,
          equipArr: dataPE
        };
        popUtil.installMapPop().manPop(popoptions);
        let options = {
          "viewer": viewer,
          "id": data.deviceNum,
          "popupWidth": 300,
          "popupHeight": 215,
          "pos": {"lon": Number(lon), "lat": Number(lat), "alt": Number(cartographic.height)},
          "extentHeight": 30,
          "extentColor": Cesium.Color.WHITE,
        };
        CesiumPop.addDivPop(options);
      });
    },
    //登录执法仪
    smartEyelogin() {
      if (!smartEyesession) {
        let urlArrtemp = window.serverUrl.split(':');
        let urlArr = urlArrtemp[1].split('\//');
        smartEyesession = new jSW.SWSession({
          server: urlArr[1], // 如果是jSW.CallProtoType.OCX方式，这里需要填写具体的IP
          port: 9701,
          onopen: function (sess) {
            sess.swLogin({
              user: 'admin',
              password: '123456'
            });
          }
        });
      }
    },
    //注销执法仪
    smartEyelogout() {
      if (smartEyesession) {
        smartEyesession.swLogout();
      }
    },
    //创建视频回传播放器
    initSewisePlayer(id, name) {
      let isVideoOn = false;
      for (let i = 0; i < manVideoPlayerArr.length; i++) {
        if (manVideoPlayerArr[i] === id) {
          isVideoOn = true;
          break;
        }
      }
      if (!isVideoOn) {
        let options = {
          title: name + "-视频图传",
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
        manVideoPlayerArr.push(id);

        setTimeout(() => {
          let strVideoDivId = document.getElementById('vc-1');
          that.openSmartEyeVideo(id, strVideoDivId, 'min');
        }, 2000);
      }
    },
    //关闭指定的视频回传播放器
    closeVideoPlayer(id) {
      for (let j = 0; j < manVideoPlayerArr.length; j++) {
        if (manVideoPlayerArr[j] === id) {
          this.closeSmartEyeVideo(manVideoPlayerArr[j], 'min');
          manVideoPlayerArr.splice(j, 1);
          break;
        }
      }
    },
    //关闭全部视频播放器
    clearVideoPlayer() {
      for (let j = 0; j < manVideoPlayerArr.length; j++) {
        that.closeSmartEyeVideo(manVideoPlayerArr[j], 'min');
      }
      manVideoPlayerArr = [];
    },
    //开通视频回传通道
    openSmartEyeVideo(deviceNum, divobj, type) {
      let chanel = smartEyesession.swGetPuChanel(deviceNum, 0);
      if (chanel) {
        let result = chanel.swOpenEx({
          ismuti: true,
          div: divobj,
          prototype: 'auto', //rtmp > hls
          callback: function (options, response, dlghandle) {
            let obj = {'dn': deviceNum, 'dlghandle': dlghandle, 'type': type};
            dlghandleArr.push(obj);
          }
        });

        if (result !== jSW.RcCode.RC_CODE_S_OK) {
          console.log('打开视频失败: ' + result);
        }
      } else {
        console.log('没有该设备通道');
      }
    },
    //关闭执法仪视频通道
    closeSmartEyeVideo(deviceNum, type) {
      let chanel = smartEyesession.swGetPuChanel(deviceNum, 0);
      if (chanel) {
        for (let j = 0; j < dlghandleArr.length; j++) {
          if (dlghandleArr[j].type === type) {
            if (deviceNum === dlghandleArr[j].dn) {
              chanel.swClose(dlghandleArr[j].dlghandle.hdlg);
              dlghandleArr.splice(j, 1);
              break;
            }
          }
        }
      } else {
        console.log('没有该设备通道');
      }
    },
    //历史轨迹回放
    manHisPlay(data, velocity) {
      document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "block";
      document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "block";
      if (data.length > 0) {
        let traceList = [];
        data.map(item => {
          let arrPos = item.realPos.split(',');
          traceList.push(Number(arrPos[0]));
          traceList.push(Number(arrPos[1]));
          traceList.push(Number(arrPos[2]) + 5);
        });
        let indexPos = data[0].realPos.split(',');
        let position = [Number(indexPos[0]), Number(indexPos[1]), 500];
        map3d.methods.flyToLocation(position);

        let startTime = Cesium.JulianDate.now(startTime);
        let stopTime = Cesium.JulianDate.now(startTime);
        let result = createManLines(traceList, data[0].deviceNum, data);
        if (Cesium.JulianDate.compare(startTime, result.startTime) > 0) {
          startTime = result.startTime;
        }
        if (Cesium.JulianDate.compare(stopTime, result.stopTime) < 0) {
          stopTime = result.stopTime;
        }

        viewer.clock.startTime = startTime.clone();
        viewer.clock.stopTime = stopTime.clone();
        viewer.clock.currentTime = startTime.clone();
        viewer.clock.clockRange = Cesium.ClockRange.UNBOUNDED;
        viewer.clock.multiplier = 10;
        viewer.timeline.zoomTo(startTime, stopTime);

        function createManLines(nodes, lineId, data) {
          //添加轨迹线
          policeManLine = viewer.entities.add({
            polyline: {
              positions: Cesium.Cartesian3.fromDegreesArrayHeights(nodes),
              width: 4.0,
              material: new Cesium.PolylineDashMaterialProperty({
                color: Cesium.Color.RED.withAlpha(0.8),
                //glowPower: 0.6
              }),
              clampToGround: true,
              classificationType: Cesium.ClassificationType.BOTH
            }
          });
          //添加移动实体
          let nodesPosition = [];
          let times = [];
          let startTime = Cesium.JulianDate.now(startTime);
          let isTimeLabelShow = false;
          for (let i = 0; i < nodes.length / 3; i++) {
            let time = new Cesium.JulianDate();
            Cesium.JulianDate.addSeconds(startTime, 30 * i / velocity, time);
            times.push(time);
            let point = Cesium.Cartesian3.fromDegrees(nodes[i * 3], nodes[i * 3 + 1], nodes[i * 3 + 2]);
            nodesPosition.push(point);
            let clampedpoint = viewer.scene.clampToHeight(point);
            let timeTextArr = data[i].realTime.split(" ");
            isTimeLabelShow = i % 5 === 0;
            policeMan_points.push(
              viewer.entities.add({
                position: clampedpoint,
                point: {
                  pixelSize: 5,
                  color: Cesium.Color.RED,
                  outlineColor: Cesium.Color.WHITE,
                  outlineWidth: 2,
                  disableDepthTestDistance: 100000000,
                },
                label: {
                  show: isTimeLabelShow,
                  verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                  horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                  text: timeTextArr[0] + '\n' + timeTextArr[1],
                  font: 'bold 26px Helvetica',
                  scale: 0.5,
                  style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                  fillColor: Cesium.Color.RED,
                  outlineColor: Cesium.Color.WHITE,
                  outlineWidth: 8,
                  disableDepthTestDistance: 100000000,
                  pixelOffset: new Cesium.Cartesian2(0, -50.0),
                }
              })
            );
          }
          let stopTime = times[times.length - 1];
          //插值
          let property = new Cesium.SampledPositionProperty();
          property.addSamples(times, nodesPosition);
          let orientationproperty = new Cesium.VelocityOrientationProperty(property);// 计算朝向
          let pinBuilder = new Cesium.PinBuilder();
          Promise.resolve(
            pinBuilder.fromUrl('static/images/treeicon/police1.png', Cesium.Color.DODGERBLUE, 48)
          ).then(function (canvas) {
            policeMan_mark = viewer.entities.add({
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
              /*model: {
                uri: 'static/model/car/jingche_a.gltf',
                minimumPixelSize: 128,
                maximumScale: 20,
                scale: 0.02,
                //小于20000显示模型，隐藏pin
                distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, 4000),
                imageBasedLightingFactor : new Cesium.Cartesian2(3, 1),
              }*/
            });
          });
          //起点
          let startpoint = Cesium.Cartesian3.fromDegrees(Number(nodes[0]), Number(nodes[1]), Number(nodes[2]));
          policeMan_mark_start = viewer.entities.add({
            position: startpoint,
            billboard: {
              image: pinBuilder.fromText('起', Cesium.Color.GREEN, 40).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            }
          });
          //终点
          let endpoint = Cesium.Cartesian3.fromDegrees(Number(nodes[nodes.length - 3]), Number(nodes[nodes.length - 2]), Number(nodes[nodes.length - 1]));
          policeMan_mark_end = viewer.entities.add({
            position: endpoint,
            billboard: {
              image: pinBuilder.fromText('终', Cesium.Color.RED, 40).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            }
          });
          //轨迹
          let pathPosition1 = new Cesium.SampledPositionProperty();
          viewer.entities.add({
            id: 'manPath',
            position: pathPosition1,
            path: {
              show: true,
              leadTime: 0,
              trailTime: 6000000000,
              width: 7,
              resolution: 1,
              material: new Cesium.PolylineGlowMaterialProperty({
                color: Cesium.Color.YELLOW,
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
            id: 'manPathWall',
            wall: {
              positions: new Cesium.CallbackProperty(function () {
                wallPosArr.push(newWallPoint);
                return wallPosArr;
              }, false),
              minimumHeights: new Cesium.CallbackProperty(function () {
                wallMinArr.push(0);
                return wallMinArr;
              }, false),
              material: Cesium.Color.YELLOW.withAlpha(0.4)
            },
          });

          listener = function (scene, time) {
            if (policeMan_mark && policeMan_mark.position._property && policeMan_mark.position._property._interpolationResult[0]) {
              let interPosArr1 = policeMan_mark.position._property._interpolationResult;
              let interPos1 = Cesium.Cartesian3.fromElements(interPosArr1[0], interPosArr1[1], interPosArr1[2]);
              pathPosition1.addSample(Cesium.JulianDate.now(), interPos1);
              newWallPoint = interPos1;
            }
          };
          viewer.scene.preUpdate.addEventListener(listener);
          return {
            startTime: startTime,
            stopTime: stopTime
          };
        }
      } else {
        this.$message.error('该时段未查询到指定人员轨迹数据，请重试！');
      }
    },
    //历史轨迹停止
    manHisStop() {
      document.getElementsByClassName("cesium-viewer-animationContainer")[0].style.display = "none";
      document.getElementsByClassName("cesium-viewer-timelineContainer")[0].style.display = "none";
      viewer.scene.preUpdate.removeEventListener(listener);
      viewer.entities.remove(policeManLine);
      viewer.entities.remove(policeMan_mark);
      viewer.entities.remove(policeMan_mark_start);
      viewer.entities.remove(policeMan_mark_end);
      viewer.entities.removeById('manPath');
      viewer.entities.removeById('manPathWall');
      for (let i = 0; i < policeMan_points.length; i++) {
        viewer.entities.remove(policeMan_points[i]);
      }
      policeMan_points = [];
      policeMan_mark = undefined;
    },
  },
  mounted() {
    that = this;
    if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
      getPolice().then(res => {
        this.createManZTree(res.data)
      });
    } else {
      let params = {
        'roleId': localStorage.getItem("roleId"),
      };
      getAllandPoliceById(params).then(res => {
        let resultArr = [];
        res.data.sysRolePolice.map(item => {
          resultArr.push(item.police);
        });
        this.createManZTree(resultArr);
      });
    }
    CesiumPop.bindPopGlobeEventHandler(viewer);
  }
}
</script>

<style scoped>

</style>
