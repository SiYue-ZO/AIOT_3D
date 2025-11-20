//随机生成十六进制颜色
function randomHexColor() {
  let hex = Math.floor(Math.random() * 16777216).toString(16); //生成ffffff以内16进制数
  while (hex.length < 6) { //while循环判断hex位数，少于6位前面加0凑够6位
    hex = '0' + hex;
  }
  return '#' + hex; //返回‘#'开头16进制颜色
}

Array.prototype.getRandomItem = function () {
  return this[Math.floor(Math.random() * this.length)];
};

//字符串数据转数字字符串
export function stringToNumber(stringInput) {
  let stringArray = stringInput.split(",");
  let numberArrayOutput = [];
  for (let i = 0; i < stringArray.length; i++) {
    numberArrayOutput.push(Number(stringArray[i]));
  }
  return numberArrayOutput;
}

//截取字符串，返回经度数值，cj添加,mty改为判断
function substringLon(str) {
  let lon, lon1, lon2;
  if (str.toString().substring(0, 1) !== '1') {
    lon1 = str.toString().substring(0, 2);
    lon2 = str.toString().substring(2);
  } else {
    lon1 = str.toString().substring(0, 3);
    lon2 = str.toString().substring(3);
  }
  if (str.indexOf('.') === -1) {
    lon = Number(lon1 + "." + lon2);
  } else {
    lon = Number(lon1 + lon2);
  }
  return lon;
}

//截取字符串，返回纬度数值，cj添加
function substringLat(str) {
  let lat1 = str.toString().substring(0, 2);
  let lat2 = str.toString().substring(2);
  let lat;
  if (str.indexOf('.') === -1) {
    lat = Number(lat1 + "." + lat2);
  } else {
    lat = Number(lat1 + lat2);
  }
  return lat;
}

//定义一些常量
let x_PI = 3.14159265358979324 * 3000.0 / 180.0;
let C_PI = 3.1415926535897932384626;
let a = 6378245.0;
let ee = 0.00669342162296594323;

//将WGS84坐标系，转换成百度坐标体系
function wgs84tobd09(lon, lat) {
  let gcj02poi1 = wgs84togcj02(lon, lat);
  let baidupoi1 = gcj02tobd09(gcj02poi1[0], gcj02poi1[1]);
  return baidupoi1;
}

//将百度坐标体系，转换成WGS84坐标系
export function bd09towgs84(lon, lat) {
  let gcj02poi1 = bd09togcj02(lon, lat);
  let wgs84poi1 = gcj02towgs84(gcj02poi1[0], gcj02poi1[1]);
  return wgs84poi1;
}

/**
 * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换
 * 即 百度 转 谷歌、高德
 * @param bd_lon
 * @param bd_lat
 * @returns {*[]}
 */
function bd09togcj02(bd_lon, bd_lat) {
  let x_pi = 3.14159265358979324 * 3000.0 / 180.0;
  let x = bd_lon - 0.0065;
  let y = bd_lat - 0.006;
  let z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
  let theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
  let gg_lng = z * Math.cos(theta);
  let gg_lat = z * Math.sin(theta);
  return [gg_lng, gg_lat];
}

/**
 * GCJ02 转换为 WGS84
 * @param lng
 * @param lat
 * @returns {*[]}
 */
function gcj02towgs84(lng, lat) {
  if (out_of_china(lng, lat)) {
    return [lng, lat];
  } else {
    let dlat = transformlat(lng - 105.0, lat - 35.0);
    let dlng = transformlng(lng - 105.0, lat - 35.0);
    let radlat = lat / 180.0 * C_PI;
    let magic = Math.sin(radlat);
    magic = 1 - ee * magic * magic;
    let sqrtmagic = Math.sqrt(magic);
    dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * C_PI);
    dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * C_PI);
    let mglat = lat + dlat;
    let mglng = lng + dlng;
    return [lng * 2 - mglng, lat * 2 - mglat];
  }
}

//WGS84转GCj02
function wgs84togcj02(lng, lat) {
  if (out_of_china(lng, lat)) {
    return [lng, lat];
  } else {
    let dlat = transformlat(lng - 105.0, lat - 35.0);
    let dlng = transformlng(lng - 105.0, lat - 35.0);
    let radlat = lat / 180.0 * C_PI;
    let magic = Math.sin(radlat);
    magic = 1 - ee * magic * magic;
    let sqrtmagic = Math.sqrt(magic);
    dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * C_PI);
    dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * C_PI);
    let mglat = lat + dlat;
    let mglng = lng + dlng;
    return [mglng, mglat];
  }
}

