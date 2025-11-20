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
      </div>
      <div v-show="isTableShow" class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'dutyType', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="任务名称" prop="dutyName" sortable></el-table-column>
          <el-table-column label="任务类型" prop="dutyType" sortable></el-table-column>
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
          <el-form-item label="任务名称" prop="dutyName">
            <el-input v-model="formData.dutyName" placeholder="请填写任务名称" style="width: 90%"></el-input>
          </el-form-item>
          <el-form-item label="任务类型" prop="dutyType">
            <el-select v-model="formData.dutyType" placeholder="请选择任务类型">
              <el-option label="日常" value="日常"></el-option>
              <el-option label="节日安保" value="节日安保"></el-option>
              <el-option label="活动安保" value="活动安保"></el-option>
              <el-option label="其它" value="其它"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="巡逻间隔" prop="dutyTime">
            <el-input-number v-model="formData.dutyTime" :precision="0" :step="1" :min="1"></el-input-number>
          </el-form-item>
          <el-form-item label="相应相机" prop="dutyVideo">
            <font-awesome-icon class="form-fai" :icon="['fas', 'edit']" fixed-width
                               @click="selectVideoHandler"></font-awesome-icon>
            <div class="form-note">* 左键点选相机图标选取，右键结束</div>
            <div v-for="(item,index) in dutyVideoArr" :key="index" class="video-list">{{item.camAdd}}
              <font-awesome-icon class="form-fai-list" :icon="['fas', 'times']" fixed-width
                                 @click="removeVideoArrById(item.id)"></font-awesome-icon>
            </div>
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
  import {getDutyVideo, deleteDutyVideo, insertDutyVideo, updateDutyVideo, getVideoNoNodes} from "../api/api";

  let camera_marks = [];
  let pomhandler;
  let dutyVideoLines = [];
  export default {
    name: "duty-video",
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
          dutyName: [{required: true, message: '请输入', trigger: 'blur'}],
          dutyType: [{required: true, message: '请输入', trigger: 'blur'}],
          dutyTime: [{required: true, message: '请输入', trigger: 'blur'}],
        },
        formData: {
          dutyVideoId: '',
          dutyName: '',
          dutyType: '日常',
          dutyVideoVideo: [],
          dutyTime: '30'
        },
        dutyVideoArr: [],
        videoArr: [],
        selectDutyVideoPois: [],
      }
    },
    methods: {
      showVideo() {
        getVideoNoNodes().then(res => {
          let data = res.data;
          this.videoArr = res.data;
          for (let i = 0; i < data.length; i++) {
            let position = data[i].camPosition.split(',');
            let point = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
            let imgurl;
            if (data[i].camType === "3") {
              imgurl = 'static/images/pinimg/03.png';
            } else if (data[i].camType === "1") {
              imgurl = 'static/images/pinimg/04.png';
            } else if (data[i].camType === "2") {
              imgurl = 'static/images/pinimg/05.png';
            } else {
              imgurl = 'static/images/pinimg/05.png';
            }
            camera_marks.push(viewer.entities.add({
              name: '摄像头',
              id: 'ca' + data[i].id,
              position: point,
              billboard: {
                image: imgurl,
                scale: 0.15,
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
                scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
                disableDepthTestDistance: 200,
              },
            }));
          }
        });
      },
      selectVideoHandler() {
        let _this = this;
        this.removeDutyVideoArr();
        pomhandler = pomhandler && pomhandler.destroy();
        pomhandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
        let id;
        pomhandler.setInputAction(function (movement) {
          let pickedObject = viewer.scene.pick(movement.position);
          if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)) {
            //判断拾取的是pin还是ClassificationPrimitive
            //若是pin ,pickedObject.id为一个对象，需要读取pickedObject.id._id获取id
            //若是ClassificationPrimitive，pickedObject.id则是字符串，直接获取id
            if (typeof pickedObject.id == "string") {
              id = pickedObject.id;
            } else {
              id = pickedObject.id._id;
            }
            let type = id.substring(0, 2);
            let pomid = id.substring(2);
            switch (type) {
              case 'ca':
                _this.videoArr.some(item => {
                  if (item.id === pomid) {
                    _this.dutyVideoArr.push(item);
                    let posArr = item.camPosition.split(',');
                    let videoPos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
                    if (_this.selectDutyVideoPois.length !== 0) {
                      _this.addDutyLineToMap([_this.selectDutyVideoPois[_this.selectDutyVideoPois.length - 1], videoPos]);
                    }
                    _this.selectDutyVideoPois.push(videoPos);
                    return true;
                  }
                });
                break;
              default:
                break;
            }
          }
        }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
        pomhandler.setInputAction(function (movement) {
          pomhandler = pomhandler && pomhandler.destroy();
        }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
      },
      addDutyLineToMap(videoPosArr) {
        dutyVideoLines.push(viewer.entities.add({
          polyline: {
            positions: videoPosArr,
            width: 15.0,
            material: new Cesium.PolylineArrowMaterialProperty(Cesium.Color.RED),
            clampToGround: true
          }
        }));
      },
      removeVideoArrById(id) {
        this.dutyVideoArr.some((item, index) => {
          if (item.id === id) {
            this.dutyVideoArr.splice(index, 1);
            this.removeDutyVideoArr();
            if (this.dutyVideoArr.length > 1) {
              for (let i = 0; i < this.dutyVideoArr.length - 1; i++) {
                let posArr = this.dutyVideoArr[i].camPosition.split(',');
                let posArr1 = this.dutyVideoArr[i + 1].camPosition.split(',');
                let videoPos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
                let videoPos1 = new Cesium.Cartesian3.fromDegrees(posArr1[0], posArr1[1], posArr1[2]);
                this.addDutyLineToMap([videoPos, videoPos1]);
              }
            }
            return true;
          }
        });
      },
      removeDutyVideoArr() {
        dutyVideoLines.map(item => {
          viewer.entities.remove(item);
        });
        dutyVideoLines = [];
      },
      getDutyVideoData() {
        this.pictLoading = true;
        getDutyVideo().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
          this.removeDutyVideoArr();
        });
      },
      rowClick(row, column, event) {
        this.currentId = row.dutyVideoId;
        this.currentRow = row;
        if (row.dutyVideoVideo.length > 1) {
          this.removeDutyVideoArr();
          for (let i = 0; i < row.dutyVideoVideo.length - 1; i++) {
            let posArr = row.dutyVideoVideo[i].video.camPosition.split(',');
            let posArr1 = row.dutyVideoVideo[i + 1].video.camPosition.split(',');
            let videoPos = new Cesium.Cartesian3.fromDegrees(posArr[0], posArr[1], posArr[2]);
            let videoPos1 = new Cesium.Cartesian3.fromDegrees(posArr1[0], posArr1[1], posArr1[2]);
            this.addDutyLineToMap([videoPos, videoPos1]);
          }
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
      },
      editData() {
        if (this.currentId !== '') {
          this.isTableShow = false;
          this.isEdit = true;
          this.formData = Object.assign(this.formData, this.currentRow);
          this.currentRow.dutyVideoVideo.map(item => {
            this.dutyVideoArr.push(item.video);
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
              dutyVideoId: this.currentId
            };
            deleteDutyVideo(params).then(res => {
              if (res.data === 1) {
                this.$message({
                  type: 'success',
                  message: '删除成功，刷新列表！'
                });
                this.backTable();
                this.getDutyVideoData();
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
        if (this.dutyVideoArr.length !== 0) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              this.formData.dutyVideoVideo = this.dutyVideoArr;
              if (this.isEdit) {
                this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                  distinguishCancelAndClose: true,
                  confirmButtonText: '确认',
                  cancelButtonText: '取消'
                }).then(() => {
                  updateDutyVideo(this.formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '修改成功，返回列表！'
                      });
                      this.backTable();
                      this.getDutyVideoData();
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
                  insertDutyVideo(this.formData).then(res => {
                    if (res.data === 1) {
                      this.$message({
                        type: 'success',
                        message: '新增成功，返回列表！'
                      });
                      this.backTable();
                      this.getDutyVideoData();
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
        } else {
          this.$message({
            message: '请选取巡查相机！',
            type: 'error'
          });
        }
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.dutyVideoArr = [];
      },
      backTable() {
        this.isTableShow = true;
        this.dutyVideoArr = [];
      }
    },
    watch: {
      devFilter: function (val, oldVal) {
        this.tableDate = this.queryResult.filter(
          item => (~item.dutyName.indexOf(val)
            || ~item.dutyType.indexOf(val)
          ));
      }
    },
    mounted() {
      this.getDutyVideoData();
      this.showVideo();
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
  }

  .form-note {
    margin: 5px 0 0 10px
  }

  .video-list {
    width: 80%;
    border: solid #DCDFE6 1px;
    border-radius: 3px;
    margin: 5px 0;
    padding-left: 15px;
  }

  .form-fai-list {
    float: right;
    margin: 13px 7px 0 0;
    font-size: 15px;
    color: #9fa2a7;
    cursor: pointer
  }

  .search-input {
    width: 180px;
    float: right;
    margin: 0 0 0 10px;
  }
</style>
