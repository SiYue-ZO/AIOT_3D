package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.ManPos;
import com.city3d.dao.entry.ManPosExample;

@Mapper
public interface ManPosMapper {
    int countByExample(ManPosExample example);

    int deleteByExample(ManPosExample example);

    int deleteByPrimaryKey(String realId);

    int insert(ManPos record);

    int insertSelective(ManPos record);

    List<ManPos> selectByExample(ManPosExample example);

    ManPos selectByPrimaryKey(String realId);

    int updateByExampleSelective(@Param("record") ManPos record, @Param("example") ManPosExample example);

    int updateByExample(@Param("record") ManPos record, @Param("example") ManPosExample example);

    int updateByPrimaryKeySelective(ManPos record);

    int updateByPrimaryKey(ManPos record);
}