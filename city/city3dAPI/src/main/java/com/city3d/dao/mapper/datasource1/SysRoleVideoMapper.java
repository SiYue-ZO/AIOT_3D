package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleVideo;
import com.city3d.dao.entry.SysRoleVideoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleVideoMapper {
    long countByExample(SysRoleVideoExample example);

    int deleteByExample(SysRoleVideoExample example);

    int deleteByPrimaryKey(String roleVideoId);

    int insert(SysRoleVideo record);

    int insertSelective(SysRoleVideo record);

    List<SysRoleVideo> selectByExample(SysRoleVideoExample example);

    SysRoleVideo selectByPrimaryKey(String roleVideoId);

    int updateByExampleSelective(@Param("record") SysRoleVideo record, @Param("example") SysRoleVideoExample example);

    int updateByExample(@Param("record") SysRoleVideo record, @Param("example") SysRoleVideoExample example);

    int updateByPrimaryKeySelective(SysRoleVideo record);

    int updateByPrimaryKey(SysRoleVideo record);
}