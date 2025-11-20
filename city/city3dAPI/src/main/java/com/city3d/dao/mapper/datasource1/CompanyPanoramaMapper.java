package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.CompanyPanorama;
import com.city3d.dao.entry.CompanyPanoramaExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyPanoramaMapper {
    int countByExample(CompanyPanoramaExample example);

    int deleteByExample(CompanyPanoramaExample example);

    int deleteByPrimaryKey(String panoramaId);

    int insert(CompanyPanorama record);

    int insertSelective(CompanyPanorama record);

    List<CompanyPanorama> selectByExample(CompanyPanoramaExample example);

    CompanyPanorama selectByPrimaryKey(String panoramaId);

    int updateByExampleSelective(@Param("record") CompanyPanorama record, @Param("example") CompanyPanoramaExample example);

    int updateByExample(@Param("record") CompanyPanorama record, @Param("example") CompanyPanoramaExample example);

    int updateByPrimaryKeySelective(CompanyPanorama record);

    int updateByPrimaryKey(CompanyPanorama record);

}