(function (window) {
  'use strict';

  function define_CesiumPlan() {
    //Main object
    let CesiumPlan = {};
    let drawHandler;
    let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
    let isRightOver = true;
    let ePlanCon = [];
    let particleCollectionArr = [];
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
    let drawpointArr = [];
    CesiumPlan.drawPolygon = function (options) {
      if (isRightOver) {
        isRightOver = false;
        let activeShapePoints = [];
        let activeShapePointsgeo = [];
        let pointCount = 1;
        drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          let earthPosition = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
          let height = cartographic.height; //模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            earthPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
          }
          if (Cesium.defined(earthPosition)) {
            activeShapePoints.push(earthPosition);
            activeShapePointsgeo.push(cartographic);
            if (activeShapePoints.length > 3) {
              drawPolygon();
            }
            createPoint(earthPosition, String(pointCount));
            pointCount++;
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          let newPosition = options.viewer.scene.pickPosition(movement.endPosition);
          let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
          let height = cartographic.height; //模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.endPosition);
            newPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          activeShapePoints.pop();
          activeShapePoints.push(newPosition);
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        drawHandler.setInputAction(function (movement) {
          drawHandler = drawHandler && drawHandler.destroy();
          let tempPointsStr = '';
          if (activeShapePointsgeo.length > 2) {
            for (let pindex = 0; pindex < activeShapePointsgeo.length; pindex++) {
              let longitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].longitude);
              let latitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].latitude);
              let heightString = activeShapePointsgeo[pindex].height;
              tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
            }
            tempPointsStr = tempPointsStr.substring(0, tempPointsStr.length - 1);
            let ePlanConStr = '{'
              + '\"id\":\"' + options.polylineId + '\",'
              + '\"type\":\"' + 'Polygon_' + options.type + '\",'
              + '\"poi\":\"' + tempPointsStr + '\"'
              + '};';
            ePlanCon.push(ePlanConStr);
          } else {
            alert('至少指定三个顶点！');
          }
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }

      function createPoint(worldPosition, i) {
        drawpointArr.push(options.viewer.entities.add({
          id: String(options.polylineId) + i,
          position: worldPosition,
          point: {
            color: options.pointcolor,
            pixelSize: 10,
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE,
            disableDepthTestDistance: 10000
          }
        }));
      }

      function drawPolygon() {
        if ((options.viewer.entities.getById(options.polylineId) !== undefined)) {
          options.viewer.entities.removeById(options.polylineId);
        }
        options.viewer.entities.add({
          id: options.polylineId,
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
                    return activeShapePoints;
                }, false),*/
            material: new Cesium.ColorMaterialProperty(options.polygoncolor),
            classificationType: Cesium.ClassificationType.BOTH,
            outline: true,
            outlineColor: Cesium.Color.WHITE
          }
        });
      }
    };

    /*let options = {
        'viewer':viewer,
        'polylinecolor':Cesium.Color.YELLOW,
        'pointcolor':Cesium.Color.RED,
        'printId':'textid',
        'text':'证'
    };*/
    let lineDrawMarkArr = [];
    CesiumPlan.drawPolyline = function (options) {
      if (isRightOver) {
        isRightOver = false;
        lineDrawMarkArr = [];
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let pointCount = 1;
        let dynamicLineGroundEntity = options.viewer.entities.add({
          id: 'dynamicLineGroundEntity' + options.polylineId,
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureLineGroundEntity = options.viewer.entities.add({
          id: options.polylineId,
          polyline: {
            clampToGround: true,
            width: 3,
            material: options.polylinecolor,
          }
        });

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          if (isFirst) {
            previousPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              previousPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp1 = previousPosition.clone();
            measureLinePositonsArray.push(tmp1);
            isFirst = false;
            addPin(tmp1, String(pointCount));
          } else {
            currentPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp2 = currentPosition.clone();
            measureLinePositonsArray.push(tmp2);
            measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
            previousPosition = currentPosition.clone();
            addPin(tmp2, String(pointCount));
          }
          pointCount++;
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          if (!isFirst) {
            //获取当前点的坐标
            currentPosition = options.viewer.scene.pickPosition(movement.endPosition);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.endPosition);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            if (currentPosition) {
              dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        drawHandler.setInputAction(function () {
          drawHandler = drawHandler && drawHandler.destroy();
          let tempPointsStr = '';
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          tempPointsStr = tempPointsStr.substring(0, tempPointsStr.length - 1);
          let ePlanConStr = '{'
            + '\"id\":\"' + options.polylineId + '\",'
            + '\"type\":\"' + 'Polyline_' + options.type + '\",'
            + '\"poi\":\"' + tempPointsStr + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }

      //节点添加标签
      function addPin(carPoi, i) {
        lineDrawMarkArr.push(options.viewer.entities.add({
          id: String(options.polylineId) + i,
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
    };

    CesiumPlan.drawPoint = function (options) {
      if (isRightOver) {
        isRightOver = false;
        let poiResult = '';
        drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            cartesian = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          height = cartographic.height;//地形高度
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          poiResult = lng + "," + lat + "," + height;
          let billboardgraphic;
          if (options.type === 'caseimg') {
            billboardgraphic = {
              image: common.serverIp + 'city3dfile/' + options.poiimg,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
            };
          } else {
            billboardgraphic = {
              image: pinBuilder.fromUrl(common.serverIp + 'city3dfile/' + options.poiimg, options.pointcolor, options.size),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
            };
          }
          let drawPointEntity = options.viewer.entities.getById(options.pointId);
          if (drawPointEntity === undefined) {
            options.viewer.entities.add({
              id: options.pointId,
              position: cartesian.clone(),
              billboard: billboardgraphic
            });
          } else {
            drawPointEntity.position = cartesian.clone();
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          drawHandler = drawHandler && drawHandler.destroy();
          isRightOver = true;
          let ePlanConStr = '{'
            + '\"id\":\"' + options.pointId + '\",'
            + '\"type\":\"' + 'Point_' + options.type + '\",'
            + '\"size\":\"' + options.size + '\",'
            + '\"poi\":\"' + poiResult + '\",'
            + '\"poiimg\":\"' + options.poiimg + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }
    };

    let wallDrawMarkArr = [];
    CesiumPlan.drawWall = function (options) {
      if (isRightOver) {
        isRightOver = false;
        wallDrawMarkArr = [];
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicLineGroundEntity = options.viewer.entities.add({
          id: 'dynamicLineGroundEntity' + options.polylineId,
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureLineGroundEntity = options.viewer.entities.add({
          id: options.polylineId,
          polyline: {
            clampToGround: true,
            width: 3,
            material: options.polylinecolor,
          }
        });

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          if (isFirst) {
            previousPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              previousPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp1 = previousPosition.clone();
            measureLinePositonsArray.push(tmp1);
            isFirst = false;
            addPin(tmp1);
          } else {
            currentPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp2 = currentPosition.clone();
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
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.endPosition);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            if (currentPosition) {
              dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        drawHandler.setInputAction(function () {
          drawHandler = drawHandler && drawHandler.destroy();
          let tempPointsStr = '';
          let tempPosArr = [];
          let minimumHeights = [];
          let measureResult = 0;
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
            tempPosArr.push(Number(longitudeString), Number(latitudeString), Number(heightString) + options.wallHeight);
            minimumHeights.push(Number(heightString));
            if (i < measureLinePositonsArray.length - 1) {
              measureResult += Cesium.Cartesian3.distance(measureLinePositonsArray[i], measureLinePositonsArray[i + 1]);
            }
          }
          let repeat;
          if (options.wallType === 'wall7') {
            repeat = new Cesium.Cartesian2(measureResult / 6, 1.0);
          } else if (options.wallType === 'wall8') {
            repeat = new Cesium.Cartesian2(measureResult / 2, 1.0);
          }
          options.polylinecolor.repeat = repeat;
          tempPointsStr = tempPointsStr.substring(0, tempPointsStr.length - 1);
          options.viewer.entities.remove(dynamicLineGroundEntity);
          options.viewer.entities.remove(measureLineGroundEntity);
          for (let i = 0; i < wallDrawMarkArr.length; i++) {
            options.viewer.entities.remove(wallDrawMarkArr[i]);
          }
          options.viewer.entities.add({
            id: options.polylineId,
            wall: {
              positions: Cesium.Cartesian3.fromDegreesArrayHeights(tempPosArr),
              material: options.polylinecolor,
              minimumHeights: minimumHeights,
            },
          });
          let ePlanConStr = '{'
            + '\"id\":\"' + options.polylineId + '\",'
            + '\"type\":\"' + 'Wall_' + options.wallType + '\",'
            + '\"wallHeight\":\"' + options.wallHeight + '\",'
            + '\"wallImg\":\"' + options.pointcolor.image + '\",'
            + '\"poi\":\"' + tempPointsStr + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }

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
    };

    CesiumPlan.drawModel = function (options) {
      if (isRightOver) {
        isRightOver = false;
        let poiResult = '';
        drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            cartesian = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          height = cartographic.height;//地形高度
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          poiResult = lng + "," + lat + "," + height;
          let hpr = new Cesium.HeadingPitchRoll(Cesium.Math.toRadians(Number(options.modelHeading)), 0, 0);
          let orientation = Cesium.Transforms.headingPitchRollQuaternion(cartesian, hpr);
          let drawPointEntity = options.viewer.entities.getById(options.modelId);
          if (drawPointEntity === undefined) {
            options.viewer.entities.add({
              id: options.modelId,
              position: cartesian.clone(),
              orientation: orientation,
              model: {
                uri: common.serverIp + 'city3dfile/' + options.modelUrl,
                scale: options.modelScale,
                silhouetteColor: Cesium.Color.WHITE,
                silhouetteSize: 0.5
              }
            });
          } else {
            drawPointEntity.position = cartesian.clone();
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          drawHandler = drawHandler && drawHandler.destroy();
          let ePlanConStr = '{'
            + '\"id\":\"' + options.modelId + '\",'
            + '\"type\":\"' + 'Model_' + options.type + '\",'
            + '\"modelUrl\":\"' + options.modelUrl + '\",'
            + '\"modelHeading\":\"' + options.modelHeading + '\",'
            + '\"modelScale\":\"' + options.modelScale + '\",'
            + '\"modelHeight\":\"' + options.modelHeight + '\",'
            + '\"modelName\":\"' + options.modelName + '\",'
            + '\"poi\":\"' + poiResult + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }
    };

    CesiumPlan.drawLabel = function (options) {
      if (isRightOver) {
        isRightOver = false;
        let poiResult = '';
        drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            cartesian = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          height = cartographic.height;//地形高度
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          poiResult = lng + "," + lat + "," + height;
          let textlength = options.labelText.length;
          let billboardpixelOffset;
          let labelpixelOffset;
          let imgurl;
          if (textlength < 5) {
            imgurl = common.serverIp + 'city3dfile/' + options.labelImg + 'S.png';
            labelpixelOffset = new Cesium.Cartesian2(49.0, -135.0);
            billboardpixelOffset = new Cesium.Cartesian2(36.0, 0.0);
          } else if (4 < textlength && textlength < 9) {
            imgurl = common.serverIp + 'city3dfile/' + options.labelImg + 'M.png';
            labelpixelOffset = new Cesium.Cartesian2(85.0, -135.0);
            billboardpixelOffset = new Cesium.Cartesian2(72.0, 0.0);
          } else {
            imgurl = common.serverIp + 'city3dfile/' + options.labelImg + 'L.png';
            labelpixelOffset = new Cesium.Cartesian2(122.0, -135.0);
            billboardpixelOffset = new Cesium.Cartesian2(109.0, 0.0);
          }
          let drawPointEntity = options.viewer.entities.getById(options.pointId);
          if (drawPointEntity === undefined) {
            options.viewer.entities.add({
              position: cartesian,
              id: options.pointId,
              billboard: {
                image: imgurl,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                pixelOffset: billboardpixelOffset,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              },
              label: {
                show: true,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                font: 'bold 32px Helvetica',
                scale: 0.5,
                fillColor: Cesium.Color.WHITE,
                text: options.labelText,
                pixelOffset: labelpixelOffset,
                disableDepthTestDistance: 10000000,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              }
            });
          } else {
            drawPointEntity.position = cartesian.clone();
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          drawHandler = drawHandler && drawHandler.destroy();
          let ePlanConStr = '{'
            + '\"id\":\"' + options.pointId + '\",'
            + '\"type\":\"' + 'Label_' + options.type + '\",'
            + '\"labelImg\":\"' + options.labelImg + '\",'
            + '\"labelText\":\"' + options.labelText + '\",'
            + '\"poi\":\"' + poiResult + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }
    };

    CesiumPlan.drawParticle = function (options) {
      if (isRightOver) {
        isRightOver = false;
        particleCollectionArr.push(options.particleCollection);
        let poiResult = '';
        drawHandler = drawHandler && drawHandler.destroy();
        drawHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          //获取鼠标点击处的坐标
          let cartesian = options.viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = options.viewer.camera.getPickRay(movement.position);
            cartesian = options.viewer.scene.globe.pick(ray, options.viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          height = cartographic.height;//地形高度
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          poiResult = lng + "," + lat + "," + height;
          let highpos = new Cesium.Cartesian3.fromDegrees(lng, lat, height);
          let drawPointEntity = options.viewer.entities.getById(options.particleId);
          if (drawPointEntity === undefined) {
            let particleEntity = options.viewer.entities.add({
              id: options.particleId,
              position: highpos,
            });
            addParticleSystem(particleEntity);
          } else {
            drawPointEntity.position = highpos;
            options.particleCollection.removeAll();
            addParticleSystem(drawPointEntity);
          }

          function addParticleSystem(particleEntity) {
            function computeModelMatrix(entity, time) {
              let position = Cesium.Property.getValueOrUndefined(entity.position);
              let modelMatrix = Cesium.Transforms.eastNorthUpToFixedFrame(position);
              return modelMatrix;
            }

            function computeEmitterModelMatrix() {
              let hpr = Cesium.HeadingPitchRoll.fromDegrees(0, 0, 0);
              let trs = new Cesium.TranslationRotationScale();
              trs.translation = Cesium.Cartesian3.fromElements(2.5, 4, 1);
              trs.rotation = Cesium.Quaternion.fromHeadingPitchRoll(hpr);
              let result = Cesium.Matrix4.fromTranslationRotationScale(trs);
              return result;
            }

            options.particleCollection.add(new Cesium.ParticleSystem({
              image: common.serverIp + 'city3dfile/' + options.particleImg,
              startColor: Cesium.Color.RED.withAlpha(0.7),
              endColor: Cesium.Color.YELLOW.withAlpha(0.2),
              startScale: 0,
              endScale: Number(options.endScale),
              minimumParticleLife: 1,
              maximumParticleLife: 6,
              minimumSpeed: 1,
              maximumSpeed: 4,
              minimumImageSize: new Cesium.Cartesian2(15, 15),
              maximumImageSize: new Cesium.Cartesian2(45, 45),
              //imageSize : new Cesium.Cartesian2(55, 55),
              emissionRate: 4,
              lifetime: 160.0,
              emitter: new Cesium.CircleEmitter(Number(options.emitterRadius)),
              modelMatrix: computeModelMatrix(particleEntity, Cesium.JulianDate.now()),
              emitterModelMatrix: computeEmitterModelMatrix()
            }));
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          drawHandler = drawHandler && drawHandler.destroy();
          let ePlanConStr = '{'
            + '\"id\":\"' + options.particleId + '\",'
            + '\"type\":\"' + 'Particle_' + options.type + '\",'
            + '\"endScale\":\"' + options.endScale + '\",'
            + '\"particleImg\":\"' + options.particleImg + '\",'
            + '\"emitterRadius\":\"' + options.emitterRadius + '\",'
            + '\"poi\":\"' + poiResult + '\"'
            + '};';
          ePlanCon.push(ePlanConStr);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }
    };

    let roamStart, roamStop;
    function ComputeRoamingLineProperty(viewer, Lines, time, isRe) {
      let property = new Cesium.SampledPositionProperty();
      let lineLength = Lines.length;
      let tempTime = time - time % lineLength;
      let increment = tempTime / lineLength;
      roamStart = Cesium.JulianDate.now();
      roamStop = Cesium.JulianDate.addSeconds(roamStart, tempTime, new Cesium.JulianDate());

      viewer.clock.startTime = roamStart.clone();
      viewer.clock.stopTime = roamStop.clone();
      viewer.clock.currentTime = roamStart.clone();
      viewer.clock.clockRange = isRe ? Cesium.ClockRange.LOOP_STOP : Cesium.ClockRange.CLAMPED; // Loop at the end
      viewer.clock.multiplier = 2;

      for (let i = 0; i < lineLength; i++) {
        let timesample = Cesium.JulianDate.addSeconds(roamStart, i * increment, new Cesium.JulianDate());
        let position = Lines[i];
        property.addSample(timesample, position);
      }
      return property;
    }

    /**
     * @param {*} position computeRoamingLineProperty计算的属性
     * @param {*} start 开始时间节点
     * @param {*} stop 结束时间节点
     * @param {*} isPathShow path路径是否显示
     * @memberof Roaming
     */
    let roamEntity;
    CesiumPlan.initRoaming = function (options) {
      let lineArrtemp = options.lines.split(',');
      let lineArr = [];
      for (let i = 0; i < lineArrtemp.length; i = i + 3) {
        let linepoint = Cesium.Cartesian3.fromDegrees(Number(lineArrtemp[i]), Number(lineArrtemp[i + 1]), Number(lineArrtemp[i + 2]));
        lineArr.push(linepoint);
      }
      let roamproperty = ComputeRoamingLineProperty(options.viewer, lineArr, options.speed, options.isRe);
      let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
      roamEntity = options.viewer.entities.add({
        id: options.roamId,
        availability: new Cesium.TimeIntervalCollection([new Cesium.TimeInterval({
          start: roamStart,
          stop: roamStop
        })]),
        position: roamproperty,// 位置
        orientation: orientationproperty,
        path: {
          resolution: 1,
          material: new Cesium.PolylineGlowMaterialProperty({
            glowPower: 0.1,
            color: Cesium.Color.YELLOW
          }),
          width: 10,
          show: options.isPathShow
        }
      });
      if (options.roamtype === 'img') {
        let billboard = new Cesium.BillboardGraphics({
          image: common.serverIp + 'city3dfile/' + options.modeluri,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          scale: options.scale,
        });
        roamEntity.billboard = billboard;
      } else {
        // 加载模型
        let model = new Cesium.ModelGraphics({
          uri: common.serverIp + 'city3dfile/' + options.modeluri,// 模型路径
          minimumPixelSize: 32,// 模型最小刻度
          maximumSize: 128,
          maximumScale: 200,// 设置模型最大放大大小
          silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
          // color: color,// 模型颜色  ，这里可以设置颜色的变化
          debugWireframe: false,// 仅用于调试，显示魔仙绘制时的线框
          debugShowBoundingVolume: false,// 仅用于调试。显示模型绘制时的边界球。
          scale: options.scale,
          runAnimations: true // 是否运行模型中的动画效果
        });
        roamEntity.model = model;
      }
      if (options.type === '平滑线') {
        roamEntity.position.setInterpolationOptions({ // 点插值
          interpolationDegree: 5,
          interpolationAlgorithm: Cesium.LagrangePolynomialApproximation
        });
      }
      if (options.roamIsmodelshow) {
        options.viewer.trackedEntity = roamEntity;
      }
      let ePlanConStr = '{'
        + '\"id\":\"' + options.roamId + '\",'
        + '\"modeluri\":\"' + options.modeluri + '\",'
        + '\"type\":\"' + 'Roam_' + options.modeltype + '\",'
        + '\"scale\":\"' + options.scale + '\",'
        + '\"speed\":\"' + options.speed + '\",'
        + '\"roamtype\":\"' + options.roamtype + '\",'
        + '\"poi\":\"' + options.lines + '\"'
        + '};';
      ePlanCon.push(ePlanConStr);
    };
    /**
     *漫游的暂停和继续
     *
     * @param {*} state bool类型 false为暂停，ture为继续
     * @memberof Roaming
     */
    CesiumPlan.PauseOrContinue = function (viewer, state) {
      viewer.clock.shouldAnimate = state;
    };
    /**
     *改变飞行的速度
     *
     * @param {*} value  整数类型
     * @memberof Roaming
     */
    CesiumPlan.ChangeRoamingSpeed = function (viewer, value) {
      viewer.clock.multiplier = value;
    };
    /**
     *取消漫游
     * @memberof Roaming
     */
    CesiumPlan.EndRoaming = function (viewer) {
      if (roamEntity !== undefined) {
        viewer.entities.remove(roamEntity);
      }
    };

    let roamDrawMarkArr = [];
    let roamHandler;
    CesiumPlan.drawRoamDraw = function (options) {
      if (isRightOver) {
        isRightOver = false;
        roamHandler = roamHandler && roamHandler.destroy();
        CesiumPlan.clearRoamDraw(options.viewer);
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicRoamGroundEntity = options.viewer.entities.add({
          id: 'dynamicRoamGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureRoamGroundEntity = options.viewer.entities.add({
          id: 'measureRoamGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: options.polylinecolor,
          }
        });

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        roamHandler = new Cesium.ScreenSpaceEventHandler(options.viewer.scene.canvas);
        roamHandler.setInputAction(function (movement) {
          if (isFirst) {
            previousPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              previousPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp1 = previousPosition.clone();
            measureLinePositonsArray.push(tmp1);
            isFirst = false;
            addPin(tmp1);
          } else {
            currentPosition = options.viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.position);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            let tmp2 = currentPosition.clone();
            measureLinePositonsArray.push(tmp2);
            measureRoamGroundEntity.polyline.positions = measureLinePositonsArray;
            previousPosition = currentPosition.clone();
            addPin(tmp2);
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        roamHandler.setInputAction(function (movement) {
          if (!isFirst) {
            //获取当前点的坐标
            currentPosition = options.viewer.scene.pickPosition(movement.endPosition);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = options.viewer.camera.getPickRay(movement.endPosition);
              currentPosition = options.viewer.scene.globe.pick(ray, options.viewer.scene);
            }
            if (currentPosition) {
              dynamicRoamGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        roamHandler.setInputAction(function () {
          roamHandler = roamHandler && roamHandler.destroy();
          let tempPointsStr = '';
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height + options.roamHeight;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          document.getElementById(options.printId).value = tempPointsStr.substring(0, tempPointsStr.length - 1);
          isRightOver = true;
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      } else {
        alert('请先结束前一绘制操作！');
      }

      //节点添加标签
      function addPin(carPoi) {
        roamDrawMarkArr.push(options.viewer.entities.add({
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
    };

    CesiumPlan.clearRoamDraw = function (viewer) {
      if ((viewer.entities.getById('dynamicRoamGroundEntity') !== undefined)) {
        viewer.entities.removeById('dynamicRoamGroundEntity');
      }
      if ((viewer.entities.getById('measureRoamGroundEntity') !== undefined)) {
        viewer.entities.removeById('measureRoamGroundEntity');
      }
      for (let i = 0; i < roamDrawMarkArr.length; i++) {
        viewer.entities.remove(roamDrawMarkArr[i]);
      }
      roamDrawMarkArr = [];
    };

    CesiumPlan.clearDraw = function (viewer) {
      viewer.entities.removeAll();
      drawpointArr.length = 0;
      lineDrawMarkArr.length = 0;
      wallDrawMarkArr.length = 0;
      for (let i = 0; i < particleCollectionArr.length; i++) {
        particleCollectionArr[i].removeAll();
      }
      ePlanCon.length = 0;
    };

    CesiumPlan.clearDrawHandler = function () {
      drawHandler = drawHandler && drawHandler.destroy();
    };

    CesiumPlan.stopDraw = function () {
      isRightOver = true;
    };

    CesiumPlan.getEplanCon = function () {
      return ePlanCon;
    };

    CesiumPlan.deleteDraw = function (viewer, id) {
      if ((viewer.entities.getById(id) !== undefined)) {
        viewer.entities.removeById(id);
        if ((viewer.entities.getById('dynamicLineGroundEntity' + id) !== undefined)) {
          viewer.entities.removeById('dynamicLineGroundEntity' + id);
        }
        for (let i = 1; i < 1000; i++) {
          if ((viewer.entities.getById(String(id) + i) !== undefined)) {
            viewer.entities.removeById(String(id) + i);
          } else {
            break;
          }
        }
        for (let j = 0; j < ePlanCon.length; j++) {
          let ePlanConjson = ePlanCon[j].substring(0, ePlanCon[j].length - 1);
          let eplanObj = JSON.parse(ePlanConjson);
          if (eplanObj.id === id) {
            ePlanCon.splice(j, 1);
          }
        }
      }
    };

    CesiumPlan.deleteLastParticle = function () {
      if (particleCollectionArr.length > 0) {
        particleCollectionArr[particleCollectionArr.length - 1].removeAll();
        particleCollectionArr.splice(particleCollectionArr.length - 1, 1);
      }
    };

    CesiumPlan.addAllPlan = function (eplanStr, viewer) {
      function checkcolor(type) {
        let color;
        switch (type) {
          case 'blue':
            color = Cesium.Color.ROYALBLUE;
            break;
          case 'red':
            color = Cesium.Color.RED;
            break;
          case 'green':
            color = Cesium.Color.GREEN;
            break;
          case 'yellow':
            color = Cesium.Color.GOLD;
            break;
          case 'purple':
            color = Cesium.Color.PURPLE;
            break;
          case 'orange':
            color = Cesium.Color.DARKORANGE;
            break;
          default:
            color = Cesium.Color.WHITE;
            break;
        }
        return color;
      }

      let eplanArr = eplanStr.split(';;');
      for (let j = 0; j < eplanArr.length - 1; j++) {
        ePlanCon.push(eplanArr[j] + ';');
        let eplanObj = JSON.parse(eplanArr[j]);
        let eplanType = eplanObj.type.split('_');
        switch (eplanType[0]) {
          case 'Point':
            let ppoiArr = eplanObj.poi.split(',');
            let billboardgraphic;
            if (eplanType[1] !== 'caseimg') {
              let color = checkcolor(eplanType[1]);
              billboardgraphic = {
                image: pinBuilder.fromUrl(common.serverIp + 'city3dfile/' + eplanObj.poiimg, color, Number(eplanObj.size)),
                // image: pinBuilder.fromUrl(eplanObj.poiimg, color, Number(eplanObj.size)),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              };
            } else {
              billboardgraphic = {
                image: common.serverIp + 'city3dfile/' + eplanObj.poiimg,
                // image: eplanObj.poiimg,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              };
            }
            viewer.entities.add({
              id: eplanObj.id,
              position: new Cesium.Cartesian3.fromDegrees(ppoiArr[0], ppoiArr[1], ppoiArr[2]),
              billboard: billboardgraphic
            });
            break;
          case 'Polyline':
            let lColor = checkcolor(eplanType[1]);
            let lPosCarArr = [];
            let lPosArr = eplanObj.poi.split(',');
            for (let i = 0; i < lPosArr.length; i = i + 3) {
              let point = new Cesium.Cartesian3.fromDegrees(lPosArr[i], lPosArr[i + 1], lPosArr[i + 2]);
              lPosCarArr.push(point);
              lineDrawMarkArr.push(viewer.entities.add({
                id: String(eplanObj.id) + (i / 3 + 1),
                position: point,
                point: {
                  pixelSize: 10,
                  color: lColor,
                  disableDepthTestDistance: 5000000,
                  outlineWidth: 2,
                  outlineColor: Cesium.Color.WHITE.withAlpha(1)
                },
              }));
            }
            viewer.entities.add({
              id: eplanObj.id,
              polyline: {
                positions: lPosCarArr,
                clampToGround: true,
                width: 3,
                material: lColor,
              }
            });
            break;
          case 'Polygon':
            let gColor = checkcolor(eplanType[1]);
            let gPosCarArr = [];
            let gPosArr = eplanObj.poi.split(',');
            for (let i = 0; i < gPosArr.length; i = i + 3) {
              let point = new Cesium.Cartesian3.fromDegrees(gPosArr[i], gPosArr[i + 1], gPosArr[i + 2]);
              gPosCarArr.push(point);
              drawpointArr.push(viewer.entities.add({
                id: String(eplanObj.id) + (i / 3 + 1),
                position: point,
                point: {
                  color: gColor,
                  pixelSize: 10,
                  outlineWidth: 1,
                  outlineColor: Cesium.Color.WHITE,
                  disableDepthTestDistance: 10000
                }
              }));
            }
            viewer.entities.add({
              id: eplanObj.id,
              polygon: {
                hierarchy: new Cesium.PolygonHierarchy(gPosCarArr),
                material: new Cesium.ColorMaterialProperty(gColor.withAlpha(0.5)),
                classificationType: Cesium.ClassificationType.BOTH,
                outline: true,
                outlineColor: Cesium.Color.WHITE
              }
            });
            break;
          case 'Wall':
            let color = checkcolor(eplanType[1]);
            color = color.withAlpha(0.5);
            let posCarArr = [];
            let posArr = eplanObj.poi.split(',');
            let minimumHeights = [];
            let measureResult = 0;
            for (let i = 0; i < posArr.length; i = i + 3) {
              let point = new Cesium.Cartesian3.fromDegrees(posArr[i], posArr[i + 1], Number(posArr[i + 2]) + Number(eplanObj.wallHeight));
              posCarArr.push(point);
              minimumHeights.push(Number(posArr[i + 2]));
            }
            if (eplanType[1] === 'wall7' || eplanType[1] === 'wall8') {
              for (let i = 0; i < posCarArr.length - 1; i++) {
                measureResult += Cesium.Cartesian3.distance(posCarArr[i], posCarArr[i + 1]);
              }
              let repeat;
              if (eplanType[1] === 'wall7') {
                repeat = new Cesium.Cartesian2(measureResult / 6, 1.0);
              } else if (eplanType[1] === 'wall8') {
                repeat = new Cesium.Cartesian2(measureResult / 2, 1.0);
              }
              color = new Cesium.ImageMaterialProperty({
                'image': common.serverIp + 'city3dfile/' + eplanObj.wallImg,
                // 'image': eplanObj.wallImg,
                'transparent': true,
                'repeat': repeat
              });
            }
            viewer.entities.add({
              id: eplanObj.id,
              wall: {
                positions: posCarArr,
                material: color,
                minimumHeights: minimumHeights,
              },
            });
            break;
          case 'Model':
            let mPoiArr = eplanObj.poi.split(',');
            let mPoint = new Cesium.Cartesian3.fromDegrees(mPoiArr[0], mPoiArr[1], mPoiArr[2] + Number(eplanObj.modelHeight));
            let hpr = new Cesium.HeadingPitchRoll(Cesium.Math.toRadians(Number(eplanObj.modelHeading)), 0, 0);
            let orientation = Cesium.Transforms.headingPitchRollQuaternion(mPoint, hpr);
            viewer.entities.add({
              id: eplanObj.id,
              position: mPoint,
              orientation: orientation,
              model: {
                uri: common.serverIp + 'city3dfile/' + eplanObj.modelUrl,
                // uri: eplanObj.modelUrl,
                scale: eplanObj.modelScale,
                silhouetteColor: Cesium.Color.WHITE,
                silhouetteSize: 0.5
              }
            });
            break;
          case 'Roam':
            let lineArrtemp = eplanObj.poi.split(',');
            let lineArr = [];
            for (let i = 0; i < lineArrtemp.length; i = i + 3) {
              let linepoint = Cesium.Cartesian3.fromDegrees(Number(lineArrtemp[i]), Number(lineArrtemp[i + 1]), Number(lineArrtemp[i + 2]));
              lineArr.push(linepoint);
            }
            let roamproperty = ComputeRoamingLineProperty(viewer, lineArr, Number(eplanObj.speed), true);
            let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
            roamEntity = viewer.entities.add({
              id: eplanObj.id,
              availability: new Cesium.TimeIntervalCollection([new Cesium.TimeInterval({
                start: roamStart,
                stop: roamStop
              })]),
              position: roamproperty,// 位置
              orientation: orientationproperty,
              path: {
                resolution: 1,
                material: new Cesium.PolylineGlowMaterialProperty({
                  glowPower: 0.1,
                  color: Cesium.Color.YELLOW
                }),
                width: 10,
                show: true
              }
            });
            if (eplanObj.roamtype === 'img') {
              let billboard = new Cesium.BillboardGraphics({
                image: common.serverIp + 'city3dfile/' + eplanObj.modeluri,
                // image: eplanObj.modeluri,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scale: Number(eplanObj.scale),
              });
              roamEntity.billboard = billboard;
            } else {
              // 加载模型
              let model = new Cesium.ModelGraphics({
                uri: common.serverIp + 'city3dfile/' + eplanObj.modeluri,// 模型路径
                // uri: eplanObj.modeluri,// 模型路径
                minimumPixelSize: 32,// 模型最小刻度
                maximumSize: 128,
                maximumScale: 200,// 设置模型最大放大大小
                silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
                // color: color,// 模型颜色  ，这里可以设置颜色的变化
                debugWireframe: false,// 仅用于调试，显示魔仙绘制时的线框
                debugShowBoundingVolume: false,// 仅用于调试。显示模型绘制时的边界球。
                scale: Number(eplanObj.scale),
                runAnimations: true // 是否运行模型中的动画效果
              });
              roamEntity.model = model;
            }
            break;
          case 'Label':
            let bPoiArr = eplanObj.poi.split(',');
            let bPoint = new Cesium.Cartesian3.fromDegrees(bPoiArr[0], bPoiArr[1], bPoiArr[2]);
            let textlength = eplanObj.labelText.length;
            let billboardpixelOffset;
            let labelpixelOffset;
            let imgurl;
            if (textlength < 5) {
              imgurl = common.serverIp + 'city3dfile/' + eplanObj.labelImg + 'S.png';
              // imgurl = eplanObj.labelImg + 'S.png';
              labelpixelOffset = new Cesium.Cartesian2(49.0, -135.0);
              billboardpixelOffset = new Cesium.Cartesian2(36.0, 0.0);
            } else if (4 < textlength && textlength < 9) {
              imgurl = common.serverIp + 'city3dfile/' + eplanObj.labelImg + 'M.png';
              // imgurl = eplanObj.labelImg + 'M.png';
              labelpixelOffset = new Cesium.Cartesian2(85.0, -135.0);
              billboardpixelOffset = new Cesium.Cartesian2(72.0, 0.0);
            } else {
              imgurl = common.serverIp + 'city3dfile/' + eplanObj.labelImg + 'L.png';
              // imgurl = eplanObj.labelImg + 'L.png';
              labelpixelOffset = new Cesium.Cartesian2(122.0, -135.0);
              billboardpixelOffset = new Cesium.Cartesian2(109.0, 0.0);
            }
            viewer.entities.add({
              position: bPoint,
              id: eplanObj.id,
              billboard: {
                image: imgurl,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                pixelOffset: billboardpixelOffset,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              },
              label: {
                show: true,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
                font: 'bold 32px Helvetica',
                scale: 0.5,
                fillColor: Cesium.Color.WHITE,
                text: eplanObj.labelText,
                pixelOffset: labelpixelOffset,
                disableDepthTestDistance: 10000000,
                scaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1000, 1, 20000, 0.2),
              }
            });
            break;
          case 'Particle':
            let particleCollection = new Cesium.PrimitiveCollection();
            viewer.scene.primitives.add(particleCollection);
            particleCollectionArr.push(particleCollection);
            let poiArr = eplanObj.poi.split(',');
            let point = new Cesium.Cartesian3.fromDegrees(poiArr[0], poiArr[1], poiArr[2]);
            let particleEntity = viewer.entities.add({
              id: eplanObj.id,
              position: point,
            });

            particleCollection.add(new Cesium.ParticleSystem({
              image: common.serverIp + 'city3dfile/' + eplanObj.particleImg,
              // image: eplanObj.particleImg,
              startColor: Cesium.Color.RED.withAlpha(0.7),
              endColor: Cesium.Color.YELLOW.withAlpha(0.2),
              startScale: 0,
              endScale: Number(eplanObj.endScale),
              minimumParticleLife: 1,
              maximumParticleLife: 6,
              minimumSpeed: 1,
              maximumSpeed: 4,
              minimumImageSize: new Cesium.Cartesian2(15, 15),
              maximumImageSize: new Cesium.Cartesian2(45, 45),
              //imageSize : new Cesium.Cartesian2(55, 55),
              emissionRate: 4,
              lifetime: 160.0,
              emitter: new Cesium.CircleEmitter(Number(eplanObj.emitterRadius)),
              modelMatrix: computeModelMatrix(particleEntity, Cesium.JulianDate.now()),
              emitterModelMatrix: computeEmitterModelMatrix()
            }));
            break;
          default:
            break;
        }
      }

      function computeModelMatrix(entity, time) {
        let position = Cesium.Property.getValueOrUndefined(entity.position);
        let modelMatrix = Cesium.Transforms.eastNorthUpToFixedFrame(position);
        return modelMatrix;
      }

      function computeEmitterModelMatrix() {
        let hpr = Cesium.HeadingPitchRoll.fromDegrees(0, 0, 0);
        let trs = new Cesium.TranslationRotationScale();
        trs.translation = Cesium.Cartesian3.fromElements(2.5, 4, 1);
        trs.rotation = Cesium.Quaternion.fromHeadingPitchRoll(hpr);
        let result = Cesium.Matrix4.fromTranslationRotationScale(trs);
        return result;
      }
    };

    return CesiumPlan;
  }

  if (typeof (CesiumPlan) === 'undefined') {
    window.CesiumPlan = define_CesiumPlan();
  } else {
    console.log("CesiumPlan already defined.");
  }
})(window);
