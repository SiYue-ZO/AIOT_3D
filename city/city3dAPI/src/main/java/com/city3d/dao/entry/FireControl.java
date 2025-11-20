package com.city3d.dao.entry;

public class FireControl {
    private String fireCtlId;

    private String addId;

    private String fireCtlName;

    private String fireCtlType;

    private String fireCtlPerson;

    private String fireCtlTel;

    private String fireCtlDescribe;

    private String fireCtlUrl;

    private String fireCtlLevel;

    private String fireCtlScale;
    
    private Address address;

    public String getFireCtlId() {
        return fireCtlId;
    }

    public void setFireCtlId(String fireCtlId) {
        this.fireCtlId = fireCtlId == null ? null : fireCtlId.trim();
    }

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }

    public String getFireCtlName() {
        return fireCtlName;
    }

    public void setFireCtlName(String fireCtlName) {
        this.fireCtlName = fireCtlName == null ? null : fireCtlName.trim();
    }

    public String getFireCtlType() {
        return fireCtlType;
    }

    public void setFireCtlType(String fireCtlType) {
        this.fireCtlType = fireCtlType == null ? null : fireCtlType.trim();
    }

    public String getFireCtlPerson() {
        return fireCtlPerson;
    }

    public void setFireCtlPerson(String fireCtlPerson) {
        this.fireCtlPerson = fireCtlPerson == null ? null : fireCtlPerson.trim();
    }

    public String getFireCtlTel() {
        return fireCtlTel;
    }

    public void setFireCtlTel(String fireCtlTel) {
        this.fireCtlTel = fireCtlTel == null ? null : fireCtlTel.trim();
    }

    public String getFireCtlDescribe() {
        return fireCtlDescribe;
    }

    public void setFireCtlDescribe(String fireCtlDescribe) {
        this.fireCtlDescribe = fireCtlDescribe == null ? null : fireCtlDescribe.trim();
    }

    public String getFireCtlUrl() {
        return fireCtlUrl;
    }

    public void setFireCtlUrl(String fireCtlUrl) {
        this.fireCtlUrl = fireCtlUrl == null ? null : fireCtlUrl.trim();
    }

    public String getFireCtlLevel() {
        return fireCtlLevel;
    }

    public void setFireCtlLevel(String fireCtlLevel) {
        this.fireCtlLevel = fireCtlLevel == null ? null : fireCtlLevel.trim();
    }

    public String getFireCtlScale() {
        return fireCtlScale;
    }

    public void setFireCtlScale(String fireCtlScale) {
        this.fireCtlScale = fireCtlScale == null ? null : fireCtlScale.trim();
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
}