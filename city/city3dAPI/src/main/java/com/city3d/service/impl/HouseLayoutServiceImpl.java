package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.HouseLayoutMapperC;
import com.city3d.dao.entry.HouseLayout;
import com.city3d.dao.entry.HouseLayoutExample;
import com.city3d.service.HouseLayoutService;
import org.springframework.stereotype.Service;

@Service
public class HouseLayoutServiceImpl implements HouseLayoutService {
    @Autowired
    private HouseLayoutMapperC houseLayoutMapper;

    @Override
    public List<HouseLayout> getHouseLayout() {
        return houseLayoutMapper.getHouseLayoutAll();
    }

    @Override
    public int insert(HouseLayout houseLayout) {
        return houseLayoutMapper.insert(houseLayout);
    }

    @Override
    public int updateByPrimaryKey(HouseLayout houseLayout) {
        return houseLayoutMapper.updateByPrimaryKey(houseLayout);
    }

    @Override
    public int deleteByPrimaryKey(String layoutId) {
        return houseLayoutMapper.deleteByPrimaryKey(layoutId);
    }

    @Override
    public int batchDelete(List<String> layoutIds) {
        return houseLayoutMapper.batchDelete(layoutIds);
    }

    @Override
    public List<HouseLayout> getLayoutByName(String layoutName) {
        HouseLayoutExample example = new HouseLayoutExample();
        example.or().andLayoutNameLike("%" + layoutName + "%");
        return houseLayoutMapper.selectByExample(example);
    }
}
