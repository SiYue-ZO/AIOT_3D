package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.PeopleRoute;
import com.city3d.dao.entry.PeopleRouteExample;

@Mapper
public interface PeopleRouteMapper {
    int countByExample(PeopleRouteExample example);

    int deleteByExample(PeopleRouteExample example);

    int deleteByPrimaryKey(String routeId);

    int insert(PeopleRoute record);

    int insertSelective(PeopleRoute record);

    List<PeopleRoute> selectByExample(PeopleRouteExample example);

    PeopleRoute selectByPrimaryKey(String routeId);

    int updateByExampleSelective(@Param("record") PeopleRoute record, @Param("example") PeopleRouteExample example);

    int updateByExample(@Param("record") PeopleRoute record, @Param("example") PeopleRouteExample example);

    int updateByPrimaryKeySelective(PeopleRoute record);

    int updateByPrimaryKey(PeopleRoute record);
}