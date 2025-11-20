package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleVehicleMapperC;
import com.city3d.dao.entry.PeopleVehicle;
import com.city3d.dao.entry.PeopleVehicleExample;
import com.city3d.service.PeopleVehicleService;
import org.springframework.stereotype.Service;

@Service
public class PeopleVehicleServiceImpl implements PeopleVehicleService {
	@Autowired
	private PeopleVehicleMapperC peopleVehicleMapperC;
	
	@Override
	public List<PeopleVehicle> selectPeopleVehicleAll() {
		return peopleVehicleMapperC.selectPeopleVehicleAll();
	}

	@Override
	public List<PeopleVehicle> findByPpId(String ppId) {
		PeopleVehicleExample example = new PeopleVehicleExample();
		example.createCriteria().andPpIdEqualTo(ppId);
		return peopleVehicleMapperC.selectByExample(example);
	}

	@Override
	public int insert(PeopleVehicle entity) {
		return peopleVehicleMapperC.insert(entity);
	}
	
	@Override
	public int updateByPrimaryKey(PeopleVehicle entity) {
		return peopleVehicleMapperC.updateByPrimaryKey(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return peopleVehicleMapperC.deleteByPrimaryKey(id);
	}
	
	@Override
	public int batchDelete(List<String> vehicleIds) {
		return peopleVehicleMapperC.batchDelete(vehicleIds);
	}
}
