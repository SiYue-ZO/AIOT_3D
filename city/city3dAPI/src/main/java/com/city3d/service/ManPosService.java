package com.city3d.service;

import java.util.List;
import java.util.Map;

import com.city3d.dao.entry.ManPos;

public interface ManPosService {
    List<ManPos> getManPosAll();

    List<ManPos> getManPosByDn(ManPos manPos);

    List<ManPos> getManPosWithNameAndOrigin(String[] deviceNums);

    List<ManPos> getTraceManPos2Days(Map<String, String> params);

    List<ManPos> getTraceManPosInOneDay(Map<String, String> params);
}
