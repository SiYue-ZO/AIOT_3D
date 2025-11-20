package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Datalayer;

public interface DatalayerService {
    List<Datalayer> getDatalayer();

    int insert(Datalayer datalayer);

    int updateByPrimaryKey(Datalayer datalayer);

    int deleteByPrimaryKey(String layerId);
}
