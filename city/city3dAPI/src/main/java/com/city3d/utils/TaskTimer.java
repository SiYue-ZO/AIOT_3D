package com.city3d.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.city3d.dao.entry.Task;

public class TaskTimer {
	
	private Map<String, WebSocketSession> socketSessionMap;
	
	private String timerName;
	
	private Task task;
	
	private int count;
	
	public TaskTimer(Map<String, WebSocketSession> socketSessionMap,String timerName,int count){
		this.socketSessionMap = socketSessionMap;
		this.timerName = timerName;
		this.count = count;
		JSONObject jsonTask = JSONObject.parseObject(timerName);
		Task task = JSON.toJavaObject(jsonTask, Task.class);
		this.task = task;
		creatTimer(task.getName(),task.getDate());
		System.out.println("定时器"+timerName+"已创建");
	}
	
	public Map<String, WebSocketSession> getSocketSessionMap() {
		return socketSessionMap;
	}

	public void setSocketSessionMap(Map<String, WebSocketSession> socketSessionMap) {
		this.socketSessionMap = socketSessionMap;
	}
	
	public String getTimerName() {
		return timerName;
	}

	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void creatTimer(String name,String date){
		Map<String,String> map = new HashMap();
		Calendar cts = Calendar.getInstance();
	    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String s0 = df.format(new Date());
		Date date0 = null;
		try {
			date0 = df.parse(s0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cts = Calendar.getInstance();
		cts.setTime(date0);
		Timer timer = new Timer();
	    TimerTask timerTask =new TimerTask(){
	        public void run(){
        		try {
        			map.put("task", count+"");
        			String mapJSON = JSON.toJSONString(map);
        			sendMessageToAll(new TextMessage(mapJSON));
        			System.out.println(name);
				} catch (IOException e) {
					System.out.println(task.getName()+" throw exception");
					e.printStackTrace();
					return;
				}
	        }
	    };
	    String[] time = date.split(" ");
	    String hour = time[1].split(":")[0];
	    String minute = time[1].split(":")[1];
		cts.add(Calendar.HOUR_OF_DAY, Integer.valueOf(hour));
		cts.add(Calendar.MINUTE, Integer.valueOf(minute));
		Date date1 = cts.getTime();	
		timer.scheduleAtFixedRate(timerTask,date1,24*60*60*1000);
	}
	
	public void sendMessageToAll(TextMessage message) throws IOException {
		try {
			System.out.println("session数:"+socketSessionMap.size());
		} catch (Exception e) {
			System.out.println("该任务的session已清空");
		}
		for(String key : socketSessionMap.keySet()){
			WebSocketSession value = socketSessionMap.get(key);
			if (value != null && value.isOpen()) {
				try {
		    		synchronized (value) {
		    			value.sendMessage(message);
		    			System.out.println("session号:"+value.getId());
		    		}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}
}
