package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.DutyMapper;
import com.city3d.dao.entry.Duty;
import com.city3d.service.DutyService;
import org.springframework.stereotype.Service;

@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    private DutyMapper dutyMapper;

    @Override
    public List<Duty> getDuty() {
        return dutyMapper.selectByExample(null);
    }

    @Override
    public Duty getDutyById(String dutyId) {
        return dutyMapper.selectByPrimaryKey(dutyId);
    }

    @Override
    public int insert(Duty duty) {
        return dutyMapper.insert(duty);
    }

    @Override
    public int updateByPrimaryKey(Duty duty) {
        return dutyMapper.updateByPrimaryKey(duty);
    }

    @Override
    public int deleteByPrimaryKey(String dutyId) {
        return dutyMapper.deleteByPrimaryKey(dutyId);
    }
}
