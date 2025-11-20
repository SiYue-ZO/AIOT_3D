package com.city3d.dao.entry;

public class PoliceCase {
    private String caseId;

    private String netId;

    private String caseName;

    private String caseType;

    private String caseAddr;

    private String casePosition;

    private String caseDate;

    private String caseSource;

    private String victim;

    private String suspect;

    private String caseDescribe;

    private String imgUrl;

    private String audioUrl;

    private String videoUrl;

    private String caseResult;

    private String camPoi;

    private String camHeading;

    private String camPitch;

    private PoliceNet policeNet;
    
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId == null ? null : netId.trim();
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getCaseAddr() {
        return caseAddr;
    }

    public void setCaseAddr(String caseAddr) {
        this.caseAddr = caseAddr == null ? null : caseAddr.trim();
    }

    public String getCasePosition() {
        return casePosition;
    }

    public void setCasePosition(String casePosition) {
        this.casePosition = casePosition == null ? null : casePosition.trim();
    }

    public String getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate == null ? null : caseDate.trim();
    }

    public String getCaseSource() {
        return caseSource;
    }

    public void setCaseSource(String caseSource) {
        this.caseSource = caseSource == null ? null : caseSource.trim();
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim == null ? null : victim.trim();
    }

    public String getSuspect() {
        return suspect;
    }

    public void setSuspect(String suspect) {
        this.suspect = suspect == null ? null : suspect.trim();
    }

    public String getCaseDescribe() {
        return caseDescribe;
    }

    public void setCaseDescribe(String caseDescribe) {
        this.caseDescribe = caseDescribe == null ? null : caseDescribe.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl == null ? null : audioUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult == null ? null : caseResult.trim();
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

	public PoliceNet getPoliceNet() {
		return policeNet;
	}

	public void setPoliceNet(PoliceNet policeNet) {
		this.policeNet = policeNet;
	}
    
}