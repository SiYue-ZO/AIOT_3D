package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.HouseLayout;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseLayoutMapperC extends HouseLayoutMapper {
    List<HouseLayout> getHouseLayoutAll();

    int batchDelete(List<String> layoutIds);
}