package com.city3d.dao.entry;

public class SysRoleUav {
    private String roleUavId;

    private String roleId;

    private String uavId;

    private Uav uav;

    public Uav getUav() {
        return uav;
    }

    public void setUav(Uav uav) {
        this.uav = uav;
    }

    public String getRoleUavId() {
        return roleUavId;
    }

    public void setRoleUavId(String roleUavId) {
        this.roleUavId = roleUavId == null ? null : roleUavId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUavId() {
        return uavId;
    }

    public void setUavId(String uavId) {
        this.uavId = uavId == null ? null : uavId.trim();
    }
}