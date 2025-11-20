package com.city3d.dao.entry;

public class UavReal {
    private String realId;

    private String yawValue;

    private String pitchValue;

    private String rollValue;

    private String batterValue;

    private String flyState;

    private Boolean isVideoOn;

    private String cYam;

    private String cPitch;

    private String cRoll;

    private String camFov;

    private String camNear;

    private String camFar;

    private String camAspectratio;

    private String uavId;

    private String realDate;

    private String droneLocationLng;

    private String droneLocationLat;

    private String droneLocationArt;

    private String velocityX;

    private String velocityY;

    private String velocityZ;

    private String satelliteCount;

    private String flightTimeInSeconds;

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId == null ? null : realId.trim();
    }

    public String getYawValue() {
        return yawValue;
    }

    public void setYawValue(String yawValue) {
        this.yawValue = yawValue == null ? null : yawValue.trim();
    }

    public String getPitchValue() {
        return pitchValue;
    }

    public void setPitchValue(String pitchValue) {
        this.pitchValue = pitchValue == null ? null : pitchValue.trim();
    }

    public String getRollValue() {
        return rollValue;
    }

    public void setRollValue(String rollValue) {
        this.rollValue = rollValue == null ? null : rollValue.trim();
    }

    public String getBatterValue() {
        return batterValue;
    }

    public void setBatterValue(String batterValue) {
        this.batterValue = batterValue == null ? null : batterValue.trim();
    }

    public String getFlyState() {
        return flyState;
    }

    public void setFlyState(String flyState) {
        this.flyState = flyState == null ? null : flyState.trim();
    }

    public Boolean getIsVideoOn() {
        return isVideoOn;
    }

    public void setIsVideoOn(Boolean isVideoOn) {
        this.isVideoOn = isVideoOn;
    }

    public String getcYam() {
        return cYam;
    }

    public void setcYam(String cYam) {
        this.cYam = cYam == null ? null : cYam.trim();
    }

    public String getcPitch() {
        return cPitch;
    }

    public void setcPitch(String cPitch) {
        this.cPitch = cPitch == null ? null : cPitch.trim();
    }

    public String getcRoll() {
        return cRoll;
    }

    public void setcRoll(String cRoll) {
        this.cRoll = cRoll == null ? null : cRoll.trim();
    }

    public String getCamFov() {
        return camFov;
    }

    public void setCamFov(String camFov) {
        this.camFov = camFov == null ? null : camFov.trim();
    }

    public String getCamNear() {
        return camNear;
    }

    public void setCamNear(String camNear) {
        this.camNear = camNear == null ? null : camNear.trim();
    }

    public String getCamFar() {
        return camFar;
    }

    public void setCamFar(String camFar) {
        this.camFar = camFar == null ? null : camFar.trim();
    }

    public String getCamAspectratio() {
        return camAspectratio;
    }

    public void setCamAspectratio(String camAspectratio) {
        this.camAspectratio = camAspectratio == null ? null : camAspectratio.trim();
    }

    public String getUavId() {
        return uavId;
    }

    public void setUavId(String uavId) {
        this.uavId = uavId == null ? null : uavId.trim();
    }

    public String getRealDate() {
        return realDate;
    }

    public void setRealDate(String realDate) {
        this.realDate = realDate == null ? null : realDate.trim();
    }

    public String getDroneLocationLng() {
        return droneLocationLng;
    }

    public void setDroneLocationLng(String droneLocationLng) {
        this.droneLocationLng = droneLocationLng == null ? null : droneLocationLng.trim();
    }

    public String getDroneLocationLat() {
        return droneLocationLat;
    }

    public void setDroneLocationLat(String droneLocationLat) {
        this.droneLocationLat = droneLocationLat == null ? null : droneLocationLat.trim();
    }

    public String getDroneLocationArt() {
        return droneLocationArt;
    }

    public void setDroneLocationArt(String droneLocationArt) {
        this.droneLocationArt = droneLocationArt == null ? null : droneLocationArt.trim();
    }

    public String getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(String velocityX) {
        this.velocityX = velocityX == null ? null : velocityX.trim();
    }

    public String getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(String velocityY) {
        this.velocityY = velocityY == null ? null : velocityY.trim();
    }

    public String getVelocityZ() {
        return velocityZ;
    }

    public void setVelocityZ(String velocityZ) {
        this.velocityZ = velocityZ == null ? null : velocityZ.trim();
    }

    public String getSatelliteCount() {
        return satelliteCount;
    }

    public void setSatelliteCount(String satelliteCount) {
        this.satelliteCount = satelliteCount == null ? null : satelliteCount.trim();
    }

    public String getFlightTimeInSeconds() {
        return flightTimeInSeconds;
    }

    public void setFlightTimeInSeconds(String flightTimeInSeconds) {
        this.flightTimeInSeconds = flightTimeInSeconds == null ? null : flightTimeInSeconds.trim();
    }
}