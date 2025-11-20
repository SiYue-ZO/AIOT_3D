<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline" @click="addData('formData')">
          添 加
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
      </div>
      <div class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  :default-sort="{prop: 'carLicense', order: 'ascending'}" @row-click="rowClick">
          <el-table-column label="牌照" prop="carLicense" sortable></el-table-column>
          <el-table-column label="用途" prop="policeType" sortable></el-table-column>
          <el-table-column label="驾驶员" prop="driver" sortable></el-table-column>
          <el-table-column label="车辆型号" prop="carStyle" sortable></el-table-column>
          <el-table-column label="设备号码" prop="cardNum" sortable></el-table-column>
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
    </el-card>
    <div v-show="!isTableShow">
      <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
        <div slot="header" class="card-header">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">确
            定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">重
            置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="90px">
            <el-form-item label="外观照片" prop="image">
              <div class="row_display avatar-img-row">
                <el-image class="avatar-img" :src="imagePreview" fit="fill"></el-image>
                <el-upload ref="uploadImage"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList"
                           :limit="1"
                           :on-change="onChangeUpload"
                           :on-exceed="handleExceed"
                           class="avatar-img-upload">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </div>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="牌照" prop="carLicense">
                <el-input v-model="formData.carLicense" placeholder="请填写牌照"></el-input>
              </el-form-item>
              <el-form-item label="设备号码" prop="cardNum" style="margin-left:15px;">
                <el-input v-model="formData.cardNum" placeholder="请填写设备号码"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="用途" prop="policeType">
                <el-select v-model="formData.policeType" placeholder="请选择用途" style="width: 93%">
                  <el-option label="警卫车" value="警卫车"></el-option>
                  <el-option label="巡逻车" value="巡逻车"></el-option>
                  <el-option label="武装巡逻车" value="武装巡逻车"></el-option>
                  <el-option label="防爆装甲车" value="防爆装甲车"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="型号" prop="carStyle">
                <el-input v-model="formData.carStyle" placeholder="请填写车辆型号"></el-input>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="驾驶员" prop="driver">
                <el-input v-model="formData.driver" placeholder="请填写驾驶员姓名"></el-input>
              </el-form-item>
              <el-form-item label="购置时间" prop="carDate" style="margin-left:15px;">
                <el-date-picker v-model="formData.carDate" type="date" placeholder="请选择日期"
                                style="width: 87%"></el-date-picker>
              </el-form-item>
            </div>
          </el-form>
        </div>
      </el-card>
      <el-card id="right-card" class="right-card" :style="{width: rightWidth, height: viewerHeight}">
        <div class="my-card-body">
          <div slot="header" class="card-header right-card-title">装备库-现总分：{{ totalGrade.toFixed(1) }}</div>
          <div class="equip-content" :style="{height: cardBodyEquipHeight}">
            <el-card :id="item.equipmentId" class="equip-card" v-for="item in equipListAll" :key="item.equipmentId"
                     :body-style="{ padding: '0px' }">
              <img :src="item.equipmentPicture" class="equip-image"
                   @click="selectEquip(item.equipmentId,item.equipmentGrade)">
              <div style="padding: 14px;" @click="selectEquip(item.equipmentId,item.equipmentGrade)">
                <span>{{ item.equipmentName }}</span>
                <div class="equip-bottom equip-clearfix">
                  <span class="equip-time">{{ item.equipmentType }}</span>
                  <span class="equip-time-r">+ {{ item.equipmentGrade }}</span>
                </div>
              </div>
            </el-card>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import {
  deleteCar,
  getAllCars,
  insertCar,
  updateCar,
  getCarAndEquipmentsByPuid,
  selectEquipmentByType, getAllandCarById
} from "../api/api";

