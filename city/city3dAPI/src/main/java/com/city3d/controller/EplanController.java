package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Eplan;
import com.city3d.service.EplanService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/eplan")
public class EplanController {
    @Autowired
    private EplanService eplanService;

    @RequestMapping("/getEplan")
    public @ResponseBody List<Eplan> getEplan() {
        return eplanService.getEplan();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Eplan eplan) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        eplan.setEplanId(uid);
        return eplanService.insert(eplan);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Eplan eplan) throws Exception {
        return eplanService.updateByPrimaryKey(eplan);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Eplan eplan) throws Exception {
        return eplanService.deleteByPrimaryKey(eplan.getEplanId());
    }
}
