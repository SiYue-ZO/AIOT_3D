package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.DutyVideoVideo;
import com.city3d.dao.entry.DutyVideoVideoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DutyVideoVideoMapper {
    int countByExample(DutyVideoVideoExample example);

    int deleteByExample(DutyVideoVideoExample example);

    int deleteByPrimaryKey(String dutyVideoVideoId);

    int insert(DutyVideoVideo record);

    int insertSelective(DutyVideoVideo record);

    List<DutyVideoVideo> selectByExample(DutyVideoVideoExample example);

    DutyVideoVideo selectByPrimaryKey(String dutyVideoVideoId);

    int updateByExampleSelective(@Param("record") DutyVideoVideo record, @Param("example") DutyVideoVideoExample example);

    int updateByExample(@Param("record") DutyVideoVideo record, @Param("example") DutyVideoVideoExample example);

    int updateByPrimaryKeySelective(DutyVideoVideo record);

    int updateByPrimaryKey(DutyVideoVideo record);
}