package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.Equipment;

public interface EquipmentService {
    int insertEquipment(Equipment equipment);

    int deleteEquipment(String equipmentId);

    int updateEquipment(Equipment equipment);

    List<Equipment> selectEquipmentByType(String equipmentType);

    List<Equipment> selectEquipmentAllOrderByType();
}
