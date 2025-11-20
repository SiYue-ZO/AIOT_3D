package com.city3d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysRoleFuncMapper;
import com.city3d.dao.entry.SysRoleFunc;
import com.city3d.dao.entry.SysRoleFuncExample;
import com.city3d.service.SysRoleFuncService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleFuncServiceImpl implements SysRoleFuncService {
    @Autowired
    private SysRoleFuncMapper sysRoleFuncMapper;

    @Override
    public int deleteSysRoleFunc(String roleId) {
        SysRoleFuncExample example = new SysRoleFuncExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleFuncMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleFunc(SysRoleFunc sysRoleFunc) {
        return sysRoleFuncMapper.insert(sysRoleFunc);
    }
}
