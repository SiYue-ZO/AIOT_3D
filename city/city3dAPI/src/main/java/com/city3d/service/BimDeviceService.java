package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.BimDevice;

public interface BimDeviceService {
    List<BimDevice> getBimDevice();

    BimDevice getBimDeviceById(String deviceId);

    int insert(BimDevice bimDevice);

    int updateByPrimaryKey(BimDevice bimDevice);

    int deleteByPrimaryKey(String deviceId);

    int batchDelete(List<String> deviceIds);
}
