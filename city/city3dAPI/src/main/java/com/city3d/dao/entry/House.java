package com.city3d.dao.entry;

import java.util.List;

public class House {
    private String houseId;

    private String addId;

    private String paperId;

    private String owner;

    private String area;

    private String buildDate;

    private String houseUrl;

    private String panoramaUrl;

    private String beginDate;

    private String buildingPhotos;

    private String buldingStructure;

    private String cancelled;

    private String communityPolice;

    private String endDate;

    private String houseArea;

    private String houseCount;

    private String housePhotos;

    private String houseSource;

    private String houseType;

    private String houseUse;

    private String ppId;

    private String propertyNo;

    private String propertyType;

    private String rateTime;

    private String rentStatus;

    private String responseLeader;

    private String signResponseBook;

    private String star;

    private String stopRentReason;

    private String trustBy;

    private String trusteeHouseholdAddress;

    private String trusteeName;

    private String trusteeNation;

    private String trusteePpId;

    private String trusteeRelation;

    private String trusteeTel;
    
    private Address address;
    
    private PeopleBase peopleBase;
    
    private List<HousePanorama> HousePanoramas;
    
    public List<HousePanorama> getHousePanoramas() {
		return HousePanoramas;
	}

	public void setHousePanoramas(List<HousePanorama> housePanoramas) {
		HousePanoramas = housePanoramas;
	}

	public PeopleBase getPeopleBase() {
		return peopleBase;
	}

	public void setPeopleBase(PeopleBase peopleBase) {
		this.peopleBase = peopleBase;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate == null ? null : buildDate.trim();
    }

    public String getHouseUrl() {
        return houseUrl;
    }

    public void setHouseUrl(String houseUrl) {
        this.houseUrl = houseUrl == null ? null : houseUrl.trim();
    }

    public String getPanoramaUrl() {
        return panoramaUrl;
    }

    public void setPanoramaUrl(String panoramaUrl) {
        this.panoramaUrl = panoramaUrl == null ? null : panoramaUrl.trim();
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    public String getBuildingPhotos() {
        return buildingPhotos;
    }

    public void setBuildingPhotos(String buildingPhotos) {
        this.buildingPhotos = buildingPhotos == null ? null : buildingPhotos.trim();
    }

    public String getBuldingStructure() {
        return buldingStructure;
    }

    public void setBuldingStructure(String buldingStructure) {
        this.buldingStructure = buldingStructure == null ? null : buldingStructure.trim();
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled == null ? null : cancelled.trim();
    }

    public String getCommunityPolice() {
        return communityPolice;
    }

    public void setCommunityPolice(String communityPolice) {
        this.communityPolice = communityPolice == null ? null : communityPolice.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public String getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(String houseCount) {
        this.houseCount = houseCount == null ? null : houseCount.trim();
    }

    public String getHousePhotos() {
        return housePhotos;
    }

    public void setHousePhotos(String housePhotos) {
        this.housePhotos = housePhotos == null ? null : housePhotos.trim();
    }

    public String getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(String houseSource) {
        this.houseSource = houseSource == null ? null : houseSource.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getHouseUse() {
        return houseUse;
    }

    public void setHouseUse(String houseUse) {
        this.houseUse = houseUse == null ? null : houseUse.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo == null ? null : propertyNo.trim();
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType == null ? null : propertyType.trim();
    }

    public String getRateTime() {
        return rateTime;
    }

    public void setRateTime(String rateTime) {
        this.rateTime = rateTime == null ? null : rateTime.trim();
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus == null ? null : rentStatus.trim();
    }

    public String getResponseLeader() {
        return responseLeader;
    }

    public void setResponseLeader(String responseLeader) {
        this.responseLeader = responseLeader == null ? null : responseLeader.trim();
    }

    public String getSignResponseBook() {
        return signResponseBook;
    }

    public void setSignResponseBook(String signResponseBook) {
        this.signResponseBook = signResponseBook == null ? null : signResponseBook.trim();
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getStopRentReason() {
        return stopRentReason;
    }

    public void setStopRentReason(String stopRentReason) {
        this.stopRentReason = stopRentReason == null ? null : stopRentReason.trim();
    }

    public String getTrustBy() {
        return trustBy;
    }

    public void setTrustBy(String trustBy) {
        this.trustBy = trustBy == null ? null : trustBy.trim();
    }

    public String getTrusteeHouseholdAddress() {
        return trusteeHouseholdAddress;
    }

    public void setTrusteeHouseholdAddress(String trusteeHouseholdAddress) {
        this.trusteeHouseholdAddress = trusteeHouseholdAddress == null ? null : trusteeHouseholdAddress.trim();
    }

    public String getTrusteeName() {
        return trusteeName;
    }

    public void setTrusteeName(String trusteeName) {
        this.trusteeName = trusteeName == null ? null : trusteeName.trim();
    }

    public String getTrusteeNation() {
        return trusteeNation;
    }

    public void setTrusteeNation(String trusteeNation) {
        this.trusteeNation = trusteeNation == null ? null : trusteeNation.trim();
    }

    public String getTrusteePpId() {
        return trusteePpId;
    }

    public void setTrusteePpId(String trusteePpId) {
        this.trusteePpId = trusteePpId == null ? null : trusteePpId.trim();
    }

    public String getTrusteeRelation() {
        return trusteeRelation;
    }

    public void setTrusteeRelation(String trusteeRelation) {
        this.trusteeRelation = trusteeRelation == null ? null : trusteeRelation.trim();
    }

    public String getTrusteeTel() {
        return trusteeTel;
    }

    public void setTrusteeTel(String trusteeTel) {
        this.trusteeTel = trusteeTel == null ? null : trusteeTel.trim();
    }
}