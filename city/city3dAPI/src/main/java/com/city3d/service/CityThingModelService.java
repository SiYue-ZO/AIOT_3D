package com.city3d.service;

import com.city3d.dao.entry.CityThingModel;

import java.util.List;

public interface CityThingModelService {
    List<CityThingModel> getCityThingModel();

    int insert(CityThingModel cityThingModel);

    int updateByPrimaryKey(CityThingModel cityThingModel);

    int deleteByPrimaryKey(String thingModelId);
}
