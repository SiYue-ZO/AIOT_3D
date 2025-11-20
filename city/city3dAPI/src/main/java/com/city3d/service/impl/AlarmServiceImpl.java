package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AlarmMapperC;
import com.city3d.dao.entry.Alarm;
import com.city3d.service.AlarmService;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmMapperC alarmMapper;

    @Override
    public List<Alarm> getAlarm() {
        return alarmMapper.selectAllByExample(null);
    }

    @Override
    public int insert(Alarm alarm) {
        return alarmMapper.insert(alarm);
    }

    @Override
    public int updateByPrimaryKey(Alarm alarm) {
        return alarmMapper.updateByPrimaryKey(alarm);
    }

    @Override
    public int deleteByPrimaryKey(String alarmId) {
        return alarmMapper.deleteByPrimaryKey(alarmId);
    }

    @Override
    public int batchDelete(List<String> alarmIds) {
        return alarmMapper.batchDelete(alarmIds);
    }
}
