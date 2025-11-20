import axios from './http.js';

const jsonp = require('jsonp');

//应急指挥-一键接派警信息保存
export const insertEmergencyCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/insertEmergencyCase', {...params}
);

//应急指挥-获取全部接入平台的人员实时位置
export const getRHPCPolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getPoliceRealDateWithManPos', {...params}
);

//应急指挥-获取全部接入平台的车辆实时位置
export const getRHPCCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getPoliceCarRealData', {...params}
);

//案件-获取全部案件信息
export const getCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/getCase', {...params}
);

//案件-根据id获取案件信息
export const getCaseById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/getCaseandNetById', {...params}
);

//案件-根据条件查询案件
export const queryPoliceCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/queryPoliceCase', {...params}
);

//案件-根据id获取案件材料
export const getCaseMaterialById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/getCaseMaterialById', {...params}
);

//车辆-获取所有车辆信息构建目录树
export const getAllCars = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getAllCars', {...params}
);

//车辆-根据车辆卡号查询车辆位置
export const getCarRealgpsByPhone = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getCarRealgpsByPhone', {...params}
);

//车辆-根据车牌号刷新车辆实时定位坐标
export const getPoliceCarRealDataPart = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getPoliceCarRealDataPart', {...params}
);

//车辆-通过车辆id获取单辆车辆详细信息
export const getCarAndEquipmentsByPuid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getCarAndEquipmentsByPuid', {...params}
);

//车辆-获取车辆历史轨迹数据
export const getHisDataByTime = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'gpsHisDataInfo/getHisDataByTime', {...params}
);

//车辆-见警率统计-获取见警率统计所需的车辆热力图数据-暂时使用Demo数据表达效果
export const getCarHeatmap = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'gpsHisDataInfo/getHisDataAllByTime', {...params}
);

//车辆-见警率统计-获取目前有数据的指定时间段的车辆历史轨迹数据-Demo示例
export const getHisDataAllDemo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'gpsHisDataInfo/getHisDataAllDemo', {...params}
);

//车辆-根据权限id获取该权限所有对应的车辆
export const getAllandCarById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandCarById', {...params}
);

//人员-获取全部人员信息
export const getPolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getPolice', {...params}
);

//人员-根据人员ID查询人员详细信息
export const getPoliceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getPoliceAndEquipmentsByPuid', {...params}
);

//人员-根据执法仪设备编号获得人员位置
export const getManPosByDn = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getManPosByDn', {...params}
);

//人员-获取执法仪设备列表获取设备GPS
export const getGpsRealdata = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getManPosWithNameAndOrigin', {...params}
);

//人员-获取全部人员的定位位置
export const getManRealPosAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getManRealPosAll', {...params}
);

//人员-轨迹查询
export const getManHisDataByTime = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'manPos/getHisDataByTime', {...params}
);

//人员-根据权限id获取该权限所有对应的人员
export const getAllandPoliceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandPoliceById', {...params}
);

//应急预案-获取全部应急预案
export const getEplanAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'eplan/getEplan', {...params}
);

//指挥标绘-获取全部应急指挥标绘记录
export const getPlan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'plan/getPlan', {...params}
);

//指挥标绘-保存应急指挥标绘记录
export const savePlan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'plan/insert', {...params}
);

//指挥标绘-删除应急指挥标绘记录
export const deletePlanById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'plan/delete', {...params}
);

//自定义图层-获取全部图层
export const getCoverageAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'coverage/getCoverageAll', {...params}
);

//自定义图层-根据图层id只获取属性项
export const getAttributeOnlyByCoverId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/getAttributeOnlyByCoverId', {...params}
);

//自定义图层-条件检索自定义图层
export const getAttributeDataByValue = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/getAttributeDataByValue', {...params}
);

//自定义图层-根据数据id获取该数据的属性项和数值
export const getAttributeDataAndAddressById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/getAttributeDataAndAddressById', {...params}
);

//地图线路-根据分类获取路线，可用于多种只需要展示线的功能
export const queryPoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/queryPoliceLine', {...params}
);

//三拆一改-根据id获取单个建筑物
export const getBuildingById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/getBuildingById', {...params}
);

//三拆一改-获取所有建筑物信息
export const getBuildingAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/getBuilding', {...params}
);

//三拆一改-条件查询建筑物信息
export const queryBuilding = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/queryBuilding', {...params}
);

//地图-获取全部3dtiles数据
export const getTiles3D = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tiles3d/getTiles3D', {...params}
);

//地图-根据当前用户权限获取对应的3dtiles数据
export const getAllandTiles3dById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandTiles3dById', {...params}
);

//地图-获取全部BIM模型
export const getBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/getBim', {...params}
);

//地图-根据当前用户权限获取对应的BIM模型
export const getAllandBimById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandBimById', {...params}
);

