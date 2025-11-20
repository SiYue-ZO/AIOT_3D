package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.HousePanorama;
import com.city3d.dao.entry.HousePanoramaExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HousePanoramaMapper {
    int countByExample(HousePanoramaExample example);

    int deleteByExample(HousePanoramaExample example);

    int deleteByPrimaryKey(String panoramaId);

    int insert(HousePanorama record);

    int insertSelective(HousePanorama record);

    List<HousePanorama> selectByExample(HousePanoramaExample example);

    HousePanorama selectByPrimaryKey(String panoramaId);

    int updateByExampleSelective(@Param("record") HousePanorama record, @Param("example") HousePanoramaExample example);

    int updateByExample(@Param("record") HousePanorama record, @Param("example") HousePanoramaExample example);

    int updateByPrimaryKeySelective(HousePanorama record);

    int updateByPrimaryKey(HousePanorama record);
}