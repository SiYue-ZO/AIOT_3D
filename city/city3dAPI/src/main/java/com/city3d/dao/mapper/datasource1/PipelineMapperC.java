package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Pipeline;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PipelineMapperC extends PipelineMapper {
    int batchDelete(List<String> pipeIds);

    int insertBatch(@Param("pipelineList") List<Pipeline> pipelineList);
}