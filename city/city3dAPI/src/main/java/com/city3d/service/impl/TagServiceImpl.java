package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.ViewtagMapper;
import com.city3d.dao.entry.Viewtag;
import com.city3d.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private ViewtagMapper viewtagMapper;

    @Override
    public List<Viewtag> getTag() {
        return viewtagMapper.selectByExample(null);
    }

    @Override
    public int deleteByPrimaryKey(String tagId) {
        return viewtagMapper.deleteByPrimaryKey(tagId);
    }

    @Override
    public int insert(Viewtag tag) {
        return viewtagMapper.insert(tag);
    }
}
