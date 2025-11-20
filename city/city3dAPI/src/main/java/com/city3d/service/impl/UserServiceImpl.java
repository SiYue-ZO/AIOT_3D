package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.SysUserMapperC;
import com.city3d.dao.entry.SysUser;
import com.city3d.dao.entry.SysUserExample;
import com.city3d.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapperC sysUserMapper;

    @Override
    public List<SysUser> getUser() {
        return sysUserMapper.selectUserAll();
    }

    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int updateByPrimaryKey(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser findByLoginNameAndPwd(String loginName, String pwd) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andPwdEqualTo(pwd);
        List<SysUser> result = sysUserMapper.selectByExample(example);
        try {
            return result.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SysUser> findByLoginName(String loginName) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        return sysUserMapper.selectByExample(example);
    }

    @Override
    public int updatePwd(SysUser sysUser) {
        return sysUserMapper.updatePwd(sysUser);
    }
}
