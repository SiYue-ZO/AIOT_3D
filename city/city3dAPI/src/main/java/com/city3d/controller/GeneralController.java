package com.city3d.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.SysPara;
import com.city3d.service.GeneralService;
import com.city3d.vo.EchartDataVo;

@Controller
@RequestMapping("/general")
public class GeneralController {
    @Autowired
    private GeneralService generalService;

    @RequestMapping("/getChartData")
    public @ResponseBody List<EchartDataVo> getChartData() {
        List<EchartDataVo> result = new ArrayList<>();
        List<HashMap<String, String>> peopleResult = generalService.countPeople();
        List<HashMap<String, String>> addResult = generalService.countAdd();
        List<HashMap<String, String>> depResult = generalService.countDep();
        List<HashMap<String, String>> patrolResult = generalService.countPatrol();
        List<HashMap<String, String>> camResult = generalService.countCam();
        List<HashMap<String, String>> manResult = generalService.countMan();
        EchartDataVo echartDataVo1 = new EchartDataVo();
        echartDataVo1.setName("重点人口");
        echartDataVo1.setValue(String.valueOf(peopleResult.get(0).get("count")));
        echartDataVo1.setType("人口");
        result.add(echartDataVo1);
        EchartDataVo echartDataVo2 = new EchartDataVo();
        echartDataVo2.setName("流动人口");
        echartDataVo2.setValue(String.valueOf(peopleResult.get(1).get("count")));
        echartDataVo2.setType("人口");
        result.add(echartDataVo2);
        EchartDataVo echartDataVo3 = new EchartDataVo();
        echartDataVo3.setName("普通人口");
        echartDataVo3.setValue(String.valueOf(peopleResult.get(2).get("count")));
        echartDataVo3.setType("人口");
        result.add(echartDataVo3);
        EchartDataVo echartDataVo4 = new EchartDataVo();
        echartDataVo4.setName("地名地址");
        echartDataVo4.setValue(String.valueOf(addResult.get(0).get("count")));
        echartDataVo4.setType("地址");
        result.add(echartDataVo4);
        EchartDataVo echartDataVo5 = new EchartDataVo();
        echartDataVo5.setName("房屋");
        echartDataVo5.setValue(String.valueOf(addResult.get(1).get("count")));
        echartDataVo5.setType("地址");
        result.add(echartDataVo5);
        EchartDataVo echartDataVo6 = new EchartDataVo();
        echartDataVo6.setName("重点单位");
        echartDataVo6.setValue(String.valueOf(depResult.get(0).get("count")));
        echartDataVo6.setType("单位");
        result.add(echartDataVo6);
        EchartDataVo echartDataVo7 = new EchartDataVo();
        echartDataVo7.setName("消防列管单位");
        echartDataVo7.setValue(String.valueOf(depResult.get(1).get("count")));
        echartDataVo7.setType("单位");
        result.add(echartDataVo7);
        EchartDataVo echartDataVo8 = new EchartDataVo();
        echartDataVo8.setName("行业场所");
        echartDataVo8.setValue(String.valueOf(depResult.get(2).get("count")));
        echartDataVo8.setType("单位");
        result.add(echartDataVo8);
        EchartDataVo echartDataVo9 = new EchartDataVo();
        echartDataVo9.setName("巡逻点位");
        echartDataVo9.setValue(String.valueOf(patrolResult.get(0).get("count")));
        echartDataVo9.setType("巡逻");
        result.add(echartDataVo9);
        EchartDataVo echartDataVo10 = new EchartDataVo();
        echartDataVo10.setName("治安卡口");
        echartDataVo10.setValue(String.valueOf(patrolResult.get(1).get("count")));
        echartDataVo10.setType("巡逻");
        result.add(echartDataVo10);
        EchartDataVo echartDataVo11 = new EchartDataVo();
        echartDataVo11.setName("巡区");
        echartDataVo11.setValue(String.valueOf(patrolResult.get(2).get("count")));
        echartDataVo11.setType("巡逻");
        result.add(echartDataVo11);
        EchartDataVo echartDataVo12 = new EchartDataVo();
        echartDataVo12.setName("巡线");
        echartDataVo12.setValue(String.valueOf(patrolResult.get(3).get("count")));
        echartDataVo12.setType("巡逻");
        result.add(echartDataVo12);
        EchartDataVo echartDataVo13 = new EchartDataVo();
        echartDataVo13.setName("枪机");
        echartDataVo13.setValue(String.valueOf(camResult.get(0).get("count")));
        echartDataVo13.setType("摄像头");
        result.add(echartDataVo13);
        EchartDataVo echartDataVo14 = new EchartDataVo();
        echartDataVo14.setName("球机");
        echartDataVo14.setValue(String.valueOf(camResult.get(1).get("count")));
        echartDataVo14.setType("摄像头");
        result.add(echartDataVo14);
        EchartDataVo echartDataVo15 = new EchartDataVo();
        echartDataVo15.setName("高空贴地");
        echartDataVo15.setValue(String.valueOf(camResult.get(2).get("count")));
        echartDataVo15.setType("摄像头");
        result.add(echartDataVo15);
        EchartDataVo echartDataVo16 = new EchartDataVo();
        echartDataVo16.setName("车辆识别");
        echartDataVo16.setValue(String.valueOf(camResult.get(3).get("count")));
        echartDataVo16.setType("摄像头");
        result.add(echartDataVo16);
        EchartDataVo echartDataVo17 = new EchartDataVo();
        echartDataVo17.setName("人脸识别");
        echartDataVo17.setValue(String.valueOf(camResult.get(4).get("count")));
        echartDataVo17.setType("摄像头");
        result.add(echartDataVo17);
        EchartDataVo echartDataVo18 = new EchartDataVo();
        echartDataVo18.setName("警员");
        echartDataVo18.setValue(String.valueOf(manResult.get(0).get("count")));
        echartDataVo18.setType("力量");
        result.add(echartDataVo18);
        EchartDataVo echartDataVo19 = new EchartDataVo();
        echartDataVo19.setName("车辆");
        echartDataVo19.setValue(String.valueOf(manResult.get(1).get("count")));
        echartDataVo19.setType("力量");
        result.add(echartDataVo19);
        EchartDataVo echartDataVo20 = new EchartDataVo();
        echartDataVo20.setName("摩托");
        echartDataVo20.setValue(String.valueOf(manResult.get(2).get("count")));
        echartDataVo20.setType("力量");
        result.add(echartDataVo20);
        EchartDataVo echartDataVo21 = new EchartDataVo();
        echartDataVo21.setName("无人机");
        echartDataVo21.setValue(String.valueOf(manResult.get(3).get("count")));
        echartDataVo21.setType("力量");
        result.add(echartDataVo21);
        EchartDataVo echartDataVo22 = new EchartDataVo();
        echartDataVo22.setName("治安员");
        echartDataVo22.setValue(String.valueOf(manResult.get(4).get("count")));
        echartDataVo22.setType("力量");
        result.add(echartDataVo22);

        return result;
    }

    @RequestMapping("/countGeneralByExample")
    public @ResponseBody List<Object> countGeneralByExample() {
        return generalService.countGeneralByExample();
    }

    @RequestMapping("/getMain")
    public @ResponseBody List<SysPara> selectByExample() throws Exception {
        return generalService.getMain();
    }
}
