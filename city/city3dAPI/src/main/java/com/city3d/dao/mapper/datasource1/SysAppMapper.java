package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysApp;
import com.city3d.dao.entry.SysAppExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysAppMapper {
    int countByExample(SysAppExample example);

    int deleteByExample(SysAppExample example);

    int deleteByPrimaryKey(String appId);

    int insert(SysApp record);

    int insertSelective(SysApp record);

    List<SysApp> selectByExample(SysAppExample example);

    SysApp selectByPrimaryKey(String appId);

    int updateByExampleSelective(@Param("record") SysApp record, @Param("example") SysAppExample example);

    int updateByExample(@Param("record") SysApp record, @Param("example") SysAppExample example);

    int updateByPrimaryKeySelective(SysApp record);

    int updateByPrimaryKey(SysApp record);
}