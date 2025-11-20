package com.city3d.service;

import com.city3d.dao.entry.SysRoleFunc;

public interface SysRoleFuncService {
    int deleteSysRoleFunc(String roleId);

    int insertSysRoleFunc(SysRoleFunc sysRoleFunc);
}
