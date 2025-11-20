package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.House;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapperC extends HouseMapper {
    House selectHouseById(String hId);

    List<House> selectByExampleH(House house);

    List<House> selectHouseByAddId(String addId);

    int batchDelete(List<String> houseIds);
}
