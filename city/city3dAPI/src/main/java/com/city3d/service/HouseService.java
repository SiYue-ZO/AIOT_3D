package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.House;

public interface HouseService {
    House findHouseById(String houseId);

    List<House> queryHouse(House house);

    List<House> getHouseByAddId(String addId);

    int insert(House house);

    int updateByPrimaryKey(House house);

    int deleteByPrimaryKey(String houseId);

    int batchDelete(List<String> houseIds);
}
