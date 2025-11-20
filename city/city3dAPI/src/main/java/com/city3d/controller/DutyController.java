package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Duty;
import com.city3d.service.DutyService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/duty")
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @RequestMapping("/getDutyInfoData")
    public @ResponseBody List<Duty> getDutyInfoData() {
        return dutyService.getDuty();
    }

    @RequestMapping("/getDutyById")
    public @ResponseBody Duty getDutyById(String dutyId) {
        return dutyService.getDutyById(dutyId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Duty duty) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        duty.setDutyId(uid);
        return dutyService.insert(duty);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Duty duty) throws Exception {
        return dutyService.updateByPrimaryKey(duty);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(String dutyId) throws Exception {
        return dutyService.deleteByPrimaryKey(dutyId);
    }
}