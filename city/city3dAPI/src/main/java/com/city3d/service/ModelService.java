package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Model;

public interface ModelService {
    List<Model> getModel();

    int insert(Model model);

    int updateByPrimaryKey(Model model);

    int deleteByPrimaryKey(String modelId);
}
