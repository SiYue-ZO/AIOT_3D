package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRolePolice;
import com.city3d.dao.entry.SysRolePoliceExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRolePoliceMapper {
    long countByExample(SysRolePoliceExample example);

    int deleteByExample(SysRolePoliceExample example);

    int deleteByPrimaryKey(String rolePoliceId);

    int insert(SysRolePolice record);

    int insertSelective(SysRolePolice record);

    List<SysRolePolice> selectByExample(SysRolePoliceExample example);

    SysRolePolice selectByPrimaryKey(String rolePoliceId);

    int updateByExampleSelective(@Param("record") SysRolePolice record, @Param("example") SysRolePoliceExample example);

    int updateByExample(@Param("record") SysRolePolice record, @Param("example") SysRolePoliceExample example);

    int updateByPrimaryKeySelective(SysRolePolice record);

    int updateByPrimaryKey(SysRolePolice record);
}