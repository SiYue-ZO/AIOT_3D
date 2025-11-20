package com.city3d.dao.entry;

public class Roam {
    private String roamId;

    private String roamName;

    private String roamModel;

    private String roamLine;

    private String roamIsshow;

    private String roamIsre;

    private String roamNote;

    private String roamSpeed;

    private String roamType;

    private String roamIsmodelshow;

    public String getRoamId() {
        return roamId;
    }

    public void setRoamId(String roamId) {
        this.roamId = roamId == null ? null : roamId.trim();
    }

    public String getRoamName() {
        return roamName;
    }

    public void setRoamName(String roamName) {
        this.roamName = roamName == null ? null : roamName.trim();
    }

    public String getRoamModel() {
        return roamModel;
    }

    public void setRoamModel(String roamModel) {
        this.roamModel = roamModel == null ? null : roamModel.trim();
    }

    public String getRoamLine() {
        return roamLine;
    }

    public void setRoamLine(String roamLine) {
        this.roamLine = roamLine == null ? null : roamLine.trim();
    }

    public String getRoamIsshow() {
        return roamIsshow;
    }

    public void setRoamIsshow(String roamIsshow) {
        this.roamIsshow = roamIsshow == null ? null : roamIsshow.trim();
    }

    public String getRoamIsre() {
        return roamIsre;
    }

    public void setRoamIsre(String roamIsre) {
        this.roamIsre = roamIsre == null ? null : roamIsre.trim();
    }

    public String getRoamNote() {
        return roamNote;
    }

    public void setRoamNote(String roamNote) {
        this.roamNote = roamNote == null ? null : roamNote.trim();
    }

    public String getRoamSpeed() {
        return roamSpeed;
    }

    public void setRoamSpeed(String roamSpeed) {
        this.roamSpeed = roamSpeed == null ? null : roamSpeed.trim();
    }

    public String getRoamType() {
        return roamType;
    }

    public void setRoamType(String roamType) {
        this.roamType = roamType == null ? null : roamType.trim();
    }

    public String getRoamIsmodelshow() {
        return roamIsmodelshow;
    }

    public void setRoamIsmodelshow(String roamIsmodelshow) {
        this.roamIsmodelshow = roamIsmodelshow == null ? null : roamIsmodelshow.trim();
    }
}