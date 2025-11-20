package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.BimCase;
import com.city3d.service.BimCaseService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/bimCase")
public class BimCaseController {
    @Autowired
    private BimCaseService bimCaseService;

    @RequestMapping("/getBimCase")
    public @ResponseBody List<BimCase> getBimCase() {
        return bimCaseService.getBimCase();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody BimCase bimCase) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        bimCase.setBimCaseId(uid);
        return bimCaseService.insert(bimCase);
    }

    //	放置后期需要更新，此接口暂留
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody BimCase bimCase) throws Exception {
        return bimCaseService.updateByPrimaryKey(bimCase);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody BimCase bimCase) throws Exception {
        return bimCaseService.deleteByPrimaryKey(bimCase.getBimCaseId());
    }
}
