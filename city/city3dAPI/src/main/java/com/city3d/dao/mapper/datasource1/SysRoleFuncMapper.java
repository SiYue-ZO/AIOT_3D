package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleFunc;
import com.city3d.dao.entry.SysRoleFuncExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleFuncMapper {
    int countByExample(SysRoleFuncExample example);

    int deleteByExample(SysRoleFuncExample example);

    int deleteByPrimaryKey(String roleFuncId);

    int insert(SysRoleFunc record);

    int insertSelective(SysRoleFunc record);

    List<SysRoleFunc> selectByExample(SysRoleFuncExample example);

    SysRoleFunc selectByPrimaryKey(String roleFuncId);

    int updateByExampleSelective(@Param("record") SysRoleFunc record, @Param("example") SysRoleFuncExample example);

    int updateByExample(@Param("record") SysRoleFunc record, @Param("example") SysRoleFuncExample example);

    int updateByPrimaryKeySelective(SysRoleFunc record);

    int updateByPrimaryKey(SysRoleFunc record);
}