//地图-获取全部专题数据图层
export const getDatalayer = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'datalayer/getDatalayer', {...params}
);

//地图-获取全部街道名
export const getStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/getStreetAll', {...params}
);

//视角标签-获取全部定位标签
export const getTag = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tag/getTag', {...params}
);

//视角标签-根据id删除定位标签
export const deleteTagById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tag/delete', {...params}
);

//视角标签-插入标签
export const insertTag = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tag/insert', {...params}
);

//路径-获取全部漫游路径
export const getRoamAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/getRoam', {...params}
);

//初始化-登录
export const login = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/login', {...params}
);

//初始化-获取全部系统参数
export const getSys = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/getSys', {...params}
);

//初始化-启动nginx代理服务器
export const freshNginx = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/freshNginxff', {...params}
);

//初始化-根据权限id和前后台来源获取该权限所有对应的功能
export const getAllandFuncByIdandSrc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandFuncByIdandSrc', {...params}
);

//初始化-根据该功能是前台还是后台的条件获取数据
export const getFuncBySrc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/getFuncBySrc', {...params}
);

//初始化-根据appId获取数据
export const getAppById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/getAppById', {...params}
);

//视频-获取所有视频监督信息
export const getVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoAndNodes', {...params}
);

//视频-根据摄像头ID获取摄像头详细信息
export const getVideoById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoById', {...params}
);

//视频-启动视频转换进程
export const startVideoConverter = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/startffVideoConverter', {...params}
);

//视频-关闭视频转换进程
export const stopVideoConvertor = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/stopffVideoConverter', {...params}
);

//视频-清除所有视频转换进程
export const clearVideoConverter = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/clearffVideoConverter', {...params}
);

//视频-获取所有视频范围信息
export const getAllVideoScope = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoNoNodes', {...params}
);

//视频-根据权限id获取该权限所有对应的视频监控
export const getAllandVideoById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandVideoById', {...params}
);

//人脸识别-获取重点监控黑名单
export const getKeypeopleAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/getKeypeopleAll', {...params}
);

// 人脸识别-以图搜图
export const searchImgByFace = params => axios.post(
  common.aiIp + 'api/Face/searchFaceByFace', {...params}
);

// 人脸识别-注册新黑名单
export const addFaceToServer = params => axios.post(
  common.aiIp + 'api/CustomRepo/addImageToRepo', {...params}
);

//人脸识别-同步黑名单，向重点监控表中新增人员记录
export const insertKeypeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/insert', params
);

// 人脸识别-删除黑名单
export const delFaceToServer = id => axios.delete(
  common.aiIp + 'api/CustomRepo/delImageFromRepo/' + id
);

//人脸识别-根据id获得该人身份
export const queryKeypeopleByIdentity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/queryKeypeopleByIdentity', {...params}
);

//人脸识别-根据摄像头ip 获取所有相同ip集合(统一摄像头,更改位置使用,返回数组)
export const getVideoListByMacUrl = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoListByMacUrl', {...params}
);

//人脸识别-根据条件获取符合条件的关键人口信息
export const queryKeypeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/queryKeypeople', {...params}
);

//周界报警-根据摄像头IP获取摄像头详细信息
export const getVideoByMacUrl = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoByMacUrl', {...params}
);

//周界报警-保存报警信息
export const insertAlert = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alert/insertAlert', {...params}
);

//重点监控人口-电子围栏/人脸识别-获取人口热力图数据
export const getKeyPeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/getKeypeople', {...params}
);

//电子围栏-获取全部电子围栏信息
export const getWall = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'wall/getWall', {...params}
);

//电子围栏-获取全部定位监控人员信息
export const getKeypeopleNoPic = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/getKeypeopleNoPic', {...params}
);

//电子围栏-获取重点人员手机定位模拟数据
export const getPeopleRoute = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'People/getPeopleRoute', {...params}
);

//电子围栏-模拟判断报警的空间分析过程，实际应用中应都在后端进行：当后端获取到手机定位时一边入库一边直接就判断是否报警
export const checkWallAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/checkWallAlarm', {...params}
);

//电子围栏-模拟插入报警记录
export const insertAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/insert', {...params}
);

//电子围栏/人脸比对-获取指定id的监控人员信息
export const getKeypeopleById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/getKeypeopleById', {...params}
);

//百度服务-访问百度地图服务
export const searchPOIJsonp = function (url, func) {
  jsonp(url, null, func);
};

//实有人口-获取符合查询条件的人口信息
export const queryPeoplebase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/queryPeoplebase', {...params}
);

//实有人口-根据人口ID获取人口详细信息
export const getPeopleBaseById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/getPeopleBaseById', {...params}
);

//实有人口-获取全部网格化管理记录并统计人口、地址、下级网格
export const getNetAndCount = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCount', {...params}
);

