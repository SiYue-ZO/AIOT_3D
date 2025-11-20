package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.UavMapper;
import com.city3d.dao.mapper.datasource1.UavRealMapperC;
import com.city3d.dao.entry.Uav;
import com.city3d.dao.entry.UavReal;
import com.city3d.dao.entry.UavRealExample;
import com.city3d.service.UavService;
import org.springframework.stereotype.Service;

@Service
public class UavServiceImpl implements UavService {
    @Autowired
    private UavMapper uavMapper;

    @Autowired
    private UavRealMapperC uavRealMapper;

    @Override
    public List<Uav> getUav() {
        return uavMapper.selectByExample(null);
    }

    @Override
    public int insert(Uav uav) {
        return uavMapper.insert(uav);
    }

    @Override
    public int updateByPrimaryKey(Uav uav) {
        return uavMapper.updateByPrimaryKey(uav);
    }

    @Override
    public int deleteByPrimaryKey(String uavId) {
        return uavMapper.deleteByPrimaryKey(uavId);
    }

    @Override
    public List<UavReal> getUavPosByUavId(String uavId) {
        UavRealExample example = new UavRealExample();
        example.or().andUavIdEqualTo(uavId);
        return uavRealMapper.selectByExample(example);
    }

    @Override
    public List<UavReal> getUavPosByUavIds(String[] uavIds) {
        return uavRealMapper.getUavPosByUavIds(uavIds);
    }
}
