package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.MapImage;
import com.city3d.dao.entry.MapImageExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MapImageMapper {
    int countByExample(MapImageExample example);

    int deleteByExample(MapImageExample example);

    int deleteByPrimaryKey(String imageId);

    int insert(MapImage record);

    int insertSelective(MapImage record);

    List<MapImage> selectByExample(MapImageExample example);

    MapImage selectByPrimaryKey(String imageId);

    int updateByExampleSelective(@Param("record") MapImage record, @Param("example") MapImageExample example);

    int updateByExample(@Param("record") MapImage record, @Param("example") MapImageExample example);

    int updateByPrimaryKeySelective(MapImage record);

    int updateByPrimaryKey(MapImage record);
}