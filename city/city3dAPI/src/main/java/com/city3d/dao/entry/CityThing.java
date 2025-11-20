package com.city3d.dao.entry;

public class CityThing {
    private String thingId;

    private String thingType;

    private String thingName;

    private String thingPos;

    private String thingNet;

    private String thingDep;

    private String thingClass;

    private String thingPid;

    private String thingHeading;

    private String thingScale;

    private String thingUrl;

    public String getThingId() {
        return thingId;
    }

    public void setThingId(String thingId) {
        this.thingId = thingId == null ? null : thingId.trim();
    }

    public String getThingType() {
        return thingType;
    }

    public void setThingType(String thingType) {
        this.thingType = thingType == null ? null : thingType.trim();
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName == null ? null : thingName.trim();
    }

    public String getThingPos() {
        return thingPos;
    }

    public void setThingPos(String thingPos) {
        this.thingPos = thingPos == null ? null : thingPos.trim();
    }

    public String getThingNet() {
        return thingNet;
    }

    public void setThingNet(String thingNet) {
        this.thingNet = thingNet == null ? null : thingNet.trim();
    }

    public String getThingDep() {
        return thingDep;
    }

    public void setThingDep(String thingDep) {
        this.thingDep = thingDep == null ? null : thingDep.trim();
    }

    public String getThingClass() {
        return thingClass;
    }

    public void setThingClass(String thingClass) {
        this.thingClass = thingClass == null ? null : thingClass.trim();
    }

    public String getThingPid() {
        return thingPid;
    }

    public void setThingPid(String thingPid) {
        this.thingPid = thingPid == null ? null : thingPid.trim();
    }

    public String getThingHeading() {
        return thingHeading;
    }

    public void setThingHeading(String thingHeading) {
        this.thingHeading = thingHeading == null ? null : thingHeading.trim();
    }

    public String getThingScale() {
        return thingScale;
    }

    public void setThingScale(String thingScale) {
        this.thingScale = thingScale == null ? null : thingScale.trim();
    }

    public String getThingUrl() {
        return thingUrl;
    }

    public void setThingUrl(String thingUrl) {
        this.thingUrl = thingUrl == null ? null : thingUrl.trim();
    }
}