package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BimDeviceMapperC;
import com.city3d.dao.entry.BimDevice;
import com.city3d.service.BimDeviceService;
import org.springframework.stereotype.Service;

@Service
public class BimDeviceServiceImpl implements BimDeviceService {
	@Autowired
	private BimDeviceMapperC bimDeviceMapper;
	
	@Override
	public List<BimDevice> getBimDevice() {
		return bimDeviceMapper.selectByExample(null);
	}
	
	@Override
	public BimDevice getBimDeviceById(String deviceId) {
		return bimDeviceMapper.selectByPrimaryKey(deviceId);
	}

	@Override
	public int insert(BimDevice bimDevice) {
		return bimDeviceMapper.insert(bimDevice);
	}

	@Override
	public int updateByPrimaryKey(BimDevice bimDevice) {
		return bimDeviceMapper.updateByPrimaryKey(bimDevice);
	}

	@Override
	public int deleteByPrimaryKey(String deviceId) {
		return bimDeviceMapper.deleteByPrimaryKey(deviceId);
	}

	@Override
	public int batchDelete(List<String> deviceIds) {
		return bimDeviceMapper.batchDelete(deviceIds);
	}
}
