package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.AccessMan;

public interface AccessManService {
    List<AccessMan> getAccessMan();

    int deleteByPrimaryKey(String accessManId);

    int batchDelete(List<String> accessManIds);
}
