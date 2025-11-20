package com.city3d.dao.mapper.datasource2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.VehicleRealData;
import com.city3d.dao.entry.VehicleRealDataExample;

//@DataSource("datasource2")
@Mapper
public interface VehicleRealDataMapper {
    int countByExample(VehicleRealDataExample example);

    int deleteByExample(VehicleRealDataExample example);

    int deleteByPrimaryKey(Integer iD);

    int insert(VehicleRealData record);

    int insertSelective(VehicleRealData record);

    List<VehicleRealData> selectByExample(VehicleRealDataExample example);

    VehicleRealData selectByPrimaryKey(Integer iD);

    int updateByExampleSelective(@Param("record") VehicleRealData record, @Param("example") VehicleRealDataExample example);

    int updateByExample(@Param("record") VehicleRealData record, @Param("example") VehicleRealDataExample example);

    int updateByPrimaryKeySelective(VehicleRealData record);

    int updateByPrimaryKey(VehicleRealData record);
}
