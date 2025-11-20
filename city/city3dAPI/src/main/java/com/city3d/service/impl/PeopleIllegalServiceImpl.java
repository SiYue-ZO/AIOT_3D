package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleIllegalMapper;
import com.city3d.dao.entry.PeopleIllegal;
import com.city3d.dao.entry.PeopleIllegalExample;
import com.city3d.service.PeopleIllegalService;
import org.springframework.stereotype.Service;

@Service
public class PeopleIllegalServiceImpl implements PeopleIllegalService {
    @Autowired
    private PeopleIllegalMapper peopleIllegalServiceMapper;

    @Override
    public List<PeopleIllegal> findByPpId(String ppId) {
        PeopleIllegalExample example = new PeopleIllegalExample();
        example.createCriteria().andPpIdEqualTo(ppId);
        return peopleIllegalServiceMapper.selectByExample(example);
    }

    @Override
    public int save(PeopleIllegal entity) {
        return peopleIllegalServiceMapper.insert(entity);
    }

    @Override
    public int updateByPrimaryKey(PeopleIllegal entity) {
        return peopleIllegalServiceMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int deleteById(String id) {
        return peopleIllegalServiceMapper.deleteByPrimaryKey(id);
    }
}
