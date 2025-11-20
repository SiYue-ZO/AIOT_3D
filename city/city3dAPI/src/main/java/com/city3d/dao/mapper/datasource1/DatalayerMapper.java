package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.Datalayer;
import com.city3d.dao.entry.DatalayerExample;

@Mapper
public interface DatalayerMapper {
    int countByExample(DatalayerExample example);

    int deleteByExample(DatalayerExample example);

    int deleteByPrimaryKey(String layerId);

    int insert(Datalayer record);

    int insertSelective(Datalayer record);

    List<Datalayer> selectByExample(DatalayerExample example);

    Datalayer selectByPrimaryKey(String layerId);

    int updateByExampleSelective(@Param("record") Datalayer record, @Param("example") DatalayerExample example);

    int updateByExample(@Param("record") Datalayer record, @Param("example") DatalayerExample example);

    int updateByPrimaryKeySelective(Datalayer record);

    int updateByPrimaryKey(Datalayer record);
}