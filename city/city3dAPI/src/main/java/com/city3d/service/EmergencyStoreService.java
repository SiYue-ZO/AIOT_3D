package com.city3d.service;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.EmergencyStore;

public interface EmergencyStoreService {
    List<HashMap<String, String>> getEmergencyStore();

    List<EmergencyStore> getEmergencyStoreAll();

    EmergencyStore getEmergencyStoreById(String storeId);

    List<EmergencyStore> queryEmergencyStore(EmergencyStore emergencyStore);

    int insert(EmergencyStore emergencyStore);

    int updateByPrimaryKey(EmergencyStore emergencyStore);

    int deleteByPrimaryKey(String storeId);
}
