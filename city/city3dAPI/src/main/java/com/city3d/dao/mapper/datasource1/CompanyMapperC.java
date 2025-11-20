package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapperC extends CompanyMapper {
    List<Company> queryCompanyData(Company company);

    Company selectCompanyById(String companyId);

    List<Company> getCompanyByAddId(String addId);

    List<Company> getCompanyByComName(String community);

    int batchDelete(List<String> companyIds);
}