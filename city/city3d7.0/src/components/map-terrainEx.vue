<template>
  <div id="terrainEx-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="terrainEx" title="确定">
      <font-awesome-icon :icon="['fas', 'check']"></font-awesome-icon>
    </div>
    <div style="margin-top:25px">
      <el-input v-model="terrainExStr" placeholder="1.0"></el-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "map-terrainEx",
  data() {
    return {
      terrainExStr: ""
    }
  },
  methods: {
    //地形夸张
    terrainEx() {
      this.$message.warning("此功能为Cesium-1.100版本适用");
      viewer.scene.globe.terrainExaggeration = Number(this.terrainExStr);//Cesium-1.100适用
    }
  },
  mounted() {
    this.terrainExStr = viewer.scene.globe.terrainExaggeration;
  }
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

.pop-fai-start {
  right: 80px;
}

.pop-fai-start:hover {
  background-color: #20920a;
}
</style>
