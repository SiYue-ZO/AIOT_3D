<template>
  <ztree :nodes="nodes" :setting="setting" class="addtree" @onCreated="handleCreated"/>
</template>

<script>
import ztree from "vue-giant-tree";
import {getAddressDirectory, getAllandNetById, queryNetData} from "../../api/api";

export default {
  name: "address-tree",
  components: {ztree},
  data() {
    return {
      setting: {},
      nodes: [],
      ztreeObj: null,
    }
  },
  methods: {
    createZTree(data) {
      let _this = this;
      this.setting = {
        check: {
          enable: true,
          chkStyle: "radio",
          radioType: "all",
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: "0",
          },
        },
        callback: {
          onClick: onClick,
          onCheck: TreeChecked,
        },
        view: {
          showIcon: false,
          selectedMulti: false, //可以多选
        },
      };
      let treeNodes = [
        {
          id: 0,
          pid: "",
          name: "地址目录树（单击节点查询下级地名地址）",
          isNode: false,
          showIcon: false,
          nocheck: true,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].netId;
        treeObj.pid = data[i].netPid;
        treeObj.name = data[i].netName;
        treeObj.nocheck = true;
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      //check触发回调函数
      function onClick(event, treeId, treeNode) {
        let params = {
          pid: treeNode.id,
        };
        getAddressDirectory(params).then((res) => {
          //异步点击查询子节点，无该子节点则插入到该父节点中
          if (!treeNode.hasOwnProperty("children") || treeNode.children.length === 0) {
            let data = res.data;
            for (let i = 0; i < data.length; i++) {
              let parentZNode = _this.ztreeObj.getNodeByParam("id", treeNode.id, null);
              let treeObj = {};
              treeObj.id = data[i].addId;
              treeObj.pid = data[i].pid;
              treeObj.name = data[i].addName;
              let newNode = _this.ztreeObj.addNodes(parentZNode, treeObj, false);
            }
          }
        });
      }

      function TreeChecked(event, treeId, treeNode) {
        window.addressId = treeNode.id;
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    init() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        queryNetData().then((res) => {
          this.createZTree(res.data);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandNetById(params).then(res => {
          let netArr = [];
          res.data.sysRoleNet.map(item => {
            netArr.push(item.net);
          });
          this.createZTree(netArr);
        });
      }
    }
  },
  mounted() {
    this.init();
  },
}
</script>

<style scoped>
.addtree {
  margin: 10px 0 0 20px
}
</style>
