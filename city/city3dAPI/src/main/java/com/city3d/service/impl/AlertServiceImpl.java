package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.AlertMapperC;
import com.city3d.dao.entry.Alert;
import com.city3d.service.AlertService;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertMapperC alertMapper;

    @Override
    public int insertAlert(Alert alert) {
        return alertMapper.insert(alert);
    }

    @Override
    public List<Alert> getAlert() {
        return alertMapper.selectByExample(null);
    }

    @Override
    public int updateByPrimaryKey(Alert alert) {
        return alertMapper.updateByPrimaryKey(alert);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return alertMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<String> ids) {
        return alertMapper.batchDelete(ids);
    }
}
