package com.city3d.dao.mapper.datasource1;

import java.util.List;

import com.city3d.dao.entry.PeopleKnife;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleKnifeMapperC extends PeopleKnifeMapper {
    List<PeopleKnife> selectPeopleKnifeAll();

    int batchDelete(List<String> knifeIds);
}