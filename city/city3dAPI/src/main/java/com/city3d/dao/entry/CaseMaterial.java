package com.city3d.dao.entry;

public class CaseMaterial {
    private String caseMaterialId;

    private String caseId;

    private String materialUrl;

    private String materialType;

    public String getCaseMaterialId() {
        return caseMaterialId;
    }

    public void setCaseMaterialId(String caseMaterialId) {
        this.caseMaterialId = caseMaterialId == null ? null : caseMaterialId.trim();
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl == null ? null : materialUrl.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }
}