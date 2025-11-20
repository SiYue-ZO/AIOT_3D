package com.city3d.service.impl;

import com.city3d.dao.entry.SysRoleVideo;
import com.city3d.dao.entry.SysRoleVideoExample;
import com.city3d.dao.mapper.datasource1.SysRoleVideoMapper;
import com.city3d.service.SysRoleVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleVideoServiceImpl implements SysRoleVideoService {
    @Autowired
    private SysRoleVideoMapper sysRoleVideoMapper;

    @Override
    public int deleteSysRoleVideo(String roleId) {
        SysRoleVideoExample example = new SysRoleVideoExample();
        example.or().andRoleIdEqualTo(roleId);
        return sysRoleVideoMapper.deleteByExample(example);
    }

    @Override
    public int insertSysRoleVideo(SysRoleVideo sysRoleVideo) {
        return sysRoleVideoMapper.insert(sysRoleVideo);
    }
}
