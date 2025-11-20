package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.BimMapperC;
import com.city3d.dao.entry.Bim;
import com.city3d.service.BimService;
import org.springframework.stereotype.Service;

@Service
public class BimServiceImpl implements BimService {
	@Autowired
	private BimMapperC bimMapper;

	@Override
	public List<Bim> getBim() {
		return bimMapper.selectByExample(null);
	}

	@Override
	public int insert(Bim bim) {
		return bimMapper.insert(bim);
	}

	@Override
	public int updateByPrimaryKey(Bim bim) {
		return bimMapper.updateByPrimaryKey(bim);
	}

	@Override
	public int deleteByPrimaryKey(String tilesId) {
		return bimMapper.deleteByPrimaryKey(tilesId);
	}

	@Override
	public int batchDelete(List<String> accessManIds) {
		return bimMapper.batchDelete(accessManIds);
	}
}
