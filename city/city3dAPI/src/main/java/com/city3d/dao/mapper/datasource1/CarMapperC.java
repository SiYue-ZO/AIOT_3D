package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapperC extends CarMapper {
    List<Car> getPoliceCarListPart(String[] carLicenses);

    Car getCarAndEquipmentsByPuid(String carId);
}