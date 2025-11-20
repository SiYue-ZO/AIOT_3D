package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleBase;

public interface PeopleBaseService {
    List<PeopleBase> getPeopleBaseAll();

    List<PeopleBase> queryPeoplebasebyExample(PeopleBase peopleBase);

    List<PeopleBase> queryPeoplebasebyPartExample(PeopleBase peopleBase);

    PeopleBase getPeopleBaseById(String ppId);

    List<PeopleBase> queryPeoplebaseByPolygon(PeopleBase peopleBase);

    int updateByPrimaryKey(PeopleBase peopleBase);

    int insert(PeopleBase peopleBase);

    int deleteByPrimaryKey(String ppId);

    List<PeopleBase> queryPeopleByAddId(String addId);

    int batchDelete(List<String> ppIds);
}
