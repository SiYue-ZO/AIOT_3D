<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <el-select v-model="formData.coverageId" placeholder="请选择" @change="changeTable">
            <el-option v-for="item in coverageArr" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
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
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'value', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="数据值" prop="value" sortable></el-table-column>
          <el-table-column label="地址" prop="addName" sortable></el-table-column>
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
          <el-form-item :label="item.attrName" prop="attributeArr" v-for="item in attributeArr" :key="item.value">
            <el-input v-if="item.type === '文本'" v-model="item.normalValue" placeholder="请填写"
                      style="width: 90%"></el-input>
            <el-select v-if="item.type === '下拉列表'" v-model="item.normalValue" placeholder="请选择分类">
              <el-option v-for="itemc in item.optionArr" :key="itemc" :label="itemc" :value="itemc"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="地址" prop="addName">
            <el-input v-model="formData.addName" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="点位坐标" prop="poi">
            <el-input v-model="formData.poi" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="addPoiToMapHandler"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="相机坐标" prop="camPoi">
            <el-input v-model="formData.camPoi" placeholder="请生成相机坐标" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="朝向" prop="camHeading">
            <el-input v-model="formData.camHeading" placeholder="请生成相机朝向" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="俯角" prop="camPitch">
            <el-input v-model="formData.camPitch" placeholder="请生成相机俯角" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="标签颜色" prop="color">
            <el-input v-model="formData.color" placeholder="请选择或填入CSS颜色值" style="width: 90%"></el-input>
            <el-color-picker class="color-picker" v-model="formData.color" size="small"
                             :predefine="predefineColors"></el-color-picker>
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
import {
  deleteAttributeData,
  getAttributeDataByCoverageId, getAttributeOnlyByCoverId,
  getCoverage,
  insertAttributeData,
  updateAttributeData
} from "../api/api";
import {stringToNumber} from "@/js/CesiumTools";

