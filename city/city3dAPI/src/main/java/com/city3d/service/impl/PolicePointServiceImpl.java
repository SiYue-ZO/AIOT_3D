package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PolicePointMapperC;
import com.city3d.dao.entry.PolicePoint;
import com.city3d.dao.entry.PolicePointExample;
import com.city3d.dao.entry.PolicePointExample.Criteria;
import com.city3d.service.PolicePointService;
import org.springframework.stereotype.Service;

@Service
public class PolicePointServiceImpl implements PolicePointService {
    @Autowired
    private PolicePointMapperC policePointMapper;

    @Override
    public List<PolicePoint> queryPolicePoint(PolicePoint policePoint) {
        PolicePointExample example = new PolicePointExample();
        Criteria criteriaResult = example.or();
        if (policePoint.getpName() != null) {
            criteriaResult = criteriaResult.andPNameLike("%" + policePoint.getpName() + "%");
        }
        if (policePoint.getpType() != null) {
            criteriaResult = criteriaResult.andPTypeLike("%" + policePoint.getpType() + "%");
        }
        return policePointMapper.selectByExample(example);
    }

    @Override
    public List<PolicePoint> getPolicePoint() {
        return policePointMapper.selectByExample(null);
    }

    @Override
    public PolicePoint findPolicePointById(String poiId) {
        return policePointMapper.selectByPrimaryKey(poiId);
    }

    @Override
    public int insert(PolicePoint policePoint) {
        return policePointMapper.insert(policePoint);
    }

    @Override
    public int updateByPrimaryKey(PolicePoint policePoint) {
        return policePointMapper.updateByPrimaryKey(policePoint);
    }

    @Override
    public int deleteByPrimaryKey(String poiId) {
        return policePointMapper.deleteByPrimaryKey(poiId);
    }

    @Override
    public int batchDelete(List<String> poiIds) {
        return policePointMapper.batchDelete(poiIds);
    }
}
