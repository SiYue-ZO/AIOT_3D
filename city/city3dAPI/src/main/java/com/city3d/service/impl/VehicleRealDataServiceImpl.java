package com.city3d.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource2.VehicleRealDataMapperC;
import com.city3d.dao.entry.VehicleRealData;
import com.city3d.service.VehicleRealDataService;
import org.springframework.stereotype.Service;

@Service
public class VehicleRealDataServiceImpl implements VehicleRealDataService {
    @Autowired
    private VehicleRealDataMapperC vehicleRealDataMapperC;

    @Override
    public VehicleRealData getVehicleByPhone(Map<String, Object> params) {
        return vehicleRealDataMapperC.selectByPhone(params);
    }

    @Override
    public List<VehicleRealData> getVehiclePartByPhone(List<String> simNos) {
        return vehicleRealDataMapperC.getVehiclePartByPhone(simNos);
    }
}
