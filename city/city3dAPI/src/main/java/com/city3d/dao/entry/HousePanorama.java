package com.city3d.dao.entry;

public class HousePanorama {
    private String panoramaId;

    private String houseId;

    private String housePanorama;

    private String housePattern;

    public String getPanoramaId() {
        return panoramaId;
    }

    public void setPanoramaId(String panoramaId) {
        this.panoramaId = panoramaId == null ? null : panoramaId.trim();
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getHousePanorama() {
        return housePanorama;
    }

    public void setHousePanorama(String housePanorama) {
        this.housePanorama = housePanorama == null ? null : housePanorama.trim();
    }

    public String getHousePattern() {
        return housePattern;
    }

    public void setHousePattern(String housePattern) {
        this.housePattern = housePattern == null ? null : housePattern.trim();
    }
}