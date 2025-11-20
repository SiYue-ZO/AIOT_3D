package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.LiveMapper;
import com.city3d.dao.mapper.datasource1.Video0LiveMapper;
import com.city3d.dao.entry.Live;
import com.city3d.dao.entry.LiveExample;
import com.city3d.dao.entry.Video0Live;
import com.city3d.service.LiveService;
import org.springframework.stereotype.Service;

@Service
public class LiveServiceImpl implements LiveService {
    @Autowired
    private LiveMapper liveMapper;

    @Autowired
    private Video0LiveMapper video0LiveMapper;

    @Override
    public List<Live> getLiveAll() {
        return liveMapper.selectByExample(null);
    }

    @Override
    public List<Live> selectByVideoId(String id) {
        LiveExample example = new LiveExample();
        example.or().andVideoIdEqualTo(id);
        return liveMapper.selectByExample(example);
    }

    @Override
    public int countByVideoId(String id) {
        LiveExample example = new LiveExample();
        example.or().andVideoIdEqualTo(id);
        return liveMapper.countByExample(example);
    }

    @Override
    public int insert(Live live) {
        return liveMapper.insert(live);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return liveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update0(Video0Live video0Live) {
        return video0LiveMapper.updateByPrimaryKey(video0Live);
    }
}
