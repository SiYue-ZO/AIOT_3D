package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.AccessMan;
import com.city3d.dao.entry.AccessManExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccessManMapper {
    int countByExample(AccessManExample example);

    int deleteByExample(AccessManExample example);

    int deleteByPrimaryKey(String accessManId);

    int insert(AccessMan record);

    int insertSelective(AccessMan record);

    List<AccessMan> selectByExample(AccessManExample example);

    AccessMan selectByPrimaryKey(String accessManId);

    int updateByExampleSelective(@Param("record") AccessMan record, @Param("example") AccessManExample example);

    int updateByExample(@Param("record") AccessMan record, @Param("example") AccessManExample example);

    int updateByPrimaryKeySelective(AccessMan record);

    int updateByPrimaryKey(AccessMan record);
}