package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Address;

public interface AddressService {
    List<Address> getAddress(String addType);

    Address getAddressById(String addId);

    List<Address> getAddressByType(String addType);

    List<Address> getAddressByComName(String comName);

    List<Address> queryAddress(Address address);

    List<String> queryAddressByPolygon(Address address);

    List<Object> getNetAllByAddId(String addId);

    int insert(Address address);

    int updateByPrimaryKey(Address address);

    int deleteByPrimaryKey(String addId);

    int batchDelete(List<String> addIds);

    List<Address> getAddressDirectory(String pid);

    List<Address> getAddressByPid(String pid);

    int countAddress();
}
