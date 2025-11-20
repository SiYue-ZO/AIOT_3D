package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Uav;
import com.city3d.dao.entry.UavReal;

public interface UavService {
    List<Uav> getUav();

    int insert(Uav uav);

    int updateByPrimaryKey(Uav uav);

    int deleteByPrimaryKey(String uavId);

    List<UavReal> getUavPosByUavId(String uavId);

    List<UavReal> getUavPosByUavIds(String[] uavIds);
}
