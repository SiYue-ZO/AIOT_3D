package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleRelation;

public interface PeopleRelationService {
    List<PeopleRelation> selectPeopleRelationById(String ppId);

    List<PeopleRelation> findByPpId(String ppId);

    int save(PeopleRelation peopleRelation);

    int deleteByPrimaryKey(String id);
}
