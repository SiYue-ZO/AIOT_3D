package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.BimWaterFlow;
import com.city3d.dao.entry.BimWaterFlowExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BimWaterFlowMapper {
    int countByExample(BimWaterFlowExample example);

    int deleteByExample(BimWaterFlowExample example);

    int deleteByPrimaryKey(String bimFlowId);

    int insert(BimWaterFlow record);

    int insertSelective(BimWaterFlow record);

    List<BimWaterFlow> selectByExample(BimWaterFlowExample example);

    BimWaterFlow selectByPrimaryKey(String bimFlowId);

    int updateByExampleSelective(@Param("record") BimWaterFlow record, @Param("example") BimWaterFlowExample example);

    int updateByExample(@Param("record") BimWaterFlow record, @Param("example") BimWaterFlowExample example);

    int updateByPrimaryKeySelective(BimWaterFlow record);

    int updateByPrimaryKey(BimWaterFlow record);
}