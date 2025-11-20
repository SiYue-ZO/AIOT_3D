package com.city3d.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysParaMapper;
import com.city3d.dao.entry.SysPara;
import com.city3d.dao.entry.SysParaExample;
import com.city3d.dao.entry.SysParaExample.Criteria;
import com.city3d.service.SysParaService;
import org.springframework.stereotype.Service;

@Service
public class SysParaServiceImpl implements SysParaService {
    @Autowired
    private SysParaMapper sysParaMapper;

    @Override
    public List<SysPara> getSysPara() {
        return sysParaMapper.selectByExample(null);
    }

    @Override
    public SysPara findSysParaById(String sysId) {
        return sysParaMapper.selectByPrimaryKey(sysId);
    }

    @Override
    public List<SysPara> querySysParabyType(SysPara sysPara) {
        SysParaExample example = new SysParaExample();
        Criteria criteriaResult = example.or();
        if (!Objects.equals(sysPara.getSysType(), "")) {
            criteriaResult = criteriaResult.andSysTypeEqualTo(sysPara.getSysType());
        }
        return sysParaMapper.selectByExample(example);
    }

    @Override
    public int insert(SysPara sysPara) {
        return sysParaMapper.insert(sysPara);
    }

    @Override
    public int updateByPrimaryKey(SysPara sysPara) {
        return sysParaMapper.updateByPrimaryKey(sysPara);
    }

    @Override
    public int deleteByPrimaryKey(String sysId) {
        return sysParaMapper.deleteByPrimaryKey(sysId);
    }
}
