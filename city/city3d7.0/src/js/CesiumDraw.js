/*
 * draw tools
 */

(function (window) {
  'use strict';

  function define_CesiumDraw() {
    //Main object
    var CesiumDraw = {};
    var drawHandler;
    var pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签

    /*
     * options = {
     * 		'viewer':viewer,
     * 		'polygoncolor':Cesium.Color.YELLOW,
     * 		'pointcolor':Cesium.Color.RED,
     * 		'printId':'textid',
     * 		'type':'net',
     * };
     * */
    //绘制多边形面
    var drawpointArr = [];
    CesiumDraw.drawPolygon = function (options) {
      var positions = [];
      var activeShapePoints = [];
      var activeShapePointsgeo = [];
      drawHandler = drawHandler && drawHandler.destroy();
      drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        var earthPosition = options.viewer.scene.pickPosition(movement.position);
        var cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        var height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          var ray = options.viewer.camera.getPickRay(movement.position);
          earthPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        }
        var longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
        var latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
        var heightString = cartographic.height;
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          activeShapePointsgeo.push(cartographic);
          if (activeShapePoints.length > 3) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        var newPosition = options.viewer.scene.pickPosition(movement.endPosition);
        var cartographic = Cesium.Cartographic.fromCartesian(newPosition);
        var height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          var ray = options.viewer.camera.getPickRay(movement.endPosition);
          newPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
        }
        activeShapePoints.pop();
        activeShapePoints.push(newPosition);
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      drawHandler.setInputAction(function (movement) {
        drawHandler = drawHandler && drawHandler.destroy();
        var tempPointsStr = '';
        if (activeShapePointsgeo.length > 2) {
          for (var pindex = 0; pindex < activeShapePointsgeo.length; pindex++) {
            var longitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].longitude);
            var latitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].latitude);
            var heightString = activeShapePointsgeo[pindex].height;
            if (options.type == 'net') {
              tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
            } else {
              tempPointsStr += longitudeString + "," + latitudeString + ","; //+heightString+","
            }
          }
          document.getElementById(options.printId).value = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        drawpointArr.push(options.viewer.entities.add({
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
        if ((options.viewer.entities.getById('areaEntity') !== undefined)) {
          options.viewer.entities.removeById('areaEntity');
        }
        options.viewer.entities.add({
          id: 'areaEntity',
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
    };

    /*var options = {
        'viewer':viewer,
        'polylinecolor':Cesium.Color.YELLOW,
        'pointcolor':Cesium.Color.RED,
        'printId':'textid',
        'text':'证'
    };*/
    var lineDrawMarkArr = [];
    CesiumDraw.drawPolyline = function (options) {
      drawHandler = drawHandler && drawHandler.destroy();
      if ((options.viewer.entities.getById('dynamicLineGroundEntity') !== undefined)) {
        options.viewer.entities.removeById('dynamicLineGroundEntity');
      }
      if ((options.viewer.entities.getById('measureLineGroundEntity') !== undefined)) {
        options.viewer.entities.removeById('measureLineGroundEntity');
      }
      for (var i = 0; i < lineDrawMarkArr.length; i++) {
        options.viewer.entities.remove(lineDrawMarkArr[i]);
      }
      lineDrawMarkArr = [];
      var isFirst = true;//是否为第一个点
      var previousPosition;//前一个点的坐标
      var currentPosition;//当前点坐标
      var dynamicLineGroundEntity = options.viewer.entities.add({
        id: 'dynamicLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: Cesium.Color.RED,
        }
      });
      //已输入的线段的entity
      var measureLineGroundEntity = options.viewer.entities.add({
        id: 'measureLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: options.polylinecolor,
        }
      });

      //节点添加标签
      function addPin(carPoi) {
        lineDrawMarkArr.push(options.viewer.entities.add({
          position: carPoi,
          point: {
            pixelSize: 10,
            color: options.pointcolor,
            disableDepthTestDistance: 5000000,
            outlineWidth: 2,
            outlineColor: Cesium.Color.WHITE.withAlpha(1)
          },
        }));
      }

      var measureLinePositonsArray = [];//存储已量测的线段的折点
      drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        if (isFirst) {
          previousPosition = options.viewer.scene.pickPosition(movement.position);
          var cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.position);
            previousPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          var tmp1 = previousPosition.clone();
          measureLinePositonsArray.push(tmp1);
          isFirst = false;
          addPin(tmp1);
        } else {
          currentPosition = options.viewer.scene.pickPosition(movement.position);
          var cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.position);
            currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          var tmp2 = currentPosition.clone();
          measureLinePositonsArray.push(tmp2);
          measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
          previousPosition = currentPosition.clone();
          addPin(tmp2);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        if (!isFirst) {
          //获取当前点的坐标
          currentPosition = options.viewer.scene.pickPosition(movement.endPosition);
          var cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.endPosition);
            currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          if (currentPosition) {
            dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
          }
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      drawHandler.setInputAction(function () {
        drawHandler = drawHandler && drawHandler.destroy();
        var tempPointsStr = '';
        for (var i = 0; i < measureLinePositonsArray.length; i++) {
          var cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
          var longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
          var latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
          var heightString = cartographic.height;
          tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
        }
        document.getElementById(options.printId).value = tempPointsStr.substring(0, tempPointsStr.length - 1);
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    }

    CesiumDraw.drawPoint = function (options) {
      drawHandler = drawHandler && drawHandler.destroy();
      drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        var cartesian = options.viewer.scene.pickPosition(movement.position);
        var cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        var height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          var ray = options.viewer.camera.getPickRay(movement.position);
          cartesian = options.viewer.scene.globe.pick(ray, options.viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        var lng = Cesium.Math.toDegrees(cartographic.longitude);
        var lat = Cesium.Math.toDegrees(cartographic.latitude);
        var poiResult = lng + "," + lat + "," + height;
        document.getElementById(options.printId).value = poiResult;
        var drawPointEntity = options.viewer.entities.getById("drawPointEntity");
        if (drawPointEntity == undefined) {
          options.viewer.entities.add({
            id: 'drawPointEntity',
            position: cartesian.clone(),
            billboard: {
              image: pinBuilder.fromText(options.text, options.pointcolor, options.size).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.33, 0.65, 0.5),
              material: options.pointcolor.withAlpha(0.7)
            }
          });
        } else {
          drawPointEntity.position = cartesian.clone();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
    }

    var wallDrawMarkArr = [];
    CesiumDraw.drawWall = function (options) {
      wallDrawMarkArr = [];
      var isFirst = true;//是否为第一个点
      var previousPosition;//前一个点的坐标
      var currentPosition;//当前点坐标
      var dynamicLineGroundEntity = options.viewer.entities.add({
        id: 'dynamicLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: Cesium.Color.RED,
        }
      });
      //已输入的线段的entity
      var measureLineGroundEntity = options.viewer.entities.add({
        id: 'measureLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: options.wallcolor,
        }
      });

      //节点添加标签
      function addPin(carPoi) {
        wallDrawMarkArr.push(options.viewer.entities.add({
          position: carPoi,
          point: {
            pixelSize: 10,
            color: options.pointcolor,
            disableDepthTestDistance: 5000000,
            outlineWidth: 2,
            outlineColor: Cesium.Color.WHITE.withAlpha(1)
          },
        }));
      }

      var measureLinePositonsArray = [];//存储已量测的线段的折点
      drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        if (isFirst) {
          previousPosition = options.viewer.scene.pickPosition(movement.position);
          var cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.position);
            previousPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          var tmp1 = previousPosition.clone();
          measureLinePositonsArray.push(tmp1);
          isFirst = false;
          addPin(tmp1);
        } else {
          currentPosition = options.viewer.scene.pickPosition(movement.position);
          var cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.position);
            currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          var tmp2 = currentPosition.clone();
          measureLinePositonsArray.push(tmp2);
          measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
          previousPosition = currentPosition.clone();
          addPin(tmp2);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        if (!isFirst) {
          //获取当前点的坐标
          currentPosition = options.viewer.scene.pickPosition(movement.endPosition);
          var cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          var height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            var ray = options.viewer.camera.getPickRay(movement.endPosition);
            currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          if (currentPosition) {
            dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
          }
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      drawHandler.setInputAction(function () {
        drawHandler = drawHandler && drawHandler.destroy();
        var tempPointsStr = '';
        var tempPosArr = [];
        var minimumHeights = [];
        var measureResult = 0;
        for (var i = 0; i < measureLinePositonsArray.length; i++) {
          var cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
          var longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
          var latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
          var heightString = cartographic.height;
          tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          tempPosArr.push(Number(longitudeString), Number(latitudeString), Number(heightString) + options.wallHeight);
          minimumHeights.push(Number(heightString));
        }

        var cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[0]);
        var longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
        var latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
        var heightString = cartographic.height;
        tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
        tempPosArr.push(Number(longitudeString), Number(latitudeString), Number(heightString) + options.wallHeight);
        minimumHeights.push(Number(heightString));

        tempPointsStr = tempPointsStr.substring(0, tempPointsStr.length - 1);
        document.getElementById(options.printId).value = tempPointsStr;
        options.viewer.entities.remove(dynamicLineGroundEntity);
        options.viewer.entities.remove(measureLineGroundEntity);
        for (var i = 0; i < wallDrawMarkArr.length; i++) {
          options.viewer.entities.remove(wallDrawMarkArr[i]);
        }
        options.viewer.entities.add({
          wall: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(tempPosArr),
            material: options.wallcolor.withAlpha(0.5),
            minimumHeights: minimumHeights,
          },
        });
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    }

    CesiumDraw.clearDraw = function (options) {
      for (var i = 0; i < drawpointArr.length; i++) {
        options.viewer.entities.remove(drawpointArr[i]);
      }
      if ((options.viewer.entities.getById('areaEntity') !== undefined)) {
        options.viewer.entities.removeById('areaEntity');
      }
      if ((options.viewer.entities.getById('dynamicLineGroundEntity') !== undefined)) {
        options.viewer.entities.removeById('dynamicLineGroundEntity');
      }
      if ((options.viewer.entities.getById('measureLineGroundEntity') !== undefined)) {
        options.viewer.entities.removeById('measureLineGroundEntity');
      }
      if ((options.viewer.entities.getById('drawPointEntity') !== undefined)) {
        options.viewer.entities.removeById('drawPointEntity');
      }
      for (var i = 0; i < lineDrawMarkArr.length; i++) {
        options.viewer.entities.remove(lineDrawMarkArr[i]);
      }
      lineDrawMarkArr.length = 0;
      for (var i = 0; i < wallDrawMarkArr.length; i++) {
        options.viewer.entities.remove(wallDrawMarkArr[i]);
      }
      wallDrawMarkArr.length = 0;
    }

    CesiumDraw.clearDrawHandler = function () {
      drawHandler = drawHandler && drawHandler.destroy();
    }

    return CesiumDraw;
  }

  if (typeof (CesiumDraw) === 'undefined') {
    window.CesiumDraw = define_CesiumDraw();
  } else {
    console.log("CesiumDraw already defined.");
  }
})(window);
