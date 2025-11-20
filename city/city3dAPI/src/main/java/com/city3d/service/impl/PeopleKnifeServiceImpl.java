package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleKnifeMapperC;
import com.city3d.dao.entry.PeopleKnife;
import com.city3d.dao.entry.PeopleKnifeExample;
import com.city3d.service.PeopleKnifeService;
import org.springframework.stereotype.Service;

@Service
public class PeopleKnifeServiceImpl implements PeopleKnifeService {
    @Autowired
    private PeopleKnifeMapperC peopleKnifeMapper;

    @Override
    public List<PeopleKnife> getPeopleKnife() {
        return peopleKnifeMapper.selectPeopleKnifeAll();
    }

    @Override
    public List<PeopleKnife> findByPpId(String ppId) {
        PeopleKnifeExample example = new PeopleKnifeExample();
        example.createCriteria().andPpIdEqualTo(ppId);
        return peopleKnifeMapper.selectByExample(example);
    }

    @Override
    public int save(PeopleKnife peopleKnife) {
        return peopleKnifeMapper.insert(peopleKnife);
    }

    @Override
    public int updateByPrimaryKey(PeopleKnife peopleKnife) {
        return peopleKnifeMapper.updateByPrimaryKey(peopleKnife);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return peopleKnifeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<String> knifeIds) {
        return peopleKnifeMapper.batchDelete(knifeIds);
    }
}
