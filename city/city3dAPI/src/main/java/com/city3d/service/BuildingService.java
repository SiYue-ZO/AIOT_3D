package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Building;

public interface BuildingService {
    List<Building> getBuilding();

    Building getBuildingById(String buildingId);

    int insert(Building building);

    int updateByPrimaryKey(Building building);

    int deleteByPrimaryKey(String buildingId);

    List<Building> queryBuilding(Building building);

    int batchDelete(List<String> buildingIds);
}
