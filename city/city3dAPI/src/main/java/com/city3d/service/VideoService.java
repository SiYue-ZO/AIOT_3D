package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Video;

public interface VideoService {

	List<Video> getVideoAndNodes(String isIndoor);

	int countCam();
	
	List<Video> getVideosIsNode();

	Video getVideoById(String id);
	
	List<Video> getRHPCVideo(String positionStr);
	
	List<Video> getVideoNoNodes();
	
	int insert(Video Video);

	int updateByPrimaryKey(Video Video);

	int deleteByPrimaryKey(String videoId);
	
	Video getVideoByMacUrl(String macUrl);
	
	List<Video> getVideoListByMacUrl(String macUrl);
	
	int countVideoByCamPort(String camPort);
}
