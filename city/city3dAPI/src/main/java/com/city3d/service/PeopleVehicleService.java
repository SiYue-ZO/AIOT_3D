package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleVehicle;

public interface PeopleVehicleService {
    List<PeopleVehicle> selectPeopleVehicleAll();

    List<PeopleVehicle> findByPpId(String ppId);

    int insert(PeopleVehicle entity);

    int updateByPrimaryKey(PeopleVehicle entity);

    int deleteByPrimaryKey(String id);

    int batchDelete(List<String> vehicleIds);
}
