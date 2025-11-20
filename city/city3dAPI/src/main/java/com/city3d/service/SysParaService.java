package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.SysPara;

public interface SysParaService {
    List<SysPara> getSysPara();

    SysPara findSysParaById(String sysId);

    List<SysPara> querySysParabyType(SysPara sysPara);

    int insert(SysPara sysPara);

    int updateByPrimaryKey(SysPara sysPara);

    int deleteByPrimaryKey(String sysId);
}
