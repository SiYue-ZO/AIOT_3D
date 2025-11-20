package com.city3d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.DutyVideoVideoMapper;
import com.city3d.dao.entry.DutyVideoVideo;
import com.city3d.dao.entry.DutyVideoVideoExample;
import com.city3d.service.DutyVideoVideoService;
import org.springframework.stereotype.Service;

@Service
public class DutyVideoVideoServiceImpl implements DutyVideoVideoService {
    @Autowired
    private DutyVideoVideoMapper dutyVideoVideoMapper;

    @Override
    public int deleteDutyVideoVideo(String dutyVideoId) {
        DutyVideoVideoExample example = new DutyVideoVideoExample();
        example.or().andDutyVideoIdEqualTo(dutyVideoId);
        return dutyVideoVideoMapper.deleteByExample(example);
    }

    @Override
    public int insertDutyVideoVideo(DutyVideoVideo dutyVideoVideo) {
        return dutyVideoVideoMapper.insert(dutyVideoVideo);
    }
}
