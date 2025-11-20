package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PipelineCheck;

public interface PipelineCheckService {
    List<PipelineCheck> getPipelineCheck();

    int insert(PipelineCheck pipelineCheck);

    int updateByPrimaryKey(PipelineCheck pipelineCheck);

    int deleteByPrimaryKey(String checkId);

    List<PipelineCheck> getPipelineCheckByAdd(PipelineCheck pipelineCheck);

    int batchDelete(List<String> checkIds);
}
