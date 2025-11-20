package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.HouseLayout;
import com.city3d.dao.entry.HouseLayoutExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HouseLayoutMapper {
    int countByExample(HouseLayoutExample example);

    int deleteByExample(HouseLayoutExample example);

    int deleteByPrimaryKey(String layoutId);

    int insert(HouseLayout record);

    int insertSelective(HouseLayout record);

    List<HouseLayout> selectByExample(HouseLayoutExample example);

    HouseLayout selectByPrimaryKey(String layoutId);

    int updateByExampleSelective(@Param("record") HouseLayout record, @Param("example") HouseLayoutExample example);

    int updateByExample(@Param("record") HouseLayout record, @Param("example") HouseLayoutExample example);

    int updateByPrimaryKeySelective(HouseLayout record);

    int updateByPrimaryKey(HouseLayout record);
}