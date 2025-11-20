(function (window) {
  'use strict';

  function define_CesiumCloud() {
    let CesiumCloud = {};
    let cloudArr = [];
    let cloudInterval;

    CesiumCloud.show = function (options) {
      let xnum = parseInt(options.radii / options.step);
      let ynum = parseInt(options.radii / options.step);
      let allNum = xnum * ynum;
      let num = allNum * options.density;
      let numArr = [];
      for (let i = 0; i < num; i++) {
        numArr.push(i);
      }
      let vec2 = [];
      numArr.map(item => {
        let x = parseInt(Math.random() * xnum);
        let y = parseInt(Math.random() * ynum);
        if (!vec2.includes([x, y])) {
          vec2.push([x, y]);
        }
      });
      let originPos = [options.pos[0] - options.radii / 2 * 0.00001, options.pos[1] - options.radii / 2 * 1.1 * 0.00001, options.pos[2]];
      // 数据量过大可以采用此种方式，但是没有移动效果
      // let billboards = options.viewer.scene.primitives.add(new Cesium.BillboardCollection());
      vec2.map(item => {
        let name = parseInt(Math.random() * 15) + 1;
        let scale = (1 - Math.random() * 0.8);
        let heightRandom = (1 - Math.random() * 0.8);
        let time = 0;
        // billboards.add({
        //   position:Cesium.Cartesian3.fromDegrees(originPos[0] + (options.step * item[0]) * 0.00001, originPos[1] + (options.step * item[1]) * 0.00001, options.pos[2] * heightRandom),
        //   scale: 2 * scale,
        //   image: 'static/images/cloud/cloud' + name + '-1.png',
        //   verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
        //   scaleByDistance: new Cesium.NearFarScalar(5000, 1, 100000, 0.5),
        //   pixelOffsetScaleByDistance: new Cesium.NearFarScalar(5000, 1, 100000, 0.5),
        // });

        cloudArr.push(options.viewer.entities.add({
          position: new Cesium.CallbackProperty((function () {
            let pos = Cesium.Cartesian3.fromDegrees(originPos[0] + (options.step * item[0] + time * options.speedx) * 0.00001, originPos[1] + (options.step * item[1] + time * options.speedy) * 0.00001, options.pos[2] * heightRandom);
            time++;
            if (time > 10000) {
              time = 0;
            }
            return pos;//控制云移动的回调方法
          }), false),
          billboard: {
            scale: 2 * scale,
            image: 'static/images/cloud/cloud' + name + '-1.png',
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: new Cesium.NearFarScalar(5000, 1, 100000, 0.5),
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(5000, 1, 100000, 0.5),
          }
        }));
      });

      cloudInterval = setInterval(() => {
        options.viewer.scene.requestRender();
      }, 100);
    };

    CesiumCloud.clear = function (viewer) {
      cloudArr.map(item => {
        viewer.entities.remove(item);
      });
      cloudArr = [];
      clearInterval(cloudInterval);
    };

    return CesiumCloud;
  }

  if (typeof (CesiumCloud) === 'undefined') {
    window.CesiumCloud = define_CesiumCloud();
  } else {
    console.log("CesiumCloud already defined.");
  }
})(window);
