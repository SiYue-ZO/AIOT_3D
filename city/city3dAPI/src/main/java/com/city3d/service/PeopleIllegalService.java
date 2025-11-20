package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleIllegal;

public interface PeopleIllegalService {
    List<PeopleIllegal> findByPpId(String ppId);

    int save(PeopleIllegal entity);

    int updateByPrimaryKey(PeopleIllegal entity);

    int deleteById(String id);
}
