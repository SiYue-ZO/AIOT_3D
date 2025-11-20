package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapperC extends SysRoleMapper {
    List<SysRole> getAllandFunc();

    SysRole getAllandFuncById(String roleId);

    SysRole getAllandFuncByIdandSrc(SysRole sysRole);

    SysRole getAllandTiles3dById(String roleId);

    SysRole getAllandBimById(String roleId);

    SysRole getAllandCarById(String roleId);

    SysRole getAllandDeviceById(String roleId);

    SysRole getAllandNetById(String roleId);

    SysRole getAllandPoliceById(String roleId);

    SysRole getAllandSecurityById(String roleId);

    SysRole getAllandUavById(String roleId);

    SysRole getAllandVideoById(@Param("roleId") String roleId, @Param("isIndoor") String isIndoor);
}