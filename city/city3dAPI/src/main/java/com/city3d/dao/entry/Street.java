package com.city3d.dao.entry;

public class Street {
    private String streetId;

    private String streetName;

    private String poi;

    private String color;

    private String groupId;

    private String rowId;

    private String streetCheck;

    private String wordSize;

    private String rotationAngle;

    private String showHeight;

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId == null ? null : streetId.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi == null ? null : poi.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId == null ? null : rowId.trim();
    }

    public String getStreetCheck() {
        return streetCheck;
    }

    public void setStreetCheck(String streetCheck) {
        this.streetCheck = streetCheck == null ? null : streetCheck.trim();
    }

    public String getWordSize() {
        return wordSize;
    }

    public void setWordSize(String wordSize) {
        this.wordSize = wordSize == null ? null : wordSize.trim();
    }

    public String getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(String rotationAngle) {
        this.rotationAngle = rotationAngle == null ? null : rotationAngle.trim();
    }

    public String getShowHeight() {
        return showHeight;
    }

    public void setShowHeight(String showHeight) {
        this.showHeight = showHeight == null ? null : showHeight.trim();
    }
}