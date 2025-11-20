package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleUav;
import com.city3d.dao.entry.SysRoleUavExample;
import com.city3d.dao.mapper.datasource1.SysRoleUavMapper;
import com.city3d.service.SysRoleUavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleUavServiceImpl implements SysRoleUavService {
    @Autowired
    private SysRoleUavMapper sysRoleUavMapper;

    @Override
    public int deleteSysRoleUav(String roleId) {
        SysRoleUavExample example = new SysRoleUavExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleUavMapper.deleteByExample(example);
    }

    public int insertSysRoleUav(SysRoleUav sysRoleUav) {
        return sysRoleUavMapper.insert(sysRoleUav);
    }
}
