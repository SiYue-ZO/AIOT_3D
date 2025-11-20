package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.BuildingRemove;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildingRemoveMapperC extends BuildingRemoveMapper {
    int batchDelete(List<String> removeIds);

    int batchInsert(@Param("buildingRemoveList") List<BuildingRemove> buildingRemoveList);

    List<BuildingRemove> selectBuildingRemoveAndAddress();

    List<BuildingRemove> selectBuildingRemoveAndAddressByAddId(String removeSite);

    List<BuildingRemove> selectByExampleR(BuildingRemove buildingRemove);

    List<BuildingRemove> selectByRemovePid(String RemovePid);
}