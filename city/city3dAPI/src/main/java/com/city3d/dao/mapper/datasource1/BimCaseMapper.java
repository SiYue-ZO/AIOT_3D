package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.BimCase;
import com.city3d.dao.entry.BimCaseExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BimCaseMapper {
    int countByExample(BimCaseExample example);

    int deleteByExample(BimCaseExample example);

    int deleteByPrimaryKey(String bimCaseId);

    int insert(BimCase record);

    int insertSelective(BimCase record);

    List<BimCase> selectByExample(BimCaseExample example);

    BimCase selectByPrimaryKey(String bimCaseId);

    int updateByExampleSelective(@Param("record") BimCase record, @Param("example") BimCaseExample example);

    int updateByExample(@Param("record") BimCase record, @Param("example") BimCaseExample example);

    int updateByPrimaryKeySelective(BimCase record);

    int updateByPrimaryKey(BimCase record);
}