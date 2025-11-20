package com.city3d.dao.entry;

public class SysRoleNet {
    private String roleNetId;

    private String roleId;

    private String netId;

    private Net net;

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public String getRoleNetId() {
        return roleNetId;
    }

    public void setRoleNetId(String roleNetId) {
        this.roleNetId = roleNetId == null ? null : roleNetId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId == null ? null : netId.trim();
    }
}