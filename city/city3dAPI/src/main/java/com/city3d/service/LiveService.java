package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Live;
import com.city3d.dao.entry.Video0Live;

public interface LiveService {
    List<Live> getLiveAll();

    List<Live> selectByVideoId(String id);

    int countByVideoId(String id);

    int insert(Live live);

    int deleteByPrimaryKey(String id);

    int update0(Video0Live video0Live);
}
