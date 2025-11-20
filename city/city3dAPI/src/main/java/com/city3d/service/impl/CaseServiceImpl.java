package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PoliceCaseMapperC;
import com.city3d.dao.entry.PoliceCase;
import com.city3d.dao.entry.PoliceCaseExample;
import com.city3d.dao.entry.PoliceCaseExample.Criteria;
import com.city3d.service.CaseService;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    private PoliceCaseMapperC policeCaseMapperC;

    @Override
    public List<PoliceCase> getCase() {
        return policeCaseMapperC.getCase();
    }

    @Override
    public List<PoliceCase> getCaseAll() {
        return policeCaseMapperC.selectByExample(null);
    }

    @Override
    public PoliceCase getCaseandNetById(String caseId) {
        return policeCaseMapperC.selectCaseandNetById(caseId);
    }

    @Override
    public int countByNet(String netId) {
        PoliceCaseExample example = new PoliceCaseExample();
        example.or().andNetIdEqualTo(netId);
        return policeCaseMapperC.countByExample(example);
    }

    @Override
    public int insertEmergencyCase(PoliceCase policeCase) {
        return policeCaseMapperC.insert(policeCase);
    }

    @Override
    public int insert(PoliceCase policeCase) {
        return policeCaseMapperC.insert(policeCase);
    }

    @Override
    public int updateByPrimaryKey(PoliceCase policeCase) {
        return policeCaseMapperC.updateByPrimaryKey(policeCase);
    }

    @Override
    public int deleteByPrimaryKey(String caseId) {
        return policeCaseMapperC.deleteByPrimaryKey(caseId);
    }

    @Override
    public List<PoliceCase> queryPoliceCase(PoliceCase policeCase) {
        PoliceCaseExample example = new PoliceCaseExample();
        Criteria criteria = example.createCriteria();
        if (policeCase.getCaseName() != null && !policeCase.getCaseName().equals("")) {
            criteria.andCaseNameLike("%" + policeCase.getCaseName() + "%");
        }
        if (policeCase.getCaseType() != null && !policeCase.getCaseType().equals("")) {
            criteria.andCaseTypeLike("%" + policeCase.getCaseType() + "%");
        }
        if (policeCase.getCaseSource() != null && !policeCase.getCaseSource().equals("")) {
            criteria.andCaseSourceEqualTo(policeCase.getCaseSource());
        }
        return policeCaseMapperC.selectByExample(example);
    }
}
