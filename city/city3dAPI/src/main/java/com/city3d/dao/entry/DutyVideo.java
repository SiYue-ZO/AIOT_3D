package com.city3d.dao.entry;

import java.util.List;

public class DutyVideo {
    private String dutyVideoId;

    private String dutyName;

    private String dutyTime;

    private String dutyType;
    
    private List<DutyVideoVideo> dutyVideoVideo;

	public List<DutyVideoVideo> getDutyVideoVideo() {
		return dutyVideoVideo;
	}

	public void setDutyVideoVideo(List<DutyVideoVideo> dutyVideoVideo) {
		this.dutyVideoVideo = dutyVideoVideo;
	}

	public String getDutyVideoId() {
        return dutyVideoId;
    }

    public void setDutyVideoId(String dutyVideoId) {
        this.dutyVideoId = dutyVideoId == null ? null : dutyVideoId.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(String dutyTime) {
        this.dutyTime = dutyTime == null ? null : dutyTime.trim();
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType == null ? null : dutyType.trim();
    }
}