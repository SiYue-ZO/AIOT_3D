package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PoliceLine;
import com.city3d.service.PoliceLineService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/policeLine")
public class PoliceLineController {
    @Autowired
    private PoliceLineService policeLineService;

    @RequestMapping("/queryPoliceLine")
    public @ResponseBody List<PoliceLine> queryPoliceLine(@RequestBody PoliceLine policeLine) {
        return policeLineService.queryPoliceLine(policeLine);
    }

    @RequestMapping("/getPoliceLine")
    public @ResponseBody List<PoliceLine> getPoliceLine() {
        return policeLineService.getPoliceLine();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody PoliceLine policeLine) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        policeLine.setlId(uid);
        return policeLineService.insert(policeLine);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody PoliceLine policeLine) throws Exception {
        return policeLineService.updateByPrimaryKey(policeLine);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody PoliceLine policeLine) throws Exception {
        return policeLineService.deleteByPrimaryKey(policeLine.getlId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PoliceLine> policeLines) throws Exception {
        List<String> lineIds = new ArrayList<>();
        for (PoliceLine policeLine : policeLines) {
            lineIds.add(policeLine.getlId());
        }
        return policeLineService.batchDelete(lineIds);
    }
}
