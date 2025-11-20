package com.city3d.dao.entry;

public class Address {
    private String addId;

    private String addName;

    private String province;

    private String subdistrict;

    private String communities;

    private String street;

    private String houseNumPrefix;

    private String houseNum;

    private String houseNumPostfix;

    private String auxiliaryNum;

    private String auxiliaryNumPostfix;

    private String communityName;

    private String buildingNumPrefix;

    private String buildingNum;

    private String buildingNumPostfix;

    private String unitNum;

    private String roomNum;

    private String roomNumPostfix;

    private String subsidiaryAdd;

    private String remark;

    private String poi;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    private String addType;

    private String floorHeight;

    private String floorPoi;

    private String miniheading;

    private String floorHeading;

    private String pid;

    private String addDate;
    
    private House house;
    
    private Net net;

    public Net getNet() {
		return net;
	}

	public void setNet(Net net) {
		this.net = net;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName == null ? null : addName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict == null ? null : subdistrict.trim();
    }

    public String getCommunities() {
        return communities;
    }

    public void setCommunities(String communities) {
        this.communities = communities == null ? null : communities.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getHouseNumPrefix() {
        return houseNumPrefix;
    }

    public void setHouseNumPrefix(String houseNumPrefix) {
        this.houseNumPrefix = houseNumPrefix == null ? null : houseNumPrefix.trim();
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum == null ? null : houseNum.trim();
    }

    public String getHouseNumPostfix() {
        return houseNumPostfix;
    }

    public void setHouseNumPostfix(String houseNumPostfix) {
        this.houseNumPostfix = houseNumPostfix == null ? null : houseNumPostfix.trim();
    }

    public String getAuxiliaryNum() {
        return auxiliaryNum;
    }

    public void setAuxiliaryNum(String auxiliaryNum) {
        this.auxiliaryNum = auxiliaryNum == null ? null : auxiliaryNum.trim();
    }

    public String getAuxiliaryNumPostfix() {
        return auxiliaryNumPostfix;
    }

    public void setAuxiliaryNumPostfix(String auxiliaryNumPostfix) {
        this.auxiliaryNumPostfix = auxiliaryNumPostfix == null ? null : auxiliaryNumPostfix.trim();
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getBuildingNumPrefix() {
        return buildingNumPrefix;
    }

    public void setBuildingNumPrefix(String buildingNumPrefix) {
        this.buildingNumPrefix = buildingNumPrefix == null ? null : buildingNumPrefix.trim();
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum == null ? null : buildingNum.trim();
    }

    public String getBuildingNumPostfix() {
        return buildingNumPostfix;
    }

    public void setBuildingNumPostfix(String buildingNumPostfix) {
        this.buildingNumPostfix = buildingNumPostfix == null ? null : buildingNumPostfix.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum == null ? null : roomNum.trim();
    }

    public String getRoomNumPostfix() {
        return roomNumPostfix;
    }

    public void setRoomNumPostfix(String roomNumPostfix) {
        this.roomNumPostfix = roomNumPostfix == null ? null : roomNumPostfix.trim();
    }

    public String getSubsidiaryAdd() {
        return subsidiaryAdd;
    }

    public void setSubsidiaryAdd(String subsidiaryAdd) {
        this.subsidiaryAdd = subsidiaryAdd == null ? null : subsidiaryAdd.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi == null ? null : poi.trim();
    }

    public String getCamPoi() {
        return camPoi;
    }

    public void setCamPoi(String camPoi) {
        this.camPoi = camPoi == null ? null : camPoi.trim();
    }

    public String getCamHeading() {
        return camHeading;
    }

    public void setCamHeading(String camHeading) {
        this.camHeading = camHeading == null ? null : camHeading.trim();
    }

    public String getCamPitch() {
        return camPitch;
    }

    public void setCamPitch(String camPitch) {
        this.camPitch = camPitch == null ? null : camPitch.trim();
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType == null ? null : addType.trim();
    }

    public String getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(String floorHeight) {
        this.floorHeight = floorHeight == null ? null : floorHeight.trim();
    }

    public String getFloorPoi() {
        return floorPoi;
    }

    public void setFloorPoi(String floorPoi) {
        this.floorPoi = floorPoi == null ? null : floorPoi.trim();
    }

    public String getMiniheading() {
        return miniheading;
    }

    public void setMiniheading(String miniheading) {
        this.miniheading = miniheading == null ? null : miniheading.trim();
    }

    public String getFloorHeading() {
        return floorHeading;
    }

    public void setFloorHeading(String floorHeading) {
        this.floorHeading = floorHeading == null ? null : floorHeading.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
    }
}