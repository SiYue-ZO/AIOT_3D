package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysRoleMapperC;
import com.city3d.dao.entry.SysRole;
import com.city3d.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapperC sysRoleMapperC;

    @Override
    public List<SysRole> getRole() {
        return sysRoleMapperC.getAllandFunc();
    }

    @Override
    public int insert(SysRole sysRole) {
        return sysRoleMapperC.insert(sysRole);
    }

    @Override
    public int updateByPrimaryKey(SysRole sysRole) {
        return sysRoleMapperC.updateByPrimaryKey(sysRole);
    }

    @Override
    public int deleteByPrimaryKey(String roleId) {
        return sysRoleMapperC.deleteByPrimaryKey(roleId);
    }

    @Override
    public SysRole getAllandFuncById(String roleId) {
        return sysRoleMapperC.getAllandFuncById(roleId);
    }

    @Override
    public SysRole getAllandFuncByIdandSrc(SysRole sysRole) {
        return sysRoleMapperC.getAllandFuncByIdandSrc(sysRole);
    }

    @Override
    public SysRole getAllandTiles3dById(String roleId) {
        return sysRoleMapperC.getAllandTiles3dById(roleId);
    }

    @Override
    public SysRole getAllandBimById(String roleId) {
        return sysRoleMapperC.getAllandBimById(roleId);
    }

    @Override
    public SysRole getAllandCarById(String roleId) {
        return sysRoleMapperC.getAllandCarById(roleId);
    }

    @Override
    public SysRole getAllandDeviceById(String roleId) {
        return sysRoleMapperC.getAllandDeviceById(roleId);
    }

    @Override
    public SysRole getAllandNetById(String roleId) {
        return sysRoleMapperC.getAllandNetById(roleId);
    }

    @Override
    public SysRole getAllandPoliceById(String roleId) {
        return sysRoleMapperC.getAllandPoliceById(roleId);
    }

    @Override
    public SysRole getAllandSecurityById(String roleId) {
        return sysRoleMapperC.getAllandSecurityById(roleId);
    }

    @Override
    public SysRole getAllandUavById(String roleId) {
        return sysRoleMapperC.getAllandUavById(roleId);
    }

    @Override
    public SysRole getAllandVideoById(String roleId, String isIndoor) {
        return sysRoleMapperC.getAllandVideoById(roleId, isIndoor);
    }
}
