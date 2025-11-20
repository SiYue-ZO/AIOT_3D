package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.BimDevice;
import com.city3d.dao.entry.BimDeviceExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BimDeviceMapper {
    int countByExample(BimDeviceExample example);

    int deleteByExample(BimDeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(BimDevice record);

    int insertSelective(BimDevice record);

    List<BimDevice> selectByExample(BimDeviceExample example);

    BimDevice selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") BimDevice record, @Param("example") BimDeviceExample example);

    int updateByExample(@Param("record") BimDevice record, @Param("example") BimDeviceExample example);

    int updateByPrimaryKeySelective(BimDevice record);

    int updateByPrimaryKey(BimDevice record);
}