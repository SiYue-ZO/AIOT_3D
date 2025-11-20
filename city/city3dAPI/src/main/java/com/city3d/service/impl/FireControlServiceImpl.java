package com.city3d.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.FireControlMapperC;
import com.city3d.dao.entry.FireControl;
import com.city3d.dao.entry.FireControlExample;
import com.city3d.dao.entry.FireControlExample.Criteria;
import com.city3d.service.FireControlService;
import org.springframework.stereotype.Service;

@Service
public class FireControlServiceImpl implements FireControlService {
    @Autowired
    private FireControlMapperC fireControlMapperC;

    @Override
    public List<HashMap<String, String>> getFireControl() {
        return fireControlMapperC.getIDandPOI();
    }

    @Override
    public List<FireControl> getFireControlNoPic() {
        return fireControlMapperC.getAllNoPic();
    }

    @Override
    public FireControl getFireControlById(String fireCtlId) {
        return fireControlMapperC.selectFireControlById(fireCtlId);
    }

    @Override
    public List<FireControl> queryFireControl(FireControl fireControl) {
        FireControlExample example = new FireControlExample();
        Criteria criteriaResult = example.or();
        if (fireControl.getFireCtlName() != null) {
            criteriaResult = criteriaResult.andFireCtlNameLike("%" + fireControl.getFireCtlName() + "%");
        }
        if (fireControl.getFireCtlPerson() != null) {
            criteriaResult = criteriaResult.andFireCtlPersonLike("%" + fireControl.getFireCtlPerson() + "%");
        }
        if (fireControl.getFireCtlLevel() != null) {
            criteriaResult = criteriaResult.andFireCtlLevelLike("%" + fireControl.getFireCtlLevel() + "%");
        }
        return fireControlMapperC.selectByExampleC(example);
    }

    @Override
    public int insert(FireControl fireControl) {
        return fireControlMapperC.insert(fireControl);
    }

    @Override
    public int updateByPrimaryKey(FireControl fireControl) {
        return fireControlMapperC.updateByPrimaryKey(fireControl);
    }

    @Override
    public int deleteByPrimaryKey(String fireCtlId) {
        return fireControlMapperC.deleteByPrimaryKey(fireCtlId);
    }
}
