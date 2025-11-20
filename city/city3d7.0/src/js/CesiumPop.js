/*
 * Html div pop in cesium
 */

(function (window) {
  'use strict';

  function define_CesiumPop() {
    //Main object
    let CesiumPop = {};
    let pophandler;
    let popEntityArr = [];
    let optionsArr = [];
    let optionsArrH = [];
    let moveEndWindow = function () {
      chooseWindow(viewer);
    };

    //初始div标签和地图坐标绑定的监听
    CesiumPop.bindPopGlobeEventHandler = function (viewer) {
      bindGlobeEventHandler(viewer);
    };

    //在地图上添加div标签
    CesiumPop.addDivPop = function (options, type) {
      if (type === "h") {
        optionsArrH.push(options);
        updatePopupPosH(options.viewer, options.id, options.pos, options.extentHeight, options.popupWidth, options.popupHeight);
      } else {
        optionsArr.push(options);
        addCenterMarker(options.viewer, options.pos, options.id, options.extentHeight, options.extentColor);
        updatePopupPos(options.viewer, options.id, options.pos, options.extentHeight, options.popupWidth, options.popupHeight);
      }
    };

    //添加标签点图形
    function addCenterMarker(viewer, pos, id, extentHeight, extentColor) {
      let position = new Cesium.Cartesian3.fromDegrees(pos.lon, pos.lat, pos.alt);
      let positionextent = new Cesium.Cartesian3.fromDegrees(pos.lon, pos.lat, pos.alt + extentHeight);
      popEntityArr.push(viewer.entities.add({
        id: "popentity" + id,
        position: position,
        point: {
          pixelSize: 10,
          color: Cesium.Color.RED.withAlpha(0.8),
          disableDepthTestDistance: 1000,
          outlineWidth: 2,
          outlineColor: Cesium.Color.WHITE.withAlpha(1)
        },
        polyline: {
          positions: [position, positionextent],
          width: 2,
          show: true,
          material: new Cesium.PolylineDashMaterialProperty({
            color: extentColor
          })
        }
      }));
    }

    //初始化标签与地理坐标匹配监听
    function bindGlobeEventHandler(viewer) {
      pophandler = pophandler && pophandler.destroy();
      pophandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      // pophandler.setInputAction(function (movement) {
      //   chooseWindow(viewer);
      // }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      // pophandler.setInputAction(function (movement) {
      //   chooseWindow(viewer);
      // }, Cesium.ScreenSpaceEventType.WHEEL);
      viewer.scene.preRender.addEventListener(moveEndWindow);
      // viewer.camera.moveEnd.addEventListener(moveEndWindow);
    }

    //更新位置
    function chooseWindow(viewer) {
      for (let i = 0; i < optionsArr.length; i++) {
        updatePopupPos(viewer, optionsArr[i].id, optionsArr[i].pos, optionsArr[i].extentHeight,
          optionsArr[i].popupWidth, optionsArr[i].popupHeight);
      }
      for (let i = 0; i < optionsArrH.length; i++) {
        updatePopupPosH(viewer, optionsArrH[i].id, optionsArrH[i].pos, optionsArrH[i].extentHeight,
          optionsArrH[i].popupWidth, optionsArrH[i].popupHeight);
      }
    }

    //根据地图坐标更新垂直型气泡的屏幕坐标
    function updatePopupPos(viewer, id, pos, extentHeight, popupWidth, popupHeight) {
      let scene = viewer.scene;
      let p3d = Cesium.Cartesian3.fromDegrees(pos.lon, pos.lat, pos.alt + extentHeight);
      let p = Cesium.SceneTransforms.wgs84ToWindowCoordinates(scene, p3d);
      if (!p) {
        return;
      }
      let popupNode = document.getElementById("popupDiv" + id);
      if (popupNode) {
        popupNode.style.left = (p.x - popupWidth / 2) + "px";
        popupNode.style.top = (p.y - popupHeight) + "px";
      }
    }

    //根据地图坐标更新水平型气泡的屏幕坐标
    function updatePopupPosH(viewer, id, pos, extentHeight, popupWidth, popupHeight) {
      let scene = viewer.scene;
      let p3d = Cesium.Cartesian3.fromDegrees(pos.lon, pos.lat, pos.alt + extentHeight);
      let p = Cesium.SceneTransforms.wgs84ToWindowCoordinates(scene, p3d);
      if (!p) {
        return;
      }
      let popupNode = document.getElementById("popupDiv" + id);
      if (popupNode) {
        popupNode.style.left = p.x + "px";
        popupNode.style.top = (p.y - popupHeight) + "px";
      }
    }

    //外部更新气泡位置方法，不需要重新创建气泡
    CesiumPop.updatePopPos = function (viewer, id, pos, extentHeight, popupWidth, popupHeight, extentColor) {
      updatePopupPos(viewer, id, pos, extentHeight, popupWidth, popupHeight);
      viewer.entities.removeById("popentity" + id);
      addCenterMarker(viewer, pos, id, extentHeight, extentColor);
      for (let i = 0; i < optionsArr.length; i++) {
        if (optionsArr[i].id === id) {
          optionsArr[i].pos = pos;
          break;
        }
      }
    };

    //根据节点数组，更新气泡位置方法，让气泡与地图中的动画物体同步，不需要重新创建气泡
    let updateSampledPopupPosi = 0;

    function updateSampledPopupPos(viewer, id, nodes, extentHeight, popupWidth, popupHeight) {
      let scene = viewer.scene;
      let intervalSpop = setInterval(function () {
        let lon = Cesium.Math.lerp(nodes[0].x, nodes[1].x, 0.01 * updateSampledPopupPosi);
        let lat = Cesium.Math.lerp(nodes[0].y, nodes[1].y, 0.01 * updateSampledPopupPosi);
        //var height = nodes[0].z-(nodes[0].z-nodes[1].z)*0.2*updateSampledPopupPosi;
        let height = Cesium.Math.lerp(nodes[0].z, nodes[1].z, 0.01 * updateSampledPopupPosi);
        let position = new Cesium.Cartesian3(lon, lat, height);
        let p = Cesium.SceneTransforms.wgs84ToWindowCoordinates(scene, position);
        if (!p) {
          return;
        }
        let popupNode = document.getElementById("popupDiv" + id);
        popupNode.style.left = (p.x - popupWidth / 2) + "px";
        popupNode.style.top = (p.y - popupHeight) + "px";
        updateSampledPopupPosi++;
      }, 200);
      return intervalSpop;
    }

    //外部更新动画气泡位置方法
    CesiumPop.updateSampledPopPos = function (viewer, id, nodes, extentHeight, popupWidth, popupHeight, extentColor) {
      let times = [];
      let startTime = Cesium.JulianDate.now(startTime);
      for (let i = 0; i < nodes.length; i++) {
        let time = new Cesium.JulianDate();
        Cesium.JulianDate.addSeconds(startTime, i * 10, time);
        times.push(time);
      }
      let stopTime = times[times.length - 1];
      //插值
      let property = new Cesium.SampledPositionProperty();
      property.addSamples(times, nodes);
      viewer.entities.getById("popentity" + id).position = property;
      viewer.entities.getById("popentity" + id).polyline.show = false;
      let intervalSpop = updateSampledPopupPos(viewer, id, nodes, extentHeight, popupWidth, popupHeight);
      for (let i = 0; i < optionsArr.length; i++) {
        if (optionsArr[i].id === id) {
          optionsArr[i].pos = nodes[nodes.length - 1];
          break;
        }
      }
      return intervalSpop;
    };

    //清除所有气泡
    CesiumPop.clearDivPop = function (viewer) {
      for (let i = 0; i < popEntityArr.length; i++) {
        viewer.entities.remove(popEntityArr[i]);
      }
      for (let i = 0; i < optionsArr.length; i++) {
        let elem = document.getElementById('popupDiv' + optionsArr[i].id);
        if (elem) {
          elem.parentNode.removeChild(elem);
        }
      }
      for (let i = 0; i < optionsArrH.length; i++) {
        let elem = document.getElementById('popupDiv' + optionsArrH[i].id);
        if (elem) {
          elem.parentNode.removeChild(elem);
        }
      }
      popEntityArr = [];
      optionsArr = [];
      optionsArrH = [];
      pophandler = pophandler && pophandler.destroy();
      viewer.camera.moveEnd.removeEventListener(moveEndWindow);
    };

    //根据id删除气泡
    CesiumPop.removeDivPopById = function (viewer, id) {
      for (let i = 0; i < optionsArr.length; i++) {
        if (id === optionsArr[i].id) {
          viewer.entities.removeById("popentity" + id);
          let elem = document.getElementById('popupDiv' + id);
          if (elem) {
            elem.parentNode.removeChild(elem);
          }
          optionsArr.splice(i, 1);
          break;
        }
      }
      for (let i = 0; i < optionsArrH.length; i++) {
        if (id === optionsArrH[i].id) {
          let elem = document.getElementById('popupDiv' + id);
          if (elem) {
            elem.parentNode.removeChild(elem);
          }
          optionsArrH.splice(i, 1);
          break;
        }
      }
    };

    //停止气泡绑定监听
    CesiumPop.removePophandler = function () {
      pophandler = pophandler && pophandler.destroy();
      viewer.camera.moveEnd.removeEventListener(moveEndWindow);
    };

    //停止动画绑定
    CesiumPop.stopInterval = function (Interval) {
      clearInterval(Interval);
      updateSampledPopupPosi = 1;
    };

    return CesiumPop;
  }

  if (typeof (CesiumPop) === 'undefined') {
    window.CesiumPop = define_CesiumPop();
  } else {
    console.log("CesiumPop already defined.");
  }
})(window);
