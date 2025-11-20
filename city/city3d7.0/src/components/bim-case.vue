<template>
  <div id="bim-case-is-show">
    <div class="pop-fai pop-fai-slider" v-on:click="ctrlSlider" title="卷帘">
      <font-awesome-icon :icon="['fas', 'arrows-alt-h']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="flattenTiles" title="压平地面" v-show="!isFlattened">
      <font-awesome-icon :icon="['fas', 'cube']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-start" v-on:click="clearFlattenTiles" title="还原压平" v-show="isFlattened">
      <font-awesome-icon :icon="['fas', 'redo']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="addModelToMapHandler" title="放置模型">
      <font-awesome-icon :icon="['fas', 'map-marked-alt']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="saveBimCase" title="保存方案">
      <font-awesome-icon :icon="['fas', 'save']"></font-awesome-icon>
    </div>
    <div class="model-list">
      <el-table class="list-tabel" :data="modelArr"
                :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                :default-sort="{prop: 'modelName', order: 'ascending'}" @row-click="rowClick">
        <el-table-column label="缩略图" prop="modelImg" sortable>
          <template slot-scope="scope">
            <el-image style="width: 40px" :src="scope.row.modelImg" :preview-src-list="[scope.row.modelImg]"/>
          </template>
        </el-table-column>
        <el-table-column label="模型名称" prop="modelName" sortable></el-table-column>
        <el-table-column label="申报单位" prop="modelDep" sortable></el-table-column>
      </el-table>
    </div>
    <div class="emer-row" style="margin-top: 15px">
      <el-input class="emer-input" v-model="bimCase.bimCaseName" placeholder="方案名称" size="small"></el-input>
    </div>
    <div class="emer-row" style="margin-top: 15px">
      <span style="margin: 0 15px 0 0">旋转角度</span>
      <el-input class="emer-input-half" v-model="bimCase.modelHeading" placeholder="旋转角度" size="small"></el-input>
      <span style="margin: 0 15px 0 42px">缩放比例</span>
      <el-input class="emer-input-half" v-model="bimCase.modelScale" placeholder="缩放比例" size="small"></el-input>
    </div>
    <div class="emer-row" style="margin-top: 20px">
      <div class="emer-row-label">调整姿态</div>
      <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-left']" fixed-width
                         @click="updateModel(1)" title="左转"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-right']" fixed-width
                         @click="updateModel(2)" title="右转"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-up']" fixed-width
                         @click="updateModel(3)" title="上移"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['far', 'arrow-alt-circle-down']" fixed-width
                         @click="updateModel(4)" title="下移"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['fas', 'search-plus']" fixed-width
                         @click="updateModel(5)" title="放大"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['fas', 'search-minus']" fixed-width
                         @click="updateModel(6)" title="缩小"></font-awesome-icon>
      <font-awesome-icon class="form-fai-update" :icon="['far', 'times-circle']" fixed-width
                         @click="clearModel" title="清除"></font-awesome-icon>
    </div>
    <el-table class="list-tabel" :data="bimCaseArr"
              :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
              :default-sort="{prop: 'bimCaseName', order: 'ascending'}" @row-click="rowClickCase">
      <el-table-column label="方案名称" prop="bimCaseName" sortable></el-table-column>
      <el-table-column label="更新" width="50">
        <template slot-scope="scope">
          <el-button type="text" @click="doUpdateBimCase()">
            <font-awesome-icon class="pop-fai" :icon="['fas', 'save']"></font-awesome-icon>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="删除" width="50">
        <template slot-scope="scope">
          <el-button type="text" @click="deleteBimCaseById(scope.row.bimCaseId)">
            <font-awesome-icon class="pop-fai" :icon="['fas', 'times']"></font-awesome-icon>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import map3d from "./map-3d";
import {deleteBimCase, getBimCase, insertBimCase, updateBimCase, getBimCaseModel} from "../api/api";

let handler;
let pointArr = [];
let clipPos = [];
let modelHandler;
let tileset;
let positionEnt;
let sliderLayer = [];
let sliderhandler;
let isSlidershow = false;
let tilesetArr = [];

