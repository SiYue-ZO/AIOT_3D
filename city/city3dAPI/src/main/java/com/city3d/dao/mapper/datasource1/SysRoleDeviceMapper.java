package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRoleDevice;
import com.city3d.dao.entry.SysRoleDeviceExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleDeviceMapper {
    long countByExample(SysRoleDeviceExample example);

    int deleteByExample(SysRoleDeviceExample example);

    int deleteByPrimaryKey(String roleDeviceId);

    int insert(SysRoleDevice record);

    int insertSelective(SysRoleDevice record);

    List<SysRoleDevice> selectByExample(SysRoleDeviceExample example);

    SysRoleDevice selectByPrimaryKey(String roleDeviceId);

    int updateByExampleSelective(@Param("record") SysRoleDevice record, @Param("example") SysRoleDeviceExample example);

    int updateByExample(@Param("record") SysRoleDevice record, @Param("example") SysRoleDeviceExample example);

    int updateByPrimaryKeySelective(SysRoleDevice record);

    int updateByPrimaryKey(SysRoleDevice record);
}