package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BuildingMapperC;
import com.city3d.dao.entry.Building;
import com.city3d.dao.entry.BuildingExample;
import com.city3d.dao.entry.BuildingExample.Criteria;
import com.city3d.service.BuildingService;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapperC buildingMapper;

    @Override
    public List<Building> getBuilding() {
        return buildingMapper.selectByExample(null);
    }

    @Override
    public Building getBuildingById(String buildingId) {
        return buildingMapper.selectByPrimaryKey(buildingId);
    }

    @Override
    public int insert(Building building) {
        return buildingMapper.insert(building);
    }

    @Override
    public int updateByPrimaryKey(Building building) {
        return buildingMapper.updateByPrimaryKey(building);
    }

    @Override
    public int deleteByPrimaryKey(String buildingId) {
        return buildingMapper.deleteByPrimaryKey(buildingId);
    }

    @Override
    public List<Building> queryBuilding(Building building) {
        BuildingExample example = new BuildingExample();
        Criteria criteriaResult = example.or();
        if (building.getDbnum() != null) {
            criteriaResult = criteriaResult.andDbnumLike("%" + building.getDbnum() + "%");
        }
        if (building.getTdxz() != null) {
            criteriaResult = criteriaResult.andTdxzLike("%" + building.getTdxz() + "%");
        }
        if (building.getYxgs() != null) {
            criteriaResult = criteriaResult.andYxgsLike("%" + building.getYxgs() + "%");
        }
        if (building.getFwcs() != null) {
            criteriaResult = criteriaResult.andFwcsLike("%" + building.getFwcs() + "%");
        }
        if (building.getFwjg() != null) {
            criteriaResult = criteriaResult.andFwjgLike("%" + building.getFwjg() + "%");
        }
        if (building.getZdh() != null) {
            criteriaResult = criteriaResult.andZdhLike("%" + building.getZdh() + "%");
        }
        if (building.getFczh() != null) {
            criteriaResult = criteriaResult.andFczhLike("%" + building.getFczh() + "%");
        }
        return buildingMapper.selectByExample(example);
    }

    @Override
    public int batchDelete(List<String> buildingIds) {
        return buildingMapper.batchDelete(buildingIds);
    }
}
