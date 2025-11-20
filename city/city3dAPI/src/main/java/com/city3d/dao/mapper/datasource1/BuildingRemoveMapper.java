package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.BuildingRemove;
import com.city3d.dao.entry.BuildingRemoveExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildingRemoveMapper {
    int countByExample(BuildingRemoveExample example);

    int deleteByExample(BuildingRemoveExample example);

    int deleteByPrimaryKey(String removeId);

    int insert(BuildingRemove record);

    int insertSelective(BuildingRemove record);

    List<BuildingRemove> selectByExample(BuildingRemoveExample example);

    BuildingRemove selectByPrimaryKey(String removeId);

    int updateByExampleSelective(@Param("record") BuildingRemove record, @Param("example") BuildingRemoveExample example);

    int updateByExample(@Param("record") BuildingRemove record, @Param("example") BuildingRemoveExample example);

    int updateByPrimaryKeySelective(BuildingRemove record);

    int updateByPrimaryKey(BuildingRemove record);
}