export default {
  name: "bim-case",
  data() {
    return {
      isFlattened: false,
      modelArr: [],
      curModelId: "",
      bimCaseArr: [],
      bimCase: {
        bimCaseId: "",
        bimCaseName: "理工大学7号教学楼建筑方案论证",
        modelId: "",
        modelPosArr: [],
        modelPos: "",
        modelHeading: 0,
        modelScale: 1.0,
        flattenPos: ""
      },
    }
  },
  methods: {
    flattenTiles() {
      let _this = this;
      this.clearFlattenTiles();

      let activeShapePoints = [];
      handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      handler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        clipPos.push(earthPosition);
        _this.bimCase.flattenPos +=
          Cesium.Math.toDegrees(cartographic.longitude) + "," +
          Cesium.Math.toDegrees(cartographic.latitude) + "," +
          height + ",";
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          if (activeShapePoints.length > 3) {
            drawShape();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(function (movement) {
        let newPosition = viewer.scene.pickPosition(movement.endPosition);
        let cartographic = Cesium.Cartographic.fromCartesian(newPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.endPosition);
          newPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        activeShapePoints.pop();
        activeShapePoints.push(newPosition);
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(function (movement) {
        handler = handler && handler.destroy();
        viewer.entities.add({
          id: "comEntityFlat",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(clipPos),
            material: Cesium.Color.DARKGRAY,
            classificationType: Cesium.ClassificationType.NONE,
            perPositionHeight: true,
          },
        });
        map3d.methods.flatten3dtilesmap(clipPos);
        _this.bimCase.flattenPos = _this.bimCase.flattenPos.substring(0, _this.bimCase.flattenPos.length - 1);
        for (let i = 0; i < pointArr.length; i++) {
          viewer.entities.remove(pointArr[i]);
        }
        pointArr = [];
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        _this.isFlattened = true;
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        pointArr.push(
          viewer.entities.add({
            position: worldPosition,
            point: {
              color: Cesium.Color.RED,
              pixelSize: 10,
              outlineWidth: 1,
              outlineColor: Cesium.Color.WHITE,
              disableDepthTestDistance: 10000,
            },
          })
        );
      }

      function drawShape() {
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        viewer.entities.add({
          id: "comEntity",
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            material: new Cesium.ColorMaterialProperty(
              Cesium.Color.GREENYELLOW.withAlpha(0.3)
            ),
            classificationType: Cesium.ClassificationType.BOTH,
          },
        });
      }
    },
    clearFlattenTiles() {
      if (viewer.entities.getById("comEntity") !== undefined) {
        viewer.entities.removeById("comEntity");
      }
      if (viewer.entities.getById("comEntityFlat") !== undefined) {
        viewer.entities.removeById("comEntityFlat");
      }
      for (let i = 0; i < pointArr.length; i++) {
        viewer.entities.remove(pointArr[i]);
      }
      pointArr = [];
      clipPos = [];
      handler = handler && handler.destroy();
      map3d.methods.clearClippingPlanes();
      if (this.bimCase) {
        this.isFlattened = false;
        this.bimCase.flattenPos = "";
      }
    },
    addModelToMapHandler() {
      if (this.curModelId === "") {
        this.$message.error("请先选择模型！");
        return;
      }
      let _this = this;
      let earthPosition;
      modelHandler = modelHandler && modelHandler.destroy();
      modelHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      modelHandler.setInputAction(function (movement) {
        earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let lng = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        height = cartographic.height;//模型高度
        _this.bimCase.modelPosArr = [lng, lat, height];
        _this.bimCase.modelPos = lng + "," + lat + "," + height;
        if (positionEnt) {
          positionEnt.position = earthPosition;
        } else {
          positionEnt = viewer.entities.add({
            position: earthPosition,
            point: {
              color: Cesium.Color.RED,
              pixelSize: 10,
              outlineWidth: 1,
              outlineColor: Cesium.Color.WHITE,
              disableDepthTestDistance: 10000,
            },
          });
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      modelHandler.setInputAction(function (movement) {
        for (let i = 0; i < _this.modelArr.length; i++) {
          if (_this.modelArr[i].modelId === _this.curModelId) {
            let tilesetOption = {
              url: _this.modelArr[i].modelUrl,
              imageBasedLightingFactor: new Cesium.Cartesian2(1, 1),
              maximumScreenSpaceError: 2,
              maximumNumberOfLoadedTiles: 1500,
              maximumMemoryUsage: 512,
              dynamicScreenSpaceError: true,
              dynamicScreenSpaceErrorDensity: 0.00278,
              dynamicScreenSpaceErrorFactor: 4.0,
              dynamicScreenSpaceErrorHeightFalloff: 0.25,
              skipLevelOfDetail: false,
              baseScreenSpaceError: 1024,
              skipScreenSpaceErrorFactor: 16,
              skipLevels: 2,
              immediatelyLoadDesiredLevelOfDetail: true,
              loadSiblings: false,
              cullWithChildrenBounds: true,
              cullRequestsWhileMoving: true,
              cullRequestsWhileMovingMultiplier: 0.001, // 值越小能够更快的剔除
              preloadWhenHidden: true,
              preferLeaves: true,
              progressiveResolutionHeightFraction: 0.1, // 数值偏于0能够让初始加载变得模糊
            };
            tileset = new Cesium.Cesium3DTileset(tilesetOption);
            tilesetArr.push(tileset);
            let model = viewer.scene.primitives.add(tileset); //加载3dtiles数据
            if (sliderLayer.length === 2) {
              sliderLayer.splice(0, 1);
              sliderLayer.push(model);
            } else {
              sliderLayer.push(model);
            }
            tileset.readyPromise.then(function () {
              if (tileset._root.transform) {
                let matrix = Cesium.Transforms.eastNorthUpToFixedFrame(earthPosition);
                let scale = Cesium.Matrix4.fromUniformScale(Number(_this.modelArr[i].modelScale));
                Cesium.Matrix4.multiply(matrix, scale, matrix);
                tileset._root.transform = matrix;
                _this.bimCase.modelScale = Number(_this.modelArr[i].modelScale);
              }
            });
            viewer.entities.remove(positionEnt);
            positionEnt = undefined;
            modelHandler = modelHandler && modelHandler.destroy();
            break;
          }
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    updateModel(key) {
      let matrix = {}, pos, scale, rotationX, rotationY, rotationZ, rotationTranslationX, rotationTranslationY,
        rotationTranslationZ;
      switch (key) {
        case 1:
          this.bimCase.modelHeading = Number(this.bimCase.modelHeading) - 1;
          break;
        case 2:
          this.bimCase.modelHeading = Number(this.bimCase.modelHeading) + 1;
          break;
        case 3:
          this.bimCase.modelPosArr[2]++;
          break;
        case 4:
          this.bimCase.modelPosArr[2]--;
          break;
        case 5:
          this.bimCase.modelScale = Number(this.bimCase.modelScale) + 0.1;
          break;
        case 6:
          this.bimCase.modelScale = Number(this.bimCase.modelScale) - 0.1;
          break;
        default:
          break;
      }
      pos = new Cesium.Cartesian3.fromDegrees(this.bimCase.modelPosArr[0], this.bimCase.modelPosArr[1], this.bimCase.modelPosArr[2]);
      matrix = Cesium.Transforms.eastNorthUpToFixedFrame(pos);
      scale = Cesium.Matrix4.fromUniformScale(this.bimCase.modelScale);
      Cesium.Matrix4.multiply(matrix, scale, matrix);
      rotationX = Cesium.Matrix3.fromRotationX(Cesium.Math.toRadians(0));
      rotationY = Cesium.Matrix3.fromRotationY(Cesium.Math.toRadians(0));
      rotationZ = Cesium.Matrix3.fromRotationZ(Cesium.Math.toRadians(this.bimCase.modelHeading));
      rotationTranslationX = Cesium.Matrix4.fromRotationTranslation(rotationX);
      rotationTranslationY = Cesium.Matrix4.fromRotationTranslation(rotationY);
      rotationTranslationZ = Cesium.Matrix4.fromRotationTranslation(rotationZ);
      Cesium.Matrix4.multiply(matrix, rotationTranslationX, matrix);
      Cesium.Matrix4.multiply(matrix, rotationTranslationY, matrix);
      Cesium.Matrix4.multiply(matrix, rotationTranslationZ, matrix);
      tileset._root.transform = matrix;
      this.bimCase.modelPos = this.bimCase.modelPosArr[0] + "," + this.bimCase.modelPosArr[1] + "," + this.bimCase.modelPosArr[2];
    },
    clearModel() {
      tilesetArr.map(item => {
        viewer.scene.primitives.remove(item);
      });
      tilesetArr = [];
      viewer.entities.remove(positionEnt);
      positionEnt = undefined;
    },
    rowClick(row) {
      this.curModelId = row.modelId;
    },
    dogetBimCase() {
      getBimCase().then(res => {
        this.bimCaseArr = res.data;
      });
    },
    rowClickCase(row) {
      this.closeBimCase();
      this.bimCase = Object.assign(this.bimCase, row);
      let _this = this;
      let clipPos = [];
      for (let i = 0; i < this.modelArr.length; i++) {
        if (this.modelArr[i].modelId === row.modelId) {
          let tilesetOption = {
            url: this.modelArr[i].modelUrl,
            imageBasedLightingFactor: new Cesium.Cartesian2(1, 1),
            maximumScreenSpaceError: 2,
            maximumNumberOfLoadedTiles: 1500,
            maximumMemoryUsage: 512,
            dynamicScreenSpaceError: true,
            dynamicScreenSpaceErrorDensity: 0.00278,
            dynamicScreenSpaceErrorFactor: 4.0,
            dynamicScreenSpaceErrorHeightFalloff: 0.25,
            skipLevelOfDetail: false,
            baseScreenSpaceError: 1024,
            skipScreenSpaceErrorFactor: 16,
            skipLevels: 2,
            immediatelyLoadDesiredLevelOfDetail: true,
            loadSiblings: false,
            cullWithChildrenBounds: true,
            cullRequestsWhileMoving: true,
            cullRequestsWhileMovingMultiplier: 0.001, // 值越小能够更快的剔除
            preloadWhenHidden: true,
            preferLeaves: true,
            progressiveResolutionHeightFraction: 0.1, // 数值偏于0能够让初始加载变得模糊
          };
          tileset = new Cesium.Cesium3DTileset(tilesetOption);
          viewer.scene.primitives.add(tileset); //加载3dtiles数据
          tileset.readyPromise.then(function () {
            if (tileset._root.transform) {
              let modelPosArr = row.modelPos.split(",");
              _this.bimCase.modelPosArr = modelPosArr;
              let pos = new Cesium.Cartesian3.fromDegrees(modelPosArr[0], modelPosArr[1], modelPosArr[2]);
              let matrix = Cesium.Transforms.eastNorthUpToFixedFrame(pos);
              let scale = Cesium.Matrix4.fromUniformScale(Number(row.modelScale));
              Cesium.Matrix4.multiply(matrix, scale, matrix);
              let rotationX = Cesium.Matrix3.fromRotationX(Cesium.Math.toRadians(0));
              let rotationY = Cesium.Matrix3.fromRotationY(Cesium.Math.toRadians(0));
              let rotationZ = Cesium.Matrix3.fromRotationZ(Cesium.Math.toRadians(Number(row.modelHeading)));
              let rotationTranslationX = Cesium.Matrix4.fromRotationTranslation(rotationX);
              let rotationTranslationY = Cesium.Matrix4.fromRotationTranslation(rotationY);
              let rotationTranslationZ = Cesium.Matrix4.fromRotationTranslation(rotationZ);
              Cesium.Matrix4.multiply(matrix, rotationTranslationX, matrix);
              Cesium.Matrix4.multiply(matrix, rotationTranslationY, matrix);
              Cesium.Matrix4.multiply(matrix, rotationTranslationZ, matrix);
              tileset._root.transform = matrix;
              map3d.methods.flyToLocation([modelPosArr[0], modelPosArr[1], Number(modelPosArr[2]) + 500]);

              let flattenArr = row.flattenPos.split(',');
              for (let i = 0; i < flattenArr.length; i = i + 3) {
                clipPos.push(new Cesium.Cartesian3.fromDegrees(flattenArr[i], flattenArr[i + 1], flattenArr[i + 2]));
              }
              viewer.entities.add({
                id: "comEntityFlat",
                polygon: {
                  hierarchy: new Cesium.PolygonHierarchy(clipPos),
                  material: Cesium.Color.DARKGRAY,
                  classificationType: Cesium.ClassificationType.NONE,
                  perPositionHeight: true,
                },
              });
              map3d.methods.flatten3dtilesmap(clipPos);
            }
          });
          break;
        }
      }
    },
    deleteBimCaseById(id) {
      let params = {
        bimCaseId: id
      };
      deleteBimCase(params).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '删除成功，返回列表！'
          });
          this.closeBimCase();
          this.dogetBimCase();
        } else {
          this.$message({
            type: 'error',
            message: '删除失败，请重试！'
          });
        }
      });
    },
    saveBimCase() {
      if (this.curModelId === "" || this.bimCase.modelPos === "") {
        this.$message({
          type: 'error',
          message: '新增失败，请先放置模型！'
        });
        return;
      }
      this.bimCase.modelId = this.curModelId;
      insertBimCase(this.bimCase).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '新增成功，返回列表！'
          });
          this.closeBimCase();
          this.dogetBimCase();
        } else {
          this.$message({
            type: 'error',
            message: '新增失败，请重试！'
          });
        }
      });
    },
    doUpdateBimCase() {
      updateBimCase(this.bimCase).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '更新成功，返回列表！'
          });
          this.closeBimCase();
          this.dogetBimCase();
        } else {
          this.$message({
            type: 'error',
            message: '更新失败，请重试！'
          });
        }
      });
    },
    dogetModel() {
      getBimCaseModel().then(res => {
        res.data.map(item => {
          item.modelUrl = window.mapServerIp + item.modelUrl;
          item.modelImg = common.serverIp + "city3dfile/" + item.modelImg;
          this.modelArr.push(item);
        });
      });
    },
    closeBimCase() {
      this.clearFlattenTiles();
      this.clearModel();
      sliderLayer = [];
      this.stopSlider();
    },
    //控制卷帘操作
    ctrlSlider() {
      if (isSlidershow) {
        isSlidershow = false;
        this.stopSlider();
      } else {
        isSlidershow = true;
        this.startSlider();
        this.$message.warning("此功能为Cesium-1.100版本适用");
      }
    },
    //卷帘滚动条
    startSlider() {
      //Cesium-1.100适用
      if (sliderLayer.length === 2) {
        sliderLayer[0].splitDirection = Cesium.SplitDirection.LEFT;
        sliderLayer[1].splitDirection = Cesium.SplitDirection.RIGHT;

        let slider = document.getElementById('slider');
        slider.style.display = "block";
        viewer.scene.splitPosition = (slider.offsetLeft) / slider.parentElement.offsetWidth;

        sliderhandler = sliderhandler && sliderhandler.destroy();
        sliderhandler = new Cesium.ScreenSpaceEventHandler(slider);
        let moveActive = false;

        function move(movement) {
          if (!moveActive) {
            return;
          }

          const relativeOffset = movement.endPosition.x;
          const splitPosition = (slider.offsetLeft + relativeOffset) / slider.parentElement.offsetWidth;
          slider.style.left = `${100.0 * splitPosition}%`;
          viewer.scene.splitPosition = splitPosition;
        }

        sliderhandler.setInputAction(function () {
          moveActive = true;
        }, Cesium.ScreenSpaceEventType.LEFT_DOWN);
        sliderhandler.setInputAction(function () {
          moveActive = true;
        }, Cesium.ScreenSpaceEventType.PINCH_START);

        sliderhandler.setInputAction(move, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        sliderhandler.setInputAction(move, Cesium.ScreenSpaceEventType.PINCH_MOVE);

        sliderhandler.setInputAction(function () {
          moveActive = false;
        }, Cesium.ScreenSpaceEventType.LEFT_UP);
        sliderhandler.setInputAction(function () {
          moveActive = false;
        }, Cesium.ScreenSpaceEventType.PINCH_END);
      } else {
        this.$message.warning("请先选择两个图层!");
        this.ctrlSlider();
      }
    },
    //停止卷帘
    stopSlider() {
      document.getElementById('slider').style.display = "none";
      sliderhandler = sliderhandler && sliderhandler.destroy();
      viewer.scene.splitPosition = 1;
    },
  },
  mounted() {
    this.dogetModel();
    this.dogetBimCase();
  }
}
</script>

