<template>
  <el-radio-group v-model="radioId" id="net-custom-is-show">
    <table class="list-tabel" cellspacing="0">
      <tr v-for="(item,index) in coverageData">
        <td>
          <el-radio class="check-group" :label="item.id" @change="ctrlAttrData(item.name)">{{item.name}}</el-radio>
        </td>
      </tr>
    </table>
  </el-radio-group>
</template>

<script>
  import netCustomSearch from './net-custom-search';
  import {getCoverageAll} from "../api/api";

  export default {
    name: "net-custom",
    data() {
      return {
        coverageData: [],
        radioId: 0, // 选中的值
      }
    },
    methods: {
      //获取全部定制图层
      getCoverage_3D() {
        getCoverageAll().then(res => this.showCoverageAll(res.data));
      },
      showCoverageAll(data) {
        this.coverageData = data;
      },
      //控制各个图层的面板
      ctrlAttrData(name) {
        window.curNetCustomId = this.radioId;
        window.curNetCustomName = name;
        let options = {
          title: "图层数据条件检索",
          message: netCustomSearch,
          initWidth: "405px",
          initHeight: "355px",
          top: 550,
          left: 0,
          titleImg: ['fas', 'indent'],
          options: {
            minWidth: "405px",
            minHeight: "355px",
            fullScreen: true,
            closeCallback: this.closeCustomSearch,
          }
        };
        this.$installdialog.subPop(options);
      },
      closeCustomSearch() {
        netCustomSearch.methods.closeNetCustomSearch();
      },
      closeCustom() {
        this.closeCustomSearch();
      }
    },
    mounted() {
      this.getCoverage_3D();
    }
  }
</script>

<style scoped>
  .list-tabel {
    width: 365px;
    border: none;
    margin-top: 5px;
    color: #fff;
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

  .check-group {
    font-size: 18px;
    color: #ffffff;
    width: 100%;
    margin: 5px 10px;
  }

</style>
