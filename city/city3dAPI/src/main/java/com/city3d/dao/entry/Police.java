package com.city3d.dao.entry;

import java.util.List;

public class Police {
    private String policeId;

    private String netId;

    private String depId;

    private String name;

    private String identity;

    private String gender;

    private String birth;

    private String nation;

    private String origin;

    private String post;

    private String jobDate;

    private String policeRank;

    private String education;

    private String deviceNum;

    private String deviceType;

    private String deviceDate;

    private String image;
    
    private ManPos manPos;
    
    private List<EquipmentRel> equipmentRels;

	public List<EquipmentRel> getEquipmentRels() {
		return equipmentRels;
	}

	public void setEquipmentRels(List<EquipmentRel> equipmentRels) {
		this.equipmentRels = equipmentRels;
	}

	public ManPos getManPos() {
		return manPos;
	}

	public void setManPos(ManPos manPos) {
		this.manPos = manPos;
	}

	public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId == null ? null : policeId.trim();
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId == null ? null : netId.trim();
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate == null ? null : jobDate.trim();
    }

    public String getPoliceRank() {
        return policeRank;
    }

    public void setPoliceRank(String policeRank) {
        this.policeRank = policeRank == null ? null : policeRank.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(String deviceDate) {
        this.deviceDate = deviceDate == null ? null : deviceDate.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}