<style scoped>
.emer-row {
  color: #ffffff;
  margin: 8px 0;
}

.emer-row-label {
  width: 70px;
  font-size: 15px;
  margin: 0 0 0 7px;
  float: left;
}

.model-list {
  width: 100%;
  max-height: 210px;
  overflow-y: auto;
  overflow-x: hidden;
}

.model-list::-webkit-scrollbar {
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.model-list::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.model-list::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.list-tabel {
  width: 100%;
  border: none;
  margin-top: 5px;
  color: #fff;
  font-size: 14px;
}

.list-tabel td {
  padding: 2px 10px;
  cursor: pointer;
  height: 32px;
}

.list-tabel tr:nth-child(odd) {
  background: #004c5abb;
}

.list-tabel tr:nth-child(even) {
  background: #091d46bb;
}

.pop-fai {
  position: absolute;
  z-index: 100;
  top: 3px;
  color: #efefef;
  font-size: 15px;
  cursor: pointer;
  padding: 5px 6px;
}

.pop-fai-start {
  right: 160px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}

.pop-fai-pause {
  right: 120px;
}

.pop-fai-pause:hover {
  background-color: #e0960d;
}

.pop-fai-stop {
  right: 80px;
}

.pop-fai-stop:hover {
  background-color: #e6002f;
}

.pop-fai-slider {
  right: 200px;
}

.pop-fai-slider:hover {
  background-color: #001fe6;
}

.form-fai-update {
  font-size: 22px !important;
  cursor: pointer;
  margin: 0 8px 0 0;
}

.emer-input-half {
  width: 70px;
}
</style>
