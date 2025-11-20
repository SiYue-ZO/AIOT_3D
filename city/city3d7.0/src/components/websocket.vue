<template>
  <div class="websocket">
  </div>
</template>

<script>
  import {eventBus} from "../main";

  let websock = null;
  let websockAir = null;
  export default {
    name: "websocket",
    created() {
      this.initWebSocket();
      this.initWebSocketAir();
    },
    destroyed() {
      websock.close(); //离开路由之后断开websocket连接
    },
    methods: {
      //初始化Websocket连接
      initWebSocket() {
        let wsIpArr = common.serverIp.split(":");
        const wsuri = 'ws:' + wsIpArr[1] + ":" + wsIpArr[2] + 'city3dAPI/' + "spring-ws";
        websock = new WebSocket(wsuri);
        websock.onmessage = this.websocketonmessage;
        websock.onopen = this.websocketonopen;
        websock.onerror = this.websocketonerror;
        websock.onclose = this.websocketclose;
        window.faceAlarmId = [];
        window.videoNum = 0;
      },
      websocketonopen() {
        //连接建立之后执行send方法发送数据
        // let actions = {test: "12345"};
        // this.websocketsend(JSON.stringify(actions));
      },
      websocketonerror() {
        //连接建立失败重连
        this.initWebSocket();
      },
      websocketonmessage(e) {
        //数据接收
        const redata = JSON.parse(e.data);
        switch (Object.keys(redata)[0]) {
          case "task"://任务提醒
            console.log(redata);
            break;
          case "alert"://周界报警
            let protectAlert = document.getElementById("protectAlert");
            if (protectAlert) {
              eventBus.$emit("busAlert", redata.alert);
            }
            break;
          case "alarm"://人脸识别
            let pop_face_alarm = document.getElementById("pop_face_alarm");
            if (pop_face_alarm) {
              eventBus.$emit("face_alarm", redata);
            }
            break;
          default:
            break;
        }
      },
      websocketsend(Data) {
        //数据发送
        websock.send(JSON.stringify(Data));
      },
      websocketclose(e) {
        //关闭
        console.log("断开连接", e);
      },
      //初始化Websocket连接
      initWebSocketAir() {
        let wsIpArr = common.serverIp.split(":");
        const wsuri = 'ws:' + wsIpArr[1] + ":" + wsIpArr[2] + 'city3dair/' + "dji/rData/web";
        websockAir = new WebSocket(wsuri);
        websockAir.onmessage = this.websocketonmessageAir;
        websockAir.onopen = this.websocketonopenAir;
        websockAir.onerror = this.websocketonerrorAir;
        websockAir.onclose = this.websocketclose;
      },
      websocketonopenAir() {
        //连接建立之后执行send方法发送数据
        // let actions = {test: "12345"};
        // this.websocketsend(JSON.stringify(actions));
      },
      websocketonerrorAir() {
        //连接建立失败重连
        this.initWebSocketAir();
      },
      websocketonmessageAir(e) {
        //数据接收
        const redata = JSON.parse(e.data);
        //无人机-为了解决视频与定位不同步的问题，后端推送定位需延迟3秒或视频延时时间
        eventBus.$emit("uav_real_data", redata);
      },
      websocketsendAir(Data) {
        //数据发送
        websockAir.send(JSON.stringify(Data));
      },
      websocketcloseAir(e) {
        //关闭
        console.log("断开连接", e);
      },
    },
  };
</script>
<style scoped>
</style>
