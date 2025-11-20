<template>
  <div class="faceBox" id="protect-face-is-show">
    <div class="pop-fai pop-fai-follow" @click="checkHistory" title="比对回查">
      <font-awesome-icon :icon="['fas', 'user-check']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" @click="clearKeyPeople" title="重新指定识别目标">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-vs-follow" @click="saveKeyPeople" title="存入黑名单">
      <font-awesome-icon :icon="['far', 'check-circle']" fixed-width></font-awesome-icon>
    </div>
    <div class="vsCanvas" v-show="isCanvasShow">
      <div class="vsTitle">
        <font-awesome-icon :icon="['far', 'comment-alt']" fixed-width></font-awesome-icon>
        <label>指定识别目标</label>
      </div>
      <div class="pop-fai pop-fai-upload" @click="uploadImg" title="选择照片">
        <font-awesome-icon :icon="['fas', 'users-cog']" fixed-width></font-awesome-icon>
      </div>
      <div class="pop-fai pop-fai-vs-follow" @click="addKeyPeople" title="确定目标">
        <font-awesome-icon :icon="['fas', 'check']" fixed-width></font-awesome-icon>
      </div>
      <div class="pop-fai pop-fai-vs-save" @click="shootup" title="抓拍视频">
        <font-awesome-icon :icon="['fas', 'camera']" fixed-width></font-awesome-icon>
      </div>
      <div class="pop-fai pop-fai-vs-stop" @click="clearRect" title="清除框选">
        <font-awesome-icon :icon="['far', 'trash-alt']" fixed-width></font-awesome-icon>
      </div>
      <canvas id="vscanvas" width="940px" height="540px" style="margin-top: 35px;padding:5px"></canvas>
      <div class="box_lt"></div>
      <div class="box_lb"></div>
      <div class="box_rt"></div>
      <div class="box_rb"></div>
    </div>
    <el-dialog title="请选择起始时间-终止时间" :visible.sync="dialogVisible" width="30%" :modal=false :center=true
               :before-close="handleClose">
      <el-date-picker v-model="valueTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetimerange" range-separator="至"
                      :default-time="['12:00:00', '08:00:00']" start-placeholder="开始日期" end-placeholder="结束日期">
      </el-date-picker>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="this.searchImg">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="请选择本地照片" :visible.sync="uploadVisible" width="30%" :modal=false :center=true
               :before-close="uploadHandleClose">
      <div class="row_display avatar-img-row">
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
        <el-dialog :visible.sync="predialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="uploadVisible = false">取 消</el-button>
        <el-button type="primary" @click="this.confirmImg">确 定</el-button>
      </span>
    </el-dialog>
    <div>
      <div class="poi_bottem">
        <span class="lable_face_people">摄像头IP:</span>
        <el-input class="ipt_face_people" size="small" v-model="keyPeopleIp" placeholder="请填写此摄像头的IP地址"></el-input>
      </div>
      <div class="poi_bottem">
        <span class="lable_face_people">身份证:</span>
        <el-input class="ipt_face_people" size="small" v-model="keyPeopleId" placeholder="未知可疑人员,请勿填写此项"></el-input>
      </div>
      <div class="poi_bottem">
        <span class="lable_face_people">简要描述:</span>
        <el-input class="ipt_face_people" size="small" v-model="keyPeopleDes" placeholder="请输入对可疑人员的描述"></el-input>
      </div>
      <div style="height:200px;display:flex;">
        <span class="lable_face_people_img">识别目标预览:</span>
        <img id="targetfaceimg" class="targetfaceimg"/>
      </div>
    </div>
    <label id="isFacingShow" style="color: #ffffff" v-show="isFacingShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width spin></font-awesome-icon>
      正在识别，请稍后......
    </label>
    <label id="isFollowingShow" style="color: #ffffff" v-show="isFollowingShow">
      <font-awesome-icon :icon="['fas', 'redo']" fixed-width spin></font-awesome-icon>
      正在保存，请稍后......
    </label>
    <div class="list-tabel">
      <table v-for="(item,index) in faceResultArr" :key="index" v-on:click="dogetKeypeopleById(item.keyId)">
        <tr>
          <td style="text-align: center">
            <div class="face-percent textshadow-p">{{item.percent}}</div>
          </td>
          <td colspan="2">{{item.birthday}}</td>
        </tr>
        <tr>
          <td rowspan="4"><img style="width: 90px" v-bind:src="item.imgurl" :preview-src-list="[item.imgurl]"/></td>
          <td colspan="2">{{item.identity}}</td>
        </tr>
        <tr>
          <td>{{item.name}}</td>
          <td>{{item.type}}</td>
        </tr>
        <tr>
          <td>{{item.gender}}</td>
          <td>{{item.tel}}</td>
        </tr>
        <tr>
          <td colspan="2">{{item.addName}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
  import popUtil from "@/utils/pop/popUtil";
  import map3d from "./map-3d";
  import {eventBus} from "../main";
  import {getRandom} from "../js/CesiumTools";
  import {
    getKeypeopleById,
    getVideoById,
    searchImgByFace,
    addFaceToServer, queryKeypeople, insertKeypeople,
  } from "../api/api";

  let that;

  let vscanvas;
  let targetcanvas;
  let facecxt;
  let lineArr = []; //边线数组
  let prefacevideoId;
  let prefaceimgElement;
  let isCanvasOnFirst = true;
  let query2_overlays3D = [];

  export default {
    name: "protect-face",
    data() {
      return {
        faceResultArr: [],
        isCanvasShow: true,
        isFacingShow: false,
        isFollowingShow: false,
        dialogVisible: false,
        uploadVisible: false,
        disabled: false,
        valueTime: "",
        keyPeopleIp: "",
        keyPeopleId: "",
        keyPeopleDes: "",
        acceptFileType: ".jpg,.jpeg,.png,.gif,.bmp,.JPG,.JPEG,.PNG,.GIF,.BMP",
        fileList: [],
        dialogImageUrl: "",
        predialogVisible: false
      };
    },
    methods: {
      //创建识别画面的canvas画板并开启监控对象框选
      createvscanvas(videoId) {
        prefacevideoId = videoId;
        let params = {
          id: videoId,
        };
        getVideoById(params).then((res) => {
          that.keyPeopleIp = res.data.macUrl
        });
        this.shootup();
        document.getElementById("vscanvas").onmousedown = function (e) {
          if (isCanvasOnFirst) {
            that.clearRect();
            drawpoint(e);
            isCanvasOnFirst = false;
          } else {
            drawpoint(e);
            let imgwidth = Math.abs(lineArr[0].x - lineArr[1].x);
            let imgheight = Math.abs(lineArr[0].y - lineArr[1].y);
            let leftx = lineArr[0].x > lineArr[1].x ? lineArr[1].x : lineArr[0].x;
            let lefty = lineArr[0].y > lineArr[1].y ? lineArr[1].y : lineArr[0].y;
            let imgdata = facecxt.getImageData(leftx, lefty, imgwidth, imgheight);
            targetcanvas = document.createElement("canvas");
            targetcanvas.width = imgwidth;
            targetcanvas.height = imgheight;
            targetcanvas.getContext("2d").putImageData(imgdata, 0, 0);
            facecxt.save();
            facecxt.fillStyle = "rgba(0,0,0,0.8)";
            facecxt.fillRect(0, 0, vscanvas.width, vscanvas.height);
            facecxt.beginPath();
            facecxt.lineWidth = 2;
            facecxt.setLineDash([6, 4]);
            facecxt.lineTo(leftx, lefty);
            facecxt.lineTo(leftx + imgwidth, lefty);
            facecxt.lineTo(leftx + imgwidth, lefty + imgheight);
            facecxt.lineTo(leftx, lefty + imgheight);
            facecxt.lineTo(leftx, lefty);
            facecxt.strokeStyle = "red";
            facecxt.stroke();
            facecxt.closePath();
            facecxt.clip();
            facecxt.drawImage(prefaceimgElement, 0, 0, vscanvas.width, vscanvas.height);
            facecxt.restore();
            isCanvasOnFirst = true;
          }
        };

        function drawpoint(e) {
          let x = e.offsetX; // 鼠标落下时的X
          let y = e.offsetY; // 鼠标落下时的Y
          let lineObj = {x: x, y: y};
          lineArr.push(lineObj);
          facecxt.beginPath();
          facecxt.arc(x, y, 5, 0, Math.PI * 2, true);
          facecxt.closePath();
          facecxt.strokeStyle = "rgba(255,0,0,1)";
          facecxt.stroke();
        }
      },
      //清除截图
      clearRect() {
        facecxt.clearRect(0, 0, vscanvas.width, vscanvas.height);
        facecxt.drawImage(prefaceimgElement, 0, 0, vscanvas.width, vscanvas.height);
        lineArr = [];
        isCanvasOnFirst = true;
      },
      //截图抓拍方法
      shootup() {
        vscanvas = document.getElementById("vscanvas");
        facecxt = vscanvas.getContext("2d");
        if (prefacevideoId !== "local") {
          let faceVideoElement = document.getElementById(prefacevideoId);
          facecxt.drawImage(faceVideoElement, 0, 0, vscanvas.width, vscanvas.height);
          prefaceimgElement.src = vscanvas.toDataURL("image/jpeg");
        } else {
          this.uploadVisible = true;
        }
      },
      //清除可疑人员表单，重新识别目标
      clearKeyPeople() {
        this.keyPeopleId = "";
        this.keyPeopleDes = "";
        document.getElementById("targetfaceimg").src = "";
        this.isCanvasShow = true;
        this.closeFaceResult();
      },
      //保存可疑人员加入黑名单(数据库/服务器/NASS三个一起添加)
      saveKeyPeople() {
        let _this = this;
        this.$confirm("确认向AI服务器注册此条黑名单？").then(() => {
          let numId = getRandom(9);
          let args = {
            repoType: 1,
            userId: numId,
            image: document.getElementById("targetfaceimg").src,
            cardId: _this.keyPeopleId,
          };
          _this.isFollowingShow = true;
          addFaceToServer(args).then((res) => {
            if (res.data.result.code === 200) {
              let params = {
                'blood': '1',
                'name': _this.keyPeopleDes,
                'birthday': numId,
                'type': "重点人员",
                'identity': _this.keyPeopleId,
              };
              insertKeypeople(params).then(res => {
                if (res.data === 1) {
                  _this.$message({
                    message: "该目标已存入黑名单!",
                    type: "success",
                  });
                  _this.clearKeyPeople();
                } else {
                  this.$message({
                    type: 'error',
                    message: '新增重点监控人员失败，请重试！'
                  });
                }
              })
            } else {
              _this.$message.error("注册失败,请检查后重新录入!");
            }
            _this.isFollowingShow = false;
          });
        }).catch(() => {
          _this.$message.error("已取消保存操作!");
        });
      },
      //开始识别
      searchImg() {
        if (document.getElementById("targetfaceimg").src.length !== 0) {
          this.faceRecognition(this.valueTime[0], this.valueTime[1]);
          this.dialogVisible = false;
        } else {
          this.$notify({
            title: "警告",
            message: "请先框选或选择本地照片，作为人工智能识别的图像!",
            type: "warning",
            offset: 70,
          });
        }
      },
      //取消识别
      handleClose(done) {
        this.$confirm("确认关闭？").then(() => {
          done();
        }).catch(() => {
        });
      },
      //黑名单人脸注册 图片预览
      addKeyPeople() {
        document.getElementById("targetfaceimg").src = targetcanvas.toDataURL("image/jpeg");
      },
      //AI识别方法，根据时间范围
      faceRecognition(start, end) {
        this.isCanvasShow = false;
        this.isFacingShow = true;
        //人脸以图搜图
        let params = {
          repoType: 1,
          image: document.getElementById("targetfaceimg").src,
          startDateTime: start,
          endDateTime: end,
        };
        searchImgByFace(params).then((res) => {
          this.isFacingShow = false;
          this.startFace(res.data.data);
          this.clearRect();
        });
      },
      //根据识别结果获取重点监控人员信息
      startFace(faceData) {
        if (faceData.length > 0) {
          faceData.map(item => {
            if (item.userId !== null || item.userId !== "") {
              let params = {
                birthday: item.userId,
              };
              queryKeypeople(params).then((res) => {
                  this.showfaceresultlist(res.data[0], item.score, item);
                  if (res.data[0].address.poi !== undefined || res.data[0].address.poi !== "" || res.data[0].address.poi !== null) {
                    this.showfaceresultMark(res.data[0]);
                  }
                }
              );
            } else {
              let res = {
                keyId: getRandom(9),
                name: "陌生人",
                gender: "未知",
                identity: "未知",
                type: "未知",
                tel: "未知",
                nation: "未知",
                addName: "未知",
              };
              this.showfaceresultlist(res, item.score, item)
            }
          });
        } else {
          this.$notify({
            title: "警告",
            message: "没能匹配到目标图像!",
            type: "warning",
            offset: 70,
          });
        }
      },
      //绘制重点监控人员的点位图形
      showfaceresultlist(data, percent, faceItem) {
        let faceResult = {
          keyId: data.keyId,
          imgurl: common.aiIp + "api/captureImage/" + faceItem.image,
          percent: percent + "%",
          name: data.name,
          gender: data.gender,
          identity: data.identity,
          type: data.type,
          tel: data.tel,
          nation: data.nation,
          birthday: faceItem.captureTime,
          addName: data.address.addName,
        };
        this.faceResultArr.push(faceResult);
      },
      showfaceresultMark(data) {
        let position = data.address.poi.split(",");
        let pos = Cesium.Cartesian3.fromDegrees(Number(position[0]), Number(position[1]), Number(position[2]));
        query2_overlays3D.push(
          viewer.entities.add({
            name: "查询结果",
            id: "ke" + data.keyId,
            position: pos,
            ellipsoid: {
              radii: new Cesium.Cartesian3(0.5, 0.5, 0.5),
              material: Cesium.Color.GOLD.withAlpha(0.7),
            },
            billboard: {
              image: "static/images/pinimg/20.png",
              scale: 0.8,
              verticalOrigin: Cesium.VerticalOrigin.BOTTOM,
              scaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              pixelOffsetScaleByDistance: new Cesium.NearFarScalar(500, 1, 15000, 0.2),
              disableDepthTestDistance: 200,
            }
          })
        );
      },
      //清除识别比对结果
      closeFaceResult() {
        this.clearRect();
        for (let i = 0; i < query2_overlays3D.length; i++) {
          viewer.entities.remove(query2_overlays3D[i]);
        }
        query2_overlays3D = [];
        // CesiumPop.clearDivPop(viewer);
        this.faceResultArr = [];
      },
      //根据id获取重点监控人员信息
      dogetKeypeopleById(id) {
        let params = {
          keyId: id,
        };
        getKeypeopleById(params).then((res) => showKeypeopleById(res.data));

        function showKeypeopleById(data) {
          let popoptions = {
            popId: data.keyId,
            imgurl: common.serverIp + "city3dfile/" + data.imgurl,
            name: data.name,
            identity: data.identity,
            gender: data.gender,
            birthday: data.birthday,
            blood: data.blood,
            nation: data.nation,
            origin: data.origin,
            height: data.height,
            type: data.type,
            describe: data.describe,
            job: data.job,
            tel: data.tel,
            addName: data.address.addName,
          };
          popUtil.installMapPop().kpPop(popoptions);
          let addArr = data.address.poi.split(",");
          let options = {
            viewer: viewer,
            id: data.keyId,
            popupWidth: 477,
            popupHeight: 323,
            pos: {
              lon: Number(addArr[0]),
              lat: Number(addArr[1]),
              alt: Number(addArr[2]),
            },
            extentHeight: 0,
            extentColor: Cesium.Color.WHITE,
          };
          CesiumPop.addDivPop(options, "h");
          let camPoiArr = data.address.camPoi.split(",");
          map3d.methods.moveToWin(
            camPoiArr[0],
            camPoiArr[1],
            camPoiArr[2],
            data.address.camHeading,
            data.address.camPitch
          );
        }
      },
      //显示识别比对的时间范围选择面板
      checkHistory() {
        if (document.getElementById("targetfaceimg").src !== "") {
          this.dialogVisible = !this.dialogVisible;
        } else {
          this.$notify({
            title: "警告",
            message: "请先框选AI智能识别的图像!",
            type: "warning",
            offset: 70,
          });
        }
      },
      //选择本地照片，进行人脸比对
      uploadImg() {
        this.uploadVisible = !this.uploadVisible;
      },
      //本地照片窗口关闭
      uploadHandleClose(done) {
        this.$confirm("确认关闭？").then(() => {
          done();
          this.$refs.uploadImage.clearFiles();
        }).catch(() => {
        });
      },
      //本地识别图片确认
      confirmImg() {
        let base64Url = "";
        let img = document.getElementsByClassName("el-upload-list__item-thumbnail")[0];
        if (img) {
          base64Url = this.getBase64Image(img);
          document.getElementById("targetfaceimg").src = base64Url;
          this.$refs.uploadImage.clearFiles();
          this.uploadVisible = false;
        } else {
          this.$message({
            type: 'error',
            message: "自选照片不能为空，请点击“+”添加图片！"
          });
          return;
        }
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
        this.predialogVisible = true;
      },
      handleRemove(file) {
        this.$refs.uploadImage.handleRemove(file);
      },
      getBase64Image(img) {
        let canvas = document.createElement("canvas");
        canvas.width = img.width;
        canvas.height = img.height;
        let ctx = canvas.getContext("2d");
        ctx.drawImage(img, 0, 0, img.width, img.height);
        let dataUrl = canvas.toDataURL("image/jpeg");
        return dataUrl;
      },
    },
    mounted() {
      that = this;
      CesiumPop.bindPopGlobeEventHandler(viewer);
      prefaceimgElement = document.createElement("img");
      //通过Websocket和事件公交触发显示报警结果
      eventBus.$on("creat_face_key_people", (msg) => {
        this.createvscanvas(msg);
      });
      //关闭识别比对
      eventBus.$on("close_face_key_people", (msg) => {
        this.closeFaceResult();
      });
    },
  };
</script>


<style scoped>
  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel table {
    width: 100%;
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

  .pop-fai-upload {
    right: 100px;
  }

  .pop-fai-upload:hover {
    background-color: #e0960d;
  }

  .pop-fai-follow {
    right: 130px;
  }

  .pop-fai-follow:hover {
    background-color: #21e000;
  }

  .pop-fai-stop {
    right: 100px;
  }

  .pop-fai-stop:hover {
    background-color: #e600c3;
  }

  .pop-fai-vs-follow {
    right: 70px;
  }

  .pop-fai-vs-follow:hover {
    background-color: #e0960d;
  }

  .pop-fai-vs-save {
    right: 40px;
  }

  .pop-fai-vs-save:hover {
    background-color: #0035e6;
  }

  .pop-fai-vs-stop {
    right: 10px;
  }

  .pop-fai-vs-stop:hover {
    background-color: #e600c3;
  }

  .box_lt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    top: 0;
  }

  .box_rt {
    width: 10px;
    height: 10px;
    position: absolute;
    border-top: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    top: 0;
  }

  .box_rb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-right: 2px solid #00d3e7;
    right: 0;
    bottom: 0;
  }

  .box_lb {
    width: 10px;
    height: 10px;
    position: absolute;
    border-bottom: 2px solid #00d3e7;
    border-left: 2px solid #00d3e7;
    left: 0;
    bottom: 0;
  }

  .vsCanvas {
    position: absolute;
    left: -955px;
    top: 7px;
    background-color: #11264dd1;
    border-radius: 10px;
    border: 4px solid #025c95;
  }

  .vsTitle {
    color: #fff;
    top: 5px;
    left: 10px;
    position: absolute;
  }

  .targetfaceimg {
    height: 185px;
    margin-top: 10px;
    max-width: 70%;
  }

  .face-percent {
    font-size: 22px;
  }

  .lable_face_people {
    color: #fff;
    width: 100px;
    line-height: 33px;
  }

  .lable_face_people_img {
    color: #fff;
    width: 100px;
    line-height: 33px;
    vertical-align: 190px;
  }

  .ipt_face_people {
    color: #fff;
    width: 70% !important;
    background-color: #004c5abb !important;
  }

  .poi_bottem {
    display: flex;
    margin-bottom: 10px;
  }

  .avatar-img-row {
    width: 69%;
    margin: 0 0 10px 80px;
    border: 1px dashed #409EFF;
    border-radius: 6px;
  }

  .avatar-img-upload {
    margin: 10px 0 0 10px;
  }
</style>
