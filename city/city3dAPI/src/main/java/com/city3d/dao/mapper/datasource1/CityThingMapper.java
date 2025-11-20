package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.CityThing;
import com.city3d.dao.entry.CityThingExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CityThingMapper {
    int countByExample(CityThingExample example);

    int deleteByExample(CityThingExample example);

    int deleteByPrimaryKey(String thingId);

    int insert(CityThing record);

    int insertSelective(CityThing record);

    List<CityThing> selectByExample(CityThingExample example);

    CityThing selectByPrimaryKey(String thingId);

    int updateByExampleSelective(@Param("record") CityThing record, @Param("example") CityThingExample example);

    int updateByExample(@Param("record") CityThing record, @Param("example") CityThingExample example);

    int updateByPrimaryKeySelective(CityThing record);

    int updateByPrimaryKey(CityThing record);
}