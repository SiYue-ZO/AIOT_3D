package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Video0Live;
import com.city3d.dao.entry.Video0LiveExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Video0LiveMapper {
    int countByExample(Video0LiveExample example);

    int deleteByExample(Video0LiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Video0Live record);

    int insertSelective(Video0Live record);

    List<Video0Live> selectByExample(Video0LiveExample example);

    Video0Live selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Video0Live record, @Param("example") Video0LiveExample example);

    int updateByExample(@Param("record") Video0Live record, @Param("example") Video0LiveExample example);

    int updateByPrimaryKeySelective(Video0Live record);

    int updateByPrimaryKey(Video0Live record);
}