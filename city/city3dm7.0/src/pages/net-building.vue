<template>
  <div>
    <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
      <div slot="header" class="card-header">
        <div v-show="isTableShow">
          <div>
            <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                      class="search-input"></el-input>
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
          <div>
            <el-upload
              class="header-button second-header-button"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-remove="beforeRemove"
              :on-exceed="handleExceed"
              :file-list="fileList">
              <el-button type="primary" icon="el-icon-folder-opened"> 文 件</el-button>
            </el-upload>
            <el-button class="header-button second-header-button" type="success" icon="el-icon-upload2"
                       @click="multiuploadData"> 导 入
            </el-button>
          </div>
        </div>
        <div v-show="!isTableShow">
          <el-button class="header-button" type="success" icon="el-icon-circle-check"
                     @click="submitForm('formData')">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right"
                     @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回
          </el-button>
        </div>
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="buildingId"
                  :default-sort="{prop: 'dbnum', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="建库号" prop="dbnum" sortable></el-table-column>
          <el-table-column label="土地性质" prop="tdxz" sortable></el-table-column>
          <el-table-column label="意向公司" prop="yxgs" sortable></el-table-column>
          <el-table-column label="占地面积" prop="jzzdmj" sortable></el-table-column>
          <el-table-column label="建筑面积" prop="sjjzmj" sortable></el-table-column>
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
          <el-form-item label="地块照片" prop="buildingImg">
            <div class="row_display avatar-img-row">
              <el-image class="avatar-img" :src="imagePreview" fit="fill"></el-image>
              <el-upload ref="uploadImage"
                         action=""
                         list-type="picture-card"
                         :auto-upload="false"
                         :accept="acceptFileType"
                         :file-list="fileListPic"
                         :limit="1"
                         :on-change="onChangeUpload"
                         :on-exceed="handleExceedPic"
                         class="avatar-img-upload">
                <i slot="default" class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemovePic(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                </div>
              </el-upload>
            </div>
          </el-form-item>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
          <el-form-item label="地块介绍" prop="note">
            <el-input v-model="formData.note" placeholder="请填写" style="width: 91%"></el-input>
          </el-form-item>
          <div class="row_display">
            <el-steps class="form-steps" direction="vertical" :active="stepActive-1" :space="62"
                      finish-status="success">
              <el-step title="批复文件"></el-step>
              <el-step title="征迁公告"></el-step>
              <el-step title="征迁补偿办法"></el-step>
            </el-steps>
            <div class="form-pdf">
              <div class="row_display">
                <el-form-item prop="buildingPdf1" style="width: 320px">
                  <el-upload
                    ref="uploadFilesPdf1"
                    action=""
                    :limit="1"
                    :file-list="fileListPdf1"
                    accept=".pdf"
                    :on-exceed="handleExceedPic"
                    :on-change="onChangeUploadPdf1"
                    :on-remove="handleRemovePdf1"
                    :auto-upload="false"
                    :show-file-list="true"
                    :disabled="stepActive!==1"
                  >
                    <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                               class="button-upload-pdf" :disabled="stepActive!==1">
                      选取pdf文件
                    </el-button>
                  </el-upload>
                </el-form-item>
                <el-form-item label="预览" prop="buildingPdf1">
                  <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                     @click="previewPdf1" title="预览pdf" style="right:-40px"></font-awesome-icon>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item prop="buildingPdf2" style="width: 320px">
                  <el-upload
                    ref="uploadFilesPdf2"
                    action=""
                    :limit="1"
                    :file-list="fileListPdf2"
                    accept=".pdf"
                    :on-exceed="handleExceedPic"
                    :on-change="onChangeUploadPdf2"
                    :on-remove="handleRemovePdf2"
                    :auto-upload="false"
                    :show-file-list="true"
                    :disabled="stepActive!==2"
                  >
                    <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                               class="button-upload-pdf" :disabled="stepActive!==2">
                      选取pdf文件
                    </el-button>
                  </el-upload>
                </el-form-item>
                <el-form-item label="预览" prop="buildingPdf2">
                  <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                     @click="previewPdf2" title="预览pdf" style="right:-40px"></font-awesome-icon>
                </el-form-item>
              </div>
              <div class="row_display">
                <el-form-item prop="buildingPdf3" style="width: 320px">
                  <el-upload
                    ref="uploadFilesPdf3"
                    action=""
                    :limit="1"
                    :file-list="fileListPdf3"
                    accept=".pdf"
                    :on-exceed="handleExceedPic"
                    :on-change="onChangeUploadPdf3"
                    :on-remove="handleRemovePdf3"
                    :auto-upload="false"
                    :show-file-list="true"
                    :disabled="stepActive!==3"
                  >
                    <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                               class="button-upload-pdf" :disabled="stepActive!==3">
                      选取pdf文件
                    </el-button>
                  </el-upload>
                </el-form-item>
                <el-form-item label="预览" prop="buildingPdf3">
                  <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                     @click="previewPdf3" title="预览pdf" style="right:-40px"></font-awesome-icon>
                </el-form-item>
              </div>
            </div>
          </div>
          <el-form-item label="建库号" prop="dbnum">
            <el-input v-model="formData.dbnum" placeholder="请填写" style="width: 91%"></el-input>
          </el-form-item>
          <div class="row_display">
            <el-form-item label="土地性质" prop="tdxz">
              <el-select v-model="formData.tdxz" placeholder="请选择" style="width: 93%">
                <el-option label="宅基地" value="宅基地"></el-option>
                <el-option label="集体建设用地" value="集体建设用地"></el-option>
                <el-option label="其他" value="其他"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="意向公司" prop="yxgs">
              <el-input v-model="formData.yxgs" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="占地面积" prop="jzzdmj">
              <el-input v-model="formData.jzzdmj" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="建筑面积" prop="sjjzmj" style="margin-left:15px;">
              <el-input v-model="formData.sjjzmj" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="房屋层数" prop="fwcs">
              <el-input v-model="formData.fwcs" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="房屋结构" prop="fwjg" style="margin-left:15px;">
              <el-select v-model="formData.fwjg" placeholder="请选择" style="width: 93%">
                <el-option label="砼" value="砼"></el-option>
                <el-option label="混" value="混"></el-option>
                <el-option label="砖" value="砖"></el-option>
                <el-option label="简" value="简"></el-option>
                <el-option label="棚" value="棚"></el-option>
                <el-option label="其他" value="其他"></el-option>
              </el-select>
            </el-form-item>
          </div>
          <div class="row_display">
            <el-form-item label="宗地号" prop="zdh">
              <el-input v-model="formData.zdh" placeholder="请填写"></el-input>
            </el-form-item>
            <el-form-item label="房产证号" prop="fczh" style="margin-left:15px;">
              <el-input v-model="formData.fczh" placeholder="请填写"></el-input>
            </el-form-item>
          </div>
          <el-form-item label="建筑轮廓" prop="coordinates">
            <el-input v-model="formData.coordinates" placeholder="请左键地图点选、右键结束或填写点位坐标值"
                      style="width: 91%" type="textarea" :rows="5"></el-input>
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="addNetToMapHandler"></font-awesome-icon>
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
import {stringToNumber} from "@/js/CesiumTools";
import CesiumMap from "../utils/components/cesium-map";
import {
  deleteBuilding,
  getBuildingAll,
  insertBuilding,
  updateBuilding,
  batchDeleteBuilding,
} from "../api/api";

let _this;
let tmpClassificationPrimitive;
export default {
  name: "net-building",
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
      fileList: [],
      rules: {
        coordinates: [{required: true, message: '请输入', trigger: 'blur'}],
        dbnum: [{required: true, message: '请输入', trigger: 'blur'}],
        tdxz: [{required: true, message: '请输入', trigger: 'blur'}],
        jzzdmj: [{required: true, message: '请输入', trigger: 'blur'}],
        sjjzmj: [{required: true, message: '请输入', trigger: 'blur'}],
        fwcs: [{required: true, message: '请输入', trigger: 'blur'}],
        fwjg: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        buildingId: '',
        coordinates: '',
        dbnum: '',
        tdxz: '',
        yxgs: '',
        jzzdmj: '',
        sjjzmj: '',
        fwcs: '',
        fwjg: '',
        zdh: '',
        fczh: '',
        note: '',
        buildingImg: '',
        buildingPdf1: '',
        buildingPdf2: '',
        buildingPdf3: ''
      },
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileListPic: [],
      fileListPdf1: [],
      fileListPdf2: [],
      fileListPdf3: [],
      imagePreview: '',
      stepActive: 1
    }
  },
  methods: {
    addNetToMapHandler() {
      _this = this;
      let activeShapePoints = [];
      let activeShapePointsgeo = [];
      let drawHandler = drawHandler && drawHandler.destroy();
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        let earthPosition = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        let height = cartographic.height; //模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          earthPosition = viewer.scene.globe.pick(ray, viewer.scene);
          cartographic = Cesium.Cartographic.fromCartesian(earthPosition);
        }
        if (Cesium.defined(earthPosition)) {
          activeShapePoints.push(earthPosition);
          activeShapePointsgeo.push(cartographic);
          if (activeShapePoints.length > 3) {
            drawPolygon();
          }
          createPoint(earthPosition);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
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
      drawHandler.setInputAction(function (movement) {
        drawHandler = drawHandler && drawHandler.destroy();
        let tempPointsStr = '';
        if (activeShapePointsgeo.length > 2) {
          for (let pindex = 0; pindex < activeShapePointsgeo.length; pindex++) {
            let longitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].longitude);
            let latitudeString = Cesium.Math.toDegrees(activeShapePointsgeo[pindex].latitude);
            let heightString = activeShapePointsgeo[pindex].height;
            tempPointsStr += longitudeString + "," + latitudeString + ","; //+ heightString + ",";
          }
          _this.formData.coordinates = tempPointsStr.substring(0, tempPointsStr.length - 1);
        }
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);

      function createPoint(worldPosition) {
        viewer.entities.add({
          position: worldPosition,
          point: {
            color: Cesium.Color.RED,
            pixelSize: 10,
            outlineWidth: 1,
            outlineColor: Cesium.Color.WHITE,
            disableDepthTestDistance: 10000
          }
        });
      }

      function drawPolygon() {
        if ((viewer.entities.getById('areaEntity') !== undefined)) {
          viewer.entities.removeById('areaEntity');
        }
        viewer.entities.add({
          id: 'areaEntity',
          polygon: {
            hierarchy: new Cesium.PolygonHierarchy(activeShapePoints),
            /*new Cesium.CallbackProperty(function () {
                  return activeShapePoints;
              }, false),*/
            material: new Cesium.ColorMaterialProperty(Cesium.Color.RED.withAlpha(0.3)),
            classificationType: Cesium.ClassificationType.BOTH,
            outline: true,
            outlineColor: Cesium.Color.WHITE
          }
        });
      }
    },
    addNetToMap(row) {
      let pois = stringToNumber(row.coordinates);
      let tmpGeometryInstance = new Cesium.GeometryInstance({
        geometry: new Cesium.PolygonGeometry({
          polygonHierarchy: new Cesium.PolygonHierarchy(Cesium.Cartesian3.fromDegreesArray(pois)),
          extrudedHeight: 5000,
        }),
        attributes: {
          color: Cesium.ColorGeometryInstanceAttribute.fromColor(Cesium.Color.YELLOW.withAlpha(0.7)),
        }
      });
      tmpClassificationPrimitive = new Cesium.ClassificationPrimitive({
        geometryInstances: tmpGeometryInstance
      });
      viewer.scene.primitives.add(tmpClassificationPrimitive);

      viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(Number(pois[0]), Number(pois[1]), 1000),
      });
    },
    clearBuilding() {
      viewer.entities.removeAll();
      viewer.scene.primitives.remove(tmpClassificationPrimitive);
      this.fileListPic = [];
      this.fileListPdf1 = [];
      this.fileListPdf2 = [];
      this.fileListPdf3 = [];
      this.$refs.uploadFilesPdf1.clearFiles();
      this.$refs.uploadFilesPdf2.clearFiles();
      this.$refs.uploadFilesPdf3.clearFiles();
      this.imagePreview = '';
    },
    getDutyNetData() {
      this.pictLoading = true;
      getBuildingAll().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.clearBuilding();
      this.currentId = row.buildingId;
      this.currentRow = row;
      this.addNetToMap(row);
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
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    addData(formName) {
      this.isTableShow = false;
      this.isEdit = false;
      this.$refs[formName].resetFields();
      this.clearBuilding();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        console.log(this.currentRow);
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.buildingImg;
        if (this.currentRow.buildingPdf3 !== "" && this.currentRow.buildingPdf3 !== null && this.currentRow.buildingPdf3 !== "null") {
          this.stepActive = 4;
        } else if (this.currentRow.buildingPdf2 !== "" && this.currentRow.buildingPdf2 !== null && this.currentRow.buildingPdf2 !== "null") {
          this.stepActive = 3;
        } else if (this.currentRow.buildingPdf1 !== "" && this.currentRow.buildingPdf1 !== null && this.currentRow.buildingPdf1 !== "null") {
          this.stepActive = 2;
        }
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
            buildingId: this.currentId,
            buildingImg: this.currentRow.buildingImg,
            buildingPdf1: this.currentRow.buildingPdf1,
            buildingPdf2: this.currentRow.buildingPdf2,
            buildingPdf3: this.currentRow.buildingPdf3,
          };
          deleteBuilding(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getDutyNetData();
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
          batchDeleteBuilding(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getDutyNetData();
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
    multiuploadData() {
      this.$message({
        message: '待完善，批量导入！',
        type: 'error'
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let formData = new FormData();
          this.fileListPic.map(item => {
            formData.append('buildingImgFiles', item.raw);
          });
          this.fileListPdf1.map(item => {
            formData.append('buildingPdf1Files', item.raw);
          });
          this.fileListPdf2.map(item => {
            formData.append('buildingPdf2Files', item.raw);
          });
          this.fileListPdf3.map(item => {
            formData.append('buildingPdf3Files', item.raw);
          });
          formData.append('buildingId', this.formData.buildingId);
          formData.append('coordinates', this.formData.coordinates);
          formData.append('dbnum', this.formData.dbnum);
          formData.append('tdxz', this.formData.tdxz);
          formData.append('yxgs', this.formData.yxgs);
          formData.append('jzzdmj', this.formData.jzzdmj);
          formData.append('sjjzmj', this.formData.sjjzmj);
          formData.append('fwcs', this.formData.fwcs);
          formData.append('fwjg', this.formData.fwjg);
          formData.append('zdh', this.formData.zdh);
          formData.append('fczh', this.formData.fczh);
          formData.append('note', this.formData.note);
          formData.append('buildingImg', this.formData.buildingImg);
          formData.append('buildingPdf1', this.formData.buildingPdf1);
          formData.append('buildingPdf2', this.formData.buildingPdf2);
          formData.append('buildingPdf3', this.formData.buildingPdf3);
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateBuilding(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getDutyNetData();
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
              insertBuilding(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getDutyNetData();
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
      this.clearBuilding();
    },
    backTable() {
      this.isTableShow = true;
      this.clearBuilding();
      this.stepActive = 1;
    },
    onChangeUpload(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'jpg' && fileName !== 'jpeg' && fileName !== 'png' && fileName !== 'gif' && fileName !== 'bmp'
        && fileName !== 'JPG' && fileName !== 'JPEG' && fileName !== 'PNG' && fileName !== 'GIF' && fileName !== 'BMP') {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是照片文件!'
        });
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        return false;
      }
      this.fileListPic = fileList;
      return false;
    },
    handleExceedPic(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleRemovePic(file) {
      this.$refs.uploadImage.handleRemove(file);
    },
    onChangeUploadPdf1(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是pdf文件!'
        });
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        return false;
      }
      this.fileListPdf1 = fileList;
      this.stepActive = 2;
      return false;
    },
    onChangeUploadPdf2(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是pdf文件!'
        });
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        return false;
      }
      this.fileListPdf2 = fileList;
      this.stepActive = 3;
      return false;
    },
    onChangeUploadPdf3(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是pdf文件!'
        });
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        that.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        return false;
      }
      this.fileListPdf3 = fileList;
      this.stepActive = 4;
      return false;
    },
    handleRemovePdf1(file) {
      this.$refs.uploadFilesPdf1.handleRemove(file);
    },
    handleRemovePdf2(file) {
      this.$refs.uploadFilesPdf2.handleRemove(file);
    },
    handleRemovePdf3(file) {
      this.$refs.uploadFilesPdf3.handleRemove(file);
    },
    previewPdf1() {
      if (this.formData.buildingPdf1 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.buildingPdf1;
      window.open(url, "", "_blank");
    },
    previewPdf2() {
      if (this.formData.buildingPdf2 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.buildingPdf2;
      window.open(url, "", "_blank");
    },
    previewPdf3() {
      if (this.formData.buildingPdf3 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.buildingPdf3;
      window.open(url, "", "_blank");
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.dbnum.indexOf(val)
          || ~item.tdxz.indexOf(val)
          || ~item.yxgs.indexOf(val)
          || ~item.jzzdmj.indexOf(val)
          || ~item.sjjzmj.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getDutyNetData();
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
      return (window.innerHeight - 130 - 130) + 'px';
    },
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  font-size: 15px !important;
}

.card-header {
  height: 80px;
}

.header-button {
  margin: 0 10px 0 0;
  float: left;
  font-size: 15px;
}

.second-header-button {
  margin-top: 10px;
}

.search-input {
  width: 180px;
  float: right;
  margin: 0 0 0 10px;
}

.my-pagination {
  margin-top: 15px;
}

.my-card-body {
  overflow-y: auto;
  overflow-x: hidden;
  font-size: 15px !important;
}

.row_display {
  display: flex;
}

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

.avatar-img-row {
  width: 91%;
  margin: 0 0 10px 0;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img {
  margin: 5px 5px 5px 5px;
  width: 170px;
  height: 150px;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img-upload {
  margin: 5px 5px 0 0;
}

.button-upload-pdf {
  font-size: 14px;
}

.form-steps {
  font-size: 15px;
  margin: 15px 0 0 40px;
  width: 190px;
}

.form-pdf {
  margin: 5px 0 0 -110px;
}
</style>
