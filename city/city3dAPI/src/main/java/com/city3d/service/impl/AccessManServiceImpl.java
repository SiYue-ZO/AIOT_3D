package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AccessManMapperC;
import com.city3d.dao.entry.AccessMan;
import com.city3d.service.AccessManService;
import org.springframework.stereotype.Service;

@Service
public class AccessManServiceImpl implements AccessManService {
    @Autowired
    private AccessManMapperC accessManMapper;

    @Override
    public List<AccessMan> getAccessMan() {
        return accessManMapper.selectByExample(null);
    }

    @Override
    public int deleteByPrimaryKey(String accessManId) {
        return accessManMapper.deleteByPrimaryKey(accessManId);
    }

    @Override
    public int batchDelete(List<String> accessManIds) {
        return accessManMapper.batchDelete(accessManIds);
    }
}
