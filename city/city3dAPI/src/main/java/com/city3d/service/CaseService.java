package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PoliceCase;

public interface CaseService {
    List<PoliceCase> getCase();

    List<PoliceCase> getCaseAll();

    PoliceCase getCaseandNetById(String caseId);

    int countByNet(String netId);

    int insertEmergencyCase(PoliceCase policeCase);

    int insert(PoliceCase policeCase);

    int updateByPrimaryKey(PoliceCase policeCase);

    int deleteByPrimaryKey(String caseId);

    List<PoliceCase> queryPoliceCase(PoliceCase policeCase);
}
