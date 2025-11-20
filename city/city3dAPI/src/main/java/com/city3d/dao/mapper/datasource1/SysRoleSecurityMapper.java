package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleSecurity;
import com.city3d.dao.entry.SysRoleSecurityExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleSecurityMapper {
    long countByExample(SysRoleSecurityExample example);

    int deleteByExample(SysRoleSecurityExample example);

    int deleteByPrimaryKey(String roleSecurityId);

    int insert(SysRoleSecurity record);

    int insertSelective(SysRoleSecurity record);

    List<SysRoleSecurity> selectByExample(SysRoleSecurityExample example);

    SysRoleSecurity selectByPrimaryKey(String roleSecurityId);

    int updateByExampleSelective(@Param("record") SysRoleSecurity record, @Param("example") SysRoleSecurityExample example);

    int updateByExample(@Param("record") SysRoleSecurity record, @Param("example") SysRoleSecurityExample example);

    int updateByPrimaryKeySelective(SysRoleSecurity record);

    int updateByPrimaryKey(SysRoleSecurity record);
}