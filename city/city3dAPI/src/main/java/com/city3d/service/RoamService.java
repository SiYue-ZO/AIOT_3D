package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Roam;

public interface RoamService {
    List<Roam> getRoam();

    Roam getRoamById(String roamId);

    int insert(Roam roam);

    int updateByPrimaryKey(Roam roam);

    int deleteByPrimaryKey(String roamId);

    int batchDelete(List<String> roamIds);
}
