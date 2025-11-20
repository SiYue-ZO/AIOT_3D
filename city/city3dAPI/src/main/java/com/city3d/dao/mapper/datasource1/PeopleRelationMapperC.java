package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.PeopleRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleRelationMapperC extends PeopleRelationMapper {
    List<PeopleRelation> selectPeopleRelationById(String ppId);
}