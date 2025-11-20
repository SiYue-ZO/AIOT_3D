package com.city3d.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.ManPos;
import com.city3d.service.ManPosService;

@Controller
@RequestMapping("/manPos")
public class ManPosController {
    @Autowired
    private ManPosService manPosService;

    @RequestMapping("/getHisDataByTime")
    public @ResponseBody List<ManPos> getHisDataByTime(@RequestBody Map<String, String> manPosMap) {
        Map<String, String> params = new HashMap<>();
        String startTime = manPosMap.get("startTime");
        String endTime = manPosMap.get("endTime");
        params.put("deviceNum", manPosMap.get("deviceNum"));
        params.put("startTime", startTime);
        params.put("endTime", endTime);

        String tableName1 = "man_pos_" + startTime.substring(0, 10).replace("-", "_");
        params.put("tableName1", tableName1);
        String tableName2 = "man_pos_" + endTime.substring(0, 10).replace("-", "_");
        params.put("tableName2", tableName2);

        if (!tableName1.equals(tableName2)) {
            return manPosService.getTraceManPos2Days(params);
        } else {
            return manPosService.getTraceManPosInOneDay(params);
        }
    }
}
