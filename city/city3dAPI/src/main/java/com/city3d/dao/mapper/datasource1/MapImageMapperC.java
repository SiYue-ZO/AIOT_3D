package com.city3d.dao.mapper.datasource1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapImageMapperC extends MapImageMapper {
    int batchDelete(List<String> imageIds);
}