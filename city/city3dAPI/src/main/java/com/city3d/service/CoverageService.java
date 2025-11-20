package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Coverage;

public interface CoverageService {
    List<Coverage> getCoverageAll();

    int insert(Coverage coverage);

    int updateByPrimaryKey(Coverage coverage);

    int deleteByPrimaryKey(String id);
}
