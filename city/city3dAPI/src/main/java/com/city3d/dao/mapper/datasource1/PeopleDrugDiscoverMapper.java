package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PeopleDrugDiscover;
import com.city3d.dao.entry.PeopleDrugDiscoverExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleDrugDiscoverMapper {
    int countByExample(PeopleDrugDiscoverExample example);

    int deleteByExample(PeopleDrugDiscoverExample example);

    int deleteByPrimaryKey(String drugDiscoverId);

    int insert(PeopleDrugDiscover record);

    int insertSelective(PeopleDrugDiscover record);

    List<PeopleDrugDiscover> selectByExample(PeopleDrugDiscoverExample example);

    PeopleDrugDiscover selectByPrimaryKey(String drugDiscoverId);

    int updateByExampleSelective(@Param("record") PeopleDrugDiscover record, @Param("example") PeopleDrugDiscoverExample example);

    int updateByExample(@Param("record") PeopleDrugDiscover record, @Param("example") PeopleDrugDiscoverExample example);

    int updateByPrimaryKeySelective(PeopleDrugDiscover record);

    int updateByPrimaryKey(PeopleDrugDiscover record);
}