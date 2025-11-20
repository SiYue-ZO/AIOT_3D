package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.WallMapper;
import com.city3d.dao.entry.Wall;
import com.city3d.service.WallService;
import org.springframework.stereotype.Service;

@Service
public class WallServiceImpl implements WallService {
    @Autowired
    private WallMapper wallMapper;

    @Override
    public List<Wall> getWall() {
        return wallMapper.selectByExample(null);
    }

    @Override
    public Wall getWallById(String wallId) {
        return wallMapper.selectByPrimaryKey(wallId);
    }

    @Override
    public int insert(Wall wall) {
        return wallMapper.insert(wall);
    }

    @Override
    public int updateByPrimaryKey(Wall wall) {
        return wallMapper.updateByPrimaryKey(wall);
    }

    @Override
    public int deleteByPrimaryKey(String wallId) {
        return wallMapper.deleteByPrimaryKey(wallId);
    }
}
