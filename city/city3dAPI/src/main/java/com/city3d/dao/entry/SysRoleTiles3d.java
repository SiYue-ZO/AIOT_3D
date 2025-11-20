package com.city3d.dao.entry;

public class SysRoleTiles3d {
    private String roleTilesId;

    private String roleId;

    private String tilesId;
    
    private Tiles3d tiles3d;

    public Tiles3d getTiles3d() {
		return tiles3d;
	}

	public void setTiles3d(Tiles3d tiles3d) {
		this.tiles3d = tiles3d;
	}

	public String getRoleTilesId() {
        return roleTilesId;
    }

    public void setRoleTilesId(String roleTilesId) {
        this.roleTilesId = roleTilesId == null ? null : roleTilesId.trim();
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