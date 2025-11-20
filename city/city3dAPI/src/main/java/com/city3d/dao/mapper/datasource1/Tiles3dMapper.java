package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Tiles3d;
import com.city3d.dao.entry.Tiles3dExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Tiles3dMapper {
    long countByExample(Tiles3dExample example);

    int deleteByExample(Tiles3dExample example);

    int deleteByPrimaryKey(String tilesId);

    int insert(Tiles3d record);

    int insertSelective(Tiles3d record);

    List<Tiles3d> selectByExample(Tiles3dExample example);

    Tiles3d selectByPrimaryKey(String tilesId);

    int updateByExampleSelective(@Param("record") Tiles3d record, @Param("example") Tiles3dExample example);

    int updateByExample(@Param("record") Tiles3d record, @Param("example") Tiles3dExample example);

    int updateByPrimaryKeySelective(Tiles3d record);

    int updateByPrimaryKey(Tiles3d record);
}