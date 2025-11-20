package com.city3d.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.ManPosMapperC;
import com.city3d.dao.entry.ManPos;
import com.city3d.dao.entry.ManPosExample;
import com.city3d.dao.entry.ManPosExample.Criteria;
import com.city3d.service.ManPosService;
import org.springframework.stereotype.Service;

@Service
public class ManPosServiceImpl implements ManPosService {
    @Autowired
    private ManPosMapperC manPosMapperC;

    @Override
    public List<ManPos> getManPosAll() {
        return manPosMapperC.selectByExample(null);
    }

    @Override
    public List<ManPos> getManPosByDn(ManPos manPos) {
        ManPosExample example = new ManPosExample();
        Criteria criteriaResult = example.or();
        if (manPos.getDeviceNum() != null) {
            criteriaResult = criteriaResult.andDeviceNumEqualTo(manPos.getDeviceNum());
        }
        return manPosMapperC.selectByExample(example);
    }

    @Override
    public List<ManPos> getManPosWithNameAndOrigin(String[] deviceNums) {
        return manPosMapperC.getManPosWithNameAndOrigin(deviceNums);
    }

    @Override
    public List<ManPos> getTraceManPos2Days(Map<String, String> params) {
        return manPosMapperC.getTraceManPos2Days(params);
    }

    @Override
    public List<ManPos> getTraceManPosInOneDay(Map<String, String> params) {
        return manPosMapperC.getTraceManPosInOneDay(params);
    }
}
