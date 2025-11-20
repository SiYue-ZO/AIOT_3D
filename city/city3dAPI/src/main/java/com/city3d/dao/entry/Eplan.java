package com.city3d.dao.entry;

public class Eplan {
    private String eplanId;

    private String eplanName;

    private String eplanCon;

    private String eplanType;

    private String eplanDate;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    public String getEplanId() {
        return eplanId;
    }

    public void setEplanId(String eplanId) {
        this.eplanId = eplanId == null ? null : eplanId.trim();
    }

    public String getEplanName() {
        return eplanName;
    }

    public void setEplanName(String eplanName) {
        this.eplanName = eplanName == null ? null : eplanName.trim();
    }

    public String getEplanCon() {
        return eplanCon;
    }

    public void setEplanCon(String eplanCon) {
        this.eplanCon = eplanCon == null ? null : eplanCon.trim();
    }

    public String getEplanType() {
        return eplanType;
    }

    public void setEplanType(String eplanType) {
        this.eplanType = eplanType == null ? null : eplanType.trim();
    }

    public String getEplanDate() {
        return eplanDate;
    }

    public void setEplanDate(String eplanDate) {
        this.eplanDate = eplanDate == null ? null : eplanDate.trim();
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