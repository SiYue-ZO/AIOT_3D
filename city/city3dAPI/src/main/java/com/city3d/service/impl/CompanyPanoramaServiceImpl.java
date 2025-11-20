package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CompanyPanoramaMapper;
import com.city3d.dao.entry.CompanyPanorama;
import com.city3d.dao.entry.CompanyPanoramaExample;
import com.city3d.service.CompanyPanoramaService;
import org.springframework.stereotype.Service;

@Service
public class CompanyPanoramaServiceImpl implements CompanyPanoramaService {
    @Autowired
    private CompanyPanoramaMapper companyPanoramaMapper;

    @Override
    public List<CompanyPanorama> getCompanyPanoramaByCompanyId(String companyId) {
        CompanyPanoramaExample example = new CompanyPanoramaExample();
        example.createCriteria().andCompanyIdEqualTo(companyId);
        return companyPanoramaMapper.selectByExample(example);
    }

    @Override
    public List<CompanyPanorama> findByCompanyId(String companyId) {
        CompanyPanoramaExample example = new CompanyPanoramaExample();
        example.createCriteria().andCompanyIdEqualTo(companyId);
        return companyPanoramaMapper.selectByExample(example);
    }

    @Override
    public int save(CompanyPanorama entity) {
        return companyPanoramaMapper.insert(entity);
    }

    @Override
    public int updateByPrimaryKey(CompanyPanorama entity) {
        return companyPanoramaMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return companyPanoramaMapper.deleteByPrimaryKey(id);
    }
}