export default {
  name: "iot-car",
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
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileList: [],
      imagePreview: '',
      equipListAll: [],
      selectEquipList: [],
      totalGrade: 0,
      rules: {
        carLicense: [{required: true, message: '请输入', trigger: 'blur'}],
        policeType: [{required: true, message: '请输入', trigger: 'blur'}],
        cardNum: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        carId: '',
        carLicense: '',
        carStyle: '',
        carDate: '2020-01-01',
        driver: '',
        policeType: '',
        cardNum: '',
        image: ''
      }
    }
  },
  methods: {
    getPoliceCarData() {
      this.pictLoading = true;
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getAllCars().then(res => {
          this.queryResult = res.data;
          this.tableDate = res.data;
          this.pictLoading = false;
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandCarById(params).then(res => {
          let resultArr = [];
          res.data.sysRoleCar.map(item => {
            resultArr.push(item.car);
          });
          this.queryResult = resultArr;
          this.tableDate = resultArr;
          this.pictLoading = false;
        });
      }
    },
    rowClick(row, column, event) {
      this.currentId = row.carId;
      this.currentRow = row;
    },
    handleSizeChange: function (size) {
      this.pagesize = size;
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
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
      this.fileList = fileList;
      return false;
    },
    handleExceed(files, fileList) {
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
    handleRemove(file) {
      this.$refs.uploadImage.handleRemove(file);
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
        this.imagePreview = common.serverIp + 'city3dfile/' + this.formData.image;
        let params = {
          carId: this.currentRow.carId
        };
        getCarAndEquipmentsByPuid(params).then(res => {
          let carEquipments = res.data.CarEquipments;
          carEquipments.map(item => {
            item.equipment.equipmentPicture = common.serverIp + 'city3dfile/' + item.equipment.equipmentPicture;
            document.getElementById(item.equipment.equipmentId).style.backgroundColor = '#139cec85';
            this.selectEquipList.push(item.equipment.equipmentId);
            this.totalGrade += Number(item.equipment.equipmentGrade);
          });
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
            carId: this.currentId,
            image: this.currentRow.image
          };
          deleteCar(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getPoliceCarData();
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
          let params = this.formData;
          params.carDate = new Date(params.carDate).toLocaleDateString().replace(/\//g, '-');
          let formData = new FormData();
          this.fileList.map(item => {
            formData.append('files', item.raw);
          });
          formData.append('carId', params.carId);
          formData.append('carLicense', params.carLicense);
          formData.append('carStyle', params.carStyle);
          formData.append('carDate', params.carDate);
          formData.append('driver', params.driver);
          formData.append('policeType', params.policeType);
          formData.append('cardNum', params.cardNum);
          formData.append('image', params.image);
          formData.append('roleId', localStorage.getItem("roleId"));
          this.selectEquipList.map(item => {
            formData.append('equips', item);
          });
          if (this.isEdit) {
            this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
              distinguishCancelAndClose: true,
              confirmButtonText: '确认',
              cancelButtonText: '取消'
            }).then(() => {
              updateCar(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '修改成功，返回列表！'
                  });
                  this.backTable();
                  this.getPoliceCarData();
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
              insertCar(formData).then(res => {
                if (res.data === 1) {
                  this.$message({
                    type: 'success',
                    message: '新增成功，返回列表！'
                  });
                  this.backTable();
                  this.getPoliceCarData();
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
                message: '新增失败，请重试！'
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
    },
    backTable() {
      this.isTableShow = true;
      this.fileList = [];
      this.$refs.uploadImage.clearFiles();
      this.imagePreview = '';
      this.selectEquipList.map(item => {
        document.getElementById(item).style.backgroundColor = '#FFF';
      });
      this.selectEquipList = [];
      this.totalGrade = 0;
    },
    getEquipAll() {
      selectEquipmentByType().then(res => {
        let equipListAll = res.data;
        equipListAll.map(item => {
          item.equipmentPicture = common.serverIp + 'city3dfile/' + item.equipmentPicture;
        });
        this.equipListAll = equipListAll;
      });
    },
    selectEquip(id, grade) {
      let backgroundColor = document.getElementById(id).style.backgroundColor;
      if (backgroundColor !== null && backgroundColor !== '' && backgroundColor === 'rgba(19, 156, 236, 0.52)') {
        document.getElementById(id).style.backgroundColor = '#FFF';
        let index = this.selectEquipList.indexOf(id);
        this.selectEquipList.splice(index, 1);
        this.totalGrade -= Number(grade);
      } else {
        document.getElementById(id).style.backgroundColor = '#139cec85';
        this.selectEquipList.push(id);
        this.totalGrade += Number(grade);
      }
    }
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.carLicense.indexOf(val)
          || ~item.policeType.indexOf(val)
          || ~item.driver.indexOf(val)
          || ~item.carStyle.indexOf(val)
          || ~item.cardNum.indexOf(val)
        ));
    }
  },
  mounted() {
    this.getPoliceCarData();
    this.getEquipAll();
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 100) + 'px';
    },
    cardBodyEquipHeight: function () {
      return (window.innerHeight - 130 - 65) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.5) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 230) * 0.5) + 'px';
    }
  }
}
</script>

<style scoped>
.result-table {
  width: 100%;
  font-size: 15px !important;
}

.card-header {
  height: 30px;
}

.header-button {
  margin: -3px 10px 0 0;
  float: left;
  font-size: 15px;
}

.search-input {
  width: 400px;
  float: right;
  margin: -5px 0 0 20px;
}

.my-pagination {
  margin-top: 15px;
}

.my-card-body {
  overflow-y: auto;
  overflow-x: hidden;
  font-size: 15px !important;
  margin: 10px 0 0 5px;
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

.right-card-title {
  font-size: 16px;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.avatar-img-row {
  width: 81%;
  margin: 0 0 10px 0;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img {
  margin: 5px 10px 5px 10px;
  width: 240px;
  height: 196px;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.avatar-img-upload {
  margin: 30px 0 0 10px;
}

.equip-content {
  overflow-y: auto;
}

.equip-content::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.equip-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.equip-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.equip-card {
  width: 190px;
  margin: 5px;
  cursor: pointer;
  border-radius: 6px;
  float: left;
}

.equip-time {
  font-size: 13px;
  color: #999;
}

.equip-time-r {
  font-size: 13px;
  color: #ff8000;
  float: right;
}

.equip-bottom {
  margin-top: 13px;
  line-height: 12px;
}

.equip-image {
  width: 190px;
  height: 160px;
  display: block;
}

.equip-clearfix:before, .equip-clearfix:after {
  display: table;
  content: "";
}

.equip-clearfix:after {
  clear: both
}
</style>
