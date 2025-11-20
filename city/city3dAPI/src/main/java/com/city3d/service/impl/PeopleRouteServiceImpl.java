package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleRouteMapper;
import com.city3d.dao.entry.PeopleRoute;
import com.city3d.dao.entry.PeopleRouteExample;
import com.city3d.service.PeopleRouteService;
import org.springframework.stereotype.Service;

@Service
public class PeopleRouteServiceImpl implements PeopleRouteService {
    @Autowired
    private PeopleRouteMapper peopleRouteMapper;

    @Override
    public List<PeopleRoute> getPeopleRoute(String keyId) {
        PeopleRouteExample example = new PeopleRouteExample();
        example.or().andKeyIdEqualTo(keyId);
        return peopleRouteMapper.selectByExample(example);
    }
}
