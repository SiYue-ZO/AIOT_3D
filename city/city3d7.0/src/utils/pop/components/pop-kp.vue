<template>
  <div v-bind:id="'popupDiv'+popId" class="infoPop" v-bind:ref="'kpPop-'+levelNum"
       v-on:click="clickStick('popupDiv'+popId)">
    <div class="infoPop-title">
      <div class="infoPop-name">姓名：{{name}}</div>
      <div class="infoPop-tools">
        <font-awesome-icon class="infoPop-tools-fai" :icon="['fas', 'times']" title="清除"
                           v-on:click.stop="pop_close"></font-awesome-icon>
      </div>
    </div>
    <div class="infoPop-content">
      <div class="leftimg">
        <el-image class="leftimg-img" :src="imgurl" :preview-src-list="[imgurl]"></el-image>
      </div>
      <table class="infoPop-tabel" cellspacing="0">
        <tr>
          <td>身份证号</td>
          <td>{{identity}}</td>
        </tr>
        <tr>
          <td>性别</td>
          <td>{{gender}}</td>
        </tr>
        <tr>
          <td>生日</td>
          <td>{{birthday}}</td>
        </tr>
        <tr>
          <td>血型</td>
          <td>{{blood}}</td>
        </tr>
        <tr>
          <td>民族</td>
          <td>{{nation}}</td>
        </tr>
        <tr>
          <td>籍贯</td>
          <td>{{origin}}</td>
        </tr>
        <tr>
          <td>身高</td>
          <td>{{height}}</td>
        </tr>
        <tr>
          <td>类别</td>
          <td>{{type}}</td>
        </tr>
        <tr>
          <td>情况描述</td>
          <td>{{describe}}</td>
        </tr>
        <tr>
          <td>工作单位</td>
          <td>{{job}}</td>
        </tr>
        <tr>
          <td>联系电话</td>
          <td>{{tel}}</td>
        </tr>
        <tr>
          <td>地址</td>
          <td>{{addName}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
  let popzIndex = 0;

  export default {
    name: "pop-building",
    data() {
      return {
        popId: "",
        levelNum: 0,//层级
        imgurl: "",
        name: "",
        identity: "",
        gender: "",
        birthday: "",
        blood: "",
        nation: "",
        origin: "",
        height: "",
        type: "",
        describe: "",
        job: "",
        tel: "",
        addName: "",
      }
    },
    methods: {
      pop_close() {
        let pop = this.$refs['kpPop-' + this.levelNum];
        if (pop) {
          document.querySelector('body').removeChild(pop);
        }
        CesiumPop.removeDivPopById(viewer, this.popId);
      },
      clickStick(id) {
        ++popzIndex;
        let stick = document.getElementById(id);
        if (stick !== null) {
          stick.style.zIndex = popzIndex;
          stick.style.position = "fixed";
        }
      }
    }
  }
</script>

<style scoped>
  .infoPop {
    width: 477px;
    height: 323px;
    color: #fff;
    font-family: Microsoft YaHei;
    position: absolute;
    left: -1000px;
    top: -1000px;
    background: url("../../../assets/pop/info_pop_h.png");
  }

  .infoPop-title {
    width: 370px;
    font-size: 14px;
    padding: 5px 8px;
    min-height: 30px;
    margin: 23px 0 0 90px;
    border-bottom: solid;
    border-width: 1px 0;
  }

  .infoPop-name {
    float: left;
  }

  .infoPop-tools {
    float: right
  }

  .infoPop-tools-fai {
    cursor: pointer;
    margin: 0 4px 0 6px;
  }

  .leftimg {
    float:left;
    margin-top: 6px;
  }

  .leftimg-img {
    width: 93px !important
  }

  .infoPop-content {
    font-size: 14px;
    padding: 3px;
    width: 370px;
    height: 160px;
    overflow-y: auto;
    overflow-x: hidden;
    color: #fff;
    margin: 0 0 0 90px;
  }

  .infoPop-content::-webkit-scrollbar {
    width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px;
  }

  .infoPop-content::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: #00ffff33;
  }

  .infoPop-content::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.2);
  }

  .infoPop-tabel {
    width: 260px;
    border: none;
    margin-top: 5px;
    float:right
  }

  .infoPop-tabel td {
    padding: 2px 5px;
  }

  .infoPop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }
</style>
