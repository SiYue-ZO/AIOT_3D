package com.city3d.dao.entry;

public class AccessCar {
    private String accessCarId;

    private String accessTime;

    private String cameraId;

    private String accessType;

    private String image;

    private String userId;

    private String serialNumber;

    public String getAccessCarId() {
        return accessCarId;
    }

    public void setAccessCarId(String accessCarId) {
        this.accessCarId = accessCarId == null ? null : accessCarId.trim();
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime == null ? null : accessTime.trim();
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId == null ? null : cameraId.trim();
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType == null ? null : accessType.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }
}