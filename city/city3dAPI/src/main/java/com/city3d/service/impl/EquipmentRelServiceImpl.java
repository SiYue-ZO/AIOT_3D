package com.city3d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.EquipmentRelMapper;
import com.city3d.dao.entry.EquipmentRel;
import com.city3d.dao.entry.EquipmentRelExample;
import com.city3d.service.EquipmentRelService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentRelServiceImpl implements EquipmentRelService {
    @Autowired
    private EquipmentRelMapper equipmentRelMapper;

    @Override
    public int deleteEquipmentRel(String relId) {
        EquipmentRelExample example = new EquipmentRelExample();
        example.or().andRelIdEqualTo(relId);
        return equipmentRelMapper.deleteByExample(example);
    }

    @Override
    public int insertEquipmentRel(EquipmentRel equipmentRel) {
        return equipmentRelMapper.insert(equipmentRel);
    }
}
