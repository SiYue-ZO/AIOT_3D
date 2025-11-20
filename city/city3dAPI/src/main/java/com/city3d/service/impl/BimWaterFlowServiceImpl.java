package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BimWaterFlowMapper;
import com.city3d.dao.entry.BimWaterFlow;
import com.city3d.service.BimWaterFlowService;
import org.springframework.stereotype.Service;

@Service
public class BimWaterFlowServiceImpl implements BimWaterFlowService {
    @Autowired
    private BimWaterFlowMapper bimWaterFlowMapper;

    @Override
    public List<BimWaterFlow> getBimWaterFlow() {
        return bimWaterFlowMapper.selectByExample(null);
    }

    @Override
    public int insert(BimWaterFlow bimWaterFlow) {
        return bimWaterFlowMapper.insert(bimWaterFlow);
    }

    @Override
    public int updateByPrimaryKey(BimWaterFlow bimWaterFlow) {
        return bimWaterFlowMapper.updateByPrimaryKey(bimWaterFlow);
    }

    @Override
    public int deleteByPrimaryKey(String bimFlowId) {
        return bimWaterFlowMapper.deleteByPrimaryKey(bimFlowId);
    }
}
