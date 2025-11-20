/**
 * 海量三维地图地名地址标注
 */

(function (window) {
  'use strict';

  function define_CesiumHeatmap3d() {
    //Main object
    let CesiumHeatmap3d = {};
    let environCollection;
    let moveHandler;

    CesiumHeatmap3d.load = function (options) {
      let devicePos = [];
      options.devicePosArr.map(item => {
        devicePos.push(Cesium.Cartesian3.fromDegrees(item[0], item[1], item[2]));
      });
      environCollection = new Cesium.PointPrimitiveCollection();
      options.viewer.scene.primitives.add(environCollection);
      let environmentData = [];
      for (let i = -100; i < 100; i++) {
        for (let j = -100; j < 100; j++) {
          for (let k = -3; k < 30; k++) {
            let tempArr = [];
            tempArr[0] = Cesium.Cartesian3.fromDegrees(options.cityPos[0] + i * 0.00007 * options.offset,
              options.cityPos[1] + j * 0.00005 * options.offset,
              options.cityPos[2] + k * 4 * options.offset);
            tempArr[1] = 0;
            environmentData.push(tempArr);
          }
        }
      }
      let range = [
        options.cityPos[0] + 100 * 0.00007 * options.offset,
        options.cityPos[1] - 100 * 0.00005 * options.offset,
        options.cityPos[0] - 100 * 0.00007 * options.offset,
        options.cityPos[1] + 100 * 0.00005 * options.offset,
        options.cityPos[2] - 3 * 4 * options.offset,
        options.cityPos[2] + 30 * 4 * options.offset
      ];
      devicePos.map((item, i) => {
        environmentData.map(item1 => {
          let dis = Cesium.Cartesian3.distance(item, item1[0]);
          let val = ((options.valArr[i] - dis) / options.valArr[i]);
          val = val > 0 ? val : 0;
          item1[1] += val;
        });
      });
      environmentData.map(item => {
        let material;
        let val = item[1];
        if (val <= options.defaultGradient[0][0] && val > 0) {
          material = new Cesium.Color(options.defaultGradient[0][1] / 255, options.defaultGradient[0][2] / 255, options.defaultGradient[0][3] / 255, options.defaultGradient[0][4]);
        } else if (val <= options.defaultGradient[1][0] && val > options.defaultGradient[0][0]) {
          material = new Cesium.Color(options.defaultGradient[1][1] / 255, options.defaultGradient[1][2] / 255, options.defaultGradient[1][3] / 255, options.defaultGradient[1][4]);
        } else if (val <= options.defaultGradient[2][0] && val > options.defaultGradient[1][0]) {
          material = new Cesium.Color(options.defaultGradient[2][1] / 255, options.defaultGradient[2][2] / 255, options.defaultGradient[2][3] / 255, options.defaultGradient[2][4]);
        } else if (val <= options.defaultGradient[3][0] && val > options.defaultGradient[2][0]) {
          material = new Cesium.Color(options.defaultGradient[3][1] / 255, options.defaultGradient[3][2] / 255, options.defaultGradient[3][3] / 255, options.defaultGradient[3][4]);
        } else if (val > options.defaultGradient[3][0]) {
          material = new Cesium.Color(options.defaultGradient[4][1] / 255, options.defaultGradient[4][2] / 255, options.defaultGradient[4][3] / 255, options.defaultGradient[4][4]);
        } else {
          material = Cesium.Color.BLUE.withAlpha(0);
        }
        environCollection.add({
          position: item[0],
          color: material,
          pixelSize: options.size
        });
      });
      return range;
    };

    CesiumHeatmap3d.clear = function (viewer) {
      viewer.scene.primitives.remove(environCollection);
    };

    CesiumHeatmap3d.clip = function (lng, lat, height) {
      environCollection._pointPrimitives.map(item => {
        let point = new Cesium.Cartographic.fromCartesian(item.position);
        let pointHeight = point.height;
        let longitude = Cesium.Math.toDegrees(point.longitude);
        let latitude = Cesium.Math.toDegrees(point.latitude);
        item.show = !(pointHeight > height) && !(longitude > lng) && !(latitude > lat);
      });
    };

    CesiumHeatmap3d.clearClip = function () {
      environCollection._pointPrimitives.map(item => {
        item.show = true;
      });
      moveHandler = moveHandler && moveHandler.destroy();
    };

    return CesiumHeatmap3d;
  }

  if (typeof (CesiumHeatmap3d) === 'undefined') {
    window.CesiumHeatmap3d = define_CesiumHeatmap3d();
  } else {
    console.log("CesiumHeatmap3d already defined.");
  }
})(window);
