package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Wall;
import com.city3d.dao.entry.WallExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WallMapper {
    int countByExample(WallExample example);

    int deleteByExample(WallExample example);

    int deleteByPrimaryKey(String wallId);

    int insert(Wall record);

    int insertSelective(Wall record);

    List<Wall> selectByExample(WallExample example);

    Wall selectByPrimaryKey(String wallId);

    int updateByExampleSelective(@Param("record") Wall record, @Param("example") WallExample example);

    int updateByExample(@Param("record") Wall record, @Param("example") WallExample example);

    int updateByPrimaryKeySelective(Wall record);

    int updateByPrimaryKey(Wall record);
}