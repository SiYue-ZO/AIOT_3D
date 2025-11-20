package com.city3d.controller;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Alarm;
import com.city3d.service.AlarmService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.GeoTools;

@Controller
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/getAlarm")
    public @ResponseBody List<Alarm> getAlarm() {
        return alarmService.getAlarm();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Alarm alarm) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        alarm.setAlarmId(uid);
        return alarmService.insert(alarm);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Alarm alarm) throws Exception {
        return alarmService.updateByPrimaryKey(alarm);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Alarm alarm) throws Exception {
        return alarmService.deleteByPrimaryKey(alarm.getAlarmId());
    }

    @RequestMapping("/checkWallAlarm")
    public @ResponseBody Boolean checkWallAlarm(@RequestBody Alarm alarm) {
        boolean result = false;
        String[] poiArr = alarm.getAlarmType().split(",");
        Point2D.Double point = new Point2D.Double(Double.parseDouble(poiArr[0]), Double.parseDouble(poiArr[1]));
        List<Point2D.Double> pts = new ArrayList<>();
        String[] wallpoiArr = alarm.getAlarmPoi().split(",");
        for (int i = 0; i < wallpoiArr.length; i = i + 3) {
            pts.add(new Point2D.Double(Double.parseDouble(wallpoiArr[i]), Double.parseDouble(wallpoiArr[i + 1])));
        }
        if (GeoTools.IsPtInPoly(point, pts)) {
            result = true;
        }
        return result;
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Alarm> alarms) throws Exception {
        List<String> alarmIds = new ArrayList<>();
        for (Alarm alarm : alarms) {
            alarmIds.add(alarm.getAlarmId());
        }
        return alarmService.batchDelete(alarmIds);
    }
}
