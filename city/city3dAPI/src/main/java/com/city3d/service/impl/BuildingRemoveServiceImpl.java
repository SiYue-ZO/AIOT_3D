package com.city3d.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BuildingRemoveMapperC;
import com.city3d.dao.entry.BuildingRemove;
import com.city3d.dao.entry.BuildingRemoveExample;
import com.city3d.dao.entry.BuildingRemoveExample.Criteria;
import com.city3d.service.BuildingRemoveService;
import org.springframework.stereotype.Service;

@Service
public class BuildingRemoveServiceImpl implements BuildingRemoveService {
    @Autowired
    private BuildingRemoveMapperC buildingRemoveMapperC;

    @Override
    public List<BuildingRemove> getBuildingRemove() {
        return buildingRemoveMapperC.selectBuildingRemoveAndAddress();
    }

    @Override
    public List<BuildingRemove> getBuildingRemoveByAddId(String addId) {
        return buildingRemoveMapperC.selectBuildingRemoveAndAddressByAddId(addId);
    }

    @Override
    public int insert(BuildingRemove buildingRemove) {
        return buildingRemoveMapperC.insert(buildingRemove);
    }

    @Override
    public int updateByPrimaryKey(BuildingRemove buildingRemove) {
        return buildingRemoveMapperC.updateByPrimaryKey(buildingRemove);
    }

    @Override
    public int deleteByPrimaryKey(String removeId) {
        return buildingRemoveMapperC.deleteByPrimaryKey(removeId);
    }

    @Override
    public int batchDelete(List<String> removeIds) {
        return buildingRemoveMapperC.batchDelete(removeIds);
    }

    @Override
    public int batchInsert(List<BuildingRemove> BuildingRemoves) {
        return buildingRemoveMapperC.batchInsert(BuildingRemoves);
    }

    @Override
    public List<BuildingRemove> queryBuildingRemove(BuildingRemove buildingRemove) {
        return buildingRemoveMapperC.selectByExampleR(buildingRemove);
    }

    @Override
    public List<BuildingRemove> getBuildingRemoveByPid(BuildingRemove buildingRemove) {
        return buildingRemoveMapperC.selectByRemovePid(buildingRemove.getRemovePid());
    }

    @Override
    public int countBuildingRemove() {
        return buildingRemoveMapperC.countByExample(null);
    }

    @Override
    public int countBuildingRemoveLand() {
        BuildingRemoveExample example = new BuildingRemoveExample();
        Criteria criteriaResult = example.or();
        criteriaResult = criteriaResult.andRemoveLandNumNotEqualTo("null");
        criteriaResult = criteriaResult.andRemoveLandNumNotEqualTo("");
        return buildingRemoveMapperC.countByExample(example);
    }

    @Override
    public double sumBuildingRemoveLandArea() {
        List<BuildingRemove> buildingRemoves = buildingRemoveMapperC.selectByExample(null);
        double result = 0.0;
        for (BuildingRemove buildingRemove : buildingRemoves) {
            if (buildingRemove.getRemoveLandArea() != null && !buildingRemove.getRemoveLandArea().equals("null") && !buildingRemove.getRemoveLandArea().equals(" ")) {
                result += Double.parseDouble(buildingRemove.getRemoveLandArea());
            }
        }
        return result;
    }

    @Override
    public double sumBuildingRemoveHouseArea() {
        List<BuildingRemove> buildingRemoves = buildingRemoveMapperC.selectByExample(null);
        double result = 0.0;
        for (BuildingRemove buildingRemove : buildingRemoves) {
            if (buildingRemove.getRemoveHouseArea() != null && !buildingRemove.getRemoveHouseArea().equals("null") && !buildingRemove.getRemoveHouseArea().equals(" ")) {
                result += Double.parseDouble(buildingRemove.getRemoveHouseArea());
            }
        }
        return result;
    }

    @Override
    public List<Object> countBuildingRemoveUse() {
        List<Object> resultList = new ArrayList<>();
        BuildingRemoveExample example = new BuildingRemoveExample();
        example.or().andRemoveUseEqualTo("住宅");
        int result1 = buildingRemoveMapperC.countByExample(example);
        resultList.add(result1);
        example.clear();

        example.or().andRemoveUseNotEqualTo("住宅");
        int result2 = buildingRemoveMapperC.countByExample(example);
        resultList.add(result2);

        return resultList;
    }

    @Override
    public List<Object> countBuildingRemoveLandNum() {
        List<Object> resultList = new ArrayList<>();
        BuildingRemoveExample example = new BuildingRemoveExample();

        example.or().andRemoveProTypeEqualTo("集体");
        int result1 = buildingRemoveMapperC.countByExample(example);
        resultList.add(result1);
        example.clear();

        example.or().andRemoveProTypeNotEqualTo("集体");
        int result2 = buildingRemoveMapperC.countByExample(example);
        resultList.add(result2);

        return resultList;
    }

    @Override
    public List<Object> countBuildingRemoveLandArea() {
        List<Object> resultList = new ArrayList<>();
        BuildingRemoveExample example = new BuildingRemoveExample();

        example.or().andRemoveProTypeEqualTo("集体");
        List<BuildingRemove> jtbuildingRemoves = buildingRemoveMapperC.selectByExample(example);
        double result1 = 0.0;
        for (BuildingRemove buildingRemove : jtbuildingRemoves) {
            if (buildingRemove.getRemoveLandArea() != null && !buildingRemove.getRemoveLandArea().equals("null") && !buildingRemove.getRemoveHouseArea().equals(" ")) {
                result1 += Double.parseDouble(buildingRemove.getRemoveLandArea());
            }
        }
        resultList.add(result1);
        example.clear();

        example.or().andRemoveProTypeNotEqualTo("集体");
        List<BuildingRemove> gybuildingRemoves = buildingRemoveMapperC.selectByExample(example);
        double result2 = 0.0;
        for (BuildingRemove buildingRemove : gybuildingRemoves) {
            if (buildingRemove.getRemoveLandArea() != null && !buildingRemove.getRemoveLandArea().equals("null") && !buildingRemove.getRemoveHouseArea().equals(" ")) {
                result2 += Double.parseDouble(buildingRemove.getRemoveLandArea());
            }
        }
        resultList.add(result2);

        return resultList;
    }
}
