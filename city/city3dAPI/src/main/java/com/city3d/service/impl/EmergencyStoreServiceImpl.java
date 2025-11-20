package com.city3d.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.EmergencyStoreMapperC;
import com.city3d.dao.entry.EmergencyStoreExample.Criteria;
import com.city3d.dao.entry.EmergencyStore;
import com.city3d.dao.entry.EmergencyStoreExample;
import com.city3d.service.EmergencyStoreService;
import org.springframework.stereotype.Service;

@Service
public class EmergencyStoreServiceImpl implements EmergencyStoreService {
    @Autowired
    private EmergencyStoreMapperC emergencyStoreMapperC;

    @Override
    public List<HashMap<String, String>> getEmergencyStore() {
        return emergencyStoreMapperC.getIDandPOI();
    }

    @Override
    public List<EmergencyStore> getEmergencyStoreAll() {
        return emergencyStoreMapperC.selectByExample(null);
    }

    @Override
    public EmergencyStore getEmergencyStoreById(String storeId) {
        return emergencyStoreMapperC.selectEmergencyStoreById(storeId);
    }

    @Override
    public List<EmergencyStore> queryEmergencyStore(EmergencyStore emergencyStore) {
        EmergencyStoreExample example = new EmergencyStoreExample();
        Criteria criteriaResult = example.or();
        if (emergencyStore.getType() != null) {
            criteriaResult = criteriaResult.andTypeLike("%" + emergencyStore.getType() + "%");
        }
        return emergencyStoreMapperC.selectByExampleC(example);
    }

    @Override
    public int insert(EmergencyStore emergencyStore) {
        return emergencyStoreMapperC.insert(emergencyStore);
    }

    @Override
    public int updateByPrimaryKey(EmergencyStore emergencyStore) {
        return emergencyStoreMapperC.updateByPrimaryKey(emergencyStore);
    }

    @Override
    public int deleteByPrimaryKey(String storeId) {
        return emergencyStoreMapperC.deleteByPrimaryKey(storeId);
    }
}
