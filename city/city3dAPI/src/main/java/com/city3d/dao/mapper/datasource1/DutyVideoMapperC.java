package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.DutyVideo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DutyVideoMapperC extends DutyVideoMapper {
    List<DutyVideo> getDutyVideoAll();
}
