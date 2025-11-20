package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AttributeDataMapperC;
import com.city3d.dao.entry.AttributeData;
import com.city3d.service.AttributeDataService;
import org.springframework.stereotype.Service;

@Service
public class AttributeDataServiceImpl implements AttributeDataService {
	@Autowired
	private AttributeDataMapperC attributeDataMapperC;
	
	@Override
	public List<AttributeData> getAttributeDataAndCoverageByCoverageId(String coverageId) {
		return attributeDataMapperC.getAttributeDataAndCoverageByCoverageId(coverageId);
	}
	
	@Override
	public int insert(AttributeData attributeData) {
		return attributeDataMapperC.insert(attributeData);
	}
	
	@Override
	public int updateByPrimaryKey(AttributeData attributeData) {
		return attributeDataMapperC.updateByPrimaryKey(attributeData);
	}
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return attributeDataMapperC.deleteByPrimaryKey(id);
	}

	@Override
	public AttributeData getAttributeDataAndAddressById(String id) {
		return attributeDataMapperC.selectByPrimaryKey(id);
	}
	
	@Override
	public List<AttributeData> getAttributeDataAddressByCoverageIdAndAddName(String coverageId,String addName) {
		return attributeDataMapperC.getAttributeDataAddressByCoverageIdAndAddName(coverageId,addName);
	}
}
