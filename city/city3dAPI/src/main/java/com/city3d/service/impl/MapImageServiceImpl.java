package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.MapImageMapperC;
import com.city3d.dao.entry.MapImage;
import com.city3d.dao.entry.MapImageExample;
import com.city3d.service.MapImageService;
import org.springframework.stereotype.Service;

@Service
public class MapImageServiceImpl implements MapImageService {
	@Autowired
	private MapImageMapperC mapImageMapper;

	@Override
	public List<MapImage> getMapImage() {
		MapImageExample example = new MapImageExample();
		example.or().andImagePidEqualTo("0");
		example.setOrderByClause("image_time");
		return mapImageMapper.selectByExample(example);
	}

	@Override
	public int insert(MapImage mapImage) {
		return mapImageMapper.insert(mapImage);
	}

	@Override
	public int deleteByPrimaryKey(String imageId) {
		return mapImageMapper.deleteByPrimaryKey(imageId);
	}

	@Override
	public int batchDelete(List<String> imageIds) {
		return mapImageMapper.batchDelete(imageIds);
	}

	@Override
	public List<MapImage> getMapImageByPid(String imagePid) {
		MapImageExample example = new MapImageExample();
		example.or().andImagePidEqualTo(imagePid);
		return mapImageMapper.selectByExample(example);
	}
}
