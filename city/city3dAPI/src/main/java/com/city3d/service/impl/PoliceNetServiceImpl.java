package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.PoliceNetMapperC;
import com.city3d.dao.entry.PoliceNet;
import com.city3d.dao.entry.PoliceNetExample;
import com.city3d.dao.entry.PoliceNetExample.Criteria;
import com.city3d.service.PoliceNetService;
import org.springframework.stereotype.Service;

@Service
public class PoliceNetServiceImpl implements PoliceNetService {
    @Autowired
    private PoliceNetMapperC policeNetMapper;

    @Override
    public List<PoliceNet> getPoliceNet() {
        return policeNetMapper.selectByExample(null);
    }

    @Override
    public List<PoliceNet> queryPoliceNet(PoliceNet policeNet) {
        PoliceNetExample example = new PoliceNetExample();
        Criteria criteriaResult = example.or();
        if (policeNet.getNetName() != null) {
            criteriaResult = criteriaResult.andNetNameLike("%" + policeNet.getNetName() + "%");
        }
        if (policeNet.getNetDep() != null) {
            criteriaResult = criteriaResult.andNetDepLike("%" + policeNet.getNetDep() + "%");
        }
        return policeNetMapper.selectByExample(example);
    }

    @Override
    public int insert(PoliceNet policeNet) {
        return policeNetMapper.insert(policeNet);
    }

    @Override
    public int updateByPrimaryKey(PoliceNet policeNet) {
        return policeNetMapper.updateByPrimaryKey(policeNet);
    }

    @Override
    public int deleteByPrimaryKey(String netId) {
        return policeNetMapper.deleteByPrimaryKey(netId);
    }

    @Override
    public int batchDelete(List<String> netIds) {
        return policeNetMapper.batchDelete(netIds);
    }
}
