package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.BuildingRemove;

public interface BuildingRemoveService {
    List<BuildingRemove> getBuildingRemove();

    List<BuildingRemove> getBuildingRemoveByAddId(String addId);

    int insert(BuildingRemove buildingRemove);

    int updateByPrimaryKey(BuildingRemove buildingRemove);

    int deleteByPrimaryKey(String removeId);

    int batchDelete(List<String> removeIds);

    int batchInsert(List<BuildingRemove> BuildingRemoves);

    List<BuildingRemove> queryBuildingRemove(BuildingRemove buildingRemove);

    List<BuildingRemove> getBuildingRemoveByPid(BuildingRemove buildingRemove);

    int countBuildingRemove();

    int countBuildingRemoveLand();

    double sumBuildingRemoveLandArea();

    double sumBuildingRemoveHouseArea();

    List<Object> countBuildingRemoveUse();

    List<Object> countBuildingRemoveLandNum();

    List<Object> countBuildingRemoveLandArea();
}
