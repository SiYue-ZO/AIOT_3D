package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.DutyVideo;
import com.city3d.dao.entry.DutyVideoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyVideoMapper {
    int countByExample(DutyVideoExample example);

    int deleteByExample(DutyVideoExample example);

    int deleteByPrimaryKey(String dutyVideoId);

    int insert(DutyVideo record);

    int insertSelective(DutyVideo record);

    List<DutyVideo> selectByExample(DutyVideoExample example);

    DutyVideo selectByPrimaryKey(String dutyVideoId);

    int updateByExampleSelective(@Param("record") DutyVideo record, @Param("example") DutyVideoExample example);

    int updateByExample(@Param("record") DutyVideo record, @Param("example") DutyVideoExample example);

    int updateByPrimaryKeySelective(DutyVideo record);

    int updateByPrimaryKey(DutyVideo record);
}