package com.city3d.controller;

import java.util.List;

import com.city3d.dao.entry.*;
import com.city3d.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private SysRoleFuncService sysRoleFuncService;

    @Autowired
    private SysRoleTiles3dService sysRoleTiles3dService;

    @Autowired
    private SysRoleBimService sysRoleBimService;

    @Autowired
    private SysRoleCarService sysRoleCarService;

    @Autowired
    private SysRolePoliceService sysRolePoliceService;

    @Autowired
    private SysRoleDeviceService sysRoleDeviceService;

    @Autowired
    private SysRoleNetService sysRoleNetService;

    @Autowired
    private SysRoleSecurityService sysRoleSecurityService;

    @Autowired
    private SysRoleUavService sysRoleUavService;

    @Autowired
    private SysRoleVideoService sysRoleVideoService;

    @RequestMapping("/getRole")
    public @ResponseBody List<SysRole> getRole() {
        return roleService.getRole();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody SysRole sysRole) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        sysRole.setRoleId(uid);
        int result = roleService.insert(sysRole);
        for (SysRoleFunc sysRoleFunc : sysRole.getSysRoleFunc()) {
            sysRoleFunc.setRoleId(uid);
            CharacterUtils roleFuncCharacterUtils = new CharacterUtils();
            String roleFuncuid = roleFuncCharacterUtils.getUUID();
            sysRoleFunc.setRoleFuncId(roleFuncuid);
            sysRoleFuncService.insertSysRoleFunc(sysRoleFunc);
        }
        for (SysRoleTiles3d sysRoleTiles3d : sysRole.getSysRoleTiles3d()) {
            sysRoleTiles3d.setRoleId(uid);
            CharacterUtils roleTiles3dCharacterUtils = new CharacterUtils();
            String roleTiles3duid = roleTiles3dCharacterUtils.getUUID();
            sysRoleTiles3d.setRoleTilesId(roleTiles3duid);
            sysRoleTiles3dService.insertSysRoleTiles3d(sysRoleTiles3d);
        }
        for (SysRoleBim sysRoleBim : sysRole.getSysRoleBim()) {
            sysRoleBim.setRoleId(uid);
            CharacterUtils roleBimCharacterUtils = new CharacterUtils();
            String roleBimuid = roleBimCharacterUtils.getUUID();
            sysRoleBim.setRoleBimId(roleBimuid);
            sysRoleBimService.insertSysRoleBim(sysRoleBim);
        }
        for (SysRoleCar sysRoleCar : sysRole.getSysRoleCar()) {
            sysRoleCar.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleCar.setRoleCarId(roleUid);
            sysRoleCarService.insertSysRoleCar(sysRoleCar);
        }
        for (SysRolePolice sysRolePolice : sysRole.getSysRolePolice()) {
            sysRolePolice.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRolePolice.setRolePoliceId(roleUid);
            sysRolePoliceService.insertSysRolePolice(sysRolePolice);
        }
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            sysRoleNet.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleNet.setRoleNetId(roleUid);
            sysRoleNetService.insertSysRoleNet(sysRoleNet);
        }
        for (SysRoleDevice sysRoleDevice : sysRole.getSysRoleDevice()) {
            sysRoleDevice.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleDevice.setRoleDeviceId(roleUid);
            sysRoleDeviceService.insertSysRoleDevice(sysRoleDevice);
        }
        for (SysRoleSecurity sysRoleSecurity : sysRole.getSysRoleSecurity()) {
            sysRoleSecurity.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleSecurity.setRoleSecurityId(roleUid);
            sysRoleSecurityService.insertSysRoleSecurity(sysRoleSecurity);
        }
        for (SysRoleUav sysRoleUav : sysRole.getSysRoleUav()) {
            sysRoleUav.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleUav.setRoleUavId(roleUid);
            sysRoleUavService.insertSysRoleUav(sysRoleUav);
        }
        for (SysRoleVideo sysRoleVideo : sysRole.getSysRoleVideo()) {
            sysRoleVideo.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleVideo.setRoleVideoId(roleUid);
            sysRoleVideoService.insertSysRoleVideo(sysRoleVideo);
        }
        for (SysRoleVideo sysRoleVideo : sysRole.getSysRoleVideoIndoor()) {
            sysRoleVideo.setRoleId(uid);
            CharacterUtils characterUtils1 = new CharacterUtils();
            String roleUid = characterUtils1.getUUID();
            sysRoleVideo.setRoleVideoId(roleUid);
            sysRoleVideoService.insertSysRoleVideo(sysRoleVideo);
        }
        return result;
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody SysRole sysRole) throws Exception {
        sysRoleFuncService.deleteSysRoleFunc(sysRole.getRoleId());
        sysRoleTiles3dService.deleteSysRoleTiles3d(sysRole.getRoleId());
        sysRoleBimService.deleteSysRoleBim(sysRole.getRoleId());
        sysRoleCarService.deleteSysRoleCar(sysRole.getRoleId());
        sysRolePoliceService.deleteSysRolePolice(sysRole.getRoleId());
        sysRoleNetService.deleteSysRoleNet(sysRole.getRoleId());
        sysRoleDeviceService.deleteSysRoleDevice(sysRole.getRoleId());
        sysRoleSecurityService.deleteSysRoleSecurity(sysRole.getRoleId());
        sysRoleUavService.deleteSysRoleUav(sysRole.getRoleId());
        sysRoleVideoService.deleteSysRoleVideo(sysRole.getRoleId());
        int result = roleService.updateByPrimaryKey(sysRole);
        for (SysRoleFunc sysRoleFunc : sysRole.getSysRoleFunc()) {
            sysRoleFunc.setRoleId(sysRole.getRoleId());
            CharacterUtils roleFuncCharacterUtils = new CharacterUtils();
            String roleFuncuid = roleFuncCharacterUtils.getUUID();
            sysRoleFunc.setRoleFuncId(roleFuncuid);
            sysRoleFuncService.insertSysRoleFunc(sysRoleFunc);
        }
        for (SysRoleTiles3d sysRoleTiles3d : sysRole.getSysRoleTiles3d()) {
            if (sysRoleTiles3d.getTilesId() != null) {
                sysRoleTiles3d.setRoleId(sysRole.getRoleId());
                CharacterUtils roleTiles3dCharacterUtils = new CharacterUtils();
                String roleTiles3duid = roleTiles3dCharacterUtils.getUUID();
                sysRoleTiles3d.setRoleTilesId(roleTiles3duid);
                sysRoleTiles3dService.insertSysRoleTiles3d(sysRoleTiles3d);
            }
        }
        for (SysRoleBim sysRoleBim : sysRole.getSysRoleBim()) {
            if (sysRoleBim.getTilesId() != null) {
                sysRoleBim.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleBim.setRoleBimId(roleBimuid);
                sysRoleBimService.insertSysRoleBim(sysRoleBim);
            }
        }
        for (SysRoleCar sysRoleCar : sysRole.getSysRoleCar()) {
            if (sysRoleCar.getCarId() != null) {
                sysRoleCar.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleCar.setRoleCarId(roleBimuid);
                sysRoleCarService.insertSysRoleCar(sysRoleCar);
            }
        }
        for (SysRolePolice sysRolePolice : sysRole.getSysRolePolice()) {
            if (sysRolePolice.getPoliceId() != null) {
                sysRolePolice.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRolePolice.setRolePoliceId(roleBimuid);
                sysRolePoliceService.insertSysRolePolice(sysRolePolice);
            }
        }
        for (SysRoleNet sysRoleNet : sysRole.getSysRoleNet()) {
            if (sysRoleNet.getNetId() != null) {
                sysRoleNet.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleNet.setRoleNetId(roleBimuid);
                sysRoleNetService.insertSysRoleNet(sysRoleNet);
            }
        }
        for (SysRoleDevice sysRoleDevice : sysRole.getSysRoleDevice()) {
            if (sysRoleDevice.getDeviceId() != null) {
                sysRoleDevice.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleDevice.setRoleDeviceId(roleBimuid);
                sysRoleDeviceService.insertSysRoleDevice(sysRoleDevice);
            }
        }
        for (SysRoleSecurity sysRoleSecurity : sysRole.getSysRoleSecurity()) {
            if (sysRoleSecurity.getSecurityId() != null) {
                sysRoleSecurity.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleSecurity.setRoleSecurityId(roleBimuid);
                sysRoleSecurityService.insertSysRoleSecurity(sysRoleSecurity);
            }
        }
        for (SysRoleUav sysRoleUav : sysRole.getSysRoleUav()) {
            if (sysRoleUav.getUavId() != null) {
                sysRoleUav.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleUav.setRoleUavId(roleBimuid);
                sysRoleUavService.insertSysRoleUav(sysRoleUav);
            }
        }
        for (SysRoleVideo sysRoleVideo : sysRole.getSysRoleVideo()) {
            if (sysRoleVideo.getVideoId() != null) {
                sysRoleVideo.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleVideo.setRoleVideoId(roleBimuid);
                sysRoleVideoService.insertSysRoleVideo(sysRoleVideo);
            }
        }
        for (SysRoleVideo sysRoleVideo : sysRole.getSysRoleVideoIndoor()) {
            if (sysRoleVideo.getVideoId() != null) {
                sysRoleVideo.setRoleId(sysRole.getRoleId());
                CharacterUtils roleBimCharacterUtils = new CharacterUtils();
                String roleBimuid = roleBimCharacterUtils.getUUID();
                sysRoleVideo.setRoleVideoId(roleBimuid);
                sysRoleVideoService.insertSysRoleVideo(sysRoleVideo);
            }
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody SysRole sysRole) throws Exception {
        int result = roleService.deleteByPrimaryKey(sysRole.getRoleId());
        sysRoleFuncService.deleteSysRoleFunc(sysRole.getRoleId());
        sysRoleTiles3dService.deleteSysRoleTiles3d(sysRole.getRoleId());
        sysRoleBimService.deleteSysRoleBim(sysRole.getRoleId());
        sysRoleCarService.deleteSysRoleCar(sysRole.getRoleId());
        sysRolePoliceService.deleteSysRolePolice(sysRole.getRoleId());
        sysRoleNetService.deleteSysRoleNet(sysRole.getRoleId());
        sysRoleDeviceService.deleteSysRoleDevice(sysRole.getRoleId());
        sysRoleSecurityService.deleteSysRoleSecurity(sysRole.getRoleId());
        sysRoleUavService.deleteSysRoleUav(sysRole.getRoleId());
        sysRoleVideoService.deleteSysRoleVideo(sysRole.getRoleId());
        return result;
    }

    @RequestMapping("/getAllandFuncById")
    public @ResponseBody SysRole getAllandFuncById(@RequestBody SysRole sysRole) {
        return roleService.getAllandFuncById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandFuncByIdandSrc")
    public @ResponseBody SysRole getAllandFuncByIdandSrc(@RequestBody SysRole sysRole) {
        return roleService.getAllandFuncByIdandSrc(sysRole);
    }

    @RequestMapping("/getAllandTiles3dById")
    public @ResponseBody SysRole getAllandTiles3dById(@RequestBody SysRole sysRole) {
        return roleService.getAllandTiles3dById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandBimById")
    public @ResponseBody SysRole getAllandBimById(@RequestBody SysRole sysRole) {
        return roleService.getAllandBimById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandCarById")
    public @ResponseBody SysRole getAllandCarById(@RequestBody SysRole sysRole) {
        return roleService.getAllandCarById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandDeviceById")
    public @ResponseBody SysRole getAllandDeviceById(@RequestBody SysRole sysRole) {
        return roleService.getAllandDeviceById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandNetById")
    public @ResponseBody SysRole getAllandNetById(@RequestBody SysRole sysRole) {
        return roleService.getAllandNetById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandPoliceById")
    public @ResponseBody SysRole getAllandPoliceById(@RequestBody SysRole sysRole) {
        return roleService.getAllandPoliceById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandSecurityById")
    public @ResponseBody SysRole getAllandSecurityById(@RequestBody SysRole sysRole) {
        return roleService.getAllandSecurityById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandUavById")
    public @ResponseBody SysRole getAllandUavById(@RequestBody SysRole sysRole) {
        return roleService.getAllandUavById(sysRole.getRoleId());
    }

    @RequestMapping("/getAllandVideoById")
    public @ResponseBody SysRole getAllandVideoById(@RequestBody SysRole sysRole) {
        return roleService.getAllandVideoById(sysRole.getRoleId(), sysRole.getRoleName());
    }
}
