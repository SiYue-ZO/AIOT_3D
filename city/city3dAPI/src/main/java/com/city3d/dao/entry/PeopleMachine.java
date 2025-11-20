package com.city3d.dao.entry;

public class PeopleMachine {
    private String machineId;

    private String ppId;

    private String qrCode;

    private String machineImgUrl;

    private String machineRemark;

    private String machineType;
    
    private PeopleBase peopleBase;

    public PeopleBase getPeopleBase() {
		return peopleBase;
	}

	public void setPeopleBase(PeopleBase peopleBase) {
		this.peopleBase = peopleBase;
	}

	public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId == null ? null : machineId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public String getMachineImgUrl() {
        return machineImgUrl;
    }

    public void setMachineImgUrl(String machineImgUrl) {
        this.machineImgUrl = machineImgUrl == null ? null : machineImgUrl.trim();
    }

    public String getMachineRemark() {
        return machineRemark;
    }

    public void setMachineRemark(String machineRemark) {
        this.machineRemark = machineRemark == null ? null : machineRemark.trim();
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType == null ? null : machineType.trim();
    }
}