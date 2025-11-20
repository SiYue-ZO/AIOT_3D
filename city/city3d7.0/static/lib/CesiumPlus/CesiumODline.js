//the dynamic line from orgin to direction
(function (window) {
	'use strict';

	function define_CesiumODline(){
		//Main object
		var CesiumODline = {};

		function createFlightLinesApperance(color) {
		    var polylineAppearance = new Cesium.PolylineMaterialAppearance({
		        material: new Cesium.Material({
		            fabric : {
		                type : 'Color',
		                uniforms : {
		                    color : color
		                }
		            },
		            translucent: true
		        })
		    });
		    var renamedVS = Cesium.ShaderSource.replaceMain(polylineAppearance._vertexShaderSource, 'czm_twp_main');
		    var twpMain =
		        'varying vec4 v_twp; \n' +
		        'void main() \n' +
		        '{ \n' +
		        '    czm_twp_main(); \n' +
		        '    v_twp = czm_batchTable_twp(batchId); \n' +
		        '}';
		    polylineAppearance._vertexShaderSource = renamedVS + '\n' + twpMain;
		    var renamedFS = Cesium.ShaderSource.replaceMain(polylineAppearance._fragmentShaderSource, 'czm_twp2_main');
		    var twp2Main =
		        'varying vec4 v_twp; \n' +
		        'void main() \n' +
		        '{ \n' +
		        '    czm_twp2_main(); \n' +
		        '    float t = v_twp.x;' +
		        '    t *= 1.03;' +  //控制飞行速度
		        '    float alpha = smoothstep(t - 0.055, t, v_st.s) * step(-t, -v_st.s); ' + //控制尾迹长度
		        '    alpha += 0.0;' +  //控制轨迹底线的透明度
		        '    alpha *= step(-0.1, -abs(0.5-v_st.t));  ' +
		        '    gl_FragColor.a *= alpha;' +
		        '}';
		    polylineAppearance._fragmentShaderSource = renamedFS + '\n' + twp2Main;
		    return polylineAppearance;
		}

		function createFlightLinesGeometryInstance(positions,width) {
		    var gi = new Cesium.GeometryInstance({
		        geometry: new Cesium.PolylineGeometry({
		            positions: positions,
		            width: width,
		            vertexFormat: Cesium.PolylineMaterialAppearance.VERTEX_FORMAT
		        }),
		        attributes : {
		            twp: new Cesium.GeometryInstanceAttribute({
		                componentDatatype : Cesium.ComponentDatatype.FLOAT,
		                componentsPerAttribute : 4,
		                normalize : false,
		                value : [0.0, 0.5, 1.0, 1.0]
		            })
		        },
		    });
		    return gi;
		}

		function createFlightLinesPrimitive(routePaths,color,tracewidth) {
		    var geometryInstances = [];
		    routePaths.forEach(function (route) {
		    	//线路样式在此分流：连续路径||只有起止点
		        var positions = route.positions || createTransmitPolyline(route.startPos, route.endPos);
		        var gi = createFlightLinesGeometryInstance(positions,tracewidth);
		        geometryInstances.push(gi);
		    });
		    var flightLinesPrimitive = new Cesium.Primitive({
		        geometryInstances: geometryInstances,
		        appearance: createFlightLinesApperance(color)
		    });
		    return flightLinesPrimitive;
		}

		var scratchTWP;
		function getScratchTWP() {
		    if (typeof scratchTWP === 'undefined') {
		        scratchTWP = new Cesium.Cartesian4(0.0, 0.0, 0.0, 0.0);
		    }
		    return scratchTWP;
		}

		function setFlightLinesStatus(flightLinesPrimitive, statusCallback) {
		    var scratchTWP = getScratchTWP();
		    if (typeof flightLinesPrimitive._batchTable !== 'undefined') {
		        //var attributeName = 'color';
		        var attributeName = 'twp';
		        var attributeIndex = flightLinesPrimitive._batchTableAttributeIndices[attributeName];
		        var ni = flightLinesPrimitive._batchTable._numberOfInstances;
		        for (var i = 0; i < ni; ++i) {
		            var instanceIndex = i;
		            statusCallback(instanceIndex, scratchTWP);
		            flightLinesPrimitive._batchTable.setBatchedAttribute(instanceIndex, attributeIndex, scratchTWP);
		        }
		    }
		}

		function addGlowLine(viewer,ODLines,color,linewidth,lineglow){
			var glowLines = [];
			ODLines.forEach(function (line) {
				var glowLine = viewer.entities.add({
	    			polyline : {
	    				positions : line.positions,
	    				width : linewidth,
	    				material : new Cesium.PolylineGlowMaterialProperty({
	    					color : color,
	    					glowPower : lineglow
	    				})
	    			}
	    		});
				glowLines.push(glowLine);
		    });
			return glowLines;
		}

		/*Option = {
				viewer: viewer,
				geoJsonUrl: '../data/busLines.json',
				linecolor: Cesium.Color.GOLD,//ORANGE;//ORANGE;//GOLD;//底线颜色
				linewidth: 8.0,//底线宽度
				lineheight: 500.0,//底线高度
				lineglow: 0.15,//底线光晕宽度
				tracecolor: Cesium.Color.WHITE,//ORANGE;//GOLD;//尾迹线颜色
				tracewidth: 28.0,//尾迹线宽度
				positions: [[Cartesian3,Cartesian3,...],[Cartesian3,...],...],//坐标点数组
				timeDuration: 3.0,//各个尾迹线发出的时间间隔
				moveBaseDuration: 3.0,//各个尾迹线的速度，数值越大越慢
		};*/

		var jsonresult = [];
		CesiumODline.loadGeoJson = function(option){
			var glowlines;
			var flightLinesPrimitive;
			Cesium.Resource.fetchJson(option.geoJsonUrl).then(function(data) {
			    var ODLines = [];
			    data.features.map(function (dataArr, idx) {
			        var points = [];
			        var coords = dataArr.geometry.coordinates;
			        for (var i = 0; i < coords.length; i++) {
			            var cart = Cesium.Cartesian3.fromDegrees(
			            		coords[i][0], coords[i][1], option.lineheight);
			            points.push(cart);
			        }
			        ODLines.push({
			        	positions: points,
			            startTime: option.timeDuration * Math.random(),
			            duration: option.moveBaseDuration + 1.0 * Math.random(),
			        });
			    });
			    flightLinesPrimitive = createFlightLinesPrimitive(ODLines,
			    		option.tracecolor,option.tracewidth);
			    option.viewer.scene.primitives.add(flightLinesPrimitive);
			    glowlines = addGlowLine(option.viewer,ODLines,option.linecolor,
			    		option.linewidth,option.lineglow);

			    var time = 0;
			    var disposeListener = option.viewer.scene.preUpdate.addEventListener(function() {
			        time += 0.01;
			        if (time >= option.timeDuration) {
			            time = 0.0;
			        }
			        setFlightLinesStatus(flightLinesPrimitive, function(instanceIndex, result) {
			            var st = ODLines[instanceIndex].startTime;
			            var dr = ODLines[instanceIndex].duration;
			            var diff = time > st ? time - st : time + option.timeDuration - st;
			            var timeRatio = Math.min(diff / dr, 1.0);

			            Cesium.Cartesian4.fromElements(timeRatio, 0.3, 1.0, 1.0, result);
			        });
			    });
			    jsonresult.push(flightLinesPrimitive,glowlines);
			});
		};

		/*Option = {
				viewer: viewer,
				linecolor: Cesium.Color.GOLD,//ORANGE;//ORANGE;//GOLD;//底线颜色
				linewidth: 8.0,//底线宽度
				lineglow: 0.15,//底线光晕宽度
				tracecolor: Cesium.Color.WHITE,//ORANGE;//GOLD;//尾迹线颜色
				tracewidth: 28.0,//尾迹线宽度
				positions: [[Cartesian3,Cartesian3,...],[Cartesian3,...],...],//坐标点数组
				timeDuration: 3.0,//各个尾迹线发出的时间间隔
				moveBaseDuration: 3.0,//各个尾迹线的速度，数值越大越慢
		};*/
		CesiumODline.add = function(option){
		    var ODLines = [];
		    for ( var i = 0; i < option.positions.length; i++) {
		    	ODLines.push({
		        	positions: option.positions[i],
		        	startTime: option.timeDuration * Math.random(),
		        	duration: option.moveBaseDuration + 1.0 * Math.random(),
		        });
			}

		    var flightLinesPrimitive = createFlightLinesPrimitive(ODLines,
		    		option.tracecolor,option.tracewidth);
		    option.viewer.scene.primitives.add(flightLinesPrimitive);
		    var glowlines = addGlowLine(option.viewer,ODLines,option.linecolor,
		    		option.linewidth,option.lineglow);

		    var time = 0;
		    var disposeListener = option.viewer.scene.preUpdate.addEventListener(function() {
		        time += 0.01;
		        if (time >= option.timeDuration) {
		            time = 0.0;
		        }
		        setFlightLinesStatus(flightLinesPrimitive, function(instanceIndex, result) {
		            var st = ODLines[instanceIndex].startTime;
		            var dr = ODLines[instanceIndex].duration;
		            var diff = time > st ? time - st : time + option.timeDuration - st;
		            var timeRatio = Math.min(diff / dr, 1.0);

		            Cesium.Cartesian4.fromElements(timeRatio, 0.3, 1.0, 1.0, result);
		        });
		    });

			return [flightLinesPrimitive, glowlines];
		};

		CesiumODline.remove = function(viewer, odlines){
			if(odlines.length!==0&&odlines!==undefined){
				viewer.scene.primitives.remove(odlines[0]);
				for ( var i = 0; i < odlines[1].length; i++) {
					viewer.entities.remove(odlines[1][i]);
				}
			}
		};

		CesiumODline.removeJson = function(viewer){
			if(jsonresult.length!==0){
				viewer.scene.primitives.remove(jsonresult[0]);
				for ( var i = 0; i < jsonresult[1].length; i++) {
					viewer.entities.remove(jsonresult[1][i]);
				}
				jsonresult = [];
			}
		};

		return CesiumODline;
	}

	if (typeof(CesiumODline) === 'undefined') {
		window.CesiumODline = define_CesiumODline();
	} else {
		console.log("CesiumODline already defined.");
	}
})(window);
