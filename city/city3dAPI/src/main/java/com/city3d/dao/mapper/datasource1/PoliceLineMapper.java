package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PoliceLine;
import com.city3d.dao.entry.PoliceLineExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PoliceLineMapper {
    int countByExample(PoliceLineExample example);

    int deleteByExample(PoliceLineExample example);

    int deleteByPrimaryKey(String lId);

    int insert(PoliceLine record);

    int insertSelective(PoliceLine record);

    List<PoliceLine> selectByExample(PoliceLineExample example);

    PoliceLine selectByPrimaryKey(String lId);

    int updateByExampleSelective(@Param("record") PoliceLine record, @Param("example") PoliceLineExample example);

    int updateByExample(@Param("record") PoliceLine record, @Param("example") PoliceLineExample example);

    int updateByPrimaryKeySelective(PoliceLine record);

    int updateByPrimaryKey(PoliceLine record);
}