package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PolicePoint;

public interface PolicePointService {
    List<PolicePoint> queryPolicePoint(PolicePoint policePoint);

    List<PolicePoint> getPolicePoint();

    PolicePoint findPolicePointById(String poiId);

    int insert(PolicePoint policePoint);

    int updateByPrimaryKey(PolicePoint policePoint);

    int deleteByPrimaryKey(String poiId);

    int batchDelete(List<String> poiIds);
}
