import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

const login = r => require.ensure([], () => r(require('@/pages/login')), 'login');
const main = r => require.ensure([], () => r(require('@/pages/main-view')), 'main');
const sysHome = r => require.ensure([], () => r(require('@/pages/sys-home')), 'sysHome');
const sysParams = r => require.ensure([], () => r(require('@/pages/sys-params')), 'sysParams');
const sysUser = r => require.ensure([], () => r(require('@/pages/sys-user')), 'sysUser');
const mapTiles = r => require.ensure([], () => r(require('@/pages/map-tiles')), 'mapTiles');
const mapLayer = r => require.ensure([], () => r(require('@/pages/map-layer')), 'mapLayer');
const iotCar = r => require.ensure([], () => r(require('@/pages/iot-car')), 'iotCar');
const iotMan = r => require.ensure([], () => r(require('@/pages/iot-man')), 'iotMan');
const iotVideo = r => require.ensure([], () => r(require('@/pages/iot-video')), 'iotVideo');
const iotVideoIndoor = r => require.ensure([], () => r(require('@/pages/iot-video-indoor')), 'iotVideoIndoor');
const iotUav = r => require.ensure([], () => r(require('@/pages/iot-uav')), 'iotUav');
const dutyPoint = r => require.ensure([], () => r(require('@/pages/duty-point')), 'dutyPoint');
const dutyLine = r => require.ensure([], () => r(require('@/pages/duty-line')), 'dutyLine');
const dutyNet = r => require.ensure([], () => r(require('@/pages/duty-net')), 'dutyNet');
const dutyVideo = r => require.ensure([], () => r(require('@/pages/duty-video')), 'dutyVideo');
const realAddress = r => require.ensure([], () => r(require('@/pages/real-address')), 'realAddress');
const realPeople = r => require.ensure([], () => r(require('@/pages/real-people')), 'realPeople');
const realHouse = r => require.ensure([], () => r(require('@/pages/real-house')), 'realHouse');
const realCompany = r => require.ensure([], () => r(require('@/pages/real-company')), 'realCompany');
const caseMap = r => require.ensure([], () => r(require('@/pages/case-map')), 'caseMap');
const netManage = r => require.ensure([], () => r(require('@/pages/net-manage')), 'netManage');
const netSecurity = r => require.ensure([], () => r(require('@/pages/net-security')), 'netSecurity');
const toolRoam = r => require.ensure([], () => r(require('@/pages/tool-roam')), 'toolRoam');
const protectAlarm = r => require.ensure([], () => r(require('@/pages/protect-alarm')), 'protectAlarm');
const protectAlert = r => require.ensure([], () => r(require('@/pages/protect-alert')), 'protectAlert');
const protectFace = r => require.ensure([], () => r(require('@/pages/protect-face')), 'protectFace');
const protectWall = r => require.ensure([], () => r(require('@/pages/protect-wall')), 'protectWall');
const bimManage = r => require.ensure([], () => r(require('@/pages/bim-manage')), 'bimManage');
const bimDevice = r => require.ensure([], () => r(require('@/pages/bim-device')), 'bimDevice');
const bimWaterFlow = r => require.ensure([], () => r(require('@/pages/bim-water-flow')), 'bimWaterFlow');
const netBuilding = r => require.ensure([], () => r(require('@/pages/net-building')), 'netBuilding');
const customCoverage = r => require.ensure([], () => r(require('@/pages/custom-coverage')), 'customCoverage');
const customAttribute = r => require.ensure([], () => r(require('@/pages/custom-attribute')), 'customAttribute');
const customAttributeData = r => require.ensure([], () => r(require('@/pages/custom-attributeData')), 'customAttributeData');
const equipManage = r => require.ensure([], () => r(require('@/pages/equip-manage')), 'equipManage');
const firePlan = r => require.ensure([], () => r(require('@/pages/fire-plan')), 'firePlan');
const mapAddress = r => require.ensure([], () => r(require('@/pages/map-address')), 'mapAddress');
const mapStreet = r => require.ensure([], () => r(require('@/pages/map-street')), 'mapStreet');
const protectPeople = r => require.ensure([], () => r(require('@/pages/protect-people')), 'protectPeople');
const realVehicle = r => require.ensure([], () => r(require('@/pages/real-vehicle')), 'realVehicle');
const realKnife = r => require.ensure([], () => r(require('@/pages/real-knife')), 'realKnife');
const realMachine = r => require.ensure([], () => r(require('@/pages/real-machine')), 'realMachine');
const netPipeline = r => require.ensure([], () => r(require('@/pages/net-pipeline')), 'netPipeline');
const netPipelineCheck = r => require.ensure([], () => r(require('@/pages/net-pipeline-check')), 'netPipelineCheck');
const netPipelineRoad = r => require.ensure([], () => r(require('@/pages/net-pipeline-road')), 'netPipelineRoad');
const sysFunc = r => require.ensure([], () => r(require('@/pages/sys-func')), 'sysFunc');
const sysRole = r => require.ensure([], () => r(require('@/pages/sys-role')), 'sysRole');
const sysApp = r => require.ensure([], () => r(require('@/pages/sys-app')), 'sysApp');
const accessCar = r => require.ensure([], () => r(require('@/pages/access-car')), 'accessCar');
const accessMan = r => require.ensure([], () => r(require('@/pages/access-man')), 'accessMan');
const cityThing = r => require.ensure([], () => r(require('@/pages/city-thing')), 'cityThing');
const cityThingModel = r => require.ensure([], () => r(require('@/pages/city-thing-model')), 'cityThingModel');
const mapPhotos = r => require.ensure([], () => r(require('@/pages/map-photos')), 'mapPhotos');
const netMan = r => require.ensure([], () => r(require('@/pages/net-man')), 'netMan');
const bimCaseModel = r => require.ensure([], () => r(require('@/pages/bim-case-model')), 'bimCaseModel');
const mapImage = r => require.ensure([], () => r(require('@/pages/map-image')), 'mapImage');
const cityBuilding = r => require.ensure([], () => r(require('@/pages/city-building')), 'cityBuilding');
const cityBuildingRemove = r => require.ensure([], () => r(require('@/pages/city-building-remove')), 'cityBuildingRemove');

