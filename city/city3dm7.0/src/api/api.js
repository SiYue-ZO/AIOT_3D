import axios from './http.js';

//首页-登录
export const login = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/login', {...params}
);

//首页-数据量统计
export const countGeneralByExample = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'general/countGeneralByExample', {...params}
);

//首页-修改密码
export const updatePwd = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/updatePwd', {...params}
);

//系统参数-获取全部
export const getSys = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/getSys', {...params}
);

//系统参数-新增
export const insertSys = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/insert', {...params}
);

//系统参数-修改
export const updateSys = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/update', {...params}
);

//系统参数-删除
export const deleteSys = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/delete', {...params}
);

//系统参数-根据类型获取系统参数
export const querySysParabyType = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sys/querySysParabyType', {...params}
);

//启动nginx代理服务器
export const freshNginx = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/freshNginxff', {...params}
);

//用户管理-获取全部数据
export const getUser = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/getUser', {...params}
);

//用户管理-新增
export const insertUser = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/insert', {...params}
);

//用户管理-更新
export const updateUser = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/update', {...params}
);

//用户管理-删除
export const deleteUser = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'user/delete', {...params}
);

//功能管理-获取全部数据
export const getFunc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/getFunc', {...params}
);

//功能管理-新增
export const insertFunc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/insert', {...params}
);

//功能管理-更新
export const updateFunc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/update', {...params}
);

//功能管理-删除
export const deleteFunc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/delete', {...params}
);

//功能管理-根据等级获取数据
export const getFuncByLevel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/getFuncByLevel', {...params}
);

//功能管理-获取全部功能和依赖关系
export const getFuncAndRel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/getFuncAndRel', {...params}
);

//功能管理-根据该功能是前台还是后台的条件获取数据
export const getFuncBySrc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'func/getFuncBySrc', {...params}
);

//权限管理-获取全部数据
export const getRole = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getRole', {...params}
);

//权限管理-新增
export const insertRole = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/insert', {...params}
);

//权限管理-更新
export const updateRole = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/update', {...params}
);

//权限管理-删除
export const deleteRole = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/delete', {...params}
);

//权限管理-根据权限id获取该权限所有对应的功能
export const getAllandFuncById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandFuncById', {...params}
);

//权限管理-根据权限id和前后台来源获取该权限所有对应的功能
export const getAllandFuncByIdandSrc = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandFuncByIdandSrc', {...params}
);

//权限管理-根据权限id获取该权限所有对应的车辆
export const getAllandCarById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandCarById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的人员
export const getAllandPoliceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandPoliceById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的设备
export const getAllandDeviceById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandDeviceById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的网格
export const getAllandNetById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandNetById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的警务站
export const getAllandSecurityById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandSecurityById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的无人机
export const getAllandUavById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandUavById', {...params}
);

//权限管理-根据权限id获取该权限所有对应的视频监控
export const getAllandVideoById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandVideoById', {...params}
);

//应用管理-获取全部数据
export const getApp = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/getSysApp', {...params}
);

//应用管理-新增
export const insertApp = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/insert', params
);

//应用管理-更新
export const updateApp = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/update', params
);

//应用管理-删除
export const deleteApp = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/delete', {...params}
);

//应用管理-根据appId获取数据
export const getAppById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'sysApp/getAppById', {...params}
);

//实景三维-获取全部3dtiles数据地址
export const getTiles3D = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tiles3d/getTiles3D', {...params}
);

//实景三维-根据当前用户权限获取对应的3dtiles数据
export const getAllandTiles3dById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandTiles3dById', {...params}
);

//实景三维-新增3dtiles数据
export const insertTiles3D = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tiles3d/insert', {...params}
);

//实景三维-更新3dtiles数据
export const updateTiles3D = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tiles3d/update', {...params}
);

//实景三维-删除3dtiles数据
export const deleteTiles3D = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'tiles3d/delete', {...params}
);

//物联网-人员-获取没有照片的全部人员信息
export const getPolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getPolice', {...params}
);

//物联网-人员-添加人员数据
export const insertPolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/insert', params
);

//物联网-人员-更新人员数据
export const updatePolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/update', params
);

//物联网-人员-删除人员数据
export const deletePolice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/delete', {...params}
);

//物联网-人员-获取关联装备
export const getPoliceAndEquipmentsByPuid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'police/getPoliceAndEquipmentsByPuid', {...params}
);

