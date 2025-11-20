package com.city3d.controller;

import java.util.List;

import com.city3d.service.SysRoleTiles3dService;
import com.city3d.vo.RoleTiles3d;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Tiles3d;
import com.city3d.service.Tiles3DService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/tiles3d")
public class Tiles3DController {
    @Autowired
    private Tiles3DService tiles3DService;

    @Autowired
    private SysRoleTiles3dService sysRoleTiles3dService;

    @RequestMapping("/getTiles3D")
    public @ResponseBody List<Tiles3d> getTiles3D() {
        return tiles3DService.getTiles3d();
    }

    @RequestMapping("/getTiles3DById")
    public @ResponseBody Tiles3d getTiles3DById(String tilesId) {
        return tiles3DService.getTiles3DById(tilesId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleTiles3d roleTiles3d) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleTiles3d.getTiles3d().setTilesId(uid);

        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        roleTiles3d.getSysRoleTiles3d().setRoleTilesId(uidRole);
        roleTiles3d.getSysRoleTiles3d().setTilesId(uid);

        sysRoleTiles3dService.insertSysRoleTiles3d(roleTiles3d.getSysRoleTiles3d());
        return tiles3DService.insert(roleTiles3d.getTiles3d());
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Tiles3d tiles3d) throws Exception {
        return tiles3DService.updateByPrimaryKey(tiles3d);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Tiles3d tiles3d) throws Exception {
        return tiles3DService.deleteByPrimaryKey(tiles3d.getTilesId());
    }
}
