package com.city3d.service;

import com.city3d.dao.entry.SysRoleDevice;

public interface SysRoleDeviceService {
    int deleteSysRoleDevice(String roleId);

    int insertSysRoleDevice(SysRoleDevice sysRoleDevice);
}
