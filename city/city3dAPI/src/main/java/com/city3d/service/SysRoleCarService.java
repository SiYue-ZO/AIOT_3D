package com.city3d.service;

import com.city3d.dao.entry.SysRoleCar;

public interface SysRoleCarService {
    int deleteSysRoleCar(String roleId);

    int insertSysRoleCar(SysRoleCar sysRoleCar);
}
