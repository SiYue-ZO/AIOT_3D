package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Coverage;
import com.city3d.dao.entry.CoverageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CoverageMapper {
    int countByExample(CoverageExample example);

    int deleteByExample(CoverageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Coverage record);

    int insertSelective(Coverage record);

    List<Coverage> selectByExample(CoverageExample example);

    Coverage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Coverage record, @Param("example") CoverageExample example);

    int updateByExample(@Param("record") Coverage record, @Param("example") CoverageExample example);

    int updateByPrimaryKeySelective(Coverage record);

    int updateByPrimaryKey(Coverage record);
}