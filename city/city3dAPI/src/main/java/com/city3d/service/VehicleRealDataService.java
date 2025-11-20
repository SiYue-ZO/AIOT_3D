package com.city3d.service;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.VehicleRealData;

public interface VehicleRealDataService {
    VehicleRealData getVehicleByPhone(Map<String, Object> params);

    List<VehicleRealData> getVehiclePartByPhone(List<String> simNos);
}
