package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Tiles3d;

public interface Tiles3DService {
    List<Tiles3d> getTiles3d();

    Tiles3d getTiles3DById(String tilesId);

    int insert(Tiles3d tiles3d);

    int updateByPrimaryKey(Tiles3d tiles3d);

    int deleteByPrimaryKey(String tilesId);
}
