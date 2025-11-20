package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Wall;
import com.city3d.service.WallService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/wall")
public class WallController {
    @Autowired
    private WallService wallService;

    @RequestMapping("/getWall")
    public @ResponseBody List<Wall> getWall() {
        return wallService.getWall();
    }

    @RequestMapping("/getWallById")
    public @ResponseBody Wall getWallById(String wallId) {
        return wallService.getWallById(wallId);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Wall wall) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        wall.setWallId(uid);
        return wallService.insert(wall);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Wall wall) throws Exception {
        return wallService.updateByPrimaryKey(wall);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Wall wall) throws Exception {
        return wallService.deleteByPrimaryKey(wall.getWallId());
    }
}
