package com.city3d.service;

import com.city3d.dao.entry.SysRoleUav;

public interface SysRoleUavService {
    int deleteSysRoleUav(String roleId);

    int insertSysRoleUav(SysRoleUav sysRoleUav);
}
