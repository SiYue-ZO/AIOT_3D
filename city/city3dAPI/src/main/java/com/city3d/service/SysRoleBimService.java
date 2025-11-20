package com.city3d.service;

import com.city3d.dao.entry.SysRoleBim;

public interface SysRoleBimService {
    int deleteSysRoleBim(String roleId);

    int insertSysRoleBim(SysRoleBim sysRoleBim);
}
