package com.city3d.dao.entry;

public class MapPhotos {
    private String photoId;

    private String photoName;

    private String photoPos;

    private String photoTime;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoPos() {
        return photoPos;
    }

    public void setPhotoPos(String photoPos) {
        this.photoPos = photoPos == null ? null : photoPos.trim();
    }

    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime == null ? null : photoTime.trim();
    }
}