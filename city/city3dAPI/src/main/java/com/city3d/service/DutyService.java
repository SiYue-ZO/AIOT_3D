package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Duty;

public interface DutyService {
    List<Duty> getDuty();

    Duty getDutyById(String dutyId);

    int insert(Duty duty);

    int updateByPrimaryKey(Duty duty);

    int deleteByPrimaryKey(String dutyId);
}
