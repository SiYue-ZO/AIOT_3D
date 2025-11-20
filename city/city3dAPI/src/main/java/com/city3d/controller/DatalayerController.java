package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Datalayer;
import com.city3d.service.DatalayerService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/datalayer")
public class DatalayerController {
    @Autowired
    private DatalayerService datalayerService;

    @RequestMapping("/getDatalayer")
    public @ResponseBody List<Datalayer> getDatalayer() {
        return datalayerService.getDatalayer();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Datalayer datalayer) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        datalayer.setLayerId(uid);
        return datalayerService.insert(datalayer);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody Datalayer datalayer) throws Exception {
        return datalayerService.updateByPrimaryKey(datalayer);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Datalayer datalayer) throws Exception {
        return datalayerService.deleteByPrimaryKey(datalayer.getLayerId());
    }
}
