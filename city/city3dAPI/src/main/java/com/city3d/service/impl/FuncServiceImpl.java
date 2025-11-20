package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysFuncMapperC;
import com.city3d.dao.entry.SysFunc;
import com.city3d.dao.entry.SysFuncExample;
import com.city3d.service.FuncService;
import org.springframework.stereotype.Service;

@Service
public class FuncServiceImpl implements FuncService {
    @Autowired
    private SysFuncMapperC sysFuncMapper;

    @Override
    public List<SysFunc> getFunc() {
        SysFuncExample example = new SysFuncExample();
        SysFuncExample.Criteria criteria = example.createCriteria();
        criteria.andFuncTypeNotEqualTo("不可选");
        return sysFuncMapper.selectByExample(example);
    }

    @Override
    public int insert(SysFunc sysFunc) {
        return sysFuncMapper.insert(sysFunc);
    }

    @Override
    public int updateByPrimaryKey(SysFunc sysFunc) {
        return sysFuncMapper.updateByPrimaryKey(sysFunc);
    }

    @Override
    public int deleteByPrimaryKey(String funcId) {
        return sysFuncMapper.deleteByPrimaryKey(funcId);
    }

    @Override
    public List<SysFunc> getFuncByLevel(SysFunc sysFunc) {
        SysFuncExample example = new SysFuncExample();
        SysFuncExample.Criteria criteria = example.createCriteria();
        criteria.andFuncLevelEqualTo(sysFunc.getFuncLevel());
        criteria.andFuncSrcEqualTo(sysFunc.getFuncSrc());
        return sysFuncMapper.selectByExample(example);
    }

    @Override
    public List<SysFunc> getFuncAndRel(String roleId) {
        return sysFuncMapper.getFuncAndRel(roleId);
    }

    @Override
    public List<SysFunc> getFuncBySrc(String funcSrc) {
        SysFuncExample example = new SysFuncExample();
        SysFuncExample.Criteria criteria = example.createCriteria();
        criteria.andFuncSrcEqualTo(funcSrc);
        return sysFuncMapper.selectByExample(example);
    }
}
