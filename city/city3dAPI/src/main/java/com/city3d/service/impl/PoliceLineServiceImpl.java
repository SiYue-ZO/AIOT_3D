package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PoliceLineMapperC;
import com.city3d.dao.entry.PoliceLine;
import com.city3d.dao.entry.PoliceLineExample;
import com.city3d.dao.entry.PoliceLineExample.Criteria;
import com.city3d.service.PoliceLineService;
import org.springframework.stereotype.Service;

@Service
public class PoliceLineServiceImpl implements PoliceLineService {
    @Autowired
    private PoliceLineMapperC policeLineMapper;

    @Override
    public List<PoliceLine> queryPoliceLine(PoliceLine policeLine) {
        PoliceLineExample example = new PoliceLineExample();
        Criteria criteriaResult = example.or();
        if (policeLine.getlName() != null) {
            criteriaResult = criteriaResult.andLNameLike("%" + policeLine.getlName() + "%");
        }
        if (policeLine.getlType() != null) {
            criteriaResult = criteriaResult.andLTypeLike("%" + policeLine.getlType() + "%");
        }
        return policeLineMapper.selectByExample(example);
    }

    @Override
    public List<PoliceLine> getPoliceLine() {
        return policeLineMapper.selectByExample(null);
    }

    @Override
    public int insert(PoliceLine policeLine) {
        return policeLineMapper.insert(policeLine);
    }

    @Override
    public int updateByPrimaryKey(PoliceLine policeLine) {
        return policeLineMapper.updateByPrimaryKey(policeLine);
    }

    @Override
    public int deleteByPrimaryKey(String lineId) {
        return policeLineMapper.deleteByPrimaryKey(lineId);
    }

    @Override
    public int batchDelete(List<String> lineIds) {
        return policeLineMapper.batchDelete(lineIds);
    }
}
