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

  .stat-window {
    position: absolute;
    z-index: 2;
    filter: drop-shadow(0 0 40px #11264D);
  }

  .stat-title {
    color: #ffffff;
    margin-left: 13px;
    font-family: "Microsoft YaHei UI"
  }

  .stat-top {
    width: 415px;
    height: 20px;
  }

  .stat-middle {
    background: url("assets/window/window_middle.png") repeat-y;
    margin-top: -4px
  }

  .stat-bottom {
    width: 415px;
    height: 30px;
  }

  .stat-content {
    margin: 0 0 0 25px
  }

  .stat-img-back {
    position: absolute;
    width: 100%;
    height: 100%;
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

  .cesium-viewer-toolbar {
    right: 30px
  }

  .cesium-infoBox {
    width: 50%
  }

  button.cesium-infoBox-close {
    right: 420px
  }

  /* elementUI */
  .el-menu.el-menu--horizontal {
    border: none !important;
  }

  .el-menu {
    border-right: none !important;
  }

  .el-menu--horizontal > .el-submenu .el-submenu__title {
    height: 40px !important;
    line-height: 40px !important;
    font-size: 15px !important;
    font-style: italic !important;
    padding: 0 10px !important
  }

  .el-menu--horizontal > .el-submenu .el-submenu__title:hover {
    background: url("../src/assets/header/navi_back.png");
    background-position: -50% 62% !important;
    background-color: #00ffff00 !important;
    box-shadow: none !important;
  }

  .el-menu--horizontal > .el-menu-item {
    height: 40px !important;
    line-height: 40px !important;
    font-size: 18px !important;
    font-style: italic !important;
    padding: 0 10px !important;
  }

  .el-menu--horizontal > .el-menu-item:hover {
    background: url("../src/assets/header/navi_back_s.png");
    background-position: 0% 62% !important;
    background-color: #00ffff00 !important;
    box-shadow: none !important;
  }

  .el-menu--horizontal > .el-menu > .el-menu-item:hover {
    background-color: #00ffff66 !important;
    box-shadow: none !important;
  }

  .pop-form .el-form-item {
    width: 100% !important;
  }

  .el-form--inline .el-form-item {
    margin-right: 0 !important
  }

  .el-range__icon {
    color: #fff !important;
  }

  .el-input__icon {
    color: #fff !important;
  }

  .el-range-separator {
    color: #fff !important;
  }

  .el-range-input {
    color: #fff !important;
    background-color: #00000000 !important;
  }

  .el-form--inline .el-form-item__content {
    width: 100% !important;
  }

  .el-input__inner {
    color: #fff !important;
    width: 100% !important;
    background-color: #004c5abb !important;
  }

  .el-textarea__inner {
    font-family: "Microsoft YaHei UI" !important;
    color: #fff !important;
    background-color: #004c5abb !important;
  }

  .el-textarea__inner::-webkit-scrollbar {
    width: 8px !important; /*高宽分别对应横竖滚动条的尺寸*/
    height: 4px !important;
  }

  .el-textarea__inner::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 5px !important;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
    background: #00ffff33 !important;
  }

  .el-textarea__inner::-webkit-scrollbar-track { /*滚动条里面轨道*/
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2) !important;
    border-radius: 0 !important;
    background: rgba(0, 0, 0, 0.2) !important;
  }

  .el-table thead {
    color: #ffffff !important;
  }

  .el-table th, .el-table tr {
    background: #004c5abb !important;
  }

  .el-table, .el-table__expanded-cell {
    background: rgba(0, 0, 0, 0) !important;
  }

  .el-table td, .el-table th.is-leaf {
    border: 0 !important;
  }

  .el-table tr {
    cursor: pointer !important;
  }

  .el-table--border::after, .el-table--group::after, .el-table::before {
    background-color: #001ea800 !important;
  }

  .el-table--striped .el-table__body tr.el-table__row--striped td {
    background: rgba(0, 29, 101, 0.91) !important;
  }

  .el-table__row--striped:hover {
    background-color: #00ffff !important
  }

  .el-table tbody tr:hover > td {
    background-color: #07b6f1 !important
  }

  .el-table--striped .el-table__body tr.el-table__row--striped.current-row td, .el-table__body tr.current-row > td {
    background-color: #0053f1 !important;
  }

  .el-table .cell {
    padding-right: 5px !important;
    padding-left: 8px !important;
    white-space: pre-line !important;
  }

  .el-table th > .cell {
    padding-right: 5px !important;
    padding-left: 8px !important;
  }

  .el-pagination {
    color: #ffffff !important;
  }

  .el-pagination button:disabled {
    background: #004c5abb !important;
  }

  .el-dialog, .el-pager li {
    background: #004c5abb !important;
  }

  .el-pager li.btn-quicknext, .el-pager li.btn-quickprev {
    color: #ffffff !important;
  }

  .faceBox .el-date-editor .el-range-input {
    color: #606266 !important;
  }

  .el-pagination__total {
    margin-right: 2px !important;
  }

  .el-pagination .el-select .el-input {
    width: 80px !important;
  }

  .el-pagination__sizes {
    margin-right: 3px !important;
  }

  .el-pagination .btn-prev, .el-pagination .btn-next {
    padding-right: 4px !important;
    background: #004c5abb !important;
    color: #ffffff !important;
  }

  .el-pagination button, .el-pagination {
    min-width: 10px !important;
  }

  .el-pagination button, .el-pagination span:not([class*=suffix]) {
    min-width: 10px !important;
  }

  .el-pager li {
    min-width: 24px !important;
  }

  .el-pager li.active {
    cursor: pointer !important;
  }

  .el-pagination__total {
    color: #ffffff !important;
  }

  .el-table__empty-text {
    color: #ffffff !important;
  }

  .el-table td, .el-table th {
    padding: 4px 0 !important;
  }

  .el-popover {
    background-color: #11264DD1 !important;
    border: solid 2px #004c5abb !important;
    border-radius: 7px;
  }

  .el-tabs__item {
    color: #ffffff !important;
    padding: 0 5px !important;
  }

  .el-radio__label {
    /*line-height: 23px;*/
    font-size: 15px !important;
    padding-left: 14px !important;
  }

  .el-dialog__title {
    color: #fff !important;
  }

  .el-input-number__decrease, .el-input-number__increase {
    background: #11264DD1 !important;
    color: #fff !important;
  }

  .el-submenu__title:focus, .el-submenu__title:hover {
    background-color: #00ffff00 !important;
    box-shadow: #1768e8 0 0 9px 6px inset;
  }

  .el-menu-item:focus, .el-menu-item:hover {
    background: #11264DD1 !important;
    box-shadow: #1768e8 0 0 9px 6px inset;
  }

  .el-submenu__title i {
    color: #eeeeee !important;
  }

  .protect-alert .el-dialog, .el-pager li {
    background: #11264DD1 !important;
  }

  .protect-alert .demo-image__preview, .el-image-viewer__canvas img {
    min-width: 70% !important;
  }

  /* ztree */
  .ztree li a {
    color: #ffffff !important;
  }

  .ztree .chk {
    width: 16px !important;
    height: 16px !important;
  }

  /* font */
  @font-face {
    font-family: 'IconFont';
    src: url('./utils/dialog/assets/font/iconfont.eot');
    src: url('./utils/dialog/assets/font/iconfont.eot?#iefix') format('embedded-opentype'),
    url('./utils/dialog/assets/font/iconfont.woff') format('woff'),
    url('./utils/dialog/assets/font/iconfont.ttf') format('truetype'),
    url('./utils/dialog/assets/font/iconfont.svg#NeuesBauenDemo') format('svg');
    font-weight: normal;
    font-style: normal;
  }

  /* baidu */
  .anchorBL {
    display: none;
  }

  .maplibTfctr {
    display: none;
  }

  .maplibTc {
    display: none
  }

  .maplibTcBtn_deskTop {
    display: none
  }

  .el-image-viewer__wrapper {
    top: 74px;
  }

  .el-image-viewer__close {
    top: 5px;
  }
</style>
