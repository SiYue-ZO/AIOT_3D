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
          <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
          </el-button>
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
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="lId"
                  :default-sort="{prop: 'lType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="线路名称" prop="lName" sortable></el-table-column>
          <el-table-column label="类别" prop="lType" sortable></el-table-column>
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
          <el-form-item label="线路名称" prop="lName">
            <el-input v-model="formData.lName" placeholder="请填写线路名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="类别" prop="lType">
            <el-input v-model="formData.lType" placeholder="请填写线路类别" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="线路坐标" prop="lPoyline">
            <el-input v-model="formData.lPoyline" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 90%" type="textarea" :rows="5"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'map-marker-alt']" fixed-width
                               @click="addLineToMapHandler"></font-awesome-icon>
          </el-form-item>
          <el-form-item label="外观颜色" prop="lColor">
            <el-input v-model="formData.lColor" placeholder="请选择或填入CSS颜色值" style="width: 90%"></el-input>
            <el-color-picker class="color-picker" v-model="formData.lColor" size="small"
                             :predefine="predefineColors"></el-color-picker>
          </el-form-item>
          <el-form-item label="登记时间" prop="lTime">
            <el-date-picker v-model="formData.lTime" align="left" type="date"
                            placeholder="选择日期" :picker-options="pickerOptions" style="width: 90%">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="人员姓名" prop="lPName">
            <el-input v-model="formData.lPName" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="停留时间" prop="lStop">
            <el-input v-model="formData.lStop" placeholder="请填写" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="活动范围" prop="lLiving">
            <el-input v-model="formData.lLiving" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="lNote">
            <el-input v-model="formData.lNote" placeholder="请填写" style="width: 90%" type="textarea"
                      :autosize="{minRows: 2, maxRows: 2}"></el-input>
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
  import {
    deletePoliceLine,
    getPoliceLine,
    insertPoliceLine,
    updatePoliceLine,
    batchDeletePoliceLine
  } from "../api/api";
  import {stringToNumber} from "@/js/CesiumTools";
  import CesiumMap from "../utils/components/cesium-map";

  export default {
    name: "duty-line",
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
        multipleSelection: [],
        rules: {
          lName: [{required: true, message: '请输入', trigger: 'blur'}],
          lType: [{required: true, message: '请输入', trigger: 'blur'}],
          lPoyline: [{required: true, message: '请输入', trigger: 'blur'}],
          lColor: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          lId: '',
          lName: '',
          lType: '',
          lPoyline: '',
          lColor: '',
          lTime: '',
          lPName: '',
          lStop: '',
          lLiving: '',
          lNote: '',
        },
        predefineColors: [
          '#ff4500',
          '#ff8c00',
          '#ffd700',
          '#90ee90',
          '#00ced1',
          '#1e90ff',
          '#c71585',
        ],
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
      addLineToMapHandler() {
        let _this = this;
        viewer.entities.removeAll();
        let drawHandler = drawHandler && drawHandler.destroy();
        let isFirst = true;//是否为第一个点
        let previousPosition;//前一个点的坐标
        let currentPosition;//当前点坐标
        let dynamicLineGroundEntity = viewer.entities.add({
          id: 'dynamicLineGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.RED,
          }
        });
        //已输入的线段的entity
        let measureLineGroundEntity = viewer.entities.add({
          id: 'measureLineGroundEntity',
          polyline: {
            clampToGround: true,
            width: 3,
            material: Cesium.Color.YELLOW,
          }
        });

        //节点添加标签
        function addPin(carPoi) {
          viewer.entities.add({
            position: carPoi,
            point: {
              pixelSize: 10,
              color: Cesium.Color.RED,
              disableDepthTestDistance: 5000000,
              outlineWidth: 2,
              outlineColor: Cesium.Color.WHITE
            },
          });
        }

        let measureLinePositonsArray = [];//存储已量测的线段的折点
        drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        drawHandler.setInputAction(function (movement) {
          if (isFirst) {
            previousPosition = viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(previousPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              previousPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            let tmp1 = previousPosition.clone();
            measureLinePositonsArray.push(tmp1);
            isFirst = false;
            addPin(tmp1);
          } else {
            currentPosition = viewer.scene.pickPosition(movement.position);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.position);
              currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            let tmp2 = currentPosition.clone();
            measureLinePositonsArray.push(tmp2);
            measureLineGroundEntity.polyline.positions = measureLinePositonsArray;
            previousPosition = currentPosition.clone();
            addPin(tmp2);
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        drawHandler.setInputAction(function (movement) {
          if (!isFirst) {
            //获取当前点的坐标
            currentPosition = viewer.scene.pickPosition(movement.endPosition);
            let cartographic = Cesium.Cartographic.fromCartesian(currentPosition);
            let height = cartographic.height;//模型高度
            if (Number(height) < 0) {
              let ray = viewer.camera.getPickRay(movement.endPosition);
              currentPosition = viewer.scene.globe.pick(ray, viewer.scene);
            }
            if (currentPosition) {
              dynamicLineGroundEntity.polyline.positions = [previousPosition, currentPosition];
            }
          }
        }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
        drawHandler.setInputAction(function () {
          drawHandler = drawHandler && drawHandler.destroy();
          let tempPointsStr = '';
          for (let i = 0; i < measureLinePositonsArray.length; i++) {
            let cartographic = Cesium.Cartographic.fromCartesian(measureLinePositonsArray[i]);
            let longitudeString = Cesium.Math.toDegrees(cartographic.longitude);
            let latitudeString = Cesium.Math.toDegrees(cartographic.latitude);
            let heightString = cartographic.height;
            tempPointsStr += longitudeString + "," + latitudeString + "," + heightString + ",";
          }
          _this.formData.lPoyline = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      addLineToMap(pois, color) {
        viewer.entities.removeAll();
        viewer.entities.add({
          polyline: {
            positions: Cesium.Cartesian3.fromDegreesArrayHeights(pois),
            width: 7.0,
            material: new Cesium.PolylineGlowMaterialProperty({
              color: Cesium.Color.fromCssColorString(color),
              glowPower: 0.25
            }),
            clampToGround: true
          }
        });
        //创建标注
        for (let i = 0; i < pois.length; i = i + 3) {
          viewer.entities.add({
            position: Cesium.Cartesian3.fromDegrees(pois[i], pois[i + 1], pois[i + 2]),
            point: {
              pixelSize: 8.0,
              color: Cesium.Color.fromCssColorString(color),
              outlineColor: Cesium.Color.WHITE,
              outlineWidth: 2.0,
              disableDepthTestDistance: 5000000,
            }
          });
        }
        viewer.camera.flyTo({
          destination: Cesium.Cartesian3.fromDegrees(Number(pois[0]), Number(pois[1]), Number(pois[2]) + 1000)
        });
      },
      getDutyLineData() {
        this.pictLoading = true;
        getPoliceLine().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.lId;
        this.currentRow = row;
        let pois = stringToNumber(row.lPoyline);
        this.addLineToMap(pois, row.lColor);
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
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
              lId: this.currentId
            };
            deletePoliceLine(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getDutyLineData();
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
      batchDeleteData() {
        if (this.multipleSelection !== []) {
          this.$confirm("删除后无法恢复，请确认是否删除？", "删除数据", {
            distinguishCancelAndClose: true,
            confirmButtonText: "确认",
            cancelButtonText: "取消",
          }).then(() => {
            batchDeletePoliceLine(this.multipleSelection).then((res) => {
              if (res.status === 200) {
                this.$message({
                  message: '删除成功，刷新列表！',
                  type: 'success'
                });
                this.backTable();
                this.getDutyLineData();
              } else {
                this.$message({
                  message: '删除失败，请重试！',
                  type: 'error'
                });
              }
            });
          }).catch((action) => {
            this.$message({
              message: '放弃删除！',
              type: 'warning'
            });
          });
        } else {
          this.$message({
            message: '至少选择一条需要删除的数据！',
            type: 'warning'
          });
        }
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.formData.lTime = new Date(this.formData.lTime).toLocaleDateString().replace(/\//g, '-');
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updatePoliceLine(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getDutyLineData();
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
                insertPoliceLine(this.formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getDutyLineData();
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
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.lName.indexOf(val)
            || ~item.lType.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getDutyLineData();
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

  .search-input {
    width: 180px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
