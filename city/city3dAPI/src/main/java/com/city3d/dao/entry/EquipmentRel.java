package com.city3d.dao.entry;

public class EquipmentRel {
    private String equipRelId;

    private String equipId;

    private String relId;
    
    private Equipment equipment;

    public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getEquipRelId() {
        return equipRelId;
    }

    public void setEquipRelId(String equipRelId) {
        this.equipRelId = equipRelId == null ? null : equipRelId.trim();
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId == null ? null : equipId.trim();
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId == null ? null : relId.trim();
    }
}