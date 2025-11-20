package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.PeopleKnife;
import com.city3d.dao.entry.PeopleKnifeExample;

@Mapper
public interface PeopleKnifeMapper {
    int countByExample(PeopleKnifeExample example);

    int deleteByExample(PeopleKnifeExample example);

    int deleteByPrimaryKey(String knifeId);

    int insert(PeopleKnife record);

    int insertSelective(PeopleKnife record);

    List<PeopleKnife> selectByExample(PeopleKnifeExample example);

    PeopleKnife selectByPrimaryKey(String knifeId);

    int updateByExampleSelective(@Param("record") PeopleKnife record, @Param("example") PeopleKnifeExample example);

    int updateByExample(@Param("record") PeopleKnife record, @Param("example") PeopleKnifeExample example);

    int updateByPrimaryKeySelective(PeopleKnife record);

    int updateByPrimaryKey(PeopleKnife record);
}