/**
 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换
 * 即谷歌、高德 转 百度
 * @param lng
 * @param lat
 * @returns {*[]}
 */
function gcj02tobd09(lng, lat) {
  let z = Math.sqrt(lng * lng + lat * lat) + 0.00002 * Math.sin(lat * x_PI);
  let theta = Math.atan2(lat, lng) + 0.000003 * Math.cos(lng * x_PI);
  let bd_lng = z * Math.cos(theta) + 0.0065;
  let bd_lat = z * Math.sin(theta) + 0.006;
  return [bd_lng, bd_lat]
}

/**
 * 判断是否在国内，不在国内则不做偏移
 * @param lng
 * @param lat
 * @returns {boolean}
 */
function out_of_china(lng, lat) {
  return (lng < 72.004 || lng > 137.8347) || ((lat < 0.8293 || lat > 55.8271) || false);
}

function transformlat(lng, lat) {
  let ret = -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat + 0.2 * Math.sqrt(Math.abs(lng));
  ret += (20.0 * Math.sin(6.0 * lng * C_PI) + 20.0 * Math.sin(2.0 * lng * C_PI)) * 2.0 / 3.0;
  ret += (20.0 * Math.sin(lat * C_PI) + 40.0 * Math.sin(lat / 3.0 * C_PI)) * 2.0 / 3.0;
  ret += (160.0 * Math.sin(lat / 12.0 * C_PI) + 320 * Math.sin(lat * C_PI / 30.0)) * 2.0 / 3.0;
  return ret
}

function transformlng(lng, lat) {
  let ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt(Math.abs(lng));
  ret += (20.0 * Math.sin(6.0 * lng * C_PI) + 20.0 * Math.sin(2.0 * lng * C_PI)) * 2.0 / 3.0;
  ret += (20.0 * Math.sin(lng * C_PI) + 40.0 * Math.sin(lng / 3.0 * C_PI)) * 2.0 / 3.0;
  ret += (150.0 * Math.sin(lng / 12.0 * C_PI) + 300.0 * Math.sin(lng / 30.0 * C_PI)) * 2.0 / 3.0;
  return ret
}

/**
 * approx distance between two points on earth ellipsoid
 * @param {Object} lat1
 * @param {Object} lng1
 * @param {Object} lat2
 * @param {Object} lng2
 */
let EARTH_RADIUS = 6378137.0; //单位M
let E_PI = Math.PI;

function getRad(d) {
  return d * E_PI / 180.0;
}

export function getFlatternDistance(lng1, lat1, lng2, lat2) {
  let f = getRad((lat1 + lat2) / 2);
  let g = getRad((lat1 - lat2) / 2);
  let l = getRad((lng1 - lng2) / 2);

  let sg = Math.sin(g);
  let sl = Math.sin(l);
  let sf = Math.sin(f);

  let s,
    c,
    w,
    r,
    d,
    h1,
    h2;
  let a = EARTH_RADIUS;
  let fl = 1 / 298.257;

  sg = sg * sg;
  sl = sl * sl;
  sf = sf * sf;

  s = sg * (1 - sl) + (1 - sf) * sl;
  c = (1 - sg) * (1 - sl) + sf * sl;

  w = Math.atan(Math.sqrt(s / c));
  r = Math.sqrt(s * c) / w;
  d = 2 * w * a;
  h1 = (3 * r - 1) / 2 / c;
  h2 = (3 * r + 1) / 2 / s;

  return d * (1 + fl * (h1 * sf * (1 - sg) - h2 * (1 - sf) * sg));
}

/**
 *  判断一个点是否在多边形内部
 *  @param points 多边形坐标集合
 *  @param testPoint 需检测点坐标
 *  返回true为真，false为假
 *  */
export function insidePolygon(points, testPoint) {
  let x = testPoint[0],
    y = testPoint[1];
  let inside = false;
  for (let i = 0, j = points.length - 1; i < points.length; j = i++) {
    let xi = points[i][0],
      yi = points[i][1];
    let xj = points[j][0],
      yj = points[j][1];

    let intersect = ((yi > y) !== (yj > y))
      && (x < (xj - xi) * (y - yi) / (yj - yi) + xi);
    if (intersect)
      inside = !inside;
  }
  return inside;
}

