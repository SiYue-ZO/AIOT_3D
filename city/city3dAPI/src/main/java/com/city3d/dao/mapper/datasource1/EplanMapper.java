package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Eplan;
import com.city3d.dao.entry.EplanExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EplanMapper {
    int countByExample(EplanExample example);

    int deleteByExample(EplanExample example);

    int deleteByPrimaryKey(String eplanId);

    int insert(Eplan record);

    int insertSelective(Eplan record);

    List<Eplan> selectByExample(EplanExample example);

    Eplan selectByPrimaryKey(String eplanId);

    int updateByExampleSelective(@Param("record") Eplan record, @Param("example") EplanExample example);

    int updateByExample(@Param("record") Eplan record, @Param("example") EplanExample example);

    int updateByPrimaryKeySelective(Eplan record);

    int updateByPrimaryKey(Eplan record);
}