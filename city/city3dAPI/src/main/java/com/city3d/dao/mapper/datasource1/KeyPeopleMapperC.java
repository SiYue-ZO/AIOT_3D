package com.city3d.dao.mapper.datasource1;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.KeyPeople;
import com.city3d.dao.entry.KeyPeopleExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeyPeopleMapperC extends KeyPeopleMapper {
    List<HashMap<String, String>> getIDandPOI();

    List<KeyPeople> getAllNoPic();

    KeyPeople selectKeypeopleById(String kpId);

    List<KeyPeople> selectByExampleC(KeyPeopleExample example);

    KeyPeople queryKeypeopleByIdentity(String identity);
}
