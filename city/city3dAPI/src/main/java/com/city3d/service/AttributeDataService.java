package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.AttributeData;

public interface AttributeDataService {
    List<AttributeData> getAttributeDataAndCoverageByCoverageId(String coverageId);

    AttributeData getAttributeDataAndAddressById(String id);

    List<AttributeData> getAttributeDataAddressByCoverageIdAndAddName(String coverageId, String addName);

    int insert(AttributeData attributeData);

    int updateByPrimaryKey(AttributeData attributeData);

    int deleteByPrimaryKey(String id);
}
