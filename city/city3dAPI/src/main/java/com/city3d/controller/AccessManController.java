package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.AccessMan;
import com.city3d.service.AccessManService;

@Controller
@RequestMapping("/accessMan")
public class AccessManController {
    @Autowired
    private AccessManService accessManService;

    @RequestMapping("/getAccessMan")
    public @ResponseBody List<AccessMan> getAccessMan() {
        return accessManService.getAccessMan();
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody AccessMan accessMan) throws Exception {
        return accessManService.deleteByPrimaryKey(accessMan.getAccessManId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<AccessMan> accessMans) throws Exception {
        List<String> accessManIds = new ArrayList<>();
        for (AccessMan accessMan : accessMans) {
            accessManIds.add(accessMan.getAccessManId());
        }
        return accessManService.batchDelete(accessManIds);
    }
}
