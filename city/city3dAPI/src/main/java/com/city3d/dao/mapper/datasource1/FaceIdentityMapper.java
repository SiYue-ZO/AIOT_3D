package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.FaceIdentity;
import com.city3d.dao.entry.FaceIdentityExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FaceIdentityMapper {
    int countByExample(FaceIdentityExample example);

    int deleteByExample(FaceIdentityExample example);

    int deleteByPrimaryKey(String faceId);

    int insert(FaceIdentity record);

    int insertSelective(FaceIdentity record);

    List<FaceIdentity> selectByExample(FaceIdentityExample example);

    FaceIdentity selectByPrimaryKey(String faceId);

    int updateByExampleSelective(@Param("record") FaceIdentity record, @Param("example") FaceIdentityExample example);

    int updateByExample(@Param("record") FaceIdentity record, @Param("example") FaceIdentityExample example);

    int updateByPrimaryKeySelective(FaceIdentity record);

    int updateByPrimaryKey(FaceIdentity record);
}