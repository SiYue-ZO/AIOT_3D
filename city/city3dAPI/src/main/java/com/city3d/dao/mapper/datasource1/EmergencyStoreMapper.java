package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.EmergencyStore;
import com.city3d.dao.entry.EmergencyStoreExample;

@Mapper
public interface EmergencyStoreMapper {
    int countByExample(EmergencyStoreExample example);

    int deleteByExample(EmergencyStoreExample example);

    int deleteByPrimaryKey(String storeId);

    int insert(EmergencyStore record);

    int insertSelective(EmergencyStore record);

    List<EmergencyStore> selectByExample(EmergencyStoreExample example);

    EmergencyStore selectByPrimaryKey(String storeId);

    int updateByExampleSelective(@Param("record") EmergencyStore record, @Param("example") EmergencyStoreExample example);

    int updateByExample(@Param("record") EmergencyStore record, @Param("example") EmergencyStoreExample example);

    int updateByPrimaryKeySelective(EmergencyStore record);

    int updateByPrimaryKey(EmergencyStore record);
}