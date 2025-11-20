package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.CompanyCheck;
import com.city3d.dao.entry.CompanyCheckExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyCheckMapper {
    int countByExample(CompanyCheckExample example);

    int deleteByExample(CompanyCheckExample example);

    int deleteByPrimaryKey(String companyCheckId);

    int insert(CompanyCheck record);

    int insertSelective(CompanyCheck record);

    List<CompanyCheck> selectByExample(CompanyCheckExample example);

    CompanyCheck selectByPrimaryKey(String companyCheckId);

    int updateByExampleSelective(@Param("record") CompanyCheck record, @Param("example") CompanyCheckExample example);

    int updateByExample(@Param("record") CompanyCheck record, @Param("example") CompanyCheckExample example);

    int updateByPrimaryKeySelective(CompanyCheck record);

    int updateByPrimaryKey(CompanyCheck record);
}