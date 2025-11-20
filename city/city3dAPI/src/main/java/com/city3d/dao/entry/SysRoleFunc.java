package com.city3d.dao.entry;

public class SysRoleFunc {
    private String roleFuncId;

    private String funcId;

    private String funcName;

    private String roleId;

    private String roleFuncPid;

    private Integer roleFuncOrder;
    
    private SysFunc sysFunc;

    public SysFunc getSysFunc() {
		return sysFunc;
	}

	public void setSysFunc(SysFunc sysFunc) {
		this.sysFunc = sysFunc;
	}

    public String getRoleFuncId() {
        return roleFuncId;
    }

    public void setRoleFuncId(String roleFuncId) {
        this.roleFuncId = roleFuncId == null ? null : roleFuncId.trim();
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleFuncPid() {
        return roleFuncPid;
    }

    public void setRoleFuncPid(String roleFuncPid) {
        this.roleFuncPid = roleFuncPid == null ? null : roleFuncPid.trim();
    }

    public Integer getRoleFuncOrder() {
        return roleFuncOrder;
    }

    public void setRoleFuncOrder(Integer roleFuncOrder) {
        this.roleFuncOrder = roleFuncOrder;
    }
}