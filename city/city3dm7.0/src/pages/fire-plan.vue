<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter" class="search-input"></el-input>
          <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline"
                     @click="addData('formData')">
            添 加
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        </div>
        <div v-show="!isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
        <div v-show="!isTableShow" style="margin-top: 10px">
          <el-button class="header-button" type="primary" icon="el-icon-circle-check" @click="pauseOrContinue(true)">
            播 放
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="pauseOrContinue(false)">
            暂 停
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="stopRoaming">停 止</el-button>
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="deleteDraw">
            删 除
          </el-button>
          <el-button class="header-button" type="primary" icon="el-icon-circle-check" @click="stopDraw">
            结束绘制
          </el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'eplanType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="预案名称" prop="eplanName" sortable></el-table-column>
          <el-table-column label="预案类型" prop="eplanType" sortable></el-table-column>
          <el-table-column label="日期" prop="eplanDate" sortable></el-table-column>
        </el-table>
        <el-pagination
          class="my-pagination"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20, 40]"
          :page-size="pagesize"
          :pager-count="5"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableDate.length">
        </el-pagination>
      </div>
      <div v-show="!isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
          <el-form-item label="预案名称" prop="eplanName">
            <el-input v-model="formData.eplanName" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="预案类型" prop="eplanType">
            <el-select v-model="formData.eplanType" placeholder="请选择" style="width: 90%">
              <el-option label="防暴反恐" value="防暴反恐"></el-option>
              <el-option label="活动安保" value="活动安保"></el-option>
              <el-option label="消防灭火" value="消防灭火"></el-option>
              <el-option label="治安巡逻" value="治安巡逻"></el-option>
              <el-option label="区域安防" value="区域安防"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="预案时间" prop="eplanDate">
            <el-date-picker v-model="formData.eplanDate" align="left" type="date"
                            placeholder="选择日期" :picker-options="pickerOptions" style="width: 90%">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="操作提示">左键点击定位，右键结束绘制</el-form-item>
          <el-form-item label="点标记">
            <el-image class="btn-img" v-for="item in pointImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addPoint(item.type)"></el-image>
          </el-form-item>
          <el-form-item label="线标记">
            <el-image class="btn-img" v-for="item in polylineImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addPolyline(item.type)"></el-image>
          </el-form-item>
          <el-form-item label="面标记">
            <el-image class="btn-img" v-for="item in polygonImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addPolygon(item.type)"></el-image>
          </el-form-item>
          <el-form-item label="围墙标记">
            <el-image class="btn-img" v-for="item in wallImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addWall(item.type)"></el-image>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="模型名称" prop="modelName">
              <el-input v-model="formData.modelName"></el-input>
            </el-form-item>
            <el-form-item label="模型高度" prop="modelHeight">
              <el-input v-model="formData.modelHeight"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="缩放比例" prop="modelScale">
              <el-input v-model="formData.modelScale"></el-input>
            </el-form-item>
            <el-form-item label="旋转角度" prop="modelHeading">
              <el-input v-model="formData.modelHeading"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="模型标记">
            <el-image class="btn-img" v-for="item in modelImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addModel(item.type)"></el-image>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="漫游时间" prop="roamSpeed">
              <el-input v-model="formData.roamSpeed"></el-input>
            </el-form-item>
            <el-form-item label="路径高度" prop="roamHeight">
              <el-input v-model="formData.roamHeight"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="三维动画">
            <el-image class="btn-img" v-for="item in roamImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addRoam(item.type)"></el-image>
            <font-awesome-icon class="form-fai" :icon="['fas', 'globe-asia']" fixed-width title="左键点击地图绘制路径，右键结束"
                               @click="roamPreview" style="position: absolute;right:30px"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="粒子标记">
            <el-image class="btn-img" v-for="item in particleImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addParticle(item.type)"></el-image>
            <font-awesome-icon class="form-fai" :icon="['fas', 'reply']" fixed-width title="回退上一个粒子效果"
                               @click="deleteLastParticle" style="position: absolute;right:30px"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="标签文字" prop="labelText">
            <el-input v-model="formData.labelText" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="文字标记">
            <el-image class="btn-img" v-for="item in labelImgArr" :key="item.src" :title="item.title"
                      :src="item.src" v-on:click="addLabel(item.type)"></el-image>
          </el-form-item>
          <el-form-item label="相机坐标" prop="camPoi">
            <el-input v-model="formData.camPoi" placeholder="请生成相机坐标" style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="getPlanCam"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="朝向" prop="camHeading">
            <el-input v-model="formData.camHeading" placeholder="请生成相机朝向" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="俯角" prop="camPitch">
            <el-input v-model="formData.camPitch" placeholder="请生成相机俯角" style="width: 90%"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
      <CesiumMap></CesiumMap>
    </el-card>
  </div>
