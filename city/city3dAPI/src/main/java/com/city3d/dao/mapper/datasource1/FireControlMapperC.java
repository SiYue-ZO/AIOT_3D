package com.city3d.dao.mapper.datasource1;

import java.util.HashMap;
import java.util.List;

import com.city3d.dao.entry.FireControl;
import com.city3d.dao.entry.FireControlExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FireControlMapperC extends FireControlMapper {
    List<HashMap<String, String>> getIDandPOI();

    List<FireControl> getAllNoPic();

    FireControl selectFireControlById(String fcId);

    List<FireControl> selectByExampleC(FireControlExample example);
}
