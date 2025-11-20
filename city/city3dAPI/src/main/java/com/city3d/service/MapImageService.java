package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.MapImage;

public interface MapImageService {
    List<MapImage> getMapImage();

    int insert(MapImage mapImage);

    int deleteByPrimaryKey(String imageId);

    int batchDelete(List<String> imageIds);

    List<MapImage> getMapImageByPid(String imagePid);
}
