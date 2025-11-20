package com.city3d.dao.entry;

public class FaceIdentity {
    private String faceId;

    private String serialNumber;

    private String cameraId;

    private String imgId;

    private String userId;

    private String cardId;

    private String name;

    private String repoType;

    private String captureTime;

    private String image;

    private String description;

    private String idCardName;

    private String idCardGender;

    private String idCardNational;

    private String idCardBirthday;

    private String idCardAddress;

    private String idCardId;

    private String idCardMaker;

    private String idCardStartDate;

    private String idCardEndDate;

    private String idCardImg;
    
    private Video video;

    public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId == null ? null : faceId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId == null ? null : cameraId.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRepoType() {
        return repoType;
    }

    public void setRepoType(String repoType) {
        this.repoType = repoType == null ? null : repoType.trim();
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime == null ? null : captureTime.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName == null ? null : idCardName.trim();
    }

    public String getIdCardGender() {
        return idCardGender;
    }

    public void setIdCardGender(String idCardGender) {
        this.idCardGender = idCardGender == null ? null : idCardGender.trim();
    }

    public String getIdCardNational() {
        return idCardNational;
    }

    public void setIdCardNational(String idCardNational) {
        this.idCardNational = idCardNational == null ? null : idCardNational.trim();
    }

    public String getIdCardBirthday() {
        return idCardBirthday;
    }

    public void setIdCardBirthday(String idCardBirthday) {
        this.idCardBirthday = idCardBirthday == null ? null : idCardBirthday.trim();
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress == null ? null : idCardAddress.trim();
    }

    public String getIdCardId() {
        return idCardId;
    }

    public void setIdCardId(String idCardId) {
        this.idCardId = idCardId == null ? null : idCardId.trim();
    }

    public String getIdCardMaker() {
        return idCardMaker;
    }

    public void setIdCardMaker(String idCardMaker) {
        this.idCardMaker = idCardMaker == null ? null : idCardMaker.trim();
    }

    public String getIdCardStartDate() {
        return idCardStartDate;
    }

    public void setIdCardStartDate(String idCardStartDate) {
        this.idCardStartDate = idCardStartDate == null ? null : idCardStartDate.trim();
    }

    public String getIdCardEndDate() {
        return idCardEndDate;
    }

    public void setIdCardEndDate(String idCardEndDate) {
        this.idCardEndDate = idCardEndDate == null ? null : idCardEndDate.trim();
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg == null ? null : idCardImg.trim();
    }
}