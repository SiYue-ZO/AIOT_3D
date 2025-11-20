package com.city3d.dao.entry;

public class SysPara {
    private String sysId;

    private String sysName;

    private String sysType;

    private String sysContent;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId == null ? null : sysId.trim();
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType == null ? null : sysType.trim();
    }

    public String getSysContent() {
        return sysContent;
    }

    public void setSysContent(String sysContent) {
        this.sysContent = sysContent == null ? null : sysContent.trim();
    }
}