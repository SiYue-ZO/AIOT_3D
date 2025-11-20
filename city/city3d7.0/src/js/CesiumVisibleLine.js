/*
 * visible line from origin to target.
 * the visible part of line renders green, otherwise renders red.
 */

(function (window) {
  'use strict';

  function define_CesiumVisibleLine() {
    //Main object
    let CesiumVisibleLine = {};
    let vlhandler;
    let visibleLineEntityC = [];
    let hiddenLineEntityC = [];
    let originEntityC = [];
    let targetEntityC = [];
    let breakEntityC = [];
    let bodyEntityC = [];
    let visiblepolygonC = [];
    let isFirst = true;//是否为第一个点
    let vcisFirst = true;//是否为第一个点

    CesiumVisibleLine.drawLines = function (options) {
      let isVisible = false;
      let originPosition;//前一个点的坐标
      let targetPosition;//当前点坐标
      let bodyPosition;
      let isFirst = true;//是否为第一个点

      vlhandler = vlhandler && vlhandler.destroy();
      //前一个点与鼠标连线的entity
      /*var dynamicLineEntity = options.viewer.entities.add({
              id : 'dve'+new Date().getTime(),
              polyline : {
                  width : 3,
                  material : options.drawColor,
                  show : true
              }
          });*/

      vlhandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      vlhandler.setInputAction(function (movement) {
        if (isFirst) {
          originPosition = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(originPosition);
          let height = cartographic.height;//观察者高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            originPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(originPosition);
          height = cartographic.height;
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          bodyPosition = Cesium.Cartesian3.fromDegrees(lng, lat, height + options.bodyHeight);
          let originEntity = options.viewer.entities.add({
            id: 'originEntity' + new Date().getTime(),
            position: bodyPosition,
            point: {
              color: options.originColor,
              pixelSize: 10,
            }
          });
          let bodyEntity = options.viewer.entities.add({
            id: 'bodyEntity' + new Date().getTime(),
            polyline: {
              width: 3,
              material: options.bodyColor,
              show: true
            }
          });
          bodyEntity.polyline.positions = [originPosition, bodyPosition];

          isFirst = false;
          bodyEntityC.push(bodyEntity);
          originEntityC.push(originEntity);
        } else {
          //dynamicLineEntity.show = false;
          targetPosition = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(targetPosition);
          let height = cartographic.height;//观察者高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            targetPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          let targetEntity = options.viewer.entities.add({
            id: 'targetEntity' + new Date().getTime(),
            position: targetPosition,
            point: {
              color: options.targetColor,
              pixelSize: 10,
            }
          });
          targetEntityC.push(targetEntity);

          let breakpoint = computeVisible(bodyPosition, targetPosition, movement.position, options.viewer.scene, options.viewer);

          let visibleLineEntity = options.viewer.entities.add({
            id: 'visibleLineEntity' + new Date().getTime(),
            polyline: {
              width: 3,
              material: options.visibleColor,
              show: true
            }
          });

          if (breakpoint) {
            let hiddenLineEntity = options.viewer.entities.add({
              id: 'hiddenLineEntity' + new Date().getTime(),
              polyline: {
                width: 3,
                material: options.hiddenColor,
                show: true
              }
            });
            visibleLineEntity.polyline.positions = [bodyPosition, breakpoint];
            hiddenLineEntity.polyline.positions = [breakpoint, targetPosition];
            visibleLineEntityC.push(visibleLineEntity);
            hiddenLineEntityC.push(hiddenLineEntity);
            let breakEntity = options.viewer.entities.add({
              id: 'breakEntity' + new Date().getTime(),
              position: breakpoint,
              point: {
                color: options.breakColor,
                pixelSize: 10,
              }
            });
            breakEntityC.push(breakEntity);
            isVisible = false;
          } else {
            visibleLineEntity.polyline.positions = [bodyPosition, targetPosition];
            visibleLineEntityC.push(visibleLineEntity);
            isVisible = true;
          }
          //dynamicLineEntity.show = true;
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      /*vlhandler.setInputAction(function(movement){
              if(!isFirst){
                  //获取当前点的坐标
                  targetPosition = options.viewer.scene.pickPosition(movement.endPosition);
                  if(targetPosition){
                      dynamicLineEntity.polyline.positions = [originPosition,targetPosition];
                  }
              }
          },Cesium.ScreenSpaceEventType.MOUSE_MOVE);*/
      vlhandler.setInputAction(function () {
        //move事件监听
        vlhandler = vlhandler && vlhandler.destroy();
        isFirst = true;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      return isVisible;
    };

    function computeVisible(origin, target, movementpoi, scene, computeviewer) {
      for (let i = 1; i < 101; i++) {
        let lon = Cesium.Math.lerp(origin.x, target.x, 0.01 * i);
        let lat = Cesium.Math.lerp(origin.y, target.y, 0.01 * i);
        let height = origin.z - (origin.z - target.z) * 0.01 * i;
        let position = new Cesium.Cartesian3(lon, lat, height);
        let clampPoi = scene.clampToHeight(position);
        if (clampPoi !== undefined) {
          let cartographic = Cesium.Cartographic.fromCartesian(clampPoi);
          let heightclamp = cartographic.height;
          if (heightclamp < 0) {
            let ray = computeviewer.camera.getPickRay(movementpoi);
            clampPoi = computeviewer.scene.globe.pick(ray, scene);
          }
        } else {
          let ray = computeviewer.camera.getPickRay(movementpoi);
          clampPoi = computeviewer.scene.globe.pick(ray, scene);
        }
        if (clampPoi.z >= height) {
          return position;
        }
      }
    }

    CesiumVisibleLine.removeLines = function (viewer) {
      isFirst = true;
      vcisFirst = true;
      vlhandler = vlhandler && vlhandler.destroy();
      for (let i = 0; i < visibleLineEntityC.length; i++) {
        viewer.entities.remove(visibleLineEntityC[i]);
      }
      for (let j = 0; j < hiddenLineEntityC.length; j++) {
        viewer.entities.remove(hiddenLineEntityC[j]);
      }
      for (let m = 0; m < originEntityC.length; m++) {
        viewer.entities.remove(originEntityC[m]);
      }
      for (let n = 0; n < targetEntityC.length; n++) {
        viewer.entities.remove(targetEntityC[n]);
      }
      for (let o = 0; o < breakEntityC.length; o++) {
        viewer.entities.remove(breakEntityC[o]);
      }
      for (let p = 0; p < bodyEntityC.length; p++) {
        viewer.entities.remove(bodyEntityC[p]);
      }
      for (let q = 0; q < visiblepolygonC.length; q++) {
        viewer.entities.remove(visiblepolygonC[q]);
      }
    };

    CesiumVisibleLine.drawCircles = function (options) {
      let originPosition;//前一个点的坐标
      let targetPosition;//当前点坐标
      let bodyPosition;
      let lng;
      let lat;
      let breakpointC = [];
      let vcisFirst = true;//是否为第一个点

      vlhandler = vlhandler && vlhandler.destroy();
      vlhandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      vlhandler.setInputAction(function (movement) {
        if (vcisFirst) {
          originPosition = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(originPosition);
          let height = cartographic.height;//观察者高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            originPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(originPosition);
          lng = Cesium.Math.toDegrees(cartographic.longitude);
          lat = Cesium.Math.toDegrees(cartographic.latitude);
          height = cartographic.height;//观察者高度
          bodyPosition = Cesium.Cartesian3.fromDegrees(lng, lat, height + options.bodyHeight);
          let originEntity = options.viewer.entities.add({
            id: 'originEntity' + new Date().getTime(),
            position: bodyPosition,
            point: {
              color: options.originColor,
              pixelSize: 10,
            }
          });
          let bodyEntity = options.viewer.entities.add({
            id: 'bodyEntity' + new Date().getTime(),
            polyline: {
              width: 3,
              material: options.bodyColor,
              show: true
            }
          });
          bodyEntity.polyline.positions = [originPosition, bodyPosition];

          vcisFirst = false;
          bodyEntityC.push(bodyEntity);
          originEntityC.push(originEntity);
        } else {
          //document.getElementById("loading").style.display = "block";
          targetPosition = options.viewer.scene.pickPosition(movement.position);
          let origincartographic = Cesium.Cartographic.fromCartesian(originPosition);
          let targetcartographic = Cesium.Cartographic.fromCartesian(targetPosition);
          let height = targetcartographic.height;
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            targetPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          targetcartographic = Cesium.Cartographic.fromCartesian(targetPosition);
          let geodesic = new Cesium.EllipsoidGeodesic();
          geodesic.setEndPoints(origincartographic, targetcartographic);
          let radius = geodesic.surfaceDistance;
          let targetEntity = options.viewer.entities.add({
            id: 'targetEntity' + new Date().getTime(),
            position: originPosition,
            ellipse: {
              semiMinorAxis: radius,
              semiMajorAxis: radius,
              height: targetcartographic.height,
              fill: false,
              outline: true,
              outlineColor: options.targetColor,
              outlineWidth: 1.5
            }
          });
          targetEntityC.push(targetEntity);

          let ddegree = radius / 6378137;
          let lngr = lng * Math.PI / 180;
          let latr = lat * Math.PI / 180;
          for (let i = 0; i < 360; i = i + 10) {
            /*var x = originPosition.x + radius*Math.sin(i*2*Math.PI/360);
                    var y = originPosition.y + radius*Math.cos(i*2*Math.PI/360);
                    var pointonCircle = Cesium.Cartesian3.fromElements(x,y,targetPosition.z);*/
            let ir = i * Math.PI / 180;
            let y = Math.asin(Math.sin(latr) * Math.cos(ddegree) + Math.cos(latr) * Math.sin(ddegree) * Math.cos(ir));
            let x = lngr + Math.atan2(Math.sin(ir) * Math.sin(ddegree) * Math.cos(latr),
              Math.cos(ddegree) - Math.sin(latr) * Math.sin(y));
            let lononCircle = x * 180 / Math.PI;
            let latonCircle = y * 180 / Math.PI;
            let pointonCircle = Cesium.Cartesian3.fromDegrees(lononCircle, latonCircle, targetcartographic.height);
            let breakpoint = computeVisible(bodyPosition, pointonCircle, movement.position, options.viewer.scene, options.viewer);

            let visibleLineEntity = options.viewer.entities.add({
              id: 'visibleLineEntity' + new Date().getTime(),
              polyline: {
                width: 3,
                material: options.visibleColor,
                show: true
              }
            });

            if (breakpoint) {
              let hiddenLineEntity = options.viewer.entities.add({
                id: 'hiddenLineEntity' + new Date().getTime(),
                polyline: {
                  width: 3,
                  material: options.hiddenColor,
                  show: true
                }
              });
              visibleLineEntity.polyline.positions = [bodyPosition, breakpoint];
              hiddenLineEntity.polyline.positions = [breakpoint, pointonCircle];
              visibleLineEntityC.push(visibleLineEntity);
              hiddenLineEntityC.push(hiddenLineEntity);
              let breakEntity = options.viewer.entities.add({
                id: 'breakEntity' + new Date().getTime(),
                position: breakpoint,
                point: {
                  color: options.breakColor,
                  pixelSize: 10,
                }
              });
              breakEntityC.push(breakEntity);
              breakpointC.push(breakpoint);
            } else {
              visibleLineEntity.polyline.positions = [bodyPosition, pointonCircle];
              visibleLineEntityC.push(visibleLineEntity);
              breakpointC.push(pointonCircle);
            }
          }
          let visiblepolygon = options.viewer.entities.add({
            id: 'visiblepolygon' + new Date().getTime(),
            polygon: {
              hierarchy: breakpointC,
              material: options.visiblePolygonColor,
            }
          });
          visiblepolygonC.push(visiblepolygon);
          //document.getElementById("loading").style.display = "none";
          //取消同一起始点多次分析时使用如下代码：
          //vlhandler = vlhandler && vlhandler.destroy();
          //vcisFirst = true;
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      vlhandler.setInputAction(function () {
        //move事件监听
        vlhandler = vlhandler && vlhandler.destroy();
        vcisFirst = true;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    };

    return CesiumVisibleLine;
  }

  if (typeof (CesiumVisibleLine) === 'undefined') {
    window.CesiumVisibleLine = define_CesiumVisibleLine();
  } else {
    console.log("CesiumVisibleLine already defined.");
  }
})(window);
