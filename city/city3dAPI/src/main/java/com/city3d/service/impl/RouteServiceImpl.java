package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleRouteMapperC;
import com.city3d.dao.entry.PeopleRoute;
import com.city3d.dao.entry.PeopleRouteExample;
import com.city3d.service.RouteService;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private PeopleRouteMapperC peopleRouteMapperC;

    @Override
    public List<PeopleRoute> getPeopleRoute() {
        return peopleRouteMapperC.selectPeopleRoute();
    }

    @Override
    public PeopleRoute getRouteById(String routeId) {
        return peopleRouteMapperC.selectByPrimaryKey(routeId);
    }

    @Override
    public int insert(PeopleRoute PeopleRoute) {
        return peopleRouteMapperC.insert(PeopleRoute);
    }

    @Override
    public int updateByPrimaryKey(PeopleRoute PeopleRoute) {
        return peopleRouteMapperC.updateByPrimaryKey(PeopleRoute);
    }

    @Override
    public int deleteByPrimaryKey(String routeId) {
        return peopleRouteMapperC.deleteByPrimaryKey(routeId);
    }

    @Override
    public int iskpBe(String kpId) {
        PeopleRouteExample example = new PeopleRouteExample();
        example.or().andKeyIdEqualTo(kpId);
        return peopleRouteMapperC.countByExample(example);
    }
}
