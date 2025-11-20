package com.city3d.dao.entry;

public class Datalayer {
    private String layerId;

    private String layerName;

    private String layerType;

    private String layerFormat;

    private String layerPid;

    private String layerPath;

    public String getLayerId() {
        return layerId;
    }

    public void setLayerId(String layerId) {
        this.layerId = layerId == null ? null : layerId.trim();
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName == null ? null : layerName.trim();
    }

    public String getLayerType() {
        return layerType;
    }

    public void setLayerType(String layerType) {
        this.layerType = layerType == null ? null : layerType.trim();
    }

    public String getLayerFormat() {
        return layerFormat;
    }

    public void setLayerFormat(String layerFormat) {
        this.layerFormat = layerFormat == null ? null : layerFormat.trim();
    }

    public String getLayerPid() {
        return layerPid;
    }

    public void setLayerPid(String layerPid) {
        this.layerPid = layerPid == null ? null : layerPid.trim();
    }

    public String getLayerPath() {
        return layerPath;
    }

    public void setLayerPath(String layerPath) {
        this.layerPath = layerPath == null ? null : layerPath.trim();
    }
}