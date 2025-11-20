package com.city3d.dao.entry;

public class SysRoleSecurity {
    private String roleSecurityId;

    private String roleId;

    private String securityId;

    private Security security;

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public String getRoleSecurityId() {
        return roleSecurityId;
    }

    public void setRoleSecurityId(String roleSecurityId) {
        this.roleSecurityId = roleSecurityId == null ? null : roleSecurityId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }
}