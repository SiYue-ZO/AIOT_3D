package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.MapPhotosMapperC;
import com.city3d.dao.entry.MapPhotos;
import com.city3d.dao.entry.MapPhotosExample;
import com.city3d.service.MapPhotosService;
import org.springframework.stereotype.Service;

@Service
public class MapPhotosServiceImpl implements MapPhotosService {
    @Autowired
    private MapPhotosMapperC mapPhotosMapper;

    @Override
    public List<MapPhotos> getMapPhotos() {
        MapPhotosExample example = new MapPhotosExample();
        example.setOrderByClause("photo_time");
        return mapPhotosMapper.selectByExample(example);
    }

    @Override
    public List<MapPhotos> getMapPhotosByTime(String startTime, String endTime) {
        MapPhotosExample example = new MapPhotosExample();
        example.or().andPhotoTimeBetween(startTime, endTime);
        example.setOrderByClause("photo_time");
        return mapPhotosMapper.selectByExample(example);
    }

    @Override
    public int insert(MapPhotos mapPhotos) {
        return mapPhotosMapper.insert(mapPhotos);
    }

    @Override
    public int deleteByPrimaryKey(String photoId) {
        return mapPhotosMapper.deleteByPrimaryKey(photoId);
    }

    @Override
    public int batchDelete(List<String> photoIds) {
        return mapPhotosMapper.batchDelete(photoIds);
    }
}
