<template>
  <div id="demo-missile-is-show">
    <div class="pop-fai pop-fai-start" v-on:click="trackMissile" title="是否跟踪导弹">
      <font-awesome-icon :icon="['fas', 'binoculars']"></font-awesome-icon>
    </div>
    <div class="pop-fai pop-fai-stop" v-on:click="showTail" title="是否开启尾焰">
      <font-awesome-icon :icon="['fas', 'dharmachakra']"></font-awesome-icon>
    </div>
    <table class="infoPop-tabel" cellspacing="0">
      <tr>
        <td>时间（秒）</td>
        <td>{{time}}</td>
      </tr>
      <tr>
        <td>经度（度）</td>
        <td>{{lng}}</td>
      </tr>
      <tr>
        <td>纬度（度）</td>
        <td>{{lat}}</td>
      </tr>
      <tr>
        <td>高程（米）</td>
        <td>{{alt}}</td>
      </tr>
      <tr>
        <td>俯仰角（度）</td>
        <td>{{pitch}}</td>
      </tr>
      <tr>
        <td>偏航角（度）</td>
        <td>{{heading}}</td>
      </tr>
      <tr>
        <td>滚转角（度）</td>
        <td>{{roll}}</td>
      </tr>
      <tr>
        <td>水平舵（度）</td>
        <td>{{deltz}}</td>
      </tr>
      <tr>
        <td>垂直舵（度）</td>
        <td>{{delty}}</td>
      </tr>
      <tr>
        <td>阶段</td>
        <td>{{step}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
  let _this;
  let poistart1;
  let intervalMis;
  let listener;
  let missile;
  let particleSystem;
  export default {
    name: "demo-missile",
    data() {
      return {
        isTrack: true,
        isTail: true,
        time: 0,
        lng: 0,
        lat: 0,
        alt: 0,
        pitch: 0,
        roll: 0,
        heading: 0,
        deltz: 0,
        delty: 0,
        step: 1,
      }
    },
    methods: {
      startMissile() {
        _this = this;

        let mpath1 = controldata;
        this.time = mpath1[0][0];
        this.lng = mpath1[0][1];
        this.lat = mpath1[0][2];
        this.alt = mpath1[0][3];
        this.pitch = mpath1[0][4];
        this.heading = mpath1[0][5];
        this.roll = mpath1[0][6];
        this.deltz = mpath1[0][7];
        this.delty = mpath1[0][8];
        this.step = mpath1[0][9];

        poistart1 = Cesium.Cartesian3.fromDegrees(mpath1[0][1], mpath1[0][2], mpath1[0][3]);
        let heading1 = Cesium.Math.toRadians(mpath1[0][5]);
        let pitch1 = Cesium.Math.toRadians(mpath1[0][4]);
        let roll1 = Cesium.Math.toRadians(mpath1[0][6]);
        let hpr1 = new Cesium.HeadingPitchRoll(heading1, pitch1, roll1);
        let orientation1 = Cesium.Transforms.headingPitchRollQuaternion(poistart1, hpr1);

        missile = viewer.entities.add({
          id: 'missile1',
          position: poistart1,
          orientation: orientation1,
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/mis/mis-body.gltf",
            scale: 0.15,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(3, 1),
          }
        });
        viewer.entities.add({
          id: 'mis-tail01',
          parent: missile,
          position: poistart1,
          orientation: orientation1,
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/mis/mis-tail01.gltf",
            scale: 0.15,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(3, 1),
          }
        });
        viewer.entities.add({
          id: 'mis-tail02',
          parent: missile,
          position: poistart1,
          orientation: orientation1,
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/mis/mis-tail02.gltf",
            scale: 0.15,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(3, 1),
          }
        });
        viewer.entities.add({
          id: 'mis-tail03',
          parent: missile,
          position: poistart1,
          orientation: orientation1,
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/mis/mis-tail03.gltf",
            scale: 0.15,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(3, 1),
          }
        });
        viewer.entities.add({
          id: 'mis-tail04',
          parent: missile,
          position: poistart1,
          orientation: orientation1,
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/mis/mis-tail04.gltf",
            scale: 0.15,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(3, 1),
          }
        });
        viewer.trackedEntity = missile;

        //粒子
        let viewModel = {
          emissionRate: 100.0,
          gravity: 0.0,
          minimumParticleLife: 0.25,
          maximumParticleLife: 0.25,
          minimumSpeed: 0.00005,
          maximumSpeed: 0.00005,
          startScale: 0.5,
          endScale: 3.5,
          particleSize: 25.0,
        };

        function computeModelMatrix(entity, time) {
          return entity.computeModelMatrix(time, new Cesium.Matrix4());
        }

        let emitterModelMatrix = new Cesium.Matrix4();
        let translation = new Cesium.Cartesian3();
        let rotation = new Cesium.Quaternion();
        let hpr = new Cesium.HeadingPitchRoll();
        let trs = new Cesium.TranslationRotationScale();

        function computeEmitterModelMatrix() {
          hpr = Cesium.HeadingPitchRoll.fromDegrees(0.0, 0.0, 0.0, hpr);
          trs.translation = Cesium.Cartesian3.fromElements(-0.3, 0.0, 0.0, translation);
          trs.rotation = Cesium.Quaternion.fromHeadingPitchRoll(hpr, rotation);
          return Cesium.Matrix4.fromTranslationRotationScale(trs, emitterModelMatrix);
        }

        particleSystem = viewer.scene.primitives.add(
          new Cesium.ParticleSystem({
            id: "missileParticleSystem",
            //image: "static/images/fire.png",
            //startColor: Cesium.Color.ORANGERED.withAlpha(0.7),
            image: "static/images/smoke.png",
            startColor: Cesium.Color.LIGHTSEAGREEN.withAlpha(0.7),
            endColor: Cesium.Color.WHITE.withAlpha(0.0),
            startScale: viewModel.startScale,
            endScale: viewModel.endScale,
            minimumParticleLife: viewModel.minimumParticleLife,
            maximumParticleLife: viewModel.maximumParticleLife,
            minimumSpeed: viewModel.minimumSpeed,
            maximumSpeed: viewModel.maximumSpeed,
            imageSize: new Cesium.Cartesian2(viewModel.particleSize, viewModel.particleSize),
            emissionRate: viewModel.emissionRate,
            bursts: [
              // these burst will occasionally sync to create a multicolored effect
              new Cesium.ParticleBurst({time: 5.0, minimum: 10, maximum: 100,}),
              new Cesium.ParticleBurst({time: 10.0, minimum: 50, maximum: 100,}),
              new Cesium.ParticleBurst({time: 15.0, minimum: 200, maximum: 300,}),
            ],
            lifetime: 2.0,
            emitter: new Cesium.CircleEmitter(0.15),
            emitterModelMatrix: computeEmitterModelMatrix(),
          })
        );

        //轨迹
        let pathPosition1 = new Cesium.SampledPositionProperty();
        viewer.entities.add({
          id: 'mpath1',
          position: pathPosition1,
          path: {
            show: true,
            leadTime: 0,
            trailTime: 6000000000,
            width: 7,
            resolution: 1,
            material: new Cesium.PolylineGlowMaterialProperty({
              color: Cesium.Color.YELLOW,
              glowPower: 0.4
            }),
            // new Cesium.PolylineDashMaterialProperty({
            //   color: Cesium.Color.YELLOW
            // })
          },
        });

        //轨迹投影
        let newWallPoint = Cesium.Cartesian3.fromDegrees(mpath1[0][1], mpath1[0][2], mpath1[0][3]);
        let wallPosArr = [newWallPoint];
        let wallMinArr = [0];
        //投影轨迹增长
        viewer.entities.add({
          id: 'pathWall',
          wall: {
            positions: new Cesium.CallbackProperty(function () {
              wallPosArr.push(newWallPoint);
              return wallPosArr;
            }, false),
            minimumHeights: new Cesium.CallbackProperty(function () {
              wallMinArr.push(0);
              return wallMinArr;
            }, false),
            material: Cesium.Color.GREEN.withAlpha(0.3)
          },
        });

        //期望轨迹线
        let trajPathArr = [];
        for (let j = 0; j < trajdata.length; j++) {
          let point = Cesium.Cartesian3.fromDegrees(trajdata[j][1], trajdata[j][2], trajdata[j][3]);
          trajPathArr.push(point);
        }
        viewer.entities.add({
          id: 'trajPath',
          polyline: {
            positions: trajPathArr,
            width: 3,
            material: new Cesium.PolylineDashMaterialProperty({
              color: Cesium.Color.RED.withAlpha(0.6)
            })
          },
        });

        //雷达
        //通过3个画布交替切换实现探测纹理动态
        let changenum = 0;
        let curCanvas = 'a';

        function readyCanvas(convasid, radius) {
          let canvas = document.getElementById(convasid);
          let cwidth = 400;
          let cheight = 400;
          let ctx = canvas.getContext("2d");
          ctx.clearRect(0, 0, cwidth, cheight);
          ctx.fillStyle = 'rgba(255, 255, 255, 0)';
          ctx.fillRect(0, 0, cwidth, cheight);

          for (let ii = 0; radius <= 200; ii++) {
            ctx.lineWidth = 5;
            //开始一个新的绘制路径
            ctx.beginPath();
            //设置弧线的颜色
            let trans = 1.0 - (radius / 255);
            ctx.strokeStyle = "rgba(0,255,0, " + trans + ")";
            let circle = {
              x: 200, //圆心的x轴坐标值
              y: 200, //圆心的y轴坐标值
              r: radius //圆的半径
            };
            //以canvas中的坐标点(200,200)为圆心，绘制一个半径为50px的圆形
            ctx.arc(circle.x, circle.y, circle.r, 0, Math.PI * 2, true);
            //按照指定的路径绘制弧线
            ctx.stroke();
            radius += 20;
          }
        }

        readyCanvas("canvas-a", 5);
        readyCanvas("canvas-b", 10);
        readyCanvas("canvas-c", 15);

        function drawCanvasImage(time, result) {
          changenum++;
          let canvas = document.getElementById("canvas-" + curCanvas);
          if (changenum >= 20) {
            changenum = 0;
            if (curCanvas === 'a')
              curCanvas = 'b';
            else if (curCanvas === 'b')
              curCanvas = 'c';
            else
              curCanvas = 'a';
          }
          return canvas;
        }

        //创建圆锥实体
        let cylinder = viewer.entities.add({
          id: 'Radar',
          name: 'Red cone',
          position: poistart1,
          orientation: orientation1,
          //show: false,
          cylinder: {
            length: 5000,
            topRadius: 0.0,
            bottomRadius: 10.0,
            //topSurface: false,    //新增参数，控制顶部是否渲染
            //bottomSurface: false,    //新增参数，控制底部是否渲染
            material: new Cesium.ImageMaterialProperty({
              image: new Cesium.CallbackProperty(drawCanvasImage, false),
              transparent: true
            })
            // material: Cesium.Color.LAWNGREEN.withAlpha(0.3)
          }
        });

        //已知一点经纬度及与另一点距离和方位角，求另一点经纬度；
        function getTargetPOI(origin, len, azimuth, earthradius) {
          let target = [];
          let cr = len / earthradius;
          let ctor = Math.PI / 180;
          let A = Math.acos(Math.cos((90 - origin[1]) * ctor) * Math.cos(cr) + Math.sin((90 - origin[1]) * ctor) * Math.sin(cr) * Math.cos(azimuth));
          let C = Math.asin(Math.sin(cr) * Math.sin(azimuth) / Math.sin(A));
          target[0] = origin[0] + C / ctor;
          target[1] = 90 - A / ctor;
          return target;
        }

        //末端靶舰
        let shiprotation = Cesium.Math.toRadians(0);

        function getRotationValue() {
          shiprotation += 0.015;
          return shiprotation;
        }

        viewer.entities.add({
          id: 'ship',
          position: Cesium.Cartesian3.fromDegrees(trajdata[trajdata.length - 1][1], trajdata[trajdata.length - 1][2], trajdata[trajdata.length - 1][3]),
          model: {
            uri: common.serverIp + "city3dfile/" + "data/model/military/054a.gltf",
            scale: 0.026,
            shadows: Cesium.ShadowMode.DISABLED,
            imageBasedLightingFactor: new Cesium.Cartesian2(1, 1),
          },
          rectangle: {
            coordinates: Cesium.Rectangle.fromDegrees(
              trajdata[trajdata.length - 1][1] - 0.0006,
              trajdata[trajdata.length - 1][2] - 0.0006,
              trajdata[trajdata.length - 1][1] + 0.0006,
              trajdata[trajdata.length - 1][2] + 0.0006),
            material: new Cesium.ImageMaterialProperty({
              image: 'static/images/halo/bg_circle.png',
              transparent: true,
            }),
            rotation: new Cesium.CallbackProperty(getRotationValue, false),
            stRotation: new Cesium.CallbackProperty(getRotationValue, false),
            classificationType: Cesium.ClassificationType.BOTH,
          }
        });

        //开始通过计数器绘制动画
        let i = 1;
        let timei = 2;
        intervalMis = setInterval(function () {
          _this.time = mpath1[i][0];
          _this.lng = mpath1[i][1];
          _this.lat = mpath1[i][2];
          _this.alt = mpath1[i][3];
          _this.pitch = mpath1[i][4];
          _this.heading = mpath1[i][5];
          _this.roll = mpath1[i][6];
          _this.deltz = mpath1[i][7];
          _this.delty = mpath1[i][8];
          _this.step = mpath1[i][9];

          let startTime = Cesium.JulianDate.now(startTime);
          let stopTime = Cesium.JulianDate.now(startTime);
          if (i < mpath1.length - 1) {
            let finalHeading = 270 - mpath1[i][5];
            let curpos1 = Cesium.Cartesian3.fromDegrees(mpath1[i][1], mpath1[i][2], mpath1[i][3]);

            let heading1 = Cesium.Math.toRadians(finalHeading);
            let pitch1 = Cesium.Math.toRadians(mpath1[i][4]);
            let roll1 = Cesium.Math.toRadians(mpath1[i][6]);
            let hpr1 = new Cesium.HeadingPitchRoll(heading1, pitch1, roll1);
            let orientation1 = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hpr1);

            let heading2 = Cesium.Math.toRadians(finalHeading);
            let pitch2 = Cesium.Math.toRadians(mpath1[i][4] + mpath1[i][7]);
            let roll2 = Cesium.Math.toRadians(mpath1[i][6]);
            let hpr2 = new Cesium.HeadingPitchRoll(heading2, pitch2, roll2);
            let orientation2 = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hpr2);

            let heading3 = Cesium.Math.toRadians(finalHeading + mpath1[i][8]);
            let pitch3 = Cesium.Math.toRadians(mpath1[i][4]);
            let roll3 = Cesium.Math.toRadians(mpath1[i][6]);
            let hpr3 = new Cesium.HeadingPitchRoll(heading3, pitch3, roll3);
            let orientation3 = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hpr3);

            let heading4 = Cesium.Math.toRadians(finalHeading);
            let pitch4 = Cesium.Math.toRadians(mpath1[i][4] + mpath1[i][7]);
            let roll4 = Cesium.Math.toRadians(mpath1[i][6]);
            let hpr4 = new Cesium.HeadingPitchRoll(heading4, pitch4, roll4);
            let orientation4 = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hpr4);

            let heading5 = Cesium.Math.toRadians(finalHeading + mpath1[i][8]);
            let pitch5 = Cesium.Math.toRadians(mpath1[i][4]);
            let roll5 = Cesium.Math.toRadians(mpath1[i][6]);
            let hpr5 = new Cesium.HeadingPitchRoll(heading5, pitch5, roll5);
            let orientation5 = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hpr5);

            let orientationArr = [orientation1, orientation2, orientation3, orientation4, orientation5];
            let result = updateMissile('missile1', [poistart1, curpos1], orientationArr);

            //雷达
            //if (mpath1[i][9] === 3) {
            //cylinder.show = true;
            let radarLength = 5000;
            let hLength = radarLength * Math.cos(Cesium.Math.toRadians(mpath1[i][4])) / 2;
            let vLength = radarLength * Math.sin(Cesium.Math.toRadians(mpath1[i][4])) / 2;
            let radarHeading = Cesium.Math.toRadians(finalHeading + 90);
            let targetPoi = getTargetPOI([mpath1[i][1], mpath1[i][2]], hLength, radarHeading, 6378245.0);
            cylinder.position = Cesium.Cartesian3.fromDegrees(targetPoi[0], targetPoi[1], mpath1[i][3] + vLength);
            let pitchc = Cesium.Math.toRadians(mpath1[i][4] + 90);
            let rollc = Cesium.Math.toRadians(0);
            let hprc = new Cesium.HeadingPitchRoll(heading1, pitchc, rollc);
            let orientationc = Cesium.Transforms.headingPitchRollQuaternion(curpos1, hprc);
            cylinder.orientation = orientationc;
            cylinder.cylinder.length = radarLength;
            cylinder.cylinder.bottomRadius = radarLength / 5;
            //}

            poistart1 = curpos1;
            if (Cesium.JulianDate.compare(startTime, result.startTime) > 0) {
              startTime = result.startTime;
            }
            if (Cesium.JulianDate.compare(stopTime, result.stopTime) < 0) {
              stopTime = result.stopTime;
            }
            i++;
          } else {
            i = 0;
          }

          viewer.clock.startTime = startTime.clone();
          viewer.clock.stopTime = stopTime.clone();
          viewer.clock.currentTime = startTime.clone();
          viewer.clock.clockRange = Cesium.ClockRange.UNBOUNDED;
          viewer.clock.multiplier = 1;
          viewer.timeline.zoomTo(startTime, stopTime);
        }, timei * 1000);

        function updateMissile(id, nodes, orientation) {
          //添加移动实体
          let times = [];
          let startTime = Cesium.JulianDate.now(startTime);
          for (let i = 0; i < nodes.length; i++) {
            let time = new Cesium.JulianDate();
            Cesium.JulianDate.addSeconds(startTime, i * timei, time);
            times.push(time);
          }
          let stopTime = times[times.length - 1];
          //插值
          let property = new Cesium.SampledPositionProperty();
          property.addSamples(times, nodes);

          let ent = viewer.entities.getById(id);
          ent.position = property;
          ent.orientation = orientation[0];
          let entChildren = ent._children;
          for (let j = 0; j < entChildren.length; j++) {
            entChildren[j].position = property;
            entChildren[j].orientation = orientation[j + 1];
          }
          return {
            startTime: startTime,
            stopTime: stopTime
          };
        }

        //每一帧渲染时的监听，取到导弹的位置，给轨迹线
        listener = function (scene, time) {
          particleSystem.modelMatrix = computeModelMatrix(missile, time);
          particleSystem.emitterModelMatrix = computeEmitterModelMatrix();

          let timerPos1 = viewer.entities.getById('missile1');
          if (timerPos1 && timerPos1.position._property && timerPos1.position._property._interpolationResult[0]) {
            let interPosArr1 = timerPos1.position._property._interpolationResult;
            let interPos1 = Cesium.Cartesian3.fromElements(interPosArr1[0], interPosArr1[1], interPosArr1[2]);
            pathPosition1.addSample(Cesium.JulianDate.now(), interPos1);
            newWallPoint = interPos1;
          }
        };
        viewer.scene.preUpdate.addEventListener(listener);
      },
      //视角跟踪导弹
      trackMissile() {
        if (viewer.trackedEntity === undefined) {
          viewer.trackedEntity = missile;
          this.isTrack = true;
        } else {
          viewer.trackedEntity = undefined;
          this.isTrack = false;
        }
      },
      //显示尾部轨迹
      showTail() {
        if (this.isTail) {
          particleSystem.show = false;
          this.isTail = false;
        } else {
          particleSystem.show = true;
          this.isTail = true;
        }
      },
      //清除导弹效果
      closeMissile() {
        viewer.scene.preUpdate.removeEventListener(listener);
        viewer.trackedEntity = undefined;
        viewer.entities.removeById('missile1');
        viewer.entities.removeById('mis-tail01');
        viewer.entities.removeById('mis-tail02');
        viewer.entities.removeById('mis-tail03');
        viewer.entities.removeById('mis-tail04');
        viewer.entities.removeById('mpath1');
        viewer.entities.removeById('pathWall');
        viewer.entities.removeById('trajPath');
        viewer.entities.removeById('Radar');
        viewer.entities.removeById('ship');
        viewer.scene.primitives.remove(particleSystem);
        clearInterval(intervalMis);
      }
    },
    mounted() {
      this.startMissile();
    }
  }
</script>

<style scoped>
  .infoPop-tabel {
    width: 100%;
    border: none;
    margin-top: 5px;
    color: #ffffff;
  }

  .infoPop-tabel td {
    padding: 6px 5px 7px 5px;
  }

  .infoPop-tabel tr:nth-child(odd) {
    background: #004c5abb;
  }

  .infoPop-tabel tr:nth-child(even) {
    background: #091d46bb;
  }

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
    right: 120px;
  }

  .pop-fai-start:hover {
    background-color: #20920a;
  }

  .pop-fai-stop {
    right: 80px;
  }

  .pop-fai-stop:hover {
    background-color: #e6002f;
  }
</style>
