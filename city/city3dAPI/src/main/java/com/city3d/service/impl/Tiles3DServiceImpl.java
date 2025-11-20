package com.city3d.service.impl;

import java.util.List;

import com.city3d.dao.mapper.datasource1.Tiles3dMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.entry.Tiles3d;
import com.city3d.service.Tiles3DService;
import org.springframework.stereotype.Service;

@Service
public class Tiles3DServiceImpl implements Tiles3DService {
    @Autowired
    private Tiles3dMapper tiles3dMapper;

    @Override
    public List<Tiles3d> getTiles3d() {
        return tiles3dMapper.selectByExample(null);
    }

    @Override
    public Tiles3d getTiles3DById(String tilesId) {
        return tiles3dMapper.selectByPrimaryKey(tilesId);
    }

    @Override
    public int insert(Tiles3d tiles3d) {
        return tiles3dMapper.insert(tiles3d);
    }

    @Override
    public int updateByPrimaryKey(Tiles3d tiles3d) {
        return tiles3dMapper.updateByPrimaryKey(tiles3d);
    }

    @Override
    public int deleteByPrimaryKey(String tilesId) {
        return tiles3dMapper.deleteByPrimaryKey(tilesId);
    }
}
