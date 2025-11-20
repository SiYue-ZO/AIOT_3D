package com.city3d.dao.entry;

public class PeopleKnife {
    private String knifeId;

    private String ppId;

    private String knifeLenth;

    private String qrCode;

    private String fixedSituation;

    private String knifeImgUrl;

    private String knifeRemark;

    private String knifeType;
    
    private PeopleBase peopleBase;

    public PeopleBase getPeopleBase() {
		return peopleBase;
	}

	public void setPeopleBase(PeopleBase peopleBase) {
		this.peopleBase = peopleBase;
	}

	public String getKnifeId() {
        return knifeId;
    }

    public void setKnifeId(String knifeId) {
        this.knifeId = knifeId == null ? null : knifeId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getKnifeLenth() {
        return knifeLenth;
    }

    public void setKnifeLenth(String knifeLenth) {
        this.knifeLenth = knifeLenth == null ? null : knifeLenth.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public String getFixedSituation() {
        return fixedSituation;
    }

    public void setFixedSituation(String fixedSituation) {
        this.fixedSituation = fixedSituation == null ? null : fixedSituation.trim();
    }

    public String getKnifeImgUrl() {
        return knifeImgUrl;
    }

    public void setKnifeImgUrl(String knifeImgUrl) {
        this.knifeImgUrl = knifeImgUrl == null ? null : knifeImgUrl.trim();
    }

    public String getKnifeRemark() {
        return knifeRemark;
    }

    public void setKnifeRemark(String knifeRemark) {
        this.knifeRemark = knifeRemark == null ? null : knifeRemark.trim();
    }

    public String getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(String knifeType) {
        this.knifeType = knifeType == null ? null : knifeType.trim();
    }
}