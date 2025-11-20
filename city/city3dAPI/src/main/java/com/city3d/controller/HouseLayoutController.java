package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.HouseLayout;
import com.city3d.service.HouseLayoutService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/layout")
public class HouseLayoutController {
    @Autowired
    private HouseLayoutService houseLayoutService;

    @RequestMapping("/getLayout")
    public @ResponseBody List<HouseLayout> getLayout() {
        return houseLayoutService.getHouseLayout();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody HouseLayout houseLayout) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        houseLayout.setLayoutId(uid);
        return houseLayoutService.insert(houseLayout);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody HouseLayout houseLayout) throws Exception {
        return houseLayoutService.updateByPrimaryKey(houseLayout);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody HouseLayout houseLayout) throws Exception {
        return houseLayoutService.deleteByPrimaryKey(houseLayout.getLayoutId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<HouseLayout> houseLayouts) throws Exception {
        List<String> layoutIds = new ArrayList<>();
        for (HouseLayout houseLayout : houseLayouts) {
            layoutIds.add(houseLayout.getLayoutId());
        }
        return houseLayoutService.batchDelete(layoutIds);
    }

    @RequestMapping("/getLayoutByName")
    public @ResponseBody List<HouseLayout> getLayoutByName(@RequestBody HouseLayout houseLayout) {
        return houseLayoutService.getLayoutByName(houseLayout.getLayoutName());
    }
}
