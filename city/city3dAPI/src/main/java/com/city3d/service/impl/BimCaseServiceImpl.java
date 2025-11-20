package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BimCaseMapper;
import com.city3d.dao.entry.BimCase;
import com.city3d.service.BimCaseService;
import org.springframework.stereotype.Service;

@Service
public class BimCaseServiceImpl implements BimCaseService {
    @Autowired
    private BimCaseMapper bimCaseMapper;

    @Override
    public List<BimCase> getBimCase() {
        return bimCaseMapper.selectByExample(null);
    }

    @Override
    public int insert(BimCase bimCase) {
        return bimCaseMapper.insert(bimCase);
    }

    @Override
    public int updateByPrimaryKey(BimCase bimCase) {
        return bimCaseMapper.updateByPrimaryKey(bimCase);
    }

    @Override
    public int deleteByPrimaryKey(String bimCaseId) {
        return bimCaseMapper.deleteByPrimaryKey(bimCaseId);
    }
}
