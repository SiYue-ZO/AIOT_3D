package com.city3d.service;

import java.util.List;

import com.city3d.dao.entry.CaseMaterial;

public interface CaseMaterialService {
    int uploadImg(CaseMaterial caseMaterial);

    List<CaseMaterial> getCaseMaterialByIdAndType(CaseMaterial caseMaterial);

    int deleteCaseMaterial(String caseMaterialId);
}
