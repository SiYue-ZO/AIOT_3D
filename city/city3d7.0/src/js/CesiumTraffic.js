(function (window) {
  'use strict';

  function define_CesiumTraffic() {
    let CesiumTraffic = {};
    let trafficArr = [];
    let crossArr = [];

    /**
     * viewer
     * time
     * speed
     * data
     * */
    CesiumTraffic.show = function (options) {
      let time = options.time;
      let roamStart = Cesium.JulianDate.now();
      let roamStop = Cesium.JulianDate.addSeconds(roamStart, time * 2 + time / 2, new Cesium.JulianDate());
      options.viewer.clock.startTime = roamStart.clone();
      options.viewer.clock.stopTime = roamStop.clone();
      options.viewer.clock.currentTime = Cesium.JulianDate.now();
      options.viewer.clock.clockRange = Cesium.ClockRange.LOOP_STOP;
      options.viewer.clock.multiplier = options.speed;

      let modelUriArr = [
        ["car-white.gltf", 0.08, 2],
        ["car-red.gltf", 2, 2],
        ["sportcar-white.gltf", 2, 1.5],
        ["sportcar-gold.gltf", 2, 1.5],
        ["bus-red.gltf", 1.5, 3],
        ["bus-green.gltf", 1.5, 3],
        ["suv.gltf", 2, 2],
        ["truck-blue.gltf", 1.5, 2.5],
        ["truck-red.gltf", 1.5, 2.5],
        ["dumptruck-gold.glb", 1, 2],
        ["dumptruck-yellow.glb", 2, 5],
      ];

      function ComputeRoamingLineProperty(Lines, time) {
        let property = new Cesium.SampledPositionProperty();
        for (let i = 0; i < Lines.length; i++) {
          let timesample = Cesium.JulianDate.addSeconds(roamStart, time + i / 2, new Cesium.JulianDate());
          let position = Lines[i];
          property.addSample(timesample, position);
        }
        return property;
      }

      options.data.map(item => {
        let lineArr = [];
        let times = [];
        for (let j = 0; j < item.length; j = j + 3) {
          let linepoint = Cesium.Cartesian3.fromDegrees(Number(item[j]), Number(item[j + 1]), Number(item[j + 2]));
          lineArr.push(linepoint);
          times.push(j / (item.length - 3));
        }
        let points = [];
        let spline = new Cesium.LinearSpline({
          times: times,
          points: lineArr
        });
        for (let i = 0; i <= time; i++) {
          let cart3 = spline.evaluate(i / time);
          points.push(cart3);
        }
        for (let i = 0; i < time; i++) {
          if (Math.floor(Math.random() * 10) % 2 === 0) {
            let roamproperty = ComputeRoamingLineProperty(points, i);
            let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
            let model = modelUriArr[Math.floor(Math.random() * modelUriArr.length)];
            trafficArr.push(options.viewer.entities.add({
              position: roamproperty,// 位置
              orientation: orientationproperty,
              model: {
                uri: options.modeUri + model[0],// 模型路径
                imageBasedLightingFactor: new Cesium.Cartesian2(model[2], 1),
                scale: model[1],
                runAnimations: true, // 是否运行模型中的动画效果
              }
            }));
          }
          if (Math.floor(Math.random() * 10) % 2 === 0) {
            let roamproperty1 = ComputeRoamingLineProperty(points, i + time);
            let orientationproperty1 = new Cesium.VelocityOrientationProperty(roamproperty1);// 计算朝向
            let model1 = modelUriArr[Math.floor(Math.random() * modelUriArr.length)];
            trafficArr.push(options.viewer.entities.add({
              position: roamproperty1,// 位置
              orientation: orientationproperty1,
              model: {
                uri: options.modeUri + model1[0],// 模型路径
                imageBasedLightingFactor: new Cesium.Cartesian2(model1[2], 1),
                scale: model1[1],
                runAnimations: true, // 是否运行模型中的动画效果
              }
            }));
          }
        }
      });
    };

    CesiumTraffic.clear = function (viewer) {
      trafficArr.map(item => {
        viewer.entities.remove(item);
      });
      trafficArr = [];
    };

    /**
     * viewer
     * time
     * stopTime
     * stopStep
     * speed
     * data
     * */
    CesiumTraffic.showCross = function (options) {
      let time = options.time;
      let roamStart = Cesium.JulianDate.now();
      let roamStop = Cesium.JulianDate.addSeconds(roamStart, time + options.stopTime, new Cesium.JulianDate());
      options.viewer.clock.startTime = roamStart.clone();
      options.viewer.clock.stopTime = roamStop.clone();
      options.viewer.clock.currentTime = Cesium.JulianDate.now();
      options.viewer.clock.clockRange = Cesium.ClockRange.LOOP_STOP;
      options.viewer.clock.multiplier = options.speed;

      let modelUriArr = [
        ["car-white.gltf", 0.06, 2],
        ["car-red.gltf", 1.3, 2],
        ["sportcar-white.gltf", 1.5, 1.5],
        ["sportcar-gold.gltf", 1.5, 1.5],
        ["bus-red.gltf", 1, 3],
        ["bus-green.gltf", 1, 3],
        ["suv.gltf", 1.5, 2],
        ["truck-blue.gltf", 1, 2.5],
        ["truck-red.gltf", 1, 2.5],
        ["dumptruck-gold.glb", 0.5, 2],
        ["dumptruck-yellow.glb", 1, 5],
      ];

      function ComputeRoamingLineProperty(Lines, time) {
        let property = new Cesium.SampledPositionProperty();
        let comStopTime = 0;
        for (let i = 0; i < Lines.length; i++) {
          if (i === options.stopStep) comStopTime = options.stopTime;
          let timesample = Cesium.JulianDate.addSeconds(roamStart, time * i + comStopTime, new Cesium.JulianDate());
          let position = Lines[i];
          property.addSample(timesample, position);
        }
        return property;
      }

      options.data.map(item => {
        let lineArr = [];
        for (let j = 0; j < item.length; j = j + 3) {
          let linepoint = Cesium.Cartesian3.fromDegrees(Number(item[j]), Number(item[j + 1]), Number(item[j + 2]));
          lineArr.push(linepoint);
        }
        let roamproperty = ComputeRoamingLineProperty(lineArr, time/lineArr.length);
        let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
        let model = modelUriArr[Math.floor(Math.random() * modelUriArr.length)];
        crossArr.push(options.viewer.entities.add({
          position: roamproperty,// 位置
          orientation: orientationproperty,
          model: {
            uri: options.modeUri + model[0],// 模型路径
            imageBasedLightingFactor: new Cesium.Cartesian2(model[2], 1),
            scale: model[1],
            runAnimations: true, // 是否运行模型中的动画效果
          }
        }));
      });
    };

    /**
     * viewer
     * time
     * stopTime
     * speed
     * data
     * */
    CesiumTraffic.turnRight = function (options) {
      let time = options.time;

      let modelUriArr = [
        ["car-white.gltf", 0.06, 2],
        ["car-red.gltf", 1.3, 2],
        ["sportcar-white.gltf", 1.5, 1.5],
        ["sportcar-gold.gltf", 1.5, 1.5],
        ["bus-red.gltf", 1, 3],
        ["bus-green.gltf", 1, 3],
        ["suv.gltf", 1.5, 2],
        ["truck-blue.gltf", 1, 2.5],
        ["truck-red.gltf", 1, 2.5],
        ["dumptruck-gold.glb", 0.5, 2],
        ["dumptruck-yellow.glb", 1, 5],
      ];

      function ComputeRoamingLineProperty(Lines, time) {
        let property = new Cesium.SampledPositionProperty();
        for (let i = 0; i < Lines.length; i++) {
          let timesample = Cesium.JulianDate.addSeconds(roamStart, time * i, new Cesium.JulianDate());
          let position = Lines[i];
          property.addSample(timesample, position);
        }
        return property;
      }
      options.data.map(item => {
        let lineArr = [];
        for (let j = 0; j < item.length; j = j + 3) {
          let linepoint = Cesium.Cartesian3.fromDegrees(Number(item[j]), Number(item[j + 1]), Number(item[j + 2]));
          lineArr.push(linepoint);
        }
        let roamproperty = ComputeRoamingLineProperty(lineArr, time/lineArr.length);
        let orientationproperty = new Cesium.VelocityOrientationProperty(roamproperty);// 计算朝向
        let model = modelUriArr[Math.floor(Math.random() * modelUriArr.length)];
        crossArr.push(options.viewer.entities.add({
          position: roamproperty,// 位置
          orientation: orientationproperty,
          model: {
            uri: options.modeUri + model[0],// 模型路径
            imageBasedLightingFactor: new Cesium.Cartesian2(model[2], 1),
            scale: model[1],
            runAnimations: true, // 是否运行模型中的动画效果
          }
        }));
      });
    };

    CesiumTraffic.clearCross= function (viewer) {
      crossArr.map(item => {
        viewer.entities.remove(item);
      });
      crossArr = [];
    };

    return CesiumTraffic;
  }

  if (typeof (CesiumTraffic) === 'undefined') {
    window.CesiumTraffic = define_CesiumTraffic();
  } else {
    console.log("CesiumTraffic already defined.");
  }
})(window);
