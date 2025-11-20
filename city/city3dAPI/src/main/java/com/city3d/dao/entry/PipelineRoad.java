package com.city3d.dao.entry;

public class PipelineRoad {
    private String roadId;

    private String roadName;

    private String roadPid;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    public String getRoadId() {
        return roadId;
    }

    public void setRoadId(String roadId) {
        this.roadId = roadId == null ? null : roadId.trim();
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName == null ? null : roadName.trim();
    }

    public String getRoadPid() {
        return roadPid;
    }

    public void setRoadPid(String roadPid) {
        this.roadPid = roadPid == null ? null : roadPid.trim();
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