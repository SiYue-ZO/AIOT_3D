package com.city3d.service;

import com.city3d.dao.entry.SysRoleNet;

public interface SysRoleNetService {
    int deleteSysRoleNet(String roleId);

    int insertSysRoleNet(SysRoleNet sysRoleNet);
}
