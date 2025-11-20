package com.city3d.service;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.FireControl;

public interface FireControlService {
    List<HashMap<String, String>> getFireControl();

    List<FireControl> getFireControlNoPic();

    FireControl getFireControlById(String fireCtlId);

    List<FireControl> queryFireControl(FireControl fireControl);

    int insert(FireControl fireControl);

    int updateByPrimaryKey(FireControl fireControl);

    int deleteByPrimaryKey(String fireCtlId);
}
