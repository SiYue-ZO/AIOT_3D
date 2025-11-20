package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleCar;
import com.city3d.dao.entry.SysRoleCarExample;
import com.city3d.dao.mapper.datasource1.SysRoleCarMapper;
import com.city3d.service.SysRoleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleCarServiceImpl implements SysRoleCarService {
    @Autowired
    private SysRoleCarMapper sysRoleCarMapper;

    @Override
    public int deleteSysRoleCar(String roleId) {
        SysRoleCarExample example = new SysRoleCarExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleCarMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleCar(SysRoleCar sysRoleCar) {
        return sysRoleCarMapper.insert(sysRoleCar);
    }
}
