package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.CompanyPanorama;

public interface CompanyPanoramaService {
    List<CompanyPanorama> getCompanyPanoramaByCompanyId(String companyId);

    List<CompanyPanorama> findByCompanyId(String companyId);

    int save(CompanyPanorama entity);

    int updateByPrimaryKey(CompanyPanorama entity);

    int deleteByPrimaryKey(String id);
}
