package com.city3d.dao.mapper.datasource1;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GeneralMapper {
    List<HashMap<String, String>> countPeople();

    List<HashMap<String, String>> countAdd();

    List<HashMap<String, String>> countDep();

    List<HashMap<String, String>> countPatrol();

    List<HashMap<String, String>> countCam();

    List<HashMap<String, String>> countMan();
}
