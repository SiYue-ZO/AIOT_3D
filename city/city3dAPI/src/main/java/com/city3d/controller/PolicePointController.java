package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PolicePoint;
import com.city3d.service.PolicePointService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/policePoint")
public class PolicePointController {
    @Autowired
    private PolicePointService policePointService;

    @RequestMapping("/queryPolicePoint")
    public @ResponseBody List<PolicePoint> queryPolicePoint(@RequestBody PolicePoint policePoint) {
        return policePointService.queryPolicePoint(policePoint);
    }

    @RequestMapping("/getPolicePoint")
    public @ResponseBody List<PolicePoint> getPolicePoint() {
        return policePointService.getPolicePoint();
    }

    @RequestMapping("/getPolicePointById")
    public @ResponseBody PolicePoint getPolicePointById(String pId) {
        return policePointService.findPolicePointById(pId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody PolicePoint policePoint) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        policePoint.setpId(uid);
        return policePointService.insert(policePoint);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody PolicePoint policePoint) throws Exception {
        return policePointService.updateByPrimaryKey(policePoint);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody PolicePoint policePoint) throws Exception {
        return policePointService.deleteByPrimaryKey(policePoint.getpId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PolicePoint> policePoints) throws Exception {
        List<String> pIds = new ArrayList<>();
        for (PolicePoint policePoint : policePoints) {
            pIds.add(policePoint.getpId());
        }
        return policePointService.batchDelete(pIds);
    }
}
