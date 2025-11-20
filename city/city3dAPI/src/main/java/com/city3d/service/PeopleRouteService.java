package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleRoute;

public interface PeopleRouteService {
    List<PeopleRoute> getPeopleRoute(String keyId);
}
