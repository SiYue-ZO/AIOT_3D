package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.AccessCar;
import com.city3d.dao.entry.AccessCarExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccessCarMapper {
    int countByExample(AccessCarExample example);

    int deleteByExample(AccessCarExample example);

    int deleteByPrimaryKey(String accessCarId);

    int insert(AccessCar record);

    int insertSelective(AccessCar record);

    List<AccessCar> selectByExample(AccessCarExample example);

    AccessCar selectByPrimaryKey(String accessCarId);

    int updateByExampleSelective(@Param("record") AccessCar record, @Param("example") AccessCarExample example);

    int updateByExample(@Param("record") AccessCar record, @Param("example") AccessCarExample example);

    int updateByPrimaryKeySelective(AccessCar record);

    int updateByPrimaryKey(AccessCar record);
}