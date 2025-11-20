package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.UavReal;
import com.city3d.dao.entry.UavRealExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UavRealMapper {
    int countByExample(UavRealExample example);

    int deleteByExample(UavRealExample example);

    int deleteByPrimaryKey(String realId);

    int insert(UavReal record);

    int insertSelective(UavReal record);

    List<UavReal> selectByExample(UavRealExample example);

    UavReal selectByPrimaryKey(String realId);

    int updateByExampleSelective(@Param("record") UavReal record, @Param("example") UavRealExample example);

    int updateByExample(@Param("record") UavReal record, @Param("example") UavRealExample example);

    int updateByPrimaryKeySelective(UavReal record);

    int updateByPrimaryKey(UavReal record);
}