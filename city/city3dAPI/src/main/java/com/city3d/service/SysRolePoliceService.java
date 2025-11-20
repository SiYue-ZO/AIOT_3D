package com.city3d.service;

import com.city3d.dao.entry.SysRolePolice;

public interface SysRolePoliceService {
    int deleteSysRolePolice(String roleId);

    int insertSysRolePolice(SysRolePolice sysRolePolice);
}
