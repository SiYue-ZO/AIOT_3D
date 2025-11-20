package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleDevice;
import com.city3d.dao.entry.SysRoleDeviceExample;
import com.city3d.dao.mapper.datasource1.SysRoleDeviceMapper;
import com.city3d.service.SysRoleDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleDeviceServiceImpl implements SysRoleDeviceService {
    @Autowired
    private SysRoleDeviceMapper sysRoleDeviceMapper;

    @Override
    public int deleteSysRoleDevice(String roleId) {
        SysRoleDeviceExample example = new SysRoleDeviceExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleDeviceMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleDevice(SysRoleDevice sysRoleDevice) {
        return sysRoleDeviceMapper.insert(sysRoleDevice);
    }
}
