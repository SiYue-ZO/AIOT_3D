package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CompanyMapperC;
import com.city3d.dao.entry.Company;
import com.city3d.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapperC companyMapperC;

    @Override
    public List<Company> queryCompanyData(Company company) {
        return companyMapperC.queryCompanyData(company);
    }

    @Override
    public Company selectCompanyById(String companyId) {
        return companyMapperC.selectCompanyById(companyId);
    }

    @Override
    public List<Company> getCompanyByAddId(String addId) {
        return companyMapperC.getCompanyByAddId(addId);
    }

    @Override
    public List<Company> getCompanyByComName(String community) {
        return companyMapperC.getCompanyByComName(community);
    }

    @Override
    public int save(Company entity) {
        return companyMapperC.insert(entity);
    }

    @Override
    public int updateByPrimaryKey(Company entity) {
        return companyMapperC.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(String id) {
        return companyMapperC.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<String> companyIds) {
        return companyMapperC.batchDelete(companyIds);
    }
}
