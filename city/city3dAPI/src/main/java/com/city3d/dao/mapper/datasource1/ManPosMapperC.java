package com.city3d.dao.mapper.datasource1;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.ManPos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManPosMapperC extends ManPosMapper {
    List<ManPos> getManPosWithNameAndOrigin(String[] deviceNums);

    List<ManPos> getTraceManPos2Days(Map<String, String> params);

    List<ManPos> getTraceManPosInOneDay(Map<String, String> params);
}