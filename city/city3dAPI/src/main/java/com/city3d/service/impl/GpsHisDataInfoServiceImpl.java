package com.city3d.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource3.GpsHisDataInfoMapper;
import com.city3d.dao.entry.GpsHisDataInfo;
import com.city3d.service.GpsHisDataInfoService;
import org.springframework.stereotype.Service;

@Service
public class GpsHisDataInfoServiceImpl implements GpsHisDataInfoService {
    @Autowired
    private GpsHisDataInfoMapper gpsHisDataInfoMapper;

    @Override
    public List<GpsHisDataInfo> getTracehisdata2Days(Map<String, Object> map) {
        return gpsHisDataInfoMapper.selectGpsInfosIn2Days(map);
    }

    @Override
    public List<GpsHisDataInfo> getTracehisdata(Map<String, Object> map) {
        return gpsHisDataInfoMapper.selectGpsInfosInOneDay(map);
    }

    @Override
    public List<GpsHisDataInfo> getTracehisdataAll7Days(Map<String, Object> map) {
        return gpsHisDataInfoMapper.getTracehisdataAll7Days(map);
    }

    @Override
    public List<GpsHisDataInfo> getHisDataAllDemo() {
        return gpsHisDataInfoMapper.getHisDataAllDemo();
    }
}
