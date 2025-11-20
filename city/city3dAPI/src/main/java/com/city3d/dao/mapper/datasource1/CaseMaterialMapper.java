package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.CaseMaterial;
import com.city3d.dao.entry.CaseMaterialExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CaseMaterialMapper {
    int countByExample(CaseMaterialExample example);

    int deleteByExample(CaseMaterialExample example);

    int deleteByPrimaryKey(String caseMaterialId);

    int insert(CaseMaterial record);

    int insertSelective(CaseMaterial record);

    List<CaseMaterial> selectByExample(CaseMaterialExample example);

    CaseMaterial selectByPrimaryKey(String caseMaterialId);

    int updateByExampleSelective(@Param("record") CaseMaterial record, @Param("example") CaseMaterialExample example);

    int updateByExample(@Param("record") CaseMaterial record, @Param("example") CaseMaterialExample example);

    int updateByPrimaryKeySelective(CaseMaterial record);

    int updateByPrimaryKey(CaseMaterial record);
}