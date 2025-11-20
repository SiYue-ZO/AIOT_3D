package com.city3d.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AddressMapperC;
import com.city3d.dao.mapper.datasource1.CompanyMapper;
import com.city3d.dao.mapper.datasource1.HouseMapper;
import com.city3d.dao.mapper.datasource1.PeopleBaseMapper;
import com.city3d.dao.entry.Address;
import com.city3d.dao.entry.AddressExample;
import com.city3d.dao.entry.CompanyExample;
import com.city3d.dao.entry.HouseExample;
import com.city3d.dao.entry.PeopleBaseExample;
import com.city3d.dao.entry.AddressExample.Criteria;
import com.city3d.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapperC addressMapperC;
    @Autowired
    private PeopleBaseMapper peopleBaseMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Address> getAddress(String addType) {
        return addressMapperC.getAddressAll(addType);
    }

    @Override
    public Address getAddressById(String addId) {
        return addressMapperC.selectByPrimaryKey(addId);
    }

    @Override
    public List<Address> getAddressByType(String addType) {
        AddressExample example = new AddressExample();
        Criteria criteriaResult = example.or();
        if (addType != "") {
            criteriaResult = criteriaResult.andAddTypeEqualTo(addType);
        }
        return addressMapperC.selectByExample(example);
    }

    @Override
    public List<Address> getAddressByComName(String comName) {
        AddressExample example = new AddressExample();
        example.or().andPidEqualTo(comName);
        return addressMapperC.selectByExample(example);
    }

    @Override
    public List<Address> queryAddress(Address address) {
        AddressExample example = new AddressExample();
        Criteria criteriaResult = example.or();
        if (address.getAddName() != "" && address.getAddName() != null) {
            criteriaResult = criteriaResult.andAddNameLike("%" + address.getAddName() + "%");
        }
        if (address.getCommunities() != "" && address.getCommunities() != null) {
            criteriaResult = criteriaResult.andCommunitiesLike("%" + address.getCommunities() + "%");
        }
        if (address.getStreet() != "" && address.getStreet() != null) {
            criteriaResult = criteriaResult.andStreetLike("%" + address.getStreet() + "%");
        }
        if (address.getCommunityName() != "" && address.getCommunityName() != null) {
            criteriaResult = criteriaResult.andCommunityNameLike("%" + address.getCommunityName() + "%");
        }
        if (address.getAddType() != "" && address.getAddType() != null) {
            criteriaResult = criteriaResult.andAddTypeLike("%" + address.getAddType() + "%");
        }
        return addressMapperC.selectByExample(example);
    }

    @Override
    public List<String> queryAddressByPolygon(Address address) {
        String[] poiArr = address.getPoi().split(",");
        String poi = "";
        for (int i = 0; i < poiArr.length; i = i + 2) {
            poi += poiArr[i] + " " + poiArr[i + 1] + ",";
        }
        poi += poiArr[0] + " " + poiArr[1];
        address.setPoi(poi);
        List<Address> resultArr = addressMapperC.queryAddressByPolygon(address);
        List<String> result = new ArrayList<>();
        for (Address add : resultArr) {
            result.add(add.getAddId());
        }
        return result;
    }

    @Override
    public List<Object> getNetAllByAddId(String addId) {
        List<Object> resultList = new ArrayList<>();

        AddressExample addressExample = new AddressExample();
        PeopleBaseExample peopleExample = new PeopleBaseExample();
        HouseExample houseExample = new HouseExample();
        CompanyExample companyExample = new CompanyExample();

        addressExample.or().andAddIdEqualTo(addId);
        resultList.add(addressMapperC.selectByExample(addressExample));

        peopleExample.or().andAddIdEqualTo(addId);
        resultList.add(peopleBaseMapper.selectByExample(peopleExample));

        houseExample.or().andAddIdEqualTo(addId);
        resultList.add(houseMapper.selectByExample(houseExample));

        companyExample.or().andAddIdEqualTo(addId);
        resultList.add(companyMapper.selectByExample(companyExample));

        return resultList;
    }

    @Override
    public int insert(Address address) {
        return addressMapperC.insert(address);
    }

    @Override
    public int updateByPrimaryKey(Address address) {
        return addressMapperC.updateByPrimaryKey(address);
    }

    @Override
    public int deleteByPrimaryKey(String addId) {
        return addressMapperC.deleteByPrimaryKey(addId);
    }

    @Override
    public int batchDelete(List<String> addIds) {
        return addressMapperC.batchDelete(addIds);
    }

    @Override
    public List<Address> getAddressDirectory(String pid) {
        AddressExample example = new AddressExample();
        example.setOrderByClause("add_name");
        example.createCriteria().andPidEqualTo(pid);
        return addressMapperC.selectByExample(example);
    }

    @Override
    public List<Address> getAddressByPid(String pid) {
        AddressExample example = new AddressExample();
        example.createCriteria().andPidEqualTo(pid);
        return addressMapperC.selectByExample(example);
    }

    @Override
    public int countAddress() {
        return addressMapperC.countByExample(null);
    }
}
