package com.city3d.dao.entry;

public class CityThingModel {
    private String thingModelId;

    private String thingModelPid;

    private String thingModelName;

    private String thingModelUrl;

    public String getThingModelId() {
        return thingModelId;
    }

    public void setThingModelId(String thingModelId) {
        this.thingModelId = thingModelId == null ? null : thingModelId.trim();
    }

    public String getThingModelPid() {
        return thingModelPid;
    }

    public void setThingModelPid(String thingModelPid) {
        this.thingModelPid = thingModelPid == null ? null : thingModelPid.trim();
    }

    public String getThingModelName() {
        return thingModelName;
    }

    public void setThingModelName(String thingModelName) {
        this.thingModelName = thingModelName == null ? null : thingModelName.trim();
    }

    public String getThingModelUrl() {
        return thingModelUrl;
    }

    public void setThingModelUrl(String thingModelUrl) {
        this.thingModelUrl = thingModelUrl == null ? null : thingModelUrl.trim();
    }
}