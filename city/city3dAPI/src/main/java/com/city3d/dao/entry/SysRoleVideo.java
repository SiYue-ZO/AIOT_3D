package com.city3d.dao.entry;

public class SysRoleVideo {
    private String roleVideoId;

    private String roleId;

    private String videoId;

    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getRoleVideoId() {
        return roleVideoId;
    }

    public void setRoleVideoId(String roleVideoId) {
        this.roleVideoId = roleVideoId == null ? null : roleVideoId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }
}