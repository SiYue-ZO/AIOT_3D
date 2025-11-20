/**
 * 海量三维地图地名地址标注
 */

(function (window) {
  'use strict';

  function define_CesiumHugePin() {
    //Main object
    let CesiumHugePin = {};
    let tileset;
    let billboardsArr = [];
    let billboards;
    let listener;
    let level = [
      false, false, false, false, false,
      false, false, false, false, false,
      false, false, false, false, false,
      false, false, false, false, false,
      false, false, false, false, false,
      false, false, false, false, false,
      false, false, false, false, false,
    ];

    //加载
    CesiumHugePin.init = function (options) {
      // options.viewer.extend(Cesium.viewerCesium3DTilesInspectorMixin);
      let tilesetOption = {
        url: options.tilesetUrl,
        maximumScreenSpaceError: 1,
        maximumNumberOfLoadedTiles: 2000,
        maximumMemoryUsage: 64,
        // dynamicScreenSpaceError: true,
        // dynamicScreenSpaceErrorDensity: 0.00278,
        // dynamicScreenSpaceErrorFactor: 4.0,
        // dynamicScreenSpaceErrorHeightFalloff: 0.25,
        immediatelyLoadDesiredLevelOfDetail: true,
        loadSiblings: false,
        cullWithChildrenBounds: true,
        cullRequestsWhileMoving: true,
        cullRequestsWhileMovingMultiplier: 0.0001, // 值越小能够更快的剔除
        preloadWhenHidden: true,
        preferLeaves: true,
        progressiveResolutionHeightFraction: 0.2, // 数值偏于0能够让初始加载变得模糊
      };
      tileset = new Cesium.Cesium3DTileset(tilesetOption);

      let refPathArr = [];
      tileset.readyPromise.then(function () {
        options.viewer.scene.primitives.add(tileset); //加载3dtiles数据
        tileset.tileLoad.addEventListener(function (tile) {
          refPathArr = [];
          let content = tile.content;
          if (!refPathArr.includes(content.getFeature(0).getProperty("refPath"))) {
            let bill = addData(content);
            refPathArr.push(content.getFeature(0).getProperty("refPath"));
            billboardsArr.push(bill);
          }
        });
        tileset.tileUnload.addEventListener(function (tile) {
          let content = tile.content;
          console.log(content.getFeature(0).getProperty("refPath"));
        });
      });

      function addData(content) {
        let billboards = options.viewer.scene.primitives.add(new Cesium.BillboardCollection());
        let featuresLength = content.featuresLength;
        let maxerror = "1500000";
        let minerror = "0";
        let fillStyle = "#ffffff";
        let strokeStyle = "#ffffff";
        let scaleByDistance = new Cesium.NearFarScalar(3000, 2, 50000, 0.2);
        let scale = 3;
        switch (content.getFeature(0).getProperty("级别")) {
          case "1":
            maxerror = "3000000";
            minerror = "1500000";
            fillStyle = "#ffffff";
            strokeStyle = "#000000";
            scaleByDistance = new Cesium.NearFarScalar(1200000, 0.3, 20000000, 0.2);
            scale = 6;
            break;
          case "2":
            maxerror = "1800000";
            minerror = "900000";
            fillStyle = "#ffffff";
            strokeStyle = "#a25100";
            scaleByDistance = new Cesium.NearFarScalar(1100000, 0.3, 1500000, 0.2);
            scale = 4;
            break;
          case "3":
            maxerror = "1100000";
            minerror = "50000";
            fillStyle = "#ffffff";
            strokeStyle = "#a20920";
            scaleByDistance = new Cesium.NearFarScalar(700000, 0.4, 1100000, 0.3);
            scale = 2;
            break;
          case "4":
            maxerror = "200000";
            minerror = "100000";
            fillStyle = "#ffffff";
            strokeStyle = "#00a209";
            scaleByDistance = new Cesium.NearFarScalar(100000, 0.5, 200000, 0.4);
            scale = 1;
            break;
          case "5":
            maxerror = "150000";
            minerror = "30000";
            fillStyle = "#ffffff";
            strokeStyle = "#1714a2";
            scaleByDistance = new Cesium.NearFarScalar(30000, 0.6, 150000, 0.5);
            scale = 1;
            break;
          case "6":
            maxerror = "50000";
            minerror = "0";
            fillStyle = "#ffffff";
            strokeStyle = "#9810a2";
            scaleByDistance = new Cesium.NearFarScalar(20000, 0.7, 50000, 0.6);
            scale = 1;
            break;
          default:
            break;
        }

        for (let i = 0; i < featuresLength; ++i) {
          const feature = content.getFeature(i);
          let propertyNames = feature.getPropertyNames();
          let length = propertyNames.length;
          for (let j = 0; j < length; ++j) {
            let propertyName = propertyNames[j];
            console.log(propertyName + ': ' + feature.getProperty(propertyName));
          }

          let name = feature.getProperty("名称");
          let canvas = document.createElement('canvas');
          let ctx = canvas.getContext('2d');
          canvas.width = name.length * 18;
          canvas.height = 18;
          ctx.font = 'bold 16px Microsoft YaHei';
          ctx.textAlign = 'center';
          ctx.textBaseline = 'bottom';
          ctx.fillStyle = fillStyle;
          ctx.strokeStyle = strokeStyle;
          ctx.lineWidth = "0.8";
          ctx.fillText(name, canvas.width / 2, 18);
          ctx.strokeText(name, canvas.width / 2, 18);
          // let imageUrl = canvas.toDataURL("image/png");
          let point = Cesium.Cartesian3.fromDegrees(feature.getProperty("经度"), feature.getProperty("纬度"), feature.getProperty("height"));
          billboards.add({
            // id: "bm" + feature.getProperty("gml_id"),
            position: point,
            image: canvas,
            scale: scale,
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            scaleByDistance: scaleByDistance,
            pixelOffsetScaleByDistance: new Cesium.NearFarScalar(3000, 2, 50000, 0.2),
            disableDepthTestDistance: 1,
            distanceDisplayCondition: new Cesium.DistanceDisplayCondition(Number(minerror), Number(maxerror))
          });
        }
        return billboards;
      }
    };

    CesiumHugePin.close = function (viewer) {
      billboardsArr.map(item => {
        viewer.scene.primitives.remove(item);
      });
      billboardsArr = [];
      viewer.scene.primitives.remove(tileset);
      viewer.scene.requestRender();
    };

    CesiumHugePin.load = function (xm, viewer) {
      billboards = viewer.scene.primitives.add(new Cesium.BillboardCollection());
      for (let i = 0; i < 1000; i++) {
        let data = xm.features[i];
        showPoi(data, 8000000);
      }

      listener = viewer.camera.moveEnd.addEventListener(function () {
        let height = viewer.camera.positionCartographic.height;

        if (670000 < height && height < 700000) {
          if (!level[0]) {
            for (let i = 1000; i < 2000; i++) {
              let data = xm.features[i];
              showPoi(data, 700000);
            }
            level[0] = true;
          }
        } else if (650000 < height && height < 670000) {
          if (!level[1]) {
            for (let i = 2000; i < 3000; i++) {
              let data = xm.features[i];
              showPoi(data, 670000);
            }
            level[1] = true;
          }
        } else if (630000 < height && height < 650000) {
          if (!level[2]) {
            for (let i = 3000; i < 4000; i++) {
              let data = xm.features[i];
              showPoi(data, 650000);
            }
            level[2] = true;
          }
        } else if (610000 < height && height < 630000) {
          if (!level[3]) {
            for (let i = 4000; i < 5000; i++) {
              let data = xm.features[i];
              showPoi(data, 630000);
            }
            level[3] = true;
          }
        } else if (580000 < height && height < 610000) {
          if (!level[4]) {
            for (let i = 5000; i < 6000; i++) {
              let data = xm.features[i];
              showPoi(data, 610000);
            }
            level[4] = true;
          }
        } else if (560000 < height && height < 580000) {
          if (!level[5]) {
            for (let i = 6000; i < 7000; i++) {
              let data = xm.features[i];
              showPoi(data, 580000);
            }
            level[5] = true;
          }
        } else if (540000 < height && height < 560000) {
          if (!level[6]) {
            for (let i = 7000; i < 8000; i++) {
              let data = xm.features[i];
              showPoi(data, 560000);
            }
            level[6] = true;
          }
        } else if (520000 < height && height < 540000) {
          if (!level[7]) {
            for (let i = 8000; i < 9000; i++) {
              let data = xm.features[i];
              showPoi(data, 540000);
            }
            level[7] = true;
          }
        } else if (500000 < height && height < 520000) {
          if (!level[8]) {
            for (let i = 9000; i < 10000; i++) {
              let data = xm.features[i];
              showPoi(data, 520000);
            }
            level[8] = true;
          }
        } else if (480000 < height && height < 500000) {
          if (!level[9]) {
            for (let i = 10000; i < 11000; i++) {
              let data = xm.features[i];
              showPoi(data, 500000);
            }
            level[9] = true;
          }
        } else if (460000 < height && height < 480000) {
          if (!level[10]) {
            for (let i = 11000; i < 12000; i++) {
              let data = xm.features[i];
              showPoi(data, 480000);
            }
            level[10] = true;
          }
        } else if (440000 < height && height < 460000) {
          if (!level[11]) {
            for (let i = 12000; i < 13000; i++) {
              let data = xm.features[i];
              showPoi(data, 460000);
            }
            level[11] = true;
          }
        } else if (420000 < height && height < 440000) {
          if (!level[12]) {
            for (let i = 13000; i < 14000; i++) {
              let data = xm.features[i];
              showPoi(data, 440000);
            }
            level[12] = true;
          }
        } else if (400000 < height && height < 420000) {
          if (!level[13]) {
            for (let i = 14000; i < 15000; i++) {
              let data = xm.features[i];
              showPoi(data, 420000);
            }
            level[13] = true;
          }
        } else if (380000 < height && height < 400000) {
          if (!level[14]) {
            for (let i = 15000; i < 16000; i++) {
              let data = xm.features[i];
              showPoi(data, 400000);
            }
            level[14] = true;
          }
        } else if (360000 < height && height < 380000) {
          if (!level[15]) {
            for (let i = 16000; i < 17000; i++) {
              let data = xm.features[i];
              showPoi(data, 380000);
            }
            level[15] = true;
          }
        } else if (340000 < height && height < 360000) {
          if (!level[16]) {
            for (let i = 17000; i < 18000; i++) {
              let data = xm.features[i];
              showPoi(data, 360000);
            }
            level[16] = true;
          }
        } else if (320000 < height && height < 340000) {
          if (!level[17]) {
            for (let i = 18000; i < 19000; i++) {
              let data = xm.features[i];
              showPoi(data, 340000);
            }
            level[17] = true;
          }
        } else if (300000 < height && height < 320000) {
          if (!level[18]) {
            for (let i = 19000; i < 20000; i++) {
              let data = xm.features[i];
              showPoi(data, 320000);
            }
            level[18] = true;
          }
        } else if (280000 < height && height < 300000) {
          if (!level[19]) {
            for (let i = 20000; i < 21000; i++) {
              let data = xm.features[i];
              showPoi(data, 300000);
            }
            level[19] = true;
          }
        } else if (260000 < height && height < 280000) {
          if (!level[20]) {
            for (let i = 21000; i < 22000; i++) {
              let data = xm.features[i];
              showPoi(data, 280000);
            }
            level[20] = true;
          }
        } else if (240000 < height && height < 260000) {
          if (!level[21]) {
            for (let i = 22000; i < 23000; i++) {
              let data = xm.features[i];
              showPoi(data, 260000);
            }
            level[21] = true;
          }
        } else if (220000 < height && height < 240000) {
          if (!level[22]) {
            for (let i = 23000; i < 24000; i++) {
              let data = xm.features[i];
              showPoi(data, 240000);
            }
            level[22] = true;
          }
        } else if (200000 < height && height < 220000) {
          if (!level[23]) {
            for (let i = 24000; i < 25000; i++) {
              let data = xm.features[i];
              showPoi(data, 220000);
            }
            level[23] = true;
          }
        } else if (180000 < height && height < 200000) {
          if (!level[24]) {
            for (let i = 25000; i < 26000; i++) {
              let data = xm.features[i];
              showPoi(data, 200000);
            }
            level[24] = true;
          }
        } else if (160000 < height && height < 180000) {
          if (!level[25]) {
            for (let i = 26000; i < 27000; i++) {
              let data = xm.features[i];
              showPoi(data, 180000);
            }
            level[25] = true;
          }
        } else if (140000 < height && height < 160000) {
          if (!level[26]) {
            for (let i = 27000; i < 28000; i++) {
              let data = xm.features[i];
              showPoi(data, 160000);
            }
            level[26] = true;
          }
        } else if (120000 < height && height < 140000) {
          if (!level[27]) {
            for (let i = 28000; i < 29000; i++) {
              let data = xm.features[i];
              showPoi(data, 140000);
            }
            level[27] = true;
          }
        } else if (100000 < height && height < 120000) {
          if (!level[28]) {
            for (let i = 29000; i < 30000; i++) {
              let data = xm.features[i];
              showPoi(data, 120000);
            }
            level[28] = true;
          }
        } else if (80000 < height && height < 100000) {
          if (!level[29]) {
            for (let i = 30000; i < 31000; i++) {
              let data = xm.features[i];
              showPoi(data, 100000);
            }
            level[29] = true;
          }
        } else if (60000 < height && height < 80000) {
          if (!level[30]) {
            for (let i = 31000; i < 32000; i++) {
              let data = xm.features[i];
              showPoi(data, 80000);
            }
            level[30] = true;
          }
        } else if (50000 < height && height < 60000) {
          if (!level[31]) {
            for (let i = 32000; i < 33000; i++) {
              let data = xm.features[i];
              showPoi(data, 60000);
            }
            level[31] = true;
          }
        } else if (40000 < height && height < 50000) {
          if (!level[32]) {
            for (let i = 33000; i < 34000; i++) {
              let data = xm.features[i];
              showPoi(data, 50000);
            }
            level[32] = true;
          }
        } else if (30000 < height && height < 40000) {
          if (!level[33]) {
            for (let i = 34000; i < 35000; i++) {
              let data = xm.features[i];
              showPoi(data, 40000);
            }
            level[33] = true;
          }
        } else if (20000 < height && height < 30000) {
          if (!level[34]) {
            for (let i = 35000; i < 36000; i++) {
              let data = xm.features[i];
              showPoi(data, 30000);
            }
            level[34] = true;
          }
        } else if (15000 < height && height < 20000) {
          if (!level[35]) {
            for (let i = 36000; i < 37000; i++) {
              let data = xm.features[i];
              showPoi(data, 20000);
            }
            level[35] = true;
          }
        } else if (13000 < height && height < 15000) {
          if (!level[36]) {
            for (let i = 37000; i < 38000; i++) {
              let data = xm.features[i];
              showPoi(data, 15000);
            }
            level[36] = true;
          }
        } else if (11000 < height && height < 13000) {
          if (!level[37]) {
            for (let i = 38000; i < 39000; i++) {
              let data = xm.features[i];
              showPoi(data, 13000);
            }
            level[37] = true;
          }
        } else if (9000 < height && height < 11000) {
          if (!level[38]) {
            for (let i = 39000; i < 40000; i++) {
              let data = xm.features[i];
              showPoi(data, 11000);
            }
            level[38] = true;
          }
        } else if (7000 < height && height < 9000) {
          if (!level[39]) {
            for (let i = 40000; i < 41000; i++) {
              let data = xm.features[i];
              showPoi(data, 9000);
            }
            level[39] = true;
          }
        } else if (5000 < height && height < 7000) {
          if (!level[40]) {
            for (let i = 41000; i < 42000; i++) {
              let data = xm.features[i];
              showPoi(data, 7000);
            }
            level[40] = true;
          }
        } else if (2500 < height && height < 5000) {
          if (!level[41]) {
            for (let i = 42000; i < 43000; i++) {
              let data = xm.features[i];
              showPoi(data, 5000);
            }
            level[41] = true;
          }
        } else if (1000 < height && height < 2500) {
          if (!level[42]) {
            for (let i = 43000; i < 44000; i++) {
              let data = xm.features[i];
              showPoi(data, 2500);
            }
            level[42] = true;
          }
        } else if (500 < height && height < 1000) {
          if (!level[43]) {
            for (let i = 44000; i < 45000; i++) {
              let data = xm.features[i];
              showPoi(data, 1000);
            }
            level[43] = true;
          }
        } else if (0 < height && height < 500) {
          if (!level[44]) {
            for (let i = 45000; i < xm.length; i++) {
              let data = xm.features[i];
              showPoi(data, 500);
            }
            level[44] = true;
          }
        }
      });

      function showPoi(data, error) {
        let canvas = document.createElement('canvas');
        let ctx = canvas.getContext('2d');
        let name = data.properties.Name;
        canvas.width = name.length * 14;
        canvas.height = 12;
        ctx.font = 'bold 10px Microsoft YaHei';
        ctx.textAlign = 'center';
        ctx.textBaseline = 'bottom';
        ctx.fillStyle = '#ffffff';
        ctx.strokeStyle = "#a25100";
        ctx.lineWidth = "0.7";
        ctx.fillText(name, canvas.width / 2, 12);
        ctx.strokeText(name, canvas.width / 2, 12);
        let point = Cesium.Cartesian3.fromDegrees(data.geometry.coordinates[0], data.geometry.coordinates[1], 50);
        billboards.add({
          id: "bm" + data.properties.gml_id,
          position: point,
          image: canvas,
          scale: 2,
          color: Cesium.Color.WHITE.withAlpha(1),
          verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          scaleByDistance: new Cesium.NearFarScalar(3000, 2, 50000, 0.2),
          pixelOffsetScaleByDistance: new Cesium.NearFarScalar(3000, 2, 50000, 0.2),
          disableDepthTestDistance: 1,
          distanceDisplayCondition: new Cesium.DistanceDisplayCondition(0, error)
        });
      }
    };

    CesiumHugePin.clear = function (viewer) {
      viewer.scene.primitives.remove(billboards);
      viewer.camera.moveEnd.removeEventListener(listener);
      viewer.scene.requestRender();
    };

    return CesiumHugePin;
  }

  if (typeof (CesiumHugePin) === 'undefined') {
    window.CesiumHugePin = define_CesiumHugePin();
  } else {
    console.log("CesiumHugePin already defined.");
  }
})(window);
