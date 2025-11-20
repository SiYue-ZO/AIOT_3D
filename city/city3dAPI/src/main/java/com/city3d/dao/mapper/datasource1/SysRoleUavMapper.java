package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleUav;
import com.city3d.dao.entry.SysRoleUavExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleUavMapper {
    long countByExample(SysRoleUavExample example);

    int deleteByExample(SysRoleUavExample example);

    int deleteByPrimaryKey(String roleUavId);

    int insert(SysRoleUav record);

    int insertSelective(SysRoleUav record);

    List<SysRoleUav> selectByExample(SysRoleUavExample example);

    SysRoleUav selectByPrimaryKey(String roleUavId);

    int updateByExampleSelective(@Param("record") SysRoleUav record, @Param("example") SysRoleUavExample example);

    int updateByExample(@Param("record") SysRoleUav record, @Param("example") SysRoleUavExample example);

    int updateByPrimaryKeySelective(SysRoleUav record);

    int updateByPrimaryKey(SysRoleUav record);
}