package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.EquipmentMapper;
import com.city3d.dao.entry.Equipment;
import com.city3d.dao.entry.EquipmentExample;
import com.city3d.service.EquipmentService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentMapper equipmentMapper;

	@Override
	public int insertEquipment(Equipment equipment) {
		return equipmentMapper.insert(equipment);
	}

	@Override
	public int deleteEquipment(String equipmentId) {
		return equipmentMapper.deleteByPrimaryKey(equipmentId);
	}

	@Override
	public int updateEquipment(Equipment equipment) {
		return equipmentMapper.updateByPrimaryKey(equipment);
	}

	@Override
	public List<Equipment> selectEquipmentByType(String equipmentType) {
		EquipmentExample equipmentExample = new EquipmentExample();
		equipmentExample.createCriteria().andEquipmentTypeEqualTo(equipmentType);
		return equipmentMapper.selectByExample(equipmentExample);
	}

	@Override
	public List<Equipment> selectEquipmentAllOrderByType() {
		EquipmentExample equipmentExample = new EquipmentExample();
		equipmentExample.setOrderByClause("equipment_type");
		return equipmentMapper.selectByExample(equipmentExample);
	}
}
