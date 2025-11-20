package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.Bim;
import com.city3d.dao.entry.BimExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BimMapper {
    int countByExample(BimExample example);

    int deleteByExample(BimExample example);

    int deleteByPrimaryKey(String tilesId);

    int insert(Bim record);

    int insertSelective(Bim record);

    List<Bim> selectByExample(BimExample example);

    Bim selectByPrimaryKey(String tilesId);

    int updateByExampleSelective(@Param("record") Bim record, @Param("example") BimExample example);

    int updateByExample(@Param("record") Bim record, @Param("example") BimExample example);

    int updateByPrimaryKeySelective(Bim record);

    int updateByPrimaryKey(Bim record);
}