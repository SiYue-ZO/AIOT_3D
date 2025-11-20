package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Alarm;
import com.city3d.dao.entry.AlarmExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapperC extends AlarmMapper {
    List<Alarm> selectAllByExample(AlarmExample example);

    int batchDelete(List<String> alarmIds);
}