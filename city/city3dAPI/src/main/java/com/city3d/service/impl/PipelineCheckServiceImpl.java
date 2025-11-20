package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PipelineCheckMapperC;
import com.city3d.dao.entry.PipelineCheck;
import com.city3d.dao.entry.PipelineCheckExample;
import com.city3d.service.PipelineCheckService;
import org.springframework.stereotype.Service;

@Service
public class PipelineCheckServiceImpl implements PipelineCheckService {
    @Autowired
    private PipelineCheckMapperC pipelineCheckMapper;

    @Override
    public List<PipelineCheck> getPipelineCheck() {
        return pipelineCheckMapper.selectByExample(null);
    }

    @Override
    public int insert(PipelineCheck pipelineCheck) {
        return pipelineCheckMapper.insert(pipelineCheck);
    }

    @Override
    public int updateByPrimaryKey(PipelineCheck pipelineCheck) {
        return pipelineCheckMapper.updateByPrimaryKey(pipelineCheck);
    }

    @Override
    public int deleteByPrimaryKey(String checkId) {
        return pipelineCheckMapper.deleteByPrimaryKey(checkId);
    }

    @Override
    public List<PipelineCheck> getPipelineCheckByAdd(PipelineCheck pipelineCheck) {
        PipelineCheckExample example = new PipelineCheckExample();
        example.or().andCheckAddEqualTo(pipelineCheck.getCheckAdd());
        return pipelineCheckMapper.selectByExample(example);
    }

    @Override
    public int batchDelete(List<String> checkIds) {
        return pipelineCheckMapper.batchDelete(checkIds);
    }
}
