package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.RoamMapperC;
import com.city3d.dao.entry.Roam;
import com.city3d.service.RoamService;
import org.springframework.stereotype.Service;

@Service
public class RoamServiceImpl implements RoamService {
    @Autowired
    private RoamMapperC roamMapper;

    @Override
    public List<Roam> getRoam() {
        return roamMapper.selectByExample(null);
    }

    @Override
    public Roam getRoamById(String roamId) {
        return roamMapper.selectByPrimaryKey(roamId);
    }

    @Override
    public int insert(Roam roam) {
        return roamMapper.insert(roam);
    }

    @Override
    public int updateByPrimaryKey(Roam roam) {
        return roamMapper.updateByPrimaryKey(roam);
    }

    @Override
    public int deleteByPrimaryKey(String roamId) {
        return roamMapper.deleteByPrimaryKey(roamId);
    }

    @Override
    public int batchDelete(List<String> roamIds) {
        return roamMapper.batchDelete(roamIds);
    }
}
