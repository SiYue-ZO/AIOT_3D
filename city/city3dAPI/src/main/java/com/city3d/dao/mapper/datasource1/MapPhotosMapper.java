package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.MapPhotos;
import com.city3d.dao.entry.MapPhotosExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MapPhotosMapper {
    int countByExample(MapPhotosExample example);

    int deleteByExample(MapPhotosExample example);

    int deleteByPrimaryKey(String photoId);

    int insert(MapPhotos record);

    int insertSelective(MapPhotos record);

    List<MapPhotos> selectByExample(MapPhotosExample example);

    MapPhotos selectByPrimaryKey(String photoId);

    int updateByExampleSelective(@Param("record") MapPhotos record, @Param("example") MapPhotosExample example);

    int updateByExample(@Param("record") MapPhotos record, @Param("example") MapPhotosExample example);

    int updateByPrimaryKeySelective(MapPhotos record);

    int updateByPrimaryKey(MapPhotos record);
}