<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* default */
html, body, #app {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  overflow: hidden
}

.textshadow-p {
  text-shadow: 0 0 2px #00ddddcc
}

.textshadow-i {
  filter: drop-shadow(0 0 2px #00dddd77);
}

.my-card-body::-webkit-scrollbar {
  width: 8px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.my-card-body::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.my-card-body::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

/* cesium */
.cesium-viewer-bottom {
  display: none
}

.cesium-viewer-animationContainer {
  display: none
}

.cesium-viewer-timelineContainer {
  display: none
}

/* elementUI */
.el-header {
  padding: 0;
}

.el-menu {
  border-right: none !important;
}

.el-main {
  padding: 10px;
}

.el-main::-webkit-scrollbar {
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.el-main::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.el-main::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.el-container {
  overflow-y: auto;
}

.el-container::-webkit-scrollbar {
  width: 6px; /*高宽分别对应横竖滚动条的尺寸*/
  height: 4px;
}

.el-container::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
  border-radius: 5px;
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  background: #00ffff33;
}

.el-container::-webkit-scrollbar-track { /*滚动条里面轨道*/
  box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
  border-radius: 0;
  background: rgba(0, 0, 0, 0.2);
}

.el-submenu__icon-arrow {
  color: #ffffff !important;
  margin-top: -6px !important;
}

.el-table tr {
  cursor: pointer;
}

.el-button {
  padding: 11px 18px !important;
}

.el-card__body {
  padding: 10px;
  max-height: 780px;
}

.el-aside {
  overflow: hidden;
}

.el-form-item__label {
  font-size: 15px !important;
}

.el-radio-button__inner {
  border-left: 1px solid #DCDFE6 !important;
  margin-top: 8px;
}

.el-step__title {
  font-size: 15px !important;
  font-weight: normal;
}
</style>
