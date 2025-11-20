<template>
  <div>
    <table id="pop_face_alarm" class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in faceAlarmArr" :key="index">
        <td>
          <el-image style="width: 50px" :src="item.imgurl" :preview-src-list="[item.imgurl]"/>
        </td>
        <td @click="dogetKeypeopleById(item)">
          <div>{{item.name}}</div>
          <div>{{item.cardId}}</div>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  import map3d from "./map-3d";
  import popUtil from "@/utils/pop/popUtil";
  import {queryKeypeopleByIdentity, delFaceToServer, getKeypeopleAll} from "../api/api";

  export default {
    name: "protect-alarm-blacklist",
    data() {
      return {
        faceAlarmArr: [],
      };
    },
    methods: {
      //初始化黑名单
      createBlacklist(data) {
        for (let i = 0; i < data.length; i++) {
          this.faceAlarmArr.unshift({
            keyId: data[i].keyId,
            imgurl: common.serverIp + 'city3dfile/' + data[i].imgurl,
            name: data[i].name,
            cardId: data[i].identity,
          });
        }
      },
      //向AI服务器发送删除黑名单的指令
      removeBlacklist() {
        delFaceToServer().then(res => {
          if (res.data) {
            this.$message({
              message: "删除成功!",
              type: "success",
            });
          } else {
            this.$message({
              message: "删除失败!",
              type: "error",
            });
          }
        });
      },
      //从重点监控获取被识别人员的身份信息
      dogetKeypeopleById(item) {
        if (!item.cardId) {
          this.$message.error("该人员未关联到本地数据库!");
          return;
        }
        if (document.getElementById("popupDiv" + item.cardId)) {
          document.getElementById("popupDiv" + item.cardId).remove();
        }
        if (document.getElementById("popupDiv" + item.id)) {
          document.getElementById("popupDiv" + item.id).style.top = "2000px"
        }
        CesiumPop.bindPopGlobeEventHandler(viewer);
        let params = {
          identity: item.cardId,
        };
        queryKeypeopleByIdentity(params).then((res) => {
          showKeypeopleById(res.data, item.cardId)
        });

        function showKeypeopleById(data, keyId) {
          let popoptions = {
            popId: keyId,
            imgurl: common.serverIp + 'city3dfile/' + data.imgurl,
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
            id: keyId,
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
    },
    mounted() {
      getKeypeopleAll().then(res => this.createBlacklist(res.data));
    },
  }
</script>

<style scoped>
  .pop-fai {
    position: absolute;
    z-index: 100;
    top: 3px;
    color: #efefef;
    font-size: 15px;
    cursor: pointer;
    padding: 5px 6px;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }

  .list-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .list-tabel td {
    padding: 1px 3px;
    cursor: pointer;
  }

  .list-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .list-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

  .show_close {
    margin-right: 15px;
  }

  .show_close:hover {
    color: dodgerblue;
  }

  .play_video {
    width: 30px;
  }
</style>
