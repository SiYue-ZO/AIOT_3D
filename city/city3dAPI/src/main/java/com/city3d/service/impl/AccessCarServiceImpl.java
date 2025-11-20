package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AccessCarMapperC;
import com.city3d.dao.entry.AccessCar;
import com.city3d.service.AccessCarService;
import org.springframework.stereotype.Service;

@Service
public class AccessCarServiceImpl implements AccessCarService {
    @Autowired
    private AccessCarMapperC accessCarMapper;

    @Override
    public List<AccessCar> getAccessCar() {
        return accessCarMapper.selectByExample(null);
    }

    @Override
    public int deleteByPrimaryKey(String accessCarId) {
        return accessCarMapper.deleteByPrimaryKey(accessCarId);
    }

    @Override
    public int batchDelete(List<String> accessCarIds) {
        return accessCarMapper.batchDelete(accessCarIds);
    }
}
