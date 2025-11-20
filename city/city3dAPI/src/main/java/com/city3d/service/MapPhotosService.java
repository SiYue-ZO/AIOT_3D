package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.MapPhotos;

public interface MapPhotosService {
    List<MapPhotos> getMapPhotos();

    List<MapPhotos> getMapPhotosByTime(String startTime, String endTime);

    int insert(MapPhotos mapPhotos);

    int deleteByPrimaryKey(String photoId);

    int batchDelete(List<String> photoIds);
}
