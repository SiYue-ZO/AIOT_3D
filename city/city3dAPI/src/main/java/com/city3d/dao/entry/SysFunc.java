package com.city3d.dao.entry;

public class SysFunc {
    private String funcId;

    private String funcUrl;

    private String funcIotName;

    private String funcIotImg;

    private String funcType;

    private String funcSrc;

    private String funcDefaultName;

    private String funcPid;

    private String funcLevel;

    private String funcIcon;
    
    private SysRoleFunc sysRoleFunc;

    public SysRoleFunc getSysRoleFunc() {
		return sysRoleFunc;
	}

	public void setSysRoleFunc(SysRoleFunc sysRoleFunc) {
		this.sysRoleFunc = sysRoleFunc;
	}

	public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getFuncIotName() {
        return funcIotName;
    }

    public void setFuncIotName(String funcIotName) {
        this.funcIotName = funcIotName == null ? null : funcIotName.trim();
    }

    public String getFuncIotImg() {
        return funcIotImg;
    }

    public void setFuncIotImg(String funcIotImg) {
        this.funcIotImg = funcIotImg == null ? null : funcIotImg.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public String getFuncSrc() {
        return funcSrc;
    }

    public void setFuncSrc(String funcSrc) {
        this.funcSrc = funcSrc == null ? null : funcSrc.trim();
    }

    public String getFuncDefaultName() {
        return funcDefaultName;
    }

    public void setFuncDefaultName(String funcDefaultName) {
        this.funcDefaultName = funcDefaultName == null ? null : funcDefaultName.trim();
    }

    public String getFuncPid() {
        return funcPid;
    }

    public void setFuncPid(String funcPid) {
        this.funcPid = funcPid == null ? null : funcPid.trim();
    }

    public String getFuncLevel() {
        return funcLevel;
    }

    public void setFuncLevel(String funcLevel) {
        this.funcLevel = funcLevel == null ? null : funcLevel.trim();
    }

    public String getFuncIcon() {
        return funcIcon;
    }

    public void setFuncIcon(String funcIcon) {
        this.funcIcon = funcIcon == null ? null : funcIcon.trim();
    }
}