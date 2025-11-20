package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.NetMan;
import com.city3d.dao.entry.NetManExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NetManMapper {
    int countByExample(NetManExample example);

    int deleteByExample(NetManExample example);

    int deleteByPrimaryKey(String netManId);

    int insert(NetMan record);

    int insertSelective(NetMan record);

    List<NetMan> selectByExample(NetManExample example);

    NetMan selectByPrimaryKey(String netManId);

    int updateByExampleSelective(@Param("record") NetMan record, @Param("example") NetManExample example);

    int updateByExample(@Param("record") NetMan record, @Param("example") NetManExample example);

    int updateByPrimaryKeySelective(NetMan record);

    int updateByPrimaryKey(NetMan record);
}