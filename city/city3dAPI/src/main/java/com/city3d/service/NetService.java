package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Net;

public interface NetService {
    List<Object> getNetAndCount(Net net);

    List<Object> getNetAndCountById(Net net);

    List<Object> getNetByExample(Net net);

    List<Object> getNetAndCountHouse(Net net);

    List<Object> getNetAndCountHouseById(Net net);

    List<Object> getNetHouseByExample(Net net);

    List<Object> getNetCompanyByExample(Net net);

    List<Object> getNetCompanyByExampleById(Net net);

    List<Object> getNetAndCountAddress(Net net);

    List<Object> getNetAndCountAddressById(Net net);

    List<Object> getNetAddressByExample(Net net);

    List<Object> getNetAndCountAll(Net net);

    List<Object> getNetAndCountAllById(Net net);

    List<Net> queryNetData(Net net);

    List<Object> getNetById(String netId);

    Net getNetInfoById(String netId);

    List<Object> getNetAndCountAllN(Net net);

    int insertNet(Net net);

    int deleteByPrimaryKey(String netId);

    int updateByPrimaryKey(Net net);

    int batchDelete(List<String> netIds);

    List<Object> getNetAndCountBuildingRemove(Net net);

    List<Object> getNetAndCountBuildingRemoveById(Net net);

    List<Object> getBuildingRemoveNetById(Net net);
}
