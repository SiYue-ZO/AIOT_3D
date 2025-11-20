package com.city3d.service.impl;

import com.city3d.dao.entry.PipelineRoad;
import com.city3d.dao.mapper.datasource1.PipelineRoadMapper;
import com.city3d.service.PipelineRoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipelineRoadServiceImpl implements PipelineRoadService {
    @Autowired
    private PipelineRoadMapper pipelineRoadMapper;

    @Override
    public List<PipelineRoad> getPipelineRoad() {
        return pipelineRoadMapper.selectByExample(null);
    }

    @Override
    public int insert(PipelineRoad pipelineRoad) {
        return pipelineRoadMapper.insert(pipelineRoad);
    }

    @Override
    public int updateByPrimaryKey(PipelineRoad pipelineRoad) {
        return pipelineRoadMapper.updateByPrimaryKey(pipelineRoad);
    }

    @Override
    public int deleteByPrimaryKey(String roadId) {
        return pipelineRoadMapper.deleteByPrimaryKey(roadId);
    }
}
