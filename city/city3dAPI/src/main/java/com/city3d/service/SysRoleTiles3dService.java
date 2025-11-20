package com.city3d.service;

import com.city3d.dao.entry.SysRoleTiles3d;

public interface SysRoleTiles3dService {
    int deleteSysRoleTiles3d(String roleId);

    int insertSysRoleTiles3d(SysRoleTiles3d sysRoleTiles3d);
}
