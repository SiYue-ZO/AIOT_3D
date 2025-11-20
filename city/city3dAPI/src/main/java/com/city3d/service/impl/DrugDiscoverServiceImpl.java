package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleDrugDiscoverMapper;
import com.city3d.dao.entry.PeopleDrugDiscover;
import com.city3d.dao.entry.PeopleDrugDiscoverExample;
import com.city3d.service.DrugDiscoverService;
import org.springframework.stereotype.Service;

@Service
public class DrugDiscoverServiceImpl implements DrugDiscoverService{
	@Autowired
	private PeopleDrugDiscoverMapper peopleDrugDiscoverMapper;

	@Override
	public List<PeopleDrugDiscover> findByPpId(String ppId) {
		PeopleDrugDiscoverExample example = new PeopleDrugDiscoverExample();
		example.createCriteria().andPpIdEqualTo(ppId);
		return peopleDrugDiscoverMapper.selectByExample(example);
	}

	@Override
	public int save(PeopleDrugDiscover entity) {
		return peopleDrugDiscoverMapper.insert(entity);
	}
	
	@Override
	public int updateByPrimaryKey(PeopleDrugDiscover entity) {
		return peopleDrugDiscoverMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return peopleDrugDiscoverMapper.deleteByPrimaryKey(id);
	}
}
