package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleNet;
import com.city3d.dao.entry.SysRoleNetExample;
import com.city3d.dao.mapper.datasource1.SysRoleNetMapper;
import com.city3d.service.SysRoleNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleNetServiceImpl implements SysRoleNetService {
    @Autowired
    private SysRoleNetMapper sysRoleNetMapper;


    @Override
    public int deleteSysRoleNet(String roleId) {
        SysRoleNetExample example = new SysRoleNetExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleNetMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleNet(SysRoleNet sysRoleNet) {
        return sysRoleNetMapper.insert(sysRoleNet);
    }
}
