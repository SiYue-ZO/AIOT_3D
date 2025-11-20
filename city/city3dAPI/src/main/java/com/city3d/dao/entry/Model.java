package com.city3d.dao.entry;

public class Model {
    private String modelId;

    private String modelName;

    private String modelDep;

    private String modelUrl;

    private String modelImg;

    private String modelScale;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelDep() {
        return modelDep;
    }

    public void setModelDep(String modelDep) {
        this.modelDep = modelDep == null ? null : modelDep.trim();
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl == null ? null : modelUrl.trim();
    }

    public String getModelImg() {
        return modelImg;
    }

    public void setModelImg(String modelImg) {
        this.modelImg = modelImg == null ? null : modelImg.trim();
    }

    public String getModelScale() {
        return modelScale;
    }

    public void setModelScale(String modelScale) {
        this.modelScale = modelScale == null ? null : modelScale.trim();
    }
}