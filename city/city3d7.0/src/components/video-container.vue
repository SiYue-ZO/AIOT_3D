<template>
  <table class="video-container" cellspacing="0">
    <tr>
      <td v-bind:id="vcid"></td>
    </tr>
  </table>
</template>

<script>
  export default {
    name: "video-container",
    data() {
      return {
        vcid: 'vc-1',
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .video-container {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #fff;
  }

  .video-container td {
    cursor: pointer;
    height: 320px;
    width: 360px;
    background: #091d46bb;
    border: solid 1px #88888888;
  }
</style>
