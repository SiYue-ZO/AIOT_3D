package com.city3d.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PeopleBaseMapperC;
import com.city3d.dao.entry.Address;
import com.city3d.dao.entry.PeopleBase;
import com.city3d.service.PeopleBaseService;
import org.springframework.stereotype.Service;

@Service
public class PeopleBaseServiceImpl implements PeopleBaseService {
    @Autowired
    private PeopleBaseMapperC peopleBaseMapperC;

    @Override
    public List<PeopleBase> getPeopleBaseAll() {
        return peopleBaseMapperC.selectByExample(null);
    }

    @Override
    public List<PeopleBase> queryPeoplebasebyExample(PeopleBase peopleBase) {
        return peopleBaseMapperC.selectByExampleC(peopleBase);
    }

    @Override
    public List<PeopleBase> queryPeoplebasebyPartExample(PeopleBase peopleBase) {
        return peopleBaseMapperC.selectByExampleCPart(peopleBase);
    }

    @Override
    public List<PeopleBase> queryPeoplebaseByPolygon(PeopleBase peopleBase) {
        List<PeopleBase> result = new ArrayList<>();
        Map<String, PeopleBase> map = new HashMap<>();
        List<Address> addresses = peopleBaseMapperC.queryPeopleByPolygon(peopleBase);
        List<PeopleBase> peopleBases = peopleBaseMapperC.selectByExampleC(peopleBase);
        for (PeopleBase base : peopleBases) {
            String add_id = base.getAddId();
            map.put(add_id, base);
        }
        for (Address address : addresses) {
            String add_id = address.getAddId();
            if (map.containsKey(add_id)) {
                result.add(map.get(add_id));
            }
        }
        return result;
    }

    @Override
    public PeopleBase getPeopleBaseById(String ppId) {
        return peopleBaseMapperC.selectPeopleBaseById(ppId);
    }

    @Override
    public int updateByPrimaryKey(PeopleBase peopleBase) {
        return peopleBaseMapperC.updateByPrimaryKey(peopleBase);
    }

    @Override
    public int insert(PeopleBase peopleBase) {
        return peopleBaseMapperC.insert(peopleBase);
    }

    @Override
    public int deleteByPrimaryKey(String ppId) {
        return peopleBaseMapperC.deleteByPrimaryKey(ppId);
    }

    @Override
    public List<PeopleBase> queryPeopleByAddId(String addId) {
        return peopleBaseMapperC.selectPeopleBaseByAddId(addId);
    }

    @Override
    public int batchDelete(List<String> ppIds) {
        return peopleBaseMapperC.batchDelete(ppIds);
    }
}
