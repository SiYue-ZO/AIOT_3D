package com.city3d.vo;

import com.city3d.dao.entry.SysRoleVideo;
import com.city3d.dao.entry.Video;

public class RoleVideo {
    Video video;

    SysRoleVideo sysRoleVideo;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public SysRoleVideo getSysRoleVideo() {
        return sysRoleVideo;
    }

    public void setSysRoleVideo(SysRoleVideo sysRoleVideo) {
        this.sysRoleVideo = sysRoleVideo;
    }
}
