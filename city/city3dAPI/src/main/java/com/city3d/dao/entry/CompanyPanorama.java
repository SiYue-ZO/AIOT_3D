package com.city3d.dao.entry;

public class CompanyPanorama {
    private String panoramaId;

    private String companyId;

    private String companyPanorama;

    private String companyPattern;

    public String getPanoramaId() {
        return panoramaId;
    }

    public void setPanoramaId(String panoramaId) {
        this.panoramaId = panoramaId == null ? null : panoramaId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyPanorama() {
        return companyPanorama;
    }

    public void setCompanyPanorama(String companyPanorama) {
        this.companyPanorama = companyPanorama == null ? null : companyPanorama.trim();
    }

    public String getCompanyPattern() {
        return companyPattern;
    }

    public void setCompanyPattern(String companyPattern) {
        this.companyPattern = companyPattern == null ? null : companyPattern.trim();
    }
}