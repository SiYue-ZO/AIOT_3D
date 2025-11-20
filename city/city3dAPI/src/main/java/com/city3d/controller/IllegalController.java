package com.city3d.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PeopleIllegal;
import com.city3d.service.PeopleIllegalService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.Res;

@Controller
@RequestMapping("/illegal")
public class IllegalController {
    //此接口没有应用，留作学习使用
    @Autowired
    private PeopleIllegalService peopleIllegalService;

    @RequestMapping("/getByPeopleId")
    public @ResponseBody Object getByPeopleId(@RequestBody Map param) {
        String ppId = (String) param.get("peopleId");
        if (StringUtils.isEmpty(ppId)) {
            return null;
        }
        return peopleIllegalService.findByPpId(ppId);
    }

    @RequestMapping("/save")
    public @ResponseBody Object save(@RequestBody PeopleIllegal entity) {
        if (StringUtils.isBlank(entity.getIllegalId())) {
            CharacterUtils characterUtils = new CharacterUtils();
            String illegalId = characterUtils.getUUID();
            entity.setIllegalId(illegalId);
            int result = peopleIllegalService.save(entity);
            return Res.success();
        } else {
            int result = peopleIllegalService.updateByPrimaryKey(entity);
            return Res.success();
        }
    }

    @RequestMapping("/delete")
    public @ResponseBody Object delete(@RequestBody Map param) {
        String id = (String) param.get("illegalId");
        int result = peopleIllegalService.deleteById(id);
        return Res.success();
    }
}
