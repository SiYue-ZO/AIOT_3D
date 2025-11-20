package com.city3d.vo;

import com.city3d.dao.entry.SysRoleUav;
import com.city3d.dao.entry.Uav;

public class RoleUav {
    Uav uav;

    SysRoleUav sysRoleUav;

    public Uav getUav() {
        return uav;
    }

    public void setUav(Uav uav) {
        this.uav = uav;
    }

    public SysRoleUav getSysRoleUav() {
        return sysRoleUav;
    }

    public void setSysRoleUav(SysRoleUav sysRoleUav) {
        this.sysRoleUav = sysRoleUav;
    }
}
