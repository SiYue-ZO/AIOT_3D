package com.city3d.dao.mapper.datasource1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BimDeviceMapperC extends BimDeviceMapper {
    int batchDelete(List<String> deviceIds);
}