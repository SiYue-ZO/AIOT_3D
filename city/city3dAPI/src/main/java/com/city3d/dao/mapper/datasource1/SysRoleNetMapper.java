package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleNet;
import com.city3d.dao.entry.SysRoleNetExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleNetMapper {
    long countByExample(SysRoleNetExample example);

    int deleteByExample(SysRoleNetExample example);

    int deleteByPrimaryKey(String roleNetId);

    int insert(SysRoleNet record);

    int insertSelective(SysRoleNet record);

    List<SysRoleNet> selectByExample(SysRoleNetExample example);

    SysRoleNet selectByPrimaryKey(String roleNetId);

    int updateByExampleSelective(@Param("record") SysRoleNet record, @Param("example") SysRoleNetExample example);

    int updateByExample(@Param("record") SysRoleNet record, @Param("example") SysRoleNetExample example);

    int updateByPrimaryKeySelective(SysRoleNet record);

    int updateByPrimaryKey(SysRoleNet record);
}