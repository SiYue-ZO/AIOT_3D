package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Bim;

public interface BimService {
    List<Bim> getBim();

    int insert(Bim bim);

    int updateByPrimaryKey(Bim bim);

    int deleteByPrimaryKey(String tilesId);

    int batchDelete(List<String> tilesIds);
}
