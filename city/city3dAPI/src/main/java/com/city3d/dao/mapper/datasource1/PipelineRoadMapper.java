package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PipelineRoad;
import com.city3d.dao.entry.PipelineRoadExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PipelineRoadMapper {
    long countByExample(PipelineRoadExample example);

    int deleteByExample(PipelineRoadExample example);

    int deleteByPrimaryKey(String roadId);

    int insert(PipelineRoad record);

    int insertSelective(PipelineRoad record);

    List<PipelineRoad> selectByExample(PipelineRoadExample example);

    PipelineRoad selectByPrimaryKey(String roadId);

    int updateByExampleSelective(@Param("record") PipelineRoad record, @Param("example") PipelineRoadExample example);

    int updateByExample(@Param("record") PipelineRoad record, @Param("example") PipelineRoadExample example);

    int updateByPrimaryKeySelective(PipelineRoad record);

    int updateByPrimaryKey(PipelineRoad record);
}