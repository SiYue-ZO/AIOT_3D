package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Coverage;
import com.city3d.service.CoverageService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/coverage")
public class CoverageController {
    @Autowired
    private CoverageService coverageService;

    @RequestMapping("/getCoverageAll")
    public @ResponseBody List<Coverage> getCoverageAll() {
        return coverageService.getCoverageAll();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Coverage coverage) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        coverage.setId(uid);
        return coverageService.insert(coverage);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody Coverage coverage) throws Exception {
        return coverageService.updateByPrimaryKey(coverage);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Coverage coverage) throws Exception {
        return coverageService.deleteByPrimaryKey(coverage.getId());
    }
}
