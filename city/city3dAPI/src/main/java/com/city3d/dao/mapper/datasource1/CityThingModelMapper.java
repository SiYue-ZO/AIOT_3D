package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.CityThingModel;
import com.city3d.dao.entry.CityThingModelExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CityThingModelMapper {
    long countByExample(CityThingModelExample example);

    int deleteByExample(CityThingModelExample example);

    int deleteByPrimaryKey(String thingModelId);

    int insert(CityThingModel record);

    int insertSelective(CityThingModel record);

    List<CityThingModel> selectByExample(CityThingModelExample example);

    CityThingModel selectByPrimaryKey(String thingModelId);

    int updateByExampleSelective(@Param("record") CityThingModel record, @Param("example") CityThingModelExample example);

    int updateByExample(@Param("record") CityThingModel record, @Param("example") CityThingModelExample example);

    int updateByPrimaryKeySelective(CityThingModel record);

    int updateByPrimaryKey(CityThingModel record);
}