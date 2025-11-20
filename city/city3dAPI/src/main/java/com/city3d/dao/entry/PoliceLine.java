package com.city3d.dao.entry;

public class PoliceLine {
    private String lId;

    private String lName;

    private String lType;

    private String lPoyline;

    private String lColor;

    private String lTime;

    private String lPName;

    private String lStop;

    private String lLiving;

    private String lNote;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType == null ? null : lType.trim();
    }

    public String getlPoyline() {
        return lPoyline;
    }

    public void setlPoyline(String lPoyline) {
        this.lPoyline = lPoyline == null ? null : lPoyline.trim();
    }

    public String getlColor() {
        return lColor;
    }

    public void setlColor(String lColor) {
        this.lColor = lColor == null ? null : lColor.trim();
    }

    public String getlTime() {
        return lTime;
    }

    public void setlTime(String lTime) {
        this.lTime = lTime == null ? null : lTime.trim();
    }

    public String getlPName() {
        return lPName;
    }

    public void setlPName(String lPName) {
        this.lPName = lPName == null ? null : lPName.trim();
    }

    public String getlStop() {
        return lStop;
    }

    public void setlStop(String lStop) {
        this.lStop = lStop == null ? null : lStop.trim();
    }

    public String getlLiving() {
        return lLiving;
    }

    public void setlLiving(String lLiving) {
        this.lLiving = lLiving == null ? null : lLiving.trim();
    }

    public String getlNote() {
        return lNote;
    }

    public void setlNote(String lNote) {
        this.lNote = lNote == null ? null : lNote.trim();
    }
}