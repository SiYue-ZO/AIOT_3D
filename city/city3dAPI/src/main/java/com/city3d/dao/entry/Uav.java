package com.city3d.dao.entry;

public class Uav {
    private String uavId;

    private String uavName;

    private String uavType;

    private String uavModel;

    private String uavProperty;

    private String uavDate;

    private String uavElec;

    private String uavCamType;

    private String uavUrl;
    
    private String[] uavIds;

    public String[] getUavIds() {
		return uavIds;
	}

	public void setUavIds(String[] uavIds) {
		this.uavIds = uavIds;
	}

	public String getUavId() {
        return uavId;
    }

    public void setUavId(String uavId) {
        this.uavId = uavId == null ? null : uavId.trim();
    }

    public String getUavName() {
        return uavName;
    }

    public void setUavName(String uavName) {
        this.uavName = uavName == null ? null : uavName.trim();
    }

    public String getUavType() {
        return uavType;
    }

    public void setUavType(String uavType) {
        this.uavType = uavType == null ? null : uavType.trim();
    }

    public String getUavModel() {
        return uavModel;
    }

    public void setUavModel(String uavModel) {
        this.uavModel = uavModel == null ? null : uavModel.trim();
    }

    public String getUavProperty() {
        return uavProperty;
    }

    public void setUavProperty(String uavProperty) {
        this.uavProperty = uavProperty == null ? null : uavProperty.trim();
    }

    public String getUavDate() {
        return uavDate;
    }

    public void setUavDate(String uavDate) {
        this.uavDate = uavDate == null ? null : uavDate.trim();
    }

    public String getUavElec() {
        return uavElec;
    }

    public void setUavElec(String uavElec) {
        this.uavElec = uavElec == null ? null : uavElec.trim();
    }

    public String getUavCamType() {
        return uavCamType;
    }

    public void setUavCamType(String uavCamType) {
        this.uavCamType = uavCamType == null ? null : uavCamType.trim();
    }

    public String getUavUrl() {
        return uavUrl;
    }

    public void setUavUrl(String uavUrl) {
        this.uavUrl = uavUrl == null ? null : uavUrl.trim();
    }
}