//物联网-车辆-获取没有照片的全部车辆数据
export const getAllCars = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getAllCars', {...params}
);

//物联网-车辆-新增车辆数据
export const insertCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/insert', params
);

//物联网-车辆-更新车辆数据
export const updateCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/update', params
);

//物联网-车辆-删除车辆数据
export const deleteCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/delete', {...params}
);

//物联网-车辆-获取关联装备
export const getCarAndEquipmentsByPuid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'car/getCarAndEquipmentsByPuid', {...params}
);

//装备管理-根据类型查询，但没有条件时，获取全部
export const selectEquipmentByType = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'equipment/selectEquipmentByType', {...params}
);

//装备管理-新增
export const insertEquipment = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'equipment/insertEquipment', params
);

//装备管理-更新
export const updateEquipment = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'equipment/updateEquipment', params
);

//装备管理-删除
export const deleteEquipment = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'equipment/deleteEquipment', {...params}
);

//漫游路径-获取全部
export const getRoamAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/getRoam', {...params}
);

//漫游路径-新增
export const insertRoam = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/insert', {...params}
);

//漫游路径-更新
export const updateRoam = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/update', {...params}
);

//漫游路径-删除
export const deleteRoam = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/delete', {...params}
);

//漫游路径-批量删除
export const batchDeleteRoam = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'roam/batchDelete', params
);

//案件管理-获取全部案件信息
export const getCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/getCaseAll', {...params}
);

//案件管理-更新案件信息
export const updateCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/updateCase', params
);

//案件管理-删除案件信息
export const deleteCase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/delete', {...params}
);

//案件管理-根据id获取资料
export const getCaseMaterialById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/getCaseMaterialById', {...params}
);

//案件管理-根据id删除资料
export const deleteCaseMaterial = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'case/deleteCaseMaterial', {...params}
);

//专题数据图层-获取全部
export const getDatalayer = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'datalayer/getDatalayer', {...params}
);

//专题数据图层-新增专题数据图层
export const insertDatalayer = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'datalayer/insert', {...params}
);

//专题数据图层-更新专题数据图层
export const updateDatalayer = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'datalayer/update', {...params}
);

//专题数据图层-删除专题数据图层
export const deleteDatalayer = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'datalayer/delete', {...params}
);

//三拆一改-获取所有建筑物信息
export const getBuildingAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/getBuilding', {...params}
);

//三拆一改-新增并上传照片和全景图
export const insertBuilding = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/insert', params
);

//三拆一改-更新并上传照片和全景图
export const updateBuilding = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/update', params
);

//三拆一改-删除
export const deleteBuilding = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/delete', {...params}
);

//三拆一改-批量删除
export const batchDeleteBuilding = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'building/batchDelete', params
);

//视频监控-获取所有信息
export const getVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoAndNodes', {...params}
);

//视频监控-新增视频监控数据
export const insertVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/insert', {...params}
);

//视频监控-更新视频监控数据
export const updateVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/update', {...params}
);

//视频监控-删除视频监控数据
export const deleteVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/delete', {...params}
);

//视频监控-只获取目录节点
export const getVideosIsNode = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideosIsNode', {...params}
);

//视频监控-启动视频转换进程
export const startVideoConverter = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/startffVideoConverter', {...params}
);

//视频监控-关闭视频转换进程
export const stopVideoConvertor = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/stopffVideoConverter', {...params}
);

//视频监控-清除所有视频转换进程
export const clearVideoConverter = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/clearffVideoConverter', {...params}
);

//视频监控-检测视频转码端口是否重复
export const testVideoRepetitionByCamPort = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/testVideoRepetitionByCamPort', {...params}
);

//视频监控-获取视频没有节点
export const getVideoNoNodes = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'video/getVideoNoNodes', {...params}
);

//电子围栏-获取全部电子围栏信息
export const getWall = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'wall/getWall', {...params}
);

//电子围栏-新增
export const insertWall = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'wall/insert', {...params}
);

//电子围栏-更新
export const updateWall = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'wall/update', {...params}
);

//电子围栏-删除
export const deleteWall = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'wall/delete', {...params}
);

//围栏报警-获取全部
export const getAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/getAlarm', {...params}
);

//围栏报警-更新
export const updateAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/update', {...params}
);

//围栏报警-删除
export const deleteAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/delete', {...params}
);

