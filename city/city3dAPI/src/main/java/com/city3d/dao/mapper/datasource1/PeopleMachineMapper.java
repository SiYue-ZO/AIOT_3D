package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.PeopleMachine;
import com.city3d.dao.entry.PeopleMachineExample;

@Mapper
public interface PeopleMachineMapper {
    int countByExample(PeopleMachineExample example);

    int deleteByExample(PeopleMachineExample example);

    int deleteByPrimaryKey(String machineId);

    int insert(PeopleMachine record);

    int insertSelective(PeopleMachine record);

    List<PeopleMachine> selectByExample(PeopleMachineExample example);

    PeopleMachine selectByPrimaryKey(String machineId);

    int updateByExampleSelective(@Param("record") PeopleMachine record, @Param("example") PeopleMachineExample example);

    int updateByExample(@Param("record") PeopleMachine record, @Param("example") PeopleMachineExample example);

    int updateByPrimaryKeySelective(PeopleMachine record);

    int updateByPrimaryKey(PeopleMachine record);
}