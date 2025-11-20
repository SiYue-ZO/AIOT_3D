package com.city3d.dao.entry;

public class SysRoleDevice {
    private String roleDeviceId;

    private String roleId;

    private String deviceId;

    private BimDevice bimDevice;

    public BimDevice getBimDevice() {
        return bimDevice;
    }

    public void setBimDevice(BimDevice bimDevice) {
        this.bimDevice = bimDevice;
    }

    public String getRoleDeviceId() {
        return roleDeviceId;
    }

    public void setRoleDeviceId(String roleDeviceId) {
        this.roleDeviceId = roleDeviceId == null ? null : roleDeviceId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }
}