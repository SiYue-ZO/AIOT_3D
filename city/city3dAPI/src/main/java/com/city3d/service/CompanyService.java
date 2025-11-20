package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Company;

public interface CompanyService {
    List<Company> queryCompanyData(Company company);

    Company selectCompanyById(String companyId);

    List<Company> getCompanyByAddId(String addId);

    List<Company> getCompanyByComName(String community);

    int save(Company entity);

    int updateByPrimaryKey(Company entity);

    int deleteById(String id);

    int batchDelete(List<String> companyIds);
}
