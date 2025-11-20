package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CityThingMapperC;
import com.city3d.dao.entry.CityThing;
import com.city3d.dao.entry.CityThingExample;
import com.city3d.service.CityThingService;
import org.springframework.stereotype.Service;

@Service
public class CityThingServiceImpl implements CityThingService {
    @Autowired
    private CityThingMapperC cityThingMapper;

    @Override
    public List<CityThing> getCityThing() {
        return cityThingMapper.selectByExample(null);
    }

    @Override
    public List<CityThing> getCityThingByPid(String thingPid) {
        CityThingExample example = new CityThingExample();
        example.or().andThingPidEqualTo(thingPid);
        return cityThingMapper.selectByExample(example);
    }

    @Override
    public int insert(CityThing cityThing) {
        return cityThingMapper.insert(cityThing);
    }

    @Override
    public int updateByPrimaryKey(CityThing cityThing) {
        return cityThingMapper.updateByPrimaryKey(cityThing);
    }

    @Override
    public int deleteByPrimaryKey(String thingId) {
        return cityThingMapper.deleteByPrimaryKey(thingId);
    }

    @Override
    public int batchDelete(List<String> thingIds) {
        return cityThingMapper.batchDelete(thingIds);
    }
}
