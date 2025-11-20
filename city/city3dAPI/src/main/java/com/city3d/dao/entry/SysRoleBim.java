package com.city3d.dao.entry;

public class SysRoleBim {
    private String roleBimId;

    private String roleId;

    private String tilesId;
    
    private Bim bim;

    public Bim getBim() {
		return bim;
	}

	public void setBim(Bim bim) {
		this.bim = bim;
	}

	public String getRoleBimId() {
        return roleBimId;
    }

    public void setRoleBimId(String roleBimId) {
        this.roleBimId = roleBimId == null ? null : roleBimId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getTilesId() {
        return tilesId;
    }

    public void setTilesId(String tilesId) {
        this.tilesId = tilesId == null ? null : tilesId.trim();
    }
}