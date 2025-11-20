package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.PeopleRoute;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleRouteMapperC extends PeopleRouteMapper {
    List<PeopleRoute> selectPeopleRoute();
}