package com.city3d.service;

import com.city3d.dao.entry.PipelineRoad;

import java.util.List;

public interface PipelineRoadService {
    List<PipelineRoad> getPipelineRoad();

    int insert(PipelineRoad pipelineRoad);

    int updateByPrimaryKey(PipelineRoad pipelineRoad);

    int deleteByPrimaryKey(String roadId);
}
