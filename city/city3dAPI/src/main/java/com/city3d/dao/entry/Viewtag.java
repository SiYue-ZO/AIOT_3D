package com.city3d.dao.entry;

public class Viewtag {
    private String tagId;

    private String tagName;

    private String tagPoi;

    private String tagHeading;

    private String tagPitch;

    private String tagLabelPoi;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagPoi() {
        return tagPoi;
    }

    public void setTagPoi(String tagPoi) {
        this.tagPoi = tagPoi == null ? null : tagPoi.trim();
    }

    public String getTagHeading() {
        return tagHeading;
    }

    public void setTagHeading(String tagHeading) {
        this.tagHeading = tagHeading == null ? null : tagHeading.trim();
    }

    public String getTagPitch() {
        return tagPitch;
    }

    public void setTagPitch(String tagPitch) {
        this.tagPitch = tagPitch == null ? null : tagPitch.trim();
    }

    public String getTagLabelPoi() {
        return tagLabelPoi;
    }

    public void setTagLabelPoi(String tagLabelPoi) {
        this.tagLabelPoi = tagLabelPoi == null ? null : tagLabelPoi.trim();
    }
}