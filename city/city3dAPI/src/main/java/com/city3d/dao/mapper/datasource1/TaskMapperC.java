package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Task;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskMapperC extends TaskMapper {
    int selectTaskCountToday();

    List<Task> selectTaskToday();

    List<Task> selectTaskNextDays(@Param("dateStr") String dateStr, @Param("weekStr") String weekStr);
}