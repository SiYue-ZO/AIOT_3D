package com.city3d.service;

import com.city3d.dao.entry.SysRoleSecurity;

public interface SysRoleSecurityService {
    int deleteSysRoleSecurity(String roleId);

    int insertSysRoleSecurity(SysRoleSecurity sysRoleSecurity);
}