/**
 * 将秒转换为 分:秒
 * s int 秒数
 */
export function s_to_hs(s) {
  //计算分钟
  //算法：将秒数除以60，然后下舍入，既得到分钟数
  let h;
  h = Math.floor(s / 60);
  //计算秒
  //算法：取得秒%60的余数，既得到秒数
  s = s % 60;
  //将变量转换为字符串
  h += '';
  s += '';
  //如果只有一位数，前面增加一个0
  h = (h.length === 1) ? '0' + h : h;
  s = (s.length === 1) ? '0' + s : s;
  return h + ':' + s;
}

//判断点是否在另一平面图中
//点: { x: xxx, y: xxx }
//线: [{ x: xxx, y: xxx }, { x: xxx, y: xxx }]
//面: [{ x: xxx, y: xxx }, { x: xxx, y: xxx }, { x: xxx, y: xxx }...]
function isPointInPolygon(point, polygon) {
  //下述代码来源：http://paulbourke.net/geometry/insidepoly/，进行了部分修改
  //基本思想是利用射线法，计算射线与多边形各边的交点，如果是偶数，则点在多边形外，否则
  //在多边形内。还会考虑一些特殊情况，如点在多边形顶点上，点在多边形边上等特殊情况。

  let N = polygon.length;
  let boundOrVertex = true; //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
  let intersectCount = 0; //cross points count of x
  let precision = 2e-10; //浮点类型计算时候与0比较时候的容差
  let p1, p2; //neighbour bound vertices
  let p = point; //测试点

  p1 = polygon[0]; //left vertex
  for (let i = 1; i <= N; ++i) { //check all rays
    if (p.x === p1.x && p.y === p1.y) {
      return boundOrVertex; //p is an vertex
    }

    p2 = polygon[i % N]; //right vertex
    if (p.y < Math.min(p1.y, p2.y) || p.y > Math.max(p1.y, p2.y)) { //ray is outside of our interests
      p1 = p2;
      continue; //next ray left point
    }

    if (p.y > Math.min(p1.y, p2.y) && p.y < Math.max(p1.y, p2.y)) { //ray is crossing over by the algorithm (common part of)
      if (p.x <= Math.max(p1.x, p2.x)) { //x is before of ray
        if (p1.y === p2.y && p.x >= Math.min(p1.x, p2.x)) { //overlies on a horizontal ray
          return boundOrVertex;
        }

        if (p1.x === p2.x) { //ray is vertical
          if (p1.x === p.x) { //overlies on a vertical ray
            return boundOrVertex;
          } else { //before ray
            ++intersectCount;
          }
        } else { //cross point on the left side
          let xinters = (p.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x; //cross point of x
          if (Math.abs(p.x - xinters) < precision) { //overlies on a ray
            return boundOrVertex;
          }

          if (p.x < xinters) { //before ray
            ++intersectCount;
          }
        }
      }
    } else { //special case when ray is crossing through the vertex
      if (p.y === p2.y && p.x <= p2.x) { //p crossing over p2
        let p3 = polygon[(i + 1) % N]; //next vertex
        if (p.y >= Math.min(p1.y, p3.y) && p.y <= Math.max(p1.y, p3.y)) { //p.y lies between p1.y & p3.y
          ++intersectCount;
        } else {
          intersectCount += 2;
        }
      }
    }
    p1 = p2; //next ray left point
  }

  if (intersectCount % 2 === 0) { //偶数在多边形外
    return false;
  } else { //奇数在多边形内
    return true;
  }
}

//判断两多变形是否存在点与区域的包含关系(A的点在B的区域内或B的点在A的区域内)
export function isPointInPolygonBidirectional(plyA, plyB) {
  let [a, b] = [false, false];
  a = plyA.some(item => isPointInPolygon(item, plyB));
  if (!a) {
    b = plyB.some(item => isPointInPolygon(item, plyA));
  }
  return a || b;
}

//根据两点坐标计算方位角
export function azimuthtwopoi(x1, y1, x2, y2) {
  let result;
  let a = Math.abs(Math.atan((y2 - y1) / (x2 - x1))) * 180 / Math.PI;
  if ((x2 - x1) < 0) {
    if ((y2 - y1) > 0) {
      result = a + 270;
    } else {
      result = 90 - a + 180;
    }
  } else {
    if ((y2 - y1) > 0) {
      result = 90 - a;
    } else {
      result = a + 90;
    }
  }
  return result;
}

//获取立方体中心点、方位角、边线长度
export function fixtoboxvertex(floorPoiStrArr) {
  let oriLonArr = [], oriLatArr = [];
  for (let i = 0; i < 12; i = i + 3) {
    oriLonArr.push(Number(floorPoiStrArr[i]));
    oriLatArr.push(Number(floorPoiStrArr[i + 1]));
  }
  oriLonArr.push(Number(floorPoiStrArr[0]));
  oriLatArr.push(Number(floorPoiStrArr[1]));
  let sumLon = 0, sumLat = 0;
  let heading = [], distance = [];
  for (let i = 0; i < oriLonArr.length - 1; i++) {
    sumLon += oriLonArr[i];
    sumLat += oriLatArr[i];
    heading.push(azimuthtwopoi(oriLonArr[i], oriLatArr[i], oriLonArr[i + 1], oriLatArr[i + 1]));
    distance.push(getFlatternDistance(oriLonArr[i], oriLatArr[i], oriLonArr[i + 1], oriLatArr[i + 1]));
  }
  let centerLon = sumLon / 4;
  let centerLat = sumLat / 4;
  return {centerLon, centerLat, heading, distance};
}

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function (fmt) {
  let o = {
    "M+": this.getMonth() + 1, //月份
    "d+": this.getDate(), //日
    "h+": this.getHours() % 12 === 0 ? 12 : this.getHours() % 12, //小时
    "H+": this.getHours(), //小时
    "m+": this.getMinutes(), //分
    "s+": this.getSeconds(), //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds() //毫秒
  };
  let week = {
    "0": "/u65e5",
    "1": "/u4e00",
    "2": "/u4e8c",
    "3": "/u4e09",
    "4": "/u56db",
    "5": "/u4e94",
    "6": "/u516d"
  };
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  if (/(E+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
  }
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
  }
  return fmt;
};

export function randomNumber() {
  let result = (Math.random() * 1000000000).toFixed(0);
  return result;
}

//根据两点，计算姿态
export function getOrientationBy2Point(pointA, pointB) {
  let m = getModelMatrix(pointA, pointB);
  let hpr = getHeadingPitchRoll(m);
  // hpr.pitch = hpr.pitch + 3.14 / 2 + 3.14; //朝前
  return Cesium.Transforms.headingPitchRollQuaternion(pointA, hpr);
}

//根据两点计算姿态矩阵
export function getModelMatrix(pointA, pointB) {
  //向量AB
  const vector2 = Cesium.Cartesian3.subtract(pointB, pointA, new Cesium.Cartesian3());
  //归一化
  const normal = Cesium.Cartesian3.normalize(vector2, new Cesium.Cartesian3());
  //旋转矩阵 rotationMatrixFromPositionVelocity源码中有，并未出现在cesiumAPI中
  const rotationMatrix3 = Cesium.Transforms.rotationMatrixFromPositionVelocity(
    pointA,
    normal,
    Cesium.Ellipsoid.WGS84
  );
  const modelMatrix4 = Cesium.Matrix4.fromRotationTranslation(rotationMatrix3, pointA);
  return modelMatrix4;
}
//根据姿态计算hpr
export function getHeadingPitchRoll(m) {
  let m1 = Cesium.Transforms.eastNorthUpToFixedFrame(
    Cesium.Matrix4.getTranslation(m, new Cesium.Cartesian3()),
    Cesium.Ellipsoid.WGS84,
    new Cesium.Matrix4()
  );
  // 矩阵相除
  let m3 = Cesium.Matrix4.multiply(Cesium.Matrix4.inverse(m1, new Cesium.Matrix4()),
    m,
    new Cesium.Matrix4()
  );
  // 得到旋转矩阵
  let mat3 = Cesium.Matrix4.getMatrix3(m3, new Cesium.Matrix3());// 计算四元数
  let q = Cesium.Quaternion.fromRotationMatrix(mat3);// 计算旋转角(狐度)
  let hpr = Cesium.HeadingPitchRoll.fromQuaternion(q);
  return hpr;
}
