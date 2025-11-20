package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Street;
import com.city3d.service.StreetService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/street")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreetAll")
    public @ResponseBody List<Street> getStreetAll() {
        return streetService.getStreetAll();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Street street) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        street.setStreetId(uid);
        return streetService.insert(street);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Street street) throws Exception {
        return streetService.updateByPrimaryKey(street);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Street street) throws Exception {
        return streetService.deleteByPrimaryKey(street.getStreetId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Street> streets) throws Exception {
        List<String> streetIds = new ArrayList<>();
        for (Street street : streets) {
            streetIds.add(street.getStreetId());
        }
        return streetService.batchDelete(streetIds);
    }
}
