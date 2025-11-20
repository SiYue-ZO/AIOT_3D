<template>
  <div id="tiles3d-is-show">
    <ztree :nodes="nodes" :setting="setting"/>
  </div>
</template>

<script>
  import ztree from "vue-giant-tree";
  import map3d from "./map-3d";
  import {getAllandTiles3dById, getTiles3D} from "../api/api";

  export default {
    name: "tiles3d",
    components: {
      ztree
    },
    data() {
      return {
        setting: {},
        nodes: []
      }
    },
    methods: {
      //创建实景三维模型目录树
      createTiles3DTree(data) {
        //目录树配置
        this.setting = {
          check: {
            enable: true,
          },
          data: {
            simpleData: {
              enable: true,
              idKey: "id",
              pIdKey: "pid",
              rootPId: "0"
            }
          },
          callback: {
            onCheck: tiles3dzTreeOnCheck,
            onClick: tiles3dzTreeOnClick,
          }
        };
        let treeNodes = [{id: 0, pid: "", name: "实景三维数据集", isNode: false, open: true, showIcon: false, nocheck: true}];
        if (data) {
          for (let i = 0; i < data.length; i++) {
            let j = {};
            j.id = data[i].tiles3d.tilesId;
            j.name = data[i].tiles3d.tilesName;
            j.pid = "0";
            j.tilesX = data[i].tiles3d.tilesX;
            j.tilesY = data[i].tiles3d.tilesY;
            j.tilesZ = data[i].tiles3d.tilesZ;
            j.tilesUrl = data[i].tiles3d.tilesUrl;
            j.camPoi = data[i].tiles3d.camPoi;
            j.camHeading = data[i].tiles3d.camHeading;
            j.camPitch = data[i].tiles3d.camPitch;
            j.checked = data[i].tiles3d.tilesType === "cc";
            treeNodes.push(j);
          }
        }
        this.nodes = treeNodes;

        //check触发回调函数
        function tiles3dzTreeOnClick(event, treeId, treeNode) {
          let camPoiArr = treeNode.camPoi.split(',');
          map3d.methods.moveToWin(Number(camPoiArr[0]), Number(camPoiArr[1]), Number(camPoiArr[2]), Number(treeNode.camHeading), Number(treeNode.camPitch));
        }

        function tiles3dzTreeOnCheck(event, treeId, treeNode) {
          if (treeNode.checked) {
            map3d.methods.add3dtilesmap(treeNode);
          } else {
            map3d.methods.remove3dtilesmap(treeNode.tilesUrl);
          }
        }
      }
    },
    mounted() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getTiles3D().then(res => {
          let tilesetArr = [];
          res.data.map(item => {
            item.tiles3d = item;
            tilesetArr.push(item);
          });
          this.createTiles3DTree(tilesetArr);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId"),
        };
        getAllandTiles3dById(params).then(res => this.createTiles3DTree(res.data.sysRoleTiles3d));
      }
    }
  }
</script>

<style scoped>

</style>
