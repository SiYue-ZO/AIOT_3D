package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Attribute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttributeMapperC extends AttributeMapper {
    List<Attribute> getAttributeAll();
}