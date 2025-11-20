package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.AttributeData;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttributeDataMapperC extends AttributeDataMapper {
    List<AttributeData> getAttributeDataAndCoverageByCoverageId(String coverageId);

    List<AttributeData> getAttributeDataAddressByCoverageIdAndAddName(@Param("coverageId") String coverageId, @Param("addName") String addName);
}