package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import com.city3d.service.SysRoleBimService;
import com.city3d.vo.RoleBim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Bim;
import com.city3d.service.BimService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/bim")
public class BimController {
    @Autowired
    private BimService bimService;

    @Autowired
    private SysRoleBimService sysRoleBimService;

    @RequestMapping("/getBim")
    public @ResponseBody List<Bim> getBim() {
        return bimService.getBim();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleBim roleBim) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleBim.getBim().setTilesId(uid);

        CharacterUtils characterUtilsBim = new CharacterUtils();
        String uidBim = characterUtilsBim.getUUID();
        roleBim.getSysRoleBim().setRoleBimId(uidBim);
        roleBim.getSysRoleBim().setTilesId(uid);

        sysRoleBimService.insertSysRoleBim(roleBim.getSysRoleBim());
        return bimService.insert(roleBim.getBim());
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Bim bim) throws Exception {
        return bimService.updateByPrimaryKey(bim);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Bim bim) throws Exception {
        return bimService.deleteByPrimaryKey(bim.getTilesId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Bim> bims) throws Exception {
        List<String> tilesIds = new ArrayList<>();
        for (Bim bim : bims) {
            tilesIds.add(bim.getTilesId());
        }
        return bimService.batchDelete(tilesIds);
    }
}
