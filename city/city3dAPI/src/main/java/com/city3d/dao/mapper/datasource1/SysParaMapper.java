package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.SysPara;
import com.city3d.dao.entry.SysParaExample;

@Mapper
public interface SysParaMapper {
    int countByExample(SysParaExample example);

    int deleteByExample(SysParaExample example);

    int deleteByPrimaryKey(String sysId);

    int insert(SysPara record);

    int insertSelective(SysPara record);

    List<SysPara> selectByExample(SysParaExample example);

    SysPara selectByPrimaryKey(String sysId);

    int updateByExampleSelective(@Param("record") SysPara record, @Param("example") SysParaExample example);

    int updateByExample(@Param("record") SysPara record, @Param("example") SysParaExample example);

    int updateByPrimaryKeySelective(SysPara record);

    int updateByPrimaryKey(SysPara record);
}