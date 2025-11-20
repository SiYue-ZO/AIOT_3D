package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AttributeMapperC;
import com.city3d.dao.entry.Attribute;
import com.city3d.dao.entry.AttributeExample;
import com.city3d.service.AttributeService;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeMapperC attributeMapperC;

    @Override
    public List<Attribute> getAttributeAll() {
        return attributeMapperC.getAttributeAll();
    }

    @Override
    public List<Attribute> getAttributeOnlyByCoverId(String coverageId) {
        AttributeExample example = new AttributeExample();
        example.createCriteria().andCoverageIdEqualTo(coverageId);
        return attributeMapperC.selectByExample(example);
    }

    @Override
    public int getAttributeMaxOrderNumByCoverageId(String coverageId) {
        AttributeExample example = new AttributeExample();
        example.createCriteria().andCoverageIdEqualTo(coverageId);
        return attributeMapperC.countByExample(example);
    }

    @Override
    public int insert(Attribute attribute) {
        return attributeMapperC.insert(attribute);
    }

    @Override
    public int updateByPrimaryKey(Attribute attribute) {
        return attributeMapperC.updateByPrimaryKey(attribute);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return attributeMapperC.deleteByPrimaryKey(id);
    }
}
