package com.city3d.dao.entry;

public class Bim {
    private String tilesId;

    private String tilesName;

    private String tilesUrl;

    private String tilesType;

    private String tilesX;

    private String tilesY;

    private String tilesZ;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    public String getTilesId() {
        return tilesId;
    }

    public void setTilesId(String tilesId) {
        this.tilesId = tilesId == null ? null : tilesId.trim();
    }

    public String getTilesName() {
        return tilesName;
    }

    public void setTilesName(String tilesName) {
        this.tilesName = tilesName == null ? null : tilesName.trim();
    }

    public String getTilesUrl() {
        return tilesUrl;
    }

    public void setTilesUrl(String tilesUrl) {
        this.tilesUrl = tilesUrl == null ? null : tilesUrl.trim();
    }

    public String getTilesType() {
        return tilesType;
    }

    public void setTilesType(String tilesType) {
        this.tilesType = tilesType == null ? null : tilesType.trim();
    }

    public String getTilesX() {
        return tilesX;
    }

    public void setTilesX(String tilesX) {
        this.tilesX = tilesX == null ? null : tilesX.trim();
    }

    public String getTilesY() {
        return tilesY;
    }

    public void setTilesY(String tilesY) {
        this.tilesY = tilesY == null ? null : tilesY.trim();
    }

    public String getTilesZ() {
        return tilesZ;
    }

    public void setTilesZ(String tilesZ) {
        this.tilesZ = tilesZ == null ? null : tilesZ.trim();
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