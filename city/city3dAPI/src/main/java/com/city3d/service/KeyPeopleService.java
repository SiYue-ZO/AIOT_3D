package com.city3d.service;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.KeyPeople;

public interface KeyPeopleService {
    List<HashMap<String, String>> getKeypeople();

    List<KeyPeople> getKeypeopleAll();

    List<KeyPeople> getKeypeopleNoPic();

    KeyPeople getKeypeopleById(String keyId);

    List<KeyPeople> queryKeypeoplebyExample(KeyPeople keyPeople);

    KeyPeople queryKeypeopleByIdentity(String identity);

    int insert(KeyPeople keyPeople);

    int updateByPrimaryKey(KeyPeople keyPeople);

    int deleteByPrimaryKey(String kpId);
}
