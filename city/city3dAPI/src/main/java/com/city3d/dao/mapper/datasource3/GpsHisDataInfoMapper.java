package com.city3d.dao.mapper.datasource3;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.GpsHisDataInfo;
import org.apache.ibatis.annotations.Mapper;

//@DataSource("datasource3")
@Mapper
public interface GpsHisDataInfoMapper {
    List<GpsHisDataInfo> selectGpsInfosIn2Days(Map<String, Object> map);

    List<GpsHisDataInfo> selectGpsInfosInOneDay(Map<String, Object> map);

    List<GpsHisDataInfo> getTracehisdataAll7Days(Map<String, Object> map);

    List<GpsHisDataInfo> getHisDataAllDemo();
}
