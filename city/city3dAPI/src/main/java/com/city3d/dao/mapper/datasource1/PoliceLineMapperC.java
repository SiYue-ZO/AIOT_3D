package com.city3d.dao.mapper.datasource1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoliceLineMapperC extends PoliceLineMapper {
    int batchDelete(List<String> lIds);
}