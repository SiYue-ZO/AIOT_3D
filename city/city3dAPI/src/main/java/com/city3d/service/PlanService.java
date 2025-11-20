package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Plan;

public interface PlanService {
    List<Plan> getPlan();

    int deleteByPrimaryKey(String planId);

    int insert(Plan plan);
}
