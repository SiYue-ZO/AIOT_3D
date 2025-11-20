package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleSecurity;
import com.city3d.dao.entry.SysRoleSecurityExample;
import com.city3d.dao.mapper.datasource1.SysRoleSecurityMapper;
import com.city3d.service.SysRoleSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleSecurityServiceImpl implements SysRoleSecurityService {
    @Autowired
    private SysRoleSecurityMapper sysRoleSecurityMapper;

    @Override
    public int deleteSysRoleSecurity(String roleId) {
        SysRoleSecurityExample example = new SysRoleSecurityExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleSecurityMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleSecurity(SysRoleSecurity sysRoleSecurity) {
        return sysRoleSecurityMapper.insert(sysRoleSecurity);
    }
}
