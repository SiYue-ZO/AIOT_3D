package com.city3d.controller;

import java.util.List;

import com.city3d.service.SysRoleUavService;
import com.city3d.vo.RoleUav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Uav;
import com.city3d.dao.entry.UavReal;
import com.city3d.service.UavService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/uav")
public class UavController {
    @Autowired
    private UavService uavService;

    @Autowired
    private SysRoleUavService sysRoleUavService;

    @RequestMapping("/getUav")
    public @ResponseBody List<Uav> getUav() {
        return uavService.getUav();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleUav roleUav) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleUav.getUav().setUavId(uid);

        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        roleUav.getSysRoleUav().setRoleUavId(uidRole);
        roleUav.getSysRoleUav().setUavId(uid);

        sysRoleUavService.insertSysRoleUav(roleUav.getSysRoleUav());
        return uavService.insert(roleUav.getUav());
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Uav uav) throws Exception {
        return uavService.updateByPrimaryKey(uav);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Uav uav) throws Exception {
        return uavService.deleteByPrimaryKey(uav.getUavId());
    }

    @RequestMapping("/getUavPosByUavId")
    public @ResponseBody List<UavReal> getUavPosByUavId(@RequestBody Uav uav) {
        return uavService.getUavPosByUavId(uav.getUavId());
    }

    @RequestMapping("/getUavPosByUavIds")
    public @ResponseBody List<UavReal> getUavPosByUavIds(@RequestBody Uav uav) {
        return uavService.getUavPosByUavIds(uav.getUavIds());
    }
}
