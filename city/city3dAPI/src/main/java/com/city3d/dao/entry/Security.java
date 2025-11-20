package com.city3d.dao.entry;

public class Security {
    private String securityId;

    private String securityName;

    private String securityType;

    private String securityPoliceId;

    private String securityTel;

    private String securityDescribe;

    private String securityPoi;

    private String securityCenter;

    private String securityVideoId;

    private String equipmentId;

    private String securityCommunity;

    private String netMaster;

    private String netListener;

    private String netBasePeople;

    private String netHoldPeople;

    private String netFlowPeople;

    private String netGroup;

    private String netNote;

    private String pid;

    private String level;
    
    private Police police;

    public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
	}

	public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName == null ? null : securityName.trim();
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType == null ? null : securityType.trim();
    }

    public String getSecurityPoliceId() {
        return securityPoliceId;
    }

    public void setSecurityPoliceId(String securityPoliceId) {
        this.securityPoliceId = securityPoliceId == null ? null : securityPoliceId.trim();
    }

    public String getSecurityTel() {
        return securityTel;
    }

    public void setSecurityTel(String securityTel) {
        this.securityTel = securityTel == null ? null : securityTel.trim();
    }

    public String getSecurityDescribe() {
        return securityDescribe;
    }

    public void setSecurityDescribe(String securityDescribe) {
        this.securityDescribe = securityDescribe == null ? null : securityDescribe.trim();
    }

    public String getSecurityPoi() {
        return securityPoi;
    }

    public void setSecurityPoi(String securityPoi) {
        this.securityPoi = securityPoi == null ? null : securityPoi.trim();
    }

    public String getSecurityCenter() {
        return securityCenter;
    }

    public void setSecurityCenter(String securityCenter) {
        this.securityCenter = securityCenter == null ? null : securityCenter.trim();
    }

    public String getSecurityVideoId() {
        return securityVideoId;
    }

    public void setSecurityVideoId(String securityVideoId) {
        this.securityVideoId = securityVideoId == null ? null : securityVideoId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getSecurityCommunity() {
        return securityCommunity;
    }

    public void setSecurityCommunity(String securityCommunity) {
        this.securityCommunity = securityCommunity == null ? null : securityCommunity.trim();
    }

    public String getNetMaster() {
        return netMaster;
    }

    public void setNetMaster(String netMaster) {
        this.netMaster = netMaster == null ? null : netMaster.trim();
    }

    public String getNetListener() {
        return netListener;
    }

    public void setNetListener(String netListener) {
        this.netListener = netListener == null ? null : netListener.trim();
    }

    public String getNetBasePeople() {
        return netBasePeople;
    }

    public void setNetBasePeople(String netBasePeople) {
        this.netBasePeople = netBasePeople == null ? null : netBasePeople.trim();
    }

    public String getNetHoldPeople() {
        return netHoldPeople;
    }

    public void setNetHoldPeople(String netHoldPeople) {
        this.netHoldPeople = netHoldPeople == null ? null : netHoldPeople.trim();
    }

    public String getNetFlowPeople() {
        return netFlowPeople;
    }

    public void setNetFlowPeople(String netFlowPeople) {
        this.netFlowPeople = netFlowPeople == null ? null : netFlowPeople.trim();
    }

    public String getNetGroup() {
        return netGroup;
    }

    public void setNetGroup(String netGroup) {
        this.netGroup = netGroup == null ? null : netGroup.trim();
    }

    public String getNetNote() {
        return netNote;
    }

    public void setNetNote(String netNote) {
        this.netNote = netNote == null ? null : netNote.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}