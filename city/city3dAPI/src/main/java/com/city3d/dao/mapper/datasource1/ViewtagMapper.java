package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.Viewtag;
import com.city3d.dao.entry.ViewtagExample;

@Mapper
public interface ViewtagMapper {
    int countByExample(ViewtagExample example);

    int deleteByExample(ViewtagExample example);

    int deleteByPrimaryKey(String tagId);

    int insert(Viewtag record);

    int insertSelective(Viewtag record);

    List<Viewtag> selectByExample(ViewtagExample example);

    Viewtag selectByPrimaryKey(String tagId);

    int updateByExampleSelective(@Param("record") Viewtag record, @Param("example") ViewtagExample example);

    int updateByExample(@Param("record") Viewtag record, @Param("example") ViewtagExample example);

    int updateByPrimaryKeySelective(Viewtag record);

    int updateByPrimaryKey(Viewtag record);
}