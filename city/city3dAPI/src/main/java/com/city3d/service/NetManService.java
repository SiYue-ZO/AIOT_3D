package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.NetMan;

public interface NetManService {
    List<NetMan> getNetMan();

    NetMan getNetManById(String netManId);

    List<NetMan> getNetManByType(String type);

    int insert(NetMan netMan);

    int updateByPrimaryKey(NetMan netMan);

    int deleteByPrimaryKey(String netManId);

    int batchDelete(List<String> netManIds);
}
