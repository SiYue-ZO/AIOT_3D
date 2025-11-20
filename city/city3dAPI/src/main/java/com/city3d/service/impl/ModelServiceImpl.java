package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.ModelMapper;
import com.city3d.dao.entry.Model;
import com.city3d.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Model> getModel() {
        return modelMapper.selectByExample(null);
    }

    @Override
    public int insert(Model model) {
        return modelMapper.insert(model);
    }

    @Override
    public int updateByPrimaryKey(Model model) {
        return modelMapper.updateByPrimaryKey(model);
    }

    @Override
    public int deleteByPrimaryKey(String modelId) {
        return modelMapper.deleteByPrimaryKey(modelId);
    }
}
