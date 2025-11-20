package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysAppMapper;
import com.city3d.dao.entry.SysApp;
import com.city3d.service.SysAppService;
import org.springframework.stereotype.Service;

@Service
public class SysAppServiceImpl implements SysAppService {
    @Autowired
    private SysAppMapper sysAppMapper;

    @Override
    public List<SysApp> getSysApp() {
        return sysAppMapper.selectByExample(null);
    }

    @Override
    public int insert(SysApp sysApp) {
        return sysAppMapper.insert(sysApp);
    }

    @Override
    public int updateByPrimaryKey(SysApp sysApp) {
        return sysAppMapper.updateByPrimaryKey(sysApp);
    }

    @Override
    public int deleteByPrimaryKey(String appId) {
        return sysAppMapper.deleteByPrimaryKey(appId);
    }

    @Override
    public SysApp getAppById(String appId) {
        return sysAppMapper.selectByPrimaryKey(appId);
    }
}
