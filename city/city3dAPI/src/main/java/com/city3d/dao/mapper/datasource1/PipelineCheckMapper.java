package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PipelineCheck;
import com.city3d.dao.entry.PipelineCheckExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PipelineCheckMapper {
    int countByExample(PipelineCheckExample example);

    int deleteByExample(PipelineCheckExample example);

    int deleteByPrimaryKey(String checkId);

    int insert(PipelineCheck record);

    int insertSelective(PipelineCheck record);

    List<PipelineCheck> selectByExample(PipelineCheckExample example);

    PipelineCheck selectByPrimaryKey(String checkId);

    int updateByExampleSelective(@Param("record") PipelineCheck record, @Param("example") PipelineCheckExample example);

    int updateByExample(@Param("record") PipelineCheck record, @Param("example") PipelineCheckExample example);

    int updateByPrimaryKeySelective(PipelineCheck record);

    int updateByPrimaryKey(PipelineCheck record);
}