package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.HouseMapperC;
import com.city3d.dao.entry.House;
import com.city3d.service.HouseService;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseMapperC houseMapperC;
	
	@Override
	public House findHouseById(String houseId) {
		return houseMapperC.selectHouseById(houseId);
	}
	
	@Override
	public List<House> queryHouse(House house) {
		return houseMapperC.selectByExampleH(house);
	}
	
	@Override
	public List<House> getHouseByAddId(String addId) {
		return houseMapperC.selectHouseByAddId(addId);
	}
	
	@Override
	public int insert(House house){
		return houseMapperC.insert(house);
	}
	
	@Override
	public int updateByPrimaryKey(House house){
		return houseMapperC.updateByPrimaryKey(house);
	}
	
	@Override
	public int deleteByPrimaryKey(String houseId){
		return houseMapperC.deleteByPrimaryKey(houseId);
	}
	
	@Override
	public int batchDelete(List<String> houseIds) {
		return houseMapperC.batchDelete(houseIds);
	}
}
