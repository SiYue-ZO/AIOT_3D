package com.city3d.service;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.GpsHisDataInfo;

public interface GpsHisDataInfoService {
    List<GpsHisDataInfo> getTracehisdata(Map<String, Object> map);

    List<GpsHisDataInfo> getTracehisdata2Days(Map<String, Object> map);

    List<GpsHisDataInfo> getTracehisdataAll7Days(Map<String, Object> map);

    List<GpsHisDataInfo> getHisDataAllDemo();
}
