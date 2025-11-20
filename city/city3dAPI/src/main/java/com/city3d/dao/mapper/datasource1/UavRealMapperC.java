package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.UavReal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UavRealMapperC extends UavRealMapper {
    List<UavReal> getUavPosByUavIds(String[] uavIds);
}