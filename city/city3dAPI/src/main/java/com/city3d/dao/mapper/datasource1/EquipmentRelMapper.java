package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.EquipmentRel;
import com.city3d.dao.entry.EquipmentRelExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EquipmentRelMapper {
    int countByExample(EquipmentRelExample example);

    int deleteByExample(EquipmentRelExample example);

    int deleteByPrimaryKey(String equipRelId);

    int insert(EquipmentRel record);

    int insertSelective(EquipmentRel record);

    List<EquipmentRel> selectByExample(EquipmentRelExample example);

    EquipmentRel selectByPrimaryKey(String equipRelId);

    int updateByExampleSelective(@Param("record") EquipmentRel record, @Param("example") EquipmentRelExample example);

    int updateByExample(@Param("record") EquipmentRel record, @Param("example") EquipmentRelExample example);

    int updateByPrimaryKeySelective(EquipmentRel record);

    int updateByPrimaryKey(EquipmentRel record);
}