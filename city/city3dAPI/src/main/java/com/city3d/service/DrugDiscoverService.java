package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PeopleDrugDiscover;

public interface DrugDiscoverService {
    List<PeopleDrugDiscover> findByPpId(String ppId);

    int save(PeopleDrugDiscover entity);

    int updateByPrimaryKey(PeopleDrugDiscover entity);

    int deleteByPrimaryKey(String id);
}
