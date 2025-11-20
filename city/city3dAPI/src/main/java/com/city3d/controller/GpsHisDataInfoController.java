package com.city3d.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.GpsHisDataInfo;
import com.city3d.service.GpsHisDataInfoService;

@Controller
@RequestMapping("/gpsHisDataInfo")
public class GpsHisDataInfoController {
    @Autowired
    private GpsHisDataInfoService gpsHisDataInfoService;

    @RequestMapping("/getHisDataByTime")
    public @ResponseBody List<GpsHisDataInfo> getHisDataByTime(@RequestBody GpsHisDataInfo gpsHisDataInfo) {
        Map<String, Object> params = new HashMap<>();
        String startTime = gpsHisDataInfo.getStartTime();
        String endTime = gpsHisDataInfo.getEndTime();
        params.put("simNo", gpsHisDataInfo.getSimNo());
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("velocity", Integer.parseInt(gpsHisDataInfo.getVelocity()));

        String substartTime = startTime.substring(0, 10).replace("-", "");
        String subendTime = endTime.substring(0, 10).replace("-", "");
        String today = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
        //String today = DateUtil.toStringByFormat(new Date(), "yyyyMMdd");
        if (subendTime.compareTo(today) > 0)
            subendTime = today;
        String tableName1 = "gpsInfo" + substartTime;
        params.put("tableName1", tableName1);
        String tableName2 = "gpsInfo" + subendTime;
        params.put("tableName2", tableName2);

        if (!tableName1.equals(tableName2)) {
            return gpsHisDataInfoService.getTracehisdata2Days(params);
        } else {
            return gpsHisDataInfoService.getTracehisdata(params);
        }
    }

    @RequestMapping("/getHisDataAllByTime")
    public @ResponseBody List<GpsHisDataInfo> getHisDataAllByTime() {
        Map<String, Object> params = new HashMap<>();
        Format format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i < 8; i++) {
            calendar.setTime(date);
            int reduce = 1 - i;
            calendar.add(Calendar.DATE, reduce);
            String day = format.format(calendar.getTime());
            String tableName = "gpsInfo" + day;
            String name = "tableName" + i;
            params.put(name, tableName);
        }
        return gpsHisDataInfoService.getTracehisdataAll7Days(params);
    }

    @RequestMapping("/getHisDataAllDemo")
    public @ResponseBody List<GpsHisDataInfo> getHisDataAllDemo() {
        return gpsHisDataInfoService.getHisDataAllDemo();
    }
}
