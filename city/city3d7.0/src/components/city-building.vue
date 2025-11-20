<template>
  <div id="city-building-is-show">
    <div class="pop-fai pop-fai-follow" @click="bombFloor" title="炸开楼层">
      <font-awesome-icon :icon="['fas', 'bomb']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" @click="flattenFloor" title="压平外层">
      <font-awesome-icon :icon="['fas', 'cube']" fixed-width></font-awesome-icon>
    </div>
    <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
              v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
              element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
              :stripe="true" :fit="false" :highlight-current-row="true" size="small"
              :default-sort="{prop: 'net.netName', order: 'ascending'}" @row-click="rowClick">
      <el-table-column label="户型地址" prop="layoutName" width="215px" sortable>
      </el-table-column>
      <el-table-column label="社区" prop="net.netName" width="150px" sortable>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 20, 40]"
      :page-size="pagesize"
      :pager-count="5"
      layout="total, sizes, prev, pager, next"
      :total="queryResult.length">
    </el-pagination>
  </div>
</template>

<script>
  import {getLayout} from "../api/api";
  import map3d from "./map-3d";
  import "../js/CesiumFloor.js";
  import "../js/CesiumLayout.js";

  export default {
    name: "city-building",
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        pictLoading: false,
        queryResult: [],
        curData: {}
      }
    },
    methods: {
      //elementUI表格方法
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      //elementUI表格方法
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      //elementUI表格方法：点击行
      rowClick(row, column, event) {
        let camPoiArr = row.layoutPos.split(',');
        map3d.methods.flyToLocation([Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]) + 200]);
        this.addLayoutToMap(row);
      },
      //回显室内户型结构
      addLayoutToMap(data) {
        this.removeFloor();

        //回显分层分户
        if (data.layoutPos !== null && data.layoutPos !== '') {
          let options = {
            'viewer': viewer,
            'floorPoi': data.layoutPos,
            'floorHeight': data.layoutHeight,
          };
          CesiumFloor.showFloor(options);
        }

        this.curData = data
      },
      // 清除分层分户实体
      removeFloor() {
        CesiumFloor.removeFloor(viewer);
      },
      //室内户型
      clearLayoutFloorPoi() {
        CesiumLayout.clearLayout(viewer);
      },
      getLayoutData() {
        this.pictLoading = true;
        getLayout().then(res => {
          this.queryResult = res.data;
          this.pictLoading = false;
        });
      },
      closeCityBuilding() {
        this.removeFloor();
        this.clearLayoutFloorPoi();
        map3d.methods.clearClippingPlanes();
      },
      bombFloor() {
        CesiumLayout.bombFloor();
      },
      flattenFloor() {
        if (this.curData.layoutPos === undefined) {
          this.$message.warning('请先选择列表中的建筑地址！');
          return;
        }
        let data = this.curData;

        //压平模型
        let clipPos = [];
        let layoutPosArr = data.layoutPos.split(',');
        for (let i = 0; i < layoutPosArr.length; i = i + 3) {
          clipPos.push(Cesium.Cartesian3.fromDegrees(layoutPosArr[i], layoutPosArr[i + 1], layoutPosArr[i + 2]));
        }
        map3d.methods.flatten3dtilesmap(clipPos);

        this.clearLayoutFloorPoi();

        let layoutHeightArr = data.layoutHeight.split(',');
        for (let i = 0; i < layoutHeightArr.length - 2; i++) {
          let height = Number(layoutHeightArr[i]);

          //回显地板和外墙
          let options = {
            'viewer': viewer,
            'layoutPos': data.layoutPos,
            'height': height,
            // 'color': Cesium.Color.DEEPSKYBLUE.withAlpha(0.8),
            'color': new Cesium.ImageMaterialProperty({
              image: 'static/images/wallimg1.jpg',
              transparent: true,
            }),
            'outColor': Cesium.Color.DODGERBLUE,
            'textColor': "#ffffff",
            'floorNum': i + 1
          };
          CesiumLayout.showWalls(options);

          //回显室内墙体
          let walloptions = {
            'viewer': viewer,
            'layoutFloor': data.layoutFloor,
            'height': height,
            // 'color': Cesium.Color.DEEPSKYBLUE.withAlpha(0.8),
            'color': new Cesium.ImageMaterialProperty({
              image: 'static/images/wallimg.jpg',
              transparent: true,
            }),
            'outColor': Cesium.Color.DODGERBLUE
          };
          CesiumLayout.showLayout(walloptions);
        }
      }
    },
    mounted() {
      this.getLayoutData();
    },
  }
</script>

<style scoped>
  .result-table {
    width: 100%;
    color: #ffffff;
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

  .pop-fai-follow {
    right: 80px;
  }

  .pop-fai-follow:hover {
    background-color: #21e000;
  }

  .pop-fai-pause {
    right: 120px;
  }

  .pop-fai-pause:hover {
    background-color: #e0960d;
  }
</style>
