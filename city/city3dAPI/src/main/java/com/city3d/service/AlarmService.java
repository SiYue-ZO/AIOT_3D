package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Alarm;

public interface AlarmService {
    List<Alarm> getAlarm();

    int insert(Alarm alarm);

    int updateByPrimaryKey(Alarm alarm);

    int deleteByPrimaryKey(String alarmId);

    int batchDelete(List<String> alarmIds);
}
