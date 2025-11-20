package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CompanyCheckMapper;
import com.city3d.dao.entry.CompanyCheck;
import com.city3d.dao.entry.CompanyCheckExample;
import com.city3d.service.CompanyCheckService;
import org.springframework.stereotype.Service;

@Service
public class CompanyCheckServiceImpl implements CompanyCheckService {
    @Autowired
    private CompanyCheckMapper companyCheckMapper;

    @Override
    public List<CompanyCheck> findByCompanyId(String companyId) {
        CompanyCheckExample example = new CompanyCheckExample();
        example.createCriteria().andCompanyIdEqualTo(companyId);
        return companyCheckMapper.selectByExample(example);
    }

    @Override
    public int save(CompanyCheck entity) {
        return companyCheckMapper.insert(entity);
    }

    @Override
    public int updateByPrimaryKey(CompanyCheck entity) {
        return companyCheckMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return companyCheckMapper.deleteByPrimaryKey(id);
    }
}
