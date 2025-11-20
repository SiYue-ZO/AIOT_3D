package com.city3d.service;

import com.city3d.dao.entry.SysRoleVideo;

public interface SysRoleVideoService {
    int deleteSysRoleVideo(String roleId);

    int insertSysRoleVideo(SysRoleVideo sysRoleVideo);
}
