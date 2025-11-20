package com.city3d.vo;

import com.city3d.dao.entry.Net;
import com.city3d.dao.entry.SysRoleNet;

public class RoleNet {
    Net net;

    SysRoleNet sysRoleNet;

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public SysRoleNet getSysRoleNet() {
        return sysRoleNet;
    }

    public void setSysRoleNet(SysRoleNet sysRoleNet) {
        this.sysRoleNet = sysRoleNet;
    }
}