//围栏报警-批量删除
export const batchDeleteAlarm = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alarm/batchDelete', params
);

//实有人口-获取全部人口信息
export const getPeopleBaseAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/getPeopleBaseAll', {...params}
);

//实有人口-保存人口信息
export const insertPeopleBase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/insert', params
);

//实有人口-更新人口信息
export const updatePeopleBase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/update', params
);

//实有人口-删除人口信息
export const deletePeopleBase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/delete', {...params}
);

//实有人口-批量删除
export const batchDeletePeopleBase = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/batchDelete', params
);

//实有人口-根据条件获取人口信息
export const queryPeoplebasePart = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleBase/queryPeoplebasePart', {...params}
);

//实有车辆-获取全部实有车辆
export const getPeopleVehicle = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleVehicle/getPeopleVehicle', {...params}
);

//实有车辆-保存
export const insertPeopleVehicle = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleVehicle/insert', params
);

//实有车辆-更新
export const updatePeopleVehicle = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleVehicle/update', params
);

//实有车辆-删除
export const deletePeopleVehicle = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleVehicle/delete', {...params}
);

//实有车辆-批量删除
export const batchDeleteVehicle = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleVehicle/batchDelete', params
);

//实有刀具-获取全部实有刀具
export const getPeopleKnife = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleKnife/getPeopleKnife', {...params}
);

//实有刀具-保存
export const insertPeopleKnife = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleKnife/insert', params
);

//实有刀具-更新
export const updatePeopleKnife = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleKnife/update', params
);

//实有刀具-删除
export const deletePeopleKnife = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleKnife/delete', {...params}
);

//实有刀具-批量删除
export const batchDeleteKnife = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleKnife/batchDelete', params
);

//实有机械-获取全部
export const getPeopleMachine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleMachine/getPeopleMachine', {...params}
);

//实有机械-保存
export const insertPeopleMachine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleMachine/insert', params
);

//实有机械-更新
export const updatePeopleMachine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleMachine/update', params
);

//实有机械-删除
export const deletePeopleMachine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleMachine/delete', {...params}
);

//实有机械-批量删除
export const batchDeletePeopleMachine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'peopleMachine/batchDelete', params
);

//实有房屋-根据条件获取房屋信息
export const queryHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/queryHouse', {...params}
);

//实有房屋-保存房屋信息
export const insertHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/insert', params
);

//实有房屋-修改房屋信息
export const updateHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/update', params
);

//实有房屋-删除房屋信息
export const deleteHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/delete', {...params}
);

//实有房屋-根据房屋id获取全景图
export const getHousePanoramaByHosueId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/getHousePanoramaByHosueId', {...params}
);

//实有房屋-根据id删除全景照片
export const deleteHousePanorama = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/deleteHousePanorama', {...params}
);

//实有房屋-批量删除
export const batchDeleteHouse = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'house/batchDelete', params
);

//实有单位-获取符合条件的实有单位信息
export const queryCompanyData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/queryCompanyData', {...params}
);

//实有单位-新增实有单位信息
export const insertCompany = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/insert', params
);

//实有单位-更新
export const updateCompany = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/update', params
);

//实有单位-删除实有单位信息
export const deleteCompany = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/delete', {...params}
);

//实有单位-批量删除
export const batchDeleteCompany = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'company/batchDelete', params
);

//地名地址-获取全部地名地址中的住宅的数据
export const getAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddress', {...params}
);

//地名地址-获取全部地名地址中的地名和行政数据
export const getAddressByType = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressByType', {...params}
);

//地名地址-获取指定ID的地名地址信息
export const getAddressById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressById', {...params}
);

//地名地址-根据网格编号获取地名地址
export const getAddressDirectory = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/getAddressDirectory', {...params}
);

//地名地址-删除记录
export const deleteAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/delete', {...params}
);

//地名地址-批量删除
export const batchDeleteAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/batchDelete', params
);

//地名地址-更新记录
export const updateAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/update', {...params}
);

//地名地址-新增记录
export const insertAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/insert', {...params}
);

//巡逻点位-获取全部
export const getPolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/getPolicePoint', {...params}
);

//巡逻点位-增加巡逻点位数据
export const insertPolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/insert', {...params}
);

//巡逻点位-更新巡逻点位数据
export const updatePolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/update', {...params}
);

//巡逻点位-删除巡逻点位数据
export const deletePolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/delete', {...params}
);

