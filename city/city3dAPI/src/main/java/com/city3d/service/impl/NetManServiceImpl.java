package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.NetManMapperC;
import com.city3d.dao.entry.NetMan;
import com.city3d.dao.entry.NetManExample;
import com.city3d.service.NetManService;
import org.springframework.stereotype.Service;

@Service
public class NetManServiceImpl implements NetManService {
    @Autowired
    private NetManMapperC netManMapper;

    @Override
    public List<NetMan> getNetMan() {
        return netManMapper.selectByExample(null);
    }

    @Override
    public NetMan getNetManById(String netManId) {
        return netManMapper.selectByPrimaryKey(netManId);
    }

    public List<NetMan> getNetManByType(String type) {
        NetManExample example = new NetManExample();
        example.or().andTypeEqualTo(type);
        return netManMapper.selectByExample(example);
    }

    @Override
    public int insert(NetMan netMan) {
        return netManMapper.insert(netMan);
    }

    @Override
    public int updateByPrimaryKey(NetMan netMan) {
        return netManMapper.updateByPrimaryKey(netMan);
    }

    @Override
    public int deleteByPrimaryKey(String netManId) {
        return netManMapper.deleteByPrimaryKey(netManId);
    }

    @Override
    public int batchDelete(List<String> netManIds) {
        return netManMapper.batchDelete(netManIds);
    }
}
