package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PoliceNet;

public interface PoliceNetService {
    List<PoliceNet> getPoliceNet();

    List<PoliceNet> queryPoliceNet(PoliceNet policeNet);

    int insert(PoliceNet policeNet);

    int updateByPrimaryKey(PoliceNet policeNet);

    int deleteByPrimaryKey(String netId);

    int batchDelete(List<String> netIds);
}
