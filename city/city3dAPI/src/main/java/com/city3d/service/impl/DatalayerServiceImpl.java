package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.DatalayerMapper;
import com.city3d.dao.entry.Datalayer;
import com.city3d.service.DatalayerService;
import org.springframework.stereotype.Service;

@Service
public class DatalayerServiceImpl implements DatalayerService {
	@Autowired
	DatalayerMapper datalayerMapper;
	
	@Override
	public List<Datalayer> getDatalayer() {
		return datalayerMapper.selectByExample(null);
	}

	@Override
	public int insert(Datalayer datalayer) {
		return datalayerMapper.insert(datalayer);
	}

	@Override
	public int updateByPrimaryKey(Datalayer datalayer) {
		return datalayerMapper.updateByPrimaryKey(datalayer);
	}

	@Override
	public int deleteByPrimaryKey(String layerId) {
		return datalayerMapper.deleteByPrimaryKey(layerId);
	}
}
