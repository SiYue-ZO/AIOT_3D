/**
 * 室内户型
 */

(function (window) {
  'use strict';

  function define_CesiumLayout() {
    //Main object
    let CesiumLayout = {};
    let floorWallDrawArr = [];
    let floorEntity = [];

    CesiumLayout.showWall = function (options) {
      options.viewer.entities.removeById("floorEntity");
      let layoutPosArr = stringToNumber(options.layoutPos);
      let minimumHeights = new Array(layoutPosArr.length + 1).fill(options.height);
      let maximumHeights = new Array(layoutPosArr.length + 1).fill(options.height + 3.2);
      layoutPosArr.push(layoutPosArr[0], layoutPosArr[1], layoutPosArr[2]);
      options.viewer.entities.add({
        id: "floorEntity",
        polygon: {
          hierarchy: Cesium.Cartesian3.fromDegreesArrayHeights(layoutPosArr),
          height: options.height,
          material: options.color,
          classificationType: Cesium.ClassificationType.NONE,
        },
        wall: {
          positions: Cesium.Cartesian3.fromDegreesArrayHeights(layoutPosArr),
          minimumHeights: minimumHeights,
          maximumHeights: maximumHeights,
          material: options.color,
          outline: true,
          outlineColor: options.outColor ? options.outColor : options.color,
          outlineWidth: 2
        }
      });
    };

    CesiumLayout.showWalls = function (options) {
      let layoutPosArr = stringToNumber(options.layoutPos);
      let minimumHeights = new Array(layoutPosArr.length + 1).fill(options.height);
      let maximumHeights = new Array(layoutPosArr.length + 1).fill(options.height + 3.2);
      layoutPosArr.push(layoutPosArr[0], layoutPosArr[1], layoutPosArr[2]);
      floorEntity.push(options.viewer.entities.add({
        polygon: {
          hierarchy: Cesium.Cartesian3.fromDegreesArrayHeights(layoutPosArr),
          height: options.height,
          material: options.color,
          classificationType: Cesium.ClassificationType.NONE,
        },
        wall: {
          positions: Cesium.Cartesian3.fromDegreesArrayHeights(layoutPosArr),
          minimumHeights: minimumHeights,
          maximumHeights: maximumHeights,
          material: options.color,
          outline: true,
          outlineColor: options.outColor ? options.outColor : options.color,
          outlineWidth: 2
        }
      }));
    };

    CesiumLayout.showLayout = function (options) {
      let wallStrArr = options.layoutFloor.split('+');
      wallStrArr.pop();
      for (let j = 0; j < wallStrArr.length; j++) {
        let drawFloorPosArr = stringToNumber(wallStrArr[j]);
        drawFloorPosArr.pop();
        let minimumHeights = new Array(drawFloorPosArr.length).fill(options.height);
        let maximumHeights = new Array(drawFloorPosArr.length).fill(options.height + 3.2);
        floorWallDrawArr.push(options.viewer.entities.add({
          wall: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(drawFloorPosArr),
            minimumHeights: minimumHeights,
            maximumHeights: maximumHeights,
            material: options.color,
            outline: true,
            outlineColor: options.outColor ? options.outColor : options.color,
            outlineWidth: 2
          }
        }));
      }
    };

    CesiumLayout.showSingleLayout = function (options) {
      let drawFloorPosArr = stringToNumber(options.layoutFloor);
      drawFloorPosArr.pop();
      let floorminimumHeights = [];
      let showFloorPosArr = [];
      for (let i = 0; i < drawFloorPosArr.length; i = i + 3) {
        floorminimumHeights.push(options.height);
        showFloorPosArr.push(drawFloorPosArr[i], drawFloorPosArr[i + 1], options.height + 3.2);
      }
      floorWallDrawArr.push(options.viewer.entities.add({
        wall: {
          positions: Cesium.Cartesian3.fromDegreesArrayHeights(showFloorPosArr),
          minimumHeights: floorminimumHeights,
          material: options.color,
          outline: true,
          outlineColor: options.outColor ? options.outColor : options.color,
          outlineWidth: 2
        }
      }));
    };

    CesiumLayout.clearLayout = function (viewer) {
      floorWallDrawArr.map(item => {
        viewer.entities.remove(item);
      });
      floorWallDrawArr = [];
      viewer.entities.removeById("floorEntity");
      floorEntity.map(item => {
        viewer.entities.remove(item);
      });
      floorEntity = [];
    };

    CesiumLayout.bombFloor = function () {
      if (floorEntity === []) {
        return;
      }
      floorEntity.map((item, index) => {
        let curHeight = item.polygon.height;
        let maxMove = curHeight + index * 10;
        let moveStep = curHeight;
        item.polygon.height = maxMove;
        //   = new Cesium.CallbackProperty(function (time, result) {
        //   if (moveStep < maxMove) {
        //     moveStep += 1;
        //   }
        //   return moveStep;
        // }, false);

        let minimumHeights = item.wall.minimumHeights;
        // item.wall.minimumHeights = new Cesium.CallbackProperty(function (time, result) {
        //   if (moveStep < maxMove) {
        for (let i = 0; i < minimumHeights._value.length; i++) {
          minimumHeights._value[i] += index * 10;//= moveStep;
        }
        //     moveStep += 0.5;
        //   }
        //   return minimumHeights;
        // }, false);
        item.wall.minimumHeights = minimumHeights;

        let maximumHeights = item.wall.maximumHeights;
        // item.wall.maximumHeights = new Cesium.CallbackProperty(function (time, result) {
        //   if (moveStep < maxMove) {
        for (let i = 0; i < maximumHeights._value.length; i++) {
          maximumHeights._value[i] += index * 10;//= moveStep + 3.2;
        }
        //     moveStep += 0.5;
        //   }
        //   return maximumHeights;
        // }, false);
        item.wall.maximumHeights = maximumHeights;
      });
      let layoutNum = floorWallDrawArr.length / floorEntity.length;
      floorWallDrawArr.map((item, index) => {
        let minimumHeights = item.wall.minimumHeights;
        // item.wall.minimumHeights = new Cesium.CallbackProperty(function (time, result) {
        //   if (moveStep < maxMove) {
        let moveIndex = parseInt(index / layoutNum);
        for (let i = 0; i < minimumHeights._value.length; i++) {
          minimumHeights._value[i] += moveIndex * 10;//= moveStep;
        }
        //     moveStep += 0.5;
        //   }
        //   return minimumHeights;
        // }, false);
        item.wall.minimumHeights = minimumHeights;

        let maximumHeights = item.wall.maximumHeights;
        // item.wall.maximumHeights = new Cesium.CallbackProperty(function (time, result) {
        //   if (moveStep < maxMove) {
        for (let i = 0; i < maximumHeights._value.length; i++) {
          maximumHeights._value[i] += moveIndex * 10;//= moveStep + 3.2;
        }
        //     moveStep += 0.5;
        //   }
        //   return maximumHeights;
        // }, false);
        item.wall.maximumHeights = maximumHeights;
      });
    };

    function stringToNumber(stringInput) {
      let stringArray = stringInput.split(",");
      let numberArrayOutput = [];
      for (let i = 0; i < stringArray.length; i++) {
        numberArrayOutput.push(Number(stringArray[i]));
      }
      return numberArrayOutput;
    }

    return CesiumLayout;
  }

  if (typeof (CesiumLayout) === 'undefined') {
    window.CesiumLayout = define_CesiumLayout();
  } else {
    console.log("CesiumLayout already defined.");
  }
})(window);
