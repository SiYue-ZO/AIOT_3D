//from cdxiaodao cesium.js
//measure or survey point, height, distance, area
(function (window) {
  'use strict';

  function define_CesiumSurvey() {
    let CesiumSurvey = {};
    let handler;
    //Get height String from 3dtiles to Mouse's position
    CesiumSurvey.measureHeight = function (viewer) {
      handler = handler && handler.destroy();
      if ((viewer.entities.getById('measureHeightLineEntity') !== undefined)) {
        viewer.entities.removeById('measureHeightLineEntity');
      }
      if ((viewer.entities.getById('mheightPlaneEntity') !== undefined)) {
        viewer.entities.removeById('mheightPlaneEntity');
      }
      if ((viewer.entities.getById('mheightLabelEntity') !== undefined)) {
        viewer.entities.removeById('mheightLabelEntity');
      }
      let isFirst = true;
      let firstPosition;
      let secondPosition;
      let previousPosition;
      let heightLineEntity = viewer.entities.add({
        id: 'measureHeightLineEntity',
        polyline: {
          followSurface: false,
          width: 3,
          material: Cesium.Color.RED,
          show: true
        }
      });
      let heightPlaneEntity = viewer.entities.add({
        id: 'mheightPlaneEntity',
        ellipse: {
          outline: true,
          show: false
        }
      });
      let heightLabelEntity = viewer.entities.add({
        id: 'mheightLabelEntity',
        label: {
          show: false,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
          disableDepthTestDistance: 100000000,
          font: '28px Helvetica',
          scale: 0.5,
          fillColor: Cesium.Color.WHITE,
          showBackground: true,
          backgroundColor: new Cesium.Color(0, 0, 0, 0.8),
        }
      });
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        if (isFirst) {
          firstPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(firstPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            firstPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          isFirst = false;
        } else {
          secondPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(secondPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            secondPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          if (secondPosition) {
            previousPosition = secondPosition.clone();
          } else {
            secondPosition = previousPosition.clone();
          }
          let centerPosition = new Cesium.Cartesian3(
            firstPosition.x * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.y * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.z * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition)
          );
          heightLineEntity.polyline.positions = [firstPosition, centerPosition];
          heightPlaneEntity.position = centerPosition;
          let cartographicCenter = Cesium.Cartographic.fromCartesian(centerPosition);
          let cartographicFirst = Cesium.Cartographic.fromCartesian(firstPosition);
          heightPlaneEntity.ellipse.height = cartographicCenter.height;
          heightPlaneEntity.ellipse.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.YELLOW.withAlpha(0.5) : Cesium.Color.DEEPPINK.withAlpha(0.2);
          heightPlaneEntity.ellipse.semiMinorAxis = Cesium.Cartesian3.distance(centerPosition, secondPosition);
          heightPlaneEntity.ellipse.semiMajorAxis = heightPlaneEntity.ellipse.semiMinorAxis;
          heightPlaneEntity.ellipse.show = true;
          heightLabelEntity.position = (cartographicCenter.height > cartographicFirst.height) > 0 ? centerPosition : firstPosition;
          heightLabelEntity.label.show = true;
          resultStr = cartographicCenter.height - cartographicFirst.height;
          heightLabelEntity.label.text = '高度：' + resultStr.toFixed(2) + '米';
          let camera = viewer.scene.camera;
          heightLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 0.5, 0.0);
          handler = handler && handler.destroy();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      let resultStr;
      handler.setInputAction(function (movement) {
        if (!isFirst) {
          secondPosition = viewer.scene.pickPosition(movement.endPosition);
          let cartographic = Cesium.Cartographic.fromCartesian(secondPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            secondPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          if (secondPosition) {
            previousPosition = secondPosition.clone();
          } else {
            secondPosition = previousPosition.clone();
          }
          let centerPosition = new Cesium.Cartesian3(
            firstPosition.x * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.y * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.z * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition)
          );
          heightLineEntity.polyline.positions = [firstPosition, centerPosition];
          heightPlaneEntity.position = centerPosition;
          let cartographicCenter = Cesium.Cartographic.fromCartesian(centerPosition);
          let cartographicFirst = Cesium.Cartographic.fromCartesian(firstPosition);
          heightPlaneEntity.ellipse.height = cartographicCenter.height;
          heightPlaneEntity.ellipse.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.YELLOW.withAlpha(0.5) : Cesium.Color.DEEPPINK.withAlpha(0.2);
          heightPlaneEntity.ellipse.semiMinorAxis = Cesium.Cartesian3.distance(centerPosition, secondPosition);
          heightPlaneEntity.ellipse.semiMajorAxis = heightPlaneEntity.ellipse.semiMinorAxis;
          heightPlaneEntity.ellipse.show = true;
          heightLabelEntity.position = (cartographicCenter.height > cartographicFirst.height) > 0 ? centerPosition : firstPosition;
          heightLabelEntity.label.show = true;
          resultStr = cartographicCenter.height - cartographicFirst.height;
          heightLabelEntity.label.text = '高度：' + resultStr.toFixed(2) + '米';
          let camera = viewer.scene.camera;
          heightLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 0.5, 0.0);
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function () {
        handler = handler && handler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      return resultStr;
    };

    //Get height String from 3dtiles to Mouse's position(三角尺)
    CesiumSurvey.measureHeightAngle = function (viewer) {
      handler = handler && handler.destroy();
      if ((viewer.entities.getById('measureHeightAngleLineEntity') !== undefined)) {
        viewer.entities.removeById('measureHeightAngleLineEntity');
      }
      if ((viewer.entities.getById('mheightAngleEntity') !== undefined)) {
        viewer.entities.removeById('mheightAngleEntity');
      }
      if ((viewer.entities.getById('mheighthriEntity') !== undefined)) {
        viewer.entities.removeById('mheighthriEntity');
      }
      if ((viewer.entities.getById('mheightLabelAngleEntity') !== undefined)) {
        viewer.entities.removeById('mheightLabelAngleEntity');
      }
      let isFirst = true;
      let firstPosition;
      let secondPosition;
      let previousPosition;
      let heightLineEntity = viewer.entities.add({
        id: 'measureHeightAngleLineEntity',
        polyline: {
          followSurface: false,
          width: 3,
          material: Cesium.Color.RED,
          show: true
        }
      });
      let heightAngleEntity = viewer.entities.add({
        id: 'mheightAngleEntity',
        polyline: {
          width: 3,
          material: Cesium.Color.RED,
          show: true
        }
      });
      let heighthriEntity = viewer.entities.add({
        id: 'mheighthriEntity',
        polyline: {
          width: 3,
          material: Cesium.Color.RED,
          show: true
        }
      });
      let heightLabelEntity = viewer.entities.add({
        id: 'mheightLabelAngleEntity',
        label: {
          show: false,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
          disableDepthTestDistance: 100000000,
          font: '28px Helvetica',
          scale: 0.5,
          fillColor: Cesium.Color.WHITE,
          showBackground: true,
          backgroundColor: new Cesium.Color(0, 0, 0, 0.7),
        }
      });
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        if (isFirst) {
          firstPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(firstPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            firstPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          isFirst = false;
        } else {
          secondPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(secondPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            secondPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          if (secondPosition) {
            previousPosition = secondPosition.clone();
          } else {
            secondPosition = previousPosition.clone();
          }
          let centerPosition = new Cesium.Cartesian3(
            firstPosition.x * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.y * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.z * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition)
          );
          heightLineEntity.polyline.positions = [firstPosition, centerPosition];
          heightAngleEntity.polyline.positions = [firstPosition, secondPosition];
          heighthriEntity.polyline.positions = [centerPosition, secondPosition];
          let cartographicCenter = Cesium.Cartographic.fromCartesian(centerPosition);
          let cartographicFirst = Cesium.Cartographic.fromCartesian(firstPosition);
          heightAngleEntity.polyline.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.RED : Cesium.Color.YELLOW;
          heighthriEntity.polyline.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.RED : Cesium.Color.YELLOW;
          heightLabelEntity.position = (cartographicCenter.height > cartographicFirst.height) > 0 ? centerPosition : firstPosition;
          heightLabelEntity.label.show = true;
          resultStr = cartographicCenter.height - cartographicFirst.height;
          let resulthoriStr = Cesium.Cartesian3.distance(centerPosition, secondPosition);
          let resultangleStr = Cesium.Cartesian3.distance(firstPosition, secondPosition);
          heightLabelEntity.label.text = '高度：' + resultStr.toFixed(2) + '米\n' + "水平：" + resulthoriStr.toFixed(2) + '米\n' + "直线：" + resultangleStr.toFixed(2) + "米";
          let camera = viewer.scene.camera;
          heightLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 0.5, 0.0);
          handler = handler && handler.destroy();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      let resultStr;
      handler.setInputAction(function (movement) {
        if (!isFirst) {
          secondPosition = viewer.scene.pickPosition(movement.endPosition);
          let cartographic = Cesium.Cartographic.fromCartesian(secondPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            secondPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          if (secondPosition) {
            previousPosition = secondPosition.clone();
          } else {
            secondPosition = previousPosition.clone();
          }
          let centerPosition = new Cesium.Cartesian3(
            firstPosition.x * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.y * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition),
            firstPosition.z * Cesium.Cartesian3.dot(firstPosition, secondPosition) / Cesium.Cartesian3.magnitudeSquared(firstPosition)
          );
          heightLineEntity.polyline.positions = [firstPosition, centerPosition];
          heightAngleEntity.polyline.positions = [firstPosition, secondPosition];
          heighthriEntity.polyline.positions = [centerPosition, secondPosition];
          let cartographicCenter = Cesium.Cartographic.fromCartesian(centerPosition);
          let cartographicFirst = Cesium.Cartographic.fromCartesian(firstPosition);
          heightAngleEntity.polyline.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.RED : Cesium.Color.YELLOW;
          heighthriEntity.polyline.material = (cartographicCenter.height > cartographicFirst.height) > 0 ? Cesium.Color.RED : Cesium.Color.YELLOW;
          heightLabelEntity.position = (cartographicCenter.height > cartographicFirst.height) > 0 ? centerPosition : firstPosition;
          heightLabelEntity.label.show = true;
          resultStr = cartographicCenter.height - cartographicFirst.height;
          let resulthoriStr = Cesium.Cartesian3.distance(centerPosition, secondPosition);
          let resultangleStr = Cesium.Cartesian3.distance(firstPosition, secondPosition);
          heightLabelEntity.label.text = '高度：' + resultStr.toFixed(2) + '米\n' + "水平：" + resulthoriStr.toFixed(2) + '米\n' + "直线：" + resultangleStr.toFixed(2) + "米";
          let camera = viewer.scene.camera;
          heightLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 0.5, 0.0);
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function () {
        handler = handler && handler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      return resultStr;
    };

    //Get distence String between first left_click and second left_click
    CesiumSurvey.measureDist = function (viewer, type) {
      handler = handler && handler.destroy();
      if ((viewer.entities.getById('dynamicLineEntity') !== undefined)) {
        viewer.entities.removeById('dynamicLineEntity');
      }
      if ((viewer.entities.getById('dynamicLineGroundEntity') !== undefined)) {
        viewer.entities.removeById('dynamicLineGroundEntity');
      }
      if ((viewer.entities.getById('measureLineEntity') !== undefined)) {
        viewer.entities.removeById('measureLineEntity');
      }
      if ((viewer.entities.getById('measureLineGroundEntity') !== undefined)) {
        viewer.entities.removeById('measureLineGroundEntity');
      }
      if ((viewer.entities.getById('distLabelEntity') !== undefined)) {
        viewer.entities.removeById('distLabelEntity');
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      pointArr = [];
      let isFirst = true;//是否为第一个点
      let previousPosition;//前一个点的坐标
      let currentPosition;//当前点坐标
      let measureValue = 0.0;
      //随鼠标移动的标签entity
      let distLabelEntity = viewer.entities.add({
        id: 'distLabelEntity',
        label: {
          show: false,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
          disableDepthTestDistance: 100000000,
          font: '28px Helvetica',
          scale: 0.5,
          fillColor: Cesium.Color.WHITE,
          showBackground: true,
          backgroundColor: new Cesium.Color(0, 0, 0, 0.7),
        }
      });

      function createPoint(worldPosition) {
        pointArr.push(viewer.entities.add({
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

      let show3d = true, show2d = false;
      if (type === "two") {
        show2d = true;
        show3d = false;
      }
      //前一个点与鼠标连线的entity
      let dynamicLineEntity = viewer.entities.add({
        id: 'dynamicLineEntity',
        polyline: {
          followSurface: false,
          width: 3,
          material: Cesium.Color.YELLOW,
          show: show3d
        }
      });
      let dynamicLineGroundEntity = viewer.entities.add({
        id: 'dynamicLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: Cesium.Color.YELLOW,
          show: show2d,
        }
      });
      //已输入的线段的entity
      let measureLineEntity = viewer.entities.add({
        id: 'measureLineEntity',
        polyline: {
          followSurface: false,
          width: 3,
          material: Cesium.Color.RED,
          show: show3d
        }
      });
      let measureLineGroundEntity = viewer.entities.add({
        id: 'measureLineGroundEntity',
        polyline: {
          clampToGround: true,
          width: 3,
          material: Cesium.Color.RED,
          show: show2d
        }
      });
      let measureLinePositonsArray = [];//存储已量测的线段的折点
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        if (isFirst) {
          previousPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            previousPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          let tmp1 = previousPosition.clone();
          measureValue = 0.0;
          isFirst = false;
          measureLinePositonsArray.push(tmp1);
          createPoint(previousPosition);
        } else {
          currentPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          let tmp2 = currentPosition.clone();
          measureLinePositonsArray.push(tmp2);
          measureLineEntity.polyline.positions = measureLinePositonsArray;
          measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
          measureValue = measureValue + Cesium.Cartesian3.distance(currentPosition, previousPosition);
          previousPosition = currentPosition.clone();
          createPoint(currentPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      let measureValueShow;
      handler.setInputAction(function (movement) {
        //move事件监听
        if (!isFirst) {
          //console.log('move，不是第一个点');
          //获取当前点的坐标
          currentPosition = viewer.scene.pickPosition(movement.endPosition);
          let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          if (currentPosition) {
            distLabelEntity.position = currentPosition;
            distLabelEntity.label.show = true;
            measureValueShow = measureValue + Cesium.Cartesian3.distance(currentPosition, previousPosition);
            distLabelEntity.label.text = '距离：' + measureValueShow.toFixed(2) + '米';
            let camera = viewer.scene.camera;
            distLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 1, 0.0);
            dynamicLineEntity.polyline.positions = [previousPosition, currentPosition];
            dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
          }
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function () {
        //move事件监听
        handler = handler && handler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      return measureValueShow;
    };

    //Get area string by dynamic polygon on earth
    let pointArr = [];
    CesiumSurvey.measureArea = function (viewer) {
      let measureAreaValue = 0.0;
      let activeShapePoints = [];
      handler = handler && handler.destroy();
      if ((viewer.entities.getById('areaLabelEntity') !== undefined)) {
        viewer.entities.removeById('areaLabelEntity');
      }
      if ((viewer.entities.getById('areaEntity') !== undefined)) {
        viewer.entities.removeById('areaEntity');
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      pointArr = [];
      let areaLabelEntity = viewer.entities.add({
        id: 'areaLabelEntity',
        label: {
          show: false,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          horizontalOrigin: Cesium.HorizontalOrigin.LEFT,
          disableDepthTestDistance: 100000000,
          font: '28px Helvetica',
          scale: 0.5,
          fillColor: Cesium.Color.WHITE,
          showBackground: true,
          backgroundColor: new Cesium.Color(0, 0, 0, 0.7),
        }
      });

      function createPoint(worldPosition) {
        pointArr.push(viewer.entities.add({
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
        if ((viewer.entities.getById('areaEntity') !== undefined)) {
          viewer.entities.removeById('areaEntity');
        }
        viewer.entities.add({
          id: 'areaEntity',
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
                  return activeShapePoints;
              }, false),*/
            material: new Cesium.ColorMaterialProperty(Cesium.Color.YELLOW.withAlpha(0.6)),
            classificationType: Cesium.ClassificationType.BOTH,
            outline: true,
            outlineColor: Cesium.Color.WHITE
          }
        });
      }

      function distance(point1, point2) {
        let point1cartographic = Cesium.Cartographic.fromCartesian(point1);
        let point2cartographic = Cesium.Cartographic.fromCartesian(point2);
        /**根据经纬度计算出距离**/
        let geodesic = new Cesium.EllipsoidGeodesic();
        geodesic.setEndPoints(point1cartographic, point2cartographic);
        let s = geodesic.surfaceDistance;
        //返回两点之间的距离
        s = Math.sqrt(Math.pow(s, 2) + Math.pow(point2cartographic.height - point1cartographic.height, 2));
        return s;
      }

      let radiansPerDegree = Cesium.Math.PI / 180.0;//角度转化为弧度(rad)
      let degreesPerRadian = 180.0 / Cesium.Math.PI;//弧度转化为角度
      //计算多边形面积
      function getArea(points) {
        let res = 0.0;
        //拆分三角曲面
        for (let i = 0; i < points.length - 2; i++) {
          let j = (i + 1) % points.length;
          let k = (i + 2) % points.length;
          let totalAngle = Angle(points[0], points[j], points[k]);
          let dis_temp1 = distance(activeShapePoints[0], activeShapePoints[j]);
          let dis_temp2 = distance(activeShapePoints[0], activeShapePoints[k]);
          let tmp = 0.5 * dis_temp1 * dis_temp2 * Math.sin(totalAngle * radiansPerDegree);
          res = res + tmp;
        }
        return Math.abs(res.toFixed(1));//顺时针负，逆时针正
      }

      //计算三角形面积
      function getTriArea(points) {
        console.log(points);
        let area = (
          Number(points[0].lon) * Number(points[1].lat)
          - Number(points[0].lon) * Number(points[2].lat)
          + Number(points[1].lon) * Number(points[2].lat)
          - Number(points[1].lon) * Number(points[0].lat)
          + Number(points[2].lon) * Number(points[0].lat)
          - Number(points[1].lon) * Number(points[1].lat));
        return Math.abs(area.toFixed(1));
      }

      /*角度*/
      function Angle(p1, p2, p3) {
        let bearing12 = Bearing(p1, p2);
        let bearing13 = Bearing(p1, p3);
        let angle = bearing12 - bearing13;
        if (angle < 0) {
          angle += 360;
        }
        return angle;
      }

      /*方向*/
      function Bearing(from, to) {
        let lat1 = from.lat * radiansPerDegree;
        let lon1 = from.lon * radiansPerDegree;
        let lat2 = to.lat * radiansPerDegree;
        let lon2 = to.lon * radiansPerDegree;
        let angle = -Math.atan2(Math.sin(lon1 - lon2) * Math.cos(lat2), Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
        if (angle < 0) {
          angle += Cesium.Math.PI * 2.0;
        }
        angle = angle * degreesPerRadian;//角度
        return angle;
      }

      //选点
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        //获取地理坐标（经度、纬度、高程）
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 2) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      //移动
      handler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.endPosition);
          newPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        activeShapePoints.pop();
        activeShapePoints.push(newPosition);
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      //结束并计算
      let areaResult;
      handler.setInputAction(function (movement) {
        if (activeShapePoints.length > 1) {
          let rightPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(rightPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            rightPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
          activeShapePoints.push(rightPosition);
          let tempPoints = [];
          for (let pindex = 0; pindex < activeShapePoints.length; pindex++) {
            let cartographic = Cesium.Cartographic.fromCartesian(activeShapePoints[pindex].clone());
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPoints.push({lon: longitudeString, lat: latitudeString, hei: heightString});
          }
          if (Cesium.defined(rightPosition)) {
            if (activeShapePoints.length > 2) {
              drawPolygon();
              areaResult = getArea(tempPoints);
            } else if (activeShapePoints.length === 2) {
              drawPolygon();
              areaResult = getTriArea(tempPoints);
            }
            createPoint(rightPosition);
          }

          areaLabelEntity.label.text = '面积：' + areaResult + '平方米';
          areaLabelEntity.position = rightPosition.clone();
          areaLabelEntity.label.show = true;
          areaLabelEntity.label.eyeOffset = new Cesium.Cartesian3(0.0, 0.5, 0.0);
          handler = handler && handler.destroy();
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      return areaResult;
    };

    let measurePointArr = [];
    CesiumSurvey.measurePoint = function (viewer, img) {
      let poiResult;
      handler = handler && handler.destroy();
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        let cartesian = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          cartesian = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        let lng = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        let heading = Cesium.Math.toDegrees(viewer.camera.heading);
        let pitch = Cesium.Math.toDegrees(viewer.camera.pitch);
        let roll = Cesium.Math.toDegrees(viewer.camera.roll);
        poiResult = lng.toFixed(4) + "\u00B0" + "\n" + lat.toFixed(4) + "\u00B0" + "\n" + height.toFixed(1) + "米";
        console.log(lng + ',' + lat + ',' + height + ',' + heading + ',' + pitch + ',' + roll);
        let camPoiR = viewer.camera.position;
        let camPoi = Cesium.Cartographic.fromCartesian(camPoiR);
        let camPoiStr = Cesium.Math.toDegrees(camPoi.longitude) + "," + Cesium.Math.toDegrees(camPoi.latitude) + "," + camPoi.height.toString();
        console.log(camPoiStr + ',' + heading + ',' + pitch + ',' + roll);
        let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
        let point;
        if (img && img !== '') {
          point = viewer.entities.add({
            id: 'measurePointEntity' + new Date().getTime(),
            position: cartesian.clone(),
            billboard: {
              image: img,
              scale: 0.6,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            },
            label: {
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              font: 'bold 42px Helvetica',
              scale: 0.5,
              fillColor: Cesium.Color.WHITE,
              text: poiResult,
              showBackground: true,
              backgroundColor: new Cesium.Color.fromCssColorString("#e54163").withAlpha(0.8),
              backgroundPadding: new Cesium.Cartesian2(25, 5),
              pixelOffset: new Cesium.Cartesian2(0.0, -50.0),
              disableDepthTestDistance: 100000000,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
            }
          });
        } else {
          point = viewer.entities.add({
            id: 'measurePointEntity' + new Date().getTime(),
            position: cartesian.clone(),
            billboard: {
              image: pinBuilder.fromText('测', Cesium.Color.RED, 36).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM
            },
            label: {
              show: true,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              horizontalOrigin: Cesium.HorizontalOrigin.CENTER,
              disableDepthTestDistance: 100000000,
              font: '28px Helvetica',
              scale: 0.5,
              fillColor: Cesium.Color.WHITE,
              backgroundColor: new Cesium.Color(0, 0, 0, 0.7),
              text: poiResult,
              pixelOffset: new Cesium.Cartesian2(0.0, -14.0),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(1.5e2, 3.0, 1.5e7, 0.5),
              showBackground: true,
            }
          });
        }
        measurePointArr.push(point);
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      return poiResult;
    };

    let mmhandler;
    CesiumSurvey.measureMovePoint = function (viewer, resultid) {
      mmhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      //移动
      mmhandler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        if (newPosition !== undefined) {
          let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
          let height = cartographic.height;//模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.endPosition);
            newPosition = viewer.scene.globe.pick(ray, viewer.scene);
            cartographic = Cesium.Cartographic.fromCartesian(newPosition);
          }
          height = cartographic.height;//地形高度
          let lng = Cesium.Math.toDegrees(cartographic.longitude);
          let lat = Cesium.Math.toDegrees(cartographic.latitude);
          let camPoiR = viewer.camera.position;
          let camcartographic = Cesium.Cartographic.fromCartesian(camPoiR);
          let camheight = camcartographic.height;//地形高度
          let camlng = Cesium.Math.toDegrees(camcartographic.longitude);
          let camlat = Cesium.Math.toDegrees(camcartographic.latitude);
          let heading = Cesium.Math.toDegrees(viewer.camera.heading);
          let pitch = Cesium.Math.toDegrees(viewer.camera.pitch);
          let roll = Cesium.Math.toDegrees(viewer.camera.roll);
          let poiResult = lng.toFixed(4) + "\u00B0" + "," + lat.toFixed(4) + "\u00B0" + "," + height.toFixed(1) + "米"
          document.getElementById(resultid).innerHTML = poiResult;
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
    };

    let cammmhandler;
    CesiumSurvey.cammeasureMovePoint = function (viewer, camresultid) {
      cammmhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      //移动
      cammmhandler.setInputAction(function (movement) {
        let camPoiR = viewer.camera.position;
        let camcartographic = Cesium.Cartographic.fromCartesian(camPoiR);
        let camheight = camcartographic.height;//地形高度
        let camlng = Cesium.Math.toDegrees(camcartographic.longitude);
        let camlat = Cesium.Math.toDegrees(camcartographic.latitude);
        let heading = Cesium.Math.toDegrees(viewer.camera.heading);
        let pitch = Cesium.Math.toDegrees(viewer.camera.pitch);
        let roll = Cesium.Math.toDegrees(viewer.camera.roll);
        let camResult = camlng.toFixed(4) + "\u00B0" + "," + camlat.toFixed(4) + "\u00B0" + "," + camheight.toFixed(1) + "米,"
          + heading.toFixed(2) + "\u00B0" + "," + pitch.toFixed(2) + "\u00B0" + "," + roll.toFixed(1) + "\u00B0";
        document.getElementById(camresultid).innerHTML = camResult;
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
    };

    //Clear measure result
    CesiumSurvey.measureClear = function (viewer) {
      handler = handler && handler.destroy();
      if ((viewer.entities.getById('measureHeightLineEntity') !== undefined)) {
        viewer.entities.removeById('measureHeightLineEntity');
      }
      if ((viewer.entities.getById('mheightPlaneEntity') !== undefined)) {
        viewer.entities.removeById('mheightPlaneEntity');
      }
      if ((viewer.entities.getById('mheightLabelEntity') !== undefined)) {
        viewer.entities.removeById('mheightLabelEntity');
      }
      if ((viewer.entities.getById('measureHeightAngleLineEntity') !== undefined)) {
        viewer.entities.removeById('measureHeightAngleLineEntity');
      }
      if ((viewer.entities.getById('mheightAngleEntity') !== undefined)) {
        viewer.entities.removeById('mheightAngleEntity');
      }
      if ((viewer.entities.getById('mheighthriEntity') !== undefined)) {
        viewer.entities.removeById('mheighthriEntity');
      }
      if ((viewer.entities.getById('mheightLabelAngleEntity') !== undefined)) {
        viewer.entities.removeById('mheightLabelAngleEntity');
      }
      if ((viewer.entities.getById('dynamicLineEntity') !== undefined)) {
        viewer.entities.removeById('dynamicLineEntity');
      }
      if ((viewer.entities.getById('dynamicLineGroundEntity') !== undefined)) {
        viewer.entities.removeById('dynamicLineGroundEntity');
      }
      if ((viewer.entities.getById('measureLineEntity') !== undefined)) {
        viewer.entities.removeById('measureLineEntity');
      }
      if ((viewer.entities.getById('measureLineGroundEntity') !== undefined)) {
        viewer.entities.removeById('measureLineGroundEntity');
      }
      if ((viewer.entities.getById('distLabelEntity') !== undefined)) {
        viewer.entities.removeById('distLabelEntity');
      }
      if ((viewer.entities.getById('areaLabelEntity') !== undefined)) {
        viewer.entities.removeById('areaLabelEntity');
      }
      if ((viewer.entities.getById('areaEntity') !== undefined)) {
        viewer.entities.removeById('areaEntity');
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      pointArr = [];
      if ((viewer.entities.getById('measurePointEntity') !== undefined)) {
        viewer.entities.removeById('measurePointEntity');
      }
      for (let i = 0; i < measurePointArr.length; i++) {
        viewer.entities.remove(measurePointArr[i]);
      }
      measurePointArr = [];
      return true;
    };

    //shutdown handler
    CesiumSurvey.clearHandler = function () {
      handler = handler && handler.destroy();
    };

    //shutdown mmhandler
    CesiumSurvey.clearMMHandler = function () {
      mmhandler = mmhandler && mmhandler.destroy();
    };

    //shutdown cammmhandler
    CesiumSurvey.clearCamMMHandler = function () {
      cammmhandler = cammmhandler && cammmhandler.destroy();
    };

    return CesiumSurvey;
  }

  if (typeof (CesiumSurvey) === 'undefined') {
    window.CesiumSurvey = define_CesiumSurvey();
  } else {
    console.log("CesiumSurvey already defined.");
  }
})(window);