</template>

<script>
  import CesiumMap from "../utils/components/cesium-map";
  import {deleteEplan, getEplanAll, insertEplan, updateEplan} from "../api/api";
  import "../js/CesiumPlan";
  import {stringToNumber} from "@/js/CesiumTools";

  let curRoamType;
  let planobjid = '';
  let planpomhandler;//操作监听句柄对象

  export default {
    name: "fire-plan",
    components: {CesiumMap},
    data() {
      return {
        currentPage: 1, //初始页
        pagesize: 10,   //每页的数据
        queryResult: [],
        tableDate: [],
        pictLoading: false,
        devFilter: '',
        isTableShow: true,
        isEdit: false,
        currentId: '',
        currentRow: {},
        rules: {
          eplanName: [{required: true, message: '请输入', trigger: 'blur'}],
          eplanType: [{required: true, message: '请输入', trigger: 'blur'}],
          eplanCon: [{required: true, message: '请输入', trigger: 'blur'}],
          eplanDate: [{required: true, message: '请输入', trigger: 'blur'}],
          camPoi: [{required: true, message: '请输入', trigger: 'blur'}],
          camHeading: [{required: true, message: '请输入', trigger: 'blur'}],
          camPitch: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          eplanId: '',
          eplanName: '',
          eplanType: '防暴反恐',
          eplanCon: '',
          eplanDate: (new Date()).pattern("yyyy-MM-dd"),
          modelName: '',
          modelHeight: '1',
          modelScale: '1',
          modelHeading: '0',
          roamSpeed: '3000',
          roamHeight: '150',
          labelText: '标注文字',
          camPoi: '',
          camHeading: '',
          camPitch: '',
        },
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
        pointImgArr: [
          {title: '报警图标', src: common.serverIp + 'city3dfile/data/eplanimg/point1.png', type: 'caseimg'},
          {title: '蓝色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point2.png', type: 'blue'},
          {title: '红色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point3.png', type: 'red'},
          {title: '绿色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point4.png', type: 'green'},
          {title: '黄色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point5.png', type: 'yellow'},
          {title: '橙色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point6.png', type: 'orange'},
          {title: '紫色图标', src: common.serverIp + 'city3dfile/data/eplanimg/point7.png', type: 'purple'},
        ],
        polylineImgArr: [
          {title: '蓝色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline1.png', type: 'blue'},
          {title: '红色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline2.png', type: 'red'},
          {title: '绿色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline3.png', type: 'green'},
          {title: '黄色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline4.png', type: 'yellow'},
          {title: '橙色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline5.png', type: 'orange'},
          {title: '紫色线', src: common.serverIp + 'city3dfile/data/eplanimg/polyline6.png', type: 'purple'},
        ],
        polygonImgArr: [
          {title: '蓝色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon1.png', type: 'blue'},
          {title: '红色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon2.png', type: 'red'},
          {title: '绿色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon3.png', type: 'green'},
          {title: '黄色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon4.png', type: 'yellow'},
          {title: '橙色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon5.png', type: 'orange'},
          {title: '紫色面', src: common.serverIp + 'city3dfile/data/eplanimg/polygon6.png', type: 'purple'},
        ],
        wallImgArr: [
          {title: '蓝色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall1.png', type: 'blue'},
          {title: '红色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall2.png', type: 'red'},
          {title: '绿色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall3.png', type: 'green'},
          {title: '黄色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall4.png', type: 'yellow'},
          {title: '橙色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall5.png', type: 'orange'},
          {title: '紫色围墙', src: common.serverIp + 'city3dfile/data/eplanimg/wall6.png', type: 'purple'},
          {title: '坚固围栏', src: common.serverIp + 'city3dfile/data/eplanimg/wall7.png', type: 'wall7'},
          {title: '简易围栏', src: common.serverIp + 'city3dfile/data/eplanimg/wall8.png', type: 'wall8'},
        ],
        modelImgArr: [
          {title: '消防员-奔跑', src: common.serverIp + 'city3dfile/data/eplanimg/model1.png', type: 'firemana'},
          {title: '消防员-站立', src: common.serverIp + 'city3dfile/data/eplanimg/model2.png', type: 'fireman'},
          {title: '警车', src: common.serverIp + 'city3dfile/data/eplanimg/model3.png', type: 'jingche'},
          {title: '无人机', src: common.serverIp + 'city3dfile/data/eplanimg/model4.png', type: 'UAV'},
          {title: '旋翼无人机', src: common.serverIp + 'city3dfile/data/eplanimg/model5.png', type: 'rUAV'},
        ],
        roamImgArr: [
          {title: '警车-模型', src: common.serverIp + 'city3dfile/data/eplanimg/model3.png', type: 'jingche'},
          {title: '无人机', src: common.serverIp + 'city3dfile/data/eplanimg/model4.png', type: 'UAV'},
          {title: '旋翼无人机', src: common.serverIp + 'city3dfile/data/eplanimg/model5.png', type: 'rUAV'},
          {title: '警员', src: common.serverIp + 'city3dfile/data/eplanimg/police1.png', type: 'police'},
          {title: '警车', src: common.serverIp + 'city3dfile/data/eplanimg/policecar1.png', type: 'policecar'},
        ],
        particleImgArr: [
          {title: '火焰', src: common.serverIp + 'city3dfile/data/eplanimg/fire.png', type: 'fire'},
        ],
        labelImgArr: [
          {title: '文字', src: common.serverIp + 'city3dfile/data/eplanimg/label1.png', type: '28'},
        ],
      }
    },
    methods: {
      addPoint(type) {
        CesiumPlan.clearDrawHandler();
        let color;
        let poiimg = 'data/eplanimg/marker-stroked.png';
        switch (type) {
          case 'caseimg':
            poiimg = 'data/eplanimg/01.png';
            break;
          case 'blue':
            color = Cesium.Color.ROYALBLUE;
            break;
          case 'red':
            color = Cesium.Color.RED;
            break;
          case 'green':
            color = Cesium.Color.GREEN;
            break;
          case 'yellow':
            color = Cesium.Color.GOLD;
            break;
          case 'orange':
            color = Cesium.Color.DARKORANGE;
            break;
          case 'purple':
            color = Cesium.Color.PURPLE;
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'pointcolor': color,
          'poiimg': poiimg,
          'type': type,
          'size': 36,
          'pointId': pointId,
        };
        CesiumPlan.drawPoint(options);
      },
      addPolyline(type) {
        CesiumPlan.clearDrawHandler();
        let color;
        switch (type) {
          case 'blue':
            color = Cesium.Color.ROYALBLUE;
            break;
          case 'red':
            color = Cesium.Color.RED;
            break;
          case 'green':
            color = Cesium.Color.GREEN;
            break;
          case 'yellow':
            color = Cesium.Color.GOLD;
            break;
          case 'orange':
            color = Cesium.Color.DARKORANGE;
            break;
          case 'purple':
            color = Cesium.Color.PURPLE;
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'polylinecolor': color,
          'pointcolor': color,
          'polylineId': pointId,
          'type': type
        };
        CesiumPlan.drawPolyline(options);
      },
      addPolygon(type) {
        CesiumPlan.clearDrawHandler();
        let color;
        switch (type) {
          case 'blue':
            color = Cesium.Color.ROYALBLUE;
            break;
          case 'red':
            color = Cesium.Color.RED;
            break;
          case 'green':
            color = Cesium.Color.GREEN;
            break;
          case 'yellow':
            color = Cesium.Color.GOLD;
            break;
          case 'orange':
            color = Cesium.Color.DARKORANGE;
            break;
          case 'purple':
            color = Cesium.Color.PURPLE;
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'polygoncolor': color.withAlpha(0.5),
          'pointcolor': color,
          'polylineId': pointId,
          'type': type
        };
        CesiumPlan.drawPolygon(options);
      },
      addWall(type) {
        CesiumPlan.clearDrawHandler();
        let color;
        switch (type) {
          case 'blue':
            color = Cesium.Color.ROYALBLUE;
            break;
          case 'red':
            color = Cesium.Color.RED;
            break;
          case 'green':
            color = Cesium.Color.GREEN;
            break;
          case 'yellow':
            color = Cesium.Color.GOLD;
            break;
          case 'orange':
            color = Cesium.Color.DARKORANGE;
            break;
          case 'purple':
            color = Cesium.Color.PURPLE;
            break;
          case 'wall7':
            color = new Cesium.ImageMaterialProperty({
              'image': 'data/eplanimg/02.png',
              'transparent': true
            });
            break;
          case 'wall8':
            color = new Cesium.ImageMaterialProperty({
              'image': 'data/eplanimg/03.png',
              'transparent': true
            });
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let finalcolor = (type === 'wall7' || type === 'wall8') ? color : color.withAlpha(0.5);
        let options = {
          'viewer': viewer,
          'polylinecolor': finalcolor,
          'pointcolor': color,
          'wallHeight': 3,
          'polylineId': pointId,
          'wallType': type
        };
        CesiumPlan.drawWall(options);
      },
      addModel(type) {
        CesiumPlan.clearDrawHandler();
        let modelUrl;
        switch (type) {
          case 'firemana':
            modelUrl = 'data/model/man/fireman_a.gltf';
            break;
          case 'fireman':
            modelUrl = 'data/model/man/fireman.glb';
            break;
          case 'jingche':
            modelUrl = 'data/model/car/jingche_a.gltf';
            break;
          case 'UAV':
            modelUrl = "data/model/air/UAV.glb";
            break;
          case 'rUAV':
            modelUrl = "data/model/air/rUAVa.gltf";
            break;
          default:
            break;
        }
        let modelId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'modelUrl': modelUrl,
          'modelHeading': this.formData.modelHeading,
          'modelScale': this.formData.modelScale,
          'modelHeight': this.formData.modelHeight,
          'modelName': this.formData.modelName,
          'modelId': modelId,
          'type': type
        };
        CesiumPlan.drawModel(options);
      },
      addRoam(type) {
        curRoamType = type;
        let options = {
          'viewer': viewer,
          'polylinecolor': Cesium.Color.YELLOW,
          'pointcolor': Cesium.Color.RED.withAlpha(0.8),
          'printId': 'roamLine',
          'roamHeight': this.formData.roamHeight,
        };
        CesiumPlan.drawRoamDraw(options);
      },
      roamPreview() {
        CesiumPlan.clearRoamDraw(viewer);
        let modeluri = '';
        let modelscale = 0;
        let roamtype = '';
        switch (curRoamType) {
          case 'jingche':
            modeluri = "data/model/car/jingche_a.gltf";
            modelscale = 1;
            roamtype = 'model';
            break;
          case 'UAV':
            modeluri = "data/model/air/UAV.glb";
            modelscale = 0.01;
            roamtype = 'model';
            break;
          case 'rUAV':
            modeluri = "data/model/air/rUAVa.gltf";
            modelscale = 0.5;
            roamtype = 'model';
            break;
          case 'police':
            modeluri = 'data/eplanimg/police1.png';
            modelscale = 1;
            roamtype = 'img';
            break;
          case 'policecar':
            modeluri = 'data/eplanimg/policecar1.png';
            modelscale = 1;
            roamtype = 'img';
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'roamId': pointId,
          'modeluri': modeluri,
          'scale': modelscale,
          'lines': CesiumPlan.getRoamLine(),
          'isPathShow': true,
          'isRe': true,
          'roamIsmodelshow': false,
          'speed': this.formData.roamSpeed,
          'type': '折线',
          'modeltype': curRoamType,
          'roamtype': roamtype
        };
        CesiumPlan.initRoaming(options);
      },
      addParticle(type) {
        CesiumPlan.clearDrawHandler();
        let particleCollection = new Cesium.PrimitiveCollection();
        viewer.scene.primitives.add(particleCollection);
        let particleImg;
        switch (type) {
          case 'fire':
            particleImg = "data/eplanimg/fire.png";
            break;
          default:
            break;
        }
        let particleId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'particleImg': particleImg,
          'endScale': 9,
          'emitterRadius': 4,
          'particleId': particleId,
          'particleCollection': particleCollection,
          'type': type
        };
        CesiumPlan.drawParticle(options);
      },
      addLabel(type) {
        CesiumPlan.clearDrawHandler();
        let labelImg;
        switch (type) {
          case '28':
            labelImg = "data/eplanimg/28";
            break;
          default:
            break;
        }
        let pointId = new Date().getTime();
        let options = {
          'viewer': viewer,
          'labelImg': labelImg,
          'labelText': this.formData.labelText,
          'pointId': pointId,
          'type': type
        };
        CesiumPlan.drawLabel(options);
      },
      getPlanCam() {
        let camPoiR = viewer.camera.position;
        let camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
        let camHeading = viewer.camera.heading;
        let camPitch = viewer.camera.pitch;
        this.formData.camPoi = camPoi;
        this.formData.camHeading = camHeading;
        this.formData.camPitch = camPitch;
      },
      pauseOrContinue(isPause) {
        CesiumPlan.PauseOrContinue(viewer, isPause);
      },
      stopRoaming() {
        CesiumPlan.EndRoaming(viewer);
      },
      stopDraw() {
        CesiumPlan.stopDraw();
      },
      deleteDraw() {
        CesiumPlan.deleteDraw(viewer, planobjid);
      },
      deleteLastParticle() {
        CesiumPlan.deleteLastParticle();
      },
      addPOMListener() {
        planpomhandler = planpomhandler && planpomhandler.destroy();
        planpomhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        planpomhandler.setInputAction(function (movement) {
          let pickedObject = viewer.scene.pick(movement.position);
          if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)) {
            if (typeof pickedObject.id == "string") {
              planobjid = pickedObject.id;
            } else {
              planobjid = pickedObject.id._id;
            }
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      },
      getEplanData() {
        this.pictLoading = true;
        getEplanAll().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.eplanId;
        this.currentRow = row;
        viewer.entities.removeAll();
        CesiumPlan.clearDraw(viewer);
        CesiumPlan.addAllPlan(row.eplanCon, viewer);
        if (row.camPoi !== null && row.camPoi !== "") {
          let camPoiArr = stringToNumber(row.camPoi);
          viewer.camera.setView({
            destination: Cesium.Cartesian3.fromElements(camPoiArr[0], camPoiArr[1], camPoiArr[2]),
            orientation: {
              heading: Number(row.camHeading),
              pitch: Number(row.camPitch),
              roll: 0.0
            }
          });
        }
      },
      handleSizeChange: function (size) {
        this.pagesize = size;
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
      },
      addData(formName) {
        this.isTableShow = false;
        this.isEdit = false;
        this.$refs[formName].resetFields();
        CesiumPlan.clearEplanCon();
        viewer.entities.removeAll();
        CesiumPlan.clearDraw(viewer);
      },
      editData() {
        if (this.currentId !== '') {
          this.isTableShow = false;
          this.isEdit = true;
          this.formData = Object.assign(this.formData, this.currentRow);
        } else {
          this.$message({
            message: '请选择需要操作的行！',
            type: 'warning'
          });
        }
      },
      deleteData() {
        if (this.currentId !== '') {
          this.$confirm('删除后无法恢复，请确认是否删除？', '删除数据', {
            distinguishCancelAndClose: true,
            confirmButtonText: '确认',
            cancelButtonText: '取消'
          }).then(() => {
            let params = {
              eplanId: this.currentId
            };
            deleteEplan(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getEplanData();
              } else {
                this.$message({
                  type: 'error',
                  message: '删除失败，请重试！'
                });
              }
            });
          }).catch(action => {
            this.$message({
              type: 'warning',
              message: '放弃删除！'
            });
          });
        } else {
          this.$message({
            message: '请选择需要操作的行！',
            type: 'warning'
          });
        }
      },
      multideleteData() {
        this.$message({
          message: '待完善，批量删除！',
          type: 'error'
        });
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let EplanConArr = CesiumPlan.getEplanCon();
            let eplanConStr = '';
            for (let i = 0; i < EplanConArr.length; i++) {
              eplanConStr += EplanConArr[i] + ";";
            }
            let params = this.formData;
            params.eplanDate = new Date(params.eplanDate).toLocaleDateString().replace(/\//g, '-');
            params.eplanCon = eplanConStr;
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateEplan(params).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getEplanData();
                  } else {
                    this.$message({
                      type: 'error',
                      message: '修改失败，请重试！'
                    });
                  }
                });
              }).catch(action => {
                this.$message({
                  type: 'warning',
                  message: '请完善信息！'
                });
              });
            } else {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                insertEplan(params).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getEplanData();
                  } else {
                    this.$message({
                      type: 'error',
                      message: '新增失败，请重试！'
                    });
                  }
                });
              }).catch(action => {
                this.$message({
                  type: 'warning',
                  message: '请完善信息！'
                });
              });
            }
          } else {
            this.$message({
              message: '请完善信息！',
              type: 'error'
            });
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        viewer.entities.removeAll();
        CesiumPlan.clearDraw(viewer);
      },
      backTable() {
        this.isTableShow = true;
        viewer.entities.removeAll();
        CesiumPlan.clearDraw(viewer);
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.eplanName.indexOf(val)
            || ~item.eplanType.indexOf(val)
            || ~item.eplanDate.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getEplanData();
      this.addPOMListener();
    },
    computed: {
      viewerHeight: function () {
        return (window.innerHeight - 130) + 'px';
      },
      leftWidth: function () {
        return ((window.innerWidth - 230) * 0.4) + 'px';
      },
      rightWidth: function () {
        return ((window.innerWidth - 230) * 0.6) + 'px';
      },
      cardBodyHeight: function () {
        return (window.innerHeight - 130 - 140) + 'px';
      },
    }
  }
</script>

<style scoped>
  .left-card {
    float: left;
  }

  .right-card {
    float: right;
  }

  .form-fai {
    font-size: 19px !important;
    cursor: pointer;
    margin: 10px 0 0 8px;
    color: #007acc;
  }

  .result-table {
    width: 100%;
    font-size: 15px !important;
  }

  .my-card-body {
    overflow-y: auto;
    font-size: 15px !important;
  }

  .btn-img {
    width: 55px;
    height: 55px;
    margin-right: 10px;
    cursor: pointer;
    border-radius: 7px;
  }

  .row_display {
    display: flex;
  }

  .search-input {
    width: 180px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
