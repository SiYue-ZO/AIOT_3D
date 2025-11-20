package com.city3d.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.city3d.dao.mapper.datasource1.CaseMaterialMapper;
import com.city3d.dao.entry.CaseMaterial;
import com.city3d.dao.entry.CaseMaterialExample;
import com.city3d.dao.entry.CaseMaterialExample.Criteria;
import com.city3d.service.CaseMaterialService;
import org.springframework.stereotype.Service;

@Service
public class CaseMaterialServiceImpl implements CaseMaterialService {
    @Autowired
    private CaseMaterialMapper caseMaterialMapper;

    @Override
    public int uploadImg(CaseMaterial caseMaterial) {
        return caseMaterialMapper.insert(caseMaterial);
    }

    @Override
    public List<CaseMaterial> getCaseMaterialByIdAndType(CaseMaterial caseMaterial) {
        CaseMaterialExample example = new CaseMaterialExample();
        Criteria criteriaResult = example.or();
        if (caseMaterial.getCaseId() != null) {
            criteriaResult = criteriaResult.andCaseIdEqualTo(caseMaterial.getCaseId());
        }
        if (caseMaterial.getMaterialType() != null) {
            criteriaResult = criteriaResult.andMaterialTypeEqualTo(caseMaterial.getMaterialType());
        }
        return caseMaterialMapper.selectByExample(example);
    }

    @Override
    public int deleteCaseMaterial(String caseMaterialId) {
        return caseMaterialMapper.deleteByPrimaryKey(caseMaterialId);
    }
}
