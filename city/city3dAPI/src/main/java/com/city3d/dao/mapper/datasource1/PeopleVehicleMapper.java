package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PeopleVehicle;
import com.city3d.dao.entry.PeopleVehicleExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleVehicleMapper {
    int countByExample(PeopleVehicleExample example);

    int deleteByExample(PeopleVehicleExample example);

    int deleteByPrimaryKey(String vehicleId);

    int insert(PeopleVehicle record);

    int insertSelective(PeopleVehicle record);

    List<PeopleVehicle> selectByExample(PeopleVehicleExample example);

    PeopleVehicle selectByPrimaryKey(String vehicleId);

    int updateByExampleSelective(@Param("record") PeopleVehicle record, @Param("example") PeopleVehicleExample example);

    int updateByExample(@Param("record") PeopleVehicle record, @Param("example") PeopleVehicleExample example);

    int updateByPrimaryKeySelective(PeopleVehicle record);

    int updateByPrimaryKey(PeopleVehicle record);
}