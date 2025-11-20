package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleRoute;

public interface RouteService {
    List<PeopleRoute> getPeopleRoute();

    PeopleRoute getRouteById(String routeId);

    int insert(PeopleRoute peopleRoute);

    int updateByPrimaryKey(PeopleRoute PeopleRoute);

    int deleteByPrimaryKey(String routeId);

    int iskpBe(String kpId);
}
