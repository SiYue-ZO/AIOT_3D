package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.HousePanoramaMapper;
import com.city3d.dao.entry.HousePanorama;
import com.city3d.dao.entry.HousePanoramaExample;
import com.city3d.service.HousePanoramaService;
import org.springframework.stereotype.Service;

@Service
public class HousePanoramaServiceImpl implements HousePanoramaService {
    @Autowired
    private HousePanoramaMapper housePanoramaMapper;

    @Override
    public List<HousePanorama> getHousePanoramaByHosueId(String houseId) {
        HousePanoramaExample example = new HousePanoramaExample();
        example.createCriteria().andHouseIdEqualTo(houseId);
        return housePanoramaMapper.selectByExample(example);
    }

    @Override
    public int insert(HousePanorama housePanorama) {
        return housePanoramaMapper.insert(housePanorama);
    }

    @Override
    public int deleteByPrimaryKey(String panoramaId) {
        return housePanoramaMapper.deleteByPrimaryKey(panoramaId);
    }
}
