package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.VideoMapperC;
import com.city3d.dao.entry.Video;
import com.city3d.dao.entry.VideoExample;
import com.city3d.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapperC videoMapperC;

    @Override
    public List<Video> getVideoAndNodes(String isIndoor) {
        VideoExample example = new VideoExample();
        example.or().andIsIndoorEqualTo(isIndoor);
        String orderByClause = "cam_add";
        example.setOrderByClause(orderByClause);
        return videoMapperC.selectByExample(example);
    }

    @Override
    public int countCam() {
        VideoExample example = new VideoExample();
        example.or().andCamIsnodeNotEqualTo(true);
        return videoMapperC.countByExample(example);
    }

    @Override
    public List<Video> getVideosIsNode() {
        VideoExample example = new VideoExample();
        example.or().andCamIsnodeEqualTo(true);
        return videoMapperC.selectByExample(example);
    }

    @Override
    public Video getVideoById(String id) {
        return videoMapperC.selectByPrimaryKey(id);
    }

    @Override
    public List<Video> getRHPCVideo(String positionStr) {
        return videoMapperC.getRHPCVideo(positionStr);
    }

    @Override
    public List<Video> getVideoNoNodes() {
        VideoExample example = new VideoExample();
        example.or().andCamIsnodeEqualTo(false);
        return videoMapperC.selectByExample(example);
    }

    @Override
    public int insert(Video Video) {
        return videoMapperC.insert(Video);
    }

    @Override
    public int updateByPrimaryKey(Video Video) {
        return videoMapperC.updateByPrimaryKey(Video);
    }

    @Override
    public int deleteByPrimaryKey(String videoId) {
        return videoMapperC.deleteByPrimaryKey(videoId);
    }

    @Override
    public Video getVideoByMacUrl(String macUrl) {
        VideoExample example = new VideoExample();
        example.createCriteria().andMacUrlEqualTo(macUrl);
        List<Video> result = videoMapperC.selectByExample(example);
        try {
            return result.get(0);
        } catch (Exception e) {
            return new Video();
        }
    }

    @Override
    public List<Video> getVideoListByMacUrl(String macUrl) {
        VideoExample example = new VideoExample();
        example.setOrderByClause("cam_add");
        example.createCriteria().andMacUrlEqualTo(macUrl);
        return videoMapperC.selectByExample(example);
    }

    @Override
    public int countVideoByCamPort(String camPort) {
        VideoExample example = new VideoExample();
        example.createCriteria().andCamPortLike("%" + camPort);
        return videoMapperC.countByExample(example);
    }
}
