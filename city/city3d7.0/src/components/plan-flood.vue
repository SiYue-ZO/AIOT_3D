<template>
  <div id="plan-flood-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="startFlood" v-show="!isStarted" title="播放">
      <font-awesome-icon :icon="['fas', 'play']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="!isPause" title="继续">
      <font-awesome-icon :icon="['fas', 'step-forward']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-pause" v-on:click="pauseOrContinue" v-show="isPause" title="暂停">
      <font-awesome-icon :icon="['fas', 'pause']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="stopFlood" title="停止清除">
      <font-awesome-icon :icon="['fas', 'stop']"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">基准高</div>
      <el-input class="emer-input" v-model="floodHeight" placeholder="输入或点选基准高" size="small"
                @change="floodHeightOnchange"></el-input>
      <font-awesome-icon class="pop-fai-btn-maker" :icon="['fas', 'map-marker-alt']" fixed-width
                         v-on:click="getFloodHeight"></font-awesome-icon>
      <div class="emer-row-label-r">米</div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">发生区域</div>
      <el-radio-group v-model="floodRegion" size="small">
        <el-radio border label="城市"></el-radio>
        <el-radio border label="乡镇/野外"></el-radio>
      </el-radio-group>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">淹没面积</div>
      <el-input class="emer-input" v-model="floodArea" placeholder="淹没分析降雨范围" size="small"></el-input>
      <font-awesome-icon class="pop-fai-btn-maker" :icon="['fas', 'edit']" fixed-width
                         v-on:click="drawArea"></font-awesome-icon>
      <div class="emer-row-label-r">平方米</div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">模拟速度</div>
      <el-input-number class="emer-input" v-model="floodSpeed" :min="1" :max="10" size="small"></el-input-number>
      <font-awesome-icon class="pop-fai-btn-maker" :icon="['fas', 'times-circle']" fixed-width
                         v-on:click="clearFloodArea"></font-awesome-icon>
      <div class="emer-row-label-r">(1-10)</div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">排涝能力</div>
      <el-input class="emer-input" v-model="floodDown" placeholder="输入单位时间排涝水位" size="small"></el-input>
      <div class="emer-row-label-r-nobtn">毫米</div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label" style="width:360px">-- · 天气预报 · --</div>
      <iframe width="350" scrolling="no" height="100" frameborder="0" allowtransparency="true"
              src="https://i.tianqi.com?c=code&id=48&color=%23FFFFFF&icon=1&num=3&site=12"></iframe>
    </div>
    <div class="emer-row">
      <div class="emer-row-label" style="width: 360px; margin-bottom: 20px; color: #00ffff">降雨量录入：
        <div class="split-line"></div>
      </div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">降雨量</div>
      <el-input class="emer-input" v-model="floodVal" placeholder="降雨量" size="small"></el-input>
      <div class="emer-row-label-r-nobtn">毫米</div>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">时间</div>
      <el-date-picker v-model="floodTime" align="left" type="datetime" size="small"
                      placeholder="选择日期" :picker-options="pickerOptions" class="emer-input">
      </el-date-picker>
      <font-awesome-icon class="pop-fai-btn" :icon="['fas', 'plus-circle']"
                         v-on:click="addFloodData"></font-awesome-icon>
      <font-awesome-icon class="pop-fai-btn" :icon="['fas', 'times-circle']"
                         v-on:click="clearFloodData"></font-awesome-icon>
    </div>
    <div class="emer-row">
      <div class="emer-row-label">模拟降雨</div>
      <el-radio-group v-model="isRainShow" size="small">
        <el-radio border label="是"></el-radio>
        <el-radio border label="否"></el-radio>
      </el-radio-group>
    </div>
    <div class="emer-row">
      <el-table class="result-table" :data="queryResult.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                v-loading="pictLoading" element-loading-background="rgba(0, 0, 0, 0.5)"
                element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                :stripe="true" :fit="false" :highlight-current-row="true" size="small"
                :default-sort="{prop: 'floodTime', order: 'descending'}">
        <el-table-column label="序号" prop="floodId" width="70px" sortable></el-table-column>
        <el-table-column label="时间" prop="floodTime" width="175px" sortable></el-table-column>
        <el-table-column label="降雨量" prop="floodVal" width="110px" sortable></el-table-column>
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
    <div class="emer-row">
      <div id="floodStatDiv" class="flood-stat"></div>
    </div>
  </div>
