package com.city3d.service.impl;

import com.city3d.dao.entry.CityThingModel;
import com.city3d.dao.mapper.datasource1.CityThingModelMapper;
import com.city3d.service.CityThingModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityThingModelServiceImpl implements CityThingModelService {
    @Autowired
    private CityThingModelMapper cityThingModelMapper;

    @Override
    public List<CityThingModel> getCityThingModel() {
        return cityThingModelMapper.selectByExample(null);
    }

    @Override
    public int insert(CityThingModel cityThingModel) {
        return cityThingModelMapper.insert(cityThingModel);
    }

    @Override
    public int updateByPrimaryKey(CityThingModel cityThingModel) {
        return cityThingModelMapper.updateByPrimaryKey(cityThingModel);
    }

    @Override
    public int deleteByPrimaryKey(String thingModelId) {
        return cityThingModelMapper.deleteByPrimaryKey(thingModelId);
    }
}
