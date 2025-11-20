/**
 * 路径漫游
 */

(function (window) {
  'use strict';

  function define_CesiumRoam() {
    //Main object
    let CesiumRoam = {};

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
      viewer.clock.multiplier = 10;

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
    CesiumRoam.initRoaming = function (options) {
      let lineArrtemp = options.lines.split(',');
      let lineArr = [];
      for (let i = 0; i < lineArrtemp.length; i = i + 3) {
        let linepoint = Cesium.Cartesian3.fromDegrees(Number(lineArrtemp[i]), Number(lineArrtemp[i + 1]), Number(lineArrtemp[i + 2]));
        lineArr.push(linepoint);
      }
      let roamproperty = ComputeRoamingLineProperty(options.viewer, lineArr, options.speed, options.isRe);
      let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
      roamEntity = options.viewer.entities.add({
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
      if (options.modeltype === 'img') {
        let billboard = new Cesium.BillboardGraphics({
          image: options.modeluri,
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          scale: options.scale,
        });
        roamEntity.billboard = billboard;
      } else {
        // 加载模型
        let model = new Cesium.ModelGraphics({
          uri: options.modeluri,// 模型路径
          minimumPixelSize: 32,// 模型最小刻度
          maximumSize: 128,
          maximumScale: 200,// 设置模型最大放大大小
          silhouetteColor: Cesium.Color.WHITE,// 模型轮廓颜色
          // color: color,// 模型颜色  ，这里可以设置颜色的变化
          debugWireframe: false,// 仅用于调试，显示魔仙绘制时的线框
          debugShowBoundingVolume: false,// 仅用于调试。显示模型绘制时的边界球。
          scale: options.scale,
          runAnimations: true, // 是否运行模型中的动画效果
        });
        roamEntity.model = model;
      }
      if (options.type === '平滑线') {
        roamEntity.position.setInterpolationOptions({ // 点插值
          interpolationDegree: 5,
          interpolationAlgorithm: Cesium.LagrangePolynomialApproximation
        });
      }
      options.viewer.trackedEntity = roamEntity;
    };
    /**
     *漫游的暂停和继续
     *
     * @param {*} state bool类型 false为暂停，ture为继续
     * @memberof Roaming
     */
    CesiumRoam.PauseOrContinue = function (viewer, state) {
      viewer.clock.shouldAnimate = state;
    };
    /**
     *改变飞行的速度
     *
     * @param {*} value  整数类型
     * @memberof Roaming
     */
    CesiumRoam.ChangeRoamingSpeed = function (viewer, value) {
      viewer.clock.multiplier = value;
    };
    /**
     *取消漫游
     * @memberof Roaming
     */
    CesiumRoam.EndRoaming = function (viewer) {
      if (roamEntity !== undefined) {
        viewer.entities.remove(roamEntity);
      }
    };

    let roamDrawMarkArr = [];
    let roamHandler;
    CesiumRoam.drawRoamDraw = function (options) {
      roamHandler = roamHandler && roamHandler.destroy();
      CesiumRoam.clearRoamDraw(options.viewer);
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
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    };

    CesiumRoam.clearRoamDraw = function (viewer) {
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

    return CesiumRoam;
  }

  if (typeof (CesiumRoam) === 'undefined') {
    window.CesiumRoam = define_CesiumRoam();
  } else {
    console.log("CesiumRoam already defined.");
  }
})(window);