//实有人口-根据权限id和层级获取该权限所有对应的网格，并统计各网格业务信息
export const getNetAndCountById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountById', {...params}
);

//实有人口-获取符合查询条件的网格化管理信息并统计人口、地址
export const queryNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNet', {...params}
);

//地名地址-根据网格名获取地址信息
export const getAddressByComName = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressByComName', {...params}
);

//实有人口-根据地址ID获取人口信息
export const queryPeopleByAddId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/queryPeopleByAddId', {...params}
);

//实有房屋-根据条件获取房屋信息
export const queryHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/queryHouse', {...params}
);

//实有房屋-获取指定ID的房屋信息
export const getHouseById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/getHouseById', {...params}
);

//实有房屋-获取全部网格化管理记录并统计房屋、地址、下级网格
export const getNetAndCountHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountHouse', {...params}
);

//实有房屋-根据权限和层级获取网格并统计房屋、地址、下级网格
export const getNetAndCountHouseById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountHouseById', {...params}
);

//实有房屋-获取符合查询条件的网格化管理信息并统计房屋、地址
export const queryNetHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetHouse', {...params}
);

//实有房屋-根据地址ID获取房屋信息
export const getHouseByAddId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/getHouseByAddId', {...params}
);

//实有单位-获取符合条件的实有单位信息
export const queryCompanyData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/queryCompanyData', {...params}
);

//实有单位-获取指定ID的单位信息
export const selectCompanyById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/selectCompanyById', {...params}
);

//实有单位-获取符合查询条件的网格化管理信息并统计单位和地址
export const queryNetCompany = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetCompany', {...params}
);

//实有单位-根据权限和层级获取网格并统计单位和地址
export const queryNetCompanyById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetCompanyById', {...params}
);

//实有单位-根据地址ID获取单位信息
export const getCompanyByAddId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/getCompanyByAddId', {...params}
);

//实有单位-根据社区名获取单位信息
export const getCompanyByComName = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/getCompanyByComName', {...params}
);

//地名地址-获取符合查询条件的地名地址信息
export const queryAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/queryAddress', {...params}
);

//地名地址-获取指定ID的地名地址信息
export const getAddressById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressById', {...params}
);

//地名地址-获取全部网格化管理记录并统计、地址、下级网格
export const getNetAndCountAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountAddress', {...params}
);

//地名地址-根据权限和层级获取网格并统计、地址、下级网格
export const getNetAndCountAddressById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountAddressById', {...params}
);

//地名地址-获取符合查询条件的网格化管理信息并统计地址
export const queryNetAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetAddress', {...params}
);

//地名地址-根据类型获取地名地址信息
export const getAddressByType = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressByType', {...params}
);

//网格化管理-获取符合查询条件的网格化管理信息并统计全部一标三实
export const getNetAndCountAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountAll', {...params}
);

//网格化管理-根据权限和层级获取网格并统计全部一标三实
export const getNetAndCountAllById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountAllById', {...params}
);

//网格化管理-获取符合查询条件的网格信息
export const queryNetData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetData', {...params}
);

//网格化管理-获取指定ID的网格信息
export const getNetById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetById', {...params}
);

//网格化管理-获取指定Pid的网格信息并统计全部一标三实
export const getNetAndCountAllN = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountAllN', {...params}
);

//网格化管理-获取指定地址id的全部一标三实基本信息
export const getNetAllByAddId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getNetAllByAddId', {...params}
);

//派出所与警务站-根据名称\层级\获取警务站信息
export const querySecurity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/querySecurityS', {...params}
);

//派出所与警务站-获取指定id的警务站信息
export const getSecuritySById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/getSecuritySById', {...params}
);

//派出所与警务站-计算下级网格数量
export const countNextSecurityS = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/countSecuritySByPid', {...params}
);

//派出所与警务站-根据权限id获取该权限所有对应的警务站
export const getAllandSecurityById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandSecurityById', {...params}
);

//管线管理-获取全部
export const getPipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/getPipeline', {...params}
);

//管线管理-获取指定id的管道信息
export const getPipelineById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/getPipelineById', {...params}
);

//管线管理-获取指定管段的管道信息
export const getPipelineByPlName = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/getPipelineByPlName', {...params}
);

//管线权属-获取全部
export const getPipelineRoad = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineRoad/getPipelineRoad', {...params}
);

//管线巡查-获取全部
export const getPipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/getPipelineCheck', {...params}
);

//管线巡查-根据管段获取巡查记录
export const getPipelineCheckByAdd = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/getPipelineCheckByAdd', {...params}
);

//设备监控-获取全部
export const getBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/getBimDevice', {...params}
);

//设备监控-根据指定id的设备信息
export const getBimDeviceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/getBimDeviceById', {...params}
);

