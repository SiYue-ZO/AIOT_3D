package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Task;

public interface TaskService {
    List<Task> selectTaskAll();

    Task selectTaskById(String id);

    int insertTask(Task task);

    int updateTaskByPrimaryKey(Task task);

    int deleteTaskByPrimaryKey(String id);

    List<Task> selectTaskByCycleDay(String date);

    List<Task> selectTaskByCycleWeek(String date, String weekDate);

    List<Task> selectTaskByCycleMonth(String date, String datemStr);

    int selectTaskCountToday();

    List<Task> selectTaskToday();

    List<Task> selectTaskNextDays(String dateStr, String weekStr);
}
