package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PolicePoint;
import com.city3d.dao.entry.PolicePointExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PolicePointMapper {
    int countByExample(PolicePointExample example);

    int deleteByExample(PolicePointExample example);

    int deleteByPrimaryKey(String pId);

    int insert(PolicePoint record);

    int insertSelective(PolicePoint record);

    List<PolicePoint> selectByExample(PolicePointExample example);

    PolicePoint selectByPrimaryKey(String pId);

    int updateByExampleSelective(@Param("record") PolicePoint record, @Param("example") PolicePointExample example);

    int updateByExample(@Param("record") PolicePoint record, @Param("example") PolicePointExample example);

    int updateByPrimaryKeySelective(PolicePoint record);

    int updateByPrimaryKey(PolicePoint record);
}