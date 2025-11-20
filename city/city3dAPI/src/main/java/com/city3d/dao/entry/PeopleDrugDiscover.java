package com.city3d.dao.entry;

public class PeopleDrugDiscover {
    private String drugDiscoverId;

    private String caseType;

    private String ppId;

    private String resultsObtained;

    private String seizedUnit;

    private String seizureTime;

    private String type;

    public String getDrugDiscoverId() {
        return drugDiscoverId;
    }

    public void setDrugDiscoverId(String drugDiscoverId) {
        this.drugDiscoverId = drugDiscoverId == null ? null : drugDiscoverId.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getResultsObtained() {
        return resultsObtained;
    }

    public void setResultsObtained(String resultsObtained) {
        this.resultsObtained = resultsObtained == null ? null : resultsObtained.trim();
    }

    public String getSeizedUnit() {
        return seizedUnit;
    }

    public void setSeizedUnit(String seizedUnit) {
        this.seizedUnit = seizedUnit == null ? null : seizedUnit.trim();
    }

    public String getSeizureTime() {
        return seizureTime;
    }

    public void setSeizureTime(String seizureTime) {
        this.seizureTime = seizureTime == null ? null : seizureTime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}