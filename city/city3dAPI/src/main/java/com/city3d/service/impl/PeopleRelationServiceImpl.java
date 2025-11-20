package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleRelationMapperC;
import com.city3d.dao.entry.PeopleRelation;
import com.city3d.dao.entry.PeopleRelationExample;
import com.city3d.service.PeopleRelationService;
import org.springframework.stereotype.Service;

@Service
public class PeopleRelationServiceImpl implements PeopleRelationService {
    @Autowired
    private PeopleRelationMapperC peopleRelationMapperC;

    @Override
    public List<PeopleRelation> selectPeopleRelationById(String ppId) {
        return peopleRelationMapperC.selectPeopleRelationById(ppId);
    }

    @Override
    public List<PeopleRelation> findByPpId(String ppId) {
        PeopleRelationExample example = new PeopleRelationExample();
        example.createCriteria().andPpIdEqualTo(ppId);
        return peopleRelationMapperC.selectByExample(example);
    }

    @Override
    public int save(PeopleRelation peopleRelation) {
        return peopleRelationMapperC.insert(peopleRelation);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return peopleRelationMapperC.deleteByPrimaryKey(id);
    }
}
