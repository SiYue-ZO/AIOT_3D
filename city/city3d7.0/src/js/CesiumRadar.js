(function (window) {
	'use strict';

	function define_CesiumRadar(){
		//Main object
		var CesiumRadar = {};
		var CesiumRadarArr = [];
		
		CesiumRadar.create = function(options){
			CesiumRadarArr.push(options.viewer.entities.add({
				id : options.id,
			    position : options.position,
			    orientation : Cesium.Transforms.headingPitchRollQuaternion(options.position,
			        new Cesium.HeadingPitchRoll(
			        		Cesium.Math.toRadians(options.heading),
			        		Cesium.Math.toRadians(options.pitch),
			        		options.roll)
			    ),
			    ellipsoid : {
			        radii : new Cesium.Cartesian3(options.far, options.far, options.far),
			        innerRadii : new Cesium.Cartesian3(options.near, options.near, options.near),
			        minimumClock : Cesium.Math.toRadians(options.heading-options.angle/2),
			        maximumClock : Cesium.Math.toRadians(options.heading+options.angle/2),
			        minimumCone : Cesium.Math.toRadians(90-options.cone),
			        maximumCone : Cesium.Math.toRadians(95),
			        stackPartitions : 32,
			        slicePartitions : 32,
			        material : options.color,
			        outline : true,
			        outlineColor : options.outColor
			    }
			}));
		};
		
		CesiumRadar.remove = function(viewer,id){
			if(viewer.entities.getById(id)){
				viewer.entities.removeById(id);
			}
		};
		
		CesiumRadar.clear = function(viewer){
			for (var i = 0; i < CesiumRadarArr.length; i++) {
				viewer.entities.remove(CesiumRadarArr[i]);
			}
		}
		
		return CesiumRadar;
	}
	
	if (typeof(CesiumRadar) === 'undefined') {
		window.CesiumRadar = define_CesiumRadar();
	} else {
		console.log("CesiumRadar already defined.");
	}
})(window);
