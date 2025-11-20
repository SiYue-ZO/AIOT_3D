package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.SysApp;

public interface SysAppService {
    List<SysApp> getSysApp();

    int insert(SysApp sysApp);

    int updateByPrimaryKey(SysApp sysApp);

    int deleteByPrimaryKey(String appId);

    SysApp getAppById(String appId);
}
