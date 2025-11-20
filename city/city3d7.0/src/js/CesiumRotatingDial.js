export default class {
  constructor(viewer, position, radius, height) {
    this.viewer = viewer;
    this.position = position;
    this.radius = radius;
    this.height = height;
    this.entities = [];
    this.addEntities();
  }

  addEntities() {
    let t = 0;
    let n = 4;
    let i = [{
      range: this.radius,
      url: "static/images/kedu/kedu.png",
      color: new Cesium.Color(.4, .4, .4, .8)
    }, {
      range: this.radius * 0.92,
      url: "static/images/kedu/fangxiang.png",
      st: -.05,
      color: new Cesium.Color(.4, .4, .4, .8)
    }, {
      range: this.radius * 0.85,
      url: "static/images/kedu/keduzhi.png",
      color: new Cesium.Color(1, 1, 1, .2)
    }, {
      range: this.radius,
      url: "static/images/kedu/faguang.png",
      color: new Cesium.Color(1, 1, 1, .5)
    }];
    let e;
    i.forEach((t) => {
      e = this.viewer.entities.add({
        position: this.position,
        ellipse: {
          height: this.height,
          semiMajorAxis: t.range,
          semiMinorAxis: t.range,
          material: new Cesium.ImageMaterialProperty({
            image: t.url,
            transparent: !0,
            color: t.color ? t.color : new Cesium.Color(1, 1, 1, .7)
          }),
          stRotation: t.st ? t.st : 0
        }
      });
      this.entities.push(e);
    });

    e = this.viewer.entities.add({
      id: "rotatingDial",
      position: this.position,
      ellipse: {
        height: this.height,
        semiMajorAxis: this.radius * 0.9,
        semiMinorAxis: this.radius * 0.9,
        material: new Cesium.ImageMaterialProperty({
          image: "static/images/kedu/banyuan.png",
          transparent: !0,
          color: new Cesium.Color(.4, .4, .4, .4)
        }),
        stRotation: new Cesium.CallbackProperty((function () {
          return t += .005
        }), !1)
      }
    });
    this.entities.push(e);
  }

  remove() {
    this.entities.forEach(item => {
      this.viewer.entities.remove(item);
    });

    this.entities = undefined;
  }
}