//巡逻点位-批量删除巡逻点位数据
export const batchDeletePolicePoint = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policePoint/batchDelete', params
);

//巡逻路线-获取全部
export const getPoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/getPoliceLine', {...params}
);

//巡逻路线-增加巡逻路线数据
export const insertPoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/insert', {...params}
);

//巡逻路线-更新巡逻路线数据
export const updatePoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/update', {...params}
);

//巡逻路线-删除巡逻路线数据
export const deletePoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/delete', {...params}
);

//巡逻路线-批量删除巡逻路线数据
export const batchDeletePoliceLine = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeLine/batchDelete', params
);

//巡逻网格-获取全部
export const getPoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/getPoliceNet', {...params}
);

//巡逻网格-增加
export const insertPoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/insert', {...params}
);

//巡逻网格-更新
export const updatePoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/update', {...params}
);

//巡逻网格-删除
export const deletePoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/delete', {...params}
);

//巡逻网格-批量删除巡逻网格数据
export const batchDeletePoliceNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'policeNet/batchDelete', params
);

//派出所警务站-网格绘制列表
export const getSecurityAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/getSecurityAll', {...params}
);

//派出所警务站-新增
export const insertSecurity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/insert', {...params}
);

//派出所警务站-更新
export const updateSecurity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/update', {...params}
);

//派出所警务站-删除
export const deleteSecurity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/delete', {...params}
);

//派出所警务站-批量删除
export const batchDeleteSecurity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'securityS/batchDelete', params
);

//网格绘制-查询网格信息
export const queryNetData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/queryNetData', {...params}
);

//网格化管理-获取指定ID的网格信息
export const getNetInfoById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/getNetInfoById', {...params}
);

//网格绘制-新增网格
export const insertNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/insert', {...params}
);

//网格绘制-更新网格
export const updateNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/update', {...params}
);

//网格绘制-删除网格(有子集的不可以删除)
export const deleteNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/delete', {...params}
);

//网格绘制-批量删除
export const batchDeleteNet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'net/batchDelete', params
);

//周界报警-获取全部
export const getAlert = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alert/getAlert', {...params}
);

//周界报警-更新
export const updateAlert = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alert/update', {...params}
);

//周界报警-删除
export const deleteAlert = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alert/delete', {...params}
);

//周界报警-批量删除
export const batchDeleteAlert = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'alert/batchDelete', params
);

//人脸识别-获取全部
export const getFaceIdentity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'faceIdentity/getFaceIdentity', {...params}
);

//人脸识别-更新
export const updateFaceIdentity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'faceIdentity/update', {...params}
);

//人脸识别-删除
export const deleteFaceIdentity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'faceIdentity/delete', {...params}
);

//人脸识别-批量删除
export const batchDeleteFaceIdentity = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'faceIdentity/batchDelete', params
);

//bim管理-获取全部
export const getBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/getBim', {...params}
);

//bim管理-根据当前用户权限获取对应的bim数据
export const getAllandBimById = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'role/getAllandBimById', {...params}
);

//bim管理-新增
export const insertBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/insert', {...params}
);

//bim管理-更新
export const updateBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/update', {...params}
);

//bim管理-删除
export const deleteBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/delete', {...params}
);

//bim管理-批量删除
export const batchDeleteBim = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bim/batchDelete', params
);

//定制图层-图层-获取全部
export const getCoverage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'coverage/getCoverageAll', {...params}
);

//定制图层-图层-新增
export const insertCoverage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'coverage/insert', {...params}
);

//定制图层-图层-更新
export const updateCoverage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'coverage/update', {...params}
);

//定制图层-图层-删除
export const deleteCoverage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'coverage/delete', {...params}
);

//定制图层-属性项-获取全部
export const getAttribute = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/getAttributeAll', {...params}
);

//定制图层-属性项-新增
export const insertAttribute = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/insert', {...params}
);

//定制图层-属性项-更新
export const updateAttribute = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/update', {...params}
);

//定制图层-属性项-删除
export const deleteAttribute = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/delete', {...params}
);

//定制图层-属性值-根据图层id获取属性值
export const getAttributeDataByCoverageId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/getAttributeDataByCoverageId', {...params}
);

//定制图层-属性值-根据图层id只获取属性项
export const getAttributeOnlyByCoverId = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attribute/getAttributeOnlyByCoverId', {...params}
);

