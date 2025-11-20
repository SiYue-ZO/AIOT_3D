package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Net;
import com.city3d.dao.entry.NetExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NetMapper {
    int countByExample(NetExample example);

    int deleteByExample(NetExample example);

    int deleteByPrimaryKey(String netId);

    int insert(Net record);

    int insertSelective(Net record);

    List<Net> selectByExample(NetExample example);

    Net selectByPrimaryKey(String netId);

    int updateByExampleSelective(@Param("record") Net record, @Param("example") NetExample example);

    int updateByExample(@Param("record") Net record, @Param("example") NetExample example);

    int updateByPrimaryKeySelective(Net record);

    int updateByPrimaryKey(Net record);
}