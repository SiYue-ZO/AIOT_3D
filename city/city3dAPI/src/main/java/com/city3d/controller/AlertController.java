package com.city3d.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;

import com.city3d.dao.entry.Alert;
import com.city3d.dao.entry.FaceIdentity;
import com.city3d.dao.entry.Task;
import com.city3d.service.AlertService;
import com.city3d.service.FaceIdentityService;
import com.city3d.service.TaskService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.TaskTimer;

@Controller
@Component
@RequestMapping("/alert")
public class AlertController implements WebSocketHandler {

    public static final Map<String, WebSocketSession> socketSessionMap;

    static {
        socketSessionMap = new HashMap<>();
    }

    public static final List<TaskTimer> taskTimerList;

    static {
        taskTimerList = new ArrayList<>();
    }

    @Autowired
    private TaskService taskService;

    @Autowired
    private FaceIdentityService faceIdentityService;

    @Autowired
    private AlertService alertService;

    private List<Task> taskList = new ArrayList<>();

    @RequestMapping("/insertTask")
    public @ResponseBody int insertTask(@RequestBody Task task) {
        CharacterUtils characterUtils = new CharacterUtils();
        String id = characterUtils.getUUID();
        task.setId(id);
        int result = taskService.insertTask(task);
        if (result == 0) {
            return result;
        } else {
            for (TaskTimer taskTimer : taskTimerList) {
                taskTimer.setSocketSessionMap(null);
            }
            taskList.clear();
            taskTimerList.clear();
            taskList = taskService.selectTaskToday();
            int count = taskList.size();
            Set<String> dateSet = new HashSet<>();
            for (Task taskt : taskList) {
                dateSet.add(taskt.getDate().substring(11, 16));
            }
            Map<String, Task> taskMap = new HashMap<>();
            for (String date : dateSet) {
                for (Task taskt : taskList) {
                    if (date.equals(taskt.getDate().substring(11, 16))) {
                        taskMap.put(date, taskt);
                    }
                }
            }
            for (Task taskt : taskMap.values()) {
                DateFormat dfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date datec = new Date();
                String datestr = dfr.format(datec);
                String datestr0 = datestr.substring(0, 11) + taskt.getDate().substring(11, 16);
                Date date;
                try {
                    date = dfr.parse(datestr0);
                    if (datec.getTime() < date.getTime()) {
                        TaskTimer taskTimer = new TaskTimer(socketSessionMap, JSON.toJSONString(taskt), count);
                        taskTimerList.add(taskTimer);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    @RequestMapping("/updateTaskByPrimaryKey")
    public @ResponseBody int updateTaskByPrimaryKey(@RequestBody Task task) {
        int result = taskService.updateTaskByPrimaryKey(task);
        if (result == 0) {
            return result;
        } else {
            for (TaskTimer taskTimer : taskTimerList) {
                taskTimer.setSocketSessionMap(null);
            }
            taskList.clear();
            taskTimerList.clear();
            taskList = taskService.selectTaskToday();
            int count = taskList.size();
            Set<String> dateSet = new HashSet<>();
            for (Task taskt : taskList) {
                dateSet.add(taskt.getDate().substring(11, 16));
            }
            Map<String, Task> taskMap = new HashMap<>();
            for (String date : dateSet) {
                for (Task taskt : taskList) {
                    if (date.equals(taskt.getDate().substring(11, 16))) {
                        taskMap.put(date, taskt);
                    }
                }
            }
            for (Task taskt : taskMap.values()) {
                DateFormat dfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date datec = new Date();
                String datestr = dfr.format(datec);
                String datestr0 = datestr.substring(0, 11) + taskt.getDate().substring(11, 16);
                Date date;
                try {
                    date = dfr.parse(datestr0);
                    if (datec.getTime() < date.getTime()) {
                        TaskTimer taskTimer = new TaskTimer(socketSessionMap, JSON.toJSONString(taskt), count);
                        taskTimerList.add(taskTimer);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    @RequestMapping("/deleteTaskByPrimaryKey")
    public @ResponseBody int deleteTaskByPrimaryKey(String id) {
        int result = taskService.deleteTaskByPrimaryKey(id);
        if (result == 0) {
            return result;
        } else {
            for (TaskTimer taskTimer : taskTimerList) {
                taskTimer.setSocketSessionMap(null);
            }
            taskList.clear();
            taskTimerList.clear();
            taskList = taskService.selectTaskToday();
            int count = taskList.size();
            Set<String> dateSet = new HashSet<>();
            for (Task task : taskList) {
                dateSet.add(task.getDate().substring(11, 16));
            }
            Map<String, Task> taskMap = new HashMap<>();
            for (String date : dateSet) {
                for (Task task : taskList) {
                    if (date.equals(task.getDate().substring(11, 16))) {
                        taskMap.put(date, task);
                    }
                }
            }
            for (Task task : taskMap.values()) {
                DateFormat dfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date datec = new Date();
                String datestr = dfr.format(datec);
                String datestr0 = datestr.substring(0, 11) + task.getDate().substring(11, 16);
                Date date;
                try {
                    date = dfr.parse(datestr0);
                    if (datec.getTime() < date.getTime()) {
                        TaskTimer taskTimer = new TaskTimer(socketSessionMap, JSON.toJSONString(task), count);
                        taskTimerList.add(taskTimer);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    @RequestMapping("/selectTaskToday")
    public @ResponseBody Map<String, List> selectTaskToday() {
        List<Task> result = taskService.selectTaskToday();
        Map<String, List> map = new HashMap<>();
        List<Task> dayTask = new ArrayList<>();
        List<Task> weekTask = new ArrayList<>();
        List<Task> monthTask = new ArrayList<>();
        List<Task> noneTask = new ArrayList<>();
        for (Task task : result) {
            switch (task.getCycle()) {
                case "day":
                    dayTask.add(task);
                    break;
                case "week":
                    weekTask.add(task);
                    break;
                case "month":
                    monthTask.add(task);
                    break;
                case "none":
                    noneTask.add(task);
                    break;
            }
        }
        map.put("day", dayTask);
        map.put("week", weekTask);
        map.put("month", monthTask);
        map.put("none", noneTask);
        return map;
    }

    @RequestMapping("/selectTaskNextSevenDays")
    public @ResponseBody Map<String, List<Map<String, Object>>> selectTaskNextSevenDays() {
        Map<String, List<Map<String, Object>>> data = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        DateFormat dfd = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dfw = new SimpleDateFormat("EEEE");
        int i = 0;
        int j = 7;
        while (list.size() < 7 && j >= 0) {
            Calendar cts = Calendar.getInstance();
            cts.add(Calendar.DAY_OF_MONTH, i);
            Date date = cts.getTime();
            String dateStr = dfd.format(date);
            String weekStr = dfw.format(date);
            List<Task> result = taskService.selectTaskNextDays(dateStr, weekStr);
            if (result.size() == 0) {
                j--;
                i++;
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("date", dateStr);
                map.put("week", weekStr);
                map.put("content", result);
                list.add(map);
                i++;
                j--;
            }
        }
        data.put("data", list);
        return data;
    }

    @RequestMapping("/ws_insert_alert")
    public @ResponseBody Map<String, Object> ws_insert_alert(@RequestBody Map<String, Object> alert) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("ServerTime", s);
        map.put("code", 1000);
        map.put("msg", "");
        map.put("data", "");
        Map<String, Map<String, Object>> map0 = new HashMap<>();
        CharacterUtils characterUtils = new CharacterUtils();
        String id = characterUtils.getUUID();
        alert.put("id", id);
        alert.put("date", s);
        switch (alert.get("type").toString()) {
            case "0":
                alert.put("typeInfo", "不做任何分析");
                break;
            case "1":
                alert.put("typeInfo", "可疑物体报警");
                break;
            case "2":
                alert.put("typeInfo", "物体失踪报警");
                break;
            case "3":
                alert.put("typeInfo", "移动方向侦测（逆向行驶）");
                break;
            case "4":
                alert.put("typeInfo", "入侵侦测（越界报警）");
                break;
            case "5":
                alert.put("typeInfo", "绊线检测");
                break;
            case "6":
                alert.put("typeInfo", "客流量分析（单向）");
                break;
            case "7":
                alert.put("typeInfo", "对象计数");
                break;
            case "8":
                alert.put("typeInfo", "移动侦测");
                break;
            default:
                break;
        }
        map0.put("alert", alert);
        sendMessageToAll(new TextMessage(JSON.toJSONString(map0)));
        return map;
    }

    @RequestMapping("/ws_insert_alarm")
    public @ResponseBody Map<String, Object> ws_insert_alarm(@RequestBody FaceIdentity faceIdentity) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("ServerTime", faceIdentity.getCaptureTime());
        map.put("code", 1000);
        map.put("msg", "");
        map.put("data", "");
        if (faceIdentity.getRepoType().equals("3")) {
            return null;
        } else {
            CharacterUtils characterUtils = new CharacterUtils();
            String id = characterUtils.getUUID();
            faceIdentity.setFaceId(id);
            int result = faceIdentityService.insert(faceIdentity);
            Map<String, FaceIdentity> mapr = new HashMap<>();
            mapr.put("alarm", faceIdentity);
            sendMessageToAll(new TextMessage(JSON.toJSONString(mapr)));
            return map;
        }
    }

    @RequestMapping("/insertAlert")
    public @ResponseBody int insertAlert(@RequestBody Alert alert) {
        return alertService.insertAlert(alert);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("链接建立");
        System.out.println("session:" + session.getId());
        socketSessionMap.put(session.getId(), session);

        //开机创建任务提醒
        for (TaskTimer taskTimer : taskTimerList) {
            taskTimer.setSocketSessionMap(null);
        }
        taskList = taskService.selectTaskToday();
        int count = taskList.size();
        Set<String> dateSet = new HashSet<>();
        for (Task task : taskList) {
            dateSet.add(task.getDate().substring(11, 16));
        }
        Map<String, Task> taskMap = new HashMap<>();
        for (String date : dateSet) {
            for (Task task : taskList) {
                if (date.equals(task.getDate().substring(11, 16))) {
                    taskMap.put(date, task);
                }
            }
        }
        for (Task task : taskMap.values()) {
            DateFormat dfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date datec = new Date();
            String datestr = dfr.format(datec);
            String datestr0 = datestr.substring(0, 11) + task.getDate().substring(11, 16);
            Date date = dfr.parse(datestr0);
            if (datec.getTime() < date.getTime()) {
                TaskTimer taskTimer = new TaskTimer(socketSessionMap, JSON.toJSONString(task), count);
                taskTimerList.add(taskTimer);
            }
        }

        //定时0点创建任务提醒
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                for (TaskTimer taskTimer : taskTimerList) {
                    taskTimer.setSocketSessionMap(null);
                }
                taskList.clear();
                taskTimerList.clear();
                taskList = taskService.selectTaskToday();
                int count = taskList.size();
                Set<String> dateSet = new HashSet<>();
                for (Task task : taskList) {
                    dateSet.add(task.getDate().substring(11, 16));
                }
                Map<String, Task> taskMap = new HashMap<>();
                for (String date : dateSet) {
                    for (Task task : taskList) {
                        if (date.equals(task.getDate().substring(11, 16))) {
                            taskMap.put(date, task);
                        }
                    }
                }
                for (Task task : taskMap.values()) {
                    DateFormat dfr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date datec = new Date();
                    String datestr = dfr.format(datec);
                    String datestr0 = datestr.substring(0, 11) + task.getDate().substring(11, 16);
                    Date date;
                    try {
                        date = dfr.parse(datestr0);
                        if (datec.getTime() < date.getTime()) {
                            TaskTimer taskTimer = new TaskTimer(socketSessionMap, JSON.toJSONString(task), count);
                            taskTimerList.add(taskTimer);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        DateFormat dfd = new SimpleDateFormat("yyyy/MM/dd");
        String sd = dfd.format(new Date());
        Date dated = dfd.parse(sd);
        Calendar cts = Calendar.getInstance();
        cts.setTime(dated);
        cts.add(Calendar.DAY_OF_MONTH, 1);
        Date datet = cts.getTime();
        timer.scheduleAtFixedRate(timerTask, datet, 24 * 60 * 60 * 1000);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        System.out.println("数据传输");
        System.out.println("session:" + session.getId());
        String payload = message.getPayload().toString();
        String result = "{\"uav\":1," + payload.substring(1, payload.length());
        System.out.println(result.toString());
//		sendMessageToAll(new TextMessage(result));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        System.out.println("链接出错,重新建立");
        System.out.println("session:" + session.getId());
        socketSessionMap.put(session.getId(), session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessageTo(WebSocketSession webSocketSession, TextMessage message) {
        if (webSocketSession != null && webSocketSession.isOpen()) {
            try {
                synchronized (webSocketSession) {
                    webSocketSession.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessageToAll(TextMessage message) throws IOException {
        try {
            System.out.println("session数:" + socketSessionMap.size());
        } catch (Exception e) {
            System.out.println("该任务的session已清空");
        }
        for (String key : socketSessionMap.keySet()) {
            WebSocketSession value = socketSessionMap.get(key);
            if (value != null && value.isOpen()) {
                synchronized (value) {
                    value.sendMessage(message);
                    System.out.println("session:" + value.getId());
                }
            }
        }
    }

    @RequestMapping("/getAlert")
    public @ResponseBody List<Alert> getAlert() {
        return alertService.getAlert();
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody Alert alert) throws IOException {
        return alertService.updateByPrimaryKey(alert);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Alert alert) throws IOException {
        return alertService.deleteByPrimaryKey(alert.getId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Alert> alerts) throws Exception {
        List<String> ids = new ArrayList<>();
        for (Alert alert : alerts) {
            ids.add(alert.getId());
        }
        return alertService.batchDelete(ids);
    }
}
