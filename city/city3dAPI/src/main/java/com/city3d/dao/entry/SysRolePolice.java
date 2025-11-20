package com.city3d.dao.entry;

public class SysRolePolice {
    private String rolePoliceId;

    private String roleId;

    private String policeId;

    private Police police;

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public String getRolePoliceId() {
        return rolePoliceId;
    }

    public void setRolePoliceId(String rolePoliceId) {
        this.rolePoliceId = rolePoliceId == null ? null : rolePoliceId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId == null ? null : policeId.trim();
    }
}