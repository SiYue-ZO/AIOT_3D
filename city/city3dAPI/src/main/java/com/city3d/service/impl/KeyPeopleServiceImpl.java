package com.city3d.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.city3d.dao.mapper.datasource1.KeyPeopleMapperC;
import com.city3d.dao.entry.KeyPeople;
import com.city3d.dao.entry.KeyPeopleExample;
import com.city3d.dao.entry.KeyPeopleExample.Criteria;
import com.city3d.service.KeyPeopleService;
import org.springframework.stereotype.Service;

@Service
public class KeyPeopleServiceImpl implements KeyPeopleService {
    @Autowired
    private KeyPeopleMapperC keyPeopleMapperC;

    @Override
    public List<HashMap<String, String>> getKeypeople() {
        return keyPeopleMapperC.getIDandPOI();
    }

    @Override
    public List<KeyPeople> getKeypeopleAll() {
        return keyPeopleMapperC.selectByExample(null);
    }

    @Override
    public List<KeyPeople> getKeypeopleNoPic() {
        return keyPeopleMapperC.getAllNoPic();
    }

    @Override
    public KeyPeople getKeypeopleById(String keyId) {
        return keyPeopleMapperC.selectKeypeopleById(keyId);
    }

    @Override
    public List<KeyPeople> queryKeypeoplebyExample(KeyPeople keyPeople) {
        KeyPeopleExample example = new KeyPeopleExample();
        Criteria criteriaResult = example.or();
        if (keyPeople.getName() != null) {
            criteriaResult = criteriaResult.andNameLike("%" + keyPeople.getName() + "%");
        }
        if (keyPeople.getIdentity() != null) {
            criteriaResult = criteriaResult.andIdentityLike("%" + keyPeople.getIdentity() + "%");
        }
        if (keyPeople.getNation() != null) {
            criteriaResult = criteriaResult.andNationLike("%" + keyPeople.getNation() + "%");
        }
        if (keyPeople.getType() != null) {
            criteriaResult = criteriaResult.andTypeLike("%" + keyPeople.getType() + "%");
        }
        if (keyPeople.getJob() != null) {
            criteriaResult = criteriaResult.andJobLike("%" + keyPeople.getJob() + "%");
        }
        if (keyPeople.getTel() != null) {
            criteriaResult = criteriaResult.andTelLike("%" + keyPeople.getTel() + "%");
        }
        if (keyPeople.getBirthday() != null) {
            criteriaResult = criteriaResult.andBirthdayLike("%" + keyPeople.getBirthday() + "%");
        }
        return keyPeopleMapperC.selectByExampleC(example);
    }

    @Override
    public KeyPeople queryKeypeopleByIdentity(String identity) {
        return keyPeopleMapperC.queryKeypeopleByIdentity(identity);
    }

    @Override
    public int insert(KeyPeople keyPeople) {
        return keyPeopleMapperC.insert(keyPeople);
    }

    @Override
    public int updateByPrimaryKey(KeyPeople keyPeople) {
        return keyPeopleMapperC.updateByPrimaryKey(keyPeople);
    }

    @Override
    public int deleteByPrimaryKey(String kpId) {
        return keyPeopleMapperC.deleteByPrimaryKey(kpId);
    }
}
