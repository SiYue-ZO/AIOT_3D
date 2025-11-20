package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.HouseLayout;

public interface HouseLayoutService {
    List<HouseLayout> getHouseLayout();

    int insert(HouseLayout houseLayout);

    int updateByPrimaryKey(HouseLayout houseLayout);

    int deleteByPrimaryKey(String layoutId);

    int batchDelete(List<String> layoutIds);

    List<HouseLayout> getLayoutByName(String layoutName);
}
