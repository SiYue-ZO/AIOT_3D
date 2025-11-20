<template>
  <ztree :nodes="nodes" :setting="setting" class="addtree" @onCreated="handleCreated"/>
</template>

<script>
import ztree from "vue-giant-tree";
import {getAllandSecurityById, getSecurityAll} from "../../api/api";

export default {
  name: "security-tree",
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
          name: "网格目录树",
          isNode: false,
          showIcon: false,
          open: true
        },
      ];
      for (let i = 0; i < data.length; i++) {
        let treeObj = {};
        treeObj.id = data[i].securityId;
        treeObj.pid = data[i].pid;
        treeObj.name = data[i].securityName;
        if (data[i].level === "微网格") {
          treeObj.nocheck = true;
        }
        treeNodes.push(treeObj);
      }
      this.nodes = treeNodes;

      function TreeChecked(event, treeId, treeNode) {
        window.securityPid = treeNode.id;
      }
    },
    handleCreated(ztreeObj) {
      this.ztreeObj = ztreeObj;
    },
    init() {
      if (localStorage.getItem("roleId") === "sunhengyi18826126699") {
        getSecurityAll().then((res) => {
          this.createZTree(res.data);
        });
      } else {
        let params = {
          'roleId': localStorage.getItem("roleId")
        };
        getAllandSecurityById(params).then(res => {
          let sArr = [];
          res.data.sysRoleSecurity.map(item => {
            sArr.push(item.security);
          });
          this.createZTree(sArr);
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
