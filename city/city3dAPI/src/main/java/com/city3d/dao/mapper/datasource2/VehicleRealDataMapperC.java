package com.city3d.dao.mapper.datasource2;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.VehicleRealData;
import org.apache.ibatis.annotations.Mapper;

//@DataSource("datasource2")
@Mapper
public interface VehicleRealDataMapperC extends VehicleRealDataMapper {
    VehicleRealData selectByPhone(Map<String, Object> map);

    List<VehicleRealData> getVehiclePartByPhone(List<String> simNos);
}
