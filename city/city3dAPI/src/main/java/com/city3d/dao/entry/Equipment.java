package com.city3d.dao.entry;

public class Equipment {
    private String equipmentId;

    private String equipmentType;

    private String equipmentName;

    private String equipmentGrade;

    private String equipmentPicture;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentGrade() {
        return equipmentGrade;
    }

    public void setEquipmentGrade(String equipmentGrade) {
        this.equipmentGrade = equipmentGrade == null ? null : equipmentGrade.trim();
    }

    public String getEquipmentPicture() {
        return equipmentPicture;
    }

    public void setEquipmentPicture(String equipmentPicture) {
        this.equipmentPicture = equipmentPicture == null ? null : equipmentPicture.trim();
    }
}