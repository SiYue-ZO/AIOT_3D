package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.EplanMapper;
import com.city3d.dao.entry.Eplan;
import com.city3d.service.EplanService;
import org.springframework.stereotype.Service;

@Service
public class EplanServiceImpl implements EplanService {
	@Autowired
	private EplanMapper eplanMapper;

	@Override
	public List<Eplan> getEplan() {
		return eplanMapper.selectByExample(null);
	}

	@Override
	public int insert(Eplan eplan) {
		return eplanMapper.insert(eplan);
	}

	@Override
	public int updateByPrimaryKey(Eplan eplan) {
		return eplanMapper.updateByPrimaryKey(eplan);
	}

	@Override
	public int deleteByPrimaryKey(String eplanId) {
		return eplanMapper.deleteByPrimaryKey(eplanId);
	}
}
