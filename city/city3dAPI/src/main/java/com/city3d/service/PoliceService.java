package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Police;

public interface PoliceService {
    List<Police> getPolice();

    int insert(Police police);

    int updateByPrimaryKey(Police police);

    int deleteByPrimaryKey(String policeId);

    List<Police> findPoliceByPuid(String deviceNum);

    List<Police> getPoliceRealDateWithManPos();

    Police getPoliceAndEquipmentsByPuid(String deviceNum);
}
