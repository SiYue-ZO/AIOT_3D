package com.city3d.dao.mapper.datasource1;

import com.city3d.dao.entry.FaceIdentity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaceIdentityMapperC extends FaceIdentityMapper {
    FaceIdentity getFaceIdentityAndVideoById(String faceId);

    List<FaceIdentity> getFaceIdentityByRepoTypeandUserId(FaceIdentity faceIdentity);

    int batchDelete(List<String> faceIds);
}