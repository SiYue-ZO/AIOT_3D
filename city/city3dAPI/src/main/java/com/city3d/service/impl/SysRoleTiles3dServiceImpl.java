package com.city3d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysRoleTiles3dMapper;
import com.city3d.dao.entry.SysRoleTiles3d;
import com.city3d.dao.entry.SysRoleTiles3dExample;
import com.city3d.service.SysRoleTiles3dService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleTiles3dServiceImpl implements SysRoleTiles3dService {
    @Autowired
    private SysRoleTiles3dMapper sysRoleTiles3dMapper;

    @Override
    public int deleteSysRoleTiles3d(String roleId) {
        SysRoleTiles3dExample example = new SysRoleTiles3dExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleTiles3dMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleTiles3d(SysRoleTiles3d sysRoleTiles3d) {
        return sysRoleTiles3dMapper.insert(sysRoleTiles3d);
    }
}
