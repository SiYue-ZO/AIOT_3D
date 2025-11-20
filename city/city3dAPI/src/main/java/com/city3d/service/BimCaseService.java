package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.BimCase;

public interface BimCaseService {
    List<BimCase> getBimCase();

    int insert(BimCase bimCase);

    int updateByPrimaryKey(BimCase bimCase);

    int deleteByPrimaryKey(String bimCaseId);
}
