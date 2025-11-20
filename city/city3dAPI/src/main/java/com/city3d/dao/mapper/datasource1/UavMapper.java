package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Uav;
import com.city3d.dao.entry.UavExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UavMapper {
    int countByExample(UavExample example);

    int deleteByExample(UavExample example);

    int deleteByPrimaryKey(String uavId);

    int insert(Uav record);

    int insertSelective(Uav record);

    List<Uav> selectByExample(UavExample example);

    Uav selectByPrimaryKey(String uavId);

    int updateByExampleSelective(@Param("record") Uav record, @Param("example") UavExample example);

    int updateByExample(@Param("record") Uav record, @Param("example") UavExample example);

    int updateByPrimaryKeySelective(Uav record);

    int updateByPrimaryKey(Uav record);
}