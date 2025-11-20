package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysUserTiles3d;
import com.city3d.dao.entry.SysUserTiles3dExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserTiles3dMapper {
    int countByExample(SysUserTiles3dExample example);

    int deleteByExample(SysUserTiles3dExample example);

    int deleteByPrimaryKey(String userTilesId);

    int insert(SysUserTiles3d record);

    int insertSelective(SysUserTiles3d record);

    List<SysUserTiles3d> selectByExample(SysUserTiles3dExample example);

    SysUserTiles3d selectByPrimaryKey(String userTilesId);

    int updateByExampleSelective(@Param("record") SysUserTiles3d record, @Param("example") SysUserTiles3dExample example);

    int updateByExample(@Param("record") SysUserTiles3d record, @Param("example") SysUserTiles3dExample example);

    int updateByPrimaryKeySelective(SysUserTiles3d record);

    int updateByPrimaryKey(SysUserTiles3d record);
}