//定制图层-属性值-新增
export const insertAttributeData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/insert', {...params}
);

//定制图层-属性值-更新
export const updateAttributeData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/update', {...params}
);

//定制图层-属性值-删除
export const deleteAttributeData = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'attributeData/delete', {...params}
);

//应急预案-获取全部
export const getEplanAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'eplan/getEplan', {...params}
);

//应急预案-新增
export const insertEplan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'eplan/insert', {...params}
);

//应急预案-更新
export const updateEplan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'eplan/update', {...params}
);

//应急预案-删除
export const deleteEplan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'eplan/delete', {...params}
);

//街道-获取全部
export const getStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/getStreetAll', {...params}
);

//街道-新增
export const insertStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/insert', {...params}
);

//街道-更新
export const updateStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/update', {...params}
);

//街道-删除
export const deleteStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/delete', {...params}
);

//街道-批量删除
export const batchDeleteStreet = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'street/batchDelete', params
);

//重点监控人员-获取全部
export const getKeypeopleAll = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/getKeypeopleAll', {...params}
);

//重点监控人员-新增
export const insertKeypeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/insert', params
);

//重点监控人员-更新
export const updateKeypeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/update', params
);

//重点监控人员-删除
export const deleteKeypeople = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'keyPeople/delete', {...params}
);

//注册AI人脸识别的黑名单和白名单
export const registAIFace = (ip, params) => axios.post(
  ip + 'api/CustomRepo/addImageToRepo', {...params}
);

//删除AI人脸识别的黑名单和白名单
export const deleteAIFace = (ip, userId) => axios.delete(
  ip + 'api/CustomRepo/delImageFromRepo/' + userId,
);

//管线管理-获取全部
export const getPipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/getPipeline', {...params}
);

//管线管理-新增
export const insertPipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/insert', params
);

//管线管理-更新
export const updatePipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/update', params
);

//管线管理-删除
export const deletePipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/delete', {...params}
);

//管线管理-批量删除
export const batchDeletePipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/batchDelete', params
);

//管线管理-批量添加
export const insertBatchPipeline = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipeline/insertBatch', params
);

//管线巡查记录-获取全部
export const getPipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/getPipelineCheck', {...params}
);

//管线巡查记录-新增
export const insertPipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/insert', params
);

//管线巡查记录-更新
export const updatePipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/update', params
);

//管线巡查记录-删除
export const deletePipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/delete', {...params}
);

//管线巡查记录-批量删除
export const batchDeletePipelineCheck = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineCheck/batchDelete', params
);

//设备监控-获取全部
export const getBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/getBimDevice', {...params}
);

//设备监控-新增
export const insertBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/insert', {...params}
);

//设备监控-更新
export const updateBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/update', {...params}
);

//设备监控-删除
export const deleteBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/delete', {...params}
);

//设备监控-批量删除
export const batchDeleteBimDevice = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimDevice/batchDelete', params
);

//管线水流-获取全部
export const getBimWaterFlow = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimWaterFlow/getBimWaterFlow', {...params}
);

//管线水流-新增
export const insertBimWaterFlow = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimWaterFlow/insert', {...params}
);

//管线水流-更新
export const updateBimWaterFlow = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimWaterFlow/update', {...params}
);

//管线水流-删除
export const deleteBimWaterFlow = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimWaterFlow/delete', {...params}
);

//视频巡查-获取全部
export const getDutyVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'dutyVideo/getDutyVideo', {...params}
);

//视频巡查-新增
export const insertDutyVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'dutyVideo/insert', {...params}
);

//视频巡查-更新
export const updateDutyVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'dutyVideo/update', {...params}
);

//视频巡查-删除
export const deleteDutyVideo = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'dutyVideo/delete', {...params}
);

//车辆道闸-获取全部
export const getAccessCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessCar/getAccessCar', {...params}
);

//车辆道闸-删除
export const deleteAccessCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessCar/delete', {...params}
);

//车辆道闸-批量删除
export const batchDeleteAccessCar = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessCar/batchDelete', params
);

//人员门禁-获取全部
export const getAccessMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessMan/getAccessMan', {...params}
);

//人员门禁-删除
export const deleteAccessMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessMan/delete', {...params}
);

//人员门禁-批量删除
export const batchDeleteAccessMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'accessMan/batchDelete', params
);

//城市部件-获取全部
export const getCityThing = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/getCityThing', {...params}
);

