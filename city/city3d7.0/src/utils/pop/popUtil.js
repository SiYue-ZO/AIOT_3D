import Vue from 'vue'
import carPop from './components/pop-car.vue'
import poiPop from './components/pop-poi.vue'
import casePop from './components/pop-case.vue'
import buildingPop from './components/pop-building.vue'
import videoPop from './components/pop-video'
import manPop from './components/pop-man'
import kpPop from './components/pop-kp'
import rpPop from './components/pop-realPeople'
import rpaPop from './components/pop-realPeopleArea'
import rpcPop from './components/pop-realPeopleCom'
import rhPop from './components/pop-realHouse'
import rhaPop from './components/pop-realHouseArea'
import rhcPop from './components/pop-realHouseCom'
import rcPop from './components/pop-realCompany'
import rcaPop from './components/pop-realCompanyArea'
import raPop from './components/pop-realAddress'
import raaPop from './components/pop-realAddressArea'
import nmaPop from './components/pop-netManageArea'
import nmPop from './components/pop-netManage'
import nsPop from './components/pop-netSecurity'
import plPop from './components/pop-pipeline'
import pcPop from './components/pop-custom'
import waterPop from './components/pop-water'
import dePop from './components/pop-bimDevice'
import thingPop from './components/pop-thing'
import dpPop from './components/pop-dutyPoint';
import dlPop from './components/pop-dutyLine';
import dnPop from './components/pop-dutyNet';
import brPop from './components/pop-building-remove';
import braPop from './components/pop-buildingRemoveArea';
import brcPop from './components/pop-buildingRemoveCom';

export default {
  installMapPop() {
    return {
      carPop: this.initCar.bind(this),
      poiPop: this.initPoi.bind(this),
      casePop: this.initCase.bind(this),
      buildingPop: this.initBuilding.bind(this),
      videoPop: this.initVideo.bind(this),
      manPop: this.initMan.bind(this),
      kpPop: this.initKp.bind(this),
      rpPop: this.initRp.bind(this),
      rpaPop: this.initRpa.bind(this),
      rpcPop: this.initRpc.bind(this),
      rhPop: this.initRh.bind(this),
      rhaPop: this.initRha.bind(this),
      rhcPop: this.initRhc.bind(this),
      rcPop: this.initRc.bind(this),
      rcaPop: this.initRca.bind(this),
      raPop: this.initRa.bind(this),
      raaPop: this.initRaa.bind(this),
      nmaPop: this.initNma.bind(this),
      nmPop: this.initNm.bind(this),
      nsPop: this.initNs.bind(this),
      plPop: this.initPl.bind(this),
      pcPop: this.initPc.bind(this),
      waterPop: this.initWater.bind(this),
      dePop: this.initDe.bind(this),
      thingPop: this.initThing.bind(this),
      dpPop: this.initDutyPoint.bind(this),
      dlPop: this.initDutyLine.bind(this),
      dnPop: this.initDutyNet.bind(this),
      brPop: this.initBuildingRemove.bind(this),
      braPop: this.initBuildingRemoveArea.bind(this),
      brcPop: this.initBuildingRemoveCom.bind(this),
    }
  },

  initCar(options) {
    options.levelNum = 1;
    let Pop = Vue.extend(carPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initPoi(options) {
    options.levelNum = 2;
    let Pop = Vue.extend(poiPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initCase(options) {
    options.levelNum = 3;
    let Pop = Vue.extend(casePop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initBuilding(options) {
    options.levelNum = 4;
    let Pop = Vue.extend(buildingPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initVideo(options) {
    options.levelNum = 5;
    let Pop = Vue.extend(videoPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initMan(options) {
    options.levelNum = 6;
    let Pop = Vue.extend(manPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initKp(options) {
    options.levelNum = 7;
    let Pop = Vue.extend(kpPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRp(options) {
    options.levelNum = 8;
    let Pop = Vue.extend(rpPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRpa(options) {
    options.levelNum = 9;
    let Pop = Vue.extend(rpaPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRpc(options) {
    options.levelNum = 10;
    let Pop = Vue.extend(rpcPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRh(options) {
    options.levelNum = 11;
    let Pop = Vue.extend(rhPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRha(options) {
    options.levelNum = 12;
    let Pop = Vue.extend(rhaPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRhc(options) {
    options.levelNum = 13;
    let Pop = Vue.extend(rhcPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRc(options) {
    options.levelNum = 14;
    let Pop = Vue.extend(rcPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRca(options) {
    options.levelNum = 15;
    let Pop = Vue.extend(rcaPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRa(options) {
    options.levelNum = 16;
    let Pop = Vue.extend(raPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initRaa(options) {
    options.levelNum = 17;
    let Pop = Vue.extend(raaPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initNma(options) {
    options.levelNum = 18;
    let Pop = Vue.extend(nmaPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initNm(options) {
    options.levelNum = 19;
    let Pop = Vue.extend(nmPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initNs(options) {
    if (!document.getElementById("popupDiv" + options.popId)) {
      options.levelNum = 20;
      let Pop = Vue.extend(nsPop);
      let component = new Pop({
        data: options
      }).$mount();
      document.querySelector('body').appendChild(component.$el);
    }
  },
  initPl(options) {
    options.levelNum = 21;
    let Pop = Vue.extend(plPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initPc(options) {
    options.levelNum = 22;
    let Pop = Vue.extend(pcPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initWater(options) {
    options.levelNum = 23;
    let Pop = Vue.extend(waterPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initDe(options) {
    options.levelNum = 24;
    let Pop = Vue.extend(dePop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initThing(options) {
    options.levelNum = 25;
    let Pop = Vue.extend(thingPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initDutyPoint(options) {
    options.levelNum = 26;
    let Pop = Vue.extend(dpPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initDutyLine(options) {
    options.levelNum = 27;
    let Pop = Vue.extend(dlPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initDutyNet(options) {
    options.levelNum = 28;
    let Pop = Vue.extend(dnPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initBuildingRemove(options) {
    options.levelNum = 29;
    let Pop = Vue.extend(brPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initBuildingRemoveArea(options) {
    options.levelNum = 30;
    let Pop = Vue.extend(braPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
  initBuildingRemoveCom(options) {
    options.levelNum = 31;
    let Pop = Vue.extend(brcPop);
    let component = new Pop({
      data: options
    }).$mount();
    document.querySelector('body').appendChild(component.$el);
  },
}
