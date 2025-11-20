package com.city3d.service.impl;

import com.city3d.dao.entry.SysRolePolice;
import com.city3d.dao.entry.SysRolePoliceExample;
import com.city3d.dao.mapper.datasource1.SysRolePoliceMapper;
import com.city3d.service.SysRolePoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRolePoliceServiceImpl implements SysRolePoliceService {
    @Autowired
    private SysRolePoliceMapper sysRolePoliceMapper;

    @Override
    public int deleteSysRolePolice(String roleId) {
        SysRolePoliceExample example = new SysRolePoliceExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRolePoliceMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRolePolice(SysRolePolice sysRolePolice) {
        return sysRolePoliceMapper.insert(sysRolePolice);
    }
}
