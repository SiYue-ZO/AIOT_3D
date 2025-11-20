package com.city3d.dao.entry;

import java.util.List;

public class PeopleBase {
    private String ppId;

    private String addId;

    private String town;

    private String identity;

    private String tel;

    private String motherIdentity;

    private String motherName;

    private String nation;

    private String mateIdentity;

    private String mateName;

    private String height;

    private String communityCode;

    private String gender;

    private String calture;

    private String name;

    private String bloodType;

    private String phone;

    private String householdRelation;

    private String region;

    private String political;

    private String onceName;

    private String unitName;

    private String job;

    private String fatherIdentity;

    private String fatherName;

    private String identity1;

    private String householdNo;

    private String householdAddress;

    private String householdPorvince;

    private String householdNature;

    private String marriage;

    private String nativePlaceCountry;

    private String nativePlaceProvince;

    private String fromCountry;

    private String fromAddress;

    private String fromProvince;

    private String inDate;

    private String inReason;

    private String serveArmy;

    private String overseasRelation;

    private String peopleType;

    private String imgurl;

    private String imgOther;

    private String skill;

    private String entryType;

    private String isDrug;

    private String isFlow;

    private String isImportant;

    private String isLost;

    private String isMental;

    private String isOut;

    private String isSupervise;

    private String isVisit;

    private String isXinjiang;

    private String isKey;
    
    private Address address;
    
    private PeopleKnife peopleKnife;
    
    private String polygon;
    
    private List<PeopleKnife> peopleKnifes;
    
    private List<PeopleMachine> peopleMachines;
    
    private List<PeopleVehicle> peopleVehicles;

	public List<PeopleVehicle> getPeopleVehicles() {
		return peopleVehicles;
	}

	public void setPeopleVehicles(List<PeopleVehicle> peopleVehicles) {
		this.peopleVehicles = peopleVehicles;
	}

	public List<PeopleMachine> getPeopleMachines() {
		return peopleMachines;
	}

	public void setPeopleMachines(List<PeopleMachine> peopleMachines) {
		this.peopleMachines = peopleMachines;
	}

	public List<PeopleKnife> getPeopleKnifes() {
		return peopleKnifes;
	}

	public void setPeopleKnifes(List<PeopleKnife> peopleKnifes) {
		this.peopleKnifes = peopleKnifes;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PeopleKnife getPeopleKnife() {
		return peopleKnife;
	}

	public void setPeopleKnife(PeopleKnife peopleKnife) {
		this.peopleKnife = peopleKnife;
	}

	public String getPolygon() {
		return polygon;
	}

	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}

	public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMotherIdentity() {
        return motherIdentity;
    }

    public void setMotherIdentity(String motherIdentity) {
        this.motherIdentity = motherIdentity == null ? null : motherIdentity.trim();
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName == null ? null : motherName.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getMateIdentity() {
        return mateIdentity;
    }

    public void setMateIdentity(String mateIdentity) {
        this.mateIdentity = mateIdentity == null ? null : mateIdentity.trim();
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName == null ? null : mateName.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode == null ? null : communityCode.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCalture() {
        return calture;
    }

    public void setCalture(String calture) {
        this.calture = calture == null ? null : calture.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getHouseholdRelation() {
        return householdRelation;
    }

    public void setHouseholdRelation(String householdRelation) {
        this.householdRelation = householdRelation == null ? null : householdRelation.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public String getOnceName() {
        return onceName;
    }

    public void setOnceName(String onceName) {
        this.onceName = onceName == null ? null : onceName.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getFatherIdentity() {
        return fatherIdentity;
    }

    public void setFatherIdentity(String fatherIdentity) {
        this.fatherIdentity = fatherIdentity == null ? null : fatherIdentity.trim();
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    public String getIdentity1() {
        return identity1;
    }

    public void setIdentity1(String identity1) {
        this.identity1 = identity1 == null ? null : identity1.trim();
    }

    public String getHouseholdNo() {
        return householdNo;
    }

    public void setHouseholdNo(String householdNo) {
        this.householdNo = householdNo == null ? null : householdNo.trim();
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress == null ? null : householdAddress.trim();
    }

    public String getHouseholdPorvince() {
        return householdPorvince;
    }

    public void setHouseholdPorvince(String householdPorvince) {
        this.householdPorvince = householdPorvince == null ? null : householdPorvince.trim();
    }

    public String getHouseholdNature() {
        return householdNature;
    }

    public void setHouseholdNature(String householdNature) {
        this.householdNature = householdNature == null ? null : householdNature.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getNativePlaceCountry() {
        return nativePlaceCountry;
    }

    public void setNativePlaceCountry(String nativePlaceCountry) {
        this.nativePlaceCountry = nativePlaceCountry == null ? null : nativePlaceCountry.trim();
    }

    public String getNativePlaceProvince() {
        return nativePlaceProvince;
    }

    public void setNativePlaceProvince(String nativePlaceProvince) {
        this.nativePlaceProvince = nativePlaceProvince == null ? null : nativePlaceProvince.trim();
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry == null ? null : fromCountry.trim();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince == null ? null : fromProvince.trim();
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate == null ? null : inDate.trim();
    }

    public String getInReason() {
        return inReason;
    }

    public void setInReason(String inReason) {
        this.inReason = inReason == null ? null : inReason.trim();
    }

    public String getServeArmy() {
        return serveArmy;
    }

    public void setServeArmy(String serveArmy) {
        this.serveArmy = serveArmy == null ? null : serveArmy.trim();
    }

    public String getOverseasRelation() {
        return overseasRelation;
    }

    public void setOverseasRelation(String overseasRelation) {
        this.overseasRelation = overseasRelation == null ? null : overseasRelation.trim();
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType == null ? null : peopleType.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getImgOther() {
        return imgOther;
    }

    public void setImgOther(String imgOther) {
        this.imgOther = imgOther == null ? null : imgOther.trim();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType == null ? null : entryType.trim();
    }

    public String getIsDrug() {
        return isDrug;
    }

    public void setIsDrug(String isDrug) {
        this.isDrug = isDrug == null ? null : isDrug.trim();
    }

    public String getIsFlow() {
        return isFlow;
    }

    public void setIsFlow(String isFlow) {
        this.isFlow = isFlow == null ? null : isFlow.trim();
    }

    public String getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(String isImportant) {
        this.isImportant = isImportant == null ? null : isImportant.trim();
    }

    public String getIsLost() {
        return isLost;
    }

    public void setIsLost(String isLost) {
        this.isLost = isLost == null ? null : isLost.trim();
    }

    public String getIsMental() {
        return isMental;
    }

    public void setIsMental(String isMental) {
        this.isMental = isMental == null ? null : isMental.trim();
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut == null ? null : isOut.trim();
    }

    public String getIsSupervise() {
        return isSupervise;
    }

    public void setIsSupervise(String isSupervise) {
        this.isSupervise = isSupervise == null ? null : isSupervise.trim();
    }

    public String getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(String isVisit) {
        this.isVisit = isVisit == null ? null : isVisit.trim();
    }

    public String getIsXinjiang() {
        return isXinjiang;
    }

    public void setIsXinjiang(String isXinjiang) {
        this.isXinjiang = isXinjiang == null ? null : isXinjiang.trim();
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey == null ? null : isKey.trim();
    }
}