package com.city3d.vo;

import com.city3d.dao.entry.SysRoleTiles3d;
import com.city3d.dao.entry.Tiles3d;

public class RoleTiles3d {
    Tiles3d tiles3d;

    SysRoleTiles3d sysRoleTiles3d;

    public Tiles3d getTiles3d() {
        return tiles3d;
    }

    public void setTiles3d(Tiles3d tiles3d) {
        this.tiles3d = tiles3d;
    }

    public SysRoleTiles3d getSysRoleTiles3d() {
        return sysRoleTiles3d;
    }

    public void setSysRoleTiles3d(SysRoleTiles3d sysRoleTiles3d) {
        this.sysRoleTiles3d = sysRoleTiles3d;
    }
}