//城市部件-新增
export const insertCityThing = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/insert', {...params}
);

//城市部件-更新
export const updateCityThing = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/update', {...params}
);

//城市部件-删除
export const deleteCityThing = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/delete', {...params}
);

//城市部件-批量删除
export const batchDeleteCityThing = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThing/batchDelete', params
);

//建筑模型-获取全部
export const getBimCaseModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCaseModel/getBimCaseModel', {...params}
);

//建筑模型-新增并上传缩略图
export const insertBimCaseModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCaseModel/insert', params
);

//建筑模型-更新并上传缩略图
export const updateBimCaseModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCaseModel/update', params
);

//建筑模型-删除
export const deleteBimCaseModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'bimCaseModel/delete', {...params}
);

//全景地图-获取全部
export const getMapPhotos = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/getMapPhotos', {...params}
);

//全景地图-新增
export const insertMapPhotos = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/insert', params
);

//全景地图-删除
export const deleteMapPhotos = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/delete', {...params}
);

//全景地图-批量删除
export const batchDeleteMapPhotos = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapPhotos/batchDelete', params
);

//网格员-获取全部
export const getNetMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/getNetMan', {...params}
);

//网格员-新增
export const insertNetMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/insert', params
);

//网格员-更新
export const updateNetMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/update', params
);

//网格员-删除
export const deleteNetMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/delete', {...params}
);

//网格员-根据类型获取网格员
export const getNetManByType = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/getNetManByType', {...params}
);

//网格员-批量删除
export const batchDeleteNetMan = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'netMan/batchDelete', params
);

//照片地图-获取全部
export const getMapImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/getMapImage', {...params}
);

//照片地图-新增
export const insertMapImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/insert', params
);

//照片地图-删除
export const deleteMapImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/delete', {...params}
);

//照片地图-批量删除
export const batchDeleteMapImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/batchDelete', params
);

//照片地图-根据pid获取数据
export const getMapImageByPid = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/getMapImageByPid', {...params}
);

//照片地图-删除图片
export const deleteImage = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'mapImage/deleteImage', {...params}
);

//室内户型-获取全部户型的数据
export const getLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/getLayout', {...params}
);

//室内户型-删除记录
export const deleteLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/delete', {...params}
);

//室内户型-批量删除
export const batchDeleteLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/batchDelete', params
);

//室内户型-更新记录
export const updateLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/update', {...params}
);

//室内户型-新增记录
export const insertLayout = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'layout/insert', {...params}
);

//无人机-获取全部
export const getUav = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/getUav', {...params}
);

//无人机-删除记录
export const deleteUav = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/delete', {...params}
);

//无人机-更新记录
export const updateUav = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/update', {...params}
);

//无人机-新增记录
export const insertUav = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'uav/insert', {...params}
);

//征地拆迁-获取全部
export const getBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/getBuildingRemove', {...params}
);

//征地拆迁-删除记录
export const deleteBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/delete', {...params}
);

//征地拆迁-新增记录并上传照片和pdf
export const insertBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/insert', params
);

//征地拆迁-更新记录并上传照片和pdf
export const updateBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/update', params
);

//征地拆迁-批量删除
export const batchDeleteBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/batchDelete', params
);

//征地拆迁-批量添加
export const batchInsertBuildingRemove = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'buildingRemove/batchInsert', params
);

//征地拆迁-根据条件获取地名地址坐标
export const queryAddress = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'address/queryAddress', {...params}
);

//部件模型管理-获取全部部件模型
export const getCityThingModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThingModel/getCityThingModel', {...params}
);

//部件模型管理-新增并上传模型
export const insertCityThingModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThingModel/insert', params
);

//部件模型管理-更新并上传模型
export const updateCityThingModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThingModel/update', params
);

//部件模型管理-删除
export const deleteCityThingModel = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'cityThingModel/delete', {...params}
);

//管线街道管理-获取全部街道
export const getPipelineRoad = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineRoad/getPipelineRoad', {...params}
);

//管线街道管理-新增
export const insertPipelineRoad = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineRoad/insert', {...params}
);

//管线街道管理-更新
export const updatePipelineRoad = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineRoad/update', {...params}
);

//管线街道管理-更新
export const deletePipelineRoad = params => axios.post(
  common.serverIp + 'city3dAPI/' + 'pipelineRoad/delete', {...params}
);
