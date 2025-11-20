package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Alert;

public interface AlertService {
    int insertAlert(Alert alert);

    List<Alert> getAlert();

    int updateByPrimaryKey(Alert alert);

    int deleteByPrimaryKey(String id);

    int batchDelete(List<String> ids);
}
