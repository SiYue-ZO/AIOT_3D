package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.PeopleRelation;
import com.city3d.dao.entry.PeopleRelationExample;

@Mapper
public interface PeopleRelationMapper {
    int countByExample(PeopleRelationExample example);

    int deleteByExample(PeopleRelationExample example);

    int deleteByPrimaryKey(String relationId);

    int insert(PeopleRelation record);

    int insertSelective(PeopleRelation record);

    List<PeopleRelation> selectByExample(PeopleRelationExample example);

    PeopleRelation selectByPrimaryKey(String relationId);

    int updateByExampleSelective(@Param("record") PeopleRelation record, @Param("example") PeopleRelationExample example);

    int updateByExample(@Param("record") PeopleRelation record, @Param("example") PeopleRelationExample example);

    int updateByPrimaryKeySelective(PeopleRelation record);

    int updateByPrimaryKey(PeopleRelation record);

}