package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Roam;
import com.city3d.service.RoamService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/roam")
public class RoamController {
    @Autowired
    private RoamService roamService;

    @RequestMapping("/getRoam")
    public @ResponseBody List<Roam> getRoam() {
        return roamService.getRoam();
    }

    @RequestMapping("/getRoamById")
    public @ResponseBody Roam getRoamById(String roamId) {
        return roamService.getRoamById(roamId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Roam roam) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roam.setRoamId(uid);
        return roamService.insert(roam);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Roam roam) throws Exception {
        return roamService.updateByPrimaryKey(roam);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Roam roam) throws Exception {
        return roamService.deleteByPrimaryKey(roam.getRoamId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Roam> roams) throws Exception {
        List<String> roamIds = new ArrayList<>();
        for (Roam roam : roams) {
            roamIds.add(roam.getRoamId());
        }
        return roamService.batchDelete(roamIds);
    }
}
