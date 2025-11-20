package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.BimWaterFlow;

public interface BimWaterFlowService {
    List<BimWaterFlow> getBimWaterFlow();

    int insert(BimWaterFlow bimWaterFlow);

    int updateByPrimaryKey(BimWaterFlow bimWaterFlow);

    int deleteByPrimaryKey(String bimFlowId);
}
