package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleMachineMapperC;
import com.city3d.dao.entry.PeopleMachine;
import com.city3d.service.PeopleMachineService;
import org.springframework.stereotype.Service;

@Service
public class PeopleMachineServiceImpl implements PeopleMachineService {
    @Autowired
    private PeopleMachineMapperC peopleMachineMapper;

    @Override
    public List<PeopleMachine> selectPeopleMachineAll() {
        return peopleMachineMapper.selectPeopleMachineAll();
    }

    @Override
    public int updateByPrimaryKey(PeopleMachine entity) {
        return peopleMachineMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int save(PeopleMachine entity) {
        return peopleMachineMapper.insert(entity);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return peopleMachineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<String> machineIds) {
        return peopleMachineMapper.batchDelete(machineIds);
    }
}
