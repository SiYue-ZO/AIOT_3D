package com.city3d.dao.mapper.datasource1;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.EmergencyStore;
import com.city3d.dao.entry.EmergencyStoreExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmergencyStoreMapperC extends EmergencyStoreMapper {
    List<HashMap<String, String>> getIDandPOI();

    EmergencyStore selectEmergencyStoreById(String storeId);

    List<EmergencyStore> selectByExampleC(EmergencyStoreExample example);
}
