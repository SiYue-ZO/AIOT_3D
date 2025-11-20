package com.city3d.dao.entry;

public class DutyVideoVideo {
    private String dutyVideoVideoId;

    private String dutyVideoId;

    private String id;

    private Integer dutyOrder;
    
    private Video video;

    public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getDutyVideoVideoId() {
        return dutyVideoVideoId;
    }

    public void setDutyVideoVideoId(String dutyVideoVideoId) {
        this.dutyVideoVideoId = dutyVideoVideoId == null ? null : dutyVideoVideoId.trim();
    }

    public String getDutyVideoId() {
        return dutyVideoId;
    }

    public void setDutyVideoId(String dutyVideoId) {
        this.dutyVideoId = dutyVideoId == null ? null : dutyVideoId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getDutyOrder() {
        return dutyOrder;
    }

    public void setDutyOrder(Integer dutyOrder) {
        this.dutyOrder = dutyOrder;
    }
}