<template>
  <div id="protect-wall-is-show">
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
  import ztree from "vue-giant-tree";
  import {insidePolygon, stringToNumber} from "@/js/CesiumTools";
  import map3d from "./map-3d";
  import popUtil from "@/utils/pop/popUtil";
  import {
    checkWallAlarm,
    getKeypeopleById,
    getKeyPeople,
    getKeypeopleNoPic,
    getPeopleRoute, getWall,
    insertAlarm
  } from "../api/api";

  let that;
  let wallalarmdata;
  let wallArr = [];

  let peopleAlarmRouteInv;
  let wallAlarmEntity;
  let wallAlarmPath;

  let inWall = false;
  let wallAlarmImgArr = [];

  let kp_overlays3D = [];
  let kp2_overlays3D = [];

  export default {
    name: "protect-wall",
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
      //创建重点监控人员的目录树
      createZTree(data) {
        that = this;
        //目录树配置
        this.setting = {
          check: {
            enable: true,
            chkStyle: "radio",
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
            onCheck: zTreeChecked,
            onClick: zTreeOnClick,
          },
          view: {
            showIcon: false,
            selectedMulti: true,     //可以多选
          }
        };
        let treeNodes = [{id: 0, pId: "", name: "重点监控人", isNode: false, open: true, showIcon: false, nocheck: true}];
        for (let i = 0; i < data.length; i++) {
          let treeObj = {};
          treeObj.id = data[i].keyId;
          treeObj.pid = 0;
          treeObj.name = data[i].name + "(" + data[i].type + ")";
          treeObj.isNode = true;
          treeNodes.push(treeObj);
        }
        this.nodes = treeNodes;

        //check触发回调函数
        function zTreeChecked(event, treeId, treeNode) {
          if (treeNode.checked === true) {
            let params = {
              'keyId': treeNode.id
            };
            // getPeopleRoute(params).then(res => that.showPeopleAlarmRoute(res.data));
            that.showPeopleAlarmRoute(peopleRoute);
          } else {
            that.clearWallAlarm();
          }
        }

        //人员目录树点击定位方法
        function zTreeOnClick(event, treeId, treeNode) {
          if (!document.getElementById('popupDiv' + treeNode.id)) {
            that.getKeypeopleById(treeNode.id);
          } else {
            that.$message({
              message: '提示，气泡已打开！请勿重复操作！',
              type: 'warning'
            });
          }
        }

        getKeyPeople().then(res => this.showKeypeople(res.data));
      },
      //绘制重点人员分布的图形，图形聚合方法
      showKeypeople(data) {
        let geojson = {
          "type": "FeatureCollection",
          "features": []
        };
        for (let i = 0; i < data.length; i++) {
          let position = data[i].poi.split(',');
          let feature = {
            "type": "Feature",
            "geometry": {
              "type": "Point",
              "coordinates": [Number(position[0]), Number(position[1]), Number(position[2])]
            },
            "id": "kp" + data[i].key_id,
            "name": '实有重点人口',
            "properties": {
              "title": "marker",
              "marker-symbol": "pitch",
              "marker-color": "#8A2BE2"
            }
          };
          geojson.features.push(feature);
          let nearEllipsoidId = 'ke' + data[i].key_id;
          let pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
          let color = Cesium.Color.BLUEVIOLET.withAlpha(0.7);
          kp2_overlays3D.push(viewer.entities.add({
            name: '实有重点人口',
            id: nearEllipsoidId,
            show: true,
            position: pos,
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: color
            }
          }));
        }
        let promise = Cesium.GeoJsonDataSource.load(geojson, {"markerSize": 30});
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
      },
      //清除重点监控人员图形
      closeKeypeople() {
        for (let i = 0; i < kp2_overlays3D.length; i++) {
          viewer.entities.remove(kp2_overlays3D[i]); // 将标注从场景移除
        }
        kp2_overlays3D.length = 0;
        viewer.dataSources.remove(kp_overlays3D);
        CesiumPop.clearDivPop(viewer);
      },
      //根据id获取监控人员信息
      getKeypeopleById(id) {
        let params = {
          "keyId": id
        };
        getKeypeopleById(params).then(res => showKeypeopleById(res.data));

        function showKeypeopleById(data) {
          let popoptions = {
            popId: data.keyId,
            imgurl: common.serverIp + 'city3dfile/' + data.imgurl,
            name: data.name,
            identity: data.identity,
            gender: data.gender,
            birthday: data.birthday,
            blood: data.blood,
            nation: data.nation,
            origin: data.origin,
            height: data.height,
            type: data.type,
            describe: data.describe,
            job: data.job,
            tel: data.tel,
            addName: data.address.addName,
          };
          popUtil.installMapPop().kpPop(popoptions);
          let addArr = data.address.poi.split(',');
          let options = {
            "viewer": viewer,
            "id": data.keyId,
            "popupWidth": 477,
            "popupHeight": 323,
            "pos": {"lon": Number(addArr[0]), "lat": Number(addArr[1]), "alt": Number(addArr[2])},
            "extentHeight": 0,
            "extentColor": Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, 'h');
          let camPoiArr = data.address.camPoi.split(',');
          map3d.methods.moveToWin(camPoiArr[0], camPoiArr[1], camPoiArr[2], data.address.camHeading, data.address.camPitch);
        }
      },
      //显示监控人员行动轨迹，模拟数据
      showPeopleAlarmRoute(data) {
        this.clearWallAlarm();
        let traceList = stringToNumber(data[0].cardPosition);
        let path = [];
        for (let i = 0; i < traceList.length; i = i + 3) {
          let temppoi = Cesium.Cartesian3.fromDegrees(traceList[i], traceList[i + 1], traceList[i + 2]);
          path.push(temppoi);
        }
        let position = [traceList[0], traceList[1], 1600];
        map3d.methods.flyToLocation(position);

        wallAlarmPath = viewer.entities.add({
          id: 'wallAlarmPath',
          polyline: {
            clampToGround: true,
            width: 3,
            show: true,
            material: new Cesium.PolylineDashMaterialProperty({
              color: Cesium.Color.YELLOW
            })
          }
        });

        let j = 1;
        let poistart = path[0];
        let pathArr = [poistart];
        let isfirst = true;
        peopleAlarmRouteInv = setInterval(function () {
          let startTime = Cesium.JulianDate.now(startTime);
          let stopTime = Cesium.JulianDate.now(startTime);
          if (path[j]) {
            let curpos = path[j];
            pathArr.push(curpos);
            wallAlarmPath.polyline.positions = pathArr;
            let result = createPeopleAlarm([poistart, curpos]);
            poistart = curpos;
            if (Cesium.JulianDate.compare(startTime, result.startTime) > 0) {
              startTime = result.startTime;
            }
            if (Cesium.JulianDate.compare(stopTime, result.stopTime) < 0) {
              stopTime = result.stopTime;
            }
            let alarmpoi = traceList[j * 3] + ',' + traceList[j * 3 + 1] + ',' + traceList[j * 3 + 2];
            for (let x = 0; x < wallalarmdata.length; x++) {
              let params = {
                "alarmType": alarmpoi,
                "alarmPoi": wallalarmdata[x].wallPoi
              };
              checkWallAlarm(params).then(res => docheck(alarmpoi, wallalarmdata[x], data[0], isfirst, res.data));

              function docheck(poi, wallObj, peopleObj, isfirst, data) {
                if (!isfirst) {
                  if (inWall !== data) {
                    let alarm = {};
                    alarm.wallId = wallObj.wallId;
                    alarm.alarmTime = (new Date()).pattern("yyyy-MM-dd hh:mm:ss");
                    alarm.alarmPeopleId = peopleObj.keyId;
                    alarm.alarmPoi = poi;
                    if (wallObj.wallIn === '是' && data) {
                      alarm.alarmType = '进入';
                    }
                    if (wallObj.wallOut === '是' && !data) {
                      alarm.alarmType = '离开';
                    }
                    insertAlarm(alarm).then(res => consoleInsertAlarm(res.data));

                    function consoleInsertAlarm(data) {
                      if (data === 1) {
                        console.log("保存成功！");
                      } else {
                        console.log("保存失败！");
                      }
                    }

                    let poiArr = poi.split(',');
                    let point = Cesium.Cartesian3.fromDegrees(poiArr[0], poiArr[1], poiArr[2]);
                    let x = 1;
                    let flog = true;
                    wallAlarmImgArr.push(viewer.entities.add({
                      position: point,
                      billboard: {
                        image: 'static/images/pinimg/01.png',
                        scale: 0.9,
                        color: new Cesium.CallbackProperty(function (time, result) {
                          if (flog) {
                            x -= 0.02;
                            if (x <= 0) {
                              flog = false;
                            }
                          } else {
                            x += 0.02;
                            if (x >= 1) {
                              flog = true;
                            }
                          }
                          return Cesium.Color.WHITE.withAlpha(x);
                        }, false),
                        verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                        scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                        pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                        disableDepthTestDistance: 200,
                      },
                      label: {
                        show: true,
                        verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                        horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                        font: 'bold 36px Helvetica',
                        scale: 0.5,
                        style: Cesium.LabelStyle.FILL_AND_OUTLINE,
                        outlineColor: Cesium.Color.RED,
                        outlineWidth: 8,
                        fillColor: Cesium.Color.WHITE,
                        text: alarm.alarmTime + "\n" + alarm.alarmType,
                        pixelOffset: new Cesium.Cartesian2(0.0, -340.0),
                        disableDepthTestDistance: 100000000,
                        scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                        pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                      }
                    }));
                  }
                }
                inWall = data;
              }
            }
          } else {
            that.clearWallAlarm();
          }
          isfirst = false;
          j++;
          viewer.clock.startTime = startTime.clone();
          viewer.clock.stopTime = stopTime.clone();
          viewer.clock.currentTime = startTime.clone();
          viewer.clock.clockRange = Cesium.ClockRange.UNBOUNDED;
          viewer.clock.multiplier = 1;
          viewer.timeline.zoomTo(startTime, stopTime);
        }, 5000);

        function createPeopleAlarm(nodes) {
          //添加移动实体
          let times = [];
          let startTime = Cesium.JulianDate.now(startTime);
          for (let i = 0; i < nodes.length; i++) {
            let time = new Cesium.JulianDate();
            Cesium.JulianDate.addSeconds(startTime, i * 5, time);
            times.push(time);
          }
          let stopTime = times[times.length - 1];
          //插值
          let property = new Cesium.SampledPositionProperty();
          property.addSamples(times, nodes);

          wallAlarmEntity = viewer.entities.add({
            position: property,
            billboard: {
              image: 'static/images/pinimg/03.png',
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            }
          });
          return {
            startTime: startTime,
            stopTime: stopTime
          };
        }
      },
      //清除模块数据
      stopWallAlarm() {
        this.clearWall();
        this.clearWallAlarm();
        this.closeKeypeople();
      },
      //清除报警图形
      clearWallAlarm() {
        clearInterval(peopleAlarmRouteInv);
        viewer.entities.remove(wallAlarmEntity);
        viewer.entities.remove(wallAlarmPath);
        for (let i = 0; i < wallAlarmImgArr.length; i++) {
          viewer.entities.remove(wallAlarmImgArr[i]);
        }
        wallAlarmImgArr = [];
      },
      //显示电子围栏
      showAllwalls(data) {
        wallalarmdata = data;
        for (let i = 0; i < data.length; i++) {
          let posCarArr = [];
          let posArr = data[i].wallPoi.split(',');
          let minimumHeights = [];
          let measureResult = 0;
          for (let j = 0; j < posArr.length; j = j + 3) {
            let point = new Cesium.Cartesian3.fromDegrees(posArr[j], posArr[j + 1], Number(posArr[j + 2]) + 40);
            posCarArr.push(point);
            minimumHeights.push(Number(posArr[j + 2]));
          }
          let point = new Cesium.Cartesian3.fromDegrees(posArr[3], posArr[4], Number(posArr[5]) + 40);
          posCarArr.push(point);
          minimumHeights.push(Number(posArr[5]));
          for (let n = 0; n < posCarArr.length - 1; n++) {
            measureResult += Cesium.Cartesian3.distance(posCarArr[n], posCarArr[n + 1]);
          }
          let alp = 1;
          let num = 0;
          wallArr.push(viewer.entities.add({
            polygon: {
              hierarchy: new Cesium.PolygonHierarchy(posCarArr),
              material: Cesium.Color.RED.withAlpha(0.05)
            },
            wall: {
              positions: posCarArr,
              minimumHeights: minimumHeights,
              material: new Cesium.ImageMaterialProperty({
                image: "static/images/wallbg.png",
                transparent: true,
                repeat: new Cesium.Cartesian2(measureResult / 60, 1.0),
                color: new Cesium.CallbackProperty(function () {
                  if ((num % 2) === 0) {
                    alp -= 0.01;
                  } else {
                    alp += 0.01;
                  }

                  if (alp <= 0.1) {
                    num++;
                  } else if (alp >= 1) {
                    num++;
                  }
                  return Cesium.Color.WHITE.withAlpha(alp)
                  //entity的颜色透明 并不影响材质，并且 entity也会透明
                }, false)
              }),
            },
          }));
        }
      },
      //获取电子围栏信息
      getAlarmById(id) {
        this.$message.error('电子围栏信息查询方法占位!');
      },
      //清除电子围栏图形
      clearWall() {
        for (let i = 0; i < wallArr.length; i++) {
          viewer.entities.remove(wallArr[i]);
        }
        wallArr = [];
      }
    },
    mounted() {
      getKeypeopleNoPic().then(res => this.createZTree(res.data));
      getWall().then(res => this.showAllwalls(res.data));
      CesiumPop.bindPopGlobeEventHandler(viewer);
    }
  }
</script>

<style scoped>

</style>