export default {
  name: "custom-attributeData",
  components: {CesiumMap},
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 10,   //每页的数据
      queryResult: [],
      tableDate: [],
      pictLoading: false,
      isTableShow: true,
      isEdit: false,
      currentId: '',
      currentRow: {},
      attributeArr: [],
      coverageArr: [],
      rules: {
        value: [{required: true, message: '请输入', trigger: 'blur'}],
        coverageId: [{required: true, message: '请输入', trigger: 'blur'}],
        addName: [{required: true, message: '请输入', trigger: 'blur'}],
        poi: [{required: true, message: '请输入', trigger: 'blur'}],
        camPoi: [{required: true, message: '请输入', trigger: 'blur'}],
        camHeading: [{required: true, message: '请输入', trigger: 'blur'}],
        camPitch: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        id: '',
        value: '',
        coverageId: '',
        addName: '',
        poi: '',
        camPoi: '',
        camHeading: '',
        camPitch: '',
        color: '',
        coverage: {
          id: '',
          name: '',
          color: ''
        }
      },
      predefineColors: [
        '#ff4500',
        '#ff8c00',
        '#ffd700',
        '#90ee90',
        '#00ced1',
        '#1e90ff',
        '#c71585',
      ]
    }
  },
  methods: {
    addPoiToMapHandler() {
      let _this = this;
      viewer.entities.removeAll();
      let drawHandler = drawHandler && drawHandler.destroy();
      let poiResult, camPoi, camHeading, camPitch;
      let pinBuilder = new Cesium.PinBuilder();//创建cesium pin标签
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        let cartesian = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        let height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          cartesian = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        let lng = Cesium.Math.toDegrees(cartographic.longitude);
        let lat = Cesium.Math.toDegrees(cartographic.latitude);
        poiResult = lng + "," + lat + "," + height;

        let camPoiR = viewer.camera.position;
        camPoi = camPoiR.x.toString() + "," + camPoiR.y.toString() + "," + camPoiR.z.toString();
        camHeading = viewer.camera.heading;
        camPitch = viewer.camera.pitch;

        let drawPointEntity = viewer.entities.getById("drawPointEntity");
        if (drawPointEntity === undefined) {
          viewer.entities.add({
            id: 'drawPointEntity',
            position: cartesian.clone(),
            billboard: {
              image: pinBuilder.fromText('新', Cesium.Color.fromCssColorString(_this.formData.coverage.color), 42).toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.GREEN.withAlpha(0.7)
            }
          });
        } else {
          drawPointEntity.position = cartesian.clone();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        _this.formData.poi = poiResult;
        _this.formData.camPoi = camPoi;
        _this.formData.camHeading = camHeading;
        _this.formData.camPitch = camPitch;
        drawHandler = drawHandler && drawHandler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    addPoiToMap(row) {
      viewer.entities.removeAll();
      let pois = stringToNumber(row.poi);
      let pinBuilder = new Cesium.PinBuilder();
      let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
      Promise.resolve(
        pinBuilder.fromUrl(url, Cesium.Color.RED, 30)
      ).then(function (canvas) {
        return viewer.entities.add({
          position: Cesium.Cartesian3.fromDegrees(pois[0], pois[1], pois[2]),
          billboard: {
            image: canvas.toDataURL(),
            verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
          },
          ellipsoid: {
            radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
            material: Cesium.Color.RED.withAlpha(0.7)
          }
        });
      });
      if (row.camPoi !== null) {
        let camPoiArr = stringToNumber(row.camPoi);
        viewer.camera.setView({
          destination: Cesium.Cartesian3.fromElements(camPoiArr[0], camPoiArr[1], camPoiArr[2]),
          orientation: {
            heading: Number(row.camHeading),
            pitch: Number(row.camPitch),
            roll: 0.0
          }
        });
      } else {
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(pois[0], pois[1], pois[2] + 600)
        });
      }
    },
    getCoverageData() {
      getCoverage().then(res => {
        this.coverageArr = res.data;
      });
    },
    changeTable() {
      this.currentRow = {};
      this.currentId = '';
      this.getAttributeDDataByCoverageId(this.formData.coverageId);
      let params = {
        coverageId: this.formData.coverageId
      };
      getAttributeOnlyByCoverId(params).then(res => {
        this.attributeArr = [];
        res.data.map((item, index) => {
          if (item.option !== null && item.option !== '') {
            item.optionArr = item.option.split('&');
          }
          this.attributeArr.push(item);
        });
      });
    },
    getAttributeDDataByCoverageId(coverageId) {
      let _this = this;
      this.pictLoading = true;
      let params = {
        coverageId: coverageId
      };
      getAttributeDataByCoverageId(params).then(res => {
        let _coverageArr = this.coverageArr;
        for (let i = 0; i < _coverageArr.length; i++) {
          if (_coverageArr[i].id === coverageId) {
            _this.formData.coverage.color = _coverageArr[i].color;
            break;
          }
        }
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.currentId = row.id;
      this.currentRow = row;
      this.addPoiToMap(row);
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
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        let valueArr = this.currentRow.value.split('&');
        this.attributeArr.map((item, i) => {
          for (let j = 0; j < valueArr.length; j++) {
            let valItem = valueArr[j].split('#');
            if (valItem[0] === item.attrName) {
              item.normalValue = valItem[1];
              break;
            }
          }
        });
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
            id: this.currentId
          };
          deleteAttributeData(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getAttributeDDataByCoverageId(this.formData.coverageId);
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
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.formData.value = '';
          this.attributeArr.map(item => {
            this.formData.value += item.attrName + '#' + item.normalValue + '&';
          });
          this.formData.value.substring(0, this.formData.value.length - 1);
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateAttributeData(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getAttributeDDataByCoverageId(this.formData.coverageId);
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
              insertAttributeData(this.formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getAttributeDDataByCoverageId(this.formData.coverageId);
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
    },
    backTable() {
      this.isTableShow = true;
      viewer.entities.removeAll();
    }
  },
  mounted() {
    this.getCoverageData();
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
      return (window.innerHeight - 130 - 90) + 'px';
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
  margin: 0 0 0 8px;
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

.color-picker {
  position: absolute;
  top: 4px;
  margin: 0 0 0 8px;
}
</style>
