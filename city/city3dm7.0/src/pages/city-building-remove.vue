<template>
  <div>
    <el-card v-show="isTableShow">
      <div slot="header" class="card-header">
        <el-button class="header-button" type="success" icon="el-icon-circle-plus-outline" @click="addData('formData')">
          添 加
        </el-button>
        <el-button class="header-button" type="warning" icon="el-icon-edit" @click="editData">编 辑
        </el-button>
        <el-button class="header-button" type="danger" icon="el-icon-delete" @click="deleteData">删 除</el-button>
        <el-button class="header-button" type="info" icon="el-icon-circle-close" @click="batchDeleteData">批量删除
        </el-button>
        <el-upload
          ref="upload"
          action=""
          :limit="1"
          :file-list="fileList"
          accept=".xlsx, .xls"
          :on-exceed="handleExceed"
          :on-change="onChangeUpload"
          :on-remove="handleRemove"
          :auto-upload="false"
          :show-file-list="true"
          :disabled="isUploading"
          class="header-upload-1"
        >
          <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary" class="header-button-upload">
            选取导入文件
          </el-button>
          <div slot="tip" class="el-upload__tip">
            仅允许导入xls、xlsx格式文件
            <el-link type="primary" :underline="false" style="font-size: 12px; vertical-align: baseline; float: right"
                     :href="downloadUrl" download="city-building-remove.xlsx" target="_blank">
              下载模板
            </el-link>
          </div>
        </el-upload>
        <el-button class="header-button" type="success" icon="el-icon-upload2" @click="uploadData"
                   style="margin:0 0 50px 220px">
          导入
        </el-button>
        <el-button class="header-button" type="primary" icon="el-icon-download" @click="downloadData">
          导出
        </el-button>
        <el-input placeholder="请输入搜索内容" prefix-icon="el-icon-search" v-model="devFilter"
                  class="search-input"></el-input>
      </div>
      <div class="my-card-body" :style="{height: cardBodyHeight}">
        <el-table class="result-table" :data="tableDate.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  v-loading="pictLoading" element-loading-background="rgba(230, 230, 230, 0.5)"
                  element-loading-text="数据正在加载中" element-loading-spinner="el-icon-loading"
                  :stripe="true" :fit="true" :highlight-current-row="true" size="medium"
                  @selection-change="handleSelectionChange" ref="multipleTable" row-key="removeId"
                  :default-sort="{prop: 'removeHouseNum', order: 'ascending'}" @row-click="rowClick">
          <el-table-column type="selection" :reserve-selection="true" width="42"></el-table-column>
          <el-table-column label="权利人" prop="removeName" sortable width="110"></el-table-column>
          <el-table-column label="坐落" prop="removeSite" sortable></el-table-column>
          <el-table-column label="产权性质" prop="removeProType" sortable width="110"></el-table-column>
          <el-table-column label="用途" prop="removeUse" sortable width="110"></el-table-column>
          <el-table-column label="是否签约" prop="removeSign" sortable width="110"></el-table-column>
          <el-table-column label="房产证号" prop="removeHouseNum" sortable></el-table-column>
          <el-table-column label="房产证载面积" prop="removeHouseArea" sortable width="140"></el-table-column>
          <el-table-column label="土地证号" prop="removeLandNum" sortable></el-table-column>
          <el-table-column label="土地证载面积" prop="removeLandArea" sortable width="140"></el-table-column>
        </el-table>
        <el-pagination class="my-pagination" @size-change="handleSizeChange" @current-change="handleCurrentChange"
                       :current-page="currentPage" :page-sizes="[5, 10, 20, 40]" :page-size="pagesize" :pager-count="5"
                       layout="total, sizes, prev, pager, next, jumper" :total="tableDate.length">
        </el-pagination>
      </div>
    </el-card>
    <div v-show="!isTableShow">
      <el-card id="left-card" class="left-card" :style="{width: leftWidth, height: viewerHeight}">
        <div slot="header" class="card-header">
          <el-button class="header-button" type="success" icon="el-icon-circle-check" @click="submitForm('formData')">
            确 定
          </el-button>
          <el-button class="header-button" type="warning" icon="el-icon-refresh-right" @click="resetForm('formData')">
            重 置
          </el-button>
          <el-button class="header-button" type="danger" icon="el-icon-s-promotion" @click="backTable">返 回</el-button>
        </div>
        <div class="my-card-body" :style="{height: cardBodyHeight}">
          <el-form ref="formData" :model="formData" :rules="rules" label-width="110px">
            <div class="row_display">
              <el-form-item label="户主" prop="removeName">
                <el-input v-model="formData.removeName" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="电话" prop="removeTel" style="margin-left:20px">
                <el-input v-model="formData.removeTel" placeholder="请填写"></el-input>
              </el-form-item>
            </div>
            <el-form-item label="坐落" prop="removeSite">
              <el-input v-model="formData.removeSite" placeholder="请填写" style="width: 91%"></el-input>
            </el-form-item>
            <el-form-item label="四至" prop="removeCorner">
              <el-input v-model="formData.removeCorner" placeholder="请填写" style="width: 91%"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-form-item label="身份证" prop="removeCard">
                <el-input v-model="formData.removeCard" maxlength=18 placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="产权性质" prop="removeProType" style="margin-left:20px">
                <el-select v-model="formData.removeProType" placeholder="请选择" style="width: 93%">
                  <el-option label="集体土地" value="集体土地"></el-option>
                  <el-option label="国有土地" value="国有土地"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="使用情况" prop="removeState">
                <el-select v-model="formData.removeState" placeholder="请选择" style="width: 93%">
                  <el-option label="自住" value="自住"></el-option>
                  <el-option label="出租" value="出租"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="用途" prop="removeUse" style="margin-left:5px">
                <el-select v-model="formData.removeUse" placeholder="请选择" style="width: 93%">
                  <el-option label="住宅" value="住宅"></el-option>
                  <el-option label="商住" value="商住"></el-option>
                </el-select>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="是否签约" prop="removeSign">
                <el-select v-model="formData.removeSign" placeholder="请选择" style="width: 93%">
                  <el-option label="已签约" value="已签约"></el-option>
                  <el-option label="未签约" value="未签约"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="签约日期" prop="removeDate" style="margin-left:5px">
                <el-date-picker v-model="formData.removeDate" align="left" type="date" format="yyyy-MM-dd"
                                value-format="yyyy-MM-dd"
                                placeholder="选择日期" :picker-options="pickerOptions" style="width: 87%">
                </el-date-picker>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="房产证号" prop="removeHouseNum">
                <el-input v-model="formData.removeHouseNum" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="房产证载面积" prop="removeHouseArea" style="margin-left:20px">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeHouseArea"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="房产核定面积" prop="removeHouseAreaCheck">
                <el-input v-model="formData.removeHouseAreaCheck" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="确权建筑面积" prop="removeBuildingAreaCheck" style="margin-left:20px">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeBuildingAreaCheck"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="阁楼确权面积" prop="removeTop">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeTop"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
              <el-form-item label="无证建筑面积" prop="removeAreaNoCer" style="margin-left:42px">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeAreaNoCer"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="土地证号" prop="removeLandNum">
                <el-input v-model="formData.removeLandNum" placeholder="请填写"></el-input>
              </el-form-item>
              <el-form-item label="土地证载面积" prop="removeLandArea" style="margin-left:20px">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeLandArea"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="土地核定面积" prop="removeLandAreaCheck">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeLandAreaCheck"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
              <el-form-item label="确权土地面积" prop="removeLandAreaOk" style="margin-left:42px">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeLandAreaOk"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <div class="row_display">
              <el-form-item label="无证土地面积" prop="removeLandAreaNoCer">
                <el-input-number :precision="2" :step="0.1" v-model="formData.removeLandAreaNoCer"
                                 placeholder="请填写"></el-input-number>
              </el-form-item>
            </div>
            <el-form-item label="备注" prop="removeNote">
              <el-input v-model="formData.removeNote" placeholder="请填写" style="width: 91%" type="textarea"
                        :autosize="{minRows: 2, maxRows: 2}"></el-input>
            </el-form-item>
            <div class="row_display">
              <el-steps class="form-steps" direction="vertical" :active="stepActive-1" :space="62"
                        finish-status="success">
                <el-step title="权属材料"></el-step>
                <el-step title="身份户籍证明"></el-step>
                <el-step title="现场测量资料"></el-step>
                <el-step title="面积确权资材"></el-step>
                <el-step title="分户评估报告"></el-step>
                <el-step title="征迁补偿协议"></el-step>
                <el-step title="补偿款领款单"></el-step>
                <el-step title="补偿核算单"></el-step>
                <el-step title="补偿款领取单"></el-step>
                <el-step title="房屋腾空材料"></el-step>
              </el-steps>
              <div class="form-pdf">
                <div class="row_display">
                  <el-form-item prop="removePdf" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf"
                      :on-remove="handleRemovePdf"
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
                  <el-form-item label="预览" prop="removePdf">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf1" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf1"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf1"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf1"
                      :on-remove="handleRemovePdf1"
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
                  <el-form-item label="预览" prop="removePdf1">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf1" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf2" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf2"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf2"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf2"
                      :on-remove="handleRemovePdf2"
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
                  <el-form-item label="预览" prop="removePdf2">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf2" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf3" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf3"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf3"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf3"
                      :on-remove="handleRemovePdf3"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==4"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==4">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf3">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf3" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf4" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf4"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf4"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf4"
                      :on-remove="handleRemovePdf4"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==5"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==5">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf4">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf4" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf5" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf5"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf5"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf5"
                      :on-remove="handleRemovePdf5"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==6"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==6">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf5">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf5" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf6" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf6"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf6"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf6"
                      :on-remove="handleRemovePdf6"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==7"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==7">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf6">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf6" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf7" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf7"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf7"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf7"
                      :on-remove="handleRemovePdf7"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==8"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==8">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf7">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf7" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf8" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf8"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf8"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf8"
                      :on-remove="handleRemovePdf8"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==9"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==9">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf8">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf8" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
                <div class="row_display">
                  <el-form-item prop="removePdf9" style="width: 400px">
                    <el-upload
                      ref="uploadFilesPdf9"
                      action=""
                      :limit="1"
                      :file-list="fileListPdf9"
                      accept=".pdf"
                      :on-exceed="handleExceedPdf"
                      :on-change="onChangeUploadPdf9"
                      :on-remove="handleRemovePdf9"
                      :auto-upload="false"
                      :show-file-list="true"
                      :disabled="stepActive!==10"
                    >
                      <el-button slot="trigger" icon="el-icon-tickets" size="small" type="primary"
                                 class="button-upload-pdf" :disabled="stepActive!==10">
                        选取pdf文件
                      </el-button>
                    </el-upload>
                  </el-form-item>
                  <el-form-item label="预览" prop="removePdf9">
                    <font-awesome-icon class="form-fai icon_position" :icon="['far', 'file-powerpoint']" fixed-width
                                       @click="previewPdf9" title="预览pdf" style="right:-40px"></font-awesome-icon>
                  </el-form-item>
                </div>
              </div>
            </div>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
            <el-form-item label="东至照片" prop="removePicPos1">
              <el-input v-model="formData.removePicPos1" placeholder="请填写" style="width: 91%"></el-input>
              <font-awesome-icon class="form-fai icon_position" style="color:red" :icon="['fas', 'map-pin']"
                                 fixed-width @click="drawPicPos(1)" title="左键点击获取坐标，右键结束">
              </font-awesome-icon>
            </el-form-item>
            <el-form-item prop="removePic1">
              <div class="row_display avatar-img-row">
                <el-image class="avatar-img" :src="imagePreview1" fit="fill"></el-image>
                <el-upload ref="uploadImage1"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList1"
                           :limit="1"
                           :on-change="onChangeUpload1"
                           :on-exceed="handleExceed1"
                           class="avatar-img-upload">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove1(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="南至照片" prop="removePicPos2">
              <el-input v-model="formData.removePicPos2" placeholder="请填写" style="width: 91%"></el-input>
              <font-awesome-icon class="form-fai icon_position" style="color:green" :icon="['fas', 'map-pin']"
                                 fixed-width @click="drawPicPos(2)" title="左键点击获取坐标，右键结束">
              </font-awesome-icon>
            </el-form-item>
            <el-form-item prop="removePic2">
              <div class="row_display avatar-img-row">
                <el-image class="avatar-img" :src="imagePreview2" fit="fill"></el-image>
                <el-upload ref="uploadImage2"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList2"
                           :limit="1"
                           :on-change="onChangeUpload2"
                           :on-exceed="handleExceed2"
                           class="avatar-img-upload">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove2(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="西至照片" prop="removePicPos3">
              <el-input v-model="formData.removePicPos3" placeholder="请填写" style="width: 91%"></el-input>
              <font-awesome-icon class="form-fai icon_position" style="color:orange" :icon="['fas', 'map-pin']"
                                 fixed-width @click="drawPicPos(3)" title="左键点击获取坐标，右键结束">
              </font-awesome-icon>
            </el-form-item>
            <el-form-item prop="removePic3">
              <div class="row_display avatar-img-row">
                <el-image class="avatar-img" :src="imagePreview3" fit="fill"></el-image>
                <el-upload ref="uploadImage3"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList3"
                           :limit="1"
                           :on-change="onChangeUpload3"
                           :on-exceed="handleExceed3"
                           class="avatar-img-upload">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove3(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="北至照片" prop="removePicPos4">
              <el-input v-model="formData.removePicPos4" placeholder="请填写" style="width: 91%"></el-input>
              <font-awesome-icon class="form-fai icon_position" :icon="['fas', 'map-pin']" fixed-width
                                 @click="drawPicPos(4)" title="左键点击获取坐标，右键结束">
              </font-awesome-icon>
            </el-form-item>
            <el-form-item prop="removePic4">
              <div class="row_display avatar-img-row">
                <el-image class="avatar-img" :src="imagePreview4" fit="fill"></el-image>
                <el-upload ref="uploadImage4"
                           action=""
                           list-type="picture-card"
                           :auto-upload="false"
                           :accept="acceptFileType"
                           :file-list="fileList4"
                           :limit="1"
                           :on-change="onChangeUpload4"
                           :on-exceed="handleExceed4"
                           class="avatar-img-upload">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove4(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="全景VR照片" prop="removePanomara">
              <el-upload ref="uploadFilesPP"
                         action=""
                         list-type="picture-card"
                         :auto-upload="false"
                         :accept="acceptFileType"
                         :file-list="fileListPP"
                         :multiple="true"
                         :limit="8"
                         :on-change="onChangeUploadPP"
                         :on-exceed="handleExceedPP">
                <i slot="default" class="el-icon-plus"></i>
                <div slot="file" slot-scope="{file}">
                  <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                  <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemovePP(file)">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
                </div>
              </el-upload>
            </el-form-item>
            <el-form-item label="现有全景照片">
              <el-carousel class="right-card-bottom-carousel" :interval="4000" type="card">
                <el-carousel-item v-for="item in panoramas" :key="item.panoramaId">
                  <el-image class="carousel-item" :src="item.housePanorama"
                            :preview-src-list="[item.housePanorama]"></el-image>
                  <font-awesome-icon class="form-fai-carousel" :icon="['fas', 'times-circle']" fixed-width
                                     title="删除资料"
                                     @click="dodeletePanoramas(item.panoramaId,item.housePanorama)"></font-awesome-icon>
                </el-carousel-item>
              </el-carousel>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
      <div class="right-card">
        <el-card class="right-card-top" :style="{width: rightWidth, height: viewerHeightTopR}">
          <CesiumMap :style="{height: treeHeight}"></CesiumMap>
        </el-card>
        <el-card class="right-card-bottom" :style="{width: rightWidth, height: viewerHeightBottomR}">
          <div class="my-card-body" :style="{height: treeHeight}">
            <AddressTree></AddressTree>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import AddressTree from "../utils/components/address-tree";
import CesiumMap from "../utils/components/cesium-map";
import XLSX from "xlsx";
import {
  batchDeleteBuildingRemove,
  batchInsertBuildingRemove,
  deleteBuildingRemove,
  getBuildingRemove,
  insertBuildingRemove,
  updateBuildingRemove,
  queryAddress,
  getHousePanoramaByHosueId,
  deleteHousePanorama,
} from "../api/api";
import "../js/CesiumFloor.js";

let drawHandler;
let excelJsonResult = [];
let _this;

export default {
  name: "city-building-remove",
  components: {AddressTree, CesiumMap},
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
        removeName: [{required: true, message: '请输入', trigger: 'blur'}],
        removeSite: [{required: true, message: '请输入', trigger: 'blur'}],
      },
      formData: {
        removeId: '',
        removeName: '',
        removeSite: '',
        removeTel: '',
        removeCard: '',
        removeLandNum: '',
        removeProType: '',
        removeLandArea: '',
        removeHouseNum: '',
        removeHouseArea: '',
        removeState: '',
        removeUse: '',
        removeHouseAreaCheck: '',
        removeBuildingAreaCheck: '',
        removeAreaNoCer: '',
        removeLandAreaCheck: '',
        removeLandAreaOk: '',
        removeLandAreaNoCer: '',
        removeNote: '',
        removeDate: new Date(),
        removeCorner: '',
        removePic1: '',
        removePicPos1: '',
        removePic2: '',
        removePicPos2: '',
        removePic3: '',
        removePicPos3: '',
        removePic4: '',
        removePicPos4: '',
        removePdf: '',
        removePdf1: '',
        removePdf2: '',
        removePdf3: '',
        removePdf4: '',
        removePdf5: '',
        removePdf6: '',
        removePdf7: '',
        removePdf8: '',
        removePdf9: '',
        removeSign: '',
        addId: '',
        removeTop: '',
      },
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
      fileList: [],
      fileList1: [],
      fileList2: [],
      fileList3: [],
      fileList4: [],
      fileListPdf: [],
      fileListPdf1: [],
      fileListPdf2: [],
      fileListPdf3: [],
      fileListPdf4: [],
      fileListPdf5: [],
      fileListPdf6: [],
      fileListPdf7: [],
      fileListPdf8: [],
      fileListPdf9: [],
      fileListPP: [],
      imagePreview1: '',
      imagePreview2: '',
      imagePreview3: '',
      imagePreview4: '',
      panoramas: [],
      isUploading: false,
      downloadUrl: "",
      pickerOptions: {},
      stepActive: 1,
    }
  },
  methods: {
    getBuildingRemoveData() {
      this.pictLoading = true;
      getBuildingRemove().then(res => {
        this.queryResult = res.data;
        this.tableDate = res.data;
        this.pictLoading = false;
      });
    },
    rowClick(row, column, event) {
      this.clearData();
      this.currentId = row.removeId;
      this.currentRow = row;
      if (row.address === null || row.address === undefined) {
        this.$message.warning("该条记录没有匹配到地名地址数据！");
        return;
      }
      let camPoiArr = row.address.camPoi.split(',');
      CesiumMap.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), row.address.camHeading, row.address.camPitch);
      this.addAddressToMap(row.address);//分层
      //角点
      let pinBuilder = new Cesium.PinBuilder();
      let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
      if (row.removePicPos1 !== "" && row.removePicPos1 !== null && row.removePicPos1 !== "null") {
        let removePicPos1Arr = row.removePicPos1.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.RED, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner1",
            position: Cesium.Cartesian3.fromDegrees(removePicPos1Arr[0], removePicPos1Arr[1], removePicPos1Arr[2]),
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
      }
      if (row.removePicPos2 !== "" && row.removePicPos2 !== null && row.removePicPos2 !== "null") {
        let removePicPos2Arr = row.removePicPos2.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.GREEN, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner2",
            position: Cesium.Cartesian3.fromDegrees(removePicPos2Arr[0], removePicPos2Arr[1], removePicPos2Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.GREEN.withAlpha(0.7)
            }
          });
        });
      }
      if (row.removePicPos3 !== "" && row.removePicPos3 !== null && row.removePicPos3 !== "null") {
        let removePicPos3Arr = row.removePicPos3.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.ORANGE, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner3",
            position: Cesium.Cartesian3.fromDegrees(removePicPos3Arr[0], removePicPos3Arr[1], removePicPos3Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.ORANGE.withAlpha(0.7)
            }
          });
        });
      }
      if (row.removePicPos4 !== "" && row.removePicPos4 !== null && row.removePicPos4 !== "null") {
        let removePicPos4Arr = row.removePicPos4.split(',');
        Promise.resolve(
          pinBuilder.fromUrl(url, Cesium.Color.BLUE, 30)
        ).then(function (canvas) {
          viewer.entities.add({
            id: "corner4",
            position: Cesium.Cartesian3.fromDegrees(removePicPos4Arr[0], removePicPos4Arr[1], removePicPos4Arr[2]),
            billboard: {
              image: canvas.toDataURL(),
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
            },
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.BLUE.withAlpha(0.7)
            }
          });
        });
      }
    },
    //回显分层分户单体化结构和重心点
    addAddressToMap(data) {
      CesiumFloor.removeFloor(viewer);
      if (data.floorPoi !== null && data.floorPoi !== '') {
        let options = {
          'viewer': viewer,
          'floorPoi': data.floorPoi,
          'floorHeight': data.floorHeight,
        };
        CesiumFloor.showFloor(options);
      }
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
      window.addressId = '';
      this.clearData();
    },
    editData() {
      if (this.currentId !== '') {
        this.isTableShow = false;
        this.isEdit = true;
        this.formData = Object.assign(this.formData, this.currentRow);
        window.addressId = this.currentRow.addId;
        this.imagePreview1 = common.serverIp + 'city3dfile/' + this.formData.removePic1;
        this.imagePreview2 = common.serverIp + 'city3dfile/' + this.formData.removePic2;
        this.imagePreview3 = common.serverIp + 'city3dfile/' + this.formData.removePic3;
        this.imagePreview4 = common.serverIp + 'city3dfile/' + this.formData.removePic4;
        if (this.currentRow.removePdf9 !== "" && this.currentRow.removePdf9 !== null) {
          this.stepActive = 11;
        } else if (this.currentRow.removePdf8 !== "" && this.currentRow.removePdf8 !== null) {
          this.stepActive = 10;
        } else if (this.currentRow.removePdf7 !== "" && this.currentRow.removePdf7 !== null) {
          this.stepActive = 9;
        } else if (this.currentRow.removePdf6 !== "" && this.currentRow.removePdf6 !== null) {
          this.stepActive = 8;
        } else if (this.currentRow.removePdf5 !== "" && this.currentRow.removePdf5 !== null) {
          this.stepActive = 7;
        } else if (this.currentRow.removePdf4 !== "" && this.currentRow.removePdf4 !== null) {
          this.stepActive = 6;
        } else if (this.currentRow.removePdf3 !== "" && this.currentRow.removePdf3 !== null) {
          this.stepActive = 5;
        } else if (this.currentRow.removePdf2 !== "" && this.currentRow.removePdf2 !== null) {
          this.stepActive = 4;
        } else if (this.currentRow.removePdf1 !== "" && this.currentRow.removePdf1 !== null) {
          this.stepActive = 3;
        } else if (this.currentRow.removePdf !== "" && this.currentRow.removePdf !== null) {
          this.stepActive = 2;
        }
        let paramsPanorama = {
          "houseId": this.currentId
        };
        getHousePanoramaByHosueId(paramsPanorama).then(res => {
          for (let i = 0; i < res.data.length; i++) {
            res.data[i].housePanorama = common.serverIp + 'city3dfile/' + res.data[i].housePanorama;
            if (removeDate !== '') {
              res.data[i].removeDate = new Date(removeDate)
            } else {
              res.data[i].removeDate = new Date()
            }
          }
          this.panoramas = res.data;
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
            removeId: this.currentId,
            removePic1: this.currentRow.removePic1,
            removePic2: this.currentRow.removePic2,
            removePic3: this.currentRow.removePic3,
            removePic4: this.currentRow.removePic4,
            removePdf: this.currentRow.removePdf,
            removePdf1: this.currentRow.removePdf1,
            removePdf2: this.currentRow.removePdf2,
            removePdf3: this.currentRow.removePdf3,
            removePdf4: this.currentRow.removePdf4,
            removePdf5: this.currentRow.removePdf5,
            removePdf6: this.currentRow.removePdf6,
            removePdf7: this.currentRow.removePdf7,
            removePdf8: this.currentRow.removePdf8,
            removePdf9: this.currentRow.removePdf9,
          };
          deleteBuildingRemove(params).then(res => {
            if (res.data === 1) {
              this.$message({
                type: 'success',
                message: '删除成功，刷新列表！'
              });
              this.backTable();
              this.getBuildingRemoveData();
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
          batchDeleteBuildingRemove(this.multipleSelection).then((res) => {
            if (res.status === 200) {
              this.$message({
                message: '删除成功，刷新列表！',
                type: 'success'
              });
              this.backTable();
              this.getBuildingRemoveData();
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
    clearData() {
      viewer.entities.removeAll();
      CesiumFloor.removeFloor(viewer);
      this.fileList = [];
      this.fileList1 = [];
      this.fileList2 = [];
      this.fileList3 = [];
      this.fileList4 = [];
      this.fileListPdf = [];
      this.fileListPdf1 = [];
      this.fileListPdf2 = [];
      this.fileListPdf3 = [];
      this.fileListPdf4 = [];
      this.fileListPdf5 = [];
      this.fileListPdf6 = [];
      this.fileListPdf7 = [];
      this.fileListPdf8 = [];
      this.fileListPdf9 = [];
      this.fileListPP = [];
      this.$refs.upload.clearFiles();
      this.$refs.uploadImage1.clearFiles();
      this.$refs.uploadImage2.clearFiles();
      this.$refs.uploadImage3.clearFiles();
      this.$refs.uploadImage4.clearFiles();
      this.$refs.uploadFilesPP.clearFiles();
      this.$refs.uploadFilesPdf.clearFiles();
      this.$refs.uploadFilesPdf1.clearFiles();
      this.$refs.uploadFilesPdf2.clearFiles();
      this.$refs.uploadFilesPdf3.clearFiles();
      this.$refs.uploadFilesPdf4.clearFiles();
      this.$refs.uploadFilesPdf5.clearFiles();
      this.$refs.uploadFilesPdf6.clearFiles();
      this.$refs.uploadFilesPdf7.clearFiles();
      this.$refs.uploadFilesPdf8.clearFiles();
      this.$refs.uploadFilesPdf9.clearFiles();
      this.imagePreview1 = '';
      this.imagePreview2 = '';
      this.imagePreview3 = '';
      this.imagePreview4 = '';
      this.panoramas = [];
    },
    //提交
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (window.addressId !== undefined && window.addressId !== null && window.addressId !== '') {
            let formData = new FormData();
            this.fileList1.map(item => {
              formData.append('removePicFile1', item.raw);
            });
            this.fileList2.map(item => {
              formData.append('removePicFile2', item.raw);
            });
            this.fileList3.map(item => {
              formData.append('removePicFile3', item.raw);
            });
            this.fileList4.map(item => {
              formData.append('removePicFile4', item.raw);
            });
            this.fileListPdf.map(item => {
              formData.append('removePdfFile', item.raw);
            });
            this.fileListPdf1.map(item => {
              formData.append('removePdfFile1', item.raw);
            });
            this.fileListPdf2.map(item => {
              formData.append('removePdfFile2', item.raw);
            });
            this.fileListPdf3.map(item => {
              formData.append('removePdfFile3', item.raw);
            });
            this.fileListPdf4.map(item => {
              formData.append('removePdfFile4', item.raw);
            });
            this.fileListPdf5.map(item => {
              formData.append('removePdfFile5', item.raw);
            });
            this.fileListPdf6.map(item => {
              formData.append('removePdfFile6', item.raw);
            });
            this.fileListPdf7.map(item => {
              formData.append('removePdfFile7', item.raw);
            });
            this.fileListPdf8.map(item => {
              formData.append('removePdfFile8', item.raw);
            });
            this.fileListPdf9.map(item => {
              formData.append('removePdfFile9', item.raw);
            });
            this.fileListPP.map(item => {
              formData.append('removePPFile', item.raw);
            });
            formData.append('removeId', this.isnull(this.formData.removeId));
            formData.append('removeName', this.isnull(this.formData.removeName));
            formData.append('removeSite', this.isnull(this.formData.removeSite));
            formData.append('removeTel', this.isnull(this.formData.removeTel));
            formData.append('removeCard', this.isnull(this.formData.removeCard));
            formData.append('removeLandNum', this.isnull(this.formData.removeLandNum));
            formData.append('removeProType', this.isnull(this.formData.removeProType));
            formData.append('removeLandArea', this.isnull(this.formData.removeLandArea));
            formData.append('removeHouseNum', this.isnull(this.formData.removeHouseNum));
            formData.append('removeHouseArea', this.isnull(this.formData.removeHouseArea));
            formData.append('removeState', this.isnull(this.formData.removeState));
            formData.append('removeUse', this.isnull(this.formData.removeUse));
            formData.append('removeHouseAreaCheck', this.isnull(this.formData.removeHouseAreaCheck));
            formData.append('removeBuildingAreaCheck', this.isnull(this.formData.removeBuildingAreaCheck));
            formData.append('removeAreaNoCer', this.isnull(this.formData.removeAreaNoCer));
            formData.append('removeLandAreaCheck', this.isnull(this.formData.removeLandAreaCheck));
            formData.append('removeLandAreaOk', this.isnull(this.formData.removeLandAreaOk));
            formData.append('removeLandAreaNoCer', this.isnull(this.formData.removeLandAreaNoCer));
            formData.append('removeNote', this.isnull(this.formData.removeNote));
            this.formData.removeDate = new Date(this.formData.removeDate).toLocaleDateString().replace(/\//g, '-');
            formData.append('removeDate', this.formData.removeDate);
            formData.append('removeCorner', this.isnull(this.formData.removeCorner));
            formData.append('removePic1', this.isnull(this.formData.removePic1));
            formData.append('removePicPos1', this.isnull(this.formData.removePicPos1));
            formData.append('removePic2', this.isnull(this.formData.removePic2));
            formData.append('removePicPos2', this.isnull(this.formData.removePicPos2));
            formData.append('removePic3', this.isnull(this.formData.removePic3));
            formData.append('removePicPos3', this.isnull(this.formData.removePicPos3));
            formData.append('removePic4', this.isnull(this.formData.removePic4));
            formData.append('removePicPos4', this.isnull(this.formData.removePicPos4));
            formData.append('removePdf', this.isnull(this.formData.removePdf));
            formData.append('removePdf1', this.isnull(this.formData.removePdf1));
            formData.append('removePdf2', this.isnull(this.formData.removePdf2));
            formData.append('removePdf3', this.isnull(this.formData.removePdf3));
            formData.append('removePdf4', this.isnull(this.formData.removePdf4));
            formData.append('removePdf5', this.isnull(this.formData.removePdf5));
            formData.append('removePdf6', this.isnull(this.formData.removePdf6));
            formData.append('removePdf7', this.isnull(this.formData.removePdf7));
            formData.append('removePdf8', this.isnull(this.formData.removePdf8));
            formData.append('removePdf9', this.isnull(this.formData.removePdf9));
            formData.append('removeSign', this.isnull(this.formData.removeSign));
            this.formData.addId = window.addressId;
            formData.append('addId', this.isnull(this.formData.addId));
            formData.append('removeTop', this.isnull(this.formData.removeTop));
            if (this.isEdit) {
              this.$confirm('请确认信息填写无误，是否保存？', '确认信息', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确认',
                cancelButtonText: '取消'
              }).then(() => {
                updateBuildingRemove(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '修改成功，返回列表！'
                    });
                    this.backTable();
                    this.getBuildingRemoveData();
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
                insertBuildingRemove(formData).then(res => {
                  if (res.data === 1) {
                    this.$message({
                      type: 'success',
                      message: '新增成功，返回列表！'
                    });
                    this.backTable();
                    this.getBuildingRemoveData();
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
              type: 'error',
              message: '请选择目录树中的地名地址！'
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
    isnull(str) {
      if (str === null || str === 'null') {
        return '';
      }
      return str
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.clearData();
    },
    backTable() {
      this.isTableShow = true;
      this.clearData();
      window.addressId = null;
      this.stepActive = 1;
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    //选取导入文件并解析excel
    onChangeUpload(file, fileList) {
      this.isUploading = true;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'xlsx' && fileName !== 'xls' && fileName !== 'XLSX' && fileName !== 'XLS') {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件类型不是Excel文件!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      //读取文件大小
      let fileSize = file.size;
      if (fileSize > 1048576 * 20) {
        this.$message({
          type: 'error',
          showClose: true,
          duration: 3000,
          message: '文件不能大于20M!'
        });
        this.isUploading = false;
        this.$refs.upload.clearFiles();
        return false;
      }
      //解析excel
      let reader = new FileReader();
      reader.onload = (e) => {
        let data = e.target.result;
        let workbook = XLSX.read(data, {
          type: 'binary',
          cellDates: true,
        });
        let excelJson = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]], {
          defval: null,
          raw: false
        });
        excelJsonResult = dealExcel(excelJson);
        this.isUploading = false;
      };
      reader.readAsBinaryString(file.raw);
      this.fileList = fileList;

      function dealExcel(ws) {
        let keymap = {
          "户主": "removeName",
          "坐落": "removeSite",
          "电话": "removeTel",
          "身份证": "removeCard",
          "土地证号": "removeLandNum",
          "产权性质": "removeProType",
          "土地证载面积": "removeLandArea",
          "房产证号": "removeHouseNum",
          "房产证载面积": "removeHouseArea",
          "使用情况": "removeState",
          "用途": "removeUse",
          "房产核定面积": "removeHouseAreaCheck",
          "确权建筑面积": "removeBuildingAreaCheck",
          "无证建筑面积": "removeAreaNoCer",
          "土地核定面积": "removeLandAreaCheck",
          "确权土地面积": "removeLandAreaOk",
          "无证土地面积": "removeLandAreaNoCer",
          "备注": "removeNote",
          "创建时间": "removeDate",
          "四至": "removeCorner",
          "照片1": "removePic1",
          "照片坐标1": "removePicPos1",
          "照片2": "removePic2",
          "照片坐标2": "removePicPos2",
          "照片3": "removePic3",
          "照片坐标3": "removePicPos3",
          "照片4": "removePic4",
          "照片坐标4": "removePicPos4",
          "pdf链接": "removePdf",
          "是否签约": "removeSign",
          "阁楼确权面积": "removeTop",
        };
        ws.forEach((sourceObj) => {
          Object.keys(sourceObj).map((keys) => {
            if (keymap[keys]) {
              sourceObj[keymap[keys]] = sourceObj[keys];
              delete sourceObj[keys]
            }
          });
        });
        return ws
      }
    },
    //卸载选取的批量导入文件
    handleRemove(files, fileList) {
      excelJsonResult = [];
      this.fileList = [];
    },
    //批量上传
    uploadData() {
      if (excelJsonResult.length === 0 || this.fileList.length === 0) {
        this.$message({
          type: 'error',
          message: '请选择批量导入表！'
        });
        return;
      }
      let confirmStr = "您上传的地块总数为" + excelJsonResult.length + "，是否确认上传？";
      this.$confirm(confirmStr, '批量上传', {
        distinguishCancelAndClose: true,
        confirmButtonText: '确认',
        cancelButtonText: '取消'
      }).then(() => {
        batchInsertBuildingRemove(excelJsonResult).then(res => {
          if (res.data > 0) {
            this.$message({
              type: 'success',
              message: '批量导入成功，返回列表！'
            });
            this.backTable();
            this.getBuildingRemoveData();
            excelJsonResult = [];
            this.fileList = [];
            this.$refs.upload.clearFiles();
          } else {
            this.$message({
              type: 'error',
              message: '批量导入失败，请重试！'
            });
          }
        });
      }).catch(action => {
        this.$message({
          type: 'warning',
          message: '放弃上传！'
        });
      });
    },
    //批量下载数据
    downloadData() {
      let aoa = [
        ['户主', '身份证', '坐落',
          '用途', '产权性质',
          '房产证号', '房产证载面积',
          '房产核定面积', '确权建筑面积',
          '阁楼确权面积', '无证建筑面积',
          '使用情况', '土地证号',
          '土地证载面积', '土地核定面积',
          '确权土地面积', '无证土地面积',
          '备注', '是否签约',
          '电话', '四至',
          '创建时间'
        ]
      ];
      let ms = this.multipleSelection;
      for (let i = 0; i < ms.length; i++) {
        aoa.push([ms[i].removeName, ms[i].removeCard, ms[i].removeSite,
          ms[i].removeUse, ms[i].removeProType,
          ms[i].removeHouseNum, ms[i].removeHouseArea,
          ms[i].removeHouseAreaCheck, ms[i].removeBuildingAreaCheck,
          ms[i].removeTop, ms[i].removeAreaNoCer,
          ms[i].removeState, ms[i].removeLandNum,
          ms[i].removeLandArea, ms[i].removeLandAreaCheck,
          ms[i].removeLandAreaOk, ms[i].removeLandAreaNoCer,
          ms[i].removeNote, ms[i].removeSign,
          ms[i].removeTel, ms[i].removeCorner,
          ms[i].removeDate
        ]);
      }
      let workbook = XLSX.utils.aoa_to_sheet(aoa);
      this.openDownloadDialog(sheet2blob(workbook), '征地拆迁导出结果.xlsx');

      //将一个sheet转成最终的excel文件的blob对象，然后利用URL.createObjectURL下载
      function sheet2blob(sheet, sheetName) {
        sheetName = sheetName || 'sheet1';
        let workbook = {
          SheetNames: [sheetName],
          Sheets: {}
        };
        workbook.Sheets[sheetName] = sheet;
        // 生成excel的配置项
        let wopts = {
          bookType: 'xlsx', // 要生成的文件类型
          bookSST: false, // 是否生成Shared String Table，官方解释是，如果开启生成速度会下降，但在低版本IOS设备上有更好的兼容性
          type: 'binary'
        };
        let wbout = XLSX.write(workbook, wopts);
        let outBlob = new Blob([s2ab(wbout)], {type: "application/octet-stream"});

        // 字符串转ArrayBuffer
        function s2ab(s) {
          let buf = new ArrayBuffer(s.length);
          let view = new Uint8Array(buf);
          for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
          return buf;
        }

        return outBlob;
      }
    },
    //开始下载
    openDownloadDialog(url, saveName) {
      if (typeof url == 'object' && url instanceof Blob) {
        url = URL.createObjectURL(url); // 创建blob地址
      }
      let aLink = document.createElement('a');
      aLink.href = url;
      aLink.download = saveName || ''; // HTML5新增的属性，指定保存文件名，可以不要后缀，注意，file:///模式下不会生效
      let event;
      if (window.MouseEvent) event = new MouseEvent('click');
      else {
        event = document.createEvent('MouseEvents');
        event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
      }
      aLink.dispatchEvent(event);
    },
    //绘制四角照片的坐标
    drawPicPos(type) {
      let curId = "corner";
      let pinBuilder = new Cesium.PinBuilder();
      let url = Cesium.buildModuleUrl("Assets/Textures/maki/marker-stroked.png");
      let color;
      let target;
      switch (type) {
        case 1:
          curId += type;
          color = Cesium.Color.RED;
          target = this.formData.removePicPos1;
          break;
        case 2:
          curId += type;
          color = Cesium.Color.GREEN;
          target = this.formData.removePicPos2;
          break;
        case 3:
          curId += type;
          color = Cesium.Color.ORANGE;
          target = this.formData.removePicPos3;
          break;
        case 4:
          curId += type;
          color = Cesium.Color.BLUE;
          target = this.formData.removePicPos4;
          break;
      }
      viewer.entities.removeById(curId);
      let lng, lat, height;
      drawHandler = drawHandler && drawHandler.destroy();
      drawHandler = new Cesium.ScreenSpaceEventHandler(viewer.scene.canvas);
      drawHandler.setInputAction(function (movement) {
        //获取鼠标点击处的坐标
        let cartesian = viewer.scene.pickPosition(movement.position);
        let cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//模型高度
        if (Number(height) < 0) {
          let ray = viewer.camera.getPickRay(movement.position);
          cartesian = viewer.scene.globe.pick(ray, viewer.scene);
        }
        cartographic = Cesium.Cartographic.fromCartesian(cartesian);
        height = cartographic.height;//地形高度
        lng = Cesium.Math.toDegrees(cartographic.longitude);
        lat = Cesium.Math.toDegrees(cartographic.latitude);

        let drawPointEntity = viewer.entities.getById(curId);
        if (drawPointEntity === undefined) {
          Promise.resolve(
            pinBuilder.fromUrl(url, color, 30)
          ).then(function (canvas) {
            return viewer.entities.add({
              id: curId,
              position: Cesium.Cartesian3.fromDegrees(lng, lat, height),
              billboard: {
                image: canvas.toDataURL(),
                verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              },
              ellipsoid: {
                radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
                material: color.withAlpha(0.7)
              }
            });
          });
        } else {
          drawPointEntity.position = cartesian.clone();
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      drawHandler.setInputAction(function (movement) {
        let pos = lng + "," + lat + "," + height;
        switch (type) {
          case 1:
            _this.formData.removePicPos1 = pos;
            break;
          case 2:
            _this.formData.removePicPos2 = pos;
            break;
          case 3:
            _this.formData.removePicPos3 = pos;
            break;
          case 4:
            _this.formData.removePicPos4 = pos;
            break;
        }
        drawHandler = drawHandler && drawHandler.destroy();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    //预览该地址是否能够匹配到分层分户坐标
    createFloorPreview() {
      let params = {
        addName: this.formData.removeSite
      };
      queryAddress(params).then(res => {
        if (res.data === null || res.data.length === 0) {
          this.$message.error("没有匹配到地名地址及其坐标");
          return;
        }
        let camPoiArr = res.data[0].camPoi.split(',');
        CesiumMap.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), res.data[0].camHeading, res.data[0].camPitch);
        this.addAddressToMap(res.data[0]);//分层
      });
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    onChangeUpload1(file, fileList) {
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
      this.fileList1 = fileList;
      return false;
    },
    handleExceed1(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemove1(file) {
      this.$refs.uploadImage1.handleRemove(file);
    },
    onChangeUpload2(file, fileList) {
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
      this.fileList2 = fileList;
      return false;
    },
    handleExceed2(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemove2(file) {
      this.$refs.uploadImage2.handleRemove(file);
    },
    onChangeUpload3(file, fileList) {
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
      this.fileList3 = fileList;
      return false;
    },
    handleExceed3(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemove3(file) {
      this.$refs.uploadImage3.handleRemove(file);
    },
    onChangeUpload4(file, fileList) {
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
      this.fileList4 = fileList;
      return false;
    },
    handleExceed4(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemove4(file) {
      this.$refs.uploadImage4.handleRemove(file);
    },
    onChangeUploadPdf(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf = fileList;
      this.stepActive = 2;
      return false;
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
      this.fileListPdf1 = fileList;
      this.stepActive = 3;
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
      this.fileListPdf2 = fileList;
      this.stepActive = 4;
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
      this.fileListPdf3 = fileList;
      this.stepActive = 5;
      return false;
    },
    onChangeUploadPdf4(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf4 = fileList;
      this.stepActive = 6;
      return false;
    },
    onChangeUploadPdf5(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf5 = fileList;
      this.stepActive = 7;
      return false;
    },
    onChangeUploadPdf6(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf6 = fileList;
      this.stepActive = 8;
      return false;
    },
    onChangeUploadPdf7(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf7 = fileList;
      this.stepActive = 9;
      return false;
    },
    onChangeUploadPdf8(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf8 = fileList;
      this.stepActive = 10;
      return false;
    },
    onChangeUploadPdf9(file, fileList) {
      let that = this;
      //文件类型
      let fileName = file.name.substring(file.name.lastIndexOf('.') + 1);
      if (fileName !== 'pdf' && fileName !== 'PDF') {
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
      this.fileListPdf9 = fileList;
      this.stepActive = 11;
      return false;
    },
    handleExceedPdf(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemovePdf(file) {
      this.$refs.uploadFilesPdf.handleRemove(file);
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
    handleRemovePdf4(file) {
      this.$refs.uploadFilesPdf4.handleRemove(file);
    },
    handleRemovePdf5(file) {
      this.$refs.uploadFilesPdf5.handleRemove(file);
    },
    handleRemovePdf6(file) {
      this.$refs.uploadFilesPdf6.handleRemove(file);
    },
    handleRemovePdf7(file) {
      this.$refs.uploadFilesPdf7.handleRemove(file);
    },
    handleRemovePdf8(file) {
      this.$refs.uploadFilesPdf8.handleRemove(file);
    },
    handleRemovePdf9(file) {
      this.$refs.uploadFilesPdf9.handleRemove(file);
    },
    //预览pdf
    previewPdf() {
      if (this.formData.removePdf === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf;
      window.open(url, "", "_blank");
    },
    previewPdf1() {
      if (this.formData.removePdf1 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf1;
      window.open(url, "", "_blank");
    },
    previewPdf2() {
      if (this.formData.removePdf2 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf2;
      window.open(url, "", "_blank");
    },
    previewPdf3() {
      if (this.formData.removePdf3 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf3;
      window.open(url, "", "_blank");
    },
    previewPdf4() {
      if (this.formData.removePdf4 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf4;
      window.open(url, "", "_blank");
    },
    previewPdf5() {
      if (this.formData.removePdf5 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf5;
      window.open(url, "", "_blank");
    },
    previewPdf6() {
      if (this.formData.removePdf6 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf6;
      window.open(url, "", "_blank");
    },
    previewPdf7() {
      if (this.formData.removePdf7 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf7;
      window.open(url, "", "_blank");
    },
    previewPdf8() {
      if (this.formData.removePdf8 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf8;
      window.open(url, "", "_blank");
    },
    previewPdf9() {
      if (this.formData.removePdf9 === "") {
        this.$message.error("请先选取pdf文件！");
        return;
      }
      let url = common.serverIp + "city3dfile/" + this.formData.removePdf9;
      window.open(url, "", "_blank");
    },
    onChangeUploadPP(file, fileList) {
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
      this.fileListPP = fileList;
      return false;
    },
    handleExceedPP(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 个文件，本次选择了 ${
          files.length
        } 个文件，共选择了 ${files.length + fileList.length} 个文件`
      );
    },
    handleRemovePP(file) {
      this.$refs.uploadFilesPP.handleRemove(file);
    },
    dodeletePanoramas(id, url) {
      let params = {
        'panoramaId': id,
        'housePanorama': url,
      };
      deleteHousePanorama(params).then(res => {
        if (res.data === 1) {
          this.$message({
            type: 'success',
            message: '删除成功！'
          });
          for (let i = 0; i < this.panoramas.length; i++) {
            if (this.panoramas[i].panoramaId === id) {
              this.panoramas.splice(i, 1);
              break;
            }
          }
        } else {
          this.$message({
            type: 'error',
            message: '删除失败，请重试！'
          });
        }
      });
    },
  },
  watch: {
    devFilter: function (val, oldVal) {
      this.tableDate = this.queryResult.filter(
        item => (~item.removeName.indexOf(val)
          || ~item.removeSign.indexOf(val)
          || ~item.removeSite.indexOf(val)
        ));
      // || ~item.removeProType.indexOf(val)
      // || ~item.removeSite.indexOf(val)
      //   || ~item.removeUse.indexOf(val)
      //   || ~item.removeSign.indexOf(val)
      // || ~item.removeHouseNum.indexOf(val)
      //   || ~item.removeHouseArea.indexOf(val)
      // || ~item.removeLandNum.indexOf(val)
      //   || ~item.removeLandArea.indexOf(val)
    }
  },
  mounted() {
    _this = this;
    this.getBuildingRemoveData();
    this.downloadUrl = common.serverIp + "city3dfile/download/city-building-remove.xlsx";
  },
  computed: {
    viewerHeight: function () {
      return (window.innerHeight - 130) + 'px';
    },
    leftWidth: function () {
      return ((window.innerWidth - 230) * 0.5) + 'px';
    },
    rightWidth: function () {
      return ((window.innerWidth - 230) * 0.5) + 'px';
    },
    cardBodyHeight: function () {
      return (window.innerHeight - 130 - 90) + 'px';
    },
    treeHeight: function () {
      return (window.innerHeight - 130 - 10) / 2 - 18 + 'px';
    },
    viewerHeightTopR: function () {
      return (window.innerHeight - 130 - 10) / 2 + 'px';
    },
    viewerHeightBottomR: function () {
      return (window.innerHeight - 130 - 10) / 2 + 'px';
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

.right-card-bottom {
  float: right;
  margin-top: 8px;
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

.row_display {
  display: flex;
}

.search-input {
  width: 400px;
  float: right;
  margin: 0 0 0 20px;
}

.header-upload-1 {
  width: 210px;
  position: absolute;
  top: 77px;
  left: 675px;
}

.header-button-upload {
  margin-top: 12px;
  font-size: 14px;
}

.icon_position {
  position: absolute;
  top: 12px;
  right: 15px;
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

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.right-card-bottom-carousel {
  margin-top: 0;
  width: 91%;
  height: 350px;
  border: 1px dashed #409EFF;
  border-radius: 6px;
}

.carousel-item {
  height: 100%
}

.form-fai-carousel {
  font-size: 18px !important;
  cursor: pointer;
  color: #007acc;
  position: absolute;
  top: 4px;
  right: 1px;
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
