package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Roam;
import com.city3d.dao.entry.RoamExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoamMapper {
    int countByExample(RoamExample example);

    int deleteByExample(RoamExample example);

    int deleteByPrimaryKey(String roamId);

    int insert(Roam record);

    int insertSelective(Roam record);

    List<Roam> selectByExample(RoamExample example);

    Roam selectByPrimaryKey(String roamId);

    int updateByExampleSelective(@Param("record") Roam record, @Param("example") RoamExample example);

    int updateByExample(@Param("record") Roam record, @Param("example") RoamExample example);

    int updateByPrimaryKeySelective(Roam record);

    int updateByPrimaryKey(Roam record);
}