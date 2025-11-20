package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.StreetMapperC;
import com.city3d.dao.entry.Street;
import com.city3d.dao.entry.StreetExample;
import com.city3d.service.StreetService;
import org.springframework.stereotype.Service;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetMapperC streetMapper;

    @Override
    public List<Street> getStreetAll() {
        StreetExample example = new StreetExample();
        return streetMapper.selectByExample(example);
    }

    @Override
    public int insert(Street street) {
        return streetMapper.insert(street);
    }

    @Override
    public int updateByPrimaryKey(Street street) {
        return streetMapper.updateByPrimaryKey(street);
    }

    @Override
    public int deleteByPrimaryKey(String streetId) {
        return streetMapper.deleteByPrimaryKey(streetId);
    }

    @Override
    public int batchDelete(List<String> streetIds) {
        return streetMapper.batchDelete(streetIds);
    }
}
