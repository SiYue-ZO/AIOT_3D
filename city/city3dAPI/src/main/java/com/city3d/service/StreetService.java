package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Street;

public interface StreetService {
    List<Street> getStreetAll();

    int insert(Street street);

    int updateByPrimaryKey(Street street);

    int deleteByPrimaryKey(String streetId);

    int batchDelete(List<String> streetIds);
}
