package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuildingMapperC extends BuildingMapper {
    int batchDelete(List<String> buildingIds);
}