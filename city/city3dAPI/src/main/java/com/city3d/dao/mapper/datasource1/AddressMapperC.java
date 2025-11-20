package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapperC extends AddressMapper {
    List<Address> getAddressAll(String addType);

    int batchDelete(List<String> addIds);

    List<Address> queryAddressByPolygon(Address address);
}