</template>

<script>
  import echarts from 'echarts';
  import demoWeather from './demo-weather';

  let floodStat;
  let pointArr = [];
  let handler = handler && handler.destroy();
  let activeShapePoints = [];
  let waterPrimitive;
  let _this;
  let floodInterval;
  let floodCurHeight = 0;
  let interIndex = 0;

  export default {
    name: "plan-flood",
    data() {
      return {
        floodArea: 0,
        floodHeight: 0,
        floodRegion: '城市',
        floodVal: 0,
        floodTime: new Date().toISOString(),
        floodDown: 0,
        floodSpeed: 1,
        isRainShow: '是',
        queryResult: [],
        pictLoading: false,
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        isPause: true,
        isStarted: false,
        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
      }
    },
    methods: {
      drawArea() {
        this.clearPointsSelect();

        activeShapePoints = [];
        handler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        handler.setInputAction(function (movement) {
          let earthPosition = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
          let height = cartographic.height; //模型高度
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
          }
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
          for (let i = 0; i < pointArr.length; i++) {
            viewer.entities.remove(pointArr[i]);
          }
          pointArr = [];
          if (viewer.entities.getById("comEntity") !== undefined) {
            viewer.entities.removeById("comEntity");
          }
          if (activeShapePoints.length > 2) {
            let tempPoints = [];
            for (let pindex = 0; pindex < activeShapePoints.length; pindex++) {
              let cartographic = Cesium.Cartographic.fromCartesian(activeShapePoints[pindex].clone());
              let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
              let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
              let heightString = cartographic.height;
              tempPoints.push({lon: longitudeString, lat: latitudeString, hei: heightString});
            }
            if (activeShapePoints.length > 2) {
              _this.floodArea = getArea(tempPoints);
            } else if (activeShapePoints.length === 2) {
              _this.floodArea = getTriArea(tempPoints);
            }
            _this.createWater(activeShapePoints);
          } else {
            _this.$message.error('错误，淹没范围图形至少为三角形！');
          }
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
                Cesium.Color.SANDYBROWN.withAlpha(0.3)
              ),
              classificationType: Cesium.ClassificationType.BOTH,
            },
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
      },
      createWater(water) {
        let baseWaterColor;
        if (this.floodRegion === '城市') {
          baseWaterColor = Cesium.Color.fromCssColorString('#1f3751')
        } else {
          baseWaterColor = Cesium.Color.fromCssColorString('#b27a42')
        }
        waterPrimitive = new Cesium.Primitive({
          show: true,// 默认隐藏
          allowPicking: false,
          releaseGeometryInstances: false,
          geometryInstances: new Cesium.GeometryInstance({
            geometry: new Cesium.PolygonGeometry({
              polygonHierarchy: new Cesium.PolygonHierarchy(water),
              //extrudedHeight: 0,//注释掉此属性可以只显示水面
              perPositionHeight: false,//注释掉此属性水面就贴地了
              height: floodCurHeight
            })
          }),
          // 可以设置内置的水面shader
          appearance: new Cesium.EllipsoidSurfaceAppearance({
            material: new Cesium.Material({
              fabric: {
                type: 'Water',
                uniforms: {
                  // baseWaterColor:Cesium.Color.SANDYBROWN,
                  // baseWaterColor: Cesium.Color.fromCssColorString('#b28850'),
                  baseWaterColor: baseWaterColor,
                  normalMap: 'static/images/water/waterNormals.jpg',
                  frequency: 2000.0,
                  animationSpeed: 0.01,
                  amplitude: 2.6,
                  specularIntensity: 0.07,
                }
              }
            }),
          })
        });
        viewer.scene.primitives.add(waterPrimitive);
      },
      //清除框选绘制点
      clearPointsSelect() {
        if (viewer.entities.getById("comEntity") !== undefined) {
          viewer.entities.removeById("comEntity");
        }
        for (let i = 0; i < pointArr.length; i++) {
          viewer.entities.remove(pointArr[i]);
        }
        pointArr = [];
        handler = handler && handler.destroy();
      },
      clearFloodArea() {
        this.floodArea = 0;
        viewer.scene.primitives.remove(waterPrimitive);
      },
      floodHeightOnchange() {
        floodCurHeight = Number(this.floodHeight);
      },
      getFloodHeight() {
        let RHPChandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        RHPChandler.setInputAction(function (movement) {
          let cartesian = viewer.scene.pickPosition(movement.position);
          let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          let height = cartographic.height;//模型高度
          //如果没有三维数据，获取地形数据对应的坐标
          if (Number(height) < 0) {
            let ray = viewer.camera.getPickRay(movement.position);
            cartesian = viewer.scene.globe.pick(ray, viewer.scene);
          }
          cartographic = Cesium.Cartographic.fromCartesian(cartesian);
          _this.floodHeight = cartographic.height;//模型高度
          floodCurHeight = cartographic.height;//模型高度
          RHPChandler.destroy();
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      },
      startFlood() {
        if (waterPrimitive) {
          if (this.queryResult.length > 0) {
            viewer.scene.primitives.remove(waterPrimitive);
            let floodMat;
            if (this.floodRegion === '城市') {
              floodMat = Cesium.Color.fromCssColorString('#1f3751').withAlpha(0.7);
            } else {
              floodMat = Cesium.Color.fromCssColorString('#b27a42').withAlpha(0.7);
            }
            viewer.entities.add({
              id: "floodEnt",
              polygon: {
                hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
                material: floodMat,
                classificationType: Cesium.ClassificationType.NONE,
                height: new Cesium.CallbackProperty(function (time, result) {
                  return floodCurHeight;
                }, false),
              },
            });
            _this.floodAnimation();
            this.isStarted = true;
          } else {
            _this.$message.warning('请先录入降雨信息！');
          }
        } else {
          _this.$message.warning('请先绘制淹没范围！');
        }
      },
      pauseOrContinue() {
        if (waterPrimitive) {
          if (this.queryResult.length > 0) {
            if (this.isPause) {
              clearInterval(floodInterval);
            } else {
              _this.floodAnimation();
            }
            this.isPause = !this.isPause;
          } else {
            _this.$message.warning('请先录入降雨信息！');
          }
        } else {
          _this.$message.warning('请先绘制淹没范围！');
        }
      },
      floodAnimation() {
        floodInterval = setInterval(() => {
          if (interIndex < _this.queryResult.length) {
            //水面抬升
            floodCurHeight += (Number(_this.queryResult[interIndex].floodVal) - _this.floodDown) / 100;//实际情况应该除以1000，为了效果，夸张10倍，实际项目中应调整为1000
            //统计图表浮窗推进
            floodStat.dispatchAction({
              type: 'showTip',
              seriesIndex: 0,
              dataIndex: interIndex
            });
            //降雨模拟
            if (_this.isRainShow === '是') {
              if (_this.queryResult[interIndex].floodVal > 20) {
                demoWeather.methods.openRainHigh();
              } else if (_this.queryResult[interIndex].floodVal <= 20 && _this.queryResult[interIndex].floodVal > 10) {
                demoWeather.methods.openRainMid()
              } else if (_this.queryResult[interIndex].floodVal <= 10 && _this.queryResult[interIndex].floodVal > 0) {
                demoWeather.methods.openRainLow();
              }
            }
            interIndex++;
          } else {
            _this.stopFlood();
          }
        }, 500 * 10 / _this.floodSpeed);
      },
      stopFlood() {
        if (waterPrimitive) {
          if (this.queryResult.length > 0) {
            clearInterval(floodInterval);
            viewer.entities.removeById("floodEnt");
            _this.createWater(activeShapePoints);
            _this.$message.success('淹没分析已停止！');
            this.isStarted = false;
            interIndex = 0;
            floodCurHeight = Number(this.floodHeight);
            demoWeather.methods.closeWeather();
          } else {
            _this.$message.warning('请先录入降雨信息！');
          }
        } else {
          _this.$message.warning('请先绘制淹没范围！');
        }
      },
      //elementUI表格方法
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      //elementUI表格方法
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      addFloodData() {
        this.pictLoading = true;
        let floodTimeFormat = new Date(this.floodTime).toLocaleString().replace(/\//g, '-');
        let floodData = {
          floodId: this.queryResult.length + 1,
          floodVal: this.floodVal,
          floodTime: floodTimeFormat,
        };
        this.queryResult.push(floodData);
        this.floodVal = 0;
        this.floodTime = new Date().toISOString();
        this.pictLoading = false;
        let data = [[], [], []];
        let totalVal = 0;
        this.queryResult.map(item => {
          data[0].push(item.floodTime);
          data[1].push(item.floodVal);
          data[2].push(totalVal += Number(item.floodVal));
        });
        this.freshChart(data);
      },
      clearFloodData() {
        this.queryResult = [];
        let data = [[], [], []];
        this.freshChart(data);
      },
      closeFlood() {
        this.clearPointsSelect();
        clearInterval(floodInterval);
        viewer.entities.removeById("floodEnt");
        this.clearFloodArea();
      },
      initChart() {
        floodStat = this.$echarts.init(document.getElementById("floodStatDiv"), 'dark');
        let floodStatOption = {
          legend: {top: '5px'},
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow',
            },
            backgroundColor: 'rgba(9, 24, 48, 0.5)',
            textStyle: {
              color: '#CFE3FC',
            },
            formatter: (p) => {
              let str = '<div>时间：' + p[0].name + '</div><div>降雨量：' + p[0].data + '毫米</div><div>累计降雨量：' + p[1].data + '毫米</div>';
              return str;
            }
          },
          grid: {
            left: '5px',
            right: '20px',
            top: '45px',
            bottom: '10px',
            containLabel: true,
          },
          toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: false, readOnly: false},
              saveAsImage: {show: false}
            }
          },
          backgroundColor: 'rgba(255, 255, 255, 0)',
          xAxis: [{
            type: 'category',
            data: [],
            boundaryGap: true,
            axisTick: {
              show: true,
              alignWithLabel: true
            },
            axisLabel: {
              // interval: interVal,
              fontSize: 10,
            },
          }],
          yAxis: {},
          series: [
            {
              name: '降雨量',
              data: [],
              type: 'line',
              smooth: true,
              symbol: 'circle',
              symbolSize: 7,
              itemStyle: {
                type: 'normal',
                // color: 'rgba(0, 255, 240, 1)',
                color: 'rgba(98, 227, 255, 1)',
              },
              areaStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: 'rgba(98, 227, 255, 1)',
                  },
                  {
                    offset: 1,
                    color: 'rgba(98, 227, 255, 0)',
                  },
                ]),
              },
            },
            {
              name: '累计降雨量',
              data: [],
              type: 'line',
              smooth: true,
              symbol: 'circle',
              symbolSize: 7,
              itemStyle: {
                type: 'normal',
                // color: 'rgba(0, 255, 240, 1)',
                color: '#188df0',
              },
              areaStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: '#188df0',
                  },
                  {
                    offset: 1,
                    color: '#188df000',
                  },
                ]),
              },
            },
          ]
        };
        floodStat.setOption(floodStatOption);
      },
      freshChart(data) {
        floodStat.setOption({
          xAxis: {
            data: data[0]
          },
          series: [{
            // 根据名字对应到相应的系列
            name: '降雨量',
            data: data[1]
          }, {
            name: '累计降雨量',
            data: data[2]
          }]
        });
      },
    },
    mounted() {
      _this = this;
      setTimeout(() => {
        _this.initChart();
      }, 2000);
      demoWeather.methods.initWeather();
    }
  }
</script>

<style scoped>
  .emer-row {
    color: #ffffff;
    margin: 8px 0;
  }

  .emer-row-label {
    width: 75px;
    font-size: 16px;
    margin-top: 5px;
    float: left;
  }

  .emer-row-label-r {
    width: 50px;
    font-size: 16px;
    margin-top: 6px;
    margin-right: 21px;
    float: right;
  }

  .emer-row-label-r-nobtn {
    width: 50px;
    font-size: 16px;
    margin-top: 6px;
    margin-right: 45px;
    float: right;
  }

  .emer-input {
    width: 180px;
  }

  .flood-stat {
    color: #fff;
    width: 380px;
    height: 320px;
  }

  .result-table {
    width: 100%;
    color: #ffffff;
  }

  .pop-fai-btn {
    color: #00ffff;
    font-size: 20px;
    cursor: pointer;
    margin-left: 10px;
  }

  .pop-fai-btn-maker {
    color: #00ffff;
    font-size: 20px;
    cursor: pointer;
    float: right;
    margin-top: 7px;
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

  .split-line {
    border-bottom: solid 1px #00ffff;
    width: 250px;
    margin: -10px 0 0 100px;
  }
</style>
