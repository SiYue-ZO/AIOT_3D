package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PoliceNet;
import com.city3d.dao.entry.PoliceNetExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PoliceNetMapper {
    int countByExample(PoliceNetExample example);

    int deleteByExample(PoliceNetExample example);

    int deleteByPrimaryKey(String netId);

    int insert(PoliceNet record);

    int insertSelective(PoliceNet record);

    List<PoliceNet> selectByExample(PoliceNetExample example);

    PoliceNet selectByPrimaryKey(String netId);

    int updateByExampleSelective(@Param("record") PoliceNet record, @Param("example") PoliceNetExample example);

    int updateByExample(@Param("record") PoliceNet record, @Param("example") PoliceNetExample example);

    int updateByPrimaryKeySelective(PoliceNet record);

    int updateByPrimaryKey(PoliceNet record);
}