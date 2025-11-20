package com.city3d.vo;

import com.city3d.dao.entry.BimDevice;
import com.city3d.dao.entry.SysRoleDevice;

public class RoleDevice {
    BimDevice bimDevice;

    SysRoleDevice sysRoleBimDevice;

    public BimDevice getBimDevice() {
        return bimDevice;
    }

    public void setBimDevice(BimDevice bimDevice) {
        this.bimDevice = bimDevice;
    }

    public SysRoleDevice getSysRoleBimDevice() {
        return sysRoleBimDevice;
    }

    public void setSysRoleBimDevice(SysRoleDevice sysRoleBimDevice) {
        this.sysRoleBimDevice = sysRoleBimDevice;
    }
}
