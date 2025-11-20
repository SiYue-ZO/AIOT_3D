package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PoliceMapperC;
import com.city3d.dao.entry.Police;
import com.city3d.dao.entry.PoliceExample;
import com.city3d.service.PoliceService;
import org.springframework.stereotype.Service;

@Service
public class PoliceServiceImpl implements PoliceService {
    @Autowired
    private PoliceMapperC policeMapperC;

    @Override
    public List<Police> getPolice() {
        return policeMapperC.selectByExample(null);
    }

    @Override
    public int insert(Police police) {
        return policeMapperC.insert(police);
    }

    @Override
    public int updateByPrimaryKey(Police police) {
        return policeMapperC.updateByPrimaryKey(police);
    }

    @Override
    public int deleteByPrimaryKey(String policeId) {
        return policeMapperC.deleteByPrimaryKey(policeId);
    }

    @Override
    public List<Police> findPoliceByPuid(String deviceNum) {
        PoliceExample example = new PoliceExample();
        example.or().andDeviceNumEqualTo(deviceNum);
        return policeMapperC.selectByExample(example);
    }

    @Override
    public List<Police> getPoliceRealDateWithManPos() {
        return policeMapperC.getPoliceRealDateWithManPos();
    }

    @Override
    public Police getPoliceAndEquipmentsByPuid(String deviceNum) {
        return policeMapperC.getPoliceAndEquipmentsByPuid(deviceNum);
    }
}
