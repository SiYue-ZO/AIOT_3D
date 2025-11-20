package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Pipeline;

public interface PipelineService {
    List<Pipeline> getPipeline();

    int insert(Pipeline pipeline);

    int updateByPrimaryKey(Pipeline pipeline);

    int deleteByPrimaryKey(String pipeId);

    Pipeline getPipelineById(String pipeId);

    List<Pipeline> getPipelineByPlName(Pipeline pipeline);

    int batchDelete(List<String> pipeIds);

    int insertBatch(List<Pipeline> pipelineList);
}
