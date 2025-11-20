package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.PoliceLine;

public interface PoliceLineService {
    List<PoliceLine> queryPoliceLine(PoliceLine policeLine);

    List<PoliceLine> getPoliceLine();

    int insert(PoliceLine policeLine);

    int updateByPrimaryKey(PoliceLine policeLine);

    int deleteByPrimaryKey(String lineId);

    int batchDelete(List<String> lineIds);
}
