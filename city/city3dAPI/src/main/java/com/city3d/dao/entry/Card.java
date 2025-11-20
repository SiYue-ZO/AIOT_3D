package com.city3d.dao.entry;

public class Card {
    private String crId;

    private String crAdd;

    private String crTime;

    private String crCardnum;

    private String poi;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId == null ? null : crId.trim();
    }

    public String getCrAdd() {
        return crAdd;
    }

    public void setCrAdd(String crAdd) {
        this.crAdd = crAdd == null ? null : crAdd.trim();
    }

    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime == null ? null : crTime.trim();
    }

    public String getCrCardnum() {
        return crCardnum;
    }

    public void setCrCardnum(String crCardnum) {
        this.crCardnum = crCardnum == null ? null : crCardnum.trim();
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi == null ? null : poi.trim();
    }

    public String getCamPoi() {
        return camPoi;
    }

    public void setCamPoi(String camPoi) {
        this.camPoi = camPoi == null ? null : camPoi.trim();
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
}