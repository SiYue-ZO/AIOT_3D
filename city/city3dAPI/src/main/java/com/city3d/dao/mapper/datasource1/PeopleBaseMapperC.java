package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Address;
import com.city3d.dao.entry.PeopleBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleBaseMapperC extends PeopleBaseMapper {
    List<PeopleBase> selectByExampleC(PeopleBase peopleBase);

    List<PeopleBase> selectByExampleCPart(PeopleBase peopleBase);

    PeopleBase selectPeopleBaseById(String ppId);

    List<PeopleBase> selectPeopleBaseByAddId(String addId);

    List<Address> queryPeopleByPolygon(PeopleBase peopleBase);

    int batchDelete(List<String> ppIds);
}