const routes = [
  {
    path: '/',
    component: login
  },
  {
    path: '/main',
    component: main,
    name: '',
    children: [
      {
        path: '',
        component: sysHome,
        meta: [],
      }, {
        path: '/sysParams',
        component: sysParams,
        meta: [],
      }, {
        path: '/sysUser',
        component: sysUser,
        meta: [],
      }, {
        path: '/mapTiles',
        component: mapTiles,
        meta: [],
      }, {
        path: '/mapLayer',
        component: mapLayer,
        meta: [],
      }, {
        path: '/iotCar',
        component: iotCar,
        meta: [],
      }, {
        path: '/iotMan',
        component: iotMan,
        meta: [],
      }, {
        path: '/iotVideo',
        component: iotVideo,
        meta: [],
      }, {
        path: '/iotVideoIndoor',
        component: iotVideoIndoor,
        meta: [],
      }, {
        path: '/iotUav',
        component: iotUav,
        meta: [],
      }, {
        path: '/dutyPoint',
        component: dutyPoint,
        meta: [],
      }, {
        path: '/dutyLine',
        component: dutyLine,
        meta: [],
      }, {
        path: '/dutyNet',
        component: dutyNet,
        meta: [],
      }, {
        path: '/dutyVideo',
        component: dutyVideo,
        meta: [],
      }, {
        path: '/realAddress',
        component: realAddress,
        meta: [],
      }, {
        path: '/realPeople',
        component: realPeople,
        meta: [],
      }, {
        path: '/realHouse',
        component: realHouse,
        meta: [],
      }, {
        path: '/realCompany',
        component: realCompany,
        meta: [],
      }, {
        path: '/caseMap',
        component: caseMap,
        meta: [],
      }, {
        path: '/netManage',
        component: netManage,
        meta: [],
      }, {
        path: '/netSecurity',
        component: netSecurity,
        meta: [],
      }, {
        path: '/toolRoam',
        component: toolRoam,
        meta: [],
      }, {
        path: '/protectAlarm',
        component: protectAlarm,
        meta: [],
      }, {
        path: '/protectAlert',
        component: protectAlert,
        meta: [],
      }, {
        path: '/protectFace',
        component: protectFace,
        meta: [],
      }, {
        path: '/protectWall',
        component: protectWall,
        meta: [],
      }, {
        path: '/bimManage',
        component: bimManage,
        meta: [],
      }, {
        path: '/bimDevice',
        component: bimDevice,
        meta: [],
      }, {
        path: '/bimWaterFlow',
        component: bimWaterFlow,
        meta: [],
      }, {
        path: '/netBuilding',
        component: netBuilding,
        meta: [],
      }, {
        path: '/customCoverage',
        component: customCoverage,
        meta: [],
      }, {
        path: '/customAttribute',
        component: customAttribute,
        meta: [],
      }, {
        path: '/customAttributeData',
        component: customAttributeData,
        meta: [],
      }, {
        path: '/equipManage',
        component: equipManage,
        meta: [],
      }, {
        path: '/firePlan',
        component: firePlan,
        meta: [],
      }, {
        path: '/mapAddress',
        component: mapAddress,
        meta: [],
      }, {
        path: '/mapStreet',
        component: mapStreet,
        meta: [],
      }, {
        path: '/protectPeople',
        component: protectPeople,
        meta: [],
      }, {
        path: '/realVehicle',
        component: realVehicle,
        meta: [],
      }, {
        path: '/realKnife',
        component: realKnife,
        meta: [],
      }, {
        path: '/realMachine',
        component: realMachine,
        meta: [],
      }, {
        path: '/netPipeline',
        component: netPipeline,
        meta: [],
      }, {
        path: '/netPipelineCheck',
        component: netPipelineCheck,
        meta: [],
      }, {
        path: '/netPipelineRoad',
        component: netPipelineRoad,
        meta: [],
      }, {
        path: '/sysFunc',
        component: sysFunc,
        meta: [],
      }, {
        path: '/sysRole',
        component: sysRole,
        meta: [],
      }, {
        path: '/sysApp',
        component: sysApp,
        meta: [],
      }, {
        path: '/accessCar',
        component: accessCar,
        meta: [],
      }, {
        path: '/accessMan',
        component: accessMan,
        meta: [],
      }, {
        path: '/cityThing',
        component: cityThing,
        meta: [],
      },{
        path: '/cityThingModel',
        component: cityThingModel,
        meta: [],
      }, {
        path: '/mapPhotos',
        component: mapPhotos,
        meta: [],
      }, {
        path: '/netMan',
        component: netMan,
        meta: [],
      }, {
        path: '/bimCaseModel',
        component: bimCaseModel,
        meta: [],
      }, {
        path: '/mapImage',
        component: mapImage,
        meta: [],
      }, {
        path: '/cityBuilding',
        component: cityBuilding,
        meta: [],
      }, {
        path: '/cityBuildingRemove',
        component: cityBuildingRemove,
        meta: [],
      }
    ]
  }
];

let router = new Router({
  routes,
});

export default router;

router.beforeEach((to, from, next) => {
  let islogin = localStorage.getItem("isLogin");
  if (to.path === "/") {
    if (islogin === "isLogin") {
      next("/main");
    } else {
      next();
    }
  } else {
    if (islogin === "isLogin") {
      next();
    } else {
      next("/");
    }
  }
});
