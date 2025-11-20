package com.city3d.dao.entry;

public class Video {
    private String id;

    private String camAdd;

    private String camUrl;

    private String camType;

    private String camPosition;

    private String camPid;

    private Boolean camIsnode;

    private String camHoles;

    private String camFov;

    private String camHeading;

    private String camPitch;

    private String camRoll;

    private String camNear;

    private String camFar;

    private String camAspectratio;

    private String camRtsp;

    private String camPort;

    private String macUrl;

    private String isIndoor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCamAdd() {
        return camAdd;
    }

    public void setCamAdd(String camAdd) {
        this.camAdd = camAdd == null ? null : camAdd.trim();
    }

    public String getCamUrl() {
        return camUrl;
    }

    public void setCamUrl(String camUrl) {
        this.camUrl = camUrl == null ? null : camUrl.trim();
    }

    public String getCamType() {
        return camType;
    }

    public void setCamType(String camType) {
        this.camType = camType == null ? null : camType.trim();
    }

    public String getCamPosition() {
        return camPosition;
    }

    public void setCamPosition(String camPosition) {
        this.camPosition = camPosition == null ? null : camPosition.trim();
    }

    public String getCamPid() {
        return camPid;
    }

    public void setCamPid(String camPid) {
        this.camPid = camPid == null ? null : camPid.trim();
    }

    public Boolean getCamIsnode() {
        return camIsnode;
    }

    public void setCamIsnode(Boolean camIsnode) {
        this.camIsnode = camIsnode;
    }

    public String getCamHoles() {
        return camHoles;
    }

    public void setCamHoles(String camHoles) {
        this.camHoles = camHoles == null ? null : camHoles.trim();
    }

    public String getCamFov() {
        return camFov;
    }

    public void setCamFov(String camFov) {
        this.camFov = camFov == null ? null : camFov.trim();
    }

    public String getCamHeading() {
        return camHeading;
    }

    public void setCamHeading(String camHeading) {
        this.camHeading = camHeading == null ? null : camHeading.trim();
    }

    public String getCamPitch() {
        return camPitch;
    }

    public void setCamPitch(String camPitch) {
        this.camPitch = camPitch == null ? null : camPitch.trim();
    }

    public String getCamRoll() {
        return camRoll;
    }

    public void setCamRoll(String camRoll) {
        this.camRoll = camRoll == null ? null : camRoll.trim();
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

    public String getCamRtsp() {
        return camRtsp;
    }

    public void setCamRtsp(String camRtsp) {
        this.camRtsp = camRtsp == null ? null : camRtsp.trim();
    }

    public String getCamPort() {
        return camPort;
    }

    public void setCamPort(String camPort) {
        this.camPort = camPort == null ? null : camPort.trim();
    }

    public String getMacUrl() {
        return macUrl;
    }

    public void setMacUrl(String macUrl) {
        this.macUrl = macUrl == null ? null : macUrl.trim();
    }

    public String getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(String isIndoor) {
        this.isIndoor = isIndoor == null ? null : isIndoor.trim();
    }
}