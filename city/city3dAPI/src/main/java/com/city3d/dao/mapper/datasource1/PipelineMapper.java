package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Pipeline;
import com.city3d.dao.entry.PipelineExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PipelineMapper {
    long countByExample(PipelineExample example);

    int deleteByExample(PipelineExample example);

    int deleteByPrimaryKey(String pipeId);

    int insert(Pipeline record);

    int insertSelective(Pipeline record);

    List<Pipeline> selectByExample(PipelineExample example);

    Pipeline selectByPrimaryKey(String pipeId);

    int updateByExampleSelective(@Param("record") Pipeline record, @Param("example") PipelineExample example);

    int updateByExample(@Param("record") Pipeline record, @Param("example") PipelineExample example);

    int updateByPrimaryKeySelective(Pipeline record);

    int updateByPrimaryKey(Pipeline record);
}