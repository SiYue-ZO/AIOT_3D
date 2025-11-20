package com.city3d.dao.entry;

import java.util.List;

public class Car {
    private String carId;

    private String depId;

    private String carLicense;

    private String carStyle;

    private String carDate;

    private String driver;

    private String policeType;

    private String deviceId;

    private String cardNum;

    private String image;
    
    private String[] carLicenses;
    
    private List<EquipmentRel> equipmentRels;

	public List<EquipmentRel> getEquipmentRels() {
		return equipmentRels;
	}

	public void setEquipmentRels(List<EquipmentRel> equipmentRels) {
		this.equipmentRels = equipmentRels;
	}

	public String[] getCarLicenses() {
		return carLicenses;
	}

	public void setCarLicenses(String[] carLicenses) {
		this.carLicenses = carLicenses;
	}

	public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense == null ? null : carLicense.trim();
    }

    public String getCarStyle() {
        return carStyle;
    }

    public void setCarStyle(String carStyle) {
        this.carStyle = carStyle == null ? null : carStyle.trim();
    }

    public String getCarDate() {
        return carDate;
    }

    public void setCarDate(String carDate) {
        this.carDate = carDate == null ? null : carDate.trim();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getPoliceType() {
        return policeType;
    }

    public void setPoliceType(String policeType) {
        this.policeType = policeType == null ? null : policeType.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}