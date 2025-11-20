(function(window) {
	'use strict';

	function define_CesiumCurvedTrail() {
		//Main object
		var CesiumCurvedTrail = {};

		/*
		 流纹纹理线
		color 颜色
		duration 持续时间 毫秒
		*/
		function PolylineTrailLinkMaterialProperty(color, duration) {
			this._definitionChanged = new Cesium.Event();
			this._color = undefined;
			this._colorSubscription = undefined;
			this.color = color;
			this.duration = duration;
			this._time = (new Date()).getTime();
		}
		Cesium.defineProperties(PolylineTrailLinkMaterialProperty.prototype, {
			isConstant : {
				get : function() {
					return false;
				}
			},
			definitionChanged : {
				get : function() {
					return this._definitionChanged;
				}
			},
			color : Cesium.createPropertyDescriptor('color')
		});
		PolylineTrailLinkMaterialProperty.prototype.getType = function(time) {
			return 'PolylineTrailLink';
		}
		PolylineTrailLinkMaterialProperty.prototype.getValue = function(time, result) {
			if (!Cesium.defined(result)) {
				result = {};
			}
			result.color = Cesium.Property.getValueOrClonedDefault(this._color, time, Cesium.Color.WHITE, result.color);
			result.image = Cesium.Material.PolylineTrailLinkImage;
			result.time = (((new Date()).getTime() - this._time) % this.duration) / this.duration;
			return result;
		}
		PolylineTrailLinkMaterialProperty.prototype.equals = function(other) {
			return this === other ||
				(other instanceof PolylineTrailLinkMaterialProperty &&
				Cesium.Property.equals(this._color, other._color))
		}
		Cesium.PolylineTrailLinkMaterialProperty = PolylineTrailLinkMaterialProperty;
		Cesium.Material.PolylineTrailLinkType = 'PolylineTrailLink';
		Cesium.Material.PolylineTrailLinkImage = "../images/color1.png";
		Cesium.Material.PolylineTrailLinkSource = "czm_material czm_getMaterial(czm_materialInput materialInput)\n\
                                                     {\n\
                                                          czm_material material = czm_getDefaultMaterial(materialInput);\n\
                                                          vec2 st = materialInput.st;\n\
                                                          vec4 colorImage = texture2D(image, vec2(fract(st.s - time), st.t));\n\
                                                          material.alpha = colorImage.a * color.a;\n\
                                                          material.diffuse = (colorImage.rgb+color.rgb)/2.0;\n\
                                                          return material;\n\
                                                      }";
		Cesium.Material._materialCache.addMaterial(Cesium.Material.PolylineTrailLinkType, {
			fabric : {
				type : Cesium.Material.PolylineTrailLinkType,
				uniforms : {
					color : new Cesium.Color(1.0, 0.0, 0.0, 0.5),
					image : Cesium.Material.PolylineTrailLinkImage,
					time : 0
				},
				source : Cesium.Material.PolylineTrailLinkSource
			},
			translucent : function(material) {
				return true;
			}
		});

		function parabolaEquation(options, resultOut) {
			//方程 y=-(4h/L^2)*x^2+h h:顶点高度 L：横纵间距较大者
			var h = options.height && options.height < 5000 ? options.height : 5000;
			var L = Math.abs(options.pt1.lon - options.pt2.lon) > Math.abs(options.pt1.lat - options.pt2.lat) ? Math.abs(options.pt1.lon - options.pt2.lon) : Math.abs(options.pt1.lat - options.pt2.lat);
			var num = options.num && options.num > 50 ? options.num : 50;
			var result = [];
			var dlt = L / num;
			if (Math.abs(options.pt1.lon - options.pt2.lon) > Math.abs(options.pt1.lat - options.pt2.lat)) { //以lon为基准
				var delLat = (options.pt2.lat - options.pt1.lat) / num;
				if (options.pt1.lon - options.pt2.lon > 0) {
					dlt = -dlt;
				}
				for (var i = 0; i < num; i++) {
					var tempH = options.baseheight + h - Math.pow((-0.5 * L + Math.abs(dlt) * i), 2) * 4 * h / Math.pow(L, 2);
					var lon = options.pt1.lon + dlt * i;
					var lat = options.pt1.lat + delLat * i;
					result.push([ lon, lat, tempH ]);
				}
			} else { //以lat为基准
				var delLon = (options.pt2.lon - options.pt1.lon) / num;
				if (options.pt1.lat - options.pt2.lat > 0) {
					dlt = -dlt;
				}
				for (var i = 0; i < num; i++) {
					var tempH = options.baseheight + h - Math.pow((-0.5 * L + Math.abs(dlt) * i), 2) * 4 * h / Math.pow(L, 2);
					var lon = options.pt1.lon + delLon * i;
					var lat = options.pt1.lat + dlt * i;
					result.push([ lon, lat, tempH ]);
				}
			}
			if (resultOut != undefined) {
				resultOut = result;
			}
			return result;
		}


		var trailArr = [];
		CesiumCurvedTrail.create = function(options) {
			var viewer = options.viewer;
			var isAdd = false;
			var material = null;
			var center = {
				lon : options.lon,
				lat : options.lat
			}
			var target = {
				"lon" : options.targetlon,
				"lat" : options.targetlat
			};
			if (!isAdd) {
				if (material != null) {
				} else {
					material = new Cesium.PolylineTrailLinkMaterialProperty(Cesium.Color.ORANGE, 3000);
				}
				var points = parabolaEquation({
					pt1 : center,
					pt2 : target,
					baseheight : options.alt,
					height : options.curheight,
					num : 100
				});
				var pointArr = [];
				for (var i = 0; i < points.length; i++) {
					pointArr.push(points[i][0], points[i][1], points[i][2]);
				}
				trailArr.push(
					viewer.entities.add({
						polyline : {
							positions : Cesium.Cartesian3.fromDegreesArrayHeights(pointArr),
							width : 2,
							material : material
						}
					}),
					viewer.entities.add({
						position : Cesium.Cartesian3.fromDegrees(center.lon, center.lat, options.alt),
						point : {
							pixelSize : 6,
							color : Cesium.Color.BLUE
						}
					}),
					viewer.entities.add({
						position : Cesium.Cartesian3.fromDegrees(target.lon, target.lat, options.alt),
						point : {
							pixelSize : 6,
							color : Cesium.Color.RED
						}
					})
				);
				isAdd = true;
			}
		}

		CesiumCurvedTrail.clear = function(viewer) {
			for (var i = 0; i < trailArr.length; i++) {
				viewer.entities.remove(trailArr[i]);
			}
		}

		return CesiumCurvedTrail;
	}

	if (typeof (CesiumCurvedTrail) === 'undefined') {
		window.CesiumCurvedTrail = define_CesiumCurvedTrail();
	} else {
		console.log("CesiumCurvedTrail already defined.");
	}
})(window);
