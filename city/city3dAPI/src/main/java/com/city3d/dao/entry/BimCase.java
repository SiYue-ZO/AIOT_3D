package com.city3d.dao.entry;

public class BimCase {
    private String bimCaseId;

    private String bimCaseName;

    private String modelId;

    private String modelPos;

    private String modelHeading;

    private String modelScale;

    private String flattenPos;

    public String getBimCaseId() {
        return bimCaseId;
    }

    public void setBimCaseId(String bimCaseId) {
        this.bimCaseId = bimCaseId == null ? null : bimCaseId.trim();
    }

    public String getBimCaseName() {
        return bimCaseName;
    }

    public void setBimCaseName(String bimCaseName) {
        this.bimCaseName = bimCaseName == null ? null : bimCaseName.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelPos() {
        return modelPos;
    }

    public void setModelPos(String modelPos) {
        this.modelPos = modelPos == null ? null : modelPos.trim();
    }

    public String getModelHeading() {
        return modelHeading;
    }

    public void setModelHeading(String modelHeading) {
        this.modelHeading = modelHeading == null ? null : modelHeading.trim();
    }

    public String getModelScale() {
        return modelScale;
    }

    public void setModelScale(String modelScale) {
        this.modelScale = modelScale == null ? null : modelScale.trim();
    }

    public String getFlattenPos() {
        return flattenPos;
    }

    public void setFlattenPos(String flattenPos) {
        this.flattenPos = flattenPos == null ? null : flattenPos.trim();
    }
}