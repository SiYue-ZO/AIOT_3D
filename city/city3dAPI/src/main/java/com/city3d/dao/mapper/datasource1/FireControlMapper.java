package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.FireControl;
import com.city3d.dao.entry.FireControlExample;

@Mapper
public interface FireControlMapper {
    int countByExample(FireControlExample example);

    int deleteByExample(FireControlExample example);

    int deleteByPrimaryKey(String fireCtlId);

    int insert(FireControl record);

    int insertSelective(FireControl record);

    List<FireControl> selectByExample(FireControlExample example);

    FireControl selectByPrimaryKey(String fireCtlId);

    int updateByExampleSelective(@Param("record") FireControl record, @Param("example") FireControlExample example);

    int updateByExample(@Param("record") FireControl record, @Param("example") FireControlExample example);

    int updateByPrimaryKeySelective(FireControl record);

    int updateByPrimaryKey(FireControl record);
}