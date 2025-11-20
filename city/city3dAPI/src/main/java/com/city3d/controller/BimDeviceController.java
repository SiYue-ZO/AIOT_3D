package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import com.city3d.service.SysRoleDeviceService;
import com.city3d.vo.RoleDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.BimDevice;
import com.city3d.service.BimDeviceService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/bimDevice")
public class BimDeviceController {
    @Autowired
    private BimDeviceService bimDeviceService;

    @Autowired
    private SysRoleDeviceService sysRoleDeviceService;

    @RequestMapping("/getBimDevice")
    public @ResponseBody List<BimDevice> getBimDevice() throws Exception {
        return bimDeviceService.getBimDevice();
    }

    @RequestMapping("/getBimDeviceById")
    public @ResponseBody BimDevice getBimDeviceById(@RequestBody BimDevice bimDevice) throws Exception {
        return bimDeviceService.getBimDeviceById(bimDevice.getDeviceId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleDevice roleDevice) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleDevice.getBimDevice().setDeviceId(uid);

        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        roleDevice.getSysRoleBimDevice().setRoleDeviceId(uidRole);
        roleDevice.getSysRoleBimDevice().setDeviceId(uid);

        sysRoleDeviceService.insertSysRoleDevice(roleDevice.getSysRoleBimDevice());
        return bimDeviceService.insert(roleDevice.getBimDevice());
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody BimDevice bimDevice) throws Exception {
        return bimDeviceService.updateByPrimaryKey(bimDevice);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody BimDevice bimDevice) throws Exception {
        return bimDeviceService.deleteByPrimaryKey(bimDevice.getDeviceId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<BimDevice> bimDevices) throws Exception {
        List<String> deviceIds = new ArrayList<>();
        for (BimDevice bimDevice : bimDevices) {
            deviceIds.add(bimDevice.getDeviceId());
        }
        return bimDeviceService.batchDelete(deviceIds);
    }
}