//设备监控-根据权限id获取该权限所有对应的设备
export const getAllandDeviceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandDeviceById', {...params}
);

//管线水流-获取全部
export const getBimWaterFlow = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimWaterFlow/getBimWaterFlow', {...params}
);

//bim室内分区/巡逻网格-根据类型获取网格
export const queryPoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/queryPoliceNet', {...params}
);

//视频巡查-获取全部
export const getDutyVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'dutyVideo/getDutyVideo', {...params}
);

//AI巡更-根据名单类型和用户id
export const getFaceIdentityByRepoTypeandUserId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'faceIdentity/getFaceIdentityByRepoTypeandUserId', {...params}
);

//部件模型管理-获取全部部件模型
export const getCityThingModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThingModel/getCityThingModel', {...params}
);

//城市部件
export const getCityThingByPid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/getCityThingByPid', {...params}
);

//人员门禁-获取全部
export const getAccessCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessCar/getAccessCar', {...params}
);

//车辆道闸-获取全部
export const getAccessMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessMan/getAccessMan', {...params}
);

//超级地图-点
export const getPolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/getPolicePoint', {...params}
);

//超级地图-线
export const getPoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/getPoliceLine', {...params}
);

//超级地图-面
export const getPoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/getPoliceNet', {...params}
);

//方案对比-获取全部
export const getBimCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCase/getBimCase', {...params}
);

//方案对比-新增
export const insertBimCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCase/insert', {...params}
);

//方案对比-更新
export const updateBimCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCase/update', {...params}
);

//方案对比-删除
export const deleteBimCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCase/delete', {...params}
);

//建筑模型-获取全部
export const getBimCaseModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCaseModel/getBimCaseModel', {...params}
);

//全景地图-获取全部
export const getMapPhotos = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/getMapPhotos', {...params}
);

//全景地图-根据时间段检索
export const getMapPhotosByTime = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/getMapPhotosByTime', {...params}
);

//网格员-根据ID获取网格员
export const getNetManById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/getNetManById', {...params}
);

//照片地图-获取全部
export const getMapImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/getMapImage', {...params}
);

//照片地图-根据pid获取数据
export const getMapImageByPid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/getMapImageByPid', {...params}
);

//室内户型-获取全部户型的数据
export const getLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/getLayout', {...params}
);

//室内户型-根据建筑模型获取对应户型数据
export const getLayoutByName = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/getLayoutByName', {...params}
);

//无人机-获取全部
export const getUav = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/getUav', {...params}
);

//无人机-根据无人机id获取无人机实时位置
export const getUavPosByUavId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/getUavPosByUavId', {...params}
);

//无人机-根据权限id获取该权限所有对应的无人机
export const getAllandUavById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandUavById', {...params}
);

//征地拆迁-根据id获取数据
export const getBuildingRemoveByAddId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/getBuildingRemoveByAddId', {...params}
);

//征地拆迁-条件查询数据
export const queryBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/queryBuildingRemove', {...params}
);

//征地拆迁-获取全部网格化管理记录并统计户主数、房屋总数、已签约数
export const getNetAndCountBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountBuildingRemove', {...params}
);

//征地拆迁-根据权限和层级获取网格并统计户主数、房屋总数、已签约数
export const getNetAndCountBuildingRemoveById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetAndCountBuildingRemoveById', {...params}
);

//征地拆迁-根据id获取全景图
export const getHousePanoramaByHosueId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/getHousePanoramaByHosueId', {...params}
);

//征地拆迁-根据id获取单个网格信息及其征地拆迁统计数据
export const getBuildingRemoveNetById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getBuildingRemoveNetById', {...params}
);

//征地拆迁-根据pid网格获取征地拆迁数据
export const getBuildingRemoveByPid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/getBuildingRemoveByPid', {...params}
);

//征地拆迁-户数统计
export const countBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/countBuildingRemove', {...params}
);

//征地拆迁-房屋（地名地址）统计
export const countAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/countAddress', {...params}
);

//征地拆迁-地块总数（土地证总数）
export const countBuildingRemoveLand = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/countBuildingRemoveLand', {...params}
);

//征地拆迁-土地证总面积
export const sumBuildingRemoveLandArea = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/sumBuildingRemoveLandArea', {...params}
);

//征地拆迁-房产证总面积
export const sumBuildingRemoveHouseArea = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/sumBuildingRemoveHouseArea', {...params}
);

//征地拆迁-房屋用途占比
export const countBuildingRemoveUse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/countBuildingRemoveUse', {...params}
);

//征地拆迁-国有集体地块数量占比
export const countBuildingRemoveLandNum = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/countBuildingRemoveLandNum', {...params}
);

//征地拆迁-国有集体地块面积占比
export const countBuildingRemoveLandArea = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/countBuildingRemoveLandArea', {...params}
);
