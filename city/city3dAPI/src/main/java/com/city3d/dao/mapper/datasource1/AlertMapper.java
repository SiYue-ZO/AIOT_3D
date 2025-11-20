package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Alert;
import com.city3d.dao.entry.AlertExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AlertMapper {
    int countByExample(AlertExample example);

    int deleteByExample(AlertExample example);

    int deleteByPrimaryKey(String id);

    int insert(Alert record);

    int insertSelective(Alert record);

    List<Alert> selectByExample(AlertExample example);

    Alert selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Alert record, @Param("example") AlertExample example);

    int updateByExample(@Param("record") Alert record, @Param("example") AlertExample example);

    int updateByPrimaryKeySelective(Alert record);

    int updateByPrimaryKey(Alert record);
}