package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Police;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoliceMapperC extends PoliceMapper {
    List<Police> getPoliceRealDateWithManPos();

    Police getPoliceAndEquipmentsByPuid(String deviceNum);
}