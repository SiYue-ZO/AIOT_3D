package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.HousePanorama;

public interface HousePanoramaService {
    List<HousePanorama> getHousePanoramaByHosueId(String houseId);

    int insert(HousePanorama housePanorama);

    int deleteByPrimaryKey(String panoramaId);
}
