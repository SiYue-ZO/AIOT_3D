package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Eplan;

public interface EplanService {
    List<Eplan> getEplan();

    int insert(Eplan eplan);

    int updateByPrimaryKey(Eplan eplan);

    int deleteByPrimaryKey(String eplanId);
}
