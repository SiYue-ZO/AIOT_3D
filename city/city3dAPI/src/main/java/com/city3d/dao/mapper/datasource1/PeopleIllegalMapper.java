package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.PeopleIllegal;
import com.city3d.dao.entry.PeopleIllegalExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleIllegalMapper {
    int countByExample(PeopleIllegalExample example);

    int deleteByExample(PeopleIllegalExample example);

    int deleteByPrimaryKey(String illegalId);

    int insert(PeopleIllegal record);

    int insertSelective(PeopleIllegal record);

    List<PeopleIllegal> selectByExample(PeopleIllegalExample example);

    PeopleIllegal selectByPrimaryKey(String illegalId);

    int updateByExampleSelective(@Param("record") PeopleIllegal record, @Param("example") PeopleIllegalExample example);

    int updateByExample(@Param("record") PeopleIllegal record, @Param("example") PeopleIllegalExample example);

    int updateByPrimaryKeySelective(PeopleIllegal record);

    int updateByPrimaryKey(PeopleIllegal record);
}