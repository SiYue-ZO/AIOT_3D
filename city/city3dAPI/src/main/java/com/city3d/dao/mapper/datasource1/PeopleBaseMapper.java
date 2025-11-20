package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PeopleBase;
import com.city3d.dao.entry.PeopleBaseExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleBaseMapper {
    int countByExample(PeopleBaseExample example);

    int deleteByExample(PeopleBaseExample example);

    int deleteByPrimaryKey(String ppId);

    int insert(PeopleBase record);

    int insertSelective(PeopleBase record);

    List<PeopleBase> selectByExample(PeopleBaseExample example);

    PeopleBase selectByPrimaryKey(String ppId);

    int updateByExampleSelective(@Param("record") PeopleBase record, @Param("example") PeopleBaseExample example);

    int updateByExample(@Param("record") PeopleBase record, @Param("example") PeopleBaseExample example);

    int updateByPrimaryKeySelective(PeopleBase record);

    int updateByPrimaryKey(PeopleBase record);
}