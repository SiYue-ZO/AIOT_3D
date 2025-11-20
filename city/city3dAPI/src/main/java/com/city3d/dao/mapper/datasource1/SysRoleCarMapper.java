package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleCar;
import com.city3d.dao.entry.SysRoleCarExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleCarMapper {
    long countByExample(SysRoleCarExample example);

    int deleteByExample(SysRoleCarExample example);

    int deleteByPrimaryKey(String roleCarId);

    int insert(SysRoleCar record);

    int insertSelective(SysRoleCar record);

    List<SysRoleCar> selectByExample(SysRoleCarExample example);

    SysRoleCar selectByPrimaryKey(String roleCarId);

    int updateByExampleSelective(@Param("record") SysRoleCar record, @Param("example") SysRoleCarExample example);

    int updateByExample(@Param("record") SysRoleCar record, @Param("example") SysRoleCarExample example);

    int updateByPrimaryKeySelective(SysRoleCar record);

    int updateByPrimaryKey(SysRoleCar record);
}