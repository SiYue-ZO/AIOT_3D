package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.PlanMapper;
import com.city3d.dao.entry.Plan;
import com.city3d.service.PlanService;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<Plan> getPlan() {
        return planMapper.selectByExample(null);
    }

    @Override
    public int deleteByPrimaryKey(String planId) {
        return planMapper.deleteByPrimaryKey(planId);
    }

    @Override
    public int insert(Plan plan) {
        return planMapper.insert(plan);
    }
}
