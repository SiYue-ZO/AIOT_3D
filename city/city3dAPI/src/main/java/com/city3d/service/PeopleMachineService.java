package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleMachine;

public interface PeopleMachineService {
    List<PeopleMachine> selectPeopleMachineAll();

    int save(PeopleMachine entity);

    int updateByPrimaryKey(PeopleMachine entity);

    int deleteByPrimaryKey(String id);

    int batchDelete(List<String> machineIds);
}
