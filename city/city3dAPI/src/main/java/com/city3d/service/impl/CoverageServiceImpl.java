package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CoverageMapper;
import com.city3d.dao.entry.Coverage;
import com.city3d.dao.entry.CoverageExample;
import com.city3d.service.CoverageService;
import org.springframework.stereotype.Service;

@Service
public class CoverageServiceImpl implements CoverageService {
    @Autowired
    private CoverageMapper coverageMapper;

    @Override
    public List<Coverage> getCoverageAll() {
        CoverageExample example = new CoverageExample();
        example.setOrderByClause("name");
        return coverageMapper.selectByExample(example);
    }

    @Override
    public int insert(Coverage coverage) {
        return coverageMapper.insert(coverage);
    }

    @Override
    public int updateByPrimaryKey(Coverage coverage) {
        return coverageMapper.updateByPrimaryKey(coverage);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return coverageMapper.deleteByPrimaryKey(id);
    }
}
