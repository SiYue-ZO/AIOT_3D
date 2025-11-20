package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.SysRole;

public interface RoleService {
    List<SysRole> getRole();

    int insert(SysRole sysRole);

    int updateByPrimaryKey(SysRole sysRole);

    int deleteByPrimaryKey(String roleId);

    SysRole getAllandFuncById(String roleId);

    SysRole getAllandFuncByIdandSrc(SysRole sysRole);

    SysRole getAllandTiles3dById(String roleId);

    SysRole getAllandBimById(String roleId);

    SysRole getAllandCarById(String roleId);

    SysRole getAllandDeviceById(String roleId);

    SysRole getAllandNetById(String roleId);

    SysRole getAllandPoliceById(String roleId);

    SysRole getAllandSecurityById(String roleId);

    SysRole getAllandUavById(String roleId);

    SysRole getAllandVideoById(String roleId, String isIndoor);
}
