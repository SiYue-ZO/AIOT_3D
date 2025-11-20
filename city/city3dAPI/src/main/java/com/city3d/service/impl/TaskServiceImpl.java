package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.TaskMapperC;
import com.city3d.dao.entry.Task;
import com.city3d.dao.entry.TaskExample;
import com.city3d.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapperC taskMapperC;

    @Override
    public List<Task> selectTaskAll() {
        TaskExample example = new TaskExample();
        return taskMapperC.selectByExample(example);
    }

    @Override
    public Task selectTaskById(String id) {
        return taskMapperC.selectByPrimaryKey(id);
    }

    @Override
    public int insertTask(Task task) {
        return taskMapperC.insert(task);
    }

    @Override
    public int updateTaskByPrimaryKey(Task task) {
        return taskMapperC.updateByPrimaryKey(task);
    }

    @Override
    public int deleteTaskByPrimaryKey(String id) {
        return taskMapperC.deleteByPrimaryKey(id);
    }

    @Override
    public List<Task> selectTaskByCycleDay(String date) {
        TaskExample example = new TaskExample();
        example.createCriteria().andCycleEqualTo("day").andDateLessThanOrEqualTo(date);
        example.setOrderByClause("date");
        return taskMapperC.selectByExample(example);
    }

    @Override
    public List<Task> selectTaskByCycleWeek(String date, String weekDate) {
        TaskExample example = new TaskExample();
        example.createCriteria().andCycleEqualTo("week," + weekDate).andDateLessThanOrEqualTo(date);
        example.setOrderByClause("date");
        return taskMapperC.selectByExample(example);
    }

    @Override
    public List<Task> selectTaskByCycleMonth(String date, String datemStr) {
        TaskExample example = new TaskExample();
        example.createCriteria().andCycleEqualTo("month," + datemStr).andDateLessThanOrEqualTo(date);
        example.setOrderByClause("date");
        return taskMapperC.selectByExample(example);
    }

    @Override
    public int selectTaskCountToday() {
        return taskMapperC.selectTaskCountToday();
    }

    @Override
    public List<Task> selectTaskToday() {
        return taskMapperC.selectTaskToday();
    }

    @Override
    public List<Task> selectTaskNextDays(String dateStr, String weekStr) {
        return taskMapperC.selectTaskNextDays(dateStr, weekStr);
    }
}
