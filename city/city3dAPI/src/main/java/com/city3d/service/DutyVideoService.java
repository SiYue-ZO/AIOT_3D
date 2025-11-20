package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.DutyVideo;

public interface DutyVideoService {
    List<DutyVideo> getDutyVideo();

    int insert(DutyVideo dutyVideo);

    int updateByPrimaryKey(DutyVideo dutyVideo);

    int deleteByPrimaryKey(String dutyVideoId);
}
