package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.DutyVideoMapperC;
import com.city3d.dao.entry.DutyVideo;
import com.city3d.service.DutyVideoService;
import org.springframework.stereotype.Service;

@Service
public class DutyVideoServiceImpl implements DutyVideoService {
    @Autowired
    private DutyVideoMapperC dutyVideoMapper;

    @Override
    public List<DutyVideo> getDutyVideo() {
        return dutyVideoMapper.getDutyVideoAll();
    }

    @Override
    public int insert(DutyVideo dutyVideo) {
        return dutyVideoMapper.insert(dutyVideo);
    }

    @Override
    public int updateByPrimaryKey(DutyVideo dutyVideo) {
        return dutyVideoMapper.updateByPrimaryKey(dutyVideo);
    }

    @Override
    public int deleteByPrimaryKey(String dutyVideoId) {
        return dutyVideoMapper.deleteByPrimaryKey(dutyVideoId);
    }
}
