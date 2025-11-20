package com.city3d.service;

import com.city3d.dao.entry.EquipmentRel;

public interface EquipmentRelService {
    int deleteEquipmentRel(String relId);

    int insertEquipmentRel(EquipmentRel equipmentRel);
}
