package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleBim;
import com.city3d.dao.entry.SysRoleBimExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleBimMapper {
    int countByExample(SysRoleBimExample example);

    int deleteByExample(SysRoleBimExample example);

    int deleteByPrimaryKey(String roleBimId);

    int insert(SysRoleBim record);

    int insertSelective(SysRoleBim record);

    List<SysRoleBim> selectByExample(SysRoleBimExample example);

    SysRoleBim selectByPrimaryKey(String roleBimId);

    int updateByExampleSelective(@Param("record") SysRoleBim record, @Param("example") SysRoleBimExample example);

    int updateByExample(@Param("record") SysRoleBim record, @Param("example") SysRoleBimExample example);

    int updateByPrimaryKeySelective(SysRoleBim record);

    int updateByPrimaryKey(SysRoleBim record);
}