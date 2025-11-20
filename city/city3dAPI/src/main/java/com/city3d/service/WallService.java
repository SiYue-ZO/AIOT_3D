package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Wall;

public interface WallService {
    List<Wall> getWall();

    Wall getWallById(String wallId);

    int insert(Wall wall);

    int updateByPrimaryKey(Wall wall);

    int deleteByPrimaryKey(String wallId);
}
