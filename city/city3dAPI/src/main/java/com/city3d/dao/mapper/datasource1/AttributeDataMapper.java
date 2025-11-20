package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.AttributeData;
import com.city3d.dao.entry.AttributeDataExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttributeDataMapper {
    int countByExample(AttributeDataExample example);

    int deleteByExample(AttributeDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(AttributeData record);

    int insertSelective(AttributeData record);

    List<AttributeData> selectByExample(AttributeDataExample example);

    AttributeData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AttributeData record, @Param("example") AttributeDataExample example);

    int updateByExample(@Param("record") AttributeData record, @Param("example") AttributeDataExample example);

    int updateByPrimaryKeySelective(AttributeData record);

    int updateByPrimaryKey(AttributeData record);
}