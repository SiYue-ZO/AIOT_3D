package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PipelineMapperC;
import com.city3d.dao.entry.Pipeline;
import com.city3d.dao.entry.PipelineExample;
import com.city3d.service.PipelineService;
import org.springframework.stereotype.Service;

@Service
public class PipelineServiceImpl implements PipelineService {
    @Autowired
    private PipelineMapperC pipelineMapper;

    @Override
    public List<Pipeline> getPipeline() {
        return pipelineMapper.selectByExample(null);
    }

    @Override
    public int insert(Pipeline pipeline) {
        return pipelineMapper.insert(pipeline);
    }

    @Override
    public int updateByPrimaryKey(Pipeline pipeline) {
        return pipelineMapper.updateByPrimaryKey(pipeline);
    }

    @Override
    public int deleteByPrimaryKey(String pipeId) {
        return pipelineMapper.deleteByPrimaryKey(pipeId);
    }

    @Override
    public Pipeline getPipelineById(String pipeId) {
        return pipelineMapper.selectByPrimaryKey(pipeId);
    }

    @Override
    public List<Pipeline> getPipelineByPlName(Pipeline pipeline) {
        PipelineExample example = new PipelineExample();
        example.or().andPlNameEqualTo(pipeline.getPlName());
        return pipelineMapper.selectByExample(example);
    }

    @Override
    public int batchDelete(List<String> pipeIds) {
        return pipelineMapper.batchDelete(pipeIds);
    }

    @Override
    public int insertBatch(List<Pipeline> pipelineList) {
        return pipelineMapper.insertBatch(pipelineList);
    }
}
