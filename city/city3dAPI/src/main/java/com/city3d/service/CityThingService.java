package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.CityThing;

public interface CityThingService {
    List<CityThing> getCityThing();

    List<CityThing> getCityThingByPid(String thingPid);

    int insert(CityThing cityThing);

    int updateByPrimaryKey(CityThing cityThing);

    int deleteByPrimaryKey(String thingId);

    int batchDelete(List<String> thingIds);
}
