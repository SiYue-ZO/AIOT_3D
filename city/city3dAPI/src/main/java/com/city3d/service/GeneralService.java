package com.city3d.service;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.SysPara;

public interface GeneralService {
    List<HashMap<String, String>> countPeople();

    List<HashMap<String, String>> countAdd();

    List<HashMap<String, String>> countDep();

    List<HashMap<String, String>> countPatrol();

    List<HashMap<String, String>> countCam();

    List<HashMap<String, String>> countMan();

    List<SysPara> getMain();

    List<Object> countGeneralByExample();
}
