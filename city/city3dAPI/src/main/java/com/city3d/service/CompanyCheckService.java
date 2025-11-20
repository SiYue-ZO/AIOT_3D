package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.CompanyCheck;

public interface CompanyCheckService {
    List<CompanyCheck> findByCompanyId(String companyId);

    int save(CompanyCheck entity);

    int updateByPrimaryKey(CompanyCheck entity);

    int deleteByPrimaryKey(String id);
}
