package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.PeopleMachine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMachineMapperC extends PeopleMachineMapper {
    List<PeopleMachine> selectPeopleMachineAll();

    int batchDelete(List<String> machineIds);
}