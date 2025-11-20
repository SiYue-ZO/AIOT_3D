package com.city3d.vo;

import com.city3d.dao.entry.Security;
import com.city3d.dao.entry.SysRoleSecurity;

public class RoleSecurity {
    Security security;

    SysRoleSecurity sysRoleSecurity;

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public SysRoleSecurity getSysRoleSecurity() {
        return sysRoleSecurity;
    }

    public void setSysRoleSecurity(SysRoleSecurity sysRoleSecurity) {
        this.sysRoleSecurity = sysRoleSecurity;
    }
}
