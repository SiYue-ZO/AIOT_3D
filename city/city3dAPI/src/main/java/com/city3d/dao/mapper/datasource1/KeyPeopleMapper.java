package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.KeyPeople;
import com.city3d.dao.entry.KeyPeopleExample;

@Mapper
public interface KeyPeopleMapper {
    int countByExample(KeyPeopleExample example);

    int deleteByExample(KeyPeopleExample example);

    int deleteByPrimaryKey(String keyId);

    int insert(KeyPeople record);

    int insertSelective(KeyPeople record);

    List<KeyPeople> selectByExample(KeyPeopleExample example);

    KeyPeople selectByPrimaryKey(String keyId);

    int updateByExampleSelective(@Param("record") KeyPeople record, @Param("example") KeyPeopleExample example);

    int updateByExample(@Param("record") KeyPeople record, @Param("example") KeyPeopleExample example);

    int updateByPrimaryKeySelective(KeyPeople record);

    int updateByPrimaryKey(KeyPeople record);
}