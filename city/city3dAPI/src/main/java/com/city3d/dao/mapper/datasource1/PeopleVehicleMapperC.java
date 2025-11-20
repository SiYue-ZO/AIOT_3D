package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PeopleVehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleVehicleMapperC extends PeopleVehicleMapper {
    List<PeopleVehicle> selectPeopleVehicleAll();

    int batchDelete(List<String> vehicleIds);
}