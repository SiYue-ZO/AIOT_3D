package com.city3d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysRoleBimMapper;
import com.city3d.dao.entry.SysRoleBim;
import com.city3d.dao.entry.SysRoleBimExample;
import com.city3d.service.SysRoleBimService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleBimServiceImpl implements SysRoleBimService {
    @Autowired
    private SysRoleBimMapper sysRoleBimMapper;

    @Override
    public int deleteSysRoleBim(String roleId) {
        SysRoleBimExample example = new SysRoleBimExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleBimMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleBim(SysRoleBim sysRoleBim) {
        return sysRoleBimMapper.insert(sysRoleBim);
    }
}
