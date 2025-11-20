package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.AccessCar;

public interface AccessCarService {
    List<AccessCar> getAccessCar();

    int deleteByPrimaryKey(String accessCarId);

    int batchDelete(List<String> accessCarIds);
}
