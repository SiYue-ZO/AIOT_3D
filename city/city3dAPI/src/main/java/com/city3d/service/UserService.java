package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.SysUser;

public interface UserService {
    List<SysUser> getUser();

    int insert(SysUser sysUser);

    int updateByPrimaryKey(SysUser sysUser);

    int deleteByPrimaryKey(String userId);

    SysUser findByLoginNameAndPwd(String loginName, String pwd);

    List<SysUser> findByLoginName(String loginName);

    int updatePwd(SysUser sysUser);
}
