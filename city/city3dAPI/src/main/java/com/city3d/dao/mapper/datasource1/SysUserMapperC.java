package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapperC extends SysUserMapper {
    List<SysUser> selectUserAll();

    int updatePwd(SysUser sysUser);
}