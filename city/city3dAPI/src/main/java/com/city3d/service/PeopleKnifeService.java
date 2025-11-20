package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleKnife;

public interface PeopleKnifeService {
    List<PeopleKnife> getPeopleKnife();

    List<PeopleKnife> findByPpId(String ppId);

    int save(PeopleKnife peopleKnife);

    int updateByPrimaryKey(PeopleKnife peopleKnife);

    int deleteByPrimaryKey(String id);

    int batchDelete(List<String> knifeIds);
}
