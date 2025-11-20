package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Attribute;

public interface AttributeService {
    List<Attribute> getAttributeAll();

    List<Attribute> getAttributeOnlyByCoverId(String coverageId);

    int getAttributeMaxOrderNumByCoverageId(String coverageId);

    int insert(Attribute attribute);

    int updateByPrimaryKey(Attribute attribute);

    int deleteByPrimaryKey(String id);
}
