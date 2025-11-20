import ECEF from "./CoordinateTranslate.js";

let CesiumVideoShadow = (function () {
  let Cesium = null;

  //主方法
  let CesiumVideoShadow = function (cesium, viewer, param) {
    Cesium = cesium;
    this.ECEF = new ECEF();
    this.param = param;
    let option = this._initCameraParam();
    this.optionType = {
      Color: 1,
      Image: 2,
      Video: 3
    };
    this._near = option.near ? option.near : 0.1;
    if (option || (option = {}),
      this.viewer = viewer,
      this._cameraPosition = option.cameraPosition,
      this._position = option.position,
      this.type = option.type,
      this._alpha = option.alpha || 1,
      this.url = option.url,
      this.color = option.color,
      this.element = option.element,
      this._rotation = option.rotation,
      this._depth = option.depth,
      this._debugFrustum = Cesium.defaultValue(option.debugFrustum, !0),
      this._aspectRatio = option.aspectRatio || this._getWinWidHei(),
      this._camerafov = option.fov || Cesium.Math.toDegrees(this.viewer.scene.camera.frustum.fov),
      this.texture = option.texture || new Cesium.Texture({
        context: this.viewer.scene.context,
        source: {
          width: 1,
          height: 1,
          arrayBufferView: new Uint8Array([255, 255, 255, 255])
        },
        flipY: !1
      }),
      this.defaultShow = Cesium.defaultValue(option.show, !0),
    !this.cameraPosition || !this.position) return void console.log('初始化失败：请确认相机位置与视点位置正确!');
    switch (this.type) {
      default:
      case this.optionType.Video:
        this.activeVideo(this.url);
        break;
      case this.optionType.Image:
        this.activePicture(this.url);
        this.deActiveVideo();
        break;
      case this.optionType.Color:
        this.activeColor(this.color);
        this.deActiveVideo();
    }
    this._createShadowMap();
    this._getOrientation();
    this._addCameraFrustum();
    this._addPostProcess();
    this.viewer.scene.primitives.add(this);
  };
  //初始化参数
  CesiumVideoShadow.prototype._initCameraParam = function () {
    let viewPoint = this.ECEF.enu_to_ecef(
      {
        longitude: this.param.position.x * 1,
        latitude: this.param.position.y * 1,
        altitude: this.param.position.z * 1
      },
      {
        distance: this.param.far,
        azimuth: this.param.rotation.y * 1,
        elevation: this.param.rotation.x * 1
      });
    let position = Cesium.Cartesian3.fromDegrees(viewPoint.longitude, viewPoint.latitude, viewPoint.altitude);
    let cameraPosition = Cesium.Cartesian3.fromDegrees(this.param.position.x * 1, this.param.position.y * 1, this.param.position.z * 1);
    return {
      type: 3,
      url: this.param.url,
      cameraPosition: cameraPosition,
      position: position,
      alpha: this.param.alpha,
      near: this.param.near,
      fov: this.param.fov,
      debugFrustum: this.param.debugFrustum,
      element: this.param.element,
      aspectRatio: this.param.aspectRatio,
      rotation: this.param.rotation,
      depth: this.param.depth,
    }
  };
  //类定义
  Object.defineProperties(CesiumVideoShadow.prototype, {
    cameraPosition: {
      get: function () {
        return this._cameraPosition;
      },
      set: function (e) {
        this._cameraPosition = e;
        this._changeCameraPosition(e);
      }
    },
    position: {
      get: function () {
        return this._position;
      },
      set: function (e) {
        this._position = e;
        this._changeViewPos();
      }
    },
    aspectRatio: {
      get: function () {
        return this._aspectRatio;
      },
      set: function (e) {
        this._aspectRatio = e;
        this._changeVideoWidHei();
      }
    },
    fov: {
      get: function () {
        return this._camerafov;
      },
      set: function (e) {
        this._camerafov = e;
        this._changeCameraFov();
      }
    },
    rotation: {
      set: function (e) {
        this._changeRotation(e);
      }
    },
    far: {
      get: function () {
        return this._far;
      },
      set: function (e) {
        this._far = e;
        this._changeFar(e);
      }
    },
    near: {
      get: function () {
        return this._near;
      },
      set: function (e) {
        this._near = e;
        this._changeNear(e);
      }
    },
    alpha: {
      get: function () {
        return this._alpha;
      },
      set: function (e) {
        this._alpha = e;
      }
    },
    debugFrustum: {
      get: function () {
        return this._debugFrustum;
      },
      set: function (e) {
        this._debugFrustum = e;
        this.cameraFrustum.show = e;
      }
    },
    show: {
      get: function () {
        return this.defaultShow;
      },
      set: function (e) {
        this.defaultShow = Boolean(e);
        this._switchShow();
      }
    },
    params: {
      get: function () {
        let t = {};
        t.type = this.type;
        // this.type === this.optionType.Color ? t.color = this.color : t.url = this.url;
        t.position = this.position;
        t.cameraPosition = this.cameraPosition;
        t.fov = this.fov;
        t.aspectRatio = this.aspectRatio;
        t.alpha = this.alpha;
        t.debugFrustum = this.debugFrustum;
        return t
      }
    },
  });
  //更新相机坐标
  CesiumVideoShadow.prototype._changeViewPos = function () {
    this.viewer.scene.postProcessStages.remove(this.postProcess);
    this.viewer.scene.primitives.remove(this.cameraFrustum);
    this.viewShadowMap.destroy();
    this.cameraFrustum.destroy();
    this._createShadowMap(this.cameraPosition, this.position);
    this._getOrientation();
    this._addCameraFrustum();
    this._addPostProcess();
  };
  //更新相机位置
  CesiumVideoShadow.prototype._changeCameraPosition = function (e) {
    if (e) {
      this.param.position = e;
      let option = this._initCameraParam();
      this.viewer.scene.postProcessStages.remove(this.postProcess);
      this.viewer.scene.primitives.remove(this.cameraFrustum);
      this.viewShadowMap.destroy();
      this.cameraFrustum.destroy();
      this._createShadowMap(option.cameraPosition, option.position);
      this._getOrientation();
      this._addCameraFrustum();
      this._addPostProcess();
    }
  };
  //获取三维地图容器像素大小
  CesiumVideoShadow.prototype._getWinWidHei = function () {
    let viewer = this.viewer.scene;
    return viewer.canvas.clientWidth / viewer.canvas.clientHeight;
  };
  //更新相机画面比例
  CesiumVideoShadow.prototype._changeVideoWidHei = function () {
    this.viewer.scene.postProcessStages.remove(this.postProcess);
    this.viewer.scene.primitives.remove(this.cameraFrustum);
    this._createShadowMap(this.cameraPosition, this.position);
    this._getOrientation();
    this._addCameraFrustum();
    this._addPostProcess();
  };
  //更新视场角
  CesiumVideoShadow.prototype._changeCameraFov = function () {
    this.viewer.scene.postProcessStages.remove(this.postProcess);
    this.viewer.scene.primitives.remove(this.cameraFrustum);
    this._createShadowMap(this.cameraPosition, this.position);
    this._getOrientation();
    this._addCameraFrustum();
    this._addPostProcess();
  };
  //更新相机heading\pitch\roll三个姿态参数
  CesiumVideoShadow.prototype._changeRotation = function (e) {
    if (e) {
      this.param.rotation = e;
      let option = this._initCameraParam();
      this.position = option.position;
      this._rotation = option.rotation;
      this.camera.setView({
        destination: this.cameraPosition,
        orientation: {
          heading: Cesium.Math.toRadians(this._rotation.y),// east, default value is 0.0 (north)
          pitch: Cesium.Math.toRadians(this._rotation.x),// default value (looking down)
          roll: Cesium.Math.toRadians(this._rotation.r)// default value
        }
      });
    }
  };
  //更新视距
  CesiumVideoShadow.prototype._changeFar = function (e) {
    if (e) {
      this.param.far = e;
      let option = this._initCameraParam();
      this.position = option.position;
    }
  };
  //更新焦距
  CesiumVideoShadow.prototype._changeNear = function (e) {
    if (e) {
      this.param.near = e;
      let option = this._initCameraParam();
      this.position = option.position;
    }
  };
  //切换视频投影显示
  CesiumVideoShadow.prototype._switchShow = function () {
    this.show ? !this.postProcess && this._addPostProcess() : (this.viewer.scene.postProcessStages.remove(this.postProcess), delete this.postProcess, this.postProcess = null);
    this.cameraFrustum.show = this.show;
  };

  /** 视频投射
   * @param {String} url 视频地址
   */
  CesiumVideoShadow.prototype.activeVideo = function (url) {
    let video = this.element, that = this;
    if (video) {
      this.type = that.optionType.Video;
      let viewer = this.viewer;
      this.activeVideoListener || (this.activeVideoListener = function () {
        that.videoTexture && that.videoTexture.destroy();
        that.videoTexture = new Cesium.Texture({
          context: viewer.scene.context,
          source: video,
          width: 1,
          height: 1,
          pixelFormat: Cesium.PixelFormat.RGBA,
          pixelDatatype: Cesium.PixelDatatype.UNSIGNED_BYTE
        })
      });
      viewer.clock.onTick.addEventListener(this.activeVideoListener)
    }
  };
  CesiumVideoShadow.prototype.deActiveVideo = function () {
    if (this.activeVideoListener) {
      this.viewer.clock.onTick.removeEventListener(this.activeVideoListener);
      delete this.activeVideoListener
    }
  };
  /** 图片投放
   * @param {String} url 图片地址
   **/
  CesiumVideoShadow.prototype.activePicture = function (url) {
    this.videoTexture = this.texture;
    let that = this, img = new Image;
    img.onload = function () {
      that.type = that.optionType.Image;
      that.videoTexture = new Cesium.Texture({
        context: that.viewer.scene.context,
        source: img
      });
    };
    img.onerror = function () {
      console.log('图片加载失败:' + url)
    };
    img.src = url
  };
  CesiumVideoShadow.prototype.locate = function () {
    let cameraPosition = Cesium.clone(this.cameraPosition), position = Cesium.clone(this.position);
    this.viewer.Camera.position = cameraPosition;
    this.viewer.camera.direction = Cesium.Cartesian3.subtract(position, cameraPosition, new Cesium.Cartesian3(0, 0, 0));
    this.viewer.camera.up = Cesium.Cartesian3.normalize(cameraPosition, new Cesium.Cartesian3(0, 0, 0));
  };
  CesiumVideoShadow.prototype.update = function (e) {
    this.viewShadowMap && this.viewer.scene.frameState.shadowMaps.push(this.viewShadowMap) // *重点* 多投影
  };
  // 创建shadowmap
  CesiumVideoShadow.prototype._createShadowMap = function () {
    let e = this.cameraPosition,
      t = this.position,
      i = this.viewer.scene;
    let camera = new Cesium.Camera(i);
    camera.setView({
      destination: this.cameraPosition,
      orientation: {
        heading: Cesium.Math.toRadians(this._rotation.y),// east, default value is 0.0 (north)
        pitch: Cesium.Math.toRadians(this._rotation.x),// default value (looking down)
        roll: Cesium.Math.toRadians(this._rotation.r)// default value
      }
    });
    let n = Cesium.Cartesian3.distance(t, e);
    camera.frustum = new Cesium.PerspectiveFrustum({
      fov: Cesium.Math.toRadians(this.fov),
      aspectRatio: this.aspectRatio,
      near: this._near,
      far: n
    });
    this.camera = camera;
    this.viewShadowMap = new Cesium.ShadowMap({
      lightCamera: camera,
      enable: !1,
      isPointLight: !1,
      isSpotLight: !0,
      cascadesEnabled: !1,
      context: i.context,
      pointLightRadius: n,
      darkness: 1.
    })
  };
  // 获取shadowmap位置
  CesiumVideoShadow.prototype._getOrientation = function () {
    let e = this.cameraPosition,
      t = this.position,
      i = Cesium.Cartesian3.normalize(Cesium.Cartesian3.subtract(t, e, new Cesium.Cartesian3), new Cesium.Cartesian3),
      a = Cesium.Cartesian3.normalize(e, new Cesium.Cartesian3),
      n = new Cesium.Camera(this.viewer.scene);
    n.position = e;
    n.direction = i;
    n.up = a;
    i = n.directionWC;
    a = n.upWC;
    let r = n.rightWC,
      o = new Cesium.Cartesian3,
      l = new Cesium.Matrix3,
      u = new Cesium.Quaternion;
    r = Cesium.Cartesian3.negate(r, o);
    let d = l;
    Cesium.Matrix3.setColumn(d, 0, r, d);
    Cesium.Matrix3.setColumn(d, 1, a, d);
    Cesium.Matrix3.setColumn(d, 2, i, d);
    let c = Cesium.Quaternion.fromRotationMatrix(d, u);

    this.orientation = c;
    return c;
  };
  //创建视锥
  CesiumVideoShadow.prototype._addCameraFrustum = function () {
    this.cameraFrustum = new Cesium.Primitive({
      geometryInstances: new Cesium.GeometryInstance({
        geometry: new Cesium.FrustumOutlineGeometry({
          origin: this.cameraPosition,
          orientation: this.orientation,
          frustum: this.viewShadowMap._lightCamera.frustum,
          _drawNearPlane: !0
        }),
        attributes: {
          color: Cesium.ColorGeometryInstanceAttribute.fromColor(new Cesium.Color(0, 0.5, 0.5))
        }
      }),
      appearance: new Cesium.PerInstanceColorAppearance({
        translucent: !1,
        flat: !0
      }),
      asynchronous: !1,
      show: this.debugFrustum && this.show
    });
    this.viewer.scene.primitives.add(this.cameraFrustum);
  };
  //材质shader
  let CesiumVideoShadowShader =
    "\r\n\r\n\r\n\r\nuniform float mixNum; " +
    "\r\nuniform sampler2D colorTexture; " +
    "\r\nuniform sampler2D stcshadow; " +
    "\r\nuniform sampler2D videoTexture; " +
    "\r\nuniform sampler2D depthTexture; " +
    "\r\nuniform mat4 _shadowMap_matrix; " +
    "\r\nuniform vec4 shadowMap_lightPositionEC; " +
    "\r\nuniform vec4 shadowMap_normalOffsetScaleDistanceMaxDistanceAndDarkness; " +
    "\r\nuniform vec4 shadowMap_texelSizeDepthBiasAndNormalShadingSmooth; " +
    "\r\nvarying vec2 v_textureCoordinates;" +
    "\r\nuniform float shadowMap_depth;" +
    "\r\nvec4 toEye(in vec2 uv, in float depth){" +
    "\r\n    vec2 xy = vec2((uv.x * 2.0 - 1.0),(uv.y * 2.0 - 1.0));" +
    "\r\n    vec4 posInCamera =czm_inverseProjection * vec4(xy, depth, 1.0);" +
    "\r\n    posInCamera =posInCamera / posInCamera.w;" +
    "\r\n    return posInCamera;" +
    "\r\n}" +
    "\r\nfloat getDepth(in vec4 depth){" +
    "\r\n    float z_window = czm_unpackDepth(depth);" +
    "\r\n    z_window = czm_reverseLogDepth(z_window);" +
    "\r\n    float n_range = czm_depthRange.near;" +
    "\r\n    float f_range = czm_depthRange.far;" +
    "\r\n    return (2.0 * z_window - n_range - f_range) / (f_range - n_range);" +
    "\r\n}" +
    "\r\nfloat _czm_sampleShadowMap(sampler2D shadowMap, vec2 uv){" +
    "\r\n    return texture2D(shadowMap, uv).r;" +
    "\r\n}" +
    "\r\nfloat _czm_shadowDepthCompare(sampler2D shadowMap, vec2 uv, float depth){" +
    "\r\n    return step(depth, _czm_sampleShadowMap(shadowMap, uv));" +
    "\r\n}" +
    "\r\nfloat _czm_shadowVisibility(sampler2D shadowMap, czm_shadowParameters shadowParameters){" +
    "\r\n    float depthBias = shadowParameters.depthBias;" +
    "\r\n    float depth = shadowParameters.depth;" +
    "\r\n    float nDotL = shadowParameters.nDotL;" +
    "\r\n    float normalShadingSmooth = shadowParameters.normalShadingSmooth;" +
    "\r\n    float darkness = shadowParameters.darkness;" +
    "\r\n    vec2 uv = shadowParameters.texCoords;" +
    "\r\n    depth -= depthBias;" +
    "\r\n    vec2 texelStepSize = shadowParameters.texelStepSize;" +
    "\r\n    float radius = 1.0;" +
    "\r\n    float dx0 = -texelStepSize.x * radius;" +
    "\r\n    float dy0 = -texelStepSize.y * radius;" +
    "\r\n    float dx1 = texelStepSize.x * radius;" +
    "\r\n    float dy1 = texelStepSize.y * radius;" +
    "\r\n    float visibility = " +
    "\r\n    (" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv, depth)" +
    "\r\n    +_czm_shadowDepthCompare(shadowMap, uv + vec2(dx0, dy0), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(0.0, dy0), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(dx1, dy0), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(dx0, 0.0), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(dx1, 0.0), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(dx0, dy1), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(0.0, dy1), depth) +" +
    "\r\n    _czm_shadowDepthCompare(shadowMap, uv + vec2(dx1, dy1), depth)" +
    "\r\n    ) * (1.0 / 9.0)" +
    "\r\n    ;" +
    "\r\n    return visibility;" +
    "\r\n}" +
    "\r\nvec3 pointProjectOnPlane(in vec3 planeNormal, in vec3 planeOrigin, in vec3 point){" +
    "\r\n    vec3 v01 = point -planeOrigin;" +
    "\r\n    float d = dot(planeNormal, v01) ;" +
    "\r\n    return (point - planeNormal * d);" +
    "\r\n}" +
    "\r\nfloat ptm(vec3 pt){" +
    "\r\n    return sqrt(pt.x*pt.x + pt.y*pt.y + pt.z*pt.z);" +
    "\r\n}" +
    "\r\nvoid main() " +
    "\r\n{ " +
    "\r\n    const float PI = 3.141592653589793;" +
    "\r\n    vec4 color = texture2D(colorTexture, v_textureCoordinates);" +
    "\r\n    vec4 currD = texture2D(depthTexture, v_textureCoordinates);" +
    "\r\n    if(currD.r>=1.0){" +
    "\r\n        gl_FragColor = color;" +
    "\r\n        return;" +
    "\r\n    }" +
    "\r\n    " +
    "\r\n    float depth = getDepth(currD);" +
    "\r\n    vec4 positionEC = toEye(v_textureCoordinates, depth);" +
    "\r\n    vec3 normalEC = vec3(1.0);" +
    "\r\n    czm_shadowParameters shadowParameters; " +
    "\r\n    shadowParameters.texelStepSize = shadowMap_texelSizeDepthBiasAndNormalShadingSmooth.xy; " +
    "\r\n    shadowParameters.depthBias = shadowMap_texelSizeDepthBiasAndNormalShadingSmooth.z; " +
    "\r\n    shadowParameters.normalShadingSmooth = shadowMap_texelSizeDepthBiasAndNormalShadingSmooth.w; " +
    "\r\n    shadowParameters.darkness = shadowMap_normalOffsetScaleDistanceMaxDistanceAndDarkness.w; " +
    "\r\n    shadowParameters.depthBias *= max(depth * 0.01, 1.0); " +
    "\r\n    vec3 directionEC = normalize(positionEC.xyz - shadowMap_lightPositionEC.xyz); " +
    "\r\n    float nDotL = clamp(dot(normalEC, -directionEC), 0.0, 1.0); " +
    "\r\n    vec4 shadowPosition = _shadowMap_matrix * positionEC; " +
    "\r\n    shadowPosition /= shadowPosition.w; " +
    "\r\n    if (any(lessThan(shadowPosition.xyz, vec3(0.0))) || any(greaterThan(shadowPosition.xyz, vec3(1.0)))) " +
    "\r\n    { " +
    "\r\n        gl_FragColor = color;" +
    "\r\n        return;" +
    "\r\n    }" +
    "\r\n\r\n    shadowParameters.texCoords = shadowPosition.xy; " +
    "\r\n    shadowParameters.depth = shadowPosition.z - shadowMap_depth; " +
    "\r\n    shadowParameters.nDotL = nDotL; " +
    "\r\n    float visibility = _czm_shadowVisibility(stcshadow, shadowParameters); " +
    "\r\n\r\n    vec4 videoColor = texture2D(videoTexture,shadowPosition.xy);" +
    "\r\n    if(visibility==1.0){" +
    "\r\n        gl_FragColor = mix(color,vec4(videoColor.xyz,1.0),mixNum*videoColor.a);" +
    "\r\n    }else{" +
    "\r\n        if(abs(shadowPosition.z-0.0)<0.01){" +
    "\r\n            return;" +
    "\r\n        }" +
    "\r\n        gl_FragColor = color;" +
    "\r\n    }" +
    "\r\n} ";
  //后处理方法
  CesiumVideoShadow.prototype._addPostProcess = function () {
    let e = this,
      t = CesiumVideoShadowShader,
      i = e.viewShadowMap._isPointLight ? e.viewShadowMap._pointBias : e.viewShadowMap._primitiveBias;
    this.postProcess = new Cesium.PostProcessStage({
      fragmentShader: t,
      uniforms: {
        mixNum: function () {
          return e.alpha
        },
        stcshadow: function () {
          return e.viewShadowMap._shadowMapTexture
        },
        videoTexture: function () {
          return e.videoTexture
        },
        _shadowMap_matrix: function () {
          return e.viewShadowMap._shadowMapMatrix
        },
        shadowMap_lightPositionEC: function () {
          return e.viewShadowMap._lightPositionEC
        },
        shadowMap_texelSizeDepthBiasAndNormalShadingSmooth: function () {
          let t = new Cesium.Cartesian2;
          t.x = 1 / e.viewShadowMap._textureSize.x;
          t.y = 1 / e.viewShadowMap._textureSize.y;
          return Cesium.Cartesian4.fromElements(t.x, t.y, i.depthBias, i.normalShadingSmooth, this.combinedUniforms1)
        },
        shadowMap_normalOffsetScaleDistanceMaxDistanceAndDarkness: function () {
          return Cesium.Cartesian4.fromElements(i.normalOffsetScale, e.viewShadowMap._distance, e.viewShadowMap.maximumDistance, e.viewShadowMap._darkness, this.combinedUniforms2)
        },
        shadowMap_depth: function () {
          return e._depth
        },
      }
    });
    this.viewer.scene.postProcessStages.add(this.postProcess);
  };
  //销毁清除视频投影
  CesiumVideoShadow.prototype.destroy = function () {
    this.viewer.scene.postProcessStages.remove(this.postProcess);
    this.viewer.scene.primitives.remove(this.cameraFrustum);
    this.activeVideoListener && this.viewer.clock.onTick.removeEventListener(this.activeVideoListener);
    this.activeVideoListener && delete this.activeVideoListener;
    this.viewer.scene.primitives.remove(this);
  };

  return CesiumVideoShadow;
})();

export default CesiumVideoShadow;
