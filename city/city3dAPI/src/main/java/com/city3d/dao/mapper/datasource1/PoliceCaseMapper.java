package com.city3d.dao.mapper.datasource1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.city3d.dao.entry.PoliceCase;
import com.city3d.dao.entry.PoliceCaseExample;

@Mapper
public interface PoliceCaseMapper {
    int countByExample(PoliceCaseExample example);

    int deleteByExample(PoliceCaseExample example);

    int deleteByPrimaryKey(String caseId);

    int insert(PoliceCase record);

    int insertSelective(PoliceCase record);

    List<PoliceCase> selectByExample(PoliceCaseExample example);

    PoliceCase selectByPrimaryKey(String caseId);

    int updateByExampleSelective(@Param("record") PoliceCase record, @Param("example") PoliceCaseExample example);

    int updateByExample(@Param("record") PoliceCase record, @Param("example") PoliceCaseExample example);

    int updateByPrimaryKeySelective(PoliceCase record);

    int updateByPrimaryKey(PoliceCase record);
}